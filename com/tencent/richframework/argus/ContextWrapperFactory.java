package com.tencent.richframework.argus;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.argus.ContextWrapperFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\t\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00070\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/richframework/argus/ContextWrapperFactory;", "", "Ljava/lang/Class;", "wrapperClass", "Landroid/content/Context;", "baseContext", "getContextWrapper", "Landroidx/fragment/app/FragmentActivity;", "baseFragmentActivity", "getFragmentActivityWrapper", "Lcom/tencent/richframework/argus/ContextWrapperFactory$IContextWrapperOperationListener;", "listener", "", "addOperationListener", "", "constructorFragmentActivity", "[Ljava/lang/Class;", "", "contextWrapperOperationListeners", "Ljava/util/Set;", "", "", "fragmentActivityWrapper", "Ljava/util/Map;", "<init>", "()V", "IContextWrapperOperationListener", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ContextWrapperFactory {

    @NotNull
    public static final ContextWrapperFactory INSTANCE = new ContextWrapperFactory();
    private static final Class<?>[] constructorFragmentActivity = {FragmentActivity.class};
    private static final Set<IContextWrapperOperationListener> contextWrapperOperationListeners;
    private static final Map<Integer, Map<Class<?>, FragmentActivity>> fragmentActivityWrapper;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t0\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/ContextWrapperFactory$IContextWrapperOperationListener;", "", "onRemove", "", "context", "Landroid/content/Context;", "wrapperContext", "", "Ljava/lang/Class;", "Landroidx/fragment/app/FragmentActivity;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface IContextWrapperOperationListener {
        void onRemove(@NotNull Context context, @NotNull Map<Class<?>, FragmentActivity> wrapperContext);
    }

    static {
        Set<IContextWrapperOperationListener> synchronizedSet = Collections.synchronizedSet(new HashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "Collections.synchronizedSet(HashSet())");
        contextWrapperOperationListeners = synchronizedSet;
        fragmentActivityWrapper = new ConcurrentHashMap();
    }

    ContextWrapperFactory() {
    }

    public final void addOperationListener(@NotNull IContextWrapperOperationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        contextWrapperOperationListeners.add(listener);
    }

    @Nullable
    public final Context getContextWrapper(@NotNull Class<?> wrapperClass, @NotNull Context baseContext) {
        Intrinsics.checkNotNullParameter(wrapperClass, "wrapperClass");
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        if (baseContext instanceof FragmentActivity) {
            return getFragmentActivityWrapper(wrapperClass, (FragmentActivity) baseContext);
        }
        return null;
    }

    @NotNull
    public final FragmentActivity getFragmentActivityWrapper(@NotNull Class<?> wrapperClass, @NotNull final FragmentActivity baseFragmentActivity) {
        Intrinsics.checkNotNullParameter(wrapperClass, "wrapperClass");
        Intrinsics.checkNotNullParameter(baseFragmentActivity, "baseFragmentActivity");
        final int hashCode = baseFragmentActivity.hashCode();
        Map<Integer, Map<Class<?>, FragmentActivity>> map = fragmentActivityWrapper;
        Map<Class<?>, FragmentActivity> map2 = map.get(Integer.valueOf(hashCode));
        if (map2 != null && map2.containsKey(wrapperClass)) {
            FragmentActivity fragmentActivity = map2.get(wrapperClass);
            Intrinsics.checkNotNull(fragmentActivity);
            return fragmentActivity;
        }
        Class<?>[] clsArr = constructorFragmentActivity;
        Object newInstance = wrapperClass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(baseFragmentActivity);
        if (newInstance != null) {
            FragmentActivity fragmentActivity2 = (FragmentActivity) newInstance;
            if (map2 == null) {
                Integer valueOf = Integer.valueOf(hashCode);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put(wrapperClass, fragmentActivity2);
                Unit unit = Unit.INSTANCE;
                map.put(valueOf, concurrentHashMap);
            } else {
                map2.put(wrapperClass, fragmentActivity2);
            }
            baseFragmentActivity.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.richframework.argus.ContextWrapperFactory$getFragmentActivityWrapper$2
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    Map map3;
                    Set set;
                    Set set2;
                    RFWLog.i("ContextWrapperFactory", RFWLog.USR, "remove contextWrapper with:" + hashCode);
                    ContextWrapperFactory contextWrapperFactory = ContextWrapperFactory.INSTANCE;
                    map3 = ContextWrapperFactory.fragmentActivityWrapper;
                    Map<Class<?>, FragmentActivity> map4 = (Map) map3.remove(Integer.valueOf(hashCode));
                    if (map4 != null) {
                        set = ContextWrapperFactory.contextWrapperOperationListeners;
                        synchronized (set) {
                            set2 = ContextWrapperFactory.contextWrapperOperationListeners;
                            Iterator it = set2.iterator();
                            while (it.hasNext()) {
                                ((ContextWrapperFactory.IContextWrapperOperationListener) it.next()).onRemove(baseFragmentActivity, map4);
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            });
            return fragmentActivity2;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
