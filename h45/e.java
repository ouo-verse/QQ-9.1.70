package h45;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes29.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f404316a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f404317b = new Object();

    e(Context context) {
        new f(context);
    }

    public static e a(Context context) {
        synchronized (f404317b) {
            if (f404316a == null) {
                if (context.getApplicationContext() != null) {
                    f404316a = new e(context.getApplicationContext());
                } else {
                    f404316a = new e(context);
                }
            }
        }
        return f404316a;
    }

    public String b() {
        return "com.hihonor.id";
    }
}
