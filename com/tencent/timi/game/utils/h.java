package com.tencent.timi.game.utils;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/utils/h;", "", "<init>", "()V", "a", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static volatile Typeface f380302b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/utils/h$a;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "a", "", "NUM_FONT_ASSETS", "Ljava/lang/String;", "numberTypeface", "Landroid/graphics/Typeface;", "<init>", "()V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.utils.h$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Typeface a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (h.f380302b == null) {
                synchronized (h.class) {
                    if (h.f380302b == null) {
                        h.f380302b = Typeface.createFromAsset(context.getAssets(), "fonts/tg_din_condensed_bold.ttf");
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return h.f380302b;
        }

        Companion() {
        }
    }
}
