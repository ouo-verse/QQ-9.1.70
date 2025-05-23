package com.tencent.qqnt.aio.bottombar.sectionbar;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.msf.core.net.u.c.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarMviUIState;
import com.tencent.qqnt.aio.bottombar.sectionbar.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.event.BottomSectionBarEvent;
import com.tencent.qqnt.aio.bottombar.sectionbar.view.InterceptTouchEventRecyclerView;
import com.tencent.qqnt.aio.utils.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000278B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010\u001a\u001a\u00020\u00062\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/b;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "model", "", "g1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "modelList", "h1", "e1", "f1", "k1", "i1", "d1", "j1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "mUIModel", "afterCreateVM", "state", "c1", "bindViewAndData", "", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "d", "Ljava/util/Map;", "bottomSectionBarAdapterMap", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/a;", "e", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/a;", "bottomSectionBarAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "i", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "reporter", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BottomSectionBarVB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.bottombar.sectionbar.b, BottomSectionBarMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, ? extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> bottomSectionBarAdapterMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a bottomSectionBarAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.bottombar.sectionbar.report.b reporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVB$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB$b;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "b", "", "sectionType", "Lol3/b;", "intent", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB;", "Ljava/lang/ref/WeakReference;", "weakThis", "vb", "<init>", "(Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.aio.bottombar.sectionbar.adapter.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<BottomSectionBarVB> weakThis;

        public b(@NotNull BottomSectionBarVB vb5) {
            Intrinsics.checkNotNullParameter(vb5, "vb");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vb5);
            } else {
                this.weakThis = new WeakReference<>(vb5);
            }
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.a
        public void a(int sectionType, @NotNull ol3.b intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, sectionType, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            BottomSectionBarVB bottomSectionBarVB = this.weakThis.get();
            if (bottomSectionBarVB != null) {
                bottomSectionBarVB.sendIntent(new b.C9471b(sectionType, intent));
            }
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.a
        public void b(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
                return;
            }
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            BottomSectionBarVB bottomSectionBarVB = this.weakThis.get();
            if (bottomSectionBarVB != null) {
                bottomSectionBarVB.sendIntent(new b.a(msgIntent));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVB$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int b16 = l.b(7);
            int b17 = l.b(16);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                i3 = layoutManager.getItemCount();
            }
            outRect.left = b16;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
            if (viewLayoutPosition == 0) {
                outRect.left = b17;
            } else if (viewLayoutPosition == i3 - 1) {
                outRect.left = b16;
                outRect.right = b17;
            } else {
                outRect.left = b16;
            }
            outRect.top = l.b(8);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(g.f249461c);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BottomSectionBarVB() {
        Map<Integer, ? extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.bottomSectionBarAdapterMap = emptyMap;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1() {
        com.tencent.aio.api.runtime.a aVar;
        j e16;
        ViewGroup viewGroup = this.containerView;
        boolean z16 = false;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                e16.h(BottomSectionBarEvent.OnBottomSectionBarHide.f349815d);
            }
            ViewGroup viewGroup2 = this.containerView;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
                com.tencent.qqnt.aio.bottombar.sectionbar.report.b bVar = this.reporter;
                if (bVar != null) {
                    bVar.a(viewGroup2, 8);
                }
            }
        }
    }

    private final void e1() {
        com.tencent.qqnt.aio.bottombar.sectionbar.report.b bVar;
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> c16;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel == null) {
            QLog.i("BottomSectionBarVB", 1, "initAdaptersIfNeed but VM is null.");
            return;
        }
        if (this.bottomSectionBarAdapterMap.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BottomSectionBarVB", 4, "init bottomSectionBarAdapterMap.");
            }
            com.tencent.qqnt.aio.bottombar.sectionbar.loader.c a16 = com.tencent.qqnt.aio.bottombar.sectionbar.loader.a.f349818a.a(((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).g().r().c().e());
            if (a16 != null && (c16 = a16.c()) != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj : c16) {
                    linkedHashMap.put(Integer.valueOf(((com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) obj).c()), obj);
                }
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ((com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) ((Map.Entry) it.next()).getValue()).m(new b(this));
                }
                this.bottomSectionBarAdapterMap = linkedHashMap;
            }
            Iterator<Map.Entry<Integer, ? extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b>> it5 = this.bottomSectionBarAdapterMap.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().l((com.tencent.aio.api.runtime.a) mUIModel.getMContext());
            }
        }
        if (this.reporter == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BottomSectionBarVB", 4, "init reporter.");
            }
            com.tencent.qqnt.aio.bottombar.sectionbar.loader.c a17 = com.tencent.qqnt.aio.bottombar.sectionbar.loader.a.f349818a.a(((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).g().r().c().e());
            if (a17 != null) {
                bVar = a17.b();
            } else {
                bVar = null;
            }
            this.reporter = bVar;
            ViewGroup viewGroup = this.containerView;
            if (viewGroup != null && bVar != null) {
                bVar.b(viewGroup, (com.tencent.aio.api.runtime.a) mUIModel.getMContext());
            }
        }
    }

    private final void f1() {
        if (this.bottomSectionBarAdapter == null || this.recyclerView == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BottomSectionBarVB", 4, "initViewIfNeed, bottomSectionBarAdapterMap size = " + this.bottomSectionBarAdapterMap.size());
            }
            this.bottomSectionBarAdapter = new a(this.bottomSectionBarAdapterMap);
            InterceptTouchEventRecyclerView interceptTouchEventRecyclerView = new InterceptTouchEventRecyclerView(getMContext());
            interceptTouchEventRecyclerView.setItemAnimator(null);
            interceptTouchEventRecyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            interceptTouchEventRecyclerView.setOverScrollMode(2);
            interceptTouchEventRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 0, false));
            interceptTouchEventRecyclerView.setAdapter(this.bottomSectionBarAdapter);
            interceptTouchEventRecyclerView.addItemDecoration(new c());
            ViewGroup viewGroup = this.containerView;
            if (viewGroup != null) {
                viewGroup.addView(interceptTouchEventRecyclerView);
            }
            this.recyclerView = interceptTouchEventRecyclerView;
        }
    }

    private final void g1(com.tencent.qqnt.aio.bottombar.sectionbar.model.b model) {
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(model);
        h1(arrayListOf);
    }

    private final void h1(ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> modelList) {
        if (modelList.isEmpty()) {
            return;
        }
        e1();
        f1();
        a aVar = this.bottomSectionBarAdapter;
        if (aVar != null) {
            aVar.k0(modelList, new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVB$submitSections$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomSectionBarVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
                
                    r4 = r3.this$0.recyclerView;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16) {
                    RecyclerView recyclerView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    } else {
                        if (!z16 || recyclerView == null) {
                            return;
                        }
                        recyclerView.scrollToPosition(0);
                    }
                }
            });
        }
        k1();
    }

    private final void i1() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar;
        j e16;
        a aVar2 = this.bottomSectionBarAdapter;
        if (aVar2 != null) {
            boolean z17 = true;
            if (aVar2 != null && aVar2.i0() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ViewGroup viewGroup = this.containerView;
                if (viewGroup == null || viewGroup.getVisibility() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    ViewGroup viewGroup2 = this.containerView;
                    if (viewGroup2 != null) {
                        viewGroup2.setVisibility(0);
                        com.tencent.qqnt.aio.bottombar.sectionbar.report.b bVar = this.reporter;
                        if (bVar != null) {
                            bVar.a(viewGroup2, 0);
                        }
                    }
                    FrameworkVM mUIModel = getMUIModel();
                    if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                        e16.h(BottomSectionBarEvent.OnBottomSectionBarShow.f349816d);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("BottomSectionBarVB", 4, "tryShowBottomSectionBar");
                    }
                }
            }
        }
    }

    private final void j1() {
        com.tencent.aio.api.runtime.a aVar;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext();
        } else {
            aVar = null;
        }
        if ((aVar != null && AIOUtil.f194084a.b(aVar)) || QQTheme.isVasTheme()) {
            getHostView().setBackgroundColor(0);
        } else {
            getHostView().setBackgroundResource(com.tencent.mobileqq.aio.input.themecompat.a.f189924a.c());
        }
    }

    private final void k1() {
        if (QLog.isDevelopLevel()) {
            QLog.d("BottomSectionBarVB", 4, "updateVisible");
        }
        a aVar = this.bottomSectionBarAdapter;
        if (aVar != null) {
            boolean z16 = false;
            if (aVar != null && aVar.i0() == 0) {
                z16 = true;
            }
            if (!z16) {
                i1();
                return;
            }
        }
        d1();
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<com.tencent.qqnt.aio.bottombar.sectionbar.b, BottomSectionBarMviUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.qqnt.aio.bottombar.sectionbar.report.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (mUIModel == null) {
            return;
        }
        Iterator<Map.Entry<Integer, ? extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b>> it = this.bottomSectionBarAdapterMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().l(mUIModel.getMContext());
        }
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null && (bVar = this.reporter) != null) {
            bVar.b(viewGroup, mUIModel.getMContext());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.bindViewAndData();
            j1();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull BottomSectionBarMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof BottomSectionBarMviUIState.SubmitSection) {
            g1(((BottomSectionBarMviUIState.SubmitSection) state).a());
            return;
        }
        if (state instanceof BottomSectionBarMviUIState.SubmitSections) {
            h1(((BottomSectionBarMviUIState.SubmitSections) state).a());
            return;
        }
        if (state instanceof BottomSectionBarMviUIState.ShowBottomSectionBar) {
            i1();
            return;
        }
        if (state instanceof BottomSectionBarMviUIState.HideBottomSectionBar) {
            d1();
            return;
        }
        if (state instanceof BottomSectionBarMviUIState.PostThemeChanged) {
            j1();
            a aVar = this.bottomSectionBarAdapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (state instanceof BottomSectionBarMviUIState.BusinessUIState) {
            BottomSectionBarMviUIState.BusinessUIState businessUIState = (BottomSectionBarMviUIState.BusinessUIState) state;
            com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.bottomSectionBarAdapterMap.get(Integer.valueOf(businessUIState.a()));
            if (bVar != null) {
                bVar.d(businessUIState.b());
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<com.tencent.qqnt.aio.bottombar.sectionbar.b, BottomSectionBarMviUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new BottomSectionBarVM();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(getMContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout.setVisibility(8);
        this.containerView = frameLayout;
        return frameLayout;
    }
}
