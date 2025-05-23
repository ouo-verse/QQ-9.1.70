package com.tencent.mobileqq.troop.homework.clockin.publish.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/part/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel;", "f", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel;", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/publish/part/b$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<HWClockInPublishViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HWClockInPublishViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296482e;

        public a(Part part) {
            this.f296482e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HWClockInPublishViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HWClockInPublishViewModel hWClockInPublishViewModel = this.cached;
            Object partHost = this.f296482e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (hWClockInPublishViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(HWClockInPublishViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return hWClockInPublishViewModel;
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

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new a(this);
        }
    }

    private final HWClockInPublishViewModel C9() {
        return (HWClockInPublishViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(View view, boolean z16, int i3) {
        if (!z16) {
            view.clearFocus();
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d
    public void z9(@Nullable final View rootView) {
        HWMediaEditView hWMediaEditView;
        InputMethodGuard inputMethodGuard;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            hWMediaEditView = (HWMediaEditView) rootView.findViewById(R.id.yzx);
        } else {
            hWMediaEditView = null;
        }
        A9(hWMediaEditView);
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x95 = x9();
        if (x95 != null) {
            a.C8729a.a(x95, this, false, 2, null);
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x96 = x9();
        if (x96 != null) {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f S1 = C9().S1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            x96.setMediaEditManager(S1, lifecycleOwner);
        }
        if (rootView != null && (inputMethodGuard = (InputMethodGuard) rootView.findViewById(R.id.dmx)) != null) {
            inputMethodGuard.setOnInputMethodChangeListener(new InputMethodGuard.a() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.a
                @Override // com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a
                public final void Xb(boolean z16, int i3) {
                    b.D9(rootView, z16, i3);
                }
            });
        }
    }
}
