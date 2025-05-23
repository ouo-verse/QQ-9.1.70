package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.p;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/component/chat/input/TimiInputUtil;", "", "Landroid/content/Context;", "ctx", "", "height", "", "c", "b", "Lkotlin/Lazy;", "a", "()I", "defaultKeyBoardHeight", "I", "keyboardHeight", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiInputUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TimiInputUtil f376395a = new TimiInputUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy defaultKeyBoardHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int keyboardHeight;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.timi.game.component.chat.input.TimiInputUtil$defaultKeyBoardHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dip2px(196.0f));
            }
        });
        defaultKeyBoardHeight = lazy;
        keyboardHeight = -1;
    }

    TimiInputUtil() {
    }

    private final int a() {
        return ((Number) defaultKeyBoardHeight.getValue()).intValue();
    }

    public final int b(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (keyboardHeight == -1) {
            Object b16 = p.b(ctx, "-1", "key_timi_game_keyboard_height", Integer.valueOf(a()));
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.Int");
            keyboardHeight = ((Integer) b16).intValue();
        }
        return keyboardHeight;
    }

    public final void c(@NotNull Context ctx, int height) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        keyboardHeight = height;
        p.g(ctx, "-1", true, "key_timi_game_keyboard_height", Integer.valueOf(height));
    }
}
