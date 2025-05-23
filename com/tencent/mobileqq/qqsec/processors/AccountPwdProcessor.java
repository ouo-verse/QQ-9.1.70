package com.tencent.mobileqq.qqsec.processors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqsec/processors/AccountPwdProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", HippyTKDListViewAdapter.X, "", "actionName", "", IProfileCardConst.KEY_FROM_TYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AccountPwdProcessor extends com.tencent.mobileqq.setting.processor.c {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPwdProcessor(@NotNull Context context) {
        super(context, 4);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Activity activity) {
        AppInterface appInterface;
        boolean contains$default;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (com.tencent.mobileqq.phonelogin.a.a().b(appInterface, currentAccountUin)) {
            Intent intent = new Intent();
            intent.putExtra("uin", currentAccountUin);
            String updatePwdUrl = ((ISafeApi) QRoute.api(ISafeApi.class)).getUpdatePwdUrl("HasSetPwdUrl");
            boolean z16 = !TextUtils.isEmpty(updatePwdUrl);
            if (!z16) {
                updatePwdUrl = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
            }
            if (updatePwdUrl != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(updatePwdUrl);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) updatePwdUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (!contains$default) {
                    str = "?uin=" + currentAccountUin;
                } else {
                    str = "&uin=" + currentAccountUin;
                }
                sb5.append(str);
                updatePwdUrl = sb5.toString();
            }
            intent.putExtra("url", updatePwdUrl);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            appInterface.sendWirelessPswReq(1);
            if (!z16) {
                z("FetchUrl", 1);
            }
            z("ClkModifyPwd", 1);
            return;
        }
        String updatePwdUrl2 = ((ISafeApi) QRoute.api(ISafeApi.class)).getUpdatePwdUrl("RegNewUrl");
        boolean z17 = !TextUtils.isEmpty(updatePwdUrl2);
        ((ISafeApi) QRoute.api(ISafeApi.class)).gotoPwdSetWebsite(updatePwdUrl2, currentAccountUin, activity, appInterface);
        if (!z17) {
            z("FetchUrl", 2);
        }
        z("ClkModifyPwd", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_bas_account_password");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final void z(String actionName, int fromType) {
        ReportController.o(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", actionName, fromType, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.o();
            l();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = BaseApplication.getContext().getString(R.string.f199964qu);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026ing.qq_login_account_pwd)");
        com.tencent.mobileqq.setting.config.b bVar = new com.tencent.mobileqq.setting.config.b(string, R.drawable.qui_key, "100190.100199.100199002", null, 8, null);
        ReportController.y(f(), "0X800B7DA");
        ReportController.y(f(), "0X800B29B");
        bVar.M(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.qqsec.processors.AccountPwdProcessor$onCreateItemConfig$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountPwdProcessor.this);
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
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                ReportController.y(AccountPwdProcessor.this.f(), "0X800B83E");
                ReportController.y(AccountPwdProcessor.this.f(), "0X800B29C");
                Activity e16 = AccountPwdProcessor.this.e();
                if (e16 != null) {
                    AccountPwdProcessor.this.x(e16);
                }
                AppInterface f16 = AccountPwdProcessor.this.f();
                IRedTouchManager iRedTouchManager = f16 != null ? (IRedTouchManager) f16.getRuntimeService(IRedTouchManager.class, "") : null;
                if (iRedTouchManager != null) {
                    iRedTouchManager.onRedTouchItemClick("100190.100199");
                }
                AccountPwdProcessor.this.l();
            }
        });
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.processors.a
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountPwdProcessor.y(view);
            }
        });
        return bVar;
    }
}
