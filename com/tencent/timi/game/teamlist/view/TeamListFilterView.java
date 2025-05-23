package com.tencent.timi.game.teamlist.view;

import ag4.h;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import yn4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListFilterView extends RelativeLayout {
    private View C;
    private RelativeLayout D;
    private View E;
    private ViewGroup.LayoutParams F;
    private CheckBox G;
    private ValueAnimator H;
    private float I;
    private long J;
    private View.OnClickListener K;
    private String L;

    /* renamed from: d, reason: collision with root package name */
    public boolean f379848d;

    /* renamed from: e, reason: collision with root package name */
    private dn4.c f379849e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<TeamListFilterUnitView> f379850f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f379851h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f379852i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f379853m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamListFilterView.this.h();
            EventCollector.getInstance().onViewClicked(view);
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
            TeamListFilterView.this.g();
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
            TeamListFilterView.this.j(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamListFilterView teamListFilterView = TeamListFilterView.this;
            if (teamListFilterView.f379848d) {
                teamListFilterView.h();
            } else {
                teamListFilterView.l();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TeamListFilterView.this.F.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TeamListFilterView.this.D.setLayoutParams(TeamListFilterView.this.F);
            TeamListFilterView.this.C.setAlpha(TeamListFilterView.this.F.height / TeamListFilterView.this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TeamListFilterView.this.F.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TeamListFilterView.this.D.setLayoutParams(TeamListFilterView.this.F);
            TeamListFilterView.this.C.setAlpha(TeamListFilterView.this.F.height / TeamListFilterView.this.I);
        }
    }

    public TeamListFilterView(Context context) {
        super(context);
        this.f379848d = false;
        this.f379850f = new ArrayList<>();
        this.I = 600.0f;
        this.J = 500L;
        this.L = "";
        i();
    }

    private void i() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f169139hy4, (ViewGroup) this, true);
        this.E = inflate;
        inflate.setOnClickListener(new a());
        this.E.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.b9t);
        this.D = relativeLayout;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        this.F = layoutParams;
        layoutParams.height = 0;
        this.D.setLayoutParams(layoutParams);
        this.D.setClickable(true);
        this.C = findViewById(R.id.a4f);
        this.f379851h = (LinearLayout) findViewById(R.id.b8q);
        TextView textView = (TextView) findViewById(R.id.b7p);
        this.f379852i = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) findViewById(R.id.f73633u3);
        this.f379853m = textView2;
        textView2.setOnClickListener(new c());
    }

    private void k(int i3) {
        this.D.getBackground().setColorFilter(new PorterDuffColorFilter(fh4.c.a(((h) mm4.b.b(h.class)).l1(i3).team_info.bg_hue.get()), PorterDuff.Mode.SRC_ATOP));
        this.f379852i.getBackground().setColorFilter(new PorterDuffColorFilter(fh4.c.a(((h) mm4.b.b(h.class)).l1(i3).team_info.main_hue.get()), PorterDuff.Mode.SRC_ATOP));
        this.f379852i.setTextColor(fh4.c.a(((h) mm4.b.b(h.class)).l1(i3).team_info.button_text_hue.get()));
        String str = ((h) mm4.b.b(h.class)).l1(i3).room_info.hall_config.color_hall_title.get();
        Iterator<TeamListFilterUnitView> it = this.f379850f.iterator();
        while (it.hasNext()) {
            it.next().setTheme(str);
        }
        this.f379853m.setTextColor(Color.parseColor(((h) mm4.b.b(h.class)).l1(i3).team_info.text_sub_hue.get()));
    }

    public void f() {
        fn4.a.i(this.f379852i);
        fn4.a.k(this.f379853m);
    }

    public void g() {
        this.f379849e.f();
        this.K.onClick(this.f379852i);
        h();
    }

    public void h() {
        l.b("TeamListFilterView", "performHide");
        this.G.setChecked(false);
        if (!this.f379848d) {
            return;
        }
        this.f379848d = false;
        this.G.setText(this.L + " \u25bc");
        ValueAnimator ofInt = ValueAnimator.ofInt(ViewUtils.dip2px(this.I), 0);
        this.H = ofInt;
        ofInt.setInterpolator(b.f.f450694b);
        this.H.setDuration(this.J);
        this.H.addUpdateListener(new f());
        ViewGroup.LayoutParams layoutParams = this.F;
        layoutParams.height = (int) this.I;
        this.D.setLayoutParams(layoutParams);
        this.E.setVisibility(0);
        getHandler().postDelayed(new Runnable() { // from class: com.tencent.timi.game.teamlist.view.TeamListFilterView.7
            @Override // java.lang.Runnable
            public void run() {
                TeamListFilterView.this.E.setVisibility(8);
            }
        }, this.J - 100);
        this.H.start();
    }

    public void j(boolean z16) {
        this.f379849e.g();
        if (z16) {
            this.f379849e.g();
        }
    }

    public void l() {
        l.b("TeamListFilterView", "performShow");
        this.G.setChecked(true);
        if (this.f379848d) {
            return;
        }
        this.f379848d = true;
        this.G.setText(this.L + " \u25b2");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ViewUtils.dip2px(this.I));
        this.H = ofInt;
        ofInt.setInterpolator(b.f.f450693a);
        this.H.setDuration(this.J);
        this.H.addUpdateListener(new e());
        this.F.height = 0;
        this.C.setAlpha(0.0f);
        this.D.setLayoutParams(this.F);
        this.E.setVisibility(0);
        this.H.start();
    }

    public void setData(dn4.c cVar) {
        this.f379849e = cVar;
        this.f379851h.removeAllViews();
        this.f379850f.clear();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < cVar.b(); i3++) {
            TeamListFilterUnitView teamListFilterUnitView = new TeamListFilterUnitView(getContext());
            this.f379851h.addView(teamListFilterUnitView);
            teamListFilterUnitView.setData(cVar.c(i3), cVar.a(i3));
            this.f379850f.add(teamListFilterUnitView);
            if (i3 != 0) {
                sb5.append("/");
            }
            sb5.append(cVar.c(i3));
        }
        this.L = sb5.toString();
        this.G.setText(this.L + " \u25bc");
        k(cVar.d());
    }

    public void setOnFilterConfirmClickListener(View.OnClickListener onClickListener) {
        this.K = onClickListener;
    }

    public void setTriggerSlideFilterTv(CheckBox checkBox) {
        this.G = checkBox;
        checkBox.setOnClickListener(new d());
    }

    public TeamListFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379848d = false;
        this.f379850f = new ArrayList<>();
        this.I = 600.0f;
        this.J = 500L;
        this.L = "";
        i();
    }

    public TeamListFilterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379848d = false;
        this.f379850f = new ArrayList<>();
        this.I = 600.0f;
        this.J = 500L;
        this.L = "";
        i();
    }
}
