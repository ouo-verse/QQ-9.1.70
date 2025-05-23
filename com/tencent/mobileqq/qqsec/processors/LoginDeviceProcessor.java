package com.tencent.mobileqq.qqsec.processors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.account.AccountSecurityVM;
import com.tencent.mobileqq.qqsec.account.t;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqsec/processors/LoginDeviceProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "message", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "g", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "accountSecurityVM", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LoginDeviceProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountSecurityVM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginDeviceProcessor(@NotNull Context context) {
        super(context, 5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountSecurityVM>() { // from class: com.tencent.mobileqq.qqsec.processors.LoginDeviceProcessor$accountSecurityVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoginDeviceProcessor.this);
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
                    Activity e16 = LoginDeviceProcessor.this.e();
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

    private final void A(String message) {
        QQToast.makeText(BaseApplication.getContext(), message, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private final AccountSecurityVM x() {
        return (AccountSecurityVM) this.accountSecurityVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_bas_landing_device_management");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        com.tencent.mobileqq.setting.processor.e eVar;
        Bundle bundle;
        String str;
        String str2;
        FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse;
        String str3;
        ReportController.y(f(), "0X800AC51");
        ReportController.o(f(), "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        ReportController.y(f(), "0X800B840");
        com.tencent.mobileqq.setting.processor.d h16 = h(11);
        IRedTouchManager iRedTouchManager = null;
        if (h16 instanceof com.tencent.mobileqq.setting.processor.e) {
            eVar = (com.tencent.mobileqq.setting.processor.e) h16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            bundle = eVar.d();
        } else {
            bundle = null;
        }
        if (bundle == null || (str = bundle.getString("phone")) == null) {
            str = "";
        }
        if (bundle == null || (str2 = bundle.getString("country_code")) == null) {
            str2 = "";
        }
        if (bundle == null) {
            if (!NetworkUtil.isNetworkAvailable()) {
                String string = BaseApplication.getContext().getString(R.string.b3j);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026.string.failedconnection)");
                A(string);
                return;
            } else {
                ReportController.y(f(), "0X800ACBF");
                String string2 = BaseApplication.getContext().getString(R.string.zvf);
                Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026g.eq_dev_info_on_loading)");
                A(string2);
                return;
            }
        }
        AppInterface f16 = f();
        if (f16 != null) {
            f16.sendWirelessMeibaoReq(1);
        }
        Intent intent = new Intent();
        AccountSecurityVM x16 = x();
        if (x16 != null) {
            faceSecureCheck$SecureCheckResponse = x16.e2();
        } else {
            faceSecureCheck$SecureCheckResponse = null;
        }
        intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, str);
        intent.putExtra("country_code", str2);
        intent.putExtra(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, true);
        if (faceSecureCheck$SecureCheckResponse == null) {
            intent.putExtra("secureState", "secureStateUNKNOWN");
        } else {
            if (faceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
                str3 = "secureStateOk";
            } else {
                str3 = "secureStateError";
            }
            intent.putExtra("secureState", str3);
            if (faceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
                intent.putExtra("faceAppId", faceSecureCheck$SecureCheckResponse.str_openid.get());
                intent.putExtra("faceTmpKey", faceSecureCheck$SecureCheckResponse.str_tmpkey.get());
            }
        }
        Activity e16 = e();
        if (e16 != null) {
            RouteUtils.startActivityForResult(e16, intent, RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY, 0);
        }
        AppInterface f17 = f();
        if (f17 != null) {
            iRedTouchManager = (IRedTouchManager) f17.getRuntimeService(IRedTouchManager.class, "");
        }
        if (iRedTouchManager != null) {
            iRedTouchManager.onRedTouchItemClick("100190.100199");
        }
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = BaseApplication.getContext().getString(R.string.zvg);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026ring.eq_login_dev_manage)");
        t tVar = new t(string, R.drawable.qui_computer_more, "100190.100199.100199001", null, 8, null);
        ReportController.y(f(), "0X800B7DC");
        ReportController.y(f(), "0X800AC50");
        tVar.M(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.qqsec.processors.LoginDeviceProcessor$onCreateItemConfig$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoginDeviceProcessor.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LoginDeviceProcessor.this.z();
                }
            }
        });
        tVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.processors.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                LoginDeviceProcessor.y(view);
            }
        });
        return tVar;
    }
}
