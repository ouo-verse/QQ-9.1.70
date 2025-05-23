package com.tencent.mobileqq.account.processors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.account.configs.SubAccountBannerConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/account/processors/SubAccountBannerProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "N", "", "bindNum", "G", "O", "M", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "onResume", "o", "Lcom/tencent/mobileqq/account/viewmodel/a;", "g", "Lcom/tencent/mobileqq/account/viewmodel/a;", "accountVM", "Lcom/tencent/mobileqq/account/viewmodel/c;", tl.h.F, "Lkotlin/Lazy;", "I", "()Lcom/tencent/mobileqq/account/viewmodel/c;", "subAccountVM", "Lcom/tencent/mobileqq/account/configs/SubAccountBannerConfig;", "i", "H", "()Lcom/tencent/mobileqq/account/configs/SubAccountBannerConfig;", "bannerConfig", "j", "accountSize", "k", "action", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/account/viewmodel/a;)V", "l", "a", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SubAccountBannerProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.account.viewmodel.a accountVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subAccountVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bannerConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int accountSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int action;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/account/processors/SubAccountBannerProcessor$a;", "", "", "SHOW_BANNER_ACCOUNT_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.processors.SubAccountBannerProcessor$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAccountBannerProcessor(@NotNull Context context, @NotNull com.tencent.mobileqq.account.viewmodel.a accountVM) {
        super(context, 8);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountVM, "accountVM");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) accountVM);
            return;
        }
        this.accountVM = accountVM;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.account.viewmodel.c>() { // from class: com.tencent.mobileqq.account.processors.SubAccountBannerProcessor$subAccountVM$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerProcessor.this);
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
                Activity e16 = SubAccountBannerProcessor.this.e();
                QBaseActivity qBaseActivity = e16 instanceof QBaseActivity ? (QBaseActivity) e16 : null;
                if (qBaseActivity == null) {
                    return null;
                }
                return (com.tencent.mobileqq.account.viewmodel.c) com.tencent.mobileqq.mvvm.h.a(qBaseActivity).get(com.tencent.mobileqq.account.viewmodel.c.class);
            }
        });
        this.subAccountVM = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new SubAccountBannerProcessor$bannerConfig$2(this));
        this.bannerConfig = lazy2;
        this.action = -1;
    }

    private final int G(int bindNum) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.account.viewmodel.c I = I();
        if (I != null && I.N1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        com.tencent.mobileqq.account.viewmodel.c I2 = I();
        if (I2 != null) {
            z17 = Intrinsics.areEqual(I2.M1(), Boolean.FALSE);
        } else {
            z17 = false;
        }
        if (z17 && bindNum == 0) {
            return 1;
        }
        if (bindNum != 1 || this.accountSize < 3) {
            return 0;
        }
        return 2;
    }

    private final SubAccountBannerConfig H() {
        return (SubAccountBannerConfig) this.bannerConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.account.viewmodel.c I() {
        return (com.tencent.mobileqq.account.viewmodel.c) this.subAccountVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        if (u.a().b()) {
            return;
        }
        com.tencent.mobileqq.account.viewmodel.c I = I();
        if (I != null) {
            I.R1(true);
        }
        int i3 = this.action;
        if (1 == i3) {
            ReportController.o(f(), "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
            Intent intent = new Intent();
            intent.putExtra("fromWhere", ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName());
            intent.putExtra("fromWhereExactly", 3);
            Activity e16 = e();
            if (e16 != null) {
                RouteUtils.startActivity(e16, intent, RouterConstants.UI_ROUTER_SUBACCOUNT_UG);
            }
        } else if (2 == i3) {
            ReportController.o(f(), "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
            Intent intent2 = new Intent();
            intent2.putExtra("fromWhere", ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName());
            intent2.putExtra("fromWhereExactly", 3);
            Activity e17 = e();
            if (e17 != null) {
                RouteUtils.startActivity(e17, intent2, RouterConstants.UI_ROUTER_SUBACCOUNT_BIND);
            }
        }
        ReportController.y(f(), "0X800BDF2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        int i3;
        Boolean bool;
        MutableLiveData<Integer> O1;
        MutableLiveData<List<String>> P1;
        List<String> value;
        com.tencent.mobileqq.account.viewmodel.c I = I();
        if (I != null && (P1 = I.P1()) != null && (value = P1.getValue()) != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        int G = G(i3);
        if (G != this.action) {
            this.action = G;
            com.tencent.mobileqq.account.viewmodel.c I2 = I();
            if (I2 != null && (O1 = I2.O1()) != null) {
                O1.postValue(Integer.valueOf(this.action));
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshSubAccountBanner lastAccountBind=");
            com.tencent.mobileqq.account.viewmodel.c I3 = I();
            if (I3 != null) {
                bool = I3.M1();
            } else {
                bool = null;
            }
            sb5.append(bool);
            sb5.append(" bindNum=");
            sb5.append(i3);
            sb5.append(", action=");
            sb5.append(G);
            QLog.i("SubAccountBannerProcessor", 1, sb5.toString());
        }
    }

    private final void O() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.account.processors.f
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountBannerProcessor.P(SubAccountBannerProcessor.this);
            }
        }, 8, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(SubAccountBannerProcessor this$0) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecentUserProxy recentUserProxy = ((ISettingApi) QRoute.api(ISettingApi.class)).getRecentUserProxy();
        String str2 = AppConstants.SUBACCOUNT_ASSISTANT_UIN;
        if (recentUserProxy.findRecentUser(str2, 7000) != null) {
            com.tencent.mobileqq.account.viewmodel.c I = this$0.I();
            if (I != null) {
                i3 = I.L1();
            } else {
                i3 = 0;
            }
            if (i3 >= 3) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("refreshSubAccount() set stick2top fail.");
                    AppInterface f16 = this$0.f();
                    if (f16 != null) {
                        str = f16.getCurrentAccountUin();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    sb5.append(" count=");
                    sb5.append(i3);
                    sb5.append(" >=maxStick2TopCount , return.");
                    QLog.d("SubAccountBannerProcessor", 2, sb5.toString());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountBannerProcessor", 2, "refreshSubAccount() RecentList has default subAccount RU. go 2 stick2Top, current count=" + i3);
            }
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setTopInRecentList(this$0.f(), str2, true);
            com.tencent.mobileqq.account.viewmodel.c I2 = this$0.I();
            if (I2 != null) {
                I2.S1(i3);
                return;
            }
            return;
        }
        com.tencent.mobileqq.account.viewmodel.c I3 = this$0.I();
        if (I3 != null) {
            I3.S1(3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountBannerProcessor", 2, "recent list does not exist ruDefault.");
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        int i3;
        MutableLiveData<List<String>> P1;
        List<String> value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.o();
        com.tencent.mobileqq.account.viewmodel.c I = I();
        if (I != null) {
            I.Q1();
        }
        com.tencent.mobileqq.account.viewmodel.c I2 = I();
        if (I2 != null && (P1 = I2.P1()) != null && (value = P1.getValue()) != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            O();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        QBaseActivity qBaseActivity;
        MutableLiveData<Integer> O1;
        MutableLiveData<List<String>> P1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        Activity e16 = e();
        if (e16 instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) e16;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        MutableLiveData<List<QQAccount>> M1 = this.accountVM.M1();
        final Function1<List<? extends QQAccount>, Unit> function1 = new Function1<List<? extends QQAccount>, Unit>() { // from class: com.tencent.mobileqq.account.processors.SubAccountBannerProcessor$onCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerProcessor.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QQAccount> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends QQAccount> list) {
                int i3;
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                SubAccountBannerProcessor.this.accountSize = list.size();
                i3 = SubAccountBannerProcessor.this.accountSize;
                if (i3 >= 3) {
                    i16 = SubAccountBannerProcessor.this.action;
                    if (i16 <= 0) {
                        SubAccountBannerProcessor.this.N();
                    }
                }
            }
        };
        M1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.account.processors.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubAccountBannerProcessor.J(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.account.viewmodel.c I = I();
        if (I != null && (P1 = I.P1()) != null) {
            final Function1<List<? extends String>, Unit> function12 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.account.processors.SubAccountBannerProcessor$onCreate$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerProcessor.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                    invoke2((List<String>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<String> list) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SubAccountBannerProcessor.this.N();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    }
                }
            };
            P1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.account.processors.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SubAccountBannerProcessor.K(Function1.this, obj);
                }
            });
        }
        com.tencent.mobileqq.account.viewmodel.c I2 = I();
        if (I2 != null && (O1 = I2.O1()) != null) {
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.account.processors.SubAccountBannerProcessor$onCreate$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerProcessor.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    com.tencent.mobileqq.account.viewmodel.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                        return;
                    }
                    boolean z16 = num == null || num.intValue() != 0;
                    aVar = SubAccountBannerProcessor.this.accountVM;
                    aVar.Q1().setValue(Boolean.valueOf(z16));
                    SubAccountBannerProcessor.this.m(z16);
                }
            };
            O1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.account.processors.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SubAccountBannerProcessor.L(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            N();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        MutableLiveData<Integer> O1;
        Integer value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SubAccountBannerConfig H = H();
        SubAccountBannerConfig H2 = H();
        com.tencent.mobileqq.account.viewmodel.c I = I();
        boolean z16 = false;
        if (I != null && (O1 = I.O1()) != null && (value = O1.getValue()) != null && value.intValue() == 0) {
            z16 = true;
        }
        H2.p(!z16);
        return H;
    }
}
