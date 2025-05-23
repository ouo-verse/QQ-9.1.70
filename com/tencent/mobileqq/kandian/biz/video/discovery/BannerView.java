package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.util.x;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BannerView extends FrameLayout implements ViewPager.OnPageChangeListener {
    private int C;
    public int D;
    int E;

    /* renamed from: d, reason: collision with root package name */
    protected ViewPager f239601d;

    /* renamed from: e, reason: collision with root package name */
    private Context f239602e;

    /* renamed from: f, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f239603f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f239604h;

    /* renamed from: i, reason: collision with root package name */
    private int f239605i;

    /* renamed from: m, reason: collision with root package name */
    private int f239606m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class AutoSidleTimer extends Handler implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BannerView> f239607d;

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<BannerView> weakReference = this.f239607d;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f239607d.get().c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class DotsIndicator extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        private Context f239608d;

        /* renamed from: e, reason: collision with root package name */
        public int f239609e;

        /* renamed from: f, reason: collision with root package name */
        public int f239610f;

        /* renamed from: h, reason: collision with root package name */
        public int f239611h;

        /* renamed from: i, reason: collision with root package name */
        public int f239612i;

        /* renamed from: m, reason: collision with root package name */
        public int f239613m;

        public DotsIndicator(Context context) {
            this(context, 0, 81);
        }

        private void a(Context context, int i3, int i16) {
            this.f239608d = context;
            this.f239613m = i3;
            this.f239609e = BaseAIOUtils.f(6.0f, getResources());
            this.f239610f = BaseAIOUtils.f(10.0f, getResources());
            this.f239611h = BaseAIOUtils.f(7.0f, getResources());
            this.f239612i = BaseAIOUtils.f(7.0f, getResources());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.f239609e;
            layoutParams.gravity = i16;
            setLayoutParams(layoutParams);
        }

        public DotsIndicator(Context context, int i3, int i16) {
            super(context);
            a(context, i3, i16);
        }

        public void setDotsSelected(int i3) {
            if (i3 < 0 || i3 >= getChildCount()) {
                return;
            }
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                if (i16 == i3) {
                    childAt.setSelected(true);
                } else {
                    childAt.setSelected(false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class a<T, V extends View> extends PagerAdapter {
    }

    public BannerView(Context context) {
        super(context);
        this.f239604h = true;
        this.f239605i = 1;
        this.f239606m = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.C = 81;
        this.D = 0;
        this.E = x.c(getContext(), 25.0f);
        b(context);
    }

    private void b(Context context) {
        this.f239602e = context;
        ViewPager viewPager = new ViewPager(this.f239602e);
        this.f239601d = viewPager;
        viewPager.setOnPageChangeListener(this);
        this.f239601d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            e();
        } else if (action == 1 || action == 3) {
            d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f239603f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    public void setOffscreenPageLimit(int i3) {
        ViewPager viewPager = this.f239601d;
        if (viewPager != null) {
            viewPager.setOffscreenPageLimit(i3);
        }
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f239603f = onPageChangeListener;
    }

    public void setPageTransformer(boolean z16, ViewPager.PageTransformer pageTransformer) {
        ViewPager viewPager = this.f239601d;
        if (viewPager != null) {
            viewPager.setPageTransformer(z16, pageTransformer);
        }
    }

    public void setTimeInterval(int i3) {
        if (i3 > 0) {
            this.f239606m = i3;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239604h = true;
        this.f239605i = 1;
        this.f239606m = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.C = 81;
        this.D = 0;
        this.E = x.c(getContext(), 25.0f);
        b(context);
    }

    public void setDotsGravity(int i3) {
        if (i3 == 81 || i3 == 8388691 || i3 == 8388693) {
            this.C = i3;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239604h = true;
        this.f239605i = 1;
        this.f239606m = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.C = 81;
        this.D = 0;
        this.E = x.c(getContext(), 25.0f);
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
    }

    public void setAdapter(a aVar) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
