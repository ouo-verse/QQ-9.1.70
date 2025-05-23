package com.tencent.could.huiyansdk.fragments;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.could.aicamare.entity.CameraConfig;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.huiyansdk.api.HuiYanInputDataCallBack;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.base.HuiYanBaseCallBack;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.enums.HuiYanAuthEvent;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.could.huiyansdk.enums.HuiYanLiveMode;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.could.huiyansdk.exception.CallbackErrorCode;
import com.tencent.could.huiyansdk.helper.b;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.h;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.permission.c;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.utils.a;
import com.tencent.could.huiyansdk.utils.b;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.could.huiyansdk.utils.s;
import com.tencent.could.huiyansdk.view.CameraDateGatherView;
import com.tencent.could.huiyansdk.view.HuiYanReflectLayout;
import com.tencent.could.huiyansdk.view.LoadingFrontAnimatorView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AuthingFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.could.huiyansdk.turing.a f100047b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f100048c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f100049d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f100050e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f100051f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f100052g;

    /* renamed from: h, reason: collision with root package name */
    public HuiYanReflectLayout f100053h;

    /* renamed from: i, reason: collision with root package name */
    public LoadingFrontAnimatorView f100054i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f100055j;

    /* renamed from: k, reason: collision with root package name */
    public int f100056k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f100057l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f100058m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.could.huiyansdk.utils.o f100059n;

    /* renamed from: o, reason: collision with root package name */
    public CameraHolder f100060o;

    /* renamed from: p, reason: collision with root package name */
    public com.tencent.could.huiyansdk.view.b f100061p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f100062q;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f100063r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f100064s;

    /* renamed from: t, reason: collision with root package name */
    public AnimationDrawable f100065t;

    /* renamed from: u, reason: collision with root package name */
    public int f100066u;

    /* renamed from: v, reason: collision with root package name */
    public volatile boolean f100067v;

    /* renamed from: w, reason: collision with root package name */
    public volatile boolean f100068w;

    public AuthingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100055j = false;
        this.f100056k = -1;
        this.f100057l = false;
        this.f100058m = false;
        this.f100062q = false;
        this.f100063r = false;
        this.f100064s = false;
        this.f100066u = 0;
        this.f100067v = false;
        this.f100068w = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Object obj = this.f100047b;
        if (obj != null && (obj instanceof View)) {
            ((View) obj).setVisibility(0);
        }
        this.f100057l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f100060o == null) {
            this.f100060o = new CameraHolder();
        }
        this.f100060o.setLoggerCallBack(new c(this));
        this.f100060o.setEventListener(new d(this));
        CameraConfig cameraConfig = new CameraConfig();
        cameraConfig.setMainThread(false);
        cameraConfig.setPreWidth(640);
        cameraConfig.setPreHeight(480);
        if (HuiYanSdkImp.getInstance().isUsing720p()) {
            cameraConfig.setPreWidth(1280);
            cameraConfig.setPreHeight(720);
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        if (sdkConfig != null) {
            cameraConfig.setMinFps(30);
            cameraConfig.setMaxFps(30);
            cameraConfig.setBackCamera(sdkConfig.isUseBackCamera());
            if (sdkConfig.isUseBackCamera()) {
                cameraConfig.setZoom(sdkConfig.getZoomLevel());
            }
            cameraConfig.setMustDiffMinAndMaxFps(sdkConfig.isMustDiffMinAndMaxFps());
        } else {
            cameraConfig.setMinFps(30);
            cameraConfig.setMaxFps(30);
            cameraConfig.setBackCamera(false);
        }
        cameraConfig.setByteDataBuffer(true);
        cameraConfig.setSupportZoom(false);
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        this.f100060o.initCameraHolder(huiYanBaseApi.a(), cameraConfig);
        this.f100047b.setCameraHolder(this.f100060o);
        Context a16 = huiYanBaseApi.a();
        CameraHolder cameraHolder = this.f100060o;
        if (cameraHolder != null && a16 != null) {
            cameraHolder.openCamera(a16);
            com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(QbSdk.KEY_THIRD_PARTY_TURING);
            fVar.f100284m = baseHandlerThread;
            baseHandlerThread.start();
            fVar.f100285n = new com.tencent.could.huiyansdk.turing.e(fVar, fVar.f100284m.getLooper());
            return;
        }
        if (l.a.f100309a.f100307a) {
            AiLog.debug("AuthingFragment", "startAuthAction cameraHolder or context is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i3;
        CameraHolder cameraHolder = this.f100060o;
        if (cameraHolder != null) {
            cameraHolder.release();
            f.a.f100288a.b();
        }
        a(true);
        if (HuiYanSdkImp.getInstance().getSdkConfig().isAutoScreenBrightness() && (i3 = this.f100056k) != -1) {
            b(i3);
            this.f100056k = -1;
        }
        h.b.f100187a.a();
        if (HuiYanSdkImp.getInstance().isWaitingUserCompare()) {
            if (this.f100048c != null) {
                TextView textView = this.f100049d;
                if (textView != null) {
                    textView.setText(c().getString(R.string.txy_wait_for_result));
                    this.f100049d.setTextColor(c().getColor(R.color.cwu));
                }
                TextView textView2 = this.f100050e;
                if (textView2 != null) {
                    textView2.setVisibility(4);
                }
                View view = this.f100069a;
                if (view != null) {
                    view.findViewById(R.id.f113426ql).setVisibility(4);
                    this.f100069a.findViewById(R.id.f113516qu).setVisibility(4);
                }
                HuiYanInputDataCallBack inputDataCallBack = HuiYanSdkImp.getInstance().getInputDataCallBack();
                if (inputDataCallBack != null) {
                    this.f100065t = inputDataCallBack.getWaitingAnimation();
                }
                if (this.f100065t == null) {
                    if (l.a.f100309a.f100307a) {
                        AiLog.error("AuthingFragment", "animationDrawable is null!");
                    }
                    this.f100048c.setVisibility(4);
                    this.f100049d.setVisibility(4);
                    return;
                }
                Object obj = this.f100047b;
                if (obj != null && (obj instanceof View)) {
                    ((View) obj).setVisibility(4);
                }
                ImageView imageView = this.f100048c;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                this.f100048c.setImageDrawable(this.f100065t);
                this.f100065t.start();
                return;
            }
            return;
        }
        CommonUtils.closeCurrentFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.tencent.could.huiyansdk.utils.s sVar = s.a.f100325a;
        if (sVar.f100324b != null) {
            sVar.f100324b = null;
        }
        CountDownTimer countDownTimer = sVar.f100323a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            sVar.f100323a = null;
        }
        TextView textView = this.f100051f;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, obj);
            return;
        }
        k.a.f100197a.a(1, "AuthingFragment", ">>>local auth fail");
        q();
        if (obj instanceof CompareResult) {
            final CompareResult compareResult = (CompareResult) obj;
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.l
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.a(compareResult);
                }
            });
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        k.a.f100197a.a(1, "AuthingFragment", "user cancel the auth check.");
        HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "UserCancelAuth", "");
        CommonUtils.sendErrorAndExitAuth(212, c().getString(R.string.f237067g2));
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f100047b instanceof View) {
            if (this.f100057l) {
                g();
                ((View) this.f100047b).setVisibility(0);
            } else {
                this.f100048c.setVisibility(0);
                ((View) this.f100047b).setVisibility(4);
            }
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f100047b = (com.tencent.could.huiyansdk.turing.a) this.f100069a.findViewById(R.id.f113496qs);
        this.f100069a.findViewById(R.id.f113516qu).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.fragments.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthingFragment.this.a(view);
            }
        });
        this.f100048c = (ImageView) this.f100069a.findViewById(R.id.f113506qt);
        this.f100049d = (TextView) this.f100069a.findViewById(R.id.f113456qo);
        this.f100050e = (TextView) this.f100069a.findViewById(R.id.f113446qn);
        this.f100054i = (LoadingFrontAnimatorView) this.f100069a.findViewById(R.id.f113476qq);
        this.f100051f = (TextView) this.f100069a.findViewById(R.id.f113526qv);
        this.f100052g = (TextView) this.f100069a.findViewById(R.id.f113516qu);
        com.tencent.could.huiyansdk.utils.o oVar = new com.tencent.could.huiyansdk.utils.o();
        this.f100059n = oVar;
        TextView textView = this.f100050e;
        oVar.f100317e.clear();
        oVar.f100315c = textView;
        if (oVar.f100313a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("showTips");
            oVar.f100313a = baseHandlerThread;
            baseHandlerThread.start();
            oVar.f100314b = new com.tencent.could.huiyansdk.utils.n(oVar, oVar.f100313a.getLooper());
            oVar.b();
        }
        this.f100049d.setText(R.string.txy_face_preparing3);
        if (this.f100051f != null) {
            s.a.f100325a.f100324b = new b(this);
        }
        this.f100062q = false;
        this.f100066u = 0;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.f100048c == null) {
            return;
        }
        AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
        if (authUiConfig != null && authUiConfig.isHideAvatarGuideFrame()) {
            this.f100048c.setVisibility(8);
            return;
        }
        this.f100048c.setScaleX(0.935f);
        this.f100048c.setScaleY(0.935f);
        this.f100048c.setVisibility(0);
        this.f100048c.setImageResource(R.drawable.lzf);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            k.a.f100197a.a(1, "AuthingFragment", ">>>start camera preview(get light data ok)");
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.w
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.h();
                }
            });
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            k.a.f100197a.a(1, "AuthingFragment", ">>>start auth action");
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.t
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.i();
                }
            });
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        k.a.f100197a.a(1, "AuthingFragment", ">>>start auth end.");
        q();
        f.a.f100180a.b();
        a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.m
            @Override // java.lang.Runnable
            public final void run() {
                AuthingFragment.this.j();
            }
        });
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.could.huiyansdk.manager.h hVar = h.b.f100187a;
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 == null) {
            Log.e("LightSensor", "context is null");
        } else if (!hVar.f100184c) {
            hVar.f100184c = true;
            SensorManager sensorManager = (SensorManager) a16.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            hVar.f100182a = sensorManager;
            if (sensorManager == null) {
                k.a.f100197a.a(2, "LightSensor", " \u5149\u7ebf\u4f20\u611f\u5668\u4e0d\u53ef\u7528~");
            } else {
                Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 5);
                if (defaultSensor != null) {
                    h.a aVar = new h.a();
                    hVar.f100183b = aVar;
                    SensorMonitor.registerListener(hVar.f100182a, aVar, defaultSensor, 3);
                } else {
                    k.a.f100197a.a(2, "LightSensor", " \u5149\u7ebf\u4f20\u611f\u5668\u4e0d\u53ef\u7528~");
                }
            }
        }
        h.c cVar = new h.c() { // from class: com.tencent.could.huiyansdk.fragments.v
            @Override // com.tencent.could.huiyansdk.manager.h.c
            public final void a(float f16) {
                AuthingFragment.this.a(f16);
            }
        };
        if (hVar.f100183b != null) {
            hVar.f100185d = cVar;
        } else {
            k.a.f100197a.a(2, "LightSensor", "\u8bbe\u5907\u65e0\u5149\u7ebf\u4f20\u611f\u5668\u6216\u8005\u672a\u8c03\u7528start()\u65b9\u6cd5");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a.f100197a.a(2, "AuthingFragment", "can not get activity!");
            return;
        }
        try {
            this.f100056k = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException unused) {
            k.a.f100197a.a(2, "AuthingFragment", "can not get screen brightness");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
            return;
        }
        super.onAttach(context);
        this.f100064s = false;
        k.a.f100197a.a(1, "AuthingFragment", "on attach.");
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView;
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 17, this, layoutInflater, viewGroup, bundle);
        } else {
            if (this.f100069a == null) {
                HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
                if (sdkConfig != null && sdkConfig.isLandMode()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
                if (authUiConfig != null && !z16 && authUiConfig.getAuthLayoutResId() != -1) {
                    i3 = authUiConfig.getAuthLayoutResId();
                } else {
                    i3 = R.layout.i2k;
                }
                if (authUiConfig != null && z16 && authUiConfig.getLandAuthLayoutResId() != -1) {
                    i3 = authUiConfig.getLandAuthLayoutResId();
                }
                this.f100069a = layoutInflater.inflate(i3, viewGroup, false);
                f();
                e();
                c.b.f100154a.f100133b = new e(this);
                this.f100053h = (HuiYanReflectLayout) this.f100069a.findViewById(R.id.f113466qp);
                if (HuiYanSdkImp.getInstance().getPageColorStyle() == PageColorStyle.Light) {
                    this.f100053h.setBackgroundColor(c().getColor(R.color.cxh));
                } else {
                    ((TextView) this.f100069a.findViewById(R.id.f113516qu)).setTextColor(c().getColor(R.color.cxh));
                    this.f100049d.setTextColor(c().getColor(R.color.cxh));
                    this.f100051f.setTextColor(c().getColor(R.color.cxh));
                    this.f100048c.setImageResource(R.drawable.m07);
                    this.f100053h.setBackgroundColor(c().getColor(R.color.cwu));
                }
                com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
                TuringResultCacheEntity turingResultCacheEntity = fVar.f100277f;
                if (turingResultCacheEntity != null) {
                    turingResultCacheEntity.reset();
                }
                if (fVar.f100282k && fVar.f100278g != null) {
                    fVar.f100273b = false;
                    com.tencent.could.huiyansdk.turing.d dVar = new com.tencent.could.huiyansdk.turing.d(fVar);
                    if (fVar.f100282k && fVar.f100278g != null) {
                        fVar.f100278g.f100269a = dVar;
                    } else {
                        k.a.f100197a.a(2, "TuringSdkHelper", "set event listener, turing is not create!");
                    }
                    fVar.f100279h = new com.tencent.could.huiyansdk.manager.l();
                } else {
                    k.a.f100197a.a(2, "TuringSdkHelper", "init turing sdk logic, turing is not create!");
                }
                b.a.f100299a.f100298a = new com.tencent.could.huiyansdk.utils.p<>(20, "FrameCreatePool");
                a.C1020a.f100297a.f100296a = new com.tencent.could.huiyansdk.utils.p<>(10, "ChangeBytePool");
                if (HuiYanSdkImp.getInstance().isUsing720p()) {
                    com.tencent.could.huiyansdk.turing.a aVar = this.f100047b;
                    if (aVar instanceof CameraDateGatherView) {
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((CameraDateGatherView) aVar).getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (((ViewGroup.MarginLayoutParams) layoutParams).height * 1.3d);
                        ((CameraDateGatherView) this.f100047b).setLayoutParams(layoutParams);
                    }
                }
                AuthUiConfig authUiConfig2 = HuiYanSdkImp.getInstance().getAuthUiConfig();
                if (authUiConfig2 != null) {
                    if (this.f100053h != null && authUiConfig2.getAuthLayoutBgColor() != -1) {
                        this.f100053h.setBackgroundColor(authUiConfig2.getAuthLayoutBgColor());
                    }
                    if (this.f100049d != null && authUiConfig2.getFeedBackTxtColor() != -1) {
                        this.f100049d.setTextColor(authUiConfig2.getFeedBackTxtColor());
                    }
                    if (this.f100050e != null && authUiConfig2.getFeedBackExtraTipColor() != -1) {
                        this.f100050e.setTextColor(authUiConfig2.getFeedBackExtraTipColor());
                    }
                    if (this.f100048c != null && authUiConfig2.getPrepareImageViewDrawable() != null) {
                        this.f100048c.setImageDrawable(authUiConfig2.getPrepareImageViewDrawable());
                    }
                    if (this.f100050e != null && authUiConfig2.isHiddenExtraTipsTxt()) {
                        this.f100050e.setVisibility(4);
                    }
                    if (this.f100051f != null && (authUiConfig2.isCancelBtnRight() || !authUiConfig2.isShowCountdown())) {
                        this.f100051f.setVisibility(4);
                    }
                    if (this.f100052g != null && authUiConfig2.isCancelBtnRight()) {
                        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
                        layoutParams2.endToEnd = 0;
                        layoutParams2.topToTop = 0;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = CommonUtils.dpToPx(this.f100052g, 18.0f);
                        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = CommonUtils.dpToPx(this.f100052g, 16.0f);
                        this.f100052g.setLayoutParams(layoutParams2);
                    }
                }
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a.f100197a.a(2, "AuthingFragment", "activity is null!");
                } else {
                    com.tencent.could.huiyansdk.permission.c cVar = c.a.f100268a;
                    String[] strArr = com.tencent.could.huiyansdk.utils.m.f100310a;
                    a aVar2 = new a(this);
                    cVar.f100266b = aVar2;
                    ArrayList arrayList = new ArrayList();
                    for (int i16 = 0; i16 < strArr.length; i16++) {
                        if (ContextCompat.checkSelfPermission(activity, strArr[i16]) != 0) {
                            arrayList.add(strArr[i16]);
                        }
                    }
                    String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    if (strArr2.length > 0) {
                        ActivityCompat.requestPermissions(activity, strArr2, 119);
                    } else {
                        aVar2.b();
                    }
                }
            }
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.onDestroy();
        k.a.f100197a.a(1, "AuthingFragment", "on destroy.");
        this.f100064s = false;
        this.f100062q = false;
        com.tencent.could.huiyansdk.view.b bVar = this.f100061p;
        if (bVar != null) {
            bVar.dismiss();
            this.f100061p = null;
        }
        if (this.f100047b != null) {
            this.f100047b = null;
        }
        HuiYanBaseApi.b.f100031a.getClass();
        com.tencent.could.huiyansdk.helper.b bVar2 = b.a.f100123a;
        if (bVar2.f100121b != null) {
            bVar2.f100121b = null;
        }
        YtSDKKitFramework.getInstance().deInit();
        h.b.f100187a.a();
        if (HuiYanSdkImp.getInstance().getSdkConfig().isAutoScreenBrightness() && (i3 = this.f100056k) != -1) {
            b(i3);
        }
        CameraHolder cameraHolder = this.f100060o;
        if (cameraHolder != null) {
            cameraHolder.release();
            f.a.f100288a.b();
        }
        com.tencent.could.huiyansdk.manager.c cVar = c.b.f100154a;
        if (cVar.f100133b != null) {
            cVar.f100133b = null;
        }
        if (cVar.f100132a != null) {
            cVar.f100132a = null;
        }
        if (cVar.f100142k != null) {
            cVar.f100142k = null;
        }
        cVar.f100134c = false;
        a(true);
        com.tencent.could.huiyansdk.utils.o oVar = this.f100059n;
        if (oVar != null && oVar.f100314b != null) {
            oVar.f100314b.removeMessages(1);
            oVar.f100314b = null;
            HandlerThread handlerThread = oVar.f100313a;
            if (handlerThread != null && handlerThread.isAlive()) {
                oVar.f100313a.quitSafely();
            }
        }
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        com.tencent.could.huiyansdk.manager.l lVar = fVar.f100279h;
        if (lVar != null) {
            while (lVar.f100198a.size() > 0) {
                b.a.f100299a.a(lVar.f100198a.poll());
            }
            lVar.f100207j = true;
            lVar.f100208k = true;
            lVar.f100213p = false;
            lVar.f100214q = true;
        }
        fVar.f100276e = false;
        fVar.f100275d = false;
        fVar.f100273b = false;
        fVar.f100287p = false;
        fVar.b();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.onResume();
            e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        boolean a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Context a17 = HuiYanBaseApi.b.f100031a.a();
        if (a17 == null) {
            a16 = false;
        } else {
            a16 = com.tencent.could.huiyansdk.utils.m.a(a17, com.tencent.could.huiyansdk.utils.m.f100310a);
        }
        if (!a16) {
            super.onStop();
            return;
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        if (sdkConfig != null && sdkConfig.isBackgroundStopAuth()) {
            if (HuiYanSdkImp.getInstance().isCurrentFinish()) {
                super.onStop();
                return;
            }
            CameraHolder cameraHolder = this.f100060o;
            if (cameraHolder != null) {
                cameraHolder.release();
            }
            com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
            if (bVar.f100121b != null) {
                bVar.f100121b = null;
            }
            YtSDKKitFramework.getInstance().deInit();
            f.a.f100180a.b();
            if (getContext() != null) {
                String string = c().getString(R.string.txy_do_not_change_app_in_auth);
                HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "AuthLocalFail", string);
                CompareResult compareResult = new CompareResult();
                compareResult.setErrorMsg(string);
                compareResult.setErrorCode(214);
                b((Object) compareResult);
            }
            super.onStop();
            return;
        }
        super.onStop();
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        k.a.f100197a.a(1, "AuthingFragment", "start prepare auth");
        com.tencent.could.huiyansdk.manager.c cVar = c.b.f100154a;
        com.tencent.could.huiyansdk.callback.a aVar = new com.tencent.could.huiyansdk.callback.a() { // from class: com.tencent.could.huiyansdk.fragments.q
            @Override // com.tencent.could.huiyansdk.callback.a
            public final void a(AuthState authState, Object obj) {
                AuthingFragment.this.a(authState, obj);
            }
        };
        cVar.getClass();
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 == null) {
            Log.e("AuthStateManager", "context is null!");
        } else {
            Resources resources = a16.getResources();
            cVar.f100145n = resources.getColor(R.color.cx5);
            cVar.f100146o = resources.getColor(R.color.cwu);
            cVar.f100147p = resources.getColor(R.color.cwt);
            cVar.f100148q = resources.getColor(R.color.cws);
            AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
            if (authUiConfig != null) {
                if (authUiConfig.getFeedBackErrorColor() != -1) {
                    cVar.f100145n = authUiConfig.getFeedBackErrorColor();
                }
                if (authUiConfig.getFeedBackTxtColor() != -1) {
                    cVar.f100146o = authUiConfig.getFeedBackTxtColor();
                }
                if (authUiConfig.getAuthCircleErrorColor() != -1) {
                    cVar.f100147p = authUiConfig.getAuthCircleErrorColor();
                }
                if (authUiConfig.getAuthCircleCorrectColor() != -1) {
                    cVar.f100148q = authUiConfig.getAuthCircleCorrectColor();
                }
            }
        }
        cVar.f100132a = aVar;
        cVar.a(AuthState.PREPARE, (Object) null);
        cVar.f100139h = -1;
        cVar.f100140i = -1;
        cVar.f100141j = 3;
        cVar.a(AuthState.AUTH_ACTION, (Object) null);
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.o
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.k();
                }
            });
        }
    }

    public final void b(final long j3, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.n
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.a(j3, z16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    public final void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj);
            return;
        }
        q();
        if (obj instanceof CompareResult) {
            final CompareResult compareResult = (CompareResult) obj;
            AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
            if (!(authUiConfig == null ? true : authUiConfig.isShowErrorDialog())) {
                CommonUtils.sendErrorAndExitAuth(compareResult.getErrorCode(), compareResult.getErrorMsg());
            } else {
                a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthingFragment.this.b(compareResult);
                    }
                });
            }
        }
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            d();
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j3, boolean z16) {
        com.tencent.could.huiyansdk.utils.s sVar = s.a.f100325a;
        k.a.f100197a.a(1, "TimeOutHelper", "start count down: " + j3);
        CountDownTimer countDownTimer = sVar.f100323a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (j3 > 0) {
            j3--;
        }
        com.tencent.could.huiyansdk.utils.r rVar = new com.tencent.could.huiyansdk.utils.r(sVar, j3, 1000L);
        sVar.f100323a = rVar;
        rVar.start();
        TextView textView = this.f100051f;
        if (textView != null) {
            textView.setVisibility(z16 ? 0 : 4);
        }
        AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
        if (authUiConfig == null) {
            return;
        }
        if (!authUiConfig.isShowCountdown() || authUiConfig.isCancelBtnRight()) {
            this.f100051f.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CompareResult compareResult) {
        if (this.f100062q) {
            k.a.f100197a.a(2, "AuthingFragment", "error dialog had showing!");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (this.f100061p == null) {
                this.f100061p = new com.tencent.could.huiyansdk.view.b(activity, 0);
            }
            this.f100062q = true;
            HuiYanSdkImp.getInstance().setCurrentFinish();
            WindowManager windowManager = activity.getWindowManager();
            if (windowManager == null) {
                CommonUtils.sendErrorAndExitAuth(compareResult.getErrorCode(), compareResult.getErrorMsg());
                return;
            }
            com.tencent.could.huiyansdk.view.b bVar = this.f100061p;
            bVar.getClass();
            windowManager.getDefaultDisplay().getSize(new Point());
            Window window = bVar.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (HuiYanSdkImp.getInstance().isLandMode()) {
                attributes.height = (int) (r5.x * 0.32f);
                attributes.width = (int) (r5.y * 0.7f);
            } else {
                attributes.width = (int) (r5.x * 0.8f);
                attributes.height = (int) (r5.y * 0.4f);
            }
            window.setAttributes(attributes);
            com.tencent.could.huiyansdk.view.b bVar2 = this.f100061p;
            int errorCode = compareResult.getErrorCode();
            String errorMsg = compareResult.getErrorMsg();
            bVar2.f100357b = errorCode;
            bVar2.f100358c = errorMsg;
            TextView textView = bVar2.f100356a;
            if (textView != null) {
                textView.setText(errorMsg);
            }
            if (HuiYanSdkImp.getInstance().isExitDoNeedShow()) {
                k.a.f100197a.a(2, "ErrorInfoDialog", "activity has exit, do not need show!");
            } else {
                k.a.f100197a.a(2, "ErrorInfoDialog", "showErrorInfo show dialog\uff01");
                bVar2.show();
            }
            a(true);
            k.a.f100197a.a(2, "AuthingFragment", "showErrorDialog error code:" + compareResult.getErrorCode() + " msg: " + compareResult.getErrorMsg());
            return;
        }
        k.a.f100197a.a(2, "AuthingFragment", "activity is null or is finishing by create ErrorInfoDialog");
        CommonUtils.sendErrorAndExitAuth(compareResult.getErrorCode(), compareResult.getErrorMsg());
    }

    public static void a(AuthingFragment authingFragment) {
        int i3;
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        View view = (View) authingFragment.f100047b;
        CameraHolder cameraHolder = authingFragment.f100060o;
        fVar.f100283l = false;
        fVar.f100287p = false;
        if (!fVar.f100282k) {
            k.a.f100197a.a(2, "TuringSdkHelper", "start turing face defender, turing is not create!");
            i3 = CallbackErrorCode.HY_INNER_TURING_NOT_CREATE;
        } else if (fVar.f100278g == null) {
            k.a.f100197a.a(2, "TuringSdkHelper", "start turing face defender, turing interface is null");
            i3 = CallbackErrorCode.HY_INNER_TURING_INTERFACE_IS_NULL;
        } else {
            fVar.f100281j = new WeakReference<>(view);
            try {
                Camera.Size cameraSize = cameraHolder.getCameraSize();
                com.tencent.could.huiyansdk.manager.l lVar = fVar.f100279h;
                if (lVar != null) {
                    lVar.a(cameraSize.width, cameraSize.height, cameraHolder.getCurrentRotate());
                }
                HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
                if (sdkConfig != null) {
                    fVar.f100272a = sdkConfig.getCheckEnvRiskTimeout();
                    k.a.f100197a.a(1, "TuringSdkHelper", "update defaultTuringTimeOut: " + fVar.f100272a);
                }
                fVar.f100286o = System.currentTimeMillis();
                if (fVar.f100285n != null) {
                    Message obtainMessage = fVar.f100285n.obtainMessage();
                    obtainMessage.what = 5;
                    fVar.f100285n.sendMessageDelayed(obtainMessage, fVar.f100272a);
                    HuiYanBaseCallBack huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack != null) {
                        huiYanBaseCallBack.onOperateTimeEvent("GetTuringTokenUseTime", 1, false, "");
                    }
                } else {
                    k.a.f100197a.a(2, "TuringSdkHelper", "start turing face defender, handler == null!");
                }
                HuiYanInputDataCallBack inputDataCallBack = HuiYanSdkImp.getInstance().getInputDataCallBack();
                if (view instanceof com.tencent.could.huiyansdk.view.a) {
                    view = ((com.tencent.could.huiyansdk.view.a) view).getTuringPreviewView();
                }
                if (inputDataCallBack == null) {
                    i3 = fVar.f100278g.a(view, cameraHolder, "");
                } else {
                    i3 = fVar.f100278g.a(view, cameraHolder, inputDataCallBack.getCurrentToken());
                }
            } catch (RuntimeException e16) {
                k.a.f100197a.a(2, "TuringSdkHelper", "camera get parameters with error: " + e16.getLocalizedMessage());
                i3 = CallbackErrorCode.HY_INNER_GET_CAMERA_SIZE_ERROR;
            }
        }
        if (i3 != 0) {
            k.a.f100197a.a(2, "AuthingFragment", "failed to start turing face defender!");
            CommonUtils.sendErrorAndExitAuth(213, authingFragment.c().getString(R.string.txy_inner_error) + "(startTuring fail: " + i3 + ")");
        }
    }

    public final void b(final ColorMatrixColorFilter colorMatrixColorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.s
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.a(colorMatrixColorFilter);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colorMatrixColorFilter);
        }
    }

    public final void b(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.r
                @Override // java.lang.Runnable
                public final void run() {
                    AuthingFragment.this.a(i3);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            super.b();
            HuiYanSdkImp.getInstance().setActivityExitFlag();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f16) {
        String str;
        boolean z16;
        boolean z17;
        if (f16 < 4.0f) {
            str = c().getString(R.string.txy_light_low);
            z16 = true;
        } else {
            str = "";
            z16 = false;
        }
        if (f16 > 235.0f) {
            str = c().getString(R.string.txy_light_strong);
            z17 = true;
            z16 = true;
        } else {
            z17 = false;
        }
        if (this.f100050e == null) {
            return;
        }
        if (z16) {
            if (this.f100063r || !this.f100068w) {
                return;
            }
            this.f100059n.a(str);
            if (z17) {
                HuiYanSdkImp.getInstance().doAuthTipsEvent(HuiYanAuthTipsEvent.LIGHT_TOO_STRONG, true);
            } else {
                HuiYanSdkImp.getInstance().doAuthTipsEvent(HuiYanAuthTipsEvent.LIGHT_TOO_LOW, true);
            }
            this.f100063r = true;
            return;
        }
        if (this.f100063r) {
            this.f100063r = false;
            this.f100059n.a("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AuthState authState, Object obj) {
        switch (authState.ordinal()) {
            case 0:
                com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
                kVar.a(1, "AuthingFragment", ">>>start prepare event");
                if (this.f100054i == null) {
                    kVar.a(2, "AuthingFragment", "loadingFrontAnimatorView is null!");
                    return;
                }
                AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
                if (authUiConfig != null && authUiConfig.isHideFrontCircleViewOnStart()) {
                    this.f100054i.setVisibility(8);
                    return;
                } else {
                    this.f100054i.b();
                    return;
                }
            case 1:
                if (!this.f100064s) {
                    k.a.f100197a.a(1, "AuthingFragment", ">>>start auth and get live info");
                    YtSDKKitFramework.YtSDKPlatformContext platformContext = YtSDKKitFramework.getInstance().getPlatformContext();
                    CameraHolder cameraHolder = this.f100060o;
                    if (cameraHolder != null) {
                        platformContext.currentCamera = cameraHolder.getCurrentCamera();
                        platformContext.currentCameraId = this.f100060o.getCameraId();
                        platformContext.currentRotateState = this.f100060o.getCurrentRotate();
                        platformContext.currentAppContext = HuiYanBaseApi.b.f100031a.a();
                    }
                    platformContext.reflectListener = new f(this);
                    platformContext.baseFunctionListener = new g(this);
                    com.tencent.could.huiyansdk.manager.c cVar = c.b.f100154a;
                    cVar.getClass();
                    cVar.f100144m = HuiYanAuthTipsEvent.NONE;
                    cVar.f100149r = false;
                    HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
                    huiYanBaseApi.getClass();
                    com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
                    HuiYanBaseCallBack huiYanBaseCallBack = huiYanBaseApi.f100028b;
                    if (huiYanBaseCallBack != null) {
                        huiYanBaseCallBack.onOperateTimeEvent("GetConfigUseTime", 1, false, "");
                    }
                    int a16 = bVar.a(platformContext, bVar.b(), new com.tencent.could.huiyansdk.helper.a(bVar));
                    if (a16 != 0) {
                        CommonUtils.sendErrorAndExitAuth(211, "YtSDKKitFramework init error ! code: " + a16);
                    } else if (huiYanBaseApi.b() != HuiYanLiveMode.ACTION_REFLECT_MODE) {
                        HuiYanSdkImp.getInstance().realStartCheck();
                    }
                    this.f100064s = true;
                    return;
                }
                k.a.f100197a.a(1, "AuthingFragment", "has started auth and got live info");
                return;
            case 2:
                l();
                return;
            case 3:
                m();
                return;
            case 4:
                f.a.f100180a.a(this.f100060o, 2);
                return;
            case 5:
                n();
                return;
            case 6:
                a(obj);
                return;
            case 7:
                b(obj);
                return;
            case 8:
                k.a.f100197a.a(1, "AuthingFragment", ">>>first found the face.");
                this.f100058m = true;
                b(HuiYanSdkImp.getInstance().getSdkConfig().getAuthTimeOutMs(), HuiYanSdkImp.getInstance().getSdkConfig().isShowActionTimeout());
                return;
            case 9:
                k.a.f100197a.a(1, "AuthingFragment", ">>>enter other action.");
                b(HuiYanSdkImp.getInstance().getSdkConfig().getAuthTimeOutMs(), HuiYanSdkImp.getInstance().getSdkConfig().isShowActionTimeout());
                return;
            default:
                k.a.f100197a.a(1, "AuthingFragment", "error state");
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CompareResult compareResult) {
        a(true);
        CommonUtils.sendErrorAndExitAuth(compareResult.getErrorCode(), compareResult.getErrorMsg());
        k.a.f100197a.a(2, "AuthingFragment", "local auth fail! code: " + compareResult.getErrorCode() + " msg: " + compareResult.getErrorMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ColorMatrixColorFilter colorMatrixColorFilter) {
        HuiYanReflectLayout huiYanReflectLayout = this.f100053h;
        if (huiYanReflectLayout != null && huiYanReflectLayout.f100339a != null) {
            huiYanReflectLayout.f100340b = colorMatrixColorFilter;
            huiYanReflectLayout.invalidate();
        }
        if (this.f100055j) {
            return;
        }
        this.f100055j = true;
        this.f100059n.a("");
        q();
        HuiYanSdkImp.getInstance().onAuthEvent(HuiYanAuthEvent.REFLECT_CHECK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        try {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (i3 == -1) {
                attributes.screenBrightness = -1.0f;
            } else {
                if (i3 <= 0) {
                    i3 = 1;
                }
                attributes.screenBrightness = i3 / 255.0f;
            }
            window.setAttributes(attributes);
        } catch (Exception e16) {
            k.a.f100197a.a(2, "AuthingFragment", "set current screen brightness error: " + e16.getLocalizedMessage());
        }
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        LoadingFrontAnimatorView loadingFrontAnimatorView = this.f100054i;
        if (loadingFrontAnimatorView != null) {
            loadingFrontAnimatorView.f100353l = false;
            if (z16) {
                loadingFrontAnimatorView.setVisibility(8);
            }
            ValueAnimator valueAnimator = loadingFrontAnimatorView.f100343b;
            if (valueAnimator == null) {
                return;
            }
            if (valueAnimator.isRunning() || loadingFrontAnimatorView.f100343b.isStarted()) {
                loadingFrontAnimatorView.f100343b.cancel();
                loadingFrontAnimatorView.invalidate();
            }
        }
    }
}
