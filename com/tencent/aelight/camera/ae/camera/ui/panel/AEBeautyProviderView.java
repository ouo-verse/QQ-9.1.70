package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ez;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.slf4j.Marker;

/* loaded from: classes32.dex */
public class AEBeautyProviderView extends FrameLayout {
    protected TextView C;
    protected TextView D;
    private AECaptureController E;
    private View F;
    private AEProviderContainerView G;
    private View H;
    private View I;
    private SeekBar J;
    private SeekBar K;
    private SeekBar.OnSeekBarChangeListener L;
    private SeekBar.OnSeekBarChangeListener M;

    /* renamed from: d, reason: collision with root package name */
    private Animation f62850d;

    /* renamed from: e, reason: collision with root package name */
    private int f62851e;

    /* renamed from: f, reason: collision with root package name */
    private final int f62852f;

    /* renamed from: h, reason: collision with root package name */
    private float f62853h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f62854i;

    /* renamed from: m, reason: collision with root package name */
    protected View f62855m;

    /* loaded from: classes32.dex */
    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (AEBeautyProviderView.this.E != null) {
                AEBeautyProviderView.this.E.t(i3);
                AEBeautyProviderView.this.C.setText(Marker.ANY_NON_NULL_MARKER + String.format("%.1f", Float.valueOf(i3 / 10.0f)));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            AEBeautyProviderView aEBeautyProviderView = AEBeautyProviderView.this;
            aEBeautyProviderView.t(aEBeautyProviderView.H, AEBeautyProviderView.this.I);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (AEBeautyProviderView.this.F != null && (AEBeautyProviderView.this.F instanceof ViewGroup)) {
                ((ViewGroup) AEBeautyProviderView.this.F).setMotionEventSplittingEnabled(true);
            }
            AEBeautyProviderView.this.r(seekBar.getProgress());
            AEBaseReportParam.U().C0(seekBar.getProgress());
            AEBeautyProviderView aEBeautyProviderView = AEBeautyProviderView.this;
            aEBeautyProviderView.u(aEBeautyProviderView.H, AEBeautyProviderView.this.I);
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* loaded from: classes32.dex */
    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (AEBeautyProviderView.this.E != null) {
                AEBeautyProviderView.this.E.w(i3);
                AEBeautyProviderView.this.D.setText(Marker.ANY_NON_NULL_MARKER + String.format("%.1f", Float.valueOf(i3 / 10.0f)));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            AEBeautyProviderView aEBeautyProviderView = AEBeautyProviderView.this;
            aEBeautyProviderView.t(aEBeautyProviderView.I, AEBeautyProviderView.this.H);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (AEBeautyProviderView.this.F != null && (AEBeautyProviderView.this.F instanceof ViewGroup)) {
                ((ViewGroup) AEBeautyProviderView.this.F).setMotionEventSplittingEnabled(true);
            }
            AEBeautyProviderView.this.s(seekBar.getProgress());
            AEBaseReportParam.U().l1(seekBar.getProgress());
            AEBeautyProviderView aEBeautyProviderView = AEBeautyProviderView.this;
            aEBeautyProviderView.u(aEBeautyProviderView.I, AEBeautyProviderView.this.H);
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements ez.f<Float> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AEProviderContainerView f62858a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f62859b;

        c(AEProviderContainerView aEProviderContainerView, View view) {
            this.f62858a = aEProviderContainerView;
            this.f62859b = view;
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Float> ezVar, float f16, Float f17, Transformation transformation) {
            float floatValue = f17.floatValue();
            AEProviderContainerView aEProviderContainerView = this.f62858a;
            if (aEProviderContainerView != null) {
                aEProviderContainerView.setBackGroundAlpha(floatValue);
            }
            View view = this.f62859b;
            if (view != null) {
                view.setAlpha(floatValue);
            }
            AEBeautyProviderView.this.f62853h = floatValue;
        }
    }

    public AEBeautyProviderView(Context context) {
        super(context);
        this.f62851e = 500;
        this.f62852f = 300;
        this.f62853h = 1.0f;
        this.f62854i = false;
        this.L = new a();
        this.M = new b();
    }

    private Animation j(AEProviderContainerView aEProviderContainerView, View view, float f16, float f17) {
        return new ez(Float.valueOf(f16), Float.valueOf(f17), new c(aEProviderContainerView, view));
    }

    private int k() {
        int m3 = m();
        this.J.setProgress(m3);
        this.C.setText(Marker.ANY_NON_NULL_MARKER + (m3 / 10.0f));
        return m3;
    }

    private int l() {
        int n3 = n();
        this.K.setProgress(n3);
        this.D.setText(Marker.ANY_NON_NULL_MARKER + String.format("%.1f", Float.valueOf(n3 / 10.0f)));
        return n3;
    }

    public static int m() {
        String str = "ae_beauty_level_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_CAMERA_ID_" + AECameraConstants.sCurrentCamera;
        int g16 = AECameraPrefsUtil.f().g(str, AECameraConstants.sCurrentCamera == 2 ? 0 : 55, 0);
        if (ms.a.g()) {
            ms.a.a("AEBeautyProviderView", "getBeautyFeature BeautyLevel=" + g16 + ", key:" + str);
        }
        return g16;
    }

    public static int n() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        int i3 = AECameraConstants.sCurrentCamera == 2 ? 0 : 40;
        String str = "ae_sharp_face_level_" + account + "_CAMERA_ID_" + AECameraConstants.sCurrentCamera;
        int g16 = AECameraPrefsUtil.f().g(str, i3, 0);
        if (ms.a.g()) {
            ms.a.a("AEBeautyProviderView", "getSharpFaceFeature SharpFaceLevel = " + g16 + ", key:" + str);
        }
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3) {
        String str = "ae_beauty_level_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_CAMERA_ID_" + AECameraConstants.sCurrentCamera;
        AECameraPrefsUtil.f().n(str, i3, 0);
        if (ms.a.g()) {
            ms.a.a("AEBeautyProviderView", "saveBeautyFeature BeautyLevel=" + i3 + ", key: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3) {
        String str = "ae_sharp_face_level_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_CAMERA_ID_" + AECameraConstants.sCurrentCamera;
        AECameraPrefsUtil.f().n(str, i3, 0);
        if (ms.a.g()) {
            ms.a.a("AEBeautyProviderView", "saveSharpFaceFeature SharpFaceLevel = " + i3 + ", key:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view, View view2) {
        View view3 = this.F;
        int i3 = 0;
        if (view3 != null && (view3 instanceof ViewGroup)) {
            ((ViewGroup) view3).setMotionEventSplittingEnabled(false);
        }
        Animation animation = this.f62850d;
        if (animation == null || animation.hasEnded()) {
            i3 = 300;
        } else {
            this.f62850d.cancel();
        }
        view.setAlpha(1.0f);
        if (this.G.r() || this.G.q()) {
            return;
        }
        Animation j3 = j(this.G, view2, this.f62853h, 0.0f);
        this.f62850d = j3;
        j3.setDuration(this.f62853h * this.f62851e);
        this.f62850d.setStartOffset(i3);
        startAnimation(this.f62850d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view, View view2) {
        Animation animation = this.f62850d;
        if (animation != null && !animation.hasEnded()) {
            this.f62850d.cancel();
        }
        view.setAlpha(1.0f);
        if (this.G.r() || this.G.q()) {
            return;
        }
        Animation j3 = j(this.G, view2, this.f62853h, 1.0f);
        this.f62850d = j3;
        j3.setDuration((1.0f - this.f62853h) * this.f62851e);
        startAnimation(this.f62850d);
    }

    public void o(Bundle bundle) {
        if (this.f62855m == null) {
            this.f62855m = LayoutInflater.from(getContext()).inflate(R.layout.dky, (ViewGroup) this, true);
            this.f62854i = true;
        }
        this.F = ((Activity) getContext()).findViewById(R.id.ru6);
        this.G = (AEProviderContainerView) ((Activity) getContext()).findViewById(R.id.rom);
        this.H = this.f62855m.findViewById(R.id.ron);
        if (!gm2.b.c()) {
            this.H.setVisibility(8);
        }
        SeekBar seekBar = (SeekBar) this.f62855m.findViewById(R.id.rop);
        this.J = seekBar;
        seekBar.setOnSeekBarChangeListener(this.L);
        this.J.setSplitTrack(false);
        this.C = (TextView) this.f62855m.findViewById(R.id.roo);
        k();
        this.I = this.f62855m.findViewById(R.id.s0r);
        SeekBar seekBar2 = (SeekBar) this.f62855m.findViewById(R.id.s0t);
        this.K = seekBar2;
        seekBar2.setOnSeekBarChangeListener(this.M);
        this.K.setSplitTrack(false);
        this.D = (TextView) this.f62855m.findViewById(R.id.s0s);
        l();
    }

    public void p() {
        v();
    }

    public void q() {
        if (this.f62855m == null) {
            return;
        }
        int k3 = k();
        AECaptureController aECaptureController = this.E;
        if (aECaptureController != null) {
            aECaptureController.t(k3);
        }
    }

    public void setController(AECaptureController aECaptureController) {
        this.E = aECaptureController;
    }

    public void v() {
        if (this.f62855m != null) {
            int l3 = l();
            AECaptureController aECaptureController = this.E;
            if (aECaptureController != null) {
                aECaptureController.w(l3);
            }
            int k3 = k();
            AECaptureController aECaptureController2 = this.E;
            if (aECaptureController2 != null) {
                aECaptureController2.t(k3);
            }
        }
    }

    public AEBeautyProviderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62851e = 500;
        this.f62852f = 300;
        this.f62853h = 1.0f;
        this.f62854i = false;
        this.L = new a();
        this.M = new b();
    }
}
