package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.c;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;

/* loaded from: classes32.dex */
public class VideoStoryAIScenePart extends com.tencent.aelight.camera.ae.part.b implements CameraCaptureView.d, VideoFilterViewPager.b {
    private AtomicBoolean C;
    private Runnable D;
    private View E;
    private TextView F;
    private TextView G;
    private Handler H;
    private QQAnimationDrawable I;
    private QQAnimationDrawable J;
    private QQAnimationDrawable K;
    private ImageView L;
    private View M;
    private AECameraGLSurfaceView N;
    private AbsAECaptureButton P;
    private FilterPagerViewStubHolder Q;
    private QIMFilterCategoryItem R;
    private AnimationSet S;
    private AEMaterialPanel T;
    private int U;
    private long V;
    private boolean W;
    private volatile AtomicBoolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private Runnable f62395a0;

    /* renamed from: b0, reason: collision with root package name */
    private AEPituCameraUnit f62396b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f62397c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f62398d;

    /* renamed from: d0, reason: collision with root package name */
    private int f62399d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f62400e;

    /* renamed from: e0, reason: collision with root package name */
    private int f62401e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f62402f;

    /* renamed from: f0, reason: collision with root package name */
    private int f62403f0;

    /* renamed from: g0, reason: collision with root package name */
    private Runnable f62404g0;

    /* renamed from: h, reason: collision with root package name */
    private final String f62405h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.aiscene.c f62406i;

    /* renamed from: m, reason: collision with root package name */
    private AtomicReference<CameraCaptureView.d> f62407m;

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart$11, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEFilterManager f62408d;
        final /* synthetic */ VideoStoryAIScenePart this$0;

