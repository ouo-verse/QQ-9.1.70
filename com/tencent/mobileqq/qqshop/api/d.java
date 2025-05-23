package com.tencent.mobileqq.qqshop.api;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.message.db.f;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchAction;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001\bBG\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010 \u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b+\u0010,J,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\tH\u0002J.\u0010\u000e\u001a\u0004\u0018\u00010\r2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/d;", "", "", "tabIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/mobileqq/qqshop/message/db/a;", "d", "qqShopParams", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData;", "e", "", "f", "Landroid/content/Context;", "context", "c", "", "Ljava/util/Map;", "qggExt", "I", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "Z", "hasRedPoint", "", "J", "userClickTime", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "lastMsg", "Ljava/lang/String;", "firstDbScreenData", "g", "webExt", "Lorg/json/JSONObject;", h.F, "Lorg/json/JSONObject;", "nativeExt", "i", "directUrlFromQggExt", "<init>", "(Ljava/util/Map;IZJLcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;)V", "j", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> qggExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int entrance;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean hasRedPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long userClickTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MsgRecord lastMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String firstDbScreenData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> webExt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject nativeExt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String directUrlFromQggExt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/api/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.api.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqshop/api/d$b", "Lcom/tencent/mobileqq/qroute/route/o;", "", "onSuccess", "", "result", "onError", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements o {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, result);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d.this.f();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull Map<String, String> qggExt, int i3, boolean z16, long j3, @Nullable MsgRecord msgRecord, @Nullable String str) {
        Intrinsics.checkNotNullParameter(qggExt, "qggExt");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qggExt, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), msgRecord, str);
            return;
        }
        this.qggExt = qggExt;
        this.entrance = i3;
        this.hasRedPoint = z16;
        this.userClickTime = j3;
        this.lastMsg = msgRecord;
        this.firstDbScreenData = str;
        com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
        this.webExt = dVar.y(dVar.r(msgRecord));
        this.nativeExt = dVar.q(msgRecord);
        this.directUrlFromQggExt = qggExt.get("redirectToUrl");
    }

    private final String a() {
        boolean z16;
        JSONObject jSONObject;
        boolean z17;
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig;
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean != null && ecshopConfBean.forbidTransFirstPageData) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("QQShopTabModule", 1, "getFirstScreenData return forbidTransFirstPageData");
            return null;
        }
        MsgRecord msgRecord = this.lastMsg;
        if (msgRecord != null) {
            com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
            if (!dVar.h(msgRecord) && !dVar.w(this.lastMsg)) {
                EcshopConfBean ecshopConfBean2 = EcshopConfUtil.getEcshopConfBean();
                if (ecshopConfBean2 != null && (msgTabPageConfig = ecshopConfBean2.msgTabPageConfig) != null && msgTabPageConfig.shouldDisableLastUnreadDailyMsg) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    QLog.i("QQShopTabModule", 1, "getFirstScreenData return shouldDisableLastUnreadDailyMsg");
                    return null;
                }
                if (this.firstDbScreenData != null) {
                    QLog.i("QQShopTabModule", 1, "getFirstScreenData return firstDbScreenData");
                    return this.firstDbScreenData;
                }
            }
        }
        com.tencent.mobileqq.qqshop.message.a aVar = com.tencent.mobileqq.qqshop.message.a.f274473a;
        if (!aVar.q() && aVar.p()) {
            com.tencent.mobileqq.qqshop.message.db.a f16 = aVar.f();
            if (f16 != null) {
                jSONObject = aVar.s(f16);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                QLog.i("QQShopTabModule", 1, "getFirstScreenData return cacheMsgObj");
                return jSONObject.toString();
            }
        }
        com.tencent.mobileqq.qqshop.message.db.a d16 = d(this.lastMsg);
        if (d16 == null) {
            QLog.i("QQShopTabModule", 1, "getFirstScreenData return lastMsgData is null");
            return null;
        }
        try {
            JSONObject s16 = aVar.s(d16);
            if (s16 == null) {
                return null;
            }
            s16.put("isADDeleted", com.tencent.mobileqq.qqshop.publicaccount.c.f274574a.c(d16.b()));
            QLog.i("QQShopTabModule", 1, "getFirstScreenData return lastMsgData");
            return s16.toString();
        } catch (JSONException e16) {
            QLog.d("QQShopTabModule", 1, e16, new Object[0]);
            return null;
        }
    }

    private final HashMap<String, String> b(int tabIndex) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(this.webExt);
        String str = this.directUrlFromQggExt;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            hashMap.remove("brandId");
        }
        hashMap.putAll(this.qggExt);
        hashMap.put("entranceType", String.valueOf(this.entrance));
        hashMap.put("menuHeight", "60");
        hashMap.put("isStrictExposure", String.valueOf(com.tencent.mobileqq.qqshop.abtest.a.f274440a.a()));
        if (tabIndex == 0) {
            z17 = true;
        }
        hashMap.put("isShowDailyTabFirst", String.valueOf(z17));
        QLog.i("QQShopTabModule", 1, "start qqShopParams: " + hashMap);
        String a16 = a();
        if (a16 != null) {
            hashMap.put("firstScreenData", a16);
        }
        com.tencent.mobileqq.qqshop.message.a.f274473a.b();
        return hashMap;
    }

    private final com.tencent.mobileqq.qqshop.message.db.a d(MsgRecord msgRecord) {
        boolean z16;
        if (msgRecord == null || !com.tencent.mobileqq.qqshop.message.d.f274478a.h(msgRecord)) {
            return null;
        }
        String e16 = com.tencent.mobileqq.qqshop.message.a.f274473a.e(msgRecord);
        if (e16 != null && e16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return new com.tencent.mobileqq.qqshop.message.db.a(msgRecord.msgId, f.f274497a.c(), msgRecord.msgTime, e16);
    }

    private final KuiklyLaunchData e(HashMap<String, String> qqShopParams) {
        com.tencent.mobileqq.ecshop.utils.d dVar = com.tencent.mobileqq.ecshop.utils.d.f203953a;
        if (!dVar.f("qqshop_launch_report", true)) {
            return null;
        }
        Map<String, String> c16 = dVar.c("qqshop_launch_report");
        long j3 = 30000;
        if (c16 != null) {
            try {
                String str = c16.get("report_time_out");
                if (str != null) {
                    j3 = Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
            }
        }
        KuiklyLaunchData kuiklyLaunchData = new KuiklyLaunchData(this.userClickTime, j3);
        KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData, KuiklyLaunchAction.PAGE_OPEN_START, 0L, 2, null);
        if (kuiklyLaunchData.isModuleVersionExists()) {
            kuiklyLaunchData.addScene(2);
        }
        com.tencent.mobileqq.qqshop.message.a aVar = com.tencent.mobileqq.qqshop.message.a.f274473a;
        if (aVar.q()) {
            kuiklyLaunchData.addScene(8);
        }
        if (aVar.p()) {
            kuiklyLaunchData.addScene(16);
        }
        com.tencent.mobileqq.qqshop.report.dev.b bVar = com.tencent.mobileqq.qqshop.report.dev.b.f274713a;
        if (bVar.e()) {
            kuiklyLaunchData.addScene(1);
        } else {
            bVar.h(true);
        }
        kuiklyLaunchData.setLaunchOrigin(hj2.a.a(qqShopParams));
        return kuiklyLaunchData;
    }

    public final void c(@NotNull Context context) {
        int i3;
        KuiklyLaunchData e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putBoolean("open_chatfragment_withanim", true);
        activityURIRequest.extra().putString("key_peerId", "u_2ZRcriDgt2a46svnxKPPMw");
        activityURIRequest.extra().putInt("key_chat_type", 103);
        activityURIRequest.extra().putString("key_peerUin", IPublicAccountUtil.UIN_FOR_SHOP);
        MsgRecord msgRecord = this.lastMsg;
        if (msgRecord != null) {
            com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
            if (!dVar.h(msgRecord)) {
                com.tencent.mobileqq.qqshop.publicaccount.d dVar2 = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a;
                if (dVar2.d() || !dVar.w(this.lastMsg)) {
                    if (dVar2.d() && dVar.w(this.lastMsg)) {
                        i3 = com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.a();
                    } else {
                        i3 = com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.b();
                    }
                    activityURIRequest.extra().putInt("qq_shop_tab_index", i3);
                    HashMap<String, String> b16 = b(i3);
                    activityURIRequest.extra().putSerializable("qq_shop_kuikly_params", b16);
                    if (i3 == 0 && (e16 = e(b16)) != null) {
                        activityURIRequest.extra().putSerializable("qqshop_launch_data", e16);
                    }
                    QRoute.startUri(activityURIRequest, new b());
                }
            }
        }
        i3 = 0;
        activityURIRequest.extra().putInt("qq_shop_tab_index", i3);
        HashMap<String, String> b162 = b(i3);
        activityURIRequest.extra().putSerializable("qq_shop_kuikly_params", b162);
        if (i3 == 0) {
            activityURIRequest.extra().putSerializable("qqshop_launch_data", e16);
        }
        QRoute.startUri(activityURIRequest, new b());
    }

    public final void f() {
        String str;
        HashMap<String, String> hashMapOf;
        MsgRecord msgRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.entrance == 1 && (msgRecord = this.lastMsg) != null) {
            com.tencent.mobileqq.qqshop.report.gdt.b.f274718a.e(msgRecord);
            com.tencent.mobileqq.qqshop.report.a.f274706a.b(this.lastMsg);
        }
        int d16 = com.tencent.mobileqq.qqshop.message.d.f274478a.d(this.lastMsg);
        if (this.hasRedPoint) {
            str = "1";
        } else {
            str = "0";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("op_type", str), TuplesKt.to("ext1", String.valueOf(d16)));
        com.tencent.mobileqq.qqshop.report.beacon.b.f274709a.b("gouwu_aio_click", hashMapOf);
    }
}
