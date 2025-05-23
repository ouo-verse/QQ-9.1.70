package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import ev2.e;
import pw2.n;
import tv2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdImageView extends RoundRelativeLayout implements a {

    /* renamed from: h, reason: collision with root package name */
    private static String f303883h = "QAdImageView";

    /* renamed from: f, reason: collision with root package name */
    private a f303884f;

    public QAdImageView(Context context) {
        this(context, null);
    }

    private void c() {
        addView((View) this.f303884f, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d(Context context, AttributeSet attributeSet, int i3) {
        a a16 = e.a(context, attributeSet);
        this.f303884f = a16;
        if (a16 instanceof View) {
            c();
        }
    }

    @Override // tv2.a
    public void a(String str, int i3) {
        a aVar = this.f303884f;
        if (aVar == null) {
            n.b(f303883h, "updateImage, mIQAdImageView == null");
        } else {
            aVar.a(str, i3);
        }
    }

    @Override // tv2.a
    public void setCornersRadius(float f16) {
        a aVar = this.f303884f;
        if (aVar == null) {
            return;
        }
        aVar.setCornersRadius(f16);
    }

    @Override // tv2.a
    public void setImageColor(String str) {
        a aVar = this.f303884f;
        if (aVar == null) {
            return;
        }
        aVar.setImageColor(str);
    }

    public QAdImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QAdImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d(context, attributeSet, i3);
    }
}
