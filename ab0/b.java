package ab0;

import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static Object a(int i3, View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(i3);
        if (tag != null) {
            return tag;
        }
        if (!(view.getParent() instanceof View)) {
            return null;
        }
        return a(i3, (View) view.getParent());
    }
}
