package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u000f\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0011\u00100\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/n;", "holder", "", "position", "", "m0", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/i;", "k0", "", "Lcom/tencent/biz/qqcircle/beans/QFSSearchHistoryItemInfo;", "list", "setData", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter$State;", ReportConstant.COSTREPORT_PREFIX, "o0", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "onBindViewHolder", "Lcooperation/qqcircle/report/QCircleReportBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "()Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "getOnHintClick", "()Lkotlin/jvm/functions/Function0;", "q0", "(Lkotlin/jvm/functions/Function0;)V", "onHintClick", "", "D", "Ljava/util/List;", "data", "E", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter$State;", "_state", "p0", "()Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter$State;", "state", "<init>", "(Lcooperation/qqcircle/report/QCircleReportBean;)V", UserInfo.SEX_FEMALE, "a", "State", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptHistoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onHintClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<QFSSearchHistoryItemInfo> data = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private State _state = State.NORMAL;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleReportBean reportBean;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/QFSSearchPromptHistoryListAdapter$State;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "COLLAPSE", "EXPAND", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum State {
        NORMAL,
        COLLAPSE,
        EXPAND
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89919a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.COLLAPSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.EXPAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f89919a = iArr;
        }
    }

    public QFSSearchPromptHistoryListAdapter(@Nullable QCircleReportBean qCircleReportBean) {
        this.reportBean = qCircleReportBean;
    }

    private final void k0(i holder) {
        if (this._state == State.COLLAPSE) {
            holder.l(R.string.f195074dm);
        } else {
            holder.l(R.string.f195084dn);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchPromptHistoryListAdapter.l0(QFSSearchPromptHistoryListAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(QFSSearchPromptHistoryListAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onHintClick;
        if (function0 != null) {
            function0.invoke();
        }
        State state = this$0._state;
        if (state == State.COLLAPSE) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_HISTORY_ALL_BUTTON);
        } else if (state == State.EXPAND) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_ALL_BUTTON);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m0(n holder, int position) {
        if (position >= this.data.size()) {
            QLog.e("QFSSearchPromptHistoryListAdapter", 1, "[onBindViewHolder] error position=" + position + ", size=" + this.data.size());
            return;
        }
        final String str = this.data.get(position).searchHistoryWord;
        holder.m(this.data.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.history.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchPromptHistoryListAdapter.n0(str, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(String str, QFSSearchPromptHistoryListAdapter this$0, View view) {
        PartManager partManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(str);
        qFSSearchInfo.j(2);
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(view.getContext());
        if (qCircleBaseFragment != null && (partManager = qCircleBaseFragment.getPartManager()) != null) {
            partManager.broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
        }
        Context context = view.getContext();
        QCircleReportBean qCircleReportBean = this$0.reportBean;
        cf.a(context, 5106, qCircleReportBean, QCircleReportBean.getPageId("", qCircleReportBean), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3 = b.f89919a[this._state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return this.data.size() + 1;
        }
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int i3 = b.f89919a[this._state.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (position < this.data.size()) {
            return 1;
        }
        return 2;
    }

    public final void o0(@NotNull State s16) {
        Intrinsics.checkNotNullParameter(s16, "s");
        this._state = s16;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof n) {
            m0((n) holder, position);
        } else if (holder instanceof i) {
            k0((i) holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grn, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new i(itemView);
        }
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168752gr2, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        return new n(itemView2);
    }

    @NotNull
    /* renamed from: p0, reason: from getter */
    public final State get_state() {
        return this._state;
    }

    public final void q0(@Nullable Function0<Unit> function0) {
        this.onHintClick = function0;
    }

    public final void setData(@Nullable List<? extends QFSSearchHistoryItemInfo> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
        }
        notifyDataSetChanged();
    }
}
