package com.tencent.ams.dsdk.core.wormhole;

import com.tencent.ams.dsdk.event.DKEventHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DKWormholeInitParams {
    static IPatchRedirector $redirector_;
    public String adType;
    public boolean debugMode;
    public boolean enableLog;
    public DKEventHandler eventHandler;
    public HippyImageLoader imageLoader;
    public String moduleId;
    public List<HippyAPIProvider> providers;

    public DKWormholeInitParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void setHippyParams(HippyEngine.EngineInitParams engineInitParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) engineInitParams);
            return;
        }
        if (engineInitParams != null) {
            engineInitParams.debugMode = this.debugMode;
            engineInitParams.enableLog = this.enableLog;
            HippyImageLoader hippyImageLoader = this.imageLoader;
            if (hippyImageLoader != null) {
                engineInitParams.imageLoader = hippyImageLoader;
            }
            List list = engineInitParams.providers;
            if (list == null) {
                list = new ArrayList();
            }
            List<HippyAPIProvider> list2 = this.providers;
            if (list2 != null) {
                list.addAll(list2);
            }
        }
    }
}
