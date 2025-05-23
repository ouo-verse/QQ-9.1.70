package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ViewerMoreRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f209522d;

    /* renamed from: e, reason: collision with root package name */
    TextView f209523e;

    /* renamed from: f, reason: collision with root package name */
    Context f209524f;

    public ViewerMoreRelativeLayout(Context context) {
        this(context, null);
    }

    public void setGone() {
        this.f209522d.setVisibility(8);
        this.f209523e.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f209522d.setOnClickListener(onClickListener);
    }

    public void setText(int i3) {
        this.f209523e.setText(i3);
    }

    public void setVisible() {
        this.f209522d.setVisibility(0);
        this.f209523e.setVisibility(0);
    }

    public ViewerMoreRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewerMoreRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209522d = null;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alx, this);
        this.f209522d = (RelativeLayout) findViewById(R.id.kvu);
        this.f209523e = (TextView) findViewById(R.id.kxk);
        this.f209524f = context;
    }
}
