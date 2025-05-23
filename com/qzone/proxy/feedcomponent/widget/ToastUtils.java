package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ToastUtils {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f50939a = new Handler(Looper.getMainLooper());

    static boolean a() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && mainLooper.getThread() == Thread.currentThread();
    }

    public static void b(final Context context, final CharSequence charSequence) {
        if (a()) {
            Toast.makeText(context, charSequence, 0).show();
        } else {
            f50939a.post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.widget.ToastUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(context, charSequence, 0).show();
                }
            });
        }
    }
}
