package com.qzone.reborn.feedx.widget.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import b7.c;
import com.qzone.homepage.diy.DIYLayoutView;
import com.qzone.homepage.diy.protocol.QzoneDIYData;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bj extends com.qzone.reborn.feedx.part.g implements DIYLayoutView.d {

    /* renamed from: d, reason: collision with root package name */
    private DIYLayoutView f56241d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f56242e;

    /* renamed from: f, reason: collision with root package name */
    private c.a f56243f;

    /* renamed from: h, reason: collision with root package name */
    private View f56244h;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements c {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.header.c
        public void a() {
            if (bj.this.getActivity() != null) {
                bj.this.f56242e.G2(bj.this.getActivity());
            }
        }

        @Override // com.qzone.reborn.feedx.widget.header.c
        public Activity getHostActivity() {
            return bj.this.getActivity();
        }

        @Override // com.qzone.reborn.feedx.widget.header.c
        public Lifecycle getLifecycle() {
            if (bj.this.getPartHost() != null) {
                return bj.this.getPartHost().getLifecycleOwner().getLifecycle();
            }
            return null;
        }
    }

    private c F9() {
        return new b();
    }

    private void G9(View view) {
        QzoneDIYData J = QzoneDIYService.L().J(this.f56242e.getMUin());
        if (J != null && !TextUtils.isEmpty(J.layout)) {
            ViewGroup viewGroup = (ViewGroup) view;
            DIYLayoutView dIYLayoutView = new DIYLayoutView(getActivity(), J, viewGroup);
            this.f56241d = dIYLayoutView;
            if (dIYLayoutView.m()) {
                QZLog.e("QzoneUserHomeDIYLayoutElement", 1, " DIYLayoutView create error");
                return;
            }
            this.f56243f = this.f56241d.o();
            this.f56241d.v(this);
            viewGroup.addView(this.f56241d.n(), 0);
            View findViewById = view.findViewById(R.id.nch);
            this.f56244h = findViewById;
            findViewById.setVisibility(4);
            this.f56244h.setBackgroundResource(R.color.a_n);
            return;
        }
        QZLog.e("QzoneUserHomeDIYLayoutElement", 1, " initDIYLayout with data = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(x6.a aVar) {
        DIYLayoutView dIYLayoutView = this.f56241d;
        if (dIYLayoutView != null) {
            dIYLayoutView.z(this.f56242e.getMUin(), aVar, F9());
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f56242e = wVar;
        wVar.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.bi
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bj.this.H9((x6.a) obj);
            }
        });
        G9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        DIYLayoutView dIYLayoutView = this.f56241d;
        if (dIYLayoutView != null) {
            dIYLayoutView.r();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        DIYLayoutView dIYLayoutView = this.f56241d;
        if (dIYLayoutView != null) {
            dIYLayoutView.s();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        DIYLayoutView dIYLayoutView = this.f56241d;
        if (dIYLayoutView != null) {
            dIYLayoutView.t();
        }
    }

    @Override // com.qzone.homepage.diy.DIYLayoutView.d
    public void u9() {
        this.f56244h.setVisibility(0);
        float k3 = com.qzone.util.ar.k();
        this.f56244h.setTranslationY(k3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f56244h, "translationY", k3, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(ofFloat);
        animatorSet.addListener(new a());
        animatorSet.start();
    }
}
