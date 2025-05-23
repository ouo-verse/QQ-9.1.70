package com.tencent.mobileqq.guild.setting.msgnotify;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import up1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildNotifySimpleSelectItem extends RelativeLayout {
    private Drawable C;
    private int D;
    private int E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f234773d;

    /* renamed from: e, reason: collision with root package name */
    private String f234774e;

    /* renamed from: f, reason: collision with root package name */
    private int f234775f;

    /* renamed from: h, reason: collision with root package name */
    private int f234776h;

    /* renamed from: i, reason: collision with root package name */
    private int f234777i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f234778m;

    public GuildNotifySimpleSelectItem(Context context) {
        super(context);
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.f234773d = textView;
        textView.setSingleLine(true);
        this.f234773d.setEllipsize(TextUtils.TruncateAt.END);
        this.f234773d.setGravity(19);
        this.f234773d.setText(this.f234774e);
        int i3 = 0;
        this.f234773d.setTextSize(0, this.f234775f);
        this.f234773d.setTextColor(this.f234776h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f234777i;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.f234773d.setLayoutParams(layoutParams);
        addView(this.f234773d);
        ImageView imageView = new ImageView(getContext());
        this.f234778m = imageView;
        imageView.setImageDrawable(this.C);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.D, this.E);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = this.F;
        this.f234778m.setLayoutParams(layoutParams2);
        ImageView imageView2 = this.f234778m;
        if (!this.G) {
            i3 = 8;
        }
        imageView2.setVisibility(i3);
        addView(this.f234778m);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.G;
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        int i3;
        this.G = z16;
        ImageView imageView = this.f234778m;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public GuildNotifySimpleSelectItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f439733y4);
        this.f234774e = obtainStyledAttributes.getString(a.E4);
        this.f234775f = obtainStyledAttributes.getDimensionPixelSize(a.H4, 0);
        this.f234776h = obtainStyledAttributes.getColor(a.F4, 0);
        this.f234777i = obtainStyledAttributes.getDimensionPixelSize(a.G4, 0);
        this.C = obtainStyledAttributes.getDrawable(a.f439746z4);
        this.D = obtainStyledAttributes.getDimensionPixelSize(a.C4, 0);
        this.E = obtainStyledAttributes.getDimensionPixelSize(a.A4, 0);
        this.F = obtainStyledAttributes.getDimensionPixelSize(a.B4, 0);
        this.G = obtainStyledAttributes.getBoolean(a.D4, false);
        a();
    }
}
