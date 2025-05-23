package cg1;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelFeedCardAdapterDelegate;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelLiveCardAdapterDelegate;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelMediaCardAdapterDelegate;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelScreenShareCardAdapterDelegate;
import com.tencent.mobileqq.guild.channelcard.delegate.ChannelTextCardAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a8\u0006\u0012"}, d2 = {"Lcg1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Ldg1/b;", "", "position", "", "getItemId", "", "newList", "", "submitList", "Lcg1/b;", "channelCardControl", "<init>", "(Lcg1/b;)V", "I", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends d<dg1.b> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcg1/a$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ldg1/b;", "oldItem", "newItem", "", "b", "a", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class b extends DiffUtil.ItemCallback<dg1.b> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull dg1.b oldItem, @NotNull dg1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull dg1.b oldItem, @NotNull dg1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull dg1.b oldItem, @NotNull dg1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull cg1.b channelCardControl) {
        super(new b());
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.f236209m.c(new ChannelTextCardAdapterDelegate(channelCardControl));
        this.f236209m.c(new ChannelFeedCardAdapterDelegate(channelCardControl));
        this.f236209m.c(new ChannelMediaCardAdapterDelegate(channelCardControl));
        this.f236209m.c(new ChannelLiveCardAdapterDelegate(channelCardControl));
        this.f236209m.c(new ChannelScreenShareCardAdapterDelegate(channelCardControl));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getChannelId();
    }

    public final void submitList(@NotNull List<? extends dg1.b> newList) {
        List list;
        Intrinsics.checkNotNullParameter(newList, "newList");
        AsyncListDiffer<T> asyncListDiffer = this.C;
        list = CollectionsKt___CollectionsKt.toList(newList);
        asyncListDiffer.submitList(list);
    }
}
