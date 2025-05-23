package com.tencent.mobileqq.troop.soso;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f298860e;

    /* renamed from: f, reason: collision with root package name */
    public static int f298861f;

    /* renamed from: g, reason: collision with root package name */
    private static b f298862g;

    /* renamed from: a, reason: collision with root package name */
    private List<com.tencent.mobileqq.troop.soso.a> f298863a;

    /* renamed from: b, reason: collision with root package name */
    a f298864b;

    /* renamed from: c, reason: collision with root package name */
    Application f298865c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f298866d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int[] f298867a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        private com.tencent.mobileqq.troop.soso.a a(List<com.tencent.mobileqq.troop.soso.a> list, int[] iArr, boolean z16) {
            int intValue;
            if (iArr != null) {
                ArrayList arrayList = new ArrayList();
                int i3 = 5;
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    if (list.get(i16).isIpv6() == z16) {
                        int i17 = iArr[i16];
                        if (i17 < i3) {
                            arrayList.clear();
                            arrayList.add(Integer.valueOf(i16));
                            i3 = i17;
                        } else if (i17 == i3) {
                            arrayList.add(Integer.valueOf(i16));
                        }
                    }
                }
                if (arrayList.size() > 0 && (intValue = ((Integer) arrayList.get(0)).intValue()) >= 0 && intValue < list.size()) {
                    return list.get(intValue);
                }
                return null;
            }
            return null;
        }

        com.tencent.mobileqq.troop.soso.a b(int i3, boolean z16) {
            List<com.tencent.mobileqq.troop.soso.a> f16 = b.this.f(i3);
            if (f16 != null && f16.size() > 0) {
                return a(f16, c(i3), z16);
            }
            return null;
        }

        int[] c(int i3) {
            if (i3 == 0) {
                return this.f298867a;
            }
            return null;
        }

        void d(List<com.tencent.mobileqq.troop.soso.a> list) {
            if (list != null && list.size() > 0) {
                this.f298867a = new int[list.size()];
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f298860e = 0;
            f298861f = 0 + 1;
        }
    }

    b(Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application);
            return;
        }
        this.f298864b = new a();
        this.f298866d = false;
        this.f298865c = application;
    }

    public static b c() {
        if (f298862g == null) {
            synchronized (b.class) {
                if (f298862g == null) {
                    f298862g = new b(MobileQQ.sMobileQQ);
                }
            }
        }
        return f298862g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.troop.soso.a> f(int i3) {
        if (i3 == 0) {
            return this.f298863a;
        }
        return null;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SharedPreferences.Editor edit = this.f298865c.getSharedPreferences("SosoSrvAddrList", 0).edit();
        if (edit != null) {
            edit.remove("SosoSrvAddrList_key").commit();
        }
        Intent intent = new Intent("com.tencent.receiver.soso");
        intent.putExtra("com.tencent.receiver.soso.type", f298861f);
        this.f298865c.sendBroadcast(intent);
    }

    public synchronized String d(int i3, boolean z16, boolean z17) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        com.tencent.mobileqq.troop.soso.a b16 = this.f298864b.b(i3, z16);
        if (b16 != null) {
            String ip5 = b16.getIp();
            int port = b16.getPort();
            if (ip5 == null) {
                ip5 = "";
            }
            if (ip5.indexOf(58) >= 0 && !ip5.startsWith("[")) {
                ip5 = "[" + ip5 + "]";
            }
            if (z17) {
                str2 = "https://";
            } else {
                str2 = "http://";
            }
            str = str2 + ip5 + ":" + port + "/";
        } else {
            str = null;
        }
        return str;
    }

    public synchronized String e(AppInterface appInterface, int i3, boolean z16, boolean z17) {
        List<EndPoint> list;
        int i16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, appInterface, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        String str2 = null;
        if (appInterface == null) {
            return null;
        }
        String str3 = "";
        ConfigManager configManager = ConfigManager.getInstance(BaseApplication.getContext(), appInterface.getHwEngine());
        if (configManager != null) {
            list = configManager.getOtherTypeIp(appInterface.getApp().getBaseContext(), 21, z16);
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            str3 = list.get(0).host;
            i16 = list.get(0).port;
        } else {
            if (!this.f298866d && NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                HwServlet.getConfig(appInterface, appInterface.getCurrentAccountUin());
                this.f298866d = true;
            }
            com.tencent.mobileqq.troop.soso.a b16 = this.f298864b.b(i3, z16);
            if (b16 != null) {
                str3 = b16.getIp();
                i16 = b16.getPort();
                z17 = false;
            } else {
                z17 = false;
                i16 = -1;
            }
        }
        if (!TextUtils.isEmpty(str3) && i16 != -1) {
            if (str3.indexOf(58) >= 0 && !str3.startsWith("[")) {
                str3 = "[" + str3 + "]";
            }
            if (z17) {
                str = "https://";
            } else {
                str = "http://";
            }
            str2 = str + str3 + ":" + i16 + "/";
        }
        return str2;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        List<com.tencent.mobileqq.troop.soso.a> arrayList = new ArrayList<>();
        HwConfig hwConfig = (HwConfig) ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getHighwayConfig();
        if (hwConfig != null) {
            ArrayList<EndPoint> arrayList2 = hwConfig.ipv6List;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i3 = 0; i3 < hwConfig.ipv6List.size(); i3++) {
                    c cVar = new c();
                    cVar.f298869a = hwConfig.ipv6List.get(i3).host;
                    cVar.f298870b = hwConfig.ipv6List.get(i3).port;
                    cVar.f298871c = true;
                    arrayList.add(cVar);
                }
            }
            ArrayList<EndPoint> arrayList3 = hwConfig.ipList;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i16 = 0; i16 < hwConfig.ipList.size(); i16++) {
                    c cVar2 = new c();
                    cVar2.f298869a = hwConfig.ipList.get(i16).host;
                    cVar2.f298870b = hwConfig.ipList.get(i16).port;
                    cVar2.f298871c = false;
                    arrayList.add(cVar2);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("SosoSrvAddrProvider", 2, String.format("init iplist=%s", Arrays.toString(arrayList.toArray())));
        }
        h(arrayList);
    }

    public synchronized void h(List<com.tencent.mobileqq.troop.soso.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.f298863a = list;
            this.f298864b.d(list);
        }
    }
}
