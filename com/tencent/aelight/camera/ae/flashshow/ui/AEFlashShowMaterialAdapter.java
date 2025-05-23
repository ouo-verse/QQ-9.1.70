package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001wB)\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010s\u001a\u00020C\u0012\b\u0010t\u001a\u0004\u0018\u00010`\u0012\u0006\u0010f\u001a\u00020\u0006\u00a2\u0006\u0004\bu\u0010vJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\fH\u0002J3\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001a\"\u00020\bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010 \u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010%\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0018\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0012\u0010/\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00100\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00103\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020\u0011H\u0016J \u00107\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0011H\u0016J\u0018\u00109\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u00108\u001a\u00020\u0011H\u0016R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010B\u001a\n ?*\u0004\u0018\u00010>0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u0004\u0018\u00010G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR$\u0010W\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010_\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010c\u001a\u0004\u0018\u00010`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020X0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010lR\u001b\u0010r\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010o\u001a\u0004\bp\u0010q\u00a8\u0006x"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dq;", "Lyq2/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/aelight/camera/download/a;", "", "show", "", WadlProxyConsts.KEY_MATERIAL, "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "K", "needShow", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "J", "w", "data", "y", HippyTKDListViewAdapter.X, "sender", "eventId", "", "args", "notify", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "category", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", NodeProps.ON_CLICK, "O", "P", "L", "Landroid/view/ViewGroup;", "viewGroup", "viewType", BdhLogUtil.LogTag.Tag_Conn, "viewHolder", "position", "B", "holder", "H", "I", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "getItemCount", "isSuccess", "resCode", "onDownloadFinish", "progress", "onProgressUpdate", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "e", "Landroid/view/LayoutInflater;", "mLayoutInflater", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;", "f", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;", "mGridView", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", tl.h.F, "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "mTemplateManager", "i", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "mCategory", "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mTemplateList", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "getMLastMaterialMetaData", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "setMLastMaterialMetaData", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;)V", "mLastMaterialMetaData", "", "D", "Ljava/lang/String;", "getMLastSelectedMaterialId", "()Ljava/lang/String;", "setMLastSelectedMaterialId", "(Ljava/lang/String;)V", "mLastSelectedMaterialId", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "E", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "mMaterialPanelListener", UserInfo.SEX_FEMALE, "Z", "isFavoriteTab", "Ljava/util/HashSet;", "G", "Ljava/util/HashSet;", "mPendingReportMaterialIds", "Lcom/tencent/mobileqq/wink/view/al;", "Lcom/tencent/mobileqq/wink/view/al;", "mDialog", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "mLoadingDialog", "gridView", "listener", "<init>", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;Z)V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialAdapter extends RecyclerView.Adapter<dq> implements yq2.c, View.OnClickListener, com.tencent.aelight.camera.download.a {

    /* renamed from: C, reason: from kotlin metadata */
    private AEMaterialMetaData mLastMaterialMetaData;

    /* renamed from: D, reason: from kotlin metadata */
    private String mLastSelectedMaterialId;

    /* renamed from: E, reason: from kotlin metadata */
    private final AEFlashShowMaterialPanel.a mMaterialPanelListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFavoriteTab;

    /* renamed from: G, reason: from kotlin metadata */
    private final HashSet<String> mPendingReportMaterialIds;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.view.al mDialog;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy mLoadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater mLayoutInflater;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowGridView mGridView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowMaterialManager mTemplateManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AEMaterialCategory mCategory;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<AEMaterialMetaData> mTemplateList;

    public AEFlashShowMaterialAdapter(Context mContext, AEFlashShowGridView gridView, AEFlashShowMaterialPanel.a aVar, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(gridView, "gridView");
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mTemplateList = new ArrayList<>();
        this.mPendingReportMaterialIds = new HashSet<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QCircleCommonLoadingDialog>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter$mLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QCircleCommonLoadingDialog invoke() {
                Context context;
                context = AEFlashShowMaterialAdapter.this.mContext;
                return new QCircleCommonLoadingDialog.c(context).p("\u5f15\u64ce\u542f\u52a8\u4e2d").n(false).a();
            }
        });
        this.mLoadingDialog = lazy;
        com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        this.mTemplateManager = (AEFlashShowMaterialManager) b16;
        this.mMaterialPanelListener = aVar;
        this.mGridView = gridView;
        this.isFavoriteTab = z16;
    }

    private final QCircleCommonLoadingDialog A() {
        Object value = this.mLoadingDialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLoadingDialog>(...)");
        return (QCircleCommonLoadingDialog) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AEFlashShowMaterialAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.mContext, HardCodeUtil.qqStr(R.string.f169910y93), 0).show();
        ms.a.f("AEFlashShowMaterialAdapter", "is not from superQQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AEFlashShowMaterialAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xq.c.f448345a.j(new WeakReference<>(this$0.A()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(AEFlashShowMaterialAdapter this$0, int i3, AEMaterialMetaData info, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        AEMaterialMetaData aEMaterialMetaData = this$0.mTemplateList.get(i3);
        Intrinsics.checkNotNullExpressionValue(aEMaterialMetaData, "mTemplateList[finalPos]");
        AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this$0.mTemplateManager;
        Intrinsics.checkNotNull(aEFlashShowMaterialManager);
        String selectedMaterialId = aEFlashShowMaterialManager.getSelectedMaterialId();
        ms.a.f("AEFlashShowMaterialAdapter", "mlastSelectedMaterialId = " + this$0.mLastSelectedMaterialId + ", lastMaterialId = " + selectedMaterialId);
        if (!TextUtils.isEmpty(this$0.mLastSelectedMaterialId) && Intrinsics.areEqual(this$0.mLastSelectedMaterialId, info.f69050id) && Intrinsics.areEqual(selectedMaterialId, info.f69050id) && Intrinsics.areEqual(aEMaterialMetaData2.f69050id, info.f69050id) && z16) {
            AEFlashShowMaterialManager.Companion companion = AEFlashShowMaterialManager.INSTANCE;
            if (companion.b()) {
                ms.a.f("AEFlashShowMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
                this$0.notifyDataSetChanged();
                return;
            }
            if (!companion.a()) {
                ms.a.f("AEFlashShowMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
                this$0.notifyDataSetChanged();
            } else if (this$0.mMaterialPanelListener != null) {
                this$0.mTemplateManager.m0(info, !this$0.isFavoriteTab);
                ms.a.a("AEFlashShowMaterialAdapter", "### [material panel] download finish, select material " + info.f69050id);
                this$0.mMaterialPanelListener.a(info);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AEFlashShowMaterialAdapter this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyItemChanged(i3, 1);
    }

    private final void J(AEMaterialMetaData info) {
        this.mPendingReportMaterialIds.add(info.f69050id);
    }

    private final void K(AEMaterialMetaData info) {
        if (!Intrinsics.areEqual(this.mLastMaterialMetaData, info)) {
            AEMaterialMetaData aEMaterialMetaData = this.mLastMaterialMetaData;
            if (aEMaterialMetaData != null) {
                aEMaterialMetaData.ischoose = false;
            }
            if (aEMaterialMetaData != null) {
                aEMaterialMetaData.isdoubleclick = false;
            }
        }
        this.mLastMaterialMetaData = info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M() {
        ms.a.a("AEFlashShowMaterialAdapter", "use material failed because of so load failed");
        if (com.tencent.aelight.camera.ae.d.l()) {
            com.tencent.aelight.camera.ae.d.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AEFlashShowMaterialAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xq.c.f448345a.j(new WeakReference<>(this$0.A()));
    }

    private final void Q(final AEMaterialMetaData info, boolean needShow) {
        if (this.mDialog == null) {
            Context context = this.mContext;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter$showPrivateProtoDialog$1
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
                    com.tencent.mobileqq.wink.utils.ar.f326685a.m("ae_key_editor_camera_proto", false);
                    ms.a.a("AEFlashShowMaterialAdapter", "showPrivateProtoDialog  degree ");
                    AEFlashShowMaterialAdapter.this.L(info);
                }
            };
            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialAdapter$showPrivateProtoDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    com.tencent.mobileqq.wink.utils.ar.f326685a.m("ae_key_editor_camera_proto", true);
                    ms.a.a("AEFlashShowMaterialAdapter", "showPrivateProtoDialog  not  degree ");
                    AEFlashShowMaterialAdapter aEFlashShowMaterialAdapter = AEFlashShowMaterialAdapter.this;
                    AEMaterialMetaData MATERIAL_NONE = AEMaterialMetaData.MATERIAL_NONE;
                    Intrinsics.checkNotNullExpressionValue(MATERIAL_NONE, "MATERIAL_NONE");
                    aEFlashShowMaterialAdapter.L(MATERIAL_NONE);
                }
            };
            String qqStr = HardCodeUtil.qqStr(R.string.f238957l6);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(\n                 \u2026content\n                )");
            String qqStr2 = HardCodeUtil.qqStr(R.string.f238967l7);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026a_material_privacy_title)");
            this.mDialog = new com.tencent.mobileqq.wink.view.al(context, function0, function02, "https://rule.tencent.com/rule/202312250003", qqStr, qqStr2);
        }
        com.tencent.mobileqq.wink.view.al alVar = this.mDialog;
        Intrinsics.checkNotNull(alVar);
        if (alVar.isShowing() || !needShow) {
            return;
        }
        com.tencent.mobileqq.wink.view.al alVar2 = this.mDialog;
        Intrinsics.checkNotNull(alVar2);
        alVar2.show();
    }

    private final void R(boolean show, Object material) {
        Intrinsics.checkNotNull(material, "null cannot be cast to non-null type com.tencent.ttpic.openapi.model.VideoMaterial");
        VideoMaterial videoMaterial = (VideoMaterial) material;
        ArrayList<AEMaterialMetaData> arrayList = this.mTemplateList;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (videoMaterial.getId() != null && Intrinsics.areEqual(videoMaterial.getId(), arrayList.get(i3).f69050id)) {
                arrayList.get(i3).editablewatermark = show;
                notifyItemChanged(i3, 1);
                return;
            }
        }
    }

    private final void w(AEMaterialMetaData info) {
        this.mPendingReportMaterialIds.remove(info.f69050id);
    }

    private final void x(AEMaterialMetaData data) {
        ms.a.f("AEFlashShowMaterialAdapter", "start download material id = " + data.f69050id);
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        if (aEFlashShowMaterialManager != null) {
            aEFlashShowMaterialManager.r0(aEFlashShowMaterialManager.getApp(), data, this);
        }
    }

    private final int z(AEMaterialMetaData info) {
        int size = this.mTemplateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(this.mTemplateList.get(i3).f69050id, info.f69050id)) {
                return i3;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(dq viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(position);
        Intrinsics.checkNotNullExpressionValue(aEMaterialMetaData, "mTemplateList[position]");
        AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
        if (!aEMaterialMetaData2.usable) {
            aEMaterialMetaData2.usable = AEMaterialManager.W(aEMaterialMetaData2);
        }
        if (Intrinsics.areEqual(aEMaterialMetaData2, AEFlashShowMaterialManager.INSTANCE.c()) && aEMaterialMetaData2.usable) {
            viewHolder.d(2, aEMaterialMetaData2);
        } else {
            aEMaterialMetaData2.editablewatermark = false;
            viewHolder.d(1, aEMaterialMetaData2);
        }
        VideoReport.setElementId(viewHolder.itemView, "em_xsj_props_item");
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.aelight.camera.ae.flashshow.ab.c().g());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, aEMaterialMetaData2.f69050id);
        AEMaterialCategory aEMaterialCategory = this.mCategory;
        String str = aEMaterialCategory != null ? aEMaterialCategory.f69047h : null;
        if (str == null) {
            str = "none";
        }
        hashMap.put("xsj_props_category", str);
        VideoReport.setElementParams(viewHolder.itemView, hashMap);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public dq onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = this.mLayoutInflater.inflate(R.layout.dln, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "mLayoutInflater.inflate(\u2026l_item, viewGroup, false)");
        dq dqVar = new dq(inflate);
        dqVar.b(this.mContext);
        inflate.setOnClickListener(this);
        return dqVar;
    }

    public final void L(AEMaterialMetaData info) {
        Intent intent;
        Intrinsics.checkNotNullParameter(info, "info");
        String str = info.f69050id;
        this.mLastSelectedMaterialId = str;
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        if (aEFlashShowMaterialManager != null) {
            if (str == null) {
                str = "";
            }
            aEFlashShowMaterialManager.n0(str);
        }
        info.usable = AEMaterialManager.W(info);
        ms.a.f("AEFlashShowMaterialAdapter", "\u3010Select Material\u3011\uff1a" + info.f69050id);
        ms.a.f("AEFlashShowMaterialAdapter", "\u3010Select Material\u3011Usable :" + info.usable);
        if (!TextUtils.isEmpty(info.f69050id) && !AEMaterialMetaData.isNoneMaterial(info)) {
            xq.c cVar = xq.c.f448345a;
            if (cVar.f(info)) {
                xq.f.f448355a.f();
            }
            if (info.usable) {
                if (!AEResUtil.d0()) {
                    AEFlashShowMaterialManager aEFlashShowMaterialManager2 = this.mTemplateManager;
                    if (aEFlashShowMaterialManager2 != null) {
                        aEFlashShowMaterialManager2.m0(info, !this.isFavoriteTab);
                    }
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f169909y92), 0).show();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bf
                        @Override // java.lang.Runnable
                        public final void run() {
                            AEFlashShowMaterialAdapter.M();
                        }
                    }, 64, null, true);
                    return;
                }
                AEFlashShowMaterialManager aEFlashShowMaterialManager3 = this.mTemplateManager;
                if (aEFlashShowMaterialManager3 != null) {
                    aEFlashShowMaterialManager3.m0(info, true ^ this.isFavoriteTab);
                }
                AEFlashShowMaterialPanel.a aVar = this.mMaterialPanelListener;
                if (aVar != null) {
                    aVar.a(info);
                }
                if (cVar.f(info)) {
                    xq.f.f448355a.c(cVar.d(info));
                    if (cVar.e(info)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bg
                            @Override // java.lang.Runnable
                            public final void run() {
                                AEFlashShowMaterialAdapter.N(AEFlashShowMaterialAdapter.this);
                            }
                        });
                    }
                }
                ms.a.a("AEFlashShowMaterialAdapter", "### [material panel] select material " + info.f69050id);
                return;
            }
            AEFlashShowMaterialPanel.a aVar2 = this.mMaterialPanelListener;
            if (aVar2 != null) {
                aVar2.f(info);
            }
            y(info);
            return;
        }
        AEFlashShowMaterialPanel.a aVar3 = this.mMaterialPanelListener;
        if (aVar3 != null) {
            aVar3.c();
        }
        AEFlashShowMaterialManager aEFlashShowMaterialManager4 = this.mTemplateManager;
        if (aEFlashShowMaterialManager4 != null) {
            aEFlashShowMaterialManager4.m0(AEMaterialMetaData.MATERIAL_NONE, !this.isFavoriteTab);
        }
        Context context = this.mContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        intent.removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
    }

    public final void P(AEMaterialMetaData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ms.a.a("AEFlashShowMaterialAdapter", "### setMaterialWithProtoDialog ");
        ms.a.a("AEFlashShowMaterialAdapter", "### setMaterialWithProtoDialog " + info.aigcMaterial);
        boolean c16 = com.tencent.mobileqq.wink.utils.ar.f326685a.c("ae_key_editor_camera_proto", true);
        Boolean bool = info.aigcMaterial;
        Intrinsics.checkNotNullExpressionValue(bool, "info.aigcMaterial");
        if (bool.booleanValue() && c16) {
            Q(info, c16);
            ms.a.a("AEFlashShowMaterialAdapter", "### showPrivcyPotoDialog ");
        } else {
            L(info);
        }
    }

    public final void S(AEMaterialCategory category) {
        this.mCategory = category;
        this.mTemplateList.clear();
        if ((category != null ? category.f69044d : null) != null) {
            List<AEMaterialMetaData> list = category.f69044d;
            Intrinsics.checkNotNullExpressionValue(list, "category.materialList");
            for (AEMaterialMetaData aEMaterialMetaData : list) {
                if (AEFlashShowMaterialManager.INSTANCE.e(aEMaterialMetaData)) {
                    ms.a.a("AEFlashShowMaterialAdapter", "needHide " + (aEMaterialMetaData != null ? aEMaterialMetaData.f69050id : null));
                } else {
                    this.mTemplateList.add(aEMaterialMetaData);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTemplateList.size();
    }

    @Override // yq2.c
    public void notify(Object sender, int eventId, Object... args) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(args, "args");
        if (eventId == 111) {
            if ((!(args.length == 0)) && (args[0] instanceof AEMaterialCategory) && this.isFavoriteTab) {
                ms.a.a("AEFlashShowMaterialAdapter", "recent template update");
                Object obj = args[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory");
                S((AEMaterialCategory) obj);
                notifyDataSetChanged();
                return;
            }
            return;
        }
        if (eventId != 1024) {
            switch (eventId) {
                case 113:
                    if (AEFlashShowMaterialManager.INSTANCE.c() != null) {
                        notifyDataSetChanged();
                        return;
                    }
                    return;
                case 114:
                    if (args.length == 1) {
                        R(true, args[0]);
                        return;
                    }
                    return;
                case 115:
                    if (args.length == 1) {
                        R(false, args[0]);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        ms.a.a("AEFlashShowMaterialAdapter", "current watermark has change");
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int childAdapterPosition = this.mGridView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(childAdapterPosition);
            Intrinsics.checkNotNullExpressionValue(aEMaterialMetaData, "tplList[position]");
            AEMaterialMetaData MATERIAL_NONE = aEMaterialMetaData;
            AEFlashShowMaterialManager.Companion companion = AEFlashShowMaterialManager.INSTANCE;
            AEMaterialMetaData c16 = companion.c();
            AEMaterialMetaData c17 = companion.c();
            String str = c17 != null ? c17.f69050id : null;
            this.mLastSelectedMaterialId = str;
            if (str != null && Intrinsics.areEqual(str, MATERIAL_NONE.f69050id)) {
                boolean z16 = false;
                if (c16 != null && c16.editablewatermark) {
                    z16 = true;
                }
                if (!z16) {
                    MATERIAL_NONE = AEMaterialMetaData.MATERIAL_NONE;
                    Intrinsics.checkNotNullExpressionValue(MATERIAL_NONE, "MATERIAL_NONE");
                }
            }
            K(MATERIAL_NONE);
            if (MATERIAL_NONE.ischoose) {
                MATERIAL_NONE.isdoubleclick = true;
            } else {
                MATERIAL_NONE.ischoose = true;
            }
            P(MATERIAL_NONE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ms.a.a("AEFlashShowMaterialAdapter", "onDetachedFromRecyclerView");
        this.mPendingReportMaterialIds.clear();
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onDownloadFinish(final AEMaterialMetaData info, final boolean isSuccess, int resCode) {
        Intrinsics.checkNotNullParameter(info, "info");
        ms.a.f("AEFlashShowMaterialAdapter", " onDownloadFinish info = " + info.f69050id + ", success = " + isSuccess);
        final int z16 = z(info);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("position = ");
        sb5.append(z16);
        ms.a.f("AEFlashShowMaterialAdapter", sb5.toString());
        if (z16 < 0) {
            return;
        }
        AEFlashShowMaterialPanel.a aVar = this.mMaterialPanelListener;
        if (aVar != null) {
            aVar.e(info, isSuccess);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bc
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialAdapter.F(AEFlashShowMaterialAdapter.this, z16, info, isSuccess);
            }
        });
        if (!isSuccess) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bd
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowMaterialAdapter.D(AEFlashShowMaterialAdapter.this);
                }
            });
            return;
        }
        xq.c cVar = xq.c.f448345a;
        if (cVar.f(info)) {
            xq.f.f448355a.c(cVar.d(info));
            if (cVar.e(info)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.be
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowMaterialAdapter.E(AEFlashShowMaterialAdapter.this);
                    }
                });
            }
        }
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onProgressUpdate(AEMaterialMetaData info, int progress) {
        Intrinsics.checkNotNullParameter(info, "info");
        ms.a.f("AEFlashShowMaterialAdapter", "onProgressUpdate, id = " + info.f69050id + ", progress = " + progress);
        final int z16 = z(info);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bb
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialAdapter.G(AEFlashShowMaterialAdapter.this, z16);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(dq holder) {
        if (holder != null) {
            int adapterPosition = holder.getAdapterPosition();
            AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(adapterPosition);
            Intrinsics.checkNotNullExpressionValue(aEMaterialMetaData, "mTemplateList[adapterPosition]");
            AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
            ms.a.a("AEFlashShowMaterialAdapter", "onViewAttachedToWindow---position=" + adapterPosition + ", material=" + (aEMaterialMetaData2 != null ? aEMaterialMetaData2.f69050id : null));
            if (aEMaterialMetaData2 != null) {
                J(aEMaterialMetaData2);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(dq holder) {
        int adapterPosition;
        if (holder == null || (adapterPosition = holder.getAdapterPosition()) < 0 || adapterPosition >= this.mTemplateList.size()) {
            return;
        }
        AEMaterialMetaData aEMaterialMetaData = this.mTemplateList.get(adapterPosition);
        Intrinsics.checkNotNullExpressionValue(aEMaterialMetaData, "mTemplateList[adapterPosition]");
        AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
        ms.a.a("AEFlashShowMaterialAdapter", "onViewDetachedFromWindow---position=" + adapterPosition + ", material=" + (aEMaterialMetaData2 != null ? aEMaterialMetaData2.f69050id : null));
        if (aEMaterialMetaData2 != null) {
            w(aEMaterialMetaData2);
        }
    }

    private final void y(AEMaterialMetaData data) {
        if (data == null || data.downloading || TextUtils.isEmpty(data.f69050id) || this.mTemplateManager == null) {
            return;
        }
        x(data);
    }

    public final void O(AEMaterialMetaData info) {
        if (info == null) {
            return;
        }
        ms.a.f("AEFlashShowMaterialAdapter", "selectSpecificMaterialDownload \uff1a" + info.usable);
        boolean W = AEMaterialManager.W(info);
        info.usable = W;
        if (W) {
            return;
        }
        y(info);
    }
}
