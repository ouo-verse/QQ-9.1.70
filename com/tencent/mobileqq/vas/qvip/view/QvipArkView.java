package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QvipArkView extends ArkAppView {

    /* renamed from: i, reason: collision with root package name */
    private QQVipArkHeaderView f310623i;

    public QvipArkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f310623i.onTouchEvent(motionEvent);
        return super.onTouch(view, motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setmQqVipArkHeaderView(QQVipArkHeaderView qQVipArkHeaderView) {
        this.f310623i = qQVipArkHeaderView;
    }
}
