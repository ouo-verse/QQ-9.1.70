package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* compiled from: P */
/* loaded from: classes.dex */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event);
}
