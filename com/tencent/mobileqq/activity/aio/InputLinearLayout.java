package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class InputLinearLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private static final int f178106e = ViewUtils.dip2px(6.0f);

    /* renamed from: d, reason: collision with root package name */
    private int f178107d;

    public InputLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178107d = 1;
        setClipToPadding(false);
    }

    public void a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                a(viewGroup.getChildAt(i3));
            }
            return;
        }
        if (this.f178107d == 1) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.InputLinearLayout", 2, "dispatchTouchEvent status = " + this.f178107d + " action = " + motionEvent.getAction());
        }
        if (this.f178107d == 1) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable unused) {
                return false;
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            childAt.layout(0, 0, i17 - i3, i18 - i16);
        }
    }

    public void setStatus(int i3) {
        this.f178107d = i3;
        a(this);
    }

    public InputLinearLayout(Context context) {
        this(context, null);
    }
}
