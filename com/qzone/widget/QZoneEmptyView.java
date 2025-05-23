package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneEmptyView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f60469d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60470e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f60471f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f60472h;

    public QZoneEmptyView(Context context) {
        super(context);
        this.f60470e = true;
        a();
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        addView(View.inflate(getContext(), R.layout.bki, null), layoutParams);
        this.f60471f = (ImageView) findViewById(R.id.bwf);
        this.f60472h = (TextView) findViewById(R.id.bwj);
        setVisibility(8);
    }

    public boolean b() {
        return this.f60470e;
    }

    public void setAutoSwitch(boolean z16) {
        this.f60470e = z16;
    }

    public void setContentView(View view) {
        this.f60469d = view;
    }

    public void setIcon(int i3) {
        this.f60471f.setImageResource(i3);
    }

    public void setMessage(String str) {
        this.f60472h.setText(str);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        View view;
        View view2;
        super.setVisibility(i3);
        if (i3 == 0) {
            if (!b() || (view2 = this.f60469d) == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        if (!b() || (view = this.f60469d) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public QZoneEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60470e = true;
        a();
    }
}
