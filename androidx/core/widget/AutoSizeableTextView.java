package androidx.core.widget;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface AutoSizeableTextView {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    static {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 27) {
            z16 = true;
        } else {
            z16 = false;
        }
        PLATFORM_SUPPORTS_AUTOSIZE = z16;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i16, int i17, int i18) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i3) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i3);
}
