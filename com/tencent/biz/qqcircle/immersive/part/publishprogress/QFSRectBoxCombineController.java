package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSMainFragment;
import com.tencent.biz.qqcircle.immersive.part.publishprogress.r;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.wink.QCirclePublishProgress;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.HashMap;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001e\u0018\u0000 \u00062\u00020\u0001:\u0001kB\u000f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J$\u0010 \u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020%J\u0010\u0010(\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020\u0002J\u0006\u0010+\u001a\u00020\u0002J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010&\u001a\u00020,H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010BR$\u0010H\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010[R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010g\u00a8\u0006l"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxCombineController;", "Landroid/view/View$OnClickListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "P", "", "progress", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "localCoverUrl", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "targetView", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/viewmodel/wink/QFSTopPopBannerViewModel$Selection;", "selection", "p", "o", "K", "itemName", BdhLogUtil.LogTag.Tag_Conn, "H", "", "B", "t", "G", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;", "part", "showEndState", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "taskInfo", "y", HippyTKDListViewAdapter.X, "w", "", "v", "fromFirstTask", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "r", "destroy", "Landroid/view/View;", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxBubbleView;", "d", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxBubbleView;", "bubbleView", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;", "progressView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "thumbCoverContainer", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "thumbCover", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "progressValueText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "closeView", "u", "()Landroid/view/ViewGroup;", "setLayoutView", "(Landroid/view/ViewGroup;)V", "layoutView", "D", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "mTaskInfo", "E", "Z", "isCoverShow", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;", "mPart", "Landroid/content/Context;", "mContext", "Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "mCustomDialog", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/p;", "I", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/p;", "progressOperator", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "J", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mQQCustomDialog", "startShowTimeMs", "Ljava/lang/Runnable;", "L", "Ljava/lang/Runnable;", "runnableHideBubbleView", "M", "runnableShowCloseButton", "com/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxCombineController$runnableFakeProgress$1", "N", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxCombineController$runnableFakeProgress$1;", "runnableFakeProgress", "<init>", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRectBoxCombineController implements View.OnClickListener {
    private static final long Q = (QzoneConfig.getWinkCancelUploadShowCloseButton() * 60) * 1000;

    /* renamed from: C */
    @Nullable
    private ViewGroup layoutView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TaskInfo mTaskInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCoverShow;

    /* renamed from: F */
    @Nullable
    private r mPart;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QCircleCustomDialog mCustomDialog;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private p progressOperator;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mQQCustomDialog;

    /* renamed from: K, reason: from kotlin metadata */
    private long startShowTimeMs;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnableHideBubbleView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnableShowCloseButton;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final QFSRectBoxCombineController$runnableFakeProgress$1 runnableFakeProgress;

    /* renamed from: d, reason: from kotlin metadata */
    @Nullable
    private QFSRectBoxBubbleView bubbleView;

    /* renamed from: e, reason: from kotlin metadata */
    @Nullable
    private QFSRectBoxProgressBar progressView;

    /* renamed from: f, reason: from kotlin metadata */
    @Nullable
    private ViewGroup thumbCoverContainer;

    /* renamed from: h */
    @Nullable
    private RoundCornerImageView thumbCover;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private TextView progressValueText;

    /* renamed from: m */
    @Nullable
    private ImageView closeView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxCombineController$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            if (state == LoadState.STATE_SUCCESS) {
                QFSRectBoxCombineController.this.isCoverShow = true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.biz.qqcircle.immersive.part.publishprogress.QFSRectBoxCombineController$runnableFakeProgress$1] */
    public QFSRectBoxCombineController(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        this.mTaskInfo = taskInfo;
        this.runnableHideBubbleView = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSRectBoxCombineController.D(QFSRectBoxCombineController.this);
            }
        };
        this.runnableShowCloseButton = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.j
            @Override // java.lang.Runnable
            public final void run() {
                QFSRectBoxCombineController.E(QFSRectBoxCombineController.this);
            }
        };
        this.runnableFakeProgress = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.QFSRectBoxCombineController$runnableFakeProgress$1
            @Override // java.lang.Runnable
            public void run() {
                TaskInfo taskInfo2;
                QCirclePublishProgress qCirclePublishProgress = QCirclePublishProgress.f93922d;
                taskInfo2 = QFSRectBoxCombineController.this.mTaskInfo;
                int e16 = qCirclePublishProgress.e(taskInfo2.getTaskId());
                QFSRectBoxCombineController.this.Q(e16);
                if (e16 < 100) {
                    RFWThreadManager.getUIHandler().postDelayed(this, 200L);
                }
            }
        };
    }

    private final boolean B() {
        Bundle transParams = this.mTaskInfo.getTransParams();
        if (transParams == null) {
            return true;
        }
        return transParams.getBoolean(QQWinkConstants.NEED_SAVE_TO_DRAFT_BOX, true);
    }

    private final void C(String str) {
        QFSBaseFragment qFSBaseFragment;
        QFSMainFragment qFSMainFragment;
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        r rVar = this.mPart;
        String str2 = null;
        if (rVar != null) {
            qFSBaseFragment = rVar.getHostFragment();
        } else {
            qFSBaseFragment = null;
        }
        if (qFSBaseFragment instanceof QFSMainFragment) {
            qFSMainFragment = (QFSMainFragment) qFSBaseFragment;
        } else {
            qFSMainFragment = null;
        }
        if (qFSMainFragment != null) {
            str2 = qFSMainFragment.getDaTongPageId();
        }
        if (str2 == null) {
            str2 = "";
        }
        Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_item_name", str);
        Unit unit = Unit.INSTANCE;
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_EXIT_PUBLISH_POP_BUTTON, "ev_xsj_abnormal_clck", str2, buildElementParams);
    }

    public static final void D(QFSRectBoxCombineController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z();
    }

    public static final void E(QFSRectBoxCombineController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "mShowCloseBtnRunnable, taskIsEnd:" + com.tencent.biz.qqcircle.widgets.p.d(this$0.mTaskInfo));
        if (com.tencent.biz.qqcircle.widgets.p.d(this$0.mTaskInfo)) {
            return;
        }
        this$0.G();
    }

    private final void F(String str, RoundCornerImageView roundCornerImageView) {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "setLocalCover, localCoverUrl: " + str + ", isCoverShow: " + this.isCoverShow);
        if (!this.isCoverShow && !TextUtils.isEmpty(str)) {
            roundCornerImageView.setCorner(ViewUtils.dip2px(4.0f));
            roundCornerImageView.setBorder(true);
            roundCornerImageView.setBorderWidth(ViewUtils.dip2px(1.0f));
            roundCornerImageView.setColor(Color.parseColor("#1AFFFFFF"));
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(roundCornerImageView.getLayoutParams().width).setRequestHeight(roundCornerImageView.getLayoutParams().height).setTargetView(roundCornerImageView), new b());
        }
    }

    private final void G() {
        ImageView imageView = this.closeView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void H() {
        int i3;
        if (this.mTaskInfo.isVideoComment()) {
            i3 = R.string.f193984ao;
        } else if (B()) {
            i3 = R.string.f193954al;
        } else {
            i3 = R.string.f193964am;
        }
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        QCircleCustomDialog S = QCircleCustomDialog.S(context, null, context.getString(i3), R.string.cancel, R.string.f188503wv, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                QFSRectBoxCombineController.I(QFSRectBoxCombineController.this, dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                QFSRectBoxCombineController.J(dialogInterface, i16);
            }
        });
        this.mCustomDialog = S;
        if (S != null) {
            try {
                S.show();
            } catch (Exception e16) {
                QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, e16, new Object[0]);
            }
        }
    }

    public static final void I(QFSRectBoxCombineController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String q16 = q(this$0, null, 1, null);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, q16);
        r.Companion companion = r.INSTANCE;
        QCircleCustomDialog qCircleCustomDialog = this$0.mCustomDialog;
        Intrinsics.checkNotNull(qCircleCustomDialog);
        companion.a(qCircleCustomDialog.getRootView(), "dt_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_TERMINATE_PANEL, hashMap);
    }

    private final void K() {
        QFSBaseFragment qFSBaseFragment;
        QFSMainFragment qFSMainFragment;
        ViewGroup.LayoutParams layoutParams;
        final String str = "\u91cd\u65b0\u7f16\u8f91";
        final String str2 = "\u5b58\u8349\u7a3f";
        final String str3 = "\u7ee7\u7eed\u53d1\u8868";
        QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(this.mContext, 0, "\u4f5c\u54c1\u53d1\u8868\u4e2d", "\u4f60\u53ef\u4ee5\u9009\u62e9\u91cd\u65b0\u7f16\u8f91\u540e\u518d\u53d1\u8868\u54e6", "\u91cd\u65b0\u7f16\u8f91", "\u5b58\u8349\u7a3f", "\u7ee7\u7eed\u53d1\u8868", new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSRectBoxCombineController.L(QFSRectBoxCombineController.this, str, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSRectBoxCombineController.N(QFSRectBoxCombineController.this, str2, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QFSRectBoxCombineController.O(QFSRectBoxCombineController.this, str3, dialogInterface, i3);
            }
        });
        this.mQQCustomDialog = createVerticalThreeBtnDialog;
        String str4 = null;
        if (createVerticalThreeBtnDialog != null) {
            createVerticalThreeBtnDialog.setTitleTextColor(R.color.qui_common_text_primary);
            TextView titleTextView = createVerticalThreeBtnDialog.getTitleTextView();
            if (titleTextView != null) {
                titleTextView.setTextSize(17.0f);
            }
            TextView titleTextView2 = createVerticalThreeBtnDialog.getTitleTextView();
            if (titleTextView2 != null) {
                titleTextView2.setGravity(17);
            }
            TextView titleTextView3 = createVerticalThreeBtnDialog.getTitleTextView();
            if (titleTextView3 != null) {
                titleTextView3.setTypeface(null, 1);
            }
            TextView messageTextView = createVerticalThreeBtnDialog.getMessageTextView();
            if (messageTextView != null) {
                messageTextView.setTextSize(14.0f);
            }
            TextView messageTextView2 = createVerticalThreeBtnDialog.getMessageTextView();
            if (messageTextView2 != null && (layoutParams = messageTextView2.getLayoutParams()) != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                layoutParams.width = -1;
            }
            TextView messageTextView3 = createVerticalThreeBtnDialog.getMessageTextView();
            if (messageTextView3 != null) {
                messageTextView3.setGravity(17);
            }
            createVerticalThreeBtnDialog.setMessageTextColor(R.color.qui_common_text_secondary);
            TextView btnLeft = createVerticalThreeBtnDialog.getBtnLeft();
            if (btnLeft != null) {
                btnLeft.setTypeface(null, 1);
            }
            createVerticalThreeBtnDialog.getBtnLeft().setTextSize(17.0f);
            ViewGroup.LayoutParams layoutParams2 = createVerticalThreeBtnDialog.getBtnLeft().getLayoutParams();
            if (layoutParams2 != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams2, "layoutParams");
                layoutParams2.height = e83.a.b(54);
            }
            TextView btnight = createVerticalThreeBtnDialog.getBtnight();
            if (btnight != null) {
                btnight.setTypeface(null, 0);
            }
            createVerticalThreeBtnDialog.getBtnight().setTextSize(17.0f);
            ViewGroup.LayoutParams layoutParams3 = createVerticalThreeBtnDialog.getBtnight().getLayoutParams();
            if (layoutParams3 != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams3, "layoutParams");
                layoutParams3.height = e83.a.b(54);
            }
            TextView textView = (TextView) createVerticalThreeBtnDialog.findViewById(R.id.biv);
            textView.setTypeface(null, 0);
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            if (layoutParams4 != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams4, "layoutParams");
                layoutParams4.height = e83.a.b(54);
            }
        }
        try {
            QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
            if (qQCustomDialog != null) {
                qQCustomDialog.show();
            }
            com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
            r rVar = this.mPart;
            if (rVar != null) {
                qFSBaseFragment = rVar.getHostFragment();
            } else {
                qFSBaseFragment = null;
            }
            if (qFSBaseFragment instanceof QFSMainFragment) {
                qFSMainFragment = (QFSMainFragment) qFSBaseFragment;
            } else {
                qFSMainFragment = null;
            }
            if (qFSMainFragment != null) {
                str4 = qFSMainFragment.getDaTongPageId();
            }
            if (str4 == null) {
                str4 = "";
            }
            com.tencent.mobileqq.wink.report.a.b(aVar, WinkDaTongReportConstant.ElementId.EM_XSJ_EXIT_PUBLISH_POP, "ev_xsj_abnormal_imp", str4, null, 8, null);
        } catch (Exception e16) {
            QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, e16, new Object[0]);
        }
    }

    public static final void L(QFSRectBoxCombineController this$0, String reEditString, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reEditString, "$reEditString");
        this$0.p(QFSTopPopBannerViewModel.Selection.RE_EDIT);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSRectBoxCombineController.M(QFSRectBoxCombineController.this);
            }
        });
        this$0.C(reEditString);
    }

    public static final void M(QFSRectBoxCombineController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final DraftBean lastDraftBeanSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin());
        if (lastDraftBeanSync == null) {
            QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, "lastDraft == null");
            return;
        }
        if (lastDraftBeanSync.getTaskId() != this$0.mTaskInfo.getTaskId()) {
            QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, lastDraftBeanSync.getTaskId() + " != " + this$0.mTaskInfo.getTaskId());
            return;
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.QFSRectBoxCombineController$showNewDialog$1$1$1
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
                r rVar;
                QFSPersonalDraftUtil qFSPersonalDraftUtil = new QFSPersonalDraftUtil();
                rVar = QFSRectBoxCombineController.this.mPart;
                Intrinsics.checkNotNull(rVar);
                QLog.w("WinkPublish-Progress-QFSRectBoxCombineController", 1, "errorCode:" + qFSPersonalDraftUtil.c(rVar.getActivity(), lastDraftBeanSync, 11) + " lastDraft:" + lastDraftBeanSync);
            }
        });
    }

    public static final void N(QFSRectBoxCombineController this$0, String saveDraftString, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(saveDraftString, "$saveDraftString");
        this$0.p(QFSTopPopBannerViewModel.Selection.SAVE_DRAFT);
        this$0.C(saveDraftString);
    }

    public static final void O(QFSRectBoxCombineController this$0, String cancelString, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelString, "$cancelString");
        this$0.C(cancelString);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    private final void P(TaskInfo task) {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "show, task: " + task);
        RoundCornerImageView roundCornerImageView = this.thumbCover;
        if (roundCornerImageView != null) {
            F(task.getCoverUrl(), roundCornerImageView);
        }
    }

    public final void Q(int i3) {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "updateProgress:" + i3);
        p pVar = this.progressOperator;
        if (pVar != null) {
            pVar.i(i3);
        }
    }

    public static /* synthetic */ void n(QFSRectBoxCombineController qFSRectBoxCombineController, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qFSRectBoxCombineController.m(z16);
    }

    private final TaskInfo o() {
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService == null) {
            QLog.w("WinkPublish-Progress-QFSRectBoxCombineController", 1, "cancelUploadActually, serviceProxy is null ");
            return null;
        }
        long taskId = this.mTaskInfo.getTaskId();
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "cancelUploadActually, taskId: " + taskId);
        qfsService.cancelTaskWithId(taskId);
        return this.mTaskInfo;
    }

    private final String p(QFSTopPopBannerViewModel.Selection selection) {
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel;
        String str;
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel2;
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "cancelUploadManually selection:" + selection);
        TaskInfo o16 = o();
        String str2 = "";
        if (o16 != null) {
            r rVar = this.mPart;
            CharSequence charSequence = null;
            if (rVar != null) {
                qFSTopPopBannerViewModel = (QFSTopPopBannerViewModel) rVar.getViewModel(QFSTopPopBannerViewModel.class);
            } else {
                qFSTopPopBannerViewModel = null;
            }
            if (qFSTopPopBannerViewModel != null) {
                qFSTopPopBannerViewModel.f2(selection);
            }
            r rVar2 = this.mPart;
            if (rVar2 != null && (qFSTopPopBannerViewModel2 = (QFSTopPopBannerViewModel) rVar2.getViewModel(QFSTopPopBannerViewModel.class)) != null) {
                qFSTopPopBannerViewModel2.O1(o16.getTaskId());
            }
            Bundle transParams = o16.getTransParams();
            if (transParams != null) {
                str = transParams.getString(QQWinkConstants.PUBLISH_TRANS_PARAMS_CAMERA_SESSION_ID);
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            ITaskSnapshotApi iTaskSnapshotApi = (ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class);
            TextView textView = this.progressValueText;
            if (textView != null) {
                charSequence = textView.getText();
            }
            String snapshotInfo = iTaskSnapshotApi.getSnapshotInfo(String.valueOf(charSequence), this.mTaskInfo.getExportProgress(), this.mTaskInfo.getUploadProgress());
            QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "cancelUploadManually, dtCameraSessionId=" + str2 + ", snapshotInfo:" + snapshotInfo);
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).ePublishCancelUpload()).setTraceId(o16.getTraceId()).setExt1(str2).setAttachInfo(snapshotInfo));
        }
        return str2;
    }

    static /* synthetic */ String q(QFSRectBoxCombineController qFSRectBoxCombineController, QFSTopPopBannerViewModel.Selection selection, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            selection = QFSTopPopBannerViewModel.Selection.DEFAULT;
        }
        return qFSRectBoxCombineController.p(selection);
    }

    private final void t() {
        QCircleCustomDialog qCircleCustomDialog = this.mCustomDialog;
        if (qCircleCustomDialog != null && qCircleCustomDialog.isShowing()) {
            try {
                qCircleCustomDialog.dismiss();
            } catch (Exception e16) {
                QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, "dismissDialog, e:" + e16);
            }
        }
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            try {
                qQCustomDialog.dismiss();
            } catch (Exception e17) {
                QLog.e("WinkPublish-Progress-QFSRectBoxCombineController", 1, "dismissDialog, e:" + e17);
            }
        }
    }

    private final void z() {
        QFSRectBoxBubbleView qFSRectBoxBubbleView = this.bubbleView;
        if (qFSRectBoxBubbleView != null) {
            qFSRectBoxBubbleView.B0();
        }
        p pVar = this.progressOperator;
        if (pVar != null) {
            pVar.d();
        }
    }

    public final void A(@Nullable Context context, @Nullable r rVar, boolean z16) {
        QFSRectBoxBubbleView qFSRectBoxBubbleView;
        RoundCornerImageView roundCornerImageView;
        QFSRectBoxProgressBar qFSRectBoxProgressBar;
        ViewGroup viewGroup;
        TextView textView;
        this.mPart = rVar;
        this.mContext = context;
        ImageView imageView = null;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.f168744gp4, (ViewGroup) null);
        this.layoutView = viewGroup2;
        if (viewGroup2 != null) {
            qFSRectBoxBubbleView = (QFSRectBoxBubbleView) viewGroup2.findViewById(R.id.f500824f);
        } else {
            qFSRectBoxBubbleView = null;
        }
        this.bubbleView = qFSRectBoxBubbleView;
        ViewGroup viewGroup3 = this.layoutView;
        if (viewGroup3 != null) {
            roundCornerImageView = (RoundCornerImageView) viewGroup3.findViewById(R.id.f501324k);
        } else {
            roundCornerImageView = null;
        }
        this.thumbCover = roundCornerImageView;
        ViewGroup viewGroup4 = this.layoutView;
        if (viewGroup4 != null) {
            qFSRectBoxProgressBar = (QFSRectBoxProgressBar) viewGroup4.findViewById(R.id.f501024h);
        } else {
            qFSRectBoxProgressBar = null;
        }
        this.progressView = qFSRectBoxProgressBar;
        ViewGroup viewGroup5 = this.layoutView;
        if (viewGroup5 != null) {
            viewGroup = (ViewGroup) viewGroup5.findViewById(R.id.f5036257);
        } else {
            viewGroup = null;
        }
        this.thumbCoverContainer = viewGroup;
        ViewGroup viewGroup6 = this.layoutView;
        if (viewGroup6 != null) {
            textView = (TextView) viewGroup6.findViewById(R.id.f501224j);
        } else {
            textView = null;
        }
        this.progressValueText = textView;
        ViewGroup viewGroup7 = this.layoutView;
        if (viewGroup7 != null) {
            imageView = (ImageView) viewGroup7.findViewById(R.id.f500924g);
        }
        this.closeView = imageView;
        ViewGroup viewGroup8 = this.thumbCoverContainer;
        if (viewGroup8 != null) {
            viewGroup8.setOnClickListener(this);
        }
        ImageView imageView2 = this.closeView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        p pVar = new p(this.thumbCoverContainer, this.progressValueText, this.progressView);
        this.progressOperator = pVar;
        if (z16) {
            pVar.h();
        }
    }

    public final void destroy() {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "destroy");
        RFWThreadManager.getUIHandler().removeCallbacks(this.runnableHideBubbleView);
        RFWThreadManager.getUIHandler().removeCallbacks(this.runnableFakeProgress);
        RFWThreadManager.getUIHandler().removeCallbacks(this.runnableShowCloseButton);
        t();
        ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).clear();
    }

    public final void m(boolean z16) {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "bringToFront, fromFirstTask:" + z16);
        this.startShowTimeMs = System.currentTimeMillis();
        k kVar = k.f88273a;
        if (kVar.c() && z16) {
            kVar.e(this.mTaskInfo);
            p pVar = this.progressOperator;
            if (pVar != null) {
                pVar.g();
            }
            QFSRectBoxBubbleView qFSRectBoxBubbleView = this.bubbleView;
            if (qFSRectBoxBubbleView != null) {
                qFSRectBoxBubbleView.E0();
            }
            RFWThreadManager.getUIHandler().postDelayed(this.runnableHideBubbleView, kVar.a());
        } else {
            p pVar2 = this.progressOperator;
            if (pVar2 != null) {
                pVar2.h();
            }
        }
        RFWThreadManager.getUIHandler().postDelayed(this.runnableShowCloseButton, Q);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f5036257 || v3.getId() == R.id.f500924g) {
            if (com.tencent.biz.qqcircle.widgets.p.d(this.mTaskInfo)) {
                QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "Do nothing, task is end.");
            } else if (!fb0.a.a("showLoadingDialog")) {
                if (c60.a.f30394a.a()) {
                    K();
                } else {
                    H();
                }
                ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_use_new_selection_dialog_v2");
                r.INSTANCE.a(this.layoutView, "dt_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void r() {
        Q(100);
    }

    public final void s() {
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "changeToMultiTaskState");
        p pVar = this.progressOperator;
        if (pVar != null) {
            pVar.c();
        }
        QFSRectBoxBubbleView qFSRectBoxBubbleView = this.bubbleView;
        if (qFSRectBoxBubbleView != null) {
            qFSRectBoxBubbleView.B0();
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.runnableHideBubbleView);
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final ViewGroup getLayoutView() {
        return this.layoutView;
    }

    /* renamed from: v, reason: from getter */
    public final long getStartShowTimeMs() {
        return this.startShowTimeMs;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final TaskInfo getMTaskInfo() {
        return this.mTaskInfo;
    }

    public final void x(@NotNull TaskInfo task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mTaskInfo = task;
    }

    public final void y(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        QLog.d("WinkPublish-Progress-QFSRectBoxCombineController", 1, "handleTaskStateChange, taskId:" + taskInfo.getTaskId() + ", state:" + taskInfo.getState());
        if (taskInfo.isActive()) {
            P(taskInfo);
            if (!taskInfo.isNetworkWaiting()) {
                int exportProgress = taskInfo.getExportProgress();
                int uploadProgress = taskInfo.getUploadProgress();
                int i3 = 100;
                if (exportProgress != 100 || uploadProgress != 100) {
                    RFWThreadManager.getUIHandler().postDelayed(this.runnableFakeProgress, 200L);
                    i3 = 0;
                }
                Q(i3);
                return;
            }
            RFWThreadManager.getUIHandler().removeCallbacks(this.runnableFakeProgress);
            return;
        }
        if (com.tencent.biz.qqcircle.widgets.p.d(taskInfo)) {
            destroy();
        }
    }

    public static final void J(DialogInterface dialogInterface, int i3) {
    }
}
