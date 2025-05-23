package dy0;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a {
    void a(int i3, int i16, int i17, int i18);

    void b(Canvas canvas);

    void c();

    void d();

    void e(Canvas canvas);

    View getView();

    boolean superDispatchTouchEvent(MotionEvent motionEvent);

    void superOnDraw(Canvas canvas);
}
