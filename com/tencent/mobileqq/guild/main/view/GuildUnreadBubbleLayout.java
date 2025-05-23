package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.a;
import com.tencent.mobileqq.guild.component.token.AppearDirection;
import com.tencent.mobileqq.guild.component.token.AppearDistance;
import com.tencent.mobileqq.guild.component.token.AppearDuration;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.main.data.d;
import com.tencent.mobileqq.guild.main.data.g;
import com.tencent.mobileqq.guild.main.view.GuildChannelAnimIcon;
import com.tencent.mobileqq.guild.main.view.a;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.banner.titlelayout.ChannelTitleLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.theme.SkinnableView;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildUnreadBubbleLayout extends RadiusFrameLayout implements SkinnableView {
    private View C;
    private final ImageView D;
    private TextView E;
    private final View F;
    private final LottieAnimationView G;
    private ChannelTitleLayout H;
    private int I;
    private com.tencent.mobileqq.guild.component.animator.a J;
    d K;
    private boolean L;
    private boolean M;
    private int N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends a.AbstractC7700a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.animator.a.AbstractC7700a
        public void a() {
            super.a();
            QLog.i("Guild.MF.Rt.GuildUnreadBubbleLayout", 2, "onAnimationEnd");
            GuildUnreadBubbleLayout.this.l();
        }
    }

    public GuildUnreadBubbleLayout(@NonNull Context context) {
        this(context, null, 0, 0);
    }

    private void f() {
        this.G.cancelAnimation();
        this.K = null;
    }

    private void j() {
        this.J = new com.tencent.mobileqq.guild.component.animator.a(this, new a());
    }

    private boolean k(d dVar) {
        d dVar2 = this.K;
        if (dVar2 != null && dVar.equals(dVar2)) {
            return false;
        }
        this.K = dVar;
        return true;
    }

    private void m() {
        VideoReport.setElementId(this.F, "em_sgrp_unread_bubble");
        VideoReport.setElementExposePolicy(this.F, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.F, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.F, EndExposurePolicy.REPORT_NONE);
    }

    public void g() {
        String str;
        if (!this.L) {
            if (QLog.isColorLevel()) {
                if (getVisibility() == 8) {
                    str = ParseCommon.GONE;
                } else {
                    str = ParseCommon.VISIBLE;
                }
                QLog.d("Guild.MF.Rt.GuildUnreadBubbleLayout", 2, "dismissBubble don't execute. " + str);
                return;
            }
            return;
        }
        this.L = false;
        f();
        this.J.e();
        setTranslationY(0.0f);
        h("imp_end");
        this.J.j(200L);
    }

    public void h(String str) {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.M) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_sub_bubble_location", Integer.valueOf(i3));
        hashMap.put("sgrp_bubble_type", Integer.valueOf(this.N));
        VideoReport.reportEvent(str, this.F, hashMap);
    }

    public com.tencent.mobileqq.guild.main.view.a i(int i3) {
        if (i3 == 6) {
            return new a.b(R.drawable.guild_channel_voice_icon_screen_share, R.string.f142190ip, BackgroundColor.PURPLE);
        }
        if (i3 == 9) {
            return new a.C7822a(R.string.f141630h7, R.string.f142100ig, BackgroundColor.PURPLE);
        }
        if (i3 == 18) {
            return new a.C7822a(R.string.f141630h7, R.string.f142160im, BackgroundColor.PURPLE);
        }
        if (i3 == 17) {
            return new a.C7822a(R.string.f141640h8, R.string.f142120ii, BackgroundColor.PURPLE);
        }
        return new a.C7822a(R.string.f141590h3, R.string.f142210ir, BackgroundColor.PURPLE);
    }

    public void l() {
        this.J.e();
        setVisibility(8);
        this.L = false;
    }

    public void n(boolean z16) {
        String str;
        if (z16) {
            if (this.H != null) {
                ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = this.H.getHeight() + this.I + this.H.getMTopSpace();
            } else {
                ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = this.I;
            }
        }
        if (this.L && this.M == z16) {
            return;
        }
        if (QLog.isColorLevel()) {
            if (z16) {
                str = "top";
            } else {
                str = "bottom";
            }
            QLog.d("Guild.MF.Rt.GuildUnreadBubbleLayout", 2, "showMsgUnreadBubble at\uff1a" + str);
        }
        this.J.e();
        this.L = true;
        this.M = z16;
        setVisibility(0);
        setAlpha(1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (z16) {
            layoutParams.gravity = 49;
            setLayoutParams(layoutParams);
            er1.c.b(this.D, true);
            this.J.k(AppearDirection.TOP_TO_BOTTOM, AppearDistance.PX_60, AppearDuration.MS_150, 0L, 200L);
        } else {
            layoutParams.gravity = 81;
            setLayoutParams(layoutParams);
            er1.c.b(this.D, false);
            this.J.k(AppearDirection.BOTTOM_TO_TOP, AppearDistance.PX_60, AppearDuration.MS_150, 0L, 200L);
        }
        h("imp");
    }

    public void o() {
        er1.c.a(this.C);
        er1.c.c(this.E);
        er1.c.b(this.D, this.M);
        this.K = null;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        o();
    }

    public void setTitleAboveList(ChannelTitleLayout channelTitleLayout) {
        this.H = channelTitleLayout;
    }

    public void setUnreadMsgTips(d dVar) {
        if (dVar != null) {
            this.G.setVisibility(0);
            if ((dVar instanceof QQGuildChannelLive) && k(dVar)) {
                TextView textView = this.E;
                textView.setText(textView.getResources().getString(R.string.f142030i_));
                LottieAnimationView lottieAnimationView = this.G;
                lottieAnimationView.setAnimation(lottieAnimationView.getContext().getString(R.string.f141620h6));
                GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
                LottieAnimationView lottieAnimationView2 = this.G;
                guildUIUtils.t(lottieAnimationView2, lottieAnimationView2.getContext().getResources().getColor(R.color.qui_common_icon_aio_toolbar_active));
                this.N = 2;
                this.G.playAnimation();
                return;
            }
            if ((dVar instanceof g) && k(dVar)) {
                com.tencent.mobileqq.guild.main.view.a i3 = i(((g) dVar).o());
                if (i3 instanceof a.b) {
                    a.b bVar = (a.b) i3;
                    this.E.setText(bVar.getTipsResource());
                    LottieAnimationView lottieAnimationView3 = this.G;
                    GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
                    lottieAnimationView3.setImageDrawable(GuildUIUtils.w(lottieAnimationView3.getContext(), bVar.getIconResource(), Integer.valueOf(R.color.qui_common_icon_aio_toolbar_active)));
                    this.G.cancelAnimation();
                }
                if (i3 instanceof a.C7822a) {
                    a.C7822a c7822a = (a.C7822a) i3;
                    this.E.setText(c7822a.getTipsResource());
                    LottieAnimationView lottieAnimationView4 = this.G;
                    lottieAnimationView4.setAnimation(lottieAnimationView4.getContext().getString(c7822a.getLottieResource()));
                    GuildUIUtils guildUIUtils3 = GuildUIUtils.f235378a;
                    LottieAnimationView lottieAnimationView5 = this.G;
                    guildUIUtils3.t(lottieAnimationView5, lottieAnimationView5.getContext().getResources().getColor(R.color.qui_common_icon_aio_toolbar_active));
                    this.G.playAnimation();
                }
                this.N = 3;
                return;
            }
            return;
        }
        this.E.setText("\u672a\u8bfb\u6d88\u606f");
        this.G.cancelAnimation();
        this.G.setVisibility(8);
        this.N = 1;
        this.K = null;
    }

    public GuildUnreadBubbleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public GuildUnreadBubbleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildUnreadBubbleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.I = QQGuildUIUtil.f(10.0f);
        this.K = null;
        this.L = false;
        this.M = false;
        this.N = 1;
        this.F = LayoutInflater.from(context).inflate(R.layout.eiy, this);
        this.C = findViewById(R.id.f114276sw);
        this.D = (ImageView) findViewById(R.id.f114316t0);
        this.E = (TextView) findViewById(R.id.f114326t1);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.vwk);
        this.G = lottieAnimationView;
        GuildChannelAnimIcon.c cVar = new GuildChannelAnimIcon.c();
        try {
            Field declaredField = LottieAnimationView.class.getDeclaredField("lottieDrawable");
            declaredField.setAccessible(true);
            declaredField.set(lottieAnimationView, cVar);
        } catch (Exception e16) {
            QLog.e("Guild.MF.Rt.GuildUnreadBubbleLayout", 1, "GuildUnreadBubbleLayout Exception", e16);
        }
        j();
        o();
        m();
    }
}
