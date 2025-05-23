package com.tencent.kuikly.core.render.android.expand.vendor;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0004\u001e#\u0016\u0003B\u001f\b\u0002\u0012\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\u0006\u001a\u00020\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u00020\n2\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0004\"\u0006\u0012\u0002\b\u00030\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u001d\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rJ-\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0004\"\u0006\u0012\u0002\b\u00030\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\rH\u0016R\u001b\u0010\"\u001a\u0006\u0012\u0002\b\u00030\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "", "", "d", "", "args", "k", "([Ljava/lang/Object;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "Ljava/lang/Class;", "types", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a$b;", "g", "([Ljava/lang/Class;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a$b;", "", "name", "value", "l", "T", "i", "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a$c;", h.F, "c", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a$d;", "j", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a$d;", "e", "()Ljava/lang/Object;", "toString", "a", "Ljava/lang/Class;", "f", "()Ljava/lang/Class;", "clazz", "b", "Ljava/lang/Object;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "(Ljava/lang/Class;Ljava/lang/Object;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.kuikly.core.render.android.expand.vendor.a, reason: from toString */
/* loaded from: classes7.dex */
public final class KRReflect {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Class<?> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private Object instance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0007J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J1\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\r2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u0016\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\r2\u0012\u0010\u0017\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\rH\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a$a;", "", "Ljava/lang/Class;", "clazz", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "c", "d", "", "name", "Ljava/lang/ClassLoader;", "loader", "e", "", "args", "i", "([Ljava/lang/Object;)[Ljava/lang/Class;", "Ljava/lang/reflect/AccessibleObject;", "T", "accessible", "a", "(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;", "declaredTypes", "actualTypes", "", h.F, "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "source", "b", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.vendor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ KRReflect f(Companion companion, Class cls, Object obj, int i3, Object obj2) {
            if ((i3 & 2) != 0) {
                obj = null;
            }
            return companion.c(cls, obj);
        }

        public static /* synthetic */ KRReflect g(Companion companion, String str, ClassLoader classLoader, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                classLoader = null;
            }
            return companion.e(str, classLoader);
        }

        @JvmStatic
        @NotNull
        public final <T extends AccessibleObject> T a(@NotNull T accessible) {
            Intrinsics.checkNotNullParameter(accessible, "accessible");
            if (!accessible.isAccessible()) {
                accessible.setAccessible(true);
            }
            return accessible;
        }

        @JvmStatic
        @NotNull
        public final Class<?> b(@NotNull Class<?> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            String name = source.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        Intrinsics.checkNotNullExpressionValue(Double.class, "Class.forName(\"java.lang.Double\")");
                        return Double.class;
                    }
                    return source;
                case 104431:
                    if (name.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                        Intrinsics.checkNotNullExpressionValue(Integer.class, "Class.forName(\"java.lang.Integer\")");
                        return Integer.class;
                    }
                    return source;
                case 3039496:
                    if (name.equals("byte")) {
                        Intrinsics.checkNotNullExpressionValue(Byte.class, "Class.forName(\"java.lang.Byte\")");
                        return Byte.class;
                    }
                    return source;
                case 3052374:
                    if (name.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
                        Intrinsics.checkNotNullExpressionValue(Character.class, "Class.forName(\"java.lang.Character\")");
                        return Character.class;
                    }
                    return source;
                case 3327612:
                    if (name.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                        Intrinsics.checkNotNullExpressionValue(Long.class, "Class.forName(\"java.lang.Long\")");
                        return Long.class;
                    }
                    return source;
                case 64711720:
                    if (name.equals(HippyControllerProps.BOOLEAN)) {
                        Intrinsics.checkNotNullExpressionValue(Boolean.class, "Class.forName(\"java.lang.Boolean\")");
                        return Boolean.class;
                    }
                    return source;
                case 97526364:
                    if (name.equals("float")) {
                        Intrinsics.checkNotNullExpressionValue(Float.class, "Class.forName(\"java.lang.Float\")");
                        return Float.class;
                    }
                    return source;
                case 109413500:
                    if (name.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                        Intrinsics.checkNotNullExpressionValue(Short.class, "Class.forName(\"java.lang.Short\")");
                        return Short.class;
                    }
                    return source;
                default:
                    return source;
            }
        }

