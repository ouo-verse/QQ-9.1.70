package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class n extends RelativePopupWindow implements View.OnClickListener {
    private TextView C;
    protected View D;

    /* renamed from: d, reason: collision with root package name */
    private final LayoutInflater f327061d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f327062e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f327063f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f327064h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f327065i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f327066m;

    public n(Context context) {
        super(context);
        this.f327061d = LayoutInflater.from(context);
        f(R.layout.gua);
        setOutsideTouchable(true);
        setFocusable(true);
        setTouchable(true);
    }

    public void f(int i3) {
        View inflate = this.f327061d.inflate(i3, (ViewGroup) null);
        this.D = inflate;
        this.f327062e = (ImageView) inflate.findViewById(R.id.sev);
        this.f327064h = (ImageView) this.D.findViewById(R.id.f164055sf1);
        this.f327063f = (ImageView) this.D.findViewById(R.id.f164054sf0);
        this.f327065i = (ImageView) this.D.findViewById(R.id.sey);
        this.f327066m = (ImageView) this.D.findViewById(R.id.sez);
        this.C = (TextView) this.D.findViewById(R.id.seu);
        setBackgroundDrawable(new ColorDrawable(0));
        this.D.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.D.setOnClickListener(this);
        super.setContentView(this.D);
    }

    public void g(String str) {
        this.C.setText(str);
    }

    public void h(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                this.f327063f.setVisibility(8);
                                this.f327062e.setVisibility(8);
                                this.f327064h.setVisibility(8);
                                this.f327065i.setVisibility(8);
                                this.f327066m.setVisibility(8);
                                return;
                            }
                            this.f327064h.setVisibility(0);
                            this.f327062e.setVisibility(8);
                            this.f327063f.setVisibility(8);
                            this.f327065i.setVisibility(8);
                            this.f327066m.setVisibility(8);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f327064h.getLayoutParams();
                            layoutParams.addRule(14, -1);
                            layoutParams.addRule(7, 0);
                            this.f327064h.setLayoutParams(layoutParams);
                            return;
                        }
                        this.f327065i.setVisibility(0);
                        this.f327063f.setVisibility(8);
                        this.f327062e.setVisibility(8);
                        this.f327064h.setVisibility(8);
                        this.f327066m.setVisibility(8);
                        return;
                    }
                    this.f327066m.setVisibility(0);
                    this.f327063f.setVisibility(8);
                    this.f327062e.setVisibility(8);
                    this.f327064h.setVisibility(8);
                    this.f327065i.setVisibility(8);
                    return;
                }
                this.f327064h.setVisibility(0);
                this.f327062e.setVisibility(8);
                this.f327063f.setVisibility(8);
                this.f327065i.setVisibility(8);
                this.f327066m.setVisibility(8);
                return;
            }
            this.f327062e.setVisibility(0);
            this.f327063f.setVisibility(8);
            this.f327064h.setVisibility(8);
            this.f327065i.setVisibility(8);
            this.f327066m.setVisibility(8);
            return;
        }
        this.f327063f.setVisibility(0);
        this.f327062e.setVisibility(8);
        this.f327064h.setVisibility(8);
        this.f327065i.setVisibility(8);
        this.f327066m.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }
}
