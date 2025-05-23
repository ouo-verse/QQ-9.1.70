package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class u implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private Context f389858d;

    /* renamed from: e, reason: collision with root package name */
    private File f389859e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f389860f;

    public static void b(Context context, File file, final Runnable runnable) {
        new u(context, file) { // from class: com.xiaomi.push.u.1
            @Override // com.xiaomi.push.u
            protected void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        ik ikVar = null;
        try {
            try {
                if (this.f389859e == null) {
                    this.f389859e = new File(this.f389858d.getFilesDir(), "default_locker");
                }
                ikVar = ik.a(this.f389858d, this.f389859e);
                Runnable runnable = this.f389860f;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.f389858d);
                if (ikVar == null) {
                    return;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                if (ikVar == null) {
                    return;
                }
            }
            ikVar.b();
        } catch (Throwable th5) {
            if (ikVar != null) {
                ikVar.b();
            }
            throw th5;
        }
    }

    u(Context context, File file) {
        this.f389858d = context;
        this.f389859e = file;
    }
}
