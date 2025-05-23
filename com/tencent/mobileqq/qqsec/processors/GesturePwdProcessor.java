package com.tencent.mobileqq.qqsec.processors;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.account.AccountSecurityVM;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.statistics.ReportController;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J)\u0010\b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0002J\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqsec/processors/GesturePwdProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "it", "", "G", "(Lcom/tencent/mobileqq/widget/listitem/x;Ljava/lang/Integer;)V", "E", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onResume", "o", "Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "g", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "accountSecurityVM", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GesturePwdProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountSecurityVM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GesturePwdProcessor(@NotNull Context context) {
        super(context, 6);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountSecurityVM>() { // from class: com.tencent.mobileqq.qqsec.processors.GesturePwdProcessor$accountSecurityVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GesturePwdProcessor.this);
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
                    Activity e16 = GesturePwdProcessor.this.e();
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

    private final AccountSecurityVM A() {
        return (AccountSecurityVM) this.accountSecurityVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GesturePwdProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity e16 = this$0.e();
        if (e16 != null) {
            Navigator createNavigator = QRoute.createNavigator(e16, RouterConstants.UI_ROUTER_GESTURE_PWD_SETTING);
            Intrinsics.checkNotNullExpressionValue(createNavigator, "createNavigator(it, Rout\u2026UTER_GESTURE_PWD_SETTING)");
            Navigator.withRequestCode$default(createNavigator, e16, 1, (Bundle) null, 4, (Object) null).request();
        }
        ReportController.y(this$0.f(), "0X800B841");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_bas_gesture_unlock");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqsec.processors.e
            @Override // java.lang.Runnable
            public final void run() {
                GesturePwdProcessor.F(GesturePwdProcessor.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GesturePwdProcessor this$0) {
        MutableLiveData<Integer> X1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        int gesturePWDState = BaseGesturePWDUtil.getGesturePWDState(BaseApplication.getContext(), peekAppRuntime.getCurrentAccountUin());
        AccountSecurityVM A = this$0.A();
        if (A != null && (X1 = A.X1()) != null) {
            X1.postValue(Integer.valueOf(gesturePWDState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(x<x.b.C8996b, x.c.g> xVar, Integer num) {
        if (num != null && num.intValue() == 2) {
            x.c.g O = xVar.O();
            String string = BaseApplication.getContext().getString(R.string.f170991bi3);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ng.gesture_password_open)");
            O.h(string);
            return;
        }
        if (num != null && num.intValue() == 1) {
            x.c.g O2 = xVar.O();
            String string2 = BaseApplication.getContext().getString(R.string.bhu);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026.gesture_password_closed)");
            O2.h(string2);
            return;
        }
        if (num != null && num.intValue() == 0) {
            x.c.g O3 = xVar.O();
            String string3 = BaseApplication.getContext().getString(R.string.f170990bi2);
            Intrinsics.checkNotNullExpressionValue(string3, "getContext().getString(R\u2026.gesture_password_notset)");
            O3.h(string3);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.o();
            E();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onResume();
            E();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        QBaseActivity qBaseActivity;
        AccountSecurityVM A;
        MutableLiveData<Integer> X1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = BaseApplication.getContext().getString(R.string.f2039251i);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026_gesture_password_unlock)");
        final x<x.b.C8996b, x.c.g> xVar = new x<>(new x.b.C8996b(string, R.drawable.qui_lock_off), new x.c.g("", true, false));
        ReportController.y(f(), "0X800B7DD");
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.processors.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GesturePwdProcessor.B(GesturePwdProcessor.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.processors.c
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GesturePwdProcessor.C(view);
            }
        });
        Activity e16 = e();
        if (e16 instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) e16;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null && (A = A()) != null && (X1 = A.X1()) != null) {
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>(xVar) { // from class: com.tencent.mobileqq.qqsec.processors.GesturePwdProcessor$onCreateItemConfig$1$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ x<x.b.C8996b, x.c.g> $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = xVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GesturePwdProcessor.this, (Object) xVar);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    } else {
                        GesturePwdProcessor.this.G(this.$this_apply, num);
                        GesturePwdProcessor.this.l();
                    }
                }
            };
            X1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.qqsec.processors.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GesturePwdProcessor.D(Function1.this, obj);
                }
            });
            G(xVar, X1.getValue());
        }
        return xVar;
    }
}
