package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class CommercialDrainageManagerServiceProxy extends AbsEmoRuntimeServiceProxy<ICommercialDrainageManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_COMMERCIAL_ISRICHIPSITE = "action_commercial_isrichipsite";
    public static final String COMMERCIAL_RICHIPSITE = "commercial_richipsite";
    public static final String COMMERCIAL_RICHIPSITE_INFO = "commercial_richipsite_info";
    public static final String TAG = "CommercialDrainageManagerServiceProxy";

    public CommercialDrainageManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ICommercialDrainageManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult checkMatch(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (ACTION_COMMERCIAL_ISRICHIPSITE.equals(str)) {
            return onIsRichIPSite((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult onIsRichIPSite(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean isRichIPSite = ((ICommercialDrainageManagerService) baseQQAppInterface.getRuntimeService(ICommercialDrainageManagerService.class)).isRichIPSite((VipIPSiteInfo) bundle.getParcelable(COMMERCIAL_RICHIPSITE_INFO));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(COMMERCIAL_RICHIPSITE, isRichIPSite);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public boolean isRichIPSite(VipIPSiteInfo vipIPSiteInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) vipIPSiteInfo)).booleanValue();
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do isRichIPSite.");
            }
            return ((ICommercialDrainageManagerService) this.manager).isRichIPSite(vipIPSiteInfo);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(COMMERCIAL_RICHIPSITE_INFO, vipIPSiteInfo);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_COMMERCIAL_ISRICHIPSITE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(COMMERCIAL_RICHIPSITE);
        }
        QLog.e(TAG, 4, "isRichIPSite fail.");
        return false;
    }
}