        @JvmStatic
        @NotNull
        public final KRReflect c(@NotNull Class<?> clazz, @Nullable Object any) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return new KRReflect(clazz, any, null);
        }

        @JvmStatic
        @NotNull
        public final KRReflect d(@NotNull Object any) {
            Intrinsics.checkNotNullParameter(any, "any");
            if (any instanceof Class) {
                return f(this, (Class) any, null, 2, null);
            }
            if (any instanceof String) {
                return g(this, (String) any, null, 2, null);
            }
            return c(any.getClass(), any);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.kuikly.core.render.android.expand.vendor.a] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        @JvmStatic
        @NotNull
        public final KRReflect e(@NotNull String name, @Nullable ClassLoader loader) {
            Intrinsics.checkNotNullParameter(name, "name");
            DefaultConstructorMarker defaultConstructorMarker = null;
            try {
                if (loader == null) {
                    Class<?> cls = Class.forName(name);
                    Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(name)");
                    name = f(this, cls, null, 2, null);
                } else {
                    Class<?> cls2 = Class.forName(name, true, loader);
                    Intrinsics.checkNotNullExpressionValue(cls2, "Class.forName(name, true, loader)");
                    name = f(this, cls2, null, 2, null);
                }
                return name;
            } catch (Exception unused) {
                return new KRReflect(name.getClass(), name, defaultConstructorMarker);
            }
        }

        @JvmStatic
        public final boolean h(@NotNull Class<?>[] declaredTypes, @NotNull Class<?>[] actualTypes) {
            Intrinsics.checkNotNullParameter(declaredTypes, "declaredTypes");
            Intrinsics.checkNotNullParameter(actualTypes, "actualTypes");
            if (declaredTypes.length != actualTypes.length) {
                return false;
            }
            int length = declaredTypes.length;
            for (int i3 = 0; i3 < length; i3++) {
                Class<?> cls = declaredTypes[i3];
                if ((!Intrinsics.areEqual(actualTypes[i3], Void.class) || cls.isPrimitive()) && !b(cls).isAssignableFrom(b(actualTypes[i3]))) {
                    return false;
                }
            }
            return true;
        }

        @JvmStatic
        @NotNull
        public final Class<?>[] i(@NotNull Object... args) {
            boolean z16;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(args, "args");
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new Class[0];
            }
            int length = args.length;
            Class<?>[] clsArr = new Class[length];
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = args[i3];
                if (obj != null) {
                    cls = obj.getClass();
                } else {
                    cls = Void.class;
                }
                clsArr[i3] = cls;
            }
            return clsArr;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0002\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a$b;", "", "", "args", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "a", "([Ljava/lang/Object;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "Ljava/lang/reflect/Constructor;", "Ljava/lang/reflect/Constructor;", "getConstructor", "()Ljava/lang/reflect/Constructor;", "constructor", "b", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "getUpper", "()Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "upper", "<init>", "(Ljava/lang/reflect/Constructor;Lcom/tencent/kuikly/core/render/android/expand/vendor/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.vendor.a$b */
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Constructor<?> constructor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KRReflect upper;

        public b(@NotNull Constructor<?> constructor, @NotNull KRReflect upper) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Intrinsics.checkNotNullParameter(upper, "upper");
            this.constructor = constructor;
            this.upper = upper;
        }

        @NotNull
        public final KRReflect a(@NotNull Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            Companion companion = KRReflect.INSTANCE;
            Object newInstance = this.constructor.newInstance(Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNullExpressionValue(newInstance, "constructor.newInstance(*args)");
            return companion.d(newInstance);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001R\u0017\u0010\t\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a$c;", "", "T", "a", "()Ljava/lang/Object;", "value", "b", "", "Z", "isStatic", "()Z", "Ljava/lang/reflect/Field;", "Ljava/lang/reflect/Field;", "getField", "()Ljava/lang/reflect/Field;", "field", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "c", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "getUpper", "()Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "upper", "<init>", "(Ljava/lang/reflect/Field;Lcom/tencent/kuikly/core/render/android/expand/vendor/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.vendor.a$c */
    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isStatic;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Field field;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KRReflect upper;

        public c(@NotNull Field field, @NotNull KRReflect upper) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(upper, "upper");
            this.field = field;
            this.upper = upper;
            this.isStatic = Modifier.isStatic(field.getModifiers());
        }

        @Nullable
        public final <T> T a() {
            T t16;
            try {
                if (!this.isStatic) {
                    this.upper.d();
                    t16 = (T) this.field.get(this.upper.instance);
                } else {
                    t16 = (T) this.field.get(this.upper.f());
                }
                return t16;
            } catch (Exception unused) {
                return null;
            }
        }

        @NotNull
        public final c b(@Nullable Object value) {
            if (!this.isStatic) {
                this.upper.d();
                this.field.set(this.upper.instance, value);
            } else {
                this.field.set(this.upper.f(), value);
            }
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0002\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/a$d;", "", "", "args", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "a", "([Ljava/lang/Object;)Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "", "Z", "isStatic", "()Z", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "method", "c", "Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "getUpper", "()Lcom/tencent/kuikly/core/render/android/expand/vendor/a;", "upper", "<init>", "(Ljava/lang/reflect/Method;Lcom/tencent/kuikly/core/render/android/expand/vendor/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.vendor.a$d */
    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isStatic;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Method method;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KRReflect upper;

        public d(@NotNull Method method, @NotNull KRReflect upper) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(upper, "upper");
            this.method = method;
            this.upper = upper;
            this.isStatic = Modifier.isStatic(method.getModifiers());
        }

        @NotNull
        public final KRReflect a(@NotNull Object... args) {
            Object invoke;
            Intrinsics.checkNotNullParameter(args, "args");
            if (!this.isStatic) {
                this.upper.d();
                invoke = this.method.invoke(this.upper.instance, Arrays.copyOf(args, args.length));
            } else {
                invoke = this.method.invoke(this.upper.f(), Arrays.copyOf(args, args.length));
            }
            Companion companion = KRReflect.INSTANCE;
            if (invoke == null) {
                invoke = "";
            }
            return companion.d(invoke);
        }
    }

    KRReflect(Class<?> cls, Object obj) {
        this.clazz = cls;
        this.instance = obj;
    }

    @NotNull
    public final KRReflect c(@NotNull String name, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Class<?>[] i3 = INSTANCE.i(Arrays.copyOf(args, args.length));
        return j(name, (Class[]) Arrays.copyOf(i3, i3.length)).a(Arrays.copyOf(args, args.length));
    }

    @Nullable
    public final <T> T e() {
        try {
            return (T) this.instance;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @NotNull
    public final Class<?> f() {
        return this.clazz;
    }

    @NotNull
    public final b g(@NotNull Class<?>... types) {
        Constructor<?> constructor;
        Intrinsics.checkNotNullParameter(types, "types");
        try {
            constructor = this.clazz.getDeclaredConstructor((Class[]) Arrays.copyOf(types, types.length));
            Intrinsics.checkNotNullExpressionValue(constructor, "clazz.getDeclaredConstructor(*types)");
        } catch (NoSuchMethodException unused) {
            Constructor<?>[] declaredConstructors = this.clazz.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    Constructor<?> constructor2 = declaredConstructors[i3];
                    Companion companion = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(constructor2, "constructor");
                    Class<?>[] parameterTypes = constructor2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
                    if (companion.h(parameterTypes, types)) {
                        constructor = constructor2;
                        break;
                    }
                    i3++;
                } else {
                    constructor = null;
                    break;
                }
            }
            if (constructor == null) {
                throw new ReflectException("");
            }
        }
        return new b((Constructor) INSTANCE.a(constructor), this);
    }

    @NotNull
    public final c h(@NotNull String name) {
        Field field;
        Intrinsics.checkNotNullParameter(name, "name");
        Class<?> cls = this.clazz;
        try {
            Companion companion = INSTANCE;
            Intrinsics.checkNotNull(cls);
            field = (Field) companion.a(cls.getField(name));
        } catch (NoSuchFieldException e16) {
            Field field2 = null;
            do {
                try {
                    Companion companion2 = INSTANCE;
                    Intrinsics.checkNotNull(cls);
                    Field field3 = (Field) companion2.a(cls.getDeclaredField(name));
                    field2 = field3;
                    if (field3 != null) {
                        break;
                    }
                } catch (NoSuchFieldException unused) {
                }
                if (cls != null) {
                    cls = cls.getSuperclass();
                } else {
                    cls = null;
                }
            } while (cls != null);
            if (field2 != null) {
                field = field2;
            } else {
                throw new ReflectException(e16);
            }
        }
        Intrinsics.checkNotNullExpressionValue(field, "field");
        return new c(field, this);
    }

    @Nullable
    public final <T> T i(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) h(name).a();
    }

    @NotNull
    public final d j(@NotNull String name, @NotNull Class<?>... types) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(types, "types");
        Method method = null;
        for (Class<?> cls = this.clazz; cls != null; cls = cls.getSuperclass()) {
            try {
                method = cls.getDeclaredMethod(name, (Class[]) Arrays.copyOf(types, types.length));
                break;
            } catch (NoSuchMethodException unused) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        Method method2 = declaredMethods[i3];
                        Intrinsics.checkNotNullExpressionValue(method2, "method");
                        if (Intrinsics.areEqual(method2.getName(), name)) {
                            Companion companion = INSTANCE;
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
                            if (companion.h(parameterTypes, types)) {
                                method = method2;
                                break;
                            }
                        }
                        i3++;
                    }
                }
            }
        }
        Companion companion2 = INSTANCE;
        if (method != null) {
            companion2.a(method);
            return new d(method, this);
        }
        throw new RuntimeException("method:" + name + " not found");
    }

    @NotNull
    public final KRReflect k(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Class<?>[] i3 = INSTANCE.i(Arrays.copyOf(args, args.length));
        return g((Class[]) Arrays.copyOf(i3, i3.length)).a(Arrays.copyOf(args, args.length));
    }

    @NotNull
    public final KRReflect l(@NotNull String name, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        h(name).b(value);
        return this;
    }

    @NotNull
    public String toString() {
        return "KRReflect(clazz=" + this.clazz + ", instance=" + this.instance + ')';
    }

    public /* synthetic */ KRReflect(Class cls, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
    }
}
