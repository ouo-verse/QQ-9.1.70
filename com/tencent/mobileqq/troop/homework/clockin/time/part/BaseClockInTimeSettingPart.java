package com.tencent.mobileqq.troop.homework.clockin.time.part;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.time.vm.a;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/part/BaseClockInTimeSettingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "G9", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/c;", "d", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/c;", "viewModel", "Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "e", "Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "D9", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "L9", "(Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;)V", "repo", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "E9", "()Landroid/view/ViewGroup;", "M9", "(Landroid/view/ViewGroup;)V", "viewGroup", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "C9", "()Landroid/widget/TextView;", "K9", "(Landroid/widget/TextView;)V", "beginTimeTextView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class BaseClockInTimeSettingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.mobileqq.troop.homework.clockin.time.repo.d repo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected ViewGroup viewGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected TextView beginTimeTextView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/time/part/BaseClockInTimeSettingPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<com.tencent.mobileqq.troop.homework.clockin.time.vm.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.homework.clockin.time.vm.c cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296599e;

        public a(Part part) {
            this.f296599e = part;
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
            Object partHost = this.f296599e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (cVar == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.getViewModelStore();
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

    public BaseClockInTimeSettingPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.homework.clockin.time.vm.c F9() {
        return (com.tencent.mobileqq.troop.homework.clockin.time.vm.c) this.viewModel.getValue();
    }

    private final void G9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a(context, D9().b(), new a.InterfaceC8733a() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.BaseClockInTimeSettingPart$handleOnPickerSheetShow$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseClockInTimeSettingPart.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
            public void a(@NotNull List<Integer> selectItems) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
                    return;
                }
                Intrinsics.checkNotNullParameter(selectItems, "selectItems");
                LifecycleOwner lifecycleOwner = BaseClockInTimeSettingPart.this.getPartHost().getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new BaseClockInTimeSettingPart$handleOnPickerSheetShow$1$onConfirm$1(BaseClockInTimeSettingPart.this, selectItems, null), 3, null);
            }

            @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }).m();
    }

    private final void H9() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.time.vm.a> obtainUiState = F9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.time.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.time.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.BaseClockInTimeSettingPart$observeUiState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseClockInTimeSettingPart.this);
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
                    BaseClockInTimeSettingPart.this.D9().f(((a.C8724a) aVar).a());
                    BaseClockInTimeSettingPart.this.C9().setText(BaseClockInTimeSettingPart.this.D9().c());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseClockInTimeSettingPart.I9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(BaseClockInTimeSettingPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract void B9();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        TextView textView = this.beginTimeTextView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("beginTimeTextView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.troop.homework.clockin.time.repo.d D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.clockin.time.repo.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.homework.clockin.time.repo.d dVar = this.repo;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("repo");
        return null;
    }

    @NotNull
    protected final ViewGroup E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ViewGroup viewGroup = this.viewGroup;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K9(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.beginTimeTextView = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L9(@NotNull com.tencent.mobileqq.troop.homework.clockin.time.repo.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.repo = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M9(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.viewGroup = viewGroup;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        B9();
        E9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.time.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseClockInTimeSettingPart.J9(BaseClockInTimeSettingPart.this, view);
            }
        });
        H9();
    }
}
