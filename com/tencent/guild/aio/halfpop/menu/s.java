package com.tencent.guild.aio.halfpop.menu;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/s;", "", "Lcom/tencent/guild/aio/halfpop/menu/p;", "a", "Lcom/tencent/guild/aio/halfpop/menu/p;", "()Lcom/tencent/guild/aio/halfpop/menu/p;", "color", "Lcom/tencent/guild/aio/halfpop/menu/q;", "b", "Lcom/tencent/guild/aio/halfpop/menu/q;", "()Lcom/tencent/guild/aio/halfpop/menu/q;", "drawable", "Lcom/tencent/guild/aio/halfpop/menu/r;", "lp", "Lcom/tencent/guild/aio/halfpop/menu/r;", "c", "()Lcom/tencent/guild/aio/halfpop/menu/r;", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/p;Lcom/tencent/guild/aio/halfpop/menu/q;Lcom/tencent/guild/aio/halfpop/menu/r;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final p color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final q drawable;

    public s(@Nullable p pVar, @Nullable q qVar, @Nullable r rVar) {
        this.color = pVar;
        this.drawable = qVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final p getColor() {
        return this.color;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final q getDrawable() {
        return this.drawable;
    }

    @Nullable
    public final r c() {
        return null;
    }

    public /* synthetic */ s(p pVar, q qVar, r rVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pVar, qVar, (i3 & 4) != 0 ? null : rVar);
    }
}
