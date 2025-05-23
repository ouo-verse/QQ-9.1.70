package com.tencent.mobileqq.guild.main.topchannel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.au;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002#$B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/adapter/a;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/FeedTopCardItemHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "l0", "getItemCount", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "newData", "setDataList", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/a$b;", "listener", "m0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "feedSummaryList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/a$b;", "itemClickListener", "<init>", "()V", "D", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends DownToUpViewSwitcher.d<FeedTopCardItemHolder> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProFeedSummary> feedSummaryList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/adapter/a$b;", "", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "data", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@NotNull View view, @NotNull IGProFeedSummary data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.feedSummaryList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull FeedTopCardItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("Guild.MF.Sticky.FeedTopCardAdapter", 1, "onBindViewHolder: position[" + position + "] feedId:" + this.feedSummaryList.get(position).getFeedId());
        holder.q(this);
        holder.n(this.feedSummaryList.get(position));
    }

    @Override // com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher.d
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public FeedTopCardItemHolder i0(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraceUtils.h("topCard_feed_item_create");
        au g16 = au.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        FeedTopCardItemHolder feedTopCardItemHolder = new FeedTopCardItemHolder(g16);
        TraceUtils.k();
        return feedTopCardItemHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull FeedTopCardItemHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.p();
    }

    public final void m0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Object obj;
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Object obj2 = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj != null) {
            if (view != null) {
                obj2 = view.getTag();
            }
            if ((obj2 instanceof IGProFeedSummary) && (bVar = this.itemClickListener) != null) {
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary");
                bVar.a(view, (IGProFeedSummary) tag);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setDataList(@NotNull List<? extends IGProFeedSummary> newData) {
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(newData, "newData");
        QLog.i("Guild.MF.Sticky.FeedTopCardAdapter", 1, "setDataList: size[" + newData.size() + "]");
        list = CollectionsKt___CollectionsKt.toList(this.feedSummaryList);
        this.feedSummaryList.clear();
        this.feedSummaryList.addAll(newData);
        list2 = CollectionsKt___CollectionsKt.toList(this.feedSummaryList);
        DiffUtil.calculateDiff(new c(list, list2)).dispatchUpdatesTo(this);
    }
}
