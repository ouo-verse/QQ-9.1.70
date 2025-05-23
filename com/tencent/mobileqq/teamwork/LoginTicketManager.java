package com.tencent.mobileqq.teamwork;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LoginTicketManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile LoginTicketManager f291484d;

    /* renamed from: e, reason: collision with root package name */
    private static long f291485e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f291486a = false;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f291487b = "";

    /* renamed from: c, reason: collision with root package name */
    private IAccountCallback f291488c = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291493a;

        b(IGetExternalInterface.d dVar) {
            this.f291493a = dVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            if (!(obj instanceof String)) {
                return;
            }
            LoginTicketManager.this.f291487b = (String) obj;
            this.f291493a.a(LoginTicketManager.this.f291487b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                QLog.i("LoginTicketManager", 1, "--- uploadFileInfo response status: " + responseCode + " ----");
                return "";
            }
            List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
            Objects.requireNonNull(list);
            ArrayList arrayList = new ArrayList(list);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains("TOK")) {
                    it.remove();
                }
            }
            return StringUtil.listToString(arrayList, ";");
        } catch (Exception e16) {
            QLog.e("LoginTicketManager", 2, e16.toString());
            return "";
        }
    }

    public static LoginTicketManager g() {
        if (f291484d == null) {
            synchronized (LoginTicketManager.class) {
                if (f291484d == null) {
                    f291484d = new LoginTicketManager();
                }
            }
        }
        return f291484d;
    }

    private int h() {
        int i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (i3 = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getInt("tencent_docs_cookie_valid_time_hour", 672)) <= 0) {
            return 672;
        }
        QLog.i("LoginTicketManager", 1, "getTencentDocsTicketValidTime" + i3);
        return i3;
    }

    private boolean i() {
        if (System.currentTimeMillis() - f291485e < h() * 1000 * 60 * 60) {
            return true;
        }
        return false;
    }

    private void j(IAccountCallback iAccountCallback) {
        MobileQQ.sMobileQQ.registerAccountCallback(iAccountCallback);
    }

    private static synchronized void k(final IGetExternalInterface.d dVar) {
        synchronized (LoginTicketManager.class) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.LoginTicketManager.3

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.teamwork.LoginTicketManager$3$a */
                /* loaded from: classes18.dex */
                class a implements IGetExternalInterface.c {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ HttpURLConnection f291490a;

                    a(HttpURLConnection httpURLConnection) {
                        this.f291490a = httpURLConnection;
                    }

                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
                    public void a(String str) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Connection", "keep-alive");
                        hashMap.put("Referer", "https://qqandroid.docs.qq.com/api/user/qq/login");
                        hashMap.put("Cookie", new StringBuilder("p_skey=" + str + ";p_uin=" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() + ";utype=qq").toString());
                        for (Map.Entry entry : hashMap.entrySet()) {
                            this.f291490a.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        String e16 = LoginTicketManager.e(this.f291490a);
                        long unused = LoginTicketManager.f291485e = System.currentTimeMillis();
                        IGetExternalInterface.d.this.a(e16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c cVar = new c();
                        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                        sSLContext.init(null, new TrustManager[]{cVar}, null);
                        HttpsURLConnection.setDefaultSSLSocketFactory(new l(sSLContext.getSocketFactory()));
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqandroid.docs.qq.com/api/user/qq/login").openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        StringBuilder sb5 = new StringBuilder("android");
                        sb5.append("_");
                        sb5.append(Build.VERSION.SDK);
                        sb5.append("_");
                        sb5.append(Build.DEVICE);
                        sb5.append("_");
                        sb5.append(Build.VERSION.RELEASE);
                        sb5.append("_");
                        String str = AppSetting.f99551k;
                        sb5.append(str);
                        sb5.append("_");
                        sb5.append("QQ/");
                        sb5.append(str + AppSetting.f99542b);
                        httpURLConnection.setRequestProperty("User-Agent", sb5.toString());
                        httpURLConnection.setRequestProperty("Content-Type", "application/json");
                        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new a(httpURLConnection));
                    } catch (Exception e16) {
                        QLog.e("LoginTicketManager", 2, e16.toString());
                        IGetExternalInterface.d.this.a("");
                    }
                }
            }, 128, null, false);
        }
    }

    public void f(IGetExternalInterface.d dVar) {
        if (!this.f291486a) {
            j(this.f291488c);
            this.f291486a = true;
        }
        if (!this.f291487b.isEmpty() && f291485e != 0 && i()) {
            dVar.a(this.f291487b);
        } else {
            k(new b(dVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime appRuntime) {
            QLog.i("LoginTicketManager", 1, "onAccountChanged");
            if (appRuntime != null) {
                LoginTicketManager.this.f291487b = "";
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason logoutReason) {
            QLog.i("LoginTicketManager", 1, "onLogout");
            LoginTicketManager.this.f291487b = "";
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime appRuntime) {
        }
    }
}
