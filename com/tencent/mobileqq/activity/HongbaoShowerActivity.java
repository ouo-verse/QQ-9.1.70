package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HongbaoShowerActivity extends BaseActivity {
    static IPatchRedirector $redirector_;
    PortalManager.e A0;
    private SanHuaView B0;
    boolean C0;

    /* renamed from: a0, reason: collision with root package name */
    private RelativeLayout f176215a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f176216b0;

    /* renamed from: c0, reason: collision with root package name */
    private CheckBox f176217c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f176218d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f176219e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f176220f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f176221g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f176222h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f176223i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f176224j0;

    /* renamed from: k0, reason: collision with root package name */
    long f176225k0;

    /* renamed from: l0, reason: collision with root package name */
    View f176226l0;

    /* renamed from: m0, reason: collision with root package name */
    private Animation f176227m0;

    /* renamed from: n0, reason: collision with root package name */
    AlphaAnimation f176228n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f176229o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f176230p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f176231q0;

    /* renamed from: r0, reason: collision with root package name */
    private String f176232r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f176233s0;

    /* renamed from: t0, reason: collision with root package name */
    private Bitmap f176234t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f176235u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f176236v0;

    /* renamed from: w0, reason: collision with root package name */
    private String f176237w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f176238x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f176239y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f176240z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            motionEvent.getAction();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                HongbaoShowerActivity.this.R2();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                HongbaoShowerActivity.this.f176217c0.setChecked(!HongbaoShowerActivity.this.f176217c0.isChecked());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                HongbaoShowerActivity hongbaoShowerActivity = HongbaoShowerActivity.this;
                if (currentTimeMillis - hongbaoShowerActivity.f176225k0 >= 2000) {
                    hongbaoShowerActivity.finish();
                    HongbaoShowerActivity.this.overridePendingTransition(0, 0);
                    HongbaoShowerActivity hongbaoShowerActivity2 = HongbaoShowerActivity.this;
                    QQAppInterface qQAppInterface = hongbaoShowerActivity2.app;
                    if (hongbaoShowerActivity2.f176230p0 == 0) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    ReportController.o(qQAppInterface, "dc01440", "", "", "0X80077EA", "0X80077EA", 0, 0, str, "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends OvershootInterpolator {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f176246a;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
            }
        }

        @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            if (!this.f176246a && f16 > 0.7d) {
                this.f176246a = true;
                HongbaoShowerActivity.this.f176226l0.setBackgroundColor(-16777216);
                HongbaoShowerActivity hongbaoShowerActivity = HongbaoShowerActivity.this;
                hongbaoShowerActivity.f176226l0.startAnimation(hongbaoShowerActivity.f176228n0);
                HongbaoShowerActivity.this.B0.b();
            }
            return (float) (1.0d - (Math.pow(2.718281828459045d, (-f16) * 5.0f) * Math.cos(f16 * 8.0f)));
        }
    }

    public HongbaoShowerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176225k0 = 0L;
        this.f176240z0 = true;
        this.C0 = false;
    }

    public static String L2(int i3) {
        if (i3 == R.drawable.eod) {
            return "shower_star_high_bg";
        }
        if (i3 == R.drawable.eoc) {
            return "shower_star_bg";
        }
        if (i3 == R.drawable.eo5) {
            return "shower_business_high_bg";
        }
        return null;
    }

    private JSONObject M2() {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("amount", this.f176236v0);
            jSONObject2.put(WadlProxyConsts.CHANNEL, 4);
            String str2 = "";
            if (this.C0) {
                str = "";
            } else {
                str = this.f176237w0;
            }
            jSONObject2.put("mch_icon", str);
            if (!this.C0) {
                str2 = this.f176238x0;
            }
            jSONObject2.put("mch_top_img", str2);
            jSONObject2.put("wishing", this.f176239y0);
            jSONObject2.put("send_name", this.f176232r0);
            jSONObject.put("detailinfo", jSONObject2);
            jSONObject3.put("extra_data", jSONObject);
            jSONObject3.put("come_from", 2);
            jSONObject3.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
            jSONObject3.put("userId", this.app.getCurrentAccountUin());
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager.HongbaoShowerActivity", 2, jSONObject3.toString());
        }
        return jSONObject3;
    }

    private void N2() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ick);
        this.f176216b0 = relativeLayout;
        relativeLayout.setVisibility(4);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        this.f176227m0 = translateAnimation;
        translateAnimation.setInterpolator(new f());
        this.f176227m0.setDuration(800L);
        this.f176227m0.setAnimationListener(new e());
        this.f176226l0 = findViewById(R.id.d79);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.f176228n0 = alphaAnimation;
        alphaAnimation.setDuration(350L);
        this.f176228n0.setFillAfter(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        SanHuaView sanHuaView = new SanHuaView(this, displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2);
        this.B0 = sanHuaView;
        this.f176215a0.addView(sanHuaView, new ViewGroup.LayoutParams(-1, -1));
        this.B0.a(100);
    }

    private void P2() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.HongbaoShowerActivity.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoShowerActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    HongbaoShowerActivity.this.f176216b0.setVisibility(0);
                    HongbaoShowerActivity.this.f176216b0.startAnimation(HongbaoShowerActivity.this.f176227m0);
                }
            }
        }, 500L);
    }

    private void Q2(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageDrawable(new BitmapDrawable(bitmap));
        } else if (QLog.isColorLevel()) {
            QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        boolean z16;
        String str;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.f176229o0);
        }
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.n9l), 1).show();
            return;
        }
        if (this.f176230p0 != 0 && this.f176229o0 == null) {
            return;
        }
        CheckBox checkBox = this.f176217c0;
        if (checkBox != null && checkBox.isChecked()) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(getAppInterface(), this, this.f176231q0, (IPublicAccountObserver) null, 113);
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.f176230p0;
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", this.f176229o0);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent.putExtra("show_right_close_button", true);
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
                intent.putExtra("hide_operation_bar", true);
                intent.addFlags(67108864);
                startActivity(intent);
                setResult(-1);
                QQAppInterface qQAppInterface = this.app;
                if (z16) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                ReportController.o(qQAppInterface, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", str2, "", "");
            }
        } else {
            JSONObject M2 = M2();
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, M2.toString());
            bundle.putString("callbackSn", "0");
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(this);
            payBridgeIntent.putExtras(bundle);
            payBridgeIntent.putExtra("pay_requestcode", 5);
            startActivity(payBridgeIntent);
            QQAppInterface qQAppInterface2 = this.app;
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(qQAppInterface2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", str, "", "");
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Bitmap bitmap;
        boolean z16;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        boolean z17 = false;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return false;
        }
        try {
            this.f176230p0 = intent.getIntExtra("a_hb_type", 0);
            this.f176229o0 = getIntent().getStringExtra("a_hg_url");
            i3 = getIntent().getIntExtra("a_hb_task_id", -1);
            try {
                this.f176231q0 = getIntent().getStringExtra("a_hb_business_uin");
                int intExtra = getIntent().getIntExtra(WidgetCacheConstellationData.MONEY, -1);
                this.f176235u0 = getIntent().getIntExtra("award_id", -1);
                i16 = getIntent().getIntExtra("promotion_id", -1);
                if (intExtra != -1) {
                    try {
                        this.f176236v0 = String.valueOf(intExtra);
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("PortalManager.HongbaoShowerActivity", 2, "getExtra Exception", e);
                        finish();
                        if (QLog.isColorLevel()) {
                        }
                        if (i3 < 0) {
                        }
                        finish();
                        return false;
                    }
                }
                this.f176240z0 = intent.getBooleanExtra("show_follow", true);
            } catch (Exception e17) {
                e = e17;
                i16 = -1;
            }
        } catch (Exception e18) {
            e = e18;
            i3 = -1;
            i16 = -1;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(i3);
            sb5.append(", ");
            sb5.append(this.f176230p0);
            sb5.append(", ");
            sb5.append(this.f176229o0);
            sb5.append(", ");
            sb5.append(this.f176236v0);
            sb5.append(", ");
            sb5.append(getIntent().getIntExtra("a_hb_from", -1));
            sb5.append(", ");
            sb5.append(getIntent().getIntExtra("award_id", -1));
            sb5.append(", ");
            sb5.append(getIntent().getIntExtra("promotion_id", -1));
            QLog.d("PortalManager.HongbaoShowerActivity", 1, sb5.toString());
        }
        if (i3 < 0 && (i17 = this.f176230p0) >= 0 && i17 <= 2 && (this.f176235u0 >= 0 || i16 >= 0)) {
            PortalManager.e x16 = ((PortalManager) this.app.getManager(QQManagerFactory.MGR_PORTAL)).x(this.f176230p0, i3, this.f176235u0, i16);
            this.A0 = x16;
            if (x16 == null) {
                finish();
                return false;
            }
            this.f176232r0 = x16.f259314i;
            this.f176233s0 = x16.f259317l;
            this.f176234t0 = x16.f259306a;
            this.f176237w0 = x16.f259312g;
            this.f176238x0 = x16.f259313h;
            this.f176239y0 = x16.f259316k;
            this.f176231q0 = x16.f259318m;
            int i27 = x16.f259315j;
            int i28 = R.layout.f168791as1;
            if (i27 != 1) {
                if (i27 != 2) {
                    this.C0 = true;
                } else {
                    i28 = R.layout.f168792as2;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager.HongbaoShowerActivity", 1, "data.logoType = " + this.A0.f259315j);
            }
            if (i28 == 0) {
                return false;
            }
            try {
                super.setContentView(i28);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.icl);
                this.f176215a0 = relativeLayout;
                relativeLayout.setContentDescription(this.A0.f259307b);
                this.f176215a0.setOnTouchListener(new a());
                TextView textView = (TextView) findViewById(R.id.k8o);
                this.f176222h0 = textView;
                textView.setText(this.f176232r0);
                TextView textView2 = (TextView) findViewById(R.id.dvp);
                this.f176224j0 = textView2;
                if (this.f176230p0 == 0) {
                    i18 = R.string.n9m;
                } else {
                    i18 = R.string.n9n;
                }
                textView2.setText(HardCodeUtil.qqStr(i18));
                this.f176224j0.setOnClickListener(new b());
                TextView textView3 = (TextView) findViewById(R.id.k8p);
                if (this.f176230p0 == 0) {
                    i19 = R.string.n9q;
                } else {
                    i19 = R.string.n9p;
                }
                textView3.setText(HardCodeUtil.qqStr(i19));
                int i29 = this.f176230p0;
                if ((i29 == 0 || i29 == 1) && this.A0.f259322q == 1 && !TextUtils.isEmpty(this.f176233s0)) {
                    findViewById(R.id.faz).setVisibility(0);
                    TextView textView4 = (TextView) findViewById(R.id.k9y);
                    this.f176223i0 = textView4;
                    textView4.setText(this.f176233s0);
                    CheckBox checkBox = (CheckBox) findViewById(R.id.as5);
                    this.f176217c0 = checkBox;
                    if (!this.f176240z0) {
                        checkBox.setChecked(false);
                    }
                    View findViewById = findViewById(R.id.axh);
                    this.f176218d0 = findViewById;
                    findViewById.setOnClickListener(new c());
                }
                View findViewById2 = findViewById(R.id.k8n);
                if (findViewById2 != null) {
                    if (this.f176230p0 == 1) {
                        i26 = 0;
                    } else {
                        i26 = 8;
                    }
                    findViewById2.setVisibility(i26);
                }
                this.f176225k0 = System.currentTimeMillis();
                TextView textView5 = (TextView) findViewById(R.id.dxm);
                this.f176221g0 = textView5;
                textView5.setOnClickListener(new d());
                int i36 = this.A0.f259315j;
                if (i36 == 2) {
                    ImageView imageView = (ImageView) findViewById(R.id.dvr);
                    if (imageView != null) {
                        Bitmap o16 = PortalManager.o(L2(R.drawable.eod));
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("getBitmapFromCache, qq_brash_star_high_bg hit=");
                            if (o16 != null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            sb6.append(z16);
                            QLog.d("PortalManager.HongbaoShowerActivity", 2, sb6.toString());
                        }
                        if (o16 == null) {
                            o16 = PortalManager.E(L2(R.drawable.eod), R.drawable.eod);
                        }
                        if (o16 == null) {
                            imageView.setImageResource(R.drawable.eod);
                        } else {
                            imageView.setImageBitmap(o16);
                        }
                    }
                    RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.ick);
                    if (relativeLayout2 != null) {
                        Bitmap o17 = PortalManager.o(L2(R.drawable.eoc));
                        if (QLog.isColorLevel()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("getBitmapFromCache, qq_brash_star_bg hit=");
                            if (o17 != null) {
                                z17 = true;
                            }
                            sb7.append(z17);
                            QLog.d("PortalManager.HongbaoShowerActivity", 2, sb7.toString());
                        }
                        if (o17 == null) {
                            o17 = PortalManager.E(L2(R.drawable.eoc), R.drawable.eoc);
                        }
                        if (o17 == null) {
                            relativeLayout2.setBackgroundResource(R.drawable.eoc);
                        } else {
                            relativeLayout2.setBackgroundDrawable(new BitmapDrawable(o17));
                        }
                    }
                    ImageView imageView2 = (ImageView) findViewById(R.id.dvq);
                    this.f176220f0 = imageView2;
                    if (imageView2 != null && this.f176234t0 != null) {
                        imageView2.setBackgroundDrawable(new BitmapDrawable(this.f176234t0));
                    }
                } else if (i36 == 1) {
                    ImageView imageView3 = (ImageView) findViewById(R.id.dvr);
                    if (imageView3 != null) {
                        Bitmap o18 = PortalManager.o(L2(R.drawable.eo5));
                        if (QLog.isColorLevel()) {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("getBitmapFromCache, qq_brash_business_high_bg hit=");
                            if (o18 != null) {
                                z17 = true;
                            }
                            sb8.append(z17);
                            QLog.d("PortalManager.HongbaoShowerActivity", 2, sb8.toString());
                        }
                        if (o18 == null) {
                            o18 = PortalManager.E(L2(R.drawable.eo5), R.drawable.eo5);
                        }
                        if (o18 == null) {
                            imageView3.setImageResource(R.drawable.eo5);
                        } else {
                            imageView3.setImageBitmap(o18);
                        }
                    }
                    ImageView imageView4 = (ImageView) findViewById(R.id.dvs);
                    this.f176219e0 = imageView4;
                    if (imageView4 != null && (bitmap = this.f176234t0) != null) {
                        Q2(imageView4, bitmap);
                    }
                }
                N2();
                P2();
                return true;
            } catch (OutOfMemoryError e19) {
                e19.printStackTrace();
                finish();
                return false;
            }
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
    }
}
