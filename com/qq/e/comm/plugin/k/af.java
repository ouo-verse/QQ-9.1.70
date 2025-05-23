package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes3.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f39614a = Pattern.compile("^https\\://.*", 2);

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final String f39617a;

        /* renamed from: b, reason: collision with root package name */
        private a f39618b;

        public b(String str, a aVar) {
            this.f39617a = str;
            this.f39618b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                URL url = new URL(this.f39617a);
                GDTLogger.d("URLConnectionPingRunner PingURL:" + url);
                URLConnection openConnection = url.openConnection();
                if (com.qq.e.comm.plugin.j.c.a("enableSetAdUa", 1, 1) && openConnection != null) {
                    openConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
                }
                if (openConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) openConnection).getInputStream().close();
                } else {
                    openConnection.getInputStream().close();
                }
                a aVar = this.f39618b;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (MalformedURLException e16) {
                GDTLogger.e("Exception while ping", e16);
                a aVar2 = this.f39618b;
                if (aVar2 != null) {
                    aVar2.a(2001);
                }
            } catch (IOException e17) {
                a aVar3 = this.f39618b;
                if (aVar3 != null) {
                    aVar3.a(2001);
                }
                q.a(e17, this.f39617a);
            } catch (Exception e18) {
                GDTLogger.e("Exception while ping", e18);
                a aVar4 = this.f39618b;
                if (aVar4 != null) {
                    aVar4.a(2001);
                }
            } catch (Throwable th5) {
                GDTLogger.e("Exception while ping", th5);
                a aVar5 = this.f39618b;
                if (aVar5 != null) {
                    aVar5.a(2009);
                }
            }
        }
    }

    @Deprecated
    public static void a(String str) {
        a(str, true, null);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(2, new b(str, null));
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            String string = SharedPreferencedUtil.getString("ipv4_" + str, "");
            GDTLogger.d("\u672c\u5730\u9009\u5355ping \u7f13\u5b58ipv4 :" + string);
            b(string);
        }
    }

    private static boolean d(String str) {
        return f39614a.matcher(str).matches();
    }

    @Deprecated
    public static void a(String str, boolean z16, a aVar) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        if (d(str)) {
            a(str, aVar);
        } else {
            b(str, z16, aVar);
        }
    }

    @Deprecated
    private static void b(final String str, boolean z16, final a aVar) {
        NetworkClientImpl.getInstance().submit(new PlainRequest(str, 1, (byte[]) null), z16 ? 1 : 3, new NetworkCallBack() { // from class: com.qq.e.comm.plugin.k.af.1
            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onException(Exception exc) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(2000);
                }
                GDTLogger.e("error while ping URL:" + str, exc);
            }

            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onResponse(Request request, Response response) {
                GDTLogger.d("PingURL:" + str + "\t responseStatus" + response.getStatusCode());
                if (aVar != null) {
                    if (response.getStatusCode() != 200 && response.getStatusCode() != 204) {
                        aVar.a(response.getStatusCode());
                    } else {
                        aVar.a();
                    }
                }
            }
        });
    }

    public static void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(2, new b(str, aVar));
    }
}
