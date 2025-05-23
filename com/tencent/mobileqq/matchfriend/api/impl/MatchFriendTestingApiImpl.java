package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendTestingApi;
import com.tencent.mobileqq.matchfriend.fragment.MatchFriendTestingFragment;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendTestingApiImpl implements IMatchFriendTestingApi {
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendTestingApi
    public void launchTestingPage(Context context, Intent intent) {
        QPublicFragmentActivity.start(context, intent, MatchFriendTestingFragment.class);
    }
}
