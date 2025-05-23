package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.z;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h0 extends IPushCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final Object f36391a;

    /* renamed from: b, reason: collision with root package name */
    public final i0 f36392b;

    public h0(Object obj, i0 i0Var) {
        this.f36391a = obj;
        this.f36392b = i0Var;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Log.i("IPCCallback", "onResult parse start.");
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f36391a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        i0 i0Var = this.f36392b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f36391a;
        z.b bVar = (z.b) i0Var;
        bVar.getClass();
        z zVar = z.f36460c;
        f1<?> f1Var = bVar.f36469a;
        zVar.getClass();
        Log.i("HonorApiManager", "sendResolveResult start");
        Handler handler = zVar.f36461a;
        handler.sendMessage(handler.obtainMessage(2, f1Var));
        bVar.f36469a.b(apiException, obj2);
        Log.i("IPCCallback", "onResult parse end.");
    }
}
