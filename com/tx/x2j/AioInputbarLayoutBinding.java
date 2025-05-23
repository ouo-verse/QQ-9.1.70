package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioInputbarLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f387025a;

    /* renamed from: b, reason: collision with root package name */
    public AIOEditText f387026b;

    /* renamed from: c, reason: collision with root package name */
    public AIOInputSendBtn f387027c;

    /* renamed from: d, reason: collision with root package name */
    public View f387028d;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387025a = constraintLayout;
        this.f387028d = constraintLayout;
        constraintLayout.setId(R.id.dmj);
        this.f387025a.setFocusable(true);
        this.f387025a.setClickable(true);
        d.e(this.f387025a);
        this.f387025a.setBackground(context.getResources().getDrawable(R.drawable.mlf));
        this.f387025a.setPadding(0, (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.rightToLeft = R.id.send_btn;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        layoutParams.validate();
        AIOEditText aIOEditText = new AIOEditText(context, null);
        this.f387026b = aIOEditText;
        aIOEditText.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f387026b.setHighlightColor(Color.parseColor("#00CAFC"));
        this.f387026b.setId(R.id.input);
        this.f387026b.setClickable(true);
        this.f387026b.setIncludeFontPadding(false);
        this.f387026b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(resources.getInteger(R.integer.f167165o))});
        if (Build.VERSION.SDK_INT >= 29) {
            this.f387026b.setTextCursorDrawable(R.drawable.f160144bc);
        } else {
            d.g(this.f387026b, TextView.class, "mCursorDrawableRes", Integer.valueOf(R.drawable.f160144bc));
        }
        this.f387026b.setFocusable(true);
        this.f387026b.setFocusableInTouchMode(true);
        this.f387026b.setTextColor(Color.parseColor("#ff03081A"));
        this.f387026b.setHintTextColor(Color.parseColor("#B0B3BF"));
        this.f387026b.setMaxLines(6);
        this.f387026b.setGravity(19);
        this.f387026b.setMinimumHeight((int) resources.getDimension(R.dimen.cjj));
        d.e(this.f387026b);
        this.f387026b.setBackground(context.getResources().getDrawable(R.drawable.skin_aio_input_bg));
        this.f387026b.setPadding((int) (TypedValue.applyDimension(1, 11.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 11.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        this.f387026b.setInputType(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
        d.h(this.f387026b, IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN, null, null, -1, -1);
        this.f387025a.addView(this.f387026b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        layoutParams2.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (TypedValue.applyDimension(1, 60.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams2.validate();
        AIOInputSendBtn aIOInputSendBtn = new AIOInputSendBtn(context, null);
        this.f387027c = aIOInputSendBtn;
        aIOInputSendBtn.setTextSize(0, (int) resources.getDimension(R.dimen.aym));
        this.f387027c.setText(resources.getString(R.string.a1p));
        this.f387027c.setEnabled(true);
        this.f387027c.setFocusable(true);
        this.f387027c.setId(R.id.send_btn);
        this.f387027c.setClickable(true);
        this.f387027c.setVisibility(0);
        this.f387027c.setMinimumHeight((int) resources.getDimension(R.dimen.d_2));
        this.f387027c.setPadding((int) resources.getDimension(R.dimen.d_4), 0, (int) resources.getDimension(R.dimen.d_5), 0);
        this.f387027c.setSizeType(2);
        this.f387027c.setType(0);
        this.f387025a.addView(this.f387027c, layoutParams2);
        return this.f387025a;
    }

    public View u() {
        return this.f387028d;
    }
}
