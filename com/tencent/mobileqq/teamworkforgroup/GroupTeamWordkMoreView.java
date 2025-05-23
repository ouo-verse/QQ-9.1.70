package com.tencent.mobileqq.teamworkforgroup;

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
/* loaded from: classes18.dex */
public class GroupTeamWordkMoreView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f292447d;

    /* renamed from: e, reason: collision with root package name */
    TextView f292448e;

    /* renamed from: f, reason: collision with root package name */
    Context f292449f;

    /* renamed from: h, reason: collision with root package name */
    Drawable f292450h;

    public GroupTeamWordkMoreView(Context context) {
        this(context, null);
    }

    public void a() {
        Object obj = this.f292450h;
        if (obj == null) {
            return;
        }
        ((Animatable) obj).stop();
        this.f292450h = null;
        this.f292448e.setCompoundDrawables(null, null, null, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f292447d.setBackgroundResource(i3);
    }

    public void setGone() {
        this.f292447d.setVisibility(8);
        this.f292448e.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f292447d.setOnClickListener(onClickListener);
    }

    public void setText(int i3) {
        this.f292448e.setText(i3);
    }

    public void setTextColor(int i3) {
        this.f292448e.setTextColor(i3);
    }

    public void setTextLeftDrawable(int i3) {
        Drawable drawable = this.f292449f.getResources().getDrawable(i3);
        this.f292450h = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.f292450h.getMinimumHeight());
        this.f292448e.setCompoundDrawables(this.f292450h, null, null, null);
        ((Animatable) this.f292450h).start();
    }

    public void setVisible() {
        this.f292447d.setVisibility(0);
        this.f292448e.setVisibility(0);
    }

    public GroupTeamWordkMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupTeamWordkMoreView(Context context, AttributeSet attributeSet, int i3) {
        super(context);
        this.f292447d = null;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ai9, this);
        this.f292447d = (RelativeLayout) findViewById(R.id.giy);
        this.f292448e = (TextView) findViewById(R.id.giz);
        this.f292449f = context;
    }
}
