package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdInteractiveVideoRootLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f304177d;

    /* renamed from: e, reason: collision with root package name */
    private final int f304178e;

    public QAdInteractiveVideoRootLayout(Context context) {
        super(context);
        this.f304178e = 54;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(getContext());
        this.f304177d = imageView;
        imageView.setId(R.id.f29800mm);
        int a16 = s.a(54.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a16, a16);
        layoutParams.addRule(13, -1);
        this.f304177d.setLayoutParams(layoutParams);
        this.f304177d.setImageResource(R.drawable.k8a);
    }

    public ImageView a() {
        return this.f304177d;
    }

    public void b() {
        this.f304177d.setVisibility(8);
    }

    public void d() {
        if (this.f304177d.getParent() == null) {
            addView(this.f304177d);
        }
        this.f304177d.setVisibility(0);
        this.f304177d.bringToFront();
    }

    public QAdInteractiveVideoRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f304178e = 54;
        c();
    }

    public QAdInteractiveVideoRootLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f304178e = 54;
        c();
    }
}
