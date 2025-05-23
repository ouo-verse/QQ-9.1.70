package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteListLayout extends LinearLayout {
    private int[] C;

    /* renamed from: d, reason: collision with root package name */
    private int f201439d;

    /* renamed from: e, reason: collision with root package name */
    private int f201440e;

    /* renamed from: f, reason: collision with root package name */
    private View f201441f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f201442h;

    /* renamed from: i, reason: collision with root package name */
    private h f201443i;

    /* renamed from: m, reason: collision with root package name */
    private int f201444m;

    public ColorNoteListLayout(Context context) {
        super(context);
        this.f201444m = -1;
        this.C = new int[2];
        b(context);
    }

    private void b(Context context) {
        setOrientation(1);
        this.f201441f = new View(context);
        addView(this.f201441f, new LinearLayout.LayoutParams(-1, -2));
        RecyclerView recyclerView = new RecyclerView(context);
        this.f201442h = recyclerView;
        recyclerView.setId(R.id.ldn);
        addView(this.f201442h, new LinearLayout.LayoutParams(-1, -1));
    }

    public RecyclerView a() {
        return this.f201442h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        h hVar;
        if (keyEvent.getKeyCode() == 4) {
            if (keyEvent.getAction() == 1 && (hVar = this.f201443i) != null) {
                hVar.a();
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        super.onLayout(z16, i3, i16, i17, i18);
        if (!z16) {
            return;
        }
        if (this.f201444m < 0) {
            int i27 = 0;
            if (this.f201442h.getChildCount() > 0) {
                int measuredHeight = this.f201442h.getChildAt(0).getMeasuredHeight();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.f201442h.getChildAt(0).getLayoutParams();
                i19 = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else {
                i19 = 0;
            }
            if (this.f201442h.getChildCount() <= 4) {
                getLocationOnScreen(this.C);
                int childCount = this.f201442h.getChildCount() * i19;
                int i28 = this.C[1];
                if (((((View) getParent()).getMeasuredHeight() - this.f201439d) - getPaddingBottom()) + i28 >= childCount) {
                    i26 = this.f201439d;
                } else if (((this.f201440e - i16) - getPaddingTop()) + i28 >= childCount) {
                    i26 = this.f201440e - childCount;
                }
                i27 = i26 - i28;
            }
            if (i19 > 0) {
                this.f201444m = i27;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f201441f.getLayoutParams();
                layoutParams2.height = this.f201444m;
                this.f201441f.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f201441f.getLayoutParams();
        layoutParams3.height = this.f201444m;
        this.f201441f.setLayoutParams(layoutParams3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setAnchor(int i3, int i16) {
        this.f201439d = i3;
        this.f201440e = i16;
    }

    public void setHideListener(h hVar) {
        this.f201443i = hVar;
    }

    public ColorNoteListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f201444m = -1;
        this.C = new int[2];
        b(context);
    }

    public ColorNoteListLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201444m = -1;
        this.C = new int[2];
        b(context);
    }
}
