package com.tencent.mobileqq.troop.homework.clockin.time.part;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyFragment;
import com.tencent.mobileqq.troop.homework.clockin.time.vm.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", "F9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/c;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/c;", "viewModel", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "e", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "timeInfo", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "textView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInFrequencyPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.clockin.time.data.a timeInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup viewGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/time/part/HWClockInFrequencyPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<com.tencent.mobileqq.troop.homework.clockin.time.vm.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.homework.clockin.time.vm.c cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296606e;

        public a(Part part) {
            this.f296606e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.homework.clockin.time.vm.c] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.time.vm.c] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.troop.homework.clockin.time.vm.c getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.mobileqq.troop.homework.clockin.time.vm.c cVar = this.cached;
            Object partHost = this.f296606e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (cVar == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(com.tencent.mobileqq.troop.homework.clockin.time.vm.c.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return cVar;
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

    public HWClockInFrequencyPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.homework.clockin.time.vm.c E9() {
        return (com.tencent.mobileqq.troop.homework.clockin.time.vm.c) this.viewModel.getValue();
    }

    private final void F9() {
        List<Integer> emptyList;
        Bundle bundle = new Bundle();
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeInfo;
        if (aVar == null || (emptyList = aVar.a()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        bundle.putIntegerArrayList("time_setting_frequency", new ArrayList<>(emptyList));
        HWClockInFrequencyFragment hWClockInFrequencyFragment = new HWClockInFrequencyFragment(new HWClockInFrequencyFragment.a() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyPart$handleClick$fragment$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInFrequencyPart.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyFragment.a
            public void a(@NotNull List<Integer> frequencyList) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) frequencyList);
                } else {
                    Intrinsics.checkNotNullParameter(frequencyList, "frequencyList");
                    BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(HWClockInFrequencyPart.this), null, null, new HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1(HWClockInFrequencyPart.this, frequencyList, null), 3, null);
                }
            }
        });
        hWClockInFrequencyFragment.setArguments(bundle);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        hWClockInFrequencyFragment.show(((FragmentActivity) context).getSupportFragmentManager(), HWClockInFrequencyFragment.class.getSimpleName());
    }

    private final void G9() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.time.vm.a> obtainUiState = E9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.time.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.time.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyPart$observeUiState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInFrequencyPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.time.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.time.vm.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (aVar instanceof a.C8724a) {
                    HWClockInFrequencyPart.this.timeInfo = ((a.C8724a) aVar).a();
                    HWClockInFrequencyPart.this.J9();
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInFrequencyPart.H9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(HWClockInFrequencyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeInfo;
        if (aVar != null) {
            TextView textView = this.textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView = null;
            }
            textView.setText(com.tencent.mobileqq.troop.homework.clockin.time.repo.c.f296621a.a(aVar.a()));
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
        View findViewById = rootView.findViewById(R.id.tyt);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockInFrequencyPart.I9(HWClockInFrequencyPart.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026)\n            }\n        }");
        this.viewGroup = viewGroup;
        View findViewById2 = rootView.findViewById(R.id.tys);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.clock_in_frequency)");
        this.textView = (TextView) findViewById2;
        G9();
    }
}
