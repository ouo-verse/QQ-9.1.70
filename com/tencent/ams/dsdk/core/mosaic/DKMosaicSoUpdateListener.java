package com.tencent.ams.dsdk.core.mosaic;

import com.tencent.ams.dsdk.cache.SoConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.SoConfig;
import com.tencent.ams.dsdk.fodder.SoConfigManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicSoUpdateListener implements SoConfigManager.OnSoConfigUpdateListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicSoUpdateListener";

    public DKMosaicSoUpdateListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.fodder.SoConfigManager.OnSoConfigUpdateListener
    public void onUpdated(List<SoConfig> list) {
        com.tencent.ams.mosaic.load.d quickJSSOConfig;
        com.tencent.ams.mosaic.load.d quickJSSOConfig2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        DLog.i(TAG, "onUpdated, configs: " + list);
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (SoConfig soConfig : list) {
                if (soConfig != null && soConfig.engineType == 1 && (quickJSSOConfig2 = DKMosaicEngineHelper.getInstance().toQuickJSSOConfig(soConfig)) != null) {
                    hashMap.put(quickJSSOConfig2.f71512a, quickJSSOConfig2);
                }
            }
        }
        SoConfig soConfig2 = SoConfigCache.getInstance().getSoConfig(1);
        if (soConfig2 != null && (quickJSSOConfig = DKMosaicEngineHelper.getInstance().toQuickJSSOConfig(soConfig2)) != null) {
            hashMap.put(quickJSSOConfig.f71512a, quickJSSOConfig);
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        f.k().R(DKConfiguration.isUseNewSoLoader());
        f.k().P(DKEngine.getApplicationContext(), arrayList);
    }
}
