package com.tencent.ad.tangram.views.canvas.components.imagescarousel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasImagesCarouselComponentView extends AdCanvasComponentView {
    private static final String TAG = "AdCanvasImagesCarouselComponentView";
    private static int WHEEL = 100;
    private static int WHEEL_WAIT = 101;
    private static int delay;
    private List<AdCanvasPictureComponentView> adCanvasPictureComponentViews;

    @Nullable
    private InnerHandler handler;
    private boolean isScrolling;
    private AdImagesCarouselPagerAdapter mAdapter;
    private Context mContext;
    private int mCurrentPosition;

    @Nullable
    private ViewPager mViewPager;
    private long releaseTime;

    @Nullable
    private InnerRunnable runnable;
    private int showPosition;

    @Nullable
    private AdCanvasImagesCarouselComponentData value;

    @NonNull
    private List<View> viewList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class InnerHandler extends Handler {
        private final WeakReference<AdCanvasImagesCarouselComponentView> mView;

        public InnerHandler(WeakReference<AdCanvasImagesCarouselComponentView> weakReference) {
            this.mView = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView;
            super.handleMessage(message);
            WeakReference<AdCanvasImagesCarouselComponentView> weakReference = this.mView;
            if (weakReference != null) {
                adCanvasImagesCarouselComponentView = weakReference.get();
            } else {
                adCanvasImagesCarouselComponentView = null;
            }
            if (adCanvasImagesCarouselComponentView != null) {
                adCanvasImagesCarouselComponentView.autoHandleScroll(message);
            } else {
                AdLog.i(AdCanvasImagesCarouselComponentView.TAG, "handleMessage return");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class InnerRunnable implements Runnable {
        private final WeakReference<AdCanvasImagesCarouselComponentView> mView;

        public InnerRunnable(WeakReference<AdCanvasImagesCarouselComponentView> weakReference) {
            this.mView = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView;
            boolean z16;
            WeakReference<AdCanvasImagesCarouselComponentView> weakReference = this.mView;
            if (weakReference != null) {
                adCanvasImagesCarouselComponentView = weakReference.get();
            } else {
                adCanvasImagesCarouselComponentView = null;
            }
            if (adCanvasImagesCarouselComponentView != null) {
                InnerHandler innerHandler = adCanvasImagesCarouselComponentView.handler;
                AdLog.i(AdCanvasImagesCarouselComponentView.TAG, "InnerRunnable run. size=" + adCanvasImagesCarouselComponentView.viewList.size());
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("InnerRunnable handle. size=");
                sb5.append(adCanvasImagesCarouselComponentView.viewList.size());
                sb5.append(" canWheel=");
                if (currentTimeMillis - adCanvasImagesCarouselComponentView.releaseTime > AdCanvasImagesCarouselComponentView.delay + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" now= ");
                sb5.append(currentTimeMillis);
                sb5.append(" releaseTime=");
                sb5.append(adCanvasImagesCarouselComponentView.releaseTime);
                sb5.append(" timer=");
                sb5.append(currentTimeMillis - adCanvasImagesCarouselComponentView.releaseTime);
                sb5.append(" delay: ");
                sb5.append(AdCanvasImagesCarouselComponentView.delay + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT);
                AdLog.i(AdCanvasImagesCarouselComponentView.TAG, sb5.toString());
                if (currentTimeMillis - adCanvasImagesCarouselComponentView.releaseTime > AdCanvasImagesCarouselComponentView.delay + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT) {
                    innerHandler.sendEmptyMessage(AdCanvasImagesCarouselComponentView.WHEEL);
                } else {
                    innerHandler.sendEmptyMessage(AdCanvasImagesCarouselComponentView.WHEEL_WAIT);
                }
            }
        }
    }

    public AdCanvasImagesCarouselComponentView(@NonNull Context context) {
        super(context);
        this.releaseTime = 0L;
        this.viewList = new ArrayList();
        this.handler = new InnerHandler(new WeakReference(this));
        this.runnable = new InnerRunnable(new WeakReference(this));
        this.isScrolling = false;
        this.mCurrentPosition = 0;
        this.showPosition = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoHandleScroll(@NonNull Message message) {
        if (this.handler != null && this.runnable != null) {
            AdLog.i(TAG, "autoHandleScroll call: size=" + this.viewList.size() + " msg=" + message);
            if (this.viewList.size() > 0) {
                if (message.what == WHEEL) {
                    if (!this.isScrolling) {
                        int size = (this.mCurrentPosition + 1) % this.viewList.size();
                        AdLog.i(TAG, "autoHandleScroll: mCurrentPosition=" + this.mCurrentPosition + " position=" + size + " size: " + this.viewList.size());
                        this.mViewPager.setCurrentItem(size, true);
                    }
                    this.releaseTime = System.currentTimeMillis();
                }
                this.handler.removeCallbacks(this.runnable);
                this.handler.postDelayed(this.runnable, delay);
            }
        }
    }

    @Nullable
    private AdCanvasPictureComponentView getImageView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, @NonNull AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData, @NonNull AdCanvasPictureComponentData adCanvasPictureComponentData, Handler handler) {
        adCanvasPictureComponentData.enableRoundRectBackground = adCanvasImagesCarouselComponentData.enableImageRoundRectBackground;
        adCanvasPictureComponentData.radius = adCanvasImagesCarouselComponentData.imageRadius;
        adCanvasPictureComponentData.borderWidth = adCanvasImagesCarouselComponentData.imageBorderWidth;
        adCanvasPictureComponentData.borderColor = adCanvasImagesCarouselComponentData.imageBorderColor;
        AdCanvasPictureComponentView adCanvasPictureComponentView = new AdCanvasPictureComponentView(context, weakReference, adCanvasPictureComponentData, null, handler);
        this.adCanvasPictureComponentViews.add(adCanvasPictureComponentView);
        return adCanvasPictureComponentView;
    }

    private void init(@Nullable Context context, @Nullable AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData, Handler handler) {
        InnerRunnable innerRunnable;
        int i3;
        if (context != null && adCanvasImagesCarouselComponentData != null && adCanvasImagesCarouselComponentData.isValid()) {
            this.adCanvasPictureComponentViews = new ArrayList();
            this.value = adCanvasImagesCarouselComponentData;
            int i16 = adCanvasImagesCarouselComponentData.displaySpeed;
            if (i16 > 0) {
                delay = i16 * 1000;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(-1);
            frameLayout.setClipChildren(false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            addView(frameLayout);
            AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData2 = this.value;
            layoutParams.leftMargin = adCanvasImagesCarouselComponentData2.marginLeft;
            layoutParams.topMargin = adCanvasImagesCarouselComponentData2.marginTop;
            layoutParams.rightMargin = adCanvasImagesCarouselComponentData2.marginRight;
            layoutParams.bottomMargin = adCanvasImagesCarouselComponentData2.marginBottom;
            layoutParams.gravity = 0;
            frameLayout.setLayoutParams(layoutParams);
            ArrayList<AdCanvasPictureComponentData> arrayList = this.value.imageList;
            if (arrayList != null && arrayList.size() != 0) {
                this.viewList.clear();
                Iterator<AdCanvasPictureComponentData> it = this.value.imageList.iterator();
                while (it.hasNext()) {
                    AdCanvasPictureComponentData next = it.next();
                    if (next != null) {
                        this.viewList.add(getImageView(context, this.canvasViewListener, this.value, next, handler));
                    }
                }
                if (this.value.imageList.size() > this.value.pageLimit) {
                    int i17 = 0;
                    while (true) {
                        AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData3 = this.value;
                        i3 = adCanvasImagesCarouselComponentData3.pageLimit;
                        if (i17 >= i3) {
                            break;
                        }
                        this.viewList.add(0, getImageView(context, this.canvasViewListener, adCanvasImagesCarouselComponentData3, adCanvasImagesCarouselComponentData3.imageList.get((r2.size() - 1) - i17), handler));
                        List<View> list = this.viewList;
                        WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
                        AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData4 = this.value;
                        list.add(getImageView(context, weakReference, adCanvasImagesCarouselComponentData4, adCanvasImagesCarouselComponentData4.imageList.get(i17), handler));
                        i17++;
                    }
                    this.showPosition += i3;
                }
                AdImagesCarouselPagerAdapter adImagesCarouselPagerAdapter = new AdImagesCarouselPagerAdapter();
                this.mAdapter = adImagesCarouselPagerAdapter;
                adImagesCarouselPagerAdapter.setViewList(this.viewList);
                this.mAdapter.setPageLimit(this.value.pageLimit);
                ViewPager viewPager = new ViewPager(context);
                this.mViewPager = viewPager;
                viewPager.setClipChildren(false);
                this.mViewPager.setOffscreenPageLimit(this.value.pageLimit * 2);
                this.mViewPager.setAdapter(this.mAdapter);
                this.mViewPager.setCurrentItem(this.showPosition);
                this.mCurrentPosition = this.showPosition;
                this.mViewPager.setPageMargin(this.value.pageMargin);
                this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentView.1
                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i18) {
                        if (i18 == 1) {
                            AdCanvasImagesCarouselComponentView.this.isScrolling = true;
                            return;
                        }
                        if (i18 == 0) {
                            AdCanvasImagesCarouselComponentView.this.releaseTime = System.currentTimeMillis();
                            AdLog.i(AdCanvasImagesCarouselComponentView.TAG, "onPageScrollStateChanged: mCurrentPosition=" + AdCanvasImagesCarouselComponentView.this.mCurrentPosition);
                            AdCanvasImagesCarouselComponentView.this.mViewPager.setCurrentItem(AdCanvasImagesCarouselComponentView.this.mCurrentPosition, false);
                        }
                        AdCanvasImagesCarouselComponentView.this.isScrolling = false;
                    }

                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i18) {
                        int i19 = AdCanvasImagesCarouselComponentView.this.value.pageLimit;
                        int size = AdCanvasImagesCarouselComponentView.this.value.pageLimit + AdCanvasImagesCarouselComponentView.this.value.imageList.size();
                        AdCanvasImagesCarouselComponentView.this.mCurrentPosition = i18;
                        if (i18 < i19) {
                            AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView = AdCanvasImagesCarouselComponentView.this;
                            adCanvasImagesCarouselComponentView.mCurrentPosition = adCanvasImagesCarouselComponentView.value.imageList.size() + i18;
                        } else if (i18 >= size) {
                            AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView2 = AdCanvasImagesCarouselComponentView.this;
                            adCanvasImagesCarouselComponentView2.mCurrentPosition = i18 - adCanvasImagesCarouselComponentView2.value.imageList.size();
                        }
                        AdLog.i(AdCanvasImagesCarouselComponentView.TAG, "onPageSelected: mCurrentPosition=" + AdCanvasImagesCarouselComponentView.this.mCurrentPosition + " index=" + i18);
                    }

                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i18, float f16, int i19) {
                    }
                });
                frameLayout.addView(this.mViewPager);
                this.mViewPager.post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) AdCanvasImagesCarouselComponentView.this.mViewPager.getLayoutParams();
                        layoutParams2.width = AdCanvasImagesCarouselComponentView.this.value.width;
                        layoutParams2.height = AdCanvasImagesCarouselComponentView.this.value.height;
                        AdCanvasImagesCarouselComponentView.this.mViewPager.setLayoutParams(layoutParams2);
                    }
                });
                InnerHandler innerHandler = this.handler;
                if (innerHandler != null && (innerRunnable = this.runnable) != null) {
                    innerHandler.postDelayed(innerRunnable, delay);
                }
            }
        }
    }

    public List<AdCanvasPictureComponentView> getAdCanvasPictureComponentViews() {
        return this.adCanvasPictureComponentViews;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasComponentData getData() {
        return this.value;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityDestroy() {
        super.onActivityDestroy();
        InnerHandler innerHandler = this.handler;
        if (innerHandler != null) {
            innerHandler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        if (this.runnable != null) {
            this.runnable = null;
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onLocationChanged() {
        super.onLocationChanged();
        List<AdCanvasPictureComponentView> list = this.adCanvasPictureComponentViews;
        if (list != null) {
            for (AdCanvasPictureComponentView adCanvasPictureComponentView : list) {
                if (adCanvasPictureComponentView != null) {
                    adCanvasPictureComponentView.onLocationChanged();
                }
            }
        }
    }

    public AdCanvasImagesCarouselComponentView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.releaseTime = 0L;
        this.viewList = new ArrayList();
        this.handler = new InnerHandler(new WeakReference(this));
        this.runnable = new InnerRunnable(new WeakReference(this));
        this.isScrolling = false;
        this.mCurrentPosition = 0;
        this.showPosition = 0;
    }

    public AdCanvasImagesCarouselComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData) {
        super(context, weakReference);
        this.releaseTime = 0L;
        this.viewList = new ArrayList();
        this.handler = new InnerHandler(new WeakReference(this));
        this.runnable = new InnerRunnable(new WeakReference(this));
        this.isScrolling = false;
        this.mCurrentPosition = 0;
        this.showPosition = 0;
        this.mContext = context;
        init(context, adCanvasImagesCarouselComponentData, null);
    }

    public AdCanvasImagesCarouselComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData, Handler handler) {
        super(context, weakReference);
        this.releaseTime = 0L;
        this.viewList = new ArrayList();
        this.handler = new InnerHandler(new WeakReference(this));
        this.runnable = new InnerRunnable(new WeakReference(this));
        this.isScrolling = false;
        this.mCurrentPosition = 0;
        this.showPosition = 0;
        this.mContext = context;
        init(context, adCanvasImagesCarouselComponentData, handler);
    }
}
