package com.tencent.biz.pubaccount.accountdetail.api;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDetailDynamicDataManagerService extends IRuntimeService {
    Object getAccountDetailDynamicInfoFromCache(long j3);

    Object getAccountDetailDynamicInfoFromCache(String str);

    void getDynamicListForFirstEnterFromDB(AppInterface appInterface, long j3, IPublicAccountObserver iPublicAccountObserver);

    Object getDynamicListFromCache(long j3);

    int updateAccountDetailDynamicInfo(byte[] bArr, boolean z16, long j3, long j16, long j17, ArrayList<String> arrayList, boolean z17);

    int updateAccountDetailDynamicInfoCache(boolean z16, long j3, long j16, long j17, ArrayList<String> arrayList, boolean z17);
}
