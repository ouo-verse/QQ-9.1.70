package com.tencent.ecommerce.biz.register.network;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/d;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "d", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "result", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "mediaId", "f", "a", "setChannelFlag", "channelFlag", "", tl.h.F, "I", "()I", "setRole", "(I)V", "role", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "i", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "c", "()Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "setMsgBox", "(Lcom/tencent/ecommerce/repo/register/ECMsgBox;)V", "msgBox", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Boolean result;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mediaId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Boolean channelFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int role;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ECMsgBox msgBox;

    /* renamed from: a, reason: from getter */
    public final Boolean getChannelFlag() {
        return this.channelFlag;
    }

    /* renamed from: b, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* renamed from: c, reason: from getter */
    public final ECMsgBox getMsgBox() {
        return this.msgBox;
    }

    /* renamed from: d, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    /* renamed from: e, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        if (data == null) {
            return false;
        }
        this.result = Boolean.valueOf(data.optBoolean("result", false));
        this.mediaId = data.optString("media_id", "");
        this.channelFlag = Boolean.valueOf(data.optBoolean("channel_flag", false));
        this.role = data.optInt("role", 0);
        JSONObject optJSONObject = data.optJSONObject("msg_box");
        if (optJSONObject == null) {
            return true;
        }
        this.msgBox = ECMsgBox.INSTANCE.a(optJSONObject);
        return true;
    }
}
