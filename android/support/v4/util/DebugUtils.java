package android.support.v4.util;

/* compiled from: P */
/* loaded from: classes.dex */
public class DebugUtils {
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
