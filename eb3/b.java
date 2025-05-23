package eb3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u000e\u001a\u00020\r2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u001e\u0010\f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\nj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002`\u000bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J#\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00102\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R8\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0013j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R8\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0013j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Leb3/b;", "", "Ljava/lang/Class;", "clazz", "", "name", "Ljava/lang/reflect/Field;", "b", "c", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "interfaceList", "", "d", "a", "", "e", "(Ljava/lang/Class;)[Ljava/lang/Class;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "sClassCache", "Ljava/lang/reflect/Method;", "sMethodCache", "Ljava/lang/reflect/Constructor;", "sConstructorCache", "sFiledCache", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f396065a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Class<?>> sClassCache = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Method> sMethodCache = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Constructor<?>> sConstructorCache = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Field> sFiledCache = new HashMap<>();

    b() {
    }

    private final Field b(Class<?> clazz, String name) {
        Field field = null;
        for (Class<?> cls : e(clazz)) {
            try {
                field = cls.getField(name);
            } catch (NoSuchFieldException unused) {
            }
        }
        return field;
    }

    private final String f(Class<?> clazz, String name) {
        return clazz.getName() + '#' + name;
    }

    public final Field a(Class<?> clazz, String name) {
        Field field;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(name, "name");
        String f16 = f(clazz, name);
        HashMap<String, Field> hashMap = sFiledCache;
        synchronized (hashMap) {
            field = hashMap.get(f16);
            Unit unit = Unit.INSTANCE;
        }
        if (field == null) {
            field = c(clazz, name);
        }
        if (field == null) {
            field = b(clazz, name);
        }
        if (field != null) {
            Field field2 = field;
            field2.setAccessible(true);
            synchronized (hashMap) {
                hashMap.put(f16, field);
            }
            return field2;
        }
        throw new IllegalAccessException("no such field:clazz=" + clazz.getName() + ", field=" + name);
    }

    public final Class<?>[] e(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        d(clazz, arrayList);
        Object[] array = arrayList.toArray(new Class[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Class[]) array;
    }

    private final Field c(Class<?> clazz, String name) {
        while (clazz != null) {
            try {
                Field declaredField = clazz.getDeclaredField(name);
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    private final void d(Class<?> clazz, ArrayList<Class<?>> interfaceList) {
        if (clazz == null) {
            return;
        }
        Class<?>[] interfaces = clazz.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
        CollectionsKt__MutableCollectionsKt.addAll(interfaceList, interfaces);
        d(clazz.getSuperclass(), interfaceList);
    }
}
