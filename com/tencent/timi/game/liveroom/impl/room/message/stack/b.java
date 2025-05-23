package com.tencent.timi.game.liveroom.impl.room.message.stack;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/stack/b;", "", "", "e", "c", "d", "f", "b", "a", "I", "BOTTOM_MARGIN_PX", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f378084a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int BOTTOM_MARGIN_PX = (int) BaseApplication.getContext().getResources().getDimension(R.dimen.cws);

    b() {
    }

    public final int a() {
        return BOTTOM_MARGIN_PX + wi2.c.b(27) + wi2.c.b(4);
    }

    public final int b() {
        return wi2.c.b(48) + wi2.c.b(4) + wi2.c.b(27) + BOTTOM_MARGIN_PX;
    }

    public final int c() {
        return wi2.c.b(222);
    }

    public final int d() {
        return wi2.c.b(8);
    }

    public final int e() {
        return wi2.c.b(194);
    }

    public final int f() {
        return wi2.c.b(48);
    }
}
