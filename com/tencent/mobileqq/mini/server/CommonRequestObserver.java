package com.tencent.mobileqq.mini.server;

import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0013*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u0013B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/server/CommonRequestObserver;", "Rsp", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lmqq/observer/BusinessObserver;", "mRspClazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mobileqq/mini/server/RequestCallback;", "(Ljava/lang/Class;Lcom/tencent/mobileqq/mini/server/RequestCallback;)V", "mCallbackRef", "Ljava/lang/ref/WeakReference;", "onReceive", "", "type", "", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class CommonRequestObserver<Rsp extends MessageMicro<Rsp>> implements BusinessObserver {
    private static final String TAG = "CommonRequestObserver";
    private final WeakReference<RequestCallback<Rsp>> mCallbackRef;
    private final Class<Rsp> mRspClazz;

    public CommonRequestObserver(Class<Rsp> mRspClazz, RequestCallback<Rsp> callback) {
        Intrinsics.checkNotNullParameter(mRspClazz, "mRspClazz");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mRspClazz = mRspClazz;
        this.mCallbackRef = new WeakReference<>(callback);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        byte[] byteArray = bundle.getByteArray(MiniAppCmdUtil.KEY_RSP_DATA);
        if (isSuccess && byteArray != null) {
            if (!(byteArray.length == 0)) {
                try {
                    Rsp newInstance = this.mRspClazz.newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance, "mRspClazz.newInstance()");
                    Rsp rsp = newInstance;
                    rsp.mergeFrom(byteArray);
                    RequestCallback<Rsp> requestCallback = this.mCallbackRef.get();
                    if (requestCallback != null) {
                        requestCallback.onReqSucceed(rsp);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onReceive: error -->", e16);
                }
            }
        }
        RequestCallback<Rsp> requestCallback2 = this.mCallbackRef.get();
        if (requestCallback2 != null) {
            requestCallback2.onReqFailed(bundle.getLong("retCode"), bundle.getString("errMsg"));
        }
    }
}
