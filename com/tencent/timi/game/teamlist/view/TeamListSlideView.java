package com.tencent.timi.game.teamlist.view;

import ag4.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.timi.game.utils.l;
import fm4.g;
import fm4.t;
import gh4.f;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListSlideView extends RelativeLayout implements gh4.a {
    private CheckBox C;
    private TeamListFilterView D;
    private RecyclerView E;
    private RelativeLayout F;
    private TextView G;
    private QQBlurView H;
    private SwipeRefreshLayout I;
    private RelativeLayout J;
    private boolean K;
    private t L;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.timi.game.teamlist.presenter.b f379867d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f379868e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f379869f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f379870h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f379871i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f379872m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            TeamListSlideView.this.f379867d.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TeamListSlideView.this.D.f379848d) {
                TeamListSlideView.this.D.h();
            } else {
                TeamListSlideView.this.h();
            }
            EventCollector.getInstance().onViewClicked(view);
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
            TeamListSlideView.this.f379867d.h();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            l.b("TeamListSlideView", "openTeamCreatePage");
            TeamListSlideView.this.h();
            gn4.a.a();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements t {
        e() {
        }

        @Override // fm4.t
        public void f(long j3, int i3) {
            TeamListSlideView.this.f379867d.h();
        }

        @Override // fm4.t
        public void l(long j3, int i3) {
            TeamListSlideView.this.f379867d.h();
        }
    }

    public TeamListSlideView(Context context) {
        super(context);
        this.K = false;
        l();
    }

    private void i(int i3) {
        boolean z16;
        String str = ((h) mm4.b.b(h.class)).l1(i3).team_info.bg_hue.get();
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(fh4.c.a(str), PorterDuff.Mode.SRC_ATOP);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.H.setVisibility(0);
        this.H.j(this.E);
        QQBlurView qQBlurView = this.H;
        qQBlurView.m(qQBlurView);
        this.H.p(fh4.c.a(str));
        this.H.setEnableBlur(z16);
        this.H.k(0);
        this.H.A(4.0f);
        this.H.l(6);
        Drawable drawable = getResources().getDrawable(R.drawable.o7p);
        drawable.setAlpha(180);
        drawable.setColorFilter(porterDuffColorFilter);
        this.H.z(drawable);
        this.H.setDisableBlurDrawableRes(R.drawable.b8c);
        this.H.x();
        this.H.onResume();
    }

    private void j() {
        gh4.e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 != null && I0.ue() != 0) {
            q(I0.ue(), I0);
            g();
        } else {
            ((f) mm4.b.b(f.class)).V(this);
        }
    }

    private void k() {
        this.I.setOnRefreshListener(new a());
        this.f379869f.setOnClickListener(new b());
        this.D.setTriggerSlideFilterTv(this.C);
        this.f379867d.c(this.D);
        this.D.setOnFilterConfirmClickListener(new c());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.E.setLayoutManager(linearLayoutManager);
        this.f379867d.b(this.E);
        this.F.setOnClickListener(new d());
    }

    private void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.hy9, (ViewGroup) this, true);
        this.f379869f = (ImageView) findViewById(R.id.f86254r6);
        this.f379870h = (RelativeLayout) findViewById(R.id.f86304ra);
        this.f379871i = (TextView) findViewById(R.id.f86314rb);
        this.f379872m = (TextView) findViewById(R.id.f86264r7);
        this.C = (CheckBox) findViewById(R.id.f86294r_);
        this.D = (TeamListFilterView) findViewById(R.id.f86284r9);
        this.E = (RecyclerView) findViewById(R.id.f929559_);
        this.I = (SwipeRefreshLayout) findViewById(R.id.f9109549);
        this.F = (RelativeLayout) findViewById(R.id.f929659a);
        this.G = (TextView) findViewById(R.id.f929759b);
        this.H = (QQBlurView) findViewById(R.id.t9h);
        this.J = (RelativeLayout) findViewById(R.id.uuq);
        j();
    }

    private void q(long j3, @NotNull gh4.e eVar) {
        com.tencent.timi.game.teamlist.presenter.b bVar = new com.tencent.timi.game.teamlist.presenter.b(new dn4.c(eVar.o1()));
        this.f379867d = bVar;
        bVar.d(this);
        k();
        this.f379867d.i(String.valueOf(j3), gh4.b.a(eVar.O()), eVar.o1());
        this.f379867d.j(eVar.O().f376301d);
        r(eVar.o1());
        this.K = true;
    }

    private void r(int i3) {
        int i16;
        i(i3);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((h) mm4.b.b(h.class)).l1(i3);
        String str = l16.team_info.main_hue.get();
        this.F.getBackground().setColorFilter(new PorterDuffColorFilter(fh4.c.a(str), PorterDuff.Mode.SRC_ATOP));
        this.G.setTextColor(fh4.c.a(l16.team_info.button_text_hue.get()));
        this.f379871i.setTextColor(fh4.c.a(l16.room_info.hall_config.color_hall_title.get()));
        ImageView imageView = this.f379869f;
        if (l16.style_mode.get() == 1) {
            i16 = R.drawable.f162543o70;
        } else {
            i16 = R.drawable.oak;
        }
        imageView.setImageResource(i16);
        this.C.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[]{-16842912}}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
    }

    @Override // gh4.a
    public void b(long j3, @NotNull gh4.e eVar) {
        l.i("TeamListSlideView", "joinHallSucceed roomId:" + j3);
        q(j3, eVar);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.teamlist.view.TeamListSlideView.6
            @Override // java.lang.Runnable
            public void run() {
                TeamListSlideView.this.g();
            }
        }, 128, null, true);
    }

    public void g() {
        fn4.a.h(this.f379869f);
        fn4.a.l(this.C);
        fn4.a.j(this.F);
        this.D.f();
    }

    public void h() {
        View.OnClickListener onClickListener = this.f379868e;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void m() {
        l.b("TeamListSlideView", "onClose");
        if (!this.K) {
            return;
        }
        this.D.h();
    }

    public void n() {
        if (this.I.isRefreshing()) {
            this.I.setRefreshing(false);
        }
    }

    public void o() {
        com.tencent.timi.game.teamlist.presenter.b bVar;
        l.b("TeamListSlideView", "onOpen");
        if (this.K && (bVar = this.f379867d) != null) {
            bVar.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = new e();
        ((g) mm4.b.b(g.class)).R0(this.L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.H.onDestroy();
        ((g) mm4.b.b(g.class)).f1(this.L);
        this.L = null;
        super.onDetachedFromWindow();
    }

    public void p(int i3, int i16) {
        l.b("TeamListSlideView", "totalNum" + i3 + " displayTeamNum" + i16);
        if (i16 == 0) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(8);
        }
        this.f379871i.setText(i3 + "\u652f\u8f66\u961f\u5728\u62db\u52df");
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.f379868e = onClickListener;
    }

    public TeamListSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = false;
        l();
    }

    public TeamListSlideView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = false;
        l();
    }

    @Override // gh4.a
    public void a(@NotNull gh4.e eVar) {
    }

    @Override // gh4.a
    public void d(@NotNull gh4.e eVar) {
    }

    @Override // gh4.a
    public void c(int i3, @NotNull String str, @NotNull gh4.e eVar) {
    }
}
