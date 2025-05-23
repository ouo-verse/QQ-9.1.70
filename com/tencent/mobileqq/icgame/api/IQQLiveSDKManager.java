package com.tencent.mobileqq.icgame.api;

import android.content.Context;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQLiveSDKManager extends QRouteApi {
    void destroy();

    void destroySDKImpl(String str);

    QQLiveAnchorRecord getExistAnchorRecord(String str, String str2);

    IQQLiveSDK getSDKImpl(String str);

    void openDemo(Context context);
}
