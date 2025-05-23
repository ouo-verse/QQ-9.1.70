package com.tencent.mobileqq.guild.aisearch.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.history.itemholder.AIChatHistorySessionHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uy1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001)B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b&\u0010'J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J&\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Luy1/i;", "", "Lcom/tencent/mobileqq/guild/aisearch/history/a;", "newDataList", "", "setDataList", "", "position", "", "r", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "I", "holder", "d", "getItemCount", "viewType", "onCreateViewHolder", "p0", "p1", "onBindViewHolder", "", "", "payloads", "getItemViewType", "Lcom/tencent/mobileqq/guild/aisearch/history/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/aisearch/history/h;", "notifyCallback", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/aisearch/history/g;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "dataList", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/history/h;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements i<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<g> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h notifyCallback;

    public c(@NotNull h notifyCallback) {
        Intrinsics.checkNotNullParameter(notifyCallback, "notifyCallback");
        this.notifyCallback = notifyCallback;
        this.dataList = new ArrayList<>();
    }

    @Override // uy1.i
    @NotNull
    public RecyclerView.ViewHolder I(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edq, parent, false);
        view.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new com.tencent.mobileqq.guild.aisearch.history.itemholder.a(view);
    }

    @Override // uy1.i
    public void d(@NotNull RecyclerView.ViewHolder holder, int position) {
        com.tencent.mobileqq.guild.aisearch.history.itemholder.a aVar;
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AIChatHistorySessionItem aIChatHistorySessionItem = null;
        if (holder instanceof com.tencent.mobileqq.guild.aisearch.history.itemholder.a) {
            aVar = (com.tencent.mobileqq.guild.aisearch.history.itemholder.a) holder;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
            if (orNull instanceof AIChatHistorySessionItem) {
                aIChatHistorySessionItem = (AIChatHistorySessionItem) orNull;
            }
            if (aIChatHistorySessionItem == null) {
                return;
            }
            aVar.bindData(aIChatHistorySessionItem.getGroupTitle());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        g gVar = (g) orNull;
        if (gVar instanceof AIChatHistoryGroupItem) {
            return 1;
        }
        boolean z16 = gVar instanceof AIChatHistorySessionItem;
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edq, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new com.tencent.mobileqq.guild.aisearch.history.itemholder.a(view);
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.eds, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new AIChatHistorySessionHolder(view2, this.notifyCallback);
    }

    @Override // uy1.i
    public long r(int position) {
        Object orNull;
        AIChatHistorySessionItem aIChatHistorySessionItem;
        boolean z16;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        g gVar = (g) orNull;
        if (gVar == null) {
            return -1L;
        }
        if (gVar instanceof AIChatHistorySessionItem) {
            aIChatHistorySessionItem = (AIChatHistorySessionItem) gVar;
        } else {
            aIChatHistorySessionItem = null;
        }
        if (aIChatHistorySessionItem == null) {
            return -1L;
        }
        if (aIChatHistorySessionItem.getGroupTitle().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return -1L;
        }
        return b.a(aIChatHistorySessionItem.getGroupTitle().hashCode());
    }

    public final void setDataList(@NotNull List<AIChatHistoryGroupItem> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        Logger.f235387a.d().d("AIChatHistoryListAdapter", 1, "[setDataList] newDataList " + newDataList.size());
        this.dataList.clear();
        int i3 = 0;
        for (AIChatHistoryGroupItem aIChatHistoryGroupItem : newDataList) {
            i3++;
            for (AIChatHistorySessionItem aIChatHistorySessionItem : aIChatHistoryGroupItem.b()) {
                aIChatHistorySessionItem.f(aIChatHistoryGroupItem.getGroupTitle());
                aIChatHistorySessionItem.g(i3);
                this.dataList.add(aIChatHistorySessionItem);
                i3++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<Object> payloads) {
        Object orNull;
        Object orNull2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger.f235387a.d().d("AIChatHistoryListAdapter", 1, "[onBindViewHolder] position: " + position + ", payloads: " + payloads);
        if (holder instanceof com.tencent.mobileqq.guild.aisearch.history.itemholder.a) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
            AIChatHistoryGroupItem aIChatHistoryGroupItem = orNull2 instanceof AIChatHistoryGroupItem ? (AIChatHistoryGroupItem) orNull2 : null;
            if (aIChatHistoryGroupItem != null) {
                ((com.tencent.mobileqq.guild.aisearch.history.itemholder.a) holder).bindData(aIChatHistoryGroupItem.getGroupTitle());
                return;
            }
            return;
        }
        if (holder instanceof AIChatHistorySessionHolder) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
            AIChatHistorySessionItem aIChatHistorySessionItem = orNull instanceof AIChatHistorySessionItem ? (AIChatHistorySessionItem) orNull : null;
            if (aIChatHistorySessionItem != null) {
                ((AIChatHistorySessionHolder) holder).t(aIChatHistorySessionItem, payloads);
            }
        }
    }
}
