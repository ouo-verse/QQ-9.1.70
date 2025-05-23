package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue;
import com.tencent.luggage.scanner.scanner.ui.ScanUIRectView;
import com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.k0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BaseScanPage extends r {
    public static final Class<?> ACTIVITY_CLASS = BaseScanUI.class;
    public boolean C;
    public boolean D;
    public int[] E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ScanUIRectView.l O;
    public final IListener P;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f120077b;

    /* renamed from: c, reason: collision with root package name */
    public ScanUIRectView f120078c;

    /* renamed from: d, reason: collision with root package name */
    public ScannerFlashSwitcher f120079d;

    /* renamed from: e, reason: collision with root package name */
    public View f120080e;

    /* renamed from: f, reason: collision with root package name */
    public View f120081f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f120082g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f120083h;

    /* renamed from: i, reason: collision with root package name */
    public Vibrator f120084i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f120085j;

    /* renamed from: k, reason: collision with root package name */
    public long f120086k;

    /* renamed from: l, reason: collision with root package name */
    public int f120087l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f120088m;

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f120102a;

        public b(Animator.AnimatorListener animatorListener) {
            this.f120102a = animatorListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseScanPage baseScanPage = BaseScanPage.this;
            baseScanPage.a((View) baseScanPage.f120082g, true);
            Animator.AnimatorListener animatorListener = this.f120102a;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f120104a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f120105b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f120106c;

        public c(Animator.AnimatorListener animatorListener, View view, boolean z16) {
            this.f120104a = animatorListener;
            this.f120105b = view;
            this.f120106c = z16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f120104a;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            View view = this.f120105b;
            if (this.f120106c) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            Animator.AnimatorListener animatorListener = this.f120104a;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f120104a;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f120104a;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Context context = BaseScanPage.this.getContext();
            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
            BaseScanPage.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BaseScanPage.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseScanPage.this.c(false);
            BaseScanPage.this.v();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.a(BaseScanPage.this.getContext(), R.string.f216695z0);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseScanPage.this.w();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements LuggageFileDecodeQueue.FileDecodeCallBack {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f120113a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f120115a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f120116b;

            public a(List list, List list2) {
                this.f120115a = list;
                this.f120116b = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3 = 0;
                BaseScanPage.this.K = false;
                List list = this.f120115a;
                if (list == null || list.isEmpty()) {
                    BaseScanPage.this.K = true;
                    BaseScanPage.this.c(true);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("result_content", ((QBar.QBarResult) this.f120115a.get(0)).data);
                bundle.putInt("result_code_format", ((QBar.QBarResult) this.f120115a.get(0)).typeID);
                bundle.putString("result_code_name", ((QBar.QBarResult) this.f120115a.get(0)).typeName);
                byte[] bArr = ((QBar.QBarResult) this.f120115a.get(0)).rawData;
                if (bArr != null) {
                    bundle.putByteArray("result_raw_data", bArr);
                }
                List list2 = this.f120116b;
                if (list2 != null && !list2.isEmpty()) {
                    i3 = ((QbarNative.QBarReportMsg) this.f120116b.get(0)).qrcodeVersion;
                }
                bundle.putInt("result_code_version", i3);
                if (BaseScanPage.this.H) {
                    Intent intent = new Intent();
                    intent.putExtra("key_scan_result", bundle.getString("result_content"));
                    intent.putExtra("key_scan_result_raw", bundle.getByteArray("result_raw_data"));
                    intent.putExtra("key_scan_result_code_name", bundle.getString("result_code_name"));
                    intent.putExtra("key_scan_result_code_version", i3);
                    BaseScanPage.this.setResult(-1, intent);
                    BaseScanPage.this.finish();
                    BaseScanPage.this.t();
                    return;
                }
                bundle.putInt("qbar_string_scan_source", 1);
                BaseScanPage.this.t();
            }
        }

        public i(long j3) {
            this.f120113a = j3;
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue.FileDecodeCallBack
        public void afterDecode(long j3, List list, List list2) {
            if (j3 == this.f120113a && BaseScanPage.this.r()) {
                c0.a(new a(list, list2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BaseScanPage.this.f120079d.d()) {
                BaseScanPage.this.a(1);
            } else {
                BaseScanPage.this.a(2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseScanPage.this.k();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BaseScanPage.this.N) {
                BaseScanPage.this.u();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    public class m extends AnimatorListenerAdapter {
        public m() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseScanPage.this.f120086k = System.currentTimeMillis();
            BaseScanPage.this.v();
        }
    }

    /* loaded from: classes2.dex */
    public class n extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f120122a;

        public n(Animator.AnimatorListener animatorListener) {
            this.f120122a = animatorListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseScanPage baseScanPage = BaseScanPage.this;
            baseScanPage.a((View) baseScanPage.f120083h, true);
            Animator.AnimatorListener animatorListener = this.f120122a;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }
    }

    public BaseScanPage(t tVar) {
        super(tVar);
        this.f120085j = true;
        this.f120088m = true;
        this.C = true;
        this.D = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = new a();
        this.P = new IListener<com.tencent.luggage.wxa.c4.a>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.luggage.scanner.scanner.ui.BaseScanPage.15
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.c4.a aVar) {
                if (BaseScanPage.this.C && BaseScanPage.this.D) {
                    if (aVar.f123287d.f123288a) {
                        BaseScanPage.this.b(true);
                    } else {
                        BaseScanPage.this.b(false);
                    }
                }
                return false;
            }
        };
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onDestroy() {
        w.d("Luggage.ScanUI", "onDestroy()");
        super.onDestroy();
        ScanUIRectView scanUIRectView = this.f120078c;
        if (scanUIRectView != null) {
            scanUIRectView.e();
        }
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onPause() {
        super.onPause();
        w.d("Luggage.ScanUI", "onPause needPauseScan: %b", Boolean.valueOf(this.K));
        ScanUIRectView scanUIRectView = this.f120078c;
        if (scanUIRectView != null) {
            scanUIRectView.f();
            if (this.K) {
                this.f120078c.i();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onResume() {
        super.onResume();
        w.d("Luggage.ScanUI", "BaseScanUI onResume needPauseScan: %b", Boolean.valueOf(this.K));
        if (j()) {
            s();
        }
        getWindow().addFlags(128);
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onStop() {
        super.onStop();
        ScanUIRectView scanUIRectView = this.f120078c;
        if (scanUIRectView != null) {
            scanUIRectView.h();
        }
        this.f120079d.a();
        this.P.dead();
        getWindow().clearFlags(128);
    }

    public final boolean r() {
        return com.tencent.luggage.wxa.f4.d.a(this.f120087l);
    }

    public final void s() {
        w.d("Luggage.ScanUI", "onResumeAfterChkPermission needPauseScan: %b", Boolean.valueOf(this.K));
        if (!this.K) {
            this.f120078c.g();
        }
        this.P.alive();
    }

    public final void t() {
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new g());
        this.f120084i.vibrate(10L);
    }

    public final void u() {
        w.d("Luggage.ScanUI", "processMultiCodeCancel isShowingMultiCodeResult: %b", Boolean.valueOf(this.N));
        if (!this.N) {
            return;
        }
        this.N = false;
        a(false, (Animator.AnimatorListener) new m());
    }

    public final void v() {
        w.d("Luggage.ScanUI", "resumeScan");
        this.K = false;
        ScanUIRectView scanUIRectView = this.f120078c;
        if (scanUIRectView != null) {
            scanUIRectView.g();
        }
    }

    public final void w() {
        if (!this.M) {
            return;
        }
        w.d("Luggage.ScanUI", "selectImageFromGallery currentMode: %d", Integer.valueOf(this.f120087l));
        if (r()) {
            this.K = true;
            final Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            com.tencent.luggage.wxa.f6.a.a(getContext(), intent, new LuggageActivityHelper.d() { // from class: com.tencent.luggage.scanner.scanner.ui.b
                @Override // com.tencent.luggage.util.LuggageActivityHelper.d
                public final void a(int i3, Intent intent2) {
                    BaseScanPage.this.a(i3, intent2);
                }
            }, new Consumer() { // from class: com.tencent.luggage.scanner.scanner.ui.c
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    BaseScanPage.this.a(intent, (Exception) obj);
                }
            });
        }
    }

    public final void x() {
        int i3 = this.f120087l;
        if (i3 != 1 && i3 != 4 && i3 != 8) {
            this.f120078c.setScanCallback(null);
        } else {
            this.f120078c.setScanCallback(this.O);
        }
    }

    public final void y() {
        getWindow().getDecorView().setSystemUiVisibility(1280);
        if (com.tencent.luggage.wxa.aa.a.c(19)) {
            getWindow().addFlags(67109888);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        w.e("Luggage.ScanUI", "onBackPressed");
        ScanUIRectView scanUIRectView = this.f120078c;
        if (scanUIRectView != null && scanUIRectView.s()) {
            u();
        } else {
            k();
        }
    }

    public boolean j() {
        if (ContextCompat.checkSelfPermission(getContext(), QQPermissionConstants.Permission.CAMERA) == 0) {
            return true;
        }
        if (!this.f120085j) {
            return false;
        }
        this.f120085j = false;
        return LuggageActivityHelper.FOR(getContext()).checkRequestPermission(null, QQPermissionConstants.Permission.CAMERA, new LuggageActivityHelper.h() { // from class: com.tencent.luggage.scanner.scanner.ui.a
            @Override // com.tencent.luggage.util.LuggageActivityHelper.h
            public final void a(String[] strArr, int[] iArr) {
                BaseScanPage.this.a(strArr, iArr);
            }
        });
    }

    public final void k() {
        setResult(0);
        finish();
        overridePendingTransition(0, 0);
    }

    public final void l() {
        this.f120082g.setVisibility(0);
        this.f120082g.setOnClickListener(new k());
        this.f120083h.setOnClickListener(new l());
    }

    public final void m() {
        com.tencent.luggage.wxa.e4.b sharedMaskView = this.f120078c.getSharedMaskView();
        if (sharedMaskView != null) {
            this.f120079d = sharedMaskView.getFlashSwitcherView();
        }
        ScannerFlashSwitcher scannerFlashSwitcher = this.f120079d;
        if (scannerFlashSwitcher != null) {
            scannerFlashSwitcher.setOnClickListener(new j());
            this.f120078c.setFlashStatus(this.f120079d.e());
        }
    }

    public final void o() {
        com.tencent.luggage.wxa.e4.b sharedMaskView = this.f120078c.getSharedMaskView();
        if (sharedMaskView == null) {
            return;
        }
        if (!this.J) {
            sharedMaskView.getGalleryButton().setVisibility(0);
            sharedMaskView.setOnGalleryClickListener(new h());
        } else {
            sharedMaskView.getGalleryButton().setVisibility(8);
        }
    }

    public final void p() {
        this.f120084i = (Vibrator) getContext().getSystemService("vibrator");
    }

    public void q() {
        this.f120077b = (FrameLayout) findViewById(R.id.f79524_0);
        y();
        this.f120080e = findViewById(R.id.f79564_4);
        this.f120081f = findViewById(R.id.f99765qo);
        this.f120082g = (ImageView) findViewById(R.id.az_);
        this.f120083h = (TextView) findViewById(R.id.f166345zi3);
        ScanUIRectView scanUIRectView = new ScanUIRectView(getContext());
        this.f120078c = scanUIRectView;
        scanUIRectView.setBottomExtraHeight(0);
        this.f120077b.addView(this.f120078c, 0, new FrameLayout.LayoutParams(-1, -1));
        this.f120078c.d();
        this.f120078c.setShowScanTips(this.f120088m);
        this.f120078c.setScanMode(this.f120087l);
        this.f120078c.y();
        o();
        x();
        int[] iArr = this.E;
        if (iArr != null && iArr.length > 0) {
            this.f120078c.setScanCodeReaders(iArr);
        }
        m();
        l();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 28 && getWindow() != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        if (getWindow() != null) {
            getWindow().setSoftInputMode(3);
        }
        setContentView(R.layout.f167556dr2);
        p();
        this.E = getIntent().getIntArrayExtra("key_support_scan_code_type");
        this.F = getIntent().getIntExtra("key_scan_entry_scene", 0);
        this.G = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
        this.H = getIntent().getBooleanExtra("key_set_result_after_scan", true);
        this.I = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
        this.f120087l = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        this.f120088m = getIntent().getBooleanExtra("key_show_scan_tips", true);
        this.J = this.I;
        q();
        this.f120086k = System.currentTimeMillis();
    }

    public final void c(boolean z16) {
        if (z16) {
            this.f120080e.setVisibility(0);
            this.f120078c.C();
            this.f120080e.setOnClickListener(new f());
            ScanUIRectView scanUIRectView = this.f120078c;
            if (scanUIRectView != null) {
                scanUIRectView.b(true);
            }
            b(false);
            return;
        }
        this.f120080e.setVisibility(8);
        ScanUIRectView scanUIRectView2 = this.f120078c;
        if (scanUIRectView2 != null) {
            scanUIRectView2.b(false);
        }
    }

    public final void a(long j3, Bundle bundle, com.tencent.luggage.wxa.b4.d dVar) {
        if (dVar == null || bundle == null) {
            return;
        }
        bundle.putInt("result_code_format", dVar.typeID);
        bundle.putString("result_content", dVar.data);
        bundle.putString("result_code_name", dVar.typeName);
        bundle.putByteArray("result_raw_data", dVar.rawData);
        bundle.putInt("result_code_version", dVar.f121842a);
        Intent intent = new Intent();
        intent.putExtra("key_scan_result", dVar.data);
        intent.putExtra("key_scan_result_raw", dVar.rawData);
        intent.putExtra("key_scan_result_code_name", dVar.typeName);
        intent.putExtra("key_scan_result_code_version", dVar.f121842a);
        setResult(-1, intent);
        setResult(-1, intent);
    }

    /* loaded from: classes2.dex */
    public class a implements ScanUIRectView.l {

        /* renamed from: com.tencent.luggage.scanner.scanner.ui.BaseScanPage$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C5964a implements com.tencent.luggage.wxa.e4.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f120091a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f120092b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f120093c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bundle f120094d;

            public C5964a(ArrayList arrayList, int i3, long j3, Bundle bundle) {
                this.f120091a = arrayList;
                this.f120092b = i3;
                this.f120093c = j3;
                this.f120094d = bundle;
            }

            @Override // com.tencent.luggage.wxa.e4.c
            public void a(int i3, View view) {
                w.d("Luggage.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", Integer.valueOf(i3));
                if (i3 < this.f120091a.size() && this.f120092b > 1) {
                    BaseScanPage.this.K = false;
                    BaseScanPage.this.a(this.f120093c, this.f120094d, (com.tencent.luggage.wxa.b4.d) this.f120091a.get(i3));
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.scanner.scanner.ui.ScanUIRectView.l
        public void a(long j3, Bundle bundle) {
            boolean z16 = false;
            if (!BaseScanPage.this.L) {
                w.h("Luggage.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", Integer.valueOf(BaseScanPage.this.f120087l));
                return;
            }
            if (bundle != null) {
                w.d("Luggage.ScanUI", "scan code cost time: %d", Long.valueOf(System.currentTimeMillis() - BaseScanPage.this.f120086k));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("result_qbar_result_list");
                if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                    int i3 = bundle.getInt("result_code_point_count", 0);
                    long j16 = bundle.getLong(LuggageScanDecodeQueue.ScanDecodeCallBack.DECODE_SUCCESS_COST_TIME, 0L);
                    com.tencent.luggage.wxa.b4.d dVar = (com.tencent.luggage.wxa.b4.d) parcelableArrayList.get(0);
                    if (BaseScanPage.this.H) {
                        if (dVar == null) {
                            w.f("Luggage.ScanUI", "first Qbar result is null");
                            return;
                        }
                        String str = dVar.typeName;
                        String str2 = dVar.data;
                        Intent intent = new Intent();
                        intent.putExtra("key_scan_result", str2);
                        intent.putExtra("key_scan_result_raw", dVar.rawData);
                        intent.putExtra("key_scan_result_code_name", str);
                        intent.putExtra("key_scan_result_code_version", dVar.f121842a);
                        BaseScanPage.this.setResult(-1, intent);
                        BaseScanPage.this.finish();
                        return;
                    }
                    bundle.putInt("qbar_string_scan_source", 0);
                    if (i3 <= 0 || BaseScanPage.this.f120078c == null) {
                        BaseScanPage.this.a(j3, bundle, dVar);
                        return;
                    }
                    w.d("Luggage.ScanUI", "scanCode cost: %d", Long.valueOf(j16));
                    com.tencent.luggage.wxa.b4.e eVar = (com.tencent.luggage.wxa.b4.e) bundle.getParcelable(LuggageScanDecodeQueue.ScanDecodeCallBack.DECODE_SUCCESS_FRAME_DATA);
                    if (eVar != null) {
                        BaseScanPage.this.f120078c.setDecodeSuccessFrameData(eVar);
                    }
                    BaseScanPage baseScanPage = BaseScanPage.this;
                    if (i3 > 1) {
                        z16 = true;
                    }
                    baseScanPage.N = z16;
                    if (i3 > 1) {
                        BaseScanPage.this.a(true, (Animator.AnimatorListener) null);
                    }
                    BaseScanPage.this.K = true;
                    BaseScanPage.this.f120078c.setSuccessMarkClickListener(new C5964a(parcelableArrayList, i3, j3, bundle));
                    BaseScanPage.this.t();
                    BaseScanPage.this.f120078c.a(parcelableArrayList, new b(i3, parcelableArrayList, j3, bundle, dVar));
                    return;
                }
                w.f("Luggage.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
            }
        }

        /* loaded from: classes2.dex */
        public class b implements com.tencent.luggage.wxa.g4.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f120096a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ArrayList f120097b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f120098c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bundle f120099d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.b4.d f120100e;

            public b(int i3, ArrayList arrayList, long j3, Bundle bundle, com.tencent.luggage.wxa.b4.d dVar) {
                this.f120096a = i3;
                this.f120097b = arrayList;
                this.f120098c = j3;
                this.f120099d = bundle;
                this.f120100e = dVar;
            }

            @Override // com.tencent.luggage.wxa.g4.e
            public void a() {
                if (this.f120096a == 1 || this.f120097b.size() == 1) {
                    BaseScanPage.this.K = false;
                    BaseScanPage.this.a(this.f120098c, this.f120099d, this.f120100e);
                }
            }

            @Override // com.tencent.luggage.wxa.g4.e
            public void b() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, Intent intent) {
        String str;
        if (i3 == -1 && intent != null) {
            try {
                str = com.tencent.luggage.wxa.f4.a.a(getContext(), intent.getData());
            } catch (URISyntaxException e16) {
                e16.printStackTrace();
                str = null;
            }
            String str2 = str;
            if (w0.c(str2)) {
                w.f("Luggage.ScanUI", "preScanImage is null");
                return;
            }
            w.d("Luggage.ScanUI", "select: [%s]", str2);
            long currentTimeMillis = System.currentTimeMillis();
            LuggageFileDecodeQueue.getInstance().addDecodeTask(getContext(), currentTimeMillis, str2, new i(currentTimeMillis), this.E);
            return;
        }
        v();
    }

    public final void b(boolean z16) {
        a(z16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent, Exception exc) {
        if (w0.d(intent.getAction()).startsWith("android.intent.action")) {
            w.a("Luggage.ScanUI", exc, IAELaunchRecorder.MILESTONE_START_ACTIVITY, new Object[0]);
            new com.tencent.luggage.wxa.am.b(getContext(), false).a(getContext().getString(R.string.f242247u2)).a();
        }
    }

    public final void a(int i3) {
        w.d("Luggage.ScanUI", "operateFlash operation: %d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.c4.b bVar = new com.tencent.luggage.wxa.c4.b();
        bVar.f123289d.f123290a = i3;
        bVar.c();
        ScannerFlashSwitcher scannerFlashSwitcher = this.f120079d;
        if (scannerFlashSwitcher != null) {
            if (i3 == 1) {
                scannerFlashSwitcher.f();
            } else {
                scannerFlashSwitcher.a();
            }
        }
    }

    public final void a(boolean z16, Animator.AnimatorListener animatorListener) {
        w.g("Luggage.ScanUI", "switchCloseView isMultiCode: %b", Boolean.valueOf(z16));
        if (z16) {
            this.f120083h.setAlpha(0.0f);
            a((View) this.f120082g, false, (Animator.AnimatorListener) new n(animatorListener));
        } else {
            a((View) this.f120083h, false, (Animator.AnimatorListener) new b(animatorListener));
        }
    }

    public final void a(View view, boolean z16) {
        a(view, z16, (Animator.AnimatorListener) null);
    }

    public final void a(View view, boolean z16, Animator.AnimatorListener animatorListener) {
        if (view == null) {
            return;
        }
        if (z16 && view.getAlpha() != 0.0f) {
            w.h("Luggage.ScanUI", "animateAlpha show ignore, view: %s", view);
            return;
        }
        if (!z16 && view.getAlpha() != 1.0f) {
            w.h("Luggage.ScanUI", "animateAlpha hide ignore, view: %s", view);
            return;
        }
        w.g("Luggage.ScanUI", "animateAlpha show: %b, view: %s", Boolean.valueOf(z16), view);
        c cVar = new c(animatorListener, view, z16);
        view.setVisibility(0);
        view.setAlpha(z16 ? 0.0f : 1.0f);
        view.animate().alpha(z16 ? 1.0f : 0.0f).setListener(cVar).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != -1) {
            return;
        }
        a(getContext(), getContext().getString(R.string.f173442t6), getContext().getString(R.string.f173512tc), getContext().getString(R.string.f161621y8), getContext().getString(R.string.f170647xd), false, new d(), new e());
    }

    public final void a(boolean z16, boolean z17) {
        w.g("Luggage.ScanUI", "showFlash show: %b, withAnimation: %b", Boolean.valueOf(z16), Boolean.valueOf(z17));
        if (z16) {
            ScannerFlashSwitcher scannerFlashSwitcher = this.f120079d;
            if (scannerFlashSwitcher == null || scannerFlashSwitcher.isShown()) {
                return;
            }
            this.f120078c.v();
            if (z17) {
                this.f120079d.g();
                return;
            } else {
                this.f120079d.setVisibility(0);
                return;
            }
        }
        ScannerFlashSwitcher scannerFlashSwitcher2 = this.f120079d;
        if (scannerFlashSwitcher2 == null || scannerFlashSwitcher2.d()) {
            return;
        }
        this.f120078c.u();
        if (z17) {
            this.f120079d.b();
        } else {
            this.f120079d.setVisibility(8);
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, boolean z16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        com.tencent.luggage.wxa.g6.d e16 = o21.a.a(context).e(context);
        e16.a(str).d(str2).a(z16).c(str3).b(onClickListener).b(str4).a(onClickListener2);
        e16.a();
    }
}
