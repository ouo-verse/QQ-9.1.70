package com.tencent.mobileqq.icgame.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a implements BaseCallback {
    private static final String TAG = "ICGameBaseSsoCallback";

    public void onBusinessFailed(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "sso call back fail [business error] " + i3 + " error msg " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
    public void onFailed(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "sso call back fail [proxy error]" + i3 + " error msg " + str);
        }
    }

    public abstract void onProxyRequestSuccess(int i3, i iVar) throws InvalidProtocolBufferNanoException;
}
