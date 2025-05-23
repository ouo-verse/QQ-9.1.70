package com.tencent.mobileqq.troop.file.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileViewMoreRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f295711d;

    /* renamed from: e, reason: collision with root package name */
    TextView f295712e;

    /* renamed from: f, reason: collision with root package name */
    Context f295713f;

    /* renamed from: h, reason: collision with root package name */
    Drawable f295714h;

    public TroopFileViewMoreRelativeLayout(Context context) {
        this(context, null);
    }

    public void a() {
        Object obj = this.f295714h;
        if (obj == null) {
            return;
        }
        ((Animatable) obj).stop();
        this.f295714h = null;
        this.f295712e.setCompoundDrawables(null, null, null, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f295711d.setBackgroundResource(i3);
    }

    public void setGone() {
        this.f295711d.setVisibility(8);
        this.f295712e.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f295711d.setOnClickListener(onClickListener);
    }

    public void setText(int i3) {
        this.f295712e.setText(i3);
    }

    public void setTextColor(int i3) {
        this.f295712e.setTextColor(i3);
    }

    public void setTextLeftDrawable(int i3) {
        Drawable drawable = this.f295713f.getResources().getDrawable(i3);
        this.f295714h = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.f295714h.getMinimumHeight());
        this.f295712e.setCompoundDrawables(this.f295714h, null, null, null);
        ((Animatable) this.f295714h).start();
    }

    public void setVisible() {
        this.f295711d.setVisibility(0);
        this.f295712e.setVisibility(0);
    }

    public TroopFileViewMoreRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TroopFileViewMoreRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context);
        this.f295711d = null;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ai9, this);
        this.f295711d = (RelativeLayout) findViewById(R.id.giy);
        this.f295712e = (TextView) findViewById(R.id.giz);
        this.f295713f = context;
    }
}
