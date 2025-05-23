package com.tencent.ecommerce.biz.hr.module.cir;

import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/cir/a;", "", "", "b", "data", "Lorg/json/JSONObject;", "a", "", "Ljava/lang/String;", "cmd", "Lorg/json/JSONObject;", "params", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final JSONObject params;

    public a(String str, JSONObject jSONObject) {
        this.cmd = str;
        this.params = jSONObject;
    }

    public final JSONObject a(byte[] data) {
        MessageMicro<?> c16 = ECCirPBCoder.f102609a.c(this.cmd);
        if (c16 != null) {
            c16.mergeFrom(data);
        }
        return com.tencent.ecommerce.base.proto.a.s(c16);
    }

    public final byte[] b() {
        byte[] byteArray;
        MessageMicro<?> d16 = ECCirPBCoder.f102609a.d(this.cmd);
        com.tencent.ecommerce.base.proto.a.q(this.params, d16);
        return (d16 == null || (byteArray = d16.toByteArray()) == null) ? new byte[0] : byteArray;
    }
}
