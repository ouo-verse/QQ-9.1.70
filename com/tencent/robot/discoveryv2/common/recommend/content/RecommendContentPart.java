package com.tencent.robot.discoveryv2.common.recommend.content;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import com.tencent.robot.discoveryv2.common.recommend.content.c;
import com.tencent.robot.discoveryv2.common.recommend.page.core.RecommendPageViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/RecommendContentPart;", "Lo34/a;", "", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D9", "G9", "E9", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "categoryTabList", "H9", "onInitView", "", "d", "Ljava/lang/String;", "mUin", "Lcom/tencent/robot/discoveryv2/common/recommend/content/RecommendContentViewModel;", "e", "Lcom/tencent/robot/discoveryv2/common/recommend/content/RecommendContentViewModel;", "mViewModel", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "f", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "mCategoryTabBar", "Landroidx/viewpager2/widget/ViewPager2;", h.F, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "Lcom/tencent/robot/discoveryv2/common/recommend/content/a;", "i", "Lcom/tencent/robot/discoveryv2/common/recommend/content/a;", "mViewPagerAdapter", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendContentPart extends o34.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecommendContentViewModel mViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIPageTabBar mCategoryTabBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a mViewPagerAdapter;

    private final void D9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f164750tp4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.category_tab_bar)");
        this.mCategoryTabBar = (QUIPageTabBar) findViewById;
    }

    private final void E9() {
        RecommendContentViewModel recommendContentViewModel = (RecommendContentViewModel) z9(RecommendContentViewModel.class);
        this.mViewModel = recommendContentViewModel;
        RecommendContentViewModel recommendContentViewModel2 = null;
        if (recommendContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendContentViewModel = null;
        }
        recommendContentViewModel.Q1();
        RecommendContentViewModel recommendContentViewModel3 = this.mViewModel;
        if (recommendContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            recommendContentViewModel2 = recommendContentViewModel3;
        }
        MutableLiveData<c> P1 = recommendContentViewModel2.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<c, Unit> function1 = new Function1<c, Unit>() { // from class: com.tencent.robot.discoveryv2.common.recommend.content.RecommendContentPart$initContentViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c cVar) {
                if (cVar instanceof c.UpdateCategoryTabUIState) {
                    RecommendContentPart.this.H9(((c.UpdateCategoryTabUIState) cVar).a());
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discoveryv2.common.recommend.content.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendContentPart.F9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void G9(View rootView) {
        View findViewById = rootView.findViewById(R.id.b9z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_pager)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        this.mViewPager = viewPager2;
        a aVar = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        }
        viewPager2.setOffscreenPageLimit(1);
        String str = this.mUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUin");
            str = null;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        this.mViewPagerAdapter = new a(str, lifecycleOwner, new Function1<String, RecommendPageViewModel>() { // from class: com.tencent.robot.discoveryv2.common.recommend.content.RecommendContentPart$initViewPagerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final RecommendPageViewModel invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (RecommendPageViewModel) RecommendContentPart.this.A9(it, RecommendPageViewModel.class);
            }
        });
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager22 = null;
        }
        a aVar2 = this.mViewPagerAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
        } else {
            aVar = aVar2;
        }
        viewPager22.setAdapter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(List<ListNode> categoryTabList) {
        int collectionSizeOrDefault;
        a aVar = this.mViewPagerAdapter;
        ViewPager2 viewPager2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPagerAdapter");
            aVar = null;
        }
        aVar.l0(categoryTabList);
        QUIPageTabBar qUIPageTabBar = this.mCategoryTabBar;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryTabBar");
            qUIPageTabBar = null;
        }
        List<ListNode> list = categoryTabList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ListNode) it.next()).listName);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qUIPageTabBar.setTabData((String[]) array);
        QUIPageTabBar qUIPageTabBar2 = this.mCategoryTabBar;
        if (qUIPageTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryTabBar");
            qUIPageTabBar2 = null;
        }
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPager2 = viewPager22;
        }
        qUIPageTabBar2.bindViewPager2(viewPager2);
    }

    private final void initData() {
        String stringExtra = getPartHost().getHostActivity().getIntent().getStringExtra("param_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mUin = stringExtra;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
        D9(rootView);
        G9(rootView);
        E9();
    }
}
