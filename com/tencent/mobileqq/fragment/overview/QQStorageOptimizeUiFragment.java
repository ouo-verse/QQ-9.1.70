package com.tencent.mobileqq.fragment.overview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager;
import com.tencent.mobileqq.app.message.messageclean.be;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.fragment.QQStorageManageFragment;
import com.tencent.mobileqq.fragment.overview.QQStorageOptimizeUiFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.soload.api.ISoLoadResService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.storage.view.card.StorageCardView;
import com.tencent.storage.view.pv.LoadingPercentProgressView;
import com.tencent.storage.view.pv.StorageSizeView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001~B\u0007\u00a2\u0006\u0004\b|\u0010}J&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\fH\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0002J\u001a\u0010+\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002J\u0012\u0010,\u001a\u00020\f2\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\fH\u0002J\u0018\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0010\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\fH\u0002J\u0010\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0010\u00108\u001a\u00020\f2\u0006\u00107\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u00107\u001a\u00020.H\u0002R\u001c\u0010A\u001a\n >*\u0004\u0018\u00010=0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010\\R\u0016\u0010e\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010NR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010NR\u0016\u0010m\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010NR\u0016\u0010o\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010hR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010KR\u0016\u0010w\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010KR\u0016\u0010y\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010KR\u0016\u0010{\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010R\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/fragment/overview/QQStorageOptimizeUiFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/activity/en;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "needImmersive", "needStatusTrans", "onPostThemeChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "di", "Nh", "ai", "qi", WidgetCacheLunarData.YI, "pi", "gi", "si", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "storageSize", "timeout", "ri", "Zh", "Wh", "Sh", "rollText", SensorJsPlugin.SENSOR_INTERVAL_UI, "ti", "Qh", "", "size", "", "Yh", "scanStatus", "oi", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "start", "vi", "startTime", "ii", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Xh", "wi", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "scanSpaceManager", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "D", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "scanSpaceListener", "Lcom/tencent/mobileqq/app/message/messageclean/ab;", "E", "Lcom/tencent/mobileqq/app/message/messageclean/ab;", "scanImportMessageListener", UserInfo.SEX_FEMALE, "Z", "isDestroy", "G", "Landroid/view/View;", "scrollView", "H", "layoutCurrentProgress", "I", "layoutStorageOverview", "J", "storageIndicator", "Lcom/tencent/storage/view/pv/StorageSizeView;", "K", "Lcom/tencent/storage/view/pv/StorageSizeView;", TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL, "Lcom/tencent/storage/view/card/StorageCardView;", "L", "Lcom/tencent/storage/view/card/StorageCardView;", "chatAndFileCard", "Lcom/tencent/storage/view/card/e;", "M", "Lcom/tencent/storage/view/card/e;", "cacheFileCard", "N", "otherFileCard", "P", "layoutStorageOverviewOptimize", "Lcom/tencent/storage/view/pv/LoadingPercentProgressView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/storage/view/pv/LoadingPercentProgressView;", "lppyOptimize", BdhLogUtil.LogTag.Tag_Req, "lppyOuterOptimize", ExifInterface.LATITUDE_SOUTH, "ssvOuterOptimize", "T", "lppv", "Lcom/tencent/widget/ActionSheet;", "U", "Lcom/tencent/widget/ActionSheet;", "clearCacheSheet", "V", "isFirstInit", "W", "isCleanUpThorough", "X", "isUiClickBefore", "Y", "updateTitle", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQStorageOptimizeUiFragment extends QPublicBaseFragment implements en {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.app.message.messageclean.ad scanSpaceListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.app.message.messageclean.ab scanImportMessageListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: G, reason: from kotlin metadata */
    private View scrollView;

    /* renamed from: H, reason: from kotlin metadata */
    private View layoutCurrentProgress;

    /* renamed from: I, reason: from kotlin metadata */
    private View layoutStorageOverview;

    /* renamed from: J, reason: from kotlin metadata */
    private View storageIndicator;

    /* renamed from: K, reason: from kotlin metadata */
    private StorageSizeView ssv;

    /* renamed from: L, reason: from kotlin metadata */
    private StorageCardView chatAndFileCard;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.storage.view.card.e cacheFileCard;

    /* renamed from: N, reason: from kotlin metadata */
    private StorageCardView otherFileCard;

    /* renamed from: P, reason: from kotlin metadata */
    private View layoutStorageOverviewOptimize;

    /* renamed from: Q, reason: from kotlin metadata */
    private LoadingPercentProgressView lppyOptimize;

    /* renamed from: R, reason: from kotlin metadata */
    private View lppyOuterOptimize;

    /* renamed from: S, reason: from kotlin metadata */
    private View ssvOuterOptimize;

    /* renamed from: T, reason: from kotlin metadata */
    private LoadingPercentProgressView lppv;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ActionSheet clearCacheSheet;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isCleanUpThorough;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isUiClickBefore;

    /* renamed from: Y, reason: from kotlin metadata */
    private int updateTitle;

    /* renamed from: C, reason: from kotlin metadata */
    private final NTScanSpaceManager scanSpaceManager = NTScanSpaceManager.S();

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isFirstInit = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/overview/QQStorageOptimizeUiFragment$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ be f211407e;

        b(be beVar) {
            this.f211407e = beVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            super.onAnimationEnd(animation);
            StorageSizeView storageSizeView = QQStorageOptimizeUiFragment.this.ssv;
            if (storageSizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
                storageSizeView = null;
            }
            StorageSizeView.setStorageSize$default(storageSizeView, this.f211407e.l(), this.f211407e.i(), this.f211407e.f(), false, 8, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/overview/QQStorageOptimizeUiFragment$c", "Lcom/tencent/mobileqq/app/message/messageclean/ab;", "", "a", "b", "onLoading", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.mobileqq.app.message.messageclean.ab {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(QQStorageOptimizeUiFragment this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent();
            intent.putExtra("set_display_type", 1);
            PublicFragmentActivity.startForResult(this$0.getActivity(), intent, ChatHistorySettingFragment.class, 1002);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(c this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(QQStorageOptimizeUiFragment this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(QQStorageOptimizeUiFragment this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void a() {
            QLog.d("QQStorageOptimizeUiFragment", 1, "import Message is Done");
            QQStorageOptimizeUiFragment.this.si();
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void b() {
            if (QQStorageOptimizeUiFragment.this.getContext() != null && QQStorageOptimizeUiFragment.this.getActivity() != null) {
                FragmentActivity activity = QQStorageOptimizeUiFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                }
                if (!z16) {
                    Context context = QQStorageOptimizeUiFragment.this.getContext();
                    String string = QQStorageOptimizeUiFragment.this.getString(R.string.f228136sx);
                    String string2 = QQStorageOptimizeUiFragment.this.getString(R.string.f228106su);
                    String string3 = QQStorageOptimizeUiFragment.this.getString(R.string.f228146sy);
                    String string4 = QQStorageOptimizeUiFragment.this.getString(R.string.f228126sw);
                    final QQStorageOptimizeUiFragment qQStorageOptimizeUiFragment = QQStorageOptimizeUiFragment.this;
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ao
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageOptimizeUiFragment.c.g(QQStorageOptimizeUiFragment.this, dialogInterface, i3);
                        }
                    };
                    DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ap
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageOptimizeUiFragment.c.h(QQStorageOptimizeUiFragment.c.this, dialogInterface, i3);
                        }
                    };
                    final QQStorageOptimizeUiFragment qQStorageOptimizeUiFragment2 = QQStorageOptimizeUiFragment.this;
                    DialogUtil.createVerticalThreeBtnDialog(context, 0, string, string2, string3, string4, null, onClickListener, onClickListener2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.aq
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageOptimizeUiFragment.c.i(QQStorageOptimizeUiFragment.this, dialogInterface, i3);
                        }
                    }).show();
                    return;
                }
            }
            QLog.d("QQStorageOptimizeUiFragment", 1, "onIncomplete. context is null");
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void onLoading() {
            if (QQStorageOptimizeUiFragment.this.getContext() != null && QQStorageOptimizeUiFragment.this.getActivity() != null) {
                FragmentActivity activity = QQStorageOptimizeUiFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                }
                if (!z16) {
                    Context context = QQStorageOptimizeUiFragment.this.getContext();
                    String string = QQStorageOptimizeUiFragment.this.getString(R.string.f228096st);
                    String string2 = QQStorageOptimizeUiFragment.this.getString(R.string.f228086ss);
                    final QQStorageOptimizeUiFragment qQStorageOptimizeUiFragment = QQStorageOptimizeUiFragment.this;
                    DialogUtil.createCustomDialog(context, 230, (String) null, string, (String) null, string2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ar
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageOptimizeUiFragment.c.j(QQStorageOptimizeUiFragment.this, dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null).show();
                    return;
                }
            }
            QLog.d("QQStorageOptimizeUiFragment", 1, "onLoading. context is null");
        }
    }

    private final void Nh() {
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        storageCardView.h();
        StorageCardView storageCardView3 = this.chatAndFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView3 = null;
        }
        storageCardView3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.ah
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.Oh(QQStorageOptimizeUiFragment.this);
            }
        }, 50L);
        StorageCardView storageCardView4 = this.chatAndFileCard;
        if (storageCardView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
        } else {
            storageCardView2 = storageCardView4;
        }
        storageCardView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.ai
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.Ph(QQStorageOptimizeUiFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(QQStorageOptimizeUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.storage.view.card.e eVar = this$0.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(QQStorageOptimizeUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StorageCardView storageCardView = this$0.otherFileCard;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
            storageCardView = null;
        }
        storageCardView.h();
    }

    private final void Qh() {
        View view = this.storageIndicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageIndicator");
            view = null;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.aj
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.Rh(QQStorageOptimizeUiFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(QQStorageOptimizeUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.storageIndicator;
        StorageCardView storageCardView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageIndicator");
            view = null;
        }
        ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
        StorageCardView storageCardView2 = this$0.chatAndFileCard;
        if (storageCardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView2 = null;
        }
        storageCardView2.j();
        StorageCardView storageCardView3 = this$0.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView = storageCardView3;
        }
        storageCardView.j();
    }

    private final void Sh(be storageSize) {
        StorageSizeView storageSizeView = this.ssv;
        if (storageSizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
            storageSizeView = null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(storageSizeView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(200L);
        duration.addListener(new b(storageSize));
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(QQStorageOptimizeUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).cleanUpThorough();
        e.f211451a.d();
        this$0.ii(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(QQAppInterface app, final QQStorageOptimizeUiFragment this$0, final long j3) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).clearCache();
        com.tencent.mobileqq.app.message.messageclean.q.a(app, this$0, new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.aa
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.Vh(QQStorageOptimizeUiFragment.this, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(QQStorageOptimizeUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wi(j3);
    }

    private final void Wh(be storageSize) {
        Sh(storageSize);
        Qh();
        di();
    }

    private final void Xh(QQAppInterface app) {
        QLog.d("QQStorageOptimizeUiFragment", 1, "exitQQProcess");
        QLog.flushLog();
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            Context context = getContext();
            if (context != null) {
                context.sendBroadcast(intent);
            }
        }
        QQMusicPlayService.L("QQStorageOptimizeUiFragment");
        app.exit(false);
    }

    private final String Yh(long size, boolean timeout) {
        String result;
        if (timeout) {
            result = "-1";
        } else {
            result = com.tencent.mobileqq.app.message.messageclean.q.e(size);
        }
        QLog.d("QQStorageOptimizeUiFragment", 1, "getReportSize size: " + size + ", timeout: " + timeout + ", result: " + result);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    private final void Zh() {
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        storageCardView.setloadingGone();
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.w();
        StorageCardView storageCardView3 = this.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
            storageCardView3 = null;
        }
        storageCardView3.setloadingGone();
        StorageCardView storageCardView4 = this.chatAndFileCard;
        if (storageCardView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView4 = null;
        }
        storageCardView4.k();
        if (!this.isUiClickBefore) {
            com.tencent.storage.view.card.e eVar2 = this.cacheFileCard;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
                eVar2 = null;
            }
            eVar2.m();
        }
        StorageCardView storageCardView5 = this.otherFileCard;
        if (storageCardView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView2 = storageCardView5;
        }
        storageCardView2.k();
    }

    private final void ai() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        com.tencent.storage.view.card.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.t(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageOptimizeUiFragment.bi(QQStorageOptimizeUiFragment.this, qQAppInterface, view);
            }
        });
        com.tencent.storage.view.card.e eVar3 = this.cacheFileCard;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
        } else {
            eVar2 = eVar3;
        }
        eVar2.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(final QQStorageOptimizeUiFragment this$0, final QQAppInterface app, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (this$0.clearCacheSheet == null) {
            this$0.clearCacheSheet = (ActionSheet) ActionSheetHelper.createDialog(this$0.getActivity(), null);
        }
        if (this$0.clearCacheSheet == null) {
            QLog.d("QQStorageOptimizeUiFragment", 1, "click clear cache, action sheet is null");
            this$0.clearCache();
        } else {
            if (this$0.scanSpaceManager.c0()) {
                int i3 = this$0.updateTitle + 1;
                this$0.updateTitle = i3;
                if (i3 == 1) {
                    ActionSheet actionSheet = this$0.clearCacheSheet;
                    Intrinsics.checkNotNull(actionSheet);
                    actionSheet.clearMainTitle();
                }
                QLog.d("QQStorageOptimizeUiFragment", 1, "isScanningDone is true, show cache title");
                ActionSheet actionSheet2 = this$0.clearCacheSheet;
                Intrinsics.checkNotNull(actionSheet2);
                actionSheet2.setMainTitle(R.string.f228686ue);
            } else {
                ActionSheet actionSheet3 = this$0.clearCacheSheet;
                Intrinsics.checkNotNull(actionSheet3);
                actionSheet3.setMainTitle(R.string.f228696uf);
                this$0.updateTitle = 0;
                QLog.d("QQStorageOptimizeUiFragment", 1, "isScanningDone is false, show cache title optimize");
            }
            ActionSheet actionSheet4 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet4);
            actionSheet4.addButton(R.string.f228676ud, 3, 0);
            ActionSheet actionSheet5 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet5);
            actionSheet5.addCancelButton(R.string.cancel);
            ActionSheet actionSheet6 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet6);
            actionSheet6.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.fragment.overview.am
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i16) {
                    QQStorageOptimizeUiFragment.ci(QQStorageOptimizeUiFragment.this, app, view2, i16);
                }
            });
            ActionSheet actionSheet7 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet7);
            actionSheet7.show();
            ReportController.o(app, "dc00898", "", "", "0X800C1B6", "0X800C1B6", 2, 0, "", "", "", "");
        }
        ReportController.o(app, "dc00898", "", "", "0X800C1B5", "0X800C1B5", 2, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(QQStorageOptimizeUiFragment this$0, QQAppInterface app, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (i3 == 0) {
            this$0.clearCache();
            ReportController.o(app, "dc00898", "", "", "0X800C1B7", "0X800C1B7", 2, 0, "", "", "", "");
            ActionSheet actionSheet = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet);
            actionSheet.dismiss();
        }
    }

    private final void clearCache() {
        StorageReport.k().v(this.isCleanUpThorough);
        vi(true);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.isCleanUpThorough) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.an
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageOptimizeUiFragment.Th(QQStorageOptimizeUiFragment.this, currentTimeMillis);
                }
            }, 64, null, false);
            LastCleanMMKVHelper.f183341a.f(qQAppInterface.getCurrentAccountUin());
        } else {
            com.tencent.mobileqq.app.message.messageclean.q.b(qQAppInterface, this);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.y
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageOptimizeUiFragment.Uh(QQAppInterface.this, this, currentTimeMillis);
                }
            }, 64, null, false);
            LastCleanMMKVHelper.f183341a.f(qQAppInterface.getCurrentAccountUin());
        }
    }

    private final void di() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        storageCardView.setOperateAction(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageOptimizeUiFragment.ei(QQStorageOptimizeUiFragment.this, qQAppInterface, view);
            }
        });
        StorageCardView storageCardView3 = this.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView2 = storageCardView3;
        }
        storageCardView2.setOperateAction(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageOptimizeUiFragment.fi(QQStorageOptimizeUiFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(QQStorageOptimizeUiFragment this$0, QQAppInterface app, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        PublicFragmentActivity.startForResult(this$0.getActivity(), null, QQStorageManageFragment.class, 1001);
        ReportController.o(app, "dc00898", "", "", "0X800C1B0", "0X800C1B0", 2, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(QQStorageOptimizeUiFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.start(this$0.getContext(), OtherSizeInfoFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void gi() {
        if (this.scanImportMessageListener == null) {
            this.scanImportMessageListener = new c();
        }
        this.scanSpaceManager.j0(this.scanImportMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(QQStorageOptimizeUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() == null) {
            return;
        }
        be V = this$0.scanSpaceManager.V();
        Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
        this$0.ui(V, true);
        StorageSizeView storageSizeView = this$0.ssv;
        if (storageSizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
            storageSizeView = null;
        }
        storageSizeView.setStorageSize(this$0.scanSpaceManager.V().l(), this$0.scanSpaceManager.V().i(), this$0.scanSpaceManager.V().f(), true);
    }

    private final void ii(final long startTime) {
        QBaseActivity qBaseActivity;
        Object obj;
        if (this.isDestroy) {
            return;
        }
        FragmentActivity activity = getActivity();
        final QQAppInterface qQAppInterface = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            obj = qBaseActivity.getAppRuntime();
        } else {
            obj = null;
        }
        if (obj instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) obj;
        }
        if (qQAppInterface == null) {
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        LastCleanMMKVHelper lastCleanMMKVHelper = LastCleanMMKVHelper.f183341a;
        if (lastCleanMMKVHelper.e(currentAccountUin)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.z
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageOptimizeUiFragment.ji(QQStorageOptimizeUiFragment.this, qQAppInterface, startTime);
                }
            });
            lastCleanMMKVHelper.g(currentAccountUin);
        } else {
            wi(startTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(final QQStorageOptimizeUiFragment this$0, final QQAppInterface app, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        DialogUtil.createCustomDialog(this$0.getContext(), 230, (String) null, this$0.getString(R.string.f228706ug), this$0.getString(R.string.f185783pi), this$0.getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQStorageOptimizeUiFragment.ki(QQStorageOptimizeUiFragment.this, app, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQStorageOptimizeUiFragment.mi(QQStorageOptimizeUiFragment.this, j3, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(final QQStorageOptimizeUiFragment this$0, final QQAppInterface app, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        dialogInterface.cancel();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.ae
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.li(QQStorageOptimizeUiFragment.this, app);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(QQStorageOptimizeUiFragment this$0, QQAppInterface app) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        for (String str : com.tencent.mobileqq.app.message.filescan.d.f195978a.h()) {
            FileUtils.deleteFilesInDirectory(str);
            QLog.d("QQStorageOptimizeUiFragment", 1, "onClearComplete deleteFilesInDirectory: " + str);
        }
        ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).cleanLocalCache();
        this$0.Xh(app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(QQStorageOptimizeUiFragment this$0, long j3, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wi(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(QQStorageOptimizeUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(int scanStatus) {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReportController.o((QQAppInterface) appRuntime, "dc00898", "", "", "0X800C1AD", "0X800C1AD", 2, 0, String.valueOf(scanStatus), "", String.valueOf(this.scanSpaceManager.W()), "");
    }

    private final void pi() {
        if (this.isFirstInit) {
            View view = this.lppyOuterOptimize;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lppyOuterOptimize");
                view = null;
            }
            view.setVisibility(0);
            this.isFirstInit = false;
        }
    }

    private final void qi(View view) {
        View findViewById = view.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        qUISecNavBar.S(this);
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        qUISecNavBar.setTitleAlpha(0.0f);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.fragment.overview.QQStorageOptimizeUiFragment$setTitleBar$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f211409a;

                static {
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f211409a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction action) {
                FragmentActivity activity;
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (a.f211409a[action.ordinal()] != 1 || (activity = QQStorageOptimizeUiFragment.this.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri(be storageSize, boolean timeout) {
        if (getActivity() == null) {
            return;
        }
        View view = this.lppyOuterOptimize;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lppyOuterOptimize");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.ssvOuterOptimize;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssvOuterOptimize");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
        ui(storageSize, false);
        this.scanSpaceManager.x0(true);
        Zh();
        Wh(storageSize);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C1AE", "0X800C1AE", 2, 0, Yh(storageSize.l(), timeout), Yh(storageSize.b(), timeout), Yh(storageSize.a(), timeout), Yh(storageSize.j(), timeout));
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C1AF", "0X800C1AF", 2, 0, "", "", String.valueOf((((float) storageSize.l()) * 100.0f) / ((float) storageSize.f())), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        if (this.scanSpaceListener == null) {
            this.scanSpaceListener = new com.tencent.mobileqq.app.message.messageclean.ad() { // from class: com.tencent.mobileqq.fragment.overview.QQStorageOptimizeUiFragment$startScan$1
                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void B0() {
                    boolean z16;
                    boolean z17;
                    LoadingPercentProgressView loadingPercentProgressView;
                    View view;
                    z16 = QQStorageOptimizeUiFragment.this.isDestroy;
                    QLog.d("QQStorageOptimizeUiFragment", 1, "onScanStart() isDestroy:" + z16);
                    z17 = QQStorageOptimizeUiFragment.this.isDestroy;
                    if (!z17) {
                        loadingPercentProgressView = QQStorageOptimizeUiFragment.this.lppyOptimize;
                        View view2 = null;
                        if (loadingPercentProgressView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppyOptimize");
                            loadingPercentProgressView = null;
                        }
                        loadingPercentProgressView.setProgress(0.0f);
                        view = QQStorageOptimizeUiFragment.this.scrollView;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                        } else {
                            view2 = view;
                        }
                        view2.setOverScrollMode(2);
                    }
                }

                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void O1(float progress) {
                    boolean z16;
                    LoadingPercentProgressView loadingPercentProgressView;
                    z16 = QQStorageOptimizeUiFragment.this.isDestroy;
                    if (!z16) {
                        loadingPercentProgressView = QQStorageOptimizeUiFragment.this.lppyOptimize;
                        if (loadingPercentProgressView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppyOptimize");
                            loadingPercentProgressView = null;
                        }
                        loadingPercentProgressView.setProgress(progress);
                    }
                }

                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void U0(@NotNull final be storageSize, final boolean timeout) {
                    boolean z16;
                    boolean z17;
                    LoadingPercentProgressView loadingPercentProgressView;
                    LoadingPercentProgressView loadingPercentProgressView2;
                    View view;
                    int i3;
                    Intrinsics.checkNotNullParameter(storageSize, "storageSize");
                    z16 = QQStorageOptimizeUiFragment.this.isDestroy;
                    QLog.d("QQStorageOptimizeUiFragment", 1, "onScanFinish(), storageSize:" + storageSize + ", isDestroy:" + z16 + ", timeout:" + timeout);
                    z17 = QQStorageOptimizeUiFragment.this.isDestroy;
                    if (!z17) {
                        loadingPercentProgressView = QQStorageOptimizeUiFragment.this.lppyOptimize;
                        View view2 = null;
                        if (loadingPercentProgressView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppyOptimize");
                            loadingPercentProgressView = null;
                        }
                        loadingPercentProgressView.setProgress(100.0f);
                        loadingPercentProgressView2 = QQStorageOptimizeUiFragment.this.lppyOptimize;
                        if (loadingPercentProgressView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppyOptimize");
                            loadingPercentProgressView2 = null;
                        }
                        final QQStorageOptimizeUiFragment qQStorageOptimizeUiFragment = QQStorageOptimizeUiFragment.this;
                        loadingPercentProgressView2.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.fragment.overview.QQStorageOptimizeUiFragment$startScan$1$onScanFinish$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                QQStorageOptimizeUiFragment.this.ri(storageSize, timeout);
                            }
                        });
                        view = QQStorageOptimizeUiFragment.this.scrollView;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                        } else {
                            view2 = view;
                        }
                        view2.setOverScrollMode(0);
                        if (timeout) {
                            i3 = 4;
                        } else {
                            i3 = 2;
                        }
                        QQStorageOptimizeUiFragment.this.oi(i3);
                    }
                }
            };
        }
        QLog.d("QQStorageOptimizeUiFragment", 1, "startScan registerScanSpaceListener");
        this.scanSpaceManager.q0(this.scanSpaceListener);
        this.scanSpaceManager.y0(this.isCleanUpThorough);
    }

    private final void ti(boolean rollText) {
        Pair<String, String> d16 = com.tencent.mobileqq.app.message.messageclean.q.d(0L);
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        Object obj = d16.first;
        Intrinsics.checkNotNullExpressionValue(obj, "cacheSizePair.first");
        Object obj2 = d16.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "cacheSizePair.second");
        eVar.v((String) obj, (String) obj2, rollText);
    }

    private final void ui(be storageSize, boolean rollText) {
        Pair<String, String> d16 = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.b());
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        Object obj = d16.first;
        Intrinsics.checkNotNullExpressionValue(obj, "chatRecordSizePair.first");
        Object obj2 = d16.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "chatRecordSizePair.second");
        storageCardView.setStorageSize((String) obj, (String) obj2, rollText);
        Pair<String, String> d17 = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.a());
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        Object obj3 = d17.first;
        Intrinsics.checkNotNullExpressionValue(obj3, "cacheSizePair.first");
        Object obj4 = d17.second;
        Intrinsics.checkNotNullExpressionValue(obj4, "cacheSizePair.second");
        eVar.v((String) obj3, (String) obj4, rollText);
        Pair<String, String> d18 = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.j());
        StorageCardView storageCardView3 = this.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView2 = storageCardView3;
        }
        Object obj5 = d18.first;
        Intrinsics.checkNotNullExpressionValue(obj5, "otherSizePair.first");
        Object obj6 = d18.second;
        Intrinsics.checkNotNullExpressionValue(obj6, "otherSizePair.second");
        storageCardView2.setStorageSize((String) obj5, (String) obj6, rollText);
    }

    private final void vi(boolean start) {
        StorageSizeView storageSizeView;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        com.tencent.storage.view.card.e eVar = null;
        if (start) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C1B9", "0X800C1B9", 2, 0, "", "", "", "");
            com.tencent.storage.view.card.e eVar2 = this.cacheFileCard;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            } else {
                eVar = eVar2;
            }
            eVar.x();
            return;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C1BA", "0X800C1BA", 2, 0, "", "", "", "");
        com.tencent.storage.view.card.e eVar3 = this.cacheFileCard;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar3 = null;
        }
        eVar3.n();
        if (this.scanSpaceManager.c0()) {
            StorageSizeView storageSizeView2 = this.ssv;
            if (storageSizeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
                storageSizeView = null;
            } else {
                storageSizeView = storageSizeView2;
            }
            StorageSizeView.b(storageSizeView, this.scanSpaceManager.V().l(), this.scanSpaceManager.V().i(), this.scanSpaceManager.V().f(), false, 8, null);
        }
    }

    private final void wi(final long startTime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.ab
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.xi(QQStorageOptimizeUiFragment.this, startTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(QQStorageOptimizeUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDestroy) {
            QLog.d("QQStorageOptimizeUiFragment", 1, "updateDelCacheSuccessUi but activity is destroyed");
            return;
        }
        this$0.scanSpaceManager.V().p();
        if (!this$0.scanSpaceManager.c0()) {
            this$0.ti(true);
            com.tencent.storage.view.card.e eVar = this$0.cacheFileCard;
            com.tencent.storage.view.card.e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
                eVar = null;
            }
            eVar.w();
            com.tencent.storage.view.card.e eVar3 = this$0.cacheFileCard;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            } else {
                eVar2 = eVar3;
            }
            eVar2.m();
            this$0.vi(false);
            this$0.isUiClickBefore = true;
        } else {
            be V = this$0.scanSpaceManager.V();
            Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
            this$0.ui(V, true);
            this$0.vi(false);
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReportController.o((QQAppInterface) appRuntime, "dc00898", "", "", "0X800C1B8", "0X800C1B8", 2, 0, String.valueOf(currentTimeMillis), "", "", "");
    }

    private final void yi(View view) {
        if (!FontSettingManager.isFontSizeLarge()) {
            return;
        }
        int i3 = (int) ((FontSettingManager.systemMetrics.density * 22) + 0.5f);
        TextView textView = (TextView) view.findViewById(R.id.f109976h_);
        TextView textView2 = (TextView) view.findViewById(R.id.f109956h8);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i3;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1001) {
            if (requestCode == 1002) {
                QLog.d("QQStorageOptimizeUiFragment", 1, "message import isImportMessageAndScan");
                gi();
                return;
            }
            return;
        }
        QLog.d("QQStorageOptimizeUiFragment", 1, "onActivityResult() needUpdateUi:" + this.scanSpaceManager.V().h() + ", storageSize:" + this.scanSpaceManager.V());
        if (this.scanSpaceManager.V().h()) {
            long integer = getResources().getInteger(android.R.integer.config_shortAnimTime) + 50;
            StorageSizeView storageSizeView = this.ssv;
            if (storageSizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
                storageSizeView = null;
            }
            storageSizeView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.x
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageOptimizeUiFragment.hi(QQStorageOptimizeUiFragment.this);
                }
            }, integer);
            this.scanSpaceManager.V().x(false);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.scanSpaceManager.b0()) {
            oi(1);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        if (this.scanSpaceManager.b0()) {
            oi(1);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hqy, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("QQStorageOptimizeUiFragment", 1, "Fragment onDestroy");
        this.isDestroy = true;
        com.tencent.mobileqq.app.message.messageclean.ad adVar = this.scanSpaceListener;
        if (adVar != null) {
            this.scanSpaceManager.A0(adVar);
        }
        this.scanSpaceManager.J();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        Context context = getContext();
        if (context == null) {
            return;
        }
        ColorStateList color = AppCompatResources.getColorStateList(context, R.color.qui_common_fill_light_secondary);
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        storageCardView.setCardBackgroundColor(color);
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(color, "color");
        eVar.r(color);
        StorageCardView storageCardView3 = this.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView2 = storageCardView3;
        }
        storageCardView2.setCardBackgroundColor(color);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.iig);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.scroll_view)");
        this.scrollView = findViewById;
        View findViewById2 = view.findViewById(R.id.yv9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.lppy_optimize)");
        this.lppyOptimize = (LoadingPercentProgressView) findViewById2;
        View findViewById3 = view.findViewById(R.id.yfn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.l\u2026torage_overview_optimize)");
        this.layoutStorageOverviewOptimize = findViewById3;
        View findViewById4 = view.findViewById(R.id.yv_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.lppy_outer_optimize)");
        this.lppyOuterOptimize = findViewById4;
        View findViewById5 = view.findViewById(R.id.f87764v9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.ssv_outer_optimize)");
        this.ssvOuterOptimize = findViewById5;
        View findViewById6 = view.findViewById(R.id.ydw);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.layout_current_progress)");
        this.layoutCurrentProgress = findViewById6;
        View findViewById7 = view.findViewById(R.id.yfm);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.layout_storage_overview)");
        this.layoutStorageOverview = findViewById7;
        View findViewById8 = view.findViewById(R.id.yv8);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.lppv)");
        LoadingPercentProgressView loadingPercentProgressView = (LoadingPercentProgressView) findViewById8;
        this.lppv = loadingPercentProgressView;
        View view2 = null;
        if (loadingPercentProgressView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lppv");
            loadingPercentProgressView = null;
        }
        loadingPercentProgressView.setVisibility(8);
        View view3 = this.layoutCurrentProgress;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.layoutStorageOverview;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStorageOverview");
            view4 = null;
        }
        view4.setVisibility(8);
        View findViewById9 = view.findViewById(R.id.f88524xa);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.storage_indicator_optimize)");
        this.storageIndicator = findViewById9;
        View findViewById10 = view.findViewById(R.id.f88544xc);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.storage_ssv_optimize)");
        this.ssv = (StorageSizeView) findViewById10;
        View findViewById11 = view.findViewById(R.id.to8);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.card_manage_optimize)");
        this.chatAndFileCard = (StorageCardView) findViewById11;
        View findViewById12 = view.findViewById(R.id.tnd);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.card_cache_optimize)");
        this.cacheFileCard = new com.tencent.storage.view.card.e((StorageCardView) findViewById12);
        View findViewById13 = view.findViewById(R.id.tob);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.card_other_optimize)");
        this.otherFileCard = (StorageCardView) findViewById13;
        View view5 = this.scrollView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            view5 = null;
        }
        view5.setVerticalScrollBarEnabled(false);
        ai();
        qi(view);
        yi(view);
        Nh();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.scanSpaceManager.v0(intent.getBooleanExtra("OPTIMIZE_STORAGE_UI_KEY", false));
        }
        this.isCleanUpThorough = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("clean_up_thorough", false);
        QLog.d("QQStorageOptimizeUiFragment", 1, "setIsOptimizeStorageUI isOptimizeStorageUI: " + this.scanSpaceManager.a0() + ", isCleanUpThorough:" + this.isCleanUpThorough);
        if (this.scanSpaceManager.X()) {
            be V = this.scanSpaceManager.V();
            Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
            ri(V, this.scanSpaceManager.f0());
            if (this.scanSpaceManager.f0()) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            oi(i3);
            return;
        }
        QLog.d("QQStorageOptimizeUiFragment", 1, "begin isImportMessageAndScan");
        gi();
        View view6 = this.scrollView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            view2 = view6;
        }
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.af
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOptimizeUiFragment.ni(QQStorageOptimizeUiFragment.this);
            }
        });
    }
}
