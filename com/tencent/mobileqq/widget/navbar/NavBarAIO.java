package com.tencent.mobileqq.widget.navbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.mutualmark.alienation.f;
import com.tencent.mobileqq.mutualmark.e;
import com.tencent.mobileqq.mutualmark.info.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.r;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NavBarAIO extends RelativeLayout implements View.OnClickListener {

    /* renamed from: k0, reason: collision with root package name */
    private static final int f317098k0 = ViewUtils.dip2px(4.0f);

    /* renamed from: l0, reason: collision with root package name */
    private static final int f317099l0 = ViewUtils.dip2px(6.0f);

    /* renamed from: m0, reason: collision with root package name */
    private static final int f317100m0 = ViewUtils.dip2px(7.0f);

    /* renamed from: n0, reason: collision with root package name */
    private static final int f317101n0 = ViewUtils.dip2px(8.0f);

    /* renamed from: o0, reason: collision with root package name */
    private static final int f317102o0 = ViewUtils.dip2px(36.0f);

    /* renamed from: p0, reason: collision with root package name */
    private static final int f317103p0 = ViewUtils.dip2px(41.0f);
    private TextView C;
    private LinearLayout D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private RelativeLayout S;
    private RelativeLayout T;
    private View U;
    private TextView V;
    private TextView W;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f317104a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f317105b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f317106c0;

    /* renamed from: d, reason: collision with root package name */
    private float f317107d;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f317108d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f317109e;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f317110e0;

    /* renamed from: f, reason: collision with root package name */
    private TextView f317111f;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f317112f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f317113g0;

    /* renamed from: h, reason: collision with root package name */
    private TextView f317114h;

    /* renamed from: h0, reason: collision with root package name */
    private RedTouch f317115h0;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f317116i;

    /* renamed from: i0, reason: collision with root package name */
    private a f317117i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f317118j0;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f317119m;

    public NavBarAIO(Context context) {
        super(context);
        this.f317118j0 = false;
        e(context);
    }

    private boolean a() {
        if (!QQTheme.isNowSimpleUI() && !this.f317118j0) {
            return false;
        }
        return true;
    }

    private int b() {
        int dip2px;
        int childCount = getChildCount();
        int i3 = -2147483647;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8 && (!a() || childAt != this.U)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                int c16 = c(layoutParams, "mLeft");
                int c17 = c(layoutParams, "mRight");
                int measuredWidth = getMeasuredWidth() / 2;
                if (c16 < measuredWidth && c17 < measuredWidth) {
                    i3 = Math.max(i3, c17);
                }
            }
        }
        if (a()) {
            int c18 = c((RelativeLayout.LayoutParams) this.f317111f.getLayoutParams(), "mRight");
            if (c18 == i3 && TextUtils.isEmpty(this.f317111f.getText())) {
                if (this.f317114h.getVisibility() == 0) {
                    int c19 = c((RelativeLayout.LayoutParams) this.f317114h.getLayoutParams(), "mRight");
                    if (c19 < c18) {
                        i3 = c19;
                    }
                } else {
                    i3 = ViewUtils.dip2px(35.0f);
                }
            }
            if (QQTheme.isNowSimpleUI()) {
                dip2px = ViewUtils.dip2px(9.0f);
            } else if (this.f317118j0) {
                dip2px = ViewUtils.dip2px(6.0f);
            } else {
                return i3;
            }
            return i3 + dip2px;
        }
        return i3;
    }

    private static int c(RelativeLayout.LayoutParams layoutParams, String str) {
        try {
            Field field = ReflectionUtil.getField("android.widget.RelativeLayout$LayoutParams", str);
            field.setAccessible(true);
            return field.getInt(layoutParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    private int d() {
        int measuredWidth = getMeasuredWidth() / 2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8 && (!a() || childAt != this.U)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                int c16 = c(layoutParams, "mLeft");
                int c17 = c(layoutParams, "mRight");
                int measuredWidth2 = getMeasuredWidth() / 2;
                if (c16 > measuredWidth2 && c17 > measuredWidth2) {
                    measuredWidth = Math.min(measuredWidth, getMeasuredWidth() - c16);
                }
            }
        }
        return measuredWidth;
    }

    private void e(Context context) {
        View.inflate(context, R.layout.it, this);
        this.f317107d = context.getResources().getDisplayMetrics().density;
        this.f317109e = ThemeUtil.isDefaultOrDIYTheme(false);
        this.f317111f = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f317114h = (TextView) findViewById(R.id.dt6);
        this.f317116i = (LinearLayout) findViewById(R.id.e89);
        this.f317119m = (ImageView) findViewById(R.id.f165972dz1);
        this.C = (TextView) findViewById(R.id.k4f);
        this.D = (LinearLayout) findViewById(R.id.jp7);
        this.E = (ImageView) findViewById(R.id.brb);
        this.F = (ImageView) findViewById(R.id.up6);
        if (AppSetting.f99565y) {
            this.E.setContentDescription(context.getResources().getString(R.string.cws));
            this.F.setContentDescription(context.getResources().getString(R.string.cws));
        }
        this.G = (ImageView) findViewById(R.id.joy);
        this.H = (ImageView) findViewById(R.id.f98515na);
        this.I = (ImageView) findViewById(R.id.joz);
        this.J = (ImageView) findViewById(R.id.f98505n_);
        this.K = (ImageView) findViewById(R.id.f166987jp0);
        this.L = (TextView) findViewById(R.id.blz);
        this.M = (TextView) findViewById(R.id.title);
        this.N = (TextView) findViewById(R.id.title_sub);
        this.P = (TextView) findViewById(R.id.mal);
        this.Q = (RelativeLayout) findViewById(R.id.dtm);
        this.R = (RelativeLayout) findViewById(R.id.ibj);
        this.S = (RelativeLayout) findViewById(R.id.ibh);
        this.T = (RelativeLayout) findViewById(R.id.f75253yg);
        this.U = findViewById(R.id.j65);
        this.V = (TextView) findViewById(R.id.k4t);
        this.W = (TextView) findViewById(R.id.k4s);
        this.f317104a0 = (ImageView) findViewById(R.id.ivTitleBtnRightCall);
        this.f317105b0 = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.f317106c0 = (ImageView) findViewById(R.id.xzf);
        this.f317108d0 = (ImageView) findViewById(R.id.f126087nt);
        this.f317113g0 = (ImageView) findViewById(R.id.f126797pq);
        this.f317112f0 = (ImageView) findViewById(R.id.i4v);
        this.f317110e0 = (ImageView) findViewById(R.id.i4w);
        this.f317115h0 = new RedTouch(context, this.f317106c0).setGravity(53).applyTo();
        setNotDefaultThemeBackground();
    }

    private boolean f() {
        if (!this.f317118j0) {
            return false;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return true;
        }
        return !((ITroopLuckyCharacterService) r0.getRuntimeService(ITroopLuckyCharacterService.class, "")).isShowInTroopGuild();
    }

    private void g(c cVar, ImageView imageView) {
        if (cVar != null && cVar.c()) {
            ColorDrawable colorDrawable = new ColorDrawable(0);
            if (!TextUtils.isEmpty(cVar.f252106v) && cVar.f252107w == 1) {
                f.m(getResources(), imageView, cVar.f252106v, colorDrawable);
            } else if (cVar.f252107w == 0) {
                h(cVar, imageView, colorDrawable);
            }
            imageView.setAlpha(cVar.a());
            imageView.setContentDescription(cVar.f252099o);
            imageView.setVisibility(0);
            float f16 = this.f317107d;
            BaseAIOUtils.h(imageView, (int) ((f16 * 5.0f) + 0.5f), (int) ((f16 * 5.0f) + 0.5f), (int) ((f16 * 5.0f) + 0.5f), (int) ((f16 * 5.0f) + 0.5f));
            return;
        }
        imageView.setVisibility(8);
    }

    private void h(c cVar, ImageView imageView, Drawable drawable) {
        if (!TextUtils.isEmpty(cVar.f252103s)) {
            if (TextUtils.isEmpty(cVar.f252102r)) {
                cVar.f252102r = cVar.f252103s;
            }
        } else {
            drawable = new e(getContext(), cVar.f252101q);
        }
        if (!TextUtils.isEmpty(cVar.f252102r)) {
            f.m(getResources(), imageView, cVar.f252102r, drawable);
            return;
        }
        imageView.setImageDrawable(null);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (drawable.getIntrinsicWidth() > 0) {
            layoutParams.width = drawable.getIntrinsicWidth();
        } else {
            layoutParams.width = -2;
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageDrawable(drawable);
    }

    private static void i(RelativeLayout.LayoutParams layoutParams, int i3, int i16, int i17, int i18) {
        j(layoutParams, "mLeft", i3);
        j(layoutParams, "mTop", i16);
        j(layoutParams, "mRight", i17);
        j(layoutParams, "mBottom", i18);
    }

    private static void j(RelativeLayout.LayoutParams layoutParams, String str, int i3) {
        try {
            Field field = ReflectionUtil.getField("android.widget.RelativeLayout$LayoutParams", str);
            field.setAccessible(true);
            field.set(layoutParams, Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.e89) {
            if (id5 == R.id.k4t) {
                i3 = 3;
            } else if (id5 == R.id.k4s) {
                i3 = 2;
            } else if (id5 == R.id.ivTitleBtnRightCall) {
                i3 = 5;
            } else if (id5 == R.id.ivTitleBtnRightImage) {
                i3 = 4;
            } else {
                i3 = 0;
            }
        } else {
            i3 = 1;
        }
        if (i3 != 0 && (aVar = this.f317117i0) != null) {
            aVar.onItemSelect(view, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = 0;
        super.onMeasure(i3, i16);
        int b16 = b();
        int d16 = d();
        int measuredWidth = (getMeasuredWidth() - b16) - d16;
        layoutParams.leftMargin = b16;
        layoutParams.rightMargin = d16;
        int dimension = ((((int) getResources().getDimension(R.dimen.title_bar_height)) - this.D.getMeasuredHeight()) - this.U.getMeasuredHeight()) / 2;
        layoutParams.topMargin = dimension;
        int measuredHeight = dimension + this.D.getMeasuredHeight();
        this.D.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        i(layoutParams, b16, layoutParams.topMargin, measuredWidth + b16, measuredHeight);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
        j(layoutParams2, "mTop", measuredHeight);
        j(layoutParams2, "mBottom", measuredHeight + this.U.getMeasuredHeight());
        if (a()) {
            layoutParams2.leftMargin = b16;
        }
    }

    public void onPostThemeChanged() {
        boolean isDefaultOrDIYTheme = ThemeUtil.isDefaultOrDIYTheme(false);
        this.f317109e = isDefaultOrDIYTheme;
        if (!isDefaultOrDIYTheme) {
            setNotDefaultThemeBackground();
        } else {
            setBackgroundResource(R.drawable.gvl);
        }
    }

    public void setEarIconVisible(boolean z16) {
        int i3 = 0;
        if (a()) {
            ImageView imageView = this.F;
            if (!z16) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            this.E.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.E;
        if (!z16) {
            i3 = 8;
        }
        imageView2.setVisibility(i3);
        this.F.setVisibility(8);
    }

    public void setIsDefaultTheme(boolean z16) {
        this.f317109e = z16;
    }

    public void setLeftContentDescription(String str) {
        this.f317116i.setContentDescription(str);
        this.f317111f.setContentDescription(str);
        if (AppSetting.f99565y && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100177", false)) {
            AccessibilityUtil.c(this.f317116i, str, null);
        }
    }

    public void setNotDefaultThemeBackground() {
        if (QQTheme.isSimpleWhite() && r.a()) {
            setBackgroundColor(0);
        } else {
            setBackgroundResource(R.drawable.skin_header_bar_bg);
        }
    }

    public void setOnSelectListener(a aVar) {
        this.f317117i0 = aVar;
        this.f317111f.setOnClickListener(this);
        this.f317116i.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.f317104a0.setOnClickListener(this);
        this.f317105b0.setOnClickListener(this);
    }

    public void setRight1(String str) {
        this.W.setText(str);
        this.W.setContentDescription(str);
        this.W.setVisibility(0);
        this.f317105b0.setVisibility(8);
        BaseAIOUtils.h(this.W, BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(4.0f, getResources()), BaseAIOUtils.f(8.0f, getResources()));
    }

    public void setRight1Icon(int i3, int i16) {
        if (this.f317109e) {
            i3 = i16;
        }
        setRight1Icon(i3);
    }

    public void setRight2(String str) {
        this.V.setText(str);
        this.V.setContentDescription(str);
        this.V.setVisibility(0);
        this.f317104a0.setVisibility(8);
        BaseAIOUtils.h(this.V, BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(8.0f, getResources()), BaseAIOUtils.f(4.0f, getResources()));
    }

    public void setRight2Icon(int i3) {
        this.f317104a0.setVisibility(0);
        this.f317104a0.setImageResource(i3);
        this.V.setVisibility(8);
        BaseAIOUtils.h(this.f317104a0, BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(8.0f, getResources()), BaseAIOUtils.f(4.0f, getResources()));
    }

    public void setRight3Icon(int i3) {
        this.f317106c0.setImageResource(i3);
        ImageView imageView = this.f317106c0;
        int i16 = f317100m0;
        BaseAIOUtils.h(imageView, i16, i16, f317101n0, f317098k0);
    }

    public void setRightIcon1Desc(String str) {
        this.f317105b0.setContentDescription(str);
    }

    public void setRightIcon2Desc(String str) {
        this.f317104a0.setContentDescription(str);
    }

    public void setRightRootVisibility(int i3) {
        RelativeLayout relativeLayout = this.Q;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    public void setRightToStr(String str, View.OnClickListener onClickListener) {
        setRight1(str);
        this.f317105b0.setBackgroundDrawable(null);
        this.f317105b0.setImageDrawable(null);
        this.W.setSingleLine();
        this.W.setTextSize(1, 17.0f);
        this.W.setTextColor(getResources().getColor(R.color.skin_bar_text));
        this.W.setOnClickListener(onClickListener);
        this.S.setVisibility(8);
        this.f317110e0.setVisibility(8);
        this.T.setVisibility(8);
        if (QLog.isDevelopLevel()) {
            QLog.d("NavBarAIO", 4, "fight_Text is setRightToStr and rw =  " + this.Q.getMeasuredWidth());
        }
    }

    public void setTitleIcon(int i3) {
        this.G.setImageResource(i3);
        this.H.setImageResource(i3);
    }

    public void setTitleIconLeft() {
        this.G.setImageResource(0);
        this.H.setImageResource(0);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setImageResource(0);
        this.J.setImageResource(0);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
    }

    public void setTitleIconLeftForMutualMark(c cVar, c cVar2) {
        g(cVar, this.G);
        g(cVar, this.H);
        g(cVar2, this.I);
        g(cVar2, this.J);
        if (a()) {
            this.G.setVisibility(8);
            this.I.setVisibility(8);
        } else {
            this.H.setVisibility(8);
            this.J.setVisibility(8);
        }
        if (f()) {
            this.G.setVisibility(8);
            this.I.setVisibility(8);
            this.H.setVisibility(8);
            this.J.setVisibility(8);
        }
    }

    public void setRight1Icon(int i3) {
        this.f317105b0.setVisibility(0);
        this.f317105b0.setImageResource(i3);
        this.W.setVisibility(8);
        BaseAIOUtils.h(this.f317105b0, BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(4.0f, getResources()), BaseAIOUtils.f(8.0f, getResources()));
    }

    public void setRight3Icon(int i3, int i16) {
        if (this.f317109e) {
            i3 = i16;
        }
        setRight3Icon(i3);
    }

    public NavBarAIO(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f317118j0 = false;
        e(context);
    }

    public NavBarAIO(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317118j0 = false;
        e(context);
    }

    public void setRight2Icon(int i3, int i16) {
        if (this.f317109e) {
            i3 = i16;
        }
        setRight2Icon(i3);
    }

    public void setRight1Icon(Drawable drawable) {
        this.f317105b0.setVisibility(0);
        this.f317105b0.setImageDrawable(drawable);
        this.W.setVisibility(8);
        BaseAIOUtils.h(this.f317105b0, BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(7.0f, getResources()), BaseAIOUtils.f(4.0f, getResources()), BaseAIOUtils.f(8.0f, getResources()));
    }
}
