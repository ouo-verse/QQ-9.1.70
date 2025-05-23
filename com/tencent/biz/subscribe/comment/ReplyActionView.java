package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReplyActionView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f95941d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f95942e;

    public ReplyActionView(Context context) {
        this(context, null, 0);
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167693ei, (ViewGroup) this, true);
        this.f95941d = (TextView) inflate.findViewById(R.id.f0o);
        this.f95942e = (TextView) inflate.findViewById(R.id.e8b);
        int f16 = BaseAIOUtils.f(12.0f, getContext().getResources());
        Drawable drawable = getResources().getDrawable(R.drawable.h8i);
        drawable.setBounds(0, 0, f16, f16);
        this.f95941d.setCompoundDrawables(null, null, drawable, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.h8j);
        drawable2.setBounds(0, 0, f16, f16);
        this.f95942e.setCompoundDrawables(null, null, drawable2, null);
    }

    public TextView a() {
        return this.f95942e;
    }

    public TextView b() {
        return this.f95941d;
    }

    public ReplyActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReplyActionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
