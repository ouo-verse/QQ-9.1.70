package com.tencent.biz.qqcircle.comment.wrapper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$GuildDisplayInfo;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentGuildCardWrapper {
    private static final int B = cx.a(8.0f);
    private static final int C = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.d0s);
    private static final int D = cx.a(185.0f);
    private static final int E = cx.a(79.0f);
    public static final String F = com.tencent.biz.qqcircle.utils.h.a(R.string.f189043yb);
    public static final String G = com.tencent.biz.qqcircle.utils.h.a(R.string.f189013y9);

    /* renamed from: a, reason: collision with root package name */
    private boolean f84093a;

    /* renamed from: b, reason: collision with root package name */
    private QFSCommentInfo f84094b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudRead$GuildDisplayInfo f84095c;

    /* renamed from: d, reason: collision with root package name */
    private final View f84096d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f84097e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f84098f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f84099g;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAvatarListView f84100h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleRoundImageView f84101i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f84102j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f84103k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f84104l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f84105m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f84106n;

    /* renamed from: o, reason: collision with root package name */
    private View f84107o;

    /* renamed from: p, reason: collision with root package name */
    private View f84108p;

    /* renamed from: q, reason: collision with root package name */
    private View f84109q;

    /* renamed from: s, reason: collision with root package name */
    private String f84111s;

    /* renamed from: t, reason: collision with root package name */
    private int f84112t;

    /* renamed from: u, reason: collision with root package name */
    private Animation f84113u;

    /* renamed from: v, reason: collision with root package name */
    private Animation f84114v;

    /* renamed from: r, reason: collision with root package name */
    private boolean f84110r = false;

    /* renamed from: w, reason: collision with root package name */
    private int f84115w = 0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f84116x = false;

    /* renamed from: y, reason: collision with root package name */
    private final Runnable f84117y = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper.4
        @Override // java.lang.Runnable
        public void run() {
            if (QFSCommentGuildCardWrapper.this.f84115w >= 3) {
                return;
            }
            if (QFSCommentGuildCardWrapper.this.f84116x) {
                if (QFSCommentGuildCardWrapper.this.f84114v != null && QFSCommentGuildCardWrapper.this.f84105m != null) {
                    QFSCommentGuildCardWrapper.this.f84105m.startAnimation(QFSCommentGuildCardWrapper.this.f84114v);
                    QFSCommentGuildCardWrapper.this.f84105m.setVisibility(8);
                }
                if (QFSCommentGuildCardWrapper.this.f84113u != null && QFSCommentGuildCardWrapper.this.f84106n != null) {
                    QFSCommentGuildCardWrapper.this.f84106n.startAnimation(QFSCommentGuildCardWrapper.this.f84113u);
                    QFSCommentGuildCardWrapper.this.f84106n.setVisibility(0);
                }
            } else {
                if (QFSCommentGuildCardWrapper.this.f84114v != null && QFSCommentGuildCardWrapper.this.f84106n != null) {
                    QFSCommentGuildCardWrapper.this.f84106n.startAnimation(QFSCommentGuildCardWrapper.this.f84114v);
                    QFSCommentGuildCardWrapper.this.f84106n.setVisibility(8);
                }
                if (QFSCommentGuildCardWrapper.this.f84113u != null && QFSCommentGuildCardWrapper.this.f84105m != null) {
                    QFSCommentGuildCardWrapper.this.f84105m.startAnimation(QFSCommentGuildCardWrapper.this.f84113u);
                    QFSCommentGuildCardWrapper.this.f84105m.setVisibility(0);
                }
            }
            QFSCommentGuildCardWrapper.this.f84116x = !r0.f84116x;
            QFSCommentGuildCardWrapper.this.f84115w++;
            RFWThreadManager.getUIHandler().postDelayed(QFSCommentGuildCardWrapper.this.f84117y, 3000L);
        }
    };

    /* renamed from: z, reason: collision with root package name */
    private final Runnable f84118z = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper.5

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper$5$a */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (QFSCommentGuildCardWrapper.this.f84104l != null && valueAnimator != null) {
                    QFSCommentGuildCardWrapper.this.f84104l.setImageAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QFSCommentGuildCardWrapper.this.f84104l == null) {
                return;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
            ofInt.addUpdateListener(new a());
            ofInt.addListener(new b());
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(200L);
            ofInt.start();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper$5$b */
        /* loaded from: classes4.dex */
        class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RFWThreadManager.getUIHandler().postDelayed(QFSCommentGuildCardWrapper.this.A, 5000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (QFSCommentGuildCardWrapper.this.f84104l == null) {
                    return;
                }
                QFSCommentGuildCardWrapper.this.f84104l.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    };
    private final Runnable A = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper.6

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper$6$a */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (QFSCommentGuildCardWrapper.this.f84104l != null && valueAnimator != null) {
                    QFSCommentGuildCardWrapper.this.f84104l.setImageAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            ofInt.addUpdateListener(new a());
            ofInt.addListener(new b());
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(200L);
            ofInt.start();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper$6$b */
        /* loaded from: classes4.dex */
        class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (QFSCommentGuildCardWrapper.this.f84104l == null) {
                    return;
                }
                QFSCommentGuildCardWrapper.this.f84104l.setVisibility(8);
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
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f84123d;

        a(String str) {
            this.f84123d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f84123d)) {
                QCircleHostLauncher.launchChannelPage(QFSCommentGuildCardWrapper.this.s(), this.f84123d, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f84125d;

        b(boolean z16) {
            this.f84125d = z16;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean z16 = true;
            if (this.f84125d) {
                QFSCommentGuildCardWrapper.this.v();
            } else {
                QLog.d(QFSCommentGuildCardWrapper.this.u(), 1, "[onLongClick] guest feed");
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS) {
                RFWThreadManager.getUIHandler().post(QFSCommentGuildCardWrapper.this.f84118z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QFSCommentGuildCardWrapper.this.D();
            QFSCommentGuildCardWrapper.this.C(QCircleDaTongConstant.ElementId.EM_XSJ_CLOSE_CHANNEL_ENTRANCE_CONFIRM_BUTTON, "ev_xsj_abnormal_clck");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {
        f() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
            String traceId;
            String u16 = QFSCommentGuildCardWrapper.this.u();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[requestCloseCommentGuildDisplaySwitch] traceId = ");
            if (baseRequest == null) {
                traceId = "";
            } else {
                traceId = baseRequest.getTraceId();
            }
            sb5.append(traceId);
            sb5.append(", isSuccess = ");
            sb5.append(z16);
            sb5.append(", retCode = ");
            sb5.append(j3);
            sb5.append(", errMsg = ");
            sb5.append(str);
            QLog.d(u16, 1, sb5.toString());
            if (z16 && j3 == 0) {
                QFSCommentGuildCardWrapper.this.G(false);
            } else {
                cj.b(false, j3, str);
            }
        }
    }

    public QFSCommentGuildCardWrapper(View view) {
        this.f84096d = view;
    }

    private boolean A() {
        int i3 = this.f84112t;
        if (i3 != 501 && i3 != 503) {
            return false;
        }
        return true;
    }

    private void B(@NonNull FeedCloudRead$GuildDisplayInfo feedCloudRead$GuildDisplayInfo) {
        ViewGroup viewGroup = this.f84097e;
        if (viewGroup == null) {
            return;
        }
        VideoReport.setElementId(viewGroup, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_CHANNEL_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, feedCloudRead$GuildDisplayInfo.guildName.get());
        buildElementParams.put("sgrp_channel_id", feedCloudRead$GuildDisplayInfo.guildID.get());
        VideoReport.setElementParams(this.f84097e, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, String str2) {
        String str3;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", t().f398449id.get());
        FeedCloudRead$GuildDisplayInfo feedCloudRead$GuildDisplayInfo = this.f84095c;
        String str4 = "";
        if (feedCloudRead$GuildDisplayInfo == null) {
            str3 = "";
        } else {
            str3 = feedCloudRead$GuildDisplayInfo.guildName.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, str3);
        FeedCloudRead$GuildDisplayInfo feedCloudRead$GuildDisplayInfo2 = this.f84095c;
        if (feedCloudRead$GuildDisplayInfo2 != null) {
            str4 = feedCloudRead$GuildDisplayInfo2.guildID.get();
        }
        buildElementParams.put("sgrp_channel_id", str4);
        buildElementParams.put("xsj_custom_pgid", this.f84111s);
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent(str2, buildElementParams);
    }

    private void E() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.f84117y);
        ViewGroup viewGroup = this.f84106n;
        if (viewGroup != null) {
            if (viewGroup.getAnimation() != null) {
                this.f84106n.clearAnimation();
            }
            this.f84106n.setVisibility(0);
        }
        TextView textView = this.f84105m;
        if (textView != null) {
            if (textView.getAnimation() != null) {
                this.f84105m.clearAnimation();
            }
            this.f84105m.setVisibility(8);
        }
        this.f84115w = 0;
        this.f84116x = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z16) {
        int i3;
        ViewGroup viewGroup = this.f84097e;
        if (viewGroup == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        this.f84097e.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.wrapper.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentGuildCardWrapper.this.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.f84099g != null && this.f84098f != null) {
            int screenWidth = (DisplayUtil.getScreenWidth() - DisplayUtil.dip2px(this.f84099g.getContext(), 200.0f)) - this.f84098f.getMeasuredWidth();
            QLog.d("QFSCommentGuildCardWrapper", 1, "setGuildNameMaxWidth maxWidth: " + screenWidth + ", tip width: " + this.f84098f.getMeasuredWidth());
            this.f84099g.setMaxWidth(screenWidth);
        }
    }

    private void J() {
        if (this.f84104l != null && !this.f84110r) {
            int e16 = k.a().e("sp_key_comment_guild_guide_show_count", 0);
            if (e16 >= 1) {
                QLog.d("QFSCommentGuildCardWrapper", 1, "[showGuideBubbleView] has shown, count = " + e16);
                L();
                return;
            }
            k.a().m("sp_key_comment_guild_guide_show_count", e16 + 1);
            this.f84110r = true;
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_comment_pindao_userguide")).setTargetView(this.f84104l).setRequestWidth(D).setRequestHeight(E).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans), new c());
            return;
        }
        L();
    }

    private boolean K(@NonNull FeedCloudRead$GuildDisplayInfo feedCloudRead$GuildDisplayInfo) {
        String str;
        x();
        if (this.f84097e == null) {
            QLog.e(u(), 1, "[showGuildCardView] mGuildCardView == null");
            return false;
        }
        String str2 = feedCloudRead$GuildDisplayInfo.guildName.get();
        String str3 = feedCloudRead$GuildDisplayInfo.guildID.get();
        String str4 = feedCloudRead$GuildDisplayInfo.guildHead.get();
        String str5 = feedCloudRead$GuildDisplayInfo.guildHotnessText.get();
        List<String> list = feedCloudRead$GuildDisplayInfo.guildUserHeads.get();
        String str6 = feedCloudRead$GuildDisplayInfo.schemaURL.get();
        boolean y16 = y();
        QLog.d(u(), 1, "[showGuildCardView] guildName = " + str2 + ", guildId = " + str3 + ", headUrl = " + str4 + ", hotStr = " + str5 + ", jumpSchema = " + str6 + ", isHostFeed = " + y16);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            if (list.size() <= 0) {
                QLog.e(u(), 1, "[showGuildCardView] headUrls is empty");
                this.f84100h.setVisibility(8);
            } else {
                this.f84100h.setVisibility(0);
                this.f84100h.setData(list);
            }
            this.f84099g.setText(str2);
            this.f84103k.setText(str5);
            TextView textView = this.f84102j;
            if (y16) {
                str = F;
            } else {
                str = G;
            }
            textView.setText(str);
            int a16 = QFSQUIUtilsKt.a(QFSQUIUtilsKt.d(s(), R.color.qui_common_text_secondary), 0.3f);
            this.f84107o.setBackgroundColor(a16);
            this.f84108p.setBackgroundColor(a16);
            this.f84109q.setBackgroundColor(a16);
            Option targetView = Option.obtain().setUrl(str4).setTargetView(this.f84101i);
            int i3 = C;
            QCircleFeedPicLoader.g().loadImage(targetView.setRequestWidth(i3).setRequestHeight(i3).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
            this.f84097e.setOnClickListener(new a(str6));
            this.f84097e.setOnLongClickListener(new b(y16));
            G(true);
            if (y16) {
                J();
            }
            B(feedCloudRead$GuildDisplayInfo);
            return true;
        }
        G(false);
        QLog.e(u(), 1, "[showGuildCardView] guildId or guildName is empty");
        return false;
    }

    private void L() {
        if (this.f84105m != null && this.f84106n != null) {
            w();
            this.f84106n.setVisibility(8);
            this.f84105m.setVisibility(0);
            this.f84116x = true;
            RFWThreadManager.getUIHandler().removeCallbacks(this.f84117y);
            RFWThreadManager.getUIHandler().postDelayed(this.f84117y, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context s() {
        View view = this.f84096d;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }

    private FeedCloudMeta$StFeed t() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSCommentInfo qFSCommentInfo = this.f84094b;
        if (qFSCommentInfo != null && (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) != null) {
            return feedCloudMeta$StFeed;
        }
        return new FeedCloudMeta$StFeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        QCircleCustomDialog.P(s(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f189023y_), R.string.cancel, R.string.f170648xe, new d(), new e()).show();
        C(QCircleDaTongConstant.ElementId.EM_XSJ_CLOSE_CHANNEL_ENTRANCE_POPUP, "ev_xsj_abnormal_imp");
    }

    private void w() {
        if (this.f84113u == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(s(), R.anim.f154903t8);
            this.f84113u = loadAnimation;
            loadAnimation.setDuration(500L);
        }
        if (this.f84114v == null) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(s(), R.anim.t_);
            this.f84114v = loadAnimation2;
            loadAnimation2.setDuration(500L);
        }
    }

    private void x() {
        View view;
        if (this.f84097e == null && (view = this.f84096d) != null) {
            ViewGroup viewGroup = (ViewGroup) ((ViewStub) view.findViewById(R.id.u1k)).inflate();
            this.f84097e = viewGroup;
            QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) viewGroup.findViewById(R.id.y18);
            this.f84101i = qCircleRoundImageView;
            qCircleRoundImageView.setRoundRect(B);
            this.f84098f = (TextView) this.f84097e.findViewById(R.id.f164737tnn);
            this.f84099g = (TextView) this.f84097e.findViewById(R.id.f1065068w);
            this.f84100h = (QCircleAvatarListView) this.f84097e.findViewById(R.id.tnm);
            this.f84103k = (TextView) this.f84097e.findViewById(R.id.f1064968v);
            this.f84102j = (TextView) this.f84097e.findViewById(R.id.tno);
            this.f84107o = this.f84097e.findViewById(R.id.tnq);
            this.f84108p = this.f84097e.findViewById(R.id.tnp);
            this.f84109q = this.f84097e.findViewById(R.id.bnd);
            this.f84105m = (TextView) this.f84097e.findViewById(R.id.f1065168x);
            this.f84106n = (ViewGroup) this.f84097e.findViewById(R.id.toi);
            this.f84104l = (ImageView) this.f84096d.findViewById(R.id.f356312d);
        }
    }

    private boolean y() {
        return QCirclePluginUtil.isOwner(t().poster.f398463id.get());
    }

    protected void D() {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(13, 1), new f());
    }

    public void F(boolean z16, QFSCommentInfo qFSCommentInfo) {
        this.f84093a = z16;
        this.f84094b = qFSCommentInfo;
        if (z16) {
            G(false);
        }
    }

    public void I(String str, int i3) {
        this.f84111s = str;
        this.f84112t = i3;
    }

    public boolean M(QCircleCommentUpdateEvent qCircleCommentUpdateEvent, boolean z16) {
        Object valueOf;
        boolean z17;
        if (qCircleCommentUpdateEvent != null && qCircleCommentUpdateEvent.eventStatus == 1 && !qCircleCommentUpdateEvent.isProtocolCache()) {
            this.f84095c = qCircleCommentUpdateEvent.getGuildDisplayInfo();
            if (!A()) {
                return false;
            }
            if (z16) {
                G(false);
                QLog.d(u(), 1, "[update] has show ecommerce card");
                return false;
            }
            if (!this.f84093a) {
                QLog.d(u(), 1, "[update] not need reset");
                return false;
            }
            if (qCircleCommentUpdateEvent.getGuildDisplayInfo() != null && qCircleCommentUpdateEvent.getGuildDisplayInfo().has()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                G(false);
                QLog.d(u(), 1, "[update] not has guild display info");
                return false;
            }
            return K(qCircleCommentUpdateEvent.getGuildDisplayInfo());
        }
        String u16 = u();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[update] error eventStatus = ");
        Object obj = "";
        if (qCircleCommentUpdateEvent == null) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(qCircleCommentUpdateEvent.eventStatus);
        }
        sb5.append(valueOf);
        sb5.append(", isProtocolCache = ");
        if (qCircleCommentUpdateEvent != null) {
            obj = Boolean.valueOf(qCircleCommentUpdateEvent.isProtocolCache());
        }
        sb5.append(obj);
        QLog.d(u16, 1, sb5.toString());
        return false;
    }

    public void r() {
        ImageView imageView = this.f84104l;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f84118z);
        RFWThreadManager.getUIHandler().removeCallbacks(this.A);
        E();
    }

    protected String u() {
        return "QFSCommentGuildCardWrapper";
    }

    public boolean z() {
        ViewGroup viewGroup = this.f84097e;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
