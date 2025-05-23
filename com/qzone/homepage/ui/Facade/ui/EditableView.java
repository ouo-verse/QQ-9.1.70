package com.qzone.homepage.ui.Facade.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EditableView extends RelativeLayout {
    private String C;
    private boolean D;
    private Activity E;
    private int F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    Handler N;
    private View.OnClickListener P;

    /* renamed from: d, reason: collision with root package name */
    private final int f47639d;

    /* renamed from: e, reason: collision with root package name */
    private final int f47640e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f47641f;

    /* renamed from: h, reason: collision with root package name */
    private int f47642h;

    /* renamed from: i, reason: collision with root package name */
    private int f47643i;

    /* renamed from: m, reason: collision with root package name */
    private int f47644m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!EditableView.this.M) {
                EditableView.this.k();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public EditableView(Context context) {
        this(context, null);
    }

    private void j() {
        TextView textView = new TextView(getContext());
        this.f47641f = textView;
        textView.setId(16);
        this.f47641f.setBackgroundColor(0);
        TextView textView2 = this.f47641f;
        int i3 = this.f47639d;
        textView2.setPadding(i3, 0, i3, 0);
        this.f47641f.setVerticalScrollBarEnabled(false);
        this.f47641f.setMaxLines(1);
        this.f47641f.setSelectAllOnFocus(true);
        this.f47641f.setSingleLine();
        this.f47641f.setFocusable(false);
        this.f47641f.setFocusableInTouchMode(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f47641f.setLayoutParams(layoutParams);
        addView(this.f47641f);
        ViewCompat.setLayerType(this, 1, null);
        Handler handler = new Handler(Looper.getMainLooper());
        this.N = handler;
        this.J = true;
        handler.postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.EditableView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!EditableView.this.J || EditableView.this.M || EditableView.this.K >= EditableView.this.I) {
                    return;
                }
                if (EditableView.this.L == 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), EditableView.this.f47642h, ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(2.0f));
                    EditableView.this.f47641f.setBackgroundDrawable(gradientDrawable);
                    EditableView.this.L = 1;
                } else {
                    EditableView.this.f47641f.setBackgroundColor(EditableView.this.getResources().getColor(R.color.ajr));
                    EditableView.this.L = 0;
                    EditableView.this.K++;
                }
                EditableView.this.N.postDelayed(this, 1500L);
            }
        }, 1000L);
        this.f47641f.setOnClickListener(this.P);
        setOnClickListener(this.P);
    }

    public boolean k() {
        return this.D;
    }

    public void setDefaultText(String str) {
        this.C = str;
    }

    public void setEditable(boolean z16) {
        this.D = z16;
        if (z16) {
            this.J = true;
        } else {
            this.J = false;
        }
    }

    public void setFacadeEditRequest(Activity activity, int i3) {
        this.E = activity;
        this.F = i3;
    }

    @Override // android.widget.RelativeLayout
    public void setGravity(int i3) {
        this.H = i3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f47644m);
        int i16 = this.H;
        if (i16 == 3) {
            layoutParams.addRule(9, -1);
        } else if (i16 == 5) {
            layoutParams.addRule(11, -1);
        } else if (i16 != 17) {
            layoutParams.addRule(9, -1);
        } else {
            layoutParams.addRule(14, -1);
        }
        layoutParams.addRule(15, -1);
        this.f47641f.setLayoutParams(layoutParams);
    }

    public void setHeighOfText(int i3) {
        this.f47644m = i3;
    }

    public void setIndex(int i3) {
        this.G = i3;
    }

    public void setSplashMode(boolean z16) {
        this.M = z16;
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47641f.setText(str);
        } else {
            this.f47641f.setText(this.C);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f47641f.setTextColor(colorStateList);
        this.f47642h = colorStateList.getDefaultColor();
    }

    public void setTextSize(float f16) {
        this.f47641f.setTextSize(1, f16);
    }

    public void setTopOfText(int i3) {
        this.f47643i = i3;
    }

    public void setTwinkleEnable(boolean z16) {
        this.J = z16;
    }

    public EditableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47639d = ViewUtils.dpToPx(2.0f);
        this.f47640e = 16;
        this.I = 3;
        this.K = 0;
        this.M = true;
        this.P = new a();
        j();
    }

    public void setTextColor(int i3) {
        this.f47641f.setTextColor(i3);
        this.f47642h = i3;
    }
}
