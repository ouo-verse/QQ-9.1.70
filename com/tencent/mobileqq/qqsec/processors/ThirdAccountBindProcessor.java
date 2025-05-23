package com.tencent.mobileqq.qqsec.processors;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.IAccountBindingApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.account.AccountSecurityVM;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqsec/processors/ThirdAccountBindProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "o", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "g", "Lkotlin/Lazy;", "y", "()Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "accountSecurityVM", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ThirdAccountBindProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountSecurityVM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdAccountBindProcessor(@NotNull Context context) {
        super(context, 3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountSecurityVM>() { // from class: com.tencent.mobileqq.qqsec.processors.ThirdAccountBindProcessor$accountSecurityVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThirdAccountBindProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final AccountSecurityVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AccountSecurityVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Activity e16 = ThirdAccountBindProcessor.this.e();
                    QBaseActivity qBaseActivity = e16 instanceof QBaseActivity ? (QBaseActivity) e16 : null;
                    if (qBaseActivity == null) {
                        return null;
                    }
                    return (AccountSecurityVM) com.tencent.mobileqq.mvvm.h.a(qBaseActivity).get(AccountSecurityVM.class);
                }
            });
            this.accountSecurityVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_bas_third_account_binding");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final AccountSecurityVM y() {
        return (AccountSecurityVM) this.accountSecurityVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ThirdAccountBindProcessor this$0, x this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Activity e16 = this$0.e();
        if (e16 != null) {
            ((IAccountBindingApi) QRoute.api(IAccountBindingApi.class)).startAccountBindFragment(e16, null);
        }
        ((x.c.g) this_apply.O()).g(false);
        this$0.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.o();
        AccountSecurityVM y16 = y();
        if (y16 != null) {
            y16.m2();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        QBaseActivity qBaseActivity;
        MutableLiveData<Boolean> f26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String string = BaseApplication.getContext().getString(R.string.f200854t9);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026rd_party_account_binding)");
        final x xVar = new x(new x.b.C8996b(string, R.drawable.qui_link), new x.c.g("", true, false));
        ((x.c.g) xVar.O()).g(false);
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.processors.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdAccountBindProcessor.z(ThirdAccountBindProcessor.this, xVar, view);
            }
        });
        Activity e16 = e();
        if (e16 instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) e16;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            AccountSecurityVM y16 = y();
            if (y16 != null && (f26 = y16.f2()) != null) {
                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(xVar, this) { // from class: com.tencent.mobileqq.qqsec.processors.ThirdAccountBindProcessor$onCreateItemConfig$1$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ x<x.b.C8996b, x.c.g> $this_apply;
                    final /* synthetic */ ThirdAccountBindProcessor this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$this_apply = xVar;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                        } else {
                            this.$this_apply.O().g(!bool.booleanValue());
                            this.this$0.l();
                        }
                    }
                };
                f26.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.qqsec.processors.h
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ThirdAccountBindProcessor.A(Function1.this, obj);
                    }
                });
            }
            AccountSecurityVM y17 = y();
            if (y17 != null) {
                y17.m2();
            }
            xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.processors.i
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    ThirdAccountBindProcessor.B(view);
                }
            });
        }
        return xVar;
    }
}
