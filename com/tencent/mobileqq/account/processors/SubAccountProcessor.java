package com.tencent.mobileqq.account.processors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/account/processors/SubAccountProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "E", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "y", "D", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/account/viewmodel/c;", "g", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/account/viewmodel/c;", "vm", "Lcom/tencent/mobileqq/app/dc;", tl.h.F, "Lcom/tencent/mobileqq/app/dc;", "subAccountBindObserver", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/app/BaseMessageObserver;", "subPushObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "j", "a", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SubAccountProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dc subAccountBindObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subPushObserver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/account/processors/SubAccountProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.processors.SubAccountProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/account/processors/SubAccountProcessor$b", "Lcom/tencent/mobileqq/app/dc;", "", "isSuccess", "Lcom/tencent/mobileqq/subaccount/logic/a;", "data", "", "b", "a", "c", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends dc {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean isSuccess, @NotNull com.tencent.mobileqq.subaccount.logic.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("SubAccountProcessor", 1, "onBindSubAccount");
            SubAccountProcessor.this.E();
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean isSuccess, @NotNull com.tencent.mobileqq.subaccount.logic.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("SubAccountProcessor", 1, "onGetBindSubAccount");
            SubAccountProcessor.this.E();
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean isSuccess, @NotNull com.tencent.mobileqq.subaccount.logic.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("SubAccountProcessor", 1, "onUnBindSubAccount");
            SubAccountProcessor.this.E();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAccountProcessor(@NotNull Context context) {
        super(context, 1);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.account.viewmodel.c>() { // from class: com.tencent.mobileqq.account.processors.SubAccountProcessor$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.mobileqq.account.viewmodel.c invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.account.viewmodel.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Activity e16 = SubAccountProcessor.this.e();
                    QBaseActivity qBaseActivity = e16 instanceof QBaseActivity ? (QBaseActivity) e16 : null;
                    if (qBaseActivity == null) {
                        return null;
                    }
                    return (com.tencent.mobileqq.account.viewmodel.c) com.tencent.mobileqq.mvvm.h.a(qBaseActivity).get(com.tencent.mobileqq.account.viewmodel.c.class);
                }
            });
            this.vm = lazy;
            this.subAccountBindObserver = new b();
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BaseMessageObserver>() { // from class: com.tencent.mobileqq.account.processors.SubAccountProcessor$subPushObserver$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final BaseMessageObserver invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ((ISettingApi) QRoute.api(ISettingApi.class)).getPushSubMessageObserver(SubAccountProcessor.this.e(), new Function0<Unit>() { // from class: com.tencent.mobileqq.account.processors.SubAccountProcessor$subPushObserver$2.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) SubAccountProcessor.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                QLog.d("SubAccountProcessor", 1, "subPushObserver");
                                SubAccountProcessor.this.E();
                            }
                        }
                    }) : (BaseMessageObserver) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.subPushObserver = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final com.tencent.mobileqq.account.viewmodel.c A() {
        return (com.tencent.mobileqq.account.viewmodel.c) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(SubAccountProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C() {
        Activity e16 = e();
        if (e16 == null || u.a().b()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("fromWhere", ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName());
        intent.putExtra("fromWhereExactly", 2);
        RouteUtils.startActivity(e16, intent, RouterConstants.UI_ROUTE_SUB_ACCOUNT_ASSOCIATED_ACCOUNT);
        ReportController.o(f(), "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
        ReportController.o(f(), "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
        ReportController.y(f(), "0X800B838");
        QLog.d("SubAccountProcessor", 2, "subAccountClickListener AccountManageActivity-bindQQClick");
        ReportController.o(f(), "dc00898", "", "", "0X800B838", "0X800B838", 0, 0, "", "", "", "");
    }

    private final void D(BusinessObserver observer) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.account.processors.l
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountProcessor.F(SubAccountProcessor.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(SubAccountProcessor this$0) {
        ISubAccountService iSubAccountService;
        MutableLiveData<List<String>> P1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppInterface f16 = this$0.f();
        List<String> list = null;
        if (f16 != null) {
            iSubAccountService = (ISubAccountService) f16.getRuntimeService(ISubAccountService.class, "");
        } else {
            iSubAccountService = null;
        }
        if (iSubAccountService != null) {
            list = iSubAccountService.getAllSubUin();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        QLog.d("SubAccountProcessor", 1, "updateSubAccountList size=" + list.size());
        com.tencent.mobileqq.account.viewmodel.c A = this$0.A();
        if (A != null && (P1 = A.P1()) != null) {
            P1.postValue(list);
        }
    }

    private final void y(BusinessObserver observer) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(observer);
        }
    }

    private final BaseMessageObserver z() {
        return (BaseMessageObserver) this.subPushObserver.getValue();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.o();
        y(this.subAccountBindObserver);
        y(z());
        E();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        ReportController.y(f(), "0X800B7D4");
        E();
        y(this.subAccountBindObserver);
        y(z());
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        D(this.subAccountBindObserver);
        D(z());
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.account.viewmodel.c A = A();
        Activity e16 = e();
        if (e16 instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) e16;
        } else {
            qBaseActivity = null;
        }
        com.tencent.mobileqq.account.configs.i iVar = new com.tencent.mobileqq.account.configs.i(A, qBaseActivity);
        iVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubAccountProcessor.B(SubAccountProcessor.this, view);
            }
        });
        return iVar;
    }
}
