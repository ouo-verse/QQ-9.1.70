package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003;<=B\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016R\u0016\u0010%\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R*\u00107\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "arrowView", "", "j0", "", "", "", "o0", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$EditState;", "p0", "", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "infos", "setData", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$ArrowState;", "state", "", "notifyChanged", "k0", ReportConstant.COSTREPORT_PREFIX, "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewTyp", "onCreateViewHolder", "getItemCount", "position", "getItemViewType", "holder", "onBindViewHolder", "Lcooperation/qqcircle/report/QCircleReportBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "data", "D", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$EditState;", "editState", "E", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$ArrowState;", "arrowState", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "getOnArrowClick", "()Lkotlin/jvm/functions/Function0;", "r0", "(Lkotlin/jvm/functions/Function0;)V", "onArrowClick", "<init>", "(Lcooperation/qqcircle/report/QCircleReportBean;)V", "G", "ArrowState", "a", "EditState", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptHistoryFlexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<QFSSearchHistoryItemInfo> data = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private EditState editState = EditState.NORMAL;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrowState arrowState = ArrowState.NONE;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onArrowClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleReportBean reportBean;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$ArrowState;", "", "(Ljava/lang/String;I)V", "NONE", "UP", "DOWN", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum ArrowState {
        NONE,
        UP,
        DOWN
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryFlexAdapter$EditState;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "EDIT", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum EditState {
        NORMAL,
        EDIT
    }

    public QFSSearchPromptHistoryFlexAdapter(@Nullable QCircleReportBean qCircleReportBean) {
        this.reportBean = qCircleReportBean;
    }

    private final void j0(View arrowView) {
        VideoReport.setElementId(arrowView, QCircleDaTongConstant.ElementId.EM_XSJ_UNFOLD_BUTTON);
        VideoReport.setElementParams(arrowView, o0());
        VideoReport.setElementExposePolicy(arrowView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(arrowView, ClickPolicy.REPORT_NONE);
    }

    public static /* synthetic */ void l0(QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter, ArrowState arrowState, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        qFSSearchPromptHistoryFlexAdapter.k0(arrowState, z16);
    }

    public static /* synthetic */ void n0(QFSSearchPromptHistoryFlexAdapter qFSSearchPromptHistoryFlexAdapter, EditState editState, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        qFSSearchPromptHistoryFlexAdapter.m0(editState, z16);
    }

    private final Map<String, Object> o0() {
        String str;
        if (this.arrowState == ArrowState.UP) {
            str = "open";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW;
        }
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
        return params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(View view, QFSSearchPromptHistoryFlexAdapter this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("dt_clck", view, this$0.o0());
        Function0<Unit> function0 = this$0.onArrowClick;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.arrowState == ArrowState.NONE) {
            return this.data.size();
        }
        return this.data.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.arrowState == ArrowState.NONE || position < this.data.size()) {
            return 1;
        }
        return 2;
    }

    public final void k0(@NotNull ArrowState state, boolean notifyChanged) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.arrowState = state;
        if (notifyChanged) {
            notifyDataSetChanged();
        }
    }

    public final void m0(@NotNull EditState s16, boolean notifyChanged) {
        Intrinsics.checkNotNullParameter(s16, "s");
        this.editState = s16;
        if (notifyChanged) {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z16 = true;
        if (holder instanceof f) {
            f fVar = (f) holder;
            QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo = this.data.get(position);
            if (this.editState != EditState.EDIT) {
                z16 = false;
            }
            fVar.n(qFSSearchHistoryItemInfo, z16, position, this.reportBean);
            return;
        }
        if (holder instanceof c) {
            c cVar = (c) holder;
            if (this.arrowState != ArrowState.UP) {
                z16 = false;
            }
            cVar.l(z16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewTyp) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewTyp == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grm, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new f(view);
        }
        final View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.grl, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        j0(view2);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSSearchPromptHistoryFlexAdapter.q0(view2, this, view3);
            }
        });
        return new c(view2);
    }

    @NotNull
    /* renamed from: p0, reason: from getter */
    public final EditState getEditState() {
        return this.editState;
    }

    public final void r0(@Nullable Function0<Unit> function0) {
        this.onArrowClick = function0;
    }

    public final void setData(@Nullable List<? extends QFSSearchHistoryItemInfo> infos) {
        this.data.clear();
        if (infos != null) {
            this.data.addAll(infos);
        }
        notifyDataSetChanged();
    }
}
