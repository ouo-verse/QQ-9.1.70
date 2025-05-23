package ia1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f407357a;

    public static int a() {
        if (com.tencent.mobileqq.colornote.a.f201327a == -1) {
            com.tencent.mobileqq.colornote.a.f201327a = b.a();
        }
        return com.tencent.mobileqq.colornote.a.f201327a;
    }

    public static void b() {
        if (QLog.isColorLevel()) {
            QLog.i("ColorNoteCommonUtil", 2, "resetMaxCountAndUseStyle");
        }
        f407357a = null;
        com.tencent.mobileqq.colornote.a.f201327a = -1;
    }

    public static boolean c() {
        if (f407357a == null) {
            f407357a = Boolean.valueOf(b.e());
        }
        return f407357a.booleanValue();
    }
}
