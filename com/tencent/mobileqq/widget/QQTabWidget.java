package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQTabWidget extends TabWidget implements com.tencent.mobileqq.tab.b, com.tencent.mobileqq.tab.a {

    /* renamed from: d, reason: collision with root package name */
    private float f316110d;

    /* renamed from: e, reason: collision with root package name */
    private float f316111e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f316112f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.tab.c f316113h;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.mobileqq.tab.e> f316114i;

    public QQTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316110d = 0.0f;
        this.f316111e = 0.0f;
        this.f316112f = false;
        this.f316114i = new ArrayList();
    }

    @Override // com.tencent.mobileqq.tab.b
    @UiThread
    public void a(@NonNull com.tencent.mobileqq.tab.e eVar) {
        this.f316114i.add(eVar);
    }

    @Override // com.tencent.mobileqq.tab.b
    @UiThread
    public void b(@NonNull com.tencent.mobileqq.tab.e eVar) {
        this.f316114i.remove(eVar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mobileqq.tab.c cVar;
        int action;
        if (QLog.isColorLevel() && ((action = motionEvent.getAction()) == 0 || action == 1 || action == 3)) {
            QLog.d("QQTabWidget", 2, "QQTabWidget onInterceptTouchEvent. action=" + action + ",x=" + motionEvent.getRawX() + ",y=" + motionEvent.getRawY());
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            if (action2 == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float f16 = this.f316111e;
                if (y16 < f16 && f16 - y16 > 50.0f && f16 - y16 > Math.abs(this.f316110d - x16) && (cVar = this.f316113h) != null && !this.f316112f) {
                    this.f316112f = true;
                    cVar.a();
                }
            }
        } else {
            this.f316112f = false;
            this.f316110d = motionEvent.getX();
            this.f316111e = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        QLog.i("QQTabWidget", 1, "setBackgroundDrawable");
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.TabWidget
    public void setCurrentTab(int i3) {
        super.setCurrentTab(i3);
    }

    @Override // com.tencent.mobileqq.tab.a
    public void setTabWidgetMoveListener(com.tencent.mobileqq.tab.c cVar) {
        this.f316113h = cVar;
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        Iterator it = new ArrayList(this.f316114i).iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.tab.e) it.next()).a(f16);
        }
    }

    public QQTabWidget(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316110d = 0.0f;
        this.f316111e = 0.0f;
        this.f316112f = false;
        this.f316114i = new ArrayList();
    }
}
