package gd0;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static void a(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, b.a(objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        hd0.c.g(str, b.a(objArr));
    }

    public static void c(String str, Object... objArr) {
        hd0.c.t(str, b.a(objArr));
    }
}
