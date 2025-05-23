package lz3;

import android.app.Application;
import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.BaseProto$PullTarget;
import com.tencent.rdelivery.net.BaseProto$ServerType;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.TargetType;
import com.tencent.rdelivery.reshub.api.r;
import com.tencent.rdelivery.util.RDeliveryConstant$DataLoadMode;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J(\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Llz3/g;", "", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "Liz3/e;", "listener", "Lcom/tencent/rdelivery/reshub/api/r;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/rdelivery/RDelivery;", "b", "Landroid/content/Context;", "context", "", "userId", "Lcom/tencent/rdelivery/RDeliverySetting;", "d", MosaicConstants$JsProperty.PROP_ENV, "a", "Lcom/tencent/rdelivery/a;", "c", "Lcom/tencent/rdelivery/reshub/api/TargetType;", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "f", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mmkvInited", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f415854b = new g();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean mmkvInited = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"lz3/g$a", "Liz3/h;", "", "onInitFinish", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements iz3.h {
        a() {
        }

        @Override // iz3.h
        public void onInitFinish() {
            jz3.d.e("RDeliveryConfig", "RDelivery Configs Loaded.");
        }
    }

    g() {
    }

    private final String a(String env) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(env);
        if (!isBlank && !Intrinsics.areEqual(env, TPReportKeys.Common.COMMON_ONLINE)) {
            return env;
        }
        return (String) RDelivery.INSTANCE.b();
    }

    private final RDelivery b(com.tencent.rdelivery.reshub.core.a appInfo, iz3.e listener, r extraParams) {
        String str;
        String str2;
        ResHubParams resHubParams;
        String deviceId;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        Application d16 = jVar.d();
        if (jVar.S()) {
            str = jVar.w().getDeviceId();
        } else {
            str = "";
        }
        if (extraParams != null && (resHubParams = extraParams.getResHubParams()) != null && (deviceId = resHubParams.getDeviceId()) != null) {
            str2 = deviceId;
        } else {
            str2 = str;
        }
        RDeliverySetting d17 = d(d16, appInfo, str2, listener, extraParams);
        if (jVar.s() && !mmkvInited.getAndSet(true)) {
            MMKV.T(d16);
        }
        RDelivery a16 = RDelivery.INSTANCE.a(d16, d17, c(d16), new a());
        jz3.d.e("RDeliveryConfig", "RDelivery Inited. ID: " + str2);
        return a16;
    }

    private final com.tencent.rdelivery.a c(Context context) {
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        IRNetwork v3 = jVar.v();
        IRStorage.IRStorageFactory z16 = jVar.z();
        IRTask A = jVar.A();
        if (A == null) {
            A = new com.tencent.rdelivery.dependencyimpl.a();
        }
        return new com.tencent.rdelivery.a(v3, z16, A, new e());
    }

    private final RDeliverySetting d(Context context, com.tencent.rdelivery.reshub.core.a appInfo, String userId, iz3.e listener, r extraParams) {
        boolean z16;
        ResHubParams resHubParams;
        Map<String, String> plus;
        RDeliveryConstant$DataLoadMode rDeliveryConstant$DataLoadMode;
        ResHubParams resHubParams2;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        String bundleId = jVar.y();
        boolean z17 = false;
        if (bundleId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bundleId = context.getPackageName();
        }
        if (jVar.S()) {
            resHubParams = jVar.w();
        } else {
            resHubParams = new ResHubParams("", "", false, null, false, false, null, null, 0, 0, false, null, null, false, 16380, null);
        }
        if (extraParams != null && (resHubParams2 = extraParams.getResHubParams()) != null) {
            resHubParams = resHubParams2;
        }
        if (Intrinsics.areEqual(resHubParams.getAppVersion(), "")) {
            jz3.d.e("RDeliveryConfig", "reshub params.appVersion is empty");
        }
        int configUpdateStrategy = resHubParams.getConfigUpdateStrategy();
        int configUpdateInterval = resHubParams.getConfigUpdateInterval();
        Map<String, String> l3 = resHubParams.l();
        if (resHubParams.getIsRdmTest()) {
            l3 = MapsKt__MapsKt.plus(l3, new Pair("is_debug", "1"));
        }
        plus = MapsKt__MapsKt.plus(l3, new Pair("reshubSdkVersion", "1.8.18-RC02"));
        RDeliverySetting.a f06 = new RDeliverySetting.a().N(appInfo.c()).O(appInfo.getCom.heytap.mcssdk.a.a.l java.lang.String()).n0(userId).i0(userId).f0(Boolean.valueOf(resHubParams.getIsRdmTest()));
        Boolean enableRecordLastRequestTime = resHubParams.getEnableRecordLastRequestTime();
        if (enableRecordLastRequestTime != null) {
            z17 = enableRecordLastRequestTime.booleanValue();
        }
        RDeliverySetting.a l06 = f06.b0(z17).m0(Integer.valueOf(configUpdateStrategy)).l0(configUpdateInterval);
        Intrinsics.checkExpressionValueIsNotNull(bundleId, "bundleId");
        RDeliverySetting.a c06 = l06.P(bundleId).e0(resHubParams.getIs64Bit()).d0(resHubParams.getAppVersion()).h0(f(appInfo.getTarget())).k0("10010").g0(a(appInfo.i())).S(plus).j0(lz3.a.f415844d).c0(listener);
        if (resHubParams.getEnableLazyLoadInnerConfig()) {
            rDeliveryConstant$DataLoadMode = RDeliveryConstant$DataLoadMode.LAZY_LOAD;
        } else {
            rDeliveryConstant$DataLoadMode = RDeliveryConstant$DataLoadMode.INITIAL_LOAD;
        }
        RDeliverySetting.a U = c06.U(rDeliveryConstant$DataLoadMode);
        String businessSetName = appInfo.getBusinessSetName();
        if (businessSetName != null) {
            jz3.d.e("RDeliveryConfig", "reshub setBusinessSetName name = " + businessSetName);
            U.Q(businessSetName);
        }
        if (jVar.H()) {
            U.R(resHubParams.getConfigStoreSuffix());
        }
        if (jVar.B()) {
            U.T(BaseProto$ServerType.TEST);
        }
        return U.a();
    }

    private final BaseProto$PullTarget f(@NotNull TargetType targetType) {
        int i3 = f.f415852a[targetType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return BaseProto$PullTarget.PROJECT;
            }
            throw new NoWhenBranchMatchedException();
        }
        return BaseProto$PullTarget.APP;
    }

    @Nullable
    public final RDelivery e(@NotNull com.tencent.rdelivery.reshub.core.a appInfo, @Nullable iz3.e listener, @Nullable r extraParams) {
        Object m476constructorimpl;
        Object obj;
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(f415854b.b(appInfo, listener, extraParams));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            obj = null;
        } else {
            obj = m476constructorimpl;
        }
        RDelivery rDelivery = (RDelivery) obj;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.d("RDeliveryConfig", "RDelivery Init Fail.", m479exceptionOrNullimpl);
        }
        return rDelivery;
    }
}
