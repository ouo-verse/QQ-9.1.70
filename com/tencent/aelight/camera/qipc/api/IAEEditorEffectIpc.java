package com.tencent.aelight.camera.qipc.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEEditorEffectIpc extends QRouteApi {
    public static final String NAME = "AEEditorEffectIpcModule";

    QIPCModule getAEEditorEffectQIPCModule();
}
