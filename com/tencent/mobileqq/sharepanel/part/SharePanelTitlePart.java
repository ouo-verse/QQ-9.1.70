package com.tencent.mobileqq.sharepanel.part;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/SharePanelTitlePart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "M9", "", "K9", "onInitView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "L9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectVM", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTv", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", tl.h.F, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelTitlePart extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy multiSelectVM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTv;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/SharePanelTitlePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.part.SharePanelTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelTitlePart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelTitlePart$multiSelectVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelTitlePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) SharePanelTitlePart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence K9() {
        CharSequence y16 = F9().y();
        if (y16 == null) {
            return "\u5206\u4eab\u81f3";
        }
        return y16;
    }

    private final com.tencent.mobileqq.sharepanel.multiSelect.vm.a L9() {
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) this.multiSelectVM.getValue();
    }

    private final void M9(View rootView) {
        TextView textView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.kbs);
        } else {
            textView = null;
        }
        this.titleTv = textView;
        if (textView != null) {
            textView.setText(K9());
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner != null) {
            MutableLiveData<List<SharePanelContactItem>> M1 = L9().M1();
            final Function1<List<SharePanelContactItem>, Unit> function1 = new Function1<List<SharePanelContactItem>, Unit>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelTitlePart$initTitle$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelTitlePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<SharePanelContactItem> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<SharePanelContactItem> list) {
                    TextView textView2;
                    CharSequence K9;
                    CharSequence charSequence;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    textView2 = SharePanelTitlePart.this.titleTv;
                    if (textView2 == null) {
                        return;
                    }
                    if (list.isEmpty()) {
                        charSequence = SharePanelTitlePart.this.K9();
                    } else {
                        K9 = SharePanelTitlePart.this.K9();
                        charSequence = ((Object) K9) + "\uff1a";
                    }
                    textView2.setText(charSequence);
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SharePanelTitlePart.N9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            M9(rootView);
        }
    }
}
