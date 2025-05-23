package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomMenuNoIconLayout extends LinearLayout {
    private int C;
    private int D;
    private e E;
    private e F;
    private int G;
    private boolean H;
    private Integer I;

    /* renamed from: d, reason: collision with root package name */
    private BubblePopupWindow f307655d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.utils.dialogutils.a f307656e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f307657f;

    /* renamed from: h, reason: collision with root package name */
    private Context f307658h;

    /* renamed from: i, reason: collision with root package name */
    private int f307659i;

    /* renamed from: m, reason: collision with root package name */
    private int f307660m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements BubblePopupWindow.OnDismissListener {
        a() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            QQCustomMenuNoIconLayout.a(QQCustomMenuNoIconLayout.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f307662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f307663e;

        b(boolean z16, int i3) {
            this.f307662d = z16;
            this.f307663e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = QQCustomMenuNoIconLayout.this;
            if (this.f307662d) {
                i3 = qQCustomMenuNoIconLayout.f307659i + 1;
            } else {
                i3 = qQCustomMenuNoIconLayout.f307659i - 1;
            }
            qQCustomMenuNoIconLayout.f307659i = i3;
            qQCustomMenuNoIconLayout.E(qQCustomMenuNoIconLayout.u(i3), true);
            QQCustomMenuNoIconLayout.a(QQCustomMenuNoIconLayout.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307665d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.utils.dialogutils.b f307666e;

        c(int i3, com.tencent.mobileqq.utils.dialogutils.b bVar) {
            this.f307665d = i3;
            this.f307666e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QQCustomMenuNoIconLayout.this.f307657f != null) {
                QQCustomMenuNoIconLayout.this.f307657f.onClick(view);
            }
            QQCustomMenuNoIconLayout.this.f307655d.dismiss();
            QQCustomMenuNoIconLayout.a(QQCustomMenuNoIconLayout.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends LinearLayout {
        public e(Context context) {
            super(context);
            setOrientation(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z16) {
            int i3;
            int i16;
            View view = new View(QQCustomMenuNoIconLayout.this.f307658h);
            Resources resources = QQCustomMenuNoIconLayout.this.f307658h.getResources();
            if (z16) {
                i3 = R.color.c4y;
            } else {
                i3 = R.color.f157324c50;
            }
            view.setBackgroundColor(resources.getColor(i3));
            addView(view, new LinearLayout.LayoutParams(1, -1));
            View view2 = new View(QQCustomMenuNoIconLayout.this.f307658h);
            Resources resources2 = QQCustomMenuNoIconLayout.this.f307658h.getResources();
            if (z16) {
                i16 = R.color.c4z;
            } else {
                i16 = R.color.f157325c51;
            }
            view2.setBackgroundColor(resources2.getColor(i16));
            addView(view2, new LinearLayout.LayoutParams(1, -1));
        }

        @Override // android.view.ViewGroup, android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            view.setLayoutParams(layoutParams);
            addView(view);
        }
    }

    public QQCustomMenuNoIconLayout(Context context) {
        super(context);
        this.f307659i = 0;
        this.D = QQCustomMenuItemPriorityHelper.f307647b;
        this.G = ViewUtils.dpToPx(8.0f);
        this.H = false;
        this.I = null;
        this.f307658h = context;
        setOrientation(1);
        this.f307660m = ViewUtils.dpToPx(62.0f);
        this.C = ViewUtils.dpToPx(40.0f);
    }

    private float[] A() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, boolean z16) {
        e eVar;
        TextView i16;
        int width = getWidth();
        removeAllViews();
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        int h16 = this.f307656e.h() - i3;
        boolean z17 = true;
        int i17 = this.D;
        if (i3 != 0) {
            i17--;
        }
        int i18 = i17;
        int i19 = this.D * 2;
        if (i3 != 0) {
            i19--;
        }
        int i26 = i19;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuNoIconLayout", 2, "[menu] showMenu offset: " + i3 + " count: " + h16);
        }
        m(i3, isNowThemeIsNight, h16, i18, i26);
        if (h16 > i18 && h16 < i26 && this.F != null) {
            int i27 = i26 - h16;
            for (int i28 = 0; i28 < i27; i28++) {
                int i29 = i27 - 1;
                if (i28 == i29) {
                    i16 = i(this.f307660m, isNowThemeIsNight, p());
                } else {
                    i16 = i(this.f307660m, isNowThemeIsNight, v());
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f307660m, -1);
                layoutParams.gravity = 16;
                this.F.addView(i16, layoutParams);
                if (i28 < i29) {
                    this.F.b(isNowThemeIsNight);
                }
            }
        }
        if (i3 > 0 && h16 < i18 && (eVar = this.E) != null) {
            eVar.b(isNowThemeIsNight);
            this.E.addView(j((this.f307659i * this.D * 2) + h16 + 1, false, isNowThemeIsNight, w()), new LinearLayout.LayoutParams(this.f307660m, -1));
        }
        e eVar2 = this.E;
        if (eVar2 != null) {
            addView(eVar2, new LinearLayout.LayoutParams(-2, this.C));
        }
        if (this.F != null) {
            h(isNowThemeIsNight);
            addView(this.F, new LinearLayout.LayoutParams(-2, this.C));
        }
        if (z16) {
            int min = ((this.f307660m + 1) * Math.min(h16 + 1, this.D)) - 1;
            BubblePopupWindow bubblePopupWindow = this.f307655d;
            if (h16 < i18) {
                z17 = false;
            }
            bubblePopupWindow.updateLocationX(min, z17, width);
        }
    }

    static /* bridge */ /* synthetic */ d a(QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout) {
        qQCustomMenuNoIconLayout.getClass();
        return null;
    }

    private void h(boolean z16) {
        int i3;
        int i16;
        View view = new View(this.f307658h);
        Resources resources = this.f307658h.getResources();
        if (z16) {
            i3 = R.color.c4z;
        } else {
            i3 = R.color.f157325c51;
        }
        view.setBackgroundColor(resources.getColor(i3));
        addView(view, new LinearLayout.LayoutParams(-1, 1));
        View view2 = new View(this.f307658h);
        Resources resources2 = this.f307658h.getResources();
        if (z16) {
            i16 = R.color.c4y;
        } else {
            i16 = R.color.f157324c50;
        }
        view2.setBackgroundColor(resources2.getColor(i16));
        addView(view2, new LinearLayout.LayoutParams(-1, 1));
    }

    private TextView i(int i3, boolean z16, float[] fArr) {
        int i16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        Resources resources = this.f307658h.getResources();
        if (z16) {
            i16 = R.color.c4t;
        } else {
            i16 = R.color.c4v;
        }
        gradientDrawable.setColor(resources.getColor(i16));
        gradientDrawable.setCornerRadii(fArr);
        TextView textView = new TextView(getContext());
        textView.setText("");
        textView.setTextSize(1.0f);
        textView.setWidth(i3);
        textView.setMaxLines(1);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextColor(-1);
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setGravity(17);
        return textView;
    }

    private TextView k(int i3, com.tencent.mobileqq.utils.dialogutils.b bVar, boolean z16, float[] fArr) {
        StateListDrawable x16 = x(z16, fArr);
        String c16 = bVar.c();
        if (this.H && c16.length() > 4) {
            c16 = c16.substring(0, 3) + "\u2026";
        }
        TextView textView = new TextView(getContext());
        textView.setText(c16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(12.0f);
        textView.setMaxLines(1);
        textView.setContentDescription(bVar.c());
        textView.setId(bVar.b());
        textView.setTextColor(-855638017);
        textView.setBackgroundDrawable(x16);
        textView.setIncludeFontPadding(true);
        textView.setOnClickListener(new c(i3, bVar));
        textView.setGravity(17);
        return textView;
    }

    private void l(int i3, boolean z16, int i16, int i17, int i18, TextView textView) {
        float[] A;
        if (this.E == null) {
            this.E = new e(this.f307658h);
        }
        this.E.addView(textView, new LinearLayout.LayoutParams(this.f307660m, -1));
        if (i18 < i17 - 1) {
            if (i18 != i16 - 1) {
                this.E.b(z16);
            }
        } else if (i3 > 0) {
            this.E.b(z16);
            int i19 = this.f307659i;
            int i26 = this.D;
            int i27 = (i19 * i26 * 2) + i26;
            e eVar = this.E;
            if (i16 <= i17) {
                A = w();
            } else {
                A = A();
            }
            eVar.addView(j(i27, false, z16, A), new LinearLayout.LayoutParams(this.f307660m, -1));
        }
    }

    private void m(int i3, boolean z16, int i16, int i17, int i18) {
        for (int i19 = 0; i19 < i16; i19++) {
            TextView y16 = y(i3, z16, i16, i17, i18, i19, this.f307656e.f(i19 + i3));
            if (i19 < i17) {
                l(i3, z16, i16, i17, i19, y16);
            } else if (i19 < i18) {
                n(z16, i18, i19, y16);
            } else {
                e eVar = this.F;
                if (eVar != null) {
                    eVar.removeViewAt(eVar.getChildCount() - 1);
                    this.F.addView(j((this.f307659i + 1) * this.D * 2, true, z16, p()), new LinearLayout.LayoutParams(this.f307660m, -1));
                    return;
                }
                return;
            }
        }
    }

    private void n(boolean z16, int i3, int i16, TextView textView) {
        if (this.F == null) {
            this.F = new e(this.f307658h);
        }
        this.F.addView(textView, new LinearLayout.LayoutParams(this.f307660m, -1));
        if (i16 < i3 - 1) {
            this.F.b(z16);
        }
    }

    private float[] o() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] p() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, i3, i3, 0.0f, 0.0f};
    }

    private float[] r() {
        int i3 = this.G;
        return new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
    }

    private int s(int i3, int i16, int i17, int i18) {
        int i19 = this.f307659i;
        int i26 = this.D * i19 * 2;
        if (i18 >= i3 && ((i19 != 0 || i18 >= i16 - 1) && (i19 != 0 || i18 != i16 - 1 || i17 != i16))) {
            return i26 + i18 + 2;
        }
        return i26 + i18 + 1;
    }

    private float[] t() {
        int i3 = this.G;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] v() {
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] w() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, i3, i3, i3, i3, 0.0f, 0.0f};
    }

    @NotNull
    private StateListDrawable x(boolean z16, float[] fArr) {
        int i3;
        int i16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        Resources resources = this.f307658h.getResources();
        if (z16) {
            i3 = R.color.c4t;
        } else {
            i3 = R.color.c4v;
        }
        gradientDrawable.setColor(resources.getColor(i3));
        gradientDrawable.setCornerRadii(fArr);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        Resources resources2 = this.f307658h.getResources();
        if (z16) {
            i16 = R.color.c4u;
        } else {
            i16 = R.color.c4w;
        }
        gradientDrawable2.setColor(resources2.getColor(i16));
        gradientDrawable2.setCornerRadii(fArr);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(400);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @NotNull
    private TextView y(int i3, boolean z16, int i16, int i17, int i18, int i19, com.tencent.mobileqq.utils.dialogutils.b bVar) {
        float[] A;
        float[] z17;
        int s16 = s(i17, i18, i16, i19);
        if (i19 == 0) {
            if (i3 == 0 && i16 == 1) {
                z17 = r();
            } else if (i16 <= i17) {
                z17 = t();
            } else {
                z17 = z();
            }
            return k(s16, bVar, z16, z17);
        }
        if ((i3 == 0 && i19 == i17 - 1) || (i3 == 0 && i16 < i17 && i19 == i16 - 1)) {
            if (i16 <= i17) {
                A = w();
            } else {
                A = A();
            }
            return k(s16, bVar, z16, A);
        }
        if (i19 == i17) {
            return k(s16, bVar, z16, o());
        }
        if (i19 == i18 - 1) {
            return k(s16, bVar, z16, p());
        }
        return k(s16, bVar, z16, v());
    }

    private float[] z() {
        int i3 = this.G;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public boolean B() {
        return this.H;
    }

    public boolean C() {
        if (this.f307656e.h() >= this.D) {
            return true;
        }
        return false;
    }

    public void D() {
        E(0, false);
    }

    protected ImageView j(int i3, boolean z16, boolean z17, float[] fArr) {
        int i16;
        int i17;
        StateListDrawable x16 = x(z17, fArr);
        ImageView imageView = new ImageView(getContext());
        if (z16) {
            i16 = R.drawable.mou;
        } else {
            i16 = R.drawable.mov;
        }
        imageView.setImageResource(i16);
        if (z16) {
            i17 = R.string.qnw;
        } else {
            i17 = R.string.qnx;
        }
        imageView.setContentDescription(HardCodeUtil.qqStr(i17));
        imageView.setBackgroundDrawable(x16);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setOnClickListener(new b(z16, i3));
        return imageView;
    }

    public Integer q() {
        return this.I;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.E = null;
        this.F = null;
    }

    public void setContainerBottom(Integer num) {
        this.I = num;
    }

    public void setIgnoreTouchLocation(boolean z16) {
        this.H = z16;
    }

    public void setMenu(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        this.f307656e = aVar.g();
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuNoIconLayout", 4, "[menu] setMenu MENU:" + this.f307656e.toString());
        }
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        this.f307657f = onClickListener;
    }

    public void setPopupWindow(BubblePopupWindow bubblePopupWindow, BubblePopupWindow.QQMenuNoIconEmptyInterface qQMenuNoIconEmptyInterface) {
        this.f307655d = bubblePopupWindow;
        bubblePopupWindow.addOnDismissListener(new a());
        this.f307655d.setQQMenuNoIconEmptyInterface(qQMenuNoIconEmptyInterface);
    }

    int u(int i3) {
        if (i3 <= 0) {
            return 0;
        }
        int i16 = this.D;
        return ((i16 * 2) - 1) + 0 + ((i3 - 1) * ((i16 * 2) - 2));
    }

    public void setMenuCreateOrClickCallback(d dVar) {
    }
}
