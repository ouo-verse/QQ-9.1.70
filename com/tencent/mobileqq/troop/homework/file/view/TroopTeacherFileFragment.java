package com.tencent.mobileqq.troop.homework.file.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.troop.homework.file.vm.TroopTeacherFileVM;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\b\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Bh", "Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", OcrConfig.CHINESE, "Landroid/os/Bundle;", "bundle", "com/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileFragment$b", "yh", "(Landroid/os/Bundle;)Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileFragment$b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "root", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter;", "E", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "", "G", "Z", "isFileEnd", "H", "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "fileViewModel", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "I", "xh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "<init>", "()V", "J", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopTeacherFileFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup root;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopTeacherFileAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private ScanningLightView loadingView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFileEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy fileViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy emptyView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f297066a;

        b(Bundle bundle) {
            this.f297066a = bundle;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(Bundle.class).newInstance(this.f297066a);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026java).newInstance(bundle)");
            return newInstance;
        }
    }

    public TroopTeacherFileFragment() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TroopTeacherFileVM>() { // from class: com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment$fileViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopTeacherFileVM invoke() {
                TroopTeacherFileVM zh5;
                zh5 = TroopTeacherFileFragment.this.zh();
                return zh5;
            }
        });
        this.fileViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment$emptyView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIEmptyState invoke() {
                return new QUIEmptyState.Builder(TroopTeacherFileFragment.this.getContext()).setImageType(2).setTitle("\u5f53\u524d\u6ca1\u6709\u6587\u4ef6").setBackgroundColorType(1).build();
            }
        });
        this.emptyView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeacherFileVM Ah() {
        return (TroopTeacherFileVM) this.fileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        if (xh().getParent() != null) {
            return;
        }
        ViewGroup viewGroup = this.root;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup = null;
        }
        viewGroup.addView(xh(), -1, -1);
    }

    private final QUIEmptyState xh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final b yh(Bundle bundle) {
        return new b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeacherFileVM zh() {
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        ViewModel viewModel = new ViewModelProvider(this, yh(requireArguments)).get(TroopTeacherFileVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026eacherFileVM::class.java)");
        return (TroopTeacherFileVM) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.g1s, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.root = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.loading_view)");
        this.loadingView = (ScanningLightView) findViewById;
        ViewGroup viewGroup2 = this.root;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup2 = null;
        }
        View findViewById2 = viewGroup2.findViewById(R.id.f71833p8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.recycler_layout)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        ViewGroup viewGroup3 = this.root;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup3 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup3.getContext()));
        recyclerView.setOnTouchListener(new c());
        recyclerView.setOverScrollMode(0);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView.setAdapter(new TroopTeacherFileAdapter(recyclerView2, Ah(), getActivity()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment$onCreateView$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView3, int newState) {
                boolean z16;
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                super.onScrollStateChanged(recyclerView3, newState);
                z16 = TroopTeacherFileFragment.this.isFileEnd;
                if (!z16 && newState == 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    RecyclerView.LayoutManager layoutManager2 = recyclerView3.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    if (((LinearLayoutManager) layoutManager2).getItemCount() - findLastVisibleItemPosition <= 3) {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TroopTeacherFileFragment.this), null, null, new TroopTeacherFileFragment$onCreateView$1$2$onScrollStateChanged$1(TroopTeacherFileFragment.this, null), 3, null);
                    }
                }
            }
        });
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileAdapter");
        this.adapter = (TroopTeacherFileAdapter) adapter;
        ViewGroup viewGroup4 = this.root;
        if (viewGroup4 != null) {
            return viewGroup4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Ah().Q1();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!NetworkUtil.isNetworkAvailable()) {
            Bh();
            QQToast.makeText(getContext(), 1, HardCodeUtil.qqStr(R.string.cjn), 0).show();
        } else {
            LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new TroopTeacherFileFragment$onViewCreated$1(this, null));
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopTeacherFileFragment$onViewCreated$2(this, null), 3, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileFragment$c", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "d", "Z", "shouldIntercept", "Lkotlin/Pair;", "", "e", "Lkotlin/Pair;", "lastCoordinate", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean shouldIntercept;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Pair<Float, Float> lastCoordinate;

        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v3, MotionEvent event) {
            if (event == null) {
                return false;
            }
            RecyclerView recyclerView = null;
            if (event.getAction() == 2) {
                Pair<Float, Float> pair = this.lastCoordinate;
                if (pair != null && Math.abs(event.getX() - pair.getFirst().floatValue()) <= Math.abs(event.getY() - pair.getSecond().floatValue())) {
                    this.shouldIntercept = true;
                }
                if (this.shouldIntercept) {
                    RecyclerView recyclerView2 = TroopTeacherFileFragment.this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView = recyclerView2;
                    }
                    recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else {
                this.lastCoordinate = null;
                this.shouldIntercept = false;
                RecyclerView recyclerView3 = TroopTeacherFileFragment.this.recyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.lastCoordinate = TuplesKt.to(Float.valueOf(event.getX()), Float.valueOf(event.getY()));
            return false;
        }
    }
}
