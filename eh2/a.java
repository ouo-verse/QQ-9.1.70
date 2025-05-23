package eh2;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* compiled from: P */
    @TargetApi(16)
    /* renamed from: eh2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C10239a {
        public static void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void b(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    public static void a(View view, Runnable runnable) {
        C10239a.a(view, runnable);
    }

    public static void b(View view, Drawable drawable) {
        C10239a.b(view, drawable);
    }
}
