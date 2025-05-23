package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes20.dex */
public class ProfileCardFavorItemView extends LinearLayout {
    public ImageView C;
    public View D;

    /* renamed from: d, reason: collision with root package name */
    private Context f315964d;

    /* renamed from: e, reason: collision with root package name */
    private View f315965e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f315966f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f315967h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f315968i;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f315969m;

    public ProfileCardFavorItemView(Context context) {
        super(context);
        this.f315964d = context;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.f315964d).inflate(R.layout.f168335ta, (ViewGroup) this, true);
        this.f315965e = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.dr7);
        this.f315966f = textView;
        textView.setTextColor(getResources().getColorStateList(R.color.skin_black));
        this.f315967h = (ImageView) this.f315965e.findViewById(R.id.f164472yw);
        this.f315968i = (LinearLayout) this.f315965e.findViewById(R.id.g0a);
        this.f315969m = (LinearLayout) this.f315965e.findViewById(R.id.g0d);
        this.C = (ImageView) this.f315965e.findViewById(R.id.g0b);
        this.D = this.f315965e.findViewById(R.id.g0c);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.f315968i.addView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        this.f315968i.removeViewAt(i3);
    }

    public void setArrowVisiale(boolean z16) {
        int i3;
        ImageView imageView = this.f315967h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void setTitle(String str) {
        this.f315966f.setText(str);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        this.f315968i.addView(view, i3);
    }

    public ProfileCardFavorItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315964d = context;
        a();
    }
}
