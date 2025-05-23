package com.tencent.mobileqq.qqlive.api;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveSDKManager extends QRouteApi {
    void destroy();

    void destroySDKImpl(String str);

    QQLiveAnchorRecord getExistAnchorRecord(String str, String str2);

    IQQLiveSDK getSDKImpl(String str);

    void openDemo(Context context);
}
