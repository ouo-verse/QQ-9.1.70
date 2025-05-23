package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAELocalMaterialItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.aelight.camera.ae.camera.ui.panel.br;
import com.tencent.aelight.camera.ae.camera.ui.panel.bv;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.LSCameraManager;
import com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.flashshow.receiver.LSCameraBroadcastReceiver;
import com.tencent.aelight.camera.ae.flashshow.switchHelper.SwitchHelper;
import com.tencent.aelight.camera.ae.flashshow.tips.LSTipsViewController;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart;
import com.tencent.aelight.camera.ae.flashshow.ui.beauty.AIBeautyFaceType;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton;
import com.tencent.aelight.camera.ae.flashshow.ui.panel.LSBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.gif.a;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.util.LiuHaiUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jq.a;
import jq.b;
import jq.d;
import jq.f;
import kotlin.Pair;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.bean.ExposureInfo;
import org.light.bean.WMElement;
import org.light.report.LightReportManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSMiddleCameraUnit extends LSBaseCameraUnit implements m.c, LSCameraGLSurfaceView.t, h.a, MediaScanner.OnMediaInfoScannerListener, AEFilterManager.MaterialInnerEffectListener, AbsLSCaptureButton.a, LSDashboardPart.s, View.OnTouchListener, View.OnClickListener {

    /* renamed from: q1, reason: collision with root package name */
    public static String f63916q1 = "{}";

    /* renamed from: r1, reason: collision with root package name */
    public static boolean f63917r1 = false;

    /* renamed from: s1, reason: collision with root package name */
    public static boolean f63918s1 = false;
    protected a.InterfaceC10605a A0;
    protected f.b B0;
    protected d.a C0;
    protected final LSCameraGLSurfaceView.u D0;
    private LSCameraBroadcastReceiver E0;
    protected boolean F0;
    protected int G0;
    protected int H0;
    private long I0;
    private long J0;
    private boolean K0;
    public boolean L0;
    private boolean M0;
    private boolean N0;
    private boolean O0;
    protected View P0;
    protected com.tencent.aelight.camera.ae.e Q0;
    protected com.tencent.aelight.camera.ae.camera.ui.panel.t R0;
    protected AEMaterialPanel S0;
    private com.tencent.aelight.camera.ae.flashshow.mode.a T0;
    private com.tencent.aelight.camera.ae.part.a U0;
    private com.tencent.aelight.camera.ae.flashshow.ui.panel.d V0;
    private AECompoundButton W0;
    private AECompoundButton X0;
    private ImageView Y0;
    private ai Z0;

    /* renamed from: a1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.z f63919a1;

    /* renamed from: b1, reason: collision with root package name */
    private MusicSourceViewModel f63920b1;

    /* renamed from: c1, reason: collision with root package name */
    private AEFlashShowBottomPanelViewModel f63921c1;

    /* renamed from: d1, reason: collision with root package name */
    private Runnable f63922d1;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f63923e1;

    /* renamed from: f0, reason: collision with root package name */
    protected AEFilterManager f63924f0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f63925f1;

    /* renamed from: g0, reason: collision with root package name */
    private int f63926g0;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f63927g1;

    /* renamed from: h0, reason: collision with root package name */
    private int f63928h0;

    /* renamed from: h1, reason: collision with root package name */
    private View f63929h1;

    /* renamed from: i0, reason: collision with root package name */
    private Bitmap f63930i0;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f63931i1;

    /* renamed from: j0, reason: collision with root package name */
    private List<Runnable> f63932j0;

    /* renamed from: j1, reason: collision with root package name */
    private ah f63933j1;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f63934k0;

    /* renamed from: k1, reason: collision with root package name */
    private AEBeautyProviderViewModel f63935k1;

    /* renamed from: l0, reason: collision with root package name */
    protected final LSCameraManager.a f63936l0;

    /* renamed from: l1, reason: collision with root package name */
    private AEBodyProviderViewModel f63937l1;

    /* renamed from: m0, reason: collision with root package name */
    private HashMap<String, String> f63938m0;

    /* renamed from: m1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.aa f63939m1;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f63940n0;

    /* renamed from: n1, reason: collision with root package name */
    private AEProviderViewModel f63941n1;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f63942o0;

    /* renamed from: o1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.ac f63943o1;

    /* renamed from: p0, reason: collision with root package name */
    private LSTipsViewController f63944p0;

    /* renamed from: p1, reason: collision with root package name */
    protected AEVideoStoryTopBarViewModel f63945p1;

    /* renamed from: q0, reason: collision with root package name */
    protected jq.f f63946q0;

    /* renamed from: r0, reason: collision with root package name */
    protected jq.c f63947r0;

    /* renamed from: s0, reason: collision with root package name */
    protected jq.a f63948s0;

    /* renamed from: t0, reason: collision with root package name */
    protected jq.d f63949t0;

    /* renamed from: u0, reason: collision with root package name */
    protected jq.b f63950u0;

    /* renamed from: v0, reason: collision with root package name */
    protected jq.e f63951v0;

    /* renamed from: w0, reason: collision with root package name */
    protected GestureDetector f63952w0;

    /* renamed from: x0, reason: collision with root package name */
    protected LSCaptureController f63953x0;

    /* renamed from: y0, reason: collision with root package name */
    protected lq.b f63954y0;

    /* renamed from: z0, reason: collision with root package name */
    protected AEMaterialPanel.e f63955z0;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements LSCameraManager.a {

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$1$2, reason: invalid class name */
        /* loaded from: classes32.dex */
        class AnonymousClass2 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AnonymousClass1 f63958d;

            @Override // java.lang.Runnable
            public void run() {
                LSMiddleCameraUnit.this.getClass();
                throw null;
            }
        }

        AnonymousClass1() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void a() {
            LSMiddleCameraUnit.this.n2();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void onCameraPreviewSizeChanged(int i3, int i16) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onCameraPreviewSizeChanged---width=" + i3 + ", height=" + i16);
            LSCameraGLSurfaceView lSCameraGLSurfaceView = LSMiddleCameraUnit.this.E;
            if (lSCameraGLSurfaceView != null) {
                lSCameraGLSurfaceView.s1(i3, i16);
            }
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void onCameraPreviewStarted() {
            LSCameraGLSurfaceView lSCameraGLSurfaceView = LSMiddleCameraUnit.this.E;
            if (lSCameraGLSurfaceView != null) {
                lSCameraGLSurfaceView.t1();
            }
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void onCameraReadyToPreview() {
            LSMiddleCameraUnit.this.p0();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void onCameraStarted(boolean z16, String str) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onCameraStarted--success=" + z16 + ", errMsg=" + str);
            LSMiddleCameraUnit.this.j2(z16, str);
            if (z16) {
                tq.b.h().o("onCameraStart");
            }
            if (!z16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LSMiddleCameraUnit.this.i0();
                    }
                });
            } else {
                LSMiddleCameraUnit.this.getClass();
            }
            if (LSMiddleCameraUnit.this.x1() && LSMiddleCameraUnit.this.f63941n1 != null) {
                LSMiddleCameraUnit.this.J2();
                LSMiddleCameraUnit.this.K2();
                boolean z17 = ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getBoolean(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, true, 0);
                LSMiddleCameraUnit.this.f63941n1.J2(z17);
                ms.a.f(LSMiddleCameraUnit.this.f63731f, "toggleAiBeauty on camera start: " + z17);
            } else {
                int m3 = AEBeautyProviderView.m();
                int n3 = AEBeautyProviderView.n();
                LSCaptureController lSCaptureController = LSMiddleCameraUnit.this.f63953x0;
                if (lSCaptureController != null) {
                    lSCaptureController.u(m3);
                    LSMiddleCameraUnit.this.f63953x0.z(n3);
                }
            }
            LSCameraGLSurfaceView lSCameraGLSurfaceView = LSMiddleCameraUnit.this.E;
            if (lSCameraGLSurfaceView != null) {
                lSCameraGLSurfaceView.M1();
            }
            LSMiddleCameraUnit.this.f63954y0.q(458753, new Object[0]);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.a
        public void onRetryOpenCamera() {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onRetryOpenCamera|OpenCamera Error.need retry!");
            LSMiddleCameraUnit.this.f63730d0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.1.3

                /* compiled from: P */
                /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$1$3$a */
                /* loaded from: classes32.dex */
                class a implements LSCameraManager.b {
                    a() {
                    }

                    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
                    public void onOpenResult(int i3, boolean z16) {
                        ms.a.f(LSMiddleCameraUnit.this.f63731f, "onRetryOpenCamera post| tryStartPreview.");
                        LSMiddleCameraUnit.this.p0();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f(LSMiddleCameraUnit.this.f63731f, "onRetryOpenCamera post| will retry in the UI thread");
                    LSMiddleCameraUnit.this.f63734m.stopCamera(false);
                    LSMiddleCameraUnit.this.f63734m.v(new a());
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$32, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass32 implements Runnable {
        final /* synthetic */ LSMiddleCameraUnit this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.H2();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$33, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass33 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LazyLoadAnimationDrawable f63964d;
        final /* synthetic */ LSMiddleCameraUnit this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.Y0 == null) {
                this.this$0.Y0 = (ImageView) ((ViewStub) this.this$0.D.findViewById(R.id.s1b)).inflate().findViewById(R.id.ro9);
            }
            LSMiddleCameraUnit lSMiddleCameraUnit = this.this$0;
            lSMiddleCameraUnit.f63730d0.postDelayed(lSMiddleCameraUnit.f63922d1, this.f63964d.getTotalDuration());
            this.this$0.Y0.setVisibility(0);
            this.this$0.Y0.setImageDrawable(this.f63964d);
            this.f63964d.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class aa implements Observer<SeekBarOpDataWrapper> {
        aa() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(SeekBarOpDataWrapper seekBarOpDataWrapper) {
            if (LSMiddleCameraUnit.this.x1() && seekBarOpDataWrapper != null) {
                if (!seekBarOpDataWrapper.getRefreshEffect()) {
                    ms.a.f(LSMiddleCameraUnit.this.f63731f, "not refresh effect");
                    return;
                }
                int type = seekBarOpDataWrapper.getType();
                Object opData = seekBarOpDataWrapper.getOpData();
                if (type != 2) {
                    if (type == 4 && (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b)) {
                        com.tencent.aelight.camera.ae.camera.ui.panel.b bVar = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
                        ms.a.a(LSMiddleCameraUnit.this.f63731f, "bodySelected: " + bVar.getKey());
                        if (bVar.getType() == BeautyRealConfig.TYPE.NONE) {
                            if (bVar.getEnable()) {
                                LSMiddleCameraUnit.this.K2();
                                return;
                            } else {
                                LSMiddleCameraUnit.this.s1();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
                    com.tencent.aelight.camera.ae.camera.ui.panel.b bVar2 = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
                    ms.a.a(LSMiddleCameraUnit.this.f63731f, "beautySelected: " + bVar2.getKey());
                    if (!bVar2.i().isEmpty()) {
                        LSMiddleCameraUnit.this.R2(bVar2, false);
                        return;
                    }
                    if (bVar2.getType() == BeautyRealConfig.TYPE.NONE) {
                        if (bVar2.getEnable()) {
                            LSMiddleCameraUnit.this.J2();
                            return;
                        } else {
                            LSMiddleCameraUnit.this.r1();
                            return;
                        }
                    }
                    if (bVar2.getType() == BeautyRealConfig.TYPE.EYE_MAKEUP) {
                        LSMiddleCameraUnit.this.E.D1(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ab implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        ab() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (LSMiddleCameraUnit.this.x1()) {
                LSMiddleCameraUnit.this.J2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ac implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        ac() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (LSMiddleCameraUnit.this.x1()) {
                LSMiddleCameraUnit.this.K2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ad implements Observer<List<com.tencent.aelight.camera.ae.camera.ui.panel.b>> {
        ad() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.tencent.aelight.camera.ae.camera.ui.panel.b> list) {
            if (LSMiddleCameraUnit.this.x1()) {
                LSMiddleCameraUnit.this.K2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ae implements Observer<Boolean> {
        ae() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "AiBeautyToggle---onChanged: " + bool);
            if (bool != null) {
                ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).putBoolean(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, bool.booleanValue(), 0);
                LSMiddleCameraUnit.this.E.b2(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class af {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f63991a;

        static {
            int[] iArr = new int[BeautyRealConfig.TYPE.values().length];
            f63991a = iArr;
            try {
                iArr[BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63991a[BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63991a[BeautyRealConfig.TYPE.FACE_FEATURE_SOFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63991a[BeautyRealConfig.TYPE.FACTOR_THIN_NEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class ag implements LSCameraGLSurfaceView.u {
        ag() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void a() {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onFirstFrameAfterStartPreviewDone");
            LSMiddleCameraUnit.this.e1();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onBasicBeautyDownload() {
            LSMiddleCameraUnit.this.r2();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onDrawFrameWithEffect(int i3, AEFilterManager aEFilterManager) {
            LSMiddleCameraUnit.this.g2(i3, aEFilterManager);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onFirstFrameDone() {
            tq.b.h().o("onFirstFrameDone");
            LSMiddleCameraUnit.this.d1();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onOrientionChanged(int i3) {
            LSMiddleCameraUnit.this.f63734m.setActivityOrientation(i3);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onPreviewSizeChanged(int i3, int i16, int i17, int i18) {
            LSMiddleCameraUnit.this.f63734m.setFocusOperatorMatrix(i3, i16, i17, i18);
            LSMiddleCameraUnit.this.h2(i3, i16, i17, i18);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onPreviewSurfaceTextureCreate(SurfaceTexture surfaceTexture) {
            LSMiddleCameraUnit.this.K = surfaceTexture;
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onPreviewSurfaceTextureCreate---" + LSMiddleCameraUnit.this.K);
            LSMiddleCameraUnit.this.p0();
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.u
        public void onPreviewSurfaceTextureRelease() {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "onPreviewSurfaceTextureRelease---" + LSMiddleCameraUnit.this.K);
            LSMiddleCameraUnit.this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface ah {
        void callback();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class ai extends ViewModel {

        /* renamed from: i, reason: collision with root package name */
        public final MutableLiveData<com.tencent.aelight.camera.ae.flashshow.ui.panel.d> f63993i = new MutableLiveData<>();

        /* renamed from: m, reason: collision with root package name */
        public final MutableLiveData<FilterPagerViewStubHolder> f63994m = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Observer<Pair<String, String>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Pair<String, String> pair) {
            LSCameraGLSurfaceView lSCameraGLSurfaceView = LSMiddleCameraUnit.this.E;
            if (lSCameraGLSurfaceView == null || pair == null) {
                return;
            }
            lSCameraGLSurfaceView.setLightNodePresetData(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements Observer<bj> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bj bjVar) {
            if (LSMiddleCameraUnit.this.x1() && bjVar.getEnable()) {
                if (bjVar instanceof DYAELocalMaterialItem) {
                    LSMiddleCameraUnit.this.E.setMaterial(((DYAELocalMaterialItem) bjVar).getPath());
                    return;
                }
                if (bjVar instanceof br) {
                    AEMaterialMetaData material = ((br) bjVar).getMaterial();
                    LSMiddleCameraUnit.this.E.setLastForceMaterialPath(material.getLocalPath());
                    LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                    if (lSMiddleCameraUnit.Q0 != null) {
                        lSMiddleCameraUnit.E.z1();
                        LSMiddleCameraUnit.this.Q0.S1(1, material);
                    }
                    VideoReport.setPageParams(LSMiddleCameraUnit.this.A(), "ae_cosmetic_id", material.f69050id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, " mCurrentRatio---onChanged: ratio=" + ratio);
            if (ratio == null) {
                return;
            }
            VideoReport.setPageParams(LSMiddleCameraUnit.this.A(), "ae_ratio", ratio.toString());
            LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
            if (lSMiddleCameraUnit.V == ratio) {
                return;
            }
            lSMiddleCameraUnit.V = ratio;
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).putInt(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, ratio.code, 0);
            LSMiddleCameraUnit.this.E.setCurrentRatio(ratio);
            LSMiddleCameraUnit lSMiddleCameraUnit2 = LSMiddleCameraUnit.this;
            if (lSMiddleCameraUnit2.W == LSCaptureMode.NORMAL) {
                lSMiddleCameraUnit2.j0();
                LSMiddleCameraUnit.this.p0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "getCapturingLiveData--isCapturing=" + bool);
            AEFlashShowMaterialManager.INSTANCE.g(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "getWaterMarkPanelVisibleLiveData--isShow=" + bool);
            LSMiddleCameraUnit.this.f63923e1 = Boolean.TRUE.equals(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "getTplPanelVisibleLiveData--isShow=" + bool);
            LSMiddleCameraUnit.this.f63925f1 = Boolean.TRUE.equals(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements Observer<Boolean> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "getBeautyFilterPanelVisibleLiveData--isShow=" + bool);
            LSMiddleCameraUnit.this.f63927g1 = Boolean.TRUE.equals(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class k implements Observer<bv> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bv bvVar) {
            if (bvVar.getShow()) {
                LSMiddleCameraUnit.this.U0.P1().postValue(Boolean.TRUE);
            } else {
                LSMiddleCameraUnit.this.U0.P1().postValue(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class m implements Observer<MusicInfoWrapper> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(MusicInfoWrapper musicInfoWrapper) {
            if (musicInfoWrapper.getMusicInfo() == null) {
                LSMiddleCameraUnit.this.E.setAudioStart();
            } else {
                LSMiddleCameraUnit.this.E.setAudioPause();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class n implements a.InterfaceC10605a {
        n() {
        }

        @Override // jq.a.InterfaceC10605a
        public void a(MotionEvent motionEvent) {
            LSMiddleCameraUnit.this.y1();
            LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
            if (lSMiddleCameraUnit.J == null || lSMiddleCameraUnit.f63734m.isFrontCamera()) {
                return;
            }
            LSMiddleCameraUnit.this.J.c(motionEvent);
            LSMiddleCameraUnit.this.f63734m.requestCameraFocus(motionEvent.getX(), motionEvent.getY(), LSMiddleCameraUnit.this.E.O0(), LSMiddleCameraUnit.this.E.N0());
            if (ms.a.g()) {
                ms.a.a(LSMiddleCameraUnit.this.f63731f, "CameraFocusGesture isRecording == false");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class o implements LSCameraMaterialJSServiceManager.b {
        o() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager.b
        public void a(String str) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "OnCameraPropertyAIJceRsp: " + str);
            AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
            if (aEFilterManager != null) {
                aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class p implements LSCameraMaterialJSServiceManager.b {
        p() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager.b
        public void a(String str) {
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "OnCameraPropertyAIJceRsp: " + str);
            AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
            if (aEFilterManager != null) {
                aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class q implements f.b {
        q() {
        }

        @Override // jq.f.b
        public void a(float f16) {
            ms.a.a(LSMiddleCameraUnit.this.f63731f, "onRequestZoom: " + f16);
            LSMiddleCameraUnit.this.f63734m.setZoom(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class t implements b.a {
        t() {
        }

        @Override // jq.b.a
        public void a() {
            LSMiddleCameraUnit.this.f63734m.refreshDarkModeTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class u implements b.InterfaceC10606b {
        u() {
        }

        @Override // jq.b.InterfaceC10606b
        public void a() {
            LSMiddleCameraUnit.this.R0.L1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class v implements LSFilterProcessTex.e {
        v() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex.e
        public void a(List<Integer> list, List<Integer> list2) {
            ms.a.a(LSMiddleCameraUnit.this.f63731f, "AIBeauty---first get face data: genderList=" + list + "\nageList=" + list2);
            if (list == null || list2 == null || list.size() != list2.size() || list.size() <= 0 || list.get(0).intValue() == 0) {
                return;
            }
            LSMiddleCameraUnit.this.t2(list, list2);
            if (LSMiddleCameraUnit.this.x1()) {
                LSMiddleCameraUnit.this.E1(list, list2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class w implements a.b {
        w() {
        }

        @Override // com.tencent.aelight.camera.ae.gif.a.b
        public void a(com.tencent.aelight.camera.ae.gif.c cVar) {
            com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().postValue(cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class x implements LSCameraGLSurfaceView.v {
        x() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.v
        public void onGenderTypeListener(int i3) {
            if (i3 != GenderType.DEFAULT.value) {
                LSMiddleCameraUnit.this.f63919a1.L1().postValue(Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class y implements d.a {
        y() {
        }

        @Override // jq.d.a
        public void onDoubleTap() {
            LSMiddleCameraUnit.this.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class z implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private int f64020d = 0;

        z() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3 = this.f64020d + 1;
            this.f64020d = i3;
            if (i3 > 1) {
                ViewTreeObserver viewTreeObserver = LSMiddleCameraUnit.this.P0.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            com.tencent.aelight.camera.ae.flashshow.util.l.d(new com.tencent.mobileqq.activity.richmedia.i(LSMiddleCameraUnit.this.P0.getMeasuredWidth(), LSMiddleCameraUnit.this.P0.getMeasuredHeight()));
            ms.a.f(LSMiddleCameraUnit.this.f63731f, "mMaxPreviewSize set: " + com.tencent.aelight.camera.ae.flashshow.util.l.a());
        }
    }

    public LSMiddleCameraUnit() {
        this.f63930i0 = null;
        this.f63936l0 = new AnonymousClass1();
        this.f63940n0 = false;
        this.f63942o0 = false;
        this.f63955z0 = new l();
        this.A0 = new n();
        this.B0 = new q();
        this.C0 = new y();
        this.D0 = new ag();
        this.E0 = new LSCameraBroadcastReceiver(this);
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0L;
        this.J0 = -1L;
        this.K0 = false;
        this.M0 = false;
        this.N0 = false;
        this.O0 = com.tencent.aelight.camera.ae.util.i.a();
        this.f63931i1 = false;
        ms.a.f(this.f63731f, "[LSMiddleCameraUnit] + BEGIN");
        ms.a.a(this.f63731f, "unitConstructor--fake");
        ms.a.f(this.f63731f, "[LSMiddleCameraUnit] + END");
    }

    private int B1(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        if (bVar.i().isEmpty()) {
            return AEProviderViewModel.t2(bVar);
        }
        return AEProviderViewModel.t2(bVar.i().get(AEProviderViewModel.z2(bVar)));
    }

    private LSCaptureMode D1(LSCaptureMode[] lSCaptureModeArr, int i3) {
        boolean z16;
        String stringExtra = A().getIntent().getStringExtra(IAECameraUnit.KEY_CURRENT_TAB);
        if (TextUtils.isEmpty(stringExtra)) {
            int intExtra = A().getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, -1);
            if (i3 == 201 && js.a.f410906f.b() == intExtra) {
                return LSCaptureMode.PLAY;
            }
            stringExtra = (i3 == 204 && gq.a.g(intExtra)) ? ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getString(AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY, "", 4) : null;
        }
        LSCaptureMode fromName = LSCaptureMode.fromName(stringExtra);
        if (fromName != null) {
            for (LSCaptureMode lSCaptureMode : lSCaptureModeArr) {
                if (lSCaptureMode == fromName) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            ms.a.c(this.f63731f, "[getFirstModeAccordingABTest], get invalid mode=" + fromName);
            fromName = lSCaptureModeArr[0];
        }
        ms.a.f(this.f63731f, "[getFirstModeAccordingABTest], ABTest name=" + stringExtra + ", real picked mode=" + fromName);
        return fromName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(List<Integer> list, List<Integer> list2) {
        if (Z1()) {
            ms.a.a(this.f63731f, "from take same don't handle ai beauty");
            return;
        }
        if (Y1()) {
            ms.a.a(this.f63731f, "from qzone multi camera don't handle ai beauty");
            return;
        }
        if (this.f63940n0) {
            return;
        }
        this.f63940n0 = true;
        AIBeautyFaceType aIBeautyFaceType = AIBeautyFaceType.NO_FACE;
        com.tencent.aelight.camera.ae.flashshow.ui.beauty.a aVar = com.tencent.aelight.camera.ae.flashshow.ui.beauty.a.f64763a;
        if (aVar.c(list2)) {
            ms.a.f(this.f63731f, "AIBeauty---child");
            aIBeautyFaceType = AIBeautyFaceType.CHILD;
            if (o1() && !aVar.f()) {
                i1();
            }
        } else if (aVar.e(list)) {
            ms.a.f(this.f63731f, "AIBeauty---male");
            aIBeautyFaceType = AIBeautyFaceType.MALE;
            if (o1() && !aVar.g()) {
                i1();
            }
        } else if (aVar.d(list)) {
            ms.a.f(this.f63731f, "AIBeauty---female");
            aIBeautyFaceType = AIBeautyFaceType.FEMALE;
        }
        ((com.tencent.aelight.camera.ae.flashshow.ui.beauty.b) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.flashshow.ui.beauty.b.class)).M1(aIBeautyFaceType);
    }

    private void F1(HashMap<String, String> hashMap) {
        ms.a.a(this.f63731f, "handleAIGCMaterialPath~~~ ");
        if (hashMap != null && hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_UPLOAD_PIC)) {
            String str = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_UPLOAD_PIC);
            ms.a.a(this.f63731f, "handleAIGCMaterialPath jceReqFromJs: " + str);
            LSCameraMaterialJSServiceManager.f63895a.j(str, new o());
        }
    }

    private void H1(HashMap<String, String> hashMap) {
        String str;
        String str2;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.f63921c1;
        if (!(aEFlashShowBottomPanelViewModel != null && aEFlashShowBottomPanelViewModel.o2())) {
            ms.a.a(this.f63731f, "BeautyBody---panel not open");
            return;
        }
        AEProviderViewModel aEProviderViewModel = this.f63941n1;
        if (aEProviderViewModel == null) {
            return;
        }
        Integer value = aEProviderViewModel.C2().getValue();
        ms.a.a(this.f63731f, "BeautyBody---panel tab at " + value);
        if (value == null || value.intValue() != 3 || (str = hashMap.get("lightAsset.process.key")) == null || !str.equals("lightAsset.process.beautybody") || (str2 = hashMap.get("lightAsset.process.beautybody.error")) == null) {
            return;
        }
        try {
            Integer decode = Integer.decode(str2);
            LSFilterProcessTex.x0(decode.intValue());
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
    public void J2() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f63935k1.U1().getValue();
        if (value == null) {
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            P2(it.next(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f63937l1.S1().getValue();
        if (value == null) {
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            P2(it.next(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        LSCameraManager lSCameraManager = this.f63734m;
        if (lSCameraManager != null) {
            float horizontalViewAngle = lSCameraManager.getHorizontalViewAngle();
            int t16 = t1(this.f63734m.getSelectedCamera());
            if (t16 != 0 && t16 != 1) {
                t16 = 0;
            }
            if (horizontalViewAngle != -1.0f) {
                this.E.f2(horizontalViewAngle, t16);
            }
        }
    }

    private void P2(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar, boolean z16) {
        int B1 = B1(bVar);
        ms.a.a(this.f63731f, "beautyData = " + bVar.getKey() + ", adjustValue = " + B1);
        if (!bVar.i().isEmpty()) {
            R2(bVar, z16);
        }
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
        BeautyRealConfig.TYPE type = bVar.getType();
        if (!bVar.getEnable()) {
            B1 = 0;
        }
        lSCameraGLSurfaceView.setBeautyOrTransformLevel(type, B1);
    }

    private void U1() {
        nq.a.b().c(WinkContext.INSTANCE.i(false));
        LightReportManager.setReporter(nq.a.b());
        ms.a.f(this.f63731f, "initReporterForLightSdk---success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z1() {
        String str;
        HashMap hashMap;
        if (A() == null) {
            return false;
        }
        Intent intent = A().getIntent();
        if (intent == null || (hashMap = (HashMap) intent.getSerializableExtra("key_attrs")) == null || hashMap.isEmpty() || !hashMap.containsKey("meterial") || TextUtils.isEmpty((CharSequence) hashMap.get("meterial"))) {
            str = null;
        } else {
            str = (String) hashMap.get("meterial");
            ms.a.f("CircleTakeSame", "constructor---mPresetMaterialId=" + str);
        }
        return !TextUtils.isEmpty(str);
    }

    private boolean a2() {
        return (this.f63925f1 || this.f63923e1 || this.f63927g1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2() {
        LSCameraGLSurfaceView lSCameraGLSurfaceView;
        if (TextUtils.isEmpty(DYAEFilterProviderView.L()) || (lSCameraGLSurfaceView = this.E) == null) {
            return;
        }
        lSCameraGLSurfaceView.h2(AEProviderViewModel.w2(r0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(Runnable runnable) {
        if (this.M0) {
            runnable.run();
            return;
        }
        if (this.f63932j0 == null) {
            this.f63932j0 = new ArrayList();
        }
        this.f63932j0.add(runnable);
    }

    private void i1() {
        com.tencent.aelight.camera.ae.flashshow.ui.beauty.a aVar = com.tencent.aelight.camera.ae.flashshow.ui.beauty.a.f64763a;
        boolean h16 = aVar.h();
        ms.a.f(this.f63731f, "AIBeauty---applyAIBeautyTipMaterial, exists=" + h16);
        if (h16) {
            this.f63942o0 = true;
            LSCaptureController lSCaptureController = this.f63953x0;
            if (lSCaptureController != null) {
                lSCaptureController.w(aVar.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(LSCaptureMode lSCaptureMode, LSCaptureMode lSCaptureMode2) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView;
        this.W = lSCaptureMode2;
        if (lSCaptureMode == lSCaptureMode2) {
            return;
        }
        if (lSCaptureMode == LSCaptureMode.GIF && lSCaptureMode2 == LSCaptureMode.NORMAL && (lSCameraGLSurfaceView = this.E) != null) {
            lSCameraGLSurfaceView.c2(true);
        }
        ms.a.f(this.f63731f, "onCaptureModeChanged---from " + lSCaptureMode + " to " + lSCaptureMode2);
        K1(lSCaptureMode, lSCaptureMode2);
        jq.a aVar = this.f63948s0;
        if (aVar != null) {
            aVar.c();
        }
        AEBaseReportParam.U().a1(false);
        LSCameraGLSurfaceView lSCameraGLSurfaceView2 = this.E;
        if (lSCameraGLSurfaceView2 != null) {
            lSCameraGLSurfaceView2.setIsGIFMode(false);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.31
            @Override // java.lang.Runnable
            public void run() {
                LSCaptureController lSCaptureController = LSMiddleCameraUnit.this.f63953x0;
                if (lSCaptureController != null) {
                    lSCaptureController.i();
                }
            }
        });
        if (!this.W.shouldStartCamera()) {
            if (this.f63924f0 != null && lSCaptureMode2 == LSCaptureMode.PLAY) {
                ms.a.f(this.f63731f, "change to PLAY, setStickerPause");
                this.f63924f0.setStickerPause(true);
            }
            LSTipsViewController lSTipsViewController = this.f63944p0;
            if (lSTipsViewController != null) {
                lSTipsViewController.i();
            }
            GLGestureProxy.getInstance().removeListener(this.f63950u0);
            GLGestureProxy.getInstance().removeListener(null);
            GLGestureProxy.getInstance().removeListener(this.f63946q0);
            GLGestureProxy.getInstance().removeListener(this.f63951v0);
            GLGestureProxy.getInstance().removeListener(this.f63948s0);
            GLGestureProxy.getInstance().removeListener(this.f63949t0);
            return;
        }
        if (this.f63924f0 != null && lSCaptureMode == LSCaptureMode.PLAY) {
            ms.a.f(this.f63731f, "change from PLAY, setStickerResume");
            this.f63924f0.setStickerResume(true);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63950u0)) {
            GLGestureProxy.getInstance().addListener(this.f63950u0);
        }
        if (!GLGestureProxy.getInstance().hasListener(null)) {
            GLGestureProxy.getInstance().addListener(null);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63951v0)) {
            GLGestureProxy.getInstance().addListener(this.f63951v0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63946q0)) {
            GLGestureProxy.getInstance().addListener(this.f63946q0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63947r0)) {
            GLGestureProxy.getInstance().addListener(this.f63947r0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63951v0)) {
            GLGestureProxy.getInstance().addListener(this.f63951v0);
        }
        if (!GLGestureProxy.getInstance().hasListener(this.f63948s0)) {
            GLGestureProxy.getInstance().addListener(this.f63948s0);
        }
        if (GLGestureProxy.getInstance().hasListener(this.f63949t0)) {
            return;
        }
        GLGestureProxy.getInstance().addListener(this.f63949t0);
    }

    private boolean o1() {
        AEProviderViewModel aEProviderViewModel;
        Boolean value;
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar;
        AEBeautyProviderViewModel aEBeautyProviderViewModel;
        com.tencent.aelight.camera.ae.camera.ui.panel.b value2;
        ms.a.c(this.f63731f, "AIBeauty has selected material: " + this.f63934k0);
        if (this.f63934k0) {
            return false;
        }
        AEMaterialMetaData H = AEMaterialManager.H();
        if ((H != null && !H.equals(AEMaterialMetaData.MATERIAL_NONE)) || (aEProviderViewModel = this.f63941n1) == null || (value = aEProviderViewModel.u2().getValue()) == null || !value.booleanValue() || (aaVar = this.f63939m1) == null) {
            return false;
        }
        bj value3 = aaVar.N1().getValue();
        return ((value3 != null && !bk.a(value3)) || (aEBeautyProviderViewModel = this.f63935k1) == null || (value2 = aEBeautyProviderViewModel.a2().getValue()) == null || bk.a(value2)) ? false : true;
    }

    private void q2() {
        com.tencent.qqcamerakit.common.e.g(wq.a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f63935k1.U1().getValue();
        if (value == null) {
            ms.a.c(this.f63731f, "clearBeautyEffect error viewModels null.");
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            this.E.setBeautyOrTransformLevel(it.next().getType(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        if (x1() && this.f63941n1 != null) {
            J2();
            K2();
            boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, true, 0);
            this.f63941n1.J2(c16);
            ms.a.f(this.f63731f, "toggleAiBeauty on camera start: " + c16);
        } else {
            int m3 = AEBeautyProviderView.m();
            int n3 = AEBeautyProviderView.n();
            LSCaptureController lSCaptureController = this.f63953x0;
            if (lSCaptureController != null) {
                lSCaptureController.u(m3);
                this.f63953x0.z(n3);
            }
        }
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.N1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        List<com.tencent.aelight.camera.ae.camera.ui.panel.b> value = this.f63937l1.S1().getValue();
        if (value == null) {
            ms.a.c(this.f63731f, "clearBeautyEffect error viewModels null.");
            return;
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.b> it = value.iterator();
        while (it.hasNext()) {
            this.E.setBeautyOrTransformLevel(it.next().getType(), 0);
        }
    }

    private void s2() {
        VideoReport.setPageId(A(), WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
        HashMap hashMap = new HashMap();
        hashMap.put("ae_mode_refer", Integer.valueOf(this.Y.l()));
        hashMap.putAll(com.tencent.aelight.camera.ae.flashshow.ab.c().g());
        VideoReport.setPageParams(A(), new QCircleDTParamBuilder().buildPageParams(this.f63731f, hashMap));
    }

    private int t1(int i3) {
        return i3 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(List<Integer> list, List<Integer> list2) {
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
        ms.a.f(this.f63731f, "setAiBeautyFaceInfo: " + jSONArray2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        ms.a.f(this.f63731f, "AIBeauty---dismissAIBeautyTipMaterial, isApplyingAIBeautyTipMaterial=" + this.f63942o0);
        if (this.f63942o0) {
            this.f63942o0 = false;
            AEMaterialMetaData H = AEMaterialManager.H();
            if (H == null || H.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                ms.a.f(this.f63731f, "AIBeauty---dismissAIBeautyTipMaterial, reset original material");
                LSCaptureController lSCaptureController = this.f63953x0;
                if (lSCaptureController != null) {
                    lSCaptureController.w(AEMaterialManager.H());
                }
            }
        }
    }

    public HashMap<String, String> A1() {
        return this.f63938m0;
    }

    protected void A2() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ms.a.f(LSMiddleCameraUnit.this.f63731f, "[LSMiddleCameraUnit] unit init ENTER");
                    Process.setThreadPriority(-2);
                } catch (Exception e16) {
                    ms.a.c(LSMiddleCameraUnit.this.f63731f, "[UnitAsyncInit] setThreadPriority exception: " + e16.getMessage());
                }
            }
        }, 16, null, true);
    }

    protected boolean B2() {
        return this.Y.e() == 101 && this.Y.x() && this.Y.B() && this.Y.z();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected BroadcastReceiver C() {
        return this.E0;
    }

    public List<WMElement> C1() {
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager == null) {
            return Collections.emptyList();
        }
        return aEFilterManager.wmGetEditableWMElements();
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.m.c
    public void C2(boolean z16) {
        if (ms.a.g()) {
            ms.a.a(this.f63731f, "onResourceDownload isOnlineRes: " + z16);
        }
        if (!f63918s1) {
            f63918s1 = true;
            this.f63732h.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.36
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.a.g()) {
                        ms.a.a(LSMiddleCameraUnit.this.f63731f, "onResourceDownload update filterpager begin");
                    }
                    ((AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1)).N(false);
                    ((AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3)).F(false);
                    if (ms.a.g()) {
                        ms.a.a(LSMiddleCameraUnit.this.f63731f, "onResourceDownload update filterpager end");
                    }
                }
            });
        }
        if (x1() && this.W == LSCaptureMode.NORMAL) {
            this.f63732h.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.al
                @Override // java.lang.Runnable
                public final void run() {
                    LSMiddleCameraUnit.this.e2();
                }
            });
        }
    }

    protected boolean D2() {
        return this.Y.e() == 101 && this.Y.A();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected LSCameraManager.a E() {
        return this.f63936l0;
    }

    public void E2() {
        AbsLSCaptureButton absLSCaptureButton;
        if (this.W0 != null) {
            if (com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                this.W0.setVisibility(0);
            } else {
                this.W0.setVisibility(4);
            }
        }
        p1(true);
        if (!this.T0.L1() && (absLSCaptureButton = this.F) != null) {
            absLSCaptureButton.setVisibility(0);
        }
        if (a2()) {
            F2(true, A());
        }
        this.U0.M1().postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G2() {
        boolean z16 = this.f63732h.getActivity().checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
        LinkedList linkedList = new LinkedList();
        if (z16) {
            linkedList.add(QQPermissionConstants.Permission.CAMERA);
            ms.a.f(this.f63731f, "\u3010Camera Permission\u3011denied");
        }
        final String permissionWording = DialogUtil.getPermissionWording((String[]) linkedList.toArray(new String[0]));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.38

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$38$a */
            /* loaded from: classes32.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ms.a.f(LSMiddleCameraUnit.this.f63731f, "PermissionDialog--onClick which=" + i3);
                    Activity activity = LSMiddleCameraUnit.this.f63732h.getActivity();
                    if (i3 == 1) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivity(intent);
                    } else if (!LSMiddleCameraUnit.this.R()) {
                        activity.finish();
                    }
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$38$b */
            /* loaded from: classes32.dex */
            class b implements DialogInterface.OnCancelListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    ms.a.f(LSMiddleCameraUnit.this.f63731f, "PermissionDialog--onCancel");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                DialogUtil.showPermissionSettingDialog(LSMiddleCameraUnit.this.f63732h.getActivity(), null, permissionWording, aVar, aVar, new b());
            }
        });
    }

    protected void H2() {
        Runnable runnable = this.f63922d1;
        if (runnable != null) {
            this.f63730d0.removeCallbacks(runnable);
            this.f63922d1 = null;
        }
        if (this.Y0 != null) {
            this.f63730d0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.34
                @Override // java.lang.Runnable
                public void run() {
                    LSMiddleCameraUnit.this.Y0.setVisibility(8);
                    if (LSMiddleCameraUnit.this.Y0.getDrawable() != null) {
                        LazyLoadAnimationDrawable lazyLoadAnimationDrawable = (LazyLoadAnimationDrawable) LSMiddleCameraUnit.this.Y0.getDrawable();
                        lazyLoadAnimationDrawable.stop();
                        lazyLoadAnimationDrawable.clear();
                    }
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected int I() {
        if (x1()) {
            this.V = AEVideoStoryTopBarViewModel.Ratio.fromCode(((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getInt(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
            ms.a.a(this.f63731f, "adjustRatio defaultRatio : " + this.V);
        } else {
            this.V = AEVideoStoryTopBarViewModel.Ratio.FULL;
        }
        return this.V.code;
    }

    public void I2(boolean z16, View view) {
        com.tencent.aelight.camera.ae.camera.ui.panel.t tVar;
        if (this.F0 || view == null) {
            return;
        }
        ms.a.a(this.f63731f, "bClosedByCustom" + this.f63931i1);
        if (this.W == LSCaptureMode.GIF) {
            ms.a.f(this.f63731f, "\u3010Dark Mode\u3011in gif show off");
            view.setVisibility(8);
            return;
        }
        com.tencent.aelight.camera.ae.part.a aVar = this.U0;
        if ((aVar != null && aVar.R1()) || ((tVar = this.R0) != null && tVar.O1())) {
            ms.a.f(this.f63731f, "\u3010Dark Mode\u3011in panel show off ");
            view.setVisibility(8);
            return;
        }
        if (z16) {
            if (this.f63931i1) {
                return;
            }
            view.setVisibility(0);
            view.setSelected(true);
            k0(true);
            this.f63931i1 = false;
            ms.a.f(this.f63731f, "\u3010Dark Mode\u3011Start");
            return;
        }
        view.setVisibility(8);
        view.setSelected(false);
        k0(false);
        this.f63931i1 = false;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public LSCaptureMode J(int i3) {
        LSCaptureMode D1;
        LSCaptureMode lSCaptureMode = LSCaptureMode.NORMAL;
        switch (i3) {
            case 201:
                D1 = D1(this.U, i3);
                break;
            case 202:
            case 203:
                D1 = LSCaptureMode.GIF;
                break;
            case 204:
                D1 = D1(this.U, i3);
                break;
            case 205:
                D1 = LSCaptureMode.NORMAL;
                break;
            case 206:
                D1 = LSCaptureMode.PLAY;
                break;
            case 207:
                D1 = LSCaptureMode.PLAY;
                break;
            default:
                D1 = LSCaptureMode.NORMAL;
                break;
        }
        ms.a.f(this.f63731f, "initCaptureModesAndFirstMode---initialMode=" + D1 + ", initialCModes=" + Arrays.toString(this.U));
        return D1;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected int L() {
        return R.layout.dmq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public xp.a Q() {
        int f16;
        Intent intent = A().getIntent();
        int i3 = 1;
        if (gq.a.H(intent)) {
            if (intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_PREFER_BACK, false) || !com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                i3 = 2;
            }
        } else {
            if (this.Y.f() == 0) {
                f16 = K();
            } else {
                f16 = this.Y.f();
            }
            if (this.T != LSCaptureMode.GIF || !com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                i3 = f16;
            }
        }
        if (com.tencent.aelight.camera.ae.util.n.s()) {
            AECameraConstants.sCurrentCamera = i3;
            return com.tencent.aelight.camera.ae.util.j.h().c(this.f63732h.getActivity(), i3);
        }
        return com.tencent.aelight.camera.ae.flashshow.util.k.b().a(this.Y);
    }

    public void Q1() {
        LSTipsViewController lSTipsViewController = this.f63944p0;
        if (lSTipsViewController != null) {
            lSTipsViewController.k();
        }
        AECompoundButton aECompoundButton = this.W0;
        if (aECompoundButton != null) {
            aECompoundButton.setVisibility(8);
        }
        F2(false, A());
        this.U0.M1().postValue(Boolean.FALSE);
    }

    public void R1() {
        if (this.f63941n1 != null) {
            return;
        }
        ms.a.f(this.f63731f, "init beautyViewModel start...");
        this.f63943o1 = (com.tencent.aelight.camera.ae.camera.ui.panel.ac) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.ac.class);
        if (AEDashboardUtil.p(A())) {
            this.f63935k1 = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.b(this, new com.tencent.aelight.camera.ae.camera.ui.panel.e(true)).get(AEBeautyProviderViewModel.class);
        } else {
            this.f63935k1 = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEBeautyProviderViewModel.class);
        }
        this.f63937l1 = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEBodyProviderViewModel.class);
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        this.f63939m1 = aaVar;
        AEProviderViewModel aEProviderViewModel = (AEProviderViewModel) com.tencent.aelight.camera.ae.n.b(this, new com.tencent.aelight.camera.ae.camera.ui.panel.an(this.f63935k1, this.f63937l1, aaVar, this.f63943o1)).get(AEProviderViewModel.class);
        this.f63941n1 = aEProviderViewModel;
        aEProviderViewModel.A2().observe(this, new aa());
        this.f63935k1.W1().observe(this, new ab());
        this.f63937l1.T1().observe(this, new ac());
        this.f63937l1.T1().observe(this, new ad());
        if (x1()) {
            this.f63941n1.u2().observe(this, new ae());
        }
    }

    protected void S1() {
        if (this.W.shouldStartCamera()) {
            return;
        }
        v2();
        this.f63954y0.g();
        int i3 = this.f63926g0;
        if (i3 <= 0 || this.f63928h0 <= 0) {
            return;
        }
        this.f63954y0.q(851973, Arrays.asList(Integer.valueOf(i3), Integer.valueOf(this.f63928h0)));
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected boolean T() {
        return gq.a.W(this.Y.l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T1() {
        jq.b bVar = new jq.b();
        this.f63950u0 = bVar;
        bVar.a(this.S0);
        this.f63950u0.d(this.D);
        this.f63950u0.c(new t());
        this.f63950u0.b(new u());
        this.f63946q0 = new jq.f(this.B0);
        this.f63947r0 = new jq.c(this.B0);
        this.f63951v0 = new jq.e(this.E, 0);
        this.f63948s0 = new jq.a(A(), this.A0);
        this.f63949t0 = new jq.d(this.C0);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected boolean V() {
        Activity A;
        if (this.W == LSCaptureMode.GIF || (A = A()) == null) {
            return false;
        }
        return !gq.a.H(A.getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V1() {
        this.Q0 = (com.tencent.aelight.camera.ae.e) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.e.class);
        this.Z0 = (ai) com.tencent.aelight.camera.ae.n.a(this).get(ai.class);
        this.f63919a1 = (com.tencent.aelight.camera.ae.camera.ui.panel.z) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.z.class);
        ((com.tencent.aelight.camera.ae.camera.ui.panel.ac) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.ac.class)).L1().observe(this, new b());
        ((com.tencent.aelight.camera.ae.flashshow.ui.e) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.flashshow.ui.e.class)).U1().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMiddleCameraUnit.this.c2((MetaMaterial) obj);
            }
        });
        this.Q0.P1().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMiddleCameraUnit.this.d2((com.tencent.aelight.camera.ae.r) obj);
            }
        });
        this.Q0.O1().observe(this, new c());
        com.tencent.aelight.camera.ae.flashshow.mode.a aVar = (com.tencent.aelight.camera.ae.flashshow.mode.a) ay.a(this).get(com.tencent.aelight.camera.ae.flashshow.mode.a.class);
        this.T0 = aVar;
        aVar.f64352i.observe(this, new d());
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        this.f63939m1 = aaVar;
        aaVar.N1().observe(this, new e());
        this.U0 = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.part.a.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryTopBarViewModel.class);
        this.f63945p1 = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.S1(this.f63734m.isFrontCamera());
        this.f63945p1.f63374m.observe(this, new f());
        this.U0.N1().observe(this, new g());
        this.U0.Q1().observe(this, new h());
        this.U0.P1().observe(this, new i());
        this.U0.L1().observe(this, new j());
        com.tencent.aelight.camera.ae.camera.ui.panel.t tVar = (com.tencent.aelight.camera.ae.camera.ui.panel.t) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.camera.ui.panel.t.class);
        this.R0 = tVar;
        tVar.N1().observe(this, new k());
        if (x1()) {
            R1();
        }
        Activity A = A();
        if (A instanceof FragmentActivity) {
            MusicSourceViewModel musicSourceViewModel = (MusicSourceViewModel) new ViewModelProvider((FragmentActivity) A).get(MusicSourceViewModel.class);
            this.f63920b1 = musicSourceViewModel;
            musicSourceViewModel.D2().observe(this, new m());
        }
        this.f63921c1 = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEFlashShowBottomPanelViewModel.class);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void X() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.37
            @Override // java.lang.Runnable
            public void run() {
                AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
                if (aEFilterManager != null) {
                    aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_SWITCHED, LSMiddleCameraUnit.f63916q1);
                }
                LSMiddleCameraUnit.this.L2();
                if (LSMiddleCameraUnit.this.f63944p0 != null) {
                    LSMiddleCameraUnit.this.f63944p0.n();
                }
                lq.b bVar = LSMiddleCameraUnit.this.f63954y0;
                if (bVar != null) {
                    bVar.q(196611, Boolean.FALSE);
                    LSMiddleCameraUnit.this.f63954y0.q(327685, new Object[0]);
                }
            }
        });
    }

    public boolean X1() {
        if (A() == null) {
            return false;
        }
        return gq.a.j(A().getIntent());
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public void Y() {
        ms.a.f(this.f63731f, "onPhotoCaptureStart---");
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_START_RECORD, f63916q1);
        }
        P1();
        AbsLSCaptureButton absLSCaptureButton = this.F;
        if (absLSCaptureButton != null) {
            absLSCaptureButton.setVisibility(8);
        }
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.q(196609, new Object[0]);
            this.f63954y0.q(262147, new Object[0]);
        }
    }

    public boolean Y1() {
        if (A() == null) {
            return false;
        }
        return gq.a.D(A().getIntent());
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void a() {
        Log.d(this.f63731f, "onCaptureButtonVideoStop: thread = " + Thread.currentThread().getName());
        this.E.a2();
        this.f63734m.stopRecordVideo();
        try {
            AEFilterManager aEFilterManager = this.f63924f0;
            if (aEFilterManager != null) {
                aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_END_RECORD, f63916q1);
            }
            this.F0 = false;
            this.U0.N1().postValue(Boolean.FALSE);
            ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I(false);
            w2(0);
        } catch (Throwable th5) {
            ms.a.c(this.f63731f, "onCaptureButtonVideoStop error : " + th5.getMessage());
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.s
    public void b(List<LSDashboardUtil.c> list, List<LSDashboardUtil.b> list2) {
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.q(720897, list, list2);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.util.h.a
    public void c(boolean z16) {
        this.L0 = z16;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63945p1;
        if (aEVideoStoryTopBarViewModel != null) {
            aEVideoStoryTopBarViewModel.O1().postValue(Boolean.valueOf(z16));
        }
        VideoReport.setPageParams(A(), "ae_night_mode", Integer.valueOf(z16 ? 1 : 0));
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void d() {
        Q1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d1() {
        if (this.N0) {
            return;
        }
        this.N0 = true;
        ms.a.f(this.f63731f, "actionAfterFirstFrame");
        ((IAsyncControl) QRoute.api(IAsyncControl.class)).startAsyncStep(com.tencent.aelight.camera.aioeditor.capture.control.a.f66679c, new Object[]{this, Integer.valueOf(this.f63732h.getActivity().getIntent().getIntExtra("edit_video_type", 10002))});
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.18

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$18$a */
            /* loaded from: classes32.dex */
            class a extends AccessibilityDelegateCompat {
                a() {
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName(Button.class.getName());
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity A = LSMiddleCameraUnit.this.A();
                if (LSMiddleCameraUnit.this.E != null && A != null && A.getIntent() != null) {
                    LSMiddleCameraUnit.this.E.setFrom(A.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, 0));
                }
                ms.a.f(LSMiddleCameraUnit.this.f63731f, "actionAfterFirstFrame--ui run--BEGIN");
                View view = LSMiddleCameraUnit.this.D;
                if (view == null) {
                    return;
                }
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.f163793s14);
                if (viewStub != null) {
                    if (DeviceInfoMonitor.getModel().contains("OPPO R9s Plus")) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewStub.getLayoutParams();
                        layoutParams.bottomMargin = ViewUtils.dpToPx(16.0f);
                        viewStub.setLayoutParams(layoutParams);
                    }
                    viewStub.inflate();
                }
                ViewStub viewStub2 = (ViewStub) LSMiddleCameraUnit.this.D.findViewById(R.id.s1a);
                if (viewStub2 != null && !LSMiddleCameraUnit.this.X1()) {
                    viewStub2.inflate();
                }
                LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit.F = (AEFlashCameraCaptureButtonLayout) lSMiddleCameraUnit.D.findViewById(R.id.rqn);
                LSMiddleCameraUnit lSMiddleCameraUnit2 = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit2.F.d(lSMiddleCameraUnit2, lSMiddleCameraUnit2.Y.l(), LSMiddleCameraUnit.this.E);
                LSMiddleCameraUnit lSMiddleCameraUnit3 = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit3.F.setFunctionFlag(lSMiddleCameraUnit3.D().d());
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) LSMiddleCameraUnit.this.F.getLayoutParams();
                layoutParams2.bottomMargin = BaseAIOUtils.f(-30.0f, LSMiddleCameraUnit.this.F.getResources());
                LSMiddleCameraUnit.this.F.setLayoutParams(layoutParams2);
                LSMiddleCameraUnit.this.F.a();
                LSMiddleCameraUnit lSMiddleCameraUnit4 = LSMiddleCameraUnit.this;
                if (lSMiddleCameraUnit4.f63727a0) {
                    lSMiddleCameraUnit4.F.onResume();
                    LSMiddleCameraUnit.this.E2();
                }
                LSCaptureController lSCaptureController = LSMiddleCameraUnit.this.f63953x0;
                if (lSCaptureController == null) {
                    return;
                }
                lSCaptureController.f();
                if (LSMiddleCameraUnit.this.T.shouldStartCamera()) {
                    LSMiddleCameraUnit.this.v2();
                    LSMiddleCameraUnit.this.f63954y0.g();
                    if (LSMiddleCameraUnit.this.f63926g0 > 0 && LSMiddleCameraUnit.this.f63928h0 > 0) {
                        LSMiddleCameraUnit lSMiddleCameraUnit5 = LSMiddleCameraUnit.this;
                        lSMiddleCameraUnit5.f63954y0.q(851973, Arrays.asList(Integer.valueOf(lSMiddleCameraUnit5.f63926g0), Integer.valueOf(LSMiddleCameraUnit.this.f63928h0)));
                    }
                }
                LSMiddleCameraUnit lSMiddleCameraUnit6 = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit6.X0 = (AECompoundButton) lSMiddleCameraUnit6.D.findViewById(R.id.rru);
                if (LSMiddleCameraUnit.this.X0 != null) {
                    LSMiddleCameraUnit.this.X0.setOnClickListener(LSMiddleCameraUnit.this);
                    LSMiddleCameraUnit.this.X0.setSelected(false);
                    LSMiddleCameraUnit.this.X0.setVisibility(8);
                    LSMiddleCameraUnit lSMiddleCameraUnit7 = LSMiddleCameraUnit.this;
                    boolean z16 = lSMiddleCameraUnit7.L0;
                    if (z16) {
                        lSMiddleCameraUnit7.I2(z16, lSMiddleCameraUnit7.X0);
                    }
                }
                LSMiddleCameraUnit lSMiddleCameraUnit8 = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit8.W0 = (AECompoundButton) lSMiddleCameraUnit8.D.findViewById(R.id.rqx);
                if (LSMiddleCameraUnit.this.W0 != null) {
                    ViewCompat.setAccessibilityDelegate(LSMiddleCameraUnit.this.W0, new a());
                    vq.a.f443174a.b(LSMiddleCameraUnit.this.W0, "em_ae_switch_btn");
                    LSMiddleCameraUnit.this.W0.setOnClickListener(LSMiddleCameraUnit.this);
                    LSMiddleCameraUnit.this.W0.setContentDescription(LSMiddleCameraUnit.this.W0.getResources().getString(R.string.y9u));
                    if (!com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                        LSMiddleCameraUnit.this.W0.setVisibility(4);
                        LSMiddleCameraUnit.this.W0.setEnabled(false);
                    }
                }
                LSMiddleCameraUnit lSMiddleCameraUnit9 = LSMiddleCameraUnit.this;
                if (lSMiddleCameraUnit9.f63727a0) {
                    lSMiddleCameraUnit9.f63954y0.l();
                    LSMiddleCameraUnit.this.f63953x0.p();
                }
                LSMiddleCameraUnit lSMiddleCameraUnit10 = LSMiddleCameraUnit.this;
                lSMiddleCameraUnit10.D.setOnTouchListener(lSMiddleCameraUnit10);
                LSMiddleCameraUnit.this.p2();
                LSMiddleCameraUnit.this.L2();
                LSMiddleCameraUnit.this.M0 = true;
                if (LSMiddleCameraUnit.this.f63932j0 != null) {
                    Iterator it = LSMiddleCameraUnit.this.f63932j0.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    LSMiddleCameraUnit.this.f63932j0 = null;
                }
                ms.a.f(LSMiddleCameraUnit.this.f63731f, "actionAfterFirstFrame--ui run--END");
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public boolean e() {
        boolean O = O();
        if (!O && gq.a.v(A().getIntent())) {
            G2();
        }
        return O;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void f0() {
        this.E.setAECaptureController(z1());
        this.E.setAeGLSurfaceListener(this.D0);
        this.E.setCaptureListener(this);
        this.E.setFaceEffectListener(this);
        this.E.setAiBeautyFaceListener(new v());
        this.E.setStickerInnerLutFilterListener(this);
        this.E.setRecommendTextCallback(new w());
        if (com.tencent.aelight.camera.ae.util.n.s()) {
            this.E.setDynamicResolutionMode(true);
            this.f63734m.setDynamicResolutionMode(true);
        } else {
            this.E.setDynamicResolutionMode(false);
            this.f63734m.setDynamicResolutionMode(false);
        }
        if (LSDashboardUtil.p()) {
            this.E.W = this;
        }
    }

    protected void f1() {
        LiuHaiUtils.initLiuHaiScreenUI_Common(this.L, this.M, ViewUtils.dip2px(1.0f));
        g1();
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void g() {
        super.g();
        if (A() != null) {
            com.tencent.mobileqq.wink.editor.util.m.f322645a.t(null, A());
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void g0() {
        this.E.setGenderTypeListener(new x());
    }

    protected void g1() {
        Activity A = A();
        if (ScreenUtil.getRealHeight(A) / ScreenUtil.getRealWidth(A) >= 2.0f) {
            this.M.setVisibility(8);
            this.L.setVisibility(8);
            LSBaseCameraUnit.b0(A);
        }
        if (DeviceInfoMonitor.getModel().contains("Pixel 2")) {
            View decorView = A.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-5));
        }
        View view = this.P0;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new z());
            }
        }
    }

    protected void g2(int i3, AEFilterManager aEFilterManager) {
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.q(196617, Integer.valueOf(i3), aEFilterManager);
        }
    }

    @QQPermissionGrant(1)
    public void grant() {
        ms.a.f(this.f63731f, "\u3010Camera / Audio / Storage Permission\u3011grant");
        this.f63729c0 = true;
        if (this.f63727a0) {
            n0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void h() {
        if (!com.tencent.aelight.camera.ae.util.c.b(A().getIntent(), this.f63731f)) {
            ms.a.f(this.f63731f, "onCaptureButtonVideoStart no need audio");
            n1();
            return;
        }
        if (!N()) {
            Z(new a());
        } else {
            n1();
        }
        if (A() != null) {
            com.tencent.mobileqq.wink.editor.util.m.f322645a.t(null, A());
        }
    }

    protected void h2(int i3, int i16, int i17, int i18) {
        Log.d(this.f63731f, "notifyPreviewSizeChanged: ");
        this.f63926g0 = i3;
        this.f63928h0 = i16;
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.q(851973, Arrays.asList(Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    public void i2() {
        ms.a.a(this.f63731f, "takesame:  notifySdkResDownloaded");
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.f63921c1;
        if (aEFlashShowBottomPanelViewModel != null) {
            aEFlashShowBottomPanelViewModel.m2().postValue(Boolean.TRUE);
        }
    }

    public void j1(String str, String str2) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.setBundlePath(str, str2);
        }
    }

    public void k1() {
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.g();
        }
    }

    public void k2() {
        this.f63732h.getActivity().onBackPressed();
    }

    protected void l1() {
        Intent intent = new Intent();
        intent.setAction("ae_editor_bottom_tab_show_hide");
        intent.putExtra("is_show", true);
        A().sendBroadcast(intent);
        this.f63954y0.q(131077, new Object[0]);
    }

    protected void m1() {
        Intent intent = new Intent();
        intent.setAction("ae_editor_bottom_tab_show_hide");
        intent.putExtra("is_show", false);
        A().sendBroadcast(intent);
        this.f63954y0.q(131076, new Object[0]);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public void n(int i3, int i16) {
        super.n(i3, i16);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.12
            @Override // java.lang.Runnable
            public void run() {
                LiuHaiUtils.resetAllLiuHaiStatus();
                if (LSMiddleCameraUnit.this.f63732h.R().get() != null) {
                    LiuHaiUtils.initLiuHaiProperty(LSMiddleCameraUnit.this.f63732h.R().get());
                    if (LiuHaiUtils.needCloseFullScreen()) {
                        LiuHaiUtils.closeFullScreen(LSMiddleCameraUnit.this.f63732h.R().get());
                    } else {
                        LiuHaiUtils.resetFullScreen(LSMiddleCameraUnit.this.f63732h.R().get());
                    }
                }
                LSMiddleCameraUnit.this.f1();
            }
        });
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.h();
        }
    }

    protected void o2() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.17
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1d), 0).show();
                LSMiddleCameraUnit.this.E2();
                if (LSMiddleCameraUnit.this.f63734m.isFlashEnabled()) {
                    LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                    lSMiddleCameraUnit.f63734m.turnFlash(lSMiddleCameraUnit.A(), false);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.x
    public void onAEKitInited() {
        super.onAEKitInited();
        if (!x1()) {
            int m3 = AEBeautyProviderView.m();
            int n3 = AEBeautyProviderView.n();
            LSCaptureController lSCaptureController = this.f63953x0;
            if (lSCaptureController != null) {
                lSCaptureController.u(m3);
                this.f63953x0.z(n3);
            }
        }
        this.f63730d0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.10
            @Override // java.lang.Runnable
            public void run() {
                LSCaptureController lSCaptureController2 = LSMiddleCameraUnit.this.f63953x0;
                if (lSCaptureController2 != null) {
                    lSCaptureController2.A();
                }
            }
        });
        AEFontManager.d().f();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        ms.a.f(this.f63731f, "onActivityPause");
        super.onActivityPause();
        GLGestureProxy.getInstance().removeListener(this.f63950u0);
        GLGestureProxy.getInstance().removeListener(null);
        GLGestureProxy.getInstance().removeListener(this.f63946q0);
        GLGestureProxy.getInstance().removeListener(this.f63947r0);
        GLGestureProxy.getInstance().removeListener(this.f63951v0);
        GLGestureProxy.getInstance().removeListener(this.f63948s0);
        GLGestureProxy.getInstance().removeListener(this.f63949t0);
        AbsLSCaptureButton absLSCaptureButton = this.F;
        if (absLSCaptureButton != null) {
            absLSCaptureButton.onPause();
        }
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.q();
        }
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.j();
        }
        LSCameraMaterialJSServiceManager.f63895a.s();
        AEMaterialManager.f63519w = false;
        if (ms.a.h()) {
            ms.a.a(this.f63731f, "onActivityPause, ID=" + this.S);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (ms.a.g()) {
            ms.a.a(this.f63731f, "onActivityResult:requestCode=" + i3 + " resultCode=" + i16 + " data=" + intent + " publishStoryFlag=" + f63917r1);
        }
        Activity activity = this.f63732h.getActivity();
        if (activity == null || activity.isFinishing()) {
            if (ms.a.g()) {
                String str = this.f63731f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("activity is finishing, ");
                sb5.append(activity == null);
                ms.a.a(str, sb5.toString());
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
        if (i3 == 1026 || i3 == 1027 || i3 == 1029 || i3 == 1030) {
            lq.b bVar = this.f63954y0;
            if (bVar != null) {
                bVar.k(i3, i16, intent);
                return;
            }
            return;
        }
        if (i3 == 10020) {
            if (i16 == -1) {
                activity.setResult(i16, intent);
                activity.finish();
                return;
            }
            return;
        }
        if (intent == null && i16 == 0 && f63917r1) {
            f63917r1 = false;
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        ms.a.f(this.f63731f, "onActivityResume");
        this.f63727a0 = true;
        if (f63917r1) {
            ms.a.c(this.f63731f, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
            return;
        }
        nq.a.b().c(WinkContext.INSTANCE.i(false));
        super.onActivityResume();
        this.f63734m.refreshDarkModeTimer();
        GLGestureProxy.getInstance().addListener(this.f63950u0);
        GLGestureProxy.getInstance().addListener(null);
        GLGestureProxy.getInstance().addListener(this.f63946q0);
        GLGestureProxy.getInstance().addListener(this.f63947r0);
        GLGestureProxy.getInstance().addListener(this.f63951v0);
        GLGestureProxy.getInstance().addListener(this.f63948s0);
        GLGestureProxy.getInstance().addListener(this.f63949t0);
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.p();
        }
        if (this.M0) {
            AbsLSCaptureButton absLSCaptureButton = this.F;
            if (absLSCaptureButton != null) {
                absLSCaptureButton.onResume();
            }
            E2();
            c(false);
        }
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.l();
        }
        N2();
        p1(false);
        AEFlashShowMaterialManager.INSTANCE.f(true);
        if (ms.a.h()) {
            ms.a.a(this.f63731f, "onActivityResume, ID=" + this.S);
        }
        ah ahVar = this.f63933j1;
        if (ahVar != null) {
            ahVar.callback();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityStart() {
        ms.a.f(this.f63731f, "onActivityStart");
        super.onActivityStart();
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.m();
        }
        this.J0 = System.currentTimeMillis();
        if (ms.a.h()) {
            ms.a.a(this.f63731f, "onActivityStart, ID=" + this.S);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityStop() {
        ms.a.f(this.f63731f, "onActivityStop");
        super.onActivityStop();
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.n();
        }
        if (ms.a.h()) {
            ms.a.a(this.f63731f, "onActivityStop, ID=" + this.S);
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public boolean onBackPressed() {
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController == null || lSCaptureController.r()) {
            return false;
        }
        lq.b bVar = this.f63954y0;
        if (bVar != null && bVar.f(589824) && ((Boolean) this.f63954y0.b(589826, new Object[0])).booleanValue()) {
            ms.a.a(this.f63731f, "WaterMark editor need hide");
            this.f63954y0.q(589826, new Object[0]);
            return true;
        }
        this.f63953x0.q();
        this.f63953x0.n();
        this.f63732h.Q();
        Activity A = A();
        if (A != null) {
            WinkContext.INSTANCE.d().m().j(A, A.getIntent().getExtras());
        }
        ms.a.f(this.f63731f, "\u3010Click\u3011onBackPressed");
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.rqg /* 2097545378 */:
            case R.id.rqh /* 2097545379 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
                k2();
                break;
            case R.id.rqx /* 2097545395 */:
                AEFlashShowBottomPanelViewModel.l2().postValue(Boolean.TRUE);
                m2(this.W0);
                break;
            case R.id.rru /* 2097545429 */:
                AECompoundButton aECompoundButton = this.X0;
                if (aECompoundButton != null) {
                    com.tencent.aelight.camera.aioeditor.capture.view.a.d(aECompoundButton.a(), 200L, null);
                    boolean z16 = !this.X0.isSelected();
                    this.X0.setSelected(z16);
                    k0(z16);
                    if (!z16) {
                        this.f63931i1 = true;
                    } else {
                        this.f63931i1 = false;
                    }
                    com.tencent.aelight.camera.aioeditor.b.b(z16 ? 1 : 2);
                    break;
                }
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        ms.a.a(this.f63731f, "[AE Profiler] LSMiddleCameraUnit onCreate");
        super.onCreate(bundle);
        s2();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.8
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.x1()) {
                    com.tencent.aelight.camera.ae.flashshow.ui.beauty.a aVar = com.tencent.aelight.camera.ae.flashshow.ui.beauty.a.f64763a;
                    if (aVar.h() || LSMiddleCameraUnit.this.Z1() || LSMiddleCameraUnit.this.Y1()) {
                        return;
                    }
                    aVar.a();
                }
            }
        }, 128, null, true);
        boolean z16 = ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getBoolean(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, true, 0);
        ms.a.f(this.f63731f, "AiBeautyToggle---initial: " + z16);
        f63917r1 = false;
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().P(false);
        SwitchHelper.e().j();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file = new File(LSCameraMaterialJSServiceManager.f63895a.f());
                    if (file.exists() && file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            file2.delete();
                        }
                        file.delete();
                    }
                } catch (Exception unused) {
                    ms.a.c(LSMiddleCameraUnit.this.f63731f, "AECameraPropertyAIManager clear cache error");
                }
            }
        }, 64, null, true);
        q2();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        LSCameraGLSurfaceView lSCameraGLSurfaceView;
        super.onDestroy();
        q1();
        AEBodyProviderViewModel aEBodyProviderViewModel = this.f63937l1;
        if (aEBodyProviderViewModel != null) {
            aEBodyProviderViewModel.Q1();
        }
        LSFilterProcessTex.x0(0);
        if (LSDashboardUtil.p() && (lSCameraGLSurfaceView = this.E) != null) {
            lSCameraGLSurfaceView.W = null;
        }
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.o();
        }
        LSCameraGLSurfaceView lSCameraGLSurfaceView2 = this.E;
        if (lSCameraGLSurfaceView2 != null) {
            lSCameraGLSurfaceView2.setStickerInnerLutFilterListener(null);
        }
        this.C.a();
        uq.a.unRegisterModule();
        if (A() != null && gq.a.H(A().getIntent())) {
            this.f63734m.setSelectedCamera(K());
        }
        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        aEMaterialManager.n();
        aEMaterialManager.m();
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.o();
            this.f63953x0 = null;
        }
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager != null) {
            aEFilterManager.wmSetOnClickWatermarkListener(null);
            this.f63924f0.wmSetOnlineUsrCountDelegate("watermark.qq.online", null);
        }
        LSTipsViewController lSTipsViewController = this.f63944p0;
        if (lSTipsViewController != null) {
            lSTipsViewController.o();
            this.f63944p0 = null;
        }
        jq.b bVar2 = this.f63950u0;
        if (bVar2 != null) {
            bVar2.d(null);
            this.f63950u0 = null;
        }
        List<Runnable> list = this.f63932j0;
        if (list != null) {
            list.clear();
        }
        this.f63929h1 = null;
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void onDeviceNotSupportMaterial() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.62
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(LSMiddleCameraUnit.this.A(), -1, R.string.y0c, 0).show();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onHideNormalTip() {
        ms.a.a(this.f63731f, "onHideNormalTip: ");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.40
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.f63944p0 != null) {
                    LSMiddleCameraUnit.this.f63944p0.j();
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onHidePagTip() {
        ms.a.a(this.f63731f, "onHidePagTip: ");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.42
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.f63944p0 != null) {
                    LSMiddleCameraUnit.this.f63944p0.l();
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.p(intent);
        }
    }

    public void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult) {
        List<WMElement> wmGetEditableWMElements;
        this.P = aEPhotoCaptureResult;
        ms.a.f(this.f63731f, "onPhotoCaptured---\u3010Type\u3011Photo");
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager != null && (wmGetEditableWMElements = aEFilterManager.wmGetEditableWMElements()) != null) {
            for (WMElement wMElement : wmGetEditableWMElements) {
                if (WMElement.TYPE_CHECK_IN.equals(wMElement.type)) {
                    wMElement.doCheckIn();
                }
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.16
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.f63734m.isFlashEnabled()) {
                    LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                    lSMiddleCameraUnit.f63734m.turnFlash(lSMiddleCameraUnit.A(), false);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onSelectFaceEffect(VideoMaterial videoMaterial) {
        H2();
        q1();
        if (videoMaterial == null) {
            AEBaseReportParam.U().u1("none");
            AEBaseReportParam.U().n1("");
            AEBaseReportParam.U().o1("");
        } else {
            AEBaseReportParam.U().u1(videoMaterial.getId());
        }
        if (videoMaterial != null && videoMaterial.isWatermarkMaterial() && this.f63924f0 != null) {
            ms.a.a(this.f63731f, "onSelectFaceEffect: wmSetOnlineUsrCountDelegate");
            this.f63924f0.wmSetOnlineUsrCountDelegate("watermark.qq.online", yq.b.f450786a.c());
        }
        if (videoMaterial != null && videoMaterial.isEditableWatermark()) {
            A().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.35
                @Override // java.lang.Runnable
                public void run() {
                    AEMaterialMetaData B = AEFlashShowMaterialManager.B();
                    if (B != null) {
                        B.editablewatermark = true;
                    }
                    if (LSMiddleCameraUnit.this.W1(B)) {
                        B.isdoubleclick = false;
                        LSMiddleCameraUnit.this.f63954y0.q(589825, new Object[0]);
                    }
                }
            });
        }
        LSTipsViewController lSTipsViewController = this.f63944p0;
        if (lSTipsViewController != null) {
            lSTipsViewController.p(videoMaterial);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onShowNormalTip(final String str, final String str2, final int i3) {
        ms.a.a(this.f63731f, "onShowNormalTip: tip=" + str + ", icon=" + str2 + ", duration=" + i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.39
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.f63944p0 != null) {
                    LSMiddleCameraUnit.this.f63944p0.s(str, str2, i3);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onShowPagTip(final String str, final int i3) {
        ms.a.a(this.f63731f, "onShowPagTip: pagPath=" + str + ", duration=" + i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.41
            @Override // java.lang.Runnable
            public void run() {
                if (LSMiddleCameraUnit.this.f63944p0 != null) {
                    LSMiddleCameraUnit.this.f63944p0.t(str, i3);
                }
            }
        });
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            AEFlashShowBottomPanelViewModel.l2().postValue(Boolean.TRUE);
        }
        if (this.F != null) {
            boolean onTouchEvent = GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, this.F.b(), this.E);
            GestureDetector gestureDetector = this.f63952w0;
            if (gestureDetector != null && !onTouchEvent) {
                gestureDetector.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public void onVideoCaptureStart() {
        Q1();
        w2(8);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.14
            @Override // java.lang.Runnable
            public void run() {
                LSCaptureController lSCaptureController = LSMiddleCameraUnit.this.f63953x0;
                if (lSCaptureController != null) {
                    lSCaptureController.i();
                }
            }
        });
        lq.b bVar = this.f63954y0;
        if (bVar != null) {
            bVar.q(196609, new Object[0]);
            this.f63954y0.q(262145, new Object[0]);
        }
    }

    public void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult) {
        this.N = aEVideoCaptureResult;
        aEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
        if (nr.a.e(aEVideoCaptureResult.videoMp4FilePath) < (this.X == 13 ? 2000 : 500)) {
            this.F0 = false;
            this.U0.N1().postValue(Boolean.FALSE);
            o2();
        } else {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            this.Q = localMediaInfo;
            localMediaInfo.path = aEVideoCaptureResult.videoMp4FilePath;
            localMediaInfo.mMimeType = "video";
            MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(this, this.Q);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.15
                @Override // java.lang.Runnable
                public void run() {
                    if (LSMiddleCameraUnit.this.f63734m.isFlashEnabled()) {
                        LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                        lSMiddleCameraUnit.f63734m.turnFlash(lSMiddleCameraUnit.A(), false);
                    }
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    public void p1(boolean z16) {
        if (this.F == null) {
            return;
        }
        if (z16) {
            this.f63954y0.q(327687, new Object[0]);
        } else {
            this.f63954y0.q(327688, new Object[0]);
        }
    }

    protected void p2() {
        if (B2()) {
            l1();
        } else if (D2()) {
            m1();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        final String account;
        final IFriendDataService iFriendDataService;
        this.f63929h1 = super.q(viewGroup);
        this.f63953x0 = z1();
        this.f63954y0 = u1(viewGroup);
        ((AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEVideoStoryTopBarViewModel.class)).f63374m.setValue(this.V);
        f1();
        S1();
        V1();
        T1();
        AEMaterialPanel aEMaterialPanel = this.S0;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.setMaterialPanelListener(this.f63955z0);
            this.S0.setVisibility(8);
        }
        this.f63944p0 = new LSTipsViewController(this.D, this.f63954y0);
        com.tencent.aelight.camera.ae.flashshow.ui.panel.f.b(com.tencent.aelight.camera.ae.flashshow.ui.panel.g.a());
        LSBeautyAndFilterPanelViewStubHolder lSBeautyAndFilterPanelViewStubHolder = new LSBeautyAndFilterPanelViewStubHolder((ViewStub) this.D.findViewById(R.id.s1y));
        this.V0 = lSBeautyAndFilterPanelViewStubHolder;
        this.Z0.f63993i.setValue(lSBeautyAndFilterPanelViewStubHolder);
        this.V0.a(this.f63950u0);
        LinearLayout linearLayout = this.L;
        boolean z16 = linearLayout != null && linearLayout.getVisibility() == 0;
        if (ms.a.g()) {
            ms.a.f(this.f63731f, "onCreateView needLiuHaiTop:" + z16);
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && (account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount()) != null && (iFriendDataService = (IFriendDataService) com.tencent.aelight.camera.aebase.a.a().getRuntimeService(IFriendDataService.class, "all")) != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.11
                @Override // java.lang.Runnable
                public void run() {
                    GenderType genderType;
                    Friends friend = iFriendDataService.getFriend(account, true);
                    if (friend != null) {
                        MutableLiveData<Integer> L1 = LSMiddleCameraUnit.this.f63919a1.L1();
                        if (friend.gender == 1) {
                            genderType = GenderType.MALE;
                        } else {
                            genderType = GenderType.FEMALE;
                        }
                        L1.postValue(Integer.valueOf(genderType.value));
                    }
                }
            }, 32, null, true);
        }
        h1(this.f63929h1);
        return this.f63929h1;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void r(int i3, boolean z16, LSCameraManager.b bVar) {
        ms.a.f("LSMiddleCameraUnit", "onRequestChangeCamera---which=" + i3 + ",needWideAngleLens=" + z16);
        LSCameraManager lSCameraManager = this.f63734m;
        if (lSCameraManager != null) {
            lSCameraManager.s(i3, z16, new r(bVar));
        } else {
            bVar.onOpenResult(i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public void u() {
        super.u();
        this.P0 = this.D.findViewById(R.id.ru7);
        this.S0 = (AEMaterialPanel) this.D.findViewById(R.id.ryz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public lq.b u1(ViewGroup viewGroup) {
        return new lq.b(this.f63732h.getActivity(), this.D, this);
    }

    public void u2(final Runnable runnable) {
        this.f63730d0.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ao
            @Override // java.lang.Runnable
            public final void run() {
                LSMiddleCameraUnit.this.f2(runnable);
            }
        });
    }

    protected boolean v1(AEMaterialMetaData aEMaterialMetaData, int i3, boolean z16) {
        return false;
    }

    protected void v2() {
        ms.a.f(this.f63731f, "setCaptureModeViewModel---");
        com.tencent.aelight.camera.ae.flashshow.mode.a aVar = (com.tencent.aelight.camera.ae.flashshow.mode.a) ay.a(this).get(com.tencent.aelight.camera.ae.flashshow.mode.a.class);
        aVar.f64352i.setValue(new LSCaptureModeChangingEvent(null, this.Y.m(), 1));
        aVar.f64353m.setValue(this.Y.j());
    }

    public void w2(int i3) {
        this.D.findViewById(R.id.f163755ru2);
    }

    protected boolean x1() {
        return LSDashboardUtil.m();
    }

    public synchronized void x2(int i3) {
        this.G0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y1() {
        ViewStub viewStub;
        if (this.J != null || (viewStub = this.I) == null) {
            return;
        }
        this.J = (CameraFocusView) viewStub.inflate();
    }

    public synchronized void y2(int i3) {
        this.H0 = i3;
    }

    public LSCaptureController z1() {
        if (this.f63953x0 == null) {
            this.f63953x0 = new LSCaptureController(this.D, this.E, this);
        }
        return this.f63953x0;
    }

    public void z2(final String str) {
        ms.a.f(this.f63731f, "setPicPathToLightSdk");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("Path", str);
                    jSONObject.put("lightCameraUserMaterial", jSONObject2);
                    ms.a.a(LSMiddleCameraUnit.this.f63731f, "setPicPathToLightSdk ~~~ " + jSONObject.toString());
                    AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
                    if (aEFilterManager != null) {
                        aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, jSONObject.toString());
                    }
                } catch (JSONException e16) {
                    throw new RuntimeException(e16);
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Observer<QIMFilterCategoryItem> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QIMFilterCategoryItem qIMFilterCategoryItem) {
            if (qIMFilterCategoryItem != null) {
                VideoReport.setPageParams(LSMiddleCameraUnit.this.A(), AECameraConstants.AE_FILTER_ID, qIMFilterCategoryItem.f66697d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements Observer<LSCaptureModeChangingEvent> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LSCaptureModeChangingEvent lSCaptureModeChangingEvent) {
            if (lSCaptureModeChangingEvent != null) {
                LSMiddleCameraUnit.this.l2(lSCaptureModeChangingEvent.f64349a, lSCaptureModeChangingEvent.f64350b);
                VideoReport.setPageParams(LSMiddleCameraUnit.this.A(), "ae_content_type", Integer.valueOf(lSCaptureModeChangingEvent.f64350b.index));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class r implements LSCameraManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LSCameraManager.b f64011a;

        r(LSCameraManager.b bVar) {
            this.f64011a = bVar;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                LSMiddleCameraUnit.this.E.u1(i3);
                if (LSMiddleCameraUnit.this.V()) {
                    LSMiddleCameraUnit.this.c0(i3);
                }
                LSMiddleCameraUnit.this.X();
                LSMiddleCameraUnit.this.p0();
            }
            this.f64011a.onOpenResult(i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class s implements LSCameraManager.b {
        s() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                if (LSMiddleCameraUnit.this.V()) {
                    LSMiddleCameraUnit.this.c0(i3);
                }
                LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                if (lSMiddleCameraUnit.f63727a0) {
                    lSMiddleCameraUnit.p0();
                } else {
                    lSMiddleCameraUnit.x(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        this.F0 = true;
        this.U0.N1().postValue(Boolean.TRUE);
        if (this.f63734m.isFlashEnabled() && this.W != LSCaptureMode.GIF) {
            this.f63734m.turnFlash(A(), true);
        }
        this.E.X1();
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_CAMERA_START_RECORD, f63916q1);
        }
        if (!this.f63734m.isFrontCamera()) {
            this.f63734m.setFocusModeRecording();
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I(true);
    }

    private void q1() {
        this.f63938m0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P1() {
        F2(false, A());
        this.U0.M1().postValue(Boolean.FALSE);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void onCaptureError(final int i3) {
        this.F0 = false;
        this.U0.N1().postValue(Boolean.FALSE);
        ms.a.d(this.f63731f, "onCaptureError. errorCode = " + i3, new Throwable());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.60

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit$60$a */
            /* loaded from: classes32.dex */
            class a implements ah {
                a() {
                }

                @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.ah
                public void callback() {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1a), 0).show();
                    LSMiddleCameraUnit.this.f63933j1 = null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity A;
                switch (i3) {
                    case 101:
                    case 104:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1c), 1).show();
                        Activity A2 = LSMiddleCameraUnit.this.A();
                        if (A2 == null || A2.isFinishing()) {
                            return;
                        }
                        A2.finish();
                        return;
                    case 102:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1d), 0).show();
                        LSMiddleCameraUnit.this.E2();
                        LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
                        if (lSMiddleCameraUnit.f63734m == null || (A = lSMiddleCameraUnit.A()) == null || A.isFinishing()) {
                            return;
                        }
                        LSMiddleCameraUnit.this.f63734m.turnFlash(A, false);
                        return;
                    case 103:
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y1b), 0).show();
                        return;
                    case 105:
                        LSMiddleCameraUnit.this.f63933j1 = new a();
                        LSMiddleCameraUnit.this.f63954y0.q(262149, new Object[0]);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
    public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
        this.F0 = false;
        this.U0.N1().postValue(Boolean.FALSE);
        if (!z16) {
            onCaptureError(101);
            return;
        }
        ms.a.f(this.f63731f, "[onVideoCaptured] videoInfo = " + localMediaInfo.mDuration);
        M2(false);
        this.f63954y0.q(196609, new Object[0]);
        this.f63954y0.q(262146, this.N, localMediaInfo, Integer.valueOf(this.X), this.R, this.f63954y0.b(196610, new Object[0]));
    }

    private void K1(LSCaptureMode lSCaptureMode, LSCaptureMode lSCaptureMode2) {
        int f16;
        if (lSCaptureMode != null && lSCaptureMode.shouldStartCamera()) {
            j0();
        }
        if (!lSCaptureMode2.shouldStartCamera()) {
            x(false);
            return;
        }
        if (this.Y.f() == 0) {
            f16 = K();
        } else {
            f16 = this.Y.f();
        }
        if (lSCaptureMode2 == LSCaptureMode.GIF) {
            f16 = 1;
        }
        if (!this.f63727a0) {
            this.f63734m.setSelectedCamera(f16);
        } else if (this.f63729c0) {
            this.f63734m.r(f16, new s());
        }
    }

    private void O1(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey(QQWinkConstants.MATERIAL_GUIDE_VIDEO)) {
            return;
        }
        String str = hashMap.get(QQWinkConstants.MATERIAL_GUIDE_VIDEO);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ms.a.f(this.f63731f, "guideVideo:" + str);
        this.Q0.b2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W1(AEMaterialMetaData aEMaterialMetaData) {
        AEFilterManager aEFilterManager;
        return (aEMaterialMetaData == null || !aEMaterialMetaData.isdoubleclick || (aEFilterManager = this.f63924f0) == null || aEFilterManager.wmGetEditableWMElements() == null || this.f63924f0.wmGetEditableWMElements().size() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(MetaMaterial metaMaterial) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView;
        if (metaMaterial == null || (lSCameraGLSurfaceView = this.E) == null) {
            return;
        }
        lSCameraGLSurfaceView.y1();
    }

    public void N2() {
        com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
        if (gq.a.f(this.Y.l())) {
            dVar.l(14);
        } else {
            dVar.l(this.R.f423403c);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void onAssetProcessingData(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if ("did_show_image".equals(hashMap.get("material_result"))) {
                ms.a.f(this.f63731f, "AIBeauty---did_show_image");
                com.tencent.aelight.camera.ae.flashshow.ui.beauty.a.f64763a.i(((com.tencent.aelight.camera.ae.flashshow.ui.beauty.b) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.flashshow.ui.beauty.b.class)).L1().getValue());
                this.f63730d0.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.43
                    @Override // java.lang.Runnable
                    public void run() {
                        LSMiddleCameraUnit.this.w1();
                    }
                }, 3000L);
            } else if ("did_hit_image".equals(hashMap.get("material_result"))) {
                ms.a.f(this.f63731f, "AIBeauty---did_hit_image");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.44
                    @Override // java.lang.Runnable
                    public void run() {
                        LSMiddleCameraUnit.this.f63954y0.q(327702, new Object[0]);
                    }
                });
            }
        }
        I1(hashMap);
        N1(hashMap);
        H1(hashMap);
        O1(hashMap);
        L1(hashMap);
        J1(hashMap);
        M1(hashMap);
        G1(hashMap);
        F1(hashMap);
        this.f63938m0 = hashMap;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void s(LSFilterProcessTex lSFilterProcessTex) {
        LSTipsViewController lSTipsViewController;
        if (lSFilterProcessTex != null && (lSTipsViewController = this.f63944p0) != null) {
            lSFilterProcessTex.M0(lSTipsViewController.h());
        }
        if (lSFilterProcessTex != null) {
            this.f63924f0 = lSFilterProcessTex.R();
        } else {
            this.f63924f0 = null;
        }
    }

    public static void F2(boolean z16, Activity activity) {
        if (activity == null) {
            return;
        }
        if (activity.hasWindowFocus() || !z16) {
            Intent intent = new Intent();
            intent.setAction("ae_editor_bottom_tab_show_hide");
            intent.putExtra("is_show", z16);
            activity.sendBroadcast(intent);
        }
    }

    private void G1(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_ANSWER_SCORE)) {
            String str = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_ANSWER_SCORE);
            ms.a.a(this.f63731f, "score is: " + str);
            LSCameraMaterialJSServiceManager.f63895a.r(str, this.Q0);
        }
    }

    private void I1(HashMap<String, String> hashMap) {
        String str;
        if (hashMap == null || !hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_JCE_REQ) || (str = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_JCE_REQ)) == null) {
            return;
        }
        LSCameraMaterialJSServiceManager.f63895a.k(str, new p());
    }

    private void J1(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_PB_REQ)) {
            LSCameraMaterialJSServiceManager.f63895a.o(hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_PB_REQ), new LSCameraMaterialJSServiceManager.a() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.51
                @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager.a
                public void a(final String str) {
                    if (str == null || str.isEmpty()) {
                        return;
                    }
                    ms.a.a(LSMiddleCameraUnit.this.f63731f, "OnCameraMaterialGeneralJSPBRsp is: " + str);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.51.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
                            if (aEFilterManager != null) {
                                aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str);
                            }
                        }
                    }, 64, null, true);
                }
            });
        }
    }

    private void L1(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME)) {
            String str = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME);
            ms.a.a(this.f63731f, "receive filament first frame: " + str);
            if (str.equals("0")) {
                xq.c.f448345a.g();
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.50
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(LSMiddleCameraUnit.this.A(), R.string.y0d, 0).show();
                    }
                });
            }
        }
    }

    private void M1(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_FRIEND_SELECTED_REQ)) {
            String str = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_FRIEND_SELECTED_REQ);
            ms.a.a(this.f63731f, "friendSelected is: " + str);
            LSCameraMaterialJSServiceManager.f63895a.n(str, this.Q0);
        }
    }

    private void N1(HashMap<String, String> hashMap) {
        String str;
        if (hashMap == null) {
            return;
        }
        if (hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_RES_DOWNLOAD_REQ)) {
            String str2 = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_RES_DOWNLOAD_REQ);
            if (str2 != null) {
                LSCameraMaterialJSServiceManager.f63895a.l(str2, new LSCameraMaterialJSServiceManager.c() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.47
                    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager.c
                    public void a(final String str3) {
                        ms.a.f(LSMiddleCameraUnit.this.f63731f, "OnCameraMaterialJSResourceDownloadRsp: " + str3);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.47.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
                                if (aEFilterManager != null) {
                                    aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str3);
                                }
                            }
                        }, 64, null, true);
                    }
                });
                return;
            }
            return;
        }
        if (!hashMap.containsKey(AECameraConstants.KEY_CAMERA_MATERIAL_JS_RES_LIST_DOWNLOAD_REQ) || (str = hashMap.get(AECameraConstants.KEY_CAMERA_MATERIAL_JS_RES_LIST_DOWNLOAD_REQ)) == null) {
            return;
        }
        LSCameraMaterialJSServiceManager.f63895a.m(str, new LSCameraMaterialJSServiceManager.c() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.48
            @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager.c
            public void a(final String str3) {
                ms.a.f(LSMiddleCameraUnit.this.f63731f, "OnCameraMaterialJSResourceDownloadRsp: " + str3);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEFilterManager aEFilterManager = LSMiddleCameraUnit.this.f63924f0;
                        if (aEFilterManager != null) {
                            aEFilterManager.setLightNodePresetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str3);
                        }
                    }
                }, 64, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar, boolean z16) {
        com.tencent.aelight.camera.ae.camera.ui.panel.f D2;
        int B1;
        if (bVar == null || (D2 = AEProviderViewModel.D2(bVar)) == null) {
            return;
        }
        D2.getName();
        String maskPath = D2.getMaskPath();
        int i3 = af.f63991a[bVar.getType().ordinal()];
        if (i3 == 1) {
            int i16 = "lipstick_shanhu_male".equals(D2.getType()) ? 0 : 2;
            B1 = D2.getEnable() ? B1(bVar) : 0;
            if (z16) {
                this.E.setBeautyOrTransformLevel(bVar.getType(), B1);
                return;
            } else {
                this.E.A1(maskPath, B1, i16);
                this.E.D1(true);
                return;
            }
        }
        if (i3 == 2) {
            int B12 = B1(bVar);
            if ("red_check_ri_chang_male".equals(D2.getType())) {
                B12 = (int) (B12 * 0.6f);
            }
            B1 = D2.getEnable() ? B12 : 0;
            if (z16) {
                this.E.setBeautyOrTransformLevel(bVar.getType(), B1);
                return;
            } else {
                this.E.B1(maskPath, B1);
                this.E.D1(true);
                return;
            }
        }
        if (i3 != 3) {
            if (i3 != 4) {
                return;
            }
            B1 = D2.getEnable() ? B1(bVar) : 0;
            this.E.E1(D2.getType());
            this.E.setBeautyOrTransformLevel(bVar.getType(), B1);
            return;
        }
        B1 = D2.getEnable() ? B1(bVar) : 0;
        if (z16) {
            this.E.setBeautyOrTransformLevel(bVar.getType(), B1);
        } else {
            this.E.C1(maskPath, B1);
            this.E.D1(true);
        }
    }

    private void h1(View view) {
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

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void k(ExposureInfo exposureInfo) {
        if (exposureInfo == null) {
            return;
        }
        ms.a.f(this.f63731f, "onRequestExposure---iso=" + exposureInfo.iso + ",exposureTime=" + exposureInfo.exposureTime);
        LSCameraManager lSCameraManager = this.f63734m;
        if (lSCameraManager != null) {
            lSCameraManager.y(exposureInfo.iso, exposureInfo.exposureTime);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void l(ExposureInfo exposureInfo) {
        LSCameraManager lSCameraManager;
        if (exposureInfo == null || (lSCameraManager = this.f63734m) == null) {
            return;
        }
        exposureInfo.iso = lSCameraManager.u();
        exposureInfo.exposureTime = this.f63734m.t();
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public boolean m(int i3, KeyEvent keyEvent, boolean z16) {
        if (i3 == 4) {
            onBackPressed();
        }
        return super.m(i3, keyEvent, z16);
    }

    public void m2(AECompoundButton aECompoundButton) {
        if (aECompoundButton == null) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200L);
        aECompoundButton.startAnimation(rotateAnimation);
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.W0.a(), 200L, null);
        if (this.f63734m.isFrontCamera()) {
            aECompoundButton.setContentDescription(this.W0.getResources().getString(R.string.y9t));
        } else {
            aECompoundButton.setContentDescription(this.W0.getResources().getString(R.string.y9u));
        }
        m0();
        vq.a.f443174a.a(aECompoundButton, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(com.tencent.aelight.camera.ae.r rVar) {
        AEMaterialMetaData aEMaterialMetaData;
        boolean z16;
        int i3;
        if (rVar != null) {
            aEMaterialMetaData = rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            i3 = rVar.getType();
            z16 = rVar.getForceUpdate();
        } else {
            aEMaterialMetaData = null;
            z16 = false;
            i3 = 0;
        }
        if (this.f63942o0) {
            this.f63942o0 = false;
        }
        if (aEMaterialMetaData != null) {
            VideoReport.setPageParams(A(), "ae_motion_id", aEMaterialMetaData.f69050id);
        }
        if (aEMaterialMetaData != null && aEMaterialMetaData.aigcMaterial.booleanValue() && com.tencent.mobileqq.wink.utils.ar.f326685a.c("ae_key_editor_camera_proto", true)) {
            this.Q0.S1(4, null);
            return;
        }
        if (v1(aEMaterialMetaData, i3, z16)) {
            return;
        }
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.x(aEMaterialMetaData, z16);
        }
        lq.b bVar = this.f63954y0;
        Object[] objArr = new Object[1];
        if (aEMaterialMetaData == null) {
            aEMaterialMetaData = AEMaterialMetaData.MATERIAL_NONE;
        }
        objArr[0] = aEMaterialMetaData;
        bVar.q(851970, objArr);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public LSCaptureMode[] M(int i3) {
        LSCaptureMode[] lSCaptureModeArr;
        switch (i3) {
            case 201:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.NORMAL, LSCaptureMode.PLAY, LSCaptureMode.GIF};
                break;
            case 202:
            case 203:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.GIF};
                break;
            case 204:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.NORMAL, LSCaptureMode.PLAY};
                break;
            case 205:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.NORMAL, LSCaptureMode.GIF};
                break;
            case 206:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.PLAY};
                break;
            case 207:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.PLAY, LSCaptureMode.GIF};
                break;
            default:
                lSCaptureModeArr = new LSCaptureMode[]{LSCaptureMode.NORMAL};
                break;
        }
        ms.a.f(this.f63731f, "initCaptureModesAndFirstMode---initialMode=" + this.T + ", initialCModes=" + Arrays.toString(lSCaptureModeArr));
        return lSCaptureModeArr;
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void notifyEnableLutType(int i3) {
        if (i3 == 1000) {
            x2(1);
            lq.b bVar = this.f63954y0;
            if (bVar != null) {
                bVar.q(196609, new Object[0]);
            }
        } else {
            x2(0);
        }
        LSFilterProcessTex a16 = com.tencent.aelight.camera.ae.flashshow.filter.b.a();
        if (a16 != null) {
            a16.W = i3 != 1000;
            if (i3 == 1000) {
                a16.l0();
            }
        }
        LSCaptureController lSCaptureController = this.f63953x0;
        if (lSCaptureController != null) {
            lSCaptureController.f64645m = i3 != 1000;
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
    public void notifyEnableMeshType(int i3) {
        y2(i3 == 2001 ? 4 : 3);
    }

    public void Q2(int i3, Object obj, int i16, boolean z16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ms.a.f(this.f63731f, "update light camera effect with cosmetics");
                    LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
                    if (lSCameraGLSurfaceView != null) {
                        lSCameraGLSurfaceView.g2(i16);
                    }
                    VideoReport.setPageParams(A(), "ae_cosmetic_value", Integer.valueOf(i16));
                    return;
                }
                if (i3 != 4) {
                    return;
                }
            }
            ms.a.f(this.f63731f, "update light camera effect with beauty");
            if (obj instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
                P2((com.tencent.aelight.camera.ae.camera.ui.panel.b) obj, z16);
                VideoReport.setPageParams(A(), "ae_beauty_value", "");
                return;
            }
            return;
        }
        ms.a.f(this.f63731f, "update light camera effect with filter");
        LSCameraGLSurfaceView lSCameraGLSurfaceView2 = this.E;
        if (lSCameraGLSurfaceView2 != null) {
            lSCameraGLSurfaceView2.h2(i16);
        }
        VideoReport.setPageParams(A(), "ae_filter_value", Integer.valueOf(i16));
    }

    public LSMiddleCameraUnit(or.e eVar, or.d dVar, Bundle bundle) {
        super(eVar, dVar, bundle);
        this.f63930i0 = null;
        this.f63936l0 = new AnonymousClass1();
        this.f63940n0 = false;
        this.f63942o0 = false;
        this.f63955z0 = new l();
        this.A0 = new n();
        this.B0 = new q();
        this.C0 = new y();
        this.D0 = new ag();
        this.E0 = new LSCameraBroadcastReceiver(this);
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0L;
        this.J0 = -1L;
        this.K0 = false;
        this.M0 = false;
        this.N0 = false;
        this.O0 = com.tencent.aelight.camera.ae.util.i.a();
        this.f63931i1 = false;
        ms.a.f(this.f63731f, "[LSMiddleCameraUnit] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        tq.b.h().o("unitConstructor-begin");
        Log.d(this.f63731f, "LSMiddleCameraUnit: cameraConfig.getFrom() =" + this.Y.l());
        this.X = 11;
        if (!gq.a.f(this.Y.l())) {
            this.X = this.Y.i().intValue();
            this.R = new or.a(this.f63732h.getActivity().getIntent().getIntExtra("edit_video_type", 10002), this.Y.k(), this.Y.b());
        }
        ms.a.f(this.f63731f, "[LSMiddleCameraUnit] submit unit init");
        A2();
        U1();
        ms.a.f(this.f63731f, "[LSMiddleCameraUnit] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void M2(boolean z16) {
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class l implements AEMaterialPanel.e {
        l() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void a(AEMaterialMetaData aEMaterialMetaData) {
            LSMiddleCameraUnit lSMiddleCameraUnit = LSMiddleCameraUnit.this;
            if (lSMiddleCameraUnit.W == LSCaptureMode.NORMAL) {
                com.tencent.aelight.camera.ae.e eVar = lSMiddleCameraUnit.Q0;
                if (eVar != null) {
                    eVar.S1(0, aEMaterialMetaData);
                    return;
                }
                return;
            }
            ms.a.c(lSMiddleCameraUnit.f63731f, "onMaterialSelected---but current capture mode is not normal");
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.e
        public void c() {
            com.tencent.aelight.camera.ae.e eVar = LSMiddleCameraUnit.this.Q0;
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

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected h.a H() {
        return this;
    }

    @QQPermissionDenied(1)
    public void denied() {
    }

    protected void e1() {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void f() {
    }

    protected void n2() {
    }

    protected void j2(boolean z16, String str) {
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements QQPermissionCallback {
        a() {
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            LSMiddleCameraUnit.this.n1();
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
        }
    }
}
