package pk4;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.huya.m;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.timi.game.liveroom.impl.room.util.QuickGiftBalanceEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.qqgift.data.service.d f426422c;

    /* renamed from: a, reason: collision with root package name */
    private static final int f426420a = ht3.a.b("qqlive_android_diamond_fans_gift_id_yule", 301475);

    /* renamed from: b, reason: collision with root package name */
    private static final int f426421b = ht3.a.b("qqlive_android_diamond_fans_gift_id_timi", 301476);

    /* renamed from: d, reason: collision with root package name */
    private static boolean f426423d = false;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements IQQGiftRechargeCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public Map<String, String> a() {
            return new HashMap();
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public void b(boolean z16, int i3, String str) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "performRecharge", "onRecharge errCode=" + i3 + "errMsg=" + str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: pk4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11025b implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f426424d;

        C11025b(j jVar) {
            this.f426424d = jVar;
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            this.f426424d.onFail(i3, str);
        }

        @Override // rh2.e
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.d> list) {
            if (list != null && list.size() != 0) {
                this.f426424d.a(list.get(0));
            } else {
                this.f426424d.onFail(-2, "fetch gift list is empty");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f426425a;

        c(int i3) {
            this.f426425a = i3;
        }

        @Override // pk4.b.j
        public void a(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            if (dVar != null && this.f426425a == dVar.f264874d && b.v() != null) {
                AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadQuietGift", "onRecv(giftData=" + dVar + ")");
                b.f426422c = dVar;
                b.G(b.f426422c.C, b.f426422c.f264874d, b.f426422c.f264883i);
            }
        }

        @Override // pk4.b.j
        public void onFail(int i3, String str) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadQuietGift", "onFail(errCode=" + i3 + ", errMsg=" + str + ")", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements IQQGiftRechargeCallback {
        e() {
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public Map<String, String> a() {
            return new HashMap();
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public void b(boolean z16, int i3, String str) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "openPayPanel", "success=" + z16 + ", errCode=" + i3 + ", errMsg=" + str, true);
            SimpleEventBus.getInstance().dispatchEvent(new QuickGiftBalanceEvent(z16, i3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements rh2.a {
        final /* synthetic */ int C;
        final /* synthetic */ long D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f426426d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f426427e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f426428f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f426429h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f426430i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f426431m;

        f(com.tencent.mobileqq.qqgift.data.service.d dVar, k kVar, Activity activity, boolean z16, boolean z17, int i3, int i16, long j3) {
            this.f426426d = dVar;
            this.f426427e = kVar;
            this.f426428f = activity;
            this.f426429h = z16;
            this.f426430i = z17;
            this.f426431m = i3;
            this.C = i16;
            this.D = j3;
        }

        @Override // rh2.a
        public void h(long j3, long j16, long j17, int i3) {
            if (b.y(this.f426426d, j3, j16)) {
                k kVar = this.f426427e;
                if (kVar != null) {
                    kVar.e(-6, "\u4f59\u989d\u4e0d\u8db3");
                    b.C(this.f426428f);
                    return;
                }
                return;
            }
            if (this.f426429h) {
                if (this.f426430i) {
                    b.E(this.f426428f, this.f426426d, this.f426431m, this.C, this.D, j3, this.f426427e);
                    return;
                } else {
                    b.F(this.f426428f, this.f426426d, this.f426431m, this.D, j3, this.f426427e);
                    return;
                }
            }
            k kVar2 = this.f426427e;
            if (kVar2 != null) {
                kVar2.c(this.f426426d);
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            k kVar = this.f426427e;
            if (kVar != null) {
                kVar.e(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f426432a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f426433b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f426434c;

        g(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, long j3) {
            this.f426432a = dVar;
            this.f426433b = i3;
            this.f426434c = j3;
        }

        @Override // pk4.b.j
        public void a(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            if (dVar != null && dVar.f264874d == this.f426432a.f264874d) {
                long i3 = tk4.d.f436481a.i();
                int i16 = this.f426433b;
                b.r(dVar, i3, i16, i16, this.f426434c);
            }
        }

        @Override // pk4.b.j
        public void onFail(int i3, String str) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "dispatchGiftMessage", "getGiftData fail, errCode=" + i3 + ", errMsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements rh2.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f426435d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f426436e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f426437f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f426438h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f426439i;

        h(k kVar, com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16) {
            this.f426435d = kVar;
            this.f426436e = dVar;
            this.f426437f = j3;
            this.f426438h = i3;
            this.f426439i = i16;
        }

        @Override // rh2.f
        public void f(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            k kVar = this.f426435d;
            if (kVar != null) {
                kVar.c(dVar);
            }
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "sendComboGiftCallback", "onSuccess, comboSeq=" + this.f426436e.H + ", curBalance=" + this.f426437f + ", comboCnt=" + this.f426438h + ", allComboCnt=" + this.f426439i + ", giftData=" + this.f426436e);
            b.I("sendComboGiftCallback", "", this.f426437f, this.f426436e, 0, this.f426438h, this.f426439i);
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            k kVar = this.f426435d;
            if (kVar != null) {
                kVar.b(i3, str);
            }
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "sendComboGiftCallback", "onFailed, errCode=" + i3 + ", errMsg=" + str + ", comboSeq=" + this.f426436e.H + ", curBalance=" + this.f426437f + ", comboCnt=" + this.f426438h + ", allComboCnt=" + this.f426439i + ", giftData=" + this.f426436e);
            b.I("sendComboGiftCallback", "", this.f426437f, this.f426436e, i3, this.f426438h, this.f426439i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements rh2.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f426440d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f426441e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f426442f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f426443h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f426444i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ k f426445m;

        i(long j3, long j16, int i3, int i16, com.tencent.mobileqq.qqgift.data.service.d dVar, k kVar) {
            this.f426440d = j3;
            this.f426441e = j16;
            this.f426442f = i3;
            this.f426443h = i16;
            this.f426444i = dVar;
            this.f426445m = kVar;
        }

        @Override // rh2.f
        public void f(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "sendDisposableGiftCallback", "onSuccess, comboSeq=" + this.f426440d + ", curBalance=" + this.f426441e + ", comboCnt=" + this.f426442f + ", allComboCnt=" + this.f426443h + ", giftData=" + this.f426444i);
            b.I("sendDisposableGiftCallback", "", this.f426441e, this.f426444i, 0, this.f426442f, this.f426443h);
            b.K(this.f426444i, this.f426440d, this.f426442f, this.f426443h, this.f426441e);
            k kVar = this.f426445m;
            if (kVar != null) {
                kVar.c(dVar);
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "sendDisposableGiftCallback", "onFailed, errCode=" + i3 + ", errMsg=" + str + ", comboSeq=" + this.f426440d + ", curBalance=" + this.f426441e + ", comboCnt=" + this.f426442f + ", allComboCnt=" + this.f426443h + ", giftData=" + this.f426444i);
            b.I("sendDisposableGiftCallback", "", this.f426441e, this.f426444i, i3, this.f426442f, this.f426443h);
            k kVar = this.f426445m;
            if (kVar != null) {
                kVar.b(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface j {
        void a(com.tencent.mobileqq.qqgift.data.service.d dVar);

        void onFail(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface k {
        void a(int i3, String str);

        void b(int i3, String str);

        void c(com.tencent.mobileqq.qqgift.data.service.d dVar);

        void d(com.tencent.mobileqq.qqgift.data.service.d dVar);

        void e(int i3, String str);

        void f(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit A(Activity activity, boolean z16, boolean z17, long j3, long j16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j17, k kVar, Boolean bool, String str) {
        f426423d = bool.booleanValue();
        if (bool.booleanValue()) {
            o(activity, z16, z17, j3, j16, dVar, i3, i16, j17, kVar);
            return null;
        }
        QQToast.makeText(BaseApplication.getContext(), str, 0).show();
        if (kVar != null) {
            kVar.f(str);
            return null;
        }
        return null;
    }

    private static boolean B(long j3, long j16) {
        if (j3 >= 0 && j16 >= 0) {
            return false;
        }
        return true;
    }

    public static void C(Activity activity) {
        if (activity == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "openPayPanel", "activity is null", true);
        } else if (v() != null && v().f() != null) {
            v().f().I(activity, 1, true, new e());
        } else {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "openPayPanel", "getGiftSdk or getRechargeModule is null", true);
        }
    }

    public static void D(Activity activity, int i3) {
        if (v() == null) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "performRecharge", "getGiftSdk is null", true);
        } else if (v().f() == null) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "performRecharge", "getRechargeModule is null", true);
        } else {
            v().f().I(activity, i3, false, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j3, long j16, k kVar) {
        l(dVar, j3, kVar);
        r(dVar, tk4.d.f436481a.i(), i3, i16, j3);
        v().a().B(activity, dVar, i3, i16, j(j16, dVar, i3, i16, kVar));
        AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "performSendComboGift", "comboSeq=" + j3 + ", curBalance=" + j16 + ", comboCnt=" + i3 + ", allComboCnt=" + i16 + ", giftData=" + dVar);
        I("performSendComboGift", "", j16, dVar, 0, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, long j3, long j16, k kVar) {
        u(dVar.f264874d, new g(dVar, i3, j3));
        l(dVar, j3, kVar);
        v().a().B(activity, dVar, i3, i3, k(kVar, dVar, j3, i3, i3, j16));
        AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "performSendDisposableGift", "comboSeq=" + j3 + ", curBalance=" + j16 + ", giftNum=" + i3 + ", giftData=" + dVar);
        I("performSendDisposableGift", "", j16, dVar, 0, i3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(int i3, int i16, int i17) {
        if (i3 != 0 && v() != null) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadMaterialRes", "materialId=" + i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.mobileqq.qqgift.data.service.g(i3, i16, i17));
            v().b().h(arrayList, new d());
        }
    }

    public static void H(int i3) {
        if (ht3.a.b("qqlive_preload_diamond_gift_res", 1) != 1) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadQuietGift", "preload switch");
            return;
        }
        int x16 = x(i3);
        com.tencent.mobileqq.qqgift.data.service.d dVar = f426422c;
        if (dVar != null && dVar.f264874d == x16) {
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadQuietGift", "has preload giftId=" + x16);
            return;
        }
        AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "preloadQuietGift", "giftId=" + x16);
        u((long) x16, new c(x16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(String str, String str2, long j3, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, int i17) {
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder eventId = new QQLiveQualityReportData.Builder().traceId("").eventId(QQLiveReportConstants.Event.E_MONITOR_LOG_REPORT);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        sb5.append(cVar.p());
        iQQLiveReportApi.qualityReport(eventId.roomId(sb5.toString()).roomType("" + cVar.q()).retCode("" + i3).ext6("Send_Gift_Monitor|QuickGiftHelper").ext7(str).ext8(str2).ext9("" + cVar.G()).ext10("" + dVar.K).ext11("" + j3).ext12("" + dVar.f264874d).ext13("" + dVar.f264878f).ext14("" + dVar.F).ext15("" + dVar.C).ext16("" + dVar.f264883i).ext17("" + dVar.H).ext18("" + i16).ext19("" + i17));
    }

    public static void J(Activity activity, long j3, long j16, k kVar, int i3, int i16, long j17, com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (!q(activity, dVar, kVar)) {
            return;
        }
        if (f426423d) {
            o(activity, true, true, j3, j16, dVar, i3, i16, j17, kVar);
        } else {
            m(activity, true, true, j3, j16, dVar, i3, i16, j17, kVar);
        }
    }

    public static void K(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16, long j16) {
        if (v() != null && v().a() != null) {
            if (dVar == null) {
                AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "sendComboGiftOver", "fail, giftData is null");
                return;
            }
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "sendComboGiftOver", "comboSeq=" + j3 + ", curBalance=" + j16 + ", comboCnt=" + i3 + ", allComboCnt=" + i16 + ", giftData=" + dVar);
            I("sendComboGiftOver", "", j16, dVar, 0, i3, i16);
            dVar.H = j3;
            v().a().w(dVar, 1, j3, i3, i16);
            return;
        }
        AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "sendComboGiftOver", "fail, giftSDK or ServiceModule is null");
    }

    public static void L(Activity activity, long j3, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, k kVar) {
        if (!q(activity, dVar, kVar)) {
            return;
        }
        F(activity, dVar, i3, System.currentTimeMillis(), j3, kVar);
    }

    private static rh2.f j(long j3, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, k kVar) {
        return new h(kVar, dVar, j3, i3, i16);
    }

    private static rh2.f k(k kVar, com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16, long j16) {
        return new i(j3, j16, i3, i16, dVar, kVar);
    }

    private static void l(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, k kVar) {
        com.tencent.mobileqq.qqlive.huya.c g16;
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        dVar.H = j3;
        com.tencent.mobileqq.qqlive.sail.c cVar2 = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        cVar.f264860a = cVar2.G();
        long p16 = cVar2.p();
        cVar.f264861b = cVar2.k(p16, 0);
        cVar.f264870k.put(AudienceReportConst.ROOM_ID, String.valueOf(p16));
        boolean equals = "huya".equals(cVar2.D(p16, 1));
        if (equals && (g16 = m.f271359a.g()) != null && g16.b() != null) {
            cVar.f264870k.put("huya_openid", g16.b());
        }
        Map<String, String> map = dVar.M;
        if (map != null) {
            cVar.f264870k.putAll(map);
        }
        s(cVar.f264869j, "1", equals);
        v().a().Q(cVar);
    }

    private static void m(final Activity activity, final boolean z16, final boolean z17, final long j3, final long j16, final com.tencent.mobileqq.qqgift.data.service.d dVar, final int i3, final int i16, final long j17, final k kVar) {
        zh4.d.f452579a.d(activity, AuthScene.GIFT, new Function2() { // from class: pk4.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit A;
                A = b.A(activity, z16, z17, j3, j16, dVar, i3, i16, j17, kVar, (Boolean) obj, (String) obj2);
                return A;
            }
        });
    }

    public static void n(Activity activity, boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, long j16, k kVar) {
        if (!q(activity, dVar, kVar)) {
            return;
        }
        if (f426423d) {
            o(activity, true, z16, j3, j16, dVar, 1, 1, System.currentTimeMillis(), kVar);
        } else {
            m(activity, true, z16, j3, j16, dVar, 1, 1, System.currentTimeMillis(), kVar);
        }
    }

    private static void o(Activity activity, boolean z16, boolean z17, long j3, long j16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j17, k kVar) {
        if (!B(j3, j16)) {
            if (y(dVar, j3, j16)) {
                if (kVar != null) {
                    kVar.e(-6, "\u4f59\u989d\u4e0d\u8db3");
                }
                C(activity);
                return;
            } else if (!z16) {
                if (kVar != null) {
                    kVar.d(dVar);
                    return;
                }
                return;
            } else if (z17) {
                E(activity, dVar, i3, i16, j17, j3, kVar);
                return;
            } else {
                F(activity, dVar, i3, j17, j3, kVar);
                return;
            }
        }
        t(new f(dVar, kVar, activity, z16, z17, i3, i16, j17));
    }

    public static void p(Activity activity, boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, long j16, k kVar) {
        if (!q(activity, dVar, kVar)) {
            return;
        }
        if (f426423d) {
            o(activity, false, z16, j3, j16, dVar, 0, 0, 0L, kVar);
        } else {
            m(activity, false, z16, j3, j16, dVar, 0, 0, 0L, kVar);
        }
    }

    private static boolean q(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, k kVar) {
        if (activity == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "checkSendGiftCondition", "fail, activity is null");
            if (kVar != null) {
                kVar.a(-1, "activity is null");
            }
            return false;
        }
        if (v() == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "checkSendGiftCondition", "fail, getGiftSdk is null");
            if (kVar != null) {
                kVar.a(-2, "getGiftSdk is null");
            }
            return false;
        }
        if (v().e() == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "checkSendGiftCondition", "fail, getIdentifyModule is null");
            if (kVar != null) {
                kVar.a(-3, "getIdentifyModule is null");
            }
            return false;
        }
        if (v().a() == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "checkSendGiftCondition", "fail, getServiceModule is null");
            if (kVar != null) {
                kVar.a(-4, "getServiceModule is null");
            }
            return false;
        }
        if (dVar == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "checkSendGiftCondition", "fail, giftData is null");
            if (kVar != null) {
                kVar.a(-5, "giftData is null");
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16, long j16) {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        LiveLoginInfo u16 = cVar.u();
        if (u16 == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "dispatchGiftMessage", "fail, invalid login info");
            return;
        }
        if (!cVar.m().B(j3, 0)) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "dispatchGiftMessage", "fail, audienceRoom is null");
            return;
        }
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.effectLevel = dVar.f264883i;
        giftMessage.giftID = dVar.f264874d;
        giftMessage.giftName = dVar.f264876e;
        giftMessage.materialID = dVar.C;
        giftMessage.giftType = dVar.f264881h;
        giftMessage.giftNum = i3;
        giftMessage.sender = u16.q();
        giftMessage.senderHead = u16.j();
        giftMessage.senderNick = u16.m();
        giftMessage.receiverNick = cVar.m().f(j3, 0);
        giftMessage.receiverHead = cVar.m().d(j3, 0);
        giftMessage.comboSeq = j16;
        giftMessage.allComboCnt = i16;
        giftMessage.giftPrice = dVar.f264878f;
        Map<String, String> map = dVar.M;
        if (map != null && map.containsKey("batchSendCnt")) {
            giftMessage.batchSendCnt = Long.parseLong(dVar.M.get("batchSendCnt"));
        }
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftEvent(giftMessage, j3, v().getSDKConfig().f264972a));
    }

    public static void s(ConcurrentHashMap<String, String> concurrentHashMap, String str, boolean z16) {
        String str2;
        if (concurrentHashMap == null) {
            return;
        }
        tk4.d dVar = tk4.d.f436481a;
        if (!TextUtils.isEmpty(dVar.r())) {
            concurrentHashMap.put("program_id", dVar.q());
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            concurrentHashMap.put("anchor_uid", String.valueOf(dVar.e(cVar.p())));
            concurrentHashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(dVar.i()));
            concurrentHashMap.put("roomid", String.valueOf(dVar.i()));
            concurrentHashMap.put("room_type", dVar.u());
            concurrentHashMap.put("room_enter_id", dVar.r());
            if (str == null) {
                str = "";
            }
            concurrentHashMap.put("source_from", str);
            concurrentHashMap.put("item_type", "\u793c\u7269");
            concurrentHashMap.put("ownerqq", String.valueOf(dVar.e(cVar.p())));
            concurrentHashMap.put("app_version", dVar.x());
            concurrentHashMap.put("qqlive_start_source", QQLiveSDKConfigHelper.getQQLiveAppId());
            concurrentHashMap.put("qqlive_coming_way", dVar.h());
            concurrentHashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, dVar.m());
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            concurrentHashMap.put("isHuya", str2);
        }
    }

    public static void t(rh2.a aVar) {
        if (aVar == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "getBalance", "fail, callback is null", true);
        } else if (v() != null && v().a() != null) {
            v().a().F(aVar);
        } else {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "getBalance", "getBalance fail, getGiftSdk or getServiceModule is null", true);
            aVar.onFailed(-1, "getBalance fail, getGiftSdk or getServiceModule is null");
        }
    }

    public static void u(long j3, j jVar) {
        if (jVar == null) {
            return;
        }
        nh2.c v3 = v();
        if (v3 == null) {
            jVar.onFail(-1, "giftSDK or ServiceModule is null");
            return;
        }
        List<com.tencent.mobileqq.qqgift.data.service.d> D = v3.a().D();
        if (D != null) {
            for (com.tencent.mobileqq.qqgift.data.service.d dVar : D) {
                if (dVar != null && j3 == dVar.f264874d) {
                    jVar.a(dVar);
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        v3.a().v(arrayList, new C11025b(jVar));
    }

    public static nh2.c v() {
        int a16 = ni4.c.f420216a.a(Long.valueOf(tk4.d.f436481a.i()));
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(a16);
        if (sDKImpl != null && !sDKImpl.isInited()) {
            sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(a16).b());
        }
        return sDKImpl;
    }

    public static com.tencent.mobileqq.qqgift.data.service.d w(int i3) {
        com.tencent.mobileqq.qqgift.data.service.d dVar = f426422c;
        if (dVar != null && dVar.f264874d == i3) {
            return dVar;
        }
        return null;
    }

    public static int x(int i3) {
        if (SSODebugUtil.isTestEnv()) {
            return 300221;
        }
        if (1 == i3) {
            return f426421b;
        }
        return f426420a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, long j16) {
        int i3;
        if (dVar == null) {
            AegisLogger.e("Send_Gift_Monitor|QuickGiftHelper", "isNotEnoughPrice", "giftServiceData is null", true);
            return false;
        }
        Map<String, String> map = dVar.M;
        if (map == null) {
            int i16 = dVar.f264878f;
            if (j16 >= i16 || j3 >= i16) {
                return false;
            }
            return true;
        }
        if (map.containsKey("batchSendCnt")) {
            String str = dVar.M.get("batchSendCnt");
            if (str != null) {
                i3 = Integer.parseInt(str);
            } else {
                i3 = 1;
            }
            AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "isNotEnoughPrice", "has batchSend infomation: gift.Id=" + dVar.f264874d + "gift.Name=" + dVar.f264876e + "gift.Price=" + dVar.f264878f + "gift.allHitNum=" + dVar.J + "gift.hitSeq=" + dVar.H + "batchSendCnt=" + i3, true);
        } else {
            i3 = 1;
        }
        int max = dVar.f264878f * Math.max(i3, 1);
        AegisLogger.i("Send_Gift_Monitor|QuickGiftHelper", "isNotEnoughPrice", "current balance: marketingBalance=" + j16 + "balance=" + j3 + "totalPrice=" + max, true);
        long j17 = (long) max;
        if (j16 >= j17 || j3 >= j17) {
            return false;
        }
        return true;
    }

    public static boolean z(int i3) {
        if (i3 != x(com.tencent.mobileqq.qqlive.sail.c.f272176a.q()) && !oj4.a.f423029a.contains(Integer.valueOf(i3))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements qh2.h {
        d() {
        }

        @Override // qh2.h
        public void a(int i3, int i16) {
        }

        @Override // qh2.h
        public void b(boolean z16, int i3, String str) {
        }
    }
}
