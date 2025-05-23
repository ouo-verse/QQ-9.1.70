package com.tencent.mobileqq.avatar.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.DecodeCompletionListener;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarDecoderApi extends QRouteApi {
    void closeFaceDecodeThread();

    void executeTask(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener);
}
