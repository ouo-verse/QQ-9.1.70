package fk0;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Class<? extends lk0.b>> f399702a = new HashMap();

    public static Class<? extends lk0.b> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Class<? extends lk0.b> cls = f399702a.get(str);
        if (cls == null) {
            return lk0.b.class;
        }
        return cls;
    }

    public static boolean b(String str, Class<? extends lk0.b> cls) {
        if (cls == null || TextUtils.isEmpty(str) || f399702a.containsKey(str)) {
            return false;
        }
        f399702a.put(str, cls);
        return true;
    }
}
