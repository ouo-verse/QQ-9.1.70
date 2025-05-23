package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.events.QFSFriendFooterViewEvent;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFriendLayerLoadFooterView extends QFSLayerLoadFooterView implements QFSPullRefreshLayout.g {
    private static final int L = cx.a(40.0f);
    private static final int M = cx.a(80.0f);
    private static final int N = cx.a(120.0f);
    private Runnable H;
    private QFSPullRefreshLayout.g I;
    private long J;
    private boolean K;

    public QFSFriendLayerLoadFooterView(@NonNull Context context) {
        this(context, null);
    }

    private String y0(float f16) {
        if (f16 > M) {
            return h.a(R.string.f183413j4);
        }
        if (f16 > L) {
            return h.a(R.string.f183403j3);
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public int B() {
        return N;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
        super.C(qFSPullRefreshLayout, z16);
        if (z16) {
            return;
        }
        this.K = false;
        SimpleEventBus.getInstance().dispatchEvent(new QFSFriendFooterViewEvent(false, false));
        removeCallbacks(this.H);
        this.J = 0L;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qFSPullRefreshLayout, float f16) {
        boolean z16;
        if (this.I == null) {
            this.I = this;
            qFSPullRefreshLayout.setOnShowFooterViewListener(new WeakReference<>(this.I));
        }
        if (qFSPullRefreshLayout.K()) {
            return;
        }
        if (f16 != 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (qFSPullRefreshLayout.U()) {
            removeCallbacks(this.H);
            return;
        }
        if (z16 != this.K) {
            this.K = z16;
            SimpleEventBus.getInstance().dispatchEvent(new QFSFriendFooterViewEvent(this.K, false));
        }
        if (!qFSPullRefreshLayout.P()) {
            qFSPullRefreshLayout.h0();
        }
        A(f16, false);
        float b06 = b0() * f16;
        if (this.J == 0) {
            this.J = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.J < 500) {
            this.f89631e.setVisibility(8);
        } else {
            this.f89631e.setVisibility(0);
        }
        this.f89631e.setText(y0(b06));
        this.f89632f.setVisibility(8);
        this.f89633h.setVisibility(8);
        QFSPageTurnContainer.j jVar = this.f89630d;
        if (jVar != null) {
            jVar.c(true, f16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qFSPullRefreshLayout) {
        qFSPullRefreshLayout.setAutoLoadEnable(qFSPullRefreshLayout.K());
        this.f89631e.setVisibility(8);
        postDelayed(this.H, 500L);
        super.U(qFSPullRefreshLayout);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void Y(boolean z16, boolean z17) {
        if (!z17 && this.K) {
            this.K = false;
            SimpleEventBus.getInstance().dispatchEvent(new QFSFriendFooterViewEvent(false, false));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public int b0() {
        return M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.H);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView, com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qFSPullRefreshLayout) {
        if (qFSPullRefreshLayout.K()) {
            super.s(qFSPullRefreshLayout);
            return;
        }
        setHideSloganImage(true);
        setShowLoadText(true);
        this.f89631e.setText(h.a(R.string.f183423j5));
        u0();
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.refresh.QFSFriendLayerLoadFooterView.2
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFriendFooterViewEvent(QFSFriendLayerLoadFooterView.this.K, true));
            }
        }, 1000L);
    }

    public QFSFriendLayerLoadFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSFriendLayerLoadFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.refresh.QFSFriendLayerLoadFooterView.1
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = QFSFriendLayerLoadFooterView.this.f89631e;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
        };
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void f0(boolean z16) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void onHide(boolean z16) {
    }
}
