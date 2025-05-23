package com.tencent.aelight.camera.ae.play;

import android.content.res.AssetFileDescriptor;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes32.dex */
public class UrlConHttpClient implements IHttpClient {
    private static final String TAG = "UrlConHttpClient";
    private IResponseListener mResponseListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void errorResponse(int i3, String str, String str2) {
        IResponseListener iResponseListener = this.mResponseListener;
        if (iResponseListener != null) {
            iResponseListener.response(i3, 1, str, str2);
        }
    }

    @Override // com.tencent.ttpic.openapi.offlineset.utils.IHttpClient
    public void download(final int i3, final String str, final String str2, final String str3) {
        String str4 = TAG;
        LogUtils.i(str4, "\u5f00\u59cb\u4e0b\u8f7d\u6587\u4ef6:" + str2);
        if (TextUtils.isEmpty(str2)) {
            LogUtils.e(str4, "downUrl \u65e0\u6548\uff1a" + str2);
            return;
        }
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.UrlConHttpClient.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
                Throwable th5;
                FileOutputStream fileOutputStream;
                InputStream inputStream = null;
                try {
                    try {
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(3000);
                            TrafficStats.setThreadStatsTag(-255);
                            httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                            httpURLConnection.addRequestProperty("Connection", "Keep-Alive");
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                String name = new File(httpURLConnection.getURL().getFile()).getName();
                                File file = new File(str3);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                File file2 = new File(file, name);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    inputStream = httpURLConnection.getInputStream();
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                    }
                                    if (UrlConHttpClient.this.mResponseListener != null) {
                                        UrlConHttpClient.this.mResponseListener.response(i3, 0, file2.getPath(), str);
                                    }
                                    httpURLConnection.disconnect();
                                } catch (MalformedURLException unused) {
                                    UrlConHttpClient.this.errorResponse(i3, "MalformedURLException:URL \u6709\u5f02\u5e38\u3002", str);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused2) {
                                            UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    TrafficStats.clearThreadStatsTag();
                                } catch (IOException unused3) {
                                    UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused4) {
                                            UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    TrafficStats.clearThreadStatsTag();
                                } catch (Exception unused5) {
                                    UrlConHttpClient.this.errorResponse(i3, "Exception:\u4e0b\u8f7d\u6587\u4ef6\u6709\u5f02\u5e38\u3002", str);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused6) {
                                            UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    TrafficStats.clearThreadStatsTag();
                                }
                            } else {
                                if (responseCode != 301 || !str2.contains("http:")) {
                                    UrlConHttpClient.this.errorResponse(i3, "\u4e0b\u8f7d\u5931\u8d25\u3002", str);
                                } else {
                                    LogUtils.e(UrlConHttpClient.TAG, "\u4e0b\u8f7d\u91cd\u5b9a\u5411\uff0c\u5c1d\u8bd5\u4f7f\u7528https\u534f\u8bae:" + str2);
                                    UrlConHttpClient.this.download(i3, str, str2.replace("http:", "https:"), str3);
                                }
                                fileOutputStream = null;
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused7) {
                                    UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                }
                            }
                        } catch (MalformedURLException unused8) {
                            fileOutputStream = null;
                        } catch (IOException unused9) {
                            fileOutputStream = null;
                        } catch (Exception unused10) {
                            fileOutputStream = null;
                        } catch (Throwable th6) {
                            th5 = th6;
                            autoCloseOutputStream = 0;
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused11) {
                                    UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                }
                            }
                            if (autoCloseOutputStream != 0) {
                                try {
                                    autoCloseOutputStream.close();
                                } catch (IOException unused12) {
                                    UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                                }
                            }
                            TrafficStats.clearThreadStatsTag();
                            throw th5;
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException unused13) {
                        UrlConHttpClient.this.errorResponse(i3, "IOException:\u4e0b\u8f7d\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                    }
                    TrafficStats.clearThreadStatsTag();
                } catch (Throwable th7) {
                    autoCloseOutputStream = "http:";
                    th5 = th7;
                }
            }
        });
    }

    @Override // com.tencent.ttpic.openapi.offlineset.utils.IHttpClient
    public void get(final int i3, final String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            LogUtils.e(TAG, "url \u65e0\u6548\uff1a" + str2);
            return;
        }
        LogUtils.i(TAG, "GET \u8bf7\u6c42\uff1a" + str2);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.UrlConHttpClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                        httpURLConnection.setConnectTimeout(3000);
                        httpURLConnection.setReadTimeout(3000);
                        TrafficStats.setThreadStatsTag(-255);
                        httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (-1 == read) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                byteArrayOutputStream.flush();
                            }
                            inputStream.close();
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                            byteArrayOutputStream.close();
                            LogUtils.i(UrlConHttpClient.TAG, "onResponse: " + byteArrayOutputStream2);
                            if (UrlConHttpClient.this.mResponseListener != null) {
                                if (byteArrayOutputStream2 != null) {
                                    UrlConHttpClient.this.mResponseListener.response(i3, 0, byteArrayOutputStream2, str);
                                } else {
                                    UrlConHttpClient.this.mResponseListener.response(i3, 1, "\u56de\u5305\u5f02\u5e38\u3002", str);
                                }
                            }
                            httpURLConnection.disconnect();
                        } else if (responseCode != 301 || !str2.contains("http:")) {
                            LogUtils.e(UrlConHttpClient.TAG, responseCode + "->\u94fe\u63a5\u5931\u8d25\uff1a" + str2);
                            UrlConHttpClient.this.errorResponse(i3, responseCode + "->\u94fe\u63a5\u5931\u8d25\uff1a" + str2, str);
                        } else {
                            UrlConHttpClient.this.get(i3, str, str2.replace("http:", "https:"));
                        }
                    } catch (MalformedURLException unused) {
                        UrlConHttpClient.this.errorResponse(i3, "MalformedURLException:URL \u6709\u5f02\u5e38\u3002", str);
                    } catch (IOException unused2) {
                        UrlConHttpClient.this.errorResponse(i3, "IOException:\u8bfb\u53d6\u6709\u5f02\u5e38\u3002", str);
                    } catch (Exception unused3) {
                        UrlConHttpClient.this.errorResponse(i3, "Exception:\u5f02\u5e38\u3002", str);
                    }
                } finally {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        });
    }

    @Override // com.tencent.ttpic.openapi.offlineset.utils.IHttpClient
    public void setResponseListener(IResponseListener iResponseListener) {
        LogUtils.i(TAG, "setResponseListener ");
        this.mResponseListener = iResponseListener;
    }

    @Override // com.tencent.ttpic.openapi.offlineset.utils.IHttpClient
    public void post(int i3, String str, String str2) {
    }
}
