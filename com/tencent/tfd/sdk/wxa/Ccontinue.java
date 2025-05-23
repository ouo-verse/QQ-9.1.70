package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.continue, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Ccontinue {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HttpURLConnection f375753a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f375754b;

    public Ccontinue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375753a = null;
            this.f375754b = false;
        }
    }

    public static int b(Context context) {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0078, code lost:
    
        if ((r3 != null && r3.contains("ACCESS_NETWORK_STATE")) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(String str, byte[] bArr) {
        Context context;
        char c16;
        int i3;
        NetworkInfo activeNetworkInfo;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bArr)).intValue();
        }
        synchronized (Cgoto.class) {
            context = Cgoto.f375756a;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th5) {
            String message = th5.getMessage();
        }
        if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
            if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
                c16 = (NetworkMonitor.getType(activeNetworkInfo) != 0 || (a16 = a(context)) == null || a16.length() <= 0 || b(context) <= 0) ? (char) 3 : (char) 2;
                if (c16 == 4) {
                    i3 = MessageRecord.MSG_TYPE_AI_SPECIAL_GUIDE;
                } else {
                    try {
                        URL url = new URL(str);
                        if (c16 == 2) {
                            this.f375753a = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(a(Cgoto.a()), b(Cgoto.a()))));
                        } else {
                            this.f375753a = (HttpURLConnection) url.openConnection();
                        }
                        this.f375753a.setReadTimeout(15000);
                        this.f375753a.setConnectTimeout(15000);
                        i3 = 0;
                    } catch (SecurityException e16) {
                        e16.printStackTrace();
                        i3 = -1058;
                    } catch (UnsupportedOperationException e17) {
                        e17.printStackTrace();
                        i3 = -1059;
                    } catch (MalformedURLException e18) {
                        e18.printStackTrace();
                        i3 = -1053;
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        i3 = -1056;
                    } catch (IllegalArgumentException e26) {
                        e26.printStackTrace();
                        i3 = -1057;
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                        i3 = -1000;
                    }
                }
                if (i3 == 0) {
                    this.f375754b = false;
                    i3 = -2000;
                    try {
                        try {
                            int length = bArr.length;
                            this.f375753a.setDoOutput(true);
                            this.f375753a.setDoInput(true);
                            this.f375753a.setUseCaches(false);
                            this.f375753a.setRequestMethod("POST");
                            this.f375753a.setRequestProperty("Pragma", "no-cache");
                            this.f375753a.setRequestProperty("Cache-Control", "no-cache");
                            this.f375753a.setInstanceFollowRedirects(false);
                            this.f375753a.setRequestProperty("User-Agent", "Turing");
                            this.f375753a.setRequestProperty("Accept", "*/*");
                            this.f375753a.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                            this.f375753a.setRequestProperty("Content-Type", "application/octet-stream");
                            this.f375753a.setRequestProperty(FileUploadBase.CONTENT_LENGTH, "" + length);
                            try {
                                if (Build.VERSION.SDK != null) {
                                    this.f375753a.setRequestProperty("Connection", "close");
                                }
                            } catch (Exception unused) {
                            }
                            OutputStream outputStream = this.f375753a.getOutputStream();
                            outputStream.write(bArr);
                            outputStream.flush();
                            outputStream.close();
                            int responseCode = this.f375753a.getResponseCode();
                            if (responseCode == 200) {
                                this.f375754b = true;
                                return 0;
                            }
                            if (responseCode != -1) {
                                return (-2000) - responseCode;
                            }
                        } catch (IOException e27) {
                            StringBuilder a17 = Pyxis.a("post io error:");
                            a17.append(e27.getMessage());
                            Log.e("TuringHttpUtil", a17.toString());
                            e27.printStackTrace();
                            return MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG;
                        } catch (IllegalStateException e28) {
                            StringBuilder a18 = Pyxis.a("illegal state error:");
                            a18.append(e28.getMessage());
                            Log.e("TuringHttpUtil", a18.toString());
                            e28.printStackTrace();
                            return MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED;
                        } catch (ProtocolException e29) {
                            StringBuilder a19 = Pyxis.a("protocol error:");
                            a19.append(e29.getMessage());
                            Log.e("TuringHttpUtil", a19.toString());
                            e29.printStackTrace();
                            return MessageRecord.MSG_TYPE_QQSTORY;
                        }
                    } catch (IllegalAccessError e36) {
                        StringBuilder a26 = Pyxis.a("illegal access error:");
                        a26.append(e36.getMessage());
                        Log.e("TuringHttpUtil", a26.toString());
                        e36.printStackTrace();
                        return MessageRecord.MSG_TYPE_PL_NEWS;
                    } catch (Throwable th7) {
                        Log.w("TuringHttpUtil", th7);
                        th7.printStackTrace();
                    }
                }
                return i3;
            }
            c16 = 1;
            if (c16 == 4) {
            }
            if (i3 == 0) {
            }
            return i3;
        }
        c16 = 4;
        if (c16 == 4) {
        }
        if (i3 == 0) {
        }
        return i3;
    }

    public static String a(Context context) {
        return System.getProperty("http.proxyHost");
    }
}
