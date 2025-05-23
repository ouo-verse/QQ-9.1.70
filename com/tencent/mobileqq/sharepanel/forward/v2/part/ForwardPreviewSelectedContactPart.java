package com.tencent.mobileqq.sharepanel.forward.v2.part;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSelectedContactPart;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "selectedContactContainer", "Lcom/tencent/mobileqq/sharepanel/forward/v2/adapter/c;", h.F, "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/sharepanel/forward/v2/adapter/c;", "selectedContactsAdapter", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewSelectedContactPart extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout selectedContactContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedContactsAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardPreviewSelectedContactPart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.forward.v2.adapter.c>() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSelectedContactPart$selectedContactsAdapter$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewSelectedContactPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.sharepanel.forward.v2.adapter.c invoke() {
                    LinearLayout linearLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.sharepanel.forward.v2.adapter.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    linearLayout = ForwardPreviewSelectedContactPart.this.selectedContactContainer;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectedContactContainer");
                        linearLayout = null;
                    }
                    com.tencent.mobileqq.sharepanel.forward.v2.adapter.c cVar = new com.tencent.mobileqq.sharepanel.forward.v2.adapter.c(linearLayout);
                    final ForwardPreviewSelectedContactPart forwardPreviewSelectedContactPart = ForwardPreviewSelectedContactPart.this;
                    cVar.e(new Function1<SharePanelContactItem, Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSelectedContactPart$selectedContactsAdapter$2$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ForwardPreviewSelectedContactPart.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SharePanelContactItem sharePanelContactItem) {
                            invoke2(sharePanelContactItem);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull SharePanelContactItem it) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            ForwardPreviewSelectedContactPart.this.C9().P1();
                            ForwardPreviewSelectedContactPart.this.C9().O1(it);
                        }
                    });
                    return cVar;
                }
            });
            this.selectedContactsAdapter = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    private final com.tencent.mobileqq.sharepanel.forward.v2.adapter.c F9() {
        return (com.tencent.mobileqq.sharepanel.forward.v2.adapter.c) this.selectedContactsAdapter.getValue();
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
        View findViewById = rootView.findViewById(R.id.f82644hf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lected_contact_container)");
        this.selectedContactContainer = (LinearLayout) findViewById;
        F9().d(B9().c());
    }
}
