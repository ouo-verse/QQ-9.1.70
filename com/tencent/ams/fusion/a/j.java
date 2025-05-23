package com.tencent.ams.fusion.a;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {
    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        String obj2 = obj.toString();
        if (TextUtils.isEmpty(obj2)) {
            return "";
        }
        try {
            return URLEncoder.encode(obj2, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
        } catch (Throwable th5) {
            f.d("encode error", th5);
            return "";
        }
    }

    public static boolean b(Collection<?> collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean c(Map<?, ?> map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean d(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }
}
