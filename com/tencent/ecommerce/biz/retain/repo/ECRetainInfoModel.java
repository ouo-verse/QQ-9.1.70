package com.tencent.ecommerce.biz.retain.repo;

import com.tencent.ark.ark;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J1\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/repo/b;", "", "", "retainId", "spuId", "Lcom/tencent/ecommerce/biz/retain/repo/ECRetainInfoPromoteType;", "type", "Lorg/json/JSONObject;", "data", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "c", "Lcom/tencent/ecommerce/biz/retain/repo/ECRetainInfoPromoteType;", "d", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/retain/repo/ECRetainInfoPromoteType;Lorg/json/JSONObject;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.retain.repo.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECRetainInfoModel {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String retainId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECRetainInfoPromoteType type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/repo/b$a;", "", "Lcom/tencent/ecommerce/biz/retain/repo/b;", "a", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "spuId", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.retain.repo.b$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECRetainInfoModel a() {
            return new ECRetainInfoModel("", "", ECRetainInfoPromoteType.PROMOTE_TYPE_UNKNOWN, new JSONObject());
        }

        public final ECRetainInfoModel b(JSONObject json, String spuId) {
            return new ECRetainInfoModel(UUID.randomUUID().toString(), spuId, ECRetainInfoPromoteType.INSTANCE.a(json.optInt("type")), json);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECRetainInfoModel(String str, String str2, ECRetainInfoPromoteType eCRetainInfoPromoteType, JSONObject jSONObject) {
        this.retainId = str;
        this.spuId = str2;
        this.type = eCRetainInfoPromoteType;
        this.data = jSONObject;
    }

    public final ECRetainInfoModel a(String retainId, String spuId, ECRetainInfoPromoteType type, JSONObject data) {
        return new ECRetainInfoModel(retainId, spuId, type, data);
    }

    /* renamed from: c, reason: from getter */
    public final JSONObject getData() {
        return this.data;
    }

    public int hashCode() {
        String str = this.retainId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.spuId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ECRetainInfoPromoteType eCRetainInfoPromoteType = this.type;
        int hashCode3 = (hashCode2 + (eCRetainInfoPromoteType != null ? eCRetainInfoPromoteType.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.data;
        return hashCode3 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECRetainInfoModel(retainId=" + this.retainId + ", spuId=" + this.spuId + ", type=" + this.type + ", data=" + this.data + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECRetainInfoModel)) {
            return false;
        }
        ECRetainInfoModel eCRetainInfoModel = (ECRetainInfoModel) other;
        return Intrinsics.areEqual(this.retainId, eCRetainInfoModel.retainId) && Intrinsics.areEqual(this.spuId, eCRetainInfoModel.spuId) && Intrinsics.areEqual(this.type, eCRetainInfoModel.type) && Intrinsics.areEqual(this.data, eCRetainInfoModel.data);
    }

    public static /* synthetic */ ECRetainInfoModel b(ECRetainInfoModel eCRetainInfoModel, String str, String str2, ECRetainInfoPromoteType eCRetainInfoPromoteType, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eCRetainInfoModel.retainId;
        }
        if ((i3 & 2) != 0) {
            str2 = eCRetainInfoModel.spuId;
        }
        if ((i3 & 4) != 0) {
            eCRetainInfoPromoteType = eCRetainInfoModel.type;
        }
        if ((i3 & 8) != 0) {
            jSONObject = eCRetainInfoModel.data;
        }
        return eCRetainInfoModel.a(str, str2, eCRetainInfoPromoteType, jSONObject);
    }
}
