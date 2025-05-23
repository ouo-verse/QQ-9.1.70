package g1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class i {
    @Nullable
    public static Typeface a(@NonNull Context context, @NonNull Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    @Nullable
    public static Typeface b(@NonNull Configuration configuration, @NonNull Typeface typeface) {
        int i3;
        int i16;
        int weight;
        int i17;
        Typeface create;
        if (Build.VERSION.SDK_INT >= 31) {
            i3 = configuration.fontWeightAdjustment;
            if (i3 != Integer.MAX_VALUE) {
                i16 = configuration.fontWeightAdjustment;
                if (i16 != 0) {
                    weight = typeface.getWeight();
                    i17 = configuration.fontWeightAdjustment;
                    create = Typeface.create(typeface, MathUtils.clamp(weight + i17, 1, 1000), typeface.isItalic());
                    return create;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
