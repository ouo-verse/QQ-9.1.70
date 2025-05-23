package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class UIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable> extends Subscriber.SingleEventSubscriber<EVENT> {
    protected String TAG;
    private String mDebugInfo;
    protected WeakReference<T> mRef;

    public UIEventReceiver(@NonNull T t16) {
        this.mDebugInfo = t16.getClass().getSimpleName() + System.identityHashCode(t16);
        this.mRef = new WeakReference<>(t16);
        this.TAG = t16.getClass().getSimpleName() + ":UIEventReceiver";
    }

    @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriber
    protected final void onDispatch2(@NonNull EVENT event) {
        T t16 = this.mRef.get();
        if (t16 == null) {
            SLog.w(this.TAG, "onDispatch2 ignore because weak reference is released : " + this.mDebugInfo);
            return;
        }
        if (!t16.isValidate()) {
            SLog.w(this.TAG, String.format("ignore receiver one event %s for ui %s is invalidate", event, t16));
        } else {
            onEvent(t16, event);
        }
    }

    public abstract void onEvent(@NonNull T t16, @NonNull EVENT event);
}
