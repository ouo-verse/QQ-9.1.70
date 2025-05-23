package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildNestedScrollTextView extends TextView {
    private float C;

    /* renamed from: d, reason: collision with root package name */
    private Layout f235936d;

    /* renamed from: e, reason: collision with root package name */
    private int f235937e;

    /* renamed from: f, reason: collision with root package name */
    private int f235938f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f235939h;

    /* renamed from: i, reason: collision with root package name */
    private float f235940i;

    /* renamed from: m, reason: collision with root package name */
    private float f235941m;

    public GuildNestedScrollTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight > 0 && this.f235937e <= 0) {
            Layout layout = getLayout();
            this.f235936d = layout;
            this.f235937e = ((layout.getHeight() + getTotalPaddingTop()) + getTotalPaddingBottom()) - measuredHeight;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        this.f235938f = i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r0 != 2) goto L23;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f235939h = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f235941m = motionEvent.getY();
        }
        float y16 = motionEvent.getY();
        this.C = y16;
        float f16 = y16 - this.f235941m;
        this.f235940i = f16;
        if (f16 > 0.0f) {
            int i3 = this.f235938f;
            if (i3 == 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else if (i3 > 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (f16 < 0.0f) {
            int i16 = this.f235938f;
            int i17 = this.f235937e;
            if (i16 == i17) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else if (i16 < i17) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        this.f235941m = this.C;
        return this.f235939h;
    }

    public GuildNestedScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildNestedScrollTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
