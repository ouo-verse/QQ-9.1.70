package com.tencent.mobileqq.guild.channellist;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.channellist.delegate.AppChannelAdapterDelegate;
import com.tencent.mobileqq.guild.channellist.delegate.CreateChannelAdapterDelegate;
import com.tencent.mobileqq.guild.channellist.delegate.EmptyPageAdapterDelegate;
import com.tencent.mobileqq.guild.channellist.delegate.GuildSpaceAdapterDelegate;
import com.tencent.mobileqq.guild.channellist.delegate.TextChannelAdapterDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/b;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/channellist/c;", "Leg1/a;", "I", "Leg1/a;", "getEventHandler", "()Leg1/a;", "setEventHandler", "(Leg1/a;)V", "eventHandler", "Lcom/tencent/mobileqq/activity/recent/cur/b;", "dragHost", "<init>", "(Lcom/tencent/mobileqq/activity/recent/cur/b;Leg1/a;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<c> {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private eg1.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/b$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/channellist/c;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.b$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channellist/b$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/channellist/c;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.channellist.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7688a extends DiffUtil.ItemCallback<c> {
            C7688a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull c oldItem, @NotNull c newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.a(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull c oldItem, @NotNull c newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.b(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object getChangePayload(@NotNull c oldItem, @NotNull c newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.c(newItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<c> b() {
            return new C7688a();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.mobileqq.activity.recent.cur.b dragHost, @NotNull eg1.a eventHandler) {
        super(INSTANCE.b(), new com.tencent.mobileqq.guild.widget.adapterdelegates.h());
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
        this.f236209m.c(new EmptyPageAdapterDelegate(this.eventHandler)).c(new GuildSpaceAdapterDelegate()).c(new CreateChannelAdapterDelegate(this.eventHandler)).c(new TextChannelAdapterDelegate(dragHost, this.eventHandler)).c(new AppChannelAdapterDelegate(dragHost, this.eventHandler));
    }
}
