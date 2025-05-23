package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ISmallEmoticonInfoService extends QRouteApi {
    ISmallEmoticonInfo createSmallEmoticonInfo(String str);
}
