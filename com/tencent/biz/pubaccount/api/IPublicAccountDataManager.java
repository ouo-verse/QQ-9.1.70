package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@QRouteFactory(singleton = false)
@Service(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDataManager extends IRuntimeService {
    void decodeMessageRecord(ArrayList<MessageRecord> arrayList, AppInterface appInterface);

    void delAccountDetailInfoCache(String str);

    void delPublicAccountInfo(String str);

    void delPublicAccountInfoCache(String str);

    IPublicAccountDetail findAccountDetailInfo(String str);

    IPublicAccountDetail findAccountDetailInfoCache(String str);

    Object findPublicAccountInfo(String str);

    Object findPublicAccountInfo(String str, boolean z16);

    Object findPublicAccountInfoCache(String str);

    Object getAccountInfo(String str);

    Object getPublicAccountEqqInfoList();

    List<Entity> getPublicAccountList();

    ArrayList<Entity> getPublicAccountListNotIVR();

    Object getPublicAccountScriptList();

    Object getPublicRecommendAccountList();

    void initPublicAccountDataManager();

    boolean isBuildingList();

    boolean isCached();

    boolean isCertifiedAccount(Object obj);

    boolean isFollowedUin(Long l3);

    boolean isFollowedUin(Long l3, boolean z16);

    boolean isSupportPay(String str);

    void refreshPublicRecommendList(Object obj);

    void saveAccountDetailInfoCache(Object obj);

    Object saveEqqAccountInfos(Object obj, long j3);

    void savePublicAccountInfo(Object obj);

    Object savePublicAccountInfos(Object obj, long j3, boolean z16, boolean z17, boolean z18, int i3);

    void updateAccountDetailEntity(IPublicAccountDetail iPublicAccountDetail);

    void updateAccountDetailReceiveMsg(IPublicAccountDetail iPublicAccountDetail, boolean z16);
}
