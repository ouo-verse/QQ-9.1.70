package com.tencent.biz.pubaccount.weishi.home;

import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi.view.WSViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/g;", "", "Lcom/tencent/biz/pubaccount/weishi/view/WSViewPager;", "viewPager", "Le00/c;", "pageChangeHelper", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "listener", "", "a", "b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "pageChangeListener", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f80819a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ViewPager.OnPageChangeListener pageChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/pubaccount/weishi/home/g$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e00.c f80821d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPager.OnPageChangeListener f80822e;

        a(e00.c cVar, ViewPager.OnPageChangeListener onPageChangeListener) {
            this.f80821d = cVar;
            this.f80822e = onPageChangeListener;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            e00.c cVar = this.f80821d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(state);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f80822e;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            e00.c cVar = this.f80821d;
            if (cVar != null) {
                cVar.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f80822e;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            e00.c cVar = this.f80821d;
            if (cVar != null) {
                cVar.onPageSelected(position);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f80822e;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(position);
            }
        }
    }

    g() {
    }

    public final void a(WSViewPager viewPager, e00.c pageChangeHelper, ViewPager.OnPageChangeListener listener) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        a aVar = new a(pageChangeHelper, listener);
        pageChangeListener = aVar;
        viewPager.addOnPageChangeListener(aVar);
    }

    public final void b(WSViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        ViewPager.OnPageChangeListener onPageChangeListener = pageChangeListener;
        if (onPageChangeListener != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
        }
        pageChangeListener = null;
    }
}
