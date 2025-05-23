package androidx.savedstate;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: P */
/* loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NonNull
    SavedStateRegistry getSavedStateRegistry();
}
