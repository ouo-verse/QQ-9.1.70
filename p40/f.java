package p40;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.utils.be;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.animation.transition.TransitionInitData;
import com.tencent.biz.richframework.animation.transition.TransitionManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import p40.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static c f425273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements TransitionManager.OnAnimEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f425274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f425275b;

        a(d dVar, FrameLayout frameLayout) {
            this.f425274a = dVar;
            this.f425275b = frameLayout;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
            d dVar = this.f425274a;
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final FrameLayout frameLayout = this.f425275b;
            uIHandler.postDelayed(new Runnable() { // from class: p40.e
                @Override // java.lang.Runnable
                public final void run() {
                    frameLayout.setVisibility(8);
                }
            }, 200L);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            d dVar = this.f425274a;
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final FrameLayout frameLayout = this.f425275b;
            uIHandler.postDelayed(new Runnable() { // from class: p40.d
                @Override // java.lang.Runnable
                public final void run() {
                    frameLayout.setVisibility(8);
                }
            }, 200L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements TransitionManager.OnAnimEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f425276a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f425277b;

        b(d dVar, FrameLayout frameLayout) {
            this.f425276a = dVar;
            this.f425277b = frameLayout;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
            d dVar = this.f425276a;
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final FrameLayout frameLayout = this.f425277b;
            uIHandler.postDelayed(new Runnable() { // from class: p40.h
                @Override // java.lang.Runnable
                public final void run() {
                    frameLayout.setVisibility(8);
                }
            }, 300L);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            d dVar = this.f425276a;
            if (dVar != null) {
                dVar.onAnimEnd();
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final FrameLayout frameLayout = this.f425277b;
            uIHandler.postDelayed(new Runnable() { // from class: p40.g
                @Override // java.lang.Runnable
                public final void run() {
                    frameLayout.setVisibility(8);
                }
            }, 300L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        Activity a();
    }

    private static void c(TransitionInitData transitionInitData) {
        transitionInitData.setImageEndRect(new RectF(0.0f, DisplayUtil.getTopHeight(RFWApplication.getApplication()), transitionInitData.getLayoutEndRect().width(), transitionInitData.getLayoutEndRect().height() - ImmersiveUtils.dpToPx(56.0f)));
    }

    private static void d(TransitionInitData transitionInitData, float f16, float f17) {
        float f18;
        float instantScreenWidth = DisplayUtil.getInstantScreenWidth(RFWApplication.getApplication());
        float f19 = (int) ((instantScreenWidth / f16) * f17);
        float f26 = 0.0f;
        if (transitionInitData.getLayoutEndRect().width() > instantScreenWidth) {
            f18 = (transitionInitData.getLayoutEndRect().width() - instantScreenWidth) / 2.0f;
        } else {
            f18 = 0.0f;
        }
        float height = (transitionInitData.getLayoutEndRect().height() - DisplayUtil.getTopHeight(RFWApplication.getApplication())) - ImmersiveUtils.dpToPx(56.0f);
        if (height > f19) {
            f26 = (height - f19) / 2.0f;
        }
        transitionInitData.setImageEndRect(new RectF(f18, DisplayUtil.getTopHeight(RFWApplication.getApplication()) + f26, instantScreenWidth + f18, (DisplayUtil.getTopHeight(RFWApplication.getApplication()) + height) - f26));
        transitionInitData.setEndScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private static void e(TransitionInitData transitionInitData, float f16, float f17) {
        float f18;
        float height = ((transitionInitData.getLayoutEndRect().height() - DisplayUtil.getTopHeight(RFWApplication.getApplication())) - ImmersiveUtils.dpToPx(56.0f)) * (f16 / f17);
        if (transitionInitData.getLayoutEndRect().width() > height) {
            f18 = (transitionInitData.getLayoutEndRect().width() - height) / 2.0f;
        } else {
            f18 = 0.0f;
        }
        transitionInitData.setImageEndRect(new RectF(f18, DisplayUtil.getTopHeight(RFWApplication.getApplication()), height + f18, transitionInitData.getLayoutEndRect().height() - ImmersiveUtils.dpToPx(56.0f)));
    }

    private static void f(TransitionInitData transitionInitData, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (transitionInitData != null && feedCloudMeta$StFeed != null) {
            int i3 = feedCloudMeta$StFeed.video.width.get();
            int i16 = feedCloudMeta$StFeed.video.height.get();
            if (!TransitionHelper.shouldVideoYFullScreen(i3, i16) && (!TransitionHelper.isFolderScreenOpenMode(RFWApplication.getApplication()) || feedCloudMeta$StFeed.video.orientation.get() == 2)) {
                if (TransitionHelper.shouldFullScreen(i3, i16)) {
                    c(transitionInitData);
                    return;
                } else {
                    d(transitionInitData, i3, i16);
                    return;
                }
            }
            e(transitionInitData, i3, i16);
        }
    }

    public static void g(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final d dVar) {
        WeakReference<QFSVideoView> weakReference;
        final FrameLayout m3 = m();
        if (m3 != null && (weakReference = QFSVideoView.D) != null && weakReference.get() != null) {
            final QFSVideoView qFSVideoView = QFSVideoView.D.get();
            be.c().h(qFSVideoView, feedCloudMeta$StFeed, new bi.a() { // from class: p40.c
                @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                public final void a(Pair pair) {
                    f.p(f.d.this, qFSVideoView, feedCloudMeta$StFeed, m3, pair);
                }
            });
        }
    }

    public static void h(View view, Bitmap bitmap, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, d dVar) {
        FrameLayout m3 = m();
        if (m3 != null && view != null) {
            FrameLayout i3 = i(m3, true);
            if (dVar != null) {
                dVar.a();
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            TransitionInitData transitionInitData = new TransitionInitData();
            transitionInitData.setCoverDrawable(new BitmapDrawable(bitmap));
            int i16 = iArr[0];
            int i17 = com.tencent.qui.video.floatingview.view.m.f363980m;
            float f16 = i16 + i17;
            float f17 = iArr[1] + i17;
            int measuredWidth = i16 + view.getMeasuredWidth();
            int i18 = com.tencent.qui.video.floatingview.view.m.f363980m;
            transitionInitData.setLayoutStartRect(new RectF(f16, f17, measuredWidth - i18, (iArr[1] - i18) + view.getMeasuredHeight()));
            transitionInitData.setEnterAnimFadeCoverTimeMs(300);
            transitionInitData.setTransitionDelayTimeMs(0);
            transitionInitData.setTransitionAniDurationMs(200);
            transitionInitData.setStartScaleType(ImageView.ScaleType.CENTER_CROP);
            transitionInitData.setFadeAniLayoutNotImg(true);
            transitionInitData.setBackgroundColor(RFWApplication.getApplication().getResources().getColor(R.color.ajr));
            transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, DisplayUtil.getInstantScreenWidth(RFWApplication.getApplication()), (l(n()) - cx.h()) - com.tencent.mobileqq.qui.b.f276860a.h(n())));
            f(transitionInitData, feedCloudMeta$StFeed);
            TransitionManager transitionManager = new TransitionManager();
            transitionManager.initCoverViewAndData(i3, transitionInitData);
            u.H().E0();
            if (TextUtils.equals(Build.MANUFACTURER.toLowerCase(), CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.toLowerCase()) && Build.VERSION.SDK_INT >= 31 && ((RFWLifecycleHelper.getInstance().isRunningInBackground() || z16) && dVar != null && uq3.o.Y0())) {
                QLog.d("QFSFloatingAniUtils", 1, "[aniToFullScreen] current is background, enter anim end, feed id:" + bj.g(feedCloudMeta$StFeed));
                dVar.onAnimEnd();
                i3.setVisibility(8);
                return;
            }
            QLog.d("QFSFloatingAniUtils", 1, "[aniToFullScreen] start enter anim, feed id: " + bj.g(feedCloudMeta$StFeed));
            transitionManager.startEnterAnim(new b(dVar, i3));
        }
    }

    private static FrameLayout i(FrameLayout frameLayout, boolean z16) {
        FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.f41901ib);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
            frameLayout2.setAlpha(1.0f);
            return frameLayout2;
        }
        FrameLayout frameLayout3 = new FrameLayout(RFWApplication.getApplication());
        com.tencent.biz.qui.quicommon.e.o(frameLayout3, 16);
        frameLayout3.setBackgroundColor(RFWApplication.getApplication().getResources().getColor(R.color.black));
        frameLayout3.setId(R.id.f41901ib);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, com.tencent.mobileqq.qui.b.f276860a.h(n()));
        FrameLayout frameLayout4 = new FrameLayout(RFWApplication.getApplication());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(0, 0, 0, HostUIHelper.getInstance().getHostTabHeight());
        frameLayout3.addView(frameLayout4, layoutParams2);
        frameLayout.addView(frameLayout3, layoutParams);
        frameLayout4.setOnClickListener(new View.OnClickListener() { // from class: p40.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.q(view);
            }
        });
        return frameLayout3;
    }

    private static void j(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Bitmap bitmap, d dVar, FrameLayout frameLayout) {
        int[] k3 = k(new com.tencent.qui.video.floatingview.view.m(!gb0.b.z(feedCloudMeta$StFeed), true));
        FrameLayout i3 = i(frameLayout, false);
        if (dVar != null) {
            dVar.a();
        }
        TransitionInitData transitionInitData = new TransitionInitData();
        transitionInitData.setCoverDrawable(new BitmapDrawable(bitmap));
        float a16 = cx.a(2.0f);
        transitionInitData.setLayoutStartRect(new RectF(k3[0] + a16, k3[1] + com.tencent.mobileqq.qui.b.f276860a.h(n()), (k3[0] + (r2.t() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2))) - a16, k3[1] + (r2.c() - (com.tencent.qui.video.floatingview.view.m.f363980m * 2))));
        transitionInitData.setEnterAnimFadeCoverTimeMs(200);
        transitionInitData.setTransitionDelayTimeMs(0);
        transitionInitData.setTransitionAniDurationMs(200);
        transitionInitData.setFadeAniLayoutNotImg(true);
        transitionInitData.setStartScaleType(ImageView.ScaleType.CENTER_CROP);
        transitionInitData.setBackgroundColor(RFWApplication.getApplication().getResources().getColor(R.color.black));
        transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, DisplayUtil.getInstantScreenWidth(RFWApplication.getApplication()), l(n()) - cx.h()));
        f(transitionInitData, feedCloudMeta$StFeed);
        TransitionManager transitionManager = new TransitionManager();
        transitionManager.initCoverViewAndData(i3, transitionInitData);
        transitionManager.startExitAnim(new a(dVar, i3));
    }

    private static int[] k(com.tencent.qui.video.floatingview.view.m mVar) {
        return new int[]{((com.tencent.biz.qui.quicommon.e.f() - mVar.l()) - mVar.t()) + com.tencent.qui.video.floatingview.view.m.f363980m, mVar.s() + cx.h() + com.tencent.qui.video.floatingview.view.m.f363980m};
    }

    private static int l(Activity activity) {
        boolean isInMultiWindowMode;
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(RFWApplication.getApplication()) + DisplayUtil.getTopHeight(RFWApplication.getApplication());
        if (activity != null && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return instantScreenHeight - DisplayUtil.getTopHeight(RFWApplication.getApplication());
            }
            return instantScreenHeight;
        }
        return instantScreenHeight;
    }

    public static FrameLayout m() {
        c cVar = f425273a;
        if (cVar == null) {
            RFWLog.d("QFSFloatingAniUtils", RFWLog.USR, "error params");
            return null;
        }
        Activity a16 = cVar.a();
        if (a16 == null) {
            return null;
        }
        return (FrameLayout) a16.getWindow().getDecorView();
    }

    public static Activity n() {
        c cVar = f425273a;
        if (cVar == null) {
            RFWLog.d("QFSFloatingAniUtils", RFWLog.USR, "error params");
            return null;
        }
        return cVar.a();
    }

    public static void o(c cVar) {
        f425273a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(d dVar, QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FrameLayout frameLayout, Pair pair) {
        if (pair != null && pair.second != null) {
            if (dVar != null) {
                dVar.b();
            }
            RFWPlayerReuseUtils.prepareToReusePlayer(qFSVideoView);
            j(feedCloudMeta$StFeed, (Bitmap) pair.second, dVar, frameLayout);
            return;
        }
        QLog.d("QFSFloatingAniUtils", 1, "aniToFloatWindow capture failed");
        if (dVar != null) {
            dVar.b();
            dVar.a();
            dVar.onAnimEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("QFSFloatingAniUtils", 4, "click ani view do noting");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d implements TransitionManager.OnAnimEndListener {
        public void a() {
        }

        public void b() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
        }
    }
}
