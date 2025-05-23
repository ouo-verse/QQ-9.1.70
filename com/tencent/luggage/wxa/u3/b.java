package com.tencent.luggage.wxa.u3;

import com.google.protobuf.ByteString;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceInterface;
import com.tencent.ilinkservice.IlinkTdiCloneSessionInterface;
import com.tencent.ilinkservice.TdiCloneCallback;
import com.tencent.luggage.wxa.n3.r;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements r {

    /* renamed from: a, reason: collision with root package name */
    public final IlinkTdiCloneSessionInterface f142097a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f142098b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f142099c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements TdiCloneCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r.a f142100a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f142101b;

        public a(r.a aVar, b bVar) {
            this.f142100a = aVar;
            this.f142101b = bVar;
        }

        @Override // com.tencent.ilinkservice.TdiCloneCallback
        public void onCloneDestroyed() {
            this.f142101b.f142099c.set(true);
        }

        @Override // com.tencent.ilinkservice.TdiCloneCallback
        public void onReceiveAppMessage(TdiApiProto.TdiAppMessage msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r.a aVar = this.f142100a;
            byte[] byteArray = msg2.getBody().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "msg.body.toByteArray()");
            aVar.a(byteArray);
        }

        @Override // com.tencent.ilinkservice.TdiCloneCallback
        public void onReceiveAppResponse(int i3, int i16, TdiApiProto.TdiAppResponse tdiAppResponse) {
            byte[] bArr;
            ByteString body;
            r.a aVar = this.f142100a;
            if (tdiAppResponse != null && (body = tdiAppResponse.getBody()) != null) {
                bArr = body.toByteArray();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            aVar.a(i3, i16, bArr);
        }
    }

    public b(IlinkTdiCloneSessionInterface tdiSession, Runnable runnable) {
        Intrinsics.checkNotNullParameter(tdiSession, "tdiSession");
        this.f142097a = tdiSession;
        this.f142098b = runnable;
        this.f142099c = new AtomicBoolean(false);
    }

    @Override // com.tencent.luggage.wxa.n3.r
    public boolean c() {
        return this.f142099c.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IlinkServiceInterface.getInstance().destroyMultiProcessTdiSession(this.f142097a);
        Runnable runnable = this.f142098b;
        if (runnable != null) {
            runnable.run();
        }
        this.f142099c.set(true);
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public long getUin() {
        return this.f142097a.getUserInfo().getUin();
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public void writeKvData(int i3, byte[] data, boolean z16, int i16, boolean z17, int i17) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i17 == 0) {
            this.f142097a.writeKvData(i3, data, z16, i16, z17);
        } else {
            this.f142097a.writeKvData(i3, data, z16, i16, z17, i17);
        }
    }

    @Override // com.tencent.luggage.wxa.n3.u
    public int a(com.tencent.luggage.wxa.n3.b appRequest) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        int sendAppRequest = this.f142097a.sendAppRequest(TdiApiProto.TdiAppRequest.newBuilder().setCmdid(appRequest.a()).setCryptoAlgo(TdiApiProto.TdiCryptoAlgo.forNumber(appRequest.b().ordinal())).setBody(ByteString.copyFrom(appRequest.d())).setUrl(appRequest.e()).setTimeoutMs(15000).setNetType(TdiApiProto.TdiNetType.forNumber(appRequest.c().ordinal())).build());
        if (sendAppRequest <= 0) {
            w.b("IlinkServiceLoginCloneSession", "sendAppRequest get invalid taskId:" + sendAppRequest + " cloneSessionImpl@" + this.f142097a.hashCode());
        }
        return sendAppRequest;
    }

    @Override // com.tencent.luggage.wxa.n3.r
    public void a(r.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f142097a.setCallback(new a(callback, this));
    }
}
