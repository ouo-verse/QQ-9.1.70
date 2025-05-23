package com.tencent.biz.qqcircle.immersive.search.prompt.guessword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptGuessInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/g;", "", "Lcirclesearch/CircleSearchExhibition$PromptGuessInfo;", "list", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "j0", "Lcooperation/qqcircle/report/QCircleReportBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "data", "<init>", "(Lcooperation/qqcircle/report/QCircleReportBean;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends RecyclerView.Adapter<g> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<CircleSearchExhibition$PromptGuessInfo> data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleReportBean reportBean;

    public c(@NotNull QCircleReportBean reportBean) {
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        this.reportBean = reportBean;
        this.data = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(c this$0, CircleSearchExhibition$PromptGuessInfo info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(info.name.get());
        qFSSearchInfo.j(7);
        QCirclePluginUtil.getQCircleBaseFragment(view.getContext()).getPartManager().broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
        Context context = view.getContext();
        QCircleReportBean qCircleReportBean = this$0.reportBean;
        cf.a(context, 5107, qCircleReportBean, QCircleReportBean.getPageId("QFSSearchPromptGuessWordAdapter", qCircleReportBean), qFSSearchInfo.f());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull g holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CircleSearchExhibition$PromptGuessInfo circleSearchExhibition$PromptGuessInfo = this.data.get(position);
        holder.l(circleSearchExhibition$PromptGuessInfo, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.guessword.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.k0(c.this, circleSearchExhibition$PromptGuessInfo, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168750gr0, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new g(itemView);
    }

    public final void setData(@Nullable List<CircleSearchExhibition$PromptGuessInfo> list) {
        this.data.clear();
        if (list == null) {
            QLog.w("QFSSearchPromptGuessWordAdapter", 1, "[setData] empty data");
        } else {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }
}
