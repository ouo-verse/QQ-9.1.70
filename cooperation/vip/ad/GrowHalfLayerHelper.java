package cooperation.vip.ad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.data.dt.QQDtConfigHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J*\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J$\u0010\u0011\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\"\u0010\u001b\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001b\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001dJ\f\u0010\u001f\u001a\u00020\u0004*\u00020\u000eH\u0002J\f\u0010 \u001a\u00020\b*\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0004H\u0007J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010#\u001a\u00020\fJ<\u0010'\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010$2\b\b\u0002\u0010&\u001a\u00020\u0004R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "w", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "", "traceId", "", "adSpaceId", "", "g", "Lcooperation/vip/ad/GrowHalfLayerInfo;", "growHalfLayerInfo", "ignoreSplashAndConversion", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", HippyTKDListViewAdapter.X, "", PoiListCacheRecord.TIMESTAMP, "timestamp2", "e", "Lcooperation/vip/ad/GrowHalfLayerTechInfo;", "techInfo", DomainData.DOMAIN_NAME, "k", "(Lcooperation/vip/ad/GrowHalfLayerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "j", "v", tl.h.F, "f", "o", "", "extInfo", "clickOtherNoDismiss", "t", "b", "Lcooperation/vip/ad/GrowHalfLayerInfo;", "growHalfLayerInfoCache", "c", "Z", "i", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "isShowingGrowHalfLayer", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class GrowHalfLayerHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GrowHalfLayerHelper f391021a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GrowHalfLayerInfo growHalfLayerInfoCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowingGrowHalfLayer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016JT\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"cooperation/vip/ad/GrowHalfLayerHelper$a", "Lcom/tencent/hippy/qq/api/IUpdateListener;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "bundleName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateJSCosts", "", "onUpdateSuccess", "retCode", "errMsg", "onUpdateFailed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class a implements IUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GrowHalfLayerInfo f391024a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Integer> f391025b;

        /* JADX WARN: Multi-variable type inference failed */
        a(GrowHalfLayerInfo growHalfLayerInfo, CancellableContinuation<? super Integer> cancellableContinuation) {
            this.f391024a = growHalfLayerInfo;
            this.f391025b = cancellableContinuation;
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int requestId, int retCode, @Nullable String errMsg, @Nullable String bundleName, @Nullable HashMap<String, String> updateJSCosts) {
            if (retCode == 0) {
                retCode = 20230726;
            }
            if (retCode == 1) {
                int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.f391024a.getHippyJsBundleName());
                QLog.i("GrowHalfLayerUtils", 1, "updateJsBundle, current is newest, adId = " + this.f391024a.getAdId() + ", bundleName=" + bundleName + ", version=" + moduleVersion);
                CancellableContinuation<Integer> cancellableContinuation = this.f391025b;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(0));
                return;
            }
            QLog.e("GrowHalfLayerUtils", 1, "updateJsBundle failed, adId = " + this.f391024a.getAdId() + ", bundleName=" + bundleName + ", retCode=" + retCode + ", errMsg=" + errMsg);
            this.f391025b.resumeWith(Result.m476constructorimpl(Integer.valueOf(retCode)));
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int requestId, @Nullable String bundleName, @Nullable HashMap<String, String> updateJSCosts) {
            QLog.i("GrowHalfLayerUtils", 1, "updateJsBundle Success, version=" + ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.f391024a.getHippyJsBundleName()) + ", adId = " + this.f391024a.getAdId() + ", bundleName=" + bundleName);
            CancellableContinuation<Integer> cancellableContinuation = this.f391025b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(0));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"cooperation/vip/ad/GrowHalfLayerHelper$b", "Lcom/tencent/hippy/qq/api/LibraryLoadListener;", "", "onLoadSuccess", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "onLoadFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public static final class b implements LibraryLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GrowHalfLayerInfo f391026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Integer> f391027b;

        /* JADX WARN: Multi-variable type inference failed */
        b(GrowHalfLayerInfo growHalfLayerInfo, CancellableContinuation<? super Integer> cancellableContinuation) {
            this.f391026a = growHalfLayerInfo;
            this.f391027b = cancellableContinuation;
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadFail(int statusCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (statusCode == 0) {
                statusCode = 20230726;
            }
            QLog.e("GrowHalfLayerUtils", 1, "loadSo onLoadFail, adId = " + this.f391026a.getAdId() + ", statusCode=" + statusCode + ", errorMsg=" + errorMsg);
            this.f391027b.resumeWith(Result.m476constructorimpl(Integer.valueOf(statusCode)));
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadSuccess() {
            QLog.i("GrowHalfLayerUtils", 1, "loadSo onLoadSuccess, adId = " + this.f391026a.getAdId() + ", bundleName=" + this.f391026a.getHippyJsBundleName());
            CancellableContinuation<Integer> cancellableContinuation = this.f391027b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(0));
        }
    }

    static {
        GrowHalfLayerHelper growHalfLayerHelper = new GrowHalfLayerHelper();
        f391021a = growHalfLayerHelper;
        growHalfLayerHelper.x();
    }

    GrowHalfLayerHelper() {
    }

    private final boolean e(long timestamp1, long timestamp2) {
        long j3 = 86400;
        if (timestamp1 / j3 == timestamp2 / j3) {
            return true;
        }
        return false;
    }

    private final boolean f(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void g(@NotNull TianShuAccess.AdItem adItem, @Nullable Activity activity, @NotNull String traceId, int adSpaceId) {
        Intrinsics.checkNotNullParameter(adItem, "adItem");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        GrowHalfLayerHelper growHalfLayerHelper = f391021a;
        if (growHalfLayerHelper.f(activity)) {
            QLog.i("GrowHalfLayerUtils", 1, "handleGrowHalfLayer activity invalid");
            return;
        }
        QLog.i("GrowHalfLayerUtils", 1, "handleGrowHalfLayer, adItemInfo=" + growHalfLayerHelper.v(adItem));
        GrowHalfLayerInfo u16 = u(growHalfLayerHelper, adItem, traceId, adSpaceId, null, false, 12, null);
        GrowHalfLayerTechReporter.f391039a.h(u16.getTraceId(), u16.getAdId());
        s(activity, u16, false, 4, null);
    }

    @JvmStatic
    public static final boolean h() {
        SplashActivity splashActivity;
        FrameFragment frameFragment;
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        Conversation conversation = null;
        if (weakReference != null) {
            splashActivity = weakReference.get();
        } else {
            splashActivity = null;
        }
        if (splashActivity == null) {
            QLog.e("GrowHalfLayerUtils", 1, "isConversationVisible, splashActivity is null");
            return false;
        }
        Fragment findFragmentByTag = splashActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof FrameFragment) {
            frameFragment = (FrameFragment) findFragmentByTag;
        } else {
            frameFragment = null;
        }
        if (frameFragment == null) {
            QLog.e("GrowHalfLayerUtils", 1, "isConversationVisible, frameFragment is null");
            return false;
        }
        be frame = frameFragment.getFrame(Conversation.class);
        if (frame instanceof Conversation) {
            conversation = (Conversation) frame;
        }
        if (conversation == null) {
            QLog.e("GrowHalfLayerUtils", 1, "isConversationVisible, conversation is null");
            return false;
        }
        return conversation.isOnlyInConversationList();
    }

    private final boolean j(GrowHalfLayerInfo growHalfLayerInfo) {
        boolean z16;
        boolean z17;
        if (growHalfLayerInfo.getAdId() <= 0) {
            QLog.i("GrowHalfLayerUtils", 1, "adId invalid, adId=" + growHalfLayerInfo.getAdId());
            return false;
        }
        if (growHalfLayerInfo.getHippyJsBundleName().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("GrowHalfLayerUtils", 1, "hippyJsBundleName invalid, hippyJsBundleName=" + growHalfLayerInfo.getHippyJsBundleName());
            return false;
        }
        if (growHalfLayerInfo.getHippyJsBundleType().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QLog.i("GrowHalfLayerUtils", 1, "hippyJsBundleType invalid, hippyJsBundleType=" + growHalfLayerInfo.getHippyJsBundleType());
            return false;
        }
        if (growHalfLayerInfo.getHippyHeightStrategy() != 1 && growHalfLayerInfo.getHippyHeightStrategy() != 2) {
            QLog.i("GrowHalfLayerUtils", 1, "hippyHeightStrategy invalid, hippyHeightStrategy=" + growHalfLayerInfo.getHippyHeightStrategy());
            return false;
        }
        if (growHalfLayerInfo.getHippyHeightStrategy() == 1 && growHalfLayerInfo.getHippyHeight() <= 0) {
            QLog.i("GrowHalfLayerUtils", 1, "hippyHeight invalid, hippyHeight=" + growHalfLayerInfo.getHippyHeight());
            return false;
        }
        if (growHalfLayerInfo.getHippyHeightStrategy() != 2 || growHalfLayerInfo.getHippyAspectRatio() > 0.0f) {
            return true;
        }
        QLog.i("GrowHalfLayerUtils", 1, "hippyAspectRatio invalid, hippyAspectRatio=" + growHalfLayerInfo.getHippyAspectRatio());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(GrowHalfLayerInfo growHalfLayerInfo, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Bundle bundle = new Bundle();
        bundle.putString("reportFrom", "GrowHalfLayer");
        bundle.putBoolean(IHippyUpdate.EXTRA_KEY_IS_SKIP_INTERVAL, true);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).updateJsBundle(growHalfLayerInfo.getHippyJsBundleName(), ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, bundle, new a(growHalfLayerInfo, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(GrowHalfLayerInfo growHalfLayerInfo, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(new b(growHalfLayerInfo, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @JvmStatic
    public static final void m() {
        f391021a.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Activity activity, GrowHalfLayerInfo growHalfLayerInfo, GrowHalfLayerTechInfo techInfo) {
        if (f(activity)) {
            o();
            QLog.e("GrowHalfLayerUtils", 1, "realStartGrowHalfLayer activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("grow_half_layer_info", growHalfLayerInfo);
        intent.putExtra("grow_half_layer_tech_info", techInfo);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, GrowHalfLayerContainerFragment.class);
        o.d(growHalfLayerInfo.getAdId());
        o.c(growHalfLayerInfo.getAdId());
        p(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(GrowHalfLayerInfo growHalfLayerInfo) {
        growHalfLayerInfoCache = growHalfLayerInfo;
        o.f391192a.i(growHalfLayerInfoCache);
    }

    @JvmStatic
    public static final void r(@Nullable Activity activity, @NotNull GrowHalfLayerInfo growHalfLayerInfo, boolean ignoreSplashAndConversion) {
        Intrinsics.checkNotNullParameter(growHalfLayerInfo, "growHalfLayerInfo");
        GrowHalfLayerHelper growHalfLayerHelper = f391021a;
        if (growHalfLayerHelper.f(activity)) {
            QLog.i("GrowHalfLayerUtils", 1, "startGrowHalfLayer activity invalid");
            return;
        }
        if (!growHalfLayerHelper.j(growHalfLayerInfo)) {
            GrowHalfLayerTechReporter.f391039a.j(growHalfLayerInfo.getTraceId(), growHalfLayerInfo.getAdId(), 101);
            QLog.i("GrowHalfLayerUtils", 1, "handleGrowHalfLayer invalid growHalfLayerInfo");
            return;
        }
        if ((!com.tencent.mobileqq.splashad.l.l() || ignoreSplashAndConversion) && QQDtConfigHelper.INSTANCE.l() && !AppSetting.f99565y) {
            o.h(growHalfLayerInfo.getAdId());
            long j3 = o.j(growHalfLayerInfo.getAdId());
            long f16 = o.f(growHalfLayerInfo.getAdId());
            GrowHalfLayerTechReporter growHalfLayerTechReporter = GrowHalfLayerTechReporter.f391039a;
            String valueOf = String.valueOf(growHalfLayerInfo.getAdId());
            long currentTimeMillis = System.currentTimeMillis();
            growHalfLayerTechReporter.d(valueOf, growHalfLayerInfo.getHippyJsBundleName(), String.valueOf(o.g(growHalfLayerInfo.getAdId())), h(), currentTimeMillis);
            CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
            if (f17 != null) {
                CorountineFunKt.e(f17, "GrowHalfLayerUtils", null, null, null, new GrowHalfLayerHelper$startGrowHalfLayer$1(growHalfLayerInfo, ignoreSplashAndConversion, j3, f16, activity, null), 14, null);
                return;
            }
            return;
        }
        GrowHalfLayerTechReporter.f391039a.j(growHalfLayerInfo.getTraceId(), growHalfLayerInfo.getAdId(), 4);
        growHalfLayerHelper.p(growHalfLayerInfo);
        w.d(String.valueOf(growHalfLayerInfo.getAdId()), 213, growHalfLayerInfo.getTraceInfo());
        QLog.i("GrowHalfLayerUtils", 1, "handleGrowHalfLayer intercept by bizSplash, or start from push");
    }

    public static /* synthetic */ void s(Activity activity, GrowHalfLayerInfo growHalfLayerInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        r(activity, growHalfLayerInfo, z16);
    }

    public static /* synthetic */ GrowHalfLayerInfo u(GrowHalfLayerHelper growHalfLayerHelper, TianShuAccess.AdItem adItem, String str, int i3, Map map, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            map = null;
        }
        Map map2 = map;
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        return growHalfLayerHelper.t(adItem, str, i3, map2, z16);
    }

    private final String v(TianShuAccess.AdItem adItem) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("adId=");
        sb5.append(adItem.iAdId.get());
        sb5.append(",");
        List<TianShuAccess.MapEntry> list = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(list, "argList.get()");
        for (TianShuAccess.MapEntry mapEntry : list) {
            if (Intrinsics.areEqual(mapEntry.key.get(), "busi_data")) {
                sb5.append("busi_data_length=");
                sb5.append(mapEntry.value.get().length());
                sb5.append(",");
            } else {
                sb5.append(mapEntry.key.get());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(mapEntry.value.get());
                sb5.append(",");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "logBuilder.toString()");
        return sb6;
    }

    @JvmStatic
    public static final boolean w(@Nullable Activity activity) {
        GrowHalfLayerInfo growHalfLayerInfo = growHalfLayerInfoCache;
        if (growHalfLayerInfo == null) {
            return false;
        }
        GrowHalfLayerHelper growHalfLayerHelper = f391021a;
        if (growHalfLayerHelper.f(activity)) {
            QLog.i("GrowHalfLayerUtils", 1, "triggerShowHalfLayerAd activity invalid");
            return false;
        }
        if (!growHalfLayerHelper.e(growHalfLayerInfo.getAdTimestamp(), NetConnInfoCenter.getServerTime())) {
            growHalfLayerHelper.p(null);
            QLog.i("GrowHalfLayerUtils", 1, "triggerShowHalfLayerAd areTimestampsInSameDay cache " + growHalfLayerInfo.getAdTimestamp());
            return false;
        }
        GrowHalfLayerTechReporter.f391039a.e(growHalfLayerInfo.getTraceId(), growHalfLayerInfo.getAdId());
        s(activity, growHalfLayerInfo, false, 4, null);
        QLog.i("GrowHalfLayerUtils", 1, "triggerShowHalfLayerAd startGrowHalfLayer cache " + growHalfLayerInfo);
        return true;
    }

    private final void x() {
        growHalfLayerInfoCache = o.f391192a.e();
    }

    public final boolean i() {
        return isShowingGrowHalfLayer;
    }

    public final void o() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("grow_half_only_show_one", true)) {
            isShowingGrowHalfLayer = false;
        }
    }

    public final void q(boolean z16) {
        isShowingGrowHalfLayer = z16;
    }

    @NotNull
    public final GrowHalfLayerInfo t(@NotNull TianShuAccess.AdItem adItem, @NotNull String traceId, int i3, @Nullable Map<String, String> map, boolean z16) {
        List split$default;
        Integer intOrNull;
        List split$default2;
        Integer intOrNull2;
        int i16;
        Integer intOrNull3;
        int i17;
        Integer intOrNull4;
        Intrinsics.checkNotNullParameter(adItem, "<this>");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        List<TianShuAccess.MapEntry> list = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(list, "argList.get()");
        Object obj = "";
        int i18 = 0;
        int i19 = 0;
        float f16 = 0.0f;
        Object obj2 = "";
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            if (str != null) {
                switch (str.hashCode()) {
                    case -216377279:
                        if (str.equals("hippy_bundle_name")) {
                            String str2 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
                            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"@"}, false, 0, 6, (Object) null);
                            if (split$default.size() == 2) {
                                obj = split$default.get(0);
                                obj2 = split$default.get(1);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 390938404:
                        if (str.equals("hippy_height_strategy")) {
                            String str3 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str3, "it.value.get()");
                            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
                            if (intOrNull != null) {
                                i18 = intOrNull.intValue();
                                break;
                            } else {
                                i18 = 0;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 777540715:
                        if (str.equals("hippy_aspect_ratio")) {
                            String str4 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str4, "it.value.get()");
                            split$default2 = StringsKt__StringsKt.split$default((CharSequence) str4, new String[]{HippyTKDListViewAdapter.X}, false, 0, 6, (Object) null);
                            if (split$default2.size() != 2) {
                                break;
                            } else {
                                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default2.get(0));
                                if (intOrNull2 != null) {
                                    i16 = intOrNull2.intValue();
                                } else {
                                    i16 = 0;
                                }
                                intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default2.get(1));
                                if (intOrNull3 != null) {
                                    i17 = intOrNull3.intValue();
                                } else {
                                    i17 = 0;
                                }
                                if (i16 != 0 && i17 != 0) {
                                    f16 = i16 / i17;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 1646350702:
                        if (str.equals("hippy_height")) {
                            String str5 = mapEntry.value.get();
                            Intrinsics.checkNotNullExpressionValue(str5, "it.value.get()");
                            intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull(str5);
                            if (intOrNull4 != null) {
                                i19 = intOrNull4.intValue();
                                break;
                            } else {
                                i19 = 0;
                                break;
                            }
                        } else {
                            break;
                        }
                }
            }
            jSONObject.put(mapEntry.key.get(), mapEntry.value.get());
        }
        String str6 = adItem.traceinfo.get();
        Intrinsics.checkNotNullExpressionValue(str6, "traceinfo.get()");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "allAdJsonInfo.toString()");
        return new GrowHalfLayerInfo(adItem.iAdId.get(), (String) obj, (String) obj2, i18, i19, f16, str6, jSONObject2, NetConnInfoCenter.getServerTime(), traceId, i3, z16);
    }
}
