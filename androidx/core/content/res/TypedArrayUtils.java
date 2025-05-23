package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i3, int i16) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i3;
        }
        return i16;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16, boolean z16) {
        return typedArray.getBoolean(i3, typedArray.getBoolean(i16, z16));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16) {
        Drawable drawable = typedArray.getDrawable(i3);
        if (drawable == null) {
            return typedArray.getDrawable(i16);
        }
        return drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16, int i17) {
        return typedArray.getInt(i3, typedArray.getInt(i16, i17));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3, boolean z16) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z16;
        }
        return typedArray.getBoolean(i3, z16);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3, @ColorInt int i16) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i16;
        }
        return typedArray.getColor(i3, i16);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i3) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i3, typedValue);
            int i16 = typedValue.type;
            if (i16 != 2) {
                if (i16 >= 28 && i16 <= 31) {
                    return getNamedColorStateListFromInt(typedValue);
                }
                return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i3, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i3 + MsgSummary.STR_COLON + typedValue);
        }
        return null;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i3, @ColorInt int i16) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i3, typedValue);
            int i17 = typedValue.type;
            if (i17 >= 28 && i17 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i3, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i16);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3, float f16) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f16;
        }
        return typedArray.getFloat(i3, f16);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3, int i16) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i16;
        }
        return typedArray.getInt(i3, i16);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3, @AnyRes int i16) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i16;
        }
        return typedArray.getResourceId(i3, i16);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i3) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i3);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16, @AnyRes int i17) {
        return typedArray.getResourceId(i3, typedArray.getResourceId(i16, i17));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16) {
        String string = typedArray.getString(i3);
        if (string == null) {
            return typedArray.getString(i16);
        }
        return string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16) {
        CharSequence text = typedArray.getText(i3);
        if (text == null) {
            return typedArray.getText(i16);
        }
        return text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i3, @StyleableRes int i16) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        if (textArray == null) {
            return typedArray.getTextArray(i16);
        }
        return textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue(NAMESPACE, str) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i3) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i3);
    }
}
