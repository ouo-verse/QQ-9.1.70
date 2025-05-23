package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.utils.AssertUtils;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Subscriber {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class EventBatchSubscriber implements Subscriber, IDispatchableListener<Dispatcher.Dispatchable> {

        /* compiled from: P */
        /* loaded from: classes27.dex */
        private class InnerJob implements Runnable {
            private Dispatcher.Dispatchable mDispatchable;

            public InnerJob(Dispatcher.Dispatchable dispatchable) {
                this.mDispatchable = dispatchable;
            }

            @Override // java.lang.Runnable
            public void run() {
                EventBatchSubscriber.this.onDispatch(this.mDispatchable);
            }
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public final void handleDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            Bosses.get().postLightWeightJob(new InnerJob(dispatchable), 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class EventBatchSubscriberWrapper extends EventBatchSubscriber {
        private final Subscriber mSubscriber;

        public EventBatchSubscriberWrapper(Subscriber subscriber) {
            AssertUtils.checkNotNull(subscriber);
            this.mSubscriber = subscriber;
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
            this.mSubscriber.accept(list);
        }

        public boolean equals(Object obj) {
            if (obj instanceof SubscriberWrapper) {
                return ((SubscriberWrapper) obj).mSubscriber.equals(this.mSubscriber);
            }
            if (obj instanceof LooperSubscriber) {
                return obj.equals(this.mSubscriber);
            }
            if (obj instanceof Subscriber) {
                return obj.equals(this.mSubscriber);
            }
            return false;
        }

        public int hashCode() {
            return this.mSubscriber.hashCode();
        }

        @Override // com.tribe.async.dispatch.Subscriber.IDispatchableListener
        public void onDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            this.mSubscriber.handleDispatch(dispatchable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IDispatchableListener<T extends Dispatcher.Dispatchable> {
        void onDispatch(@NonNull T t16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class LooperSubscriber extends Handler implements Subscriber, IDispatchableListener<Dispatcher.Dispatchable> {
        private static final int REQUEST_SUBMIT = 1;

        public LooperSubscriber(Looper looper) {
            super(looper);
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void handleDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            Message.obtain(this, 1, dispatchable).sendToTarget();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Object obj = message.obj;
                AssertUtils.checkNotNull(obj);
                onDispatch((Dispatcher.Dispatchable) obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class SingleEventSubscriber<EVENT extends Dispatcher.Dispatchable> extends LooperSubscriber {
        private Class clazz;

        public SingleEventSubscriber() {
            super(Looper.getMainLooper());
            this.clazz = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[r0.length - 1];
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
            list.add(this.clazz);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tribe.async.dispatch.Subscriber.IDispatchableListener
        public final void onDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            onDispatch2(dispatchable);
        }

        protected abstract void onDispatch2(@NonNull EVENT event);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class SingleEventSubscriberNoRefect<EVENT extends Dispatcher.Dispatchable> extends LooperSubscriber {
        public SingleEventSubscriberNoRefect() {
            super(Looper.getMainLooper());
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
            list.add(acceptEventClass());
        }

        public abstract Class acceptEventClass();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tribe.async.dispatch.Subscriber.IDispatchableListener
        public final void onDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            onDispatch2(dispatchable);
        }

        protected abstract void onDispatch2(@NonNull EVENT event);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SubscriberWrapper extends LooperSubscriber {
        private final Subscriber mSubscriber;

        public SubscriberWrapper(Looper looper, Subscriber subscriber) {
            super(looper);
            AssertUtils.checkNotNull(subscriber);
            this.mSubscriber = subscriber;
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
            this.mSubscriber.accept(list);
        }

        public boolean equals(Object obj) {
            if (obj instanceof SubscriberWrapper) {
                SubscriberWrapper subscriberWrapper = (SubscriberWrapper) obj;
                if (subscriberWrapper.mSubscriber.equals(this.mSubscriber) && subscriberWrapper.getLooper().equals(getLooper())) {
                    return true;
                }
                return false;
            }
            if (obj instanceof LooperSubscriber) {
                if (obj.equals(this.mSubscriber) && ((LooperSubscriber) obj).getLooper().equals(getLooper())) {
                    return true;
                }
                return false;
            }
            if (!(obj instanceof Subscriber)) {
                return false;
            }
            return obj.equals(this.mSubscriber);
        }

        public int hashCode() {
            return this.mSubscriber.hashCode();
        }

        @Override // com.tribe.async.dispatch.Subscriber.IDispatchableListener
        public void onDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            this.mSubscriber.handleDispatch(dispatchable);
        }
    }

    void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list);

    void handleDispatch(@NonNull Dispatcher.Dispatchable dispatchable);
}
