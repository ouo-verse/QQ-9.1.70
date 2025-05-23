package com.tencent.timi.game.liveroom.impl.room.medal;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&R\u0017\u0010\t\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "T", "", "", "c", "b", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(Ljava/lang/Object;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T data;

    public g(T t16) {
        this.data = t16;
    }

    public final T a() {
        return this.data;
    }

    public abstract int b();

    public abstract int c();
}
