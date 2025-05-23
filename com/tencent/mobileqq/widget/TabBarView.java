package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabBarView extends LinearLayout {

    /* renamed from: c0, reason: collision with root package name */
    protected static int f316333c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int f316334d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f316335e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f316336f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final int f316337g0;
    protected int C;
    public int D;
    public int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    private int M;
    public final Paint N;
    protected float P;
    protected int Q;
    protected int R;
    protected LinearLayout.LayoutParams S;
    protected List<RedDotTextView> T;
    protected List<LinearLayout> U;
    protected List<String> V;
    protected String[] W;

    /* renamed from: a0, reason: collision with root package name */
    protected long f316338a0;

    /* renamed from: b0, reason: collision with root package name */
    Paint f316339b0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f316340d;

    /* renamed from: e, reason: collision with root package name */
    public d f316341e;

    /* renamed from: f, reason: collision with root package name */
    protected int f316342f;

    /* renamed from: h, reason: collision with root package name */
    protected int f316343h;

    /* renamed from: i, reason: collision with root package name */
    protected int f316344i;

    /* renamed from: m, reason: collision with root package name */
    public int f316345m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f316346d;

        a(int i3) {
            this.f316346d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            TabBarView tabBarView = TabBarView.this;
            if (currentTimeMillis - tabBarView.f316338a0 >= 500) {
                tabBarView.f316338a0 = currentTimeMillis;
                tabBarView.setSelectedTab(this.f316346d, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f316348d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f316349e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f316350f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f316351h;

        b(int i3, int i16, int i17, int i18) {
            this.f316348d = i3;
            this.f316349e = i16;
            this.f316350f = i17;
            this.f316351h = i18;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TabBarView tabBarView = TabBarView.this;
            int i3 = this.f316348d;
            tabBarView.K = i3 + (((this.f316349e - i3) * intValue) / 100);
            int i16 = this.f316350f;
            tabBarView.L = i16 + (((this.f316351h - i16) * intValue) / 100);
            if (intValue == 100) {
                tabBarView.j();
            }
            TabBarView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TabBarView tabBarView = TabBarView.this;
            tabBarView.P = (intValue * 1.0f) / 100.0f;
            if (intValue == 100) {
                tabBarView.j();
            }
            TabBarView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void a(int i3, int i16);
    }

    static {
        BaseApplication context = BaseApplication.getContext();
        f316334d0 = (int) ((context.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
        f316335e0 = (int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f);
        f316336f0 = 10;
        f316337g0 = 14;
    }

    public TabBarView(Context context) {
        this(context, null);
    }

    private void l(Canvas canvas) {
        View childAt;
        View childAt2 = getChildAt(this.R);
        if (childAt2 != null) {
            RedDotTextView redDotTextView = this.T.get(this.R);
            this.f316339b0.setTextSize((this.J * getContext().getResources().getDisplayMetrics().density) + 0.5f);
            float measureText = this.f316339b0.measureText(this.V.get(this.R).toString());
            int right = (int) (((childAt2.getRight() - childAt2.getLeft()) - measureText) / 2.0f);
            int i3 = (int) (right + measureText);
            if (redDotTextView != null) {
                int left = (childAt2.getLeft() + right) - this.f316344i;
                int left2 = childAt2.getLeft() + i3 + this.f316344i;
                if (this.P > 0.0f && (childAt = getChildAt(this.Q)) != null) {
                    int right2 = (int) (((childAt.getRight() - childAt.getLeft()) - this.f316339b0.measureText(this.V.get(this.Q).toString())) / 2.0f);
                    left = (int) (left + (this.P * (((childAt.getLeft() + right2) - this.f316344i) - left)));
                    left2 = (int) (left2 + (this.P * (((childAt.getLeft() + ((int) (right2 + r3))) + this.f316344i) - left2)));
                }
                canvas.drawRect(left, getHeight() - this.f316343h, left2, getHeight(), this.N);
            }
        }
    }

    private void r(int i3, int i16) {
        d dVar = this.f316341e;
        if (dVar != null) {
            dVar.a(i3, i16);
        }
    }

    private void v() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RedDotTextView o16 = o(i3);
            if (o16 != null) {
                boolean z16 = true;
                o16.setImportantForAccessibility(1);
                CharSequence text = o16.getText();
                if (this.R != i3) {
                    z16 = false;
                }
                AccessibilityUtil.x(o16, text, z16, Button.class.getName());
            }
        }
    }

    private void w(int i3, int i16) {
        RedDotTextView redDotTextView;
        int i17;
        if (i3 >= 0) {
            try {
                if (i3 < this.T.size() && (redDotTextView = this.T.get(i3)) != null) {
                    redDotTextView.setTextColor(this.C);
                    if (this.D != 0 && (i17 = this.E) != 0) {
                        redDotTextView.setBackgroundResource(i17);
                    }
                }
            } catch (IndexOutOfBoundsException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TabBarView", 2, e16, new Object[0]);
                }
            }
        }
        try {
            RedDotTextView redDotTextView2 = this.T.get(i16);
            if (redDotTextView2 != null) {
                redDotTextView2.setTextColor(this.f316345m);
                int i18 = this.D;
                if (i18 != 0) {
                    redDotTextView2.setBackgroundResource(i18);
                }
            }
        } catch (IndexOutOfBoundsException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("TabBarView", 2, e17, new Object[0]);
            }
        }
    }

    public RedDotTextView c(int i3, String str) {
        return d(i3, str, false, false, false);
    }

    public RedDotTextView d(int i3, String str, boolean z16, boolean z17, boolean z18) {
        if (QQTheme.isNowSimpleUI()) {
            return g(i3, str);
        }
        return f(i3, str, z16, z17, z18);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        s(canvas);
        super.dispatchDraw(canvas);
    }

    public RedDotTextView e(String str) {
        return c(getChildCount(), str);
    }

    protected RedDotTextView f(int i3, String str, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        if (i3 >= 0 && i3 <= getChildCount()) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            RedDotTextView redDotTextView = new RedDotTextView(getContext());
            redDotTextView.setText(str);
            redDotTextView.setTextSize(2, this.J);
            redDotTextView.setTextColor(this.C);
            redDotTextView.setPadding(this.F, this.H, this.G, this.I);
            redDotTextView.setSingleLine();
            redDotTextView.setFocusable(true);
            redDotTextView.setGravity(17);
            u(i3, str, redDotTextView);
            AccessibilityUtil.x(redDotTextView, str, false, Button.class.getName());
            this.T.add(redDotTextView);
            this.U.add(linearLayout);
            this.V.add(str);
            int size = this.T.size();
            HashMap hashMap = new HashMap();
            if (!z18) {
                if (z16) {
                    if (size >= 6) {
                        hashMap.put("width", Integer.valueOf((int) (((f316333c0 / getResources().getDisplayMetrics().density) / 6.0f) + 0.5f)));
                    } else {
                        hashMap.put("width", Integer.valueOf((int) (((f316333c0 / getResources().getDisplayMetrics().density) / size) + 0.5f)));
                    }
                } else {
                    if (size == 2) {
                        hashMap.put("width", Integer.valueOf((int) (((f316333c0 / getResources().getDisplayMetrics().density) / 3.0f) + 0.5f)));
                    }
                    if (size == 6) {
                        Boolean bool = Boolean.TRUE;
                        int i16 = 0;
                        for (int i17 = 0; i17 < size; i17++) {
                            int length = this.V.get(i17).toString().length();
                            if (i17 == 0) {
                                i16 = length;
                            } else if (i16 != length) {
                                bool = Boolean.FALSE;
                            }
                        }
                        if (bool.booleanValue()) {
                            hashMap.put("width", 69);
                        } else {
                            hashMap.put(NodeProps.PADDING_LEFT, 8);
                            hashMap.put(NodeProps.PADDING_RIGHT, 8);
                        }
                    }
                    if (size > 6) {
                        hashMap.put(NodeProps.PADDING_LEFT, 8);
                        hashMap.put(NodeProps.PADDING_RIGHT, 8);
                    }
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            for (int i18 = 0; i18 < size; i18++) {
                LinearLayout linearLayout2 = this.U.get(i18);
                if (hashMap.get("width") != null) {
                    layoutParams.width = (int) ((Integer.parseInt(hashMap.get("width").toString()) * getResources().getDisplayMetrics().density) + 0.5f);
                } else if (hashMap.get(NodeProps.PADDING_LEFT) != null && hashMap.get(NodeProps.PADDING_RIGHT) != null) {
                    int parseInt = (int) ((Integer.parseInt(hashMap.get(NodeProps.PADDING_LEFT).toString()) * getResources().getDisplayMetrics().density) + 0.5f);
                    int parseInt2 = (int) ((Integer.parseInt(hashMap.get(NodeProps.PADDING_RIGHT).toString()) * getResources().getDisplayMetrics().density) + 0.5f);
                    layoutParams.leftMargin = parseInt;
                    layoutParams.rightMargin = parseInt2;
                    layoutParams.width = -2;
                } else {
                    if (z18 && !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape(getContext())) {
                        int i19 = (int) (((this.J + (this.f316344i * 2)) * getResources().getDisplayMetrics().density) + 0.5f);
                        layoutParams.leftMargin = i19;
                        layoutParams.rightMargin = i19;
                        layoutParams.width = -2;
                    } else {
                        layoutParams.weight = 1.0f;
                    }
                    if (!z17 && size == 2) {
                        if (i18 == 0) {
                            layoutParams.gravity = 21;
                            linearLayout2.setLayoutParams(layoutParams);
                            linearLayout2.setGravity(21);
                            z19 = false;
                            linearLayout2.setPadding(0, 0, 50, 0);
                        } else {
                            z19 = false;
                            if (i18 == 1) {
                                layoutParams.gravity = 19;
                                linearLayout2.setLayoutParams(layoutParams);
                                linearLayout2.setGravity(19);
                                linearLayout2.setPadding(50, 0, 0, 0);
                            }
                        }
                    } else {
                        z19 = false;
                        layoutParams.gravity = 17;
                        linearLayout2.setLayoutParams(layoutParams);
                        linearLayout2.setGravity(17);
                    }
                }
                if (!z17) {
                }
                z19 = false;
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.setGravity(17);
            }
            redDotTextView.setId(R.id.jh8);
            if (hashMap.get(NodeProps.PADDING_LEFT) != null) {
                linearLayout.addView(redDotTextView, layoutParams);
            } else {
                linearLayout.addView(redDotTextView, this.S);
            }
            if (size == 2) {
                setGravity(1);
            } else {
                setGravity(8388627);
            }
            addView(linearLayout, i3);
            return redDotTextView;
        }
        throw new IllegalArgumentException("position is not legal, please check!");
    }

    public RedDotTextView g(int i3, String str) {
        QLog.d("TabBarView", 1, "addTabForSimple");
        if (i3 >= 0 && i3 <= getChildCount()) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            RedDotTextView redDotTextView = new RedDotTextView(getContext());
            redDotTextView.setText(str);
            redDotTextView.setTextSize(2, this.J);
            redDotTextView.setTextColor(this.C);
            redDotTextView.setSingleLine();
            redDotTextView.setFocusable(true);
            redDotTextView.setGravity(17);
            u(i3, str, redDotTextView);
            AccessibilityUtil.x(redDotTextView, str, false, Button.class.getName());
            this.T.add(redDotTextView);
            this.U.add(linearLayout);
            this.V.add(str);
            this.T.size();
            redDotTextView.setId(R.id.jh8);
            linearLayout.addView(redDotTextView, new LinearLayout.LayoutParams(-2, -1));
            linearLayout.setGravity(16);
            setGravity(8388627);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (this.T.size() == 1) {
                layoutParams.leftMargin = p();
            }
            layoutParams.rightMargin = p();
            addView(linearLayout, i3, layoutParams);
            return redDotTextView;
        }
        throw new IllegalArgumentException("position is not legal, please check!");
    }

    protected void h() {
        if (this.R != this.Q) {
            this.P = 0.0f;
            ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
            ofInt.setDuration(100L);
            ofInt.addUpdateListener(new c());
            ofInt.start();
        }
    }

    protected void i() {
        int i3 = this.R;
        if (i3 != this.Q) {
            int i16 = q(i3)[0];
            int i17 = q(this.Q)[0];
            int i18 = q(this.R)[2];
            int i19 = q(this.Q)[2];
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
            ofInt.setDuration(100L);
            ofInt.addUpdateListener(new b(i16, i17, i18, i19));
            ofInt.start();
        }
    }

    protected void j() {
        r(this.R, this.Q);
        w(this.R, this.Q);
        this.R = this.Q;
        v();
    }

    public void k() {
        this.R = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Canvas canvas, Paint paint, int i3) {
        paint.setColor(i3);
        paint.setAlpha(255);
        int[] q16 = q(this.R);
        int[] q17 = q(this.Q);
        int i16 = q16[0];
        int i17 = q16[2];
        int i18 = this.K;
        if (i18 > 0) {
            i16 = i18;
        }
        int i19 = this.L;
        if (i19 > 0) {
            i17 = i19;
        }
        int i26 = q17[1];
        int i27 = q17[3];
        if (QLog.isColorLevel()) {
            QLog.d("TabBarView", 2, "letf is " + i16 + " right is " + i17 + " top is " + i26 + " bottom is " + i27);
        }
        canvas.drawRect(i16, i26, i17, i27, paint);
    }

    public int n() {
        return this.R;
    }

    public RedDotTextView o(int i3) {
        View childAt = getChildAt(i3);
        if (childAt == null) {
            return null;
        }
        View findViewById = childAt.findViewById(R.id.jh8);
        if (!(findViewById instanceof RedDotTextView)) {
            return null;
        }
        return (RedDotTextView) findViewById;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f316342f, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.f316342f);
    }

    protected int p() {
        this.f316339b0.setTextSize((this.J * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        String[] strArr = this.W;
        if (strArr != null && strArr.length != 1) {
            int i3 = 0;
            for (String str : strArr) {
                i3 = (int) (i3 + this.f316339b0.measureText(str));
            }
            int screenWidth = (ViewUtils.getScreenWidth() - i3) / (this.W.length + 1);
            QLog.d("TabBarView", 1, "gap is " + screenWidth);
            int i16 = this.M;
            if (screenWidth >= i16) {
                return screenWidth;
            }
            return i16;
        }
        return this.M;
    }

    protected int[] q(int i3) {
        View childAt = getChildAt(i3);
        if (childAt == null) {
            return new int[]{0, 0, 0, 0};
        }
        int left = childAt.getLeft();
        int right = childAt.getRight();
        int height = childAt.getHeight();
        if (height == 0) {
            return new int[]{0, 0, 0, 0};
        }
        this.f316339b0.setTextSize((this.J * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        String str = this.V.get(i3);
        Rect rect = new Rect();
        this.f316339b0.getTextBounds(str, 0, str.length(), rect);
        int i16 = (right + left) / 2;
        int width = rect.width() / 2;
        int dpToPx = (height / 2) + (ViewUtils.dpToPx(this.J) / 2) + ViewUtils.dpToPx(5.0f);
        return new int[]{i16 - width, dpToPx, i16 + width, ViewUtils.dpToPx(2.0f) + dpToPx};
    }

    protected void s(Canvas canvas) {
        if (QQTheme.isNowSimpleUI()) {
            m(canvas, this.N, this.f316345m);
        } else {
            l(canvas);
        }
    }

    public void setEnableRepeatedClick(boolean z16) {
        this.f316340d = z16;
    }

    public void setOnTabChangeListener(d dVar) {
        this.f316341e = dVar;
    }

    public void setSelectBgRes(int i3) {
        this.D = i3;
    }

    public void setSelectColor(int i3) {
        this.f316345m = i3;
        this.N.setColor(i3);
    }

    public void setSelectedTab(int i3, boolean z16, boolean z17) {
        if (i3 < 0) {
            i3 = 0;
        }
        int childCount = getChildCount();
        if (i3 >= childCount) {
            i3 = childCount - 1;
        }
        int i16 = this.R;
        if (i16 != i3) {
            if (i16 == -1) {
                z16 = false;
            }
            if (z16) {
                this.Q = i3;
                if (QQTheme.isNowSimpleUI()) {
                    i();
                } else {
                    h();
                }
            } else {
                if (z17) {
                    r(i16, i3);
                }
                this.Q = i3;
                this.K = q(i3)[0];
                this.L = q(i3)[2];
                this.P = 1.0f;
                w(this.R, i3);
                invalidate();
                this.R = i3;
            }
            v();
            return;
        }
        if (this.f316340d && z17) {
            r(i16, i16);
        }
    }

    public void setTabHeight(int i3) {
        this.f316342f = i3;
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.S = layoutParams;
    }

    public void setTabTextSize(int i3) {
        this.J = i3;
    }

    public void setTabTitleList(String[] strArr) {
        this.W = strArr;
    }

    public void setTextPadding(int i3, int i16, int i17, int i18) {
        this.F = i3;
        this.H = i16;
        this.G = i17;
        this.I = i18;
    }

    public void setUnSelectBgRes(int i3) {
        this.E = i3;
    }

    public void setUnderLineHeight(int i3) {
        this.f316343h = i3;
    }

    public void setUnderLineMargin(int i3) {
        this.f316344i = i3;
    }

    public void setUnselectColor(int i3) {
        this.C = i3;
    }

    public void t(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.T.remove(i3);
            this.U.remove(i3);
            this.V.remove(i3);
            removeViewAt(i3);
            return;
        }
        throw new IllegalArgumentException("index is not legal, please check!");
    }

    protected void u(int i3, String str, RedDotTextView redDotTextView) {
        if (!TextUtils.isEmpty(str)) {
            redDotTextView.setOnClickListener(new a(i3));
        }
    }

    public void x() {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        this.f316345m = resources.getColor(R.color.qui_common_brand_standard, null);
        this.C = resources.getColor(R.color.qui_common_text_primary, null);
        this.N.setColor(this.f316345m);
        setBackground(resources.getDrawable(R.drawable.qui_common_bg_bottom_light_bg, null));
        postInvalidate();
    }

    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316340d = false;
        this.M = 0;
        this.Q = -1;
        this.R = -1;
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.f316338a0 = 0L;
        this.f316339b0 = new Paint();
        this.f316342f = f316334d0;
        this.f316343h = f316335e0;
        this.J = f316337g0;
        this.f316345m = context.getResources().getColor(R.color.skin_blue);
        this.C = context.getResources().getColor(R.color.skin_black);
        this.M = com.tencent.mobileqq.util.x.c(context, 20.0f);
        Paint paint = new Paint();
        this.N = paint;
        paint.setColor(this.f316345m);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        this.S = layoutParams;
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        setBackgroundDrawable(getResources().getDrawable(R.drawable.skin_tabbar_bg));
        if (f316333c0 == 0) {
            f316333c0 = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        }
    }

    public void setSelectedTab(int i3, boolean z16) {
        setSelectedTab(i3, z16, true);
    }
}
