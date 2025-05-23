package com.tencent.mobileqq.sharepanel.action;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u001c*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/action/ShareActionPart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "R9", "Lcom/tencent/mobileqq/sharepanel/action/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "X9", "Lcom/tencent/mobileqq/sharepanel/action/a;", "W9", "S9", "Z9", "Y9", "aa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "e", "Landroid/view/View;", "actionContainer", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "channelViewPager", tl.h.F, "actionViewPager", "i", "actionDivider", "Lcom/tencent/mobileqq/sharepanel/action/i;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/sharepanel/action/i;", "actionViewModel", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", BdhLogUtil.LogTag.Tag_Conn, "Q9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectVM", "", "D", "Ljava/util/List;", "shareChannelShowList", "E", "appendActionShowList", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", UserInfo.SEX_FEMALE, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionPart extends com.tencent.mobileqq.sharepanel.part.i {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy multiSelectVM;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<j> shareChannelShowList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<a> appendActionShowList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View actionContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView channelViewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView actionViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View actionDivider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy actionViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/action/ShareActionPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.action.ShareActionPart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/sharepanel/action/ShareActionPart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
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
            super.getItemOffsets(outRect, view, parent, state);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                i3 = adapter.getNUM_BACKGOURND_ICON();
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.left = ViewUtils.dpToPx(4.0f);
            outRect.right = ViewUtils.dpToPx(4.0f);
            if (childAdapterPosition == 0) {
                outRect.left = ViewUtils.dpToPx(8.0f);
            }
            if (childAdapterPosition == i3 - 1) {
                outRect.right = ViewUtils.dpToPx(8.0f);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareActionPart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Lazy lazy2;
        List<j> emptyList;
        List<a> emptyList2;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$actionViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final i invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (i) ShareActionPart.this.getViewModel(i.class) : (i) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.actionViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$multiSelectVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) ShareActionPart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectVM = lazy2;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.shareChannelShowList = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.appendActionShowList = emptyList2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final i P9() {
        return (i) this.actionViewModel.getValue();
    }

    private final com.tencent.mobileqq.sharepanel.multiSelect.vm.a Q9() {
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) this.multiSelectVM.getValue();
    }

    private final void R9() {
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$initRecyclerView$onItemClickListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull e item) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
                    return;
                }
                Intrinsics.checkNotNullParameter(item, "item");
                if (item instanceof j) {
                    ShareActionPart.this.X9((j) item);
                } else if (item instanceof a) {
                    ShareActionPart.this.W9((a) item);
                }
            }
        };
        b bVar = new b();
        RecyclerView recyclerView = this.channelViewPager;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(bVar);
            c cVar = new c();
            cVar.o0(function1);
            recyclerView.setAdapter(cVar);
        }
        RecyclerView recyclerView2 = this.actionViewPager;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            recyclerView2.addItemDecoration(bVar);
            c cVar2 = new c();
            cVar2.o0(function1);
            recyclerView2.setAdapter(cVar2);
        }
    }

    private final void S9() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null) {
            lifecycleOwner = partHost.getLifecycleOwner();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            return;
        }
        MutableLiveData<Unit> M1 = P9().M1();
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$observerData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                } else {
                    ShareActionPart.this.Z9();
                    ShareActionPart.this.aa();
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.action.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShareActionPart.T9(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> L1 = P9().L1();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$observerData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                } else {
                    ShareActionPart.this.Y9();
                    ShareActionPart.this.aa();
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.action.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShareActionPart.U9(Function1.this, obj);
            }
        });
        MutableLiveData<List<SharePanelContactItem>> M12 = Q9().M1();
        final Function1<List<SharePanelContactItem>, Unit> function13 = new Function1<List<SharePanelContactItem>, Unit>() { // from class: com.tencent.mobileqq.sharepanel.action.ShareActionPart$observerData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SharePanelContactItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SharePanelContactItem> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ShareActionPart.this.aa();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                }
            }
        };
        M12.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.action.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShareActionPart.V9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(a item) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (u.a().c(300L)) {
            return;
        }
        if (!item.b()) {
            com.tencent.mobileqq.sharepanel.h m3 = F9().m();
            if (m3 != null) {
                m3.a(item.a());
                return;
            }
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new ShareActionPart$onAppendActionClick$1(this, item, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(j item) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (u.a().c(300L)) {
            return;
        }
        if (!item.b()) {
            com.tencent.mobileqq.sharepanel.h m3 = F9().m();
            if (m3 != null) {
                m3.b(item.h());
                return;
            }
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new ShareActionPart$onShareChannelClick$1(this, item, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        RecyclerView.Adapter adapter;
        List<a> a16 = F9().a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (((a) obj).e()) {
                arrayList.add(obj);
            }
        }
        this.appendActionShowList = arrayList;
        RecyclerView recyclerView = this.actionViewPager;
        c cVar = null;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof c) {
            cVar = (c) adapter;
        }
        if (cVar != null) {
            cVar.setData(this.appendActionShowList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        RecyclerView.Adapter adapter;
        List<j> w3 = F9().w();
        ArrayList arrayList = new ArrayList();
        for (Object obj : w3) {
            if (((j) obj).e()) {
                arrayList.add(obj);
            }
        }
        this.shareChannelShowList = arrayList;
        RecyclerView recyclerView = this.channelViewPager;
        c cVar = null;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof c) {
            cVar = (c) adapter;
        }
        if (cVar != null) {
            cVar.setData(this.shareChannelShowList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        boolean z16;
        int i3;
        int i16;
        List<SharePanelContactItem> value = Q9().M1().getValue();
        boolean z17 = true;
        int i17 = 0;
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            View view = this.actionContainer;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.actionContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        boolean isEmpty = F9().s().isEmpty();
        if (!this.shareChannelShowList.isEmpty() || !this.appendActionShowList.isEmpty()) {
            z17 = false;
        }
        View view3 = this.actionDivider;
        if (view3 != null) {
            if (!isEmpty && !z17) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view3.setVisibility(i16);
        }
        RecyclerView recyclerView = this.channelViewPager;
        if (recyclerView != null) {
            if (this.shareChannelShowList.isEmpty()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            recyclerView.setVisibility(i3);
        }
        RecyclerView recyclerView2 = this.actionViewPager;
        if (recyclerView2 != null) {
            if (this.appendActionShowList.isEmpty()) {
                i17 = 8;
            }
            recyclerView2.setVisibility(i17);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.s9_);
        } else {
            view = null;
        }
        this.actionContainer = view;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f71873pb);
        } else {
            recyclerView = null;
        }
        this.channelViewPager = recyclerView;
        if (rootView != null) {
            recyclerView2 = (RecyclerView) rootView.findViewById(R.id.f71813p6);
        } else {
            recyclerView2 = null;
        }
        this.actionViewPager = recyclerView2;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.ujs);
        }
        this.actionDivider = view2;
        R9();
        Z9();
        Y9();
        aa();
        S9();
    }
}
