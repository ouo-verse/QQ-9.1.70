package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n\u00a2\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n\u00a2\u0006\u0002\u0010\u0006\u001a*\u0010\u0007\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n\u00a2\u0006\u0002\u0010\u0004\u001a*\u0010\u0007\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n\u00a2\u0006\u0002\u0010\u0006\u001a1\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001a1\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001a1\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a1\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\b\u00a8\u0006\f"}, d2 = {"component1", UserInfo.SEX_FEMALE, ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Landroidx/core/util/Pair;", "(Landroidx/core/util/Pair;)Ljava/lang/Object;", "component2", "toAndroidPair", "Lkotlin/Pair;", "toAndroidXPair", "toKotlinPair", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull Pair<F, S> component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return component1.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull Pair<F, S> component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return component2.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> toAndroidPair) {
        Intrinsics.checkNotNullParameter(toAndroidPair, "$this$toAndroidPair");
        return new android.util.Pair<>(toAndroidPair.getFirst(), toAndroidPair.getSecond());
    }

    @NotNull
    public static final <F, S> Pair<F, S> toAndroidXPair(@NotNull kotlin.Pair<? extends F, ? extends S> toAndroidXPair) {
        Intrinsics.checkNotNullParameter(toAndroidXPair, "$this$toAndroidXPair");
        return new Pair<>(toAndroidXPair.getFirst(), toAndroidXPair.getSecond());
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull Pair<F, S> toKotlinPair) {
        Intrinsics.checkNotNullParameter(toKotlinPair, "$this$toKotlinPair");
        return new kotlin.Pair<>(toKotlinPair.first, toKotlinPair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return (F) component1.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return (S) component2.second;
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> toKotlinPair) {
        Intrinsics.checkNotNullParameter(toKotlinPair, "$this$toKotlinPair");
        return new kotlin.Pair<>(toKotlinPair.first, toKotlinPair.second);
    }
}
