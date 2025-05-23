package c.t.m.g;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Context f29895a;

    public static final void a(boolean z16) {
    }

    public static final synchronized void a(Context context) {
        synchronized (o0.class) {
            if (f29895a == null || f29895a.getApplicationContext() == null) {
                if (context != null && context.getApplicationContext() != null) {
                    f29895a = context.getApplicationContext();
                    u.b();
                } else {
                    throw new NullPointerException("context cannot be null.");
                }
            }
        }
    }

    public static final synchronized Context a() {
        Context context;
        synchronized (o0.class) {
            if (f29895a != null) {
                context = f29895a;
            } else {
                throw new NullPointerException("u should init first.");
            }
        }
        return context;
    }
}
