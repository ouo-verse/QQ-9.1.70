package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher mDispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @Nullable
    @CallSuper
    public IBinder onBind(@NonNull Intent intent) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @CallSuper
    public void onStart(@Nullable Intent intent, int i3) {
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i3);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@Nullable Intent intent, int i3, int i16) {
        return super.onStartCommand(intent, i3, i16);
    }
}
