package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QwScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f277795d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    public QwScrollView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    @Override // com.tencent.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f277795d = true;
        } else if (motionEvent.getAction() == 1) {
            this.f277795d = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public QwScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QwScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f277795d = false;
    }

    public void setOnQwScrollListener(a aVar) {
    }
}
