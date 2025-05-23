package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends com.tencent.biz.qqcircle.immersive.part.u {

    /* renamed from: d, reason: collision with root package name */
    private View f88941d;

    /* renamed from: e, reason: collision with root package name */
    private View f88942e;

    /* renamed from: f, reason: collision with root package name */
    private AlphaAnimation f88943f;

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QFSLoadingPart";
    }

    public void hideLoadingView() {
        View view = this.f88941d;
        if (view != null && this.f88942e != null) {
            view.setVisibility(8);
            this.f88942e.clearAnimation();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88941d = view.findViewById(R.id.f41821i4);
        this.f88942e = view.findViewById(R.id.f46341ub);
    }

    public void showLoadingView() {
        View view = this.f88941d;
        if (view != null && this.f88942e != null) {
            view.setVisibility(0);
            if (this.f88943f == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                this.f88943f = alphaAnimation;
                alphaAnimation.setRepeatMode(2);
                this.f88943f.setRepeatCount(Integer.MAX_VALUE);
                this.f88943f.setDuration(1000L);
            }
            this.f88942e.startAnimation(this.f88943f);
        }
    }
}
