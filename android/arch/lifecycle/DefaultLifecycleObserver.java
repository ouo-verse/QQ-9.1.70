package android.arch.lifecycle;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onCreate(@NonNull LifecycleOwner lifecycleOwner);

    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onDestroy(@NonNull LifecycleOwner lifecycleOwner);

    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onPause(@NonNull LifecycleOwner lifecycleOwner);

    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onResume(@NonNull LifecycleOwner lifecycleOwner);

    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onStart(@NonNull LifecycleOwner lifecycleOwner);

    @Override // android.arch.lifecycle.FullLifecycleObserver
    void onStop(@NonNull LifecycleOwner lifecycleOwner);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final /* synthetic */ class _CC {
        public static void $default$onCreate(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onDestroy(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onPause(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onResume(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onStart(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onStop(@NonNull DefaultLifecycleObserver defaultLifecycleObserver, LifecycleOwner lifecycleOwner) {
        }
    }
}
