package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u00a8\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s16) {
        Half valueOf;
        valueOf = Half.valueOf(s16);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f16) {
        Half valueOf;
        valueOf = Half.valueOf(f16);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String toHalf) {
        Half valueOf;
        Intrinsics.checkNotNullParameter(toHalf, "$this$toHalf");
        valueOf = Half.valueOf(toHalf);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d16) {
        Half valueOf;
        valueOf = Half.valueOf((float) d16);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
