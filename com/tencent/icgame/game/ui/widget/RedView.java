package com.tencent.icgame.game.ui.widget;

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
/* loaded from: classes7.dex */
public class RedView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f115935d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f115936e;

    /* renamed from: f, reason: collision with root package name */
    private View f115937f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f115938h;

    /* renamed from: i, reason: collision with root package name */
    private int f115939i;

    /* renamed from: m, reason: collision with root package name */
    private int f115940m;

    public RedView(Context context) {
        super(context);
        this.f115935d = -1;
        this.f115938h = false;
        this.f115939i = R.drawable.f162542lr0;
        this.f115940m = 100;
        b();
    }

    private void a() {
        setBackgroundResource(0);
        this.f115937f.setVisibility(8);
        this.f115936e.setVisibility(8);
    }

    private void b() {
        setWillNotDraw(false);
        this.f115936e = new TextView(getContext());
        setBackgroundResource(this.f115939i);
        this.f115936e.setTextColor(getResources().getColor(R.color.f158017al3));
        this.f115936e.setTextSize(1, 10.0f);
        this.f115936e.setIncludeFontPadding(false);
        this.f115936e.setGravity(17);
        this.f115936e.setPadding(ViewUtils.dpToPx(4.0f), 0, ViewUtils.dpToPx(4.0f), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        addView(this.f115936e, layoutParams);
        this.f115936e.setVisibility(8);
        View view = new View(getContext());
        this.f115937f = view;
        view.setBackgroundResource(R.drawable.f162542lr0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(6.0f));
        layoutParams2.gravity = 17;
        addView(this.f115937f, layoutParams2);
        this.f115937f.setVisibility(8);
    }

    private void c() {
        this.f115937f.setVisibility(8);
        this.f115936e.setVisibility(0);
        setBackgroundResource(this.f115939i);
    }

    public void setDefaultBg(int i3) {
        this.f115939i = i3;
        setBackgroundResource(i3);
    }

    public void setDotType(int i3) {
        this.f115940m = i3;
    }

    public void setFlag(boolean z16) {
        this.f115935d = -1;
        int i3 = 0;
        setBackgroundResource(0);
        View view = this.f115937f;
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.f115936e.setVisibility(8);
    }

    public void setNum(int i3) {
        setNum(i3, 99);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            a();
            return;
        }
        c();
        this.f115936e.setText(str);
        this.f115935d = -1;
    }

    public void setTextMinWidth(float f16) {
        this.f115936e.setMinWidth(ViewUtils.dpToPx(f16));
    }

    public void setTextPadding(int i3, int i16, int i17, int i18) {
        this.f115936e.setPadding(i3, i16, i17, i18);
    }

    public void setTextSize(float f16) {
        this.f115936e.setTextSize(1, f16);
    }

    public void setNum(int i3, int i16) {
        if (this.f115935d == i3) {
            return;
        }
        if (i3 == 0) {
            a();
            return;
        }
        c();
        String str = i16 + Marker.ANY_NON_NULL_MARKER;
        this.f115935d = i3;
        boolean z16 = i3 > i16;
        if (i3 <= 0) {
            str = "";
        } else if (!z16) {
            str = i3 + "";
        }
        this.f115936e.setText(str);
    }

    public RedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f115935d = -1;
        this.f115938h = false;
        this.f115939i = R.drawable.f162542lr0;
        this.f115940m = 100;
        b();
    }

    public RedView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f115935d = -1;
        this.f115938h = false;
        this.f115939i = R.drawable.f162542lr0;
        this.f115940m = 100;
        b();
    }
}
