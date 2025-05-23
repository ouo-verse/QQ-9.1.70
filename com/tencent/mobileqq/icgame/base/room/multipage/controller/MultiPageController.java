package com.tencent.mobileqq.icgame.base.room.multipage.controller;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchDirection;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.base.room.multipage.api.d;
import com.tencent.mobileqq.icgame.base.room.multipage.api.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005*\u0002>B\u0018\u0000 \u00182\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J@\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010#\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010,R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R!\u0010=\u001a\b\u0012\u0004\u0012\u00020$088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010CR \u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100F0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "l", "", "position", "", ReportConstant.COSTREPORT_PREFIX, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "lifeCycleOwner", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "switchInfo", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/c;", "switchInfoDataModel", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/b;", "pageCreator", "Le22/a;", "logImpl", "k", "i", "Landroid/content/res/Configuration;", "newConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pageInfo", "r", "p", "t", "o", DomainData.DOMAIN_NAME, "getCurrentItem", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/a;", "listener", "b", "a", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageViewPager;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageViewPager;", "viewPager", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/c;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/c;", "pageAdapter", "c", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/c;", "d", "Landroidx/lifecycle/LifecycleOwner;", "e", "Z", "isNewIntent", "f", "I", "curPosition", "", "g", "Lkotlin/Lazy;", "j", "()Ljava/util/List;", "pageChangeListenerList", "com/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$b", h.F, "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$b;", "pageChangeCallback", "com/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$c", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$c;", "pageOperationListener", "Landroidx/lifecycle/Observer;", "", "Landroidx/lifecycle/Observer;", "dataObserver", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiPageController implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MultiPageViewPager viewPager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.icgame.base.room.multipage.controller.c pageAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.icgame.base.room.multipage.api.c switchInfoDataModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isNewIntent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pageChangeListenerList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b pageChangeCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c pageOperationListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<SwitchPageInfo>> dataObserver;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$b", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/a;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "y0", "t1", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements a {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            Iterator it = MultiPageController.this.j().iterator();
            while (it.hasNext()) {
                ((a) it.next()).onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Iterator it = MultiPageController.this.j().iterator();
            while (it.hasNext()) {
                ((a) it.next()).onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            if (position == 0 && MultiPageController.this.curPosition == position) {
                MultiPageController.this.n(position);
            } else {
                MultiPageController multiPageController = MultiPageController.this;
                multiPageController.o(multiPageController.curPosition);
                MultiPageController.this.n(position);
            }
            MultiPageController.this.curPosition = position;
            Iterator it = MultiPageController.this.j().iterator();
            while (it.hasNext()) {
                ((a) it.next()).onPageSelected(position);
            }
        }

        @Override // com.tencent.mobileqq.icgame.base.room.multipage.controller.a
        public void t1() {
            Iterator it = MultiPageController.this.j().iterator();
            while (it.hasNext()) {
                ((a) it.next()).t1();
            }
        }

        @Override // com.tencent.mobileqq.icgame.base.room.multipage.controller.a
        public void y0() {
            Iterator it = MultiPageController.this.j().iterator();
            while (it.hasNext()) {
                ((a) it.next()).y0();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController$c", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "", "index", "", "a", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.e
        public void a(int index) {
            e22.b.f395373a.a().i("ICGameMultiPageController", "querySwitchInfoList index = " + index);
            MultiPageController.this.s(index);
        }
    }

    public MultiPageController() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<a>>() { // from class: com.tencent.mobileqq.icgame.base.room.multipage.controller.MultiPageController$pageChangeListenerList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<a> invoke() {
                return new ArrayList();
            }
        });
        this.pageChangeListenerList = lazy;
        this.pageChangeCallback = new b();
        this.pageOperationListener = new c();
        this.dataObserver = new Observer() { // from class: com.tencent.mobileqq.icgame.base.room.multipage.controller.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiPageController.h(MultiPageController.this, (List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MultiPageController this$0, List it) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e22.b bVar = e22.b.f395373a;
        e22.a a16 = bVar.a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("switchListUpdated,switchList.size = ");
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = null;
        if (it != null) {
            num = Integer.valueOf(it.size());
        } else {
            num = null;
        }
        sb5.append(num);
        a16.i("ICGameMultiPageController", sb5.toString());
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar2 = this$0.pageAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar2 = null;
        }
        if (!cVar2.g().isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!it.isEmpty()) {
                Object obj = it.get(0);
                com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar3 = this$0.pageAdapter;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
                    cVar3 = null;
                }
                if (!Intrinsics.areEqual(obj, cVar3.g().get(0))) {
                    bVar.a().i("ICGameMultiPageController", "current page is a new page,not process last page preload info");
                    return;
                }
            }
        }
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar4 = this$0.pageAdapter;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
        } else {
            cVar = cVar4;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        cVar.j(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<a> j() {
        return (List) this.pageChangeListenerList.getValue();
    }

    private final void l(LifecycleOwner lifecycleOwner) {
        com.tencent.mobileqq.icgame.base.room.multipage.api.c cVar = this.switchInfoDataModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchInfoDataModel");
            cVar = null;
        }
        cVar.Z0().observe(lifecycleOwner, this.dataObserver);
    }

    private final void m(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.zjj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.multi_viewpager)");
        MultiPageViewPager multiPageViewPager = (MultiPageViewPager) findViewById;
        this.viewPager = multiPageViewPager;
        if (multiPageViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        MultiPageViewPager multiPageViewPager2 = this.viewPager;
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = null;
        if (multiPageViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            multiPageViewPager2 = null;
        }
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar2 = this.pageAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar2 = null;
        }
        multiPageViewPager2.setAdapter(cVar2);
        MultiPageViewPager multiPageViewPager3 = this.viewPager;
        if (multiPageViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            multiPageViewPager3 = null;
        }
        multiPageViewPager3.setOffscreenPageLimit(1);
        MultiPageViewPager multiPageViewPager4 = this.viewPager;
        if (multiPageViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            multiPageViewPager4 = null;
        }
        multiPageViewPager4.setOnPageChangeListener(this.pageChangeCallback);
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar3 = this.pageAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(int position) {
        e22.b.f395373a.a().i("ICGameMultiPageController", "notify switchInfoDataModel querydata position = " + position);
        SwitchDirection switchDirection = SwitchDirection.DIRECTION_DOWN;
        if (position == 0) {
            switchDirection = SwitchDirection.DIRECTION_INIT;
        } else {
            int i3 = this.curPosition;
            if (position <= i3 && position < i3) {
                switchDirection = SwitchDirection.DIRECTION_UP;
            }
        }
        com.tencent.mobileqq.icgame.base.room.multipage.api.c cVar = this.switchInfoDataModel;
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchInfoDataModel");
            cVar = null;
        }
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar3 = this.pageAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
        } else {
            cVar2 = cVar3;
        }
        cVar.u1(cVar2.g(), switchDirection, position);
        return true;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.d
    public void a(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        j().remove(listener);
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.d
    public void b(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (j().contains(listener)) {
            return;
        }
        j().add(listener);
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.d
    public int getCurrentItem() {
        MultiPageViewPager multiPageViewPager = this.viewPager;
        if (multiPageViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            multiPageViewPager = null;
        }
        return multiPageViewPager.t();
    }

    @NotNull
    public final SwitchPageInfo i() {
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = this.pageAdapter;
        MultiPageViewPager multiPageViewPager = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar = null;
        }
        MultiPageViewPager multiPageViewPager2 = this.viewPager;
        if (multiPageViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            multiPageViewPager = multiPageViewPager2;
        }
        SwitchPageInfo f16 = cVar.f(multiPageViewPager.t());
        Intrinsics.checkNotNull(f16);
        return f16;
    }

    public final void k(@NotNull ViewGroup rootView, @NotNull FragmentManager fragmentManager, @NotNull LifecycleOwner lifeCycleOwner, @Nullable SwitchPageInfo switchInfo, @NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.c switchInfoDataModel, @NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.b pageCreator, @NotNull e22.a logImpl) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(switchInfoDataModel, "switchInfoDataModel");
        Intrinsics.checkNotNullParameter(pageCreator, "pageCreator");
        Intrinsics.checkNotNullParameter(logImpl, "logImpl");
        e22.b.f395373a.b(logImpl);
        this.pageAdapter = new com.tencent.mobileqq.icgame.base.room.multipage.controller.c(switchInfo, fragmentManager, pageCreator, this, this.pageOperationListener);
        this.switchInfoDataModel = switchInfoDataModel;
        this.lifecycleOwner = lifeCycleOwner;
        LayoutInflater.from(rootView.getContext()).inflate(R.layout.fag, rootView);
        m(rootView);
        l(lifeCycleOwner);
    }

    public final void n(int position) {
        e22.b.f395373a.a().i("ICGameMultiPageController", "notifyPageSelected position = " + position);
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = this.pageAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar = null;
        }
        ActivityResultCaller item = cVar.getItem(position);
        if (item instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
            ((com.tencent.mobileqq.icgame.base.room.multipage.api.a) item).a0();
            return;
        }
        throw new IllegalArgumentException("fragment must implement IFramePage!");
    }

    public final void o(int position) {
        e22.b.f395373a.a().i("ICGameMultiPageController", "notifyPageSwitchOut position = " + position);
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = this.pageAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar = null;
        }
        ActivityResultCaller item = cVar.getItem(position);
        if (item instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
            ((com.tencent.mobileqq.icgame.base.room.multipage.api.a) item).eb();
            return;
        }
        throw new IllegalArgumentException("fragment must implement IFramePage!");
    }

    public final boolean p() {
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = this.pageAdapter;
        MultiPageViewPager multiPageViewPager = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar = null;
        }
        MultiPageViewPager multiPageViewPager2 = this.viewPager;
        if (multiPageViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            multiPageViewPager = multiPageViewPager2;
        }
        ActivityResultCaller item = cVar.getItem(multiPageViewPager.t());
        if (item instanceof com.tencent.mobileqq.icgame.base.room.multipage.api.a) {
            return ((com.tencent.mobileqq.icgame.base.room.multipage.api.a) item).onBackPressed();
        }
        throw new IllegalArgumentException("fragment must implement IFramePage!");
    }

    public final void q(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.viewPager != null) {
            e22.a a16 = e22.b.f395373a.a();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onConfigChangecurrentItem ");
            MultiPageViewPager multiPageViewPager = this.viewPager;
            if (multiPageViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                multiPageViewPager = null;
            }
            sb5.append(multiPageViewPager.t());
            a16.i("ICGameMultiPageController", sb5.toString());
        }
    }

    public final void r(@NotNull SwitchPageInfo pageInfo) {
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        this.isNewIntent = true;
        this.curPosition = 0;
        com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar = this.pageAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            cVar = null;
        }
        cVar.i(pageInfo);
        this.isNewIntent = false;
    }

    public final void t() {
        com.tencent.mobileqq.icgame.base.room.multipage.api.c cVar = this.switchInfoDataModel;
        if (cVar != null) {
            com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchInfoDataModel");
                cVar = null;
            }
            cVar.Z0().removeObserver(this.dataObserver);
            com.tencent.mobileqq.icgame.base.room.multipage.api.c cVar3 = this.switchInfoDataModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchInfoDataModel");
                cVar3 = null;
            }
            cVar3.B0();
            MultiPageViewPager multiPageViewPager = this.viewPager;
            if (multiPageViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                multiPageViewPager = null;
            }
            multiPageViewPager.setOnPageChangeListener(null);
            com.tencent.mobileqq.icgame.base.room.multipage.controller.c cVar4 = this.pageAdapter;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            } else {
                cVar2 = cVar4;
            }
            cVar2.h();
        }
        j().clear();
    }
}
