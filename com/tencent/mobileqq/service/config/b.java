package com.tencent.mobileqq.service.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReqInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, String str, ArrayList<GetResourceReqInfo> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "ResourceConfig.GetResourceReq");
            toServiceMsg.extraData.putSerializable("getResourceReqInfos", arrayList);
            appInterface.sendToService(toServiceMsg);
        }
    }
}
