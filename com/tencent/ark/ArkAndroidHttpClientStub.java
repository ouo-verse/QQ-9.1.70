package com.tencent.ark;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAndroidHttpClientStub {
    private static final int ARK_HTTP_CLIENT_ERROR_CANCEL = 9;
    private static final int ARK_HTTP_CLIENT_ERROR_DECOMPRESS_FAIL = 12;
    private static final int ARK_HTTP_CLIENT_ERROR_DNS_FAIL = 22;
    private static final int ARK_HTTP_CLIENT_ERROR_FILE_NO_FOUND = 7;
    private static final int ARK_HTTP_CLIENT_ERROR_MAX = 100;
    private static final int ARK_HTTP_CLIENT_ERROR_MD5_NOT_MATCH = 11;
    private static final int ARK_HTTP_CLIENT_ERROR_MOVE_FILE_FAIL = 13;
    private static final int ARK_HTTP_CLIENT_ERROR_NETWORK_FAIL = 5;
    private static final int ARK_HTTP_CLIENT_ERROR_NOT_MODIFIED = 1;
    private static final int ARK_HTTP_CLIENT_ERROR_OK = 0;
    private static final int ARK_HTTP_CLIENT_ERROR_OTHER = 2;
    private static final int ARK_HTTP_CLIENT_ERROR_SERVER_CLOSE = 3;
    private static final int ARK_HTTP_CLIENT_ERROR_SERVER_ERROR = 8;
    private static final int ARK_HTTP_CLIENT_ERROR_TIMEOUT = 21;
    private static final int ARK_HTTP_CLIENT_ERROR_WRITE_FAIL = 4;
    private static final int BUFFER_SIZE = 32768;
    private static final int DEFAULT_TIMEOUT = 15000;
    private static final String FORM_DATA_BEGIN = "--%s\r\nContent-Disposition: form-data; name=\"%s\"\r\n\r\n";
    private static final String FORM_DATA_END = "\r\n";
    private static final String FORM_FILE_BEGIN = "--%s\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n";
    private static final String MULTI_PART_FORM_DATA_BOUNDARY = "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4";
    private static final int REDIRECT_KEEP_VERB = 2;
    private static final int REDIRECT_MAX_COUNT = 3;
    private static final int REDIRECT_NONE = 0;
    private static final int REDIRECT_SWITCH_TO_GET = 1;
    private static final String TAG = "ArkApp.AndroidHTTP";
    private static final String UTF8 = "UTF-8";
    private String mDownloadFilePath;
    FormData mFormData;
    private HttpURLConnection mHttpURLConnection;
    private boolean mIsCanceled;
    private boolean mIsCompleted;
    private boolean mIsTimeout;
    private String mProxyHost;
    private int mProxyPort;
    public byte[] mResponseBody;
    private final RequestOption m_option = new RequestOption();
    private static final byte[] FORM_DATA_END_BYTES = {13, 10};
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static Timer sTimer = new BaseTimer();
    static ExecutorService executorService = ProxyExecutors.newFixedThreadPool(10);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class FormData {
        public String fileName;
        public String filePath;
        public final HashMap<String, String> formData;

        FormData() {
            this.formData = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Header {
        String name;
        String value;

        Header(String str, String str2) {
            this.name = str;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class RequestOption {
        public String cookie;
        public final List<Header> customHeader;
        public int timeoutInterval;

        RequestOption() {
            this.customHeader = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnTimeout() {
        synchronized (this) {
            if (this.mIsCompleted) {
                return;
            }
            Logger.logI(TAG, "OnTimeout");
            this.mIsTimeout = true;
        }
    }

    private static void cancelTimer(TimerTask timerTask) {
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    private static void closeStream(HttpURLConnection httpURLConnection) {
    }

    private static long computeFormDataLength(FormData formData) throws IOException {
        long j3 = 0;
        for (String str : formData.formData.keySet()) {
            j3 += formDataToBytes(str, formData.formData.get(str)).length;
        }
        if (!TextUtils.isEmpty(formData.fileName) && !TextUtils.isEmpty(formData.filePath)) {
            long fileLength = getFileLength(formData.filePath);
            Logger.logD(TAG, String.format("length of form file %s is %d", formData.filePath, Long.valueOf(fileLength)));
            j3 = j3 + formFileBegin(formData.fileName, formData.filePath).length + fileLength + FORM_DATA_END_BYTES.length;
        }
        return j3 + formTailer().length;
    }

    private static HttpURLConnection createConnection(String str, String str2, int i3) {
        HttpURLConnection httpURLConnection;
        try {
            if (!TextUtils.isEmpty(str)) {
                URL url = new URL(str);
                if (!TextUtils.isEmpty(str2) && i3 > 0) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, i3)));
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                Logger.logI(TAG, "createConnection, url=" + str);
                return httpURLConnection;
            }
            return null;
        } catch (Exception e16) {
            Logger.logE(TAG, "createConnection fail, error: " + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    private static byte[] formDataToBytes(String str, String str2) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(FORM_DATA_BEGIN, MULTI_PART_FORM_DATA_BOUNDARY, str));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2);
        }
        stringBuffer.append("\r\n");
        return stringBuffer.toString().getBytes("UTF-8");
    }

    private static byte[] formFileBegin(String str, String str2) throws IOException {
        return String.format(FORM_FILE_BEGIN, MULTI_PART_FORM_DATA_BOUNDARY, str, getFileName(str2)).getBytes("UTF-8");
    }

    private static byte[] formTailer() throws IOException {
        return String.format("--%s--\r\n", MULTI_PART_FORM_DATA_BOUNDARY).getBytes("UTF-8");
    }

    private static long getFileLength(String str) throws IOException {
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        throw new IOException(String.format("get file length fail due to %s is not a file", new Object[0]));
    }

    private static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int max = Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
        if (max >= 0) {
            return str.substring(max + 1);
        }
        return str;
    }

    private static String getRedirectedURL(HttpURLConnection httpURLConnection, String str) {
        try {
            String headerField = httpURLConnection.getHeaderField("Location");
            String str2 = new URL(str).getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER;
            if (!TextUtils.isEmpty(headerField)) {
                if (!str2.equalsIgnoreCase("http://") && !str2.equalsIgnoreCase("https://")) {
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    buildUpon.appendEncodedPath(headerField);
                    return buildUpon.toString();
                }
                return headerField;
            }
            return str;
        } catch (Exception e16) {
            Logger.logE(TAG, "getRedirectedURL, fail, err=" + e16.getMessage());
            return str;
        }
    }

    private void httpAsynTask(final String str, final int i3, final byte[] bArr, final int i16, final FormData formData, final String str2, final long j3) {
        executorService.execute(new Runnable() { // from class: com.tencent.ark.ArkAndroidHttpClientStub.1
            @Override // java.lang.Runnable
            public void run() {
                ArkAndroidHttpClientStub.this.httpExecuteTask(str, i3, bArr, i16, formData, str2, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void httpExecuteTask(String str, int i3, byte[] bArr, int i16, FormData formData, String str2, long j3) {
        int i17;
        String str3;
        String str4;
        HttpURLConnection httpURLConnection;
        long currentTimeMillis = System.currentTimeMillis();
        char c16 = 0;
        Logger.logI(TAG, String.format("httpExecuteTask, start, url=%s", str));
        TimerTask timer = setTimer(this.m_option.timeoutInterval);
        String str5 = str;
        byte[] bArr2 = bArr;
        int i18 = i16;
        FormData formData2 = formData;
        int i19 = 0;
        while (i19 < 3) {
            HttpURLConnection createConnection = createConnection(str5, this.mProxyHost, this.mProxyPort);
            Object[] objArr = new Object[1];
            objArr[c16] = str5;
            Logger.logI(TAG, String.format("httpExecuteTask, send request, url=%s", objArr));
            httpURLConnection = createConnection;
            int sendRequest = sendRequest(createConnection, this.m_option, i3, bArr2, i18, formData2);
            int needRedirect = needRedirect(sendRequest);
            if (needRedirect == 0) {
                str3 = str2;
                str4 = str5;
            } else {
                if (needRedirect == 1) {
                    bArr2 = null;
                    formData2 = null;
                    i18 = 0;
                }
                str4 = getRedirectedURL(httpURLConnection, str5);
                if (TextUtils.isEmpty(str4)) {
                    Logger.logE(TAG, "invalid redirect response, url=" + str4);
                    str3 = str2;
                } else {
                    closeStream(httpURLConnection);
                    Logger.logI(TAG, String.format("httpExecuteTask, redirect, status-code=%d, type=%d, url=%s->%s", Integer.valueOf(sendRequest), Integer.valueOf(needRedirect), str5, str4));
                    i19++;
                    str5 = str4;
                    c16 = 0;
                }
            }
            i17 = 2;
        }
        i17 = 2;
        str3 = str2;
        str4 = str5;
        httpURLConnection = null;
        this.mDownloadFilePath = str3;
        this.mHttpURLConnection = httpURLConnection;
        Logger.logI(TAG, String.format("httpExecuteTask, write response, url=%s", str4));
        writeResponse(str4, timer, j3, str2);
        Object[] objArr2 = new Object[i17];
        objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr2[1] = str4;
        Logger.logI(TAG, String.format("httpExecuteTask, end, time=%d ms, url=%s", objArr2));
    }

    private int needRedirect(int i3) {
        if (i3 != 307 && i3 != 308) {
            if (i3 != 301 && i3 != 302 && i3 != 303) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private static int sendRequest(HttpURLConnection httpURLConnection, RequestOption requestOption, int i3, byte[] bArr, int i16, FormData formData) {
        boolean z16;
        if (formData == null && (bArr == null || i16 <= 0)) {
            z16 = false;
        } else {
            z16 = true;
        }
        OutputStream outputStream = null;
        try {
            setConnectionOptions(httpURLConnection, requestOption, i3);
            if (z16) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                if (formData != null) {
                    httpURLConnection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", MULTI_PART_FORM_DATA_BOUNDARY));
                    httpURLConnection.setRequestProperty("Content-Length", Long.toString(computeFormDataLength(formData)));
                }
            }
            Logger.logI(TAG, "sendRequest, connect begin");
            httpURLConnection.connect();
            Logger.logI(TAG, "sendRequest, connect end");
            if (z16) {
                Logger.logI(TAG, "sendRequest, send request begin");
                outputStream = httpURLConnection.getOutputStream();
                if (formData != null) {
                    writeFormData(outputStream, formData);
                } else if (bArr != null && i16 > 0) {
                    outputStream.write(bArr, 0, i16);
                }
                outputStream.flush();
                Logger.logI(TAG, "sendRequest, send request end");
            }
            return httpURLConnection.getResponseCode();
        } catch (Exception e16) {
            Logger.logE(TAG, "sendRequest, exception=" + e16.getMessage());
            return 0;
        } finally {
            closeStream(outputStream);
        }
    }

    private static void setConnectionOptions(HttpURLConnection httpURLConnection, RequestOption requestOption, int i3) {
        int i16 = requestOption.timeoutInterval;
        if (i16 == 0) {
            i16 = 15000;
        }
        httpURLConnection.setConnectTimeout(i16);
        httpURLConnection.setReadTimeout(i16);
        httpURLConnection.setInstanceFollowRedirects(true);
        if (!TextUtils.isEmpty(requestOption.cookie)) {
            httpURLConnection.setRequestProperty("Cookie", requestOption.cookie);
        }
        for (Header header : requestOption.customHeader) {
            if (!TextUtils.isEmpty(header.name)) {
                httpURLConnection.addRequestProperty(header.name, header.value);
            }
        }
        if (i3 != 0) {
            String timeStampToString = timeStampToString(i3);
            if (!TextUtils.isEmpty(timeStampToString)) {
                httpURLConnection.setRequestProperty("If-Modified-Since", timeStampToString);
                Logger.logD(TAG, String.format("lastModify is %s(%d)", timeStampToString, Integer.valueOf(i3)));
            }
        }
    }

    private void setFlagComplete() {
        synchronized (this) {
            this.mIsCompleted = true;
        }
    }

    private TimerTask setTimer(int i3) {
        final WeakReference weakReference = new WeakReference(this);
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.ark.ArkAndroidHttpClientStub.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ArkAndroidHttpClientStub arkAndroidHttpClientStub = (ArkAndroidHttpClientStub) weakReference.get();
                if (arkAndroidHttpClientStub != null) {
                    arkAndroidHttpClientStub.OnTimeout();
                }
            }
        };
        if (i3 > 0) {
            sTimer.schedule(timerTask, i3);
        }
        return timerTask;
    }

    private static String timeStampToString(int i3) {
        if (i3 == 0) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(Long.valueOf(i3 * 1000));
        if (TextUtils.isEmpty(format)) {
            return "";
        }
        try {
            Date parse = simpleDateFormat.parse(format);
            if (parse == null) {
                return null;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat2.format(parse);
        } catch (Exception e16) {
            Logger.logE(TAG, "timeStampToString is fail and errormsg is  " + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    private static void writeFormData(OutputStream outputStream, FormData formData) throws IOException {
        for (String str : formData.formData.keySet()) {
            outputStream.write(formDataToBytes(str, formData.formData.get(str)));
        }
        if (!TextUtils.isEmpty(formData.fileName) && !TextUtils.isEmpty(formData.filePath)) {
            outputStream.write(formFileBegin(formData.fileName, formData.filePath));
            FileInputStream fileInputStream = new FileInputStream(formData.filePath);
            byte[] bArr = new byte[32768];
            long j3 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j3 += read;
            }
            Logger.logD(TAG, String.format("writeFormData, file=%s, length=%d", formData.filePath, Long.valueOf(j3)));
            outputStream.write(FORM_DATA_END_BYTES);
        }
        outputStream.write(formTailer());
    }

    private void writeResponse(String str, TimerTask timerTask, long j3, String str2) {
        OutputStream outputStream;
        int i3;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = new FileOutputStream(str2);
                } else {
                    outputStream = new ByteArrayOutputStream();
                }
                try {
                } catch (UnknownHostException e16) {
                    e = e16;
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (UnknownHostException e18) {
                e = e18;
                outputStream = null;
            } catch (Exception e19) {
                e = e19;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
            }
            if (this.mHttpURLConnection != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.mHttpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[32768];
                    int i16 = 0;
                    while (true) {
                        if (this.mIsCanceled) {
                            Logger.logI(TAG, "writeResponse, canceled, url=" + str);
                            break;
                        }
                        if (this.mIsTimeout) {
                            Logger.logI(TAG, "writeResponse, timeout, url=" + str);
                            break;
                        }
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                        i16 += read;
                    }
                    if (outputStream instanceof ByteArrayOutputStream) {
                        this.mResponseBody = ((ByteArrayOutputStream) outputStream).toByteArray();
                    }
                    Logger.logI(TAG, "writeResponse, total-length=" + i16 + " url=" + str);
                    cancelTimer(timerTask);
                    setFlagComplete();
                    OnRequestComplete(j3, 0);
                    closeStream(bufferedInputStream2);
                } catch (UnknownHostException e26) {
                    bufferedInputStream = bufferedInputStream2;
                    e = e26;
                    Logger.logE(TAG, "writeResponse, fail, url=" + str + " err=" + e.getMessage());
                    cancelTimer(timerTask);
                    setFlagComplete();
                    i3 = 22;
                    OnRequestComplete(j3, i3);
                    closeStream(bufferedInputStream);
                    closeStream(outputStream);
                    return;
                } catch (Exception e27) {
                    bufferedInputStream = bufferedInputStream2;
                    e = e27;
                    Logger.logE(TAG, "writeResponse, fail, url=" + str + " err=" + e.getMessage());
                    cancelTimer(timerTask);
                    setFlagComplete();
                    i3 = 5;
                    OnRequestComplete(j3, i3);
                    closeStream(bufferedInputStream);
                    closeStream(outputStream);
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = bufferedInputStream2;
                    cancelTimer(timerTask);
                    setFlagComplete();
                    OnRequestComplete(j3, 0);
                    closeStream(bufferedInputStream);
                    closeStream(outputStream);
                    throw th;
                }
                closeStream(outputStream);
                return;
            }
            Logger.logE(TAG, "writeResponse, connection is broken");
            throw new Exception("connection is broken");
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void AddCookie(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m_option.cookie = str;
        } else {
            this.m_option.cookie = "";
        }
        Logger.logI(TAG, "AddCookie, cookie=" + this.m_option.cookie);
    }

    public void AddCustomHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.m_option.customHeader.add(new Header(str, str2));
        Logger.logD(TAG, "AddCustomHeader, " + str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
    }

    public void AddFormData(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.mFormData == null) {
            this.mFormData = new FormData();
        }
        this.mFormData.formData.put(str, str2);
    }

    public void AddFormFile(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.mFormData == null) {
                this.mFormData = new FormData();
            }
            FormData formData = this.mFormData;
            formData.fileName = str;
            formData.filePath = str2;
        }
    }

    public void Cancel() {
        synchronized (this) {
            if (this.mIsCompleted) {
                return;
            }
            Logger.logI(TAG, "Cancel");
            this.mIsCanceled = true;
        }
    }

    public int DownloadToBuffer(String str, int i3, long j3) {
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "DownloadToBuffer, url is empty");
            return -1;
        }
        httpAsynTask(str, i3, null, 0, null, null, j3);
        return 0;
    }

    public int DownloadToFile(String str, String str2, int i3, long j3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            httpAsynTask(str, i3, null, 0, null, str2, j3);
            return 0;
        }
        Logger.logE(TAG, "DownloadToFile, url or filepath is empty");
        return -1;
    }

    public String[] GetAllResponseHeaders() {
        if (this.mHttpURLConnection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, List<String>> headerFields = this.mHttpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                for (String str2 : headerFields.get(str)) {
                    arrayList.add(str);
                    arrayList.add(str2);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public byte[] GetDownloadBuffer() {
        if (this.mResponseBody == null) {
            Logger.logI(TAG, "GetDownloadBuffer, responseBody is null");
            return null;
        }
        Logger.logD(TAG, "GetDownloadBuffer, length=" + this.mResponseBody.length);
        return this.mResponseBody;
    }

    public String GetDownloadFilePath() {
        Logger.logD(TAG, "GetDownloadFilePath, path=" + this.mDownloadFilePath);
        return this.mDownloadFilePath;
    }

    public String GetFinalURL() {
        if (this.mHttpURLConnection == null) {
            Logger.logE(TAG, "FinalURL is empty");
            return "";
        }
        Logger.logD(TAG, "FinalURL=" + this.mHttpURLConnection.getURL().toString());
        return this.mHttpURLConnection.getURL().toString();
    }

    public int GetLastModifyTime() {
        if (this.mHttpURLConnection != null) {
            Logger.logD(TAG, "LastModifyTime=" + ((int) (this.mHttpURLConnection.getLastModified() / 1000)));
            return (int) (this.mHttpURLConnection.getLastModified() / 1000);
        }
        return 0;
    }

    public int GetMaxAge() {
        String GetResponseHeader = GetResponseHeader("Cache-Control", true);
        int i3 = 0;
        if (TextUtils.isEmpty(GetResponseHeader)) {
            return 0;
        }
        String lowerCase = GetResponseHeader.toLowerCase();
        if (lowerCase.contains("max-age=")) {
            Matcher matcher = Pattern.compile("max-age=[0-9]*").matcher(lowerCase);
            if (matcher.find()) {
                try {
                    i3 = Integer.parseInt(matcher.group(0).replace("max-age=", ""));
                } catch (NumberFormatException unused) {
                    Logger.logI(TAG, "GetMaxAge, invalid max-age, " + GetResponseHeader);
                }
            }
        }
        Logger.logD(TAG, "GetMaxAge, max-age=" + i3);
        return i3;
    }

    public String GetResponseHeader(String str, boolean z16) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HttpURLConnection httpURLConnection = this.mHttpURLConnection;
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField(str);
                if (headerField != null && z16) {
                    try {
                        str2 = headerField.trim();
                    } catch (Exception e16) {
                        e = e16;
                        str2 = headerField;
                        Logger.logW(TAG, String.format("GetResponseHeader, exception=%s", e.toString()));
                        Logger.logD(TAG, String.format("GetResponseHeader, %s=%s", str, str2));
                        return str2;
                    }
                } else {
                    str2 = headerField;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        Logger.logD(TAG, String.format("GetResponseHeader, %s=%s", str, str2));
        return str2;
    }

    public String[] GetResponseHeaders(String str, boolean z16) {
        List<String> list;
        if (TextUtils.isEmpty(str)) {
            Logger.logW(TAG, "GetResponseHeaders, name is empty");
            return null;
        }
        HttpURLConnection httpURLConnection = this.mHttpURLConnection;
        if (httpURLConnection == null) {
            Logger.logW(TAG, "GetResponseHeaders, mHttpURLConnection is null");
            return null;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null && (list = headerFields.get(str)) != null) {
            if (z16) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().trim());
                }
                list = arrayList;
            }
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            return strArr;
        }
        Logger.logI(TAG, String.format("GetResponseHeaders, header not found, name=%s", str));
        return null;
    }

    public int GetStatusCode() {
        int i3 = 0;
        try {
            HttpURLConnection httpURLConnection = this.mHttpURLConnection;
            if (httpURLConnection != null) {
                i3 = httpURLConnection.getResponseCode();
            }
        } catch (Exception e16) {
            Logger.logE(TAG, "GetStatusCode is fail and errormsg=" + e16.getMessage());
            e16.printStackTrace();
        }
        Logger.logD(TAG, "StatusCode=" + i3);
        return i3;
    }

    native void OnComplete(long j3, int i3);

    public void OnRequestComplete(long j3, int i3) {
        if (this.mIsCanceled) {
            i3 = 9;
        } else if (this.mIsTimeout) {
            i3 = 21;
        } else {
            if (this.mIsCompleted) {
                if (i3 == 0) {
                    int GetStatusCode = GetStatusCode();
                    if (GetStatusCode != 0) {
                        if (GetStatusCode != 200 && GetStatusCode != 206) {
                            if (GetStatusCode != 304) {
                                i3 = 8;
                            } else {
                                i3 = 1;
                            }
                        } else {
                            i3 = 0;
                        }
                    }
                }
            }
            i3 = 2;
        }
        Logger.logI(TAG, "OnRequestComplete, errorcode=" + i3);
        OnComplete(j3, i3);
    }

    public int PostForm(String str, String str2, long j3) {
        if (!TextUtils.isEmpty(str) && this.mFormData != null) {
            Logger.logI(TAG, String.format("PostForm, URL=%s, file-path=%s", str, str2));
            FormData formData = this.mFormData;
            this.mFormData = null;
            httpAsynTask(str, 0, null, 0, formData, str2, j3);
            return 0;
        }
        Logger.logE(TAG, "PostForm, invalid arguments");
        return -1;
    }

    public void SetHeader(String str, String str2) {
        AddCustomHeader(str, str2);
    }

    public void SetTimeout(int i3) {
        this.m_option.timeoutInterval = i3;
        Logger.logI(TAG, "SetTimeout, timeout=" + this.m_option.timeoutInterval);
    }

    public int UploadBuffer(String str, byte[] bArr, int i3, long j3) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            httpAsynTask(str, 0, bArr, i3, null, null, j3);
            return 0;
        }
        Logger.logE(TAG, "UploadBuffer, invalid arguments");
        return -1;
    }

    public int UploadBufferToFile(String str, byte[] bArr, int i3, String str2, long j3) {
        if (!TextUtils.isEmpty(str) && bArr != null && !TextUtils.isEmpty(str2)) {
            httpAsynTask(str, 0, bArr, i3, null, str2, j3);
            return 0;
        }
        Logger.logE(TAG, String.format("UploadBufferToFile, invalid arguments, url=%s", str));
        return -1;
    }

    public void setProxyParam(String str, int i3) {
        this.mProxyHost = str;
        this.mProxyPort = i3;
        Logger.logD(TAG, String.format("set proxy %s:%d", str, Integer.valueOf(i3)));
    }

    private static void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e16) {
                Logger.logI(TAG, "closeStream fail, err=" + e16.getMessage());
            }
        }
    }

    private static void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e16) {
                Logger.logI(TAG, "closeStream fail, err=" + e16.getMessage());
            }
        }
    }
}
