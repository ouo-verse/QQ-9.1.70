package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bq extends u {
    private static boolean D = false;
    private QCircleInitBean C;

    /* renamed from: d, reason: collision with root package name */
    private View f87780d;

    /* renamed from: e, reason: collision with root package name */
    private QFSInterceptGestureFrameLayout f87781e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f87782f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f87783h;

    /* renamed from: i, reason: collision with root package name */
    private ObjectAnimator f87784i;

    /* renamed from: m, reason: collision with root package name */
    private QFSPagAnimView f87785m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSInterceptGestureFrameLayout.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void a() {
            if (bq.this.f87784i != null) {
                bq.this.f87784i.resume();
            }
            bq.this.C9();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void b() {
            if (bq.this.f87784i != null) {
                bq.this.f87784i.pause();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void c() {
            bq.this.C9();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSInterceptGestureFrameLayout.a
        public void onClose() {
            bq.this.C9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C9() {
        D = false;
        ObjectAnimator objectAnimator = this.f87784i;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        QFSInterceptGestureFrameLayout qFSInterceptGestureFrameLayout = this.f87781e;
        if (qFSInterceptGestureFrameLayout != null) {
            qFSInterceptGestureFrameLayout.setVisibility(8);
            this.f87781e.setLayoutStateListener(null);
        }
        QFSPagAnimView qFSPagAnimView = this.f87785m;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.setVisibility(8);
            this.f87785m.V();
        }
        ObjectAnimator objectAnimator2 = this.f87784i;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (this.f87782f != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f87782f);
        }
        if (this.f87783h != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f87783h);
        }
        QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[dismissGuide] stop full screen guide animation.");
    }

    private void D9() {
        View view = this.f87780d;
        if (view == null) {
            QLog.e("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[initGuideMantle] root view should not be null.");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f47861yf);
        if (viewStub == null) {
            QLog.e("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[initGuideMantle] view stub should not be null.");
            return;
        }
        QFSInterceptGestureFrameLayout qFSInterceptGestureFrameLayout = (QFSInterceptGestureFrameLayout) viewStub.inflate().findViewById(R.id.f47841yd);
        this.f87781e = qFSInterceptGestureFrameLayout;
        qFSInterceptGestureFrameLayout.setTargetView(this.f87780d, R.id.f165301vg1);
        this.f87785m = (QFSPagAnimView) this.f87781e.findViewById(R.id.f47831yc);
        this.f87781e.setVisibility(8);
        this.f87783h = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bp
            @Override // java.lang.Runnable
            public final void run() {
                bq.this.F9();
            }
        };
        RFWThreadManager.getUIHandler().postDelayed(this.f87783h, 3000L);
        QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[initGuideMantle] new user next video animate guide init.");
    }

    private boolean E9() {
        if (!com.tencent.biz.qqcircle.immersive.utils.ab.u(this.C) || com.tencent.biz.qqcircle.f.G("first_show_next_video_guide", false)) {
            return false;
        }
        return true;
    }

    private void G9() {
        if (!D) {
            QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[playGuideAnimation] current not show full screen guide, end flow.");
            C9();
            return;
        }
        H9();
        QFSPagAnimView qFSPagAnimView = this.f87785m;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.setBackground(null);
            this.f87785m.M("https://downv6.qq.com/video_story/qcircle/fullscreen/quanping_userguide_upglide.pag");
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f87782f);
        this.f87782f = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bo
            @Override // java.lang.Runnable
            public final void run() {
                bq.this.C9();
            }
        };
        RFWThreadManager.getUIHandler().postDelayed(this.f87782f, 6000L);
    }

    private void H9() {
        QFSInterceptGestureFrameLayout qFSInterceptGestureFrameLayout = this.f87781e;
        if (qFSInterceptGestureFrameLayout == null) {
            QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[setGuideLayoutStateListener] guide layout should not be null.");
        } else {
            qFSInterceptGestureFrameLayout.setLayoutStateListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I9, reason: merged with bridge method [inline-methods] */
    public void F9() {
        if (getActivity() != null && getActivity().isFinishing()) {
            QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[showScrollNextGuide] current activity is finishing, not execute.");
            return;
        }
        D = true;
        this.f87781e.setVisibility(0);
        G9();
        J9();
        QLog.d("VFS-QFSFullScreenNextGuideAnimatePart", 1, "[showGuide] start full screen guide animation.");
    }

    private void J9() {
        com.tencent.biz.qqcircle.f.g0("first_show_next_video_guide", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "VFS-QFSFullScreenNextGuideAnimatePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87780d = view;
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
            this.C = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        }
        if (E9()) {
            D9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f87782f != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f87782f);
        }
        C9();
    }
}
