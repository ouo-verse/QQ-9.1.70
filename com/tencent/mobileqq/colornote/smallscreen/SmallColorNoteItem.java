package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.layout.AutoBgFrameLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SmallColorNoteItem extends LinearLayout {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private View f201666d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f201667e;

    /* renamed from: f, reason: collision with root package name */
    private AutoBgFrameLayout f201668f;

    /* renamed from: h, reason: collision with root package name */
    private RoundImageView f201669h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f201670i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f201671m;

    public SmallColorNoteItem(Context context, boolean z16, ViewGroup viewGroup) {
        super(context);
        e(z16, viewGroup);
    }

    private void e(boolean z16, ViewGroup viewGroup) {
        this.C = z16;
        if (z16) {
            this.f201666d = LayoutInflater.from(getContext()).inflate(R.layout.c7n, viewGroup, false);
        } else {
            this.f201666d = LayoutInflater.from(getContext()).inflate(R.layout.c7m, viewGroup, false);
        }
        View view = this.f201666d;
        this.f201667e = (RelativeLayout) view.findViewById(R.id.leh);
        this.f201668f = (AutoBgFrameLayout) view.findViewById(R.id.lxv);
        this.f201669h = (RoundImageView) view.findViewById(R.id.lxw);
        this.f201670i = (TextView) view.findViewById(R.id.f166424ly2);
        this.f201671m = (TextView) view.findViewById(R.id.f166423ly1);
    }

    public void a(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, i3);
        this.f201666d.setLayoutParams(layoutParams);
        layoutParams.height = i3;
        float f16 = (i3 * 1.0f) / i16;
        int c16 = (int) (x.c(getContext(), 6.0f) * f16);
        RelativeLayout relativeLayout = this.f201667e;
        boolean z16 = this.C;
        int i28 = 0;
        if (z16) {
            i17 = 0;
        } else {
            i17 = c16;
        }
        if (z16) {
            i18 = c16;
        } else {
            i18 = 0;
        }
        relativeLayout.setPadding(i17, c16, i18, c16);
        this.f201669h.setmRadius((int) (x.c(getContext(), 3.0f) * f16), false);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f201669h.getLayoutParams();
        layoutParams2.height = (int) (x.c(getContext(), 20.0f) * f16);
        layoutParams2.width = (int) (x.c(getContext(), 20.0f) * f16);
        this.f201670i.setTextSize((int) (8.0f * f16));
        this.f201671m.setTextSize((int) (6.0f * f16));
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f201670i.getLayoutParams();
        int max = Math.max(x.c(getContext(), 2.0f), (int) (f16 * x.c(getContext(), 4.0f)));
        boolean z17 = this.C;
        if (z17) {
            i19 = 0;
        } else {
            i19 = max;
        }
        layoutParams3.leftMargin = i19;
        if (z17) {
            i26 = max;
        } else {
            i26 = 0;
        }
        layoutParams3.rightMargin = i26;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f201671m.getLayoutParams();
        boolean z18 = this.C;
        if (z18) {
            i27 = 0;
        } else {
            i27 = max;
        }
        layoutParams4.leftMargin = i27;
        if (z18) {
            i28 = max;
        }
        layoutParams4.rightMargin = i28;
    }

    public View b() {
        return this.f201666d;
    }

    public void c() {
        RoundImageView roundImageView = this.f201669h;
        if (roundImageView != null) {
            roundImageView.setVisibility(4);
        }
    }

    public void d() {
        TextView textView = this.f201670i;
        if (textView != null) {
            textView.setVisibility(4);
        }
        TextView textView2 = this.f201671m;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
    }

    public void f() {
        RoundImageView roundImageView = this.f201669h;
        if (roundImageView != null) {
            roundImageView.setVisibility(0);
        }
    }

    public void g() {
        TextView textView = this.f201670i;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f201671m;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setAttachLeft(boolean z16) {
        this.C = z16;
    }

    public void setSubTitle(String str) {
        TextView textView = this.f201671m;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f201670i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public SmallColorNoteItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmallColorNoteItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
