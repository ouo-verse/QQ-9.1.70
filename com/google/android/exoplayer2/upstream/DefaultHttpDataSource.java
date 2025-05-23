package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultHttpDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private final TransferListener<? super DefaultHttpDataSource> listener;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private final String userAgent;
    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference<>();

    public DefaultHttpDataSource(String str, Predicate<String> predicate) {
        this(str, predicate, null);
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                Log.e(TAG, "Unexpected error while disconnecting", e16);
            }
            this.connection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long getContentLength(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                Log.e(TAG, "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            Log.w(TAG, "Inconsistent headers [" + headerField2 + "] [" + headerField + "]");
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        Log.e(TAG, "Unexpected Content-Range [" + headerField + "]");
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    private static URL handleRedirect(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol2 = url2.getProtocol();
            if (!"https".equals(protocol2) && !"http".equals(protocol2)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol2);
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException {
        HttpURLConnection makeConnection;
        URL url = new URL(dataSpec.uri.toString());
        byte[] bArr = dataSpec.postBody;
        long j3 = dataSpec.position;
        long j16 = dataSpec.length;
        boolean isFlagSet = dataSpec.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects) {
            return makeConnection(url, bArr, j3, j16, isFlagSet, true);
        }
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i3 <= 20) {
                long j17 = j3;
                makeConnection = makeConnection(url, bArr, j3, j16, isFlagSet, false);
                int responseCode = makeConnection.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    String headerField = makeConnection.getHeaderField("Location");
                    makeConnection.disconnect();
                    url = handleRedirect(url, headerField);
                    bArr = null;
                    i3 = i16;
                    j3 = j17;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i16);
            }
        }
        return makeConnection;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j3) {
        int i3 = Util.SDK_INT;
        if (i3 != 19 && i3 != 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j3 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j3 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private int readInternal(byte[] bArr, int i3, int i16) throws IOException {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.bytesToRead;
        if (j3 != -1) {
            long j16 = j3 - this.bytesRead;
            if (j16 == 0) {
                return -1;
            }
            i16 = (int) Math.min(i16, j16);
        }
        int read = this.inputStream.read(bArr, i3, i16);
        if (read == -1) {
            if (this.bytesToRead == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.bytesRead += read;
        TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(this, read);
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
        while (true) {
            long j3 = this.bytesSkipped;
            long j16 = this.bytesToSkip;
            if (j3 != j16) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(j16 - j3, andSet.length));
                if (!Thread.interrupted()) {
                    if (read != -1) {
                        this.bytesSkipped += read;
                        TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onBytesTransferred(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                skipBufferReference.set(andSet);
                return;
            }
        }
    }

    protected final long bytesRead() {
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

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                maybeTerminateInputStream(this.connection, bytesRemaining());
                try {
                    this.inputStream.close();
                } catch (IOException e16) {
                    throw new HttpDataSource.HttpDataSourceException(e16, this.dataSpec, 3);
                }
            }
        } finally {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd(this);
                }
            }
        }
    }

    protected final HttpURLConnection getConnection() {
        return this.connection;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        this.dataSpec = dataSpec;
        long j3 = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        try {
            HttpURLConnection makeConnection = makeConnection(dataSpec);
            this.connection = makeConnection;
            try {
                int responseCode = makeConnection.getResponseCode();
                if (responseCode >= 200 && responseCode <= 299) {
                    String contentType = this.connection.getContentType();
                    Predicate<String> predicate = this.contentTypePredicate;
                    if (predicate != null && !predicate.evaluate(contentType)) {
                        closeConnectionQuietly();
                        throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                    }
                    if (responseCode == 200) {
                        long j16 = dataSpec.position;
                        if (j16 != 0) {
                            j3 = j16;
                        }
                    }
                    this.bytesToSkip = j3;
                    if (!dataSpec.isFlagSet(1)) {
                        long j17 = dataSpec.length;
                        long j18 = -1;
                        if (j17 != -1) {
                            this.bytesToRead = j17;
                        } else {
                            long contentLength = getContentLength(this.connection);
                            if (contentLength != -1) {
                                j18 = contentLength - this.bytesToSkip;
                            }
                            this.bytesToRead = j18;
                        }
                    } else {
                        this.bytesToRead = dataSpec.length;
                    }
                    try {
                        this.inputStream = this.connection.getInputStream();
                        this.opened = true;
                        TransferListener<? super DefaultHttpDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferStart(this, dataSpec);
                        }
                        return this.bytesToRead;
                    } catch (IOException e16) {
                        closeConnectionQuietly();
                        throw new HttpDataSource.HttpDataSourceException(e16, dataSpec, 1);
                    }
                }
                Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                closeConnectionQuietly();
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, dataSpec);
                if (responseCode == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException(0));
                    throw invalidResponseCodeException;
                }
                throw invalidResponseCodeException;
            } catch (IOException e17) {
                closeConnectionQuietly();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e17, dataSpec, 1);
            }
        } catch (IOException e18) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e18, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i3, i16);
        } catch (IOException e16) {
            throw new HttpDataSource.HttpDataSourceException(e16, this.dataSpec, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener) {
        this(str, predicate, transferListener, 8000, 8000);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i3, int i16) {
        this(str, predicate, transferListener, i3, i16, false, null);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i3, int i16, boolean z16, HttpDataSource.RequestProperties requestProperties) {
        this.userAgent = Assertions.checkNotEmpty(str);
        this.contentTypePredicate = predicate;
        this.listener = transferListener;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i16;
        this.allowCrossProtocolRedirects = z16;
        this.defaultRequestProperties = requestProperties;
    }

    private HttpURLConnection makeConnection(URL url, byte[] bArr, long j3, long j16, boolean z16, boolean z17) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnection.setReadTimeout(this.readTimeoutMillis);
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            for (Map.Entry<String, String> entry : requestProperties.getSnapshot().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.requestProperties.getSnapshot().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
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
        httpURLConnection.setInstanceFollowRedirects(z17);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }
}
