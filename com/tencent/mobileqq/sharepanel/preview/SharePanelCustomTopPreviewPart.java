package com.tencent.mobileqq.sharepanel.preview;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0015*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/preview/SharePanelCustomTopPreviewPart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "O9", "R9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "", "G9", "Lcom/tencent/mobileqq/sharepanel/g;", "e", "Lcom/tencent/mobileqq/sharepanel/g;", "topPreviewCreator", "f", "Landroid/view/View;", "customTopPreviewView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "L9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectViewModel", "Lcom/tencent/mobileqq/sharepanel/preview/k;", "i", "M9", "()Lcom/tencent/mobileqq/sharepanel/preview/k;", "singlePreviewVM", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelCustomTopPreviewPart extends com.tencent.mobileqq.sharepanel.part.i {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.g topPreviewCreator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View customTopPreviewView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy multiSelectViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy singlePreviewVM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelCustomTopPreviewPart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelCustomTopPreviewPart$multiSelectViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelCustomTopPreviewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) SharePanelCustomTopPreviewPart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelCustomTopPreviewPart$singlePreviewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelCustomTopPreviewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final k invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (k) SharePanelCustomTopPreviewPart.this.getViewModel(k.class) : (k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.singlePreviewVM = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final com.tencent.mobileqq.sharepanel.multiSelect.vm.a L9() {
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) this.multiSelectViewModel.getValue();
    }

    private final k M9() {
        return (k) this.singlePreviewVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        View view;
        com.tencent.mobileqq.sharepanel.g gVar = this.topPreviewCreator;
        if (gVar != null && !gVar.b() && (view = this.customTopPreviewView) != null) {
            view.setVisibility(8);
        }
    }

    private final void O9() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null) {
            lifecycleOwner = partHost.getLifecycleOwner();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            return;
        }
        MutableLiveData<List<SharePanelContactItem>> M1 = L9().M1();
        final Function1<List<SharePanelContactItem>, Unit> function1 = new Function1<List<SharePanelContactItem>, Unit>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelCustomTopPreviewPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelCustomTopPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SharePanelContactItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SharePanelContactItem> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                List<SharePanelContactItem> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    SharePanelCustomTopPreviewPart.this.R9();
                } else {
                    SharePanelCustomTopPreviewPart.this.N9();
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.preview.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SharePanelCustomTopPreviewPart.P9(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> L1 = M9().L1();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelCustomTopPreviewPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelCustomTopPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SharePanelCustomTopPreviewPart.this.N9();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.preview.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SharePanelCustomTopPreviewPart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        View view;
        com.tencent.mobileqq.sharepanel.g gVar = this.topPreviewCreator;
        if (gVar != null && !gVar.c() && (view = this.customTopPreviewView) != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.part.i
    public boolean G9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        N9();
        return super.G9(dismissType);
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
        com.tencent.mobileqq.sharepanel.g A = F9().A();
        if (A == null) {
            return;
        }
        this.topPreviewCreator = A;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.tencent.mobileqq.sharepanel.g gVar = this.topPreviewCreator;
        if (gVar != null) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            View a16 = gVar.a(context);
            if (a16 != null) {
                this.customTopPreviewView = a16;
                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f27260fr);
                if (relativeLayout != null) {
                    relativeLayout.addView(this.customTopPreviewView, layoutParams);
                }
                O9();
            }
        }
    }
}
