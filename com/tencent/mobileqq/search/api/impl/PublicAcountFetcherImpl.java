package com.tencent.mobileqq.search.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IPublicAcountFetcher;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes18.dex */
public class PublicAcountFetcherImpl implements IPublicAcountFetcher {
    @Override // com.tencent.mobileqq.search.api.IPublicAcountFetcher
    public String getSubscriptName() {
        return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), BaseApplication.getContext());
    }
}
