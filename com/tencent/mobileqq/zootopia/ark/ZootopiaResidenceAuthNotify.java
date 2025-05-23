package com.tencent.mobileqq.zootopia.ark;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import si3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J@\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00122\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J&\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ark/ZootopiaResidenceAuthNotify;", "Lcom/tencent/mobileqq/ark/module/g;", "", "paramsStr", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, IProfileProtocolConst.PARAM_TARGET_UIN, "o", "u", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "p", "t", "w", "r", ReportConstant.COSTREPORT_PREFIX, "event", "", "errCode", "errMsg", "source", "", "", "extMap", "k", "appName", AdMetricTag.EVENT_NAME, "params", "", "notify", "Lid3/d;", "d", "Lid3/d;", "reportHelper", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaResidenceAuthNotify implements com.tencent.mobileqq.ark.module.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper = new id3.d(null, 1, null);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327921a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f327921a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/ark/ZootopiaResidenceAuthNotify$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ZootopiaMapStatusService.MapStatusInfoResult> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f327923e;

        c(String str) {
            this.f327923e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZootopiaResidenceAuthNotify.this.p(result.getMapStatus(), this.f327923e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZootopiaArkNotify", 1, "checkMapStatusFromServer fail " + error + ", " + message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, java.lang.Object, java.lang.String] */
    public final void k(final String event, int errCode, String errMsg, int source, Map<String, ? extends Object> extMap) {
        Set<Map.Entry<String, ? extends Object>> entrySet;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", errCode);
            jSONObject.put("errMsg", errMsg);
            jSONObject.put("source", source);
            if (extMap != null && (entrySet = extMap.entrySet()) != null) {
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            ?? jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "rspObject.toString()");
            objectRef.element = jSONObject2;
        } catch (Throwable unused) {
            QLog.e("ZootopiaArkNotify", 1, "");
        }
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread("com.tencent.zplan.homelimit", new Runnable() { // from class: com.tencent.mobileqq.zootopia.ark.i
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaResidenceAuthNotify.m(event, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(String event, Ref.ObjectRef data) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(data, "$data");
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.zplan.homelimit", "", event, (String) data.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String targetUin) {
        new ZootopiaMapStatusService().a(AdMetricID.Click.SUCCESS, new c(targetUin));
    }

    private final void o(final String targetUin) {
        ((IZootopiaResidenceAuthApi) QRoute.api(IZootopiaResidenceAuthApi.class)).checkResidenceVisitAuth(targetUin, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaResidenceAuthNotify$checkResidenceAuthFromServer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String errMsg) {
                id3.d dVar;
                Map<String, Object> mutableMapOf;
                id3.d dVar2;
                Map<String, Object> mutableMapOf2;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (z16) {
                    ZootopiaResidenceAuthNotify.this.n(targetUin);
                    dVar2 = ZootopiaResidenceAuthNotify.this.reportHelper;
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_ark_enter_xiaowo_authorization", 1));
                    dVar2.d("ev_zplan_aio_ark_action_native", mutableMapOf2);
                    return;
                }
                QLog.i("ZootopiaArkNotify", 2, "checkResidenceAuthFromServer check fail: " + errMsg);
                ZootopiaResidenceAuthNotify.this.u();
                dVar = ZootopiaResidenceAuthNotify.this.reportHelper;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_ark_enter_xiaowo_authorization", 0));
                dVar.d("ev_zplan_aio_ark_action_native", mutableMapOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MapStatus mapStatus, final String targetUin) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        if (QBaseActivity.sTopActivity == null) {
            return;
        }
        final ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, ZootopiaSource.SUB_SOURCE_ARK_XIAOWO, null, 4, null);
        if (b.f327921a[mapStatus.ordinal()] == 1) {
            ZootopiaDownloadManager.f327992a.Y(String.valueOf(AdMetricID.Click.SUCCESS), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaResidenceAuthNotify$doRealEnter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                    invoke2(zootopiaDownloadData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                    if (zootopiaDownloadData != null) {
                        String str = targetUin;
                        c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), AdMetricID.Click.SUCCESS, d16, SmallHomeHelper.f328312a.a("3", str), null, 8, null);
                    }
                }
            });
            id3.d dVar = this.reportHelper;
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_ark_enter_xiaowo_resource", 1));
            dVar.d("ev_zplan_aio_ark_action_native", mutableMapOf2);
            return;
        }
        t(targetUin);
        id3.d dVar2 = this.reportHelper;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_ark_enter_xiaowo_resource", 0));
        dVar2.d("ev_zplan_aio_ark_action_native", mutableMapOf);
    }

    private final void q(String paramsStr) {
        com.tencent.mobileqq.zootopia.ark.b bVar = new com.tencent.mobileqq.zootopia.ark.b();
        if (!a.INSTANCE.a(paramsStr, bVar)) {
            QLog.e("ZootopiaArkNotify", 2, "enterResidence parse params err");
        } else if (bVar.getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_TARGET_UIN java.lang.String() <= 0) {
            QLog.e("ZootopiaArkNotify", 1, "enterResidence uin err");
        } else {
            o(String.valueOf(bVar.getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_TARGET_UIN java.lang.String()));
        }
    }

    private final void r(String paramsStr) {
        final com.tencent.mobileqq.zootopia.ark.c cVar = new com.tencent.mobileqq.zootopia.ark.c();
        if (!a.INSTANCE.a(paramsStr, cVar)) {
            l(this, "get_apply_status", -1, "parse params err", cVar.getSource(), null, 16, null);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            l(this, "make_decision", -1, "appInterface null", cVar.getSource(), null, 16, null);
        } else {
            com.tencent.mobileqq.zootopia.service.i.i(new com.tencent.mobileqq.zootopia.service.i(), appInterface, cVar.getBillNum(), cVar.getSource(), 0, new Function3<Integer, Integer, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaResidenceAuthNotify$getApplyStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, String str) {
                    invoke(num.intValue(), num2.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, int i16, String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    ZootopiaResidenceAuthNotify zootopiaResidenceAuthNotify = ZootopiaResidenceAuthNotify.this;
                    int source = cVar.getSource();
                    HashMap hashMap = new HashMap();
                    c cVar2 = cVar;
                    hashMap.put("status", Integer.valueOf(i3));
                    hashMap.put("billNum", Long.valueOf(cVar2.getBillNum()));
                    Unit unit = Unit.INSTANCE;
                    zootopiaResidenceAuthNotify.k("get_apply_status", i16, errMsg, source, hashMap);
                }
            }, 8, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toBigIntegerOrNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void s(String paramsStr) {
        Long longOrNull;
        BigInteger bigIntegerOrNull;
        final d dVar = new d();
        if (!a.INSTANCE.a(paramsStr, dVar)) {
            l(this, "make_decision", -1, "parse params err", dVar.getSource(), null, 16, null);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            l(this, "make_decision", -1, "appInterface null", dVar.getSource(), null, 16, null);
            return;
        }
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaResidenceAuthNotify$makeAuthDecision$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                ZootopiaResidenceAuthNotify zootopiaResidenceAuthNotify = ZootopiaResidenceAuthNotify.this;
                int source = dVar.getSource();
                HashMap hashMap = new HashMap();
                hashMap.put("billNum", Long.valueOf(dVar.getBillNum()));
                Unit unit = Unit.INSTANCE;
                zootopiaResidenceAuthNotify.k("make_decision", i3, errMsg, source, hashMap);
            }
        };
        if (dVar.getSource() == 1) {
            com.tencent.mobileqq.zootopia.service.i iVar = new com.tencent.mobileqq.zootopia.service.i();
            String guildId = dVar.getGuildId();
            long longValue = (guildId == null || bigIntegerOrNull == null) ? 0L : bigIntegerOrNull.longValue();
            String channelId = dVar.getChannelId();
            long longValue2 = (channelId == null || longOrNull == null) ? 0L : longOrNull.longValue();
            iVar.j(appInterface, longValue, longValue2, dVar.getStatus(), dVar.getBillNum(), 0, function2);
            return;
        }
        new com.tencent.mobileqq.zootopia.service.i().k(appInterface, dVar.getStatus(), dVar.getBillNum(), 4, function2);
    }

    private final void t(String targetUin) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        FragmentSource fragmentSource = new FragmentSource(Source.SmallPanel, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, ZootopiaSource.SUB_SOURCE_ARK_XIAOWO, null, 4, null));
        QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
        FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        IZootopiaC2CApi.a.b((IZootopiaC2CApi) api, supportFragmentManager, targetUin, true, fragmentSource, 0, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        QBaseActivity qBaseActivity;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        final AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null || (qBaseActivity = QBaseActivity.sTopActivity) == null) {
            return;
        }
        final Resources resources = qBaseActivity.getResources();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ark.l
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaResidenceAuthNotify.v(AppInterface.this, resources);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AppInterface appInterface, Resources resources) {
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        QQToast.makeText(appInterface.getApp(), 1, resources.getString(R.string.xk9), 0).show();
    }

    private final void w(String paramsStr) {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (!(qBaseActivity instanceof Context)) {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            QLog.e("ZootopiaArkNotify", 1, "showExpiredDialog activity is not context");
            return;
        }
        final Resources resources = qBaseActivity.getResources();
        final e eVar = new e();
        if (!a.INSTANCE.a(paramsStr, eVar)) {
            QLog.e("ZootopiaArkNotify", 1, "ArkParams parse err");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ark.h
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaResidenceAuthNotify.x(qBaseActivity, eVar, resources);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void x(final Context context, final e params, Resources resources) {
        boolean z16;
        String expiredMsg;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(params, "$params");
        String expiredMsg2 = params.getExpiredMsg();
        if (expiredMsg2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(expiredMsg2);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    expiredMsg = resources.getString(R.string.xkb);
                } else {
                    expiredMsg = params.getExpiredMsg();
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, (String) null, expiredMsg, resources.getString(R.string.xk8), resources.getString(R.string.xk7), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ark.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ZootopiaResidenceAuthNotify.y(context, params, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ark.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ZootopiaResidenceAuthNotify.z(dialogInterface, i3);
                    }
                });
                createCustomDialog.setCancelable(false);
                createCustomDialog.show();
            }
        }
        z16 = true;
        if (!z16) {
        }
        QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(context, 0, (String) null, expiredMsg, resources.getString(R.string.xk8), resources.getString(R.string.xk7), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ark.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaResidenceAuthNotify.y(context, params, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.ark.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaResidenceAuthNotify.z(dialogInterface, i3);
            }
        });
        createCustomDialog2.setCancelable(false);
        createCustomDialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Context context, e params, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.i("ZootopiaArkNotify", 1, "showExpiredDialog onConfirm");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        if (params.getSource() == 1) {
            str = IZPlanApi.FROM_CHANNEL_ARK;
        } else {
            str = IZPlanApi.FROM_C2C_ARK;
        }
        iZPlanApi.startSettingActivity(context, str);
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String appName, String eventName, String params) {
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaArkNotify", 2, "notify --->  appName: " + appName + ", eventName: " + eventName + ", params: " + params);
        }
        if (!TextUtils.equals(appName, "com.tencent.zplan.homelimit") || eventName == null) {
            return true;
        }
        switch (eventName.hashCode()) {
            case -1407895670:
                if (!eventName.equals("show_expired_info")) {
                    return true;
                }
                w(params);
                return true;
            case 285584991:
                if (!eventName.equals("enter_residence")) {
                    return true;
                }
                q(params);
                return true;
            case 292169772:
                if (!eventName.equals("get_apply_status")) {
                    return true;
                }
                r(params);
                return true;
            case 1002907405:
                if (!eventName.equals("make_decision")) {
                    return true;
                }
                s(params);
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DialogInterface dialogInterface, int i3) {
        QLog.i("ZootopiaArkNotify", 1, "showExpiredDialog onCancel");
    }

    static /* synthetic */ void l(ZootopiaResidenceAuthNotify zootopiaResidenceAuthNotify, String str, int i3, String str2, int i16, Map map, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            map = null;
        }
        zootopiaResidenceAuthNotify.k(str, i3, str2, i16, map);
    }
}
