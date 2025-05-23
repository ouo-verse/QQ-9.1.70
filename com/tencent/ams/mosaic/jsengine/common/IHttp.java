package com.tencent.ams.mosaic.jsengine.common;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.common.download.IDownload;
import com.tencent.ams.mosaic.jsengine.common.download.IDownloadStatus;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IHttp {
    @JSMethod
    IDownload download(JSObject jSObject, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4, JSFunction jSFunction5);

    @JSMethod
    IDownloadStatus queryDownload(JSObject jSObject);

    void requestAsync(JSObject jSObject, JSFunction jSFunction);
}
