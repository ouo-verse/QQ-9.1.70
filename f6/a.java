package f6;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* compiled from: P */
    /* renamed from: f6.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class ViewOnTouchListenerC10282a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f397882d;

        ViewOnTouchListenerC10282a(View view) {
            this.f397882d = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.a(this.f397882d);
                return false;
            }
            if (motionEvent.getAction() == 3) {
                a.b(this.f397882d);
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            a.b(this.f397882d);
            return false;
        }
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new ViewOnTouchListenerC10282a(view));
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        view.setAlpha(0.5f);
    }

    public static void b(View view) {
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
    }
}
