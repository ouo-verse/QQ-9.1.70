package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e1 extends f1<PushTokenResult> {
    public e1(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.f1
    public void a(ApiException apiException, Object obj) {
        if (apiException == null) {
            apiException = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
        }
        if (apiException.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
            if (obj instanceof PushTokenResult) {
                PushTokenResult pushTokenResult = (PushTokenResult) obj;
                String pushToken = pushTokenResult.getPushToken();
                try {
                    d.f36363b.a(l.f36402e.a(), pushToken);
                } catch (Exception unused) {
                }
                this.f36379a.a((n0<TResult>) pushTokenResult);
                return;
            }
            apiException = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        apiException.getErrorCode();
        this.f36379a.a((Exception) apiException);
    }
}
