package androidx.core.util;

import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DebugUtils {
    DebugUtils() {
    }

    public static void buildShortClassTag(Object obj, StringBuilder sb5) {
        int lastIndexOf;
        if (obj == null) {
            sb5.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb5.append(simpleName);
        sb5.append('{');
        sb5.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
