package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class QQUIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable> extends Subscriber.SingleEventSubscriberNoRefect<EVENT> {
    protected String TAG = "QQUIEventReceiver";
    protected WeakReference<T> mRef;

    public QQUIEventReceiver(@NonNull T t16) {
        this.mRef = new WeakReference<>(t16);
    }

    @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
    protected final void onDispatch2(@NonNull EVENT event) {
        T t16 = this.mRef.get();
        if (t16 == null || !t16.isValidate()) {
            return;
        }
        onEvent(t16, event);
    }

    public abstract void onEvent(@NonNull T t16, @NonNull EVENT event);
}
