package com.tencent.qzonehub.api.contentbox.impl;

import android.content.Context;
import com.qzone.reborn.publicaccount.QZonePublicAccountFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneMsgApiImpl implements IQzoneMsgApi {
    private static final String TAG = "QzoneMsgApi";

    @Override // com.tencent.qzonehub.api.contentbox.IQzoneMsgApi
    public boolean open(Context context, AppRuntime appRuntime) {
        QPublicFragmentActivity.start(context, QZonePublicAccountFragment.class);
        return true;
    }

    @Override // com.tencent.qzonehub.api.contentbox.IQzoneMsgApi
    public boolean openContentBox(Context context) {
        if (context == null) {
            QLog.e(TAG, 1, "activity is null");
            return false;
        }
        QPublicFragmentActivity.start(context, QZonePublicAccountFragment.class);
        QLog.d(TAG, 1, "enter qzone new style public account page");
        return true;
    }
}
