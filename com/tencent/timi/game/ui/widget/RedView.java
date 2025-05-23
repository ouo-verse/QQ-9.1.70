package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RedView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f380099d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f380100e;

    /* renamed from: f, reason: collision with root package name */
    private View f380101f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f380102h;

    /* renamed from: i, reason: collision with root package name */
    private int f380103i;

    /* renamed from: m, reason: collision with root package name */
    private int f380104m;

    public RedView(Context context) {
        super(context);
        this.f380099d = -1;
        this.f380102h = false;
        this.f380103i = R.drawable.f162542lr0;
        this.f380104m = 100;
        c();
    }

    private void b() {
        setBackgroundResource(0);
        this.f380101f.setVisibility(8);
        this.f380100e.setVisibility(8);
    }

    private void c() {
        setWillNotDraw(false);
        this.f380100e = new TextView(getContext());
        setBackgroundResource(this.f380103i);
        this.f380100e.setTextColor(getResources().getColor(R.color.f158017al3));
        this.f380100e.setTextSize(1, 10.0f);
        this.f380100e.setIncludeFontPadding(false);
        this.f380100e.setGravity(17);
        this.f380100e.setPadding(ViewUtils.dpToPx(4.0f), 0, ViewUtils.dpToPx(4.0f), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        addView(this.f380100e, layoutParams);
        this.f380100e.setVisibility(8);
        View view = new View(getContext());
        this.f380101f = view;
        view.setBackgroundResource(R.drawable.f162542lr0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(6.0f));
        layoutParams2.gravity = 17;
        addView(this.f380101f, layoutParams2);
        this.f380101f.setVisibility(8);
    }

    private void d() {
        this.f380101f.setVisibility(8);
        this.f380100e.setVisibility(0);
        setBackgroundResource(this.f380103i);
    }

    public int a() {
        if (getVisibility() == 0) {
            return this.f380104m;
        }
        return 100;
    }

    public void setDefaultBg(int i3) {
        this.f380103i = i3;
        setBackgroundResource(i3);
    }

    public void setDotType(int i3) {
        this.f380104m = i3;
    }

    public void setFlag(boolean z16) {
        this.f380099d = -1;
        int i3 = 0;
        setBackgroundResource(0);
        View view = this.f380101f;
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.f380100e.setVisibility(8);
    }

    public void setNum(int i3) {
        setNum(i3, 99);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            b();
            return;
        }
        d();
        this.f380100e.setText(str);
        this.f380099d = -1;
    }

    public void setTextMinWidth(float f16) {
        this.f380100e.setMinWidth(ViewUtils.dpToPx(f16));
    }

    public void setTextPadding(int i3, int i16, int i17, int i18) {
        this.f380100e.setPadding(i3, i16, i17, i18);
    }

    public void setTextSize(float f16) {
        this.f380100e.setTextSize(1, f16);
    }

    public void setNum(int i3, int i16) {
        if (this.f380099d == i3) {
            return;
        }
        if (i3 == 0) {
            b();
            return;
        }
        d();
        String str = i16 + Marker.ANY_NON_NULL_MARKER;
        this.f380099d = i3;
        boolean z16 = i3 > i16;
        if (i3 <= 0) {
            str = "";
        } else if (!z16) {
            str = i3 + "";
        }
        this.f380100e.setText(str);
    }

    public RedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380099d = -1;
        this.f380102h = false;
        this.f380103i = R.drawable.f162542lr0;
        this.f380104m = 100;
        c();
    }

    public RedView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f380099d = -1;
        this.f380102h = false;
        this.f380103i = R.drawable.f162542lr0;
        this.f380104m = 100;
        c();
    }
}
