package com.tencent.guild.aio.component.combinestyle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.guild.aio.component.combinestyle.ah;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/ai;", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "", "b", "c", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface ai extends ah {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable
        public static Drawable a(@NotNull ai aiVar) {
            return ah.a.a(aiVar);
        }

        public static void b(@NotNull ai aiVar, @NotNull Context context, @NotNull ag callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ah.a.b(aiVar, context, callback);
        }
    }

    @NotNull
    String b();

    @NotNull
    String c();
}
