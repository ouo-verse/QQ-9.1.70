package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static ConnectivityManager f194368b;

    /* renamed from: c, reason: collision with root package name */
    public static DefaultHttpClient f194369c;

    /* renamed from: a, reason: collision with root package name */
    public Context f194370a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194368b = null;
            f194369c = null;
        }
    }

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f194370a = context;
        }
    }

    private void c(String str, String str2) {
        InputStream inputStream;
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        byte[] bArr = new byte[4096];
        try {
            try {
                QZipFile qZipFile = new QZipFile(str);
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                while (entries.hasMoreElements()) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        inputStream = qZipFile.getInputStream(nextElement);
                        try {
                            if (nextElement.getName().contains("..")) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th.printStackTrace();
                                    }
                                }
                            } else {
                                File file = new File(str2 + nextElement.getName());
                                if (nextElement.isDirectory()) {
                                    file.mkdirs();
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (!parentFile.exists()) {
                                        parentFile.mkdirs();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            } else {
                                                fileOutputStream2.write(bArr, 0, read);
                                            }
                                        } catch (IOException unused) {
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e16) {
                                                    e16.printStackTrace();
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    th.printStackTrace();
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e17) {
                                                    e17.printStackTrace();
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                    throw th;
                                                } catch (Throwable th8) {
                                                    th8.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream = fileOutputStream2;
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th9) {
                                        th = th9;
                                        th.printStackTrace();
                                    }
                                }
                            }
                        } catch (IOException unused2) {
                        } catch (Throwable th10) {
                            th = th10;
                        }
                    } catch (IOException unused3) {
                        inputStream = null;
                    } catch (Throwable th11) {
                        th = th11;
                        inputStream = null;
                    }
                }
            } catch (Exception unused4) {
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    public boolean a(String str, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, str2, str3, Boolean.valueOf(z16))).booleanValue();
        }
        if (AppNetConnInfo.isNetSupport() && str2 != null) {
            try {
                return b(new URL(str), str2, str3, z16);
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ea, code lost:
    
        com.tencent.qphone.base.util.QLog.d("httpdownload", 1, "hash verify failed!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f1, code lost:
    
        r0 = com.tencent.mobileqq.antiphing.c.f194369c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f3, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fc, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0220, code lost:
    
        if (r0 == null) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(URL url, String str, String str2, boolean z16) {
        String str3;
        File file;
        File file2;
        HttpGet httpGet;
        String str4;
        int i3;
        int i16;
        DefaultHttpClient defaultHttpClient;
        boolean renameTo;
        String str5 = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, url, str5, str2, Boolean.valueOf(z16))).booleanValue();
        }
        if (!z16) {
            str3 = str5 + ".tmp";
            file = new File(str3);
            file2 = new File(str5);
        } else {
            str5 = str.trim();
            if (!str5.endsWith("/") && !str5.endsWith("\\")) {
                str5 = str5 + "/";
            }
            str3 = str5 + "temp.zip";
            file = new File(str3);
            file2 = new File(str5);
        }
        if (file.exists() && !file.delete()) {
            return false;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            String url2 = url.toString();
            try {
                try {
                    httpGet = new HttpGet(url2);
                } catch (IllegalArgumentException unused) {
                    httpGet = new HttpGet(HttpDownloadUtil.getEscapeSequence(url2));
                }
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                boolean isMobileConn = AppNetConnInfo.isMobileConn();
                NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
                if (recentNetworkInfo != null) {
                    str4 = NetworkMonitor.netGetExInfo(recentNetworkInfo);
                } else {
                    str4 = null;
                }
                String str6 = ConnRoutePNames.DEFAULT_PROXY;
                if (isMobileConn && ((str4 == null || str4.endsWith("wap")) && defaultHost != null && defaultPort > 0)) {
                    basicHttpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
                }
                if (isMobileConn) {
                    basicHttpParams.setIntParameter("http.socket.buffer-size", 2048);
                    i3 = 20000;
                    i16 = 60000;
                } else {
                    basicHttpParams.setIntParameter("http.socket.buffer-size", 4096);
                    i3 = 10000;
                    i16 = 30000;
                }
                basicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(i3));
                basicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(i16));
                httpGet.setParams(basicHttpParams);
                int i17 = 0;
                boolean z18 = false;
                while (true) {
                    if (i17 == z17) {
                        basicHttpParams.removeParameter(str6);
                        httpGet.setParams(basicHttpParams);
                    }
                    i17++;
                    try {
                        try {
                            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
                            HttpProtocolParams.setVersion(basicHttpParams2, HttpVersion.HTTP_1_1);
                            HttpProtocolParams.setContentCharset(basicHttpParams2, "ISO-8859-1");
                            HttpProtocolParams.setUseExpectContinue(basicHttpParams2, z17);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            String str7 = str6;
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient2 = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams2, schemeRegistry), basicHttpParams2);
                            f194369c = defaultHttpClient2;
                            defaultHttpClient2.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
                            HttpResponse execute = f194369c.execute(new HttpHost(url.getHost()), httpGet);
                            if (200 == execute.getStatusLine().getStatusCode()) {
                                HttpEntity entity = execute.getEntity();
                                entity.getContentLength();
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    entity.writeTo(fileOutputStream);
                                    file.length();
                                    file.setLastModified(System.currentTimeMillis());
                                    fileOutputStream.close();
                                    if (!MD5Utils.encodeFileHexStr(str3).equalsIgnoreCase(str2)) {
                                        break;
                                    }
                                    QLog.d("httpdownload", 1, "verify hash ok!");
                                    if (z16) {
                                        QLog.d("httpdownload", 2, "Need to be unzipped!");
                                        c(str3, str5);
                                        renameTo = true;
                                    } else {
                                        QLog.d("httpdownload", 2, "Do not need to be unzipped!");
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        renameTo = file.renameTo(file2);
                                    }
                                    z18 = renameTo;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    defaultHttpClient = f194369c;
                                }
                            }
                            DefaultHttpClient defaultHttpClient3 = f194369c;
                            if (defaultHttpClient3 != null) {
                                defaultHttpClient3.getConnectionManager().shutdown();
                                f194369c = null;
                            }
                            if (z18 || i17 >= 2) {
                                break;
                            }
                            z17 = true;
                            str6 = str7;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            defaultHttpClient = f194369c;
                        }
                    } catch (Throwable th5) {
                        DefaultHttpClient defaultHttpClient4 = f194369c;
                        if (defaultHttpClient4 != null) {
                            defaultHttpClient4.getConnectionManager().shutdown();
                            f194369c = null;
                        }
                        throw th5;
                    }
                }
                defaultHttpClient.getConnectionManager().shutdown();
                f194369c = null;
                return z18;
            } catch (Exception unused2) {
                return false;
            }
        } catch (Exception unused3) {
            return false;
        }
    }
}
