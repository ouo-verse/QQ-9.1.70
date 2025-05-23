package com.tencent.luggage.wxa.u0;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilinkservice.AidlProto;
import com.tencent.ilinkservice.IlinkService;
import com.tencent.luggage.wxa.v0.a;
import com.tencent.mars.ilink.xlog.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements a.InterfaceC6811a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.u0.c f142010a;

    /* renamed from: b, reason: collision with root package name */
    public String f142011b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC6777b f142012c;

    /* renamed from: d, reason: collision with root package name */
    public String f142013d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u0.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6777b {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static b f142014a = new b();
    }

    public static b b() {
        return c.f142014a;
    }

    public void a(InterfaceC6777b interfaceC6777b) {
        this.f142012c = interfaceC6777b;
    }

    public b() {
        this.f142010a = null;
        this.f142011b = "";
    }

    public final void a(a.InterfaceC6811a interfaceC6811a) {
        d.f142018b.a(interfaceC6811a);
    }

    public final void a(String str, String str2, int i3) {
        if (this.f142011b.equals(str2)) {
            return;
        }
        com.tencent.luggage.wxa.u0.c cVar = this.f142010a;
        if (cVar != null) {
            cVar.b().c();
            d.f142018b.a(this.f142010a);
        }
        this.f142011b = str2;
        this.f142010a = d.f142018b.a(str2);
        a(this);
        this.f142010a.b().a(str, i3, 1);
    }

    public void a() {
        com.tencent.luggage.wxa.u0.c cVar = this.f142010a;
        if (cVar != null) {
            cVar.b().c();
            d.f142018b.a(this.f142010a);
            this.f142011b = "";
            this.f142010a = null;
        }
    }

    public byte[] a(byte[] bArr, IlinkService ilinkService, String str) {
        char c16;
        try {
            AidlProto.ilinkliveCommRequest parseFrom = AidlProto.ilinkliveCommRequest.parseFrom(bArr);
            String funcname = parseFrom.getFuncname();
            switch (funcname.hashCode()) {
                case -1771004029:
                    if (funcname.equals("finderSetAnchorStatus")) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1510634881:
                    if (funcname.equals("uploadMediaFile")) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -793724546:
                    if (funcname.equals("finderCloseLive")) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 266276469:
                    if (funcname.equals("finderLivePrepare")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 268206620:
                    if (funcname.equals("initLive")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 317768910:
                    if (funcname.equals("finderCreateLive")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 328862588:
                    if (funcname.equals("sendTransferRequest")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 617074262:
                    if (funcname.equals("finderInit")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 894615818:
                    if (funcname.equals("canAutoLogin")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1093616719:
                    if (funcname.equals("thirdAppLogin")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1636021116:
                    if (funcname.equals("finderJoinLive")) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1643599610:
                    if (funcname.equals("autoLogin")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1794434997:
                    if (funcname.equals("uninitLive")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1868779378:
                    if (funcname.equals("getJsBridgeData")) {
                        c16 = '\r';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    this.f142013d = str;
                    b().a(ilinkService.m_file_dir_, AidlProto.ilinkliveInit.parseFrom(parseFrom.getFuncargs()).getAppid(), 1);
                    break;
                case 1:
                    b().a();
                    break;
                case 2:
                    return AidlProto.ilinkliveCanAutoLoginResp.newBuilder().setState(b().f142010a.b().a()).build().toByteArray();
                case 3:
                    b().f142010a.b().a(0L);
                    break;
                case 4:
                    b().f142010a.b().a(0L, AidlProto.ilinkliveThirdLogin.parseFrom(parseFrom.getFuncargs()).getAuthbuffer().toByteArray(), 1);
                    break;
                case 5:
                    AidlProto.ilinkliveFinderJsApis parseFrom2 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().f(parseFrom2.getTaskid(), parseFrom2.getBody().toStringUtf8());
                    break;
                case 6:
                    b().f142010a.b().b(AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs()).getTaskid());
                    break;
                case 7:
                    AidlProto.ilinkliveFinderJsApis parseFrom3 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().d(parseFrom3.getTaskid(), parseFrom3.getBody().toStringUtf8());
                    break;
                case '\b':
                    AidlProto.ilinkliveFinderJsApis parseFrom4 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().b(parseFrom4.getTaskid(), parseFrom4.getBody().toStringUtf8());
                    break;
                case '\t':
                    AidlProto.ilinkliveFinderJsApis parseFrom5 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().a(parseFrom5.getTaskid(), parseFrom5.getBody().toStringUtf8());
                    break;
                case '\n':
                    AidlProto.ilinkliveFinderJsApis parseFrom6 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().c(parseFrom6.getTaskid(), parseFrom6.getBody().toStringUtf8());
                    break;
                case 11:
                    AidlProto.ilinkliveFinderJsApis parseFrom7 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().e(parseFrom7.getTaskid(), parseFrom7.getBody().toStringUtf8());
                    break;
                case '\f':
                    AidlProto.ilinkliveFinderJsApis parseFrom8 = AidlProto.ilinkliveFinderJsApis.parseFrom(parseFrom.getFuncargs());
                    b().f142010a.b().g(parseFrom8.getTaskid(), parseFrom8.getBody().toStringUtf8());
                    break;
                case '\r':
                    return AidlProto.ilinkliveGetJsBridgeDataResp.newBuilder().setData(ByteString.copyFrom(b().f142010a.b().b())).build().toByteArray();
                default:
                    Log.e("IlinkLiveInstance", "ReceiveIlinkLiveCommonRequest not supported function:" + parseFrom.getFuncname());
                    return new byte[0];
            }
            return new byte[0];
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            Log.e("IlinkLiveInstance", "ReceiveIlinkLiveCommonRequest data parse error");
            return new byte[0];
        }
    }
}
