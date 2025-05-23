package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.performance.report.y;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.LeftBarAvatarFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes14.dex */
public class GuildLeftBarPersonalView extends RelativeLayout {
    public static final int F = QQGuildUIUtil.f(11.0f);
    private b C;
    private boolean D;
    private UnreadInfo.a E;

    /* renamed from: d, reason: collision with root package name */
    private final AnimatorSet f227530d;

    /* renamed from: e, reason: collision with root package name */
    private LeftBarAvatarFrameLayout f227531e;

    /* renamed from: f, reason: collision with root package name */
    private GuildUserAvatarView f227532f;

    /* renamed from: h, reason: collision with root package name */
    private GuildDragTextView f227533h;

    /* renamed from: i, reason: collision with root package name */
    private cs1.d f227534i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.i f227535m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildLeftBarPersonalView.this.D = false;
            GuildLeftBarPersonalView.this.n();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            GuildLeftBarPersonalView.this.e();
            GuildLeftBarPersonalView.this.D = true;
        }
    }

    /* loaded from: classes14.dex */
    public interface b {
        void a();

        void b(d.a aVar);
    }

    public GuildLeftBarPersonalView(Context context) {
        this(context, null);
    }

    private void d() {
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLeftBarPersonalView.this.k(view);
            }
        });
    }

    private void f() {
        if (this.f227534i.j()) {
            b bVar = this.C;
            if (bVar != null) {
                bVar.a();
            }
        } else {
            this.f227530d.cancel();
        }
        this.f227530d.start();
    }

    private void i() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator f16 = com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.f(this, 100L, 1.0f, 0.93f);
        animatorSet.playTogether(com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.f(this, 200L, 0.93f, 1.0f), com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.c(this.f227531e, 200L, 0, 255, R.drawable.guild_leftbar_me_selected_round_bg));
        this.f227530d.playSequentially(f16, animatorSet);
        this.f227530d.addListener(new a());
    }

    private void j() {
        LayoutInflater.from(getContext()).inflate(R.layout.exo, (ViewGroup) this, true);
        this.f227531e = (LeftBarAvatarFrameLayout) findViewById(R.id.t18);
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) findViewById(R.id.t1g);
        this.f227532f = guildUserAvatarView;
        guildUserAvatarView.setLogTag("Guild.MF.Lt.GuildLeftBarPersonalView");
        GuildDragTextView guildDragTextView = (GuildDragTextView) findViewById(R.id.wtp);
        this.f227533h = guildDragTextView;
        guildDragTextView.setDragViewType(2, this);
        q();
        i();
        d();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && com.tencent.mobileqq.guild.mainframe.helper.d.f().b().f227428a != 4) {
            m(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l(Typeface typeface) {
        if (typeface != null) {
            this.f227533h.setTypeface(typeface);
            this.E = null;
            u();
        }
        return null;
    }

    private void o(boolean z16) {
        if (this.f227534i.j()) {
            return;
        }
        cs1.d dVar = this.f227534i;
        com.tencent.mobileqq.guild.mainframe.helper.d.f().k(new d.a(dVar.f391795d, dVar.f391796e), z16);
    }

    private void p() {
        VideoReport.setElementId(this, "em_sgrp_mine");
        VideoReport.reportEvent("clck", this, new HashMap());
    }

    private void q() {
        TypefaceProvider.d(getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf", new Function1() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l3;
                l3 = GuildLeftBarPersonalView.this.l((Typeface) obj);
                return l3;
            }
        });
    }

    private void r() {
        this.f227533h.setText("");
        this.f227533h.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f227533h.getLayoutParams();
        int i3 = F;
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.setMargins(0, QQGuildUIUtil.f(4.0f), QQGuildUIUtil.f(4.0f), 0);
        this.f227533h.setLayoutParams(layoutParams);
        this.f227533h.h();
        this.f227531e.setHorizontalOffset(-QQGuildUIUtil.f(6.3f));
        this.f227531e.setVerticalOffset(QQGuildUIUtil.f(4.0f));
        this.f227531e.setTopRightHole(i3, i3, false);
    }

    private void s(long j3) {
        String valueOf;
        if (j3 > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(j3);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f227533h.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.setMargins(0, 0, 0, 0);
        this.f227533h.setLayoutParams(layoutParams);
        this.f227533h.setText(valueOf);
        this.f227533h.setVisibility(0);
        this.f227533h.j(R.drawable.guild_inbox_leading_icon, QQGuildUIUtil.f(12.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f227533h.measure(makeMeasureSpec, makeMeasureSpec);
        this.f227531e.setHorizontalOffset(-QQGuildUIUtil.f(2.3f));
        this.f227531e.setVerticalOffset(0);
        this.f227531e.setTopRightHole(this.f227533h.getMeasuredWidth(), this.f227533h.getMeasuredHeight(), true);
    }

    private void u() {
        if (!at.c()) {
            return;
        }
        UnreadInfo.a mine = ((IGuildTotalUnreadService) ch.R0(IGuildTotalUnreadService.class)).getTotalCount().getMine();
        if (mine.equals(this.E)) {
            return;
        }
        this.E = mine;
        QLog.d("Guild.MF.Lt.GuildLeftBarPersonalView", 1, "updateUnreadView ", mine);
        if (this.E.getCount() <= 0) {
            this.f227533h.setVisibility(8);
            this.f227531e.setTopRightHole(0, 0, true);
        } else if (this.E.getIsStrongUnread()) {
            s(this.E.getCount());
        } else {
            r();
        }
    }

    public void e() {
        this.f227531e.setBackgroundColor(0);
        this.f227533h.setOnModeChangeListener(null);
    }

    public cs1.d g() {
        return this.f227534i;
    }

    public void h(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227534i = new cs1.d();
        this.f227535m = iVar;
        n();
        t();
    }

    public void m(boolean z16) {
        if (this.f227534i == null) {
            return;
        }
        if (this.C != null) {
            this.C.b(com.tencent.mobileqq.guild.mainframe.helper.d.f().b());
        }
        o(z16);
        f();
        n();
        y.c();
        this.f227535m.e1().n(3, this.f227534i, null);
    }

    public void n() {
        cs1.d dVar = this.f227534i;
        if (dVar == null || this.D) {
            return;
        }
        if (dVar.j()) {
            this.f227531e.setBackgroundResource(R.drawable.guild_leftbar_me_selected_round_bg);
            this.f227533h.setOnModeChangeListener(this.f227535m.e());
            this.f227533h.setTag("GuildLeftBarPersonalView");
            GuildDragTextView guildDragTextView = this.f227533h;
            cs1.d dVar2 = this.f227534i;
            guildDragTextView.setDragGroup(fs1.b.x(dVar2.f391795d, dVar2.f391796e));
        } else {
            this.f227531e.setBackgroundColor(0);
            this.f227533h.setOnModeChangeListener(null);
        }
        u();
    }

    public void setDelegateCallback(b bVar) {
        this.C = bVar;
    }

    public void t() {
        ev l3 = aj.l();
        if (l3 != null) {
            this.f227532f.setAvatarMeta("0", l3.getTinyId(), l3.getAvatarMeta());
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarPersonalView", 1, "updateAvatar userProfileInfo:", l3);
        }
    }

    public GuildLeftBarPersonalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLeftBarPersonalView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildLeftBarPersonalView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f227530d = new AnimatorSet();
        this.D = false;
        j();
    }
}
