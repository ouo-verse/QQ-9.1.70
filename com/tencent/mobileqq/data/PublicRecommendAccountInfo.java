package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.publicaccount_recommend$BusinessRecommend;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class PublicRecommendAccountInfo extends Entity {
    private static final String TAG = "PublicRecommendAccountInfo";
    public int accountflag = -1;
    public String mEqqCategory;
    public String mEqqCs;
    public long mEqqKfuin;
    public String mEqqNameAccount;
    public String mEqqSi;
    public int mFilter;
    public String mIconLinkAddr;
    public String mIsVerified;

    @unique
    public int mListid;
    public String mPublicaccount;
    public String mPublicdesc;
    public String mPublicname;
    public long mPublicuin;
    public int mSource;

    public static PublicRecommendAccountInfo createPublicRecommendAccountInfo(publicaccount_recommend$BusinessRecommend publicaccount_recommend_businessrecommend) {
        PublicRecommendAccountInfo publicRecommendAccountInfo = new PublicRecommendAccountInfo();
        if (publicaccount_recommend_businessrecommend.f247290id.has()) {
            publicRecommendAccountInfo.mListid = publicaccount_recommend_businessrecommend.f247290id.get();
        }
        if (publicaccount_recommend_businessrecommend.source.has()) {
            publicRecommendAccountInfo.mSource = publicaccount_recommend_businessrecommend.source.get();
        }
        if (publicaccount_recommend_businessrecommend.uin.has()) {
            publicRecommendAccountInfo.mPublicuin = publicaccount_recommend_businessrecommend.uin.get();
        }
        if (publicaccount_recommend_businessrecommend.name.has()) {
            publicRecommendAccountInfo.mPublicname = publicaccount_recommend_businessrecommend.name.get();
        }
        if (publicaccount_recommend_businessrecommend.account.has()) {
            publicRecommendAccountInfo.mPublicaccount = publicaccount_recommend_businessrecommend.account.get();
        }
        if (publicaccount_recommend_businessrecommend.desc.has()) {
            publicRecommendAccountInfo.mPublicdesc = publicaccount_recommend_businessrecommend.desc.get();
        }
        if (publicaccount_recommend_businessrecommend.nameAccount.has()) {
            publicRecommendAccountInfo.mEqqNameAccount = publicaccount_recommend_businessrecommend.nameAccount.get();
        }
        if (publicaccount_recommend_businessrecommend.kfuin.has()) {
            publicRecommendAccountInfo.mEqqKfuin = publicaccount_recommend_businessrecommend.kfuin.get();
        }
        if (publicaccount_recommend_businessrecommend.f247291si.has()) {
            publicRecommendAccountInfo.mEqqSi = publicaccount_recommend_businessrecommend.f247291si.get();
        }
        if (publicaccount_recommend_businessrecommend.f247288cs.has()) {
            publicRecommendAccountInfo.mEqqCs = publicaccount_recommend_businessrecommend.f247288cs.get();
        }
        if (publicaccount_recommend_businessrecommend.category.has()) {
            publicRecommendAccountInfo.mEqqCategory = publicaccount_recommend_businessrecommend.category.get();
        }
        if (publicaccount_recommend_businessrecommend.f247289ic.has()) {
            publicRecommendAccountInfo.mIconLinkAddr = publicaccount_recommend_businessrecommend.f247289ic.get();
        }
        if (publicaccount_recommend_businessrecommend.isverified.has()) {
            publicRecommendAccountInfo.mIsVerified = publicaccount_recommend_businessrecommend.isverified.get();
        }
        if (publicaccount_recommend_businessrecommend.filter.has()) {
            publicRecommendAccountInfo.mFilter = publicaccount_recommend_businessrecommend.filter.get();
        }
        if (publicaccount_recommend_businessrecommend.account_flag.has()) {
            publicRecommendAccountInfo.accountflag = publicaccount_recommend_businessrecommend.account_flag.get();
        }
        return publicRecommendAccountInfo;
    }

    public static List<PublicRecommendAccountInfo> createPublicRecommendAccountInfoList(List<publicaccount_recommend$BusinessRecommend> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<publicaccount_recommend$BusinessRecommend> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(createPublicRecommendAccountInfo(it.next()));
            }
            return arrayList;
        }
        return null;
    }
}
