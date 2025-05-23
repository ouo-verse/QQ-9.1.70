package com.tencent.mobileqq.leba.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.leba.core.c;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceReqInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceRespInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig$PluginGroup;
import com.tencent.mobileqq.leba.pb.PluginConfig$PluginLayout;
import com.tencent.mobileqq.leba.utils.LebaMmkvUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    AppRuntime f240348a;

    /* renamed from: b, reason: collision with root package name */
    final byte[] f240349b;

    /* renamed from: c, reason: collision with root package name */
    List<LebaPluginInfo> f240350c;

    /* renamed from: d, reason: collision with root package name */
    public final List<ResourcePluginListener> f240351d;

    /* renamed from: e, reason: collision with root package name */
    boolean f240352e;

    /* renamed from: f, reason: collision with root package name */
    int f240353f;

    /* renamed from: g, reason: collision with root package name */
    boolean f240354g;

    /* renamed from: h, reason: collision with root package name */
    int f240355h;

    /* renamed from: i, reason: collision with root package name */
    public ILebaBasisApi f240356i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f240357j;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f240358a;

        /* renamed from: b, reason: collision with root package name */
        public final int f240359b;

        /* renamed from: c, reason: collision with root package name */
        public final int f240360c;

        a(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f240358a = z16;
            this.f240359b = i3;
            this.f240360c = i16;
        }
    }

    public LebaHelper(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        this.f240349b = new byte[0];
        this.f240352e = false;
        this.f240353f = 0;
        this.f240354g = false;
        this.f240355h = 0;
        this.f240357j = false;
        this.f240348a = appRuntime;
        this.f240350c = new ArrayList();
        this.f240351d = new ArrayList();
    }

    private void D() {
        int[] iArr = {1, 2};
        int[] iArr2 = {1, 2};
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i16 = 0; i16 < 2; i16++) {
                f.B(this.f240348a, 0, iArr[i3], iArr2[i3]);
            }
        }
    }

    private void E(Runnable runnable) {
        ThreadManagerV2.post(runnable, 8, null, true);
    }

    public static boolean c(int i3) {
        if (i3 != 0 && i3 != 2) {
            return false;
        }
        return true;
    }

    @NonNull
    public static a d() {
        int i3 = LebaPluginLogic.i();
        if (i3 != 4033 && i3 != 4034) {
            return new a(false, 0, 0);
        }
        return new a(true, com.tencent.mobileqq.leba.utils.c.a(i3), com.tencent.mobileqq.leba.utils.c.b(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        AppRuntime appRuntime = this.f240348a;
        if (appRuntime != null && appRuntime.isLogin()) {
            String str = AppConstants.Preferences.LEBAPLUGIN_CLEAR_LOCAL + this.f240348a.getAccount();
            if (LebaMmkvUtils.f240764a.c(this.f240348a, str, true)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Leba.Helper", 4, "clearLocalDBPlugin.local plugin.");
                }
                EntityManager createEntityManager = this.f240348a.getEntityManagerFactory().createEntityManager();
                try {
                    try {
                        List<LebaPluginInfo> all = LebaPluginInfo.getAll(createEntityManager);
                        if (all != null) {
                            for (int i3 = 0; i3 < all.size(); i3++) {
                                LebaPluginInfo lebaPluginInfo = all.get(i3);
                                if (lebaPluginInfo != null && lebaPluginInfo.cDataType == 1) {
                                    LebaPluginInfo.remove(createEntityManager, lebaPluginInfo.uiResId);
                                }
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    LebaMmkvUtils.f240764a.h(str, false);
                } finally {
                    createEntityManager.close();
                }
            }
        }
    }

    public static LebaPluginInfo i(PluginConfig$GetResourceRespInfo pluginConfig$GetResourceRespInfo) {
        long j3;
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        short s16;
        String str4;
        int i17;
        String str5;
        if (pluginConfig$GetResourceRespInfo == null) {
            return null;
        }
        LebaPluginInfo lebaPluginInfo = new LebaPluginInfo();
        if (pluginConfig$GetResourceRespInfo.res_id.has()) {
            j3 = pluginConfig$GetResourceRespInfo.res_id.get();
        } else {
            j3 = 0;
        }
        lebaPluginInfo.uiResId = j3;
        int i18 = 0;
        if (pluginConfig$GetResourceRespInfo.state.has()) {
            i3 = pluginConfig$GetResourceRespInfo.state.get();
        } else {
            i3 = 0;
        }
        lebaPluginInfo.state = i3;
        if (pluginConfig$GetResourceRespInfo.res_seq.has()) {
            i16 = pluginConfig$GetResourceRespInfo.res_seq.get();
        } else {
            i16 = 0;
        }
        lebaPluginInfo.sResSeq = i16;
        String str6 = "";
        if (!pluginConfig$GetResourceRespInfo.pkg_name.has()) {
            str = "";
        } else {
            str = pluginConfig$GetResourceRespInfo.pkg_name.get();
        }
        lebaPluginInfo.strPkgName = str;
        if (!pluginConfig$GetResourceRespInfo.res_name.has()) {
            str2 = "";
        } else {
            str2 = pluginConfig$GetResourceRespInfo.res_name.get();
        }
        lebaPluginInfo.strResName = str2;
        if (!pluginConfig$GetResourceRespInfo.icon_url.has()) {
            str3 = "";
        } else {
            str3 = pluginConfig$GetResourceRespInfo.icon_url.get();
        }
        lebaPluginInfo.strResURL = str3;
        if (pluginConfig$GetResourceRespInfo.sub_type.has()) {
            s16 = (short) pluginConfig$GetResourceRespInfo.sub_type.get();
        } else {
            s16 = -1;
        }
        lebaPluginInfo.sResSubType = s16;
        if (!pluginConfig$GetResourceRespInfo.jump_url.has()) {
            str4 = "";
        } else {
            str4 = pluginConfig$GetResourceRespInfo.jump_url.get();
        }
        lebaPluginInfo.strGotoUrl = str4;
        if (pluginConfig$GetResourceRespInfo.can_change_state.has()) {
            i17 = pluginConfig$GetResourceRespInfo.can_change_state.get();
        } else {
            i17 = 1;
        }
        lebaPluginInfo.cCanChangeState = i17;
        if (!pluginConfig$GetResourceRespInfo.res_conf.has()) {
            str5 = "";
        } else {
            str5 = pluginConfig$GetResourceRespInfo.res_conf.get();
        }
        lebaPluginInfo.resConf = str5;
        lebaPluginInfo.cDataType = (byte) 0;
        if (pluginConfig$GetResourceRespInfo.simple_mode.has()) {
            i18 = pluginConfig$GetResourceRespInfo.simple_mode.get();
        }
        lebaPluginInfo.showInSimpleMode = i18;
        if (pluginConfig$GetResourceRespInfo.grid_icon_url.has()) {
            str6 = pluginConfig$GetResourceRespInfo.grid_icon_url.get();
        }
        lebaPluginInfo.strGridIconUrl = str6;
        if (QLog.isColorLevel()) {
            QLog.i("ConfigManager", 2, "plugin config xml:" + pluginConfig$GetResourceRespInfo.res_conf.get());
        }
        return lebaPluginInfo;
    }

    private void q(boolean z16, boolean z17) {
        if (z16) {
            for (ResourcePluginListener resourcePluginListener : new ArrayList(this.f240351d)) {
                if (z17) {
                    ResourcePluginListener.a(resourcePluginListener, (byte) 3, 1);
                } else {
                    ResourcePluginListener.a(resourcePluginListener, (byte) 2, 1);
                }
            }
            return;
        }
        synchronized (this.f240351d) {
            for (int i3 = 0; i3 < this.f240351d.size(); i3++) {
                ResourcePluginListener.a(this.f240351d.get(i3), (byte) 1, 1);
            }
        }
    }

    public static boolean s() {
        return true;
    }

    private void w(@NonNull List<LebaPluginInfo> list, int i3, int i16) {
        List<com.tencent.mobileqq.leba.entity.d> j3;
        QLog.d("Leba.Helper", 2, "loadServerPlugins");
        boolean c16 = com.tencent.mobileqq.leba.utils.c.c(i3, i16);
        if (c16) {
            j3 = f.k(this.f240348a, i3, i16);
        } else {
            j3 = f.j(this.f240348a);
        }
        Map<Long, com.tencent.mobileqq.leba.entity.d> b16 = f.b(j3);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Leba.Helper", 2, "loadServerPlugins, groupMap is null");
                return;
            }
            return;
        }
        EntityManager createEntityManager = this.f240348a.getEntityManagerFactory().createEntityManager();
        List<LebaPluginInfo> all = LebaPluginInfo.getAll(createEntityManager);
        createEntityManager.close();
        if (all != null && all.size() > 0) {
            for (int size = all.size() - 1; size >= 0; size--) {
                LebaPluginInfo lebaPluginInfo = all.get(size);
                com.tencent.mobileqq.leba.entity.d dVar = b16.get(Long.valueOf(lebaPluginInfo.uiResId));
                if (dVar == null) {
                    QLog.i("Leba.Helper", 1, "loadServerPlugins remove: " + lebaPluginInfo);
                    all.remove(lebaPluginInfo);
                } else {
                    QLog.i("Leba.Helper", 4, "loadServerPlugins add: " + lebaPluginInfo);
                    lebaPluginInfo.groupId = dVar.f240472b + 1;
                    lebaPluginInfo.sPriority = f.i(dVar);
                }
            }
            if (c16) {
                JSONObject n3 = f.n(this.f240348a, i3, i16);
                for (LebaPluginInfo lebaPluginInfo2 : all) {
                    if (lebaPluginInfo2 != null) {
                        try {
                            lebaPluginInfo2.resConf = n3.getString(String.valueOf(lebaPluginInfo2.uiResId));
                        } catch (JSONException e16) {
                            QLog.e("Leba.Helper", 1, "loadServerPlugins exception! current resConf: " + lebaPluginInfo2.resConf, e16);
                        }
                    }
                }
            }
            list.addAll(all);
        }
    }

    private void z() {
        synchronized (this.f240351d) {
            this.f240352e = true;
            for (int i3 = 0; i3 < this.f240351d.size(); i3++) {
                ResourcePluginListener.a(this.f240351d.get(i3), (byte) -1, 1);
            }
        }
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else if (z16) {
            this.f240354g = false;
            x();
        } else {
            this.f240354g = true;
        }
    }

    public void B(boolean z16, int i3, List<com.tencent.mobileqq.leba.entity.d> list, List<LebaPluginInfo> list2, int i16, int i17, int i18, int i19) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), list, list2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        QLog.i("Leba.Helper", 1, "printPluginConfig onGetPluginConfig, isSucc= " + z16 + ",layoutSeq=" + i3 + ",layoutType=" + i16 + ",pluginType=" + i17 + ",mode=" + i18 + ",style=" + i19);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("printPluginConfig groupList= ");
        Object obj = "null";
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        QLog.i("Leba.Helper", 1, sb5.toString());
        if (list != null) {
            for (com.tencent.mobileqq.leba.entity.d dVar : list) {
                if (dVar != null) {
                    QLog.i("Leba.Helper", 1, "printPluginConfig groupInfo: " + dVar);
                } else {
                    QLog.i("Leba.Helper", 1, "printPluginConfig groupInfo is null");
                }
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("printPluginConfig resultInfos= ");
        if (list2 != null) {
            obj = Integer.valueOf(list2.size());
        }
        sb6.append(obj);
        QLog.i("Leba.Helper", 1, sb6.toString());
        if (list2 != null) {
            for (LebaPluginInfo lebaPluginInfo : list2) {
                if (lebaPluginInfo != null) {
                    QLog.i("Leba.Helper", 1, "printPluginConfig resultInfo: " + lebaPluginInfo);
                } else {
                    QLog.i("Leba.Helper", 1, "printPluginConfig resultInfo null");
                }
            }
        }
    }

    public void C(ResourcePluginListener resourcePluginListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) resourcePluginListener);
            return;
        }
        synchronized (this.f240351d) {
            this.f240351d.remove(resourcePluginListener);
        }
    }

    public void F(int i3, List<com.tencent.mobileqq.leba.entity.d> list, int i16, int i17, int i18, int i19) {
        int size;
        int l3;
        int size2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), list, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        if (com.tencent.mobileqq.leba.utils.c.c(i18, i19)) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("leba_save_group_info_fix", true);
            AppRuntime appRuntime = this.f240348a;
            if (isSwitchOn) {
                l3 = f.m(appRuntime, i18, i19);
            } else {
                l3 = f.l(appRuntime);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveLebaGroupInfo, localSeq=");
            sb5.append(l3);
            sb5.append(", seq=");
            sb5.append(i3);
            sb5.append(" , groupListSize=");
            if (list == null) {
                size2 = -1;
            } else {
                size2 = list.size();
            }
            sb5.append(size2);
            sb5.append(", layoutType=");
            sb5.append(i16);
            sb5.append(", mode=");
            sb5.append(i18);
            sb5.append(", style=");
            sb5.append(i19);
            sb5.append(", fixSwitch= ");
            sb5.append(isSwitchOn);
            QLog.i("Leba.Helper", 1, sb5.toString());
            if (i3 > 0 && i3 != l3 && list != null) {
                f.B(this.f240348a, i3, i18, i19);
                f.z(this.f240348a, list, i18, i19);
                f.C(this.f240348a, i16, i17);
                return;
            }
            return;
        }
        int l16 = f.l(this.f240348a);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("saveLebaGroupInfo, localSeq=");
        sb6.append(l16);
        sb6.append(", seq=");
        sb6.append(i3);
        sb6.append(" , groupListSize=");
        if (list == null) {
            size = -1;
        } else {
            size = list.size();
        }
        sb6.append(size);
        sb6.append(", layoutType=");
        sb6.append(i16);
        sb6.append(", mode=");
        sb6.append(i18);
        sb6.append(", style=");
        sb6.append(i19);
        QLog.i("Leba.Helper", 1, sb6.toString());
        if (i3 > 0 && i3 != l16 && list != null) {
            f.A(this.f240348a, i3);
            f.y(this.f240348a, list);
            f.C(this.f240348a, i16, i17);
        }
    }

    public void G(JSONObject jSONObject, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, jSONObject, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            f.D(this.f240348a, jSONObject, i3, i16);
        }
    }

    public void b(ResourcePluginListener resourcePluginListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) resourcePluginListener);
            return;
        }
        synchronized (this.f240351d) {
            if (!this.f240351d.contains(resourcePluginListener)) {
                this.f240351d.add(resourcePluginListener);
            }
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (r(this.f240348a)) {
            QLog.i("Leba.Helper", 1, "checkModelAndRefresh getAllPluginList");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.core.LebaHelper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.leba.core.a.b(LebaHelper.this.f240348a);
                    com.tencent.mobileqq.leba.core.a.a(LebaHelper.this.f240348a);
                    LebaHelper.this.t();
                    LebaHelper.this.x();
                }
            }, 160, null, true);
        }
    }

    public void f() {
        boolean z16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f240352e && (i16 = this.f240353f) < 3) {
            this.f240352e = false;
            this.f240353f = i16 + 1;
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f240354g && (i3 = this.f240355h) < 3) {
            this.f240354g = false;
            this.f240355h = i3 + 1;
            z16 = true;
        }
        if (z16) {
            QLog.i("Leba.Helper", 1, "checkModelAndRefresh getAllPluginList");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.core.LebaHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.leba.core.a.b(LebaHelper.this.f240348a);
                        com.tencent.mobileqq.leba.core.a.a(LebaHelper.this.f240348a);
                    }
                }
            }, 160, null, true);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        synchronized (this.f240349b) {
            this.f240350c.clear();
        }
    }

    public List<LebaPluginInfo> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f240350c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0076, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PluginConfig$GetResourceReq k() {
        boolean z16;
        Object valueOf;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PluginConfig$GetResourceReq) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        QLog.i("Leba.Helper", 2, "getLebaPluginInfoReq");
        int i16 = 0;
        if (f.r(this.f240348a)) {
            QLog.i("Leba.Helper", 1, "getLebaPluginInfoReq \uff0cisAppUpgrade");
            f.A(this.f240348a, 0);
            D();
            f.G(this.f240348a);
        }
        boolean r16 = r(this.f240348a);
        ILebaBasisApi iLebaBasisApi = this.f240356i;
        if (iLebaBasisApi != null && iLebaBasisApi.isLocaleUpdatedByUser()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || r16) {
            QLog.i("Leba.Helper", 1, "getLebaPluginInfoReq \uff0cisLocaleUpdated");
            f.A(this.f240348a, 0);
            EntityManager createEntityManager = this.f240348a.getEntityManagerFactory().createEntityManager();
            try {
                createEntityManager.drop(LebaPluginInfo.class);
            } catch (Throwable th5) {
                try {
                    QLog.e("Leba.Helper", 1, "getLebaPluginInfoReq exception", th5);
                } catch (Throwable th6) {
                    if (createEntityManager != null) {
                        createEntityManager.close();
                    }
                    throw th6;
                }
            }
            createEntityManager.close();
        }
        int l3 = f.l(this.f240348a);
        List<LebaPluginInfo> all = LebaPluginInfo.getAll(this.f240348a.getEntityManagerFactory().createEntityManager());
        ArrayList arrayList = new ArrayList();
        if (all != null) {
            for (int i17 = 0; i17 < all.size(); i17++) {
                LebaPluginInfo lebaPluginInfo = all.get(i17);
                if (lebaPluginInfo != null && lebaPluginInfo.cDataType == 0) {
                    LebaPluginInfo lebaPluginInfo2 = new LebaPluginInfo();
                    if (l3 <= 0) {
                        i3 = 0;
                    } else {
                        i3 = lebaPluginInfo.sResSeq;
                    }
                    lebaPluginInfo2.sResSeq = i3;
                    lebaPluginInfo2.uiResId = lebaPluginInfo.uiResId;
                    arrayList.add(lebaPluginInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d("Leba.Helper", 2, "" + lebaPluginInfo);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            f.A(this.f240348a, 0);
        } else {
            i16 = l3;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getLebaPluginInfoReq, layoutSeq=");
            sb5.append(i16);
            sb5.append(", lebaPluginInfos.size");
            sb5.append(arrayList.size());
            sb5.append(", tempLebaList.size()=");
            if (all == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(all.size());
            }
            sb5.append(valueOf);
            QLog.d("Leba.Helper", 2, sb5.toString());
        }
        return m(i16, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
    
        if (r8 == null) goto L33;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PluginConfig$GetResourceReq l(int i3, int i16) {
        boolean z16;
        int i17;
        Object obj;
        Map<Long, com.tencent.mobileqq.leba.entity.d> map;
        JSONObject jSONObject;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PluginConfig$GetResourceReq) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        QLog.i("Leba.Helper", 2, "getLebaPluginInfoReq");
        if (!com.tencent.mobileqq.leba.utils.c.c(i3, i16)) {
            return null;
        }
        if (f.r(this.f240348a)) {
            QLog.i("Leba.Helper", 1, "getLebaPluginInfoReq \uff0cisAppUpgrade");
            D();
            f.G(this.f240348a);
        }
        ILebaBasisApi iLebaBasisApi = this.f240356i;
        if (iLebaBasisApi != null && iLebaBasisApi.isLocaleUpdatedByUser()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("Leba.Helper", 1, "getLebaPluginInfoReq \uff0cisLocaleUpdated");
            f.A(this.f240348a, 0);
            D();
            EntityManager createEntityManager = this.f240348a.getEntityManagerFactory().createEntityManager();
            try {
                createEntityManager.drop(LebaPluginInfo.class);
            } catch (Throwable th5) {
                try {
                    QLog.e("Leba.Helper", 1, "getLebaPluginInfoReq exception", th5);
                } catch (Throwable th6) {
                    if (createEntityManager != null) {
                        createEntityManager.close();
                    }
                    throw th6;
                }
            }
            createEntityManager.close();
        }
        int m3 = f.m(this.f240348a, i3, i16);
        List<LebaPluginInfo> all = LebaPluginInfo.getAll(this.f240348a.getEntityManagerFactory().createEntityManager());
        ArrayList arrayList = new ArrayList();
        Map<Long, com.tencent.mobileqq.leba.entity.d> b16 = f.b(f.k(this.f240348a, i3, i16));
        JSONObject n3 = f.n(this.f240348a, i3, i16);
        if (all != null && b16 != null) {
            int i26 = 0;
            while (i26 < all.size()) {
                LebaPluginInfo lebaPluginInfo = all.get(i26);
                if (lebaPluginInfo != null && lebaPluginInfo.cDataType == 0 && b16.containsKey(Long.valueOf(lebaPluginInfo.uiResId))) {
                    LebaPluginInfo lebaPluginInfo2 = new LebaPluginInfo();
                    if (m3 <= 0) {
                        i18 = i19;
                    } else {
                        i18 = lebaPluginInfo.sResSeq;
                    }
                    lebaPluginInfo2.sResSeq = i18;
                    lebaPluginInfo2.uiResId = lebaPluginInfo.uiResId;
                    if (!n3.has(String.valueOf(lebaPluginInfo.uiResId))) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getLebaPluginInfoReq plugin lose resConf. resId= ");
                        map = b16;
                        jSONObject = n3;
                        sb5.append(lebaPluginInfo.uiResId);
                        QLog.i("Leba.Helper", 2, sb5.toString());
                        lebaPluginInfo2.sResSeq = 0;
                    } else {
                        map = b16;
                        jSONObject = n3;
                    }
                    arrayList.add(lebaPluginInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d("Leba.Helper", 2, "" + lebaPluginInfo);
                    }
                } else {
                    map = b16;
                    jSONObject = n3;
                }
                i26++;
                b16 = map;
                n3 = jSONObject;
                i19 = 0;
            }
        }
        if (arrayList.isEmpty()) {
            f.B(this.f240348a, 0, i3, i16);
            i17 = 0;
        } else {
            i17 = m3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getLebaPluginInfoReq, mode=");
            sb6.append(i3);
            sb6.append(", style=");
            sb6.append(i16);
            sb6.append(", layoutSeq=");
            sb6.append(i17);
            sb6.append(", lebaPluginInfos.size");
            sb6.append(arrayList.size());
            sb6.append(", tempLebaList.size()=");
            if (all != null) {
                obj = Integer.valueOf(all.size());
            } else {
                obj = "null";
            }
            sb6.append(obj);
            QLog.d("Leba.Helper", 2, sb6.toString());
        }
        PluginConfig$GetResourceReq m16 = m(i17, arrayList);
        m16.mode.set(i3);
        m16.style.set(i16);
        QLog.i("Leba.Helper", 1, "getLebaPluginListReq mode = " + i3 + ", style = " + i16);
        return m16;
    }

    public PluginConfig$GetResourceReq m(int i3, List<LebaPluginInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PluginConfig$GetResourceReq) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (LebaPluginInfo lebaPluginInfo : list) {
                if (lebaPluginInfo != null) {
                    PluginConfig$GetResourceReqInfo pluginConfig$GetResourceReqInfo = new PluginConfig$GetResourceReqInfo();
                    pluginConfig$GetResourceReqInfo.res_id.set((int) lebaPluginInfo.uiResId);
                    pluginConfig$GetResourceReqInfo.res_seq.set(lebaPluginInfo.sResSeq);
                    arrayList.add(pluginConfig$GetResourceReqInfo);
                }
            }
        }
        PluginConfig$GetResourceReq pluginConfig$GetResourceReq = new PluginConfig$GetResourceReq();
        pluginConfig$GetResourceReq.plugin_layout_seq.set(i3);
        pluginConfig$GetResourceReq.reqinfo_list.set(arrayList);
        if (d().f240358a) {
            pluginConfig$GetResourceReq.plugin_type.set(4042);
        } else {
            int i16 = LebaPluginLogic.i();
            QLog.i("Leba.Helper", 1, "getLebaPluginListReq pluginType = " + i16);
            pluginConfig$GetResourceReq.plugin_type.set(i16);
        }
        return pluginConfig$GetResourceReq;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x016a  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(boolean z16, PluginConfig$GetResourceResp pluginConfig$GetResourceResp, int i3, int i16) {
        int i17;
        boolean z17;
        List<LebaPluginInfo> list;
        List<com.tencent.mobileqq.leba.entity.d> list2;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        PluginConfig$PluginLayout pluginConfig$PluginLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i36 = 1;
        int i37 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), pluginConfig$GetResourceResp, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        List<LebaPluginInfo> emptyList = Collections.emptyList();
        List<com.tencent.mobileqq.leba.entity.d> emptyList2 = Collections.emptyList();
        int i38 = -1;
        if (z16) {
            if (pluginConfig$GetResourceResp != null) {
                try {
                    i28 = pluginConfig$GetResourceResp.plugin_type.get();
                    try {
                        List<PluginConfig$PluginGroup> list3 = null;
                        if (pluginConfig$GetResourceResp.plugin_layout.has()) {
                            pluginConfig$PluginLayout = pluginConfig$GetResourceResp.plugin_layout.get();
                        } else {
                            pluginConfig$PluginLayout = null;
                        }
                        if (pluginConfig$PluginLayout != null) {
                            if (pluginConfig$PluginLayout.layout_type.has()) {
                                i29 = pluginConfig$PluginLayout.layout_type.get();
                            } else {
                                i29 = -1;
                            }
                            try {
                                if (pluginConfig$PluginLayout.plugin_layout_seq.has()) {
                                    i38 = pluginConfig$PluginLayout.plugin_layout_seq.get();
                                }
                                if (pluginConfig$PluginLayout.group_list.has()) {
                                    list3 = pluginConfig$PluginLayout.group_list.get();
                                }
                                if (list3 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    int i39 = 0;
                                    int i46 = 0;
                                    while (i39 < list3.size()) {
                                        try {
                                            PluginConfig$PluginGroup pluginConfig$PluginGroup = list3.get(i39);
                                            if (pluginConfig$PluginGroup.has() && pluginConfig$PluginGroup.res_id.has()) {
                                                List<Integer> list4 = pluginConfig$PluginGroup.res_id.get();
                                                for (int i47 = i37; i47 < list4.size(); i47++) {
                                                    com.tencent.mobileqq.leba.entity.d dVar = new com.tencent.mobileqq.leba.entity.d();
                                                    try {
                                                        dVar.f240471a = list4.get(i47).intValue();
                                                        dVar.f240472b = i39;
                                                        i46++;
                                                        dVar.f240473c = i46;
                                                        arrayList.add(dVar);
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                        emptyList2 = arrayList;
                                                        i17 = 1;
                                                        QLog.i("Leba.Helper", i17, "handleGetLebaPluginList", e);
                                                        list = emptyList;
                                                        i18 = i29;
                                                        z17 = false;
                                                        i19 = i28;
                                                        list2 = emptyList2;
                                                        Object[] objArr = new Object[6];
                                                        objArr[0] = "handleGetLebaPluginList isSuc:";
                                                        objArr[i17] = Boolean.valueOf(z17);
                                                        objArr[2] = ", resultInfos.size=";
                                                        if (list == null) {
                                                        }
                                                        objArr[3] = Integer.valueOf(i26);
                                                        objArr[4] = ", groupList.size=";
                                                        if (list2 == null) {
                                                        }
                                                        objArr[5] = Integer.valueOf(i27);
                                                        QLog.d("Leba.Helper", 1, objArr);
                                                        y(z17, i38, list2, list, i18, i19, i3, i16);
                                                    }
                                                }
                                            }
                                            i39++;
                                            i36 = 1;
                                            i37 = 0;
                                        } catch (Exception e17) {
                                            e = e17;
                                            i17 = i36;
                                            emptyList2 = arrayList;
                                            QLog.i("Leba.Helper", i17, "handleGetLebaPluginList", e);
                                            list = emptyList;
                                            i18 = i29;
                                            z17 = false;
                                            i19 = i28;
                                            list2 = emptyList2;
                                            Object[] objArr2 = new Object[6];
                                            objArr2[0] = "handleGetLebaPluginList isSuc:";
                                            objArr2[i17] = Boolean.valueOf(z17);
                                            objArr2[2] = ", resultInfos.size=";
                                            if (list == null) {
                                            }
                                            objArr2[3] = Integer.valueOf(i26);
                                            objArr2[4] = ", groupList.size=";
                                            if (list2 == null) {
                                            }
                                            objArr2[5] = Integer.valueOf(i27);
                                            QLog.d("Leba.Helper", 1, objArr2);
                                            y(z17, i38, list2, list, i18, i19, i3, i16);
                                        }
                                    }
                                    emptyList2 = arrayList;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                i17 = 1;
                            }
                        } else {
                            i29 = -1;
                        }
                        try {
                            List<PluginConfig$GetResourceRespInfo> list5 = pluginConfig$GetResourceResp.respinfo_list.get();
                            ArrayList arrayList2 = new ArrayList();
                            if (list5 != null) {
                                try {
                                    Iterator<PluginConfig$GetResourceRespInfo> it = list5.iterator();
                                    while (it.hasNext()) {
                                        LebaPluginInfo i48 = i(it.next());
                                        if (i48 != null) {
                                            arrayList2.add(i48);
                                        }
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    emptyList = arrayList2;
                                    i17 = 1;
                                    QLog.i("Leba.Helper", i17, "handleGetLebaPluginList", e);
                                    list = emptyList;
                                    i18 = i29;
                                    z17 = false;
                                    i19 = i28;
                                    list2 = emptyList2;
                                    Object[] objArr22 = new Object[6];
                                    objArr22[0] = "handleGetLebaPluginList isSuc:";
                                    objArr22[i17] = Boolean.valueOf(z17);
                                    objArr22[2] = ", resultInfos.size=";
                                    if (list == null) {
                                    }
                                    objArr22[3] = Integer.valueOf(i26);
                                    objArr22[4] = ", groupList.size=";
                                    if (list2 == null) {
                                    }
                                    objArr22[5] = Integer.valueOf(i27);
                                    QLog.d("Leba.Helper", 1, objArr22);
                                    y(z17, i38, list2, list, i18, i19, i3, i16);
                                }
                            }
                            z17 = z16;
                            emptyList = arrayList2;
                            i17 = 1;
                        } catch (Exception e26) {
                            e = e26;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        i17 = 1;
                        i29 = -1;
                    }
                } catch (Exception e28) {
                    e = e28;
                    i17 = 1;
                    i28 = -1;
                    i29 = -1;
                    QLog.i("Leba.Helper", i17, "handleGetLebaPluginList", e);
                    list = emptyList;
                    i18 = i29;
                    z17 = false;
                    i19 = i28;
                    list2 = emptyList2;
                    Object[] objArr222 = new Object[6];
                    objArr222[0] = "handleGetLebaPluginList isSuc:";
                    objArr222[i17] = Boolean.valueOf(z17);
                    objArr222[2] = ", resultInfos.size=";
                    if (list == null) {
                    }
                    objArr222[3] = Integer.valueOf(i26);
                    objArr222[4] = ", groupList.size=";
                    if (list2 == null) {
                    }
                    objArr222[5] = Integer.valueOf(i27);
                    QLog.d("Leba.Helper", 1, objArr222);
                    y(z17, i38, list2, list, i18, i19, i3, i16);
                }
            } else {
                i17 = 1;
                try {
                    QLog.i("Leba.Helper", 1, "handleGetLebaPluginList respInfo is null");
                    i28 = -1;
                    i29 = -1;
                    z17 = false;
                } catch (Exception e29) {
                    e = e29;
                    i28 = -1;
                    i29 = -1;
                    QLog.i("Leba.Helper", i17, "handleGetLebaPluginList", e);
                    list = emptyList;
                    i18 = i29;
                    z17 = false;
                    i19 = i28;
                    list2 = emptyList2;
                    Object[] objArr2222 = new Object[6];
                    objArr2222[0] = "handleGetLebaPluginList isSuc:";
                    objArr2222[i17] = Boolean.valueOf(z17);
                    objArr2222[2] = ", resultInfos.size=";
                    if (list == null) {
                    }
                    objArr2222[3] = Integer.valueOf(i26);
                    objArr2222[4] = ", groupList.size=";
                    if (list2 == null) {
                    }
                    objArr2222[5] = Integer.valueOf(i27);
                    QLog.d("Leba.Helper", 1, objArr2222);
                    y(z17, i38, list2, list, i18, i19, i3, i16);
                }
            }
            list = emptyList;
            i18 = i29;
            i19 = i28;
            list2 = emptyList2;
        } else {
            i17 = 1;
            z17 = z16;
            list = emptyList;
            list2 = emptyList2;
            i18 = -1;
            i19 = -1;
        }
        Object[] objArr22222 = new Object[6];
        objArr22222[0] = "handleGetLebaPluginList isSuc:";
        objArr22222[i17] = Boolean.valueOf(z17);
        objArr22222[2] = ", resultInfos.size=";
        if (list == null) {
            i26 = list.size();
        } else {
            i26 = 0;
        }
        objArr22222[3] = Integer.valueOf(i26);
        objArr22222[4] = ", groupList.size=";
        if (list2 == null) {
            i27 = list2.size();
        } else {
            i27 = 0;
        }
        objArr22222[5] = Integer.valueOf(i27);
        QLog.d("Leba.Helper", 1, objArr22222);
        y(z17, i38, list2, list, i18, i19, i3, i16);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Leba.Helper", 2, "LebaHelper  init");
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.leba.core.LebaHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LebaHelper.this.h();
                    if (LebaHelper.s()) {
                        boolean b16 = com.tencent.mobileqq.leba.feed.d.b();
                        QLog.i("Leba.Helper", 1, "showQzoneFrameInit= " + b16);
                        if (b16) {
                            LebaHelper.this.t();
                        }
                    } else {
                        LebaHelper.this.t();
                    }
                    LebaHelper.this.x();
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f240356i = (ILebaBasisApi) QRoute.api(ILebaBasisApi.class);
        }
    }

    public boolean r(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime)).booleanValue();
        }
        int i3 = LebaPluginLogic.i();
        if (d().f240358a) {
            if (f.o(appRuntime) != 4042) {
                return true;
            }
            return false;
        }
        if (i3 != f.o(appRuntime)) {
            return true;
        }
        return false;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        a d16 = d();
        if (d16.f240358a) {
            u(d16.f240359b, d16.f240360c);
        } else {
            u(0, 0);
        }
    }

    public void u(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AppRuntime appRuntime = this.f240348a;
        if (appRuntime != null && appRuntime.isLogin()) {
            ArrayList arrayList = new ArrayList();
            try {
                v(arrayList);
            } catch (Exception e16) {
                QLog.e("Leba.Helper", 1, "loadAllPlugins ", e16);
            }
            w(arrayList, i3, i16);
            synchronized (this.f240349b) {
                this.f240350c.clear();
                this.f240350c.addAll(arrayList);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Leba.Helper", 2, "loadAllPlugins\uff0csize=" + this.f240350c.size());
            }
            this.f240357j = true;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Leba.Helper", 2, "error happens: loadAllPlugins while app is null || app is not login");
        }
    }

    protected void v(@NonNull List<LebaPluginInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
            return;
        }
        LebaPluginInfo lebaPluginInfo = new LebaPluginInfo();
        lebaPluginInfo.strPkgName = "qzone_feedlist";
        lebaPluginInfo.strResName = HardCodeUtil.qqStr(R.string.f162191zr);
        lebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
        lebaPluginInfo.sResSubType = (short) 2;
        lebaPluginInfo.cCanChangeState = 0;
        lebaPluginInfo.cDataType = (byte) 1;
        lebaPluginInfo.uiResId = 0L;
        lebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", this.f240348a.getAccount(), "tab_qzone");
        lebaPluginInfo.showInSimpleMode = 1;
        list.add(lebaPluginInfo);
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Iterator it = new ArrayList(this.f240351d).iterator();
        while (it.hasNext()) {
            ResourcePluginListener.a((ResourcePluginListener) it.next(), (byte) 5, 1);
        }
    }

    public void y(boolean z16, int i3, List<com.tencent.mobileqq.leba.entity.d> list, List<LebaPluginInfo> list2, int i16, int i17, int i18, int i19) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), list, list2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        B(z16, i3, list, list2, i16, i17, i18, i19);
        if (z16) {
            this.f240352e = false;
            a d16 = d();
            if (d16.f240358a) {
                jSONObject = f.n(this.f240348a, i18, i19);
            } else {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            c.a b16 = c.b(list2);
            QLog.e("Leba.Helper", 1, "onGetPluginConfig saveDb end. saveDbSuc=" + b16 + ", isAddNew=" + b16.a() + ", isChange= " + b16.b());
            if (b16.c()) {
                try {
                    for (LebaPluginInfo lebaPluginInfo : list2) {
                        jSONObject2.put(String.valueOf(lebaPluginInfo.uiResId), lebaPluginInfo.resConf);
                    }
                } catch (JSONException e16) {
                    QLog.e("Leba.Helper", 1, "onGetPluginConfig jsonExp: ", e16);
                }
                F(i3, list, i16, i17, i18, i19);
                if (d16.f240358a) {
                    G(jSONObject2, i18, i19);
                }
            }
            if (d16.f240358a) {
                QLog.e("Leba.Helper", 1, "onGetPluginConfig mode check(" + i18 + "," + d16.f240359b + ") style check(" + i19 + "," + d16.f240360c + ")");
                if (i18 == d16.f240359b && i19 == d16.f240360c) {
                    u(i18, i19);
                    x();
                }
            } else {
                u(i18, i19);
                x();
            }
            if (b16.a()) {
                ((IRedTouchServer) this.f240348a.getRuntimeService(IRedTouchServer.class, "")).forceSendReq(1);
            }
            q(b16.b(), b16.a());
            return;
        }
        z();
    }
}
