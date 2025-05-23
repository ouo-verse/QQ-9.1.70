package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCard;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B)\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u0012\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u001e\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "list", "", "i0", "", "position", "", "getItemId", "", "items", "setItems", "Ljava/lang/Runnable;", "callback", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onDetachedFromRecyclerView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/b;", "scrollDispatcher", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "delegatesManager", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedSquareListAdapter extends d<com.tencent.mobileqq.guild.feed.feedsquare.data.h> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b scrollDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareListAdapter(@NotNull DiffUtil.ItemCallback<com.tencent.mobileqq.guild.feed.feedsquare.data.h> diffCallback, @NotNull AdapterDelegatesManager<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>> delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        this.scrollDispatcher = new b(this);
    }

    private final void i0(List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> list) {
        boolean z16;
        GProRecommendCard gProRecommendCard;
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GProStFeed b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) obj).getBlockData().b();
            if (b16 != null && (gProRecommendCard = b16.recommendCard) != null && gProRecommendCard.cardType == 5) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (i3 > 0) {
                    list.get(i3 - 1).getBlockData().x(true);
                }
                if (i3 < list.size() - 1) {
                    list.get(i16).getBlockData().y(true);
                }
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.differ.getCurrentList().get(position)).getBlockData().b().idd.hashCode();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.scrollDispatcher.b(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.scrollDispatcher.c(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.scrollDispatcher.d(holder);
        QLog.d("GuildFeedSquareListAdapter", 4, "onViewAttachedToWindow:" + holder.getAdapterPosition() + "  " + holder + "  " + this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        this.scrollDispatcher.e(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(items, "items");
        i0(items);
        super.setItems(items);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(items, ", ", null, null, 0, null, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter$setItems$ids$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String str = item.getBlockData().b().idd;
                Intrinsics.checkNotNullExpressionValue(str, "item.blockData.sourceData.idd");
                return str;
            }
        }, 30, null);
        QLog.d("GuildFeedSquareListAdapter", 1, "GuildFeedSquareList setItems: " + items.size() + ", Item IDs: " + joinToString$default + " ");
        this.scrollDispatcher.h(items);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@NotNull List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> items, @Nullable Runnable callback) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(items, "items");
        i0(items);
        super.setItems(items, callback);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(items, ", ", null, null, 0, null, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter$setItems$ids$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String str = item.getBlockData().b().idd;
                Intrinsics.checkNotNullExpressionValue(str, "item.blockData.sourceData.idd");
                return str;
            }
        }, 30, null);
        QLog.i("GuildFeedSquareListAdapter", 1, "GuildFeedSquareList setItems : " + items.size() + ", Item IDs: " + joinToString$default);
        this.scrollDispatcher.h(items);
    }
}
