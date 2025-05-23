package com.tencent.mobileqq.selectfriend.part;

import android.content.ComponentCallbacks2;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/SearchResultFragmentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "C9", "initViewModel", "onInitView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mSearchResultLayout", "Ldq2/f;", "e", "Ldq2/f;", "mSearchResultViewModel", "Ldq2/a;", "f", "Ldq2/a;", "mForwardFriendHomeViewModel", "Lcom/tencent/mobileqq/search/view/f;", tl.h.F, "Lcom/tencent/mobileqq/search/view/f;", "mSearchFragment", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SearchResultFragmentPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mSearchResultLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private dq2.f mSearchResultViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private dq2.a mForwardFriendHomeViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.search.view.f mSearchFragment;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(dq2.f.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(SearchResultViewModel::class.java)");
        this.mSearchResultViewModel = (dq2.f) viewModel;
        ViewModel viewModel2 = getViewModel(dq2.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(ForwardFrie\u2026omeViewModel::class.java)");
        this.mForwardFriendHomeViewModel = (dq2.a) viewModel2;
        if (this.mSearchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultViewModel");
        }
        if (this.mForwardFriendHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
        }
        dq2.f fVar = this.mSearchResultViewModel;
        dq2.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultViewModel");
            fVar = null;
        }
        MutableLiveData<Boolean> L1 = fVar.L1();
        ComponentCallbacks2 activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.SearchResultFragmentPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean aBoolean) {
                FrameLayout frameLayout;
                frameLayout = SearchResultFragmentPart.this.mSearchResultLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLayout");
                    frameLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(aBoolean, "aBoolean");
                frameLayout.setVisibility(aBoolean.booleanValue() ? 0 : 8);
            }
        };
        L1.observe((LifecycleOwner) activity, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchResultFragmentPart.D9(Function1.this, obj);
            }
        });
        dq2.f fVar3 = this.mSearchResultViewModel;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultViewModel");
        } else {
            fVar2 = fVar3;
        }
        MutableLiveData<List<String>> M1 = fVar2.M1();
        ComponentCallbacks2 activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<List<? extends String>, Unit> function12 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.SearchResultFragmentPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                com.tencent.mobileqq.search.view.f fVar4;
                com.tencent.mobileqq.search.view.f fVar5;
                com.tencent.mobileqq.search.view.f fVar6;
                fVar4 = SearchResultFragmentPart.this.mSearchFragment;
                if (fVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchFragment");
                }
                fVar5 = SearchResultFragmentPart.this.mSearchFragment;
                if (fVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchFragment");
                    fVar5 = null;
                }
                fVar6 = SearchResultFragmentPart.this.mSearchFragment;
                if (fVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSearchFragment");
                    fVar6 = null;
                }
                fVar5.B5(list, fVar6.K9() ? null : list);
            }
        };
        M1.observe((LifecycleOwner) activity2, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchResultFragmentPart.E9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        C9(rootView);
        initViewModel();
    }

    private final void C9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f163193ot2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.result_layout)");
        this.mSearchResultLayout = (FrameLayout) findViewById;
    }
}
