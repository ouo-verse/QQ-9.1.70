package com.tencent.biz.qqcircle.comment.sticker;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSStickersOverScrollLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f83928d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f83929e;

    /* renamed from: f, reason: collision with root package name */
    private float f83930f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f83931h;

    public QFSStickersOverScrollLinearLayout(Context context) {
        this(context, null);
    }

    private boolean a() {
        LinearLayoutManager d16;
        RecyclerView recyclerView = this.f83928d;
        if (recyclerView == null || recyclerView.getAdapter() == null || (d16 = d()) == null) {
            return false;
        }
        int itemCount = this.f83928d.getAdapter().getItemCount() - 1;
        int findLastVisibleItemPosition = d16.findLastVisibleItemPosition();
        if (findLastVisibleItemPosition < itemCount) {
            return false;
        }
        View childAt = this.f83928d.getChildAt(Math.min(findLastVisibleItemPosition - d16.findFirstVisibleItemPosition(), this.f83928d.getChildCount() - 1));
        if (childAt == null || childAt.getRight() > this.f83928d.getRight() - this.f83928d.getLeft()) {
            return false;
        }
        return true;
    }

    private boolean b() {
        LinearLayoutManager d16;
        int i3;
        RecyclerView recyclerView = this.f83928d;
        if (recyclerView == null || recyclerView.getAdapter() == null || (d16 = d()) == null) {
            return false;
        }
        if (d16.findFirstVisibleItemPosition() != 0 && this.f83928d.getAdapter().getItemCount() != 0) {
            return false;
        }
        if (this.f83928d.getChildCount() > 0) {
            i3 = this.f83928d.getChildAt(0).getLeft();
        } else {
            i3 = 0;
        }
        if (i3 < 0) {
            return false;
        }
        return true;
    }

    private void c(MotionEvent motionEvent) {
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
    }

    private LinearLayoutManager d() {
        RecyclerView recyclerView = this.f83928d;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return null;
        }
        return (LinearLayoutManager) this.f83928d.getLayoutManager();
    }

    private void e() {
        if (this.f83931h && this.f83928d != null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(this.f83928d.getLeft() - this.f83929e.left, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            this.f83928d.startAnimation(translateAnimation);
            RecyclerView recyclerView = this.f83928d;
            Rect rect = this.f83929e;
            recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
            this.f83931h = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float x16 = motionEvent.getX();
        Rect rect = this.f83929e;
        if (x16 < rect.right && x16 > rect.left) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return true;
                    }
                } else {
                    e();
                    if (this.f83931h || super.dispatchTouchEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
            } else {
                this.f83930f = motionEvent.getX();
            }
            int x17 = (int) (motionEvent.getX() - this.f83930f);
            if (x17 > 0 && b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (x17 < 0 && a()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && !z17) {
                this.f83930f = motionEvent.getX();
                this.f83931h = false;
                return super.dispatchTouchEvent(motionEvent);
            }
            c(motionEvent);
            int i3 = (int) (x17 * 0.5f);
            RecyclerView recyclerView = this.f83928d;
            if (recyclerView != null) {
                Rect rect2 = this.f83929e;
                recyclerView.layout(rect2.left + i3, rect2.top, rect2.right + i3, rect2.bottom);
            }
            this.f83931h = true;
            return true;
        }
        e();
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildAt(0) instanceof RecyclerView) {
            this.f83928d = (RecyclerView) getChildAt(0);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        RecyclerView recyclerView = this.f83928d;
        if (recyclerView == null) {
            return;
        }
        this.f83929e.set(recyclerView.getLeft(), this.f83928d.getTop(), this.f83928d.getRight(), this.f83928d.getBottom());
    }

    public QFSStickersOverScrollLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSStickersOverScrollLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f83929e = new Rect();
        this.f83931h = false;
    }
}
