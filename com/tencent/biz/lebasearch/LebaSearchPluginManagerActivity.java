package com.tencent.biz.lebasearch;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes2.dex */
public class LebaSearchPluginManagerActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: x0, reason: collision with root package name */
    static int f78585x0 = 110;

    /* renamed from: y0, reason: collision with root package name */
    static double f78586y0 = 0.5d;

    /* renamed from: z0, reason: collision with root package name */
    static double f78587z0 = 0.4d;

    /* renamed from: d0, reason: collision with root package name */
    float f78591d0;

    /* renamed from: f0, reason: collision with root package name */
    Bitmap f78593f0;

    /* renamed from: g0, reason: collision with root package name */
    ImageView f78594g0;

    /* renamed from: h0, reason: collision with root package name */
    ImageView f78595h0;

    /* renamed from: i0, reason: collision with root package name */
    protected Button f78596i0;

    /* renamed from: j0, reason: collision with root package name */
    protected ImageView f78597j0;

    /* renamed from: k0, reason: collision with root package name */
    protected TextView f78598k0;

    /* renamed from: l0, reason: collision with root package name */
    protected TextView f78599l0;

    /* renamed from: m0, reason: collision with root package name */
    protected View f78600m0;

    /* renamed from: n0, reason: collision with root package name */
    protected TextView f78601n0;

    /* renamed from: o0, reason: collision with root package name */
    LebaSearchBounceScrollView f78602o0;

    /* renamed from: p0, reason: collision with root package name */
    LinearLayout f78603p0;

    /* renamed from: q0, reason: collision with root package name */
    View f78604q0;

    /* renamed from: r0, reason: collision with root package name */
    byte f78605r0;

    /* renamed from: a0, reason: collision with root package name */
    long f78588a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    List<n> f78589b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    int f78590c0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    n f78592e0 = null;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f78606s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f78607t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    QQCustomDialog f78608u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    QQCustomDialog f78609v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    Handler f78610w0 = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LebaSearchPluginManagerActivity.this.f78600m0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            LebaSearchPluginManagerActivity.this.K2(LebaSearchPluginManagerActivity.this.getWindow().getDecorView().getBottom() - LebaSearchPluginManagerActivity.this.getWindow().getDecorView().getTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            int bottom = LebaSearchPluginManagerActivity.this.getWindow().getDecorView().getBottom() - LebaSearchPluginManagerActivity.this.getWindow().getDecorView().getTop();
            LebaSearchPluginManagerActivity lebaSearchPluginManagerActivity = LebaSearchPluginManagerActivity.this;
            if (bottom != lebaSearchPluginManagerActivity.f78590c0) {
                lebaSearchPluginManagerActivity.K2(bottom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        int f78613d = 0;

        /* renamed from: e, reason: collision with root package name */
        Handler f78614e = new a();

        /* loaded from: classes2.dex */
        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                c cVar = c.this;
                if (cVar.f78613d == LebaSearchPluginManagerActivity.this.f78602o0.getScrollY()) {
                    c cVar2 = c.this;
                    if (cVar2.f78613d > 0 && !LebaSearchPluginManagerActivity.this.f78602o0.b()) {
                        c cVar3 = c.this;
                        int i3 = cVar3.f78613d;
                        LebaSearchPluginManagerActivity lebaSearchPluginManagerActivity = LebaSearchPluginManagerActivity.this;
                        int i16 = (int) ((lebaSearchPluginManagerActivity.f78590c0 * (1.0d - LebaSearchPluginManagerActivity.f78586y0)) + i3);
                        double d16 = i3;
                        float height = lebaSearchPluginManagerActivity.f78599l0.getHeight();
                        LebaSearchPluginManagerActivity lebaSearchPluginManagerActivity2 = LebaSearchPluginManagerActivity.this;
                        int i17 = (int) (d16 - ((height + (lebaSearchPluginManagerActivity2.f78591d0 * 56.0f)) - (lebaSearchPluginManagerActivity2.f78590c0 * (1.0d - LebaSearchPluginManagerActivity.f78586y0))));
                        float f16 = i16;
                        float height2 = lebaSearchPluginManagerActivity2.f78599l0.getHeight();
                        LebaSearchPluginManagerActivity lebaSearchPluginManagerActivity3 = LebaSearchPluginManagerActivity.this;
                        if (f16 > height2 + (lebaSearchPluginManagerActivity3.f78591d0 * 56.0f) || i16 > lebaSearchPluginManagerActivity3.f78599l0.getHeight()) {
                            LebaSearchPluginManagerActivity.this.f78602o0.scrollBy(0, -i17);
                            return;
                        }
                        return;
                    }
                    return;
                }
                c cVar4 = c.this;
                cVar4.f78613d = LebaSearchPluginManagerActivity.this.f78602o0.getScrollY();
                Handler handler = c.this.f78614e;
                handler.sendMessageDelayed(handler.obtainMessage(), 5L);
            }
        }

        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                Handler handler = this.f78614e;
                handler.sendMessageDelayed(handler.obtainMessage(), 5L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    LebaSearchPluginManagerActivity.this.f78592e0.a();
                    LebaSearchPluginManagerActivity.this.P2();
                    sb5.append(LebaSearchPluginManagerActivity.this.getString(R.string.dnc));
                    sb5.append(LebaSearchPluginManagerActivity.this.getString(R.string.dn7));
                    sb5.append(LebaSearchPluginManagerActivity.this.f78592e0.f240505b.strResName);
                    QQToast.makeText(LebaSearchPluginManagerActivity.this, 2, sb5.toString(), 1).show(LebaSearchPluginManagerActivity.this.getTitleBarHeight());
                    return;
                }
                return;
            }
            LebaSearchPluginManagerActivity.this.f78592e0.e();
            LebaSearchPluginManagerActivity.this.P2();
            sb5.append(LebaSearchPluginManagerActivity.this.getString(R.string.dnc));
            sb5.append(LebaSearchPluginManagerActivity.this.getString(R.string.dna));
            sb5.append(LebaSearchPluginManagerActivity.this.f78592e0.f240505b.strResName);
            QQToast.makeText(LebaSearchPluginManagerActivity.this, 2, sb5.toString(), 1).show(LebaSearchPluginManagerActivity.this.getTitleBarHeight());
        }
    }

    private boolean J2(ILebaHelperService iLebaHelperService) {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.f78590c0 = getResources().getDisplayMetrics().heightPixels - rect.top;
        this.f78591d0 = super.getResources().getDisplayMetrics().density;
        this.f78588a0 = getIntent().getLongExtra("id", 0L);
        this.f78589b0 = null;
        if (iLebaHelperService != null) {
            this.f78589b0 = iLebaHelperService.getLebaMgrList();
        }
        List<n> list = this.f78589b0;
        if (list != null) {
            Iterator<n> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                LebaPluginInfo lebaPluginInfo = next.f240505b;
                if (lebaPluginInfo != null && lebaPluginInfo.uiResId == this.f78588a0) {
                    this.f78592e0 = next;
                    break;
                }
            }
        }
        n nVar = this.f78592e0;
        if (nVar == null || nVar.f240505b == null) {
            return false;
        }
        this.f78605r0 = (byte) (!nVar.d() ? 1 : 0);
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.dez);
            this.f78593f0 = BaseImageUtil.getRoundFaceBitmap(decodeResource, 110, 110);
            decodeResource.recycle();
        } catch (OutOfMemoryError unused) {
        }
        String str = Build.BRAND;
        if (!str.startsWith(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && !str.startsWith("Coolpad")) {
            this.f78606s0 = true;
        } else {
            this.f78606s0 = false;
        }
        this.f78607t0 = Build.BOARD.equals("mx");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(int i3) {
        this.f78590c0 = i3;
        f78586y0 = this.f78600m0.getHeight() / this.f78590c0;
        ((RelativeLayout.LayoutParams) this.f78600m0.getLayoutParams()).height = (int) (this.f78590c0 * f78586y0);
        this.f78603p0.setMinimumHeight((int) ((r0 - getTitleBarHeight()) - (this.f78591d0 * 56.0f)));
        this.f78602o0.setMaxOverScrollY((int) ((this.f78603p0.getHeight() - (this.f78590c0 * (1.0d - f78586y0))) + (this.f78591d0 * 56.0f)));
        if (this.f78606s0) {
            N2(this.f78602o0.getScrollY());
            M2(this.f78602o0.getScrollY());
        }
        this.f78604q0.postInvalidate();
    }

    private void L2(boolean z16) {
        if (z16) {
            if (this.f78608u0 == null) {
                QQAppInterface qQAppInterface = this.app;
                LebaPluginInfo lebaPluginInfo = this.f78592e0.f240505b;
                this.f78608u0 = Utils.createPluginSetDialogForMain(qQAppInterface, this, 1, lebaPluginInfo.uiResId, lebaPluginInfo.strResName, null, this.f78610w0);
            }
            if (this.f78608u0.isShowing()) {
                return;
            }
            this.f78608u0.show();
            return;
        }
        if (this.f78609v0 == null) {
            QQAppInterface qQAppInterface2 = this.app;
            LebaPluginInfo lebaPluginInfo2 = this.f78592e0.f240505b;
            this.f78609v0 = Utils.createPluginSetDialogForMain(qQAppInterface2, this, 2, lebaPluginInfo2.uiResId, lebaPluginInfo2.strResName, "", this.f78610w0);
        }
        if (this.f78609v0.isShowing()) {
            return;
        }
        this.f78609v0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void M2(int i3) {
        int i16;
        int i17;
        float f16;
        if (i3 >= 0) {
            if (this.f78607t0) {
                i17 = LocaleManager.MOBILE_COUNTRY_CODE_CN_INT;
                i16 = WebSocketImpl.DEFAULT_WSS_PORT;
            } else {
                int i18 = this.f78590c0;
                i16 = (int) (i18 * 0.29d);
                i17 = (int) (i18 * 0.39d);
            }
            int height = this.f78600m0.getHeight() - i3;
            if (height <= i17 && height >= i16) {
                double d16 = height - i16;
                int i19 = this.f78590c0;
                if (d16 <= i19 * 0.01d) {
                    f16 = 0.05f;
                } else if (d16 <= i19 * 0.02d) {
                    f16 = 0.15f;
                } else if (d16 <= i19 * 0.03d) {
                    f16 = 0.25f;
                } else if (d16 <= i19 * 0.04d) {
                    f16 = 0.35f;
                } else if (d16 <= i19 * 0.05d) {
                    f16 = 0.45f;
                } else if (d16 <= i19 * 0.06d) {
                    f16 = 0.55f;
                } else if (d16 <= i19 * 0.07d) {
                    f16 = 0.65f;
                } else if (d16 <= i19 * 0.08d) {
                    f16 = 0.75f;
                } else if (d16 <= i19 * 0.08d) {
                    f16 = 0.85f;
                } else {
                    f16 = 0.95f;
                }
                this.f78598k0.setAlpha(f16);
                return;
            }
            if (height < i16) {
                this.f78598k0.setAlpha(0.0f);
            } else {
                this.f78598k0.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2() {
        int i3;
        if (this.f78592e0.d()) {
            this.f78596i0.setBackgroundResource(R.drawable.common_btn_red);
            this.f78596i0.setText(R.string.dn7);
        } else {
            this.f78596i0.setBackgroundResource(R.drawable.common_btn_blue);
            this.f78596i0.setText(R.string.dna);
        }
        if (((byte) (!this.f78592e0.d() ? 1 : 0)) != this.f78605r0) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        setResult(i3);
    }

    private void initView() {
        BitmapDrawable bitmapDrawable;
        this.f78604q0 = findViewById(R.id.root);
        View findViewById = findViewById(R.id.fvp);
        this.f78600m0 = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f78604q0.addOnLayoutChangeListener(new b());
        this.f78603p0 = (LinearLayout) super.findViewById(R.id.bpy);
        ((RelativeLayout.LayoutParams) this.f78600m0.getLayoutParams()).height = (int) (this.f78590c0 * f78586y0);
        this.f78603p0.setMinimumHeight((int) ((r1 - getTitleBarHeight()) - (this.f78591d0 * 56.0f)));
        Button button = (Button) findViewById(R.id.ipk);
        this.f78596i0 = button;
        button.setOnClickListener(this);
        this.f78599l0 = (TextView) findViewById(R.id.fvl);
        this.f78597j0 = (ImageView) findViewById(R.id.fvo);
        ImageView imageView = (ImageView) super.findViewById(R.id.d__);
        this.f78594g0 = imageView;
        imageView.setBackgroundResource(R.drawable.d6d);
        this.f78595h0 = (ImageView) super.findViewById(R.id.jtf);
        this.f78598k0 = (TextView) findViewById(R.id.fvt);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f78601n0 = textView;
        textView.setText(getString(R.string.button_back));
        this.f78601n0.setOnClickListener(this);
        this.f78602o0 = (LebaSearchBounceScrollView) super.findViewById(R.id.ixx);
        if (!this.f78606s0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f78597j0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f78594g0.getLayoutParams();
            if (layoutParams != null && layoutParams2 != null) {
                int f16 = BaseAIOUtils.f(4.0f, getResources());
                layoutParams.topMargin += f16;
                layoutParams2.topMargin += f16;
            }
        }
        this.f78602o0.setOnTouchListener(new c());
        this.f78602o0.setOnScrollChangedListener(new d());
        LebaPluginInfo lebaPluginInfo = this.f78592e0.f240505b;
        if (this.f78593f0 == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), this.f78593f0);
        }
        this.f78597j0.setImageDrawable(bitmapDrawable);
        this.f78598k0.setText(lebaPluginInfo.strResName);
        View findViewById2 = findViewById(R.id.e8z);
        if (!this.f78606s0) {
            findViewById2.setBackgroundColor(Color.parseColor("#59D3FF"));
        }
        P2();
    }

    public void N2(int i3) {
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        ((RelativeLayout.LayoutParams) this.f78600m0.getLayoutParams()).height = (int) (this.f78590c0 * f78586y0);
        this.f78603p0.setMinimumHeight((int) ((r3 - getTitleBarHeight()) - (this.f78591d0 * 56.0f)));
        int height = this.f78600m0.getHeight() - i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f78597j0.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f78594g0.getLayoutParams();
        double d16 = f78586y0;
        double d17 = f78587z0;
        double d18 = d16 - 0.3d;
        double d19 = ((d16 * d17) - 0.05d) / d18;
        double d26 = height;
        int i16 = this.f78590c0;
        double d27 = (d26 - (i16 * 0.3d)) / (d18 * i16);
        if (d26 <= i16 * 0.3d) {
            float f16 = this.f78591d0;
            layoutParams.height = (int) (f16 * 30.0f);
            layoutParams.width = (int) (30.0f * f16);
            int i17 = (int) ((((i16 * 0.1d) * 0.5d) - (r7 / 2)) + i3);
            layoutParams.topMargin = i17;
            int i18 = (int) (32.0f * f16);
            layoutParams2.height = i18;
            layoutParams2.width = i18;
            layoutParams2.topMargin = (int) (i17 - (f16 * 1.0f));
        } else if (d26 >= i16 * d16) {
            float f17 = f78585x0;
            float f18 = this.f78591d0;
            int i19 = (int) (f17 * f18);
            layoutParams.height = i19;
            layoutParams.width = i19;
            int i26 = (int) (((d26 * d17) - (i19 / 2)) + i3);
            layoutParams.topMargin = i26;
            int i27 = (int) (i19 + (10.0f * f18));
            layoutParams2.height = i27;
            layoutParams2.width = i27;
            layoutParams2.topMargin = (int) (i26 - (f18 * 5.0f));
        } else {
            float f19 = this.f78591d0;
            int i28 = (int) ((((f78585x0 - 30) * d27) + 30.0d) * f19);
            layoutParams.height = i28;
            layoutParams.width = i28;
            int i29 = (int) (((((d26 - (i16 * 0.3d)) * d19) + ((i16 * 0.1d) * 0.5d)) - (i28 / 2)) + i3);
            layoutParams.topMargin = i29;
            double d28 = (d27 * 9.0d) + 1.0d;
            int i36 = (int) (i28 + (f19 * d28));
            layoutParams2.height = i36;
            layoutParams2.width = i36;
            layoutParams2.topMargin = (int) (i29 - ((d28 * f19) / 2.0d));
        }
        this.f78597j0.setLayoutParams(layoutParams);
        this.f78594g0.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        setContentView(R.layout.a06);
        ILebaHelperService iLebaHelperService = (ILebaHelperService) this.app.getRuntimeService(ILebaHelperService.class, "");
        if (iLebaHelperService != null) {
            iLebaHelperService.setFlagBackFromMgr();
        } else {
            QLog.d("qqBaseActivity", 1, "doOnCreate lebaHelperService == null");
        }
        if (!J2(iLebaHelperService)) {
            finish();
            return false;
        }
        initView();
        if (this.f78588a0 == 886) {
            ReportController.o(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        Bitmap bitmap = this.f78593f0;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f78593f0.recycle();
        }
        super.doOnDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ipk) {
            L2(!this.f78592e0.d());
        } else if (id5 == R.id.ivTitleBtnLeft) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements BounceScrollView.d {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            double height = LebaSearchPluginManagerActivity.this.f78603p0.getHeight();
            LebaSearchPluginManagerActivity.this.f78602o0.setMaxOverScrollY((int) ((height - (r7.f78590c0 * (1.0d - LebaSearchPluginManagerActivity.f78586y0))) + (r7.f78591d0 * 56.0f)));
            if (LebaSearchPluginManagerActivity.this.f78606s0) {
                LebaSearchPluginManagerActivity.this.N2(i16);
                LebaSearchPluginManagerActivity.this.M2(i16);
            }
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void ae(float f16, float f17) {
        }
    }
}
