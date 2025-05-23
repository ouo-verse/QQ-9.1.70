package com.tencent.mobileqq.troop.teamup.home.part;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment;
import com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ts2.j;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u00140\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/part/TroopTeamUpHomePagerPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "G9", "", "position", "Landroid/os/Bundle;", "E9", "Lcom/tencent/mobileqq/troop/teamup/home/fragment/TroopTeamUpContentListFragment;", "childFragment", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lts2/j;", "d", "Lts2/j;", "binding", "", "Lkotlin/Pair;", "", "e", "Ljava/util/List;", "tabs", "Lcom/tencent/mobileqq/troop/teamup/home/vm/a;", "f", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/troop/teamup/home/vm/a;", "vm", "Landroidx/lifecycle/Observer;", "", h.F, "Landroidx/lifecycle/Observer;", "childShowEmptyViewDataObserver", "<init>", "()V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpHomePagerPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Pair<String, Integer>> tabs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> childShowEmptyViewDataObserver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/part/TroopTeamUpHomePagerPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.part.TroopTeamUpHomePagerPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/teamup/home/part/TroopTeamUpHomePagerPart$b", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends FragmentStateAdapter {
        static IPatchRedirector $redirector_;

        b(Fragment fragment) {
            super(fragment);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpHomePagerPart.this, (Object) fragment);
            }
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            TroopTeamUpContentListFragment troopTeamUpContentListFragment = new TroopTeamUpContentListFragment();
            TroopTeamUpHomePagerPart troopTeamUpHomePagerPart = TroopTeamUpHomePagerPart.this;
            troopTeamUpContentListFragment.setArguments(troopTeamUpHomePagerPart.E9(position));
            troopTeamUpHomePagerPart.I9(position, troopTeamUpContentListFragment);
            return troopTeamUpContentListFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return TroopTeamUpHomePagerPart.this.tabs.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55880);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpHomePagerPart() {
        List<Pair<String, Integer>> emptyList;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.tabs = emptyList;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.teamup.home.vm.a>() { // from class: com.tencent.mobileqq.troop.teamup.home.part.TroopTeamUpHomePagerPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpHomePagerPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.troop.teamup.home.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.teamup.home.vm.a) new ViewModelProvider(TroopTeamUpHomePagerPart.this.getHostFragment()).get(com.tencent.mobileqq.troop.teamup.home.vm.a.class) : (com.tencent.mobileqq.troop.teamup.home.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
            this.childShowEmptyViewDataObserver = new Observer() { // from class: com.tencent.mobileqq.troop.teamup.home.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopTeamUpHomePagerPart.D9(TroopTeamUpHomePagerPart.this, (Boolean) obj);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(TroopTeamUpHomePagerPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool == null) {
            return;
        }
        bool.booleanValue();
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopTeamUpHomePagerPart", "got childShowEmptyView " + bool);
        this$0.F9().L1().postValue(Boolean.valueOf(bool.booleanValue() ^ true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle E9(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", this.tabs.get(position).getSecond().intValue());
        bundle.putString("troop_id", F9().M1());
        return bundle;
    }

    private final com.tencent.mobileqq.troop.teamup.home.vm.a F9() {
        return (com.tencent.mobileqq.troop.teamup.home.vm.a) this.vm.getValue();
    }

    private final void G9() {
        ViewPager2 viewPager2;
        QUIPageTabBar qUIPageTabBar;
        j jVar = this.binding;
        if (jVar != null && (viewPager2 = jVar.f437417f) != null) {
            viewPager2.setAdapter(new b(getHostFragment()));
            j jVar2 = this.binding;
            if (jVar2 != null && (qUIPageTabBar = jVar2.f437416e) != null) {
                qUIPageTabBar.bindViewPager2(viewPager2);
            }
        }
    }

    private final void H9() {
        List<Pair<String, Integer>> listOf;
        int collectionSizeOrDefault;
        j jVar = this.binding;
        if (jVar != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(getContext().getString(R.string.f236107dg), 0), new Pair(getContext().getString(R.string.f236117dh), 1)});
            this.tabs = listOf;
            QUIPageTabBar qUIPageTabBar = jVar.f437416e;
            List<Pair<String, Integer>> list = listOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Pair) it.next()).getFirst());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar.setTabData((String[]) array);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(int position, final TroopTeamUpContentListFragment childFragment) {
        childFragment.getLifecycle().addObserver(new LifecycleObserver(childFragment, this) { // from class: com.tencent.mobileqq.troop.teamup.home.part.TroopTeamUpHomePagerPart$observeChild$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy childVM;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopTeamUpHomePagerPart f299001e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                this.f299001e = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpContentListVM>() { // from class: com.tencent.mobileqq.troop.teamup.home.part.TroopTeamUpHomePagerPart$observeChild$1$childVM$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                            }
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final TroopTeamUpContentListVM invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopTeamUpContentListVM) new ViewModelProvider(TroopTeamUpContentListFragment.this).get(TroopTeamUpContentListVM.class) : (TroopTeamUpContentListVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                    this.childVM = lazy;
                } else {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) childFragment, (Object) this);
                }
            }

            private final TroopTeamUpContentListVM a() {
                return (TroopTeamUpContentListVM) this.childVM.getValue();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onChildFragmentPaused() {
                Observer<? super Boolean> observer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                MutableLiveData<Boolean> X1 = a().X1();
                observer = this.f299001e.childShowEmptyViewDataObserver;
                X1.removeObserver(observer);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onChildFragmentResumed() {
                Observer<? super Boolean> observer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MutableLiveData<Boolean> X1 = a().X1();
                LifecycleOwner viewLifecycleOwner = this.f299001e.getHostFragment().getViewLifecycleOwner();
                observer = this.f299001e.childShowEmptyViewDataObserver;
                X1.observe(viewLifecycleOwner, observer);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Unit unit;
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null && (findViewById = rootView.findViewById(R.id.f93755af)) != null) {
            this.binding = j.e(findViewById);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            return;
        }
        H9();
        G9();
    }
}
