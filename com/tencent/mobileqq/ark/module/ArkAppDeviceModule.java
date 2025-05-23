package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ark.ark;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.MobileQQ;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppDeviceModule extends com.tencent.mobileqq.ark.module.b {

    /* renamed from: l, reason: collision with root package name */
    protected ArkAppEventObserverManager f199516l;

    /* renamed from: m, reason: collision with root package name */
    private c f199517m;

    /* renamed from: n, reason: collision with root package name */
    private a f199518n;

    /* renamed from: o, reason: collision with root package name */
    private ObserverMethod f199519o;

    /* renamed from: p, reason: collision with root package name */
    private ScanCodeMethod f199520p;

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, b> f199521q;

    /* renamed from: r, reason: collision with root package name */
    private BroadcastReceiver f199522r;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class ObserverMethod implements b {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ark.module.ArkAppDeviceModule$ObserverMethod$5, reason: invalid class name */
        /* loaded from: classes11.dex */
        class AnonymousClass5 implements f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f199528a;

            AnonymousClass5(long j3) {
                this.f199528a = j3;
            }

            @Override // com.tencent.mobileqq.ark.module.f
            public void onFail() {
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDeviceModule.this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        ArkAppDeviceModule.this.B(anonymousClass5.f199528a, false, 0.0d, 0.0d);
                        AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                        ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(anonymousClass52.f199528a);
                        if (l3 != null) {
                            l3.Reset();
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.ark.module.f
            public void onSuccess() {
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDeviceModule.this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.5.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.ark.module.ArkAppDeviceModule$ObserverMethod$5$1$a */
                    /* loaded from: classes11.dex */
                    class a implements ArkAppEventObserverManager.c {
                        a() {
                        }

                        @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.c
                        public void a(boolean z16, double d16, double d17) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            ArkAppDeviceModule.this.B(anonymousClass5.f199528a, z16, d16, d17);
                        }

                        @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.e
                        public void c(long j3) {
                            ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(j3);
                            if (l3 != null) {
                                l3.Reset();
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = new a();
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        ArkAppDeviceModule.this.f199516l.D(aVar, anonymousClass5.f199528a);
                    }
                });
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements ArkAppEventObserverManager.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f199533a;

            a(long j3) {
                this.f199533a = j3;
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.e
            public void c(long j3) {
                ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(j3);
                if (l3 != null) {
                    l3.Reset();
                }
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.d
            public void d(boolean z16, float f16, float f17, float f18) {
                ArkAppDeviceModule.this.D(this.f199533a, z16, "Motion", f16, f17, f18);
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class b implements ArkAppEventObserverManager.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f199535a;

            b(long j3) {
                this.f199535a = j3;
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.e
            public void c(long j3) {
                ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(j3);
                if (l3 != null) {
                    l3.Reset();
                }
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.f
            public void e(boolean z16, float f16, float f17, float f18) {
                ArkAppDeviceModule.this.D(this.f199535a, z16, "Orientation", f16, f17, f18);
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class c implements ArkAppEventObserverManager.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f199537a;

            c(long j3) {
                this.f199537a = j3;
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.b
            public void b(boolean z16, String str) {
                ArkAppDeviceModule.this.A(this.f199537a, z16, str);
            }

            @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.e
            public void c(long j3) {
                ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(j3);
                if (l3 != null) {
                    l3.Reset();
                }
            }
        }

        ObserverMethod() {
        }

        @Override // com.tencent.mobileqq.ark.module.ArkAppDeviceModule.b
        public boolean a(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            ArkAppEventObserverManager.e eVar;
            if ("AttachEvent".equals(str)) {
                if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString() && variantWrapperArr[1].IsFunction()) {
                    String GetString = variantWrapperArr[0].GetString();
                    final long g16 = ArkAppDeviceModule.this.g(variantWrapperArr[1].Copy());
                    if ("Motion".equals(GetString)) {
                        ArkAppDeviceModule arkAppDeviceModule = ArkAppDeviceModule.this;
                        if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule.f199566b, arkAppDeviceModule.f199565a, arkAppDeviceModule.f199570f, "permission.SENSORS")) {
                            return false;
                        }
                        eVar = new a(g16);
                    } else if ("Orientation".equals(GetString)) {
                        ArkAppDeviceModule arkAppDeviceModule2 = ArkAppDeviceModule.this;
                        if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule2.f199566b, arkAppDeviceModule2.f199565a, arkAppDeviceModule2.f199570f, "permission.SENSORS")) {
                            return false;
                        }
                        eVar = new b(g16);
                    } else {
                        if ("Position".equals(GetString)) {
                            ArkAppDeviceModule arkAppDeviceModule3 = ArkAppDeviceModule.this;
                            if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule3.f199566b, arkAppDeviceModule3.f199565a, arkAppDeviceModule3.f199570f, "permission.POSITION")) {
                                return false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("ArkAppDeviceModule", 2, String.format("Position.app.%s", ArkAppDeviceModule.this.f199566b));
                            }
                            String z16 = ArkAppDeviceModule.z();
                            ArkAppDeviceModule arkAppDeviceModule4 = ArkAppDeviceModule.this;
                            ArkModuleAPIAuthority.e(z16, arkAppDeviceModule4.f199566b, arkAppDeviceModule4.f199568d, IArkModuleAPIAuthority.ARK_AUTHORITY_API_LOCATION, BaseApplication.getContext().getString(R.string.f170435qt), new f() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.3

                                /* compiled from: P */
                                /* renamed from: com.tencent.mobileqq.ark.module.ArkAppDeviceModule$ObserverMethod$3$a */
                                /* loaded from: classes11.dex */
                                class a implements ArkAppEventObserverManager.g {
                                    a() {
                                    }

                                    @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.g
                                    public void a(boolean z16, double d16, double d17) {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        ArkAppDeviceModule.this.B(g16, z16, d16, d17);
                                    }

                                    @Override // com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.e
                                    public void c(long j3) {
                                        ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(j3);
                                        if (l3 != null) {
                                            l3.Reset();
                                        }
                                    }
                                }

                                @Override // com.tencent.mobileqq.ark.module.f
                                public void onFail() {
                                    ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDeviceModule.this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.3.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            ArkAppDeviceModule.this.B(g16, false, 0.0d, 0.0d);
                                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                            ark.VariantWrapper l3 = ArkAppDeviceModule.this.l(g16);
                                            if (l3 != null) {
                                                l3.Reset();
                                            }
                                        }
                                    });
                                }

                                @Override // com.tencent.mobileqq.ark.module.f
                                public void onSuccess() {
                                    ArkAppDeviceModule.this.f199516l.D(new a(), g16);
                                }
                            });
                            return true;
                        }
                        if ("ConnectionTypeChange".equals(GetString)) {
                            ArkAppDeviceModule arkAppDeviceModule5 = ArkAppDeviceModule.this;
                            if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule5.f199566b, arkAppDeviceModule5.f199565a, arkAppDeviceModule5.f199570f, "permission.CONNECTION_TYPE")) {
                                return false;
                            }
                            eVar = new c(g16);
                        } else {
                            eVar = null;
                        }
                    }
                    if (eVar != null && !"Position".equals(GetString)) {
                        ArkAppDeviceModule.this.f199516l.D(eVar, g16);
                        return true;
                    }
                }
                return false;
            }
            if ("DetachEvent".equals(str)) {
                if (variantWrapperArr == null || variantWrapperArr.length < 1 || !variantWrapperArr[0].IsString() || TextUtils.isEmpty(variantWrapperArr[0].GetString())) {
                    return false;
                }
                ArkAppDeviceModule.this.f199516l.E(variantWrapperArr[0].GetString());
                return true;
            }
            if ("GetCurrentPosition".equals(str)) {
                ArkAppDeviceModule arkAppDeviceModule6 = ArkAppDeviceModule.this;
                if (com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule6.f199566b, arkAppDeviceModule6.f199565a, arkAppDeviceModule6.f199570f, "permission.POSITION") && variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsFunction()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ArkAppDeviceModule", 2, String.format("GetCurrentPosition.app.%s", ArkAppDeviceModule.this.f199566b));
                    }
                    long g17 = ArkAppDeviceModule.this.g(variantWrapperArr[0].Copy());
                    String z17 = ArkAppDeviceModule.z();
                    ArkAppDeviceModule arkAppDeviceModule7 = ArkAppDeviceModule.this;
                    ArkModuleAPIAuthority.e(z17, arkAppDeviceModule7.f199566b, arkAppDeviceModule7.f199568d, IArkModuleAPIAuthority.ARK_AUTHORITY_API_LOCATION, BaseApplication.getContext().getString(R.string.f170435qt), new AnonymousClass5(g17));
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class ScanCodeMethod implements b {
        ScanCodeMethod() {
        }

        @Override // com.tencent.mobileqq.ark.module.ArkAppDeviceModule.b
        public boolean a(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            if ("ScanCode".equals(str) && variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsFunction()) {
                final long g16 = ArkAppDeviceModule.this.g(variantWrapperArr[0].Copy());
                Intent intent = new Intent();
                intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.qrscan.activity.ScannerActivity");
                intent.putExtra("from", "com.tencent.ark.scan");
                if (ArkAppDeviceModule.this.f199522r != null) {
                    try {
                        BaseApplication.getContext().unregisterReceiver(ArkAppDeviceModule.this.f199522r);
                    } catch (Exception unused) {
                    }
                    ArkAppDeviceModule.this.f199522r = null;
                }
                ArkAppDeviceModule.this.f199522r = new BroadcastReceiver() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ScanCodeMethod.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent2) {
                        final String stringExtra = intent2.getStringExtra("com.tencent.ark.scanResultData");
                        final String stringExtra2 = intent2.getStringExtra("com.tencent.ark.scanResultType");
                        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDeviceModule.this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ScanCodeMethod.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                ArkAppDeviceModule.this.C(g16, stringExtra, stringExtra2);
                            }
                        });
                        try {
                            BaseApplication.getContext().unregisterReceiver(ArkAppDeviceModule.this.f199522r);
                        } catch (Exception unused2) {
                        }
                        ArkAppDeviceModule.this.f199522r = null;
                    }
                };
                BaseApplication.getContext().registerReceiver(ArkAppDeviceModule.this.f199522r, new IntentFilter("com.tencent.mobileqq.ark.api.scanResultAction"), "com.tencent.msg.permission.pushnotify", null);
                Activity f16 = com.tencent.mobileqq.ark.module.b.f();
                if (f16 != null) {
                    f16.startActivity(intent);
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a implements b {
        a() {
        }

        @Override // com.tencent.mobileqq.ark.module.ArkAppDeviceModule.b
        public boolean a(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            ArkAppDeviceModule arkAppDeviceModule = ArkAppDeviceModule.this;
            if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule.f199566b, arkAppDeviceModule.f199565a, arkAppDeviceModule.f199570f, "permission.CONNECTION_TYPE")) {
                return false;
            }
            if (!AppNetConnInfo.isNetSupport()) {
                variantWrapper.SetString("none");
                return true;
            }
            if (AppNetConnInfo.isWifiConn()) {
                variantWrapper.SetString("wifi");
                return true;
            }
            if (AppNetConnInfo.isMobileConn()) {
                int mobileInfo = AppNetConnInfo.getMobileInfo();
                if (mobileInfo == 0) {
                    variantWrapper.SetString("none");
                    return true;
                }
                if (-1 == mobileInfo) {
                    variantWrapper.SetString("other");
                    return true;
                }
                variantWrapper.SetString("cellular");
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private interface b {
        boolean a(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class c implements b {
        c() {
        }

        @Override // com.tencent.mobileqq.ark.module.ArkAppDeviceModule.b
        public boolean a(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
            ArkAppDeviceModule arkAppDeviceModule = ArkAppDeviceModule.this;
            if (!com.tencent.mobileqq.ark.module.a.a(arkAppDeviceModule.f199566b, arkAppDeviceModule.f199565a, arkAppDeviceModule.f199570f, "permission.DEVICE_INFORMATION")) {
                return false;
            }
            DisplayMetrics displayMetrics = ((IDisplayConfig) QRoute.api(IDisplayConfig.class)).getDisplayMetrics();
            if ("GetModelName".equals(str)) {
                variantWrapper.SetString(DeviceInfoMonitor.getModel());
                return true;
            }
            if ("GetScreenWidth".equals(str)) {
                variantWrapper.SetInt((int) (displayMetrics.widthPixels / displayMetrics.density));
                return true;
            }
            if ("GetScreenHeight".equals(str)) {
                variantWrapper.SetInt((int) (displayMetrics.heightPixels / displayMetrics.density));
                return true;
            }
            if ("GetPixelRatio".equals(str)) {
                variantWrapper.SetDouble(((IDisplayConfig) QRoute.api(IDisplayConfig.class)).getDisplayDensity());
                return true;
            }
            if (!"GetIdentifier".equals(str)) {
                return false;
            }
            String z16 = ah.z();
            if (TextUtils.isEmpty(z16)) {
                try {
                    z16 = QQDeviceInfo.getIMEI("6973c4");
                } catch (Exception unused) {
                    QLog.e("ArkAppDeviceModule", 1, "get identifer: exception, catch it");
                }
            }
            if (z16 == null) {
                QLog.e("ArkAppDeviceModule", 1, "get identifer: null, fix it with empty string");
                z16 = "";
            }
            if (ArkAppDeviceModule.this.f199565a != 0) {
                z16 = MD5Coding.encodeHexStr(z16);
            }
            variantWrapper.SetString(z16);
            return true;
        }
    }

    public ArkAppDeviceModule(ark.Application application, int i3) {
        super(application, i3);
        this.f199517m = new c();
        this.f199518n = new a();
        this.f199519o = new ObserverMethod();
        this.f199520p = new ScanCodeMethod();
        this.f199522r = null;
        this.f199516l = new ArkAppEventObserverManager(this.f199566b);
        this.f199521q = new HashMap<String, b>() { // from class: com.tencent.mobileqq.ark.module.ArkAppDeviceModule.1
            {
                put("GetModelName", ArkAppDeviceModule.this.f199517m);
                put("GetScreenWidth", ArkAppDeviceModule.this.f199517m);
                put("GetScreenHeight", ArkAppDeviceModule.this.f199517m);
                put("GetPixelRatio", ArkAppDeviceModule.this.f199517m);
                put("GetConnectionType", ArkAppDeviceModule.this.f199518n);
                put("AttachEvent", ArkAppDeviceModule.this.f199519o);
                put("DetachEvent", ArkAppDeviceModule.this.f199519o);
                put("ScanCode", ArkAppDeviceModule.this.f199520p);
                put("GetIdentifier", ArkAppDeviceModule.this.f199517m);
                put("GetCurrentPosition", ArkAppDeviceModule.this.f199519o);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(long j3, boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppDeviceModule", 2, "doConnectionCallback cbId=" + j3 + ", success=" + z16 + ", netType=" + str);
        }
        ark.VariantWrapper d16 = d(j3);
        if (d16 == null) {
            return;
        }
        ark.VariantWrapper Create = d16.Create();
        if (z16) {
            Create.SetString(str);
        } else {
            Create.SetNull();
        }
        ark.VariantWrapper Create2 = d16.Create();
        d16.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
        Create2.Reset();
        Create.Reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(long j3, boolean z16, double d16, double d17) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppDeviceModule", 2, "doPositionCallback cbId=" + j3 + ", success=" + z16 + ", lat=" + d16 + ", lng=" + d17);
        }
        ark.VariantWrapper d18 = d(j3);
        if (d18 == null) {
            return;
        }
        ark.VariantWrapper Create = d18.Create();
        if (z16) {
            Create.SetTableAsJsonString(String.format(Locale.CHINA, "{\"latitude\":%.6f,\"longitude\":%.6f}", Double.valueOf(d16), Double.valueOf(d17)));
        } else {
            Create.SetNull();
        }
        ark.VariantWrapper Create2 = d18.Create();
        d18.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
        Create2.Reset();
        Create.Reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(long j3, String str, String str2) {
        boolean z16;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppDeviceModule", 2, "doScanCodeCallback cbId=" + j3 + ", scanResult=" + str + ", scanType=" + str2);
        }
        ark.VariantWrapper l3 = l(j3);
        if (l3 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        ark.VariantWrapper Create = l3.Create();
        if (z16) {
            if (CommonConstant.RETKEY.QR_CODE.equalsIgnoreCase(str2)) {
                str3 = "QRCode";
            } else {
                str3 = "BarCode";
            }
            Create.SetTableAsJsonString(String.format(Locale.CHINA, "{\"result\":\"%s\",\"type\":\"%s\",\"charset\":\"%s\"}", str, str3, "utf-8"));
        } else {
            Create.SetNull();
        }
        ark.VariantWrapper Create2 = l3.Create();
        l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
        Create2.Reset();
        Create.Reset();
        l3.Reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(long j3, boolean z16, String str, float f16, float f17, float f18) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppDeviceModule", 2, "doSensorCallback cbId=" + j3 + ", success=" + z16 + ", sensorEventType=" + str + ", argA=" + f16 + ", argB=" + f17 + ", argC=" + f18);
        }
        ark.VariantWrapper d16 = d(j3);
        if (d16 == null) {
            return;
        }
        ark.VariantWrapper Create = d16.Create();
        if ("Motion".equals(str)) {
            str2 = "{\"x\":%.6f,\"y\":%.6f,\"z\":%.6f}";
        } else if ("Orientation".equals(str)) {
            str2 = "{\"alpha\":%.6f,\"beta\":%.6f,\"gamma\":%.6f}";
        } else {
            str2 = null;
        }
        if (z16 && !TextUtils.isEmpty(str2)) {
            Create.SetTableAsJsonString(String.format(Locale.CHINA, str2, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18)));
        } else {
            Create.SetNull();
        }
        ark.VariantWrapper Create2 = d16.Create();
        d16.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
        Create2.Reset();
        Create.Reset();
    }

    private static String E() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
    }

    static /* bridge */ /* synthetic */ String z() {
        return E();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        ArkAppEventObserverManager arkAppEventObserverManager = this.f199516l;
        if (arkAppEventObserverManager != null) {
            arkAppEventObserverManager.C();
        }
        if (this.f199522r != null) {
            try {
                BaseApplication.getContext().unregisterReceiver(this.f199522r);
            } catch (Exception unused) {
            }
            this.f199522r = null;
        }
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "Device";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        HashMap<String, b> hashMap = this.f199521q;
        if (hashMap != null && hashMap.containsKey(str) && this.f199521q.get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        HashMap<String, b> hashMap;
        b bVar;
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppDeviceModule", 2, "invokeFunc=" + str);
        }
        if (!c(str) || (hashMap = this.f199521q) == null || (bVar = hashMap.get(str)) == null) {
            return false;
        }
        return bVar.a(str, variantWrapperArr, variantWrapper);
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }
}
