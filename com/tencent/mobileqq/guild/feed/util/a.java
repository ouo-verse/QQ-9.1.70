package com.tencent.mobileqq.guild.feed.util;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004J\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004J\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/a;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "Lcom/tencent/mvi/base/route/j;", "messenger", "d", "c", "b", "e", "Lcom/tencent/mobileqq/guild/feed/util/bf;", "Lcom/tencent/mobileqq/guild/feed/util/bf;", "handler", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/g;", "subscribe", "Lcom/tencent/mvi/base/route/b;", "f", "Lcom/tencent/mvi/base/route/b;", "_actionR1", "<init>", "(Lcom/tencent/mobileqq/guild/feed/util/bf;Lcom/tencent/mvi/base/route/g;)V", "", "bothProtocol", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.mvi.base.route.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bf handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.g subscribe;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.base.route.b _actionR1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/util/a$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7781a implements com.tencent.mvi.base.route.b {
        C7781a() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return a.this.handler.I(intent);
        }
    }

    public a(@NotNull bf handler, @NotNull com.tencent.mvi.base.route.g subscribe) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        this.handler = handler;
        this.subscribe = subscribe;
    }

    public final void b(@NotNull com.tencent.mvi.base.route.j messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        d(messenger);
        c(messenger);
    }

    public final void c(@NotNull com.tencent.mvi.base.route.j messenger) {
        boolean z16;
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        Set<String> subscribeEventRNames = this.subscribe.getSubscribeEventRNames();
        if (subscribeEventRNames != null && !subscribeEventRNames.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        C7781a c7781a = new C7781a();
        messenger.l(this.subscribe, c7781a);
        this._actionR1 = c7781a;
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        this.handler.E(i3);
    }

    public final void d(@NotNull com.tencent.mvi.base.route.j messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        messenger.f(this.subscribe, this);
    }

    public final void e(@NotNull com.tencent.mvi.base.route.j messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        messenger.i(this.subscribe, this);
        if (this._actionR1 != null) {
            messenger.e(this.subscribe);
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        return a.C9235a.a(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Object bothProtocol) {
        this((bf) bothProtocol, (com.tencent.mvi.base.route.g) bothProtocol);
        Intrinsics.checkNotNullParameter(bothProtocol, "bothProtocol");
    }
}
