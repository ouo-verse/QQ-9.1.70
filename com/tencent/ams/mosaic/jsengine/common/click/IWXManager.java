package com.tencent.ams.mosaic.jsengine.common.click;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IWXManager {
    String getOpenSDKVersion();

    boolean isWXAppSupportApi();

    boolean isWxInstalled();

    void launchWxBusinessView(JSObject jSObject, JSFunction jSFunction);

    void launchWxMiniProgram(JSObject jSObject, JSFunction jSFunction);
}
