package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.MainPageViewBinding;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.MainTitleIconGroup;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.QQKLAvatarViewExtKt;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel.CarouselLayout;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerOnlinePeopleEvent;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\t*\u0001!\b\u0000\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001(B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "C9", "D9", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "mainViewBinding", "", "", "e", "Lkotlin/Lazy;", "E9", "()Ljava/util/List;", "avatarValues", "com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$d", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$d;", "multListener", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainTitleBarPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: i, reason: collision with root package name */
    private static long f244209i = 22390;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MainPageViewBinding mainViewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy avatarValues;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final d multListener;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$b", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout$a;", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "a", "view", "", "bindView", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements CarouselLayout.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f244213a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MainTitleBarPart f244214b;

        b(Ref.IntRef intRef, MainTitleBarPart mainTitleBarPart) {
            this.f244213a = intRef;
            this.f244214b = mainTitleBarPart;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel.CarouselLayout.a
        public void bindView(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (this.f244213a.element == this.f244214b.E9().size()) {
                this.f244213a.element = 0;
            }
            MainTitleBarPart mainTitleBarPart = this.f244214b;
            Ref.IntRef intRef = this.f244213a;
            v72.c.b("getUrlDrawable");
            QQKLAvatarView.d((QQKLAvatarView) view, (String) mainTitleBarPart.E9().get(intRef.element), null, 2, null);
            v72.c.e();
            this.f244213a.element++;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel.CarouselLayout.a
        public View createView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return QQKLAvatarViewExtKt.b(context, 0.0f, 0, 0, 14, null);
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel.CarouselLayout.a
        public int a() {
            return com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(5);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$c", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "view", "view2", "view3", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f244215a;

        c(List<String> list) {
            this.f244215a = list;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.b
        public void a(QQKLAvatarView view, QQKLAvatarView view2, QQKLAvatarView view3) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(view2, "view2");
            Intrinsics.checkNotNullParameter(view3, "view3");
            QQKLAvatarView.d(view, this.f244215a.get(0), null, 2, null);
            QQKLAvatarView.d(view2, this.f244215a.get(1), null, 2, null);
            QQKLAvatarView.d(view3, this.f244215a.get(2), null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0017J:\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\"\u0010\u0016\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\"\u0010\u0017\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\rH\u0016J:\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\"\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\"\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001a\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\rH\u0016\u00a8\u0006!"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$d", "Lr3/f;", "Lq3/f;", "refreshLayout", "", "e", "E6", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "Lq3/d;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", "Pe", "vf", "success", "Tf", "Lq3/c;", "footer", "footerHeight", "kb", "Z7", "k6", "cd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements r3.f {
        d() {
        }

        @Override // r3.f
        public void B9(q3.d header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            QLog.d("MainTitleBarPart", 4, "onHeaderMoving " + isDragging + "  offset " + offset);
        }

        @Override // r3.e
        public void E6(q3.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        }

        @Override // r3.i
        public void d(q3.f refreshLayout, RefreshState oldState, RefreshState newState) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(newState, "newState");
        }

        @Override // r3.h
        public void e(q3.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        }

        @Override // r3.f
        public void Pe(q3.d header, int headerHeight, int maxDragHeight) {
            QLog.d("MainTitleBarPart", 4, "onHeaderReleased ");
        }

        @Override // r3.f
        public void Tf(q3.d header, boolean success) {
        }

        @Override // r3.f
        public void cd(q3.c footer, boolean success) {
        }

        @Override // r3.f
        public void kb(q3.c footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
        }

        @Override // r3.f
        public void Z7(q3.c footer, int footerHeight, int maxDragHeight) {
        }

        @Override // r3.f
        public void k6(q3.c footer, int footerHeight, int maxDragHeight) {
        }

        @Override // r3.f
        public void vf(q3.d header, int headerHeight, int maxDragHeight) {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/MainTitleBarPart$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            View findViewByPosition = ((LinearLayoutManager) layoutManager).findViewByPosition(0);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                float abs = Math.abs(top - (((ViewGroup.MarginLayoutParams) layoutParams) != null ? r2.topMargin : 0)) / findViewByPosition.getHeight();
                TextView g16 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().g();
                if (g16 != null) {
                    g16.setAlpha(1 - abs);
                }
                CarouselLayout e16 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().e();
                if (e16 != null) {
                    e16.setAlpha(1 - abs);
                }
                MainTitleIconGroup f16 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().f();
                if (f16 != null) {
                    f16.setAlpha(abs);
                }
            } else {
                TextView g17 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().g();
                if (g17 != null) {
                    g17.setAlpha(0.0f);
                }
                CarouselLayout e17 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().e();
                if (e17 != null) {
                    e17.setAlpha(0.0f);
                }
                MainTitleIconGroup f17 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().f();
                if (f17 != null) {
                    f17.setAlpha(1.0f);
                }
            }
            CarouselLayout e18 = MainTitleBarPart.this.mainViewBinding.getTitleBarViewBinding().e();
            if (e18 != null) {
                if (e18.getAlpha() == 0.0f) {
                    if (e18.getVisibility() == 0) {
                        e18.setVisibility(8);
                        e18.f();
                        return;
                    }
                    return;
                }
                if (e18.getVisibility() == 8) {
                    e18.setVisibility(0);
                    e18.i();
                }
            }
        }
    }

    public MainTitleBarPart(MainPageViewBinding mainViewBinding) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mainViewBinding, "mainViewBinding");
        this.mainViewBinding = mainViewBinding;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.MainTitleBarPart$avatarValues$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                List<Pair> zip;
                List drop;
                List plus;
                List drop2;
                List<? extends String> plus2;
                List listOf;
                com.tencent.mobileqq.matchfriend.reborn.config.c cVar = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a;
                List<String> e16 = cVar.c().e();
                List<String> c16 = cVar.c().c();
                List<String> list = e16;
                zip = CollectionsKt___CollectionsKt.zip(list, c16);
                ArrayList arrayList = new ArrayList();
                for (Pair pair : zip) {
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{(String) pair.component1(), (String) pair.component2()});
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
                }
                drop = CollectionsKt___CollectionsKt.drop(list, c16.size());
                plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) drop);
                drop2 = CollectionsKt___CollectionsKt.drop(c16, e16.size());
                plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) drop2);
                return plus2;
            }
        });
        this.avatarValues = lazy;
        this.multListener = new d();
    }

    private final void B9() {
        if (E9().isEmpty()) {
            QLog.d("MainTitleBarPart", 2, "avatarValues is empty!");
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        CarouselLayout e16 = this.mainViewBinding.getTitleBarViewBinding().e();
        if (e16 != null) {
            e16.setAdapter(new b(intRef, this));
        }
        CarouselLayout e17 = this.mainViewBinding.getTitleBarViewBinding().e();
        if (e17 != null) {
            e17.j();
        }
    }

    private final void C9() {
        List shuffled;
        List take;
        if (E9().isEmpty()) {
            return;
        }
        shuffled = CollectionsKt__CollectionsJVMKt.shuffled(E9());
        take = CollectionsKt___CollectionsKt.take(shuffled, 3);
        MainTitleIconGroup f16 = this.mainViewBinding.getTitleBarViewBinding().f();
        if (f16 != null) {
            f16.setAdapter(new c(take));
        }
    }

    private final void D9() {
        TextView g16 = this.mainViewBinding.getTitleBarViewBinding().g();
        if (g16 == null) {
            return;
        }
        g16.setText(f244209i + "\u4eba\u5728\u7ebf\u7ed3\u4f34");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> E9() {
        return (List) this.avatarValues.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(MainTitleBarPart this$0, String onlineText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onlineText, "$onlineText");
        TextView g16 = this$0.mainViewBinding.getTitleBarViewBinding().g();
        if (g16 == null) {
            return;
        }
        g16.setText(onlineText);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerOnlinePeopleEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.mainViewBinding.getRefreshLayout().c(this.multListener);
        this.mainViewBinding.getRecyclerView().addOnScrollListener(new e());
        B9();
        D9();
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.mainViewBinding.getRefreshLayout().O(this.multListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerOnlinePeopleEvent) {
            long onlinePeople = ((QQStrangerOnlinePeopleEvent) event).getOnlinePeople();
            final String str = onlinePeople + "\u4eba\u5728\u7ebf\u7ed3\u4f34";
            f244209i = onlinePeople;
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainTitleBarPart.F9(MainTitleBarPart.this, str);
                }
            });
        }
    }
}
