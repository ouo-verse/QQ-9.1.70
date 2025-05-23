package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleInteractiveLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f93007d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f93008e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93009f;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f93010h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public QCircleInteractiveLayout(@NonNull Context context) {
        super(context);
        this.f93008e = new int[4];
        this.f93010h = new ArrayList();
    }

    private void a(MotionEvent motionEvent) {
        View view = this.f93007d;
        if (view != null) {
            view.getLocationOnScreen(this.f93008e);
            int[] iArr = this.f93008e;
            iArr[2] = iArr[0] + this.f93007d.getWidth();
            int[] iArr2 = this.f93008e;
            iArr2[3] = iArr2[1] + this.f93007d.getHeight();
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr3 = this.f93008e;
        if (rawX >= iArr3[0] && rawX <= iArr3[2] && rawY >= iArr3[1] && rawY <= iArr3[3]) {
            QLog.i("QCircleInteractiveLayout", 1, "checkInteractiveState in mExcludeView area");
        } else {
            this.f93009f = true;
            QLog.i("QCircleInteractiveLayout", 1, "checkInteractiveState mHaveInteractive = true");
        }
    }

    public boolean b() {
        return this.f93009f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Iterator<a> it = this.f93010h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        if (motionEvent.getAction() == 0 && !b()) {
            a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setExcludeInteractiveView(View view) {
        this.f93007d = view;
    }
}
