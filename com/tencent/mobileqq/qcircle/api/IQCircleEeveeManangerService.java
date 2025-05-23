package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleEeveeManangerService extends IRuntimeService {
    void deleteAllRecomAutoTemplateData();

    void deleteBizUndealMsgBuffer(int i3);

    void deleteOneRecomAutoTemplateData(String str);

    byte[] getBizUndealMsgBuffer(int i3);

    void onSend(int i3, String str, String str2);
}
