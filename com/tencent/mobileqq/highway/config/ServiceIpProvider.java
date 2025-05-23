package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class ServiceIpProvider {
    static IPatchRedirector $redirector_;
    private IpContainer mGetIpContainer;
    private IpContainer mPushIpContainer;

    public ServiceIpProvider(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.mPushIpContainer = new IpContainer(context, i3 + "highway_config_push");
        this.mGetIpContainer = new IpContainer(context, i3 + "highway_config_ssoget");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPushIp(HwConfig hwConfig) {
        this.mPushIpContainer.addNew(BaseApplication.getContext(), hwConfig, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSSOGetIp(HwConfig hwConfig) {
        this.mGetIpContainer.addNew(BaseApplication.getContext(), hwConfig, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<EndPoint> getIpList(Context context, boolean z16) {
        IpContainer ipContainer;
        IpContainer ipContainer2 = this.mPushIpContainer;
        if (ipContainer2 != null) {
            ArrayList<EndPoint> findIpCurNetList = ipContainer2.findIpCurNetList(context, z16);
            if ((findIpCurNetList == null || findIpCurNetList.size() == 0) && (ipContainer = this.mGetIpContainer) != null) {
                return ipContainer.findIpCurNetList(context, z16);
            }
            return findIpCurNetList;
        }
        return null;
    }
}
