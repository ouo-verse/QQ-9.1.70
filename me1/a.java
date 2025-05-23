package me1;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    private int f416591d;

    /* renamed from: e, reason: collision with root package name */
    private int f416592e;

    /* renamed from: f, reason: collision with root package name */
    private int f416593f;

    /* renamed from: h, reason: collision with root package name */
    private int f416594h;

    /* renamed from: i, reason: collision with root package name */
    private f f416595i;

    public a(f fVar) {
        this.f416595i = fVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f416595i == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i3 = rawX - this.f416593f;
                    int i16 = rawY - this.f416594h;
                    this.f416593f = rawX;
                    this.f416594h = rawY;
                    this.f416595i.f(i3, i16, view);
                }
            } else {
                int rawX2 = (int) motionEvent.getRawX();
                int rawY2 = (int) motionEvent.getRawY();
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                if (Math.abs(rawX2 - this.f416591d) < scaledTouchSlop && Math.abs(rawY2 - this.f416592e) < scaledTouchSlop) {
                    this.f416595i.e((int) motionEvent.getX(), (int) motionEvent.getY(), view);
                } else if (rawX2 > 0) {
                    this.f416595i.d(rawX2, rawY2, view);
                }
            }
        } else {
            this.f416591d = (int) motionEvent.getRawX();
            int rawY3 = (int) motionEvent.getRawY();
            this.f416592e = rawY3;
            this.f416593f = this.f416591d;
            this.f416594h = rawY3;
        }
        return false;
    }
}
