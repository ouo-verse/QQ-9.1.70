package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenListScrollStateChangeEvent;
import com.tencent.biz.qqcircle.richframework.video.preview.a;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ax extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: a0, reason: collision with root package name */
    private static final int f85993a0 = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.f159406d31);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f85994b0 = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.f159405d30);

    /* renamed from: c0, reason: collision with root package name */
    private static final int f85995c0 = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.d2z);
    private ViewStub I;
    private LinearLayout J;
    private View K;
    private RoundCorneredFrameLayout L;
    private ImageView M;
    private FrameLayout N;
    private com.tencent.biz.qqcircle.richframework.video.preview.a P;
    private TextView Q;
    private Size T;
    private long V;
    private RFWFeedSelectInfo Y;
    private long R = 0;
    private String S = "";
    private boolean U = false;
    private boolean W = false;
    private boolean X = false;
    private final AtomicBoolean Z = new AtomicBoolean(false);

    private boolean A1() {
        if (QCircleDeviceInfoUtils.isLowDevice() || !this.U || !this.W) {
            return false;
        }
        long j3 = this.R;
        if (j3 <= 0 || j3 >= SafeBitmapFactory.PX_THRESHOID_DEFAULTS || j3 < this.V) {
            return false;
        }
        return true;
    }

    private boolean B1() {
        boolean A1 = A1();
        if (this.X != A1) {
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[isDisplayVideoPreviewAndLog] mIsDisplayVideoPreviewChange: " + this.X + " | isLowDevice: " + QCircleDeviceInfoUtils.isLowDevice() + " | mIsEnabledVideoPreview: " + this.U + " | mIsMiddleDeviceEnabled: " + this.W + " | mVideoDuration: " + this.R + " | mPreviewDisplayDuration: " + this.V);
            this.X = A1;
        }
        return A1;
    }

    private void C1() {
        y1();
        D1();
        n1();
    }

    private void D1() {
        ViewStub viewStub = this.I;
        if (viewStub != null && this.K == null) {
            try {
                View inflate = viewStub.inflate();
                this.K = inflate;
                this.L = (RoundCorneredFrameLayout) inflate.findViewById(R.id.f494522q);
                this.N = (FrameLayout) this.K.findViewById(R.id.f494722s);
                this.M = (ImageView) this.K.findViewById(R.id.f57222mq);
                QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[loadSubView] inflater view loading finish...");
            } catch (Throwable th5) {
                QLog.e("QPP-QFSFeedChildPreviewPresenter", 1, "[loadTopShadeView] error: ", th5);
            }
        }
    }

    private void F1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        FrameLayout frameLayout = this.N;
        if (frameLayout != null) {
            frameLayout.setBackground(null);
            this.N.removeAllViews();
        }
        View view = this.K;
        if (view != null) {
            view.setBackground(null);
        }
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[release] clear preview player: selectInfo: " + rFWFeedSelectInfo);
        com.tencent.biz.qqcircle.richframework.video.preview.a aVar = this.P;
        if (aVar != null) {
            aVar.release();
            this.P.a(null);
            this.P = null;
        }
        o1();
        this.R = 0L;
        this.Z.set(false);
    }

    private void G1() {
        com.tencent.biz.qqcircle.richframework.video.preview.a aVar = this.P;
        if (aVar == null) {
            return;
        }
        aVar.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(boolean z16) {
        if (!z16) {
            K1(this.K, false);
            return;
        }
        K1(this.K, true);
        if (this.Z.get()) {
            ImageView imageView = this.M;
            if (imageView != null && imageView.getBackground() == null) {
                this.M.setBackgroundColor(-16777216);
            }
            K1(this.M, true);
            return;
        }
        K1(this.M, false);
    }

    private void I1() {
        if (this.Q == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.utils.cb.c() && !com.tencent.biz.qqcircle.utils.cb.a()) {
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(4);
            com.tencent.biz.qqcircle.utils.cb.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.L;
        if (roundCorneredFrameLayout != null && roundCorneredFrameLayout.getBackground() == null) {
            this.L.setRadius(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        }
        Drawable d16 = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.klb);
        View view = this.K;
        if (view != null && view.getBackground() != d16) {
            this.K.setBackground(d16);
        }
    }

    private void M1(long j3) {
        if (this.P == null) {
            QLog.w("QPP-QFSFeedChildPreviewPresenter", 1, "[updateSeekProgress] video preview proxy should not be null.");
            return;
        }
        H1(true);
        J1(this.K, 1.0f);
        K1(this.J, true);
        J1(this.J, 1.0f);
        I1();
        this.P.seek(j3);
    }

    private void n1() {
        if (this.K == null) {
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[adjustView] inflater view should not be null.");
            return;
        }
        int width = this.T.getWidth();
        int height = this.T.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K.getLayoutParams();
        if (layoutParams.width != width || layoutParams.height != height) {
            layoutParams.width = width;
            layoutParams.height = height;
            this.K.setLayoutParams(layoutParams);
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[adjustView] width: " + width + " | height: " + height + " | layoutParams.width: " + layoutParams.width + " | layoutParams.height: " + layoutParams.height);
        }
    }

    private void o1() {
        Animation animation;
        LinearLayout linearLayout = this.J;
        Animation animation2 = null;
        if (linearLayout == null) {
            animation = null;
        } else {
            animation = linearLayout.getAnimation();
        }
        if (animation != null) {
            animation.cancel();
        }
        View view = this.K;
        if (view != null) {
            animation2 = view.getAnimation();
        }
        if (animation2 != null) {
            animation2.cancel();
        }
        K1(this.J, false);
        J1(this.J, 1.0f);
        H1(false);
        J1(this.K, 1.0f);
    }

    private void p1() {
        View view = this.K;
        if (view != null && this.J != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.J.getAnimation();
            if (animation2 != null) {
                animation2.cancel();
            }
            H1(true);
            K1(this.J, true);
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f85995c0, 0.0f);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            this.K.setAnimation(animationSet);
            this.J.setAnimation(animationSet);
            animationSet.setDuration(240L);
            animationSet.setAnimationListener(new b());
            animationSet.start();
        }
    }

    private void q1() {
        View view = this.K;
        if (view != null && this.J != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.J.getAnimation();
            if (animation2 != null) {
                animation2.cancel();
            }
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(160L);
            animationSet.addAnimation(alphaAnimation);
            this.K.setAnimation(animationSet);
            this.J.setAnimation(animationSet);
            H1(true);
            K1(this.J, true);
            animationSet.setAnimationListener(new c());
            animationSet.start();
        }
    }

    private void r1(@NonNull QFSFullScreenListScrollStateChangeEvent qFSFullScreenListScrollStateChangeEvent) {
        if (qFSFullScreenListScrollStateChangeEvent.getState() == 1) {
            o1();
        }
    }

    private void s1(com.tencent.biz.qqcircle.immersive.feed.event.z zVar) {
        u1(zVar.f86199b, zVar.f86198a, zVar.f86200c);
    }

    private void t1(@NonNull QFSSeekEvent qFSSeekEvent) {
        u1(qFSSeekEvent.mFeedId, qFSSeekEvent.mIsOnSeek, qFSSeekEvent.mStopTrackingTouchProgress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u1(String str, boolean z16, long j3) {
        String str2;
        T t16 = this.f85017h;
        if (t16 == 0) {
            str2 = "";
        } else {
            str2 = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        if ((!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) || !B1()) {
            return;
        }
        QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[handleSeekEvent] event is on seek: " + z16 + " | feed id: " + str + " | hashCode: " + hashCode());
        if (z16) {
            C1();
            x1();
            G1();
            M1(j3);
            H1(true);
            J1(this.K, 1.0f);
            K1(this.J, true);
            J1(this.J, 1.0f);
            p1();
            return;
        }
        q1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.ag agVar) {
        String str;
        if (!B1()) {
            return;
        }
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(agVar.a(), str)) {
            return;
        }
        C1();
        x1();
        M1(agVar.b());
    }

    private void w1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        this.R = anVar.c();
        this.S = anVar.a();
    }

    private void x1() {
        if (this.P != null) {
            return;
        }
        if (TextUtils.isEmpty(this.S)) {
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[initVideoPreviewProxy] current option url should not be null.");
            return;
        }
        Size size = this.T;
        if (size != null && size.getWidth() > 0 && this.T.getHeight() > 0) {
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[initVideoPreviewProxy] width: " + this.T.getWidth() + " | height: " + this.T.getHeight() + " | hashCode: " + hashCode());
            com.tencent.biz.qqcircle.richframework.video.preview.b bVar = new com.tencent.biz.qqcircle.richframework.video.preview.b();
            this.P = bVar;
            bVar.a(new a());
            K1(this.N, true);
            this.P.c(this.N, this.M, this.T.getWidth(), this.T.getHeight());
            this.P.d(this.S, this.R, this.f85018i);
            return;
        }
        QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[initVideoPreviewProxy] current video size illegality.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y1() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int max;
        T t16 = this.f85017h;
        if (t16 == 0) {
            feedCloudMeta$StVideo = null;
        } else {
            feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) t16).video.get();
        }
        if (feedCloudMeta$StVideo == null) {
            i3 = 0;
        } else {
            i3 = feedCloudMeta$StVideo.width.get();
        }
        if (feedCloudMeta$StVideo == null) {
            return;
        }
        int i27 = feedCloudMeta$StVideo.height.get();
        if (i3 != 0 && i3 == i27) {
            int i28 = f85994b0;
            this.T = new Size(i28, i28);
        }
        boolean I0 = I0();
        if (i3 > 0 && i27 > 0) {
            try {
                float max2 = Math.max(i3, i27);
                int i29 = f85993a0;
                int i36 = (int) (max2 / (max2 / i29));
                if (I0) {
                    i26 = Math.min(i36, i29);
                } else {
                    i26 = f85994b0;
                }
                if (I0) {
                    max = f85994b0;
                } else {
                    max = Math.max(i36, f85994b0);
                }
                this.T = new Size(i26, max);
                return;
            } catch (Throwable unused) {
                if (I0) {
                    i18 = f85993a0;
                } else {
                    i18 = f85994b0;
                }
                if (I0) {
                    i19 = f85994b0;
                } else {
                    i19 = f85993a0;
                }
                this.T = new Size(i18, i19);
                return;
            }
        }
        if (I0) {
            i16 = f85993a0;
        } else {
            i16 = f85994b0;
        }
        if (I0) {
            i17 = f85994b0;
        } else {
            i17 = f85993a0;
        }
        this.T = new Size(i16, i17);
    }

    private void z1() {
        boolean z16;
        boolean z17 = false;
        if (uq3.c.X0("qqcircle", "qqcircle_video_preview_enabled", 1).intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.U = z16;
        this.V = uq3.c.Z0("qqcircle", "qqcircle_video_thumbnail_generate_min_duration", Long.valueOf(JsonGrayBusiId.UI_RESERVE_100000_110000)).longValue() * 1000;
        if (uq3.c.X0("qqcircle", "qqcircle_video_device_middle_enabled", 1).intValue() == 1) {
            z17 = true;
        }
        this.W = z17;
        QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[initWnsConfig] mIsEnabledVideoPreview: " + this.U + " | mPreviewDisplayDuration: " + this.V + " | mIsMiddleDeviceEnabled: " + this.W);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ag) {
            v1((com.tencent.biz.qqcircle.immersive.feed.event.ag) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            w1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.z) {
            s1((com.tencent.biz.qqcircle.immersive.feed.event.z) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        RFWFeedSelectInfo rFWFeedSelectInfo = this.Y;
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            F1(this.Y);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (ViewStub) view.findViewById(R.id.f494622r);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.vac);
        this.J = linearLayout;
        if (linearLayout == null) {
            this.J = (LinearLayout) view.findViewById(R.id.f42511jz);
        }
        this.Q = (TextView) this.J.findViewById(R.id.f490021i);
        I1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        super.c1(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSSeekEvent.class);
        eventClass.add(QFSFullScreenListScrollStateChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[onFeedSelected] selected: " + rFWFeedSelectInfo);
        if (this.P != null) {
            F1(rFWFeedSelectInfo);
        }
        this.Z.set(false);
        z1();
        o1();
        this.Y = rFWFeedSelectInfo;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            QLog.d("QPP-QFSFeedChildPreviewPresenter", 1, "[onFeedUnSelected] selected: " + rFWFeedSelectInfo);
            F1(rFWFeedSelectInfo);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            t1((QFSSeekEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenListScrollStateChangeEvent) {
            r1((QFSFullScreenListScrollStateChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QPP-QFSFeedChildPreviewPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC0927a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.video.preview.a.InterfaceC0927a
        public void onDecodeFirstFrame() {
            ax.this.Z.set(true);
            ax.this.L1();
        }

        @Override // com.tencent.biz.qqcircle.richframework.video.preview.a.InterfaceC0927a
        public void a() {
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
            ax axVar = ax.this;
            axVar.J1(axVar.K, 1.0f);
            ax axVar2 = ax.this;
            axVar2.J1(axVar2.J, 1.0f);
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
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ax.this.H1(false);
            ax axVar = ax.this;
            axVar.J1(axVar.K, 1.0f);
            ax axVar2 = ax.this;
            axVar2.K1(axVar2.J, false);
            ax axVar3 = ax.this;
            axVar3.J1(axVar3.J, 1.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
