package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class QCirclePYMKRecommendRecyclerView extends RecyclerView {
    private a C;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93814f;

    /* renamed from: h, reason: collision with root package name */
    private int f93815h;

    /* renamed from: i, reason: collision with root package name */
    private int f93816i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f93817m;

    /* loaded from: classes5.dex */
    public interface a {
        void onDragEnd();
    }

    public QCirclePYMKRecommendRecyclerView(@NonNull Context context) {
        super(context);
        this.f93817m = true;
    }

    private boolean D(MotionEvent motionEvent) {
        if (!this.f93817m && motionEvent.getX() - this.f93815h < -150.0f) {
            return true;
        }
        return false;
    }

    public void C(a aVar) {
        this.C = aVar;
    }

    public void E(boolean z16) {
        this.f93817m = z16;
        QLog.d("QCirclePYMKRecommendRecyclerView", 1, "canScrollHorizontallyLeft:" + z16);
    }

    public void F(boolean z16) {
        this.f93814f = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f93814f && !this.f93817m) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return false;
                }
                int i3 = x16 - this.f93815h;
                int i16 = y16 - this.f93816i;
                if (this.f93817m || Math.abs(i3) <= Math.abs(i16)) {
                    return false;
                }
                return true;
            }
            this.f93815h = x16;
            this.f93816i = y16;
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (!this.f93814f) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1 && D(motionEvent) && (aVar = this.C) != null) {
            aVar.onDragEnd();
        }
        return super.onTouchEvent(motionEvent);
    }

    public QCirclePYMKRecommendRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93817m = true;
    }

    public QCirclePYMKRecommendRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93817m = true;
    }
}
