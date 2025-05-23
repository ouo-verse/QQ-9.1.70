package com.tencent.timi.game.expand.hall.impl.teamtoast;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamToastView extends RelativeLayout {
    private boolean C;
    private ViewModelProvider D;
    private TeamToastViewModel E;
    private b F;

    /* renamed from: d, reason: collision with root package name */
    private AvatarRoundImageView f376948d;

    /* renamed from: e, reason: collision with root package name */
    private AvatarTextView f376949e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f376950f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup.LayoutParams f376951h;

    /* renamed from: i, reason: collision with root package name */
    private long f376952i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f376953m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class b implements Observer<com.tencent.timi.game.expand.hall.impl.teamtoast.a> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.timi.game.expand.hall.impl.teamtoast.a aVar) {
            TeamToastView.this.h(aVar);
        }
    }

    public TeamToastView(Context context) {
        super(context);
        this.f376952i = JoinTimeType.THIRTY_MINUTES;
        this.f376953m = false;
        this.C = false;
        i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final com.tencent.timi.game.expand.hall.impl.teamtoast.a aVar) {
        post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.teamtoast.TeamToastView.1
            @Override // java.lang.Runnable
            public void run() {
                TeamToastView.this.f376948d.setUserId(aVar.b());
                TeamToastView.this.f376949e.setUserId(aVar.b());
                TeamToastView.this.f376948d.setClickJumpPersonalPage(false);
                TeamToastView.this.f376949e.setClickJumpPersonalPage(false);
                TeamToastView.this.f376950f.setText(aVar.a());
                TeamToastView.this.m();
            }
        });
        postDelayed(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.teamtoast.TeamToastView.2
            @Override // java.lang.Runnable
            public void run() {
                TeamToastView.this.k();
            }
        }, this.f376952i);
    }

    private void i(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169119hu4, this);
        this.f376951h = inflate.getLayoutParams();
        this.f376948d = (AvatarRoundImageView) inflate.findViewById(R.id.a38);
        this.f376949e = (AvatarTextView) inflate.findViewById(R.id.t1y);
        this.f376950f = (TextView) inflate.findViewById(R.id.f93545_v);
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!this.C) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, Double.valueOf(getMeasuredWidth() * 1.5d).floatValue());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(800L);
        animatorSet.addListener(new a());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.C) {
            return;
        }
        this.C = true;
        setVisibility(0);
        setAlpha(1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationX", -getMeasuredWidth(), 0.0f).setDuration(300L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    public void j(ComponentActivity componentActivity) {
        MutableLiveData<com.tencent.timi.game.expand.hall.impl.teamtoast.a> P1;
        componentActivity.getLifecycle().removeObserver(this.E);
        TeamToastViewModel teamToastViewModel = this.E;
        if (teamToastViewModel != null && (P1 = teamToastViewModel.P1()) != null) {
            P1.removeObserver(this.F);
        }
        this.f376953m = false;
    }

    public void l(ComponentActivity componentActivity, long j3) {
        if (this.f376953m) {
            return;
        }
        this.f376953m = true;
        ViewModelProvider viewModelProvider = new ViewModelProvider(componentActivity);
        this.D = viewModelProvider;
        TeamToastViewModel teamToastViewModel = (TeamToastViewModel) viewModelProvider.get(TeamToastViewModel.class);
        this.E = teamToastViewModel;
        teamToastViewModel.T1(j3);
        componentActivity.getLifecycle().addObserver(this.E);
        this.F = new b();
        this.E.P1().observe(componentActivity, this.F);
    }

    public TeamToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f376952i = JoinTimeType.THIRTY_MINUTES;
        this.f376953m = false;
        this.C = false;
        i(context);
    }

    public TeamToastView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f376952i = JoinTimeType.THIRTY_MINUTES;
        this.f376953m = false;
        this.C = false;
        i(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TeamToastView.this.C = false;
            TeamToastView.this.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
