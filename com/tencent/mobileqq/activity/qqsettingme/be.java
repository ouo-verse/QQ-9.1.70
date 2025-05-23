package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TokenResUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class be extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private static final String[] f184854n;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.p> f184855h;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<Boolean> f184856i;

    /* renamed from: j, reason: collision with root package name */
    private IWeatherRuntimeService f184857j;

    /* renamed from: k, reason: collision with root package name */
    private p43.a f184858k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f184859l;

    /* renamed from: m, reason: collision with root package name */
    private QQPermission f184860m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184861d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184861d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) be.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                return;
            }
            if (bool.booleanValue()) {
                this.f184861d.m();
                QQSettingMeViewModel k3 = this.f184861d.k();
                if (k3 != null) {
                    k3.T.postValue(bool);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.p> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184863d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184863d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) be.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar);
                return;
            }
            if (((com.tencent.mobileqq.processor.c) be.this).f259745f) {
                this.f184863d.T(pVar);
            } else {
                this.f184863d.S(pVar);
            }
            QQSettingMeViewModel k3 = this.f184863d.k();
            if (k3 != null) {
                k3.S.postValue(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f184865a;

        c(QBaseActivity qBaseActivity) {
            this.f184865a = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) be.this, (Object) qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                be.this.B();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            if (com.tencent.mobileqq.weather.util.i.a(this.f184865a, QQPermissionConstants.Business.SCENE.DRAWER_WEATHER)) {
                be.this.B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        d(String str, boolean z16) {
            super(str, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, be.this, str, Boolean.valueOf(z16));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "onLocationFinish errCode:" + i3 + ",info:" + sosoLbsInfo);
            }
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                int i17 = (int) (sosoLocation.mLat02 * 1000000.0d);
                int i18 = (int) (sosoLocation.mLon02 * 1000000.0d);
                try {
                    i16 = Integer.parseInt(sosoLocation.cityCode);
                } catch (Throwable th5) {
                    th = th5;
                    i16 = 0;
                }
                try {
                    QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeInt("cur_adcode", i16);
                } catch (Throwable th6) {
                    th = th6;
                    if (QLog.isColorLevel()) {
                        QLog.e("QQSettingMeBaseProcessor", 2, th, new Object[0]);
                    }
                    if (QLog.isColorLevel()) {
                    }
                    ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).translate((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), i17, i18, i16);
                    ee2.d.b("weather");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "onLocationFinish latitude:" + i17 + ",longtitude:" + i18 + ",adcode:" + i16);
                }
                ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).translate((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), i17, i18, i16);
                ee2.d.b("weather");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e implements p43.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.p>> f184868a;

        public e(MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.p> mutableLiveData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mutableLiveData);
            } else {
                this.f184868a = null;
                this.f184868a = new WeakReference<>(mutableLiveData);
            }
        }

        @Override // p43.a
        public void a(int i3, boolean z16, Bundle bundle) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                com.tencent.mobileqq.activity.qqsettingme.bean.p pVar = new com.tencent.mobileqq.activity.qqsettingme.bean.p();
                int i16 = bundle.getInt("show_flag");
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "onWeatherUpdateResult show_flag:" + i16);
                }
                if (i16 != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                pVar.f184944e = z17;
                if (i16 == 1) {
                    pVar.f184940a = bundle.getString("KEY_TEMPER");
                    pVar.f184943d = bundle.getString("o_wea_code");
                    pVar.f184941b = bundle.getString("area_info");
                    pVar.f184942c = bundle.getInt("adcode");
                    pVar.f184946g = bundle.getInt(be.t(), 1);
                    pVar.f184947h = bundle.getString(be.s(), "- -");
                    pVar.f184948i = bundle.getString("drawer_down_text");
                    if (QLog.isColorLevel()) {
                        QLog.d("QQSettingMeBaseProcessor", 2, "onWeatherUpdateResult temp:", pVar.f184940a, " o_wea_code:", pVar.f184943d, " area_name:", pVar.f184941b, "adcode:", Integer.valueOf(pVar.f184942c));
                    }
                    int i17 = bundle.getInt("drawer_warning_count", 0);
                    ArrayList arrayList = new ArrayList();
                    for (int i18 = 0; i18 < i17; i18++) {
                        bo boVar = new bo();
                        boVar.f184978a = bundle.getString("drawer_warning_icon_" + i18, "");
                        boVar.f184979b = bundle.getString("drawer_warning_name_" + i18, "");
                        boVar.f184980c = bundle.getString("drawer_warning_color_" + i18, "");
                        boVar.f184981d = bundle.getString("drawer_warning_level_" + i18, "");
                        arrayList.add(boVar);
                    }
                    pVar.f184949j = arrayList;
                    MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.p> mutableLiveData = this.f184868a.get();
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(pVar);
                    } else {
                        QLog.d("QQSettingMeBaseProcessor", 1, "onWeatherUpdateResult weatherBean:null");
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f184854n = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        }
    }

    public be() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184855h = new MutableLiveData<>();
            this.f184856i = new MutableLiveData<>();
        }
    }

    private void A() {
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (this.f184860m == null) {
            this.f184860m = QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEATHER, QQPermissionConstants.Business.SCENE.DRAWER_WEATHER));
        }
        this.f184860m.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new c(qBaseActivity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (!x()) {
            return;
        }
        ee2.d.a("weather");
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new d("qq_weather", false));
    }

    private long r() {
        return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong("drawer_last_success_time", 0L);
    }

    public static String s() {
        String str;
        if (TokenResUtils.useTokenIcon()) {
            str = "drawer_up_experiment_text";
        } else {
            str = "drawer_up_text";
        }
        if (QQTheme.isNowSimpleUI()) {
            return "drawer_up_simple_text";
        }
        return str;
    }

    public static String t() {
        String str;
        if (TokenResUtils.useTokenIcon()) {
            str = "drawer_up_experiment_type";
        } else {
            str = "drawer_up_type";
        }
        if (QQTheme.isNowSimpleUI()) {
            return "drawer_up_simple_type";
        }
        return str;
    }

    private com.tencent.mobileqq.activity.qqsettingme.bean.p u() {
        String str;
        String str2;
        com.tencent.mobileqq.activity.qqsettingme.bean.p pVar = new com.tencent.mobileqq.activity.qqsettingme.bean.p();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        pVar.f184940a = from.decodeString("drawer_cur_temp", "- -") + "\u00b0";
        String str3 = "\u5f53\u5730\u5929\u6c14";
        pVar.f184941b = from.decodeString("drawer_cur_city", "\u5f53\u5730\u5929\u6c14");
        pVar.f184942c = from.decodeInt("drawer_cur_adcode", 0);
        pVar.f184943d = from.decodeString("drawer_cur_code", null);
        pVar.f184944e = from.decodeBool("drawer_show_flag", true);
        pVar.f184946g = from.decodeInt(t(), 1);
        pVar.f184947h = from.decodeString(s(), "");
        pVar.f184948i = from.decodeString("drawer_down_text", "\u5f53\u5730\u5929\u6c14");
        if (pVar.f184947h.length() > 0) {
            str = pVar.f184947h;
        } else {
            str = pVar.f184940a;
        }
        pVar.f184947h = str;
        pVar.f184945f = false;
        String[] split = pVar.f184941b.split("-");
        if (split != null && split.length != 0) {
            if (pVar.f184948i.length() == 0) {
                if (split.length == 2) {
                    str2 = split[1];
                } else {
                    str2 = split[0];
                }
            } else {
                str2 = pVar.f184948i;
            }
            pVar.f184948i = str2;
        } else {
            if (pVar.f184948i.length() != 0) {
                str3 = pVar.f184948i;
            }
            pVar.f184948i = str3;
        }
        int decodeInt = from.decodeInt("drawer_warning_count", 0);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < decodeInt; i3++) {
            bo boVar = new bo();
            boVar.f184978a = from.decodeString("drawer_warning_icon_" + i3, "");
            boVar.f184979b = from.decodeString("drawer_warning_name_" + i3, "");
            boVar.f184980c = from.decodeString("drawer_warning_color_" + i3, "");
            boVar.f184981d = from.decodeString("drawer_warning_level_" + i3, "");
            arrayList.add(boVar);
        }
        pVar.f184949j = arrayList;
        return pVar;
    }

    private com.tencent.mobileqq.activity.qqsettingme.bean.p v() {
        com.tencent.mobileqq.activity.qqsettingme.bean.p pVar = new com.tencent.mobileqq.activity.qqsettingme.bean.p();
        pVar.f184940a = "- -\u00b0";
        pVar.f184941b = "\u5f53\u5730\u5929\u6c14";
        pVar.f184942c = 0;
        pVar.f184944e = true;
        pVar.f184948i = "\u5f53\u5730\u5929\u6c14";
        pVar.f184947h = "- -\u00b0";
        pVar.f184946g = 1;
        pVar.f184945f = true;
        this.f184855h.setValue(pVar);
        return pVar;
    }

    private boolean x() {
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return false;
        }
        return com.tencent.mobileqq.weather.util.i.b(qBaseActivity, QQPermissionConstants.Business.SCENE.DRAWER_WEATHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        this.f184856i.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        QBaseActivity qBaseActivity;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!this.f184859l) {
            this.f184857j = (IWeatherRuntimeService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IWeatherRuntimeService.class);
            e eVar = new e(this.f184855h);
            this.f184858k = eVar;
            this.f184857j.setWeatherUpdateListener(eVar);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bb
                @Override // java.lang.Runnable
                public final void run() {
                    be.this.B();
                }
            });
            this.f184859l = true;
        }
        try {
            qBaseActivity = this.f259741b.get();
        } catch (Throwable th5) {
            QLog.e("QQSettingMeBaseProcessor", 1, th5, new Object[0]);
        }
        if (qBaseActivity == null) {
            return;
        }
        if (((WindowManager) qBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() < 480) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bc
                @Override // java.lang.Runnable
                public final void run() {
                    be.this.y();
                }
            });
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bd
            @Override // java.lang.Runnable
            public final void run() {
                be.this.e();
            }
        });
        if (System.currentTimeMillis() - r() > 3600000) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bb
                @Override // java.lang.Runnable
                public final void run() {
                    be.this.B();
                }
            });
        }
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).onDrawerResume();
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false)), "", "", "");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        this.f259740a = new mqq.util.WeakReference<>(appRuntime);
        this.f184857j = (IWeatherRuntimeService) ((QQAppInterface) appRuntime).getRuntimeService(IWeatherRuntimeService.class);
        e eVar = new e(this.f184855h);
        this.f184858k = eVar;
        this.f184857j.setWeatherUpdateListener(eVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f184859l = false;
        this.f184856i.observe(this.f259743d, new a(aVar));
        this.f184855h.observe(this.f259743d, new b(aVar));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        com.tencent.mobileqq.activity.qqsettingme.bean.p v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (x()) {
            v3 = u();
        } else {
            v3 = v();
        }
        this.f184855h.setValue(v3);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (!x()) {
            A();
            return;
        }
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("cur_adcode", 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(qBaseActivity, qQAppInterface, new com.tencent.mobileqq.weather.util.a(false, "", true, String.valueOf(decodeInt), ""));
        QLog.i("QQSettingMeBaseProcessor", 1, "startNewWeatherWeb adCode = " + decodeInt);
        ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportWeather(qQAppInterface, "drawer_weather_click");
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IWeatherRuntimeService iWeatherRuntimeService = this.f184857j;
        if (iWeatherRuntimeService != null) {
            iWeatherRuntimeService.setWeatherUpdateListener(null);
            this.f184857j.onDestroy();
            this.f184857j = null;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.ba
                @Override // java.lang.Runnable
                public final void run() {
                    be.this.z();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_weather";
    }
}
