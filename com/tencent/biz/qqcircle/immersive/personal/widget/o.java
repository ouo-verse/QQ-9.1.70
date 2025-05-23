package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f89382d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89383e;

    /* renamed from: f, reason: collision with root package name */
    private View f89384f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f89385h;

    /* renamed from: i, reason: collision with root package name */
    private QFSPersonalPushRedPointView f89386i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f89387m;

    public o(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gm8, (ViewGroup) null);
        this.f89382d = inflate;
        this.f89383e = (TextView) inflate.findViewById(R.id.f56622l4);
        this.f89384f = this.f89382d.findViewById(R.id.f57322n0);
        this.f89385h = (ImageView) this.f89382d.findViewById(R.id.f44581pk);
        this.f89386i = (QFSPersonalPushRedPointView) this.f89382d.findViewById(R.id.f44591pl);
        this.f89382d.setOnClickListener(this);
    }

    public View a() {
        return this.f89382d;
    }

    public void b() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(this.f89386i);
    }

    public void c(boolean z16) {
        if (z16) {
            this.f89386i.setVisibility(0);
        } else {
            this.f89386i.setVisibility(8);
        }
    }

    public void d(int i3) {
        this.f89382d.setId(i3);
    }

    public void e(View.OnClickListener onClickListener) {
        this.f89387m = onClickListener;
    }

    public void f(boolean z16) {
        int i3;
        View view = this.f89384f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view.setVisibility(i3);
        this.f89383e.setSelected(z16);
        this.f89385h.setSelected(z16);
        this.f89383e.getPaint().setFakeBoldText(z16);
    }

    public void g(String str) {
        this.f89383e.setText(str);
        if (TextUtils.equals(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_))) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this.f89386i);
        }
    }

    public void h(boolean z16) {
        int i3;
        ImageView imageView = this.f89385h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void i(boolean z16) {
        this.f89386i.a(z16);
        if (!z16) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this.f89386i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.f89387m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
