package com.tencent.mobileqq.wink.picker.core.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaListTabPageFragment;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.view.NoScrollViewPager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/ah;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "A9", "", "z9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaListTabPageFragment;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mediaListTabPageFragments", "Lcom/tencent/mobileqq/wink/view/NoScrollViewPager;", "e", "Lcom/tencent/mobileqq/wink/view/NoScrollViewPager;", "viewPager", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "f", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabsGroup", "<init>", "()V", tl.h.F, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ah extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<WinkMediaListTabPageFragment> mediaListTabPageFragments = new ArrayList<>(3);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NoScrollViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageTabBar tabsGroup;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/ah$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/ah;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends FragmentPagerAdapter {
        public b() {
            super(ah.this.getHostFragment().getChildFragmentManager(), 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return ah.this.mediaListTabPageFragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            Object obj = ah.this.mediaListTabPageFragments.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mediaListTabPageFragments[position]");
            return (Fragment) obj;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324575a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f324575a = iArr;
        }
    }

    private final void A9() {
        NoScrollViewPager noScrollViewPager;
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) getPartRootView().findViewById(R.id.z06);
        this.tabsGroup = qUIPageTabBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setTabData(new String[]{"\u5168\u90e8", "\u89c6\u9891", "\u7167\u7247"});
        }
        boolean z95 = z9();
        w53.b.f("WinkMediaViewPagerPart", "hasTabLayout=" + z95);
        if (!z95) {
            QUIPageTabBar qUIPageTabBar2 = this.tabsGroup;
            if (qUIPageTabBar2 != null) {
                qUIPageTabBar2.setVisibility(8);
                return;
            }
            return;
        }
        QUIPageTabBar qUIPageTabBar3 = this.tabsGroup;
        if (qUIPageTabBar3 != null) {
            qUIPageTabBar3.setViewPager(this.viewPager);
        }
        MediaType initLocalMediaTab = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getInitLocalMediaTab();
        if (initLocalMediaTab == MediaType.LOCAL_VIDEO) {
            NoScrollViewPager noScrollViewPager2 = this.viewPager;
            if (noScrollViewPager2 != null) {
                noScrollViewPager2.setCurrentItem(1);
                return;
            }
            return;
        }
        if (initLocalMediaTab == MediaType.LOCAL_IMAGE && (noScrollViewPager = this.viewPager) != null) {
            noScrollViewPager.setCurrentItem(2);
        }
    }

    private final void B9() {
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) getPartRootView().findViewById(R.id.f166209z04);
        this.viewPager = noScrollViewPager;
        if (noScrollViewPager != null) {
            noScrollViewPager.setOffscreenPageLimit(2);
            noScrollViewPager.setAdapter(new b());
        }
    }

    private final boolean z9() {
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getLocalMediaTabType() == TabType.ALL_MEDIA) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaViewPagerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ArrayList<WinkMediaListTabPageFragment> arrayList = this.mediaListTabPageFragments;
        arrayList.clear();
        int i3 = c.f324575a[com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getLocalMediaTabType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                WinkMediaListTabPageFragment.Companion companion = WinkMediaListTabPageFragment.INSTANCE;
                arrayList.add(companion.a(MediaType.LOCAL_ALL));
                arrayList.add(companion.a(MediaType.LOCAL_VIDEO));
                arrayList.add(companion.a(MediaType.LOCAL_IMAGE));
            } else {
                arrayList.add(WinkMediaListTabPageFragment.INSTANCE.a(MediaType.LOCAL_IMAGE));
            }
        } else {
            arrayList.add(WinkMediaListTabPageFragment.INSTANCE.a(MediaType.LOCAL_VIDEO));
        }
        B9();
        A9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        NoScrollViewPager noScrollViewPager = this.viewPager;
        if (noScrollViewPager != null) {
            noScrollViewPager.setAdapter(null);
        }
        this.mediaListTabPageFragments.clear();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (z9()) {
            z93.e h16 = Wink.INSTANCE.h();
            if (h16 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                z16 = h16.a(context);
            } else {
                z16 = false;
            }
            if (z16) {
                QUIPageTabBar qUIPageTabBar = this.tabsGroup;
                if (qUIPageTabBar != null) {
                    qUIPageTabBar.setVisibility(0);
                    return;
                }
                return;
            }
            QUIPageTabBar qUIPageTabBar2 = this.tabsGroup;
            if (qUIPageTabBar2 != null) {
                qUIPageTabBar2.setVisibility(4);
            }
        }
    }
}
