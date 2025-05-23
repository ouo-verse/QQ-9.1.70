package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendReceiverImpl implements IMatchFriendReceiver {
    private static final String TAG = "MatchFriendReceiverImpl";

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preload tool process succeed");
        }
    }
}
