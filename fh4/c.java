package fh4;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {
    public static final int a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -7829368;
        }
    }
}
