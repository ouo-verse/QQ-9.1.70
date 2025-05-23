package com.tencent.mobileqq.troop.homework.homework.submit.parts;

import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/TitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "d", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "viewModel", "<init>", "()V", "e", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TitlePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/TitlePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.parts.TitlePart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TitlePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubmitHomeWorkVM>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.TitlePart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TitlePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SubmitHomeWorkVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (SubmitHomeWorkVM) new ViewModelProvider(TitlePart.this.getHostFragment()).get(SubmitHomeWorkVM.class) : (SubmitHomeWorkVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SubmitHomeWorkVM B9() {
        return (SubmitHomeWorkVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(TitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("SubmitHWTitlePart", "click close button");
        if (!this$0.B9().b2()) {
            this$0.D9();
        } else {
            this$0.B9().W1().postValue(Boolean.TRUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D9() {
        DialogUtil.createCustomDialog(getContext(), 230, getContext().getString(R.string.f23378787), getContext().getString(R.string.f23417799), getContext().getString(R.string.f2059456z), getContext().getString(R.string.f20595570), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TitlePart.E9(TitlePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TitlePart.F9(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(TitlePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.B9().W1().postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!B9().b2()) {
            D9();
            return true;
        }
        B9().W1().postValue(Boolean.TRUE);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else if (rootView != null && (findViewById = rootView.findViewById(R.id.azb)) != null) {
            TriggerRunnerKt.c(findViewById, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TitlePart.C9(TitlePart.this, view);
                }
            }, 1, null);
        }
    }
}
