package com.tencent.mobileqq.vasgift.mvvm.business.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.RegionDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vasgift.countdown.CountDownController;
import com.tencent.mobileqq.vasgift.countdown.CountDownInfo;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.vasgift.utils.i;
import com.tencent.mobileqq.vasgift.view.QQGiftCircleProgress;
import com.tencent.mobileqq.vasgift.view.anim.h;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;

/* loaded from: classes20.dex */
public class QQGiftPanelItemViewImpl extends FrameLayout implements sh2.b {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private QQGiftCircleProgress G;
    private ImageView H;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private RelativeLayout L;
    private boolean M;
    public Drawable N;
    private QQGiftPanelViewModel P;
    private RelativeLayout Q;
    private com.tencent.mobileqq.qqgift.data.service.d R;
    private h S;
    private int T;
    private Drawable U;
    private d.a V;
    private final Observer<com.tencent.mobileqq.vasgift.countdown.a> W;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f311905d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f311906e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f311907f;

    /* renamed from: h, reason: collision with root package name */
    private RoundImageView f311908h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f311909i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f311910m;

    /* loaded from: classes20.dex */
    class a implements Observer<com.tencent.mobileqq.vasgift.countdown.a> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.vasgift.countdown.a aVar) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelItemViewImpl", 2, "[onChanged] timerInfo" + hashCode());
            }
            if (!e43.a.e(QQGiftPanelItemViewImpl.this.R)) {
                QQGiftPanelItemViewImpl.this.J(false);
                return;
            }
            try {
                CountDownInfo countDownInfo = e43.a.d().c(QQGiftPanelItemViewImpl.this.P.H2().getSDKConfig().f264972a + "").m().get(QQGiftPanelItemViewImpl.this.R.f264874d + "");
                if (countDownInfo == null) {
                    QQGiftPanelItemViewImpl.this.J(false);
                } else {
                    QQGiftPanelItemViewImpl.this.H(countDownInfo, i.a(countDownInfo.remainTime * 1000));
                }
            } catch (Exception e16) {
                QLog.e("QQGiftPanelItemViewImpl", 1, e16, new Object[0]);
            }
        }
    }

    public QQGiftPanelItemViewImpl(@NonNull Context context) {
        this(context, null);
    }

    private boolean A(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        CountDownInfo countDownInfo;
        CountDownController c16 = e43.a.d().c(this.P.H2().getSDKConfig().f264972a + "");
        if (c16 != null && dVar != null) {
            countDownInfo = c16.m().get(dVar.f264874d + "");
        } else {
            countDownInfo = null;
        }
        if (countDownInfo != null) {
            return true;
        }
        return false;
    }

    private boolean B() {
        if (!C()) {
            return false;
        }
        if (this.P.H2().getSDKConfig().f264972a != 10011 && this.P.H2().getSDKConfig().f264972a != 10008) {
            return false;
        }
        return true;
    }

    private boolean C() {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.P;
        if (qQGiftPanelViewModel != null && qQGiftPanelViewModel.H2() != null && this.P.H2().getSDKConfig() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(k kVar) {
        kVar.y(1);
        kVar.I(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        dVar.d(this.V);
        return null;
    }

    private void G(View view) {
        try {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 0.9f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 0.9f, 1.0f));
            ofPropertyValuesHolder.setDuration(200L);
            ofPropertyValuesHolder.start();
        } catch (Throwable th5) {
            QLog.e("QQGiftPanelItemViewImpl", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(CountDownInfo countDownInfo, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPanelItemViewImpl", 2, "[refreshCountDownProgress] progress" + this.G.d());
        }
        J(true);
        if (this.G.d() == 0.0f) {
            s();
            float calProgress = countDownInfo.calProgress(countDownInfo.remainTime, countDownInfo.countDownTime);
            this.G.setProgress(calProgress);
            h hVar = new h(this.G, countDownInfo.countDownTime, calProgress);
            this.S = hVar;
            hVar.b();
        }
        this.F.setText(str);
    }

    private void I(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        try {
            QQGiftPanelViewModel qQGiftPanelViewModel = this.P;
            if (qQGiftPanelViewModel != null) {
                qQGiftPanelViewModel.B2().r(dVar, i3, this.f311905d, this.f311910m);
            }
        } catch (Exception e16) {
            QLog.e("QQGiftPanelItemViewImpl", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z16) {
        int i3;
        if (!z16) {
            s();
            this.G.setProgress(0.0f);
        }
        RelativeLayout relativeLayout = this.I;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.R;
        if (dVar != null) {
            g(dVar.f264878f, dVar.f264881h);
        }
        try {
            if (z16) {
                Object tag = this.H.getTag();
                if (tag != null && tag.equals(Boolean.TRUE)) {
                    return;
                }
                this.H.setTag(Boolean.TRUE);
                Drawable drawable = this.f311905d.getDrawable();
                if (!(drawable instanceof URLDrawable)) {
                    return;
                }
                Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
                if (!(currDrawable instanceof RegionDrawable)) {
                    return;
                }
                this.H.setImageBitmap(BaseImageUtil.gaussionBlur(getContext(), ((RegionDrawable) currDrawable).getBitmap(), 0.25f, 20.0f));
                return;
            }
            this.H.setTag(Boolean.FALSE);
            this.H.setImageBitmap(null);
        } catch (Throwable th5) {
            QLog.d("QQGiftPanelItemViewImpl", 1, "send_combo:  free_gauss error," + th5.getMessage());
        }
    }

    private void K() {
        if (C()) {
            CountDownController c16 = e43.a.d().c(this.P.H2().getSDKConfig().f264972a + "");
            if (c16 != null) {
                MutableLiveData<com.tencent.mobileqq.vasgift.countdown.a> o16 = c16.o();
                if (o16 != null) {
                    o16.removeObserver(this.W);
                    return;
                }
                return;
            }
            QLog.e("QQGiftPanelItemViewImpl", 1, "[onDetachedFromWindow] countDownCtrl is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        boolean z16;
        if (this.M) {
            int dip2px = ViewUtils.dip2px(10.0f);
            this.f311906e.setPadding(dip2px, dip2px, dip2px, dip2px);
            this.f311906e.setImageDrawable(this.U);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("send_combo: switch,");
            sb5.append(this.R.f264876e);
            sb5.append(",");
            sb5.append(this.M);
            sb5.append(",");
            if (this.U != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QQGiftPanelItemViewImpl", 2, sb5.toString());
        }
    }

    private void r() {
        if (C()) {
            CountDownController c16 = e43.a.d().c(this.P.H2().getSDKConfig().f264972a + "");
            if (c16 != null) {
                MutableLiveData<com.tencent.mobileqq.vasgift.countdown.a> o16 = c16.o();
                if (o16 != null) {
                    FragmentActivity fragmentActivity = (FragmentActivity) getContext();
                    o16.removeObserver(this.W);
                    o16.observe(fragmentActivity, this.W);
                    return;
                }
                return;
            }
            QLog.e("QQGiftPanelItemViewImpl", 1, "[onAttachedToWindow] countDownCtrl is null");
        }
    }

    private void s() {
        h hVar = this.S;
        if (hVar != null) {
            hVar.a();
        }
    }

    private void t(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        try {
            this.P.v2().u0(dVar, i3);
        } catch (Exception e16) {
            QLog.e("QQGiftPanelItemViewImpl", 1, e16, new Object[0]);
        }
    }

    private FastDynamicDrawable u(String str, String str2, a.c cVar) {
        if (!TextUtils.isEmpty(str2) && this.T != 0) {
            File file = new File(QQVasUpdateBusiness.getVasRootDir() + AegisLogger.GIFT + File.separator + ("qqgift." + this.T + ".panel.zip"), str2);
            if (file.exists()) {
                return com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(file.getAbsolutePath()).g(cVar).a();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).l(VasDynamicDrawableCache.INSTANCE).g(cVar).a();
        }
        return null;
    }

    private String v(d.b bVar) {
        return w(bVar.f264890b) + new SimpleDateFormat("MM-dd").format(new Date(bVar.f264889a * 1000)).replace("-", "\u6708") + "\u65e5\u8fc7\u671f";
    }

    private String w(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (j3 < 10000) {
            return j3 + "\u4e2a";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return decimalFormat.format(j3 / 10000.0d).replace(".00", "") + "\u4e07\u4e2a";
        }
        return decimalFormat.format(j3 / 1.0E8d).replace(".00", "") + "\u4ebf\u4e2a";
    }

    private String x(d.b bVar) {
        return new SimpleDateFormat("MM/dd HH:mm").format(new Date(bVar.f264889a * 1000)) + "\u8fc7\u671f";
    }

    private void y(Context context) {
        ViewGroup.LayoutParams layoutParams;
        View.inflate(context, R.layout.f168908h91, this);
        this.Q = (RelativeLayout) findViewById(R.id.f759440b);
        this.f311905d = (ImageView) findViewById(R.id.y3p);
        this.f311906e = (ImageView) findViewById(R.id.y3q);
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.y3o);
        this.f311908h = roundImageView;
        if (roundImageView != null) {
            roundImageView.setmRadius(ViewUtils.dip2px(8.0f), true);
        }
        this.f311907f = (ImageView) findViewById(R.id.y3r);
        this.f311909i = (TextView) findViewById(R.id.f108266cn);
        this.f311910m = (TextView) findViewById(R.id.f108286cp);
        this.C = (TextView) findViewById(R.id.f108246cl);
        this.D = (TextView) findViewById(R.id.f108296cq);
        this.E = (TextView) findViewById(R.id.f108256cm);
        this.K = (RelativeLayout) findViewById(R.id.f75723zq);
        this.J = (RelativeLayout) findViewById(R.id.f75743zs);
        this.L = (RelativeLayout) findViewById(R.id.f75733zr);
        z();
        this.N = com.tencent.mobileqq.vasgift.utils.d.b(getContext());
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f75703zo);
        if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(getContext()) && frameLayout != null && (layoutParams = frameLayout.getLayoutParams()) != null) {
            layoutParams.width = ImmersiveUtils.dpToPx(103.0f);
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private void z() {
        this.I = (RelativeLayout) findViewById(R.id.f75523z7);
        this.H = (ImageView) findViewById(R.id.y3g);
        QQGiftCircleProgress qQGiftCircleProgress = (QQGiftCircleProgress) findViewById(R.id.f28570ja);
        this.G = qQGiftCircleProgress;
        qQGiftCircleProgress.setBgAndProgressColor(0, getResources().getColor(R.color.ajr), 100, getResources().getColor(R.color.f157843ch0));
        this.G.setmShadowColor(0);
        this.G.setStrokeWidth(2.0f);
        this.G.setProgress(0.0f);
        TextView textView = (TextView) findViewById(R.id.f107066_e);
        this.F = textView;
        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.f161937l15));
        J(false);
    }

    @Override // sh2.b
    public void b(boolean z16, com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
        int[] iArr;
        this.f311909i.setTextColor(bVar.f264954b);
        this.C.setTextColor(bVar.f264955c);
        if (z16 && B()) {
            this.E.setTextColor(getContext().getColor(R.color.f158017al3));
        } else {
            int i3 = bVar.f264956d;
            int i16 = bVar.f264962j;
            if (i3 != i16) {
                i3 = i16;
            }
            this.E.setTextColor(i3);
        }
        ((GradientDrawable) this.f311910m.getBackground()).setColor(bVar.f264956d);
        ((GradientDrawable) this.L.getBackground()).setColor(bVar.f264953a);
        ((GradientDrawable) this.L.getBackground()).setStroke(ViewUtils.dip2px(1.0f), bVar.f264956d);
        if (bVar.f264958f) {
            iArr = new int[]{Color.parseColor("#00000000"), Color.parseColor("#FF000000")};
        } else {
            iArr = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#FFFFFFFF")};
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(iArr);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        this.E.setBackgroundDrawable(gradientDrawable);
    }

    @Override // sh2.b
    public void c(String str, long j3, d.b bVar) {
        String w3;
        String str2;
        String v3;
        try {
            TextView textView = this.E;
            if (B()) {
                w3 = str;
            } else {
                w3 = w(j3);
            }
            textView.setText(w3);
            TextView textView2 = this.E;
            if (!B()) {
                str = w(j3);
            }
            textView2.setContentDescription(str);
            int i3 = 8;
            if (bVar == null) {
                this.C.setText(w(j3));
                this.D.setVisibility(8);
                return;
            }
            TextView textView3 = this.D;
            if (B()) {
                i3 = 0;
            }
            textView3.setVisibility(i3);
            TextView textView4 = this.D;
            if (j3 > 999) {
                str2 = "x999+";
            } else {
                str2 = HippyTKDListViewAdapter.X + j3;
            }
            textView4.setText(str2);
            TextView textView5 = this.C;
            if (B()) {
                v3 = x(bVar);
            } else {
                v3 = v(bVar);
            }
            textView5.setText(v3);
        } catch (Exception e16) {
            QLog.e("QQGiftPanelItemViewImpl", 1, e16, new Object[0]);
        }
    }

    @Override // sh2.b
    public void d(int i3) {
        this.T = i3;
    }

    @Override // sh2.b
    public void e(String str, int i3) {
        if (StringUtil.isEmpty(str)) {
            this.f311907f.setVisibility(8);
            return;
        }
        this.f311907f.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        if (i3 == 0) {
            this.f311907f.setScaleType(ImageView.ScaleType.FIT_START);
        } else if (i3 == 1) {
            this.f311907f.setScaleType(ImageView.ScaleType.FIT_END);
        }
        this.f311907f.setVisibility(0);
    }

    @Override // sh2.b
    public void f(String str, String str2) {
        TextView textView;
        String str3;
        if (this.M) {
            textView = this.f311910m;
        } else {
            textView = this.f311909i;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getResources().getString(R.string.f210015gz);
        }
        if (this.M) {
            str3 = str2;
        } else {
            str3 = str;
        }
        textView.setText(str3);
        if (this.M) {
            str = "\u5df2\u9009\u4e2d" + str2 + ((Object) this.f311909i.getText());
        }
        textView.setContentDescription(str);
    }

    @Override // sh2.b
    public void g(int i3, int i16) {
        TextView textView;
        String format;
        if (this.M) {
            textView = this.E;
        } else {
            textView = this.C;
        }
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.R;
        if (dVar != null && dVar.F == 1) {
            String string = getResources().getString(R.string.f209885gm);
            d.c cVar = this.R.G;
            if (cVar != null && !TextUtils.isEmpty(cVar.f264892e) && A(this.R)) {
                string = this.R.G.f264892e;
            }
            this.C.setText(string);
            this.E.setText(string);
            this.E.setContentDescription(string);
            return;
        }
        if (i16 == 2) {
            QQGiftPanelViewModel qQGiftPanelViewModel = this.P;
            if (qQGiftPanelViewModel != null && qQGiftPanelViewModel.F2() != null) {
                format = i3 + this.P.F2().f264904b;
            } else {
                format = "";
            }
        } else {
            format = String.format(getResources().getString(R.string.f209895gn), Integer.valueOf(i3));
        }
        textView.setText(format);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.graphics.drawable.Drawable] */
    @Override // sh2.b
    public void h(String str, String str2) {
        try {
            FastDynamicDrawable u16 = u(str, "staticPreviewImage.png", new a.c() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.b
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(k kVar) {
                    QQGiftPanelItemViewImpl.D(kVar);
                }
            });
            this.U = u16;
            this.f311905d.setImageDrawable(u16);
            FastDynamicDrawable u17 = u(str2, "dynamicPreviewImage.png", new a.c() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.c
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(k kVar) {
                    QQGiftPanelItemViewImpl.E(kVar);
                }
            });
            if (u17 != null) {
                u17.c0(new Function1() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit F;
                        F = QQGiftPanelItemViewImpl.this.F((com.tencent.cachedrawable.dynamicdrawable.d) obj);
                        return F;
                    }
                });
            }
            this.f311906e.setPadding(0, 0, 0, 0);
            ImageView imageView = this.f311906e;
            FastDynamicDrawable fastDynamicDrawable = u17;
            if (u17 == null) {
                fastDynamicDrawable = this.U;
            }
            imageView.setImageDrawable(fastDynamicDrawable);
            this.f311908h.setImageDrawable(null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        J(false);
        K();
        s();
    }

    @Override // sh2.b
    public void setIsSelected(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        int i16;
        boolean z16;
        int i17;
        if (dVar != null) {
            int i18 = 0;
            if (dVar.N) {
                i16 = 4;
            } else {
                i16 = 0;
            }
            setVisibility(i16);
            if (dVar.b() && A(dVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
            J(z16);
            boolean z17 = dVar.E;
            RelativeLayout relativeLayout = this.K;
            if (z17) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            relativeLayout.setVisibility(i17);
            RelativeLayout relativeLayout2 = this.J;
            if (z17) {
                i18 = 8;
            }
            relativeLayout2.setVisibility(i18);
            if (!this.M && z17) {
                G(this);
                QQGiftPanelViewModel qQGiftPanelViewModel = this.P;
                if (qQGiftPanelViewModel != null) {
                    qQGiftPanelViewModel.u0(dVar, i3);
                }
            }
            this.M = z17;
            this.R = dVar;
            I(dVar, i3);
            t(dVar, i3);
        }
    }

    public void setViewModel(QQGiftPanelViewModel qQGiftPanelViewModel) {
        this.P = qQGiftPanelViewModel;
    }

    public QQGiftPanelItemViewImpl(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QQGiftPanelItemViewImpl(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.V = new b(this);
        this.W = new a();
        y(context);
    }

    /* loaded from: classes20.dex */
    private static class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QQGiftPanelItemViewImpl> f311912a;

        public b(QQGiftPanelItemViewImpl qQGiftPanelItemViewImpl) {
            this.f311912a = new WeakReference<>(qQGiftPanelItemViewImpl);
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onEnd() {
            QQGiftPanelItemViewImpl qQGiftPanelItemViewImpl = this.f311912a.get();
            if (qQGiftPanelItemViewImpl != null) {
                qQGiftPanelItemViewImpl.q();
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(k kVar) {
    }

    @Override // sh2.b
    public void a(int i3) {
    }
}
