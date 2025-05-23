package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0015\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a/\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u00022\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001e0 H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2 = {"checkAttribute", "", "Landroid/content/res/TypedArray;", "index", "", "getBooleanOrThrow", "", "getColorOrThrow", "getColorStateListOrThrow", "Landroid/content/res/ColorStateList;", "getDimensionOrThrow", "", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "getDrawableOrThrow", "Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "getFontOrThrow", "Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "getStringOrThrow", "", "getTextArrayOrThrow", "", "", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "getTextOrThrow", TransFileControllerImpl.VALUE_USE_PRE_CONN, BdhLogUtil.LogTag.Tag_Req, "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i3) {
        if (typedArray.hasValue(i3)) {
        } else {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray getBooleanOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getBooleanOrThrow, "$this$getBooleanOrThrow");
        checkAttribute(getBooleanOrThrow, i3);
        return getBooleanOrThrow.getBoolean(i3, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray getColorOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getColorOrThrow, "$this$getColorOrThrow");
        checkAttribute(getColorOrThrow, i3);
        return getColorOrThrow.getColor(i3, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray getColorStateListOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getColorStateListOrThrow, "$this$getColorStateListOrThrow");
        checkAttribute(getColorStateListOrThrow, i3);
        ColorStateList colorStateList = getColorStateListOrThrow.getColorStateList(i3);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray getDimensionOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getDimensionOrThrow, "$this$getDimensionOrThrow");
        checkAttribute(getDimensionOrThrow, i3);
        return getDimensionOrThrow.getDimension(i3, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray getDimensionPixelOffsetOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getDimensionPixelOffsetOrThrow, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(getDimensionPixelOffsetOrThrow, i3);
        return getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(i3, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray getDimensionPixelSizeOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getDimensionPixelSizeOrThrow, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(getDimensionPixelSizeOrThrow, i3);
        return getDimensionPixelSizeOrThrow.getDimensionPixelSize(i3, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray getDrawableOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getDrawableOrThrow, "$this$getDrawableOrThrow");
        checkAttribute(getDrawableOrThrow, i3);
        Drawable drawable = getDrawableOrThrow.getDrawable(i3);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray getFloatOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getFloatOrThrow, "$this$getFloatOrThrow");
        checkAttribute(getFloatOrThrow, i3);
        return getFloatOrThrow.getFloat(i3, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray getFontOrThrow, @StyleableRes int i3) {
        Typeface font;
        Intrinsics.checkNotNullParameter(getFontOrThrow, "$this$getFontOrThrow");
        checkAttribute(getFontOrThrow, i3);
        font = getFontOrThrow.getFont(i3);
        Intrinsics.checkNotNull(font);
        return font;
    }

    public static final int getIntOrThrow(@NotNull TypedArray getIntOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getIntOrThrow, "$this$getIntOrThrow");
        checkAttribute(getIntOrThrow, i3);
        return getIntOrThrow.getInt(i3, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray getIntegerOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getIntegerOrThrow, "$this$getIntegerOrThrow");
        checkAttribute(getIntegerOrThrow, i3);
        return getIntegerOrThrow.getInteger(i3, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray getResourceIdOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        checkAttribute(getResourceIdOrThrow, i3);
        return getResourceIdOrThrow.getResourceId(i3, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray getStringOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getStringOrThrow, "$this$getStringOrThrow");
        checkAttribute(getStringOrThrow, i3);
        String string = getStringOrThrow.getString(i3);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray getTextArrayOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getTextArrayOrThrow, "$this$getTextArrayOrThrow");
        checkAttribute(getTextArrayOrThrow, i3);
        CharSequence[] textArray = getTextArrayOrThrow.getTextArray(i3);
        Intrinsics.checkNotNullExpressionValue(textArray, "getTextArray(index)");
        return textArray;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray getTextOrThrow, @StyleableRes int i3) {
        Intrinsics.checkNotNullParameter(getTextOrThrow, "$this$getTextOrThrow");
        checkAttribute(getTextOrThrow, i3);
        CharSequence text = getTextOrThrow.getText(i3);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull TypedArray use, @NotNull Function1<? super TypedArray, ? extends R> block) {
        Intrinsics.checkNotNullParameter(use, "$this$use");
        Intrinsics.checkNotNullParameter(block, "block");
        R invoke = block.invoke(use);
        use.recycle();
        return invoke;
    }
}
