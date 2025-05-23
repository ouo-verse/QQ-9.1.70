package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneEventEmitter;
import com.tencent.tbs.one.TBSOneEventReceiver;
import com.tencent.tbs.one.impl.a.o;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b implements TBSOneEventEmitter {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<h> f374956a;

    public b(h hVar) {
        this.f374956a = new WeakReference<>(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TBSOneComponent tBSOneComponent, String str, String str2, Map<String, Object> map) {
        if (tBSOneComponent.getEntryClassLoader() == null) {
            a(tBSOneComponent.getName(), str, str2, "no entry class loader found", null);
        }
        try {
            Class<?> loadClass = tBSOneComponent.getEntryClassLoader().loadClass(str);
            if (TBSOneEventReceiver.class.isAssignableFrom(loadClass)) {
                ((TBSOneEventReceiver) loadClass.getConstructor(new Class[0]).newInstance(new Object[0])).onReceive(str2, map);
            } else {
                a(tBSOneComponent.getName(), str, str2, "can't assign receiver class to com.tencent.tbs.one.TBSOneEventReceiver", null);
            }
        } catch (ClassNotFoundException e16) {
            a(tBSOneComponent.getName(), str, str2, "can't load event receiver class", e16);
        } catch (NoSuchMethodException e17) {
            a(tBSOneComponent.getName(), str, str2, "can't find constructor method for event receiver class", e17);
        } catch (Exception e18) {
            a(tBSOneComponent.getName(), str, str2, "can't construct event receiver object", e18);
        }
    }

    @Override // com.tencent.tbs.one.TBSOneEventEmitter
    public final void emit(TBSOneEventEmitter.UnloadedBehavior unloadedBehavior, final String str, final String str2, final String str3, final Map<String, Object> map) {
        final h hVar = this.f374956a.get();
        if (hVar == null) {
            a(str, str2, str3, "TBSOneManager is not alive", null);
            return;
        }
        com.tencent.tbs.one.impl.c.a f16 = hVar.f(str);
        if (f16 == null) {
            if (unloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.IGNORE) {
                a(str, str2, str3, "component is not loaded yet", null);
                return;
            } else if (unloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.LOAD && hVar.b(str)) {
                a(str, str2, str3, "component is not installed yet", null);
                return;
            } else {
                o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.e.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        hVar.a(str, (Bundle) null, new TBSOneCallback<TBSOneComponent>() { // from class: com.tencent.tbs.one.impl.e.b.1.1
                            @Override // com.tencent.tbs.one.TBSOneCallback
                            public final /* synthetic */ void onCompleted(TBSOneComponent tBSOneComponent) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                com.tencent.tbs.one.impl.c.a f17 = hVar.f(str);
                                if (f17 != null) {
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    b.b(f17, str2, str3, map);
                                }
                            }
                        });
                    }
                });
                return;
            }
        }
        b(f16, str2, str3, map);
    }

    private static void a(String str, String str2) {
        com.tencent.tbs.one.impl.a.g.b("Failed to emit event %s, error: %s", str, str2);
    }

    private static void a(String str, String str2, String str3, String str4, Throwable th5) {
        com.tencent.tbs.one.impl.a.g.b("Failed to emit event %s to %s#%s, error: %s", str3, str, str2, str4, th5);
    }

    @Override // com.tencent.tbs.one.TBSOneEventEmitter
    public final void emit(String str, Map<String, Object> map) {
        h hVar = this.f374956a.get();
        if (hVar == null) {
            a(str, "TBSOneManager is not alive");
            return;
        }
        List<com.tencent.tbs.one.impl.common.g> list = hVar.f375054g.get(str);
        if (list == null) {
            a(str, "no event receiver found");
            return;
        }
        ListIterator<com.tencent.tbs.one.impl.common.g> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            com.tencent.tbs.one.impl.common.g next = listIterator.next();
            b(hVar.f(next.f374848a), next.f374849b, str, map);
        }
    }
}
