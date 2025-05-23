package com.tencent.now.pkgame.pkgame.pktoprank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import kotlin.Triple;

/* loaded from: classes22.dex */
public class PkTopRankView extends ConstraintLayout implements lo3.a {

    /* renamed from: d, reason: collision with root package name */
    private LifecycleOwner f339045d;

    /* renamed from: e, reason: collision with root package name */
    private ViewModelProvider f339046e;

    /* renamed from: f, reason: collision with root package name */
    private PkTopRankViewModel f339047f;

    /* renamed from: h, reason: collision with root package name */
    private ContributeView f339048h;

    /* renamed from: i, reason: collision with root package name */
    private ContributeView f339049i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f339050m;

    public PkTopRankView(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        super(context);
        this.f339046e = viewModelProvider;
        this.f339045d = lifecycleOwner;
        D0();
        H0();
    }

    private void D0() {
        LayoutInflater.from(getContext()).inflate(R.layout.hav, this);
        this.f339048h = (ContributeView) findViewById(R.id.f25470ax);
        this.f339049i = (ContributeView) findViewById(R.id.f25480ay);
        this.f339050m = (ViewGroup) findViewById(R.id.f25450av);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(Triple triple) {
        if (triple == null) {
            return;
        }
        G0(triple);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Boolean bool) {
        C0(bool.booleanValue());
    }

    public void C0(boolean z16) {
        if (z16) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setAnimationListener(new a());
            this.f339050m.startAnimation(alphaAnimation);
        }
    }

    public void G0(Triple<com.tencent.now.pkgame.pkgame.pktoprank.a, com.tencent.now.pkgame.pkgame.pktoprank.a, Integer> triple) {
        this.f339048h.A0(triple.getFirst());
        this.f339049i.A0(triple.getSecond());
        this.f339050m.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setFillAfter(true);
        this.f339050m.startAnimation(alphaAnimation);
    }

    public void H0() {
        PkTopRankViewModel pkTopRankViewModel = (PkTopRankViewModel) this.f339046e.get(PkTopRankViewModel.class);
        this.f339047f = pkTopRankViewModel;
        pkTopRankViewModel.h2(getContext());
        this.f339047f.c2().observe(this.f339045d, new Observer() { // from class: com.tencent.now.pkgame.pkgame.pktoprank.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PkTopRankView.this.E0((Triple) obj);
            }
        });
        this.f339047f.a2().observe(this.f339045d, new Observer() { // from class: com.tencent.now.pkgame.pkgame.pktoprank.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PkTopRankView.this.F0((Boolean) obj);
            }
        });
    }

    @Override // lo3.a
    public mo3.d J() {
        return this.f339047f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PkTopRankView.this.f339050m.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
