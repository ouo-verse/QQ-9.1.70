package com.tencent.guild.aio.component.combinestyle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/ah;", "", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "callback", "", "a", "Landroid/graphics/drawable/Drawable;", "d", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface ah {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        public static Drawable a(@NotNull ah ahVar) {
            return null;
        }

        public static void b(@NotNull ah ahVar, @NotNull Context context, @NotNull ag callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    void a(@NotNull Context context, @NotNull ag callback);

    @Nullable
    Drawable d();
}
