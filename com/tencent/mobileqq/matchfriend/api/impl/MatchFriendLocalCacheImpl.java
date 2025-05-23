package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendLocalCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendLocalCacheImpl implements IMatchFriendLocalCache {
    private static final String TAG = "MatchFriendLocalCacheImpl";

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendLocalCache
    public void cleanCache(Context context) {
        QLog.i(TAG, 1, "start clean cache");
        FileUtils.deleteDirectory("/data/data/com.tencent.mobileqq/cache/match_friend");
    }
}
