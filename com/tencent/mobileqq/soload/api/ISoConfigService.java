package com.tencent.mobileqq.soload.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import eipc.EIPCResult;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISoConfigService extends QRouteApi {
    int getConfigId();

    Map<String, SoInfo> getSoInfos();

    void getSoLoadInfoAsync(Bundle bundle, OnGetSoLoadInfoListener onGetSoLoadInfoListener);

    EIPCResult getSoLoadInfoSync(Bundle bundle);

    void notifyNetFailed(int[] iArr, FromServiceMsg fromServiceMsg);

    void removeSoInfo(String str);
}
