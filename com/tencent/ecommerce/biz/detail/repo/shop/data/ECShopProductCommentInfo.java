package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "reviewCount", "b", "Ljava/lang/String;", "cookie", "c", "Z", "isEnd", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "jsonResponse", "<init>", "(ILjava/lang/String;ZLorg/json/JSONObject;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopProductCommentInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int reviewCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isEnd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject jsonResponse;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECShopProductCommentInfo a(JSONObject json) {
            return new ECShopProductCommentInfo(json.optInt("review_count"), json.optString("cookie"), json.optBoolean("is_end"), json);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShopProductCommentInfo(int i3, String str, boolean z16, JSONObject jSONObject) {
        this.reviewCount = i3;
        this.cookie = str;
        this.isEnd = z16;
        this.jsonResponse = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.reviewCount * 31;
        String str = this.cookie;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z16 = this.isEnd;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        JSONObject jSONObject = this.jsonResponse;
        return i17 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECShopProductCommentInfo(reviewCount=" + this.reviewCount + ", cookie=" + this.cookie + ", isEnd=" + this.isEnd + ", jsonResponse=" + this.jsonResponse + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopProductCommentInfo)) {
            return false;
        }
        ECShopProductCommentInfo eCShopProductCommentInfo = (ECShopProductCommentInfo) other;
        return this.reviewCount == eCShopProductCommentInfo.reviewCount && Intrinsics.areEqual(this.cookie, eCShopProductCommentInfo.cookie) && this.isEnd == eCShopProductCommentInfo.isEnd && Intrinsics.areEqual(this.jsonResponse, eCShopProductCommentInfo.jsonResponse);
    }
}
