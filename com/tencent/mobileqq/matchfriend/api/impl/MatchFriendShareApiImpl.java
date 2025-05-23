package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendShareApi;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendShareApiImpl implements IMatchFriendShareApi {
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendShareApi
    public void reportShareSendEvent(Context context, AppInterface appInterface, int i3, String str) {
        com.tencent.mobileqq.matchfriend.share.a.b(context, appInterface, i3, str);
    }
}
