package com.qwallet.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;

/* loaded from: classes3.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<QWalletBounceScrollView> {

    /* renamed from: b0, reason: collision with root package name */
    public QWalletWebview f41790b0;

    /* renamed from: c0, reason: collision with root package name */
    float f41791c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    /* loaded from: classes3.dex */
    public final class a extends QWalletBounceScrollView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.widget.ScrollView, android.view.View
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
            return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
        }
    }

    public PullToRefreshScrollView(Context context) {
        super(context);
        this.f41791c0 = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public QWalletBounceScrollView i(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f41790b0 == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && (motionEvent.getY() - this.f41791c0 < 0.0f || this.f41790b0.D != 0)) {
                return false;
            }
        } else {
            this.f41791c0 = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.Orientation q() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    protected boolean y() {
        View childAt = ((QWalletBounceScrollView) this.f264230f).getChildAt(0);
        if (childAt == null || ((QWalletBounceScrollView) this.f264230f).getScrollY() < childAt.getHeight() - getHeight()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    protected boolean z() {
        if (((QWalletBounceScrollView) this.f264230f).getScrollY() == 0) {
            return true;
        }
        return false;
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41791c0 = 0.0f;
    }
}
