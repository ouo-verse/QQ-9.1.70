package com.tencent.beacon.base.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f77791a = new AtomicBoolean(false);

    public static void a(String str) {
        c.b("[strict]  " + str, new Object[0]);
        if (f77791a.get()) {
            throw new IllegalStateException("[strict] " + str);
        }
    }

    public static void a(Map map) {
        if (!f77791a.get() || map == null) {
            return;
        }
        for (Object obj : map.keySet()) {
            if (!(obj instanceof String)) {
                a("Key\u5fc5\u987b\u4e3aString\u7c7b\u578b!");
            }
            if (!(map.get(obj) instanceof String)) {
                a("Value\u5fc5\u987b\u4e3aString\u7c7b\u578b!");
            }
        }
    }

    private static boolean a() {
        return f77791a.get() || com.tencent.beacon.a.c.b.d(com.tencent.beacon.a.c.c.c().b());
    }

    public static boolean a(String str, Object obj) {
        boolean z16;
        if (obj instanceof String) {
            z16 = TextUtils.isEmpty((String) obj);
        } else {
            z16 = obj == null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(" ");
        sb5.append(obj == null ? ContainerUtils.KEY_VALUE_DELIMITER : "!");
        sb5.append("= null!");
        c.a(sb5.toString(), new Object[0]);
        if (!z16 || !a()) {
            return z16;
        }
        throw new NullPointerException(str + " == null!");
    }
}
