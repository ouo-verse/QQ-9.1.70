package com.tencent.biz.pubaccount.weishi.comment;

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
/* loaded from: classes32.dex */
public class WSReplyActionView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f80493d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f80494e;

    public WSReplyActionView(Context context) {
        this(context, null, 0);
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fvo, (ViewGroup) this, true);
        this.f80493d = (TextView) inflate.findViewById(R.id.f0o);
        this.f80494e = (TextView) inflate.findViewById(R.id.e8b);
        int f16 = BaseAIOUtils.f(18.0f, getContext().getResources());
        Drawable drawable = getResources().getDrawable(R.drawable.byp);
        drawable.setBounds(0, 0, f16, f16);
        this.f80493d.setCompoundDrawables(null, null, drawable, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.byq);
        drawable2.setBounds(0, 0, f16, f16);
        this.f80494e.setCompoundDrawables(null, null, drawable2, null);
    }

    public TextView a() {
        return this.f80494e;
    }

    public TextView b() {
        return this.f80493d;
    }

    public WSReplyActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WSReplyActionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
