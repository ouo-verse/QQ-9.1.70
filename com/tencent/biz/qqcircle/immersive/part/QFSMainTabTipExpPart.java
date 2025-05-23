package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.addtabguide.QFSQCircleAddTabManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001ZB\u000f\u0012\u0006\u0010V\u001a\u00020\u0003\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u0003H\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER#\u0010M\u001a\n H*\u0004\u0018\u00010G0G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR#\u0010R\u001a\n H*\u0004\u0018\u00010N0N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u00a8\u0006["}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSMainTabTipExpPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "", "G9", "", "U9", "T9", "Landroid/view/View;", "dialogView", "P9", "S9", "R9", "K9", "L9", "M9", "F9", "Q9", "C9", "N9", "clearKeyBoardListener", "O9", "settingBtn", "D9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartStart", "onPartResume", "onPartPause", "", "getLogTag", "v", NodeProps.ON_CLICK, "onPartDestroy", "onPartStop", "onBackEvent", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTitle", "f", "mSubTitle", tl.h.F, "mGuideSettingBtn", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mGuideCloseBtn", "Landroid/app/Dialog;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Dialog;", "mBackGuideDialog", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsFromMiddlePage", "D", "mIsResumed", "E", "mIsShowKeyboard", "Lcom/tencent/biz/qqcircle/widgets/comment/f;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/widgets/comment/f;", "mKeyBoardHelper", "Lf70/a;", "kotlin.jvm.PlatformType", "G", "Lkotlin/Lazy;", "J9", "()Lf70/a;", "interactActionVM", "Lf70/b;", "H", "I9", "()Lf70/b;", "feedExposeVM", "H9", "()Z", "canShowGuideUI", "isFromMiddlePage", "<init>", "(Z)V", "I", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMainTabTipExpPart extends u implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsFromMiddlePage;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsResumed;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsShowKeyboard;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.widgets.comment.f mKeyBoardHelper;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy interactActionVM;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedExposeVM;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mSubTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mGuideSettingBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mGuideCloseBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mBackGuideDialog;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSMainTabTipExpPart$a;", "", "", "c", "", "d", "", "DIALOG_WIDTH", "I", "", "MMKV_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c() {
            return uq3.k.a().c("key_qfs_add_main_tab_guide_dialog", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            uq3.k.a().j("key_qfs_add_main_tab_guide_dialog", true);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/QFSMainTabTipExpPart$b", "Lcom/tencent/biz/qqcircle/widgets/comment/f$b;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements f.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            QFSMainTabTipExpPart.this.mIsShowKeyboard = false;
            QFSMainTabTipExpPart.this.clearKeyBoardListener();
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            QFSMainTabTipExpPart.this.mIsShowKeyboard = true;
        }
    }

    public QFSMainTabTipExpPart(final boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        this.mIsFromMiddlePage = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<f70.a>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart$interactActionVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f70.a invoke() {
                return (f70.a) QFSMainTabTipExpPart.this.getViewModel(f70.a.class);
            }
        });
        this.interactActionVM = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<f70.b>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart$feedExposeVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f70.b invoke() {
                f70.b bVar = (f70.b) QFSMainTabTipExpPart.this.getViewModel(f70.b.class);
                bVar.Q1(z16);
                return bVar;
            }
        });
        this.feedExposeVM = lazy2;
    }

    private final void C9() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(1);
        if (this.mIsFromMiddlePage) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    private final void D9(View settingBtn) {
        if (settingBtn != null) {
            VideoReport.setElementId(settingBtn, QCircleDaTongConstant.ElementId.EM_XSJ_SET_POP_BUTTON);
            VideoReport.setEventDynamicParams(settingBtn, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.part.cy
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map E9;
                    E9 = QFSMainTabTipExpPart.E9(QFSMainTabTipExpPart.this, str);
                    return E9;
                }
            });
            VideoReport.setElementExposePolicy(settingBtn, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(settingBtn, ClickPolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map E9(QFSMainTabTipExpPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("dt_pgid", this$0.I9().N1());
        return buildElementParams;
    }

    private final void F9() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(3);
        if (this.mIsFromMiddlePage) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    private final boolean G9() {
        int i3;
        if (Cdo.B9()) {
            QLog.d(getTAG(), 1, "is showing new user pyml guide.");
            return false;
        }
        if (QFSTeenModePopWindowPart.T9()) {
            QLog.d(getTAG(), 1, "In TeenMode.");
            return false;
        }
        QFSBaseFragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            i3 = hostFragment.getPageId();
        } else {
            i3 = -1;
        }
        if (!this.mIsFromMiddlePage && i3 != 503) {
            QLog.d(getTAG(), 1, "In MainFragment, but not all push page, pageId:" + i3 + ".");
            return false;
        }
        if (!QFSPersonalRecommendSwitchPanelPart.N9()) {
            return true;
        }
        QLog.d(getTAG(), 1, "Personal recommend panel is showing.");
        return false;
    }

    private final boolean H9() {
        return uq3.c.a();
    }

    private final f70.b I9() {
        return (f70.b) this.feedExposeVM.getValue();
    }

    private final f70.a J9() {
        return (f70.a) this.interactActionVM.getValue();
    }

    private final void K9() {
        Dialog dialog;
        boolean z16 = true;
        QLog.d("QFSMainTabTipExpPart", 1, "handleClickDialogCloseButton");
        Dialog dialog2 = this.mBackGuideDialog;
        if (dialog2 == null || !dialog2.isShowing()) {
            z16 = false;
        }
        if (z16 && (dialog = this.mBackGuideDialog) != null) {
            dialog.dismiss();
        }
        F9();
    }

    private final void L9() {
        QLog.d("QFSMainTabTipExpPart", 1, "handleClickDialogSettingButton");
        M9();
        Dialog dialog = this.mBackGuideDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Q9();
    }

    private final void M9() {
        QCircleHostUtil.setQCircleToBottomTab();
        if (getContext() != null) {
            QCircleToast.k(QCircleToast.f91646f, getContext().getString(R.string.f184823mx), 0, true);
        }
        broadcastMessage("qfs_action_add_to_main_tab_success", null);
    }

    private final void N9() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(this.mRootView);
        this.mKeyBoardHelper = fVar;
        Intrinsics.checkNotNull(fVar);
        fVar.a(new b());
    }

    private final boolean O9() {
        QLog.d("QFSMainTabTipExpPart", 1, "judgeCanShowDialog, hashCode:" + hashCode());
        if (!QFSQCircleAddTabManager.f87671a.g()) {
            QLog.d(getTAG(), 1, "Feat disable.");
            return false;
        }
        if (!H9()) {
            QLog.d(getTAG(), 1, "canShowGuideUI: false.");
            return false;
        }
        if (INSTANCE.c()) {
            QLog.d(getTAG(), 1, "Has dialog show record.");
            return false;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(getTAG(), 1, "In studyMode, do nothing.");
            return false;
        }
        if (!G9()) {
            QLog.d(getTAG(), 1, "Can not show in this state.");
            return false;
        }
        if (J9().M1() || I9().R1()) {
            return true;
        }
        return false;
    }

    private final void P9(View dialogView) {
        ImageView imageView;
        if (dialogView != null) {
            imageView = (ImageView) dialogView.findViewById(R.id.f34080y7);
        } else {
            imageView = null;
        }
        QFSDynamicResourceManager.g().updateNetworkResource(imageView, "qvideo_skin_dialog_top_tab_v2", R.drawable.nq6);
    }

    private final void Q9() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(2);
        if (this.mIsFromMiddlePage) {
            str = "3";
        } else {
            str = "2";
        }
        QCircleLpReportDc05504.report(subActionType.setExt7(str));
    }

    private final void R9() {
        Window window;
        Dialog dialog = this.mBackGuideDialog;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = com.tencent.biz.qqcircle.utils.cx.a(280.0f);
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    private final void S9() {
        Dialog dialog = this.mBackGuideDialog;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.requestFeature(1);
                window.setFlags(1024, 1024);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
    }

    private final void T9() {
        QLog.d("QFSMainTabTipExpPart", 1, "showGuideDialog, hashCode:" + hashCode());
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            this.mBackGuideDialog = new com.tencent.biz.qqcircle.widgets.comment.a(getContext());
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ghs, (ViewGroup) null);
            P9(inflate);
            S9();
            this.mTitle = (TextView) inflate.findViewById(R.id.f44081o8);
            this.mSubTitle = (TextView) inflate.findViewById(R.id.f44091o9);
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1001));
            }
            TextView textView2 = this.mSubTitle;
            if (textView2 != null) {
                textView2.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1001));
            }
            View findViewById = inflate.findViewById(R.id.vvn);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) findViewById;
            this.mGuideSettingBtn = textView3;
            if (textView3 != null) {
                textView3.requestFocus();
            }
            TextView textView4 = this.mGuideSettingBtn;
            if (textView4 != null) {
                textView4.setOnClickListener(this);
            }
            View findViewById2 = inflate.findViewById(R.id.f34060y5);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) findViewById2;
            this.mGuideCloseBtn = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            TextView textView5 = this.mTitle;
            if (textView5 != null) {
                textView5.setText(getContext().getString(R.string.f195484eq));
            }
            TextView textView6 = this.mSubTitle;
            if (textView6 != null) {
                textView6.setText(getContext().getString(R.string.f195494er));
            }
            Dialog dialog = this.mBackGuideDialog;
            if (dialog != null) {
                dialog.setContentView(inflate);
            }
            Dialog dialog2 = this.mBackGuideDialog;
            if (dialog2 != null) {
                dialog2.setCancelable(false);
            }
            if (!this.mIsShowKeyboard && getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                Dialog dialog3 = this.mBackGuideDialog;
                if (dialog3 != null) {
                    dialog3.show();
                }
                R9();
                INSTANCE.d();
                D9(this.mGuideSettingBtn);
                return;
            }
            return;
        }
        QLog.e("QFSMainTabTipExpPart", 1, "showGuideDialog view == null || getActivity is finish");
    }

    private final void U9() {
        try {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.cx
                @Override // java.lang.Runnable
                public final void run() {
                    QFSMainTabTipExpPart.V9(QFSMainTabTipExpPart.this);
                }
            });
        } catch (Exception e16) {
            QLog.e("QFSMainTabTipExpPart", 1, "[showPopupWindowSafe] error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QFSMainTabTipExpPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearKeyBoardListener() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.mKeyBoardHelper;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.r();
            this.mKeyBoardHelper = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainTabTipExpPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (O9()) {
            U9();
            C9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f34060y5) {
            K9();
        } else if (v3.getId() == R.id.vvn) {
            L9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mRootView = rootView;
        if (!H9()) {
            QLog.i(getTAG(), 1, "onInitView, can not show guide ui, do nothing.");
            return;
        }
        QFSBaseFragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            i3 = hostFragment.getPageId();
        } else {
            i3 = -1;
        }
        QLog.i(getTAG(), 1, "onInitView, mIsFromMiddlePage:" + this.mIsFromMiddlePage + ", pageId:" + i3);
        if (!this.mIsFromMiddlePage && i3 != 503) {
            QLog.i(getTAG(), 1, "isMainFragment but not all pushPage, do nothing.");
            return;
        }
        N9();
        J9().onCreate();
        I9().onCreate();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        clearKeyBoardListener();
        getMainHandler().removeCallbacksAndMessages(null);
        J9().onDestroy();
        I9().onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        this.mIsResumed = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        this.mIsResumed = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStart(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStop(activity);
        getMainHandler().removeCallbacksAndMessages(null);
    }
}
