package android.arch.lifecycle;

import android.support.annotation.NonNull;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // android.arch.lifecycle.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}
