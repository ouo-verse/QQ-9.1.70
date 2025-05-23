package com.tencent.timi.game.teamlist.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.teamlist.presenter.TeamListPresenter;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.utils.l;
import fm4.t;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import th4.i;
import trpc.yes.common.MessageOuterClass$MsgContent;
import yn4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListView extends FrameLayout {
    private com.tencent.timi.game.teamlist.presenter.a C;
    private RelativeLayout D;
    private TextView E;
    private RCImageView F;
    private FrameLayout G;
    private View H;
    private URLImageView I;
    private String J;
    private String K;
    private t L;
    private gh4.a M;
    private LinearLayoutManager N;
    private int P;
    private boolean Q;
    private boolean R;
    private ValueAnimator.AnimatorUpdateListener S;
    private boolean T;
    private TimiBaseInputView.b U;

    /* renamed from: d, reason: collision with root package name */
    public TeamListPresenter f379878d;

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f379879e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f379880f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f379881h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f379882i;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerView f379883m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            TeamListView.this.P = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamListView.this.f379878d.h();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TeamListView.this.R) {
                TeamListView.this.Q = false;
                TeamListView.this.u();
            } else {
                TeamListView.this.Q = true;
                TeamListView.this.l();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f379889d;

        f(ViewGroup.LayoutParams layoutParams) {
            this.f379889d = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f379889d.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TeamListView.this.G.setLayoutParams(this.f379889d);
            if (TeamListView.this.S != null) {
                TeamListView.this.S.onAnimationUpdate(valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f379891d;

        g(ViewGroup.LayoutParams layoutParams) {
            this.f379891d = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f379891d.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TeamListView.this.G.setLayoutParams(this.f379891d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class h implements t {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<TeamListView> f379893a;

        public h(TeamListView teamListView) {
            this.f379893a = new WeakReference<>(teamListView);
        }

        @Override // fm4.t
        public void f(long j3, int i3) {
            TeamListView teamListView = this.f379893a.get();
            if (teamListView != null) {
                teamListView.m();
            }
        }

        @Override // fm4.t
        public void l(long j3, int i3) {
            TeamListView teamListView = this.f379893a.get();
            if (teamListView != null) {
                teamListView.m();
            }
        }
    }

    public TeamListView(Context context) {
        super(context);
        this.C = new com.tencent.timi.game.teamlist.presenter.a();
        this.J = "";
        this.K = "";
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.T = true;
        this.U = new a();
        p();
    }

    private void n() {
        if (this.M != null) {
            return;
        }
        this.M = new d();
        ((gh4.f) mm4.b.b(gh4.f.class)).V(this.M);
    }

    private void p() {
        LayoutInflater.from(getContext()).inflate(R.layout.hya, (ViewGroup) this, true);
        this.G = (FrameLayout) findViewById(R.id.f932059y);
        this.H = findViewById(R.id.f97605ku);
        this.f379879e = (RelativeLayout) findViewById(R.id.f932159z);
        this.f379880f = (ImageView) findViewById(R.id.yh8);
        this.f379881h = (ImageView) findViewById(R.id.f74503wf);
        this.f379882i = (TextView) findViewById(R.id.f931859w);
        this.D = (RelativeLayout) findViewById(R.id.f929859c);
        this.E = (TextView) findViewById(R.id.f929759b);
        this.f379883m = (RecyclerView) findViewById(R.id.f931959x);
        RCImageView rCImageView = (RCImageView) findViewById(R.id.f929959d);
        this.F = rCImageView;
        rCImageView.setRadius(ViewUtils.dip2px(6.0f));
        TeamListPresenter teamListPresenter = new TeamListPresenter();
        this.f379878d = teamListPresenter;
        teamListPresenter.k(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.N = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.f379883m.setLayoutManager(this.N);
        this.f379878d.e(this.f379883m);
        this.f379883m.addOnScrollListener(new b());
        this.D.setOnClickListener(new c());
        t();
        n();
    }

    private void r() {
        URLImageView uRLImageView = this.I;
        if (uRLImageView != null) {
            if (this.R) {
                i.f436350a.e(this.J, uRLImageView);
            } else {
                i.f436350a.e(this.K, uRLImageView);
            }
        }
    }

    public void h() {
        fn4.a.d(this.D);
        fn4.a.e(this.f379882i);
    }

    public TimiBaseInputView.b i() {
        return this.U;
    }

    public int j() {
        if (this.P == 0) {
            if (this.C.l0()) {
                return this.N.findLastVisibleItemPosition() - 1;
            }
            return this.N.findLastVisibleItemPosition();
        }
        return -1;
    }

    public int k() {
        if (this.P == 0) {
            return this.N.findFirstVisibleItemPosition();
        }
        return -1;
    }

    public void l() {
        l.b("TeamListView", "performHide");
        if (this.R) {
            l.b("TeamListView", "alreadyHide");
            return;
        }
        this.R = true;
        ValueAnimator ofInt = ValueAnimator.ofInt(ViewUtils.dip2px(109.0f), 0);
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        ofInt.setInterpolator(b.f.f450694b);
        ofInt.setDuration(500L);
        ofInt.addUpdateListener(new g(layoutParams));
        ofInt.start();
        r();
    }

    public void m() {
        this.f379878d.g();
        this.f379878d.l();
    }

    public void o(int i3) {
        this.F.setImageDrawable(gn4.c.b(((ag4.h) mm4.b.b(ag4.h.class)).l1(i3).team_info.create_big_icon.get(), null, 700.0f, 99.0f));
        String str = ((ag4.h) mm4.b.b(ag4.h.class)).l1(i3).room_info.hall_config.color_hall_title.get();
        this.f379882i.setTextColor(fh4.c.a(str));
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(fh4.c.a(str), PorterDuff.Mode.SRC_ATOP);
        this.f379881h.setImageDrawable(getResources().getDrawable(R.drawable.oam));
        this.f379881h.getDrawable().setColorFilter(porterDuffColorFilter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f379878d.f();
        super.onDetachedFromWindow();
    }

    public void q(int i3, int i16) {
        this.f379882i.setText(i3 + "\u652f\u8f66\u961f\u5728\u62db\u52df");
        if (i3 == 0) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        if (i3 == 0) {
            this.f379881h.setVisibility(4);
            this.f379882i.setVisibility(0);
            this.f379882i.setClickable(false);
            this.f379882i.setText("\u5f00\u9ed1\u8f66\u961f");
            return;
        }
        this.f379881h.setVisibility(0);
        this.f379882i.setVisibility(0);
        this.f379882i.setClickable(true);
    }

    protected void s() {
        if (this.L != null) {
            return;
        }
        this.L = new h(this);
        ((fm4.g) mm4.b.b(fm4.g.class)).R0(this.L);
    }

    public void setOnMoreClickListener(View.OnClickListener onClickListener) {
        this.f379878d.i(onClickListener);
        this.f379882i.setOnClickListener(onClickListener);
    }

    public void setShowAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.S = animatorUpdateListener;
    }

    public void u() {
        l.b("TeamListView", "performShow");
        if (this.Q) {
            l.b("TeamListView", "hideByUser");
            return;
        }
        if (!this.R) {
            l.b("TeamListView", "alreadyShow");
            return;
        }
        this.R = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ViewUtils.dip2px(109.0f));
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        ofInt.setInterpolator(b.f.f450693a);
        ofInt.setDuration(500L);
        ofInt.addUpdateListener(new f(layoutParams));
        ofInt.start();
        r();
    }

    public void v() {
        ((fm4.g) mm4.b.b(fm4.g.class)).f1(this.L);
        this.L = null;
    }

    public void w(String str, String str2, URLImageView uRLImageView, View view) {
        this.I = uRLImageView;
        this.J = str;
        this.K = str2;
        r();
        view.setOnClickListener(new e());
    }

    public TeamListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new com.tencent.timi.game.teamlist.presenter.a();
        this.J = "";
        this.K = "";
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.T = true;
        this.U = new a();
        p();
    }

    public TeamListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new com.tencent.timi.game.teamlist.presenter.a();
        this.J = "";
        this.K = "";
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.T = true;
        this.U = new a();
        p();
    }

    private void t() {
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements TimiBaseInputView.b {
        a() {
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int i3) {
            TeamListView teamListView = TeamListView.this;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            teamListView.T = z16;
            if (TeamListView.this.T) {
                TeamListView.this.u();
            } else {
                TeamListView.this.l();
            }
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NonNull String str, @NonNull TimiBaseInputView timiBaseInputView) {
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NonNull String str, @NonNull MessageOuterClass$MsgContent messageOuterClass$MsgContent, @NonNull TimiBaseInputView timiBaseInputView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements gh4.a {
        d() {
        }

        @Override // gh4.a
        public void a(@NotNull gh4.e eVar) {
            TeamListView.this.s();
        }

        @Override // gh4.a
        public void b(long j3, @NotNull gh4.e eVar) {
            TeamListView.this.f379878d.j(String.valueOf(j3), gh4.b.a(eVar.O()), eVar.o1());
            TeamListView.this.m();
            TeamListView.this.o(eVar.o1());
        }

        @Override // gh4.a
        public void d(@NotNull gh4.e eVar) {
            TeamListView.this.v();
            TeamListView.this.f379878d.f();
        }

        @Override // gh4.a
        public void c(int i3, @NotNull String str, @NotNull gh4.e eVar) {
        }
    }
}
