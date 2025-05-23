package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.p;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes11.dex */
public interface IArkService extends IRuntimeService {
    void doURLReport(String str);

    p getSSO();

    void reportPredownloadFirstHit(String str, boolean z16);

    void sendAppMsg(String str, String str2, int i3, int i16, BusinessObserver businessObserver);

    void startPreloadApp();
}
