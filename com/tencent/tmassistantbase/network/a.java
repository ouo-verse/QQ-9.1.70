package com.tencent.tmassistantbase.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private PostHttpRequest f380429a = new C9994a();

    /* renamed from: b, reason: collision with root package name */
    private Class<? extends JceStruct> f380430b;

    /* renamed from: c, reason: collision with root package name */
    private Class<? extends JceStruct> f380431c;

    /* compiled from: P */
    /* renamed from: com.tencent.tmassistantbase.network.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9994a extends PostHttpRequest {
        C9994a() {
        }

        @Override // com.tencent.tmassistantbase.network.PostHttpRequest
        protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
            JceStruct jceStruct;
            Response unpackPackage;
            ReqHead reqHead;
            int i16 = 0;
            JceStruct jceStruct2 = null;
            if (bArr != null) {
                Request request = (Request) ProtocolPackage.bytes2JceObj(bArr, Request.class);
                if (request != null && (reqHead = request.head) != null) {
                    i16 = reqHead.requestId;
                }
                if (request != null) {
                    jceStruct = ProtocolPackage.unpageageJceResponse(request.body, (Class<? extends JceStruct>) a.this.f380430b);
                    if (bArr2 != null && (unpackPackage = ProtocolPackage.unpackPackage(bArr2)) != null) {
                        jceStruct2 = ProtocolPackage.unpageageJceResponse(unpackPackage.body, (Class<? extends JceStruct>) a.this.f380431c);
                    }
                    a.this.a(i16, i3, jceStruct, jceStruct2);
                }
            }
            jceStruct = null;
            if (bArr2 != null) {
                jceStruct2 = ProtocolPackage.unpageageJceResponse(unpackPackage.body, (Class<? extends JceStruct>) a.this.f380431c);
            }
            a.this.a(i16, i3, jceStruct, jceStruct2);
        }
    }

    public a(Class<? extends JceStruct> cls, Class<? extends JceStruct> cls2) {
        this.f380430b = cls;
        this.f380431c = cls2;
    }

    public abstract void a(int i3, int i16, JceStruct jceStruct, JceStruct jceStruct2);

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(JceStruct jceStruct) {
        ReqHead reqHead;
        if (jceStruct == null) {
            a(0, -1, null, null);
            return -1;
        }
        Request buildRequest = ProtocolPackage.buildRequest(jceStruct);
        if (buildRequest != null && (reqHead = buildRequest.head) != null) {
            int i3 = reqHead.requestId;
            if (this.f380429a.sendRequest(ProtocolPackage.buildPostData(buildRequest))) {
                return i3;
            }
            return -1;
        }
        a(0, -2, null, null);
        return -1;
    }
}
