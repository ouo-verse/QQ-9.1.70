package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.bubble.BubbleTextView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.ao;
import com.tencent.aelight.camera.ae.camera.ui.panel.t;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.r;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.a;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* loaded from: classes32.dex */
public class VideoStoryPiecesPart extends com.tencent.aelight.camera.ae.part.b implements View.OnClickListener, yq2.c {

    /* renamed from: t0, reason: collision with root package name */
    private static int f62338t0 = 20000;

    /* renamed from: u0, reason: collision with root package name */
    private static int f62339u0 = 4000;

    /* renamed from: v0, reason: collision with root package name */
    private static int f62340v0 = 64;

    /* renamed from: w0, reason: collision with root package name */
    private static String f62341w0 = "pendent_pag";

    /* renamed from: x0, reason: collision with root package name */
    private static final String f62342x0 = g.a.b.f65260i + File.separator + AECameraConstants.CAMERA_PENDENT_PAG;
    private View C;
    private SquareRoundImageView D;
    private View E;
    private AECompoundButton F;
    private AECompoundButton G;
    private AECompoundButton H;
    private AECaptureMode I;
    private TextView J;
    private t K;
    private AEMaterialPanel L;
    private AEARCakePanel M;
    private ao N;
    private Bitmap P;
    private View Q;
    private AECameraGLSurfaceView R;
    private boolean S;
    private boolean T;
    private CountDownView U;
    private AbsAECaptureButton V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private BubbleTextView f62343a0;

    /* renamed from: b0, reason: collision with root package name */
    private BubbleTextView f62344b0;

    /* renamed from: c0, reason: collision with root package name */
    private BubbleTextView f62345c0;

    /* renamed from: d, reason: collision with root package name */
    private AEPituCameraUnit f62346d;

    /* renamed from: d0, reason: collision with root package name */
    private URLImageView f62347d0;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f62348e;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f62349e0;

    /* renamed from: f, reason: collision with root package name */
    private AEVideoStoryTopBarViewModel f62350f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f62351f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f62352g0;

    /* renamed from: h, reason: collision with root package name */
    private AEVideoStoryGIFTplViewModel f62353h;

    /* renamed from: h0, reason: collision with root package name */
    private String f62354h0;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f62355i;

    /* renamed from: i0, reason: collision with root package name */
    private String f62356i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f62357j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f62358k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f62359l0;

    /* renamed from: m, reason: collision with root package name */
    private View f62360m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f62361m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f62362n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f62363o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f62364p0;

    /* renamed from: q0, reason: collision with root package name */
    private PAGView f62365q0;

    /* renamed from: r0, reason: collision with root package name */
    private CameraTabBubbleAdBean f62366r0;

