package com.tencent.ecommerce.biz.register.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "idCardNum", "b", "cerName", "c", "appId", "d", "openId", "e", "idKey", "f", "nonce", "g", "()Ljava/lang/String;", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.register.network.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECVerifyFaceReqParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String idCardNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cerName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String appId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String openId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String idKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String nonce;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String sessionId;

    public ECVerifyFaceReqParam(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.idCardNum = str;
        this.cerName = str2;
        this.appId = str3;
        this.openId = str4;
        this.idKey = str5;
        this.nonce = str6;
        this.sessionId = str7;
    }

    /* renamed from: a, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        String str = this.idCardNum;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cerName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.appId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.openId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.idKey;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.nonce;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sessionId;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ECVerifyFaceReqParam(idCardNum=" + this.idCardNum + ", cerName=" + this.cerName + ", appId=" + this.appId + ", openId=" + this.openId + ", idKey=" + this.idKey + ", nonce=" + this.nonce + ", sessionId=" + this.sessionId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECVerifyFaceReqParam)) {
            return false;
        }
        ECVerifyFaceReqParam eCVerifyFaceReqParam = (ECVerifyFaceReqParam) other;
        return Intrinsics.areEqual(this.idCardNum, eCVerifyFaceReqParam.idCardNum) && Intrinsics.areEqual(this.cerName, eCVerifyFaceReqParam.cerName) && Intrinsics.areEqual(this.appId, eCVerifyFaceReqParam.appId) && Intrinsics.areEqual(this.openId, eCVerifyFaceReqParam.openId) && Intrinsics.areEqual(this.idKey, eCVerifyFaceReqParam.idKey) && Intrinsics.areEqual(this.nonce, eCVerifyFaceReqParam.nonce) && Intrinsics.areEqual(this.sessionId, eCVerifyFaceReqParam.sessionId);
    }
}
