package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.landscape;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ax2.b;
import ax2.c;
import bx2.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.image.QAdImageView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveImmersiveEndMaskView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveImmersiveProgressView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveVideoRootLayout;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdInteractiveImmersiveHorizontalView extends QAdInteractiveImmersiveView {
    private QAdImageView T;
    private QAdInteractiveVideoRootLayout U;
    private RoundRelativeLayout V;
    private QAdInteractiveImmersiveProgressView W;

    /* renamed from: a0, reason: collision with root package name */
    private QAdInteractiveImmersiveEndMaskView f304179a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f304180b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f304181c0;

    /* renamed from: d0, reason: collision with root package name */
    private QAdImageView f304182d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f304183e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f304184f0;

    /* renamed from: g0, reason: collision with root package name */
    private LinearLayout f304185g0;

    public QAdInteractiveImmersiveHorizontalView(Context context) {
        super(context);
    }

    private void u(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.g(this.V);
    }

    private void v() {
        QAdImageView qAdImageView;
        a aVar = this.N;
        if (aVar != null && (qAdImageView = this.T) != null) {
            qAdImageView.a(aVar.g(), R.drawable.n5v);
        }
    }

    private void x() {
        TextView textView;
        a aVar = this.N;
        if (aVar != null && (textView = this.f304181c0) != null) {
            textView.setText(aVar.f());
        }
    }

    private void z() {
        QAdImageView qAdImageView;
        a aVar = this.N;
        if (aVar != null && (qAdImageView = this.f304182d0) != null) {
            qAdImageView.a(aVar.a(), 0);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void l() {
        x();
        v();
        w();
        z();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected int n() {
        return R.layout.fsj;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public RelativeLayout o() {
        return this.U;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void p(Context context) {
        q(context);
        setId(R.id.f29820mo);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void q(Context context) {
        View.inflate(context, n(), this);
        this.T = (QAdImageView) findViewById(R.id.xlf);
        this.V = (RoundRelativeLayout) findViewById(R.id.xlm);
        this.U = (QAdInteractiveVideoRootLayout) findViewById(R.id.xlk);
        this.W = (QAdInteractiveImmersiveProgressView) findViewById(R.id.xlg);
        this.f304179a0 = (QAdInteractiveImmersiveEndMaskView) findViewById(R.id.xla);
        this.f304180b0 = (ImageView) findViewById(R.id.xlh);
        this.f304181c0 = (TextView) findViewById(R.id.xli);
        this.f304182d0 = (QAdImageView) findViewById(R.id.klf);
        this.f304183e0 = (TextView) findViewById(R.id.f100115rm);
        this.f304184f0 = (TextView) findViewById(R.id.t_1);
        this.f304185g0 = (LinearLayout) findViewById(R.id.yhk);
        this.f304182d0.setRadius(s.a(6.0f));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void s() {
        this.f304179a0.e(this.f304156i);
        setViewOnClickListener(this.f304180b0, this.U.a(), this.f304179a0, this.f304181c0, this.f304183e0, this.f304182d0, this.f304184f0, this);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setContentImageViewShow(boolean z16) {
        int i3;
        QAdImageView qAdImageView = this.T;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qAdImageView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setEndMaskShow(boolean z16) {
        int i3;
        QAdInteractiveImmersiveEndMaskView qAdInteractiveImmersiveEndMaskView = this.f304179a0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qAdInteractiveImmersiveEndMaskView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setEndMaskViewData(com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c cVar) {
        this.f304179a0.setData(cVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setProgress(int i3) {
        this.W.setProgress(i3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setReturnImageVisible(int i3) {
        ImageView imageView = this.f304180b0;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
        QAdInteractiveImmersiveEndMaskView qAdInteractiveImmersiveEndMaskView = this.f304179a0;
        if (qAdInteractiveImmersiveEndMaskView != null) {
            qAdInteractiveImmersiveEndMaskView.setReturnImageVisible(i3);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setTitleLayoutMargin(int i3) {
        LinearLayout linearLayout = this.f304185g0;
        if (linearLayout != null && (linearLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f304185g0.getLayoutParams();
            marginLayoutParams.leftMargin = i3;
            this.f304185g0.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    public void setVideoPauseIconShow(boolean z16) {
        if (z16) {
            this.U.d();
        } else {
            this.U.b();
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void w() {
        TextView textView;
        if (this.N != null && (textView = this.f304183e0) != null) {
            textView.setText("@" + this.N.c());
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveView
    protected void y(int i3) {
        c aVar;
        if (i3 == 0) {
            return;
        }
        this.R = i3;
        if (4 == i3) {
            aVar = new b(true);
        } else {
            aVar = new ax2.a(true);
        }
        aVar.d(this.S);
        u(aVar);
    }

    public QAdInteractiveImmersiveHorizontalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QAdInteractiveImmersiveHorizontalView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
