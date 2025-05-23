package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes12.dex */
public class QFileListPullMoreLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f209425d;

    /* renamed from: e, reason: collision with root package name */
    TextView f209426e;

    /* renamed from: f, reason: collision with root package name */
    Context f209427f;

    /* renamed from: h, reason: collision with root package name */
    Drawable f209428h;

    public QFileListPullMoreLayout(Context context) {
        this(context, null);
    }

    public void a() {
        Object obj = this.f209428h;
        if (obj == null) {
            return;
        }
        ((Animatable) obj).stop();
        this.f209428h = null;
        this.f209426e.setCompoundDrawables(null, null, null, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f209425d.setBackgroundResource(i3);
    }

    public void setGone() {
        this.f209425d.setVisibility(8);
        this.f209426e.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f209425d.setOnClickListener(onClickListener);
    }

    public void setText(int i3) {
        this.f209426e.setText(i3);
    }

    public void setTextColor(int i3) {
        this.f209426e.setTextColor(i3);
    }

    public void setTextLeftDrawable(int i3) {
        Drawable drawable = this.f209427f.getResources().getDrawable(i3);
        this.f209428h = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.f209428h.getMinimumHeight());
        this.f209426e.setCompoundDrawables(this.f209428h, null, null, null);
        ((Animatable) this.f209428h).start();
    }

    public void setVisible() {
        this.f209425d.setVisibility(0);
        this.f209426e.setVisibility(0);
    }

    public QFileListPullMoreLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFileListPullMoreLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context);
        this.f209425d = null;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ai9, this);
        this.f209425d = (RelativeLayout) findViewById(R.id.giy);
        this.f209426e = (TextView) findViewById(R.id.giz);
        this.f209427f = context;
    }
}
