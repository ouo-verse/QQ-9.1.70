package com.tencent.gamecenter.wadl.api.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.widget.WadlRoundProgressBar;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.gamecenter.wadl.util.i;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatBallView extends FrameLayout implements Handler.Callback, View.OnClickListener {

    /* renamed from: g0, reason: collision with root package name */
    public static int f106668g0 = Utils.n(176.0f, BaseApplication.getContext().getResources());

    /* renamed from: h0, reason: collision with root package name */
    public static int f106669h0 = Utils.n(50.0f, BaseApplication.getContext().getResources());

    /* renamed from: i0, reason: collision with root package name */
    public static int f106670i0 = Utils.n(52.0f, BaseApplication.getContext().getResources());

    /* renamed from: j0, reason: collision with root package name */
    public static int f106671j0 = Utils.n(6.0f, BaseApplication.getContext().getResources());
    protected float C;
    private long D;
    protected float E;
    protected float F;
    private boolean G;
    private LinearLayout H;
    private RFWRoundImageView I;
    private WadlRoundProgressBar J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private TextView N;
    private ImageView P;
    private ImageView Q;
    private FrameLayout R;
    private LinearLayout S;
    private ValueAnimator T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private WadlResult f106672a0;

    /* renamed from: b0, reason: collision with root package name */
    private Handler f106673b0;

    /* renamed from: c0, reason: collision with root package name */
    private ll0.a f106674c0;

    /* renamed from: d, reason: collision with root package name */
    private int f106675d;

    /* renamed from: d0, reason: collision with root package name */
    private int f106676d0;

    /* renamed from: e, reason: collision with root package name */
    private int f106677e;

    /* renamed from: e0, reason: collision with root package name */
    ArrayList<String> f106678e0;

    /* renamed from: f, reason: collision with root package name */
    private Context f106679f;

    /* renamed from: f0, reason: collision with root package name */
    ArrayList<String> f106680f0;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f106681h;

    /* renamed from: i, reason: collision with root package name */
    private int f106682i;

    /* renamed from: m, reason: collision with root package name */
    protected float f106683m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return FloatBallView.this.s(view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) FloatBallView.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = FloatBallView.f106668g0 - ((int) ((r1 - FloatBallView.f106669h0) * floatValue));
            if (FloatBallView.this.G) {
                layoutParams.x = FloatBallView.this.f106675d - layoutParams.width;
            }
            if (FloatBallView.this.f106674c0 != null) {
                FloatBallView.this.f106674c0.a(FloatBallView.this, layoutParams);
            }
        }
    }

    public FloatBallView(Context context, ll0.a aVar, int i3, int i16) {
        super(context);
        this.f106681h = true;
        this.f106682i = 250;
        this.G = true;
        this.U = 0;
        this.V = 0;
        this.W = 1;
        this.f106678e0 = new ArrayList<>();
        this.f106680f0 = new ArrayList<>();
        this.f106676d0 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f106679f = context;
        this.f106674c0 = aVar;
        this.f106675d = i3;
        this.f106677e = i16;
        int i17 = f106670i0;
        this.U = i17;
        this.V = i16 - i17;
        k();
        this.f106673b0 = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper(), this);
    }

    private void B() {
        List<WadlResult> list;
        int i3;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        ll0.a aVar = this.f106674c0;
        if (aVar != null) {
            list = aVar.e();
        } else {
            list = null;
        }
        this.f106678e0.clear();
        this.f106680f0.clear();
        if (list != null) {
            i3 = 0;
            for (WadlResult wadlResult : list) {
                if (wadlResult.isRunning()) {
                    i3++;
                } else if (wadlResult.isDownloadComplete()) {
                    this.f106680f0.add(wadlResult.wadlParams.appId);
                } else {
                    this.f106678e0.add(wadlResult.wadlParams.appId);
                }
            }
        } else {
            i3 = 0;
        }
        if (this.f106672a0.isDownloadComplete()) {
            if (this.f106680f0.size() > 1) {
                str = this.f106680f0.size() + "\u6b3e\u6e38\u620f\u4e0b\u8f7d\u5b8c\u6210";
                z18 = false;
            } else {
                str = "\u4e0b\u8f7d\u5b8c\u6210100%";
                z18 = true;
            }
            str2 = "\u70b9\u51fb\u5b89\u88c5";
            z16 = false;
            z17 = true;
        } else if (this.f106672a0.isTaskPaused()) {
            str = "\u5df2\u6682\u505c" + this.f106672a0.floatProgress + "%";
            if (this.f106678e0.size() > 1) {
                str2 = this.f106678e0.size() + "\u6b3e\u6e38\u620f\u5df2\u6682\u505c\u4e0b\u8f7d";
                z18 = false;
            } else {
                str2 = "\u70b9\u51fb\u6062\u590d";
                z18 = true;
            }
            z17 = false;
            z16 = true;
        } else {
            str = "\u5df2\u4e0b\u8f7d " + this.f106672a0.floatProgress + "%";
            if (i3 > 1) {
                str2 = i3 + "\u6b3e\u6e38\u620f\u4e0b\u8f7d\u4e2d";
                z18 = false;
                z16 = false;
                z17 = false;
            } else {
                str2 = this.f106672a0.wadlParams.appName + "\u4e0b\u8f7d\u4e2d";
                z16 = false;
                z17 = false;
                z18 = true;
            }
        }
        if (z16) {
            this.M.setVisibility(0);
            this.M.setImageResource(R.drawable.mv_);
            this.P.setVisibility(0);
            this.N.setVisibility(8);
        } else if (z17) {
            this.M.setVisibility(8);
            this.P.setVisibility(0);
            this.N.setVisibility(0);
        } else {
            this.M.setVisibility(8);
            this.P.setVisibility(8);
            this.N.setVisibility(8);
        }
        if (z18) {
            if (l(this.I, this.f106672a0.wadlParams.iconUrl)) {
                try {
                    QLog.i("WadlFloat_FloatBallView", 1, "[updateData] icon changed url=" + this.f106672a0.wadlParams.iconUrl);
                    this.I.setImageDrawable(URLDrawable.getDrawable(new URL(this.f106672a0.wadlParams.iconUrl), URLDrawable.URLDrawableOptions.obtain()));
                    this.I.setTag(R.id.xd8, this.f106672a0.wadlParams.iconUrl);
                } catch (Exception e16) {
                    QLog.e("WadlFloat_FloatBallView", 1, "[updateData] exception", e16);
                }
            }
        } else {
            this.I.setImageResource(R.drawable.mv9);
        }
        this.J.setProgress(this.f106672a0.progress);
        this.K.setText(str);
        this.L.setText(str2);
    }

    private int h() {
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult == null) {
            return 0;
        }
        int i3 = wadlResult.taskStatus;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    return -1;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private void j() {
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME);
    }

    private void k() {
        View.inflate(this.f106679f, R.layout.eb5, this);
        this.H = (LinearLayout) findViewById(R.id.iet);
        this.I = (RFWRoundImageView) findViewById(R.id.d_7);
        this.P = (ImageView) findViewById(R.id.u_g);
        this.J = (WadlRoundProgressBar) findViewById(R.id.g1g);
        this.M = (ImageView) findViewById(R.id.f88204wf);
        this.N = (TextView) findViewById(R.id.f88184wd);
        this.Q = (ImageView) findViewById(R.id.tzg);
        this.S = (LinearLayout) findViewById(R.id.ynv);
        this.R = (FrameLayout) findViewById(R.id.v85);
        this.K = (TextView) findViewById(R.id.jo5);
        this.L = (TextView) findViewById(R.id.f900651g);
        this.S.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnTouchListener(new a());
        e(false);
        this.H.setPadding(0, getPaddingTop(), f106671j0, getPaddingBottom());
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult != null) {
            A(wadlResult);
        }
    }

    private boolean l(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Object tag = view.getTag(R.id.xd8);
        if (!(tag instanceof String) || !((String) tag).equals(str)) {
            return true;
        }
        Drawable drawable = this.I.getDrawable();
        if (!(drawable instanceof URLDrawable) || ((URLDrawable) drawable).getStatus() != 1) {
            return true;
        }
        return false;
    }

    private void n() {
        String str;
        String str2;
        String str3;
        QLog.d("WadlFloat_FloatBallView", 1, "[onCloseClick] onCloseClick click");
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult != null) {
            String str4 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str = "2";
            } else {
                str = "1";
            }
            if (this.W != 0) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            if (this.f106672a0.isDownloadComplete()) {
                str3 = "2";
            } else {
                str3 = "1";
            }
            u(str4, "914836", "20", "1", str, str2, 5, str3);
        }
        try {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.removeViewImmediate(this);
            }
        } catch (Throwable th5) {
            QLog.e("WadlFloat_FloatBallView", 1, "[onCloseClick] onCloseClick exception", th5);
        }
        ll0.a aVar = this.f106674c0;
        if (aVar != null) {
            aVar.d();
        } else {
            QLog.w("WadlFloat_FloatBallView", 1, "[onCloseClick] onCloseClick wndListener is null");
        }
    }

    private boolean q() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        QLog.d("WadlFloat_FloatBallView", 1, "[onIconClick] mImageContainer click mCurrentMode=" + this.W);
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult == null) {
            j();
            return true;
        }
        if (this.W != 0) {
            String str7 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str5 = "2";
            } else {
                str5 = "1";
            }
            if (this.W != 0) {
                str6 = "2";
            } else {
                str6 = "1";
            }
            u(str7, "914836", "20", "1", str5, str6, 6, "1");
            f();
            return false;
        }
        int i3 = i();
        if (this.f106672a0.isDownloadComplete()) {
            WadlResult wadlResult2 = this.f106672a0;
            WadlParams wadlParams = wadlResult2.wadlParams;
            GameCenterUtil.goToInstallWithJump(wadlParams.appId, wadlParams.packageName, wadlResult2.downloadFilePath, wadlParams.sourceId, GameCenterUtil.INSTALL_FROM_FLOAT_BALL, false);
            String str8 = this.f106672a0.wadlParams.appId;
            if (this.W != 0) {
                str4 = "2";
            } else {
                str4 = "1";
            }
            u(str8, "914836", "20", "1", "1", str4, 4, "2");
        } else if (this.f106672a0.isRunning()) {
            if (i3 == 1) {
                WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
                WadlParams wadlParams2 = this.f106672a0.wadlParams;
                proxyService.doPauseAction(wadlParams2.from, wadlParams2.appId);
                String str9 = this.f106672a0.wadlParams.appId;
                if (this.W != 0) {
                    str3 = "2";
                } else {
                    str3 = "1";
                }
                u(str9, "914836", "20", "1", "1", str3, 1, "1");
            } else {
                j();
                String str10 = this.f106672a0.wadlParams.appId;
                if (i() > 1) {
                    str = "2";
                } else {
                    str = "1";
                }
                if (this.W != 0) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                u(str10, "914836", "20", "1", str, str2, 3, "1");
            }
        } else {
            w();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(View view, MotionEvent motionEvent) {
        boolean z16;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        QLog.d("WadlFloat_FloatBallView", 1, "[onTouchEvent] MotionEvent.ACTION_CANCEL mIsDrag=" + this.f106681h);
                        this.E = rawX;
                        this.F = rawY;
                        y(false);
                    }
                } else if (rawX >= 0.0f && rawX <= this.f106675d && rawY >= this.U && rawY <= this.V) {
                    float f16 = rawX - this.E;
                    float f17 = rawY - this.F;
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                    if (!this.f106681h) {
                        this.f106681h = true;
                        this.f106673b0.removeMessages(1);
                        ValueAnimator valueAnimator = this.T;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                        }
                        this.H.setPadding(0, getPaddingTop(), 0, getPaddingBottom());
                        e(true);
                        layoutParams.width = f106670i0;
                        int[] iArr = new int[2];
                        this.R.getLocationOnScreen(iArr);
                        layoutParams.x = iArr[0];
                        layoutParams.y = iArr[1];
                        this.f106683m = rawX;
                        this.C = rawY;
                        QLog.d("WadlFloat_FloatBallView", 1, "[onTouchEvent] MotionEvent.ACTION_MOVE update mDownX=" + this.f106683m + ",mDownY=" + this.C);
                    }
                    layoutParams.x = ((int) f16) + layoutParams.x;
                    layoutParams.y = ((int) f17) + layoutParams.y;
                    ll0.a aVar = this.f106674c0;
                    if (aVar != null) {
                        aVar.a(this, layoutParams);
                    }
                    this.E = rawX;
                    this.F = rawY;
                }
            } else {
                this.E = rawX;
                this.F = rawY;
                if (Math.abs(rawX - this.f106683m) < this.f106676d0 && Math.abs(this.F - this.C) < this.f106676d0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d("WadlFloat_FloatBallView", 1, "[onTouchEvent] MotionEvent.ACTION_UP mIsDrag=" + this.f106681h + ",isSlop=" + z16 + ",mDownX=" + this.f106683m + ",currX=" + this.E + ",mDownY=" + this.C + ",currY=" + this.F);
                if (z16 && System.currentTimeMillis() - this.D < this.f106682i) {
                    z17 = true;
                }
                if (z17) {
                    this.f106673b0.removeMessages(1);
                    ValueAnimator valueAnimator2 = this.T;
                    if (valueAnimator2 != null) {
                        valueAnimator2.cancel();
                    }
                }
                y(z17);
            }
        } else {
            this.f106681h = false;
            this.E = rawX;
            this.F = rawY;
            this.f106683m = rawX;
            this.C = rawY;
            this.D = System.currentTimeMillis();
            QLog.d("WadlFloat_FloatBallView", 1, "[onTouchEvent] MotionEvent.ACTION_DOWN mDownX=" + this.f106683m + ",mDownY=" + this.C);
            ll0.a aVar2 = this.f106674c0;
            if (aVar2 != null) {
                aVar2.f(true);
            }
        }
        return true;
    }

    private void w() {
        List<WadlResult> list;
        String str;
        ll0.a aVar = this.f106674c0;
        if (aVar != null) {
            list = aVar.e();
        } else {
            list = null;
        }
        if (list != null) {
            WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
            for (WadlResult wadlResult : list) {
                if (wadlResult.isTaskPaused()) {
                    WadlParams wadlParams = wadlResult.wadlParams;
                    proxyService.doResumeAction(wadlParams.from, wadlParams.appId);
                    String str2 = wadlResult.wadlParams.appId;
                    if (this.W == 0) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    u(str2, "914836", "20", "1", "1", str, 2, "1");
                }
            }
        }
    }

    private void y(boolean z16) {
        QLog.d("WadlFloat_FloatBallView", 1, "[springBack] isFromClick=" + z16);
        float f16 = (float) (this.f106675d / 2);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = f106669h0;
        layoutParams.width = i3;
        if (this.E <= f16) {
            layoutParams.x = 0;
            this.G = false;
            e(false);
            this.H.setLayoutDirection(1);
            this.H.setPadding(f106671j0, getPaddingTop(), 0, getPaddingBottom());
        } else {
            layoutParams.x = this.f106675d - i3;
            this.G = true;
            e(false);
            this.H.setLayoutDirection(0);
            this.H.setPadding(0, getPaddingTop(), f106671j0, getPaddingBottom());
        }
        ll0.a aVar = this.f106674c0;
        if (aVar != null) {
            aVar.a(this, layoutParams);
        }
        this.E = 0.0f;
        if (z16) {
            if (q()) {
                setMode(1);
            }
        } else {
            setMode(1);
            ll0.a aVar2 = this.f106674c0;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    public void A(WadlResult wadlResult) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        WadlResult wadlResult2 = this.f106672a0;
        if (wadlResult2 == null) {
            this.f106672a0 = wadlResult;
            String str7 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str4 = "2";
            } else {
                str4 = "1";
            }
            if (this.W != 0) {
                str5 = "2";
            } else {
                str5 = "1";
            }
            int h16 = h();
            if (this.f106672a0.isDownloadComplete()) {
                str6 = "2";
            } else {
                str6 = "1";
            }
            u(str7, "914835", "8", "1", str4, str5, h16, str6);
        } else if (wadlResult2.wadlParams.appId.equals(wadlResult.wadlParams.appId)) {
            if (!this.f106672a0.isDownloadComplete()) {
                this.f106672a0.update(wadlResult);
            }
        } else if (!this.f106672a0.isDownloadComplete()) {
            this.f106672a0 = wadlResult;
            String str8 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str = "2";
            } else {
                str = "1";
            }
            if (this.W != 0) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            int h17 = h();
            if (this.f106672a0.isDownloadComplete()) {
                str3 = "2";
            } else {
                str3 = "1";
            }
            u(str8, "914835", "8", "1", str, str2, h17, str3);
        }
        B();
    }

    public void e(boolean z16) {
        LayerDrawable layerDrawable = (LayerDrawable) this.H.getBackground();
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            Drawable drawable = layerDrawable.getDrawable(i3);
            if (drawable instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                int n3 = Utils.n(24.0f, BaseApplication.getContext().getResources());
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                if (z16) {
                    float f16 = n3;
                    fArr[0] = f16;
                    fArr[1] = f16;
                    fArr[2] = f16;
                    fArr[3] = f16;
                    fArr[4] = f16;
                    fArr[5] = f16;
                    fArr[6] = f16;
                    fArr[7] = f16;
                } else if (this.G) {
                    float f17 = n3;
                    fArr[0] = f17;
                    fArr[1] = f17;
                    fArr[2] = 0.0f;
                    fArr[3] = 0.0f;
                    fArr[4] = 0.0f;
                    fArr[5] = 0.0f;
                    fArr[6] = f17;
                    fArr[7] = f17;
                } else {
                    fArr[0] = 0.0f;
                    fArr[1] = 0.0f;
                    float f18 = n3;
                    fArr[2] = f18;
                    fArr[3] = f18;
                    fArr[4] = f18;
                    fArr[5] = f18;
                    fArr[6] = 0.0f;
                    fArr[7] = 0.0f;
                }
                gradientDrawable.setCornerRadii(fArr);
            } else {
                QLog.w("WadlFloat_FloatBallView", 1, "[changeBgRadius] not GradientDrawable");
            }
        }
        this.H.setBackground(layerDrawable);
    }

    public void f() {
        QLog.d("WadlFloat_FloatBallView", 1, "[expand] expand icon");
        this.f106673b0.removeMessages(2);
        this.f106673b0.sendEmptyMessage(2);
    }

    public WadlResult g() {
        return this.f106672a0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        WindowManager.LayoutParams layoutParams;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                setMode(0);
                if (m()) {
                    this.H.setPadding(0, getPaddingTop(), f106671j0, getPaddingBottom());
                } else {
                    this.H.setPadding(f106671j0, getPaddingTop(), 0, getPaddingBottom());
                }
                z(false);
                x(2000);
            }
        } else {
            setMode(1);
            if (this.G) {
                this.H.setPadding(0, getPaddingTop(), f106671j0, getPaddingBottom());
            } else {
                this.H.setPadding(f106671j0, getPaddingTop(), 0, getPaddingBottom());
            }
            if (message.arg1 == 1) {
                z(true);
            } else {
                this.f106673b0.removeMessages(1);
                ValueAnimator valueAnimator = this.T;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                if (!i.b() || !isAttachedToWindow() || (layoutParams = (WindowManager.LayoutParams) getLayoutParams()) == null) {
                    return false;
                }
                int i16 = f106668g0;
                int i17 = i16 - (i16 - f106669h0);
                layoutParams.width = i17;
                if (this.G) {
                    layoutParams.x = this.f106675d - i17;
                }
                QLog.d("WadlFloat_FloatBallView", 1, "initFloatBallView update view width:" + layoutParams.width);
                ll0.a aVar = this.f106674c0;
                if (aVar != null) {
                    aVar.a(this, layoutParams);
                }
            }
        }
        return false;
    }

    public int i() {
        ll0.a aVar = this.f106674c0;
        if (aVar != null) {
            return aVar.e().size();
        }
        return 0;
    }

    public boolean m() {
        return this.G;
    }

    public void o() {
        String str;
        String str2;
        String str3;
        QLog.d("WadlFloat_FloatBallView", 1, "[onSelfClick] onSelfClick:" + this.W);
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult != null) {
            if (wadlResult.isDownloadComplete()) {
                WadlResult wadlResult2 = this.f106672a0;
                WadlParams wadlParams = wadlResult2.wadlParams;
                GameCenterUtil.goToInstallWithJump(wadlParams.appId, wadlParams.packageName, wadlResult2.downloadFilePath, wadlParams.sourceId, GameCenterUtil.INSTALL_FROM_FLOAT_BALL, false);
                String str4 = this.f106672a0.wadlParams.appId;
                if (i() > 1) {
                    str = "2";
                } else {
                    str = "1";
                }
                if (this.W != 0) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                if (this.f106672a0.isDownloadComplete()) {
                    str3 = "2";
                } else {
                    str3 = "1";
                }
                u(str4, "914836", "20", "1", str, str2, 4, str3);
                return;
            }
            if (this.f106672a0.isTaskPaused()) {
                w();
                QQToast.makeText(MobileQQ.sMobileQQ, 0, "\u6062\u590d\u4e0b\u8f7d\u6210\u529f\uff01", 1).show();
            }
        }
        j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ynv) {
            o();
        } else if (id5 == R.id.tzg) {
            n();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void r(int i3, int i16, int i17) {
        if (!isAttachedToWindow()) {
            return;
        }
        this.f106675d = i3;
        this.f106677e = i16;
        this.V = i16 - f106670i0;
        QLog.d("WadlFloat_FloatBallView", 2, "[onOrientationChanged] screenWidth:" + this.f106675d + ",screenHeight:" + this.f106677e);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i17 == 2) {
            layoutParams.y = this.f106677e / 6;
        } else if (i17 == 1) {
            layoutParams.y = this.f106677e / 3;
        }
        if (this.f106677e - layoutParams.y < f106670i0) {
            layoutParams.y = 0;
        }
        x(0);
    }

    public void setMode(int i3) {
        QLog.d("WadlFloat_FloatBallView", 1, "[setMode] mCurrentMode:" + i3);
        this.W = i3;
    }

    public void t(String str) {
        WadlResult wadlResult;
        if (!TextUtils.isEmpty(str) && (wadlResult = this.f106672a0) != null && str.equals(wadlResult.wadlParams.appId)) {
            this.f106672a0 = null;
        }
    }

    public void u(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setGameAppId(str).setOperId(str2).setExt(4, str3).setExt(2, str4).setExt(6, str5).setExt(29, str6).setExt(49, str7).setRetId(i3);
        wadlReportBuilder.report();
    }

    public void v() {
        String str;
        String str2;
        String str3;
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult != null) {
            String str4 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str = "2";
            } else {
                str = "1";
            }
            if (this.W != 0) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            int h16 = h();
            if (this.f106672a0.isDownloadComplete()) {
                str3 = "2";
            } else {
                str3 = "1";
            }
            u(str4, "915131", "8", "1", str, str2, h16, str3);
        }
    }

    public void x(int i3) {
        QLog.d("WadlFloat_FloatBallView", 1, "[shrink] shrink icon delay=" + i3);
        this.f106673b0.removeMessages(1);
        Message obtainMessage = this.f106673b0.obtainMessage(1);
        if (i3 > 0) {
            obtainMessage.arg1 = 1;
            this.f106673b0.sendMessageDelayed(obtainMessage, i3);
        } else {
            obtainMessage.arg1 = 0;
            this.f106673b0.sendMessage(obtainMessage);
        }
    }

    public void z(boolean z16) {
        String str;
        String str2;
        String str3;
        WadlResult wadlResult = this.f106672a0;
        if (wadlResult != null) {
            String str4 = wadlResult.wadlParams.appId;
            if (i() > 1) {
                str = "2";
            } else {
                str = "1";
            }
            if (z16) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            int h16 = h();
            if (this.f106672a0.isDownloadComplete()) {
                str3 = "2";
            } else {
                str3 = "1";
            }
            u(str4, "914835", "8", "1", str, str2, h16, str3);
        }
        int i3 = !z16 ? 1 : 0;
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, z16 ? 1.0f : 0.0f);
        this.T = ofFloat;
        ofFloat.setDuration(200L);
        this.T.addUpdateListener(new b());
        if (z16) {
            this.T.addListener(new c());
        }
        this.T.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("WadlFloat_FloatBallView", 1, "startAnimation onAnimationEnd");
            FloatBallView.this.e(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
