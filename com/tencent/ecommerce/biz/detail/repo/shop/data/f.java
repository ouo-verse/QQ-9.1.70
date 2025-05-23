package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ark.ark;
import com.tencent.ecommerce.biz.detail.ProductLiveStatus;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0004B)\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "", "", "b", "a", "", "toString", "", "hashCode", "other", "equals", "", "J", "roomId", "I", "status", "c", "Ljava/lang/String;", "roomUrl", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "getInfoData", "()Lorg/json/JSONObject;", "infoData", "<init>", "(JILjava/lang/String;Lorg/json/JSONObject;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String roomUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final JSONObject infoData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.f$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final f a(JSONObject json) {
            String str;
            int optInt = json.optInt("status", 0);
            JSONObject optJSONObject = json.optJSONObject(AegisLogger.ROOM_INFO);
            long optLong = optJSONObject != null ? optJSONObject.optLong(AudienceReportConst.ROOM_ID, 0L) : 0L;
            JSONObject optJSONObject2 = json.optJSONObject(AegisLogger.ROOM_INFO);
            if (optJSONObject2 == null || (str = optJSONObject2.optString("room_url")) == null) {
                str = "";
            }
            return new f(optLong, optInt, str, json);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(long j3, @ProductLiveStatus int i3, String str, JSONObject jSONObject) {
        this.roomId = j3;
        this.status = i3;
        this.roomUrl = str;
        this.infoData = jSONObject;
    }

    public final boolean a() {
        return b() && this.status == 1;
    }

    public final boolean b() {
        if (this.roomId > 0) {
            return this.roomUrl.length() > 0;
        }
        return false;
    }

    public int hashCode() {
        int a16 = ((com.tencent.ecommerce.biz.commission.forecast.b.a(this.roomId) * 31) + this.status) * 31;
        String str = this.roomUrl;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.infoData;
        return hashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "[roomId:" + this.roomId + ", status:" + this.status + ", roomUrl:" + this.roomUrl + ']';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        return this.roomId == fVar.roomId && this.status == fVar.status && Intrinsics.areEqual(this.roomUrl, fVar.roomUrl) && Intrinsics.areEqual(this.infoData, fVar.infoData);
    }
}
