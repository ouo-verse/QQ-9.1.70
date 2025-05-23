package k74;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\n\u001a\u00020\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0002J4\u0010\u000e\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u000f\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0001H\u0007J%\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u0018\u001a\u00020\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0001J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0001J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0001\u00a8\u0006 "}, d2 = {"Lk74/g;", "", "Ljava/lang/Class;", "type", "Landroid/os/Bundle;", "param", "", "key", "value", "", "j", "", "curIndex", "", tl.h.F, "k", "arg", "a", "Lk74/e;", "methodToken", "", "args", "g", "(Lk74/e;[Ljava/lang/Object;)Landroid/os/Bundle;", "i", "b", "e", "f", "d", "c", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f411830a = new g();

    g() {
    }

    @JvmStatic
    public static final int a(Object arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        if (!f411830a.b(arg.getClass())) {
            return -1;
        }
        ArrayList arrayList = (ArrayList) arg;
        if (arrayList.size() == 0) {
            return 1;
        }
        if (arrayList.get(0) == null) {
            return 4;
        }
        Class<?> cls = arrayList.get(0).getClass();
        if (Intrinsics.areEqual(cls, Integer.class)) {
            return 1;
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            return 2;
        }
        if (Intrinsics.areEqual(cls, CharSequence.class)) {
            return 3;
        }
        return Intrinsics.areEqual(cls, Parcelable.class) ? 4 : -1;
    }

    private final boolean h(Class<?> type, Object value, Bundle param, int curIndex, String key) {
        if (!b(type)) {
            return false;
        }
        int a16 = a(value);
        param.putInt("ipc_param__arr_type" + curIndex, a16);
        if (a16 == 1) {
            param.putIntegerArrayList(key, (ArrayList) value);
            return true;
        }
        if (a16 == 2) {
            param.putStringArrayList(key, (ArrayList) value);
            return true;
        }
        if (a16 == 3) {
            param.putCharSequenceArrayList(key, (ArrayList) value);
            return true;
        }
        if (a16 != 4) {
            return false;
        }
        param.putParcelableArrayList(key, (ArrayList) value);
        return true;
    }

    private final void j(Class<?> type, Bundle param, String key, Object value) {
        if (d(type)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONObject");
            param.putString(key, ((JSONObject) value).toString());
        } else if (c(type)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONArray");
            param.putString(key, ((JSONArray) value).toString());
        }
    }

    private final boolean k(Class<?> type, Bundle param, String key, Object value) {
        if (Intrinsics.areEqual(type, Boolean.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
            param.putBoolean(key, ((Boolean) value).booleanValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Integer.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
            param.putInt(key, ((Integer) value).intValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Long.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
            param.putLong(key, ((Long) value).longValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Short.TYPE)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Short");
            param.putShort(key, ((Short) value).shortValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Byte.TYPE)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Byte");
            param.putByte(key, ((Byte) value).byteValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Double.TYPE)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
            param.putDouble(key, ((Double) value).doubleValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Float.TYPE)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
            param.putFloat(key, ((Float) value).floatValue());
            return true;
        }
        if (Intrinsics.areEqual(type, Character.TYPE)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Char");
            param.putChar(key, ((Character) value).charValue());
            return true;
        }
        if (Intrinsics.areEqual(type, String.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
            param.putString(key, (String) value);
            return true;
        }
        if (Intrinsics.areEqual(type, Bundle.class)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.os.Bundle");
            param.putBundle(key, (Bundle) value);
            return true;
        }
        Intrinsics.areEqual(type, Void.class);
        return false;
    }

    public final boolean b(Object type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(type, ArrayList.class);
    }

    public final boolean c(Object type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(type, JSONArray.class);
    }

    public final boolean d(Object type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(type, JSONObject.class);
    }

    public final boolean e(Object type) {
        Intrinsics.checkNotNullParameter(type, "type");
        while (!Intrinsics.areEqual(type, Parcelable.class)) {
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) type;
            Class<?>[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "interfaces");
            for (Class<?> cls2 : interfaces) {
                if (Intrinsics.areEqual(cls2, Parcelable.class)) {
                    return true;
                }
            }
            if (cls.getSuperclass() == null) {
                return false;
            }
            type = cls.getSuperclass();
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
        }
        return true;
    }

    public final boolean f(Object type) {
        Intrinsics.checkNotNullParameter(type, "type");
        while (!Intrinsics.areEqual(type, Serializable.class)) {
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) type;
            Class<?>[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "interfaces");
            for (Class<?> cls2 : interfaces) {
                if (Intrinsics.areEqual(cls2, Serializable.class)) {
                    return true;
                }
            }
            if (cls.getSuperclass() == null) {
                return false;
            }
            type = cls.getSuperclass();
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
        }
        return true;
    }

    public final Bundle g(e methodToken, Object[] args) {
        Intrinsics.checkNotNullParameter(methodToken, "methodToken");
        Bundle bundle = new Bundle();
        if (args == null) {
            return bundle;
        }
        Class<?>[] types = methodToken.d().getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(types, "types");
        int length = types.length;
        int i3 = 0;
        int i16 = 0;
        while (i16 < length) {
            int i17 = i3 + 1;
            String str = "ipc_param_" + i3;
            Class<?> type = l74.a.l(types[i16]);
            Object obj = args[i3];
            if (obj != null) {
                g gVar = f411830a;
                Intrinsics.checkNotNullExpressionValue(type, "type");
                gVar.i(type, bundle, str, obj, i3);
            }
            i16++;
            i3 = i17;
        }
        h callback = methodToken.getCallback();
        if (callback != null) {
            bundle.putString("ipc_param_" + methodToken.getCallbackIndex(), callback.getName());
        }
        return bundle;
    }

    public final void i(Class<?> type, Bundle param, String key, Object value, int curIndex) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (k(type, param, key, value) || h(type, value, param, curIndex, key)) {
            return;
        }
        if (e(type)) {
            param.putParcelable(key, (Parcelable) value);
        } else if (f(type)) {
            param.putSerializable(key, (Serializable) value);
        } else {
            j(type, param, key, value);
        }
    }
}
