package m45;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class b {
    private void b(Object obj, Field field, Bundle bundle) {
        if (!Modifier.isTransient(field.getModifiers())) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            c(field.getName(), field.get(obj), bundle);
            field.setAccessible(isAccessible);
        }
    }

    private void c(String str, Object obj, Bundle bundle) {
        if (obj != null) {
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
                return;
            }
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return;
            }
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
                return;
            }
            if (obj instanceof IBinder) {
                a.a(bundle, str, (IBinder) obj);
                return;
            }
            if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
                return;
            }
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            if (obj instanceof List) {
                d(str, (List) obj, bundle);
                return;
            }
            if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj.getClass() != Object.class) {
                Bundle a16 = a(obj, new Bundle());
                a16.putInt("_val_type_", 0);
                bundle.putBundle(str, a16);
            }
        }
    }

    public Bundle a(Object obj, Bundle bundle) {
        for (Class<?> cls = obj.getClass(); cls != null && cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    b(obj, field, bundle);
                } catch (IllegalAccessException | IllegalArgumentException e16) {
                    Log.e("MessageCodec", "encode, get value of the field exception, field name: " + field.getName(), e16);
                }
            }
        }
        return bundle;
    }

    protected void d(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            c("_list_item_" + i3, list.get(i3), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
