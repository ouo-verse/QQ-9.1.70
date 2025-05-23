package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareHomeFragment;
import com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment;
import com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareRecommendPart;
import com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010 R\u001f\u0010&\u001a\u00060\"R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "mViewModel", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "e", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "mTabBar", "Landroidx/viewpager2/widget/ViewPager2;", "f", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mSingleTab", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "mMultipleTab", "Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareHomeFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "F9", "()Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareHomeFragment;", "mParentFragment", "Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart$a;", BdhLogUtil.LogTag.Tag_Conn, "E9", "()Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart$a;", "mAdapter", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareRecommendPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIPageTabBar mTabBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mSingleTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mMultipleTab;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mParentFragment;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart$a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "fragment", "<init>", "(Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart;Landroidx/fragment/app/Fragment;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends FragmentStateAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ TroopSquareRecommendPart f301615m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull TroopSquareRecommendPart troopSquareRecommendPart, Fragment fragment) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.f301615m = troopSquareRecommendPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareRecommendPart, (Object) fragment);
            }
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            List<GroupSquareTabItem> value = this.f301615m.G9().R1().getValue();
            Bundle bundle = new Bundle();
            bundle.putLong("group_code", this.f301615m.G9().O1());
            Gson gson = new Gson();
            Intrinsics.checkNotNull(value);
            bundle.putString("tab_item", gson.toJson(value.get(position)));
            TroopSquareRecommendFragment troopSquareRecommendFragment = new TroopSquareRecommendFragment();
            troopSquareRecommendFragment.setArguments(bundle);
            return troopSquareRecommendFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            List<GroupSquareTabItem> value = this.f301615m.G9().R1().getValue();
            if (value != null) {
                return value.size();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareRecommendPart$b", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Lazy<TroopSquareHomeViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopSquareHomeViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f301617e;

        public b(Part part) {
            this.f301617e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSquareHomeViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopSquareHomeViewModel troopSquareHomeViewModel = this.cached;
            Object partHost = this.f301617e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopSquareHomeViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopSquareHomeViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopSquareHomeViewModel;
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

    public TroopSquareRecommendPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mViewModel = new b(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSquareHomeFragment>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareRecommendPart$mParentFragment$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopSquareHomeFragment invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopSquareHomeFragment) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Fragment hostFragment = TroopSquareRecommendPart.this.getHostFragment();
                Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareHomeFragment");
                return (TroopSquareHomeFragment) hostFragment;
            }
        });
        this.mParentFragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareRecommendPart$mAdapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopSquareRecommendPart.a invoke() {
                TroopSquareHomeFragment F9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopSquareRecommendPart.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TroopSquareRecommendPart troopSquareRecommendPart = TroopSquareRecommendPart.this;
                F9 = troopSquareRecommendPart.F9();
                return new TroopSquareRecommendPart.a(troopSquareRecommendPart, F9);
            }
        });
        this.mAdapter = lazy2;
    }

    private final a E9() {
        return (a) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSquareHomeFragment F9() {
        return (TroopSquareHomeFragment) this.mParentFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSquareHomeViewModel G9() {
        return (TroopSquareHomeViewModel) this.mViewModel.getValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void H9() {
        G9().R1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareRecommendPart.I9(TroopSquareRecommendPart.this, (List) obj);
            }
        });
        G9().S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareRecommendPart.L9(TroopSquareRecommendPart.this, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(final TroopSquareRecommendPart this$0, List items) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIPageTabBar qUIPageTabBar = this$0.mTabBar;
        FrameLayout frameLayout = null;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabBar");
            qUIPageTabBar = null;
        }
        Intrinsics.checkNotNullExpressionValue(items, "items");
        List list = items;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((GroupSquareTabItem) it.next()).txt);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qUIPageTabBar.setTabData((String[]) array);
        QUIPageTabBar qUIPageTabBar2 = this$0.mTabBar;
        if (qUIPageTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabBar");
            qUIPageTabBar2 = null;
        }
        qUIPageTabBar2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.g
            @Override // java.lang.Runnable
            public final void run() {
                TroopSquareRecommendPart.J9(TroopSquareRecommendPart.this);
            }
        });
        QUIPageTabBar qUIPageTabBar3 = this$0.mTabBar;
        if (qUIPageTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabBar");
            qUIPageTabBar3 = null;
        }
        ViewPager2 viewPager2 = this$0.mViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        }
        qUIPageTabBar3.bindViewPager2(viewPager2);
        this$0.E9().notifyDataSetChanged();
        int size = items.size();
        if (size != 0) {
            if (size != 1) {
                TextView textView = this$0.mSingleTab;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSingleTab");
                    textView = null;
                }
                textView.setVisibility(8);
                FrameLayout frameLayout2 = this$0.mMultipleTab;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMultipleTab");
                } else {
                    frameLayout = frameLayout2;
                }
                frameLayout.setVisibility(0);
                return;
            }
            TextView textView2 = this$0.mSingleTab;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleTab");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this$0.mSingleTab;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleTab");
                textView3 = null;
            }
            textView3.setText(((GroupSquareTabItem) items.get(0)).txt);
            FrameLayout frameLayout3 = this$0.mMultipleTab;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMultipleTab");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setVisibility(8);
            return;
        }
        TextView textView4 = this$0.mSingleTab;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleTab");
            textView4 = null;
        }
        textView4.setVisibility(8);
        FrameLayout frameLayout4 = this$0.mMultipleTab;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultipleTab");
        } else {
            frameLayout = frameLayout4;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(TroopSquareRecommendPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIPageTabBar qUIPageTabBar = this$0.mTabBar;
        QUIPageTabBar qUIPageTabBar2 = null;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabBar");
            qUIPageTabBar = null;
        }
        if (qUIPageTabBar.getChildCount() > 0) {
            QUIPageTabBar qUIPageTabBar3 = this$0.mTabBar;
            if (qUIPageTabBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabBar");
            } else {
                qUIPageTabBar2 = qUIPageTabBar3;
            }
            final int i3 = 0;
            View view = ViewGroupKt.get(qUIPageTabBar2, 0);
            if (view instanceof ViewGroup) {
                for (View view2 : ViewGroupKt.getChildren((ViewGroup) view)) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final View view3 = view2;
                    h.a.m(com.tencent.mobileqq.troop.troopsquare.common.c.f301578a, view3, "em_group_tab", ExposurePolicy.REPORT_ALL, ClickPolicy.REPORT_ALL, new IDynamicParams() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.h
                        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                        public final Map getDynamicParams(String str) {
                            Map K9;
                            K9 = TroopSquareRecommendPart.K9(view3, i3, str);
                            return K9;
                        }
                    }, null, 32, null);
                    i3 = i16;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map K9(View view, int i3, String str) {
        TextView textView;
        String str2;
        Map mapOf;
        CharSequence text;
        Intrinsics.checkNotNullParameter(view, "$view");
        Pair[] pairArr = new Pair[2];
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = null;
        }
        if (textView == null || (text = textView.getText()) == null || (str2 = text.toString()) == null) {
            str2 = "";
        }
        int i16 = 0;
        pairArr[0] = TuplesKt.to("tab_name", str2);
        if (i3 == 0) {
            i16 = 1;
        }
        pairArr[1] = TuplesKt.to("is_first_tab", Integer.valueOf(i16));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(TroopSquareRecommendPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.mViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem((int) l3.longValue(), false);
        ViewPager2 viewPager23 = this$0.mViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPager22 = viewPager23;
        }
        RecyclerView.Adapter adapter = viewPager22.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.j_7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tab_bar)");
        this.mTabBar = (QUIPageTabBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.kxy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.viewpager)");
        this.mViewPager = (ViewPager2) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f85644pi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.single_tab)");
        this.mSingleTab = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.zjm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.multiple_tab)");
        this.mMultipleTab = (FrameLayout) findViewById4;
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(E9());
        H9();
    }
}
