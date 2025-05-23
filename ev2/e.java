package ev2;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class e {
    public static tv2.a a(Context context, AttributeSet attributeSet) {
        hv2.f c16 = c();
        if (c16 != null) {
            return c16.a(context, attributeSet);
        }
        return null;
    }

    public static Integer b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str.toLowerCase()));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static hv2.f c() {
        return (hv2.f) dv2.b.d().a(hv2.f.class);
    }

    public static hv2.a d() {
        hv2.f c16 = c();
        if (c16 != null) {
            return c16.b();
        }
        return null;
    }

    public static boolean e() {
        hv2.f c16 = c();
        if (c16 != null) {
            return c16.c();
        }
        return false;
    }
}
