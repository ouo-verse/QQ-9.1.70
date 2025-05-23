package com.qq.e.tg.cfg;

import com.qq.e.tg.nativ.CarouselView;
import com.qq.e.tg.nativ.NativeCarouselListener;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes3.dex */
public class CarouselParams {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<List<CarouselView>> f40462a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<NativeCarouselListener> f40463b;

    public WeakReference<NativeCarouselListener> getCarouselListener() {
        return this.f40463b;
    }

    public WeakReference<List<CarouselView>> getWeakCarouselViews() {
        return this.f40462a;
    }

    public void setCarouselListener(WeakReference<NativeCarouselListener> weakReference) {
        this.f40463b = weakReference;
    }

    public void setWeakCarouselViews(WeakReference<List<CarouselView>> weakReference) {
        this.f40462a = weakReference;
    }
}