    /* renamed from: s0, reason: collision with root package name */
    private final AEMaterialManager f62367s0;

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart$18, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass18 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f62368d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f62369e;
        final /* synthetic */ VideoStoryPiecesPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            this.this$0.S0();
            this.this$0.Y0();
            RelativeLayout relativeLayout = (RelativeLayout) ((com.tencent.aelight.camera.ae.part.b) this.this$0).mRootView.findViewById(R.id.rzx);
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = this.this$0.f62344b0.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    AECaptureMode aECaptureMode = AECaptureMode.NORMAL;
                    if (aECaptureMode.name.equals(this.f62368d)) {
                        i3 = aECaptureMode.textId;
                    } else {
                        AECaptureMode aECaptureMode2 = AECaptureMode.PLAY;
                        if (aECaptureMode2.name.equals(this.f62368d)) {
                            i3 = aECaptureMode2.textId;
                        } else {
                            AECaptureMode aECaptureMode3 = AECaptureMode.GIF;
                            i3 = aECaptureMode3.name.equals(this.f62368d) ? aECaptureMode3.textId : -1;
                        }
                    }
                    if (i3 == -1) {
                        return;
                    }
                    ArrayList<View> arrayList = new ArrayList<>();
                    relativeLayout.findViewsWithText(arrayList, ((com.tencent.aelight.camera.ae.part.b) this.this$0).mActivity.getText(i3), 1);
                    if (arrayList.size() == 1) {
                        Rect rect = new Rect();
                        arrayList.get(0).getGlobalVisibleRect(rect);
                        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = ((rect.left + rect.right) / 2) - (this.this$0.f62344b0.getMeasuredWidth() / 2);
                        this.this$0.f62344b0.setLayoutParams(layoutParams);
                        this.this$0.f62344b0.setText(this.f62369e);
                        this.this$0.f62344b0.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -15.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setRepeatCount(-1);
                        translateAnimation.setRepeatMode(2);
                        this.this$0.f62344b0.startAnimation(translateAnimation);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart$19, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ VideoStoryPiecesPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout relativeLayout;
            if ((this.this$0.f62344b0 == null || this.this$0.f62344b0.getVisibility() != 0) && (relativeLayout = (RelativeLayout) ((com.tencent.aelight.camera.ae.part.b) this.this$0).mRootView.findViewById(R.id.rzx)) != null) {
                ViewGroup.LayoutParams layoutParams = this.this$0.f62343a0.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    relativeLayout.findViewsWithText(arrayList, ((com.tencent.aelight.camera.ae.part.b) this.this$0).mActivity.getText(AECaptureMode.GIF.textId), 1);
                    if (arrayList.size() == 1) {
                        Rect rect = new Rect();
                        arrayList.get(0).getGlobalVisibleRect(rect);
                        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = ((rect.left + rect.right) / 2) - (this.this$0.f62343a0.getMeasuredWidth() / 2);
                        this.this$0.f62343a0.setLayoutParams(layoutParams);
                        this.this$0.f62343a0.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -15.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setRepeatCount(-1);
                        translateAnimation.setRepeatMode(2);
                        this.this$0.f62343a0.startAnimation(translateAnimation);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart$20, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ VideoStoryPiecesPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                VideoStoryPiecesPart videoStoryPiecesPart = this.this$0;
                videoStoryPiecesPart.P = com.tencent.aelight.camera.aebase.f.b(((com.tencent.aelight.camera.ae.part.b) videoStoryPiecesPart).mActivity, true);
                if (this.this$0.P != null && !this.this$0.P.isRecycled()) {
                    VideoStoryPiecesPart videoStoryPiecesPart2 = this.this$0;
                    videoStoryPiecesPart2.P = BaseImageUtil.getRoundedCornerBitmap2(videoStoryPiecesPart2.P, ViewUtils.dip2px(3.0f), this.this$0.P.getWidth(), this.this$0.P.getHeight());
                }
                ((com.tencent.aelight.camera.ae.part.b) this.this$0).mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass20.this.this$0.P == null || AnonymousClass20.this.this$0.D == null) {
                            AnonymousClass20.this.this$0.K1(false);
                            return;
                        }
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(AnonymousClass20.this.this$0.P);
                        int f16 = BaseAIOUtils.f(36.0f, AnonymousClass20.this.this$0.D.getResources());
                        bitmapDrawable.setBounds(0, 0, f16, f16);
                        AnonymousClass20.this.this$0.D.setImageDrawable(bitmapDrawable);
                        AnonymousClass20.this.this$0.K1(true);
                    }
                });
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* loaded from: classes32.dex */
    public static class CameraTabBubbleAdBean implements Serializable {
        private String content;
        private String opID;
        private String tab;
        private String verFrom;
        private String verTo;

        public String getContent() {
            return this.content;
        }

        public String getOpID() {
            return this.opID;
        }

        public String getTab() {
            return this.tab;
        }

        public String getVerFrom() {
            return this.verFrom;
        }

        public String getVerTo() {
            return this.verTo;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setOpID(String str) {
            this.opID = str;
        }

        public void setTab(String str) {
            this.tab = str;
        }

        public void setVerFrom(String str) {
            this.verFrom = str;
        }

        public void setVerTo(String str) {
            this.verTo = str;
        }

        public String toString() {
            return "CameraTabBubbleAdBean{opID='" + this.opID + "', tab='" + this.tab + "', content='" + this.content + "', verFrom='" + this.verFrom + "', verTo='" + this.verTo + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<ao> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ao aoVar) {
            VideoStoryPiecesPart.this.N = aoVar;
            if (VideoStoryPiecesPart.this.N != null) {
                VideoStoryPiecesPart.this.N.b(VideoStoryPiecesPart.this.f62346d.I1(), ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mPartManager);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            VideoStoryPiecesPart.this.U1();
            VideoStoryPiecesPart.this.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            VideoStoryPiecesPart.this.U1();
            if (bool != null && bool.booleanValue()) {
                VideoStoryPiecesPart.this.R0();
            }
            VideoStoryPiecesPart.this.T1();
            if (bool != null) {
                VideoStoryPiecesPart.this.O0(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements ViewStub.OnInflateListener {
        h() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            if (VideoStoryPiecesPart.this.f62347d0 == null) {
                return;
            }
            if (gq.a.q(VideoStoryPiecesPart.this.f62357j0)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) VideoStoryPiecesPart.this.f62347d0.getLayoutParams();
                layoutParams.addRule(3, view.getId());
                VideoStoryPiecesPart.this.f62347d0.setLayoutParams(layoutParams);
            }
            VideoStoryPiecesPart.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements jf0.d {
        i() {
        }

        @Override // jf0.d
        public void onStop() {
            if (QLog.isColorLevel()) {
                QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
            }
            if (VideoStoryPiecesPart.this.L != null) {
                VideoStoryPiecesPart.this.L.setAlpha(1.0f);
                VideoStoryPiecesPart.this.L.setVisibility(4);
                VideoStoryPiecesPart.this.f62355i.P1().postValue(Boolean.FALSE);
            }
            VideoStoryPiecesPart.this.y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements jf0.d {
        j() {
        }

        @Override // jf0.d
        public void onStop() {
            if (QLog.isColorLevel()) {
                QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
            }
            if (VideoStoryPiecesPart.this.L != null) {
                VideoStoryPiecesPart.this.L.setAlpha(1.0f);
                VideoStoryPiecesPart.this.L.setVisibility(4);
                VideoStoryPiecesPart.this.f62355i.P1().postValue(Boolean.FALSE);
            }
            VideoStoryPiecesPart.this.A1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements CountDownView.b {
        l() {
        }

        @Override // com.tencent.aelight.camera.ae.view.CountDownView.b
        public void a() {
            VideoStoryPiecesPart.this.V.setTouchEnable(true);
        }

        @Override // com.tencent.aelight.camera.ae.view.CountDownView.b
        public void b() {
            VideoStoryPiecesPart.this.V.d();
            VideoStoryPiecesPart.this.V.setTouchEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class m implements Observer<AEMaterialWrapper> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEMaterialWrapper aEMaterialWrapper) {
            String x16;
            if (VideoStoryPiecesPart.this.I == AECaptureMode.GIF) {
                if (aEMaterialWrapper != null) {
                    x16 = AEGifMaterialManager.o().p(aEMaterialWrapper.f63554b);
                } else {
                    x16 = AEResUtil.x();
                }
                AEGifMaterialManager.o().x(x16);
                VideoStoryPiecesPart.this.R.setMaterial(x16);
                ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
                VideoStoryPiecesPart.this.Q0();
            }
        }
    }

    public VideoStoryPiecesPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.S = true;
        this.T = false;
        this.W = com.tencent.aelight.camera.ae.util.i.a();
        this.f62351f0 = false;
        this.f62367s0 = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        this.f62346d = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        if (gq.a.l(activity.getIntent())) {
            f62338t0 = 20000;
        }
        this.f62357j0 = gq.a.a(this.mActivity.getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1() {
        ao aoVar = this.N;
        if (aoVar != null) {
            aoVar.show();
            this.f62355i.L1().postValue(Boolean.TRUE);
        }
    }

    private void B1() {
        ms.a.a("VideoStoryPiecesPart", "watermark openWaterMarkPanel");
        if (this.X) {
            com.tencent.aelight.camera.aebase.c.c(8, null);
        }
    }

    private void C1() {
        ViewAnimator.j(this.L).m(0.0f, UIUtils.b(this.mActivity, this.L.getHeight())).c(300L).i(new i()).k();
    }

    private void D1() {
        ViewAnimator.j(this.L).m(0.0f, UIUtils.b(this.mActivity, this.L.getHeight())).c(300L).i(new j()).k();
    }

    private void E1() {
        URLImageView uRLImageView = this.f62347d0;
        if (uRLImageView == null || uRLImageView.getVisibility() == 0) {
            return;
        }
        com.tencent.aelight.camera.ae.report.b.b().f1();
    }

    private void F1() {
        AECaptureMode[] value;
        if (!this.X && (value = this.f62348e.f65623m.getValue()) != null && value.length == 1 && value[0] == AECaptureMode.NORMAL) {
            ms.a.a("VideoStoryPiecesPart", "from web need adjust layout ");
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62360m.getLayoutParams();
            layoutParams.bottomMargin = zr.a.a(BaseApplication.getContext(), f62340v0);
            layoutParams.addRule(12);
            this.f62360m.setLayoutParams(layoutParams);
        }
    }

    private void G1() {
        ms.a.f("VideoStoryPiecesPart", "content entry present.");
        if (this.f62347d0.getVisibility() != 0 || this.f62347d0.getDrawable() == null) {
            this.f62347d0.setVisibility(0);
            String str = this.f62354h0;
            if (str != null && !TextUtils.isEmpty(str)) {
                try {
                    ms.a.f("VideoStoryPiecesPart", "in url drawable set\uff1a" + this.f62354h0);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = this.mActivity.getResources().getDrawable(R.color.ajr);
                    obtain.mFailedDrawable = this.mActivity.getResources().getDrawable(R.color.ajr);
                    this.f62347d0.setImageDrawable(URLDrawable.getDrawable(this.f62354h0, obtain));
                    return;
                } catch (Exception unused) {
                    ms.a.c("VideoStoryPiecesPart", "url error url: " + this.f62354h0);
                    return;
                }
            }
            ms.a.f("VideoStoryPiecesPart", "iconUrl is empty.");
        }
    }

    private void J1(View.OnClickListener onClickListener) {
        SquareRoundImageView squareRoundImageView = this.D;
        if (squareRoundImageView != null) {
            squareRoundImageView.setOnClickListener(onClickListener);
        }
        View view = this.C;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(boolean z16) {
        this.D.setEnabled(z16);
        View view = this.C;
        if (view != null) {
            view.setEnabled(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(int i3) {
        this.D.setVisibility(i3);
        View view = this.C;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    private void M0() {
        Resources resources = this.mRootView.getResources();
        TextView textView = (TextView) this.mRootView.findViewById(R.id.s3o);
        textView.setTextSize(18.0f);
        textView.setShadowLayer(2.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.f163808s41);
        textView2.setTextSize(18.0f);
        textView2.setShadowLayer(2.0f, 0.0f, 1.0f, Integer.MIN_VALUE);
        int f16 = BaseAIOUtils.f(40.0f, resources);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.width = f16;
        layoutParams.height = f16;
        this.D.setLayoutParams(layoutParams);
        this.F.setForegroundSize(f16, f16);
        ViewGroup.LayoutParams layoutParams2 = this.F.getLayoutParams();
        layoutParams2.width = f16;
        layoutParams2.height = f16;
        this.F.setLayoutParams(layoutParams2);
        r0.bottomMargin -= 2;
        this.C.setLayoutParams((ViewGroup.MarginLayoutParams) this.C.getLayoutParams());
        r0.bottomMargin -= 2;
        this.E.setLayoutParams((ViewGroup.MarginLayoutParams) this.E.getLayoutParams());
    }

    private void M1(View.OnClickListener onClickListener) {
        this.F.setOnClickListener(onClickListener);
        this.F.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean s16;
                s16 = VideoStoryPiecesPart.this.s1(view, motionEvent);
                return s16;
            }
        });
        View view = this.E;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            this.E.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.f
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean t16;
                    t16 = VideoStoryPiecesPart.this.t1(view2, motionEvent);
                    return t16;
                }
            });
        }
        if (this.Y) {
            this.G.setOnClickListener(onClickListener);
        }
    }

    private void N1(int i3) {
        if (this.Y) {
            this.G.setVisibility(i3);
            this.F.setVisibility(8);
            View view = this.E;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.Z) {
            this.F.setVisibility(8);
            View view2 = this.E;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        this.F.setVisibility(i3);
        View view3 = this.E;
        if (view3 != null) {
            view3.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(boolean z16) {
        if (this.f62347d0 != null && this.f62351f0 && this.f62348e.O1()) {
            if (z16) {
                this.f62347d0.setVisibility(8);
            } else {
                this.f62347d0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(boolean z16) {
        N1((p1() && z16) ? 0 : 8);
        if (this.Y) {
            String j3 = AECameraPrefsUtil.f().j(IAECameraPrefsUtil.KEY_ARCAKE_PREVIEW, "", 4);
            ms.a.a("VideoStoryPiecesPart", "arcake  arstatus " + j3);
            if (!TextUtils.isEmpty(j3) && "1".equals(j3)) {
                N1(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        if (this.f62347d0 == null) {
            i1();
        }
        if (!this.f62351f0) {
            if (this.f62347d0.getVisibility() == 0) {
                this.f62347d0.setVisibility(8);
            }
            ms.a.a("VideoStoryPiecesPart", "hide camera content entry.");
            return;
        }
        if (gq.a.q(this.f62357j0)) {
            G1();
            return;
        }
        if (gq.a.f(this.f62357j0)) {
            if (this.Z && !m1()) {
                X0();
                return;
            } else {
                E1();
                G1();
                return;
            }
        }
        if (n1()) {
            if ("h5".equals(AECameraPrefsUtil.f().j(AECameraConstants.CAMERA_AD_TYPE, "", 4))) {
                E1();
                G1();
                return;
            } else {
                X0();
                return;
            }
        }
        X0();
    }

    private boolean P1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        MetaMaterial metaMaterial;
        if (this.I != AECaptureMode.GIF) {
            Z0();
            ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
            return;
        }
        Boolean value = this.f62355i.M1().getValue();
        if (value != null && !value.booleanValue()) {
            Z0();
            ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
            return;
        }
        AEMaterialWrapper value2 = this.f62353h.R1().getValue();
        if (value2 != null && (metaMaterial = value2.f63554b) != null) {
            String str = metaMaterial.additionalFields.get("gif_sponsor_name");
            if (TextUtils.isEmpty(str)) {
                Z0();
                ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
                return;
            } else {
                R1(str);
                return;
            }
        }
        Z0();
        ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
    }

    private void Q1() {
        if (this.f62345c0 == null) {
            BubbleTextView bubbleTextView = new BubbleTextView(this.mActivity);
            this.f62345c0 = bubbleTextView;
            bubbleTextView.setPadding(UIUtils.b(this.mActivity, 10.0f), UIUtils.b(this.mActivity, 11.0f), UIUtils.b(this.mActivity, 10.0f), UIUtils.b(this.mActivity, 11.0f));
            this.f62345c0.setIncludeFontPadding(false);
            this.f62345c0.setTextSize(1, 14.0f);
            this.f62345c0.setTextColor(Color.parseColor("#03081A"));
            BubbleTextView bubbleTextView2 = this.f62345c0;
            bubbleTextView2.f62581m = -1;
            bubbleTextView2.C = 2;
            bubbleTextView2.f62578f = UIUtils.b(this.mActivity, 6.0f);
            this.f62345c0.setText(this.mActivity.getString(R.string.xzz));
            this.f62345c0.a();
            this.f62345c0.setVisibility(4);
            ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1t);
            if (viewStub != null) {
                viewStub.inflate();
            }
            View findViewById = this.mRootView.findViewById(R.id.f163757ru4);
            if (findViewById != null) {
                ViewParent parent = findViewById.getParent();
                if (parent instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(3, R.id.f163757ru4);
                    layoutParams.topMargin = UIUtils.b(this.mActivity, -8.0f);
                    RelativeLayout relativeLayout = (RelativeLayout) parent;
                    relativeLayout.addView(this.f62345c0, relativeLayout.indexOfChild(findViewById), layoutParams);
                }
            }
        }
        this.f62345c0.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.17
            @Override // java.lang.Runnable
            public void run() {
                View findViewById2 = ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mRootView.findViewById(R.id.rok);
                if (findViewById2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = VideoStoryPiecesPart.this.f62345c0.getLayoutParams();
                    if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                        Rect rect = new Rect();
                        findViewById2.getGlobalVisibleRect(rect);
                        ((RelativeLayout.LayoutParams) layoutParams2).leftMargin = ((rect.left + rect.right) / 2) - (VideoStoryPiecesPart.this.f62345c0.getMeasuredWidth() / 2);
                        VideoStoryPiecesPart.this.f62345c0.setLayoutParams(layoutParams2);
                        VideoStoryPiecesPart.this.f62345c0.setVisibility(0);
                    }
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        BubbleTextView bubbleTextView = this.f62345c0;
        if (bubbleTextView == null || bubbleTextView.getVisibility() != 0) {
            return;
        }
        AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_CAMERA_BEAUTY_BUBBLE_HAS_SHOWN_PREFIX, true, 0);
        ms.a.f("VideoStoryPiecesPart", "[BeautyTip]--set flag:  has shown");
    }

    private void R1(String str) {
        ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + str);
        if (this.J == null) {
            TextView textView = (TextView) ((ViewStub) this.mRootView.findViewById(R.id.s1h)).inflate();
            this.J = textView;
            textView.setTranslationY(this.R.getY() - UIUtils.b(this.mActivity, 24.0f));
        }
        this.J.setVisibility(0);
        this.J.setText(this.mActivity.getString(R.string.y4u, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        BubbleTextView bubbleTextView = this.f62343a0;
        if (bubbleTextView == null || bubbleTextView.getVisibility() != 0) {
            return;
        }
        AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_COMICS_GIF_TIPS, true, 0);
        ms.a.f("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
    }

    private void S1() {
        if (FileUtils.fileExistsAndNotEmpty(f62342x0)) {
            ms.a.a("VideoStoryPiecesPart", "entry dynamics: not download ");
            v1();
            return;
        }
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.resurl = this.f62358k0;
        aEMaterialMetaData.name = AECameraConstants.CAMERA_PENDENT_PAG;
        aEMaterialMetaData.f69050id = f62341w0;
        aEMaterialManager.A0(aEMaterialManager.getApp(), g.a.b.f65260i, aEMaterialMetaData, new com.tencent.aelight.camera.download.a() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.5
            @Override // com.tencent.aelight.camera.download.a
            public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData2, boolean z16, final int i3) {
                ms.a.a("VideoStoryPiecesPart", "entry dynamics: onDownloadFinish" + i3);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i3 == 200) {
                            VideoStoryPiecesPart.this.v1();
                        }
                    }
                });
            }

            @Override // com.tencent.aelight.camera.download.a
            public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData2, int i3) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        BubbleTextView bubbleTextView;
        if (this.f62366r0 == null || (bubbleTextView = this.f62344b0) == null || bubbleTextView.getVisibility() != 0) {
            return;
        }
        ms.a.f("VideoStoryPiecesPart", "clearTabBubbleAd---OpId=" + this.f62366r0.getOpID() + ", tab=" + this.f62366r0.getTab());
        AECameraPrefsUtil f16 = AECameraPrefsUtil.f();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AECameraConstants.SP_KEY_AE_CAMERA_TAB_BUBBLE_AD_HAS_SHOWN_PREFIX);
        sb5.append(this.f62366r0.getOpID());
        f16.l(sb5.toString(), true, 0);
        this.f62366r0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        if (P1()) {
            Q1();
        } else {
            W0();
        }
    }

    public static com.tencent.aelight.camera.ae.view.b U0(AEVideoStoryTopBarViewModel.Ratio ratio) {
        if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
            return com.tencent.aelight.camera.ae.view.b.f65901x;
        }
        if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
            int d16 = com.tencent.aelight.camera.ae.util.h.d();
            if (d16 == 2) {
                return com.tencent.aelight.camera.ae.view.b.f65903z;
            }
            if (d16 == 1) {
                return com.tencent.aelight.camera.ae.view.b.A;
            }
            return com.tencent.aelight.camera.ae.view.b.f65902y;
        }
        return com.tencent.aelight.camera.ae.view.b.f65902y;
    }

    private void V1(int i3) {
        AECompoundButton aECompoundButton = this.G;
        if (aECompoundButton == null || aECompoundButton.a() == null) {
            return;
        }
        this.G.a().setImageResource(i3);
    }

    private void W0() {
        BubbleTextView bubbleTextView = this.f62345c0;
        if (bubbleTextView != null) {
            bubbleTextView.clearAnimation();
            this.f62345c0.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(com.tencent.aelight.camera.ae.view.b bVar) {
        if (this.X) {
            AbsAECaptureButton absAECaptureButton = this.V;
            if (absAECaptureButton != null) {
                absAECaptureButton.g(true, bVar);
            }
            AECompoundButton aECompoundButton = this.F;
            if (aECompoundButton != null) {
                aECompoundButton.setForegroundAndBackgroundResource(bVar.f65924u, bVar.f65923t);
            }
        }
    }

    private void X0() {
        if (this.f62347d0.getVisibility() == 0) {
            this.f62347d0.setVisibility(8);
        }
        this.f62351f0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        BubbleTextView bubbleTextView = this.f62343a0;
        if (bubbleTextView != null) {
            bubbleTextView.clearAnimation();
            this.f62343a0.setVisibility(4);
        }
    }

    private void Z0() {
        TextView textView = this.J;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void a1() {
        AEARCakePanel aEARCakePanel;
        if (!this.Y || (aEARCakePanel = this.M) == null) {
            return;
        }
        aEARCakePanel.setMaterialSelectId();
    }

    private void b1() {
        View view = this.mRootView;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f163804s33);
        this.f62349e0 = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    private void c1() {
        this.f62360m = this.mRootView.findViewById(R.id.ru9);
        this.Q = this.mRootView.findViewById(R.id.f163754ru1);
        this.R = (AECameraGLSurfaceView) this.mRootView.findViewById(R.id.rq9);
        this.V = (AbsAECaptureButton) this.mRootView.findViewById(R.id.rqn);
        this.T = this.mActivity.getIntent().getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        H1();
        this.V.setMaxDuration(V0(AECaptureMode.NORMAL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        if (this.U != null) {
            return;
        }
        CountDownView countDownView = (CountDownView) ((ViewStub) this.mRootView.findViewById(R.id.rm5)).inflate().findViewById(R.id.rm8);
        this.U = countDownView;
        countDownView.setCountDownListener(new l());
    }

    private void f1() {
        g1();
        i1();
    }

    private void g1() {
        d1();
        if (this.f62351f0) {
            if (this.X) {
                this.f62354h0 = AECameraPrefsUtil.f().j(AECameraConstants.CIRCLE_CAMERA_AD_ICON_URL, "", 4);
                this.f62356i0 = AECameraPrefsUtil.f().j(AECameraConstants.CIRCLE_CAMERA_AD_SCHEMA, "", 4);
            } else {
                this.f62354h0 = AECameraPrefsUtil.f().j(AECameraConstants.CAMERA_AD_ICON_URL, "", 4);
                this.f62356i0 = AECameraPrefsUtil.f().j(AECameraConstants.CAMERA_AD_SCHEMA, "", 4);
            }
        }
    }

    private void h1() {
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1t);
        if (viewStub != null) {
            viewStub.setOnInflateListener(new h());
        }
        URLImageView uRLImageView = this.f62347d0;
        if (uRLImageView != null) {
            uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    com.tencent.aelight.camera.ae.report.b.b().e1();
                    if ("h5".equals(VideoStoryPiecesPart.this.f62352g0)) {
                        if (!NetworkUtil.isNetworkAvailable(null)) {
                            QQToast.makeText(((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity, 1, ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.getString(R.string.ero), 1).show();
                        } else {
                            Intent intent = new Intent(((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", VideoStoryPiecesPart.this.f62356i0);
                            intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, VideoStoryPiecesPart.this.f62356i0);
                            if (((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.getIntent().hasExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE)) {
                                intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.getIntent().getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
                            } else {
                                intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
                            }
                            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.V.b());
                            intent.putExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID, ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.getIntent().getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID));
                            ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mActivity.startActivityForResult(intent, 1025);
                        }
                    } else if (AECameraConstants.HOT_ENTRY_TYPE_WIDGET.equals(VideoStoryPiecesPart.this.f62352g0)) {
                        VideoStoryPiecesPart.this.f62346d.B2(VideoStoryPiecesPart.this.f62356i0);
                    } else if ("play".equals(VideoStoryPiecesPart.this.f62352g0)) {
                        ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mPartManager.q(393219, new Object[0]);
                        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mPartManager.q(655365, VideoStoryPiecesPart.this.f62356i0);
                            }
                        }, 200L);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    private synchronized void i1() {
        this.f62347d0 = (URLImageView) this.mRootView.findViewById(R.id.rv7);
        if (this.f62351f0) {
            h1();
            P0();
        }
    }

    private void initViewModel() {
        this.f62353h = (AEVideoStoryGIFTplViewModel) n.a(this.f62346d).get(AEVideoStoryGIFTplViewModel.class);
        this.f62348e = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f62346d).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f62355i = (com.tencent.aelight.camera.ae.part.a) n.a(this.f62346d).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f62350f = (AEVideoStoryTopBarViewModel) n.a(this.f62346d).get(AEVideoStoryTopBarViewModel.class);
        this.K = (t) n.a(this.f62346d).get(t.class);
        this.f62353h.R1().observe(this.f62346d, new m());
        this.f62348e.f65622i.observe(this.f62346d, new a());
        this.f62350f.M1().observe(this.f62346d, new b());
        if (this.X) {
            this.f62350f.f63374m.observe(this.f62346d, new c());
        }
        this.f62355i.M1().observe(this.f62346d, new d());
        MutableLiveData<Boolean> P1 = this.f62355i.P1();
        Boolean bool = Boolean.FALSE;
        P1.postValue(bool);
        this.f62355i.L1().postValue(bool);
        ((AEPituCameraUnit.an) n.a(this.f62346d).get(AEPituCameraUnit.an.class)).f61910i.observe(this.f62346d, new e());
        this.f62355i.P1().observe(this.f62346d, new f());
        this.f62355i.L1().observe(this.f62346d, new g());
        ((com.tencent.aelight.camera.ae.e) n.a(this.f62346d).get(com.tencent.aelight.camera.ae.e.class)).P1().observe(this.f62346d, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoStoryPiecesPart.this.r1((r) obj);
            }
        });
    }

    private void j1() {
        if (this.X) {
            String stringExtra = this.f62346d.z().getIntent().getStringExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
            if (TextUtils.isEmpty(stringExtra) || !stringExtra.startsWith("http")) {
                return;
            }
            try {
                Intent intent = new Intent(this.f62346d.z(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", URLDecoder.decode(stringExtra, "UTF-8"));
                intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, stringExtra);
                intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.A.b());
                intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.V.b());
                this.f62346d.z().startActivityForResult(intent, 1025);
                this.mActivity.getIntent().removeExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void k1() {
        this.D = (SquareRoundImageView) this.mRootView.findViewById(R.id.rwx);
        this.C = this.mRootView.findViewById(R.id.rwy);
        J1(this);
        this.D.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mRootView.getResources().getDrawable(R.drawable.iwg);
                int f16 = BaseAIOUtils.f(36.0f, ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mRootView.getResources());
                drawable.setBounds(0, 0, f16, f16);
                VideoStoryPiecesPart.this.D.setImageDrawable(drawable);
            }
        });
        if (o1()) {
            L1(0);
            this.D.setDrawChecked(false);
        } else {
            L1(4);
        }
        this.F = (AECompoundButton) this.mRootView.findViewById(R.id.rps);
        this.E = this.mRootView.findViewById(R.id.rpt);
        vq.a.f443174a.b(this.F, "em_ae_motion_btn");
        AECompoundButton aECompoundButton = (AECompoundButton) this.mRootView.findViewById(R.id.f163732rp4);
        this.G = aECompoundButton;
        if (aECompoundButton != null) {
            aECompoundButton.setVisibility(8);
        }
        this.L = (AEMaterialPanel) this.mRootView.findViewById(R.id.ryz);
        l1();
        if (p1()) {
            if (this.Y) {
                List<com.tencent.aelight.camera.ae.data.a> b16 = AEGiftMaterialConfigParser.b();
                if (b16 != null && b16.size() <= 1) {
                    V1(R.drawable.ivd);
                } else {
                    V1(R.drawable.ivd);
                    Iterator<com.tencent.aelight.camera.ae.data.a> it = b16.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AEARCakeMaterial b17 = it.next().b();
                        if (b17 != null && !b17.usable) {
                            V1(R.drawable.ive);
                            break;
                        }
                    }
                }
            } else if (!this.X) {
                final String str = this.f62358k0;
                this.F.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!gq.a.f(VideoStoryPiecesPart.this.f62357j0) || TextUtils.isEmpty(str) || !VideoStoryPiecesPart.this.f62361m0 || !VideoStoryPiecesPart.this.q1()) {
                            VideoStoryPiecesPart.this.u1();
                        } else {
                            VideoStoryPiecesPart.this.w1();
                        }
                    }
                });
            } else {
                AECompoundButton aECompoundButton2 = (AECompoundButton) this.mRootView.findViewById(R.id.rv_);
                this.H = aECompoundButton2;
                aECompoundButton2.setOnClickListener(this);
            }
            M1(this);
            N1(0);
            AEARCakePanel aEARCakePanel = (AEARCakePanel) this.mRootView.findViewById(R.id.ryy);
            this.M = aEARCakePanel;
            if (aEARCakePanel != null) {
                aEARCakePanel.setCaptureController(this.f62346d.I1());
                this.M.setPartManager(this.mPartManager);
            }
            this.L.setPartManager(this.mPartManager);
            this.L.setCaptureController(this.f62346d.I1());
            return;
        }
        N1(8);
        this.L.setVisibility(8);
    }

    private void l1() {
        os.a aVar = os.a.f423933a;
        this.f62361m0 = aVar.b(AECameraConstants.CAMERA_AD_PENDENT_SHOW, false);
        this.f62358k0 = aVar.d(AECameraConstants.CAMERA_AD_PENDENT_ICON_URL, "");
        this.f62362n0 = aVar.d(AECameraConstants.CAMERA_AD_PENDENT_ICON_TYPE, "");
        this.f62363o0 = aVar.c(AECameraConstants.CAMERA_AD_PENDENT_CATEGORYID, -1);
        this.f62364p0 = aVar.d(AECameraConstants.CAMERA_AD_PENDENT_OP_ID, "");
        this.f62359l0 = aVar.d(AECameraConstants.CAMERA_AD_PENDENT_SCHEMA, "");
        ms.a.a("VideoStoryPiecesPart", "entry dynamics: icon type " + this.f62362n0 + " url:" + this.f62358k0 + " type :" + this.f62361m0 + " category id: " + this.f62363o0 + " OPID: " + this.f62364p0 + " scheme: " + this.f62359l0);
    }

    private boolean m1() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("aio_camera_ad_icon_switch", false);
    }

    private boolean n1() {
        return (gq.a.g(this.f62357j0) && !gq.a.f(this.f62357j0)) || gq.a.P(this.f62357j0) || gq.a.t(this.f62357j0) || gq.a.V(this.f62357j0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o1() {
        Activity activity = this.mActivity;
        return (activity == null || gq.a.j(activity.getIntent()) || gq.a.p(this.mActivity.getIntent()) || gq.a.z(this.mActivity.getIntent()) || gq.a.l(this.mActivity.getIntent()) || gq.a.C(this.mActivity.getIntent()) || gq.a.H(this.mActivity.getIntent()) || gq.a.r(this.mActivity.getIntent()) || gq.a.y(this.mActivity.getIntent()) || !this.f62346d.C().B()) ? false : true;
    }

    private boolean p1() {
        Activity activity = this.mActivity;
        return (activity == null || gq.a.C(activity.getIntent()) || gq.a.H(this.mActivity.getIntent()) || js.a.L.d(gq.a.a(this.mActivity.getIntent())) || !this.f62346d.C().z()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q1() {
        return AECameraPrefsUtil.f().c(this.f62364p0, true, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(r rVar) {
        if (this.F == null || rVar == null || rVar.getType() != 4) {
            return;
        }
        AEMaterialMetaData aEMaterialMetaData = rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (com.tencent.aelight.camera.ae.flashshow.util.e.a(aEMaterialMetaData)) {
            this.F.a().setImageResource(R.drawable.ixm);
        } else {
            UIUtils.t(this.F.a(), aEMaterialMetaData.iconurl, UIUtils.b(this.mActivity, 36.0f), UIUtils.b(this.mActivity, 36.0f), ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.ixm, null), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean s1(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.E.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            this.E.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean t1(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.E.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            this.E.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        AEMaterialCategory aEMaterialCategory;
        List<AEMaterialMetaData> list;
        ms.a.f("VideoStoryPiecesPart", "start load hot material icon");
        if (AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_CAMERA_TAB_B_MATERIAL_ENTRY_OLD, false, 4)) {
            ms.a.f("VideoStoryPiecesPart", "loadHotMaterialIcon---hit tab test, use old style");
            this.F.a().setImageResource(R.drawable.ixm);
            return;
        }
        List<AEMaterialCategory> L = this.f62367s0.L();
        if (L == null) {
            return;
        }
        Iterator<AEMaterialCategory> it = L.iterator();
        while (true) {
            if (!it.hasNext()) {
                aEMaterialCategory = null;
                break;
            } else {
                aEMaterialCategory = it.next();
                if ("\u70ed\u95e8".equals(aEMaterialCategory.f69047h)) {
                    break;
                }
            }
        }
        if (aEMaterialCategory == null && L.size() > 0) {
            aEMaterialCategory = L.get(0);
        }
        if (aEMaterialCategory != null && (list = aEMaterialCategory.f69044d) != null && !list.isEmpty()) {
            AEMaterialMetaData aEMaterialMetaData = aEMaterialCategory.f69044d.get(0);
            ms.a.f("VideoStoryPiecesPart", "load hot material icon, material id = " + aEMaterialMetaData.f69050id);
            UIUtils.t(this.F.a(), aEMaterialMetaData.iconurl, UIUtils.b(this.mActivity, 36.0f), UIUtils.b(this.mActivity, 36.0f), ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.ixm, null), null);
            return;
        }
        this.F.a().setImageResource(R.drawable.ixm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        if (!FeatureManager.Features.PAG.init()) {
            ms.a.c("VideoStoryPiecesPart", "entry dynamics: pag not init");
            this.F.a().setImageResource(R.drawable.ixm);
            return;
        }
        PAGFile Load = PagViewMonitor.Load(f62342x0);
        PAGView pAGView = new PAGView(BaseApplication.getContext());
        this.f62365q0 = pAGView;
        pAGView.addPAGFlushListener(new k());
        this.F.addView(this.f62365q0, new ViewGroup.LayoutParams(-1, -1));
        this.F.a().setImageDrawable(this.mActivity.getResources().getDrawable(R.color.ajr));
        PAGView pAGView2 = this.f62365q0;
        if (pAGView2 == null || Load == null) {
            return;
        }
        pAGView2.setComposition(Load);
        this.f62365q0.setRepeatCount(0);
        if (this.f62365q0.isPlaying()) {
            return;
        }
        ms.a.c("VideoStoryPiecesPart", "entry dynamics: pag  play");
        this.f62365q0.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        if ("pag".equals(this.f62362n0)) {
            S1();
        } else if ("static".equals(this.f62362n0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = this.mActivity.getResources().getDrawable(R.color.ajr);
            obtain.mFailedDrawable = this.mActivity.getResources().getDrawable(R.color.ajr);
            obtain.mRequestWidth = this.F.getLayoutParams().width;
            obtain.mRequestHeight = this.F.getLayoutParams().height;
            obtain.mUseAutoScaleParams = true;
            this.F.a().setImageDrawable(URLDrawable.getDrawable(this.f62358k0, obtain));
        }
        com.tencent.aelight.camera.ae.report.b.b().I0(this.f62359l0);
    }

    private boolean x1() {
        return ("h5".equals(this.f62352g0) || AECameraConstants.HOT_ENTRY_TYPE_WIDGET.equals(this.f62352g0) || "play".equals(this.f62352g0)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        if (this.N != null) {
            BubbleTextView bubbleTextView = this.f62345c0;
            boolean z16 = bubbleTextView != null && bubbleTextView.getVisibility() == 0;
            ms.a.f("VideoStoryPiecesPart", "openBeautyPanel---beautyBubbleShowing=" + z16);
            this.N.show();
            if (z16 && (this.N instanceof DYBeautyAndFilterPanelViewStubHolder)) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.22
                    @Override // java.lang.Runnable
                    public void run() {
                        ((DYBeautyAndFilterPanelViewStubHolder) VideoStoryPiecesPart.this.N).p();
                    }
                }, 250L);
            }
            this.f62355i.L1().postValue(Boolean.TRUE);
        }
    }

    private void z1() {
        ao aoVar = this.N;
        if (aoVar != null) {
            aoVar.show();
            if (this.N instanceof DYBeautyAndFilterPanelViewStubHolder) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.21
                    @Override // java.lang.Runnable
                    public void run() {
                        ((DYBeautyAndFilterPanelViewStubHolder) VideoStoryPiecesPart.this.N).p();
                        ((DYBeautyAndFilterPanelViewStubHolder) VideoStoryPiecesPart.this.N).o();
                    }
                }, 250L);
            }
            this.f62355i.L1().postValue(Boolean.TRUE);
        }
    }

    protected void H1() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (!gq.a.C(activity.getIntent()) && !gq.a.H(this.mActivity.getIntent())) {
                if (gq.a.r(this.mActivity.getIntent())) {
                    this.V.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 1));
                } else if (this.T) {
                    this.V.setFunctionFlag(2);
                } else {
                    this.V.setFunctionFlag(this.S ? 1 : 3);
                }
            } else {
                this.V.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
            }
        }
        this.V.setFunctionFlag(this.f62346d.C().d());
    }

    public void I1(boolean z16) {
        URLImageView uRLImageView = this.f62347d0;
        if (uRLImageView == null || !this.f62351f0) {
            return;
        }
        if (z16) {
            P0();
        } else {
            uRLImageView.setVisibility(8);
        }
    }

    protected int N0() {
        return this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13119a);
    }

    protected int V0(AECaptureMode aECaptureMode) {
        AEPituCameraUnit aEPituCameraUnit = this.f62346d;
        if (aEPituCameraUnit != null && aEPituCameraUnit.C().m() != -1) {
            return this.f62346d.C().m();
        }
        if (aECaptureMode == AECaptureMode.GIF) {
            return f62339u0;
        }
        return f62338t0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        this.X = gq.a.r(this.mActivity.getIntent());
        this.Y = gq.a.j(this.mActivity.getIntent());
        this.Z = gq.a.F(this.mActivity.getIntent());
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.f163793s14);
        if (viewStub != null) {
            viewStub.inflate();
        }
        c1();
        k1();
        initViewModel();
        F1();
        j1();
        f1();
        b1();
        a1();
        if (SimpleUIUtil.isNowElderMode()) {
            M0();
        }
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.7
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("VideoStoryPiecesPart", "receive template update event");
                if (VideoStoryPiecesPart.this.Y || VideoStoryPiecesPart.this.X) {
                    return;
                }
                if (!TextUtils.isEmpty(VideoStoryPiecesPart.this.f62358k0) && VideoStoryPiecesPart.this.f62361m0 && VideoStoryPiecesPart.this.q1()) {
                    return;
                }
                VideoStoryPiecesPart.this.u1();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityPause() {
        super.onActivityPause();
        CountDownView countDownView = this.U;
        if (countDownView != null) {
            countDownView.c();
        }
        ms.a.f("VideoStoryPiecesPart", "unregister adapter observer");
        this.f62367s0.n0(this);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        ms.a.f("VideoStoryPiecesPart", "register adapter observer for template list update");
        this.f62367s0.g(this, 116);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        HashMap hashMap = null;
        switch (view.getId()) {
            case R.id.f163732rp4 /* 2097545328 */:
            case R.id.rps /* 2097545353 */:
            case R.id.rpt /* 2097545354 */:
                if (!com.tencent.aelight.camera.ae.d.j()) {
                    Activity activity = this.mActivity;
                    QQToast.makeText(activity, 1, activity.getString(R.string.y17), 1).show();
                    break;
                } else {
                    if (this.X) {
                        if (!com.tencent.aelight.camera.ae.util.e.a(view)) {
                            Intent intent = new Intent();
                            intent.setAction("ae_editor_bottom_tab_show_hide");
                            intent.putExtra("is_show", false);
                            this.f62346d.z().sendBroadcast(intent);
                            com.tencent.aelight.camera.aebase.c.b(4, null);
                        }
                    }
                    if (gq.a.f(this.f62357j0) && this.f62361m0 && q1()) {
                        ms.a.a("VideoStoryPiecesPart", "entry dynamics: need jump from ad pendent");
                        this.f62346d.A2(this.f62363o0, this.f62359l0);
                        this.f62361m0 = false;
                        this.F.a().setImageResource(R.drawable.ixm);
                        PAGView pAGView = this.f62365q0;
                        if (pAGView != null && pAGView.isPlaying()) {
                            this.f62365q0.stop();
                            this.F.removeView(this.f62365q0);
                        }
                        AECameraPrefsUtil.f().l(this.f62364p0, false, 4);
                        String str = f62342x0;
                        if (FileUtils.fileExistsAndNotEmpty(str)) {
                            FileUtils.deleteFile(str);
                        }
                        com.tencent.aelight.camera.ae.report.b.b().K(this.f62359l0);
                    } else if (!this.X && !this.Y) {
                        this.f62346d.I1().a(true, 150);
                        this.K.Q1(null);
                        this.mPartManager.q(196612, new Object[0]);
                    } else {
                        this.mPartManager.q(131076, new Object[0]);
                    }
                    VSReporter.m("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                    if (this.Y) {
                        com.tencent.aelight.camera.ae.report.b.b().h();
                    }
                    com.tencent.aelight.camera.ae.report.b.b().K0();
                    vq.a.f443174a.a(view, null);
                    break;
                }
                break;
            case R.id.rp9 /* 2097545333 */:
                com.tencent.aelight.camera.ae.part.c cVar = this.mPartManager;
                if (cVar != null) {
                    cVar.q(786436, new Object[0]);
                    break;
                }
                break;
            case R.id.rv_ /* 2097545555 */:
                com.tencent.aelight.camera.ae.part.c cVar2 = this.mPartManager;
                if (cVar2 != null) {
                    cVar2.q(786433, new Object[0]);
                }
                if (this.X) {
                    AEMaterialMetaData H = AEMaterialManager.H();
                    if (H != null) {
                        hashMap = new HashMap();
                        hashMap.put("ext2", H.f69050id);
                    }
                    com.tencent.aelight.camera.aebase.c.e(2, hashMap);
                    break;
                }
                break;
            case R.id.rwx /* 2097545616 */:
            case R.id.rwy /* 2097545617 */:
                this.f62346d.q2();
                VSReporter.m("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
                com.tencent.aelight.camera.ae.report.b.b().h1();
                break;
            case R.id.f163804s33 /* 2097545844 */:
                com.tencent.aelight.camera.ae.report.b.b().n();
                AEMaterialMetaData H2 = AEMaterialManager.H();
                if (H2 != null) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("sourcetype", String.valueOf(20));
                    hashMap2.put(QCircleSchemeAttr.Polymerize.FILTER_ID, H2.f69050id);
                    hashMap2.put(QCircleSchemeAttr.Polymerize.FILTER_NAME, H2.takeSameName);
                    hashMap2.put(QCircleSchemeAttr.Polymerize.EXT1_FROM, "3");
                    com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(view.getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_POLYMERIZE, hashMap2);
                    break;
                }
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        super.onDestroy();
        ms.a.a("VideoStoryPiecesPart", "[BeautyTip]---clearBeautyTip when exit");
        R0();
    }

    private void d1() {
        this.f62351f0 = false;
        this.f62352g0 = "";
        if ("play".equals("")) {
            return;
        }
        if (x1()) {
            this.f62351f0 = false;
        } else if (n1()) {
            this.f62351f0 = "h5".equals(this.f62352g0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<AECaptureModeChangingEvent> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            int N0;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
            VideoStoryPiecesPart.this.I = aECaptureMode;
            ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
            VideoStoryPiecesPart.this.Q0();
            VideoStoryPiecesPart.this.S0();
            VideoStoryPiecesPart.this.T0();
            VideoStoryPiecesPart.this.U1();
            VideoStoryPiecesPart.this.T1();
            VideoStoryPiecesPart.this.f62346d.T2(aECaptureMode);
            VideoStoryPiecesPart.this.f62346d.c3();
            AECaptureMode aECaptureMode2 = AECaptureMode.NORMAL;
            if (aECaptureMode == aECaptureMode2) {
                VideoStoryPiecesPart.this.f62346d.y1(true);
            } else {
                VideoStoryPiecesPart.this.f62346d.y1(false);
            }
            if (VideoStoryPiecesPart.this.N != null) {
                VideoStoryPiecesPart.this.N.d(aECaptureMode);
            }
            if (aECaptureMode == aECaptureMode2) {
                VideoStoryPiecesPart.this.V.setVisibility(0);
                VideoStoryPiecesPart.this.H1();
                VideoStoryPiecesPart.this.V.setMaxDuration(VideoStoryPiecesPart.this.V0(aECaptureMode));
                VideoStoryPiecesPart.this.V.h(false);
                if (VideoStoryPiecesPart.this.X) {
                    VideoStoryPiecesPart.this.V.g(true, com.tencent.aelight.camera.ae.view.b.f65901x);
                }
                VideoStoryPiecesPart.this.V.setGifMode(false);
                if (VideoStoryPiecesPart.this.X && (N0 = VideoStoryPiecesPart.this.N0()) > 0 && (marginLayoutParams = (ViewGroup.MarginLayoutParams) VideoStoryPiecesPart.this.f62360m.getLayoutParams()) != null) {
                    marginLayoutParams.bottomMargin = N0;
                    VideoStoryPiecesPart.this.f62360m.setLayoutParams(marginLayoutParams);
                }
                if (VideoStoryPiecesPart.this.o1()) {
                    VideoStoryPiecesPart.this.L1(0);
                }
                VideoStoryPiecesPart.this.O1(true);
                if (VideoStoryPiecesPart.this.U != null) {
                    VideoStoryPiecesPart.this.U.c();
                    return;
                }
                return;
            }
            if (aECaptureMode == AECaptureMode.GIF) {
                VideoStoryPiecesPart.this.V.setVisibility(0);
                VideoStoryPiecesPart.this.V.setFunctionFlag(4);
                VideoStoryPiecesPart.this.V.setMaxDuration(VideoStoryPiecesPart.this.V0(aECaptureMode));
                VideoStoryPiecesPart.this.V.h(true);
                VideoStoryPiecesPart.this.V.setGifMode(true);
                if (VideoStoryPiecesPart.this.o1()) {
                    VideoStoryPiecesPart.this.L1(0);
                }
                VideoStoryPiecesPart.this.O1(true);
                VideoStoryPiecesPart.this.f62353h.O1();
                return;
            }
            if (aECaptureMode == AECaptureMode.PLAY) {
                VideoStoryPiecesPart.this.V.setVisibility(8);
                VideoStoryPiecesPart.this.L1(8);
                VideoStoryPiecesPart.this.O1(false);
                VideoStoryPiecesPart.this.R.setMaterial(null);
                return;
            }
            if (aECaptureMode == AECaptureMode.ARCAKE) {
                VideoStoryPiecesPart.this.V.setVisibility(0);
                VideoStoryPiecesPart.this.O1(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<AEVideoStoryTopBarViewModel.a> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a implements a.InterfaceC0568a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AEVideoStoryTopBarViewModel.a f62379a;

            a(AEVideoStoryTopBarViewModel.a aVar) {
                this.f62379a = aVar;
            }

            @Override // com.tencent.aelight.camera.aebase.view.a.InterfaceC0568a
            public void a() {
                if (VideoStoryPiecesPart.this.U != null) {
                    VideoStoryPiecesPart.this.U.e(this.f62379a.a(), false);
                }
                VideoStoryPiecesPart.this.V.setTouchEnable(false);
            }
        }

        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean b16 = aVar.b();
            if (b16) {
                VideoStoryPiecesPart.this.e1();
            } else if (VideoStoryPiecesPart.this.U != null) {
                VideoStoryPiecesPart.this.U.c();
            }
            VideoStoryPiecesPart.this.V.e(b16, new a(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            if (ratio == null) {
                return;
            }
            VideoStoryPiecesPart.this.W1(VideoStoryPiecesPart.U0(ratio));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (!bool.booleanValue()) {
                VideoStoryPiecesPart.this.L1(8);
                VideoStoryPiecesPart.this.O1(false);
                if (VideoStoryPiecesPart.this.f62349e0 != null) {
                    VideoStoryPiecesPart.this.f62349e0.setVisibility(8);
                }
                ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mPartManager.q(786434, new Object[0]);
                if (VideoStoryPiecesPart.this.f62347d0 != null) {
                    VideoStoryPiecesPart.this.f62347d0.setVisibility(8);
                }
            } else if (VideoStoryPiecesPart.this.f62348e.N1()) {
                VideoStoryPiecesPart.this.Q.setVisibility(0);
                VideoStoryPiecesPart.this.L1(8);
                VideoStoryPiecesPart.this.I1(false);
                VideoStoryPiecesPart.this.O1(false);
            } else if (VideoStoryPiecesPart.this.f62348e.O1()) {
                VideoStoryPiecesPart.this.Q.setVisibility(0);
                VideoStoryPiecesPart.this.I1(true);
                VideoStoryPiecesPart.this.O1(true);
                if (VideoStoryPiecesPart.this.o1()) {
                    VideoStoryPiecesPart.this.L1(0);
                }
                if (AEMaterialManager.R() && VideoStoryPiecesPart.this.f62349e0 != null) {
                    VideoStoryPiecesPart.this.f62349e0.setVisibility(0);
                }
                ((com.tencent.aelight.camera.ae.part.b) VideoStoryPiecesPart.this).mPartManager.q(786435, new Object[0]);
            } else if (VideoStoryPiecesPart.this.f62348e.P1()) {
                VideoStoryPiecesPart.this.Q.setVisibility(0);
                VideoStoryPiecesPart.this.L1(8);
                VideoStoryPiecesPart.this.O1(false);
                VideoStoryPiecesPart.this.I1(false);
            } else if (VideoStoryPiecesPart.this.f62348e.L1()) {
                VideoStoryPiecesPart.this.O1(true);
                VideoStoryPiecesPart.this.L1(8);
                VideoStoryPiecesPart.this.I1(false);
            }
            ms.a.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
            VideoStoryPiecesPart.this.Q0();
            VideoStoryPiecesPart.this.U1();
            if (!bool.booleanValue()) {
                ms.a.a("VideoStoryPiecesPart", "[BeautyTip]---clearBeautyTip when capturing");
                VideoStoryPiecesPart.this.R0();
            }
            VideoStoryPiecesPart.this.T1();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 327683:
                AEMaterialPanel aEMaterialPanel = this.L;
                if (aEMaterialPanel != null) {
                    if (objArr != null && objArr.length != 0) {
                        Object obj = objArr[0];
                        if (obj instanceof AEMaterialMetaData) {
                            AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) obj;
                            if (this.X) {
                                aEMaterialPanel.setVisibility(0);
                                this.L.s(aEMaterialMetaData.firstcategoryname, aEMaterialMetaData.f69050id, true);
                                this.f62355i.P1().postValue(Boolean.TRUE);
                            } else {
                                this.K.Q1(aEMaterialMetaData);
                            }
                        }
                    } else if (this.X) {
                        aEMaterialPanel.setVisibility(0);
                        this.L.s(null, null, false);
                        this.f62355i.P1().postValue(Boolean.TRUE);
                    } else {
                        this.K.Q1(null);
                    }
                }
                VSReporter.m("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
                return;
            case 327684:
                y1();
                return;
            case 327685:
                ao aoVar = this.N;
                if (aoVar != null) {
                    aoVar.a();
                    return;
                }
                return;
            case 327686:
                C1();
                return;
            case 327687:
                P0();
                return;
            case 327688:
                d1();
                return;
            default:
                switch (i3) {
                    case FileMsg.TRANSFILE_TYPE_ASSISTANT /* 327697 */:
                        B1();
                        return;
                    case FileMsg.TRANSFILE_TYPE_ZPLAN_UGC_DYEING /* 327698 */:
                        ms.a.f("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_START_UP_ANIM");
                        if (this.M != null) {
                            ms.a.a("VideoStoryPiecesPart", "doOpenProviderView");
                            this.M.q();
                            return;
                        }
                        return;
                    case FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT /* 327699 */:
                        ms.a.a("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_RED_DOT_SHOW");
                        if (objArr == null || objArr.length == 0 || !this.Y) {
                            return;
                        }
                        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                        ms.a.a("VideoStoryPiecesPart", "arcake : isShow" + booleanValue);
                        if (booleanValue) {
                            this.F.a().setImageResource(R.drawable.ive);
                            return;
                        } else {
                            this.F.a().setImageResource(R.drawable.ivd);
                            return;
                        }
                    case 327700:
                        D1();
                        return;
                    case 327701:
                        A1();
                        return;
                    case 327702:
                        z1();
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        if ((i3 == 10023 || i3 == 10006) && i16 == -1) {
            AEMaterialPanel aEMaterialPanel = this.L;
            if (aEMaterialPanel != null) {
                aEMaterialPanel.x(i3, i16, intent);
            } else if (QLog.isColorLevel()) {
                QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
            }
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements PAGView.PAGFlushListener {
        k() {
        }

        @Override // org.libpag.PAGView.PAGFlushListener
        public void onFlush() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
    }
}
