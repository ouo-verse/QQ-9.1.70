package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMSlidingItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    ImageView f67307d;

    /* renamed from: e, reason: collision with root package name */
    TextView f67308e;

    /* renamed from: f, reason: collision with root package name */
    a f67309f;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f67310a;

        /* renamed from: b, reason: collision with root package name */
        public int f67311b;

        /* renamed from: c, reason: collision with root package name */
        public int f67312c;
    }

    public QIMSlidingItemView(Context context) {
        super(context);
        b();
    }

    public void a(int i3, boolean z16) {
        int i16;
        this.f67308e.setTextColor(i3);
        if (this.f67307d.getVisibility() == 0) {
            ImageView imageView = this.f67307d;
            if (z16) {
                i16 = this.f67309f.f67312c;
            } else {
                i16 = this.f67309f.f67311b;
            }
            imageView.setImageResource(i16);
        }
    }

    public void c(int i3, int i16) {
        this.f67308e.setGravity(17);
        this.f67308e.setSingleLine();
        this.f67308e.setTextSize(0, i3);
        setPadding(i16, 0, i16, 0);
    }

    public void setData(a aVar) {
        this.f67309f = aVar;
        this.f67308e.setText(aVar.f67310a);
        int i3 = this.f67309f.f67311b;
        if (i3 != 0) {
            this.f67307d.setImageResource(i3);
            this.f67307d.setVisibility(0);
        }
    }

    private void b() {
        setOrientation(0);
        setGravity(16);
        this.f67307d = new ImageView(getContext());
        this.f67308e = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BaseAIOUtils.f(13.0f, getResources()), BaseAIOUtils.f(12.0f, getResources()));
        layoutParams.gravity = 17;
        addView(this.f67307d, layoutParams);
        this.f67307d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = BaseAIOUtils.f(4.0f, getResources());
        addView(this.f67308e, layoutParams2);
    }

    public QIMSlidingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public QIMSlidingItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }
}
