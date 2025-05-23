package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.mobileqq.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedBannerIndicator extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f90830d;

    /* renamed from: e, reason: collision with root package name */
    private int f90831e;

    /* renamed from: f, reason: collision with root package name */
    private int f90832f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            QFSMixFeedBannerIndicator.this.f90831e = i3;
            QFSMixFeedBannerIndicator.this.invalidate();
        }
    }

    public QFSMixFeedBannerIndicator(@NotNull Context context) {
        this(context, null);
    }

    public void b(@Nullable QFSImageBanner qFSImageBanner) {
        if (qFSImageBanner == null) {
            return;
        }
        qFSImageBanner.q0(new a());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        super.onDraw(canvas);
        if (this.f90830d != null && this.f90832f != 0) {
            this.f90830d.setBounds(0, 0, getWidth() / this.f90832f, getHeight());
            canvas.translate(this.f90831e * r0, 0.0f);
            this.f90830d.draw(canvas);
        }
    }

    public void setCount(int i3) {
        this.f90832f = i3;
        if (i3 <= 1) {
            return;
        }
        setVisibility(0);
        this.f90830d = getContext().getResources().getDrawable(R.drawable.kkh);
    }

    public QFSMixFeedBannerIndicator(@NotNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSMixFeedBannerIndicator(@NotNull Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
