package com.tencent.mobileqq.guild.feed.presenter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi;
import com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildFeedListCommentFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.presenter.GuildFeedChildBottomPresenter;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalPrefer;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* loaded from: classes13.dex */
public class GuildFeedChildBottomPresenter extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener, Observer<GProStFeed> {
    private static DecimalFormat Z = new DecimalFormat("#.#");
    private ConstraintLayout F;
    private TextView G;
    private ImageView H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private int L;
    private View M;
    private ViewGroup N;
    private boolean P;
    private GProStFeed Q;
    private long R;
    private int S;
    private int T;
    private TextView U;
    private ImageView V;
    private ViewGroup W;
    private LottieAnimationView X;
    private boolean Y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements Function1<IGProGuildInfo, Unit> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            boolean isMember;
            GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(((ij1.g) GuildFeedChildBottomPresenter.this.f222800d).b(), GuildFeedChildBottomPresenter.this.D, "");
            if (iGProGuildInfo == null) {
                QLog.e("Guild_Feed_GuildFeedChildBottomPresenter", 1, "fetchGuildInfoAnyway failed");
                isMember = true;
            } else {
                isMember = iGProGuildInfo.isMember();
            }
            if (!GuildFeedChildBottomPresenter.this.I(isMember)) {
                return Unit.INSTANCE;
            }
            if (GuildFeedChildBottomPresenter.this.P(iGProGuildInfo, isMember)) {
                QLog.d("Guild_Feed_GuildFeedChildBottomPresenter", 1, "isInvisibleForVisitor, show dialog and return");
                JumpGuildParam jumpGuildParam = new JumpGuildParam(initFeedDetailInitBeanFromFeed.getGuildId(), initFeedDetailInitBeanFromFeed.getChannelId());
                if (initFeedDetailInitBeanFromFeed.getJoinInfoParam() != null) {
                    jumpGuildParam.setJoinInfoParam(initFeedDetailInitBeanFromFeed.getJoinInfoParam());
                }
                GuildFeedChildBottomPresenter guildFeedChildBottomPresenter = GuildFeedChildBottomPresenter.this;
                guildFeedChildBottomPresenter.W(guildFeedChildBottomPresenter.f222805m.getContext(), jumpGuildParam, HardCodeUtil.qqStr(R.string.f147280wg), false);
                return Unit.INSTANCE;
            }
            if (GuildFeedChildBottomPresenter.this.O(iGProGuildInfo)) {
                QLog.d("Guild_Feed_GuildFeedChildBottomPresenter", 1, "interceptVisitorCertification, show toast and return");
                return Unit.INSTANCE;
            }
            initFeedDetailInitBeanFromFeed.setStFeed(((ij1.g) GuildFeedChildBottomPresenter.this.f222800d).b());
            initFeedDetailInitBeanFromFeed.setIsMember(isMember);
            GuildFeedChildBottomPresenter.this.b0(initFeedDetailInitBeanFromFeed);
            return null;
        }
    }

    public GuildFeedChildBottomPresenter(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
        this.L = 0;
        this.P = false;
        this.R = 0L;
        this.S = 0;
        this.T = 0;
        this.Y = false;
    }

    private void E(ij1.g gVar) {
        c0(gVar.b());
    }

    private void F() {
        View view = this.M;
        if (view != null) {
            c(view, "em_sgrp_forum_share");
            ViewGroup viewGroup = this.N;
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            com.tencent.mobileqq.guild.feed.report.d.e(viewGroup, "em_sgrp_forum_comment", clickPolicy, exposurePolicy, endExposurePolicy, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.presenter.a
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map R;
                    R = GuildFeedChildBottomPresenter.this.R(str);
                    return R;
                }
            });
            com.tencent.mobileqq.guild.feed.report.d.e(this.W, "em_sgrp_forum_up", clickPolicy, exposurePolicy, endExposurePolicy, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.presenter.b
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map S;
                    S = GuildFeedChildBottomPresenter.this.S(str);
                    return S;
                }
            });
        }
    }

    private void G(ij1.g gVar) {
        this.X.setVisibility(4);
        d0(gVar.b());
    }

    private void H(ij1.g gVar) {
        e0(gVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean I(boolean z16) {
        View view = this.f222805m;
        if (view != null && view.getContext() != null && ((ij1.g) this.f222800d).b() != null) {
            String valueOf = String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.guildId);
            String valueOf2 = String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.channelId);
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2) || Q(this.f222805m.getContext(), valueOf, valueOf2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void J(final View view) {
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.presenter.GuildFeedChildBottomPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.left -= com.tencent.mobileqq.guild.feed.util.e.a(view.getContext(), 8.0f);
                rect.top -= com.tencent.mobileqq.guild.feed.util.e.a(view.getContext(), 8.0f);
                rect.right += com.tencent.mobileqq.guild.feed.util.e.a(view.getContext(), 8.0f);
                rect.bottom += com.tencent.mobileqq.guild.feed.util.e.a(view.getContext(), 8.0f);
                view2.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    private String K(long j3, String str) {
        return bl1.b.f28597a.f((int) j3, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L() {
        T t16 = this.f222800d;
        if (t16 != 0 && ((ij1.g) t16).b() != null && ((ij1.g) this.f222800d).b().poster != null) {
            if (this.L == 0) {
                a0();
            } else {
                i(((ij1.g) this.f222800d).b(), 3, 3);
                p(new com.tencent.mobileqq.guild.feed.event.a(1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M(View view) {
        GProStFeed b16 = ((ij1.g) this.f222800d).b();
        if (b16 == null) {
            hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "handleUpVoteClicked: stFeed is null!");
            return;
        }
        hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "handleUpVoteClicked: id[" + b16.idd + "] preferCount[" + b16.totalPrefer.preferCountWithoutLike + "] anim[" + this.Y + "] clicked[" + this.S + "]");
        if (this.Y) {
            return;
        }
        if (this.S != 1) {
            this.V.setVisibility(4);
            X();
            this.Y = true;
        }
        bc.a aVar = new bc.a();
        aVar.stFeed = b16;
        aVar.curPreferStatus = this.S;
        aVar.operate = 2000;
        aVar.feedId = b16.idd;
        GProStChannelSign gProStChannelSign = b16.channelInfo.sign;
        aVar.guildId = gProStChannelSign.guildId;
        aVar.channelId = gProStChannelSign.channelId;
        aVar.enableFake = true;
        aVar.reportMap = com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(1, ax.q(this.F.getContext()));
        bc.d(aVar);
        String valueOf = String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.guildId);
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), valueOf, "feedListPreferClick");
        ((IGuildNewUserMsgNoticeApi) QRoute.api(IGuildNewUserMsgNoticeApi.class)).setNewUserStayOrWriteInChannel(valueOf, String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.channelId), 7);
    }

    private void N() {
        if ((this.F.getContext() instanceof GuildActivityWrapper) && (ax.q(((GuildActivityWrapper) this.F.getContext()).getBase()) instanceof GuildFeedTroopInitBean)) {
            this.M.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo != null && ch.r(iGProGuildInfo.getGuildID())) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                ch.h1(qBaseActivity, iGProGuildInfo.getGuildID());
                return true;
            }
            QLog.e("Guild_Feed_GuildFeedChildBottomPresenter", 1, "activity is null or finishing");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(IGProGuildInfo iGProGuildInfo, boolean z16) {
        boolean z17;
        if (iGProGuildInfo == null) {
            return false;
        }
        if (iGProGuildInfo.isVisibleForVisitor() && iGProGuildInfo.isInteractiveForVisitor()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return false;
        }
        return true;
    }

    private boolean Q(Context context, String str, String str2) {
        if (this.D == null || context == null) {
            return false;
        }
        boolean L = GuildInfoManager.L(str, str2);
        boolean K = GuildInfoManager.q().K(str, str2);
        if (!L || K) {
            return false;
        }
        QQToast.makeText(context, GuildInfoManager.q().r(str, str2), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map R(String str) {
        int i3;
        Map<String, Object> e16 = e();
        if (this.L != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        e16.put("sgrp_is_no_comment", Integer.valueOf(i3));
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map S(String str) {
        int i3;
        Map<String, Object> e16 = e();
        int i16 = 0;
        if (this.S == 1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        e16.put("sgrp_action_result", Integer.valueOf(i3));
        if (this.S == 1) {
            i16 = 1;
        }
        e16.put("sgrp_state", Integer.valueOf(i16));
        return e16;
    }

    private void X() {
        this.X.setVisibility(0);
        this.X.playAnimation();
    }

    private void Y() {
        this.U.setTextColor(AppCompatResources.getColorStateList(this.f222805m.getContext(), R.color.qui_common_text_primary));
        this.I.setTextColor(AppCompatResources.getColorStateList(this.f222805m.getContext(), R.color.qui_common_text_primary));
        this.K.setTextColor(AppCompatResources.getColorStateList(this.f222805m.getContext(), R.color.qui_common_text_primary));
        au.f223851a.i(this.X, this.f222805m.getContext().getResources().getColor(R.color.qui_common_text_primary));
    }

    private void Z(GProStFeed gProStFeed) {
        String w3 = ax.w(Math.max(gProStFeed.latestInteraction.timestamp, gProStFeed.getCreateTime()) * 1000);
        hj1.b.b("Guild_Feed_GuildFeedChildBottomPresenter", "setFeedShowTime showTimeStr: " + w3);
        this.G.setText(w3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a0() {
        GuildMainFrameUtils.l(String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.guildId), false, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b0(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        T t16;
        Fragment fragment;
        if (this.f222805m != null && guildFeedDetailInitBean != null && (t16 = this.f222800d) != 0 && ((ij1.g) t16).b() != null) {
            try {
                fragment = FragmentManager.findFragment(this.f222805m);
            } catch (IllegalStateException unused) {
                QLog.e("Guild_Feed_GuildFeedChildBottomPresenter", 1, "[showCommentInputPop]: no fm found for root, guildId= " + guildFeedDetailInitBean);
                fragment = null;
            }
            if (fragment != null) {
                View view = fragment.getView();
                if (view != null && view.findViewById(R.id.wbs) != null) {
                    GuildFeedListCommentFragment.sh(fragment.getChildFragmentManager(), R.id.wbs, guildFeedDetailInitBean, ((ij1.g) this.f222800d).b());
                    return;
                } else {
                    QLog.e("Guild_Feed_GuildFeedChildBottomPresenter", 1, "[showCommentInputPop]: container not found");
                    return;
                }
            }
            return;
        }
        QLog.e("Guild_Feed_GuildFeedChildBottomPresenter", 1, "[showCommentInputPop]: bean or rootView is null");
    }

    private void c0(GProStFeed gProStFeed) {
        int i3 = gProStFeed.commentCount;
        this.L = i3;
        this.K.setText(K(i3, ""));
        if (gProStFeed.commentCount > 0) {
            this.N.setContentDescription(QQGuildUIUtil.s(R.string.f143650mn, this.K.getText()));
        } else {
            this.N.setContentDescription(this.K.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(GProStFeed gProStFeed) {
        if (gProStFeed == null) {
            return;
        }
        GProTotalPrefer gProTotalPrefer = gProStFeed.totalPrefer;
        this.S = gProTotalPrefer.preferStatus;
        int i3 = gProTotalPrefer.preferCountWithoutLike;
        this.T = i3;
        String K = K(i3, "");
        Context context = this.U.getContext();
        this.U.setText(K);
        this.V.setVisibility(0);
        if (this.S == 1) {
            this.V.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
            this.W.setContentDescription(QQGuildUIUtil.s(R.string.f143640mm, this.U.getText()));
        } else {
            this.V.setImageResource(R.drawable.guild_feed_item_up_vote_icon_token_selector);
            this.W.setContentDescription(QQGuildUIUtil.s(R.string.f143660mo, this.U.getText()));
        }
    }

    private void e0(GProStFeed gProStFeed) {
        if (gProStFeed == null) {
            return;
        }
        int i3 = gProStFeed.share.sharedCount;
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        if (gVar != null && gVar.b() != null) {
            Y();
            GProStFeed b16 = gVar.b();
            int i16 = b16.share.sharedCount;
            int i17 = b16.commentCount;
            hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "onBindData: id[" + b16.idd + "] preferCount[" + b16.totalPrefer.preferCountWithoutLike + "] shareCount[" + i16 + "] commentCount[" + i17 + "] mUpVoteClickAnimProcess[" + this.Y + "]");
            this.Y = false;
            this.Q = null;
            jj1.b.c().observerGlobalState(b16, this);
            this.Q = b16;
            N();
            E(gVar);
            H(gVar);
            G(gVar);
            F();
            Z(b16);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void l(ij1.g gVar, int i3, List<Object> list) {
        super.l(gVar, i3, list);
        if (gVar != null && gVar.b() != null) {
            GProStFeed b16 = gVar.b();
            int i16 = b16.share.sharedCount;
            int i17 = b16.commentCount;
            hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "onBindDataWithPayloads: id[" + b16.idd + "] preferCount[" + b16.totalPrefer.preferCountWithoutLike + "] shareCount[" + i16 + "] commentCount[" + i17 + "] mUpVoteClickAnimProcess[" + this.Y + "]");
            this.Q = b16;
            E(gVar);
            H(gVar);
            G(gVar);
            Z(gVar.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onChanged(GProStFeed gProStFeed) {
        T t16 = this.f222800d;
        if (t16 != 0 && gProStFeed != null && this.Q != null && ((ij1.g) t16).b() != null && ((ij1.g) this.f222800d).b().idd.equals(gProStFeed.idd)) {
            this.Q = gProStFeed;
            if (!this.Y) {
                d0(gProStFeed);
            }
            c0(gProStFeed);
            e0(gProStFeed);
        }
    }

    public void W(Context context, JumpGuildParam jumpGuildParam, String str, boolean z16) {
        Intent zh5 = JoinGuildChannelFrag.zh(jumpGuildParam, str, z16, false);
        if (context instanceof Activity) {
            GuildTransBottomSheetDialogFragment.th(context, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            GuildTransBottomSheetDialogFragment.th(qBaseActivity, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
        } else {
            GuildTransBottomSheetDialogFragment.th(context, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void j() {
        super.j();
        T t16 = this.f222800d;
        if (t16 != 0 && ((ij1.g) t16).b() != null) {
            hj1.b.b("Guild_Feed_GuildFeedChildBottomPresenter", "onAttachedToWindow: id[" + ((ij1.g) this.f222800d).b().idd + "]");
            jj1.b.c().observerGlobalState(((ij1.g) this.f222800d).b(), this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void m() {
        T t16 = this.f222800d;
        if (t16 != 0 && ((ij1.g) t16).b() != null) {
            hj1.b.b("Guild_Feed_GuildFeedChildBottomPresenter", "onDetachedFromWindow: id[" + ((ij1.g) this.f222800d).b().idd + "]");
            jj1.b.c().removeObserverGlobalState(((ij1.g) this.f222800d).b(), this);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.w_b), this);
        Z.setRoundingMode(RoundingMode.HALF_UP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && System.currentTimeMillis() - this.R >= 500) {
            this.R = System.currentTimeMillis();
            if (view.getId() != R.id.w__) {
                if (view.getId() != R.id.w9w && view.getId() != R.id.w9y) {
                    if (view.getId() == R.id.w_6) {
                        M(view);
                    }
                } else {
                    L();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.w_3);
        this.F = constraintLayout;
        this.H = (ImageView) constraintLayout.findViewById(R.id.w_9);
        this.I = (TextView) this.F.findViewById(R.id.w_a);
        this.J = (ImageView) this.F.findViewById(R.id.w9x);
        this.K = (TextView) this.F.findViewById(R.id.w9y);
        this.M = this.F.findViewById(R.id.w__);
        this.N = (ViewGroup) this.F.findViewById(R.id.w9w);
        this.G = (TextView) this.F.findViewById(R.id.wam);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.V = (ImageView) this.F.findViewById(R.id.w_d);
        this.U = (TextView) this.F.findViewById(R.id.w_7);
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.w_6);
        this.W = viewGroup;
        J(viewGroup);
        J(this.U);
        this.W.setOnClickListener(this);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.F.findViewById(R.id.w_c);
        this.X = lottieAnimationView;
        lottieAnimationView.setAnimation("feed/feed_item/list_prefer_clicked_anim.json");
        this.X.addAnimatorListener(new a());
        if (Build.VERSION.SDK_INT >= 26) {
            StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.f155134n);
            this.J.setStateListAnimator(loadStateListAnimator);
            this.K.setStateListAnimator(loadStateListAnimator.clone());
            this.U.setStateListAnimator(loadStateListAnimator.clone());
            this.H.setStateListAnimator(loadStateListAnimator.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            GuildFeedChildBottomPresenter guildFeedChildBottomPresenter = GuildFeedChildBottomPresenter.this;
            guildFeedChildBottomPresenter.d0(guildFeedChildBottomPresenter.Q);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "onAnimationEnd: UpVote click anim finish.");
            GuildFeedChildBottomPresenter.this.X.setVisibility(4);
            GuildFeedChildBottomPresenter.this.V.setVisibility(0);
            GuildFeedChildBottomPresenter.this.Y = false;
            GuildFeedChildBottomPresenter guildFeedChildBottomPresenter = GuildFeedChildBottomPresenter.this;
            guildFeedChildBottomPresenter.d0(guildFeedChildBottomPresenter.Q);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            hj1.b.a("Guild_Feed_GuildFeedChildBottomPresenter", "onAnimationStart: UpVote click anim start.");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.presenter.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedChildBottomPresenter.a.this.b();
                }
            }, 200L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