        @Override // java.lang.Runnable
        public void run() {
            VideoStoryAIScenePart videoStoryAIScenePart = this.this$0;
            videoStoryAIScenePart.V(videoStoryAIScenePart.f62407m, this.f62408d);
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart$5, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ VideoStoryAIScenePart this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements c.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f62418a;

        b(AtomicReference atomicReference) {
            this.f62418a = atomicReference;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.aiscene.c.b
        public void a(ps.c cVar) {
            CameraCaptureView.d dVar = (CameraCaptureView.d) this.f62418a.get();
            if (dVar != null) {
                dVar.b(cVar);
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.aiscene.c.b
        public void onFail(String str) {
            CameraCaptureView.d dVar = (CameraCaptureView.d) this.f62418a.get();
            if (dVar != null) {
                dVar.e(str);
            }
        }
    }

    /* loaded from: classes32.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                VSReporter.m("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
                VideoStoryAIScenePart.this.Q();
                return;
            }
            VSReporter.m("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
            Bundle data = message.getData();
            VideoStoryAIScenePart.this.S(data.getInt("sceneLvOne"), data.getString("sceneName"), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<FilterPagerViewStubHolder> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(FilterPagerViewStubHolder filterPagerViewStubHolder) {
            VideoStoryAIScenePart.this.Q = filterPagerViewStubHolder;
            if (VideoStoryAIScenePart.this.Q != null) {
                VideoStoryAIScenePart.this.Q.t(VideoStoryAIScenePart.this);
            }
        }
    }

    public VideoStoryAIScenePart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f62398d = 400;
        this.f62400e = 1500;
        this.f62402f = 2000;
        this.f62405h = "ai_guide_shown";
        this.f62406i = new com.tencent.aelight.camera.ae.camera.ui.aiscene.d();
        this.f62407m = new AtomicReference<>();
        this.C = new AtomicBoolean(false);
        this.W = false;
        this.X = new AtomicBoolean();
        this.Y = false;
        this.Z = false;
        this.f62396b0 = (AEPituCameraUnit) this.mPartManager.b(65537, new Object[0]);
    }

    private void M() {
        if (this.f62396b0.z() != null && this.f62397c0) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent();
                    intent.setAction("ae_editor_bottom_tab_show_hide");
                    intent.putExtra("is_show", true);
                    VideoStoryAIScenePart.this.f62396b0.z().sendBroadcast(intent);
                }
            };
            this.f62395a0 = runnable;
            uIHandler.postDelayed(runnable, 250L);
        }
        View view = this.E;
        if (view == null || this.G == null || this.F == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.20
            @Override // java.lang.Runnable
            public void run() {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.F, "translationY", 0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.E, "translationY", 0.0f);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.G, "translationY", 0.0f);
                VideoStoryAIScenePart.this.F.getLocationInWindow(new int[2]);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                animatorSet.setDuration(300L).start();
            }
        });
    }

    private AnimationSet N() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.F.getMeasuredHeight(), 0.0f);
        if (this.S != null) {
            AnimationSet animationSet = new AnimationSet(true);
            this.S = animationSet;
            animationSet.setInterpolator(new DecelerateInterpolator());
            this.S.setDuration(400L);
            this.S.addAnimation(alphaAnimation);
            this.S.addAnimation(translateAnimation);
        }
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        ImageView imageView = this.L;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.L.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.6
            @Override // java.lang.Runnable
            public void run() {
                VideoStoryAIScenePart.this.L.setVisibility(4);
                VideoStoryAIScenePart.this.M.setVisibility(4);
                AECameraPrefsUtil.f().l("ai_guide_shown", true, 0);
            }
        });
    }

    private void P() {
        if (this.mActivity != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            this.f62399d0 = marginLayoutParams.bottomMargin;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
            this.f62401e0 = marginLayoutParams2.bottomMargin;
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.G.getLayoutParams();
            this.f62403f0 = marginLayoutParams3.bottomMargin;
            if (this.f62397c0) {
                return;
            }
            int i3 = gq.a.l(this.mActivity.getIntent()) ? 76 : 0;
            if (i3 == 0) {
                return;
            }
            float f16 = i3;
            marginLayoutParams.bottomMargin = this.f62399d0 - ScreenUtil.dip2px(f16);
            this.E.setLayoutParams(marginLayoutParams);
            marginLayoutParams2.bottomMargin = this.f62401e0 - ScreenUtil.dip2px(f16);
            this.F.setLayoutParams(marginLayoutParams2);
            marginLayoutParams3.bottomMargin = this.f62403f0 - ScreenUtil.dip2px(f16);
            this.G.setLayoutParams(marginLayoutParams3);
        }
    }

    private void T(final AEMaterialPanel aEMaterialPanel) {
        Activity activity = (Activity) aEMaterialPanel.getContext();
        View view = this.E;
        if (view == null || this.G == null || this.F == null) {
            return;
        }
        if (view.getVisibility() == 0 || this.F.getVisibility() == 0 || this.E.getVisibility() == 0 || this.G.getVisibility() == 0) {
            final int i3 = UIUtils.i(activity);
            this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.18
                @Override // java.lang.Runnable
                public void run() {
                    int height = ((i3 - aEMaterialPanel.getHeight()) - VideoStoryAIScenePart.this.F.getMeasuredHeight()) - 10;
                    int[] iArr = new int[2];
                    VideoStoryAIScenePart.this.F.getLocationInWindow(iArr);
                    float f16 = height - iArr[1];
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.F, "translationY", 0.0f, f16);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.E, "translationY", 0.0f, f16);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.this.G, "translationY", 0.0f, f16);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                    animatorSet.setDuration(300L).start();
                }
            });
        }
    }

    private void U(boolean z16) {
        AECameraGLSurfaceView aECameraGLSurfaceView = this.N;
        if (aECameraGLSurfaceView != null) {
            if (aECameraGLSurfaceView.getSelectedCamera() == 1) {
                R();
                W(null);
                Runnable runnable = this.f62404g0;
                if (runnable != null) {
                    this.N.removeCallbacks(runnable);
                }
                O();
            }
            this.N.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.21
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity == null || VideoStoryAIScenePart.this.Q == null) {
                        return;
                    }
                    VideoStoryAIScenePart.this.Q.r(VideoStoryAIScenePart.this.U);
                }
            }, 1000L);
        }
        VSReporter.m("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AtomicReference<CameraCaptureView.d> atomicReference, AEFilterManager aEFilterManager) {
        if (atomicReference.get() == null) {
            com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "requestAIScene()", "sceneCallback is null");
            return;
        }
        if (aEFilterManager != null && aEFilterManager.getFaceAttr() != null) {
            com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "requestAIScene()", "start");
            PTFaceAttr faceAttr = aEFilterManager.getFaceAttr();
            int faceDetWidth = faceAttr.getFaceDetWidth();
            int faceDetHeight = faceAttr.getFaceDetHeight();
            ArrayList<c.a> arrayList = new ArrayList<>();
            List<List<PointF>> allFacePoints = faceAttr.getAllFacePoints();
            if (allFacePoints != null) {
                for (List<PointF> list : allFacePoints) {
                    float f16 = list.get(18).x - list.get(0).x;
                    float f17 = list.get(9).y - list.get(87).y;
                    c.a aVar = new c.a();
                    aVar.f62436b = (int) f17;
                    aVar.f62435a = (int) f16;
                    arrayList.add(aVar);
                }
            }
            if (faceDetWidth != 0 && faceDetHeight != 0) {
                AEPituCameraUnit aEPituCameraUnit = this.f62396b0;
                if (aEPituCameraUnit == null) {
                    ms.a.c("AEAIScenePart", "requestAIScene: ptFaceAttr.getData() == null, \u4e0d\u4f7f\u7528\u667a\u80fd\u6ee4\u955c");
                    return;
                }
                Bitmap S1 = aEPituCameraUnit.S1();
                try {
                    this.X.set(false);
                    this.H.sendEmptyMessage(2);
                    this.f62406i.a(S1, arrayList, new b(atomicReference));
                    return;
                } catch (Exception e16) {
                    if (atomicReference.get() != null) {
                        atomicReference.get().e(e16.toString());
                        return;
                    }
                    return;
                }
            }
            ms.a.c("AEAIScenePart", "width or height is 0, fail to request AIScene!");
            if (atomicReference.get() != null) {
                atomicReference.get().e("no bitmap");
                return;
            }
            return;
        }
        if (atomicReference.get() != null) {
            atomicReference.get().e("mQQFilterRenderManager is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Y(int i3, String str) {
        String str2;
        String[] strArr;
        File[] listFiles;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000L);
        String str3 = com.tencent.aelight.camera.ae.f.f63680f;
        if (i3 == 1) {
            str2 = "object";
        } else if (i3 == 2) {
            str2 = "food";
        } else if (i3 == 3) {
            str2 = "scene";
        } else if (i3 != 4) {
            str2 = "";
        } else {
            str2 = PreDetect.FACE_DETECT;
        }
        this.G.setText(HardCodeUtil.qqStr(R.string.f172903v84) + str + HardCodeUtil.qqStr(R.string.f172902v83));
        this.F.setText(str);
        this.F.setVisibility(0);
        this.F.setAnimation(N());
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3 + File.separator + str2;
            File file = new File(str4);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                strArr = new String[listFiles.length];
                int i16 = 0;
                while (i16 < listFiles.length) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str4);
                    sb5.append(File.separator);
                    sb5.append(str2);
                    sb5.append("_");
                    int i17 = i16 + 1;
                    sb5.append(i17);
                    sb5.append(".png");
                    String sb6 = sb5.toString();
                    if (new File(sb6).exists()) {
                        strArr[i16] = sb6;
                    }
                    i16 = i17;
                }
                this.I.E(2500L);
                this.I.F(true);
                this.E.setVisibility(0);
                this.E.setBackgroundDrawable(this.I);
                if (strArr != null) {
                    this.I.G(strArr);
                }
                this.I.start();
                this.E.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity != null) {
                            VideoStoryAIScenePart.this.E.setVisibility(8);
                            VideoStoryAIScenePart.this.R();
                        }
                    }
                }, 2500L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        VideoStoryAIScenePart.this.G.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity != null) {
                                    VideoStoryAIScenePart.this.G.startAnimation(alphaAnimation2);
                                }
                            }
                        }, 1000L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        VideoStoryAIScenePart.this.G.setVisibility(0);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                alphaAnimation2.setAnimationListener(new a());
            }
        }
        strArr = null;
        this.I.E(2500L);
        this.I.F(true);
        this.E.setVisibility(0);
        this.E.setBackgroundDrawable(this.I);
        if (strArr != null) {
        }
        this.I.start();
        this.E.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.8
            @Override // java.lang.Runnable
            public void run() {
                if (((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity != null) {
                    VideoStoryAIScenePart.this.E.setVisibility(8);
                    VideoStoryAIScenePart.this.R();
                }
            }
        }, 2500L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                VideoStoryAIScenePart.this.G.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity != null) {
                            VideoStoryAIScenePart.this.G.startAnimation(alphaAnimation2);
                        }
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                VideoStoryAIScenePart.this.G.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        alphaAnimation2.setAnimationListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(AEVideoStoryTopBarViewModel.Ratio ratio) {
        int i3;
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        AEVideoStoryTopBarViewModel.Ratio ratio2 = AEVideoStoryTopBarViewModel.Ratio.R_1_1;
        int i16 = 0;
        if (ratio == ratio2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
            layoutParams.addRule(14);
            layoutParams.addRule(13, 0);
            layoutParams.addRule(6, R.id.rq9);
            layoutParams.topMargin = ((int) (f16 - this.L.getMeasuredWidth())) >> 1;
            this.L.setLayoutParams(layoutParams);
        } else if (ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
            layoutParams2.addRule(14);
            layoutParams2.addRule(13, -1);
            layoutParams2.addRule(6, 0);
            layoutParams2.topMargin = 0;
            this.L.setLayoutParams(layoutParams2);
        }
        if (ratio == ratio2) {
            double d16 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / f16;
            if (d16 >= 1.78d) {
                i3 = d16 >= 1.78d ? -zr.a.g(this.mActivity, f16 / 2.0f) : -20;
            }
            i16 = i3;
        } else if (ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            i16 = 46;
        }
        if (i16 == 0) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
        float f17 = i16;
        marginLayoutParams.bottomMargin = this.f62399d0 - ScreenUtil.dip2px(f17);
        this.E.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
        marginLayoutParams2.bottomMargin = this.f62401e0 - ScreenUtil.dip2px(f17);
        this.F.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.G.getLayoutParams();
        marginLayoutParams3.bottomMargin = this.f62403f0 - ScreenUtil.dip2px(f17);
        this.G.setLayoutParams(marginLayoutParams3);
    }

    private void initViewModel() {
        ((AEPituCameraUnit.an) n.a(this.f62396b0).get(AEPituCameraUnit.an.class)).f61911m.observe(this.f62396b0, new d());
        ((com.tencent.aelight.camera.ae.mode.c) n.a(this.f62396b0).get(com.tencent.aelight.camera.ae.mode.c.class)).f65622i.observe(this.f62396b0, new e());
        if (this.f62397c0) {
            ((AEVideoStoryTopBarViewModel) n.a(this.f62396b0).get(AEVideoStoryTopBarViewModel.class)).f63374m.observe(this.f62396b0, new f());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Q() {
        String[] strArr;
        File[] listFiles;
        this.F.setText(HardCodeUtil.qqStr(R.string.v7k));
        this.F.setVisibility(0);
        N();
        AnimationSet animationSet = this.S;
        if (animationSet != null) {
            this.F.setAnimation(animationSet);
        }
        this.J = new QQAnimationDrawable();
        String str = com.tencent.aelight.camera.ae.f.f63679e;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                strArr = new String[listFiles.length];
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    String str2 = str + File.separator + "image_000" + i3 + ".png";
                    if (new File(str2).exists()) {
                        strArr[i3] = str2;
                    }
                }
                this.J.E(1500L);
                this.J.F(false);
                this.E.setVisibility(0);
                this.E.setBackgroundDrawable(this.J);
                if (strArr != null) {
                    this.J.G(strArr);
                }
                this.V = System.currentTimeMillis();
                this.J.start();
                this.mPartManager.q(851972, new Object[0]);
            }
        }
        strArr = null;
        this.J.E(1500L);
        this.J.F(false);
        this.E.setVisibility(0);
        this.E.setBackgroundDrawable(this.J);
        if (strArr != null) {
        }
        this.V = System.currentTimeMillis();
        this.J.start();
        this.mPartManager.q(851972, new Object[0]);
    }

    public void S(int i3, String str, boolean z16) {
        TextView textView = this.F;
        if (textView == null || textView.getVisibility() != 0 || this.W || this.X.get()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.F.getMeasuredHeight());
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(400L);
        animationSet.addAnimation(alphaAnimation);
        this.F.startAnimation(animationSet);
        animationSet.setAnimationListener(new g(z16, i3, str));
    }

    public void W(CameraCaptureView.d dVar) {
        this.f62407m.set(dVar);
    }

    public void Z() {
        this.C.set(true);
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.b
    public void a(int i3, QIMFilterCategoryItem qIMFilterCategoryItem) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("");
        if (qIMFilterCategoryItem != null) {
            str = qIMFilterCategoryItem.f66698e;
        } else {
            str = "no filter";
        }
        sb5.append(str);
        com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onFilterSelect", sb5.toString());
        if (i3 != 0) {
            W(null);
        }
        if (this.Y) {
            this.Y = false;
        } else {
            R();
        }
        this.U = i3;
        this.R = qIMFilterCategoryItem;
        VSReporter.m("mystatus_shoot", "filter_change", 0, 0, new String[0]);
    }

    public void a0(boolean z16) {
        this.Z = z16;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.d
    public void b(ps.c cVar) {
        AEPituCameraUnit aEPituCameraUnit;
        String str;
        ArrayList<QIMFilterCategoryItem> arrayList;
        AbsAECaptureButton absAECaptureButton = this.P;
        if (absAECaptureButton != null && absAECaptureButton.c()) {
            W(null);
            R();
            return;
        }
        if (cVar.f427072a != -1 && ((aEPituCameraUnit = this.f62396b0) == null || aEPituCameraUnit.o2())) {
            String str2 = cVar.f427075d;
            if (AEDashboardUtil.q()) {
                str2 = cVar.f427077f;
            }
            QIMFilterCategoryItem i3 = m.n().i(0);
            if (i3 != null) {
                str = i3.f66698e;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", str2 + " " + str);
                final Bundle bundle = new Bundle();
                bundle.putInt("apply_source", com.tencent.aelight.camera.aioeditor.capture.data.d.P);
                bundle.putInt("capture_scene", 0);
                bundle.putBoolean("capture_force_enable", this.Z);
                final com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
                if (dVar.x() == null) {
                    arrayList = new ArrayList<>();
                    R();
                } else {
                    ArrayList<QIMFilterCategoryItem> arrayList2 = dVar.x().f66517c;
                    Iterator<QIMFilterCategoryItem> it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        final QIMFilterCategoryItem next = it.next();
                        if (next.f66698e.equals(str2)) {
                            next.f66699f = str2;
                            Message message = new Message();
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("sceneName", cVar.f427074c);
                            bundle2.putInt("sceneLvOne", cVar.f427072a);
                            message.setData(bundle2);
                            message.what = 1;
                            long j3 = this.V % 1500;
                            this.H.sendMessageDelayed(message, 0L);
                            this.mRootView.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.13
                                @Override // java.lang.Runnable
                                public void run() {
                                    if ((VideoStoryAIScenePart.this.f62396b0 == null || VideoStoryAIScenePart.this.f62396b0.o2()) && ((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity != null && VideoStoryAIScenePart.this.N.getSelectedCamera() == 2) {
                                        VideoStoryAIScenePart.this.Y = true;
                                        com.tencent.aelight.camera.ae.report.b.b().N0(next.f66697d);
                                        if (AEFilterManagerHolder.getAEFilterManager() != null && !AEFilterManagerHolder.getAEFilterManager().U) {
                                            bundle.putBoolean("capture_force_enable", true);
                                        }
                                        dVar.m(next, ((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity, bundle);
                                        if (AEDashboardUtil.q()) {
                                            DYAEFilterProviderView.P(next.f66697d);
                                        } else {
                                            AEFilterProviderView.G(next.f66697d);
                                        }
                                    }
                                }
                            }, 500L);
                            break;
                        }
                    }
                    arrayList = arrayList2;
                }
                com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", "filterLister is empty:" + arrayList.size());
                return;
            }
            R();
            return;
        }
        R();
    }

    @Override // com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.d
    public void e(String str) {
        AbsAECaptureButton absAECaptureButton = this.P;
        if (absAECaptureButton != null && absAECaptureButton.c()) {
            W(null);
            return;
        }
        X(str);
        this.mRootView.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.14
            @Override // java.lang.Runnable
            public void run() {
                VideoStoryAIScenePart.this.R();
            }
        });
        com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onAISceneFail", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        this.f62397c0 = gq.a.r(this.mActivity.getIntent());
        this.E = this.mRootView.findViewById(R.id.rny);
        this.G = (TextView) this.mRootView.findViewById(R.id.f163725ro2);
        this.F = (TextView) this.mRootView.findViewById(R.id.f163724ro1);
        this.L = (ImageView) this.mRootView.findViewById(R.id.rnz);
        this.M = this.mRootView.findViewById(R.id.f163723ro0);
        this.I = new QQAnimationDrawable();
        this.K = new QQAnimationDrawable();
        this.N = (AECameraGLSurfaceView) this.mRootView.findViewById(R.id.rq9);
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.f163793s14);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.P = (AbsAECaptureButton) this.mRootView.findViewById(R.id.rqn);
        this.T = (AEMaterialPanel) this.mRootView.findViewById(R.id.ryz);
        W(this);
        this.H = new c(Looper.getMainLooper());
        P();
        initViewModel();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityPause() {
        super.onActivityPause();
        QQAnimationDrawable qQAnimationDrawable = this.J;
        if (qQAnimationDrawable != null) {
            qQAnimationDrawable.stop();
        }
        QQAnimationDrawable qQAnimationDrawable2 = this.K;
        if (qQAnimationDrawable2 != null) {
            qQAnimationDrawable2.stop();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        QQAnimationDrawable qQAnimationDrawable = this.J;
        if (qQAnimationDrawable != null) {
            qQAnimationDrawable.start();
        }
        QQAnimationDrawable qQAnimationDrawable2 = this.K;
        if (qQAnimationDrawable2 != null) {
            qQAnimationDrawable2.start();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.D;
        if (runnable != null) {
            ThreadManagerV2.removeJobFromThreadPool(runnable, 128);
            this.D = null;
        }
        if (this.f62395a0 != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.f62395a0);
        }
        this.mActivity = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<AECaptureModeChangingEvent> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent != null && aECaptureModeChangingEvent.f65599b == AECaptureMode.PLAY) {
                VideoStoryAIScenePart.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            if (ratio == null) {
                return;
            }
            VideoStoryAIScenePart.this.b0(ratio);
        }
    }

    private void X(String str) {
        if (str == null || !str.equals("network error")) {
            return;
        }
        this.mRootView.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.15
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mActivity, HardCodeUtil.qqStr(R.string.v7y), 0).show();
            }
        });
    }

    public void R() {
        S(0, null, false);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public <T> T get(int i3, Object... objArr) {
        if (i3 != 196610) {
            return (T) super.get(i3, objArr);
        }
        return (T) this.R;
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 196609:
                W(null);
                this.X.set(true);
                this.H.removeMessages(1);
                this.H.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.17
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoStoryAIScenePart.this.F.setVisibility(8);
                        VideoStoryAIScenePart.this.E.setVisibility(8);
                    }
                });
                return;
            case 196610:
            default:
                return;
            case 196611:
                U(((Boolean) objArr[0]).booleanValue());
                return;
            case 196612:
                AEMaterialPanel aEMaterialPanel = this.T;
                if (aEMaterialPanel != null) {
                    T(aEMaterialPanel);
                    return;
                }
                return;
            case 196613:
                M();
                return;
            case 196614:
                O();
                W(this);
                Z();
                return;
            case 196615:
                a0(((Boolean) objArr[0]).booleanValue());
                return;
            case 196616:
                O();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            VideoStoryAIScenePart.this.G.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f62424d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f62425e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f62426f;

        g(boolean z16, int i3, String str) {
            this.f62424d = z16;
            this.f62425e = i3;
            this.f62426f = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            VideoStoryAIScenePart.this.W = false;
            VideoStoryAIScenePart.this.E.setVisibility(8);
            VideoStoryAIScenePart.this.F.setVisibility(8);
            if (this.f62424d && !VideoStoryAIScenePart.this.X.get()) {
                VideoStoryAIScenePart.this.Y(this.f62425e, this.f62426f);
            } else {
                ((com.tencent.aelight.camera.ae.part.b) VideoStoryAIScenePart.this).mPartManager.q(851971, new Object[0]);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            VideoStoryAIScenePart.this.W = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart$16, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ VideoStoryAIScenePart this$0;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
