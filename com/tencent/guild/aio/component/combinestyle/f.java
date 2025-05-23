package com.tencent.guild.aio.component.combinestyle;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\nR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/f;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "sKeyIndex", "c", "I", "()I", "COMBINE_ITEM_STYLE_TYPE_DEFAULT", "d", "COMBINE_ITEM_STYLE_TYPE_ENTER_ROOM", "<init>", "()V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f110215a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger sKeyIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int COMBINE_ITEM_STYLE_TYPE_DEFAULT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int COMBINE_ITEM_STYLE_TYPE_ENTER_ROOM;

    static {
        f fVar = new f();
        f110215a = fVar;
        sKeyIndex = new AtomicInteger(19999);
        COMBINE_ITEM_STYLE_TYPE_DEFAULT = fVar.a();
        COMBINE_ITEM_STYLE_TYPE_ENTER_ROOM = fVar.a();
    }

    f() {
    }

    private final int a() {
        return sKeyIndex.incrementAndGet();
    }

    public final int b() {
        return COMBINE_ITEM_STYLE_TYPE_DEFAULT;
    }

    public final int c() {
        return COMBINE_ITEM_STYLE_TYPE_ENTER_ROOM;
    }
}
