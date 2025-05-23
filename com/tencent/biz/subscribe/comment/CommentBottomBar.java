package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoLikeRsp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentPresenter;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentBottomBar extends LinearLayout implements SimpleEventReceiver {
    private CommentPresenter C;
    private CertifiedAccountMeta$StFeed D;
    private CertifiedAccountMeta$StComment E;
    private CertifiedAccountMeta$StReply F;
    private boolean G;
    private View.OnClickListener H;
    private boolean I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f95837d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f95838e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f95839f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95840h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f95841i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f95842m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentBottomBar.this.B();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!NetworkUtil.isNetworkAvailable(CommentBottomBar.this.getContext())) {
                QQToast.makeText(CommentBottomBar.this.getContext(), HardCodeUtil.qqStr(R.string.ci8), 0).show();
            }
            CommentBottomBar.this.x();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommentBottomBar.this.w();
            if (CommentBottomBar.this.H != null) {
                CommentBottomBar.this.H.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommentBottomBar.this.C != null) {
                CommentBottomBar.this.C.t1(CommentBottomBar.this.E, CommentBottomBar.this.F);
                CommentBottomBar.this.v();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoLikeRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoLikeRsp certifiedAccountWrite$StDoLikeRsp) {
            int i3;
            boolean z17 = true;
            CommentBottomBar.this.G = true;
            if (z16 && j3 == 0 && certifiedAccountWrite$StDoLikeRsp != null && CommentBottomBar.this.D != null) {
                if (certifiedAccountWrite$StDoLikeRsp.like.status.get() == 1) {
                    i3 = CommentBottomBar.this.D.likeInfo.count.get() + 1;
                } else {
                    i3 = CommentBottomBar.this.D.likeInfo.count.get() - 1;
                }
                CommentBottomBar.this.D.likeInfo.status.set(certifiedAccountWrite$StDoLikeRsp.like.status.get());
                CommentBottomBar.this.D.likeInfo.count.set(i3);
                SimpleEventBus.getInstance().dispatchEvent(new PraisedUpdateEvents(CommentBottomBar.this.D.f24925id.get(), certifiedAccountWrite$StDoLikeRsp.like.status.get(), i3));
                if (MobileQQ.sProcessId != 1) {
                    z17 = false;
                }
                if (!z17) {
                    Bundle bundle = new Bundle();
                    bundle.putString("feed_id", CommentBottomBar.this.D.f24925id.get());
                    bundle.putInt("feed_like_status", certifiedAccountWrite$StDoLikeRsp.like.status.get());
                    bundle.putInt("feed_like_num", certifiedAccountWrite$StDoLikeRsp.like.count.get());
                    QIPCClientHelper.getInstance().callServer(SimpleEventBus.IPC_SERVICE_MODULE_NAME, SimpleEventBus.ACTION_PRAISED_UPDATE, bundle, null);
                    return;
                }
                return;
            }
            QQToast.makeText(CommentBottomBar.this.getContext(), 1, str, 0).show();
        }
    }

    public CommentBottomBar(Context context) {
        this(context, null);
    }

    private void C(int i3) {
        int i16;
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this.J = z16;
        ImageView imageView = this.f95838e;
        if (i3 == 0) {
            i16 = R.drawable.hmb;
        } else {
            i16 = R.drawable.hmc;
        }
        imageView.setBackgroundResource(i16);
    }

    private String j(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        if (certifiedAccountMeta$StReply != null) {
            if (certifiedAccountMeta$StReply.postUser != null) {
                String format = String.format(getContext().getString(R.string.f170928b51), certifiedAccountMeta$StReply.postUser.nick.get());
                if (format.length() > 10) {
                    return format.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                return format;
            }
            return null;
        }
        if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.postUser != null) {
            String format2 = String.format(getContext().getString(R.string.f170928b51), certifiedAccountMeta$StComment.postUser.nick.get());
            if (format2.length() > 10) {
                return format2.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return format2;
        }
        return null;
    }

    private void n() {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f95838e.setOnClickListener(new a());
        this.f95839f.setOnClickListener(new b());
        this.f95837d.setOnClickListener(new c());
        this.f95840h.setOnClickListener(new d());
    }

    private void o() {
        setClickable(true);
        int i3 = 0;
        setOrientation(0);
        setBackgroundColor(-1);
        setGravity(16);
        LayoutInflater.from(getContext()).inflate(R.layout.f167709ep, this);
        this.f95838e = (ImageView) findViewById(R.id.dwx);
        this.f95840h = (TextView) findViewById(R.id.k59);
        this.f95837d = (ImageView) findViewById(R.id.f165971dy1);
        this.f95839f = (ImageView) findViewById(R.id.dus);
        this.f95841i = (TextView) findViewById(R.id.dur);
        this.f95842m = (TextView) findViewById(R.id.g0g);
        boolean equals = ((String) VSConfigManager.c().e("is_open_sharing", "1")).equals("1");
        this.I = equals;
        ImageView imageView = this.f95837d;
        if (!equals) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.E = null;
        this.F = null;
        D(getContext().getString(R.string.kai));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16) {
        ScaleAnimation scaleAnimation;
        ImageView imageView = this.f95837d;
        if (imageView == null) {
            return;
        }
        imageView.setBackgroundResource(R.drawable.ccb);
        if (z16) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        }
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setAnimationListener(new f(z16));
        this.f95837d.startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.f95837d.setBackgroundResource(R.drawable.fuc);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(5);
        scaleAnimation.setAnimationListener(new g());
        this.f95837d.startAnimation(scaleAnimation);
    }

    public void A() {
        y(false);
    }

    public void B() {
        if (this.D == null) {
            return;
        }
        if (!this.G) {
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.ksw), 0).show();
            return;
        }
        this.G = false;
        VSNetworkHelper.getInstance().sendRequest(new DoLikeRequest(this.D), new e());
    }

    public void D(String str) {
        TextView textView = this.f95840h;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void E(int i3) {
        TextView textView = this.f95841i;
        if (textView == null) {
            return;
        }
        if (i3 > 0) {
            textView.setText(i.a(i3));
            this.f95841i.setVisibility(0);
        } else {
            textView.setText("");
            this.f95841i.setVisibility(8);
        }
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void F(int i3) {
        TextView textView = this.f95842m;
        if (textView == null) {
            return;
        }
        if (i3 > 0) {
            textView.setText(i.a(i3));
            this.f95842m.setVisibility(0);
        } else {
            textView.setText("");
            this.f95842m.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PraisedUpdateEvents.class);
        arrayList.add(CommentReplyEvent.class);
        return arrayList;
    }

    public CommentPresenter k() {
        return this.C;
    }

    public void l(Activity activity, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CommentPresenter.h hVar) {
        m(activity, certifiedAccountMeta$StFeed, hVar, null);
    }

    public void m(Activity activity, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CommentPresenter.h hVar, ExtraTypeInfo extraTypeInfo) {
        this.C = new CommentPresenter(activity, false, certifiedAccountMeta$StFeed, hVar, extraTypeInfo);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.D;
        if (certifiedAccountMeta$StFeed != null && (simpleBaseEvent instanceof PraisedUpdateEvents)) {
            PraisedUpdateEvents praisedUpdateEvents = (PraisedUpdateEvents) simpleBaseEvent;
            if (certifiedAccountMeta$StFeed.f24925id.get().equals(praisedUpdateEvents.mTargetFeedId)) {
                if (this.f95838e != null) {
                    C(praisedUpdateEvents.mPraisedStatus);
                    F(praisedUpdateEvents.mPraisedNum);
                    return;
                }
                return;
            }
        }
        if (simpleBaseEvent instanceof CommentReplyEvent) {
            CommentReplyEvent commentReplyEvent = (CommentReplyEvent) simpleBaseEvent;
            setTargetCommentAndReply(commentReplyEvent.mStComment, commentReplyEvent.mStReply);
        }
    }

    public boolean p() {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null && commentPresenter.a1()) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.J;
    }

    public boolean r() {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null && commentPresenter.Z0()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null) {
            return commentPresenter.f1();
        }
        return false;
    }

    public void setCurrentFeed(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.D = certifiedAccountMeta$StFeed;
        C(certifiedAccountMeta$StFeed.likeInfo.status.get());
        E(certifiedAccountMeta$StFeed.commentCount.get());
        F(certifiedAccountMeta$StFeed.likeInfo.count.get());
        if (this.f95837d != null) {
            if (this.I && SubscribeUtils.r(certifiedAccountMeta$StFeed.status.get())) {
                this.f95837d.setVisibility(0);
            } else {
                this.f95837d.setVisibility(8);
            }
        }
    }

    public void setShareClickListener(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void setTargetCommentAndReply(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        this.E = certifiedAccountMeta$StComment;
        this.F = certifiedAccountMeta$StReply;
        String j3 = j(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply);
        if (!TextUtils.isEmpty(j3)) {
            D(j3);
        }
    }

    public void t(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null) {
            commentPresenter.j1(certifiedAccountMeta$StFeed);
        }
    }

    public void u() {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null) {
            commentPresenter.g();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void w() {
        this.f95837d.clearAnimation();
        this.f95837d.setBackgroundResource(R.drawable.ccb);
    }

    public void x() {
        CommentPresenter commentPresenter = this.C;
        if (commentPresenter != null) {
            commentPresenter.s1();
        }
    }

    public CommentBottomBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentBottomBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = true;
        o();
        n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f95848d;

        f(boolean z16) {
            this.f95848d = z16;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!this.f95848d) {
                CommentBottomBar.this.z();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CommentBottomBar.this.y(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
