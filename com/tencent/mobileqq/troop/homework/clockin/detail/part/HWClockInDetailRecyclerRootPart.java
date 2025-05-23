package com.tencent.mobileqq.troop.homework.clockin.detail.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.b;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/part/HWClockInDetailRecyclerRootPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initData", "G9", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a$a;", "data", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "I9", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "d", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "rootRecycler", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/b;", h.F, "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/b;", "detailAdapter", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/a;", "i", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/a;", "dateAdapter", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/d;", "statisticsAdapter", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/c;", "clockInListAdapter", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/e;", "D", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/e;", "tipsAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "E", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "loadMoreAdapter", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailRecyclerRootPart extends Part implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.detail.adapter.c clockInListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e tipsAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.common.a loadMoreAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rootRecycler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b detailAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a dateAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d statisticsAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/detail/part/HWClockInDetailRecyclerRootPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<HWClockInDetailViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HWClockInDetailViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296382e;

        public a(Part part) {
            this.f296382e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HWClockInDetailViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HWClockInDetailViewModel hWClockInDetailViewModel = this.cached;
            Object partHost = this.f296382e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (hWClockInDetailViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(HWClockInDetailViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return hWClockInDetailViewModel;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public HWClockInDetailRecyclerRootPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new a(this);
        }
    }

    public static final /* synthetic */ HWClockInDetailViewModel D9(HWClockInDetailRecyclerRootPart hWClockInDetailRecyclerRootPart) {
        return hWClockInDetailRecyclerRootPart.F9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWClockInDetailViewModel F9() {
        return (HWClockInDetailViewModel) this.viewModel.getValue();
    }

    private final void G9() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> obtainUiState = F9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailRecyclerRootPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailRecyclerRootPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a it) {
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a aVar;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e eVar;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d dVar;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a aVar2 = null;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b bVar2 = null;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d dVar2 = null;
                com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e eVar2 = null;
                if (it instanceof a.e) {
                    bVar = HWClockInDetailRecyclerRootPart.this.detailAdapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailAdapter");
                    } else {
                        bVar2 = bVar;
                    }
                    bVar2.i0(((a.e) it).a());
                    return;
                }
                if (it instanceof a.c) {
                    dVar = HWClockInDetailRecyclerRootPart.this.statisticsAdapter;
                    if (dVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("statisticsAdapter");
                    } else {
                        dVar2 = dVar;
                    }
                    dVar2.i0(((a.c) it).a());
                    return;
                }
                if (it instanceof a.C8707a) {
                    HWClockInDetailRecyclerRootPart hWClockInDetailRecyclerRootPart = HWClockInDetailRecyclerRootPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hWClockInDetailRecyclerRootPart.J9((a.C8707a) it);
                    return;
                }
                if (it instanceof a.b) {
                    eVar = HWClockInDetailRecyclerRootPart.this.tipsAdapter;
                    if (eVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tipsAdapter");
                    } else {
                        eVar2 = eVar;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    eVar2.i0((a.b) it);
                    return;
                }
                if (it instanceof a.d) {
                    aVar = HWClockInDetailRecyclerRootPart.this.dateAdapter;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
                    } else {
                        aVar2 = aVar;
                    }
                    aVar2.i0(((a.d) it).a());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInDetailRecyclerRootPart.H9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f783346s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.root_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.rootRecycler = recyclerView;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootRecycler");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        f Z1 = F9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b bVar = new com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b(Z1, lifecycleOwner);
        bVar.setHasStableIds(true);
        this.detailAdapter = bVar;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a aVar = new com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a(new Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailRecyclerRootPart$initUI$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailRecyclerRootPart$initUI$2$1", f = "HWClockInDetailRecyclerRootPart.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailRecyclerRootPart$initUI$2$1, reason: invalid class name */
            /* loaded from: classes19.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a $it;
                int label;
                final /* synthetic */ HWClockInDetailRecyclerRootPart this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HWClockInDetailRecyclerRootPart hWClockInDetailRecyclerRootPart, com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = hWClockInDetailRecyclerRootPart;
                    this.$it = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, hWClockInDetailRecyclerRootPart, aVar, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    HWClockInDetailViewModel F9;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            F9 = this.this$0.F9();
                            b.a aVar = new b.a(this.$it);
                            this.label = 1;
                            if (F9.sendUserIntent(aVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailRecyclerRootPart.this);
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(HWClockInDetailRecyclerRootPart.this), null, null, new AnonymousClass1(HWClockInDetailRecyclerRootPart.this, it, null), 3, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar2) {
                invoke2(aVar2);
                return Unit.INSTANCE;
            }
        });
        aVar.setHasStableIds(true);
        this.dateAdapter = aVar;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d dVar = new com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d();
        dVar.setHasStableIds(true);
        this.statisticsAdapter = dVar;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.c cVar = new com.tencent.mobileqq.troop.homework.clockin.detail.adapter.c(lifecycleOwner2);
        cVar.setHasStableIds(true);
        this.clockInListAdapter = cVar;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e eVar = new com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e();
        eVar.setHasStableIds(true);
        this.tipsAdapter = eVar;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.common.a();
        aVar2.registerLoadMoreListener(this);
        this.loadMoreAdapter = aVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[6];
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b bVar2 = this.detailAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAdapter");
            bVar2 = null;
        }
        adapterArr[0] = bVar2;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.a aVar3 = this.dateAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
            aVar3 = null;
        }
        adapterArr[1] = aVar3;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.d dVar2 = this.statisticsAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticsAdapter");
            dVar2 = null;
        }
        adapterArr[2] = dVar2;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.c cVar2 = this.clockInListAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockInListAdapter");
            cVar2 = null;
        }
        adapterArr[3] = cVar2;
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.e eVar2 = this.tipsAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsAdapter");
            eVar2 = null;
        }
        adapterArr[4] = eVar2;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = this.loadMoreAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aVar4 = null;
        }
        adapterArr[5] = aVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView2 = this.rootRecycler;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootRecycler");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        RecyclerView recyclerView3 = this.rootRecycler;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootRecycler");
            recyclerView3 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView3.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(a.C8707a data) {
        com.tencent.mobileqq.troop.homework.clockin.detail.adapter.c cVar = this.clockInListAdapter;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockInListAdapter");
            cVar = null;
        }
        cVar.submitList(data.a());
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = this.loadMoreAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setLoadState(false, !data.b());
    }

    private final void initData() {
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this), null, null, new HWClockInDetailRecyclerRootPart$initData$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        I9(rootView);
        G9();
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this), null, null, new HWClockInDetailRecyclerRootPart$onLoadMoreStart$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
