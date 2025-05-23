package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HttpClient {
    private static final int HTTP_CONNECT_TIME_OUT = 15000;
    private static final String HTTP_GET_METHOD = "GET";
    private static final String HTTP_POST_METHOD = "POST";
    private static final int HTTP_READ_TIME_OUT = 15000;
    private static final int HTTP_STATUS_CODE_OK = 200;

    protected static HttpURLConnection createGetConnection(String str) throws IOException {
        HttpURLConnection openConnection = HippyUtils.openConnection(new URL(str));
        openConnection.setRequestMethod("GET");
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        return openConnection;
    }

    protected static HttpURLConnection createPostConnection(String str, String str2) throws IOException {
        HttpURLConnection openConnection = HippyUtils.openConnection(new URL(str));
        openConnection.setRequestMethod("POST");
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        openConnection.setDoOutput(true);
        openConnection.setDoInput(true);
        if (str2 != null && str2.length() > 0) {
            openConnection.setRequestProperty("Authorization", str2);
        }
        openConnection.setRequestProperty("Content-Type", "application/octet-stream");
        return openConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String doGet(String str) {
        InputStream inputStream;
        Closeable closeable;
        Throwable th5;
        ?? r26;
        HttpURLConnection httpURLConnection;
        String str2;
        Closeable closeable2 = null;
        try {
            try {
                str = createGetConnection(str);
                try {
                    str.connect();
                    if (str.getResponseCode() == 200) {
                        inputStream = str.getInputStream();
                        try {
                            r26 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        } catch (MalformedURLException e16) {
                            e = e16;
                            r26 = 0;
                        } catch (IOException e17) {
                            e = e17;
                            r26 = 0;
                        } catch (Throwable th6) {
                            closeable = null;
                            th5 = th6;
                            HippyUtils.safeClose(closeable);
                            HippyUtils.safeClose(inputStream);
                            if (str != 0) {
                                str.disconnect();
                            }
                            throw th5;
                        }
                        try {
                            str2 = readHttpData(r26);
                            closeable2 = r26;
                        } catch (MalformedURLException e18) {
                            e = e18;
                            e.printStackTrace();
                            HippyUtils.safeClose(r26);
                            HippyUtils.safeClose(inputStream);
                            httpURLConnection = str;
                            if (str == 0) {
                                return null;
                            }
                            httpURLConnection.disconnect();
                            return null;
                        } catch (IOException e19) {
                            e = e19;
                            e.printStackTrace();
                            HippyUtils.safeClose(r26);
                            HippyUtils.safeClose(inputStream);
                            httpURLConnection = str;
                            if (str == 0) {
                                return null;
                            }
                            httpURLConnection.disconnect();
                            return null;
                        }
                    } else {
                        inputStream = null;
                        str2 = null;
                    }
                    HippyUtils.safeClose(closeable2);
                    HippyUtils.safeClose(inputStream);
                    str.disconnect();
                    return str2;
                } catch (MalformedURLException e26) {
                    e = e26;
                    inputStream = null;
                    str = str;
                    r26 = inputStream;
                    e.printStackTrace();
                    HippyUtils.safeClose(r26);
                    HippyUtils.safeClose(inputStream);
                    httpURLConnection = str;
                    if (str == 0) {
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (IOException e27) {
                    e = e27;
                    inputStream = null;
                    str = str;
                    r26 = inputStream;
                    e.printStackTrace();
                    HippyUtils.safeClose(r26);
                    HippyUtils.safeClose(inputStream);
                    httpURLConnection = str;
                    if (str == 0) {
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (Throwable th7) {
                    closeable = null;
                    th5 = th7;
                    inputStream = null;
                }
            } catch (MalformedURLException e28) {
                e = e28;
                str = 0;
                inputStream = null;
            } catch (IOException e29) {
                e = e29;
                str = 0;
                inputStream = null;
            } catch (Throwable th8) {
                inputStream = null;
                closeable = null;
                th5 = th8;
                str = 0;
            }
        } catch (Throwable th9) {
            th5 = th9;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f8, code lost:
    
        if (r5 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fd, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e4, code lost:
    
        if (r5 != null) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.tencent.hippy.qq.api.PackageUpdateListener] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String doPost(String str, String str2, String str3, PackageUpdateListener packageUpdateListener) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        BufferedReader bufferedReader2;
        HttpURLConnection httpURLConnection3;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        BufferedReader bufferedReader5;
        BufferedReader bufferedReader6;
        HttpURLConnection httpURLConnection4;
        BufferedReader bufferedReader7;
        BufferedReader bufferedReader8;
        HttpURLConnection httpURLConnection5;
        BufferedReader bufferedReader9;
        BufferedReader bufferedReader10;
        HttpURLConnection httpURLConnection6;
        BufferedReader bufferedReader11;
        BufferedReader bufferedReader12;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection createPostConnection;
        ?? r65;
        String str4;
        BufferedReader bufferedReader13;
        BufferedReader bufferedReader14;
        BufferedReader bufferedReader15;
        BufferedReader bufferedReader16;
        BufferedReader bufferedReader17;
        BufferedReader bufferedReader18;
        BufferedReader bufferedReader19;
        BufferedReader bufferedReader20 = null;
        try {
            try {
                createPostConnection = createPostConnection(str, str3);
            } catch (MalformedURLException e16) {
                e = e16;
                httpURLConnection3 = null;
                bufferedReader3 = null;
            } catch (IOException e17) {
                e = e17;
                httpURLConnection2 = null;
                bufferedReader2 = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                bufferedReader = null;
            }
            try {
                ?? outputStream = createPostConnection.getOutputStream();
                try {
                    outputStream.write(str2.getBytes("utf-8"));
                    int responseCode = createPostConnection.getResponseCode();
                    if (QLog.isColorLevel()) {
                        QLog.d(HippyQQConstants.HIPPY_TAG, 2, "Hippy: doPost responseCode=" + responseCode);
                    }
                    if (responseCode == 200) {
                        r65 = createPostConnection.getInputStream();
                        try {
                            bufferedReader19 = new BufferedReader(new InputStreamReader((InputStream) r65, "UTF-8"));
                        } catch (MalformedURLException e18) {
                            bufferedReader4 = null;
                            bufferedReader17 = outputStream;
                            bufferedReader18 = r65;
                            e = e18;
                        } catch (IOException e19) {
                            bufferedReader4 = null;
                            bufferedReader15 = outputStream;
                            bufferedReader16 = r65;
                            e = e19;
                        } catch (Throwable th6) {
                            bufferedReader4 = null;
                            bufferedReader13 = outputStream;
                            bufferedReader14 = r65;
                            th = th6;
                        }
                        try {
                            bufferedReader20 = bufferedReader19;
                            str4 = readHttpData(bufferedReader19);
                        } catch (MalformedURLException e26) {
                            bufferedReader17 = outputStream;
                            bufferedReader18 = r65;
                            e = e26;
                            bufferedReader4 = bufferedReader19;
                            bufferedReader11 = bufferedReader17;
                            httpURLConnection7 = createPostConnection;
                            bufferedReader12 = bufferedReader18;
                            logException(e);
                            HippyUtils.safeClose(bufferedReader4);
                            HippyUtils.safeClose(bufferedReader11);
                            HippyUtils.safeClose(bufferedReader12);
                            httpURLConnection6 = httpURLConnection7;
                            bufferedReader10 = bufferedReader12;
                            bufferedReader9 = bufferedReader11;
                            str = httpURLConnection7;
                            str3 = bufferedReader12;
                            packageUpdateListener = bufferedReader11;
                        } catch (IOException e27) {
                            bufferedReader15 = outputStream;
                            bufferedReader16 = r65;
                            e = e27;
                            bufferedReader4 = bufferedReader19;
                            bufferedReader7 = bufferedReader15;
                            httpURLConnection5 = createPostConnection;
                            bufferedReader8 = bufferedReader16;
                            logException(e);
                            HippyUtils.safeClose(bufferedReader4);
                            HippyUtils.safeClose(bufferedReader7);
                            HippyUtils.safeClose(bufferedReader8);
                            httpURLConnection6 = httpURLConnection5;
                            bufferedReader10 = bufferedReader8;
                            bufferedReader9 = bufferedReader7;
                            str = httpURLConnection5;
                            str3 = bufferedReader8;
                            packageUpdateListener = bufferedReader7;
                        } catch (Throwable th7) {
                            bufferedReader13 = outputStream;
                            bufferedReader14 = r65;
                            th = th7;
                            bufferedReader4 = bufferedReader19;
                            bufferedReader5 = bufferedReader13;
                            httpURLConnection4 = createPostConnection;
                            bufferedReader6 = bufferedReader14;
                            logException(th);
                        }
                    } else {
                        if (packageUpdateListener != 0) {
                            packageUpdateListener.onUpdateComplete(-6, "do post response code: " + responseCode, null);
                        }
                        r65 = null;
                        str4 = null;
                    }
                    HippyUtils.safeClose(bufferedReader20);
                    HippyUtils.safeClose(outputStream);
                    HippyUtils.safeClose(r65);
                    createPostConnection.disconnect();
                    return str4;
                } catch (MalformedURLException e28) {
                    e = e28;
                    bufferedReader11 = outputStream;
                    bufferedReader12 = null;
                    bufferedReader4 = null;
                    httpURLConnection7 = createPostConnection;
                } catch (IOException e29) {
                    e = e29;
                    bufferedReader7 = outputStream;
                    bufferedReader8 = null;
                    bufferedReader4 = null;
                    httpURLConnection5 = createPostConnection;
                } catch (Throwable th8) {
                    th = th8;
                    bufferedReader5 = outputStream;
                    bufferedReader6 = null;
                    bufferedReader4 = null;
                    httpURLConnection4 = createPostConnection;
                }
            } catch (MalformedURLException e36) {
                e = e36;
                bufferedReader3 = null;
                httpURLConnection3 = createPostConnection;
                BufferedReader bufferedReader21 = bufferedReader3;
                bufferedReader4 = bufferedReader21;
                httpURLConnection7 = httpURLConnection3;
                bufferedReader12 = bufferedReader3;
                bufferedReader11 = bufferedReader21;
                logException(e);
                HippyUtils.safeClose(bufferedReader4);
                HippyUtils.safeClose(bufferedReader11);
                HippyUtils.safeClose(bufferedReader12);
                httpURLConnection6 = httpURLConnection7;
                bufferedReader10 = bufferedReader12;
                bufferedReader9 = bufferedReader11;
                str = httpURLConnection7;
                str3 = bufferedReader12;
                packageUpdateListener = bufferedReader11;
            } catch (IOException e37) {
                e = e37;
                bufferedReader2 = null;
                httpURLConnection2 = createPostConnection;
                BufferedReader bufferedReader22 = bufferedReader2;
                bufferedReader4 = bufferedReader22;
                httpURLConnection5 = httpURLConnection2;
                bufferedReader8 = bufferedReader2;
                bufferedReader7 = bufferedReader22;
                logException(e);
                HippyUtils.safeClose(bufferedReader4);
                HippyUtils.safeClose(bufferedReader7);
                HippyUtils.safeClose(bufferedReader8);
                httpURLConnection6 = httpURLConnection5;
                bufferedReader10 = bufferedReader8;
                bufferedReader9 = bufferedReader7;
                str = httpURLConnection5;
                str3 = bufferedReader8;
                packageUpdateListener = bufferedReader7;
            } catch (Throwable th9) {
                th = th9;
                bufferedReader = null;
                httpURLConnection = createPostConnection;
                BufferedReader bufferedReader23 = bufferedReader;
                bufferedReader4 = bufferedReader23;
                httpURLConnection4 = httpURLConnection;
                bufferedReader6 = bufferedReader;
                bufferedReader5 = bufferedReader23;
                logException(th);
            }
        } finally {
            HippyUtils.safeClose(bufferedReader4);
            HippyUtils.safeClose(packageUpdateListener);
            HippyUtils.safeClose(str3);
            if (str != 0) {
                str.disconnect();
            }
        }
    }

    protected static void logException(Throwable th5) {
        String str;
        if (QLog.isColorLevel()) {
            if (th5 != null) {
                str = th5.getMessage();
            } else {
                str = "";
            }
            QLog.e(HippyQQConstants.HIPPY_TAG, 2, "Hippy: doPost throwable msg=" + str);
        }
    }

    protected static String readHttpData(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
                stringBuffer.append("\r\n");
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
