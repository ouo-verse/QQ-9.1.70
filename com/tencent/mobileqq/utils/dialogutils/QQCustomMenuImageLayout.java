package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomMenuImageLayout extends LinearLayout implements View.OnClickListener {
    public static int E = 0;
    public static float F = 1.0f;
    public static int G = 5;
    public static int H = 45;
    public static int I = 53;
    public static int J = 90;
    private int C;
    private View.OnClickListener D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f307637d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f307638e;

    /* renamed from: f, reason: collision with root package name */
    public int f307639f;

    /* renamed from: h, reason: collision with root package name */
    private int f307640h;

    /* renamed from: i, reason: collision with root package name */
    private BubblePopupWindow f307641i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.utils.dialogutils.a f307642m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends TextView {
        a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            QQCustomMenuImageLayout.this.f307641i.dismiss();
            return performClick;
        }
    }

    public QQCustomMenuImageLayout(Context context) {
        super(context);
        this.f307639f = 0;
        this.f307640h = -1;
        this.C = 0;
        setOrientation(0);
        this.f307639f = E - ((int) (F * 10.0f));
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuImageLayout", 4, "screenWidth:" + E + " mDensity: " + F + " layoutMaxWidth A:" + this.f307639f);
        }
        this.C = 12;
        if (F >= 2.0f) {
            this.C = 20;
        }
    }

    private TextView b(int i3) {
        TextView textView = new TextView(getContext());
        textView.setText("");
        textView.setTextSize(1.0f);
        textView.setWidth(i3);
        textView.setMaxLines(1);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextColor(-1);
        textView.setBackgroundDrawable(null);
        textView.setGravity(17);
        return textView;
    }

    private TextView c(b bVar) {
        Drawable drawable;
        a aVar = new a(getContext());
        aVar.setText(bVar.c());
        aVar.setTextSize(10.0f);
        Resources resources = getContext().getResources();
        aVar.setMinimumWidth(90);
        aVar.setMaxLines(1);
        try {
            drawable = getContext().getResources().getDrawable(bVar.a());
        } catch (RuntimeException e16) {
            l.s("QQCustomMenuImageLayout", "creatTextViewWithTopIcon ERR", e16);
            drawable = null;
        }
        aVar.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        aVar.setCompoundDrawablePadding(0);
        int f16 = BaseAIOUtils.f(9.0f, resources);
        aVar.setPadding(0, f16, 0, f16);
        aVar.setContentDescription(bVar.c());
        aVar.setId(bVar.b());
        aVar.setTextColor(-855638017);
        aVar.setBackgroundDrawable(null);
        aVar.setIncludeFontPadding(true);
        aVar.setOnClickListener(this.D);
        aVar.setGravity(17);
        return aVar;
    }

    private ImageView d() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.cbk);
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.qo8));
        imageView.setBackgroundDrawable(null);
        imageView.setOnClickListener(this);
        int i3 = this.C;
        float f16 = F;
        imageView.setPadding((int) (i3 * f16), (int) (f16 * 10.0f), (int) (i3 * f16), (int) (f16 * 10.0f));
        return imageView;
    }

    private int h() {
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt != null && childAt.getVisibility() != 8) {
                TextView textView = (TextView) childAt;
                int desiredWidth = (int) Layout.getDesiredWidth(textView.getText(), textView.getPaint());
                i3 += childAt.getPaddingLeft() + desiredWidth + childAt.getPaddingRight();
                if (QLog.isColorLevel()) {
                    QLog.d("QQCustomMenuImageLayout", 4, "child  TextView text " + ((Object) textView.getText()) + " measureWidth = " + desiredWidth + " paddingL = " + childAt.getPaddingLeft() + " paddingR = " + childAt.getPaddingRight());
                }
            }
        }
        int i17 = (G * 2) + i3;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuImageLayout", 4, "totalWidth   " + i17);
        }
        return i17;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    public boolean e(int i3) {
        if (h() + i3 <= this.f307639f) {
            return true;
        }
        return false;
    }

    public void f() {
        removeAllViews();
        int h16 = this.f307642m.h();
        int i3 = 0;
        while (true) {
            if (i3 < h16) {
                TextView c16 = c(this.f307642m.f(i3));
                int i16 = J;
                int i17 = H;
                if (i16 < i17 || i16 > (i17 = I)) {
                    i16 = i17;
                }
                if (e(i16)) {
                    if (i3 == 6) {
                        i3--;
                        removeViewAt(i3);
                        ImageView d16 = d();
                        this.f307638e = d16;
                        this.f307638e.setLayoutParams(new LinearLayout.LayoutParams(d16.getPaddingLeft() + 22 + this.f307638e.getPaddingRight(), -2));
                        addView(this.f307638e);
                        break;
                    }
                    addView(c16, new LinearLayout.LayoutParams(i16, -2, 0.0f));
                    if (i3 == h16 - 1) {
                        addView(b(G), new LinearLayout.LayoutParams(G, -2, 0.0f));
                    }
                    i3++;
                } else {
                    ImageView d17 = d();
                    this.f307638e = d17;
                    int paddingLeft = d17.getPaddingLeft() + 22 + this.f307638e.getPaddingRight();
                    this.f307638e.setLayoutParams(new LinearLayout.LayoutParams(paddingLeft, -2));
                    if (!e(paddingLeft) && i3 > 1) {
                        i3--;
                        removeViewAt(i3);
                    }
                    addView(this.f307638e);
                }
            } else {
                i3 = -1;
                break;
            }
        }
        this.f307640h = i3;
    }

    public void g() {
        if (this.f307640h >= 0) {
            removeAllViews();
            ImageView imageView = new ImageView(getContext());
            this.f307637d = imageView;
            imageView.setImageResource(R.drawable.cbf);
            this.f307637d.setContentDescription(HardCodeUtil.qqStr(R.string.f172425qo1));
            this.f307637d.setBackgroundDrawable(null);
            this.f307637d.setOnClickListener(this);
            ImageView imageView2 = this.f307637d;
            int i3 = this.C;
            float f16 = F;
            imageView2.setPadding((int) (i3 * f16), (int) (f16 * 10.0f), (int) (i3 * f16), (int) (f16 * 10.0f));
            int paddingLeft = this.f307637d.getPaddingLeft() + 22 + this.f307637d.getPaddingRight();
            this.f307637d.setLayoutParams(new LinearLayout.LayoutParams(paddingLeft, -2));
            addView(this.f307637d);
            int i16 = paddingLeft + 0;
            for (int i17 = this.f307640h; i17 < this.f307642m.h(); i17++) {
                TextView c16 = c(this.f307642m.f(i17));
                int i18 = J;
                int i19 = H;
                if (i18 < i19 || i18 > (i19 = I)) {
                    i18 = i19;
                }
                addView(c16, new LinearLayout.LayoutParams(i18, -2, 0.0f));
                i16 += i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomMenuImageLayout", 4, "secondScreenWidth: " + i16);
            }
            int i26 = E;
            if (i16 < i26 / 2) {
                int i27 = (i26 / 2) - i16;
                TextView b16 = b(i27);
                b16.setVisibility(4);
                addView(b16, new LinearLayout.LayoutParams(i27, -2, 0.0f));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f307637d) {
            f();
        } else if (view == this.f307638e) {
            g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setMenu(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        this.f307642m = aVar;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuImageLayout", 4, "MENU:" + this.f307642m.toString());
        }
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setPopup(BubblePopupWindow bubblePopupWindow) {
        this.f307641i = bubblePopupWindow;
    }
}
