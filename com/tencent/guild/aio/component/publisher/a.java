package com.tencent.guild.aio.component.publisher;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/a;", "Lol3/b;", "<init>", "()V", "a", "Lcom/tencent/guild/aio/component/publisher/a$a;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/a$a;", "Lcom/tencent/guild/aio/component/publisher/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "d", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "a", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.publisher.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1181a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.Adapter<?> adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1181a(@NotNull RecyclerView.Adapter<?> adapter) {
            super(null);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
        }

        @NotNull
        public final RecyclerView.Adapter<?> a() {
            return this.adapter;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
