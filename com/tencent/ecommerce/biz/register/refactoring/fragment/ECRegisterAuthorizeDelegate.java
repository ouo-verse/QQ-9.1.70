package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.common.ECMsgBoxDialog;
import com.tencent.ecommerce.biz.register.a;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECCheckOriginPhoneNumDialog;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECPhoneNumInconsistentDialog;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterReportScene;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.register.refactoring.utils.IECAuthorizeDelegateCallBack;
import com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.wallet.IWallet;
import com.tencent.ecommerce.biz.wallet.WalletRequestListener;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import com.tencent.ecommerce.repo.register.ECRegisterRespStatus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0015B7\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00102\u001a\u000200\u0012\u0006\u00105\u001a\u000203\u0012\u0006\u0010:\u001a\u000206\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010\u0013\u001a\u00020\u0002R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u001c\u0010&\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010)\u001a\u00020'8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010(R\u0014\u0010,\u001a\u00020*8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0014\u0010/\u001a\u00020-8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010.R\u0014\u00102\u001a\u0002008\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00101R\u0014\u00105\u001a\u0002038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00104R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECRegisterAuthorizeDelegate;", "", "", "k", "f", "", "status", "i", "l", "j", h.F, "", "showLoadingDialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "errorCode", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;)V", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "o", "p", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel;", "a", "Lkotlin/Lazy;", "g", "()Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel;", "registerConfirmViewModel", "Lcom/tencent/ecommerce/base/ui/d;", "b", "Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", "", "kotlin.jvm.PlatformType", "c", "Ljava/lang/String;", "isMcn", "d", "jumpScheme", "e", "deliverProductCallbackId", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "Landroid/os/Bundle;", "arguments", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/IECAuthorizeDelegateCallBack;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/IECAuthorizeDelegateCallBack;", "getCallback", "()Lcom/tencent/ecommerce/biz/register/refactoring/utils/IECAuthorizeDelegateCallBack;", "callback", "<init>", "(Landroid/content/Context;Landroid/app/Activity;Landroid/os/Bundle;Landroidx/lifecycle/LifecycleOwner;Landroidx/fragment/app/FragmentManager;Lcom/tencent/ecommerce/biz/register/refactoring/utils/IECAuthorizeDelegateCallBack;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterAuthorizeDelegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy registerConfirmViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.base.ui.d loadingDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String isMcn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String jumpScheme;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String deliverProductCallbackId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Activity activity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Bundle arguments;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final LifecycleOwner viewLifecycleOwner;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final FragmentManager childFragmentManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final IECAuthorizeDelegateCallBack callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel$GetPsKeyStatus;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel$GetPsKeyStatus;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<ECRegisterConfirmViewModel.GetPsKeyStatus> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECRegisterConfirmViewModel.GetPsKeyStatus getPsKeyStatus) {
            if (getPsKeyStatus != ECRegisterConfirmViewModel.GetPsKeyStatus.SUCCESS) {
                ECRegisterAuthorizeDelegate.this.m(false);
                i.f101155b.d("\u83b7\u53d6\u767b\u9646\u6001\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", ECToastIcon.ICON_ERROR, 0);
            } else {
                ECRegisterAuthorizeDelegate.this.g().o2();
            }
            a.f103962b.j(1, ECRegisterReportScene.GET_PS_KEY.sceneType, getPsKeyStatus.ordinal());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<Integer> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            ECRegisterAuthorizeDelegate.this.i(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<Integer> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            ECRegisterAuthorizeDelegate.this.j(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/register/ECMsgBox;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<ECMsgBox> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECMsgBox eCMsgBox) {
            ECRegisterAuthorizeDelegate eCRegisterAuthorizeDelegate = ECRegisterAuthorizeDelegate.this;
            new ECMsgBoxDialog(eCRegisterAuthorizeDelegate.context, eCMsgBox, eCRegisterAuthorizeDelegate.activity).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECRegisterAuthorizeDelegate$g", "Lcom/tencent/ecommerce/biz/wallet/WalletRequestListener;", "", "resCode", "", "", "result", "", "onFail", "(Ljava/lang/Integer;Ljava/util/Map;)V", "", "onSucc", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements WalletRequestListener {
        g() {
        }

        @Override // com.tencent.ecommerce.biz.wallet.WalletRequestListener
        public void onFail(Integer resCode, Map<String, String> result) {
            cg0.a.b("ECRegisterAuthorizeDelegate", "[QQWallet] failed, resCode = " + resCode);
        }

        @Override // com.tencent.ecommerce.biz.wallet.WalletRequestListener
        public void onSucc(Integer resCode, Map<String, Boolean> result) {
            cg0.a.b("ECRegisterAuthorizeDelegate", "[QQWallet] succeeded, resCode = " + resCode);
        }
    }

    public ECRegisterAuthorizeDelegate(Context context, Activity activity, Bundle bundle, LifecycleOwner lifecycleOwner, FragmentManager fragmentManager, IECAuthorizeDelegateCallBack iECAuthorizeDelegateCallBack) {
        Lazy lazy;
        this.context = context;
        this.activity = activity;
        this.arguments = bundle;
        this.viewLifecycleOwner = lifecycleOwner;
        this.childFragmentManager = fragmentManager;
        this.callback = iECAuthorizeDelegateCallBack;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECRegisterConfirmViewModel>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECRegisterAuthorizeDelegate$registerConfirmViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECRegisterConfirmViewModel invoke() {
                return new ECRegisterConfirmViewModel(ECRegisterAuthorizeDelegate.this.arguments);
            }
        });
        this.registerConfirmViewModel = lazy;
        this.isMcn = bundle.getString("is_mcn", "0");
        this.jumpScheme = bundle.getString("jump_scheme", "");
        this.deliverProductCallbackId = bundle.getString("scheme_callback_id", "");
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECRegisterConfirmViewModel g() {
        return (ECRegisterConfirmViewModel) this.registerConfirmViewModel.getValue();
    }

    private final void h() {
        ECPhoneNumInconsistentDialog eCPhoneNumInconsistentDialog = new ECPhoneNumInconsistentDialog();
        Bundle bundle = new Bundle();
        bundle.putString("origin_phone_number", g().getOriginPhoneNum());
        Unit unit = Unit.INSTANCE;
        eCPhoneNumInconsistentDialog.setArguments(bundle);
        eCPhoneNumInconsistentDialog.uh(this.childFragmentManager, new Function1<ECPhoneNumInconsistentDialog.PhoneNumInconsistentDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECRegisterAuthorizeDelegate$handlePhoneNumInconsistent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECPhoneNumInconsistentDialog.PhoneNumInconsistentDialogResult phoneNumInconsistentDialogResult) {
                invoke2(phoneNumInconsistentDialogResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECPhoneNumInconsistentDialog.PhoneNumInconsistentDialogResult phoneNumInconsistentDialogResult) {
                if (Intrinsics.areEqual(phoneNumInconsistentDialogResult, ECPhoneNumInconsistentDialog.PhoneNumInconsistentDialogResult.SendVerifyMsg.f104001d)) {
                    ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog = new ECCheckOriginPhoneNumDialog();
                    eCCheckOriginPhoneNumDialog.Ch(ECRegisterAuthorizeDelegate.this.g());
                    eCCheckOriginPhoneNumDialog.uh(ECRegisterAuthorizeDelegate.this.childFragmentManager, new Function1<ECCheckOriginPhoneNumDialog.CheckOriginPhoneNumResult, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECRegisterAuthorizeDelegate$handlePhoneNumInconsistent$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ECCheckOriginPhoneNumDialog.CheckOriginPhoneNumResult checkOriginPhoneNumResult) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ECCheckOriginPhoneNumDialog.CheckOriginPhoneNumResult checkOriginPhoneNumResult) {
                            invoke2(checkOriginPhoneNumResult);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int status) {
        if (status != ECRegisterRespStatus.SUCCESS.status) {
            m(false);
            if (status == ECRegisterRespStatus.USER_WALLET_NO_IDENTITY_VERIFICATION.status) {
                hg0.a.c(hg0.a.f404850b, "ECRegisterGoToWalletPage", null, 2, null);
                l();
            } else {
                o(status);
            }
        } else {
            g().T1(this.context);
            m(false);
        }
        a.f103962b.j(1, ECRegisterReportScene.REAL_NAME_VERIFY.sceneType, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int status) {
        Map mutableMapOf;
        a.f103962b.j(1, ECRegisterReportScene.REGISTER.sceneType, status);
        if (status == 0) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("jump_scheme", this.jumpScheme), TuplesKt.to("scheme_callback_id", this.deliverProductCallbackId), TuplesKt.to("is_mcn", this.isMcn));
            yi0.a.t(Uri.parse(String.valueOf(56)), mutableMapOf, null, null, 12, null);
            LifecycleEventBus.f100688b.f(new ECRegisterSuccessEvent(true));
        } else if (status == ECRegisterRespStatus.PHONE_NUMBER_INCONSISTENT.status) {
            h();
        } else {
            o(status);
        }
    }

    private final void k() {
        g().W1().observe(this.viewLifecycleOwner, new b());
        g().c2().observe(this.viewLifecycleOwner, new c());
        g().U1().observe(this.viewLifecycleOwner, new d());
        g().g2().observe(this.viewLifecycleOwner, new e());
        g().e2().observe(this.viewLifecycleOwner, new f());
    }

    private final void l() {
        a.f103962b.i();
        IWallet wallet = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getWallet();
        if (wallet != null) {
            wallet.requestVerify(this.context, new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean showLoadingDialog) {
        com.tencent.ecommerce.base.ui.d dVar;
        com.tencent.ecommerce.base.ui.d dVar2;
        com.tencent.ecommerce.base.ui.d dVar3;
        if (this.loadingDialog == null) {
            com.tencent.ecommerce.base.ui.d dVar4 = new com.tencent.ecommerce.base.ui.d(this.context, null, 2, null);
            dVar4.setCanceledOnTouchOutside(false);
            Unit unit = Unit.INSTANCE;
            this.loadingDialog = dVar4;
        }
        if (showLoadingDialog && ((dVar3 = this.loadingDialog) == null || !dVar3.isShowing())) {
            com.tencent.ecommerce.base.ui.d dVar5 = this.loadingDialog;
            if (dVar5 != null) {
                dVar5.show();
                return;
            }
            return;
        }
        if (showLoadingDialog || (dVar = this.loadingDialog) == null || !dVar.isShowing() || (dVar2 = this.loadingDialog) == null) {
            return;
        }
        dVar2.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Integer errorCode) {
        String str;
        ECRegisterRespStatus eCRegisterRespStatus = ECRegisterRespStatus.ERROR_CODE_FACE_VERIFY_CANCELED;
        int i3 = eCRegisterRespStatus.status;
        if (errorCode != null && errorCode.intValue() == i3) {
            this.callback.restoreAuthorizeFloatWindow();
        }
        int i16 = eCRegisterRespStatus.status;
        if (errorCode != null && errorCode.intValue() == i16) {
            str = "\u4eba\u8138\u8bc6\u522b\u88ab\u53d6\u6d88";
        } else {
            str = "\u4eba\u8138\u8bc6\u522b\u5931\u8d25, \u9519\u8bef\u7801 " + errorCode;
        }
        i.f101155b.d(str, ECToastIcon.ICON_ERROR, 0);
    }

    private final void o(int statusCode) {
        if (statusCode == ECRegisterRespStatus.PHONE_NUMBER_EXIST.status) {
            final com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(this.context);
            gVar.setTitle(gVar.getContext().getResources().getString(R.string.weq));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(gVar.getContext().getResources().getString(R.string.wrg), Arrays.copyOf(new Object[]{g().getOriginPhoneNum()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            gVar.Y(format);
            gVar.b0(gVar.getContext().getResources().getString(R.string.wgw));
            gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECRegisterAuthorizeDelegate$showToastForRegisterError$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    g.this.dismiss();
                }
            });
            gVar.f0(gVar.getContext().getResources().getString(R.string.wil));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECRegisterAuthorizeDelegate$showToastForRegisterError$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                    g.this.dismiss();
                }
            });
            gVar.show();
            return;
        }
        ECRegisterCommonDialog.q(ECRegisterCommonDialog.f104005a, statusCode, this.context, null, 4, null);
    }

    public final void p() {
        f();
    }

    private final void f() {
        m(true);
        g().Z1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<Integer> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num == null || num.intValue() != 0) {
                ECRegisterAuthorizeDelegate.this.n(num);
            } else {
                ECRegisterAuthorizeDelegate.this.g().p2();
            }
            a.f103962b.j(1, ECRegisterReportScene.FACE_VERIFY.sceneType, num.intValue());
        }
    }
}
