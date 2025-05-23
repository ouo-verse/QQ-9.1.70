package com.tencent.ams.mosaic.jsengine.common;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface INativeBridge {
    @Deprecated
    void invoke(String str, String str2, JSObject jSObject, JSFunction jSFunction);

    void invokeBridge(String str, String str2, JSObject jSObject, JSFunction jSFunction);
}
