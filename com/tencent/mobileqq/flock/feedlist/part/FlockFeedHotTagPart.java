package com.tencent.mobileqq.flock.feedlist.part;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u00029:B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0002J\u001c\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R#\u00105\u001a\n 0*\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedHotTagPart;", "Lcom/tencent/mobileqq/flock/base/b;", "", "J9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lb55/g;", "it", "H9", "G9", "uiStateData", "I9", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "d", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "F9", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout;", "hotTagLayout", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/google/android/material/appbar/AppBarLayout;", tl.h.F, "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "i", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/flock/feedlist/adapter/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/flock/feedlist/adapter/e;", "flockHotTopicAdapter", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mCurVerticalOffset", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "feedListVm", "<init>", "(Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;)V", "E", "a", "b", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedHotTagPart extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurVerticalOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedListVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlockConstants$FlockListScene type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout hotTagLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.flock.feedlist.adapter.e flockHotTopicAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedHotTagPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.part.FlockFeedHotTagPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedHotTagPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "firstSpace", "e", "space", "<init>", "(II)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int firstSpace;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int space;

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.firstSpace = i3;
                this.space = i16;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = this.firstSpace;
                outRect.right = this.space;
                return;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null || childAdapterPosition != adapter.getNUM_BACKGOURND_ICON() - 1) {
                z16 = false;
            }
            if (!z16) {
                outRect.right = this.space;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/feedlist/part/FlockFeedHotTagPart$c", "Lcom/google/android/material/appbar/AppBarLayout$g;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements AppBarLayout.g {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedHotTagPart.this);
            }
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int verticalOffset) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appBarLayout, verticalOffset);
                return;
            }
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (FlockFeedHotTagPart.this.mCurVerticalOffset != verticalOffset) {
                FlockFeedHotTagPart.this.mCurVerticalOffset = verticalOffset;
                SmartRefreshLayout smartRefreshLayout = FlockFeedHotTagPart.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                if (verticalOffset >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                smartRefreshLayout.setEnabled(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedHotTagPart(@NotNull FlockConstants$FlockListScene type) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedlist.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedHotTagPart$feedListVm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedHotTagPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.flock.feedlist.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FlockFeedHotTagPart flockFeedHotTagPart = FlockFeedHotTagPart.this;
                return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) flockFeedHotTagPart.getViewModel(com.tencent.mobileqq.flock.feedlist.viewmodel.a.INSTANCE.a(flockFeedHotTagPart.F9()));
            }
        });
        this.feedListVm = lazy;
    }

    private final void D9() {
        com.tencent.mobileqq.flock.feedlist.adapter.e eVar = new com.tencent.mobileqq.flock.feedlist.adapter.e();
        eVar.setHasStableIds(true);
        this.flockHotTopicAdapter = eVar;
        RecyclerView recyclerView = this.recycleView;
        com.tencent.mobileqq.flock.feedlist.adapter.e eVar2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            recyclerView = null;
        }
        com.tencent.mobileqq.flock.feedlist.adapter.e eVar3 = this.flockHotTopicAdapter;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flockHotTopicAdapter");
        } else {
            eVar2 = eVar3;
        }
        recyclerView.setAdapter(eVar2);
    }

    private final com.tencent.mobileqq.flock.feedlist.viewmodel.a E9() {
        return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) this.feedListVm.getValue();
    }

    private final void G9(UIStateData<List<b55.g>> it) {
        ConstraintLayout constraintLayout = this.hotTagLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotTagLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(UIStateData<List<b55.g>> it) {
        int state = it.getState();
        if (state != 0) {
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        G9(it);
                        return;
                    }
                    return;
                }
                I9(it);
                return;
            }
            I9(it);
            return;
        }
        G9(it);
    }

    private final void I9(UIStateData<List<b55.g>> uiStateData) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullExpressionValue(uiStateData.getData(), "uiStateData.data");
        ConstraintLayout constraintLayout = null;
        com.tencent.mobileqq.flock.feedlist.adapter.e eVar = null;
        if (!r0.isEmpty()) {
            ConstraintLayout constraintLayout2 = this.hotTagLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hotTagLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(0);
            com.tencent.mobileqq.flock.feedlist.adapter.e eVar2 = this.flockHotTopicAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flockHotTopicAdapter");
                eVar2 = null;
            }
            List<b55.g> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            List<b55.g> list = data;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mobileqq.flock.feedlist.bean.a((b55.g) it.next()));
            }
            eVar2.k0(arrayList);
            com.tencent.mobileqq.flock.feedlist.adapter.e eVar3 = this.flockHotTopicAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flockHotTopicAdapter");
            } else {
                eVar = eVar3;
            }
            eVar.notifyDataSetChanged();
            return;
        }
        ConstraintLayout constraintLayout3 = this.hotTagLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotTagLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.setVisibility(8);
    }

    private final void J9() {
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            appBarLayout = null;
        }
        appBarLayout.e(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        com.tencent.mobileqq.flock.feedlist.viewmodel.g gVar;
        LiveData<UIStateData<List<b55.g>>> c26;
        com.tencent.mobileqq.flock.feedlist.viewmodel.a E9 = E9();
        if (E9 instanceof com.tencent.mobileqq.flock.feedlist.viewmodel.g) {
            gVar = (com.tencent.mobileqq.flock.feedlist.viewmodel.g) E9;
        } else {
            gVar = null;
        }
        if (gVar != null && (c26 = gVar.c2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends b55.g>>, Unit> function1 = new Function1<UIStateData<List<? extends b55.g>>, Unit>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedHotTagPart$initData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedHotTagPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends b55.g>> uIStateData) {
                    invoke2((UIStateData<List<b55.g>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<b55.g>> it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    FlockFeedHotTagPart flockFeedHotTagPart = FlockFeedHotTagPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedHotTagPart.H9(it);
                }
            };
            c26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feedlist.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FlockFeedHotTagPart.K9(Function1.this, obj);
                }
            });
        }
    }

    @NotNull
    public final FlockConstants$FlockListScene F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FlockConstants$FlockListScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.xbk);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hot_tag_cl)");
            this.hotTagLayout = (ConstraintLayout) findViewById;
            View findViewById2 = rootView.findViewById(R.id.vb9);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.flock_app_bar_layout)");
            this.appBarLayout = (AppBarLayout) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.f86434rn);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.smart_refresh_layout)");
            this.refreshLayout = (SmartRefreshLayout) findViewById3;
            View findViewById4 = rootView.findViewById(R.id.xbm);
            RecyclerView recyclerView = (RecyclerView) findViewById4;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new b(i.b(16), i.b(12)));
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<RecyclerVie\u2026dp, 12.dp))\n            }");
            this.recycleView = recyclerView;
            D9();
            J9();
            FlockConstants$FlockListScene flockConstants$FlockListScene = this.type;
            if (flockConstants$FlockListScene == FlockConstants$FlockListScene.RECOM || flockConstants$FlockListScene == FlockConstants$FlockListScene.ACTIVITY) {
                initData();
            }
        }
    }
}
