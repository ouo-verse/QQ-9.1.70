package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.aibeauty.AIBeautyFaceType;
import com.tencent.aelight.camera.ae.camera.core.AECameraBroadcastReceiver;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAELocalMaterialItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper;
import com.tencent.aelight.camera.ae.camera.ui.panel.ao;
import com.tencent.aelight.camera.ae.camera.ui.panel.at;
import com.tencent.aelight.camera.ae.camera.ui.panel.au;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.aelight.camera.ae.camera.ui.panel.br;
import com.tencent.aelight.camera.ae.camera.ui.panel.bv;
import com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEARCakeDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.dw;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.gif.a;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEGuideVideoUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.current.SessionWrap;
import fm2.a;
import fm2.c;
import fm2.e;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import or.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.bean.WMElement;
import org.light.listener.OnClickWatermarkListener;
import org.light.report.LightReportManager;
import pq.a;

/* loaded from: classes32.dex */
public class AEPituCameraUnit extends AEBaseCameraUnit implements m.c, AECameraGLSurfaceView.AEEffectListener, MediaScanner.OnMediaInfoScannerListener, AEFilterManager.MaterialInnerEffectListener, AEPituCameraCaptureButtonLayout.g, AEVideoStoryDashboardPart.r, View.OnTouchListener, View.OnClickListener {

    /* renamed from: s1, reason: collision with root package name */
    private static String f61829s1 = "{}";

    /* renamed from: t1, reason: collision with root package name */
    public static boolean f61830t1 = false;

    /* renamed from: u1, reason: collision with root package name */
    public static boolean f61831u1 = false;
    protected c.a A0;
    protected final AECameraGLSurfaceView.AEGLSurfaceListener B0;
    private AECameraBroadcastReceiver C0;
    protected boolean D0;
    protected int E0;
    protected int F0;
    private long G0;
    private long H0;
    private boolean I0;
    public boolean J0;
    private boolean K0;
    private CountDownLatch L0;
    private boolean M0;
    protected View N0;
    protected com.tencent.aelight.camera.ae.e O0;
    protected com.tencent.aelight.camera.ae.camera.ui.panel.t P0;
    protected AEMaterialPanel Q0;
    protected AEARCakePanel R0;
    private com.tencent.aelight.camera.ae.mode.c S0;
    private com.tencent.aelight.camera.ae.part.a T0;
    private ao U0;
    protected FilterPagerViewStubHolder V0;
    private AECompoundButton W0;
    private AECompoundButton X0;
    private ImageView Y0;
    private an Z0;

    /* renamed from: a1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.z f61832a1;

    /* renamed from: b1, reason: collision with root package name */
    private MusicSourceViewModel f61833b1;

    /* renamed from: c0, reason: collision with root package name */
    protected AEFilterManager f61834c0;

    /* renamed from: c1, reason: collision with root package name */
    private Runnable f61835c1;

    /* renamed from: d0, reason: collision with root package name */
    private int f61836d0;

    /* renamed from: d1, reason: collision with root package name */
    private OnClickWatermarkListener f61837d1;

    /* renamed from: e0, reason: collision with root package name */
    private int f61838e0;

    /* renamed from: e1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.simple.a f61839e1;

    /* renamed from: f0, reason: collision with root package name */
    private Bitmap f61840f0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f61841f1;

    /* renamed from: g0, reason: collision with root package name */
    private List<Runnable> f61842g0;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f61843g1;

    /* renamed from: h0, reason: collision with root package name */
    protected final AECameraManager.CameraManagerListener f61844h0;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f61845h1;

    /* renamed from: i0, reason: collision with root package name */
    private HashMap<String, String> f61846i0;

    /* renamed from: i1, reason: collision with root package name */
    private View f61847i1;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f61848j0;

    /* renamed from: j1, reason: collision with root package name */
    private h.a f61849j1;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f61850k0;

    /* renamed from: k1, reason: collision with root package name */
    public boolean f61851k1;

    /* renamed from: l0, reason: collision with root package name */
    private AETipsViewController f61852l0;

    /* renamed from: l1, reason: collision with root package name */
    private al f61853l1;

    /* renamed from: m0, reason: collision with root package name */
    protected fm2.e f61854m0;

    /* renamed from: m1, reason: collision with root package name */
    private AEBeautyProviderViewModel f61855m1;

    /* renamed from: n0, reason: collision with root package name */
    protected fm2.b f61856n0;

    /* renamed from: n1, reason: collision with root package name */
    private AEBodyProviderViewModel f61857n1;

    /* renamed from: o0, reason: collision with root package name */
    protected fm2.a f61858o0;

    /* renamed from: o1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.aa f61859o1;

    /* renamed from: p0, reason: collision with root package name */
    protected fm2.c f61860p0;

    /* renamed from: p1, reason: collision with root package name */
    private AEProviderViewModel f61861p1;

    /* renamed from: q0, reason: collision with root package name */
    protected pq.a f61862q0;

    /* renamed from: q1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.ac f61863q1;

    /* renamed from: r0, reason: collision with root package name */
    protected pq.b f61864r0;

    /* renamed from: r1, reason: collision with root package name */
    protected AEVideoStoryTopBarViewModel f61865r1;

    /* renamed from: s0, reason: collision with root package name */
    protected fm2.d f61866s0;

    /* renamed from: t0, reason: collision with root package name */
    protected GestureDetector f61867t0;

    /* renamed from: u0, reason: collision with root package name */
    protected AECaptureController f61868u0;

    /* renamed from: v0, reason: collision with root package name */
    protected com.tencent.aelight.camera.ae.part.c f61869v0;

    /* renamed from: w0, reason: collision with root package name */
    protected AEMaterialPanel.e f61870w0;

    /* renamed from: x0, reason: collision with root package name */
    protected AEARCakePanel.g f61871x0;

    /* renamed from: y0, reason: collision with root package name */
    protected a.InterfaceC10327a f61872y0;

    /* renamed from: z0, reason: collision with root package name */
    protected e.b f61873z0;

    /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements AECameraManager.CameraManagerListener {

        /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$1$2, reason: invalid class name */
        /* loaded from: classes32.dex */
        class AnonymousClass2 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AnonymousClass1 f61876d;

            @Override // java.lang.Runnable
            public void run() {
                AEPituCameraUnit.this.getClass();
                throw null;
            }
        }

