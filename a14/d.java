package a14;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.HeapObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000f"}, d2 = {"La14/d;", "", "Lshark/HeapObject$HeapInstance;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "filedName", "", "b", "declaringClass", "c", "d", "e", "a", "<init>", "()V", "rmonitor-memory_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f25351a = new d();

    d() {
    }

    @JvmStatic
    @Nullable
    public static final HeapObject.HeapInstance a(@NotNull HeapObject.HeapInstance instance, @NotNull String declaringClass, @NotNull String filedName) {
        shark.c value;
        HeapObject b16;
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Intrinsics.checkParameterIsNotNull(declaringClass, "declaringClass");
        Intrinsics.checkParameterIsNotNull(filedName, "filedName");
        shark.a c16 = instance.c(declaringClass, filedName);
        if (c16 != null && (value = c16.getValue()) != null && (b16 = value.b()) != null) {
            return b16.a();
        }
        return null;
    }

    @JvmStatic
    public static final int b(@Nullable HeapObject.HeapInstance instance, @NotNull String filedName) {
        shark.a c16;
        shark.c value;
        Integer a16;
        Intrinsics.checkParameterIsNotNull(filedName, "filedName");
        if (instance != null && (c16 = instance.c(instance.e(), filedName)) != null && (value = c16.getValue()) != null && (a16 = value.a()) != null) {
            return a16.intValue();
        }
        return -1;
    }

    @JvmStatic
    public static final int c(@Nullable HeapObject.HeapInstance instance, @NotNull String declaringClass, @NotNull String filedName) {
        shark.a c16;
        shark.c value;
        Integer a16;
        Intrinsics.checkParameterIsNotNull(declaringClass, "declaringClass");
        Intrinsics.checkParameterIsNotNull(filedName, "filedName");
        if (instance != null && (c16 = instance.c(declaringClass, filedName)) != null && (value = c16.getValue()) != null && (a16 = value.a()) != null) {
            return a16.intValue();
        }
        return -1;
    }

    @JvmStatic
    @NotNull
    public static final String d(@Nullable HeapObject.HeapInstance instance, @NotNull String filedName) {
        shark.a c16;
        shark.c value;
        String c17;
        Intrinsics.checkParameterIsNotNull(filedName, "filedName");
        if (instance == null || (c16 = instance.c(instance.e(), filedName)) == null || (value = c16.getValue()) == null || (c17 = value.c()) == null) {
            return "";
        }
        return c17;
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull HeapObject.HeapInstance instance, @NotNull String declaringClass, @NotNull String filedName) {
        shark.c value;
        String c16;
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Intrinsics.checkParameterIsNotNull(declaringClass, "declaringClass");
        Intrinsics.checkParameterIsNotNull(filedName, "filedName");
        shark.a c17 = instance.c(declaringClass, filedName);
        if (c17 == null || (value = c17.getValue()) == null || (c16 = value.c()) == null) {
            return "";
        }
        return c16;
    }
}
