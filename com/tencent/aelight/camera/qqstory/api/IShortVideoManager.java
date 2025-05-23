package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IShortVideoManager extends QRouteApi {
    String parseLinkFromRedTouchBuffer(String str, String str2);
}
