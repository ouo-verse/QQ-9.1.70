package h45;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public class b {
    public static boolean a(Collection collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean b(Collection collection) {
        return !a(collection);
    }
}
