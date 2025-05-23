package com.tencent.luggage.wxa.ol;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u extends i0 {
    public u(Context context) {
        super(context);
        super.setHorizontallyScrolling(true);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public boolean f() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public final boolean h() {
        return false;
    }

    @Override // android.view.View
    public final boolean isLaidOut() {
        boolean isLaidOut = super.isLaidOut();
        if (isLaidOut && isFocusable() && !s()) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    if (stackTrace[2].getMethodName().equals("canTakeFocus")) {
                        return false;
                    }
                    return isLaidOut;
                }
                return isLaidOut;
            } catch (Throwable unused) {
                return isLaidOut;
            }
        }
        return isLaidOut;
    }

    public final boolean s() {
        if (getBottom() > getTop() && getRight() > getLeft()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        super.setGravity((i3 & (-81) & (-49)) | 16);
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView
    public final void setInputType(int i3) {
        super.setInputType(i3 & (-131073));
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView
    public final void setSingleLine(boolean z16) {
    }
}
