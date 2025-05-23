package com.tencent.mobileqq.zplan.emoticon.tab.manager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import androidx.exifinterface.media.ExifInterface;
import by4.ZPlanRecordResourceStatistic;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.tab.model.ZPlanEmoticonAvatarIconStatus;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonAvatarIconConfig;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import nh3.ZPlanEmoticonAvatarIconReportParams;
import wx4.d;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\n\u0010!\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020#H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0015\u0010(\u001a\u0004\u0018\u00010\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010\u00162\u0006\u0010*\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\tH\u0002J\b\u0010.\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\tH\u0002J\u0018\u00104\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u001d2\u0006\u00103\u001a\u000202H\u0002R\u0016\u00106\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00104R\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/tab/manager/ZPlanEmoticonTabAvatarManager;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/image/URLImageView;", "tabImageViewRef", "", "O", "", "needExpose", "Lcom/tencent/mobileqq/zplan/emoticon/tab/model/ZPlanEmoticonAvatarIconStatus;", "D", "H", "isZplan", "J", "G", "L", BdhLogUtil.LogTag.Tag_Conn, "tabView", "P", "tabImageView", "Landroid/graphics/drawable/Drawable;", "drawable", "M", "source", "p", UserInfo.SEX_FEMALE, "u", "", "localPath", BdhLogUtil.LogTag.Tag_Req, "v", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "t", "y", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "B", HippyTKDListViewAdapter.X, "E", "r", "needShake", ExifInterface.LATITUDE_SOUTH, AdMetricTag.EVENT_NAME, "Lnh3/a;", "params", "I", "b", "hitCloudCache", "c", "isSelected", "Lcom/tencent/zplan/record/model/c;", "d", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/zplan/record/model/c;", "recordSwitches", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonTabAvatarManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEmoticonTabAvatarManager f333345a = new ZPlanEmoticonTabAvatarManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int hitCloudCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int isSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy recordSwitches;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GeneralRecordSwitches>() { // from class: com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$recordSwitches$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GeneralRecordSwitches invoke() {
                return ZPlanQQMC.INSTANCE.getGeneralRecordSwitchesByScene(ZPlanRecordScene.EMOTICON_TAB_ICON);
            }
        });
        recordSwitches = lazy;
    }

    ZPlanEmoticonTabAvatarManager() {
    }

    private final GeneralRecordSwitches A() {
        return (GeneralRecordSwitches) recordSwitches.getValue();
    }

    private final Drawable B(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable q16 = q();
        obtain.mFailedDrawable = q16;
        obtain.mLoadingDrawable = q16;
        if (HttpUtil.isValidUrl(url)) {
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            boolean z16 = false;
            if (drawable != null && drawable.getStatus() == 2) {
                z16 = true;
            }
            if (!z16) {
                return drawable;
            }
            drawable.restartDownload();
            return drawable;
        }
        if (com.tencent.zplan.common.utils.c.f385288a.h(url)) {
            return URLDrawable.getFileDrawable(url, obtain);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        String e16 = bb.f335811a.e();
        if (TextUtils.isEmpty(e16)) {
            return false;
        }
        IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
        Intrinsics.checkNotNull(e16);
        ZPlanUserInfo userZPlanInfoFromCache = iZPlanDataHelper.getUserZPlanInfoFromCache(e16);
        if (userZPlanInfoFromCache == null) {
            return true;
        }
        if (!TextUtils.isEmpty(userZPlanInfoFromCache.appearanceKey) && !Intrinsics.areEqual("zplan_default_appearance_key", userZPlanInfoFromCache.appearanceKey)) {
            return false;
        }
        QLog.d("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "[getIsZplanHasDefaultAppearance] zplan has default appearanceKey");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K() {
        int i3 = isSelected;
        d.Companion companion = d.INSTANCE;
        ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager = f333345a;
        ZPlanEmoticonAvatarIconReportParams zPlanEmoticonAvatarIconReportParams = new ZPlanEmoticonAvatarIconReportParams(i3, companion.b(!zPlanEmoticonTabAvatarManager.E()), hitCloudCache, "2", ZPlanEmoticonUtil.f333176e.E());
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "reportDtImpEvent params:" + zPlanEmoticonAvatarIconReportParams);
        zPlanEmoticonTabAvatarManager.I("ev_zplan_emote_tab_imp", zPlanEmoticonAvatarIconReportParams);
    }

    private final void L(CoroutineScope scope, WeakReference<URLImageView> tabImageViewRef) {
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1(tabImageViewRef.get(), scope, tabImageViewRef, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(final URLImageView tabImageView, Drawable drawable) {
        final Drawable p16 = p(drawable);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.tab.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonTabAvatarManager.N(URLImageView.this, p16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(URLImageView uRLImageView, Drawable textDrawable) {
        Intrinsics.checkNotNullParameter(textDrawable, "$textDrawable");
        if (f333345a.F(uRLImageView)) {
            Intrinsics.checkNotNull(uRLImageView);
            uRLImageView.setImageDrawable(textDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "$animatorSet");
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "startShaking isZPlanEmoticonPanelShown? " + zPlanEmoticonUtil.H());
        if (zPlanEmoticonUtil.H()) {
            animatorSet.start();
            f333345a.S(false);
        }
    }

    private final void R(String localPath) {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(e16 + "zplan_emoticon_last_appearance_path", localPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(boolean needShake) {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "updateNeedShakeStatusToMMKV needShake? " + needShake);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(e16 + "zplan_emoticon_need_shake_status", needShake);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable q() {
        Drawable drawable = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDrawable(t() == 1 ? R.drawable.ife : R.drawable.ifd);
        Intrinsics.checkNotNullExpressionValue(drawable, "sMobileQQ.applicationCon\u2026s.getDrawable(backupIcon)");
        return drawable;
    }

    private final boolean r() {
        return ZPlanFeatureSwitch.f369852a.v() && D(true) != ZPlanEmoticonAvatarIconStatus.RegularIcon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(Continuation<? super Drawable> continuation) {
        ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1 zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1;
        Object coroutine_suspended;
        int i3;
        List<? extends Source> listOf;
        ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager;
        String localPath;
        ZPlanRecordResourceStatistic statistic;
        if (continuation instanceof ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1) {
            zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1 = (ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1) continuation;
            int i16 = zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SingleRecordRequestParams z16 = z();
                    if (z16 == null) {
                        return null;
                    }
                    if (!A().getCloudSwitches().getEnableCloudCache()) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(Source.LOCAL_CACHE);
                    } else {
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE});
                    }
                    ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
                    zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.L$0 = this;
                    zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.label = 1;
                    obj = zPlanRecordResourceCenter.h(z16, listOf, zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanEmoticonTabAvatarManager = this;
                } else if (i3 == 1) {
                    zPlanEmoticonTabAvatarManager = (ZPlanEmoticonTabAvatarManager) zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
                localPath = zPlanRecordResource == null ? zPlanRecordResource.getLocalPath() : null;
                statistic = zPlanRecordResource == null ? zPlanRecordResource.getStatistic() : null;
                QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getFileOrCloudCacheAvatarIcon cachePath:" + localPath + " source:" + (statistic == null ? statistic.getSource() : null));
                if ((statistic == null ? statistic.getSource() : null) == Source.CLOUD_CACHE) {
                    hitCloudCache = 1;
                }
                if (localPath != null) {
                    return null;
                }
                zPlanEmoticonTabAvatarManager.R(localPath);
                return zPlanEmoticonTabAvatarManager.B(localPath);
            }
        }
        zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1 = new ZPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1(this, continuation);
        Object obj2 = zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanEmoticonTabAvatarManager$getFileOrCloudCacheAvatarIcon$1.label;
        if (i3 != 0) {
        }
        ZPlanRecordResource zPlanRecordResource2 = (ZPlanRecordResource) obj2;
        if (zPlanRecordResource2 == null) {
        }
        if (zPlanRecordResource2 == null) {
        }
        if (statistic == null) {
        }
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getFileOrCloudCacheAvatarIcon cachePath:" + localPath + " source:" + (statistic == null ? statistic.getSource() : null));
        if ((statistic == null ? statistic.getSource() : null) == Source.CLOUD_CACHE) {
        }
        if (localPath != null) {
        }
    }

    private final int t() {
        bb bbVar = bb.f335811a;
        String e16 = bbVar.e();
        if (E()) {
            return bbVar.k(e16);
        }
        return bbVar.o(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable u() {
        String v3 = v();
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getLastAppearanceDrawable lastAppearancePath:" + v3);
        if (v3.length() > 0) {
            return B(v3);
        }
        return null;
    }

    private final String v() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(e16 + "zplan_emoticon_last_appearance_path", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable w() {
        String e16 = bb.f335811a.e();
        if (e16 == null || e16.length() == 0) {
            QLog.e("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getMemeCacheAvatarIcon invalid uin");
            return null;
        }
        ZPlanEmoticonAvatarIconConfig l16 = ZPlanFeatureSwitch.f369852a.l1();
        File record = MemeHelper.INSTANCE.getRecord(new MemeZPlanAction(l16.getActionId(), 1, l16.getAvatarSize(), l16.getAvatarSize(), MODE.FRAME, e16));
        String absolutePath = record != null ? record.getAbsolutePath() : null;
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getMemeCacheAvatarIcon cachePath:" + absolutePath);
        if (absolutePath == null) {
            return null;
        }
        R(absolutePath);
        return B(absolutePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        boolean z16 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(e16 + "zplan_emoticon_need_shake_status", false);
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getNeedShakeStatusFromMMKV needShake? " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable y() {
        boolean z16;
        try {
            int t16 = t();
            ZPlanEmoticonAvatarIconConfig l16 = ZPlanFeatureSwitch.f369852a.l1();
            String defaultMaleUrl = l16.getDefaultMaleUrl();
            String defaultFemaleUrl = l16.getDefaultFemaleUrl();
            boolean z17 = false;
            if (defaultFemaleUrl != null) {
                if (defaultFemaleUrl.length() > 0) {
                    z16 = true;
                    if (z16) {
                        return null;
                    }
                    if (defaultMaleUrl != null) {
                        if (defaultMaleUrl.length() > 0) {
                            z17 = true;
                        }
                    }
                    if (!z17) {
                        return null;
                    }
                    if (Intrinsics.areEqual(defaultFemaleUrl, "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultFemaleMemeIcon.png") && Intrinsics.areEqual(defaultMaleUrl, "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultMaleMemeIcon.png")) {
                        return null;
                    }
                    if (t16 != 1) {
                        defaultMaleUrl = defaultFemaleUrl;
                    }
                    Drawable B = B(defaultMaleUrl);
                    if (B == null) {
                        return null;
                    }
                    QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getBackupDrawable use net pic");
                    return B;
                }
            }
            z16 = false;
            if (z16) {
            }
        } catch (Throwable th5) {
            QLog.e("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getNetBackupDrawable error" + th5);
            return null;
        }
    }

    private final SingleRecordRequestParams z() {
        String e16 = bb.f335811a.e();
        if (e16 == null || e16.length() == 0) {
            QLog.e("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getRecordResourceParams invalid uin");
            return null;
        }
        ZPlanEmoticonAvatarIconConfig l16 = ZPlanFeatureSwitch.f369852a.l1();
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        EngineType h06 = zPlanEmoticonUtil.h0(A().getRenderSwitches());
        int actionId = l16.getActionId();
        String str = null;
        int avatarSize = l16.getAvatarSize();
        int avatarSize2 = l16.getAvatarSize();
        MODE mode = MODE.FRAME;
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
        businessConfig.C(BusinessConfig.FrameType.PNG);
        businessConfig.y(0);
        if (h06 != null) {
            businessConfig.G(h06);
            businessConfig.A(businessConfig.getTargetEngine() instanceof EngineType.Filament ? Boolean.TRUE : null);
        }
        businessConfig.z(Boolean.valueOf(f333345a.A().getRenderSwitches().getDisableGlassesMetallic()));
        Unit unit = Unit.INSTANCE;
        return new SingleRecordRequestParams(actionId, e16, str, avatarSize, avatarSize2, mode, businessConfig, 2, AppTheme.DAY, Priority.HIGH, zPlanEmoticonUtil.g0(A().getCloudSwitches()), null, 0, false, null, null, 63488, null);
    }

    public final ZPlanEmoticonAvatarIconStatus D(boolean needExpose) {
        ExpEntityInfo expEntity;
        if (!ZPlanFeatureSwitch.f369852a.v()) {
            return ZPlanEmoticonAvatarIconStatus.RegularIcon;
        }
        if (E()) {
            expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_ZPLAN_EMOTICON_AVATAR_ICON_NODRESSED);
        } else {
            expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_ZPLAN_EMOTICON_AVATAR_ICON_DRESSED);
        }
        Intrinsics.checkNotNullExpressionValue(expEntity, "if (isDefaultAppearance(\u2026R_ICON_DRESSED)\n        }");
        if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_ZPLAN_EMOTICON_AVATAR_ICON_GROUP_B)) {
            return ZPlanEmoticonAvatarIconStatus.AvatarIconNoShaking;
        }
        if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_ZPLAN_EMOTICON_AVATAR_ICON_GROUP_C)) {
            return ZPlanEmoticonAvatarIconStatus.AvatarIconWithShaking;
        }
        return ZPlanEmoticonAvatarIconStatus.RegularIcon;
    }

    public final void G() {
        if (!r() || E()) {
            return;
        }
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "recordExperimentalEmoticonAvatarIcon");
        SingleRecordRequestParams z16 = z();
        if (z16 == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEmoticonTabAvatarManager$recordZPlanEmoticonAvatarIcon$1(z16, null), 3, null);
    }

    public final void H() {
        if (!ZPlanFeatureSwitch.f369852a.v()) {
            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "toggle off do not report");
            return;
        }
        ZPlanEmoticonAvatarIconReportParams zPlanEmoticonAvatarIconReportParams = new ZPlanEmoticonAvatarIconReportParams(isSelected, d.INSTANCE.b(!E()), hitCloudCache, "2", ZPlanEmoticonUtil.f333176e.E());
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "reportDtClickEvent params:" + zPlanEmoticonAvatarIconReportParams);
        I("ev_zplan_emote_tab_click", zPlanEmoticonAvatarIconReportParams);
    }

    public final void J(boolean isZplan) {
        if (!ZPlanFeatureSwitch.f369852a.v()) {
            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "toggle off do not report");
        } else {
            isSelected = d.INSTANCE.b(isZplan);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.tab.manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEmoticonTabAvatarManager.K();
                }
            }, 160, null, true);
        }
    }

    public final void O(CoroutineScope scope, WeakReference<URLImageView> tabImageViewRef) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(tabImageViewRef, "tabImageViewRef");
        URLImageView uRLImageView = tabImageViewRef.get();
        if (!r()) {
            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "setZPlanEmoticonAvatarIcon in regular group or switch turn off, set regular icon");
            if (uRLImageView != null) {
                uRLImageView.setImageResource(R.drawable.i7v);
                return;
            }
            return;
        }
        L(scope, tabImageViewRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.tencent.mobileqq.qcoroutine.api.coroutine.b, T] */
    public final void C(CoroutineScope scope, WeakReference<URLImageView> tabImageViewRef) {
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "getZPlanEmoticonActionUpdateStatus getZPlanActions");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CorountineFunKt.e(scope, "zplan_getZPlanEmoticonActionUpdateStatus", null, null, null, new ZPlanEmoticonTabAvatarManager$getZPlanEmoticonActionUpdateStatus$1(scope, tabImageViewRef, objectRef, null), 14, null);
    }

    private final void I(String eventName, ZPlanEmoticonAvatarIconReportParams params) {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_is_selected_when_imp", Integer.valueOf(params.getIsSelected())), new Pair("zplan_is_dress_up_user", Integer.valueOf(params.getIsDressUpUser())), new Pair("zplan_is_hit_the_cloud_cache_user", Integer.valueOf(params.getHitCloudCache())), new Pair("zplan_the_first_time_enter_user_after_installation", params.getFirstTimeEnter()), new Pair("zplan_emote_page_from", params.getPageFrom()));
        VideoReport.reportEvent(eventName, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(URLImageView tabView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tabView, BasicAnimation.KeyPath.ROTATION, 0.0f, 15.0f);
        ofFloat.setDuration(120L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tabView, BasicAnimation.KeyPath.ROTATION, 15.0f, -15.0f);
        ofFloat2.setDuration(120L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(tabView, BasicAnimation.KeyPath.ROTATION, -15.0f, 15.0f);
        ofFloat3.setDuration(120L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(tabView, BasicAnimation.KeyPath.ROTATION, 15.0f, 0.0f);
        ofFloat4.setDuration(120L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        animatorSet.playSequentially(arrayList);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.tab.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonTabAvatarManager.Q(animatorSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F(URLImageView tabImageView) {
        return tabImageView != null && (tabImageView.getTag() instanceof Integer) && Intrinsics.areEqual(tabImageView.getTag(), (Object) 17);
    }

    private final Drawable p(Drawable source) {
        return source;
    }
}
