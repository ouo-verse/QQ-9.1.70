package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippySSR;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.ssr.SSRBundleRequester;
import com.tencent.hippy.qq.ssr.SSRManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippySSRImpl implements IHippySSR {
    @Override // com.tencent.hippy.qq.api.IHippySSR
    public ISSRBundleRequester createSSRBundleRequester() {
        return new SSRBundleRequester();
    }

    @Override // com.tencent.hippy.qq.api.IHippySSR
    public int getSSRCommonJsVersion() {
        return SSRManager.getInstance().getSSRCommonJsVersion();
    }

    @Override // com.tencent.hippy.qq.api.IHippySSR
    public boolean loadSSRCommonJs(HippyQQEngine hippyQQEngine, int i3) {
        return SSRManager.getInstance().loadSSRCommonJs(hippyQQEngine, i3);
    }

    @Override // com.tencent.hippy.qq.api.IHippySSR
    public void updateSSRCommonJs() {
        SSRManager.getInstance().updateSSRCommonJs();
    }
}
