package com.tencent.mobileqq.troop.homework.clockin.submit.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel;
import com.tencent.mobileqq.troop.homework.common.b;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/part/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel;", "f", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel;", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/submit/part/a$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.submit.part.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8718a implements Lazy<HWSubmitClockInViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HWSubmitClockInViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296549e;

        public C8718a(Part part) {
            this.f296549e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HWSubmitClockInViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HWSubmitClockInViewModel hWSubmitClockInViewModel = this.cached;
            Object partHost = this.f296549e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (hWSubmitClockInViewModel == null) {
                ViewModelProvider.Factory a16 = b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(HWSubmitClockInViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return hWSubmitClockInViewModel;
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

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new C8718a(this);
        }
    }

    private final HWSubmitClockInViewModel B9() {
        return (HWSubmitClockInViewModel) this.viewModel.getValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d
    public void z9(@Nullable View rootView) {
        HWMediaEditView hWMediaEditView;
        RecyclerView recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        qs2.b bVar = null;
        if (rootView != null) {
            hWMediaEditView = (HWMediaEditView) rootView.findViewById(R.id.yzx);
        } else {
            hWMediaEditView = null;
        }
        A9(hWMediaEditView);
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x95 = x9();
        if (x95 != null) {
            x95.B(this, false);
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x96 = x9();
        if (x96 != null) {
            f R1 = B9().R1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            x96.setMediaEditManager(R1, lifecycleOwner);
        }
        if (rootView != null && (recyclerView = (RecyclerView) rootView.findViewById(R.id.z07)) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f fVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f(false, 1, null);
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x97 = x9();
            if (x97 instanceof qs2.b) {
                bVar = (qs2.b) x97;
            }
            if (bVar != null) {
                fVar.u0(bVar);
            }
            recyclerView.setAdapter(fVar);
        }
    }
}
