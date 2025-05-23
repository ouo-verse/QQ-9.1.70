package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleRocketResPackage;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import fa0.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRocketView extends FrameLayout implements SimpleEventReceiver {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f93108d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f93109e;

    /* renamed from: f, reason: collision with root package name */
    private String f93110f;

    /* renamed from: h, reason: collision with root package name */
    private int f93111h;

    /* renamed from: i, reason: collision with root package name */
    private int f93112i;

    /* renamed from: m, reason: collision with root package name */
    private String[] f93113m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements d.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ fa0.d f93131d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f93132e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f93133f;

        b(fa0.d dVar, int i3, int i16) {
            this.f93131d = dVar;
            this.f93132e = i3;
            this.f93133f = i16;
        }

        @Override // fa0.d.a
        public void A2() {
            try {
                QCircleRocketView.this.x(this.f93132e, this.f93133f, this.f93131d.m(), (QCircleRocketResPackage) this.f93131d.o());
            } catch (Exception e16) {
                QLog.i("QCircleRocketView", 1, "playError " + e16.getMessage());
                e16.printStackTrace();
            }
        }

        @Override // fa0.d.a
        public void h4() {
            QLog.d("QCircleRocketView", 1, "QCircleRefreshPushEffect displayShowRecommendDiffRes onPreloadError");
            QCircleRocketView.this.getContext();
        }
    }

    public QCircleRocketView(Context context) {
        this(context, null);
    }

    private void h(View view, int i3, int i16, View view2) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        char c16;
        ObjectAnimator ofFloat3;
        long j3;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        if (i3 != this.C && !p(i16)) {
            ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.1f);
            ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.1f);
            ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, ImmersiveUtils.dpToPx(-40.0f));
            c16 = 1;
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.2f);
            ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.2f);
            c16 = 1;
            ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, ImmersiveUtils.dpToPx(-44.0f));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[4];
        animatorArr[0] = ofFloat4;
        animatorArr[c16] = ofFloat;
        animatorArr[2] = ofFloat2;
        animatorArr[3] = ofFloat3;
        animatorSet.playTogether(animatorArr);
        if (i3 == this.C) {
            j3 = 200;
        } else {
            j3 = 320;
        }
        animatorSet.setDuration(j3);
        animatorSet.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        Animator.AnimatorListener i17 = i(view2);
        if (i3 != this.C && !p(i16)) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.1f, 0.0f);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.1f, 0.0f);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view, "translationY", ImmersiveUtils.dpToPx(-40.0f), ImmersiveUtils.dpToPx(-8.0f));
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ofFloat5, ofFloat6, ofFloat7, ofFloat8);
            animatorSet2.setDuration(160L);
            animatorSet2.setStartDelay(320L);
            if (i17 != null) {
                animatorSet2.addListener(i17);
            }
            animatorSet2.start();
            return;
        }
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.2f, 0.9f, 1.05f, 0.95f, 1.0f, 0.4f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.2f, 0.9f, 1.05f, 0.95f, 1.0f, 0.4f);
        ofFloat9.setStartDelay(200L);
        ofFloat10.setStartDelay(200L);
        ofFloat9.setDuration(500L);
        ofFloat10.setDuration(500L);
        ofFloat5.setStartDelay(600L);
        ofFloat5.setDuration(100L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(ofFloat5, ofFloat9, ofFloat10);
        if (i17 != null) {
            animatorSet3.addListener(i17);
        }
        animatorSet3.start();
    }

    private Animator.AnimatorListener i(View view) {
        if (!uq3.o.j()) {
            return null;
        }
        return new a(view);
    }

    private static int j() {
        return 314;
    }

    private static int k() {
        return 100;
    }

    private String l(int i3, int i16, int i17, QCircleRocketResPackage qCircleRocketResPackage) {
        if (qCircleRocketResPackage == null) {
            return "";
        }
        String str = qCircleRocketResPackage.rocketSingleClick;
        if (i16 != 1 && i16 != 4) {
            if (i16 == 5) {
                return qCircleRocketResPackage.rocketEnd;
            }
            if (i3 == this.C) {
                return qCircleRocketResPackage.rocketEnd;
            }
            if (i17 == 0) {
                return qCircleRocketResPackage.rocket3;
            }
            if (i17 == 1) {
                return qCircleRocketResPackage.rocket1;
            }
            if (i17 == 2) {
                return qCircleRocketResPackage.rocket2;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, QQAnimationDrawable qQAnimationDrawable) {
        if (view != null && qQAnimationDrawable != null) {
            if (uq3.o.j()) {
                qQAnimationDrawable.clear();
                removeView(view);
            } else {
                view.setVisibility(4);
                qQAnimationDrawable.clear();
            }
        }
    }

    private void n(String str, Map<String, RFWMultiDownloadHelper.DownloadResult> map, QCircleRocketResPackage qCircleRocketResPackage) {
        if (qCircleRocketResPackage == null) {
            return;
        }
        RFWMultiDownloadHelper.DownloadResult downloadResult = map.get(qCircleRocketResPackage.rocketCount);
        if (downloadResult != null) {
            this.f93113m = q50.a.b(str, downloadResult.mFilePath);
        } else {
            QLog.d("QCircleRocketView", 4, " mCountPaths == null");
            this.f93113m = null;
        }
    }

    private void o() {
        this.f93108d = new AtomicInteger(0);
        this.f93109e = new AtomicInteger(0);
        bringToFront();
        setClipChildren(false);
        setClipToPadding(false);
        this.C = com.tencent.biz.qqcircle.l.c();
    }

    private boolean p(int i3) {
        if (i3 != 4 && i3 != 5) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(FrameAnimationView frameAnimationView, QQAnimationDrawable qQAnimationDrawable, int i3) {
        QLog.d("QQAnimationDrawable", 1, "postDelay end");
        m(frameAnimationView, qQAnimationDrawable);
        r(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3) {
        if (i3 >= this.f93108d.get() && !TextUtils.isEmpty(this.f93110f)) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationStateEvent(this.f93110f, 2, this.f93111h));
        }
    }

    private void s(TextView textView) {
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, textView.getPaint().getTextSize(), new int[]{Color.parseColor("#FFFEE098"), Color.parseColor("#FFFEF2E4")}, (float[]) null, Shader.TileMode.CLAMP));
        textView.setShadowLayer(2.0f, 0.0f, 5.0f, Color.parseColor("#FF000000"));
        textView.invalidate();
    }

    private void t(int i3, int i16) {
        ViewGroup frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        LayoutInflater.from(getContext()).inflate(R.layout.f168635g54, frameLayout);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(cx.a(50.0f), cx.a(70.0f), 0, 0);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        ((ImageView) frameLayout.findViewById(R.id.f31260qk)).setVisibility(8);
        TextView textView = (TextView) frameLayout.findViewById(R.id.f41101g6);
        textView.setVisibility(0);
        textView.setText(String.valueOf(i3));
        RFWTypefaceUtil.setNumberTypeface(textView, true);
        s(textView);
        addView(frameLayout);
        h(textView, i3, i16, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, int i16) {
        QLog.e("QCircleRocketView", 1, "count" + i3 + QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE + i16);
        if (this.f93112i == 4) {
            return;
        }
        t(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0120 A[Catch: Exception -> 0x0132, TRY_LEAVE, TryCatch #0 {Exception -> 0x0132, blocks: (B:11:0x005c, B:14:0x0065, B:16:0x006d, B:20:0x0072, B:22:0x00de, B:26:0x00eb, B:28:0x0120), top: B:10:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(final int i3, int i16, Map<String, RFWMultiDownloadHelper.DownloadResult> map, QCircleRocketResPackage qCircleRocketResPackage) {
        String[] b16;
        float f16;
        if (qCircleRocketResPackage == null) {
            return;
        }
        setVisibility(0);
        this.f93109e.set(i3);
        int i17 = i3 % 3;
        QLog.d("QCircleRocketView", 4, " count " + i3 + " rockeyType " + i17);
        String l3 = l(i3, i16, i17, qCircleRocketResPackage);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" key = ");
        sb5.append(l3);
        QLog.d("QCircleRocketView", 4, sb5.toString());
        if (map != null && map.containsKey(l3)) {
            try {
                RFWMultiDownloadHelper.DownloadResult downloadResult = map.get(l3);
                if (downloadResult != null && (b16 = q50.a.b(l3, downloadResult.mFilePath)) != null && b16.length != 0) {
                    n(l3, map, qCircleRocketResPackage);
                    final QQAnimationDrawable qQAnimationDrawable = new QQAnimationDrawable();
                    qQAnimationDrawable.setPngPaths(b16);
                    final FrameAnimationView frameAnimationView = new FrameAnimationView(getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cx.a(k()), cx.a(j()));
                    layoutParams.gravity = 5;
                    frameAnimationView.setLayoutParams(layoutParams);
                    frameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    qQAnimationDrawable.setOneShot(true);
                    qQAnimationDrawable.setFrameInterval(40L);
                    QLog.i("QQAnimationDrawable", 1, "hashCode" + qQAnimationDrawable.hashCode() + " count" + i3);
                    float countOfFrames = (float) qQAnimationDrawable.getCountOfFrames();
                    if (i3 != this.C && !p(i16)) {
                        f16 = 0.5f;
                        qQAnimationDrawable.setListener(new AnonymousClass1(i3, frameAnimationView, qQAnimationDrawable, Double.valueOf(countOfFrames * f16).intValue(), i16));
                        frameAnimationView.setImageDrawable(qQAnimationDrawable);
                        addView(frameAnimationView);
                        qQAnimationDrawable.start();
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_push_anim_stop", true)) {
                            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    QCircleRocketView.this.q(frameAnimationView, qQAnimationDrawable, i3);
                                }
                            }, b16.length * 40, true);
                            return;
                        }
                        return;
                    }
                    f16 = 0.79f;
                    qQAnimationDrawable.setListener(new AnonymousClass1(i3, frameAnimationView, qQAnimationDrawable, Double.valueOf(countOfFrames * f16).intValue(), i16));
                    frameAnimationView.setImageDrawable(qQAnimationDrawable);
                    addView(frameAnimationView);
                    qQAnimationDrawable.start();
                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_push_anim_stop", true)) {
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d("QCircleRocketView", 1, "startRockeyAnimation error" + e16.getMessage());
                r(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final int i3, final int i16, final Map<String, RFWMultiDownloadHelper.DownloadResult> map, final QCircleRocketResPackage qCircleRocketResPackage) {
        if (i16 != 3 && !p(i16)) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRocketView.5
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRocketView.this.w(i3, i16, map, qCircleRocketResPackage);
                }
            }, 320L, true);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRocketView.4
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRocketView.this.w(i3, i16, map, qCircleRocketResPackage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3, int i16) {
        if (i3 == this.C && i16 == 3) {
            com.tencent.biz.qqcircle.immersive.utils.bc.a(100L);
        } else {
            com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePushAnimationEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePushAnimationEvent) {
            QCirclePushAnimationEvent qCirclePushAnimationEvent = (QCirclePushAnimationEvent) simpleBaseEvent;
            if (qCirclePushAnimationEvent.mTargetFeedId.equals(this.f93110f) && qCirclePushAnimationEvent.mPageType == this.f93111h) {
                QLog.d("QCircleRocketView", 1, "onReceiveEvent QCirclePushAnimationEvent id:" + qCirclePushAnimationEvent.mTargetFeedId + "pageType:" + this.f93111h);
                v(qCirclePushAnimationEvent.mRecommendTimes, qCirclePushAnimationEvent.mClickType);
            }
        }
    }

    public void setFeedId(String str) {
        this.f93110f = str;
    }

    public void setFeedType(int i3) {
        this.f93112i = i3;
    }

    public void setPageType(int i3) {
        this.f93111h = i3;
    }

    public void v(int i3, int i16) {
        this.f93108d.set(i3);
        QLog.i("QCircleRocketView", 1, "setCount " + i3);
        fa0.d e16 = QCircleChangeResEngine.INSTANCE.getResManager(QCircleRocketResPackage.class).e();
        e16.x(new b(e16, i3, i16));
    }

    public QCircleRocketView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleRocketView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = 10;
        o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.widgets.QCircleRocketView$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements QQAnimationDrawable.QQAnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f93114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameAnimationView f93115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAnimationDrawable f93116c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f93117d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f93118e;

        AnonymousClass1(int i3, FrameAnimationView frameAnimationView, QQAnimationDrawable qQAnimationDrawable, int i16, int i17) {
            this.f93114a = i3;
            this.f93115b = frameAnimationView;
            this.f93116c = qQAnimationDrawable;
            this.f93117d = i16;
            this.f93118e = i17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, FrameAnimationView frameAnimationView, QQAnimationDrawable qQAnimationDrawable) {
            QLog.d("QCircleRocketView", 1, "onStop count:" + i3);
            QCircleRocketView.this.m(frameAnimationView, qQAnimationDrawable);
            QCircleRocketView.this.r(i3);
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
            if (i3 == this.f93117d) {
                QLog.i("QCircleRocketView", 1, "onPlay" + i3 + " showRecommendCountAnimation");
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleRocketView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QCircleRocketView.this.u(anonymousClass1.f93114a, anonymousClass1.f93118e);
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        QCircleRocketView.this.y(anonymousClass12.f93114a, anonymousClass12.f93118e);
                    }
                });
            }
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_push_anim_stop", true)) {
                Handler uIHandler = RFWThreadManager.getUIHandler();
                final int i3 = this.f93114a;
                final FrameAnimationView frameAnimationView = this.f93115b;
                final QQAnimationDrawable qQAnimationDrawable = this.f93116c;
                uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleRocketView.AnonymousClass1.this.b(i3, frameAnimationView, qQAnimationDrawable);
                    }
                });
            }
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f93129d;

        a(View view) {
            this.f93129d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QCircleRocketView.this.removeView(this.f93129d);
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
}
