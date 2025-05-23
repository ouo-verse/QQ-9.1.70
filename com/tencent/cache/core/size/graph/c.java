package com.tencent.cache.core.size.graph;

import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final c f98794b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ c[] f98795c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<Class<?>, c> f98796d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final d f98797e;

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f98798a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        
            if (r0.isEnum() != false) goto L21;
         */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final c a(@NotNull Class<?> clazz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            if (((HashMap) c.f98796d).isEmpty()) {
                for (c cVar : c.values()) {
                    ((HashMap) c.f98796d).put(cVar.f98798a, cVar);
                }
            }
            if (!clazz.isEnum()) {
                if (clazz.getSuperclass() != null) {
                    Class<? super Object> superclass = clazz.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(superclass, "clazz.superclass");
                }
                return (c) ((HashMap) c.f98796d).get(clazz);
            }
            return c.f98794b;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14361);
        $redirector_ = redirector;
        int i3 = 1;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        c cVar = new c("ENUM", 0) { // from class: com.tencent.cache.core.size.graph.c.e
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Enum.class, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                return true;
            }
        };
        f98794b = cVar;
        f98795c = new c[]{cVar, new c("CLASS", i3) { // from class: com.tencent.cache.core.size.graph.c.c
            static IPatchRedirector $redirector_;

            {
                super(r4, i3, Class.class, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, i3);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                return true;
            }
        }, new c(AlbumSocialInfoCacheData.TYPE_ALBUM_IS_LIKED, 2) { // from class: com.tencent.cache.core.size.graph.c.a
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Boolean.TYPE, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                if (obj != Boolean.TRUE && obj != Boolean.FALSE) {
                    return false;
                }
                return true;
            }
        }, new c("INTEGER", 3) { // from class: com.tencent.cache.core.size.graph.c.f
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Integer.class, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                int intValue = ((Integer) obj).intValue();
                if (intValue >= -128 && intValue <= 127) {
                    return true;
                }
                return false;
            }
        }, new c("SHORT", 4) { // from class: com.tencent.cache.core.size.graph.c.h
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Short.TYPE, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                int intValue = ((Integer) obj).intValue();
                if (intValue >= -128 && intValue <= 127) {
                    return true;
                }
                return false;
            }
        }, new c("BYTE", 5) { // from class: com.tencent.cache.core.size.graph.c.b
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Byte.TYPE, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                if (obj == Byte.valueOf(((Byte) obj).byteValue())) {
                    return true;
                }
                return false;
            }
        }, new c("LONG", 6) { // from class: com.tencent.cache.core.size.graph.c.g
            static IPatchRedirector $redirector_;

            {
                super(r4, r5, Long.TYPE, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                }
            }

            @Override // com.tencent.cache.core.size.graph.c
            public boolean a(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(obj, "obj");
                int intValue = ((Integer) obj).intValue();
                if (intValue >= -128 && intValue <= 127) {
                    return true;
                }
                return false;
            }
        }};
        f98797e = new d();
        f98796d = new HashMap();
    }

    public c(String str, int i3, Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f98798a = cls;
        } else {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), cls);
        }
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f98795c.clone();
    }

    public abstract boolean a(@NotNull Object obj);

    public /* synthetic */ c(String str, int i3, Class cls, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, cls);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), cls, defaultConstructorMarker);
    }
}
