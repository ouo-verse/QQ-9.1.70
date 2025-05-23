package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    HashMap<Integer, com.tencent.mobileqq.intervideo.yiqikan.a> f238500d;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f238501e;

    /* renamed from: f, reason: collision with root package name */
    Map<String, NewTogetherRoomMessageData> f238502f;

    /* renamed from: h, reason: collision with root package name */
    IVPluginReportInterface f238503h;

    /* renamed from: i, reason: collision with root package name */
    String f238504i;

    /* renamed from: m, reason: collision with root package name */
    tr2.d f238505m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends tr2.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // tr2.d
        protected void b(boolean z16, tr2.f fVar, int i3, String str) {
            NewTogetherRoomMessageData d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), fVar, Integer.valueOf(i3), str);
                return;
            }
            if (z16 && fVar != null) {
                QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + fVar.f437189f);
                if ((fVar instanceof WatchTogetherSession) && (d16 = h.this.d((WatchTogetherSession) fVar)) != null) {
                    h.this.q(fVar.f437189f, d16);
                    h.this.n("100", d16.f238446f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements com.tencent.mobileqq.intervideo.yiqikan.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.b
        public void callback(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements com.tencent.mobileqq.intervideo.yiqikan.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.b
        public void callback(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
        }
    }

    public h(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f238500d = new HashMap<>();
        this.f238502f = new HashMap();
        this.f238504i = "mqqapi://miniapp/open?_atype=0&_mappid=1109894538&_mvid=&_path=pages%2Findex%2Findex&_vt=3&_sig=71cba9e2ab0f0e779a62ecf6705e0f5cf65a4f764d755e8fc07b537e655c70ad";
        this.f238505m = new a();
        this.f238501e = qQAppInterface;
        p(2, (com.tencent.mobileqq.intervideo.yiqikan.a) ((com.tencent.mobileqq.intervideo.groupvideo.h) qQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)));
        p(1, (com.tencent.mobileqq.intervideo.yiqikan.a) ((com.tencent.mobileqq.intervideo.now.dynamic.b) this.f238501e.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)));
        this.f238503h = ((IFactoryApi) QRoute.api(IFactoryApi.class)).getIVPluginReportInterface();
    }

    private int b(String str) {
        NewTogetherRoomMessageData newTogetherRoomMessageData = this.f238502f.get(str);
        if (newTogetherRoomMessageData != null) {
            return newTogetherRoomMessageData.f238446f;
        }
        return 0;
    }

    private long c(String str) {
        NewTogetherRoomMessageData newTogetherRoomMessageData = this.f238502f.get(str);
        if (newTogetherRoomMessageData != null) {
            return newTogetherRoomMessageData.f238447h;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NewTogetherRoomMessageData d(WatchTogetherSession watchTogetherSession) {
        if (watchTogetherSession == null) {
            return null;
        }
        NewTogetherRoomMessageData newTogetherRoomMessageData = new NewTogetherRoomMessageData();
        newTogetherRoomMessageData.f238446f = watchTogetherSession.L;
        newTogetherRoomMessageData.f238444d = watchTogetherSession.f437189f;
        newTogetherRoomMessageData.G = watchTogetherSession.Q;
        String str = watchTogetherSession.M;
        newTogetherRoomMessageData.F = str;
        newTogetherRoomMessageData.f238447h = watchTogetherSession.N;
        newTogetherRoomMessageData.E = watchTogetherSession.P;
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("roomid");
        String queryParameter2 = parse.getQueryParameter("room_show_number");
        String queryParameter3 = parse.getQueryParameter("fromid");
        String queryParameter4 = parse.getQueryParameter("room_group_code");
        if (!TextUtils.isEmpty(queryParameter)) {
            newTogetherRoomMessageData.f238447h = Integer.parseInt(queryParameter);
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            newTogetherRoomMessageData.f238448i = Integer.parseInt(queryParameter2);
        }
        newTogetherRoomMessageData.f238449m = queryParameter4;
        newTogetherRoomMessageData.H = queryParameter3;
        return newTogetherRoomMessageData;
    }

    private String e(Bundle bundle, String str) {
        TroopInfo k3;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  troopUin is null");
            return "";
        }
        if (bundle != null) {
            str2 = bundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
            QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  from extrainfo ownerUin=" + str2);
        } else {
            QQAppInterface qQAppInterface = this.f238501e;
            if (qQAppInterface != null && (k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str)) != null) {
                str2 = k3.troopowneruin;
            }
        }
        QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  extraInfo = " + bundle + ";troopUin=" + str + ";ownerUin=" + str2);
        return str2;
    }

    private void f(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        com.tencent.mobileqq.intervideo.yiqikan.c a16;
        Iterator<Integer> it = this.f238500d.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.intervideo.yiqikan.a aVar = this.f238500d.get(it.next());
            if (aVar != null && (a16 = aVar.a()) != null) {
                a16.a(newTogetherRoomMessageData);
            }
        }
    }

    private void g(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        q(newTogetherRoomMessageData.f238444d, newTogetherRoomMessageData);
        for (Integer num : this.f238500d.keySet()) {
            com.tencent.mobileqq.intervideo.yiqikan.a aVar = this.f238500d.get(num);
            if (aVar != null) {
                if (num.intValue() == newTogetherRoomMessageData.f238446f) {
                    QLog.i("WatchTogetherManager", 1, "preload roomtype =  " + newTogetherRoomMessageData.f238446f);
                    newTogetherRoomMessageData.H = "101";
                    aVar.d(newTogetherRoomMessageData);
                }
                com.tencent.mobileqq.intervideo.yiqikan.c a16 = aVar.a();
                if (a16 != null) {
                    a16.c(newTogetherRoomMessageData);
                }
            }
        }
    }

    private void h(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        com.tencent.mobileqq.intervideo.yiqikan.c a16;
        Iterator<Integer> it = this.f238500d.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.intervideo.yiqikan.a aVar = this.f238500d.get(it.next());
            if (aVar != null && (a16 = aVar.a()) != null) {
                a16.b(newTogetherRoomMessageData);
            }
        }
    }

    private void r(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        int i3 = newTogetherRoomMessageData.C;
        if (i3 != newTogetherRoomMessageData.f238446f && i3 != 0) {
            q(newTogetherRoomMessageData.f238444d, newTogetherRoomMessageData);
            Bundle bundle = new Bundle();
            bundle.putString("close_reason", "switch_room");
            bundle.putInt("old_room_type", newTogetherRoomMessageData.C);
            bundle.putInt("new_room_type", newTogetherRoomMessageData.f238446f);
            com.tencent.mobileqq.intervideo.yiqikan.a aVar = this.f238500d.get(Integer.valueOf(newTogetherRoomMessageData.C));
            if (aVar != null) {
                aVar.h(newTogetherRoomMessageData, bundle, new c());
                return;
            }
            return;
        }
        q(newTogetherRoomMessageData.f238444d, newTogetherRoomMessageData);
        h(newTogetherRoomMessageData);
    }

    public void i(WatchTogetherSession watchTogetherSession, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) watchTogetherSession, i3);
            return;
        }
        QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushActionType = " + i3);
        NewTogetherRoomMessageData newTogetherRoomMessageData = new NewTogetherRoomMessageData();
        newTogetherRoomMessageData.f238445e = watchTogetherSession.C;
        String str = watchTogetherSession.f437189f;
        newTogetherRoomMessageData.f238444d = str;
        newTogetherRoomMessageData.f238446f = watchTogetherSession.L;
        newTogetherRoomMessageData.f238447h = watchTogetherSession.N;
        newTogetherRoomMessageData.C = b(str);
        newTogetherRoomMessageData.F = watchTogetherSession.M;
        newTogetherRoomMessageData.E = watchTogetherSession.P;
        newTogetherRoomMessageData.G = watchTogetherSession.Q;
        newTogetherRoomMessageData.D = c(watchTogetherSession.f437189f);
        QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushContent = " + newTogetherRoomMessageData.toString());
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 5) {
                    r(newTogetherRoomMessageData);
                    return;
                }
                return;
            }
            f(newTogetherRoomMessageData);
            return;
        }
        g(newTogetherRoomMessageData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface] */
    public void j(String str, WatchTogetherSession watchTogetherSession, Bundle bundle) {
        boolean isTroopAdmin;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, watchTogetherSession, bundle);
            return;
        }
        if (watchTogetherSession == null) {
            return;
        }
        if (bundle != null) {
            boolean z17 = bundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER");
            isTroopAdmin = bundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN");
            z16 = z17;
        } else {
            QQAppInterface qQAppInterface = this.f238501e;
            boolean B = TroopUtils.B(qQAppInterface, watchTogetherSession.f437189f, qQAppInterface.getCurrentAccountUin());
            ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
            QQAppInterface qQAppInterface2 = this.f238501e;
            isTroopAdmin = iTroopUtilsApi.isTroopAdmin(qQAppInterface2, watchTogetherSession.f437189f, qQAppInterface2.getCurrentAccountUin());
            z16 = B;
        }
        String e16 = e(bundle, watchTogetherSession.f437189f);
        k(str, watchTogetherSession.f437189f, e16, z16, isTroopAdmin);
        IVPluginReportInterface iVPluginReportInterface = this.f238503h;
        if (iVPluginReportInterface != null) {
            iVPluginReportInterface.opDepartment("intervideo").opName("open_together_miniapp").opType(String.valueOf(watchTogetherSession.L)).d1(watchTogetherSession.f437189f).d2(e16).d3(str).opIn(z16).report();
        }
    }

    public void k(String str, String str2, String str3, boolean z16, boolean z17) {
        String str4;
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        String str5 = "0";
        if (TextUtils.isEmpty(str3)) {
            if (!z16) {
                str3 = "0";
            } else {
                str3 = this.f238501e.getCurrentUin();
            }
        }
        StringBuilder sb5 = new StringBuilder(this.f238504i);
        sb5.append("&group_uin=" + str2);
        sb5.append("&user_uin=" + this.f238501e.getCurrentAccountUin());
        sb5.append("&source_id=" + str);
        sb5.append("&owner_uin=" + str3);
        sb5.append("&isowner=");
        if (!z16) {
            str4 = "0";
        } else {
            str4 = "1";
        }
        sb5.append(str4);
        sb5.append("&isadmain=");
        if (z17) {
            str5 = "1";
        }
        sb5.append(str5);
        try {
            String str6 = AppSetting.f99551k;
            if (!TextUtils.isEmpty(str6)) {
                String[] split = str6.split("\\.");
                if (split.length > 0) {
                    int i16 = 0;
                    while (i3 < split.length) {
                        if (i3 == 0) {
                            parseInt = Integer.parseInt(split[i3]) * 100000;
                        } else if (i3 == 1) {
                            parseInt = Integer.parseInt(split[i3]) * 100;
                        } else if (i3 == 2) {
                            parseInt = Integer.parseInt(split[i3]);
                        } else {
                            i3++;
                        }
                        i16 += parseInt;
                        i3++;
                    }
                    i3 = i16;
                }
            }
            sb5.append("&versioncode=" + i3);
        } catch (Exception unused) {
            sb5.append("&versioncode=0");
        }
        QLog.i("WatchTogetherManager", 1, "openMiniAPP  scheme = " + sb5.toString());
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb5.toString()));
        intent.setFlags(268435456);
        BaseApplication.getContext().startActivity(intent);
    }

    public void l(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        com.tencent.mobileqq.intervideo.yiqikan.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newTogetherRoomMessageData);
            return;
        }
        if (newTogetherRoomMessageData == null) {
            ToastUtil.a().e("roomInfo is null!");
            return;
        }
        if (!TextUtils.isEmpty(newTogetherRoomMessageData.f238445e) && !TextUtils.isEmpty(newTogetherRoomMessageData.f238444d)) {
            int i3 = newTogetherRoomMessageData.f238446f;
            if (i3 != 2 && i3 != 1) {
                ToastUtil.a().e("invalid roomtype!");
                return;
            }
            Boolean valueOf = Boolean.valueOf(this.f238501e.getCurrentAccountUin().equals(newTogetherRoomMessageData.f238445e));
            IVPluginReportInterface iVPluginReportInterface = this.f238503h;
            if (iVPluginReportInterface != null) {
                iVPluginReportInterface.opDepartment("intervideo").opName("open_together_room_entry").opType(String.valueOf(newTogetherRoomMessageData.f238446f)).d1(newTogetherRoomMessageData.f238444d).d2(newTogetherRoomMessageData.f238445e).d3(newTogetherRoomMessageData.H).d4(String.valueOf(newTogetherRoomMessageData.f238447h)).opIn(valueOf.booleanValue() ? 1 : 0).report();
            }
            QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  roominfo = " + newTogetherRoomMessageData.toString());
            int i16 = newTogetherRoomMessageData.f238446f;
            if (i16 == 2) {
                aVar = this.f238500d.get(2);
            } else if (i16 == 1) {
                aVar = this.f238500d.get(1);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.j(newTogetherRoomMessageData, null, new b());
                return;
            }
            return;
        }
        ToastUtil.a().e("group info is null!");
    }

    public void m(WatchTogetherSession watchTogetherSession, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) watchTogetherSession, (Object) bundle);
        } else {
            if (watchTogetherSession == null) {
                ToastUtil.a().e("watchTogetherSession == null!");
                return;
            }
            NewTogetherRoomMessageData d16 = d(watchTogetherSession);
            d16.f238445e = e(bundle, d16.f238444d);
            l(d16);
        }
    }

    public void n(String str, int i3, WatchTogetherSession watchTogetherSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), watchTogetherSession);
            return;
        }
        com.tencent.mobileqq.intervideo.yiqikan.a aVar = this.f238500d.get(Integer.valueOf(i3));
        if (aVar == null) {
            QLog.i("WatchTogetherManager", 1, "preloadBizRoom  fail!  roomtype is not registered");
            return;
        }
        NewTogetherRoomMessageData d16 = d(watchTogetherSession);
        if (d16 == null) {
            d16 = new NewTogetherRoomMessageData();
            d16.H = str;
        }
        d16.f238445e = e(null, d16.f238444d);
        QLog.i("WatchTogetherManager", 1, "preloadRoom  roomtype = " + i3);
        aVar.d(d16);
    }

    public void o(String str, NewTogetherRoomMessageData newTogetherRoomMessageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) newTogetherRoomMessageData);
            return;
        }
        Boolean valueOf = Boolean.valueOf(this.f238501e.getCurrentAccountUin().equals(newTogetherRoomMessageData.f238445e));
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        QQAppInterface qQAppInterface = this.f238501e;
        k(str, newTogetherRoomMessageData.f238444d, newTogetherRoomMessageData.f238445e, valueOf.booleanValue(), Boolean.valueOf(iTroopUtilsApi.isTroopAdmin(qQAppInterface, newTogetherRoomMessageData.f238444d, qQAppInterface.getCurrentAccountUin())).booleanValue());
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.f238500d.clear();
        }
    }

    public void p(int i3, com.tencent.mobileqq.intervideo.yiqikan.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) aVar);
        } else {
            this.f238500d.put(Integer.valueOf(i3), aVar);
        }
    }

    public void q(String str, NewTogetherRoomMessageData newTogetherRoomMessageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) newTogetherRoomMessageData);
        } else {
            this.f238502f.put(str, newTogetherRoomMessageData);
        }
    }
}
