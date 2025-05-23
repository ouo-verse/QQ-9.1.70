package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.RemoteException;
import com.qq.taf.jce.JceStruct;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJceSSo;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/k;", "Lcom/tencent/mobileqq/vas/api/IJceSSo;", "", "funcName", "Lcom/qq/taf/jce/JceStruct;", "jceReq", "jceResp", "Leipc/EIPCCallback;", "callback", "", "bgCallback", "Lcom/tencent/mobileqq/vas/api/IJce;", "jce", "", Const.BUNDLE_KEY_REQUEST, "", "type", "isSuccess", "Ljava/lang/Object;", "data", "Leipc/EIPCResult;", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class k implements IJceSSo {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EIPCCallback callback, k this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            callback.callback(this$0.b(i3, z16, obj));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    @NotNull
    public final EIPCResult b(int type, boolean isSuccess, @Nullable Object data) {
        EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle = new Bundle();
        eIPCResult.data = bundle;
        bundle.putBoolean("isSuccess", isSuccess);
        if (data != null && (data instanceof JceStruct)) {
            eIPCResult.data.putSerializable(PbProtocolSSoImpl.RESP_KEY_IS_DATA, (Serializable) data);
        }
        eIPCResult.data.putInt("type", type);
        return eIPCResult;
    }

    @Override // com.tencent.mobileqq.vas.api.IJceSSo
    public void request(@NotNull String funcName, @NotNull JceStruct jceReq, @NotNull JceStruct jceResp, @NotNull final EIPCCallback callback, boolean bgCallback, @NotNull IJce jce) {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(jceReq, "jceReq");
        Intrinsics.checkNotNullParameter(jceResp, "jceResp");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(jce, "jce");
        jce.request(funcName, jceReq, jceResp, new BusinessObserver() { // from class: com.tencent.mobileqq.vas.api.impl.j
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                k.c(EIPCCallback.this, this, i3, z16, obj);
            }
        }, bgCallback);
    }
}
