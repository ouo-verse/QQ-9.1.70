package com.tencent.could.huiyansdk.utils;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.CustomerConfig;
import com.tencent.could.huiyansdk.entity.HPCCompareResult;
import com.tencent.could.huiyansdk.enums.HuiYanPublicEvent;
import com.tencent.could.huiyansdk.fragments.AuthResultFragment;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.HuiYanOperateBody;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class k implements IJsonDataListener {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        HuiYanAuthImp.getInstance().sendOnLoadingEnd();
        String str2 = "LiveCompare, errMsg: " + str;
        if (l.a.f100309a.f100307a) {
            AiLog.debug("HuiYanSenderHelper", str2);
        }
        d.b.f100161a.a("AuthCheckStage", "RequestCompareError", com.tencent.could.huiyansdk.manager.d.a(0L, "onFail: " + str));
        com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
        cVar.a("GetCompareResultUseTime", 2, true, "onFailed:" + str);
        cVar.a("Compare", 1, 0L, "onFail: " + str);
        e.a(210, R.string.txy_network_connect_error);
        HuiYanSdkImp.getInstance().releaseCallBack();
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        HuiYanAuthImp.getInstance().sendOnLoadingEnd();
        HPCCompareResult hPCCompareResult = (HPCCompareResult) new Gson().fromJson(str, HPCCompareResult.class);
        com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
        kVar.a(1, "HuiYanSenderHelper", "on success: do live compare result: " + str);
        if (hPCCompareResult != null) {
            CompareResult compareResult = new CompareResult();
            compareResult.setErrorCode(hPCCompareResult.getErrorCode());
            compareResult.setErrorMsg(hPCCompareResult.getErrorMsg());
            com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
            dVar.a("AuthCheckStage", "RequestCompareSuccess", "");
            com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
            cVar.a("GetCompareResultUseTime", 2, false, "");
            if (compareResult.getErrorCode() == 0) {
                HuiYanAuthImp.getInstance().sendPublicEvent(HuiYanPublicEvent.GET_NET_RESULT);
                dVar.a("AuthCheckStage", "AuthResultSuccess", "");
                HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
                if (huiYanOperateBody != null) {
                    huiYanOperateBody.updateInfo("Compare", 1, 1L, System.currentTimeMillis());
                }
            } else {
                dVar.a("AuthCheckStage", "AuthResultError", "");
                cVar.a("Compare", 1, 0L, "error: " + compareResult.getErrorCode());
            }
            CustomerConfig currentCustomerConfig = HuiYanAuthImp.getInstance().getCurrentCustomerConfig();
            if (currentCustomerConfig != null && (currentCustomerConfig.isHiddenResultRage() || currentCustomerConfig.isHiddenLoadingPage())) {
                dVar.a("AuthCheckStage", "CustomerHideResultPage", "");
                HuiYanSdkImp.getInstance().closeCurrentUi();
                HYPCommonUtils.doResultCallBackResult(compareResult);
            } else {
                dVar.a("AuthCheckStage", "OpenShowResultPage", "");
                HuiYanSdkImp huiYanSdkImp = HuiYanSdkImp.getInstance();
                AuthResultFragment authResultFragment = new AuthResultFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("compareResult", compareResult);
                authResultFragment.setArguments(bundle);
                huiYanSdkImp.switchFragmentNoStackSwitchUi(authResultFragment);
            }
        } else {
            kVar.a(2, "HuiYanSenderHelper", "got do live compare result, but result is null.");
            d.b.f100161a.a("AuthCheckStage", "RequestCompareError", com.tencent.could.huiyansdk.manager.d.a(0L, "got do live compare result, but result is null."));
            com.tencent.could.huiyansdk.operate.c cVar2 = c.b.f100258a;
            cVar2.a("Compare", 1, 0L, "got do live compare result, but result is null.");
            e.a(210, R.string.txy_network_connect_error);
            cVar2.a("GetCompareResultUseTime", 2, true, "got do live compare result, but result is null.");
        }
        HuiYanSdkImp.getInstance().releaseCallBack();
    }
}
