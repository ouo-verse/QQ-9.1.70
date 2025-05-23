package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;

/* compiled from: P */
@JSAgent
@Deprecated
/* loaded from: classes3.dex */
interface IDownloadManager {
    @JSMethod
    IDownload download(JSObject jSObject, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3);
}