        AnonymousClass1() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
        public void onCameraPreviewSizeChanged(int i3, int i16) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "onCameraPreviewSizeChanged---width=" + i3 + ", height=" + i16);
            AECameraGLSurfaceView aECameraGLSurfaceView = AEPituCameraUnit.this.E;
            if (aECameraGLSurfaceView != null) {
                aECameraGLSurfaceView.onCameraPreviewSizeChanged(i3, i16);
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
        public void onCameraPreviewStarted() {
            AECameraGLSurfaceView aECameraGLSurfaceView = AEPituCameraUnit.this.E;
            if (aECameraGLSurfaceView != null) {
                aECameraGLSurfaceView.onCameraPreviewStarted();
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
        public void onCameraReadyToPreview() {
            AEPituCameraUnit.this.r0();
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
        public void onCameraStarted(boolean z16, String str) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "onCameraStarted--success=" + z16 + ", errMsg=" + str);
            AEPituCameraUnit.this.w2(z16, str);
            if (z16) {
                tq.b.h().o("onCameraStart");
            }
            if (!z16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEPituCameraUnit.this.j0();
                    }
                });
            } else {
                AEPituCameraUnit.this.getClass();
            }
            AEPituCameraUnit.this.J2();
            AEPituCameraUnit.this.f61869v0.q(458753, new Object[0]);
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener
        public void onRetryOpenCamera() {
            ms.a.f(AEPituCameraUnit.this.f61816f, "onRetryOpenCamera|OpenCamera Error.need retry!");
            AEPituCameraUnit.this.f61815a0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.1.3

                /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$1$3$a */
                /* loaded from: classes32.dex */
                class a implements AECameraManager.CameraOpenCallback {
                    a() {
                    }

                    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
                    public void onOpenResult(int i3, boolean z16) {
                        ms.a.f(AEPituCameraUnit.this.f61816f, "onRetryOpenCamera post| tryStartPreview.");
                        AEPituCameraUnit.this.r0();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f(AEPituCameraUnit.this.f61816f, "onRetryOpenCamera post| will retry in the UI thread");
                    AEPituCameraUnit.this.f61819m.stopCamera(false);
                    AEPituCameraUnit.this.f61819m.openCamera(new a());
                }
            });
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$35, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass35 implements Runnable {
        final /* synthetic */ AEPituCameraUnit this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.h3();
        }
    }

    /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$36, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass36 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LazyLoadAnimationDrawable f61882d;
        final /* synthetic */ AEPituCameraUnit this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.Y0 == null) {
                this.this$0.Y0 = (ImageView) ((ViewStub) this.this$0.D.findViewById(R.id.s1b)).inflate().findViewById(R.id.ro9);
            }
            AEPituCameraUnit aEPituCameraUnit = this.this$0;
            aEPituCameraUnit.f61815a0.postDelayed(aEPituCameraUnit.f61835c1, this.f61882d.getTotalDuration());
            this.this$0.Y0.setVisibility(0);
            this.this$0.Y0.setImageDrawable(this.f61882d);
            this.f61882d.start();
        }
    }

    /* loaded from: classes32.dex */
    class aa implements e.b {
        aa() {
        }

        @Override // fm2.e.b
        public void a(float f16) {
            ms.a.a(AEPituCameraUnit.this.f61816f, "onRequestZoom: " + f16);
            AEPituCameraUnit.this.f61819m.setZoom(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ab implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private int f61898d = 0;

        ab() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3 = this.f61898d + 1;
            this.f61898d = i3;
            if (i3 > 1) {
                ViewTreeObserver viewTreeObserver = AEPituCameraUnit.this.N0.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            com.tencent.aelight.camera.ae.util.h.e(new com.tencent.mobileqq.activity.richmedia.i(AEPituCameraUnit.this.N0.getMeasuredWidth(), AEPituCameraUnit.this.N0.getMeasuredHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ac implements Observer<SeekBarOpDataWrapper> {
        ac() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(SeekBarOpDataWrapper seekBarOpDataWrapper) {
            if (AEPituCameraUnit.this.G1() && seekBarOpDataWrapper != null) {
                if (!seekBarOpDataWrapper.getRefreshEffect()) {
                    ms.a.f(AEPituCameraUnit.this.f61816f, "not refresh effect");
                    return;
                }
                int type = seekBarOpDataWrapper.getType();
                Object opData = seekBarOpDataWrapper.getOpData();
                if (type != 2) {
                    if (type == 4 && (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b)) {
                        com.tencent.aelight.camera.ae.camera.ui.panel.b bVar = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
                        ms.a.a(AEPituCameraUnit.this.f61816f, "bodySelected: " + bVar.getKey());
                        if (bVar.getType() == BeautyRealConfig.TYPE.NONE) {
                            if (bVar.getEnable()) {
                                AEPituCameraUnit.this.k3();
                                return;
                            } else {
                                AEPituCameraUnit.this.C1();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
                    com.tencent.aelight.camera.ae.camera.ui.panel.b bVar2 = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
                    ms.a.a(AEPituCameraUnit.this.f61816f, "beautySelected: " + bVar2.getKey());
                    if (!bVar2.i().isEmpty()) {
                        AEPituCameraUnit.this.t3(bVar2, false);
                    } else if (bVar2.getType() == BeautyRealConfig.TYPE.NONE) {
                        if (bVar2.getEnable()) {
                            AEPituCameraUnit.this.j3();
                        } else {
                            AEPituCameraUnit.this.B1();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ad implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        ad() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (AEPituCameraUnit.this.G1()) {
                AEPituCameraUnit.this.j3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ae implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        ae() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (AEPituCameraUnit.this.G1()) {
                AEPituCameraUnit.this.k3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class af implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        af() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (AEPituCameraUnit.this.G1()) {
                AEPituCameraUnit.this.k3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ag implements Observer<Boolean> {
        ag() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "AiBeautyToggle---onChanged: " + bool);
            if (bool != null) {
                AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, bool.booleanValue(), 0);
                AEPituCameraUnit.this.E.switchAIBeauty(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ah implements DialogInterface.OnDismissListener {
        ah() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AEPituCameraUnit.this.V1();
            com.tencent.aelight.camera.ae.report.b.b().J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class ai {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f61906a;

        static {
            int[] iArr = new int[BeautyRealConfig.TYPE.values().length];
            f61906a = iArr;
            try {
                iArr[BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61906a[BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61906a[BeautyRealConfig.TYPE.FACE_FEATURE_SOFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61906a[BeautyRealConfig.TYPE.FACTOR_THIN_NEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes32.dex */
    class aj implements c.a {
        aj() {
        }

        @Override // fm2.c.a
        public void onDoubleTap() {
            AEPituCameraUnit.this.o0();
        }
    }

    /* loaded from: classes32.dex */
    class ak implements AECameraGLSurfaceView.AEGLSurfaceListener {
        ak() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onBasicBeautyDownload() {
            AEPituCameraUnit.this.J2();
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onDrawFrameWithEffect(int i3, AEFilterManager aEFilterManager) {
            AEPituCameraUnit.this.u2(i3, aEFilterManager);
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onFirstFrameDone() {
            tq.b.h().o("onFirstFrameDone");
            AEPituCameraUnit.this.n1();
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onOrientionChanged(int i3) {
            AEPituCameraUnit.this.f61819m.setActivityOrientation(i3);
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onPreviewSizeChanged(int i3, int i16, int i17, int i18) {
            AEPituCameraUnit.this.f61819m.setFocusOperatorMatrix(i3, i16, i17, i18);
            AEPituCameraUnit.this.v2(i3, i16, i17, i18);
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onPreviewSurfaceTextureCreate(SurfaceTexture surfaceTexture) {
            AEPituCameraUnit.this.I = surfaceTexture;
            ms.a.f(AEPituCameraUnit.this.f61816f, "onPreviewSurfaceTextureCreate---" + AEPituCameraUnit.this.I);
            AEPituCameraUnit.this.r0();
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener
        public void onPreviewSurfaceTextureRelease() {
            ms.a.f(AEPituCameraUnit.this.f61816f, "onPreviewSurfaceTextureRelease---" + AEPituCameraUnit.this.I);
            AEPituCameraUnit.this.I = null;
        }
    }

    /* loaded from: classes32.dex */
    private interface al {
        void callback();
    }

    /* loaded from: classes32.dex */
    public static class am implements h.a {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<AEPituCameraUnit> f61909d;

        public am(AEPituCameraUnit aEPituCameraUnit) {
            this.f61909d = new WeakReference<>(aEPituCameraUnit);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.util.h.a
        public void c(boolean z16) {
            AEPituCameraUnit aEPituCameraUnit = this.f61909d.get();
            if (aEPituCameraUnit == null) {
                ms.a.f("PituDarkModeListener", "changeDarkModeStatus, AEPituCameraUnit is null");
            } else {
                aEPituCameraUnit.c(z16);
            }
        }
    }

    /* loaded from: classes32.dex */
    public static class an extends ViewModel {

        /* renamed from: i, reason: collision with root package name */
        public final MutableLiveData<ao> f61910i = new MutableLiveData<>();

        /* renamed from: m, reason: collision with root package name */
        public final MutableLiveData<FilterPagerViewStubHolder> f61911m = new MutableLiveData<>();
    }

    /* loaded from: classes32.dex */
    class b implements QQPermissionCallback {
        b() {
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            AEPituCameraUnit.this.k0();
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            AEPituCameraUnit.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends SimpleObserver<fs.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f61913a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f61914b;

        c(String str, String str2) {
            this.f61913a = str;
            this.f61914b = str2;
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(fs.b bVar) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "generate observer --- onNext");
            AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
            aEPituCameraUnit.p2(aEPituCameraUnit.z(), this.f61913a, this.f61914b, bVar.f400396m);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onCancel() {
            ms.a.f(AEPituCameraUnit.this.f61816f, "generate observer --- onCancel");
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onComplete() {
            ms.a.f(AEPituCameraUnit.this.f61816f, "generate observer --- onComplete");
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            ms.a.d(AEPituCameraUnit.this.f61816f, "generate observer --- onError", error);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<String> {
        e() {
        }

        private String a() {
            com.tencent.aelight.camera.ae.r value = AEPituCameraUnit.this.O0.P1().getValue();
            if (value == null || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
                return null;
            }
            return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f69050id;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            String a16 = a();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(a16) || !str.contains(a16)) {
                return;
            }
            AEPituCameraUnit.this.e3(str, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<Pair<String, String>> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Pair<String, String> pair) {
            AECameraGLSurfaceView aECameraGLSurfaceView = AEPituCameraUnit.this.E;
            if (aECameraGLSurfaceView == null || pair == null) {
                return;
            }
            aECameraGLSurfaceView.setLightNodePresetData(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements Observer<bj> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bj bjVar) {
            if (AEPituCameraUnit.this.G1() && bjVar.getEnable()) {
                if (bjVar instanceof DYAELocalMaterialItem) {
                    AEPituCameraUnit.this.E.setMaterial(((DYAELocalMaterialItem) bjVar).getPath());
                    return;
                }
                if (bjVar instanceof br) {
                    AEMaterialMetaData material = ((br) bjVar).getMaterial();
                    AEPituCameraUnit.this.E.setLastForceMaterialPath(material.getLocalPath());
                    com.tencent.aelight.camera.ae.e eVar = AEPituCameraUnit.this.O0;
                    if (eVar != null) {
                        eVar.S1(1, material);
                    }
                    VideoReport.setPageParams(AEPituCameraUnit.this.z(), "ae_cosmetic_id", material.f69050id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            ms.a.f(AEPituCameraUnit.this.f61816f, " mCurrentRatio---onChanged: ratio=" + ratio);
            if (ratio == null) {
                return;
            }
            VideoReport.setPageParams(AEPituCameraUnit.this.z(), "ae_ratio", ratio.toString());
            AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
            if (aEPituCameraUnit.T == ratio) {
                return;
            }
            aEPituCameraUnit.T = ratio;
            AECameraPrefsUtil.f().n(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, ratio.code, 0);
            AEPituCameraUnit.this.E.setCurrentRatio(ratio);
            AEPituCameraUnit aEPituCameraUnit2 = AEPituCameraUnit.this;
            if (aEPituCameraUnit2.U == AECaptureMode.NORMAL) {
                aEPituCameraUnit2.l0();
                AEPituCameraUnit.this.r0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements Observer<Boolean> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "getCapturingLiveData--isCapturing=" + bool);
            AEMaterialManager.f63518v = bool.booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements Observer<Boolean> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(AEPituCameraUnit.this.f61816f, "getWaterMarkPanelVisibleLiveData--isShow=" + bool);
            AEPituCameraUnit.this.f61841f1 = Boolean.TRUE.equals(bool);
            AEPituCameraUnit.this.z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements Observer<Boolean> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AEPituCameraUnit.this.f61843g1 = Boolean.TRUE.equals(bool);
            AEPituCameraUnit.this.z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class n implements Observer<Boolean> {
        n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AEPituCameraUnit.this.f61845h1 = Boolean.TRUE.equals(bool);
            AEPituCameraUnit.this.z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class o implements Observer<bv> {
        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bv bvVar) {
            if (bvVar.getShow()) {
                AEPituCameraUnit.this.T0.P1().postValue(Boolean.TRUE);
            } else {
                AEPituCameraUnit.this.T0.P1().postValue(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class p implements Observer<MusicInfoWrapper> {
        p() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(MusicInfoWrapper musicInfoWrapper) {
            if (musicInfoWrapper.getMusicInfo() == null) {
                AEPituCameraUnit.this.E.setAudioStart();
            } else {
                AEPituCameraUnit.this.E.setAudioPause();
            }
        }
    }

    /* loaded from: classes32.dex */
    class q implements AEARCakePanel.g {
        q() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.g
        public void a(AEMaterialMetaData aEMaterialMetaData) {
            ms.a.a(AEPituCameraUnit.this.f61816f, "arcake onMaterialSelected" + aEMaterialMetaData);
            com.tencent.aelight.camera.ae.e eVar = AEPituCameraUnit.this.O0;
            if (eVar != null) {
                eVar.S1(3, aEMaterialMetaData);
            }
        }
    }

    /* loaded from: classes32.dex */
    class r implements a.InterfaceC10327a {
        r() {
        }

        @Override // fm2.a.InterfaceC10327a
        public void a(MotionEvent motionEvent) {
            AEPituCameraUnit.this.H1();
            AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
            if (aEPituCameraUnit.H == null || aEPituCameraUnit.f61819m.isFrontCamera()) {
                return;
            }
            AEPituCameraUnit.this.H.c(motionEvent);
            AEPituCameraUnit.this.f61819m.requestCameraFocus(motionEvent.getX(), motionEvent.getY(), AEPituCameraUnit.this.E.getSurfaceWidth(), AEPituCameraUnit.this.E.getSurfaceHeight());
            if (ms.a.g()) {
                ms.a.a(AEPituCameraUnit.this.f61816f, "CameraFocusGesture isRecording == false");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class u implements a.InterfaceC11035a {
        u() {
        }

        @Override // pq.a.InterfaceC11035a
        public void a() {
            AEPituCameraUnit.this.f61819m.refreshDarkModeTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class v implements a.b {
        v() {
        }

        @Override // pq.a.b
        public void a() {
            AEPituCameraUnit.this.P0.L1();
        }
    }

    /* loaded from: classes32.dex */
    class w implements AEFilterProcessTex.d {
        w() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.d
        public void a(List<Integer> list, List<Integer> list2) {
            ms.a.a(AEPituCameraUnit.this.f61816f, "AIBeauty---first get face data: genderList=" + list + "\nageList=" + list2);
            if (list == null || list2 == null || list.size() != list2.size() || list.size() <= 0 || list.get(0).intValue() == 0) {
                return;
            }
            AEPituCameraUnit.this.N2(list, list2);
            if (AEPituCameraUnit.this.G1()) {
                AEPituCameraUnit.this.W1(list, list2);
            }
        }
    }

    /* loaded from: classes32.dex */
    class x implements a.b {
        x() {
        }

        @Override // com.tencent.aelight.camera.ae.gif.a.b
        public void a(com.tencent.aelight.camera.ae.gif.c cVar) {
            com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().postValue(cVar);
        }
    }

    /* loaded from: classes32.dex */
    class y implements AEBottomListScrollView.a {
        y() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.a
        public void f(boolean z16) {
            com.tencent.aelight.camera.ae.part.c cVar = AEPituCameraUnit.this.f61869v0;
            if (cVar != null) {
                if (z16) {
                    cVar.q(FileMsg.TRANSFILE_TYPE_PTT_SLICE_TO_TEXT, new Object[0]);
                } else {
                    cVar.q(FileMsg.TRANSFILE_TYPE_LIGHT_VIDEO, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes32.dex */
    class z implements AECameraGLSurfaceView.AEGenderTypeListener {
        z() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGenderTypeListener
        public void onGenderTypeListener(int i3) {
            if (i3 != GenderType.DEFAULT.value) {
                AEPituCameraUnit.this.f61832a1.L1().postValue(Integer.valueOf(i3));
            }
        }
    }

    public AEPituCameraUnit() {
        this.f61840f0 = null;
        this.f61844h0 = new AnonymousClass1();
        this.f61848j0 = false;
        this.f61850k0 = false;
        this.f61870w0 = new m();
        this.f61871x0 = new q();
        this.f61872y0 = new r();
        this.f61873z0 = new aa();
        this.A0 = new aj();
        this.B0 = new ak();
        this.C0 = new AECameraBroadcastReceiver(this);
        this.D0 = false;
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = 0L;
        this.H0 = -1L;
        this.I0 = false;
        this.K0 = false;
        this.L0 = new CountDownLatch(1);
        this.M0 = false;
        this.f61849j1 = new am(this);
        this.f61851k1 = false;
        ms.a.f(this.f61816f, "[AEPituCameraUnit] + BEGIN");
        ms.a.a(this.f61816f, "unitConstructor--fake");
        ms.a.f(this.f61816f, "[AEPituCameraUnit] + END");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f61855m1.U1().getValue();
        if (value == null) {
            ms.a.c(this.f61816f, "clearBeautyEffect error viewModels null.");
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            this.E.setBeautyOrTransformLevel(it.next().getType(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f61857n1.S1().getValue();
        if (value == null) {
            ms.a.c(this.f61816f, "clearBeautyEffect error viewModels null.");
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            this.E.setBeautyOrTransformLevel(it.next().getType(), 0);
        }
    }

    private int D1(int i3) {
        return i3 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        if (this.f61850k0) {
            this.f61850k0 = false;
            AEMaterialMetaData H = AEMaterialManager.H();
            if (H == null || H.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                ms.a.f(this.f61816f, "AIBeauty---dismissAIBeautyTipMaterial, reset original material");
                this.f61868u0.v(AEMaterialManager.H());
            }
        }
    }

    private void F2() {
        com.tencent.qqcamerakit.common.e.g(wq.a.a());
    }

    private void G2(String str, String str2) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMimeType = "pic";
        EditVideoParams editVideoParams = new EditVideoParams(-1, 1387, new EditLocalPhotoSource(str, localMediaInfo), null);
        fs.b bVar = new fs.b(editVideoParams);
        bVar.f400399p = fs.s.b(2);
        bVar.f400395l = new fs.g(editVideoParams.f204059i.getSourcePath());
        bVar.f400387d.thumbPath = str;
        Stream.of(bVar).map(new ThreadOffFunction(this.f61816f, 2)).map(new fs.t(editVideoParams)).subscribe(R1(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        ViewStub viewStub;
        if (this.H != null || (viewStub = this.G) == null) {
            return;
        }
        this.H = (CameraFocusView) viewStub.inflate();
    }

    private void H2(String str, String str2, long j3) {
        ms.a.f(this.f61816f, "publishVideoToAioChat---path=" + str + ", widgetInfo=" + str2 + ", duration=" + j3);
        Activity z16 = z();
        if (TextUtils.isEmpty(str) || j3 <= 0) {
            return;
        }
        Intent intent = new Intent(z16, (Class<?>) SendVideoActivity.class);
        intent.putExtra("file_send_path", str);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, new File(str).length());
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j3);
        intent.putExtra("uin", this.W.q().f394447d);
        intent.putExtra("uintype", this.W.q().f394449f);
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, "album");
        intent.putExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, false);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str2);
        }
        z16.startActivity(intent);
        z16.finish();
    }

    private String J1() {
        if (Q()) {
            return AECameraPrefsUtil.f().j(AECameraConstants.CIRCLE_CAMERA_AD_ACTIVITY_ID, "", 4);
        }
        return AECameraPrefsUtil.f().j(AECameraConstants.CAMERA_AD_ACTIVITY_ID, "", 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        if (G1() && this.f61861p1 != null) {
            j3();
            k3();
            boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, true, 0);
            this.f61861p1.J2(c16);
            ms.a.f(this.f61816f, "toggleAiBeauty on camera start: " + c16);
        } else {
            int m3 = AEBeautyProviderView.m();
            int n3 = AEBeautyProviderView.n();
            this.f61868u0.t(m3);
            this.f61868u0.w(n3);
        }
        AECameraGLSurfaceView aECameraGLSurfaceView = this.E;
        if (aECameraGLSurfaceView != null) {
            aECameraGLSurfaceView.recoveryMaterial();
        }
    }

    private void K2() {
        or.e eVar;
        if (this.f61847i1 != null && (eVar = this.f61817h) != null) {
            if (eVar.getActivity() == null || !gq.a.r(this.f61817h.getActivity().getIntent())) {
                return;
            }
            VideoReport.setPageId(this.f61847i1, QCircleDaTongConstant.PageId.PG_XSJ_SHOOTING_PAGE);
            VideoReport.setPageParams(this.f61847i1, new QCircleDTParamBuilder().buildPageParams(this.f61816f));
            ms.a.f(this.f61816f, "reportDaTongRegister  subPage: " + this.f61816f);
            return;
        }
        ms.a.c(this.f61816f, "reportDaTongRegister  view == null || mContainer == null");
    }

    private long L1() {
        long j3;
        try {
            j3 = Utils.z();
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = Long.MAX_VALUE;
        }
        long j16 = j3 >>> 20;
        ms.a.a(this.f61816f, "available size = " + j16 + "M");
        return j16 / 30;
    }

    private void L2() {
        com.tencent.aelight.camera.ae.a aVar = this.W;
        if (aVar == null || aVar.q() == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800BFED", "0X800BFED", com.tencent.aelight.camera.ae.camera.ui.simple.d.b(this.W.q().f394449f), 0, "", "", String.valueOf(com.tencent.aelight.camera.ae.camera.ui.simple.d.a(this.W.k())), "");
    }

    private int M1(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        if (bVar.i().isEmpty()) {
            return AEProviderViewModel.t2(bVar);
        }
        return AEProviderViewModel.t2(bVar.i().get(AEProviderViewModel.z2(bVar)));
    }

    private void M2(String str, long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cameraSourceType", "QQGYCameraSourceTypeAIO");
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        hashMap.put("cameraShootType", str);
        com.tencent.aelight.camera.ae.report.b.b().u(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(List<Integer> list, List<Integer> list2) {
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < list.size(); i3++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ai_beauty_gender", list.get(i3));
                jSONObject.put("ai_beauty_age", list2.get(i3));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            jSONArray.mo162put(jSONObject);
        }
        String jSONArray2 = jSONArray.toString();
        ms.a.f(this.f61816f, "setAiBeautyFaceInfo: " + jSONArray2);
        AEBaseReportParam.U().A0(jSONArray2);
        com.tencent.aelight.camera.ae.report.b.b().m1();
    }

    private AECaptureMode P1(AECaptureMode[] aECaptureModeArr, int i3) {
        boolean z16;
        String stringExtra = z().getIntent().getStringExtra(IAECameraUnit.KEY_CURRENT_TAB);
        if (TextUtils.isEmpty(stringExtra)) {
            int intExtra = z().getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, -1);
            if (i3 == 201 && js.a.f410906f.b() == intExtra) {
                return AECaptureMode.NORMAL;
            }
            stringExtra = (i3 == 204 && gq.a.g(intExtra)) ? AECameraPrefsUtil.f().j(AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY, "", 4) : null;
        }
        AECaptureMode fromName = AECaptureMode.fromName(stringExtra);
        if (fromName != null) {
            for (AECaptureMode aECaptureMode : aECaptureModeArr) {
                if (aECaptureMode == fromName) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            ms.a.c(this.f61816f, "[getFirstModeAccordingABTest], get invalid mode=" + fromName);
            fromName = aECaptureModeArr[0];
        }
        ms.a.f(this.f61816f, "[getFirstModeAccordingABTest], ABTest name=" + stringExtra + ", real picked mode=" + fromName);
        return fromName;
    }

    private void Q2(AEPhotoCaptureResult aEPhotoCaptureResult) {
        int n3 = this.W.n();
        if (n3 != -2) {
            if (n3 != 0) {
                if (n3 == 1) {
                    this.P.e(new b.a(this.f61819m.getSelectedCamera()).m(this.W.q()).k(this.W.a()).l(1).j());
                    this.f61869v0.q(262148, aEPhotoCaptureResult, this.P, this.W.h());
                    return;
                } else if (n3 == 2) {
                    this.f61869v0.q(262148, aEPhotoCaptureResult, this.W.h(), Integer.valueOf(this.W.c()));
                    return;
                } else if (n3 != 3) {
                    ms.a.c(this.f61816f, "sendPhotoEndByConfig---unknown type: " + n3);
                    return;
                }
            }
            this.f61869v0.q(262148, aEPhotoCaptureResult);
            return;
        }
        this.f61869v0.q(262148, aEPhotoCaptureResult);
    }

    private SimpleObserver<fs.b> R1(String str, String str2) {
        return new c(str, str2);
    }

    private void R2(AEPhotoCaptureResult aEPhotoCaptureResult) {
        Intent intent = z().getIntent();
        if (gq.a.r(intent)) {
            this.f61869v0.q(262148, aEPhotoCaptureResult);
            return;
        }
        if (!gq.a.l(intent) && !gq.a.j(intent) && !gq.a.y(intent)) {
            if (gq.a.i(intent)) {
                n3(true);
                this.f61869v0.q(262148, aEPhotoCaptureResult, this.P, Integer.valueOf(this.V));
                return;
            } else {
                this.f61869v0.q(262148, aEPhotoCaptureResult, this.W.h(), 14);
                return;
            }
        }
        this.P.e(new b.a(this.f61819m.getSelectedCamera()).m(this.W.q()).k(this.W.a()).l(1).n(intent.getIntExtra("qq_sub_business_id", -1)).j());
        this.f61869v0.q(262148, aEPhotoCaptureResult, this.P, Integer.valueOf(this.V));
    }

    private String T1() {
        return os.a.f423933a.d(AECameraConstants.CAMERA_AD_PENDANT_ACTIVITY_ID, "");
    }

    private int U1() {
        int d16 = com.tencent.aelight.camera.ae.util.h.d();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(z());
        int dimensionPixelSize = z().getResources().getDimensionPixelSize(R.dimen.f13189h);
        if (d16 == 1) {
            String str = this.f61816f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getSurfaceTopMargin] long screen:");
            int i3 = statusBarHeight + dimensionPixelSize;
            sb5.append(i3);
            ms.a.a(str, sb5.toString());
            return i3;
        }
        ms.a.a(this.f61816f, "[getSurfaceTopMargin]:0");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        com.tencent.aelight.camera.ae.e eVar = this.O0;
        if (eVar != null) {
            eVar.X1(QQWinkConstants.MATERIAL_GUIDE_OVER, "{}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(List<Integer> list, List<Integer> list2) {
        if (this.f61848j0) {
            return;
        }
        this.f61848j0 = true;
        AIBeautyFaceType aIBeautyFaceType = AIBeautyFaceType.NO_FACE;
        com.tencent.aelight.camera.ae.camera.aibeauty.c cVar = com.tencent.aelight.camera.ae.camera.aibeauty.c.f62199a;
        if (cVar.c(list2)) {
            ms.a.f(this.f61816f, "AIBeauty---child");
            aIBeautyFaceType = AIBeautyFaceType.CHILD;
            if (x1() && !cVar.f()) {
                r1();
            }
        } else if (cVar.e(list)) {
            ms.a.f(this.f61816f, "AIBeauty---male");
            aIBeautyFaceType = AIBeautyFaceType.MALE;
            if (x1() && !cVar.g()) {
                r1();
            }
        } else if (cVar.d(list)) {
            ms.a.f(this.f61816f, "AIBeauty---female");
            aIBeautyFaceType = AIBeautyFaceType.FEMALE;
        }
        ((com.tencent.aelight.camera.ae.camera.aibeauty.d) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.aibeauty.d.class)).M1(aIBeautyFaceType);
        if (aIBeautyFaceType != AIBeautyFaceType.FEMALE) {
            com.tencent.aelight.camera.ae.report.b.b().D0();
        }
    }

    private void X1(HashMap<String, String> hashMap) {
        String str;
        String str2;
        ao aoVar = this.U0;
        if (!(aoVar != null && aoVar.c())) {
            ms.a.a(this.f61816f, "BeautyBody---panel not open");
            return;
        }
        AEProviderViewModel aEProviderViewModel = this.f61861p1;
        if (aEProviderViewModel == null) {
            return;
        }
        Integer value = aEProviderViewModel.C2().getValue();
        ms.a.a(this.f61816f, "BeautyBody---panel tab at " + value);
        if (value == null || value.intValue() != 3 || (str = hashMap.get("lightAsset.process.key")) == null || !str.equals("lightAsset.process.beautybody") || (str2 = hashMap.get("lightAsset.process.beautybody.error")) == null) {
            return;
        }
        try {
            Integer decode = Integer.decode(str2);
            AEFilterProcessTex.u0(decode.intValue());
            int intValue = decode.intValue();
            if (intValue != 0) {
                switch (intValue) {
                    case 10001:
                        onShowNormalTip("\u7f8e\u4f53\u6548\u679c\u53ea\u652f\u6301\u5355\u4eba\u54e6\uff01", null, 60000);
                        break;
                    case 10002:
                    case 10003:
                    case 10004:
                    case 10005:
                    case 10006:
                        onShowNormalTip("\u672a\u8bc6\u522b\u5230\u8eab\u4f53\uff0c\u8bf7\u5168\u8eab\u5165\u955c\u54e6\uff01", null, 60000);
                        break;
                }
            } else {
                onHideNormalTip();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3() {
        if (!l2() || AEGiftMaterialConfigParser.f63512c) {
            return;
        }
        this.f61852l0.t();
    }

    private void d3() {
        boolean z16 = this.f61817h.getActivity().checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
        LinkedList linkedList = new LinkedList();
        if (z16) {
            linkedList.add(QQPermissionConstants.Permission.CAMERA);
            ms.a.f(this.f61816f, "\u3010Camera Permission\u3011denied");
        }
        final String permissionWording = DialogUtil.getPermissionWording((String[]) linkedList.toArray(new String[0]));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.43

            /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$43$a */
            /* loaded from: classes32.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ms.a.f(AEPituCameraUnit.this.f61816f, "PermissionDialog--onClick which=" + i3);
                    Activity activity = AEPituCameraUnit.this.f61817h.getActivity();
                    if (i3 == 1) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivity(intent);
                    } else if (!AEPituCameraUnit.this.R()) {
                        activity.finish();
                    }
                    dialogInterface.dismiss();
                }
            }

            /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$43$b */
            /* loaded from: classes32.dex */
            class b implements DialogInterface.OnCancelListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    ms.a.f(AEPituCameraUnit.this.f61816f, "PermissionDialog--onCancel");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                DialogUtil.showPermissionSettingDialog(AEPituCameraUnit.this.f61817h.getActivity(), null, permissionWording, aVar, aVar, new b());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        if (this.W.k() != js.a.A.b()) {
            String stringExtra = z().getIntent().getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID);
            if (js.a.e(this.W.k()).c()) {
                AEBaseReportParam.U().O0(this.W.k(), stringExtra);
            }
            AEBaseReportParam.U().s1(z().getIntent().getStringExtra("intent_key_uid_for_report"));
            AEBaseReportParam.U().d1(true);
            AEBaseReportParam.U().g1();
            AEBaseReportParam.U().h1();
            AEBaseReportParam.U().p1(com.tencent.aelight.camera.ae.config.b.e());
            AEBaseReportParam.U().E0(dr.c.b());
        }
        com.tencent.aelight.camera.ae.report.b.b().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c(this.f61816f, "showVideoGuid| video path is null.");
            return;
        }
        if (AEGuideVideoUtil.b().c(QQWinkConstants.MATERIAL_GUIDED, str2)) {
            ms.a.f(this.f61816f, "showVideoGuid| video guid has showed.");
            V1();
            return;
        }
        dw dwVar = new dw(z(), str);
        dwVar.setCanceledOnTouchOutside(false);
        dwVar.setOnDismissListener(new ah());
        dwVar.show();
        AEGuideVideoUtil.b().d(QQWinkConstants.MATERIAL_GUIDED, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        if (js.a.Q.d(this.W.k())) {
            ms.a.a(this.f61816f, "simple capture ui handle");
            View findViewById = this.D.findViewById(R.id.rpt);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = this.D.findViewById(R.id.ru9);
            if (findViewById2 != null && (findViewById2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams.addRule(2, 0);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = (int) findViewById2.getResources().getDimension(R.dimen.bb6);
                layoutParams.height = (int) findViewById2.getResources().getDimension(R.dimen.bb5);
                findViewById2.setLayoutParams(layoutParams);
            }
            ReportController.o(null, "dc00898", "", "", "0X800BFF0", "0X800BFF0", com.tencent.aelight.camera.ae.camera.ui.simple.d.b(this.W.q().f394449f), 0, "", "", "", "");
        }
    }

    private void i2() {
        rs.b.c().d(this.W.k());
        LightReportManager.setReporter(rs.b.c());
        ms.a.f(this.f61816f, "initReporterForLightSdk---success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f61855m1.U1().getValue();
        if (value == null) {
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            p3(it.next(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f61857n1.S1().getValue();
        if (value == null) {
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            p3(it.next(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        AECameraManager aECameraManager = this.f61819m;
        if (aECameraManager != null) {
            float horizontalViewAngle = aECameraManager.getHorizontalViewAngle();
            int D1 = D1(this.f61819m.getSelectedCamera());
            if (D1 != 0 && D1 != 1) {
                D1 = 0;
            }
            if (horizontalViewAngle != -1.0f) {
                this.E.updateCameraDeviceConfig(horizontalViewAngle, D1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(Activity activity, String str, String str2, PublishParam publishParam) {
        Intent aliasIntent = SplashActivity.getAliasIntent(z());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        aliasIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        aliasIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
        aliasIntent.putExtra(PeakConstants.SEND_FLAG, true);
        aliasIntent.putExtra(PublishParam.Z, publishParam);
        aliasIntent.addFlags(603979776);
        aliasIntent.putExtra("open_chatfragment", true);
        aliasIntent.putExtra("open_chatfragment_fromphoto", true);
        if (!TextUtils.isEmpty(str2)) {
            aliasIntent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str2);
        }
        aliasIntent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1050);
        String stringExtra = aliasIntent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        ms.a.f(this.f61816f, "send photo---takeSameName=" + stringExtra);
        aliasIntent.putExtra("uin", this.W.q().f394447d);
        aliasIntent.putExtra("uintype", this.W.q().f394449f);
        activity.startActivity(aliasIntent);
        activity.finish();
    }

    private void p3(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar, boolean z16) {
        int M1 = M1(bVar);
        if (ms.a.h()) {
            ms.a.a(this.f61816f, "beautyData = " + bVar.getKey() + ", adjustValue = " + M1);
        }
        if (!bVar.i().isEmpty()) {
            t3(bVar, z16);
        }
        AECameraGLSurfaceView aECameraGLSurfaceView = this.E;
        BeautyRealConfig.TYPE type = bVar.getType();
        if (!bVar.getEnable()) {
            M1 = 0;
        }
        aECameraGLSurfaceView.setBeautyOrTransformLevel(type, M1);
    }

    private void r1() {
        com.tencent.aelight.camera.ae.camera.aibeauty.c cVar = com.tencent.aelight.camera.ae.camera.aibeauty.c.f62199a;
        boolean h16 = cVar.h();
        ms.a.f(this.f61816f, "AIBeauty---applyAIBeautyTipMaterial, exists=" + h16);
        if (h16) {
            this.f61850k0 = true;
            this.f61868u0.v(cVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2() {
        if (TextUtils.isEmpty(DYAEFilterProviderView.L())) {
            return;
        }
        this.E.updateLutAlpha(AEProviderViewModel.w2(r0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(Runnable runnable) {
        if (this.K0) {
            runnable.run();
            return;
        }
        if (this.f61842g0 == null) {
            this.f61842g0 = new ArrayList();
        }
        this.f61842g0.add(runnable);
    }

    private boolean x1() {
        AEMaterialMetaData H = AEMaterialManager.H();
        if (H != null && !H.equals(AEMaterialMetaData.MATERIAL_NONE)) {
            ms.a.f(this.f61816f, "AIBeauty---check fail, material state wrong");
            return false;
        }
        AECaptureMode aECaptureMode = this.U;
        if (aECaptureMode != null && aECaptureMode == AECaptureMode.NORMAL) {
            AEProviderViewModel aEProviderViewModel = this.f61861p1;
            if (aEProviderViewModel == null) {
                ms.a.f(this.f61816f, "AIBeauty---check fail, mAEProviderViewModel is null");
                return false;
            }
            Boolean value = aEProviderViewModel.u2().getValue();
            if (value != null && value.booleanValue()) {
                com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = this.f61859o1;
                if (aaVar == null) {
                    ms.a.f(this.f61816f, "AIBeauty---check fail, mCosmeticViewModel is null");
                    return false;
                }
                bj value2 = aaVar.N1().getValue();
                if (value2 != null && !bk.a(value2)) {
                    ms.a.f(this.f61816f, "AIBeauty---check fail, cosmetic state wrong");
                    return false;
                }
                AEBeautyProviderViewModel aEBeautyProviderViewModel = this.f61855m1;
                if (aEBeautyProviderViewModel == null) {
                    ms.a.f(this.f61816f, "AIBeauty---check fail, mBeautyViewModel is null");
                    return false;
                }
                com.tencent.aelight.camera.ae.camera.ui.panel.b value3 = aEBeautyProviderViewModel.a2().getValue();
                if (value3 != null && !bk.a(value3)) {
                    ms.a.f(this.f61816f, "AIBeauty---check PASS");
                    return true;
                }
                ms.a.f(this.f61816f, "AIBeauty---check fail, beauty state wrong");
                return false;
            }
            ms.a.f(this.f61816f, "AIBeauty---check fail, aiBeautyToggle state wrong");
            return false;
        }
        ms.a.f(this.f61816f, "AIBeauty---check fail, captureMode state wrong");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(AECaptureMode aECaptureMode, AECaptureMode aECaptureMode2) {
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar;
        AECameraGLSurfaceView aECameraGLSurfaceView;
        this.U = aECaptureMode2;
        if (aECaptureMode == aECaptureMode2) {
            return;
        }
        AECaptureMode aECaptureMode3 = AECaptureMode.GIF;
        if (aECaptureMode == aECaptureMode3 && aECaptureMode2 == AECaptureMode.NORMAL && (aECameraGLSurfaceView = this.E) != null) {
            aECameraGLSurfaceView.switchSegment(true);
        }
        ms.a.f(this.f61816f, "onCaptureModeChanged---from " + aECaptureMode + " to " + aECaptureMode2);
        Y1(aECaptureMode, aECaptureMode2);
        fm2.a aVar = this.f61858o0;
        if (aVar != null) {
            aVar.c();
        }
        boolean z16 = this.U == aECaptureMode3;
        AEBaseReportParam.U().a1(z16);
        AECameraGLSurfaceView aECameraGLSurfaceView2 = this.E;
        if (aECameraGLSurfaceView2 != null) {
            aECameraGLSurfaceView2.setIsGIFMode(z16);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.34
            @Override // java.lang.Runnable
            public void run() {
                AEPituCameraUnit.this.f61868u0.i();
            }
        });
        FilterPagerViewStubHolder filterPagerViewStubHolder = this.V0;
        if (filterPagerViewStubHolder != null) {
            filterPagerViewStubHolder.u(this.U == AECaptureMode.NORMAL);
        }
        if (G1() && (aaVar = this.f61859o1) != null) {
            aaVar.R1(aECaptureMode2);
        }
        if (!this.U.shouldStartCamera()) {
            if (this.f61834c0 != null && aECaptureMode2 == AECaptureMode.PLAY) {
                ms.a.f(this.f61816f, "change to PLAY, setStickerPause");
                this.f61834c0.setStickerPause(true);
            }
            AETipsViewController aETipsViewController = this.f61852l0;
            if (aETipsViewController != null) {
                aETipsViewController.k();
            }
            GLGestureProxy.getInstance().removeListener(this.f61862q0);
            GLGestureProxy.getInstance().removeListener(this.f61866s0);
            GLGestureProxy.getInstance().removeListener(this.f61854m0);
            GLGestureProxy.getInstance().removeListener(this.f61864r0);
            GLGestureProxy.getInstance().removeListener(this.f61858o0);
            GLGestureProxy.getInstance().removeListener(this.f61860p0);
            return;
        }
        if (this.f61834c0 != null && aECaptureMode == AECaptureMode.PLAY) {
            ms.a.f(this.f61816f, "change from PLAY, setStickerResume");
            this.f61834c0.setStickerResume(true);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61862q0)) {
            GLGestureProxy.getInstance().addListener(this.f61862q0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61866s0)) {
            GLGestureProxy.getInstance().addListener(this.f61866s0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61864r0)) {
            GLGestureProxy.getInstance().addListener(this.f61864r0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61854m0)) {
            GLGestureProxy.getInstance().addListener(this.f61854m0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61856n0)) {
            GLGestureProxy.getInstance().addListener(this.f61856n0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61864r0)) {
            GLGestureProxy.getInstance().addListener(this.f61864r0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f61858o0)) {
            GLGestureProxy.getInstance().addListener(this.f61858o0);
        }
        if (GLGestureProxy.getInstance().hasListener(this.f61860p0)) {
            return;
        }
        GLGestureProxy.getInstance().addListener(this.f61860p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        if (this.f61834c0 != null) {
            if (!this.f61841f1 && !this.f61843g1 && !this.f61845h1) {
                ms.a.f(this.f61816f, "checkSetOnClickWatermarkListener--PASS, no panel is showing");
                this.f61834c0.wmSetOnClickWatermarkListener(this.f61837d1);
            } else {
                ms.a.f(this.f61816f, "checkSetOnClickWatermarkListener--FAIL, some panel is showing");
                this.f61834c0.wmSetOnClickWatermarkListener(null);
            }
        }
    }

    public void A2(int i3, String str) {
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        if (aEMaterialManager != null && i3 >= 0) {
            aEMaterialManager.P(false);
            AEMaterialMetaData z16 = aEMaterialManager.z(i3, str, Q());
            ms.a.a(this.f61816f, "entry dynamics: aeMaterialMetaData" + z16);
            if (z16 == null) {
                QQToast.makeText(z(), R.string.y0q, 1).show();
                return;
            }
            if (TextUtils.isEmpty(z16.f69050id)) {
                ms.a.a(this.f61816f, "entry dynamics: category is exit but id is null");
            }
            AEBaseReportParam.U().z0(str, T1());
            I1().a(true, 150);
            this.f61869v0.q(327683, z16);
            this.f61869v0.q(196612, new Object[0]);
            return;
        }
        QQToast.makeText(z(), R.string.y0q, 1).show();
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected BroadcastReceiver B() {
        return this.C0;
    }

    public void B2(String str) {
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        if (aEMaterialManager == null || TextUtils.isEmpty(str)) {
            return;
        }
        AEBaseReportParam.U().z0(str, J1());
        aEMaterialManager.P(false);
        AEMaterialMetaData A = aEMaterialManager.A(str, Q());
        if (A == null) {
            QQToast.makeText(z(), R.string.y0q, 1).show();
            return;
        }
        I1().a(true, 150);
        this.f61869v0.q(327683, A);
        this.f61869v0.q(196612, new Object[0]);
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.m.c
    public void C2(boolean z16) {
        if (ms.a.g()) {
            ms.a.a(this.f61816f, "onResourceDownload isOnlineRes: " + z16);
        }
        if (!f61831u1) {
            f61831u1 = true;
            this.f61817h.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.40
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.a.g()) {
                        ms.a.a(AEPituCameraUnit.this.f61816f, "onResourceDownload update filterpager begin");
                    }
                    AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                    FilterPagerViewStubHolder filterPagerViewStubHolder = aEPituCameraUnit.V0;
                    if (filterPagerViewStubHolder != null) {
                        filterPagerViewStubHolder.w(aEPituCameraUnit.U == AECaptureMode.NORMAL);
                    }
                    ((AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1)).N(false);
                    ((AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3)).F(false);
                    if (ms.a.g()) {
                        ms.a.a(AEPituCameraUnit.this.f61816f, "onResourceDownload update filterpager end");
                    }
                }
            });
        } else {
            this.f61817h.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.41
                @Override // java.lang.Runnable
                public void run() {
                    AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                    FilterPagerViewStubHolder filterPagerViewStubHolder = aEPituCameraUnit.V0;
                    if (filterPagerViewStubHolder != null) {
                        filterPagerViewStubHolder.w(aEPituCameraUnit.U == AECaptureMode.NORMAL);
                    }
                }
            });
        }
        if (G1() && this.U == AECaptureMode.NORMAL) {
            this.f61817h.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.k
                @Override // java.lang.Runnable
                public final void run() {
                    AEPituCameraUnit.this.s2();
                }
            });
        }
    }

    protected void D2() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.19
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1d), 0).show();
                AEPituCameraUnit.this.c3();
                if (!AEPituCameraUnit.this.f61819m.isFlashEnabled() || AEPituCameraUnit.this.n2()) {
                    return;
                }
                AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                aEPituCameraUnit.f61819m.turnFlash(aEPituCameraUnit.z(), false);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected AECameraManager.CameraManagerListener E() {
        return this.f61844h0;
    }

    protected com.tencent.aelight.camera.ae.part.c E1() {
        return new com.tencent.aelight.camera.ae.part.c(this.f61817h.getActivity(), this.D, this);
    }

    protected void E2() {
        if (Z2()) {
            u1();
        } else if (a3()) {
            v1();
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected h.a G() {
        return this.f61849j1;
    }

    protected boolean G1() {
        return AEDashboardUtil.q();
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected int H() {
        if (Q()) {
            int d16 = com.tencent.aelight.camera.ae.util.h.d();
            if (d16 == 1) {
                this.T = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
            } else if (d16 == 2) {
                this.T = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
            } else {
                this.T = AEVideoStoryTopBarViewModel.Ratio.FULL;
            }
            ((AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryTopBarViewModel.class)).f63374m.setValue(this.T);
        } else if (m2()) {
            this.T = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.f().g(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
        } else if (G1()) {
            this.T = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.f().g(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
            ms.a.a(this.f61816f, "adjustRatio defaultRatio : " + this.T);
        } else {
            this.T = AEVideoStoryTopBarViewModel.Ratio.FULL;
        }
        return this.T.code;
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public AECaptureMode I(int i3) {
        AECaptureMode P1;
        AECaptureMode aECaptureMode = AECaptureMode.NORMAL;
        switch (i3) {
            case 201:
                P1 = P1(this.S, i3);
                break;
            case 202:
            case 203:
                P1 = AECaptureMode.GIF;
                break;
            case 204:
                P1 = P1(this.S, i3);
                break;
            case 205:
                P1 = AECaptureMode.NORMAL;
                break;
            case 206:
                P1 = AECaptureMode.PLAY;
                break;
            case 207:
                P1 = AECaptureMode.PLAY;
                break;
            case 208:
                P1 = AECaptureMode.ARCAKE;
                break;
            default:
                P1 = AECaptureMode.NORMAL;
                break;
        }
        ms.a.f(this.f61816f, "initCaptureModesAndFirstMode---initialMode=" + P1 + ", initialCModes=" + Arrays.toString(this.S));
        return P1;
    }

    public AECaptureController I1() {
        if (this.f61868u0 == null) {
            this.f61868u0 = new AECaptureController(this.D, this);
        }
        return this.f61868u0;
    }

    protected void I2(AEVideoCaptureResult aEVideoCaptureResult) {
        if (this.X) {
            if (aEVideoCaptureResult.videoFrameCount < Q1()) {
                if (ms.a.g()) {
                    ms.a.a(this.f61816f, "onVideoCaptured. videoFrameCount = " + this.L.videoFrameCount + " ; minFrameCount = " + Q1());
                }
                D2();
                return;
            }
            ms.a.f(this.f61816f, "\u3010GIF Capture\u3011during time:" + (aEVideoCaptureResult.finishTimeMs - aEVideoCaptureResult.startTimeMs) + "ms");
            AEBaseReportParam.U().D0(5L);
            com.tencent.aelight.camera.ae.report.b.b().R0();
            long L1 = L1();
            if (L1 > 0) {
                g3(L1);
                return;
            }
            final BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.54
                    @Override // java.lang.Runnable
                    public void run() {
                        Context context2 = context;
                        QQToast.makeText(context2, context2.getString(R.string.f171495fi2), 0).show();
                        AEPituCameraUnit.this.c3();
                    }
                });
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected int K() {
        if (Q()) {
            ms.a.f(this.f61816f, "is from circle, use R.layout.ae_camera_unit_circle_light");
            return R.layout.dms;
        }
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        ms.a.f(this.f61816f, "nowElderMode=" + isNowElderMode);
        return isNowElderMode ? R.layout.dmt : R.layout.dmq;
    }

    public HashMap<String, String> K1() {
        return this.f61846i0;
    }

    public AECaptureMode N1() {
        return this.U;
    }

    public List<WMElement> O1() {
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager == null) {
            return Collections.emptyList();
        }
        return aEFilterManager.wmGetEditableWMElements();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public xp.a P() {
        int g16;
        Intent intent = z().getIntent();
        int i3 = 1;
        if (gq.a.H(intent)) {
            if (intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_PREFER_BACK, false) || !com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                i3 = 2;
            }
        } else {
            if (this.W.g() == 0) {
                g16 = J();
            } else {
                g16 = this.W.g();
            }
            if (this.R != AECaptureMode.GIF || !com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                i3 = g16;
            }
        }
        if (com.tencent.aelight.camera.ae.util.n.s()) {
            AECameraConstants.sCurrentCamera = i3;
            return com.tencent.aelight.camera.ae.util.j.h().c(this.f61817h.getActivity(), i3);
        }
        return com.tencent.aelight.camera.ae.util.j.h().b(this.W);
    }

    public void P2(final Runnable runnable) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.m
            @Override // java.lang.Runnable
            public final void run() {
                AEPituCameraUnit.this.t2(runnable);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public boolean Q() {
        return gq.a.r(z().getIntent());
    }

    protected long Q1() {
        return 5L;
    }

    public Bitmap S1() {
        Bitmap bitmap = this.f61840f0;
        if (bitmap == null || !bitmap.isRecycled()) {
            return this.f61840f0;
        }
        return null;
    }

    public void S2(com.tencent.aelight.camera.ae.camera.ui.simple.a aVar) {
        this.f61839e1 = aVar;
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected boolean T() {
        return gq.a.W(this.W.k());
    }

    public void T2(AECaptureMode aECaptureMode) {
        this.U = aECaptureMode;
    }

    protected void U2() {
        ms.a.f(this.f61816f, "setCaptureModeViewModel---");
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.mode.c.class);
        cVar.f65622i.setValue(new AECaptureModeChangingEvent(null, this.W.l(), 1));
        cVar.f65623m.setValue(this.W.i());
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected boolean V() {
        Activity z16;
        if (js.a.Q.d(this.W.k()) || this.U == AECaptureMode.GIF || (z16 = z()) == null) {
            return false;
        }
        return !gq.a.H(z16.getIntent());
    }

    public void V2(int i3) {
        View findViewById = this.D.findViewById(R.id.f163755ru2);
        if (findViewById instanceof VideoFilterViewPager) {
            ((VideoFilterViewPager) findViewById).setVisibility(i3);
            ms.a.f(this.f61816f, "yes to domVideoFilterViewPager setVisibility: " + i3);
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected boolean W() {
        return Q();
    }

    public synchronized void W2(int i3) {
        this.E0 = i3;
    }

    public synchronized void X2(int i3) {
        this.F0 = i3;
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected void Y() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.42
            @Override // java.lang.Runnable
            public void run() {
                AEFilterManager aEFilterManager = AEPituCameraUnit.this.f61834c0;
                if (aEFilterManager != null) {
                    aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_SWITCHED, AEPituCameraUnit.f61829s1);
                }
                AEPituCameraUnit.this.l3();
                if (AEPituCameraUnit.this.f61852l0 != null) {
                    AEPituCameraUnit.this.f61852l0.p();
                }
                AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                com.tencent.aelight.camera.ae.part.c cVar = aEPituCameraUnit.f61869v0;
                if (cVar != null) {
                    cVar.q(196611, Boolean.valueOf(aEPituCameraUnit.n2()));
                    AEPituCameraUnit.this.f61869v0.q(327685, new Object[0]);
                }
                if (AEPituCameraUnit.this.f61839e1 != null) {
                    AEPituCameraUnit.this.f61839e1.a();
                }
            }
        });
    }

    protected void Y2() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ms.a.f(AEPituCameraUnit.this.f61816f, "[AEPituCameraUnit] setThreadForegroundAndInitAEReport");
                    Process.setThreadPriority(-2);
                } catch (Exception e16) {
                    ms.a.c(AEPituCameraUnit.this.f61816f, "[UnitAsyncInit] setThreadPriority exception: " + e16.getMessage());
                }
                try {
                    AEPituCameraUnit.this.e2();
                } finally {
                    AEPituCameraUnit.this.L0.countDown();
                }
            }
        }, 16, null, true);
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public void Z() {
        ms.a.f(this.f61816f, "onPhotoCaptureStart---");
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_START_RECORD, f61829s1);
        }
        c2();
        AbsAECaptureButton absAECaptureButton = this.F;
        if (absAECaptureButton != null) {
            absAECaptureButton.setVisibility(8);
        }
        this.f61869v0.q(196609, new Object[0]);
        this.f61869v0.q(262147, new Object[0]);
    }

    protected boolean Z2() {
        return this.W.f() == 101 && this.W.w() && this.W.A() && this.W.y();
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void a() {
        Log.d(this.f61816f, "onCaptureButtonVideoStop: thread = " + Thread.currentThread().getName());
        this.E.stopCaptureVideoInGLThread();
        this.f61819m.stopRecordVideo();
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_END_RECORD, f61829s1);
        }
        this.D0 = false;
        this.T0.N1().postValue(Boolean.FALSE);
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I(false);
        V2(0);
    }

    protected boolean a2() {
        com.tencent.aelight.camera.ae.a aVar = this.W;
        return (aVar == null || aVar.n() == -1) ? false : true;
    }

    protected boolean a3() {
        return this.W.f() == 101 && this.W.z();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.r
    public void b(List<AEDashboardUtil.c> list, List<AEDashboardUtil.b> list2) {
        this.f61869v0.q(720897, list, list2);
    }

    public void c(boolean z16) {
        this.J0 = z16;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f61865r1;
        if (aEVideoStoryTopBarViewModel != null) {
            aEVideoStoryTopBarViewModel.O1().postValue(Boolean.valueOf(z16));
        }
        VideoReport.setPageParams(z(), "ae_night_mode", Integer.valueOf(z16 ? 1 : 0));
    }

    protected void c2() {
        this.T0.M1().postValue(Boolean.FALSE);
    }

    public void c3() {
        AbsAECaptureButton absAECaptureButton;
        if (this.W0 != null) {
            if (com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                this.W0.setVisibility(0);
            } else {
                this.W0.setVisibility(4);
            }
        }
        if (GLVideoClipUtil.a()) {
            AECompoundButton aECompoundButton = this.X0;
            if (aECompoundButton != null) {
                aECompoundButton.setVisibility(0);
            }
        } else {
            AECompoundButton aECompoundButton2 = this.X0;
            if (aECompoundButton2 != null && this.f61851k1) {
                aECompoundButton2.setVisibility(0);
                this.X0.setSelected(false);
            }
        }
        y1(true);
        AEBaseReportParam.U().v0();
        com.tencent.aelight.camera.ae.report.b.b().g1();
        if (!this.S0.P1() && (absAECaptureButton = this.F) != null) {
            absAECaptureButton.setVisibility(0);
        }
        this.T0.M1().postValue(Boolean.TRUE);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void d() {
        d2();
    }

    public void d2() {
        AETipsViewController aETipsViewController = this.f61852l0;
        if (aETipsViewController != null) {
            aETipsViewController.m();
        }
        AECompoundButton aECompoundButton = this.W0;
        if (aECompoundButton != null) {
            aECompoundButton.setVisibility(8);
        }
        this.T0.M1().postValue(Boolean.FALSE);
    }

    @QQPermissionDenied(1)
    public void denied() {
        d3();
        com.tencent.aelight.camera.report.atta.d.d("cam_no_auth", Arrays.asList(String.valueOf(this.W.k())), null);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void f() {
        this.f61869v0.q(786435, new Object[0]);
        F1();
    }

    public void f2() {
        if (this.f61861p1 != null) {
            return;
        }
        ms.a.f(this.f61816f, "init beautyViewModel start...");
        this.f61863q1 = (com.tencent.aelight.camera.ae.camera.ui.panel.ac) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.ac.class);
        this.f61855m1 = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEBeautyProviderViewModel.class);
        this.f61857n1 = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEBodyProviderViewModel.class);
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        this.f61859o1 = aaVar;
        AEProviderViewModel aEProviderViewModel = (AEProviderViewModel) com.tencent.aelight.camera.ae.n.b(this, new com.tencent.aelight.camera.ae.camera.ui.panel.an(this.f61855m1, this.f61857n1, aaVar, this.f61863q1)).get(AEProviderViewModel.class);
        this.f61861p1 = aEProviderViewModel;
        aEProviderViewModel.A2().observe(this, new ac());
        this.f61855m1.W1().observe(this, new ad());
        this.f61857n1.T1().observe(this, new ae());
        this.f61857n1.T1().observe(this, new af());
        if (G1()) {
            this.f61861p1.u2().observe(this, new ag());
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected void g0() {
        this.E.setAECaptureController(I1());
        this.E.setAeGLSurfaceListener(this.B0);
        this.E.setCaptureListener(this);
        this.E.setFaceEffectListener(this);
        this.E.setAiBeautyFaceListener(new w());
        this.E.setStickerInnerLutFilterListener(this);
        this.E.setRecommendTextCallback(new x());
        if (com.tencent.aelight.camera.ae.util.n.s()) {
            this.E.setDynamicResolutionMode(true);
            this.f61819m.setDynamicResolutionMode(true);
        } else {
            this.E.setDynamicResolutionMode(false);
            this.f61819m.setDynamicResolutionMode(false);
        }
        if (AEDashboardUtil.x()) {
            this.E.debugInfoCallback = this;
        }
        if (Q()) {
            this.E.setAeEditMaterialSelectedListener(new y());
        }
    }

    protected void g2() {
        ViewStub viewStub;
        if (this.U.shouldStartCamera()) {
            return;
        }
        U2();
        if (Q() && (viewStub = (ViewStub) this.D.findViewById(R.id.f163793s14)) != null) {
            viewStub.inflate();
        }
        this.f61869v0.h();
        int i3 = this.f61836d0;
        if (i3 <= 0 || this.f61838e0 <= 0) {
            return;
        }
        this.f61869v0.q(851973, Arrays.asList(Integer.valueOf(i3), Integer.valueOf(this.f61838e0)));
    }

    protected void g3(long j3) {
        Intent intent = new Intent(z(), (Class<?>) AEStoryGIFPreviewActivity.class);
        intent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.L.videoMp4FilePath);
        intent.putExtra("KEY_AVAILABLE_EMO_COUNT", j3);
        AEVideoStoryGIFTplViewModel aEVideoStoryGIFTplViewModel = (AEVideoStoryGIFTplViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryGIFTplViewModel.class);
        AEMaterialWrapper value = aEVideoStoryGIFTplViewModel.R1().getValue();
        boolean z16 = true;
        intent.putExtra("KEY_MATERIAL_APPLIED", value != null);
        if (value != null) {
            intent.putExtra(AECameraConstants.ARG_GIF_MATERIAL_ID, value.f63553a);
        }
        intent.putExtra("KEY_AVAILABLE_SAVENAME", aEVideoStoryGIFTplViewModel.Q1().getValue());
        intent.putExtra(AECameraConstants.ARG_SESSION_INFO, this.W.q());
        String value2 = aEVideoStoryGIFTplViewModel.S1().getValue();
        if (!TextUtils.isEmpty(value2)) {
            intent.putExtra("KEY_FONT_ID", value2);
        }
        Intent intent2 = z().getIntent();
        if (!gq.a.l(intent2) && !gq.a.k(intent2)) {
            z16 = false;
        }
        intent.putExtra(AECameraConstants.ARG_GIF_SEND_TO_AIO, z16);
        Activity z17 = z();
        if (z17 != null) {
            intent.putExtra(AECameraConstants.AECAMERA_MODE, this.W.e());
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, this.W.k());
            z17.startActivityForResult(intent, 101);
        }
    }

    @QQPermissionGrant(1)
    public void grant() {
        ms.a.f(this.f61816f, "\u3010Camera / Audio / Storage Permission\u3011grant");
        this.Z = true;
        if (this.X) {
            p0();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void h() {
        if (!com.tencent.aelight.camera.ae.util.c.b(z().getIntent(), this.f61816f)) {
            ms.a.f(this.f61816f, "onCaptureButtonVideoStart no need audio");
            w1();
        } else if (!M()) {
            a0(new b());
        } else {
            w1();
        }
    }

    protected void h2() {
        pq.a aVar = new pq.a();
        this.f61862q0 = aVar;
        aVar.a(this.Q0);
        this.f61862q0.a(this.R0);
        this.f61862q0.d(this.D);
        this.f61862q0.c(new u());
        this.f61862q0.b(new v());
        this.f61854m0 = new fm2.e(this.f61873z0);
        this.f61856n0 = new fm2.b(this.f61873z0);
        this.f61864r0 = new pq.b(this.E, Q() ? U1() : 0);
        this.f61858o0 = new fm2.a(z(), this.f61872y0);
        this.f61860p0 = new fm2.c(this.E.getContext(), this.A0);
    }

    protected void h3() {
        Runnable runnable = this.f61835c1;
        if (runnable != null) {
            this.f61815a0.removeCallbacks(runnable);
            this.f61835c1 = null;
        }
        if (this.Y0 != null) {
            this.f61815a0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.37
                @Override // java.lang.Runnable
                public void run() {
                    AEPituCameraUnit.this.Y0.setVisibility(8);
                    if (AEPituCameraUnit.this.Y0.getDrawable() != null) {
                        LazyLoadAnimationDrawable lazyLoadAnimationDrawable = (LazyLoadAnimationDrawable) AEPituCameraUnit.this.Y0.getDrawable();
                        lazyLoadAnimationDrawable.stop();
                        lazyLoadAnimationDrawable.clear();
                    }
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected void i0() {
        this.E.setGenderTypeListener(new z());
    }

    public void i3(boolean z16, View view) {
        com.tencent.aelight.camera.ae.camera.ui.panel.t tVar;
        if (this.D0 || view == null) {
            return;
        }
        ms.a.a(this.f61816f, "bClosedByCustom" + this.f61851k1);
        if (this.U == AECaptureMode.GIF) {
            ms.a.f(this.f61816f, "\u3010Dark Mode\u3011in gif show off");
            view.setVisibility(8);
            return;
        }
        com.tencent.aelight.camera.ae.part.a aVar = this.T0;
        if ((aVar != null && aVar.R1()) || ((tVar = this.P0) != null && tVar.O1())) {
            ms.a.f(this.f61816f, "\u3010Dark Mode\u3011in panel show off ");
            view.setVisibility(8);
            return;
        }
        if (z16) {
            if (this.f61851k1) {
                return;
            }
            view.setVisibility(0);
            view.setSelected(true);
            m0(true);
            this.f61851k1 = false;
            ms.a.f(this.f61816f, "\u3010Dark Mode\u3011Start");
            return;
        }
        view.setVisibility(8);
        view.setSelected(false);
        m0(false);
        this.f61851k1 = false;
    }

    protected void j2() {
        this.O0 = (com.tencent.aelight.camera.ae.e) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.e.class);
        this.Z0 = (an) com.tencent.aelight.camera.ae.n.a(this).get(an.class);
        this.f61832a1 = (com.tencent.aelight.camera.ae.camera.ui.panel.z) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.z.class);
        ((com.tencent.aelight.camera.ae.camera.ui.panel.ac) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.ac.class)).L1().observe(this, new d());
        this.O0.P1().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEPituCameraUnit.this.r2((r) obj);
            }
        });
        this.O0.Q1().observe(this, new e());
        this.O0.O1().observe(this, new f());
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.S0 = cVar;
        cVar.f65622i.observe(this, new g());
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        this.f61859o1 = aaVar;
        aaVar.N1().observe(this, new h());
        this.T0 = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.part.a.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryTopBarViewModel.class);
        this.f61865r1 = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.S1(this.f61819m.isFrontCamera());
        this.f61865r1.f63374m.observe(this, new i());
        this.T0.N1().observe(this, new j());
        this.T0.Q1().observe(this, new k());
        this.T0.P1().observe(this, new l());
        this.T0.L1().observe(this, new n());
        com.tencent.aelight.camera.ae.camera.ui.panel.t tVar = (com.tencent.aelight.camera.ae.camera.ui.panel.t) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.t.class);
        this.P0 = tVar;
        tVar.N1().observe(this, new o());
        if (G1()) {
            f2();
        }
        Activity z16 = z();
        if (z16 instanceof FragmentActivity) {
            MusicSourceViewModel musicSourceViewModel = (MusicSourceViewModel) new ViewModelProvider((FragmentActivity) z16).get(MusicSourceViewModel.class);
            this.f61833b1 = musicSourceViewModel;
            musicSourceViewModel.D2().observe(this, new p());
        }
    }

    public boolean l2() {
        return gq.a.j(z().getIntent());
    }

    public boolean m2() {
        com.tencent.aelight.camera.ae.a aVar = this.W;
        if (aVar != null) {
            return js.a.Q.d(aVar.k());
        }
        return gq.a.F(z().getIntent());
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public void n(int i3, int i16) {
        super.n(i3, i16);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.13
            @Override // java.lang.Runnable
            public void run() {
                LiuHaiUtils.resetAllLiuHaiStatus();
                LiuHaiUtils.initLiuHaiProperty(AEPituCameraUnit.this.f61817h.getActivity());
                if (LiuHaiUtils.needCloseFullScreen()) {
                    LiuHaiUtils.closeFullScreen(AEPituCameraUnit.this.f61817h.getActivity());
                } else {
                    LiuHaiUtils.resetFullScreen(AEPituCameraUnit.this.f61817h.getActivity());
                }
                AEPituCameraUnit.this.o1();
            }
        });
        this.f61868u0.h();
    }

    protected void n1() {
        if (this.M0) {
            return;
        }
        this.M0 = true;
        ms.a.f(this.f61816f, "actionAfterFirstFrame");
        ((IAsyncControl) QRoute.api(IAsyncControl.class)).startAsyncStep(com.tencent.aelight.camera.aioeditor.capture.control.a.f66679c, new Object[]{this, Integer.valueOf(this.f61817h.getActivity().getIntent().getIntExtra("edit_video_type", 10002))});
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.20

            /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$20$a */
            /* loaded from: classes32.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AECaptureController aECaptureController = AEPituCameraUnit.this.f61868u0;
                    if (aECaptureController != null) {
                        aECaptureController.h();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ms.a.f(AEPituCameraUnit.this.f61816f, "actionAfterFirstFrame--ui run--BEGIN");
                ViewStub viewStub = (ViewStub) AEPituCameraUnit.this.D.findViewById(R.id.f163793s14);
                if (viewStub != null) {
                    viewStub.inflate();
                }
                ViewStub viewStub2 = (ViewStub) AEPituCameraUnit.this.D.findViewById(R.id.s1a);
                if (viewStub2 != null && !AEPituCameraUnit.this.l2()) {
                    viewStub2.inflate();
                }
                AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                aEPituCameraUnit.F = (AEPituCameraCaptureButtonLayout) aEPituCameraUnit.D.findViewById(R.id.rqn);
                AEPituCameraUnit aEPituCameraUnit2 = AEPituCameraUnit.this;
                aEPituCameraUnit2.F.f(aEPituCameraUnit2, aEPituCameraUnit2.W.k(), AEPituCameraUnit.this.E);
                if (!AEPituCameraUnit.this.Q()) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AEPituCameraUnit.this.F.getLayoutParams();
                    layoutParams.bottomMargin = BaseAIOUtils.f(-30.0f, AEPituCameraUnit.this.F.getResources());
                    AEPituCameraUnit.this.F.setLayoutParams(layoutParams);
                    AEPituCameraUnit.this.F.a();
                }
                AEPituCameraUnit aEPituCameraUnit3 = AEPituCameraUnit.this;
                if (aEPituCameraUnit3.X) {
                    aEPituCameraUnit3.F.onResume();
                    AEPituCameraUnit.this.c3();
                }
                AEPituCameraUnit.this.f3();
                AEPituCameraUnit.this.f61868u0.f();
                if (AEPituCameraUnit.this.R.shouldStartCamera()) {
                    AEPituCameraUnit.this.U2();
                    AEPituCameraUnit.this.f61869v0.h();
                    if (AEPituCameraUnit.this.f61836d0 > 0 && AEPituCameraUnit.this.f61838e0 > 0) {
                        AEPituCameraUnit aEPituCameraUnit4 = AEPituCameraUnit.this;
                        aEPituCameraUnit4.f61869v0.q(851973, Arrays.asList(Integer.valueOf(aEPituCameraUnit4.f61836d0), Integer.valueOf(AEPituCameraUnit.this.f61838e0)));
                    }
                }
                AEPituCameraUnit aEPituCameraUnit5 = AEPituCameraUnit.this;
                aEPituCameraUnit5.X0 = (AECompoundButton) aEPituCameraUnit5.D.findViewById(R.id.rru);
                if (AEPituCameraUnit.this.X0 != null) {
                    AEPituCameraUnit.this.X0.setOnClickListener(AEPituCameraUnit.this);
                    AEPituCameraUnit.this.X0.setSelected(false);
                    AEPituCameraUnit.this.X0.setVisibility(8);
                    AEPituCameraUnit aEPituCameraUnit6 = AEPituCameraUnit.this;
                    boolean z16 = aEPituCameraUnit6.J0;
                    if (z16) {
                        aEPituCameraUnit6.i3(z16, aEPituCameraUnit6.X0);
                    }
                }
                AEPituCameraUnit aEPituCameraUnit7 = AEPituCameraUnit.this;
                aEPituCameraUnit7.W0 = (AECompoundButton) aEPituCameraUnit7.D.findViewById(R.id.rqx);
                if (AEPituCameraUnit.this.W0 != null) {
                    vq.a.f443174a.b(AEPituCameraUnit.this.W0, "em_ae_switch_btn");
                    AEPituCameraUnit.this.W0.setOnClickListener(AEPituCameraUnit.this);
                    AEPituCameraUnit.this.W0.setContentDescription(AEPituCameraUnit.this.W0.getResources().getString(R.string.y9u));
                    if (!com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                        AEPituCameraUnit.this.W0.setVisibility(4);
                        AEPituCameraUnit.this.W0.setEnabled(false);
                    }
                }
                AEPituCameraUnit aEPituCameraUnit8 = AEPituCameraUnit.this;
                if (aEPituCameraUnit8.X) {
                    aEPituCameraUnit8.f61869v0.m();
                    AEPituCameraUnit.this.f61868u0.o();
                }
                AEPituCameraUnit aEPituCameraUnit9 = AEPituCameraUnit.this;
                aEPituCameraUnit9.D.setOnTouchListener(aEPituCameraUnit9);
                if (AEPituCameraUnit.this.Q()) {
                    AEPituCameraUnit.this.D.setOnClickListener(new a());
                }
                AEPituCameraUnit.this.E2();
                AEPituCameraUnit.this.l3();
                AEPituCameraUnit.this.b3();
                AEPituCameraUnit.this.K0 = true;
                if (AEPituCameraUnit.this.f61842g0 != null) {
                    Iterator it = AEPituCameraUnit.this.f61842g0.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    AEPituCameraUnit.this.f61842g0 = null;
                }
                ms.a.f(AEPituCameraUnit.this.f61816f, "actionAfterFirstFrame--ui run--END");
            }
        });
    }

    public boolean n2() {
        return this.U == AECaptureMode.GIF;
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void o() {
        D2();
    }

    protected void o1() {
        LiuHaiUtils.initLiuHaiScreenUI_Common(this.J, this.K, ViewUtils.dip2px(1.0f));
        p1();
    }

    public synchronized boolean o2() {
        return this.E0 != 1;
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitInitListener
    public void onAEKitInited() {
        super.onAEKitInited();
        if (!G1()) {
            int m3 = AEBeautyProviderView.m();
            int n3 = AEBeautyProviderView.n();
            this.f61868u0.t(m3);
            this.f61868u0.w(n3);
        }
        this.f61815a0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.12
            @Override // java.lang.Runnable
            public void run() {
                AEPituCameraUnit.this.f61868u0.x();
                FilterPagerViewStubHolder filterPagerViewStubHolder = AEPituCameraUnit.this.V0;
                if (filterPagerViewStubHolder != null) {
                    filterPagerViewStubHolder.v(true);
                }
            }
        });
        AEFontManager.d().f();
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        ms.a.f(this.f61816f, "onActivityPause");
        super.onActivityPause();
        F1();
        GLGestureProxy.getInstance().removeListener(this.f61862q0);
        GLGestureProxy.getInstance().removeListener(this.f61866s0);
        GLGestureProxy.getInstance().removeListener(this.f61854m0);
        GLGestureProxy.getInstance().removeListener(this.f61856n0);
        GLGestureProxy.getInstance().removeListener(this.f61864r0);
        GLGestureProxy.getInstance().removeListener(this.f61858o0);
        GLGestureProxy.getInstance().removeListener(this.f61860p0);
        FilterPagerViewStubHolder filterPagerViewStubHolder = this.V0;
        if (filterPagerViewStubHolder != null) {
            filterPagerViewStubHolder.p();
        }
        AbsAECaptureButton absAECaptureButton = this.F;
        if (absAECaptureButton != null) {
            absAECaptureButton.onPause();
        }
        this.f61868u0.p();
        this.f61869v0.k();
        AEMaterialManager.f63519w = false;
        if (ms.a.h()) {
            ms.a.a(this.f61816f, "onActivityPause, ID=" + this.Q);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        super.onActivityResult(i3, i16, intent);
        if (ms.a.g()) {
            ms.a.a(this.f61816f, "onActivityResult:requestCode=" + i3 + " resultCode=" + i16 + " data=" + intent + " publishStoryFlag=" + f61830t1);
        }
        Activity activity = this.f61817h.getActivity();
        gm2.d.c(activity, i3, i16);
        if (activity == null || activity.isFinishing()) {
            if (ms.a.g()) {
                String str2 = this.f61816f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("activity is finishing, ");
                sb5.append(activity == null);
                ms.a.a(str2, sb5.toString());
                return;
            }
            return;
        }
        if (i3 == 1024) {
            if (i16 == -1) {
                activity.setResult(-1, intent);
                activity.finish();
                return;
            }
            return;
        }
        if (i3 == 1026 || i3 == 1027) {
            this.f61869v0.l(i3, i16, intent);
            return;
        }
        if (i3 == 1025 && i16 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("file_send_path");
            String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.FILE_SEND_IS_PHOTO, false);
            ms.a.f(this.f61816f, "onActivityResult---H5 result back, isPhoto=" + booleanExtra);
            if (!booleanExtra) {
                H2(stringExtra, stringExtra2, intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, -1L));
                return;
            } else if (!TextUtils.isEmpty(stringExtra)) {
                G2(stringExtra, stringExtra2);
                return;
            }
        }
        if (i3 == 111) {
            activity.setResult(i16, intent);
            activity.finish();
            return;
        }
        ms.a.a(this.f61816f, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", Integer.valueOf(i3), Integer.valueOf(i16), intent));
        if (i3 == 10020) {
            if (i16 == -1) {
                activity.setResult(i16, intent);
                activity.finish();
                return;
            }
            return;
        }
        if (intent == null && i16 == 0 && f61830t1) {
            f61830t1 = false;
            return;
        }
        if (i16 == -1 && (i3 == 10006 || i3 == 1012)) {
            this.f61868u0.m();
        }
        if (i16 == 0) {
            com.tencent.mobileqq.filter.f.d(null);
        }
        if (intent != null && this.W.q() != null) {
            intent.putExtra(PeakConstants.SEND_SESSION_INFO, this.W.q().a());
        }
        if (i3 == 1012 && i16 == -1) {
            if (intent != null) {
                str = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            } else {
                str = "";
            }
            boolean z16 = intent != null && intent.getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
            if (intent != null) {
                intent.putExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT, str);
                intent.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, z16);
                activity.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT, str);
                intent2.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, z16);
                activity.setResult(-1, intent2);
            }
            activity.finish();
            return;
        }
        if (i3 == 10000 && i16 == -1) {
            Intent intent3 = z().getIntent();
            String stringExtra3 = intent3 != null ? intent3.getStringExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO) : null;
            SessionWrap q16 = this.W.q();
            String str3 = this.f61816f;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onActivityResult: edit video finish, arkId=");
            sb6.append(stringExtra3);
            sb6.append(", session is null=");
            sb6.append(q16 == null);
            ms.a.f(str3, sb6.toString());
            if (!TextUtils.isEmpty(stringExtra3) && q16 != null) {
                activity.finish();
                return;
            }
            if (intent != null) {
                intent.putExtra("gotoAIO", true);
            }
            com.tencent.aelight.camera.aebase.j.b(this.f61817h.getActivity(), intent, this.f61818i);
            return;
        }
        this.f61869v0.l(i3, i16, intent);
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        HashMap hashMap;
        ms.a.f(this.f61816f, "onActivityResume");
        this.X = true;
        if (f61830t1) {
            ms.a.c(this.f61816f, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
            return;
        }
        rs.b.c().d(this.W.k());
        super.onActivityResume();
        this.f61819m.refreshDarkModeTimer();
        z1();
        GLGestureProxy.getInstance().addListener(this.f61862q0);
        GLGestureProxy.getInstance().addListener(this.f61866s0);
        GLGestureProxy.getInstance().addListener(this.f61854m0);
        GLGestureProxy.getInstance().addListener(this.f61856n0);
        GLGestureProxy.getInstance().addListener(this.f61864r0);
        GLGestureProxy.getInstance().addListener(this.f61858o0);
        GLGestureProxy.getInstance().addListener(this.f61860p0);
        this.f61868u0.o();
        if (this.K0) {
            AbsAECaptureButton absAECaptureButton = this.F;
            if (absAECaptureButton != null) {
                absAECaptureButton.onResume();
            }
            c3();
            c(false);
        }
        com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
        if (cVar != null) {
            cVar.m();
        }
        o3();
        y1(false);
        AEMaterialManager.f63519w = true;
        if (ms.a.h()) {
            ms.a.a(this.f61816f, "onActivityResume, ID=" + this.Q);
        }
        if (Q()) {
            if (AEMaterialManager.H() != null) {
                hashMap = new HashMap();
                hashMap.put("ext2", AEMaterialManager.H().f69050id);
            } else {
                hashMap = null;
            }
            com.tencent.aelight.camera.aebase.c.c(1, hashMap);
        }
        al alVar = this.f61853l1;
        if (alVar != null) {
            alVar.callback();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityStart() {
        ms.a.f(this.f61816f, "onActivityStart");
        super.onActivityStart();
        com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
        if (cVar != null) {
            cVar.n();
        }
        this.H0 = System.currentTimeMillis();
        if (l2()) {
            com.tencent.aelight.camera.ae.report.b.b().m();
        }
        if (G1()) {
            com.tencent.aelight.camera.ae.report.e.b().e(this);
            com.tencent.aelight.camera.ae.report.b.b().O(new HashMap<>(com.tencent.aelight.camera.ae.report.e.b().a()));
        } else {
            com.tencent.aelight.camera.ae.report.b.b().t();
        }
        if (ms.a.h()) {
            ms.a.a(this.f61816f, "onActivityStart, ID=" + this.Q);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityStop() {
        ms.a.f(this.f61816f, "onActivityStop");
        super.onActivityStop();
        this.f61869v0.o();
        com.tencent.aelight.camera.ae.report.b.b().C0(this.H0);
        if (ms.a.h()) {
            ms.a.a(this.f61816f, "onActivityStop, ID=" + this.Q);
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public boolean onBackPressed() {
        AECaptureController aECaptureController = this.f61868u0;
        if (aECaptureController == null || aECaptureController.q()) {
            return false;
        }
        if (this.f61869v0.g(589824) && ((Boolean) this.f61869v0.b(589826, new Object[0])).booleanValue()) {
            ms.a.a(this.f61816f, "WaterMark editor need hide");
            this.f61869v0.q(589826, new Object[0]);
            return true;
        }
        this.f61868u0.p();
        this.f61868u0.m();
        if (Q()) {
            Intent intent = z().getIntent();
            String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            if (stringExtra != null) {
                intent.setClassName(stringExtra2, stringExtra);
                intent.removeExtra("PhotoConst.PHOTO_PATHS");
                intent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
                intent.addFlags(603979776);
                if (!intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
                    z().startActivity(intent);
                } else {
                    intent.getStringExtra("PhotoConst.PLUGIN_NAME");
                    String stringExtra3 = intent.getStringExtra("PhotoConst.PLUGIN_APK");
                    String stringExtra4 = intent.getStringExtra("PhotoConst.UIN");
                    if ("qzone_plugin.apk".equals(stringExtra3)) {
                        QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra);
                        QZoneHelper.launchQZone(z(), stringExtra4, intent, 2);
                    }
                }
            }
        }
        this.f61817h.Q();
        com.tencent.aelight.camera.ae.report.b.b().y();
        ms.a.f(this.f61816f, "\u3010Click\u3011onBackPressed");
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.rqg /* 2097545378 */:
            case R.id.rqh /* 2097545379 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
                x2();
                break;
            case R.id.rqx /* 2097545395 */:
                z2(this.W0);
                break;
            case R.id.rru /* 2097545429 */:
                AECompoundButton aECompoundButton = this.X0;
                if (aECompoundButton != null) {
                    com.tencent.aelight.camera.aioeditor.capture.view.a.d(aECompoundButton.a(), 200L, null);
                    boolean z16 = !this.X0.isSelected();
                    this.X0.setSelected(z16);
                    m0(z16);
                    if (!z16) {
                        this.f61851k1 = true;
                    } else {
                        this.f61851k1 = false;
                    }
                    gm2.d.f(z16);
                    com.tencent.aelight.camera.aioeditor.b.b(z16 ? 1 : 2);
                    break;
                }
                break;
            case R.id.rwx /* 2097545616 */:
            case R.id.f166141eg4 /* 2131375595 */:
                z().getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        ms.a.a(this.f61816f, "[AE Profiler] AEPituCameraUnit onCreate");
        AEBaseReportParam.U().u0(z().getIntent().getLongExtra("intent_key_launch_begin_time", 0L));
        super.onCreate(bundle);
        vq.a.f443174a.d(z(), "pg_ae_camera_preview");
        VideoReport.setPageParams(z(), "ae_mode_refer", Integer.valueOf(this.W.k()));
        if (gq.a.l(z().getIntent())) {
            ms.a.f(this.f61816f, "is aio, enable material race and req data");
            ((AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1)).u0(true);
            ((CameraDataServiceHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.I)).T2();
            L2();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.9
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.G1()) {
                    com.tencent.aelight.camera.ae.camera.aibeauty.c cVar = com.tencent.aelight.camera.ae.camera.aibeauty.c.f62199a;
                    if (cVar.h()) {
                        return;
                    }
                    cVar.a();
                }
            }
        }, 16, null, false);
        boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, true, 0);
        ms.a.f(this.f61816f, "AiBeautyToggle---initial: " + c16);
        AEBaseReportParam.U().B0(c16 ? 1 : 0);
        f61830t1 = false;
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().P(false);
        this.f61837d1 = new OnClickWatermarkListener() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.10
            @Override // org.light.listener.OnClickWatermarkListener
            public void onClickWatermark() {
                ms.a.a(AEPituCameraUnit.this.f61816f, "onClickWatermark");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.setAction("ae_editor_bottom_tab_show_hide");
                        intent.putExtra("is_show", false);
                        AEPituCameraUnit.this.z().sendBroadcast(intent);
                        AEPituCameraUnit.this.f61869v0.q(FileMsg.TRANSFILE_TYPE_MULTIMSG, new Object[0]);
                        com.tencent.aelight.camera.ae.report.b.b().L1();
                    }
                });
            }
        };
        if (l2()) {
            ms.a.a(this.f61816f, "[arcake] AEPituCameraUnit onCreate~~~~");
            AEGiftMaterialConfigParser.a();
            ThreadManagerV2.excute(new AEARCakeDownloadMaterialRunnable(), 128, null, true);
            AEARCakeMaterialManager.i().v(new a());
        }
        F2();
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        A1();
        if (AEDashboardUtil.x()) {
            this.E.debugInfoCallback = null;
        }
        this.f61869v0.p();
        FilterPagerViewStubHolder filterPagerViewStubHolder = this.V0;
        if (filterPagerViewStubHolder != null) {
            filterPagerViewStubHolder.s();
        }
        this.C.a();
        AEBaseReportParam.U().d();
        AEBaseReportParam.U().d1(false);
        uq.a.unRegisterModule();
        if (z() != null && gq.a.H(z().getIntent())) {
            this.f61819m.setSelectedCamera(J());
        }
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        aEMaterialManager.n();
        aEMaterialManager.m();
        AECaptureController aECaptureController = this.f61868u0;
        if (aECaptureController != null) {
            aECaptureController.n();
        }
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager != null) {
            aEFilterManager.wmSetOnClickWatermarkListener(null);
            this.f61834c0.wmSetOnlineUsrCountDelegate("watermark.qq.online", null);
        }
        AEBodyProviderViewModel aEBodyProviderViewModel = this.f61857n1;
        if (aEBodyProviderViewModel != null) {
            aEBodyProviderViewModel.Q1();
        }
        AEFilterProcessTex.u0(0);
        if (l2()) {
            AEARCakeMaterialManager.i().v(null);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onDetectStateChange(boolean z16, boolean z17) {
        AETipsViewController aETipsViewController = this.f61852l0;
        if (aETipsViewController != null) {
            aETipsViewController.q(z16, z17);
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void onDeviceNotSupportMaterial() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.62
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(AEPituCameraUnit.this.z(), -1, R.string.y0c, 0).show();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onHideNormalTip() {
        ms.a.a(this.f61816f, "onHideNormalTip: ");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.45
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.f61852l0 != null) {
                    AEPituCameraUnit.this.f61852l0.l();
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onHidePagTip() {
        ms.a.a(this.f61816f, "onHidePagTip: ");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.47
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.f61852l0 != null) {
                    AEPituCameraUnit.this.f61852l0.n();
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(AEVideoShelfPreviewFragment.FROM_FLAG_BACK_FROM_QUDONG_TO_AIO)) {
            return;
        }
        ms.a.f(this.f61816f, "onNewIntent---back from qu dong");
        String string = extras.getString("file_send_path");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        H2(string, extras.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, ""), ShortVideoUtils.a(string));
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult) {
        List<WMElement> wmGetEditableWMElements;
        this.M = aEPhotoCaptureResult;
        AEBaseReportParam.U().D0(1L);
        if (G1()) {
            com.tencent.aelight.camera.ae.report.e.b().f(this, -1L);
            com.tencent.aelight.camera.ae.report.b.b().e0(new HashMap<>(com.tencent.aelight.camera.ae.report.e.b().a()));
        } else {
            com.tencent.aelight.camera.ae.report.b.b().n1(-1L);
        }
        ms.a.f(this.f61816f, "onPhotoCaptured---\u3010Type\u3011Photo");
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager != null && (wmGetEditableWMElements = aEFilterManager.wmGetEditableWMElements()) != null) {
            for (WMElement wMElement : wmGetEditableWMElements) {
                if (WMElement.TYPE_CHECK_IN.equals(wMElement.type)) {
                    wMElement.doCheckIn();
                }
            }
        }
        boolean a26 = a2();
        ms.a.f(this.f61816f, "onPhotoCaptured---hasDefinedPhotoEditType=" + a26);
        if (a26) {
            Q2(aEPhotoCaptureResult);
        } else {
            R2(aEPhotoCaptureResult);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.17
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.f61819m.isFlashEnabled()) {
                    AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                    aEPituCameraUnit.f61819m.turnFlash(aEPituCameraUnit.z(), false);
                }
            }
        });
        mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_AIO);
        M2("shoot", mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_AIO));
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onRequestChangeCamera(int i3, AECameraManager.CameraOpenCallback cameraOpenCallback) {
        ms.a.f(this.f61816f, "onRequestChangeCamera---which=" + i3);
        AECameraManager aECameraManager = this.f61819m;
        if (aECameraManager != null) {
            aECameraManager.changeCamera(i3, new s(cameraOpenCallback));
        } else {
            cameraOpenCallback.onOpenResult(i3, false);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onSelectFaceEffect(final VideoMaterial videoMaterial) {
        h3();
        A1();
        if (!n2()) {
            if (videoMaterial == null) {
                AEBaseReportParam.U().u1("none");
                AEBaseReportParam.U().n1("");
                AEBaseReportParam.U().o1("");
            } else {
                AEBaseReportParam.U().u1(videoMaterial.getId());
            }
        }
        if (videoMaterial != null && videoMaterial.isWatermarkMaterial() && this.f61834c0 != null) {
            ms.a.a(this.f61816f, "onSelectFaceEffect: wmSetOnlineUsrCountDelegate");
            this.f61834c0.wmSetOnlineUsrCountDelegate("watermark.qq.online", yq.b.f450786a.c());
        }
        if (videoMaterial != null && videoMaterial.isEditableWatermark() && !n2()) {
            z().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.38
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.aelight.camera.ae.part.c cVar = AEPituCameraUnit.this.f61869v0;
                    if (cVar != null && cVar.f(131072) != null) {
                        AEPituCameraUnit.this.f61869v0.f(131072).f0(114, videoMaterial);
                    }
                    com.tencent.aelight.camera.ae.part.c cVar2 = AEPituCameraUnit.this.f61869v0;
                    if (cVar2 != null && cVar2.f(786432) != null) {
                        AEPituCameraUnit.this.f61869v0.f(786432).f0(114, videoMaterial);
                    }
                    AEMaterialMetaData J = AEMaterialManager.J();
                    if (J == null) {
                        J = AEMaterialManager.H();
                    }
                    if (AEPituCameraUnit.this.k2(J)) {
                        J.isdoubleclick = false;
                        com.tencent.aelight.camera.ae.part.c cVar3 = AEPituCameraUnit.this.f61869v0;
                        if (cVar3 != null) {
                            cVar3.q(589825, new Object[0]);
                        }
                        com.tencent.aelight.camera.ae.report.b b16 = com.tencent.aelight.camera.ae.report.b.b();
                        String str = J.f69050id;
                        if (str == null) {
                            str = "none";
                        }
                        b16.L(str);
                        com.tencent.aelight.camera.ae.report.b.b().c0(AEBaseReportParam.U().z());
                    }
                }
            });
        } else {
            z().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.39
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.aelight.camera.ae.part.c cVar = AEPituCameraUnit.this.f61869v0;
                    if (cVar == null || cVar.f(131072) == null) {
                        return;
                    }
                    AEPituCameraUnit.this.f61869v0.f(131072).f0(115, videoMaterial);
                }
            });
        }
        AETipsViewController aETipsViewController = this.f61852l0;
        if (aETipsViewController != null) {
            aETipsViewController.r(videoMaterial);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onShowNormalTip(final String str, final String str2, final int i3) {
        ms.a.a(this.f61816f, "onShowNormalTip: tip=" + str + ", icon=" + str2 + ", duration=" + i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.44
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.f61852l0 != null) {
                    AEPituCameraUnit.this.f61852l0.w(str, str2, i3);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onShowPagTip(final String str, final int i3) {
        ms.a.a(this.f61816f, "onShowPagTip: pagPath=" + str + ", duration=" + i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.46
            @Override // java.lang.Runnable
            public void run() {
                if (AEPituCameraUnit.this.f61852l0 != null) {
                    AEPituCameraUnit.this.f61852l0.x(str, i3);
                }
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f61867t0;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        if (this.F == null) {
            return true;
        }
        GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, this.F.b(), this.E);
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onVideoCaptureStart() {
        z().getIntent().removeExtra(AECameraConstants.KEY_SEND_ARK_MSG_GAME_SCORE);
        d2();
        V2(8);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.15
            @Override // java.lang.Runnable
            public void run() {
                AEPituCameraUnit.this.f61868u0.i();
            }
        });
        this.f61869v0.q(196609, new Object[0]);
        this.f61869v0.q(262145, new Object[0]);
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult) {
        mq.a.d().j(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_AIO);
        this.L = aEVideoCaptureResult;
        aEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
        if (n2()) {
            I2(aEVideoCaptureResult);
        } else {
            int i3 = this.V == 13 ? 2000 : 500;
            long j3 = aEVideoCaptureResult.finishTimeMs - aEVideoCaptureResult.startTimeMs;
            if (j3 < i3) {
                ms.a.a(this.f61816f, "onVideoCaptured---too short:" + j3);
                this.D0 = false;
                this.T0.N1().postValue(Boolean.FALSE);
                D2();
                return;
            }
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            this.N = localMediaInfo;
            localMediaInfo.path = aEVideoCaptureResult.videoMp4FilePath;
            localMediaInfo.mMimeType = "video";
            MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(this, this.N);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.16
            @Override // java.lang.Runnable
            public void run() {
                if (!AEPituCameraUnit.this.f61819m.isFlashEnabled() || AEPituCameraUnit.this.n2()) {
                    return;
                }
                AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                aEPituCameraUnit.f61819m.turnFlash(aEPituCameraUnit.z(), false);
            }
        });
        mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_AIO);
        M2(QQPermissionConstants.Permission.AUIDO_GROUP, mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_AIO));
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    protected void p1() {
        Activity z16 = z();
        if (ScreenUtil.getRealHeight(z16) / ScreenUtil.getRealWidth(z16) >= 2.0f) {
            this.K.setVisibility(8);
            this.J.setVisibility(8);
            if (!gq.a.q(this.W.k())) {
                AEBaseCameraUnit.c0(z16);
            }
        }
        if (DeviceInfoMonitor.getModel().contains("Pixel 2")) {
            View decorView = z16.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-5));
        }
        View view = this.N0;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ab());
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        ao beautyAndFilterPanelViewStubHolder;
        IFriendDataService iFriendDataService;
        Friends friend;
        GenderType genderType;
        this.f61847i1 = super.q(viewGroup);
        this.f61868u0 = I1();
        this.f61869v0 = E1();
        ((AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryTopBarViewModel.class)).f63374m.setValue(this.T);
        o1();
        g2();
        j2();
        h2();
        AEMaterialPanel aEMaterialPanel = this.Q0;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.setMaterialPanelListener(this.f61870w0);
            this.Q0.setVisibility(8);
        }
        AEARCakePanel aEARCakePanel = this.R0;
        if (aEARCakePanel != null) {
            aEARCakePanel.setMaterialPanelListener(this.f61871x0, l2());
        }
        this.f61852l0 = new AETipsViewController(this.D, this.f61869v0);
        if (!gq.a.v(z().getIntent())) {
            FilterPagerViewStubHolder filterPagerViewStubHolder = new FilterPagerViewStubHolder((ViewStub) this.D.findViewById(R.id.s1e));
            this.V0 = filterPagerViewStubHolder;
            this.Z0.f61911m.postValue(filterPagerViewStubHolder);
            this.V0.q(this.U == AECaptureMode.NORMAL);
        }
        at.b(au.a());
        if (G1()) {
            beautyAndFilterPanelViewStubHolder = new DYBeautyAndFilterPanelViewStubHolder((ViewStub) this.D.findViewById(R.id.s1y));
        } else {
            beautyAndFilterPanelViewStubHolder = new BeautyAndFilterPanelViewStubHolder((ViewStub) this.D.findViewById(R.id.f163791s12));
        }
        this.U0 = beautyAndFilterPanelViewStubHolder;
        this.Z0.f61910i.setValue(beautyAndFilterPanelViewStubHolder);
        this.U0.e(this.f61862q0);
        FilterPagerViewStubHolder filterPagerViewStubHolder2 = this.V0;
        if (filterPagerViewStubHolder2 != null) {
            this.f61866s0 = filterPagerViewStubHolder2.o();
        }
        LinearLayout linearLayout = this.J;
        boolean z16 = linearLayout != null && linearLayout.getVisibility() == 0;
        if (ms.a.g()) {
            ms.a.f(this.f61816f, "onCreateView needLiuHaiTop:" + z16);
        }
        String stringExtra = z().getIntent().getStringExtra(AECameraConstants.KEY_GUIDE_IMAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            byte[] a16 = com.tencent.mobileqq.musicpendant.a.a(stringExtra.substring(22));
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a16, 0, a16.length);
            if (BitmapUtils.isLegal(decodeByteArray)) {
                ImageView imageView = (ImageView) this.D.findViewById(R.id.rox);
                imageView.setImageBitmap(decodeByteArray);
                imageView.setVisibility(0);
            }
        }
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (account != null && (iFriendDataService = (IFriendDataService) com.tencent.aelight.camera.aebase.a.a().getRuntimeService(IFriendDataService.class, "all")) != null && (friend = iFriendDataService.getFriend(account, true)) != null) {
            MutableLiveData<Integer> L1 = this.f61832a1.L1();
            if (friend.gender == 1) {
                genderType = GenderType.MALE;
            } else {
                genderType = GenderType.FEMALE;
            }
            L1.postValue(Integer.valueOf(genderType.value));
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.L0.await(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            ms.a.c(this.f61816f, "[UnitAsyncInit] await interrupt exp: " + e16.getMessage());
        }
        ms.a.f(this.f61816f, "[UnitAsyncInit] await time cost: " + (System.currentTimeMillis() - currentTimeMillis));
        K2();
        q1(this.f61847i1);
        if (js.a.Q.d(this.W.k())) {
            ThreadManagerV2.excute(new AEDownloadMaterialRunnable(true), 128, null, true);
        } else if (!l2()) {
            ThreadManagerV2.excute(new AEDownloadMaterialRunnable(), 128, null, true);
        }
        return this.f61847i1;
    }

    public void q2() {
        z().getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
        com.tencent.aelight.camera.ae.util.p.d(z());
    }

    public void s1(String str, String str2) {
        AECameraGLSurfaceView aECameraGLSurfaceView = this.E;
        if (aECameraGLSurfaceView != null) {
            aECameraGLSurfaceView.setBundlePath(str, str2);
        }
    }

    public void s3(double d16) {
        com.tencent.aelight.camera.ae.e eVar = this.O0;
        if (eVar != null) {
            eVar.X1("makeup.strength", Double.toString(d16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public void t() {
        super.t();
        this.N0 = this.D.findViewById(R.id.ru7);
        this.Q0 = (AEMaterialPanel) this.D.findViewById(R.id.ryz);
        this.R0 = (AEARCakePanel) this.D.findViewById(R.id.ryy);
    }

    public void t1() {
        this.f61868u0.g();
    }

    protected void u1() {
        Intent intent = new Intent();
        intent.setAction("ae_editor_bottom_tab_show_hide");
        intent.putExtra("is_show", true);
        z().sendBroadcast(intent);
        this.f61869v0.q(131077, new Object[0]);
    }

    protected void u2(int i3, AEFilterManager aEFilterManager) {
        com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
        if (cVar != null) {
            cVar.q(196617, Integer.valueOf(i3), aEFilterManager);
        }
    }

    protected void v1() {
        Intent intent = new Intent();
        intent.setAction("ae_editor_bottom_tab_show_hide");
        intent.putExtra("is_show", false);
        z().sendBroadcast(intent);
        this.f61869v0.q(131076, new Object[0]);
    }

    protected void v2(int i3, int i16, int i17, int i18) {
        Log.d(this.f61816f, "notifyPreviewSizeChanged: ");
        this.f61836d0 = i3;
        this.f61838e0 = i16;
        com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
        if (cVar != null) {
            cVar.q(851973, Arrays.asList(Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    public void x2() {
        this.f61817h.getActivity().onBackPressed();
    }

    public void y1(boolean z16) {
        if (this.F == null) {
            return;
        }
        if (z16) {
            this.f61869v0.q(327687, new Object[0]);
        } else {
            this.f61869v0.q(327688, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<QIMFilterCategoryItem> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QIMFilterCategoryItem qIMFilterCategoryItem) {
            if (qIMFilterCategoryItem != null) {
                VideoReport.setPageParams(AEPituCameraUnit.this.z(), AECameraConstants.AE_FILTER_ID, qIMFilterCategoryItem.f66697d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<AECaptureModeChangingEvent> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent != null) {
                AEPituCameraUnit.this.y2(aECaptureModeChangingEvent.f65598a, aECaptureModeChangingEvent.f65599b);
                VideoReport.setPageParams(AEPituCameraUnit.this.z(), "ae_content_type", Integer.valueOf(aECaptureModeChangingEvent.f65599b.index));
            }
        }
    }

    /* loaded from: classes32.dex */
    class s implements AECameraManager.CameraOpenCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AECameraManager.CameraOpenCallback f61931a;

        s(AECameraManager.CameraOpenCallback cameraOpenCallback) {
            this.f61931a = cameraOpenCallback;
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                AEPituCameraUnit.this.E.onChangeCamera(i3);
                if (AEPituCameraUnit.this.V()) {
                    AEPituCameraUnit.this.d0(i3);
                }
                AEPituCameraUnit.this.Y();
                AEPituCameraUnit.this.r0();
            }
            this.f61931a.onOpenResult(i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class t implements AECameraManager.CameraOpenCallback {
        t() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                if (AEPituCameraUnit.this.V()) {
                    AEPituCameraUnit.this.d0(i3);
                }
                AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
                if (aEPituCameraUnit.X) {
                    aEPituCameraUnit.r0();
                } else {
                    aEPituCameraUnit.w(false);
                }
            }
        }
    }

    private void A1() {
        this.f61846i0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        this.D0 = true;
        this.T0.N1().postValue(Boolean.TRUE);
        if (this.f61819m.isFlashEnabled() && this.U != AECaptureMode.GIF) {
            this.f61819m.turnFlash(z(), true);
        }
        this.E.startCaptureVideoInGLThread();
        AEFilterManager aEFilterManager = this.f61834c0;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_START_RECORD, f61829s1);
        }
        if (!this.f61819m.isFrontCamera()) {
            this.f61819m.setFocusModeRecording();
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I(true);
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onCaptureError(final int i3) {
        this.D0 = false;
        this.T0.N1().postValue(Boolean.FALSE);
        ms.a.d(this.f61816f, "onCaptureError. errorCode = " + i3, new Throwable());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.60

            /* renamed from: com.tencent.aelight.camera.ae.AEPituCameraUnit$60$a */
            /* loaded from: classes32.dex */
            class a implements al {
                a() {
                }

                @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit.al
                public void callback() {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1a), 0).show();
                    AEPituCameraUnit.this.f61853l1 = null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                switch (i3) {
                    case 101:
                    case 104:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1c), 1).show();
                        Activity z16 = AEPituCameraUnit.this.z();
                        if (z16 == null || z16.isFinishing()) {
                            return;
                        }
                        z16.finish();
                        return;
                    case 102:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1d), 0).show();
                        AEPituCameraUnit.this.c3();
                        return;
                    case 103:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1b), 0).show();
                        return;
                    case 105:
                        AEPituCameraUnit.this.f61853l1 = new a();
                        AEPituCameraUnit.this.f61869v0.q(262149, new Object[0]);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
    public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
        this.D0 = false;
        this.T0.N1().postValue(Boolean.FALSE);
        if (!z16) {
            onCaptureError(101);
            return;
        }
        ms.a.f(this.f61816f, "[onVideoCaptured] videoInfo = " + localMediaInfo.mDuration);
        AEBaseReportParam.U().D0(2L);
        if (G1()) {
            com.tencent.aelight.camera.ae.report.e.b().f(this, localMediaInfo.mDuration);
            com.tencent.aelight.camera.ae.report.b.b().e0(new HashMap<>(com.tencent.aelight.camera.ae.report.e.b().a()));
        } else {
            com.tencent.aelight.camera.ae.report.b.b().n1(localMediaInfo.mDuration);
        }
        n3(false);
        this.f61869v0.q(196609, new Object[0]);
        this.f61869v0.q(262146, this.L, localMediaInfo, Integer.valueOf(this.V), this.P, this.f61869v0.b(196610, new Object[0]));
    }

    /* loaded from: classes32.dex */
    class a implements AEARCakeMaterialManager.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.b
        public void b(AEMaterialMetaData aEMaterialMetaData) {
            if (AEPituCameraUnit.this.f61852l0 != null) {
                AEPituCameraUnit.this.f61852l0.j();
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.b
        public void a(AEMaterialMetaData aEMaterialMetaData, int i3) {
            if (aEMaterialMetaData == null || AEPituCameraUnit.this.f61852l0 == null) {
                return;
            }
            AEARCakeMaterial h16 = AEARCakeMaterialManager.i().h();
            boolean p16 = AEARCakeMaterialManager.i().p();
            if (h16 != null && !p16) {
                if (TextUtils.equals(aEMaterialMetaData.cakeId, h16.cakeId)) {
                    AEPituCameraUnit.this.f61852l0.s(i3);
                    return;
                }
                return;
            }
            AEPituCameraUnit.this.f61852l0.j();
        }
    }

    private void Y1(AECaptureMode aECaptureMode, AECaptureMode aECaptureMode2) {
        int g16;
        if (aECaptureMode != null && aECaptureMode.shouldStartCamera()) {
            l0();
        }
        if (!aECaptureMode2.shouldStartCamera()) {
            w(false);
            return;
        }
        if (this.W.g() == 0) {
            g16 = J();
        } else {
            g16 = this.W.g();
        }
        if (aECaptureMode2 == AECaptureMode.GIF) {
            g16 = 1;
        }
        if (!this.X) {
            this.f61819m.setSelectedCamera(g16);
        } else if (this.Z) {
            this.f61819m.changeCamera(g16, new t());
        }
    }

    private void Z1(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey(QQWinkConstants.MATERIAL_GUIDE_VIDEO)) {
            return;
        }
        String str = hashMap.get(QQWinkConstants.MATERIAL_GUIDE_VIDEO);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ms.a.f(this.f61816f, "guideVideo:" + str);
        this.O0.b2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k2(AEMaterialMetaData aEMaterialMetaData) {
        AEFilterManager aEFilterManager;
        return (aEMaterialMetaData == null || !aEMaterialMetaData.isdoubleclick || (aEFilterManager = this.f61834c0) == null || aEFilterManager.wmGetEditableWMElements() == null || this.f61834c0.wmGetEditableWMElements().size() <= 0) ? false : true;
    }

    public void o3() {
        com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
        if (gq.a.f(this.W.k())) {
            dVar.l(14);
        } else {
            dVar.l(this.P.f423403c);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onSetFilterProcess(AEFilterProcessTex aEFilterProcessTex) {
        AETipsViewController aETipsViewController;
        if (aEFilterProcessTex != null && (aETipsViewController = this.f61852l0) != null) {
            aEFilterProcessTex.J0(aETipsViewController.i());
        }
        if (aEFilterProcessTex != null) {
            this.f61834c0 = aEFilterProcessTex.P();
        } else {
            this.f61834c0 = null;
        }
    }

    private void q1(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.s2l);
        if (constraintLayout == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.s2m);
        int a16 = com.tencent.videocut.utils.p.f384261d.a();
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        if (oVar.c(view.getContext()) / oVar.d(view.getContext()) <= 1.7777778f) {
            int e16 = com.tencent.aelight.camera.ae.camera.ui.gallery.t.e(view.getContext());
            Resources resources = view.getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f13159e);
            constraintLayout.setPadding(0, a16 + com.tencent.videocut.utils.e.f384236a.a(48.0f), 0, e16 + dimensionPixelSize + resources.getDimensionPixelSize(R.dimen.f13179g) + resources.getDimensionPixelSize(R.dimen.f13169f) + resources.getDimensionPixelSize(R.dimen.f13139c));
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.bottomToBottom = 0;
            layoutParams.dimensionRatio = null;
            return;
        }
        constraintLayout.setPadding(0, a16 + com.tencent.videocut.utils.e.f384236a.a(48.0f), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar, boolean z16) {
        com.tencent.aelight.camera.ae.camera.ui.panel.f D2;
        int M1;
        if (bVar == null || (D2 = AEProviderViewModel.D2(bVar)) == null) {
            return;
        }
        D2.getName();
        String maskPath = D2.getMaskPath();
        int i3 = ai.f61906a[bVar.getType().ordinal()];
        if (i3 == 1) {
            int i16 = "lipstick_shanhu_male".equals(D2.getType()) ? 0 : 2;
            M1 = D2.getEnable() ? M1(bVar) : 0;
            if (z16) {
                this.E.setBeautyOrTransformLevel(bVar.getType(), M1);
                return;
            } else {
                this.E.openAndUpdateBasicLips(maskPath, M1, i16);
                this.E.openBeautyEnable(true);
                return;
            }
        }
        if (i3 == 2) {
            int M12 = M1(bVar);
            if ("red_check_ri_chang_male".equals(D2.getType())) {
                M12 = (int) (M12 * 0.6f);
            }
            M1 = D2.getEnable() ? M12 : 0;
            if (z16) {
                this.E.setBeautyOrTransformLevel(bVar.getType(), M1);
                return;
            } else {
                this.E.openAndUpdateBasicMultiply(maskPath, M1);
                this.E.openBeautyEnable(true);
                return;
            }
        }
        if (i3 != 3) {
            if (i3 != 4) {
                return;
            }
            M1 = D2.getEnable() ? M1(bVar) : 0;
            this.E.openFaceThinEnable(D2.getType());
            this.E.setBeautyOrTransformLevel(bVar.getType(), M1);
            return;
        }
        M1 = D2.getEnable() ? M1(bVar) : 0;
        if (z16) {
            this.E.setBeautyOrTransformLevel(bVar.getType(), M1);
        } else {
            this.E.openAndUpdateBasicSoftLight(maskPath, M1);
            this.E.openBeautyEnable(true);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public boolean m(int i3, KeyEvent keyEvent, boolean z16) {
        if (i3 == 4) {
            onBackPressed();
        }
        return super.m(i3, keyEvent, z16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
    public void onAssetProcessingData(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        if (hashMap.containsKey("lightasset.behaviour.report")) {
            com.tencent.aelight.camera.ae.report.b.b().k1(hashMap.get("lightasset.behaviour.report"));
        } else if (hashMap.containsKey("lightasset.behaviour.ark.start_capture_cover")) {
            ms.a.f(this.f61816f, "ArkVideo---start_capture_cover");
            if (this.D0) {
                this.E.onStartCaptureCover();
            }
        } else if (hashMap.containsKey("lightasset.behaviour.ark.score")) {
            z().getIntent().putExtra(AECameraConstants.KEY_SEND_ARK_MSG_GAME_SCORE, hashMap.get("lightasset.behaviour.ark.score"));
        }
        String str = hashMap.get("material_result");
        if ("did_show_image".equals(str)) {
            ms.a.f(this.f61816f, "AIBeauty---did_show_image");
            com.tencent.aelight.camera.ae.camera.aibeauty.c.f62199a.i(((com.tencent.aelight.camera.ae.camera.aibeauty.d) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.aibeauty.d.class)).L1().getValue());
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.48
                @Override // java.lang.Runnable
                public void run() {
                    AEPituCameraUnit.this.F1();
                }
            }, 3000L);
            com.tencent.aelight.camera.ae.report.b.b().E0();
        } else if ("did_hit_image".equals(str)) {
            ms.a.f(this.f61816f, "AIBeauty---did_hit_image");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEPituCameraUnit.49
                @Override // java.lang.Runnable
                public void run() {
                    AEPituCameraUnit.this.f61869v0.q(327702, new Object[0]);
                }
            });
            com.tencent.aelight.camera.ae.report.b.b().H();
        }
        X1(hashMap);
        Z1(hashMap);
        this.f61846i0 = hashMap;
    }

    public void z2(AECompoundButton aECompoundButton) {
        if (aECompoundButton == null) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200L);
        aECompoundButton.startAnimation(rotateAnimation);
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(aECompoundButton.a(), 200L, null);
        if (!n2()) {
            com.tencent.aelight.camera.ae.report.b.b().J1();
            ms.a.f(this.f61816f, "\u3010Change Camera\u3011:isFrontCamera:" + this.f61819m.isFrontCamera());
        }
        o0();
        if (Q()) {
            com.tencent.aelight.camera.aebase.c.b(13, null);
        }
        vq.a.f443174a.a(aECompoundButton, null);
        if (AppSetting.f99565y) {
            if (this.f61819m.isFrontCamera()) {
                AccessibilityUtil.p(aECompoundButton, HardCodeUtil.qqStr(R.string.f169905y83));
            } else {
                AccessibilityUtil.p(aECompoundButton, HardCodeUtil.qqStr(R.string.f169906y84));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(com.tencent.aelight.camera.ae.r rVar) {
        String str;
        AEMaterialMetaData aEMaterialMetaData = rVar == null ? null : rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (this.f61850k0) {
            this.f61850k0 = false;
        }
        this.f61868u0.v(aEMaterialMetaData);
        com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
        Object[] objArr = new Object[1];
        objArr[0] = aEMaterialMetaData == null ? AEMaterialMetaData.MATERIAL_NONE : aEMaterialMetaData;
        cVar.q(851970, objArr);
        if (aEMaterialMetaData != null) {
            VideoReport.setPageParams(z(), "ae_motion_id", aEMaterialMetaData.f69050id);
        }
        if (aEMaterialMetaData == null) {
            str = "0";
        } else {
            str = aEMaterialMetaData.f69050id;
        }
        com.tencent.aelight.camera.report.atta.e.c(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public AECaptureMode[] L(int i3) {
        AECaptureMode[] aECaptureModeArr;
        switch (i3) {
            case 201:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF};
                break;
            case 202:
            case 203:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.GIF};
                break;
            case 204:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.NORMAL, AECaptureMode.PLAY};
                break;
            case 205:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.NORMAL, AECaptureMode.GIF};
                break;
            case 206:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.PLAY};
                break;
            case 207:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.PLAY, AECaptureMode.GIF};
                break;
            case 208:
                AECaptureMode aECaptureMode = AECaptureMode.NORMAL;
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.PLAY};
                break;
            default:
                aECaptureModeArr = new AECaptureMode[]{AECaptureMode.NORMAL};
                break;
        }
        ms.a.f(this.f61816f, "initCaptureModesAndFirstMode---initialMode=" + this.R + ", initialCModes=" + Arrays.toString(aECaptureModeArr));
        return aECaptureModeArr;
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void notifyEnableLutType(int i3) {
        if (i3 == 1000) {
            W2(1);
            com.tencent.aelight.camera.ae.part.c cVar = this.f61869v0;
            if (cVar != null) {
                cVar.q(196609, new Object[0]);
            }
        } else {
            W2(0);
        }
        AEFilterProcessTex aEFilterManager = AEFilterManagerHolder.getAEFilterManager();
        if (aEFilterManager != null) {
            aEFilterManager.U = i3 != 1000;
            if (i3 == 1000) {
                aEFilterManager.j0();
            }
        }
        AECaptureController aECaptureController = this.f61868u0;
        if (aECaptureController != null) {
            aECaptureController.f62325m = i3 != 1000;
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void notifyEnableMeshType(int i3) {
        X2(i3 == 2001 ? 4 : 3);
    }

    public void r3(int i3, Object obj, int i16, boolean z16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ms.a.f(this.f61816f, "update light camera effect with cosmetics");
                    this.E.updateFenGeAlpha(i16);
                    VideoReport.setPageParams(z(), "ae_cosmetic_value", Integer.valueOf(i16));
                    return;
                } else if (i3 != 4) {
                    return;
                }
            }
            ms.a.f(this.f61816f, "update light camera effect with beauty");
            if (obj instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
                p3((com.tencent.aelight.camera.ae.camera.ui.panel.b) obj, z16);
                VideoReport.setPageParams(z(), "ae_beauty_value", "");
                return;
            }
            return;
        }
        ms.a.f(this.f61816f, "update light camera effect with filter");
        this.E.updateLutAlpha(i16);
        VideoReport.setPageParams(z(), "ae_filter_value", Integer.valueOf(i16));
    }

    public AEPituCameraUnit(or.e eVar, or.d dVar) {
        super(eVar, dVar);
        this.f61840f0 = null;
        this.f61844h0 = new AnonymousClass1();
        this.f61848j0 = false;
        this.f61850k0 = false;
        this.f61870w0 = new m();
        this.f61871x0 = new q();
        this.f61872y0 = new r();
        this.f61873z0 = new aa();
        this.A0 = new aj();
        this.B0 = new ak();
        this.C0 = new AECameraBroadcastReceiver(this);
        this.D0 = false;
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = 0L;
        this.H0 = -1L;
        this.I0 = false;
        this.K0 = false;
        this.L0 = new CountDownLatch(1);
        this.M0 = false;
        this.f61849j1 = new am(this);
        this.f61851k1 = false;
        ms.a.f(this.f61816f, "[AEPituCameraUnit] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        tq.b.h().o("unitConstructor-begin");
        Log.d(this.f61816f, "AEPituCameraUnit: cameraConfig.getFrom() =" + this.W.k());
        this.V = 11;
        if (js.a.M.d(this.W.k())) {
            this.V = 1;
            this.P = new or.a(10000, 100, 15);
        } else if (Q()) {
            this.V = 13;
            this.P = new or.a(10023, this.W.j(), this.W.c());
        } else if (gq.a.I(this.W.k())) {
            this.V = 1;
        } else if (!gq.a.f(this.W.k())) {
            this.V = this.W.h().intValue();
            this.P = new or.a(this.f61817h.getActivity().getIntent().getIntExtra("edit_video_type", 10002), this.W.j(), this.W.c());
        } else {
            this.V = 1;
        }
        Y2();
        i2();
        ms.a.f(this.f61816f, "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void n3(boolean z16) {
    }

    /* loaded from: classes32.dex */
    class m implements AEMaterialPanel.e {
        m() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void a(AEMaterialMetaData aEMaterialMetaData) {
            AEPituCameraUnit aEPituCameraUnit = AEPituCameraUnit.this;
            if (aEPituCameraUnit.U == AECaptureMode.NORMAL) {
                com.tencent.aelight.camera.ae.e eVar = aEPituCameraUnit.O0;
                if (eVar != null) {
                    eVar.S1(0, aEMaterialMetaData);
                    return;
                }
                return;
            }
            ms.a.c(aEPituCameraUnit.f61816f, "onMaterialSelected---but current capture mode is not normal");
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void c() {
            com.tencent.aelight.camera.ae.e eVar = AEPituCameraUnit.this.O0;
            if (eVar != null) {
                eVar.L1();
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void b() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w2(boolean z16, String str) {
    }
}
