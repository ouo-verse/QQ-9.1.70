package com.tencent.mobileqq.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes16.dex */
public class MyLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f279292d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        boolean dispatchKeyEvent(KeyEvent keyEvent);
    }

    public MyLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        a aVar = this.f279292d;
        if (aVar != null && aVar.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setDispatchKeyEventListener(a aVar) {
        this.f279292d = aVar;
    }

    public MyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
