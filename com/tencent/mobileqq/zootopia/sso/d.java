package com.tencent.mobileqq.zootopia.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MainService;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\u00020\u0001:\u0001\u0003B#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u00100\u001a\u00020\u0012\u00a2\u0006\u0004\b1\u00102R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u0003\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R>\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120&j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u0013\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/d;", "", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "a", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "c", "()Lcom/tencent/qphone/base/remote/FromServiceMsg;", "setRes", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;)V", "res", "", "b", "I", "d", "()I", "setRetCode", "(I)V", "retCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "", "[B", "()[B", "setData", "([B)V", "data", "", "e", "J", "getTs", "()J", "setTs", "(J)V", "ts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "getExtMap", "()Ljava/util/HashMap;", "setExtMap", "(Ljava/util/HashMap;)V", "extMap", "g", MainService.SERVICE_CMD, "<init>", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;[BLjava/lang/String;)V", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FromServiceMsg res;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int retCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String errMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private byte[] data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long ts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> extMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String serviceCmd;

    public d(FromServiceMsg res, byte[] bArr, String serviceCmd) {
        byte[] bArr2;
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(serviceCmd, "serviceCmd");
        this.extMap = new HashMap<>();
        this.res = res;
        this.serviceCmd = serviceCmd;
        if (bArr == null) {
            this.retCode = -1;
            this.errMsg = "get proxy package null";
            return;
        }
        try {
            yu4.b c16 = yu4.b.c(bArr);
            Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
            this.retCode = c16.f451269a;
            this.errMsg = c16.f451270b;
            if (c16.f451274f == 1) {
                bArr2 = zb2.a.d(c16.f451271c);
            } else {
                bArr2 = c16.f451271c;
            }
            this.data = bArr2;
            this.ts = c16.f451273e;
            yu4.c[] cVarArr = c16.f451272d;
            if (cVarArr != null) {
                Intrinsics.checkNotNullExpressionValue(cVarArr, "proxyRsp.trans");
                for (yu4.c cVar : cVarArr) {
                    Intrinsics.checkNotNullExpressionValue(cVar, "proxyRsp.trans");
                    HashMap<String, String> hashMap = this.extMap;
                    String str = cVar.f451276a;
                    Intrinsics.checkNotNullExpressionValue(str, "tran.key");
                    String str2 = cVar.f451277b;
                    Intrinsics.checkNotNullExpressionValue(str2, "tran.value");
                    hashMap.put(str, str2);
                }
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("ZPlanRspData", 1, "ZPlanRspData throw exception:" + e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("ZPlanRspData", 1, "ZPlanRspData OutOfMemoryError:" + e17);
        }
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: c, reason: from getter */
    public final FromServiceMsg getRes() {
        return this.res;
    }

    /* renamed from: d, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }
}
