package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f305886a;

    /* renamed from: b, reason: collision with root package name */
    private long f305887b;

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f305886a = "";
        this.f305887b = 0L;
        if (str != null && str.length() >= 1) {
            h(str);
            if (this.f305886a.isEmpty()) {
                this.f305886a = IUniformDownloadMgr.FILENAME_DEFAULT;
            }
        }
    }

    public static void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(bundle.getString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, "")) || bundle.getLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG) == 0) {
            d dVar = new d(str);
            bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, dVar.f());
            bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, dVar.g());
        }
    }

    private String b(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (str.contains(":")) {
            return "";
        }
        return str;
    }

    private String c(String str) throws MalformedURLException {
        String file = new URL(str).getFile();
        if (file != null && file.contains(".")) {
            int lastIndexOf = file.lastIndexOf("/");
            if (lastIndexOf == -1) {
                return file;
            }
            return file.substring(lastIndexOf + 1);
        }
        return "";
    }

    private String d(HttpURLConnection httpURLConnection) {
        String str;
        UnsupportedEncodingException e16;
        String str2;
        String str3 = "";
        try {
            str = httpURLConnection.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
        } catch (UnsupportedEncodingException e17) {
            str = str3;
            e16 = e17;
        }
        if (str != null) {
            try {
            } catch (UnsupportedEncodingException e18) {
                e16 = e18;
            }
            if (str.length() >= 1) {
                int indexOf = str.toLowerCase().indexOf("filename=");
                if (indexOf == -1) {
                    return "";
                }
                String decode = URLDecoder.decode(str.substring(indexOf + 9), "utf-8");
                try {
                    int indexOf2 = decode.indexOf(";");
                    if (-1 != indexOf2) {
                        decode = decode.substring(0, indexOf2 - 1);
                    }
                    str = "\"";
                    str2 = decode.replaceAll("\"", "");
                } catch (UnsupportedEncodingException e19) {
                    e16 = e19;
                    str = decode;
                    e16.printStackTrace();
                    str2 = str;
                    return b(str2);
                }
                return b(str2);
            }
        }
        str3 = httpURLConnection.getURL().getFile();
        str2 = str3.substring(str3.lastIndexOf("/") + 1);
        return b(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        if (r5 == 0) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long e(String str, int i3) {
        long j3 = 0;
        if (i3 <= 0) {
            return 0L;
        }
        HttpURLConnection httpURLConnection = null;
        r2 = null;
        r2 = null;
        String str2 = null;
        try {
            try {
                str = (HttpURLConnection) new URL(str).openConnection();
            } catch (Exception e16) {
                e = e16;
                str = 0;
            } catch (Throwable th5) {
                th = th5;
                if (httpURLConnection != null) {
                }
                throw th;
            }
            try {
                if (str.getResponseCode() == 302) {
                    str2 = str.getHeaderField("Location");
                } else {
                    j3 = str.getContentLength();
                }
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
            }
            str.disconnect();
            if (str2 != null) {
                return e(str2, i3 - 1);
            }
            return j3;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = str;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private void h(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                    httpURLConnection2.setRequestProperty("contentType", "utf-8");
                    httpURLConnection2.connect();
                    httpURLConnection2.getResponseCode();
                    if (httpURLConnection2.getResponseCode() == 200) {
                        this.f305887b = httpURLConnection2.getContentLength();
                        String d16 = d(httpURLConnection2);
                        this.f305886a = d16;
                        if (d16.isEmpty()) {
                            this.f305886a = c(str);
                        }
                    }
                    httpURLConnection2.disconnect();
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f305886a;
    }

    public long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f305887b;
    }
}
