package lk0;

import android.support.annotation.Nullable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    @Nullable
    public static b a(String str) {
        Class<? extends b> a16;
        if (TextUtils.isEmpty(str) || (a16 = fk0.a.a(str)) == null) {
            return null;
        }
        try {
            if (b.class.isAssignableFrom(a16)) {
                return a16.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
