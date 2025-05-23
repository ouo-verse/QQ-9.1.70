package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        String name;
        name = floatProperty.getName();
        return new FloatPropertyCompat<T>(name) { // from class: androidx.dynamicanimation.animation.FloatPropertyCompat.1
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(T t16) {
                Object obj;
                obj = floatProperty.get(t16);
                return ((Float) obj).floatValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(T t16, float f16) {
                floatProperty.setValue(t16, f16);
            }
        };
    }

    public abstract float getValue(T t16);

    public abstract void setValue(T t16, float f16);
}
