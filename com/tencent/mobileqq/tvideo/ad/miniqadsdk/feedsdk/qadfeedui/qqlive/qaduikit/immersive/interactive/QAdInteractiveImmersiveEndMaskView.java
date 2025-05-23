package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.image.QAdImageView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c;
import cx2.a;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdInteractiveImmersiveEndMaskView extends QAdFeedBaseUI<c, Object> {
    protected ImageView C;
    protected ImageView D;
    protected QAdImageView E;
    protected TextView F;
    protected TextView G;
    protected TextView H;
    protected TextView I;

    public QAdInteractiveImmersiveEndMaskView(Context context) {
        super(context);
        i(context);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    public void e(a aVar) {
        super.e(aVar);
        setViewOnClickListener(this, this.C, this.E, this.F, this.G, this.H, this.I);
    }

    protected int h() {
        return R.layout.fsg;
    }

    protected void i(Context context) {
        View.inflate(context, h(), this);
        this.C = (ImageView) findViewById(R.id.xlb);
        this.D = (ImageView) findViewById(R.id.uvg);
        QAdImageView qAdImageView = (QAdImageView) findViewById(R.id.xl_);
        this.E = qAdImageView;
        qAdImageView.setCornersRadius(s.a(6.0f));
        this.F = (TextView) findViewById(R.id.xld);
        this.G = (TextView) findViewById(R.id.xlc);
        this.H = (TextView) findViewById(R.id.xl9);
        this.I = (TextView) findViewById(R.id.xl6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(c cVar) {
        super.f(cVar);
        if (cVar == null) {
            return;
        }
        this.E.a(cVar.b(), 0);
        this.F.setText(cVar.d());
        this.G.setText(cVar.c());
    }

    public void setImmersiveEndMaskBg(Drawable drawable) {
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    public void setReturnImageVisible(int i3) {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public QAdInteractiveImmersiveEndMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }
}
