package com.tencent.mobileqq.ocr.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.HashMap;
import mqq.app.QQPermissionGrant;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ScanOcrActivity extends ScanBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private volatile boolean A0;
    private String B0;
    private ScanSuccessView C0;
    private long D0;
    private boolean E0;
    private e F0;
    public boolean G0;
    public String H0;
    public String I0;
    public MaskView J0;
    public int K0;
    private QQPermission L0;
    private boolean M0;
    private boolean N0;
    private View.OnTouchListener O0;
    private View.OnClickListener P0;
    OcrCamera.e Q0;
    SurfaceHolder.Callback R0;
    OcrControl.a S0;

    /* renamed from: h0, reason: collision with root package name */
    private ViewGroup f254633h0;

    /* renamed from: i0, reason: collision with root package name */
    private SurfaceView f254634i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f254635j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f254636k0;

    /* renamed from: l0, reason: collision with root package name */
    private ScanOcrView f254637l0;

    /* renamed from: m0, reason: collision with root package name */
    private View f254638m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f254639n0;

    /* renamed from: o0, reason: collision with root package name */
    private ImageView f254640o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f254641p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f254642q0;

    /* renamed from: r0, reason: collision with root package name */
    private ImageView f254643r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f254644s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f254645t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f254646u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f254647v0;

    /* renamed from: w0, reason: collision with root package name */
    private SurfaceHolder f254648w0;

    /* renamed from: x0, reason: collision with root package name */
    private OcrControl f254649x0;

    /* renamed from: y0, reason: collision with root package name */
    private OcrCamera f254650y0;

    /* renamed from: z0, reason: collision with root package name */
    private volatile boolean f254651z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ocr.activity.ScanOcrActivity$6, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass6 implements OcrCamera.e {
        static IPatchRedirector $redirector_;

        AnonymousClass6() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void a(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            } else {
                ScanOcrActivity.this.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f254654d;

                    {
                        this.f254654d = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f254654d != 0) {
                            ScanOcrActivity.this.f254635j0.setVisibility(0);
                            ScanOcrActivity.this.f254635j0.setText(R.string.f170223je);
                            ScanOcrActivity scanOcrActivity = ScanOcrActivity.this;
                            if (scanOcrActivity.K0 == 1) {
                                scanOcrActivity.J0.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        ScanOcrActivity scanOcrActivity2 = ScanOcrActivity.this;
                        if (scanOcrActivity2.K0 != 1) {
                            if (!scanOcrActivity2.f254637l0.g()) {
                                ScanOcrActivity.this.f254637l0.setVisibility(0);
                                ScanOcrActivity.this.f254637l0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            ScanOcrActivity.this.f254637l0.j(0);
                                        }
                                    }
                                }, 500L);
                            }
                        } else {
                            scanOcrActivity2.J0.setVisibility(0);
                        }
                        ScanOcrActivity.this.f254635j0.setVisibility(0);
                        ScanOcrActivity.this.f254635j0.setText(ScanOcrActivity.this.f254646u0);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                ScanOcrActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            ScanOcrActivity.this.p3(null, true, false);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                ScanOcrActivity.this.runOnUiThread(new Runnable(str) { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f254660d;

                    {
                        this.f254660d = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (TextUtils.isEmpty(this.f254660d) || !new File(this.f254660d).exists()) {
                            ScanOcrActivity.this.s3(false);
                            QLog.d("Q.ocr.ScanOcrActivity", 1, "onTakePicFinish failed!");
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis() - ScanOcrActivity.this.D0;
                        ScanOcrActivity scanOcrActivity = ScanOcrActivity.this;
                        if (scanOcrActivity.K0 == 1) {
                            URLDrawable drawable = URLDrawable.getDrawable(new File(this.f254660d), URLDrawable.URLDrawableOptions.obtain());
                            drawable.downloadImediatly();
                            ScanOcrActivity.this.J0.setPreviewDrawable(drawable);
                            ScanOcrActivity.this.w3(this.f254660d, true);
                            return;
                        }
                        if (currentTimeMillis > 900) {
                            scanOcrActivity.w3(this.f254660d, false);
                        } else {
                            scanOcrActivity.f254633h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.4.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        ScanOcrActivity.this.w3(anonymousClass4.f254660d, false);
                                    }
                                }
                            }, 900 - currentTimeMillis);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                ScanOcrActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ScanOcrActivity.this.f254635j0.setVisibility(0);
                        ScanOcrActivity.this.f254635j0.setText(ScanOcrActivity.this.f254646u0);
                        ScanOcrActivity scanOcrActivity = ScanOcrActivity.this;
                        if (scanOcrActivity.K0 != 1) {
                            if (!scanOcrActivity.f254637l0.g()) {
                                ScanOcrActivity.this.f254637l0.setVisibility(0);
                                ScanOcrActivity.this.f254637l0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.2.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            ScanOcrActivity.this.f254637l0.j(0);
                                        }
                                    }
                                }, 500L);
                                return;
                            }
                            return;
                        }
                        scanOcrActivity.J0.setVisibility(0);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ocr.OcrCamera.e
        public void onStop(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                ScanOcrActivity.this.grant();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            if (view == ScanOcrActivity.this.f254643r0) {
                view.setAlpha(0.7f);
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ScanOcrActivity.this.f254645t0 == 1 && (ScanOcrActivity.this.f254644s0 == 0 || ScanOcrActivity.this.f254644s0 == 4)) {
                ScanOcrActivity.this.f254649x0.m();
                ScanOcrActivity.this.s3(false);
                ScanOcrActivity.this.t3();
            } else {
                ScanOcrActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements SurfaceHolder.Callback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ScanOcrActivity.this.f254648w0 = surfaceHolder;
                if (ScanOcrActivity.this.f254650y0 == null) {
                    ScanOcrActivity scanOcrActivity = ScanOcrActivity.this;
                    scanOcrActivity.f254650y0 = new OcrCamera(scanOcrActivity, scanOcrActivity.Q0, scanOcrActivity.f254648w0);
                    ScanOcrActivity.this.f254650y0.v(ScanOcrActivity.this.K0);
                    ScanOcrActivity.this.f254650y0.u(ScanOcrActivity.this.J0.b());
                    if (ScanOcrActivity.this.N0) {
                        ScanOcrActivity.this.f254650y0.q();
                        return;
                    }
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f254674a;

        /* renamed from: b, reason: collision with root package name */
        public OcrRecogResult f254675b;

        /* renamed from: c, reason: collision with root package name */
        public String f254676c;

        /* renamed from: d, reason: collision with root package name */
        public long f254677d;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ScanOcrActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E0 = false;
        this.G0 = false;
        this.K0 = 0;
        this.M0 = false;
        this.N0 = false;
        this.O0 = new b();
        this.P0 = new c();
        this.Q0 = new AnonymousClass6();
        this.R0 = new d();
        this.S0 = new OcrControl.a() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.ocr.OcrControl.a
            public void a(int i3, OcrRecogResult ocrRecogResult, String str, long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), ocrRecogResult, str, Long.valueOf(j3));
                } else {
                    ScanOcrActivity.this.runOnUiThread(new Runnable(str, i3, ocrRecogResult, j3) { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f254664d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f254665e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ OcrRecogResult f254666f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ long f254667h;

                        {
                            this.f254664d = str;
                            this.f254665e = i3;
                            this.f254666f = ocrRecogResult;
                            this.f254667h = j3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass8.this, str, Integer.valueOf(i3), ocrRecogResult, Long.valueOf(j3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (ScanOcrActivity.this.f254651z0 && !TextUtils.isEmpty(ScanOcrActivity.this.B0) && ScanOcrActivity.this.B0.equals(this.f254664d)) {
                                if (!ScanOcrActivity.this.E0) {
                                    ScanOcrActivity.this.n3(this.f254665e, this.f254666f, this.f254664d, this.f254667h);
                                    return;
                                }
                                ScanOcrActivity.this.F0 = new e();
                                ScanOcrActivity.this.F0.f254674a = this.f254665e;
                                ScanOcrActivity.this.F0.f254675b = this.f254666f;
                                ScanOcrActivity.this.F0.f254676c = this.f254664d;
                                ScanOcrActivity.this.F0.f254677d = this.f254667h;
                                return;
                            }
                            QLog.d("Q.ocr.ScanOcrActivity", 1, "OcrCallback onResult is not In recog, mRecogPicPath:" + ScanOcrActivity.this.B0 + " ,imagePath:" + this.f254664d);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.ocr.OcrControl.a
            public void b() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(int i3, OcrRecogResult ocrRecogResult, String str, long j3) {
        this.F0 = null;
        this.B0 = null;
        this.f254651z0 = false;
        if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.ScanOcrActivity", 2, "dealOcrResult ocrResult: " + ocrRecogResult);
        }
        if (i3 == 0 && ocrRecogResult != null && !ocrRecogResult.isEmpty() && (this.K0 != 1 || (!TextUtils.isEmpty(ocrRecogResult.ocrContent) && !TextUtils.isEmpty(ocrRecogResult.ocrContent.trim())))) {
            r3(ocrRecogResult, str);
            ReportController.o(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
            if (this.K0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
            }
        } else {
            if (this.K0 == 1) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.foa, 0).show();
            } else if (i3 == 1) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.fo8, 0).show();
            } else if (i3 == 0) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.fo_, 0).show();
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.fo6, 0).show();
            }
            int i16 = this.f254644s0;
            if (i16 != 0 && i16 != 4) {
                finish();
            } else {
                s3(false);
            }
            ReportController.o(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
            if (this.K0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
            }
        }
        t3();
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f254669d;

            {
                this.f254669d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(this.f254669d));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ocr_recog", true, 0L, 0L, hashMap, "", false);
            }
        }, 5, null, false);
        if (j3 > 0) {
            int i17 = this.f254644s0;
            if (i17 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(j3), "", "", "");
            } else if (i17 == 0) {
                ReportController.o(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(j3), "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(String str, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str) && !z16) {
            QLog.d("Q.ocr.ScanOcrActivity", 1, "enterPreviewModel picPath:" + str + ",isFromCamera:" + z16 + ",model:" + this.f254645t0);
            return;
        }
        this.f254645t0 = 1;
        this.f254639n0.setVisibility(4);
        this.f254638m0.setVisibility(4);
        this.f254635j0.setVisibility(4);
        if (this.K0 != 1) {
            this.f254637l0.m();
        }
        if (z16) {
            OcrCamera ocrCamera = this.f254650y0;
            if (ocrCamera != null) {
                ocrCamera.z();
            }
            this.D0 = System.currentTimeMillis();
            if (this.K0 != 1) {
                this.f254637l0.n();
                this.f254637l0.o();
                this.f254637l0.l();
                this.f254636k0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        ScanOcrActivity.this.f254637l0.o();
                        ScanOcrActivity.this.f254636k0.setImageDrawable(new ColorDrawable(-16777216));
                        ScanOcrActivity.this.f254636k0.setVisibility(0);
                        ScanOcrActivity.this.f254636k0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.3.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                ScanOcrActivity.this.f254637l0.setVisibility(4);
                                ScanOcrActivity.this.f254636k0.setVisibility(4);
                                ScanOcrActivity.this.f254636k0.setAlpha(255);
                            }
                        }, 200L);
                    }
                }, 600L);
            } else {
                this.J0.setModel(true);
            }
        } else {
            if (this.K0 != 1) {
                this.f254637l0.setVisibility(4);
            } else {
                this.J0.setVisibility(4);
            }
            if (this.M0) {
                this.f254636k0.setVisibility(4);
            } else {
                URLDrawable drawable = URLDrawable.getDrawable(new File(str), URLDrawable.URLDrawableOptions.obtain());
                drawable.downloadImediatly();
                this.f254636k0.setVisibility(0);
                this.f254636k0.setImageDrawable(drawable);
            }
            w3(str, z17);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.ScanOcrActivity", 2, "enterPreviewModel isFromCamera:" + z16 + ",isCrop:" + z17 + ",picPath:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(boolean z16) {
        this.f254651z0 = false;
        this.f254645t0 = 0;
        this.f254639n0.setVisibility(0);
        this.f254638m0.setVisibility(0);
        this.f254636k0.setVisibility(4);
        if (this.K0 != 1) {
            this.f254637l0.m();
        } else {
            this.J0.setVisibility(0);
            this.J0.setModel(false);
        }
        t3();
        if (!z16) {
            if (this.f254634i0 == null) {
                u3();
            } else {
                OcrCamera ocrCamera = this.f254650y0;
                if (ocrCamera != null && this.N0) {
                    ocrCamera.q();
                    this.f254649x0.i();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.ScanOcrActivity", 2, "enterScanModel");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        ScanSuccessView scanSuccessView = this.C0;
        if (scanSuccessView != null) {
            this.f254633h0.removeView(scanSuccessView);
            this.C0 = null;
        }
        ImageView imageView = this.f254640o0;
        if (imageView != null) {
            this.f254633h0.removeView(imageView);
            this.f254640o0 = null;
        }
    }

    private void u3() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.ScanOcrActivity", 2, "initCameraView");
        }
        SurfaceView surfaceView = new SurfaceView(this);
        this.f254634i0 = surfaceView;
        surfaceView.getHolder().addCallback(this.R0);
        this.f254633h0.addView(this.f254634i0, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w3(String str, boolean z16) {
        if (this.f254651z0) {
            QLog.d("Q.ocr.ScanOcrActivity", 1, "recogPic is inRecog picPath:" + str + ",isCrop:" + z16);
            return;
        }
        boolean z17 = false;
        if (NetworkUtil.isNetSupport(this)) {
            this.f254633h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanOcrActivity.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanOcrActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ScanOcrActivity.this.x3();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 200L);
            this.f254651z0 = true;
            this.B0 = str;
            this.A0 = z16;
            OcrControl ocrControl = this.f254649x0;
            if (!z16) {
                z17 = true;
            }
            ocrControl.f(str, z17);
            if (this.f254644s0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
            }
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.fod, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3() {
        if (!this.f254651z0) {
            return;
        }
        if (this.C0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ScanSuccessView scanSuccessView = new ScanSuccessView(this);
            this.C0 = scanSuccessView;
            scanSuccessView.setShowProgress(false);
            if (this.K0 != 1) {
                this.C0.setScanText(HardCodeUtil.qqStr(R.string.t3o));
            } else {
                this.C0.setScanText(HardCodeUtil.qqStr(R.string.t3q));
            }
            this.C0.setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            this.C0.setScale(ScreenUtil.SCREEN_WIDTH);
            this.f254633h0.addView(this.C0, layoutParams);
        }
        if (this.f254640o0 == null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(40.0f, getResources()), BaseAIOUtils.f(40.0f, getResources()));
            layoutParams2.addRule(14);
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = BaseAIOUtils.f(40.0f, getResources());
            ImageView imageView = new ImageView(this);
            this.f254640o0 = imageView;
            imageView.setImageResource(R.drawable.afb);
            this.f254640o0.setOnClickListener(this.P0);
            this.f254640o0.setContentDescription(getString(R.string.cancel));
            this.f254633h0.addView(this.f254640o0, layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 0) {
            if (intent != null) {
                str = intent.getStringExtra("ocr_pic_path");
            } else {
                str = null;
            }
            this.f254649x0.i();
            if (!TextUtils.isEmpty(str)) {
                p3(str, false, true);
                return;
            }
            int i17 = this.f254644s0;
            if (i17 != 0 && i17 != 4) {
                finish();
            } else {
                s3(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f254645t0 == 1 && ((i3 = this.f254644s0) == 0 || i3 == 4)) {
            this.f254649x0.m();
            s3(false);
            t3();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("no_preview_model", false);
        this.M0 = booleanExtra;
        if (!booleanExtra) {
            setTheme(R.style.f173431d5);
        }
        getWindow().addFlags(128);
        setContentView(R.layout.ayo);
        initTitleView();
        this.f254633h0 = (ViewGroup) findViewById(R.id.root);
        this.f254635j0 = (TextView) findViewById(R.id.jnf);
        this.f254636k0 = (ImageView) findViewById(R.id.fyj);
        this.f254637l0 = (ScanOcrView) findViewById(R.id.igy);
        this.f254638m0 = findViewById(R.id.b_q);
        this.f254639n0 = findViewById(R.id.jo6);
        this.f254641p0 = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f254642q0 = (TextView) findViewById(R.id.drv);
        this.f254643r0 = (ImageView) findViewById(R.id.jbg);
        this.f254642q0.setOnClickListener(this);
        this.f254641p0.setOnClickListener(this);
        this.f254642q0.setOnTouchListener(this.O0);
        this.f254643r0.setOnClickListener(this);
        this.f254643r0.setOnTouchListener(this.O0);
        this.J0 = (MaskView) findViewById(R.id.enp);
        OcrConfig ocrConfig = this.f254629d0;
        if (ocrConfig != null && !TextUtils.isEmpty(ocrConfig.tips)) {
            this.f254646u0 = this.f254629d0.tips;
        } else {
            this.f254646u0 = getResources().getString(R.string.fof);
        }
        String stringExtra = getIntent().getStringExtra("ocr_pic_path");
        this.f254644s0 = getIntent().getIntExtra("ocr_from_where", -1);
        OcrControl ocrControl = new OcrControl(this.f254630e0, this.S0, this.f254644s0);
        this.f254649x0 = ocrControl;
        ocrControl.i();
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.ScanOcrActivity", 2, "onCreate imagePath:" + stringExtra + ",from:" + this.f254644s0);
        }
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.t3r), 0).show();
            finish();
            return true;
        }
        if (this.f254644s0 == 4) {
            this.G0 = getIntent().getBooleanExtra("scanForResult", false);
            this.H0 = getIntent().getStringExtra("src");
            this.I0 = getIntent().getStringExtra("type");
            if (this.G0) {
                this.J0.setIsDisplayRect(true);
                this.K0 = 1;
                this.f254635j0 = (TextView) findViewById(R.id.jng);
                this.f254646u0 = getResources().getString(R.string.fog);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f254635j0.getLayoutParams();
                layoutParams.topMargin = this.J0.a().bottom;
                this.f254635j0.setLayoutParams(layoutParams);
                this.f254628c0.setText(R.string.f173083h61);
            }
            if (TextUtils.isEmpty(this.H0)) {
                str = "";
            } else {
                str = this.H0;
            }
            ReportController.o(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", str, "");
        }
        int i3 = this.f254644s0;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (this.L0 == null) {
                this.L0 = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SCAN_OCR, QQPermissionConstants.Business.SCENE.OCR_SCAN_CAMERA));
            }
            QQPermission qQPermission = this.L0;
            if (qQPermission != null) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
            } else {
                QLog.e("Q.ocr.ScanOcrActivity", 1, "mQQPermission is null!");
            }
        } else if (!TextUtils.isEmpty(stringExtra) && new File(stringExtra).exists()) {
            p3(stringExtra, false, false);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.fo9, 0).show();
            finish();
        }
        if (this.M0) {
            this.f254633h0.setBackgroundColor(0);
            this.f254636k0.setVisibility(4);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        OcrControl ocrControl = this.f254649x0;
        if (ocrControl != null) {
            ocrControl.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.ScanOcrActivity", 2, String.format("doOnNewIntent filePath=%s", stringExtra));
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f254647v0 = stringExtra;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnPause();
        OcrCamera ocrCamera = this.f254650y0;
        if (ocrCamera != null) {
            ocrCamera.z();
            this.f254650y0.m();
        }
        this.E0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnResume();
        if (!TextUtils.isEmpty(this.f254647v0)) {
            p3(this.f254647v0, false, false);
            this.f254647v0 = null;
            if (this.K0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
            }
        }
        this.f254649x0.i();
        if (this.f254645t0 == 0) {
            if (this.f254634i0 == null) {
                u3();
            } else {
                OcrCamera ocrCamera = this.f254650y0;
                if (ocrCamera != null && this.N0) {
                    ocrCamera.q();
                }
            }
        } else if (!TextUtils.isEmpty(this.B0) && this.f254651z0 && this.E0) {
            if (this.M0) {
                this.f254636k0.setVisibility(4);
            } else {
                URLDrawable drawable = URLDrawable.getDrawable(new File(this.B0), URLDrawable.URLDrawableOptions.obtain());
                drawable.downloadImediatly();
                this.f254636k0.setImageDrawable(drawable);
                this.f254636k0.setVisibility(0);
            }
            e eVar = this.F0;
            if (eVar != null && this.B0.equals(eVar.f254676c)) {
                e eVar2 = this.F0;
                n3(eVar2.f254674a, eVar2.f254675b, eVar2.f254676c, eVar2.f254677d);
            }
        }
        this.E0 = false;
    }

    @QQPermissionGrant(1)
    public void grant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.N0 = true;
            s3(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                doOnBackPressed();
            } else if (id5 == R.id.drv) {
                Intent intent = new Intent();
                intent.setClass(this, NewPhotoListActivity.class);
                intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 49);
                intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
                intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
                intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                intent.putExtra(PeakConstants.MULTI_PREVIEW_IN_SINGLE_MODE, true);
                startActivity(intent);
                QAlbumUtil.anim(this, false, true);
            } else if (id5 == R.id.jbg) {
                v3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.ocr.activity.ScanBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        QLog.i("Q.ocr.ScanOcrActivity", 2, "onMultiWindowModeChanged" + z16);
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.t3p), 0).show();
            finish();
        }
    }

    public void r3(OcrRecogResult ocrRecogResult, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) ocrRecogResult, (Object) str);
            return;
        }
        if (this.K0 == 1) {
            getIntent().putExtra("ocr_result", ocrRecogResult.ocrContent);
            getIntent().putExtra("ret_code", 0);
            setResult(-1, getIntent());
            finish();
            overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    public void v3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        OcrCamera ocrCamera = this.f254650y0;
        if (ocrCamera != null && this.f254645t0 == 0) {
            if (ocrCamera.C() && this.K0 != 1) {
                this.f254637l0.m();
            }
            if (this.K0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
            }
        }
    }
}
