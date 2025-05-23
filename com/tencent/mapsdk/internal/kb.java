package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mapsdk.internal.jz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kb {

    /* renamed from: a, reason: collision with root package name */
    lo f148953a = new lo();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Map<String, jz>> f148954b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <D extends ka, C extends jz<D>> C a(Class<D> cls, jz.a aVar, Class<C> cls2) {
        C c16;
        Map<String, jz> map = this.f148954b.get(cls2.getName());
        String a16 = kd.a(cls.getName() + aVar.toString());
        String name = cls2.getName();
        Constructor<?> constructor = null;
        if (map != null) {
            c16 = (C) map.get(a16);
            if (c16 != null) {
                return c16;
            }
        } else {
            c16 = null;
        }
        for (Constructor<?> constructor2 : cls2.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == aVar.getClass()) {
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            try {
                c16 = (C) ((jz) constructor.newInstance(aVar));
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            } catch (InvocationTargetException e18) {
                e18.printStackTrace();
            }
        }
        if (c16 != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(a16, c16);
            this.f148954b.put(name, map);
        }
        return c16;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a<D extends ka> extends lh<String, D> {

        /* renamed from: a, reason: collision with root package name */
        private jz.b<D> f148955a;

        public a(int i3, jz.b<D> bVar) {
            super(i3);
            this.f148955a = bVar;
        }

        @Override // com.tencent.mapsdk.internal.lh
        public final /* bridge */ /* synthetic */ int a(Object obj) {
            ka kaVar = (ka) obj;
            if (kaVar != null) {
                return kaVar.a();
            }
            return 0;
        }

        @Override // com.tencent.mapsdk.internal.lh
        public final /* bridge */ /* synthetic */ void a(boolean z16, @NonNull String str, @NonNull Object obj, @Nullable Object obj2) {
            jz.b<D> bVar;
            ka kaVar = (ka) obj;
            if (!z16 || (bVar = this.f148955a) == null) {
                return;
            }
            bVar.a(kaVar);
        }

        private static int a(D d16) {
            if (d16 != null) {
                return d16.a();
            }
            return 0;
        }

        private void a(boolean z16, @NonNull D d16) {
            jz.b<D> bVar;
            if (!z16 || (bVar = this.f148955a) == null) {
                return;
            }
            bVar.a(d16);
        }
    }

    private String a(String str) {
        return this.f148953a.a(str);
    }
}
