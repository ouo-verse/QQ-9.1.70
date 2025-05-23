package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ConfigurationHelper {
    ConfigurationHelper() {
    }

    public static int getDensityDpi(@NonNull Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
