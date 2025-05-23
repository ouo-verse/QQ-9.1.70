package cooperation.qzone.zipanimate.life;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/* loaded from: classes28.dex */
public interface PageLifeCycle extends LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onPageCreate(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onPageDestroy(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPagePause(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onPageResume(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onPageStart(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onPageStop(LifecycleOwner lifecycleOwner);
}
