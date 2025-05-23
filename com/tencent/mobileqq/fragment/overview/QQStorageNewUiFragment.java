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
import com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.storage.view.card.StorageCardView;
import com.tencent.storage.view.pv.LoadingPercentProgressView;
import com.tencent.storage.view.pv.StorageSizeView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\u001a\u0010)\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\fH\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0012H\u0002J\b\u00101\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020+H\u0002R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010>\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010KR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010YR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010KR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010HR\u0016\u0010n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010H\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/fragment/overview/QQStorageNewUiFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/activity/en;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "di", "onBackPressed", "", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "needImmersive", "needStatusTrans", "onPostThemeChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Uh", "ei", "li", "Zh", "gi", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "storageSize", "timeout", "fi", "Sh", "Oh", "Jh", "rollText", "hi", "Mh", "", "size", "", "Th", "scanStatus", "ci", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "start", "ii", "startTime", WidgetCacheLunarData.JI, "Lcom/tencent/mobileqq/app/QQAppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "kotlin.jvm.PlatformType", "D", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "scanSpaceManager", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "E", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "scanSpaceListener", "Lcom/tencent/mobileqq/app/message/messageclean/ab;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/message/messageclean/ab;", "scanImportMessageListener", "G", "Z", "isDestroy", "H", "Landroid/view/View;", "scrollView", "I", "layoutCurrentProgress", "J", "layoutStorageOverview", "K", "storageIndicator", "Lcom/tencent/storage/view/pv/StorageSizeView;", "L", "Lcom/tencent/storage/view/pv/StorageSizeView;", TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL, "Lcom/tencent/storage/view/card/StorageCardView;", "M", "Lcom/tencent/storage/view/card/StorageCardView;", "chatAndFileCard", "Lcom/tencent/storage/view/card/e;", "N", "Lcom/tencent/storage/view/card/e;", "cacheFileCard", "P", "otherFileCard", "Lcom/tencent/storage/view/pv/LoadingPercentProgressView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/storage/view/pv/LoadingPercentProgressView;", "lppv", BdhLogUtil.LogTag.Tag_Req, "layoutStorageOverviewOptimize", "Lcom/tencent/widget/ActionSheet;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/widget/ActionSheet;", "clearCacheSheet", "T", "isFirstInit", "U", "isCleanUpThorough", "<init>", "()V", "V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQStorageNewUiFragment extends QPublicBaseFragment implements en {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQAppInterface app;

    /* renamed from: D, reason: from kotlin metadata */
    private final NTScanSpaceManager scanSpaceManager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.app.message.messageclean.ad scanSpaceListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.app.message.messageclean.ab scanImportMessageListener;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: H, reason: from kotlin metadata */
    private View scrollView;

    /* renamed from: I, reason: from kotlin metadata */
    private View layoutCurrentProgress;

    /* renamed from: J, reason: from kotlin metadata */
    private View layoutStorageOverview;

    /* renamed from: K, reason: from kotlin metadata */
    private View storageIndicator;

    /* renamed from: L, reason: from kotlin metadata */
    private StorageSizeView ssv;

    /* renamed from: M, reason: from kotlin metadata */
    private StorageCardView chatAndFileCard;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.storage.view.card.e cacheFileCard;

    /* renamed from: P, reason: from kotlin metadata */
    private StorageCardView otherFileCard;

    /* renamed from: Q, reason: from kotlin metadata */
    private LoadingPercentProgressView lppv;

    /* renamed from: R, reason: from kotlin metadata */
    private View layoutStorageOverviewOptimize;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ActionSheet clearCacheSheet;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isFirstInit;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isCleanUpThorough;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/fragment/overview/QQStorageNewUiFragment$a;", "", "", "TAG", "Ljava/lang/String;", "", "TIPS_LEFT_MARGIN", "I", "UC_CONFIG_CLEAN_UP_THOROUGH", "USE_NEW_UPGRADE_UI", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/overview/QQStorageNewUiFragment$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ be f211402e;

        b(be beVar) {
            this.f211402e = beVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageNewUiFragment.this, (Object) beVar);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationEnd(animation);
            StorageSizeView storageSizeView = QQStorageNewUiFragment.this.ssv;
            if (storageSizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
                storageSizeView = null;
            }
            StorageSizeView.setStorageSize$default(storageSizeView, this.f211402e.l(), this.f211402e.i(), this.f211402e.f(), false, 8, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/overview/QQStorageNewUiFragment$c", "Lcom/tencent/mobileqq/app/message/messageclean/ab;", "", "a", "b", "onLoading", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.mobileqq.app.message.messageclean.ab {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageNewUiFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(QQStorageNewUiFragment this$0, DialogInterface dialogInterface, int i3) {
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
        public static final void i(QQStorageNewUiFragment this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(QQStorageNewUiFragment this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("QQStorageNewUiFragment", 1, "import Message is Done");
                QQStorageNewUiFragment.this.gi();
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QQStorageNewUiFragment.this.getContext() != null && QQStorageNewUiFragment.this.getActivity() != null) {
                FragmentActivity activity = QQStorageNewUiFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                }
                if (!z16) {
                    Context context = QQStorageNewUiFragment.this.getContext();
                    String string = QQStorageNewUiFragment.this.getString(R.string.f228136sx);
                    String string2 = QQStorageNewUiFragment.this.getString(R.string.f228106su);
                    String string3 = QQStorageNewUiFragment.this.getString(R.string.f228146sy);
                    String string4 = QQStorageNewUiFragment.this.getString(R.string.f228126sw);
                    final QQStorageNewUiFragment qQStorageNewUiFragment = QQStorageNewUiFragment.this;
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.u
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageNewUiFragment.c.g(QQStorageNewUiFragment.this, dialogInterface, i3);
                        }
                    };
                    DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.v
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageNewUiFragment.c.h(QQStorageNewUiFragment.c.this, dialogInterface, i3);
                        }
                    };
                    final QQStorageNewUiFragment qQStorageNewUiFragment2 = QQStorageNewUiFragment.this;
                    DialogUtil.createVerticalThreeBtnDialog(context, 0, string, string2, string3, string4, null, onClickListener, onClickListener2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.w
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageNewUiFragment.c.i(QQStorageNewUiFragment.this, dialogInterface, i3);
                        }
                    }).show();
                    return;
                }
            }
            QLog.d("QQStorageNewUiFragment", 1, "onIncomplete. context is null");
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ab
        public void onLoading() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QQStorageNewUiFragment.this.getContext() != null && QQStorageNewUiFragment.this.getActivity() != null) {
                FragmentActivity activity = QQStorageNewUiFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                }
                if (!z16) {
                    Context context = QQStorageNewUiFragment.this.getContext();
                    String string = QQStorageNewUiFragment.this.getString(R.string.f228096st);
                    String string2 = QQStorageNewUiFragment.this.getString(R.string.f228086ss);
                    final QQStorageNewUiFragment qQStorageNewUiFragment = QQStorageNewUiFragment.this;
                    DialogUtil.createCustomDialog(context, 230, (String) null, string, (String) null, string2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.t
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            QQStorageNewUiFragment.c.j(QQStorageNewUiFragment.this, dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null).show();
                    return;
                }
            }
            QLog.d("QQStorageNewUiFragment", 1, "onLoading. context is null");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQStorageNewUiFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.scanSpaceManager = NTScanSpaceManager.S();
            this.isFirstInit = true;
        }
    }

    private final void Jh() {
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
        storageCardView3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.m
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.Kh(QQStorageNewUiFragment.this);
            }
        }, 50L);
        StorageCardView storageCardView4 = this.chatAndFileCard;
        if (storageCardView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
        } else {
            storageCardView2 = storageCardView4;
        }
        storageCardView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.n
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.Lh(QQStorageNewUiFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(QQStorageNewUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.storage.view.card.e eVar = this$0.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(QQStorageNewUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StorageCardView storageCardView = this$0.otherFileCard;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
            storageCardView = null;
        }
        storageCardView.h();
    }

    private final void Mh() {
        View view = this.storageIndicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageIndicator");
            view = null;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.l
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.Nh(QQStorageNewUiFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(QQStorageNewUiFragment this$0) {
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
        storageCardView2.i();
        com.tencent.storage.view.card.e eVar = this$0.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.k();
        StorageCardView storageCardView3 = this$0.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView = storageCardView3;
        }
        storageCardView.i();
    }

    private final void Oh(be storageSize) {
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
    public static final void Ph(QQStorageNewUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).cleanUpThorough();
        e.f211451a.d();
        this$0.ji(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(final QQStorageNewUiFragment this$0, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).clearCache();
        com.tencent.mobileqq.app.message.messageclean.q.a(this$0.app, this$0, new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.j
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.Rh(QQStorageNewUiFragment.this, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(QQStorageNewUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ji(j3);
    }

    private final void Sh(be storageSize) {
        Oh(storageSize);
        Jh();
        Mh();
    }

    private final String Th(long size, boolean timeout) {
        String result;
        if (timeout) {
            result = "-1";
        } else {
            result = com.tencent.mobileqq.app.message.messageclean.q.e(size);
        }
        QLog.d("QQStorageNewUiFragment", 1, "getReportSize size: " + size + ", timeout: " + timeout + ", result: " + result);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    private final void Uh() {
        StorageCardView storageCardView = this.chatAndFileCard;
        StorageCardView storageCardView2 = null;
        if (storageCardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatAndFileCard");
            storageCardView = null;
        }
        storageCardView.setOperateAction(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageNewUiFragment.Vh(QQStorageNewUiFragment.this, view);
            }
        });
        com.tencent.storage.view.card.e eVar = this.cacheFileCard;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar = null;
        }
        eVar.t(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageNewUiFragment.Wh(QQStorageNewUiFragment.this, view);
            }
        });
        StorageCardView storageCardView3 = this.otherFileCard;
        if (storageCardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherFileCard");
        } else {
            storageCardView2 = storageCardView3;
        }
        storageCardView2.setOperateAction(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.overview.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageNewUiFragment.Yh(QQStorageNewUiFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(QQStorageNewUiFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PublicFragmentActivity.startForResult(this$0.getActivity(), null, QQStorageManageFragment.class, 1001);
        ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B0", "0X800C1B0", 1, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(final QQStorageNewUiFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.clearCacheSheet == null) {
            this$0.clearCacheSheet = (ActionSheet) ActionSheetHelper.createDialog(this$0.getActivity(), null);
        }
        ActionSheet actionSheet = this$0.clearCacheSheet;
        if (actionSheet == null) {
            QLog.d("QQStorageNewUiFragment", 1, "click clear cache, action sheet is null");
            this$0.clearCache();
        } else {
            Intrinsics.checkNotNull(actionSheet);
            actionSheet.setMainTitle(R.string.f228686ue);
            ActionSheet actionSheet2 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet2);
            actionSheet2.addButton(R.string.f228676ud, 3, 0);
            ActionSheet actionSheet3 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet3);
            actionSheet3.addCancelButton(R.string.cancel);
            ActionSheet actionSheet4 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet4);
            actionSheet4.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.fragment.overview.r
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    QQStorageNewUiFragment.Xh(QQStorageNewUiFragment.this, view2, i3);
                }
            });
            ActionSheet actionSheet5 = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet5);
            actionSheet5.show();
            ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B6", "0X800C1B6", 1, 0, "", "", "", "");
        }
        ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B5", "0X800C1B5", 1, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(QQStorageNewUiFragment this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.clearCache();
            ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B7", "0X800C1B7", 1, 0, "", "", "", "");
            ActionSheet actionSheet = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet);
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(QQStorageNewUiFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.start(this$0.getContext(), OtherSizeInfoFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Zh() {
        if (this.scanImportMessageListener == null) {
            this.scanImportMessageListener = new c();
        }
        this.scanSpaceManager.j0(this.scanImportMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(QQStorageNewUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() == null) {
            return;
        }
        be V = this$0.scanSpaceManager.V();
        Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
        this$0.hi(V, true);
        StorageSizeView storageSizeView = this$0.ssv;
        if (storageSizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
            storageSizeView = null;
        }
        storageSizeView.setStorageSize(this$0.scanSpaceManager.V().l(), this$0.scanSpaceManager.V().i(), this$0.scanSpaceManager.V().f(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(QQStorageNewUiFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(int scanStatus) {
        ReportController.o(this.app, "dc00898", "", "", "0X800C1AD", "0X800C1AD", 1, 0, String.valueOf(scanStatus), "", String.valueOf(this.scanSpaceManager.W()), "");
    }

    private final void clearCache() {
        StorageReport.k().v(this.isCleanUpThorough);
        ii(true);
        final long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        if (this.isCleanUpThorough) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.s
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageNewUiFragment.Ph(QQStorageNewUiFragment.this, currentTimeMillis);
                }
            }, 64, null, false);
            LastCleanMMKVHelper lastCleanMMKVHelper = LastCleanMMKVHelper.f183341a;
            QQAppInterface qQAppInterface = this.app;
            if (qQAppInterface != null) {
                str = qQAppInterface.getCurrentAccountUin();
            }
            lastCleanMMKVHelper.f(str);
            return;
        }
        com.tencent.mobileqq.app.message.messageclean.q.b(this.app, this);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.h
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.Qh(QQStorageNewUiFragment.this, currentTimeMillis);
            }
        }, 64, null, false);
        LastCleanMMKVHelper lastCleanMMKVHelper2 = LastCleanMMKVHelper.f183341a;
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 != null) {
            str = qQAppInterface2.getCurrentAccountUin();
        }
        lastCleanMMKVHelper2.f(str);
    }

    private final void ei(View view) {
        View findViewById = view.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        qUISecNavBar.S(this);
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        qUISecNavBar.setTitleAlpha(0.0f);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment$setTitleBar$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f211404a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58349);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f211404a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageNewUiFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction action) {
                FragmentActivity activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (a.f211404a[action.ordinal()] != 1 || (activity = QQStorageNewUiFragment.this.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(be storageSize, boolean timeout) {
        View view = this.layoutCurrentProgress;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutStorageOverview;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStorageOverview");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
        hi(storageSize, false);
        Sh(storageSize);
        ReportController.o(this.app, "dc00898", "", "", "0X800C1AE", "0X800C1AE", 1, 0, Th(storageSize.l(), timeout), Th(storageSize.b(), timeout), Th(storageSize.a(), timeout), Th(storageSize.j(), timeout));
        ReportController.o(this.app, "dc00898", "", "", "0X800C1AF", "0X800C1AF", 1, 0, "", "", String.valueOf((((float) storageSize.l()) * 100.0f) / ((float) storageSize.f())), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        if (this.scanSpaceListener == null) {
            this.scanSpaceListener = new com.tencent.mobileqq.app.message.messageclean.ad() { // from class: com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment$startScan$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageNewUiFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void B0() {
                    boolean z16;
                    boolean z17;
                    LoadingPercentProgressView loadingPercentProgressView;
                    View view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        z16 = QQStorageNewUiFragment.this.isDestroy;
                        QLog.d("QQStorageNewUiFragment", 1, "onScanStart() isDestroy:" + z16);
                        z17 = QQStorageNewUiFragment.this.isDestroy;
                        if (!z17) {
                            loadingPercentProgressView = QQStorageNewUiFragment.this.lppv;
                            View view2 = null;
                            if (loadingPercentProgressView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("lppv");
                                loadingPercentProgressView = null;
                            }
                            loadingPercentProgressView.setProgress(0.0f);
                            view = QQStorageNewUiFragment.this.scrollView;
                            if (view == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                            } else {
                                view2 = view;
                            }
                            view2.setOverScrollMode(2);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }

                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void O1(float progress) {
                    boolean z16;
                    LoadingPercentProgressView loadingPercentProgressView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        z16 = QQStorageNewUiFragment.this.isDestroy;
                        if (!z16) {
                            loadingPercentProgressView = QQStorageNewUiFragment.this.lppv;
                            if (loadingPercentProgressView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("lppv");
                                loadingPercentProgressView = null;
                            }
                            loadingPercentProgressView.setProgress(progress);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 3, this, Float.valueOf(progress));
                }

                @Override // com.tencent.mobileqq.app.message.messageclean.ad
                public void U0(@NotNull final be storageSize, final boolean timeout) {
                    boolean z16;
                    boolean z17;
                    LoadingPercentProgressView loadingPercentProgressView;
                    LoadingPercentProgressView loadingPercentProgressView2;
                    View view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    int i3 = 2;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, storageSize, Boolean.valueOf(timeout));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(storageSize, "storageSize");
                    z16 = QQStorageNewUiFragment.this.isDestroy;
                    QLog.d("QQStorageNewUiFragment", 1, "onScanFinish(), storageSize:" + storageSize + ", isDestroy:" + z16 + ", timeout:" + timeout);
                    z17 = QQStorageNewUiFragment.this.isDestroy;
                    if (!z17) {
                        loadingPercentProgressView = QQStorageNewUiFragment.this.lppv;
                        View view2 = null;
                        if (loadingPercentProgressView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppv");
                            loadingPercentProgressView = null;
                        }
                        loadingPercentProgressView.setProgress(100.0f);
                        loadingPercentProgressView2 = QQStorageNewUiFragment.this.lppv;
                        if (loadingPercentProgressView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lppv");
                            loadingPercentProgressView2 = null;
                        }
                        final QQStorageNewUiFragment qQStorageNewUiFragment = QQStorageNewUiFragment.this;
                        loadingPercentProgressView2.a(new Function0<Unit>(storageSize, timeout) { // from class: com.tencent.mobileqq.fragment.overview.QQStorageNewUiFragment$startScan$1$onScanFinish$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ be $storageSize;
                            final /* synthetic */ boolean $timeout;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$storageSize = storageSize;
                                this.$timeout = timeout;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, QQStorageNewUiFragment.this, storageSize, Boolean.valueOf(timeout));
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    QQStorageNewUiFragment.this.fi(this.$storageSize, this.$timeout);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                        view = QQStorageNewUiFragment.this.scrollView;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                        } else {
                            view2 = view;
                        }
                        view2.setOverScrollMode(0);
                        if (timeout) {
                            i3 = 4;
                        }
                        QQStorageNewUiFragment.this.ci(i3);
                    }
                }
            };
        }
        QLog.d("QQStorageNewUiFragment", 1, "startScan registerScanSpaceListener");
        this.scanSpaceManager.q0(this.scanSpaceListener);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("clean_up_thorough", false);
        this.isCleanUpThorough = isSwitchOn;
        QLog.d("QQStorageNewUiFragment", 1, "startScan(), isCleanUpThorough:" + isSwitchOn);
        this.scanSpaceManager.y0(this.isCleanUpThorough);
    }

    private final void hi(be storageSize, boolean rollText) {
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

    private final void ii(boolean start) {
        StorageSizeView storageSizeView;
        com.tencent.storage.view.card.e eVar = null;
        if (start) {
            ReportController.o(this.app, "dc00898", "", "", "0X800C1B9", "0X800C1B9", 1, 0, "", "", "", "");
            com.tencent.storage.view.card.e eVar2 = this.cacheFileCard;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            } else {
                eVar = eVar2;
            }
            eVar.x();
            return;
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800C1BA", "0X800C1BA", 1, 0, "", "", "", "");
        com.tencent.storage.view.card.e eVar3 = this.cacheFileCard;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheFileCard");
            eVar3 = null;
        }
        eVar3.n();
        StorageSizeView storageSizeView2 = this.ssv;
        if (storageSizeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
            storageSizeView = null;
        } else {
            storageSizeView = storageSizeView2;
        }
        StorageSizeView.b(storageSizeView, this.scanSpaceManager.V().l(), this.scanSpaceManager.V().i(), this.scanSpaceManager.V().f(), false, 8, null);
    }

    private final void ji(final long startTime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.i
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.ki(QQStorageNewUiFragment.this, startTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(QQStorageNewUiFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDestroy) {
            QLog.d("QQStorageNewUiFragment", 1, "updateDelCacheSuccessUi but activity is destroyed");
            return;
        }
        this$0.scanSpaceManager.V().p();
        be V = this$0.scanSpaceManager.V();
        Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
        this$0.hi(V, true);
        this$0.ii(false);
        ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B8", "0X800C1B8", 1, 0, String.valueOf(System.currentTimeMillis() - j3), "", "", "");
    }

    private final void li(View view) {
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

    public final void di() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int screenHeight = ViewUtils.getScreenHeight();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            screenHeight -= ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        View view = this.layoutCurrentProgress;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            view = null;
        }
        view.getLayoutParams().height = screenHeight;
        if (this.isFirstInit) {
            View view3 = this.layoutCurrentProgress;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            } else {
                view2 = view3;
            }
            view2.setVisibility(0);
            this.isFirstInit = false;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1001) {
            if (requestCode == 1002) {
                QLog.d("QQStorageNewUiFragment", 1, "message import isImportMessageAndScan");
                Zh();
                return;
            }
            return;
        }
        QLog.d("QQStorageNewUiFragment", 1, "onActivityResult() needUpdateUi:" + this.scanSpaceManager.V().h() + ", storageSize:" + this.scanSpaceManager.V());
        if (this.scanSpaceManager.V().h()) {
            long integer = getResources().getInteger(android.R.integer.config_shortAnimTime) + 50;
            StorageSizeView storageSizeView = this.ssv;
            if (storageSizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TVKCommonParamEnum.REQ_PARAM_KEY_CHACHA20_CAPACITY_LEVEL);
                storageSizeView = null;
            }
            storageSizeView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageNewUiFragment.ai(QQStorageNewUiFragment.this);
                }
            }, integer);
            this.scanSpaceManager.V().x(false);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.scanSpaceManager.b0()) {
            ci(1);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.scanSpaceManager.b0()) {
            ci(1);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.hqy, container, false);
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            this.app = (QQAppInterface) appRuntime;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        QLog.d("QQStorageNewUiFragment", 1, "Fragment onDestroy");
        this.isDestroy = true;
        com.tencent.mobileqq.app.message.messageclean.ad adVar = this.scanSpaceListener;
        if (adVar != null) {
            this.scanSpaceManager.A0(adVar);
        }
        this.scanSpaceManager.J();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.iig);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.scroll_view)");
        this.scrollView = findViewById;
        View findViewById2 = view.findViewById(R.id.yv8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.lppv)");
        this.lppv = (LoadingPercentProgressView) findViewById2;
        View findViewById3 = view.findViewById(R.id.yfn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.l\u2026torage_overview_optimize)");
        this.layoutStorageOverviewOptimize = findViewById3;
        View view2 = null;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStorageOverviewOptimize");
            findViewById3 = null;
        }
        findViewById3.setVisibility(8);
        View findViewById4 = view.findViewById(R.id.ydw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.layout_current_progress)");
        this.layoutCurrentProgress = findViewById4;
        View findViewById5 = view.findViewById(R.id.yfm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.layout_storage_overview)");
        this.layoutStorageOverview = findViewById5;
        View findViewById6 = view.findViewById(R.id.f88514x_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.storage_indicator)");
        this.storageIndicator = findViewById6;
        View findViewById7 = view.findViewById(R.id.f88534xb);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.storage_ssv)");
        this.ssv = (StorageSizeView) findViewById7;
        View findViewById8 = view.findViewById(R.id.to7);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.card_manage)");
        this.chatAndFileCard = (StorageCardView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tnc);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.card_cache)");
        this.cacheFileCard = new com.tencent.storage.view.card.e((StorageCardView) findViewById9);
        View findViewById10 = view.findViewById(R.id.to_);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.card_other)");
        this.otherFileCard = (StorageCardView) findViewById10;
        View view3 = this.scrollView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            view3 = null;
        }
        view3.setVerticalScrollBarEnabled(false);
        Uh();
        ei(view);
        li(view);
        if (this.scanSpaceManager.X()) {
            be V = this.scanSpaceManager.V();
            Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
            fi(V, this.scanSpaceManager.f0());
            if (this.scanSpaceManager.f0()) {
                i3 = 4;
            }
            ci(i3);
            return;
        }
        QLog.d("QQStorageNewUiFragment", 1, "begin isImportMessageAndScan");
        Zh();
        View view4 = this.scrollView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            view2 = view4;
        }
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.g
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageNewUiFragment.bi(QQStorageNewUiFragment.this);
            }
        });
    }
}
