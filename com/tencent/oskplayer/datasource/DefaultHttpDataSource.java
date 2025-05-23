package com.tencent.oskplayer.datasource;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.ContentTypeFixer;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import com.tencent.oskplayer.util.ThreadUtils;
import com.tencent.oskplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultHttpDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 30000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 12000;
    private static final int MAX_REDIRECTS = 20;
    protected String TAG;
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private long contentLength;
    private String contentType;
    private final Fixer<Map<String, List<String>>> contentTypeFixer;
    private final Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    protected String extraLogTag;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HashMap<String, String> requestProperties;
    private long totalLength;
    private final String userAgent;
    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class GetResponseCodeCallable implements Callable<Integer> {
        private HttpURLConnection mConnection;

        public GetResponseCodeCallable(HttpURLConnection httpURLConnection) {
            this.mConnection = httpURLConnection;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            return Integer.valueOf(this.mConnection.getResponseCode());
        }
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, Fixer<Map<String, List<String>>> fixer) {
        this(str, predicate, null, fixer);
    }

    private void closeConnection() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.connection = null;
        }
    }

    private HttpURLConnection configureConnection(URL url, long j3, long j16, boolean z16) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        HttpURLConnection httpURLConnection;
        if (url.getProtocol().startsWith("https")) {
            if (PlayerUtils.shouldByPassProxySetting(url)) {
                httpURLConnection = (HttpsURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            }
        } else if (PlayerUtils.shouldByPassProxySetting(url)) {
            httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnection.setReadTimeout(this.readTimeoutMillis);
        httpURLConnection.setDoOutput(false);
        synchronized (this.requestProperties) {
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (j3 != 0 || j16 != -1) {
            String str = "bytes=" + j3 + "-";
            if (j16 != -1) {
                str = str + ((j3 + j16) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        if (!z16) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        PlayerUtils.log(4, getLogTag(), PlayerUtils.removeLineBreaks("send upstream request: \r\n" + httpURLConnection.getRequestMethod() + " " + url + "\r\n" + HttpParser.getHeaders(httpURLConnection.getRequestProperties()), null));
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long getContentLength(HttpURLConnection httpURLConnection, String str) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                PlayerUtils.log(6, str, "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField);
            if (!matcher.find()) {
                return parseLong;
            }
            try {
                long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                PlayerUtils.log(5, str, "Inconsistent headers [" + headerField2 + "] [" + headerField + "]");
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                PlayerUtils.log(6, str, "Unexpected Content-Range [" + headerField + "]");
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long getTotalLength(HttpURLConnection httpURLConnection, String str) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        long j3 = -1;
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                PlayerUtils.log(6, str, "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField);
            if (matcher.find()) {
                try {
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    if (parseLong < 0) {
                        j3 = parseLong2;
                    } else if (parseLong != -1) {
                        j3 = Math.max(parseLong, parseLong2);
                    }
                } catch (NumberFormatException unused2) {
                    PlayerUtils.log(6, str, "Unexpected Content-Range [" + headerField + "]");
                }
            }
            return j3;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    public static URL handleRedirect(URL url, String str) throws IOException {
        URL url2;
        if (str != null) {
            if (URLUtil.isNetworkUrl(str)) {
                url2 = new URL(str);
            } else {
                url2 = new URL(url, str);
            }
            String protocol2 = url2.getProtocol();
            if (!"https".equals(protocol2) && !"http".equals(protocol2)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol2);
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        boolean z16;
        ArrayList arrayList;
        URL url = new URL(dataSpec.uri.toString());
        long j3 = dataSpec.position;
        long j16 = dataSpec.length;
        boolean z17 = true;
        if ((dataSpec.flags & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.allowCrossProtocolRedirects) {
            return configureConnection(url, j3, j16, z16);
        }
        PlayerUtils.getVideoUuidFromVideoUrl(url.toExternalForm());
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        URL url2 = url;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = i3 + 1;
            if (i3 <= 20) {
                URL url3 = url2;
                int i18 = i16;
                ArrayList arrayList3 = arrayList2;
                HttpURLConnection configureConnection = configureConnection(url2, j3, j16, z16);
                configureConnection.setInstanceFollowRedirects(false);
                configureConnection.connect();
                try {
                    Object submitTask = ThreadUtils.submitTask(new GetResponseCodeCallable(configureConnection), this.readTimeoutMillis, z17, "GetResponseCodeCallable", getLogTag());
                    if (submitTask != null) {
                        int intValue = ((Integer) submitTask).intValue();
                        if (intValue != 300 && intValue != 301 && intValue != 302 && intValue != 303 && intValue != 307 && intValue != 308) {
                            if (i18 > 0 && PlayerConfig.g().getVideoReporter() != null) {
                                PlayerConfig.g().getVideoReporter().urlRedirectOccurred(dataSpec.uuid, PlayerUtils.join(arrayList3), System.currentTimeMillis() - currentTimeMillis, i18);
                            }
                            try {
                                if (PlayerConfig.g().isServerIPWithGetByName() && PlayerConfig.g().getVideoReporter() != null && dataSpec.priority == 90) {
                                    String host = url3.getHost();
                                    String hostAddress = InetAddress.getByName(host).getHostAddress();
                                    PlayerConfig.g().getVideoReporter().downloadServerIp(dataSpec.uuid, hostAddress);
                                    PlayerUtils.log(4, getLogTag(), "host:" + host + ",ip:" + hostAddress);
                                }
                            } catch (Exception e16) {
                                PlayerUtils.log(5, getLogTag(), "getIpError", e16);
                            }
                            return configureConnection;
                        }
                        i16 = i18 + 1;
                        String headerField = configureConnection.getHeaderField("Location");
                        try {
                            arrayList = arrayList3;
                            try {
                                arrayList.add(new URL(headerField).getHost());
                            } catch (MalformedURLException unused) {
                                PlayerUtils.log(5, getLogTag(), "MalformedURLException url=" + headerField);
                                configureConnection.disconnect();
                                URL handleRedirect = handleRedirect(url3, headerField);
                                PlayerUtils.log(2, getLogTag(), "redirect to url=" + handleRedirect.toString() + ", fromUrl=" + url3);
                                arrayList2 = arrayList;
                                i3 = i17;
                                z17 = true;
                                url2 = handleRedirect;
                            }
                        } catch (MalformedURLException unused2) {
                            arrayList = arrayList3;
                        }
                        configureConnection.disconnect();
                        URL handleRedirect2 = handleRedirect(url3, headerField);
                        PlayerUtils.log(2, getLogTag(), "redirect to url=" + handleRedirect2.toString() + ", fromUrl=" + url3);
                        arrayList2 = arrayList;
                        i3 = i17;
                        z17 = true;
                        url2 = handleRedirect2;
                    } else {
                        closeConnection();
                        throw new HttpDataSource.UnableConnectServerException("getResponseCode TimeoutException Unable to connect to " + dataSpec.uri.toString() + " within " + this.readTimeoutMillis, new IOException("getResponseCode Timeout " + this.readTimeoutMillis), dataSpec);
                    }
                } catch (InterruptedException unused3) {
                    Thread.currentThread().interrupt();
                    PlayerUtils.log(4, getLogTag(), "GetResponseCodeCallable Interrupted");
                    throw new HttpDataSource.InterruptConnectServerException("GetResponseCodeCallable interrupted", getDataSpec());
                } catch (ExecutionException e17) {
                    PlayerUtils.log(5, getLogTag(), "GetResponseCodeCallable ExecutionException " + PlayerUtils.getPrintableStackTrace(e17));
                    throw new HttpDataSource.InterruptConnectServerException("Failed To Execute GetResponseCodeCallable", getDataSpec());
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i17);
            }
        }
    }

    private int readInternal(byte[] bArr, int i3, int i16) throws IOException {
        long j3 = this.bytesToRead;
        if (j3 != -1) {
            i16 = (int) Math.min(i16, j3 - this.bytesRead);
        }
        if (i16 == 0) {
            return -1;
        }
        int read = this.inputStream.read(bArr, i3, i16);
        if (read == -1) {
            long j16 = this.bytesToRead;
            if (j16 == -1 || j16 == this.bytesRead) {
                return -1;
            }
            throw new EOFException();
        }
        this.bytesRead += read;
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(read);
        }
        return read;
    }

    private void skipInternal() throws IOException {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        byte[] andSet = skipBufferReference.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        Log.d(getLogTag(), "bytes skipped " + this.bytesSkipped + ", bytesToSkip " + this.bytesToSkip);
        while (true) {
            long j3 = this.bytesSkipped;
            long j16 = this.bytesToSkip;
            if (j3 != j16) {
                int min = (int) Math.min(j16 - j3, andSet.length);
                Log.d(getLogTag(), "request skip " + min + " bytes");
                int read = this.inputStream.read(andSet, 0, min);
                Log.d(getLogTag(), "actual skip " + read + " bytes");
                if (!Thread.interrupted()) {
                    if (read != -1) {
                        this.bytesSkipped += read;
                        TransferListener transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onBytesTransferred(read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new HttpDataSource.InterruptReadException("skipInternal interrupted", getDataSpec());
                }
            } else {
                skipBufferReference.set(andSet);
                return;
            }
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long available() {
        return this.contentLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long bytesRead() {
        return this.bytesRead;
    }

    protected final long bytesRemaining() {
        long j3 = this.bytesToRead;
        if (j3 != -1) {
            return j3 - this.bytesRead;
        }
        return j3;
    }

    protected final long bytesSkipped() {
        return this.bytesSkipped;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public void clearAllRequestProperties() {
        synchronized (this.requestProperties) {
            this.requestProperties.clear();
        }
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.requestProperties) {
            this.requestProperties.remove(str);
        }
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                Util.maybeTerminateInputStream(this.connection, bytesRemaining());
                try {
                    this.inputStream.close();
                    this.inputStream = null;
                } catch (IOException e16) {
                    throw new HttpDataSource.HttpDataSourceException(e16, this.dataSpec);
                }
            }
        } finally {
            if (this.opened) {
                this.opened = false;
                TransferListener transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd();
                }
            }
            closeConnection();
        }
    }

    protected final HttpURLConnection getConnection() {
        return this.connection;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public Predicate<String> getContentPredicator() {
        return this.contentTypePredicate;
    }

    public String getContentType() {
        return this.contentType;
    }

    public DataSpec getDataSpec() {
        return this.dataSpec;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        return FileType.getFileType(getContentType());
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public String getLogTag() {
        return this.extraLogTag + this.TAG;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        Map<String, List<String>> headerFields;
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            headerFields = null;
        } else {
            headerFields = httpURLConnection.getHeaderFields();
        }
        Fixer<Map<String, List<String>>> fixer = this.contentTypeFixer;
        if (fixer != null) {
            return fixer.fix(headerFields);
        }
        return headerFields;
    }

    @Override // com.tencent.oskplayer.datasource.UriDataSource
    public String getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getURL().toString();
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        return open(dataSpec, null);
    }

    @Deprecated
    public int read(byte[] bArr, long j3, int i3) throws HttpDataSource.HttpDataSourceException {
        try {
            this.bytesToSkip = j3;
            skipInternal();
            int readInternal = readInternal(bArr, 0, i3);
            this.bytesSkipped += readInternal;
            return readInternal;
        } catch (IOException e16) {
            throw new HttpDataSource.HttpDataSourceException(e16, this.dataSpec);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.requestProperties) {
            this.requestProperties.put(str, str2);
        }
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener transferListener, Fixer<Map<String, List<String>>> fixer) {
        this(str, predicate, transferListener, 30000, 12000, fixer);
    }

    public long open(DataSpec dataSpec, String str) throws HttpDataSource.HttpDataSourceException {
        this.dataSpec = dataSpec;
        long j3 = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        try {
            HttpURLConnection makeConnection = makeConnection(dataSpec);
            this.connection = makeConnection;
            if (str != null) {
                makeConnection.setRequestMethod(str);
            }
        } catch (InterruptedIOException e16) {
            throw new HttpDataSource.InterruptConnectServerException("makeConnection InterruptedIOException Interrupt connection to " + dataSpec.uri.toString(), e16, dataSpec);
        } catch (IOException e17) {
            throw new HttpDataSource.UnableConnectServerException("makeConnection IOException Unable to connect to " + dataSpec.uri.toString(), e17, dataSpec);
        } catch (KeyManagementException e18) {
            PlayerUtils.log(6, getLogTag(), "makeConnection KeyManagementException Unable to connect to" + dataSpec.uri.toString(), e18);
        } catch (NoSuchAlgorithmException e19) {
            PlayerUtils.log(6, getLogTag(), "makeConnection NoSuchAlgorithmException Unable to connect to" + dataSpec.uri.toString(), e19);
        } catch (NoSuchProviderException e26) {
            PlayerUtils.log(6, getLogTag(), "makeConnection NoSuchProviderException Unable to connect to" + dataSpec.uri.toString(), e26);
        }
        try {
            int responseCode = this.connection.getResponseCode();
            PlayerUtils.log(4, getLogTag(), PlayerUtils.removeLineBreaks("uri=" + dataSpec.toString() + ", response header: \r\n" + HttpParser.getHeaders(this.connection.getHeaderFields()), null));
            if (responseCode >= 200 && responseCode <= 299) {
                String contentType = this.connection.getContentType();
                Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                Predicate<String> predicate = this.contentTypePredicate;
                if (predicate != null && !predicate.evaluate((Predicate<String>) contentType)) {
                    closeConnection();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, headerFields, dataSpec);
                }
                this.contentType = contentType;
                Fixer<Map<String, List<String>>> fixer = this.contentTypeFixer;
                if (fixer != null) {
                    this.contentType = ((ContentTypeFixer) fixer).fix(contentType);
                }
                if (responseCode == 200) {
                    long j16 = dataSpec.position;
                    if (j16 != 0) {
                        j3 = j16;
                    }
                }
                this.bytesToSkip = j3;
                long j17 = -1;
                if ((dataSpec.flags & 1) == 0) {
                    this.contentLength = getContentLength(this.connection, getLogTag());
                    this.totalLength = getTotalLength(this.connection, getLogTag());
                    long j18 = dataSpec.length;
                    if (j18 != -1) {
                        j17 = j18;
                    } else {
                        long j19 = this.contentLength;
                        if (j19 != -1) {
                            j17 = j19 - this.bytesToSkip;
                        }
                    }
                    this.bytesToRead = j17;
                } else {
                    long j26 = dataSpec.length;
                    this.bytesToRead = j26;
                    this.contentLength = j26;
                    this.totalLength = -1L;
                }
                try {
                    this.inputStream = this.connection.getInputStream();
                    this.opened = true;
                    TransferListener transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferStart();
                    }
                    return this.bytesToRead;
                } catch (IOException e27) {
                    closeConnection();
                    throw new HttpDataSource.HttpDataSourceException(e27, dataSpec);
                }
            }
            Map<String, List<String>> headerFields2 = this.connection.getHeaderFields();
            closeConnection();
            throw new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields2, dataSpec);
        } catch (SocketTimeoutException e28) {
            closeConnection();
            throw new HttpDataSource.UnableConnectServerException("getResponseCode SocketTimeoutException Unable to connect to " + dataSpec.uri.toString(), e28, dataSpec);
        } catch (InterruptedIOException e29) {
            closeConnection();
            throw new HttpDataSource.InterruptConnectServerException("getResponseCode InterruptedIOException Interrupt connection to " + dataSpec.uri.toString(), e29, dataSpec);
        } catch (IOException e36) {
            closeConnection();
            throw new HttpDataSource.UnableConnectServerException("getResponseCode IOException Unable to connect to " + dataSpec.uri.toString(), e36, dataSpec);
        } catch (ArrayIndexOutOfBoundsException e37) {
            closeConnection();
            PlayerUtils.log(6, getLogTag(), PlayerUtils.getPrintableStackTrace(e37));
            throw new HttpDataSource.MalformedResponseException("getResponseCode Got malformed response when connect to " + dataSpec.uri.toString(), dataSpec);
        }
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener transferListener, int i3, int i16, Fixer<Map<String, List<String>>> fixer) {
        this(str, predicate, transferListener, i3, i16, false, fixer);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener transferListener, int i3, int i16, boolean z16, Fixer<Map<String, List<String>>> fixer) {
        this.TAG = "DefaultHttpDataSource";
        this.contentLength = -1L;
        this.totalLength = -1L;
        this.extraLogTag = "";
        this.userAgent = Assertions.checkNotEmpty(str);
        this.contentTypePredicate = predicate;
        this.listener = transferListener;
        this.requestProperties = new HashMap<>();
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i16;
        this.allowCrossProtocolRedirects = z16;
        this.contentTypeFixer = fixer;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i3, i16);
        } catch (IOException e16) {
            throw new HttpDataSource.HttpDataSourceException(e16, this.dataSpec);
        }
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public long getTotalLength() {
        return this.totalLength;
    }

    @Override // com.tencent.oskplayer.datasource.HttpDataSource
    public long getContentLength() {
        return this.contentLength;
    }
}
