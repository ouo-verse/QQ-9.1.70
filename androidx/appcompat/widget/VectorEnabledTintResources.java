package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled = false;
    private final WeakReference<Context> mContextRef;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z16) {
        sCompatVectorFromResourcesEnabled = z16;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        Context context = this.mContextRef.get();
        if (context != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, i3);
        }
        return super.getDrawable(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable superGetDrawable(int i3) {
        return super.getDrawable(i3);
    }
}
