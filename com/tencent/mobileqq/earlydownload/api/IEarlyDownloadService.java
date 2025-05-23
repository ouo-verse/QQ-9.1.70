package com.tencent.mobileqq.earlydownload.api;

import android.content.Intent;
import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import protocol.KQQConfig.GetResourceRespInfo;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes5.dex */
public interface IEarlyDownloadService extends IRuntimeService {
    void addRequesting(String str);

    void downloadResource(XmlData xmlData, String str);

    String getCurrentUin();

    b getEarlyHandler(String str);

    void handleBroadcastReq(Intent intent);

    boolean isLowEndPhone();

    boolean isRequesting(String str);

    void onNetChanged();

    void onServerResp(GetResourceRespInfo getResourceRespInfo);

    void removeRequesting(String str);

    void setEarlyDownloadLock();

    void setEarlyDownloadUnLock();

    void updateConfigs(boolean z16);
}
