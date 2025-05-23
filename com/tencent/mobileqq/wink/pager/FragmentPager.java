package com.tencent.mobileqq.wink.pager;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.pager.FragmentPager.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u00018\u0018\u0000 \u0013*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u00022\u00020\u0004:\u0005 $=(,Bj\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u0010*\u001a\u0004\u0018\u00010'\u0012\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+\u0012\b\b\u0002\u00101\u001a\u00020\u0005\u0012!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b02\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0005J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\bR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R/\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/FragmentPager;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "T", "", "", "position", tl.h.F, "", "p", "o", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "pageId", "j", "index", "Lcom/tencent/mobileqq/wink/pager/b;", "i", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/viewpager2/widget/ViewPager2;", "b", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$e;", "c", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$e;", "pageConfig", "Landroid/view/View;", "d", "Landroid/view/View;", "tabLayout", "", "e", "Ljava/util/List;", "pages", "f", "I", "bottomPadding", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "g", "Lkotlin/jvm/functions/Function1;", "onSelectPage", "com/tencent/mobileqq/wink/pager/FragmentPager$g", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$g;", "pageChangeCallback", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/viewpager2/widget/ViewPager2;Lcom/tencent/mobileqq/wink/pager/FragmentPager$e;Landroid/view/View;Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "FragmentLifecycleObserver", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FragmentPager<T extends Fragment & d> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageConfig pageConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View tabLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.wink.pager.b<T>> pages;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int bottomPadding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> onSelectPage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g pageChangeCallback;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/pager/FragmentPager$a", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "Landroidx/viewpager2/adapter/FragmentViewHolder;", "holder", "position", "", "", "payloads", "", "i0", "Landroidx/fragment/app/Fragment;", "createFragment", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends FragmentStateAdapter {

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ FragmentPager<T> f324364m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FragmentPager<T> fragmentPager, FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.f324364m = fragmentPager;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            return this.f324364m.h(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ((FragmentPager) this.f324364m).pages.size();
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
        
            if (r0.e() == true) goto L8;
         */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(@NotNull FragmentViewHolder holder, int position, @NotNull List<Object> payloads) {
            Object orNull;
            boolean z16;
            FrameLayout frameLayout;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            orNull = CollectionsKt___CollectionsKt.getOrNull(((FragmentPager) this.f324364m).pages, position);
            com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
            if (bVar != null) {
                z16 = true;
            }
            z16 = false;
            if (z16 && ((FragmentPager) this.f324364m).bottomPadding > 0) {
                View view = holder.itemView;
                if (view instanceof FrameLayout) {
                    frameLayout = (FrameLayout) view;
                } else {
                    frameLayout = null;
                }
                if (frameLayout != null) {
                    frameLayout.setPadding(0, 0, 0, ((FragmentPager) this.f324364m).bottomPadding);
                }
            }
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "", "", "c", "", "pageId", "b", "", NodeProps.VISIBLE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(boolean visible);

        void b(@NotNull String pageId);

        void c();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "", "", "xc", "", "curPageId", "", "isSelf", "X9", "onBackEvent", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface d {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public static final class a {
            public static void a(@NotNull d dVar, @NotNull String curPageId, boolean z16) {
                Intrinsics.checkNotNullParameter(curPageId, "curPageId");
            }
        }

        void P6(@NotNull b callback);

        void X9(@NotNull String curPageId, boolean isSelf);

        boolean onBackEvent();

        void xc();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/FragmentPager$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "f", "()Z", "swipeEnabled", "b", "I", "c", "()I", "orientation", "offscreenPageLimit", "d", "pageCacheSize", "e", "prefetchPageEnabled", "initialPagePos", "<init>", "(ZIIIZI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.pager.FragmentPager$e, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class PageConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean swipeEnabled;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int orientation;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int offscreenPageLimit;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pageCacheSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean prefetchPageEnabled;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int initialPagePos;

        public PageConfig() {
            this(false, 0, 0, 0, false, 0, 63, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getInitialPagePos() {
            return this.initialPagePos;
        }

        /* renamed from: b, reason: from getter */
        public final int getOffscreenPageLimit() {
            return this.offscreenPageLimit;
        }

        /* renamed from: c, reason: from getter */
        public final int getOrientation() {
            return this.orientation;
        }

        /* renamed from: d, reason: from getter */
        public final int getPageCacheSize() {
            return this.pageCacheSize;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getPrefetchPageEnabled() {
            return this.prefetchPageEnabled;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageConfig)) {
                return false;
            }
            PageConfig pageConfig = (PageConfig) other;
            if (this.swipeEnabled == pageConfig.swipeEnabled && this.orientation == pageConfig.orientation && this.offscreenPageLimit == pageConfig.offscreenPageLimit && this.pageCacheSize == pageConfig.pageCacheSize && this.prefetchPageEnabled == pageConfig.prefetchPageEnabled && this.initialPagePos == pageConfig.initialPagePos) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getSwipeEnabled() {
            return this.swipeEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            boolean z16 = this.swipeEnabled;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = ((((((r06 * 31) + this.orientation) * 31) + this.offscreenPageLimit) * 31) + this.pageCacheSize) * 31;
            boolean z17 = this.prefetchPageEnabled;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.initialPagePos;
        }

        @NotNull
        public String toString() {
            return "PageConfig(swipeEnabled=" + this.swipeEnabled + ", orientation=" + this.orientation + ", offscreenPageLimit=" + this.offscreenPageLimit + ", pageCacheSize=" + this.pageCacheSize + ", prefetchPageEnabled=" + this.prefetchPageEnabled + ", initialPagePos=" + this.initialPagePos + ")";
        }

        public PageConfig(boolean z16, int i3, int i16, int i17, boolean z17, int i18) {
            this.swipeEnabled = z16;
            this.orientation = i3;
            this.offscreenPageLimit = i16;
            this.pageCacheSize = i17;
            this.prefetchPageEnabled = z17;
            this.initialPagePos = i18;
        }

        public /* synthetic */ PageConfig(boolean z16, int i3, int i16, int i17, boolean z17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? true : z16, (i19 & 2) != 0 ? 0 : i3, (i19 & 4) != 0 ? -1 : i16, (i19 & 8) != 0 ? 2 : i17, (i19 & 16) == 0 ? z17 : true, (i19 & 32) != 0 ? 0 : i18);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/pager/FragmentPager$f", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "", "c", "", "pageId", "b", "", NodeProps.VISIBLE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f324371a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f324372b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentPager<T> f324373c;

        f(int i3, T t16, FragmentPager<T> fragmentPager) {
            this.f324371a = i3;
            this.f324372b = t16;
            this.f324373c = fragmentPager;
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void a(boolean visible) {
            this.f324373c.q(visible);
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void b(@NotNull String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            ((FragmentPager) this.f324373c).onSelectPage.invoke(pageId);
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void c() {
            w53.b.f("FragmentPager", "[loadedListener] loaded [" + this.f324371a + "]" + this.f324372b);
            this.f324373c.o(this.f324371a + (-1));
            this.f324373c.o(this.f324371a + 1);
            this.f324373c.o(this.f324371a + (-2));
            this.f324373c.o(this.f324371a + 2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/pager/FragmentPager$g", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentPager<T> f324374b;

        g(FragmentPager<T> fragmentPager) {
            this.f324374b = fragmentPager;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            Object orNull;
            String str;
            Object orNull2;
            Fragment fragment;
            d dVar;
            Class<?> cls;
            Lazy<T> b16;
            w53.b.a("FragmentPager", "onPageSelected position: " + position);
            orNull = CollectionsKt___CollectionsKt.getOrNull(((FragmentPager) this.f324374b).pages, position);
            com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
            if (bVar == null || (str = bVar.getPageId()) == null) {
                str = "";
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(((FragmentPager) this.f324374b).pages, position);
            com.tencent.mobileqq.wink.pager.b bVar2 = (com.tencent.mobileqq.wink.pager.b) orNull2;
            if (bVar2 != null && (b16 = bVar2.b()) != 0) {
                fragment = (Fragment) b16.getValue();
            } else {
                fragment = null;
            }
            List<Fragment> fragments = ((FragmentPager) this.f324374b).activity.getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "activity.supportFragmentManager.fragments");
            for (ActivityResultCaller it : fragments) {
                if (it instanceof d) {
                    dVar = (d) it;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Class<?> cls2 = it.getClass();
                    if (fragment != null) {
                        cls = fragment.getClass();
                    } else {
                        cls = null;
                    }
                    dVar.X9(str, Intrinsics.areEqual(cls2, cls));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentPager(@NotNull FragmentActivity activity, @NotNull ViewPager2 viewPager, @NotNull PageConfig pageConfig, @Nullable View view, @NotNull List<com.tencent.mobileqq.wink.pager.b<T>> pages, int i3, @NotNull Function1<? super String, Unit> onSelectPage) {
        TabLayout tabLayout;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(pageConfig, "pageConfig");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onSelectPage, "onSelectPage");
        this.activity = activity;
        this.viewPager = viewPager;
        this.pageConfig = pageConfig;
        this.tabLayout = view;
        this.pages = pages;
        this.bottomPadding = i3;
        this.onSelectPage = onSelectPage;
        g gVar = new g(this);
        this.pageChangeCallback = gVar;
        viewPager.setOrientation(pageConfig.getOrientation());
        viewPager.setOffscreenPageLimit(pageConfig.getOffscreenPageLimit());
        View childAt = viewPager.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) childAt;
        recyclerView.setItemViewCacheSize(pageConfig.getPageCacheSize());
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager);
        layoutManager.setItemPrefetchEnabled(pageConfig.getPrefetchPageEnabled());
        viewPager.setUserInputEnabled(pageConfig.getSwipeEnabled());
        viewPager.setAdapter(new a(this, activity));
        if (pageConfig.getInitialPagePos() > 0 && pageConfig.getInitialPagePos() < pages.size()) {
            viewPager.setCurrentItem(pageConfig.getInitialPagePos(), false);
        }
        viewPager.registerOnPageChangeCallback(gVar);
        p();
        if (view instanceof TabLayout) {
            tabLayout = (TabLayout) view;
        } else {
            tabLayout = null;
        }
        TabLayout tabLayout2 = tabLayout;
        if (tabLayout2 != null) {
            new com.google.android.material.tabs.d(tabLayout2, viewPager, true, false, new d.b() { // from class: com.tencent.mobileqq.wink.pager.a
                @Override // com.google.android.material.tabs.d.b
                public final void a(TabLayout.g gVar2, int i16) {
                    FragmentPager.k(FragmentPager.this, gVar2, i16);
                }
            }).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment h(int position) {
        com.tencent.mobileqq.wink.pager.b<T> bVar = this.pages.get(position);
        boolean c16 = bVar.c();
        boolean isPrefetched = bVar.getIsPrefetched();
        T value = bVar.b().getValue();
        if (!c16) {
            w53.b.f("FragmentPager", "[createPage] init [" + position + "]" + value);
        }
        if (isPrefetched) {
            w53.b.f("FragmentPager", "[createPage] get prefetched [" + position + "]" + value);
        }
        value.getLifecycle().addObserver(new FragmentLifecycleObserver(this, bVar.getPageId(), null, 2, null));
        value.P6(new f(position, value, this));
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FragmentPager this$0, TabLayout.g tab, int i3) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.pages, i3);
        com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
        if (bVar != null) {
            str = bVar.getPageName();
        } else {
            str = null;
        }
        tab.t(str);
        tab.n(tab.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.pages, position);
        com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
        if (bVar != null && !bVar.c() && !bVar.getIsPrefetched()) {
            Object obj = (Fragment) bVar.b().getValue();
            w53.b.f("FragmentPager", "[prefetchPage] [" + position + "]" + obj);
            ((d) obj).xc();
            bVar.j(true);
        }
    }

    private final void p() {
        d dVar;
        List<Fragment> fragments = this.activity.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "activity.supportFragmentManager.fragments");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if (activityResultCaller instanceof d) {
                dVar = (d) activityResultCaller;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.P6(new h(this));
                w53.b.a("FragmentPager", "resetFragmentMember currentPage " + dVar);
            }
        }
    }

    @Nullable
    public final com.tencent.mobileqq.wink.pager.b<T> i(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.pages, index);
        return (com.tencent.mobileqq.wink.pager.b) orNull;
    }

    public final int j(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        return c.a(this.pages, pageId);
    }

    public final void l(int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<T> it = this.pages.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) it.next();
            if (bVar.c()) {
                ((Fragment) bVar.b().getValue()).onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public final boolean m() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.pages, this.viewPager.getCurrentItem());
        com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
        if (bVar != null && bVar.c()) {
            return ((d) bVar.b().getValue()).onBackEvent();
        }
        return false;
    }

    public final void n() {
        this.viewPager.setAdapter(null);
        this.viewPager.unregisterOnPageChangeCallback(this.pageChangeCallback);
        this.pages.clear();
    }

    public final void q(boolean visible) {
        int i3;
        View view = this.tabLayout;
        if (view != null && view.getVisibility() != 8) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/FragmentPager$FragmentLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onCreate", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "Ljava/lang/String;", "fragmentTag", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "postResume", "<init>", "(Lcom/tencent/mobileqq/wink/pager/FragmentPager;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class FragmentLifecycleObserver implements LifecycleObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fragmentTag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function0<Unit> postResume;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FragmentPager<T> f324363f;

        public FragmentLifecycleObserver(@NotNull FragmentPager fragmentPager, @Nullable String fragmentTag, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
            this.f324363f = fragmentPager;
            this.fragmentTag = fragmentTag;
            this.postResume = function0;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onCreate(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onCreate");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onDestroy");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onPause");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onResume");
            Function0<Unit> function0 = this.postResume;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public final void onStart(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onStart");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onStop(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w53.b.f("FragmentPager", this.fragmentTag + " onStop");
        }

        public /* synthetic */ FragmentLifecycleObserver(FragmentPager fragmentPager, String str, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(fragmentPager, str, (i3 & 2) != 0 ? null : function0);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/pager/FragmentPager$h", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "", "c", "", "pageId", "b", "", NodeProps.VISIBLE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class h implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentPager<T> f324375a;

        h(FragmentPager<T> fragmentPager) {
            this.f324375a = fragmentPager;
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void a(boolean visible) {
            this.f324375a.q(visible);
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void b(@NotNull String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            ((FragmentPager) this.f324375a).onSelectPage.invoke(pageId);
        }

        @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
        public void c() {
        }
    }
}
