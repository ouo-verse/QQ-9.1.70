package com.tencent.ams.mosaic.jsengine.component.imagegallery;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.IndicatorView;
import com.tencent.ams.mosaic.jsengine.component.view.NetworkImageView;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageGalleryView extends FrameLayout implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    private b C;
    private boolean D;
    private int E;
    private boolean F;
    private String G;

    @NonNull
    private f.c H;
    private float I;
    private float J;
    private int K;
    private final Handler L;
    private final Runnable M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final ViewPager f71211d;

    /* renamed from: e, reason: collision with root package name */
    private IndicatorView f71212e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final a f71213f;

    /* renamed from: h, reason: collision with root package name */
    private String[] f71214h;

    /* renamed from: i, reason: collision with root package name */
    private String f71215i;

    /* renamed from: m, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f71216m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends PagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final List<String> f71217d;

        /* compiled from: P */
        /* renamed from: com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryView$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class ViewOnClickListenerC0693a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f71219d;

            ViewOnClickListenerC0693a(int i3) {
                this.f71219d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (ImageGalleryView.this.C != null) {
                    ImageGalleryView.this.C.onItemClick(this.f71219d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageGalleryView.this);
            } else {
                this.f71217d = new ArrayList();
            }
        }

        private ImageView.ScaleType d() {
            if (!TextUtils.isEmpty(ImageGalleryView.this.G)) {
                String str = ImageGalleryView.this.G;
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1274298614:
                        if (str.equals("fitEnd")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -522179887:
                        if (str.equals("fitStart")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case -340708175:
                        if (str.equals("centerInside")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 97441490:
                        if (str.equals("fitXY")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 1161480325:
                        if (str.equals("centerCrop")) {
                            c16 = 5;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        return ImageView.ScaleType.CENTER;
                    case 1:
                        return ImageView.ScaleType.FIT_END;
                    case 2:
                        return ImageView.ScaleType.FIT_START;
                    case 3:
                        return ImageView.ScaleType.CENTER_INSIDE;
                    case 4:
                        return ImageView.ScaleType.FIT_XY;
                    case 5:
                        return ImageView.ScaleType.CENTER_CROP;
                    default:
                        return ImageView.ScaleType.FIT_CENTER;
                }
            }
            return ImageView.ScaleType.FIT_CENTER;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            } else {
                viewGroup.removeView((View) obj);
            }
        }

        public void e(String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
                return;
            }
            this.f71217d.clear();
            if (strArr != null && strArr.length > 0) {
                this.f71217d.addAll(Arrays.asList(strArr));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (!ImageGalleryView.this.F) {
                return this.f71217d.size();
            }
            if (this.f71217d.size() == 0) {
                return 0;
            }
            return this.f71217d.size() + 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            NetworkImageView networkImageView = new NetworkImageView(ImageGalleryView.this.getContext(), ImageGalleryView.this.H);
            int h16 = ImageGalleryView.this.h(i3);
            networkImageView.setSrc(this.f71217d.get(h16));
            networkImageView.setScaleType(d());
            networkImageView.setOnClickListener(new ViewOnClickListenerC0693a(h16));
            viewGroup.addView(networkImageView);
            return networkImageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface b {
        void onItemClick(int i3);
    }

    public ImageGalleryView(@NonNull Context context) {
        this(context, f.k().j());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(int i3) {
        int i16;
        if (!this.F) {
            return i3;
        }
        String[] strArr = this.f71214h;
        if (strArr != null) {
            i16 = strArr.length;
        } else {
            i16 = 0;
        }
        if (i3 == 0) {
            return i16 - 1;
        }
        if (i3 == i16 + 1) {
            return 0;
        }
        return i3 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f71213f.getF373114d() > 1 && this.D) {
            ViewPager viewPager = this.f71211d;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            this.L.postDelayed(this.M, this.E);
        }
    }

    private void j() {
        IndicatorView.a aVar = new IndicatorView.a();
        aVar.f71229c = MosaicUtils.n(getContext(), 7);
        this.f71212e = new IndicatorView(getContext(), aVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) MosaicUtils.n(getContext(), 80));
        layoutParams.gravity = 81;
        this.f71212e.setLayoutParams(layoutParams);
        addView(this.f71212e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3 || action == 4) {
                l();
            }
        } else {
            m();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i3 = 0;
        if ("center".equals(this.f71215i)) {
            this.f71211d.setPageMargin((int) this.J);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f71211d.getLayoutParams();
            float f16 = this.I;
            layoutParams.leftMargin = (int) f16;
            layoutParams.rightMargin = (int) f16;
            this.f71211d.setLayoutParams(layoutParams);
            this.f71213f.notifyDataSetChanged();
        } else {
            this.f71211d.setPageMargin(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f71211d.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            this.f71211d.setLayoutParams(layoutParams2);
            this.f71213f.notifyDataSetChanged();
        }
        this.f71213f.e(this.f71214h);
        String[] strArr = this.f71214h;
        if (strArr != null) {
            i3 = strArr.length;
        }
        if (i3 > 0) {
            this.f71211d.setCurrentItem(this.F ? 1 : 0);
            this.f71211d.setOffscreenPageLimit(Math.min(i3 + 2, 10));
        }
        this.f71213f.notifyDataSetChanged();
        IndicatorView indicatorView = this.f71212e;
        if (indicatorView != null) {
            indicatorView.setCount(i3);
        }
        IndicatorView indicatorView2 = this.f71212e;
        if (indicatorView2 != null) {
            indicatorView2.setCount(i3);
        }
        if (this.D) {
            l();
        }
    }

    public void k(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f71211d.setCurrentItem(i3, z16);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (!this.N && this.D && this.f71213f.getF373114d() > 1) {
            this.L.postDelayed(this.M, this.E);
            this.N = true;
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (this.N) {
            this.L.removeCallbacks(this.M);
            this.N = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f71211d.addOnPageChangeListener(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.f71211d.removeOnPageChangeListener(this);
            super.onDetachedFromWindow();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f71216m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
        if (i3 == 0) {
            int currentItem = this.f71211d.getCurrentItem();
            String[] strArr = this.f71214h;
            if (strArr != null) {
                i16 = strArr.length;
            } else {
                i16 = 0;
            }
            if (currentItem == 0) {
                this.f71211d.setCurrentItem(i16, false);
            } else if (currentItem == i16 + 1) {
                this.f71211d.setCurrentItem(1, false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f71216m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
        if (this.f71212e != null) {
            this.f71212e.c(h(i3), f16, i16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        this.K = i3;
        int h16 = h(i3);
        com.tencent.ams.mosaic.utils.f.e("ImageGalleryView", "onPageSelected position:" + i3 + ", realPosition:" + h16);
        ViewPager.OnPageChangeListener onPageChangeListener = this.f71216m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(h16);
        }
        IndicatorView indicatorView = this.f71212e;
        if (indicatorView != null) {
            indicatorView.d(h16);
        }
    }

    public void setAnimationType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71215i = str;
        }
    }

    public void setAutoScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    public void setAutoScrollInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else if (i3 > 0) {
            this.E = i3;
        }
    }

    public void setImageLoader(@NonNull f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.H = cVar;
        }
    }

    public void setInfiniteLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void setOnItemClickListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        } else {
            this.C = bVar;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onPageChangeListener);
        } else {
            this.f71216m = onPageChangeListener;
        }
    }

    public void setPageMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.J = f16;
        }
    }

    public void setScaleType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.G = str;
        }
    }

    public void setSideExposeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.I = f16;
        }
    }

    public void setSrcList(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr);
        } else {
            this.f71214h = strArr;
        }
    }

    public ImageGalleryView(@NonNull Context context, @NonNull f.c cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) cVar);
            return;
        }
        this.f71215i = "full";
        this.D = true;
        this.E = 1400;
        this.F = true;
        this.L = new Handler(Looper.getMainLooper());
        this.M = new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageGalleryView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ImageGalleryView.this.i();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.H = cVar;
        this.I = Utils.getRelativeSize375(context, 48);
        this.J = Utils.getRelativeSize375(context, 8);
        ViewPager viewPager = new ViewPager(context);
        this.f71211d = viewPager;
        viewPager.setBackgroundColor(65280);
        a aVar = new a();
        this.f71213f = aVar;
        viewPager.setAdapter(aVar);
        addView(viewPager, new FrameLayout.LayoutParams(-1, -1));
        viewPager.setClipChildren(false);
        setClipChildren(false);
        j();
    }
}
