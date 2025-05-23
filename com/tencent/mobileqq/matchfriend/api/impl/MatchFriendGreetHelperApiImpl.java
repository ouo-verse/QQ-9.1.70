package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendGreetHelperApi;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendGreetHelperApiImpl implements IMatchFriendGreetHelperApi {
    private static final String TAG = "MatchFriendGreetHelperApiImpl";

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendGreetHelperApi
    public void closeIceBreakingPanel(BaseQQAppInterface baseQQAppInterface, String str) {
        ((IceBreakingMng) baseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).X(str);
    }
}
