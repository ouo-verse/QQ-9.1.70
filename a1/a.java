package a1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Dialog f25326d;

    /* renamed from: e, reason: collision with root package name */
    private final int f25327e;

    /* renamed from: f, reason: collision with root package name */
    private final int f25328f;

    /* renamed from: h, reason: collision with root package name */
    private final int f25329h;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f25326d = dialog;
        this.f25327e = rect.left;
        this.f25328f = rect.top;
        this.f25329h = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f25327e + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f25328f + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i3 = this.f25329h;
            obtain.setLocation((-i3) - 1, (-i3) - 1);
        }
        view.performClick();
        return this.f25326d.onTouchEvent(obtain);
    }
}
