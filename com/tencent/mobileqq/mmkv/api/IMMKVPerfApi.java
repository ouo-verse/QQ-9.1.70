package com.tencent.mobileqq.mmkv.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IMMKVPerfApi extends QRouteApi {
    Boolean isAVChatting();
}
