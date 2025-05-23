package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelListenCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelLiveCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelNormalMediaCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelScreenShareCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelSmobaMediaCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.EmptyPageAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.LoadingAdapterDelegate;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\b\tB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/ChannelCardAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lgi1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "I", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelCardAdapter extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<gi1.b> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.hotlive.ChannelCardAdapter$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<View, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, d.class, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "onRefresh(Landroid/view/View;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull View p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((d) this.receiver).b(p06);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/ChannelCardAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lgi1/b;", "oldItem", "newItem", "", "b", "a", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b extends DiffUtil.ItemCallback<gi1.b> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull gi1.b oldItem, @NotNull gi1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull gi1.b oldItem, @NotNull gi1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull gi1.b oldItem, @NotNull gi1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelCardAdapter(@NotNull d channelCardControl) {
        super(new b());
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.f236209m.c(new ChannelNormalMediaCardAdapterDelegate(channelCardControl)).c(new ChannelListenCardAdapterDelegate(channelCardControl)).c(new ChannelSmobaMediaCardAdapterDelegate(channelCardControl)).c(new ChannelLiveCardAdapterDelegate(channelCardControl)).c(new ChannelScreenShareCardAdapterDelegate(channelCardControl)).c(new LoadingAdapterDelegate()).c(new EmptyPageAdapterDelegate(new AnonymousClass1(channelCardControl)));
    }
}
