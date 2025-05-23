package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.HandlerPoster;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DefaultDispatcher implements Dispatcher {
    private static final int DISPATCH = 16;
    private static final String TAG = "async.dispatch.DefaultDispatcher";
    private final InternalHandler mHandler;
    private final HandlerPoster mHandlerPoster;
    private final Looper mLooper;
    private final Map<SubscriberKey, CopyOnWriteArraySet<Wrapper>> mSubscribersByKey = new ConcurrentHashMap(10);
    private final Map<Integer, CopyOnWriteArraySet<Object>> mGroupsBySubscriber = new ConcurrentHashMap(10);
    private final ThreadLocal<PostingThreadState> mCurrentPostingThreadState = new ThreadLocal<PostingThreadState>() { // from class: com.tribe.async.dispatch.DefaultDispatcher.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PostingThreadState initialValue() {
            return new PostingThreadState();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DefaultWrpper implements Wrapper {
        private final Subscriber mSubscriber;

        public DefaultWrpper(Subscriber subscriber) {
            AssertUtils.checkNotNull(subscriber);
            this.mSubscriber = subscriber;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof DefaultWrpper)) {
                return false;
            }
            return this.mSubscriber.equals(((DefaultWrpper) obj).get());
        }

        @Override // com.tribe.async.dispatch.DefaultDispatcher.Wrapper
        public Subscriber get() {
            return this.mSubscriber;
        }

        public int hashCode() {
            return this.mSubscriber.hashCode();
        }

        public String toString() {
            return "DefaultWrapper_" + this.mSubscriber.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class InternalHandler extends Handler {
        public InternalHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 16) {
                PendingPost pendingPost = (PendingPost) message.obj;
                DefaultDispatcher.this.mHandlerPoster.enqueue(pendingPost.tag, pendingPost.group, pendingPost.dispatchable);
                PendingPost.releasePendingPost(pendingPost);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class PostingThreadState {
        boolean canceled;
        final List<PendingPost> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;

        PostingThreadState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SubscriberKey {
        public final Class<? extends Dispatcher.Dispatchable> dispatchClass;
        public final Object group;

        public SubscriberKey(Class<? extends Dispatcher.Dispatchable> cls, Object obj) {
            AssertUtils.checkNotNull(cls);
            AssertUtils.checkNotNull(obj);
            this.dispatchClass = cls;
            this.group = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SubscriberKey)) {
                return false;
            }
            SubscriberKey subscriberKey = (SubscriberKey) obj;
            if (!this.dispatchClass.equals(subscriberKey.dispatchClass) || !this.group.equals(subscriberKey.group)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.dispatchClass.hashCode();
        }

        public String toString() {
            return "SubscriberKey{dispatchClass=" + this.dispatchClass + ", group=" + this.group + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class WeakWrapper implements Wrapper {
        private int mHashCode;
        private WeakReference<Subscriber> mSubscriberRef;

        public WeakWrapper(Subscriber subscriber) {
            AssertUtils.checkNotNull(subscriber);
            this.mHashCode = subscriber.hashCode();
            this.mSubscriberRef = new WeakReference<>(subscriber);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof WeakWrapper)) {
                return false;
            }
            Subscriber subscriber = get();
            Subscriber subscriber2 = ((WeakWrapper) obj).get();
            if (subscriber == null && subscriber2 == null) {
                return true;
            }
            if (subscriber == null) {
                return false;
            }
            return subscriber.equals(subscriber2);
        }

        @Override // com.tribe.async.dispatch.DefaultDispatcher.Wrapper
        public Subscriber get() {
            return this.mSubscriberRef.get();
        }

        public int hashCode() {
            return this.mHashCode;
        }

        public String toString() {
            String obj;
            Subscriber subscriber = get();
            if (subscriber == null) {
                obj = this.mHashCode + "";
            } else {
                obj = subscriber.toString();
            }
            return "WeakWrapper_" + obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Wrapper {
        Subscriber get();
    }

    public DefaultDispatcher(Looper looper) {
        AssertUtils.checkNotNull(looper);
        this.mLooper = looper;
        this.mHandler = new InternalHandler(looper);
        HandlerPoster handlerPoster = HandlerPosterManager.instance().getHandlerPoster(looper);
        this.mHandlerPoster = handlerPoster;
        handlerPoster.addPosterRunner(new HandlerPoster.PosterRunner() { // from class: com.tribe.async.dispatch.DefaultDispatcher.2
            @Override // com.tribe.async.dispatch.HandlerPoster.PosterRunner
            public boolean acceptTag(Object obj) {
                if (DefaultDispatcher.TAG == obj) {
                    return true;
                }
                return false;
            }

            @Override // com.tribe.async.dispatch.HandlerPoster.PosterRunner
            public void run(@NonNull String str, @NonNull Dispatcher.Dispatchable dispatchable) {
                DefaultDispatcher.this.doDispatch(str, dispatchable);
            }
        });
    }

    private void dispatchSingle(Object obj, String str, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(str);
        AssertUtils.checkNotNull(dispatchable);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.mHandlerPoster.enqueue(obj, str, dispatchable);
        } else {
            doDispatch(str, dispatchable);
        }
    }

    private void insertSubscriber(Object obj, Wrapper wrapper) {
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(wrapper);
        Subscriber subscriber = wrapper.get();
        ArrayList arrayList = new ArrayList(2);
        subscriber.accept(arrayList);
        if (arrayList.size() == 0) {
            AssertUtils.fail("Please override accept function in Subscriber", new Object[0]);
        }
        Iterator<Class<? extends Dispatcher.Dispatchable>> it = arrayList.iterator();
        while (it.hasNext()) {
            SubscriberKey makeKey = makeKey(it.next(), obj);
            CopyOnWriteArraySet<Wrapper> copyOnWriteArraySet = this.mSubscribersByKey.get(makeKey);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.mSubscribersByKey.put(makeKey, copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(wrapper);
        }
        insertToGroupMap(obj, subscriber);
    }

    private void insertToGroupMap(Object obj, Subscriber subscriber) {
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(subscriber);
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = this.mGroupsBySubscriber.get(Integer.valueOf(subscriber.hashCode()));
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            this.mGroupsBySubscriber.put(Integer.valueOf(subscriber.hashCode()), copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(obj);
    }

    private SubscriberKey makeKey(Class<? extends Dispatcher.Dispatchable> cls, Object obj) {
        AssertUtils.checkNotNull(cls);
        AssertUtils.checkNotNull(obj);
        return new SubscriberKey(cls, obj);
    }

    private void notifySubscribers(Set<Wrapper> set, SubscriberKey subscriberKey, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(set);
        AssertUtils.checkNotNull(subscriberKey);
        AssertUtils.checkNotNull(dispatchable);
        SLog.d(TAG, "notifySubscribers key=%s, set=%s", subscriberKey, set);
        ArrayList<Wrapper> arrayList = new ArrayList(1);
        for (Wrapper wrapper : set) {
            Subscriber subscriber = wrapper.get();
            if (subscriber == null) {
                arrayList.add(wrapper);
            } else {
                subscriber.handleDispatch(dispatchable);
            }
        }
        for (Wrapper wrapper2 : arrayList) {
            set.remove(wrapper2);
            this.mGroupsBySubscriber.remove(Integer.valueOf(wrapper2.hashCode()));
        }
    }

    private void removeSubscriberData(Class<? extends Dispatcher.Dispatchable> cls, Object obj, Subscriber subscriber) {
        AssertUtils.checkNotNull(cls);
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(subscriber);
        SubscriberKey makeKey = makeKey(cls, obj);
        CopyOnWriteArraySet<Wrapper> copyOnWriteArraySet = this.mSubscribersByKey.get(makeKey);
        if (copyOnWriteArraySet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Wrapper> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                Wrapper next = it.next();
                Subscriber subscriber2 = next.get();
                if (subscriber2 != null && subscriber2.equals(subscriber)) {
                    arrayList.add(next);
                }
            }
            copyOnWriteArraySet.removeAll(arrayList);
            if (copyOnWriteArraySet.isEmpty()) {
                this.mSubscribersByKey.remove(makeKey);
            }
            SLog.d(TAG, "remove subscriber=%s, left=%s", arrayList, copyOnWriteArraySet);
        }
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void cancelDispatch(@Nullable String str, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(dispatchable);
        if (TextUtils.isEmpty(str)) {
            str = Dispatcher.DEFAULT_GROUP_NAME;
        }
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(TAG, str, dispatchable);
        this.mHandler.removeMessages(16, obtainPendingPost);
        this.mCurrentPostingThreadState.get().eventQueue.remove(obtainPendingPost);
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void dispatch(Dispatcher.Dispatchable dispatchable) {
        dispatch(Dispatcher.DEFAULT_GROUP_NAME, dispatchable);
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void dispatchDelayed(Dispatcher.Dispatchable dispatchable, int i3) {
        dispatchDelayed(Dispatcher.DEFAULT_GROUP_NAME, dispatchable, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void doDispatch(Object obj, Dispatcher.Dispatchable dispatchable) {
        boolean z16;
        AssertUtils.checkNotNull(dispatchable);
        AssertUtils.checkNotNull(obj);
        SubscriberKey makeKey = makeKey(dispatchable.getClass(), obj);
        CopyOnWriteArraySet<Wrapper> copyOnWriteArraySet = this.mSubscribersByKey.get(makeKey);
        boolean z17 = true;
        if (copyOnWriteArraySet != null) {
            notifySubscribers(copyOnWriteArraySet, makeKey, dispatchable);
            z16 = true;
        } else {
            z16 = false;
        }
        SubscriberKey makeKey2 = makeKey(dispatchable.getClass(), Dispatcher.ROOT_GROUP_NAME);
        CopyOnWriteArraySet<Wrapper> copyOnWriteArraySet2 = this.mSubscribersByKey.get(makeKey2);
        if (copyOnWriteArraySet2 != null) {
            notifySubscribers(copyOnWriteArraySet2, makeKey2, dispatchable);
        } else {
            z17 = z16;
        }
        if (z17) {
            SLog.d(TAG, "group = " + obj + ", dispatchable = " + dispatchable);
        }
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    @NonNull
    public Looper getDefaultLooper() {
        return this.mLooper;
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void registerSubscriber(Subscriber subscriber) {
        registerSubscriber(Dispatcher.DEFAULT_GROUP_NAME, subscriber);
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void registerWeakSubscriber(Subscriber subscriber) {
        AssertUtils.checkNotNull(subscriber);
        insertSubscriber(Dispatcher.DEFAULT_GROUP_NAME, new WeakWrapper(subscriber));
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void unRegisterSubscriber(Subscriber subscriber) {
        if (subscriber == null) {
            AssertUtils.fail("subscriber cannot be null.", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        subscriber.accept(arrayList);
        if (arrayList.size() == 0) {
            return;
        }
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = this.mGroupsBySubscriber.get(Integer.valueOf(subscriber.hashCode()));
        for (Class<? extends Dispatcher.Dispatchable> cls : arrayList) {
            if (copyOnWriteArraySet != null) {
                Iterator<Object> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    removeSubscriberData(cls, it.next(), subscriber);
                }
            } else {
                removeSubscriberData(cls, Dispatcher.DEFAULT_GROUP_NAME, subscriber);
            }
        }
        this.mGroupsBySubscriber.remove(Integer.valueOf(subscriber.hashCode()));
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void dispatch(@Nullable String str, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(dispatchable);
        if (TextUtils.isEmpty(str)) {
            str = Dispatcher.DEFAULT_GROUP_NAME;
        }
        PostingThreadState postingThreadState = this.mCurrentPostingThreadState.get();
        List<PendingPost> list = postingThreadState.eventQueue;
        list.add(PendingPost.obtainPendingPost(TAG, str, dispatchable));
        if (postingThreadState.isPosting) {
            return;
        }
        postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
        postingThreadState.isPosting = true;
        if (!postingThreadState.canceled) {
            while (!list.isEmpty()) {
                try {
                    PendingPost remove = list.remove(0);
                    dispatchSingle(remove.tag, remove.group, remove.dispatchable);
                    PendingPost.releasePendingPost(remove);
                } finally {
                    postingThreadState.isPosting = false;
                    postingThreadState.isMainThread = false;
                }
            }
            return;
        }
        throw new DispatcherException("Internal error. Abort state was not reset");
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void dispatchDelayed(@Nullable String str, Dispatcher.Dispatchable dispatchable, int i3) {
        AssertUtils.checkNotNull(dispatchable);
        if (i3 == 0) {
            dispatch(str, dispatchable);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = Dispatcher.DEFAULT_GROUP_NAME;
        }
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 16, PendingPost.obtainPendingPost(TAG, str, dispatchable)), i3);
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void registerSubscriber(@Nullable String str, Subscriber subscriber) {
        AssertUtils.checkNotNull(subscriber);
        if (TextUtils.isEmpty(str)) {
            str = Dispatcher.DEFAULT_GROUP_NAME;
        }
        AssertUtils.assertTrue(subscriber != null);
        insertSubscriber(str, new DefaultWrpper(subscriber));
    }

    @Override // com.tribe.async.dispatch.Dispatcher
    public void registerWeakSubscriber(@Nullable String str, Subscriber subscriber) {
        AssertUtils.checkNotNull(subscriber);
        if (TextUtils.isEmpty(str)) {
            str = Dispatcher.DEFAULT_GROUP_NAME;
        }
        insertSubscriber(str, new WeakWrapper(subscriber));
    }
}
