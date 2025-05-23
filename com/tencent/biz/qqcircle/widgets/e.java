package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class e extends QCircleRelativePopupWindow implements View.OnClickListener {
    protected ImageView C;
    protected ImageView D;
    protected TextView E;
    protected LinearLayout F;
    private View.OnClickListener G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f93594d;

    /* renamed from: e, reason: collision with root package name */
    protected View f93595e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f93596f;

    /* renamed from: h, reason: collision with root package name */
    protected ImageView f93597h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f93598i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f93599m;

    public e(Context context) {
        super(context);
        this.f93594d = LayoutInflater.from(context);
        k(R.layout.g3h);
        setOutsideTouchable(true);
        setFocusable(true);
        setTouchable(true);
    }

    public void f(int i3) {
        g(ResourcesCompat.getDrawable(this.f93595e.getResources(), i3, null));
    }

    public void g(Drawable drawable) {
        h(drawable, drawable, drawable, drawable, drawable, drawable);
    }

    public void h(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        ImageView imageView = this.f93598i;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        ImageView imageView2 = this.f93596f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable2);
        }
        ImageView imageView3 = this.f93597h;
        if (imageView3 != null) {
            imageView3.setImageDrawable(drawable3);
        }
        ImageView imageView4 = this.f93599m;
        if (imageView4 != null) {
            imageView4.setImageDrawable(drawable4);
        }
        ImageView imageView5 = this.C;
        if (imageView5 != null) {
            imageView5.setImageDrawable(drawable5);
        }
        ImageView imageView6 = this.D;
        if (imageView6 != null) {
            imageView6.setImageDrawable(drawable6);
        }
    }

    public void i(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams;
        int i17 = this.H;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 5) {
                            if (i17 != 6) {
                                layoutParams = null;
                            } else {
                                layoutParams = this.D.getLayoutParams();
                            }
                        } else {
                            layoutParams = this.C.getLayoutParams();
                        }
                    } else {
                        layoutParams = this.f93599m.getLayoutParams();
                    }
                } else {
                    layoutParams = this.f93597h.getLayoutParams();
                }
            } else {
                layoutParams = this.f93598i.getLayoutParams();
            }
        } else {
            layoutParams = this.f93596f.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = ImmersiveUtils.dpToPx(i3);
            layoutParams.height = ImmersiveUtils.dpToPx(i16);
        }
    }

    public void j(int i3) {
        this.F.setBackgroundResource(i3);
    }

    public void k(int i3) {
        View inflate = this.f93594d.inflate(i3, (ViewGroup) null);
        this.f93595e = inflate;
        this.f93596f = (ImageView) inflate.findViewById(R.id.sey);
        this.f93597h = (ImageView) this.f93595e.findViewById(R.id.f164056sf2);
        this.f93598i = (ImageView) this.f93595e.findViewById(R.id.sex);
        this.f93599m = (ImageView) this.f93595e.findViewById(R.id.f164055sf1);
        this.C = (ImageView) this.f93595e.findViewById(R.id.f164054sf0);
        this.D = (ImageView) this.f93595e.findViewById(R.id.sew);
        this.F = (LinearLayout) this.f93595e.findViewById(R.id.ses);
        this.E = (TextView) this.f93595e.findViewById(R.id.seu);
        setBackgroundDrawable(new ColorDrawable(0));
        this.f93595e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f93595e.setOnClickListener(this);
        super.setContentView(this.f93595e);
    }

    public void l(int i3) {
        this.E.setText(i3);
    }

    public void m(int i3) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public void n(int i3, int i16) {
        this.H = i3;
        switch (i3) {
            case 0:
                this.f93596f.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.f93596f.getLayoutParams()).leftMargin = i16;
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                return;
            case 1:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.f93598i.getLayoutParams()).leftMargin = i16;
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                return;
            case 2:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.f93597h.getLayoutParams()).rightMargin = i16;
                this.f93599m.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                return;
            case 3:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(0);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.f93599m.getLayoutParams()).rightMargin = i16;
                return;
            case 4:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(0);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f93599m.getLayoutParams();
                layoutParams.addRule(14, -1);
                layoutParams.addRule(7, 0);
                this.f93599m.setLayoutParams(layoutParams);
                return;
            case 5:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(8);
                this.C.setVisibility(0);
                this.D.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.f93599m.getLayoutParams()).rightMargin = i16;
                return;
            case 6:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.D.getLayoutParams()).rightMargin = i16;
                return;
            default:
                this.f93596f.setVisibility(8);
                this.f93598i.setVisibility(8);
                this.f93597h.setVisibility(8);
                this.f93599m.setVisibility(8);
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        View.OnClickListener onClickListener = this.G;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
