package k74;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lk74/f;", "", "Lk74/e;", "method", "Landroid/os/Bundle;", "bundleParam", "", "a", "(Lk74/e;Landroid/os/Bundle;)[Ljava/lang/Object;", "Ljava/lang/Class;", "type", "", "curIndex", "", "key", "b", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f411829a = new f();

    f() {
    }

    @JvmStatic
    public static final Object[] a(e method, Bundle bundleParam) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(bundleParam, "bundleParam");
        Class<?>[] types = method.d().getParameterTypes();
        Object[] objArr = new Object[types.length];
        Intrinsics.checkNotNullExpressionValue(types, "types");
        int length = types.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            Class<?> type = l74.a.l(types[i3]);
            f fVar = f411829a;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            objArr[i16] = fVar.b(type, i16, bundleParam, "ipc_param_" + i16);
            i3++;
            i16++;
        }
        return objArr;
    }

    public final Object b(Class<?> type, int curIndex, Bundle bundleParam, String key) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bundleParam, "bundleParam");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(type, Boolean.class)) {
            return Boolean.valueOf(bundleParam.getBoolean(key, false));
        }
        if (Intrinsics.areEqual(type, Integer.class)) {
            return Integer.valueOf(bundleParam.getInt(key, 0));
        }
        if (Intrinsics.areEqual(type, Long.class)) {
            return Long.valueOf(bundleParam.getLong(key, 0L));
        }
        if (Intrinsics.areEqual(type, Short.TYPE)) {
            return Short.valueOf(bundleParam.getShort(key, (short) 0));
        }
        if (Intrinsics.areEqual(type, Byte.TYPE)) {
            return bundleParam.getByte(key, (byte) 0);
        }
        if (Intrinsics.areEqual(type, Double.TYPE)) {
            return Double.valueOf(bundleParam.getDouble(key, 0.0d));
        }
        if (Intrinsics.areEqual(type, Float.TYPE)) {
            return Float.valueOf(bundleParam.getFloat(key, 0.0f));
        }
        if (Intrinsics.areEqual(type, Character.TYPE)) {
            return Character.valueOf(bundleParam.getChar(key));
        }
        if (Intrinsics.areEqual(type, String.class)) {
            return bundleParam.getString(key);
        }
        if (Intrinsics.areEqual(type, Bundle.class)) {
            return bundleParam.getBundle(key);
        }
        Intrinsics.areEqual(type, Void.class);
        g gVar = g.f411830a;
        if (gVar.b(type)) {
            int i3 = bundleParam.getInt("ipc_param__arr_type" + curIndex);
            if (i3 == 1) {
                return bundleParam.getIntegerArrayList(key);
            }
            if (i3 == 2) {
                return bundleParam.getStringArrayList(key);
            }
            if (i3 == 3) {
                return bundleParam.getCharSequenceArrayList(key);
            }
            if (i3 == 4) {
                return bundleParam.getParcelableArrayList(key);
            }
        }
        if (gVar.e(type)) {
            return bundleParam.getParcelable(key);
        }
        if (gVar.f(type)) {
            return bundleParam.getSerializable(key);
        }
        if (gVar.d(type)) {
            return new JSONObject(bundleParam.getString(key));
        }
        if (gVar.c(type)) {
            return new JSONArray(bundleParam.getString(key));
        }
        return null;
    }
}
