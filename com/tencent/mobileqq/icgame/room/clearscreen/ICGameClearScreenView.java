package com.tencent.mobileqq.icgame.room.clearscreen;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001d\u0018\u0000 *2\u00020\u0001:\u0004+,-\u000eB\u0019\u0012\u0006\u0010'\u001a\u00020&\u0012\b\b\u0001\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$c;", "listener", "", "setOnClearScreenStateChangeListener", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$d;", "setOnDispatchTouchEventListener", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "i", "", "d", "I", "contentContainerId", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "logger", "f", "Z", "isClearScreenState", h.F, "()I", "setScrollState", "(I)V", HippyTKDListViewAdapter.SCROLL_STATE, "com/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$e", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$e;", "pageChangeListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$c;", "onClearScreenStateChangeListener", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$d;", "onDispatchTouchEventListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "D", "a", "b", "c", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameClearScreenView extends ViewPager {

    @NotNull
    private static final b D = new b(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d onDispatchTouchEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int contentContainerId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isClearScreenState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e pageChangeListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c onClearScreenStateChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$a;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "position", "", "instantiateItem", "object", "", "destroyItem", "getCount", "Landroid/view/View;", "view", "", "isViewFromObject", "", "d", "Ljava/util/List;", "data", "<init>", "(Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView;Ljava/util/List;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    private final class a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<View> data;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ICGameClearScreenView f237437e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull ICGameClearScreenView iCGameClearScreenView, List<? extends View> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f237437e = iCGameClearScreenView;
            this.data = data;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            this.f237437e.logger.i("ICGameClearScreenView", "destroyItem " + position);
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.data.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.f237437e.logger.i("ICGameClearScreenView", "instantiateItem " + position);
            View view = this.data.get(position);
            if (view.getParent() == null) {
                container.addView(view);
            }
            return this.data.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            return Intrinsics.areEqual(view, object);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$b;", "", "", "PAGE_INDEX_CLEAR_SCREEN", "I", "PAGE_INDEX_NORMAL_SCREEN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    private static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$c;", "", "", "isClearScreenState", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface c {
        void a(boolean isClearScreenState);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$d;", "", "Landroid/view/MotionEvent;", "ev", "", "onDispatchTouchEvent", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface d {
        void onDispatchTouchEvent(@NotNull MotionEvent ev5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$e", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "state", "onPageScrollStateChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e extends ViewPager.SimpleOnPageChangeListener {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            ICGameClearScreenView.this.setScrollState(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            boolean z16;
            boolean z17 = true;
            if (positionOffset == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (position != 0) {
                    z17 = false;
                }
                if (z17 != ICGameClearScreenView.this.isClearScreenState) {
                    ICGameClearScreenView.this.isClearScreenState = z17;
                    ICGameClearScreenView.this.logger.i("ICGameClearScreenView", "onClearScreenStateChanged isClearScreenState=" + ICGameClearScreenView.this.isClearScreenState);
                    c cVar = ICGameClearScreenView.this.onClearScreenStateChangeListener;
                    if (cVar != null) {
                        cVar.a(ICGameClearScreenView.this.isClearScreenState);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICGameClearScreenView(@NotNull Context context, @IdRes int i3) {
        super(context);
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentContainerId = i3;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        e eVar = new e();
        this.pageChangeListener = eVar;
        View frameLayout = new FrameLayout(context);
        frameLayout.setId(i3);
        addView(frameLayout);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FrameLayout[]{new FrameLayout(context), frameLayout});
        setAdapter(new a(this, listOf));
        setOffscreenPageLimit(1);
        setCurrentItem(1);
        setOverScrollMode(2);
        addOnPageChangeListener(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        d dVar = this.onDispatchTouchEventListener;
        if (dVar != null) {
            dVar.onDispatchTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* renamed from: h, reason: from getter */
    public final int getScrollState() {
        return this.scrollState;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsClearScreenState() {
        return this.isClearScreenState;
    }

    public final void setOnClearScreenStateChangeListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onClearScreenStateChangeListener = listener;
    }

    public final void setOnDispatchTouchEventListener(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDispatchTouchEventListener = listener;
    }

    public final void setScrollState(int i3) {
        this.scrollState = i3;
    }
}
