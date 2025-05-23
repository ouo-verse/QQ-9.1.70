package com.tencent.ecommerce.biz.register.network;

import com.tencent.ecommerce.base.network.api.IECResponse;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/f;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "<set-?>", "d", "I", "a", "()I", "captchaErrCode", "", "e", "J", "b", "()J", "timestamp", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int captchaErrCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* renamed from: a, reason: from getter */
    public final int getCaptchaErrCode() {
        return this.captchaErrCode;
    }

    /* renamed from: b, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        if (data == null) {
            return false;
        }
        this.captchaErrCode = data.optInt("captcha_errcode", 0);
        this.timestamp = data.optLong("timestamp", 0L);
        return true;
    }
}
