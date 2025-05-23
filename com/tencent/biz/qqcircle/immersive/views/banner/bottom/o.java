package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o extends c implements View.OnClickListener, SimpleEventReceiver {
    private static final float X = cx.a(78.0f);
    private View D;
    private View E;
    private View F;
    private View G;
    private TextView H;
    private TextView I;
    private ImageView J;
    private QCircleAvatarView K;
    private TextView L;
    private QCircleAsyncTextView M;
    private ImageView N;
    private TextView P;
    private ImageView Q;
    private TextView R;
    private View S;
    private TextView T;
    private ImageView U;
    private View V;
    private Runnable W;

    public o(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void A() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, X);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.E.startAnimation(animationSet);
        animationSet.setAnimationListener(new b());
    }

    private void B() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new a());
        this.V.startAnimation(animationSet);
    }

    private void C(QFSSeekEvent qFSSeekEvent) {
        e30.b bVar;
        if (com.tencent.biz.qqcircle.immersive.utils.r.Q(this.f90601d) && this.D != null && (bVar = this.f90601d) != null && qFSSeekEvent.mFeedId.equals(bVar.g().f398449id.get())) {
            if (qFSSeekEvent.mIsOnSeek) {
                this.D.setVisibility(8);
                this.V.setVisibility(8);
                return;
            }
            this.D.setVisibility(0);
            if (G()) {
                this.V.setVisibility(8);
            } else {
                this.V.setVisibility(0);
            }
        }
    }

    private void D(View view, String str) {
        e30.b bVar = this.f90601d;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.f90601d));
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.setElementId(view, str);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementReuseIdentifier(view, str + this.f90601d.g().f398449id.get());
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private String E(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.post.post_type.get() != 2 && feedCloudMeta$StFeed.post.post_type.get() != 3) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f188993y7);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f188973y5);
    }

    private boolean F() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return false;
        }
        Object b16 = bVar.b("comment_feed_has_expand");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) b16).booleanValue();
    }

    private boolean G() {
        if (this.I == null) {
            return false;
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih).equals(this.I.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (F()) {
            return;
        }
        L();
    }

    private void I(@NotNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f40141dk);
        if (viewStub == null) {
            return;
        }
        this.V = view.findViewById(R.id.v_p);
        View inflate = viewStub.inflate();
        this.D = inflate;
        this.F = inflate.findViewById(R.id.f3550121);
        View findViewById = this.D.findViewById(R.id.f356012a);
        this.G = findViewById;
        findViewById.setOnClickListener(this);
        this.H = (TextView) this.D.findViewById(R.id.f355912_);
        this.K = (QCircleAvatarView) this.D.findViewById(R.id.f354611x);
        this.I = (TextView) this.D.findViewById(R.id.f354511w);
        this.J = (ImageView) this.D.findViewById(R.id.f354411v);
        View findViewById2 = this.D.findViewById(R.id.f354811z);
        this.E = findViewById2;
        findViewById2.setOnClickListener(this);
        this.L = (TextView) this.D.findViewById(R.id.f3556127);
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) this.D.findViewById(R.id.f354711y);
        this.M = qCircleAsyncTextView;
        qCircleAsyncTextView.setOnClickListener(this);
        this.N = (ImageView) this.D.findViewById(R.id.f3558129);
        this.P = (TextView) this.D.findViewById(R.id.f3557128);
        this.Q = (ImageView) this.D.findViewById(R.id.f3555126);
        this.R = (TextView) this.D.findViewById(R.id.f3554125);
        this.S = this.D.findViewById(R.id.f3553124);
        this.T = (TextView) this.D.findViewById(R.id.f3551122);
        this.U = (ImageView) this.D.findViewById(R.id.f3549120);
        this.M.setSpecialClickAreaColor(R.color.cla);
        this.W = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.H();
            }
        };
    }

    private void J() {
        if (G()) {
            z();
        } else {
            L();
        }
    }

    private void K() {
        if (this.f90602e != null && this.f90604h != null) {
            QLog.d("QFSFeedCommentFeedView", 1, "onCommentFeedClick schema:" + this.f90602e.buttomBanner.content.schema.get());
            com.tencent.biz.qqcircle.launcher.c.g(this.f90604h.getContext(), this.f90602e.buttomBanner.content.schema.get());
        }
    }

    private void L() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return;
        }
        bVar.o("comment_feed_has_expand", Boolean.TRUE);
        M(true);
        N();
        B();
        Q();
        QLog.d("QFSFeedCommentFeedView", 1, "openWithAni traceId:" + ba.c(this.f90601d) + "|feedId:" + this.f90601d.g().f398449id.get());
    }

    private void M(boolean z16) {
        if (z16) {
            this.I.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih));
            this.J.setRotation(0.0f);
        } else {
            this.I.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183193ii));
            this.J.setRotation(180.0f);
        }
    }

    private void N() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.E.setVisibility(0);
        this.E.startAnimation(animationSet);
        this.F.setVisibility(8);
        D(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_VIDEO_CARD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        this.V.startAnimation(alphaAnimation);
        this.V.setVisibility(0);
    }

    private void P() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, X);
        translateAnimation.setDuration(200L);
        this.G.startAnimation(translateAnimation);
    }

    private void Q() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        this.G.startAnimation(translateAnimation);
    }

    private void R(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str = feedCloudMeta$StFeed.buttomBanner.content.text.get();
        if (TextUtils.isEmpty(str)) {
            this.M.setVisibility(8);
        } else {
            this.M.setVisibility(0);
            this.M.setText(str);
        }
    }

    private void S(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str = feedCloudMeta$StFeed.buttomBanner.content.image.picUrl.get();
        if (TextUtils.isEmpty(str)) {
            this.U.setVisibility(8);
            return;
        }
        this.U.setVisibility(0);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.U).setPredecode(true).setRequestWidth(this.U.getLayoutParams().width).setRequestHeight(this.U.getLayoutParams().height), null);
    }

    private void T(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.post.post_type.get() == 1) {
            this.H.setText(R.string.f188983y6);
            this.N.setVisibility(0);
            this.P.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feedCloudMeta$StFeed.buttomBanner.count_info.view_count.get()));
            this.Q.setVisibility(0);
            this.R.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feedCloudMeta$StFeed.buttomBanner.count_info.like_count.get()));
            this.Q.setImageResource(R.drawable.nrt);
            return;
        }
        if (feedCloudMeta$StFeed.post.post_type.get() != 2 && feedCloudMeta$StFeed.post.post_type.get() != 3) {
            this.D.setVisibility(8);
            return;
        }
        this.H.setText(R.string.f194824cy);
        this.Q.setVisibility(8);
        this.R.setText("");
        this.N.setVisibility(0);
        this.P.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feedCloudMeta$StFeed.buttomBanner.count_info.like_count.get()));
        this.N.setImageResource(R.drawable.f162067ns3);
    }

    private void U(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.buttomBanner.content.user.get();
        QLog.d("QFSFeedCommentFeedView", 1, "show user id :" + feedCloudMeta$StUser.f398463id.get() + "user url " + feedCloudMeta$StUser.icon.iconUrl + "post type: " + feedCloudMeta$StFeed.post.post_type.get());
        if (feedCloudMeta$StUser.has()) {
            this.S.setVisibility(0);
            this.U.setVisibility(0);
            this.T.setVisibility(8);
            this.K.setAvatar(feedCloudMeta$StUser, com.tencent.biz.qqcircle.immersive.utils.n.a(this.D.getContext(), R.dimen.d4w));
            this.L.setText(feedCloudMeta$StUser.nick.get());
            return;
        }
        this.S.setVisibility(8);
        this.U.setVisibility(8);
        this.T.setVisibility(0);
        this.T.setText(E(feedCloudMeta$StFeed));
    }

    private void y() {
        if (this.W != null) {
            n().removeCallbacks(this.W);
        }
    }

    private void z() {
        M(false);
        A();
        P();
        QLog.d("QFSFeedCommentFeedView", 1, "openWithAni traceId:" + ba.c(this.f90601d) + "feedId:" + this.f90601d.g().f398449id.get());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 123;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return com.tencent.biz.qqcircle.immersive.utils.r.Q(this.f90601d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f356012a) {
            J();
        } else if (id5 == R.id.f354811z || id5 == R.id.f354711y) {
            K();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        I(this.f90604h);
        if (this.D == null || this.f90602e == null) {
            return;
        }
        D(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_VIDEO_GUIDE_BAR);
        D(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_VIDEO_CARD);
        D(this.H, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_VIDEO_CARD);
        this.D.setVisibility(0);
        this.F.setVisibility(0);
        this.E.setVisibility(8);
        M(false);
        this.V.setVisibility(0);
        U(this.f90602e);
        R(this.f90602e);
        S(this.f90602e);
        T(this.f90602e);
        y();
        n().postDelayed(this.W, 3000L);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("QFSFeedCommentFeedView", 1, "[onElementInactivated]");
        y();
        View view = this.D;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            C((QFSSeekEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (o.this.V == null) {
                return;
            }
            o.this.V.setVisibility(4);
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
    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (o.this.E == null) {
                return;
            }
            o.this.E.setVisibility(8);
            o.this.O();
            o.this.F.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
