package com.qzone.reborn.feedx.widget.header.famous;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l extends com.qzone.reborn.feedx.widget.header.d {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f56291f;

    /* renamed from: h, reason: collision with root package name */
    private int f56292h;

    /* renamed from: i, reason: collision with root package name */
    private int f56293i;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l lVar = l.this;
            lVar.p(lVar.f56291f, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public l(View view) {
        super(view);
        this.f56291f = (ImageView) view.findViewById(R.id.mzu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    public static String q() {
        if (com.qzone.reborn.util.k.f59549a.f()) {
            return CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_DEFAULT_COVER_NIGHT, QzoneCoverConst.DEFAULT_COVER_NIGHT);
        }
        return CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_DEFAULT_COVER, QzoneCoverConst.DEFAULT_COVER);
    }

    private void s() {
        this.f56293i = CoverEnv.getFinalCoverHeight();
        int finalCoverHeight = CoverEnv.getFinalCoverHeight() + CoverEnv.getCoverFriendPaddingTop();
        this.f56292h = finalCoverHeight;
        p(this.f56291f, finalCoverHeight);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QzoneFamousUserHomeCoverElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        s();
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(q()).setTargetView(this.f56291f));
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void M() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f56291f.getLayoutParams().height, this.f56292h);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public boolean c(float f16, float f17) {
        if (f16 > 0.0f && this.f56291f.getLayoutParams().height < this.f56293i) {
            p(this.f56291f, (int) (r5.getLayoutParams().height + f16));
            return true;
        }
        if (f16 >= 0.0f || this.f56291f.getBottom() <= this.f56292h) {
            return false;
        }
        p(this.f56291f, (int) (r5.getLayoutParams().height + f16));
        return true;
    }
}
