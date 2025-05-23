package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "i0", "", "Lcirclesearch/CircleSearchExhibition$TextIconStyleData;", "list", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "viewHolder", "position", "onBindViewHolder", "getItemViewType", "Lcooperation/qqcircle/report/QCircleReportBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "data", "D", "Ljava/lang/String;", "moreUrl", "<init>", "(Lcooperation/qqcircle/report/QCircleReportBean;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<CircleSearchExhibition$TextIconStyleData> data = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String moreUrl = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleReportBean reportBean;

    public e(@Nullable QCircleReportBean qCircleReportBean) {
        this.reportBean = qCircleReportBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        boolean isBlank;
        int size = this.data.size();
        isBlank = StringsKt__StringsJVMKt.isBlank(this.moreUrl);
        if (!isBlank) {
            return size + 1;
        }
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position < this.data.size()) {
            return 1;
        }
        return 2;
    }

    public final void i0(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.d("QFSSearchPromptRankListTextAdapter", 1, "[setMoreUrl] " + url);
        this.moreUrl = url;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof QFSSearchPromptRankListTextViewHolder) {
            CircleSearchExhibition$TextIconStyleData circleSearchExhibition$TextIconStyleData = this.data.get(position);
            ((QFSSearchPromptRankListTextViewHolder) viewHolder).n(circleSearchExhibition$TextIconStyleData);
            b.f89965a.a(viewHolder.itemView, circleSearchExhibition$TextIconStyleData.reportInfo);
        } else if (viewHolder instanceof d) {
            ((d) viewHolder).m(this.moreUrl);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grd, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(itemView);
        }
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.grb, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        return new QFSSearchPromptRankListTextViewHolder(itemView2, this.reportBean);
    }

    public final void setData(@NotNull List<CircleSearchExhibition$TextIconStyleData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }
}
