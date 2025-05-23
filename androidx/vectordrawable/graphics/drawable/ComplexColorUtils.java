package androidx.vectordrawable.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.GuildComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes.dex */
class ComplexColorUtils {
    ComplexColorUtils() {
    }

    @SuppressLint({"RestrictedApi"})
    public static GuildComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i3, @ColorInt int i16) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i3, typedValue);
            int i17 = typedValue.type;
            if (i17 >= 28 && i17 <= 31) {
                return GuildComplexColorCompat.from(typedValue.data);
            }
            GuildComplexColorCompat inflate = GuildComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i3, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return GuildComplexColorCompat.from(i16);
    }
}
