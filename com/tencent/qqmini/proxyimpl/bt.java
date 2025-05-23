package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes34.dex */
public class bt implements ThirdPartyMiniPageProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needRestart(String str, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needShareToQQ(String str, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needShareToQZone(String str, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public Map<String, String> getShareParam(String str, int i3) {
        Map<String, String> shareParams;
        if (i3 == 1) {
            shareParams = ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).getShareParams();
        } else {
            shareParams = i3 == 2 ? ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).getShareParams() : null;
        }
        if (shareParams == null) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, HardCodeUtil.qqStr(R.string.ust), 0).show();
        }
        return shareParams;
    }
}
