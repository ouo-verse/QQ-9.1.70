package com.tencent.ams.mosaic.jsengine.common;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IAppManager {
    @JSMethod
    void callPhone(String str, JSFunction jSFunction);

    boolean canLaunchApp(String str, String str2);

    @JSMethod
    boolean install(String str);

    @JSMethod
    boolean isInstalled(String str);

    @JSMethod
    void launchApp(String str, String str2, JSFunction jSFunction);

    @JSMethod
    void launchAppByULink(String str, JSFunction jSFunction);

    void openAppstore(JSObject jSObject, JSFunction jSFunction);

    @JSMethod
    int registerOnAppInstalledEvent(String str, JSFunction jSFunction);

    @JSMethod
    boolean unregisterOnAppInstalledEvent(int i3);
}
