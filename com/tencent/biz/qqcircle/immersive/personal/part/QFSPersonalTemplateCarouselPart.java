package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTemplateCarouselInfo;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.utils.DownloadResult;
import com.tencent.biz.qqcircle.immersive.personal.utils.DownloadTask;
import com.tencent.biz.qqcircle.immersive.personal.utils.FirstTemplatePublishHelper;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalTemplateCarouselView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudRead$StTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u000f\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J \u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001a\u0010#\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u00103\u001a\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSPersonalTemplateCarouselPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/a;", "", "Y9", "W9", "V9", "T9", "da", "U9", "", NodeProps.VISIBLE, "ba", "aa", "H9", "", "I9", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/t;", "M9", "info", "Q9", "show", "ca", "ea", "R9", "Landroid/content/Context;", "context", "", QZoneDTLoginReporter.SCHEMA, "S9", "elementId", "K9", "", "", "L9", "J9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "j8", "M6", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/biz/qqcircle/immersive/personal/fragment/QFSPersonalDetailsFragment;", "d", "Lcom/tencent/biz/qqcircle/immersive/personal/fragment/QFSPersonalDetailsFragment;", "parentFragment", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/r;", "e", "Lkotlin/Lazy;", "P9", "()Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/r;", "personalViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSDraftViewModel;", "f", "O9", "()Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSDraftViewModel;", "draftViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSPersonalTemplateCarouselView;", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSPersonalTemplateCarouselView;", "templateCarouselView", "Lcom/tencent/biz/qqcircle/immersive/personal/part/az;", "i", "Lcom/tencent/biz/qqcircle/immersive/personal/part/az;", "templateCarouselZip", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "templateCarouselInfoList", BdhLogUtil.LogTag.Tag_Conn, "I", "currentIndex", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper;", "D", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/FirstTemplatePublishHelper;", "firstTemplateHelper", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "E", "N9", "()Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "dialog", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/fragment/QFSPersonalDetailsFragment;)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalTemplateCarouselPart extends com.tencent.biz.qqcircle.bizparts.b implements com.tencent.biz.qqcircle.immersive.personal.widget.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int currentIndex;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FirstTemplatePublishHelper firstTemplateHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy dialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSPersonalDetailsFragment parentFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy personalViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy draftViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPersonalTemplateCarouselView templateCarouselView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateCarouselZip templateCarouselZip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSPersonalTemplateCarouselInfo> templateCarouselInfoList;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/part/QFSPersonalTemplateCarouselPart$b", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/c;", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/d;", "downloadResult", "", "a", "", "isResourceReady", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements com.tencent.biz.qqcircle.immersive.personal.utils.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSPersonalTemplateCarouselInfo f88799b;

        b(QFSPersonalTemplateCarouselInfo qFSPersonalTemplateCarouselInfo) {
            this.f88799b = qFSPersonalTemplateCarouselInfo;
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.utils.c
        public void a(@NotNull DownloadResult downloadResult) {
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.d("QFSPersonalTemplateCarouselPart", 1, "handleFirstTemplateClick, onDownloadResult, downloadResult:" + downloadResult);
            if (!downloadResult.getIsAllSuccess()) {
                QFSPersonalTemplateCarouselPart.this.ca(false);
                QFSPersonalTemplateCarouselPart.this.ea();
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.utils.c
        public void b(boolean isResourceReady, @NotNull DownloadResult downloadResult) {
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.d("QFSPersonalTemplateCarouselPart", 1, "handleFirstTemplateClick, onCheckResult, isResourceReady:" + isResourceReady + ", downloadResult:" + downloadResult);
            if (!isResourceReady) {
                QFSPersonalTemplateCarouselPart.this.ca(false);
                QFSPersonalTemplateCarouselPart.this.ea();
                return;
            }
            String appendUrl = com.tencent.biz.qqcircle.immersive.utils.t.a(this.f88799b.getSchema(), downloadResult.getQqLogoFilePath(), "", downloadResult.getTemplateFilePath(), com.tencent.biz.qqcircle.utils.y.c(this.f88799b.getSchema(), "libtemplate"), this.f88799b.getTemplateInfo());
            QFSPersonalTemplateCarouselPart qFSPersonalTemplateCarouselPart = QFSPersonalTemplateCarouselPart.this;
            Context context = qFSPersonalTemplateCarouselPart.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNullExpressionValue(appendUrl, "appendUrl");
            qFSPersonalTemplateCarouselPart.S9(context, appendUrl, this.f88799b);
            QFSPersonalTemplateCarouselPart.this.ca(false);
        }
    }

    public QFSPersonalTemplateCarouselPart(@NotNull QFSPersonalDetailsFragment parentFragment) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        this.parentFragment = parentFragment;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.qqcircle.immersive.personal.viewmodel.r>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTemplateCarouselPart$personalViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.qqcircle.immersive.personal.viewmodel.r invoke() {
                QFSPersonalDetailsFragment qFSPersonalDetailsFragment;
                QFSPersonalTemplateCarouselPart qFSPersonalTemplateCarouselPart = QFSPersonalTemplateCarouselPart.this;
                qFSPersonalDetailsFragment = qFSPersonalTemplateCarouselPart.parentFragment;
                return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) qFSPersonalTemplateCarouselPart.getViewModel(qFSPersonalDetailsFragment, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
            }
        });
        this.personalViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QFSDraftViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTemplateCarouselPart$draftViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSDraftViewModel invoke() {
                QFSPersonalDetailsFragment qFSPersonalDetailsFragment;
                QFSPersonalTemplateCarouselPart qFSPersonalTemplateCarouselPart = QFSPersonalTemplateCarouselPart.this;
                qFSPersonalDetailsFragment = qFSPersonalTemplateCarouselPart.parentFragment;
                return (QFSDraftViewModel) qFSPersonalTemplateCarouselPart.getViewModel(qFSPersonalDetailsFragment, null, QFSDraftViewModel.class);
            }
        });
        this.draftViewModel = lazy2;
        this.templateCarouselZip = new TemplateCarouselZip(null, false, false, false, 15, null);
        this.templateCarouselInfoList = new ArrayList();
        lazy3 = LazyKt__LazyJVMKt.lazy(new QFSPersonalTemplateCarouselPart$dialog$2(this));
        this.dialog = lazy3;
        FirstTemplatePublishHelper.INSTANCE.a();
        int J = com.tencent.biz.qqcircle.f.J();
        this.currentIndex = J;
        QLog.d("QFSPersonalTemplateCarouselPart", 1, "init, currentIndex:" + J);
    }

    private final void H9() {
        int size = this.templateCarouselInfoList.size();
        QLog.d("QFSPersonalTemplateCarouselPart", 1, "bindCurrentData, currentIndex:" + this.currentIndex + ", size:" + size);
        int i3 = this.currentIndex;
        if (i3 >= 0 && i3 < size) {
            QFSPersonalTemplateCarouselInfo qFSPersonalTemplateCarouselInfo = this.templateCarouselInfoList.get(i3);
            QFSPersonalTemplateCarouselView qFSPersonalTemplateCarouselView = this.templateCarouselView;
            if (qFSPersonalTemplateCarouselView != null) {
                qFSPersonalTemplateCarouselView.c(qFSPersonalTemplateCarouselInfo);
                qFSPersonalTemplateCarouselView.setTag(qFSPersonalTemplateCarouselInfo);
            }
            K9(QCircleDaTongConstant.ElementId.EM_XSJ_CAROUSEL_CARD, qFSPersonalTemplateCarouselInfo);
            K9(QCircleDaTongConstant.ElementId.EM_XSJ_SWITCH_BUTTON, qFSPersonalTemplateCarouselInfo);
        }
    }

    private final int I9() {
        try {
            int size = this.templateCarouselInfoList.size();
            if (size <= 0) {
                return -1;
            }
            return (this.currentIndex + 1) % size;
        } catch (Exception e16) {
            QLog.w("QFSPersonalTemplateCarouselPart", 1, "calculateNextIndex, error ", e16);
            return -1;
        }
    }

    private final void J9(String elementId, QFSPersonalTemplateCarouselInfo info) {
        if (info == null) {
            return;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", L9(elementId, info));
    }

    private final void K9(String elementId, QFSPersonalTemplateCarouselInfo info) {
        if (info == null) {
            return;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", L9(elementId, info));
    }

    private final Map<String, Object> L9(String elementId, QFSPersonalTemplateCarouselInfo info) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_eid", elementId);
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
        buildElementParams.put("xsj_operation_activity_id", info.f());
        buildElementParams.put("xsj_tianshu_task_id", info.getAdId());
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "QCircleDTParamBuilder().\u2026ID] = info.adId\n        }");
        return buildElementParams;
    }

    private final QFSPersonalTemplateCarouselInfo M9() {
        Object obj;
        QFSPersonalTemplateCarouselView qFSPersonalTemplateCarouselView = this.templateCarouselView;
        if (qFSPersonalTemplateCarouselView != null) {
            obj = qFSPersonalTemplateCarouselView.getTag();
        } else {
            obj = null;
        }
        if (!(obj instanceof QFSPersonalTemplateCarouselInfo)) {
            return null;
        }
        return (QFSPersonalTemplateCarouselInfo) obj;
    }

    private final QCircleLoadingDialog N9() {
        return (QCircleLoadingDialog) this.dialog.getValue();
    }

    private final QFSDraftViewModel O9() {
        Object value = this.draftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-draftViewModel>(...)");
        return (QFSDraftViewModel) value;
    }

    private final com.tencent.biz.qqcircle.immersive.personal.viewmodel.r P9() {
        Object value = this.personalViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-personalViewModel>(...)");
        return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) value;
    }

    private final void Q9(QFSPersonalTemplateCarouselInfo info) {
        QLog.d("QFSPersonalTemplateCarouselPart", 1, "handleFirstTemplateClick, info:" + info);
        FirstTemplatePublishHelper firstTemplatePublishHelper = this.firstTemplateHelper;
        if (firstTemplatePublishHelper != null) {
            ca(true);
            firstTemplatePublishHelper.v(new b(info));
            firstTemplatePublishHelper.x();
        }
    }

    private final void R9(QFSPersonalTemplateCarouselInfo info) {
        QLog.d("QFSPersonalTemplateCarouselPart", 1, "handleNormalTemplateClick, info:" + info);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        S9(context, info.getSchema(), info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(Context context, String schema, QFSPersonalTemplateCarouselInfo info) {
        com.tencent.biz.qqcircle.launcher.c.g(context, schema + "&xsj_tianshu_task_id=" + info.getAdId());
    }

    private final void T9() {
        FirstTemplatePublishHelper firstTemplatePublishHelper;
        Object obj;
        String str;
        PBStringField pBStringField;
        boolean z16;
        da();
        Iterator<T> it = this.templateCarouselInfoList.iterator();
        while (true) {
            firstTemplatePublishHelper = null;
            str = null;
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                QFSPersonalTemplateCarouselInfo qFSPersonalTemplateCarouselInfo = (QFSPersonalTemplateCarouselInfo) obj;
                if (qFSPersonalTemplateCarouselInfo.getIsLogo() && qFSPersonalTemplateCarouselInfo.getIsProfile()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QFSPersonalTemplateCarouselInfo qFSPersonalTemplateCarouselInfo2 = (QFSPersonalTemplateCarouselInfo) obj;
        if (qFSPersonalTemplateCarouselInfo2 != null) {
            FeedCloudRead$StTemplateInfo templateInfo = qFSPersonalTemplateCarouselInfo2.getTemplateInfo();
            if (templateInfo != null && (pBStringField = templateInfo.QQLogo) != null) {
                str = pBStringField.get();
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "templateInfo?.QQLogo?.get() ?: \"\"");
            }
            String c16 = com.tencent.biz.qqcircle.utils.y.c(qFSPersonalTemplateCarouselInfo2.getSchema(), "libtemplate");
            Intrinsics.checkNotNullExpressionValue(c16, "getSchemaParameter(schema, TEMPLATE_ID)");
            firstTemplatePublishHelper = new FirstTemplatePublishHelper(new DownloadTask(str, c16));
        }
        this.firstTemplateHelper = firstTemplatePublishHelper;
    }

    private final void U9() {
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f89374zl);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalTemplateCarouselView");
            QFSPersonalTemplateCarouselView qFSPersonalTemplateCarouselView = (QFSPersonalTemplateCarouselView) inflate;
            qFSPersonalTemplateCarouselView.setOnTemplateClickListener(this);
            this.templateCarouselView = qFSPersonalTemplateCarouselView;
        }
        ba(true);
        aa(true);
        H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        boolean z16;
        if (!this.templateCarouselZip.c()) {
            QLog.d("QFSPersonalTemplateCarouselPart", 1, "notifyDataChanged, isAllDataReady is false ");
            return;
        }
        List<QFSPersonalTemplateCarouselInfo> b16 = this.templateCarouselZip.b();
        if (b16 != null && !b16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("QFSPersonalTemplateCarouselPart", 1, "notifyDataChanged, infoList is null or empty ");
            ba(false);
        } else {
            if (this.templateCarouselZip.getHasDraft()) {
                QLog.d("QFSPersonalTemplateCarouselPart", 1, "notifyDataChanged, hasDraft is true ");
                ba(false);
                return;
            }
            QLog.d("QFSPersonalTemplateCarouselPart", 1, "notifyDataChanged ");
            this.templateCarouselInfoList.clear();
            this.templateCarouselInfoList.addAll(this.templateCarouselZip.b());
            T9();
            U9();
        }
    }

    private final void W9() {
        LiveData<List<DraftBean>> O1 = O9().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<DraftBean>, Unit> function1 = new Function1<List<DraftBean>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTemplateCarouselPart$observerDraftLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<DraftBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DraftBean> list) {
                TemplateCarouselZip templateCarouselZip;
                List<DraftBean> list2 = list;
                boolean z16 = !(list2 == null || list2.isEmpty());
                QLog.d("QFSPersonalTemplateCarouselPart", 1, "observerDraftLiveData, onChanged, hasDraftData:" + z16);
                templateCarouselZip = QFSPersonalTemplateCarouselPart.this.templateCarouselZip;
                templateCarouselZip.d(z16);
                templateCarouselZip.e(true);
                QFSPersonalTemplateCarouselPart.this.V9();
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalTemplateCarouselPart.X9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Y9() {
        MutableLiveData<QFSPersonalInfo> g26 = P9().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QFSPersonalInfo, Unit> function1 = new Function1<QFSPersonalInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTemplateCarouselPart$observerPersonalInfoLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPersonalInfo qFSPersonalInfo) {
                invoke2(qFSPersonalInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSPersonalInfo qFSPersonalInfo) {
                TemplateCarouselZip templateCarouselZip;
                if (!qFSPersonalInfo.f88425l) {
                    QLog.d("QFSPersonalTemplateCarouselPart", 1, "observerPersonalInfoLiveData, onChanged, not owner ");
                    return;
                }
                if (qFSPersonalInfo.L) {
                    QLog.d("QFSPersonalTemplateCarouselPart", 1, "observerPersonalInfoLiveData, onChanged, cache data ");
                    return;
                }
                if (qFSPersonalInfo.f88423j != 0) {
                    QLog.d("QFSPersonalTemplateCarouselPart", 1, "observerPersonalInfoLiveData, onChanged, feedNum is not 0");
                    return;
                }
                List<QFSPersonalTemplateCarouselInfo> newInfoList = qFSPersonalInfo.K;
                QLog.d("QFSPersonalTemplateCarouselPart", 1, "observerPersonalInfoLiveData, onChanged, newInfoList:" + newInfoList);
                templateCarouselZip = QFSPersonalTemplateCarouselPart.this.templateCarouselZip;
                List<QFSPersonalTemplateCarouselInfo> list = newInfoList;
                if (list == null || list.isEmpty()) {
                    newInfoList = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    Intrinsics.checkNotNullExpressionValue(newInfoList, "newInfoList");
                }
                templateCarouselZip.g(newInfoList);
                templateCarouselZip.f(true);
                QFSPersonalTemplateCarouselPart.this.V9();
            }
        };
        g26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalTemplateCarouselPart.Z9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void aa(boolean visible) {
        P9().s2().postValue(Boolean.valueOf(visible));
    }

    private final void ba(boolean visible) {
        QFSPersonalTemplateCarouselView qFSPersonalTemplateCarouselView = this.templateCarouselView;
        if (qFSPersonalTemplateCarouselView != null) {
            if (visible && qFSPersonalTemplateCarouselView.getVisibility() != 0) {
                qFSPersonalTemplateCarouselView.setVisibility(0);
            }
            if (!visible && qFSPersonalTemplateCarouselView.getVisibility() == 0) {
                qFSPersonalTemplateCarouselView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(boolean show) {
        if (show) {
            try {
                if (!N9().isShowing()) {
                    N9().showDialog();
                }
            } catch (Exception e16) {
                QLog.w("QFSPersonalTemplateCarouselPart", 1, "showOrDismissDialog, error ", e16);
                return;
            }
        }
        if (!show && N9().isShowing()) {
            N9().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        FirstTemplatePublishHelper firstTemplatePublishHelper = this.firstTemplateHelper;
        if (firstTemplatePublishHelper != null) {
            firstTemplatePublishHelper.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea() {
        QQToast.makeText(RFWApplication.getApplication(), 1, "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1).show();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.a
    public void M6() {
        QFSPersonalTemplateCarouselInfo M9 = M9();
        if (M9 == null) {
            QLog.w("QFSPersonalTemplateCarouselPart", 1, "onClickTemplate, info is null ");
            return;
        }
        if (M9.getIsProfile()) {
            Q9(M9);
        } else {
            R9(M9);
        }
        J9(QCircleDaTongConstant.ElementId.EM_XSJ_CAROUSEL_CARD, M9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "QFSPersonalTemplateCarouselPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.a
    public void j8() {
        this.currentIndex = I9();
        H9();
        J9(QCircleDaTongConstant.ElementId.EM_XSJ_SWITCH_BUTTON, M9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Y9();
        W9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        int I9 = I9();
        if (I9 != -1) {
            com.tencent.biz.qqcircle.f.e0(I9);
        }
    }
}
