package com.tencent.mobileqq.guild.media.core.notify;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J*\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J2\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J!\u0010\u000f\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R4\u0010\u001e\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u001b0\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/MediaChannelEventBus;", "Lcom/tencent/mobileqq/guild/media/core/notify/p;", "T", "Ljava/lang/Class;", "eventClz", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "listener", "", "V", "j", "Landroidx/lifecycle/LifecycleOwner;", "owner", "k0", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "event", "i", "(Lcom/tencent/mobileqq/guild/media/core/notify/x;)V", "", "mustMainThread", "b", "(Lcom/tencent/mobileqq/guild/media/core/notify/x;Z)V", "E0", "p", "h0", "u", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "d", "Ljava/util/Map;", "eventMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelEventBus implements p {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, CopyOnWriteArrayList<WeakReference<o<?>>>> eventMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MediaChannelEventBus this$0, x event) {
        o oVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        CopyOnWriteArrayList<WeakReference<o<?>>> copyOnWriteArrayList = this$0.eventMap.get(event.getClass());
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Object obj = ((WeakReference) it.next()).get();
            if (obj instanceof o) {
                oVar = (o) obj;
            } else {
                oVar = null;
            }
            if (oVar != null) {
                oVar.D0(event);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.notify.p
    public synchronized <T> void V(@NotNull Class<T> eventClz, @NotNull o<T> listener) {
        T t16;
        Intrinsics.checkNotNullParameter(eventClz, "eventClz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<Class<?>, CopyOnWriteArrayList<WeakReference<o<?>>>> map = this.eventMap;
        CopyOnWriteArrayList<WeakReference<o<?>>> copyOnWriteArrayList = map.get(eventClz);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            map.put(eventClz, copyOnWriteArrayList);
        }
        CopyOnWriteArrayList<WeakReference<o<?>>> copyOnWriteArrayList2 = copyOnWriteArrayList;
        Iterator<T> it = copyOnWriteArrayList2.iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                if (Intrinsics.areEqual(((WeakReference) t16).get(), listener)) {
                    break;
                }
            } else {
                t16 = (T) null;
                break;
            }
        }
        WeakReference weakReference = t16;
        if (weakReference != null) {
            copyOnWriteArrayList2.remove(weakReference);
        }
        copyOnWriteArrayList2.add(new WeakReference<>(listener));
    }

    public <T extends x> void b(@NotNull final T event, boolean mustMainThread) {
        Intrinsics.checkNotNullParameter(event, "event");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.notify.w
            @Override // java.lang.Runnable
            public final void run() {
                MediaChannelEventBus.e(MediaChannelEventBus.this, event);
            }
        };
        if (mustMainThread && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.notify.p
    public synchronized <T extends x> void i(@NotNull T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b(event, true);
    }

    @Override // com.tencent.mobileqq.guild.media.core.notify.p
    public synchronized <T> void j(@NotNull Class<T> eventClz, @NotNull o<T> listener) {
        T t16;
        Intrinsics.checkNotNullParameter(eventClz, "eventClz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<WeakReference<o<?>>> copyOnWriteArrayList = this.eventMap.get(eventClz);
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                if (Intrinsics.areEqual(((WeakReference) t16).get(), listener)) {
                    break;
                }
            } else {
                t16 = (T) null;
                break;
            }
        }
        copyOnWriteArrayList.remove(t16);
    }

    @Override // com.tencent.mobileqq.guild.media.core.notify.p
    public synchronized <T> void k0(@NotNull final LifecycleOwner owner, @NotNull final Class<T> eventClz, @NotNull final o<T> listener) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(eventClz, "eventClz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        owner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.guild.media.core.notify.MediaChannelEventBus$listenEvent$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                MediaChannelEventBus.this.j(eventClz, listener);
                owner.getLifecycle().removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onStart() {
                MediaChannelEventBus.this.V(eventClz, listener);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
    }
}
