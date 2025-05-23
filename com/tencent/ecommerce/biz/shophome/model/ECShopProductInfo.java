package com.tencent.ecommerce.biz.shophome.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\f\u0010\u001c\"\u0004\b\u000e\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "id", "b", "name", "c", "url", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "e", "I", "viewType", "f", "Z", "()Z", "(Z)V", "hasExposed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;IZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.model.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopProductInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject dataJson;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int viewType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasExposed;

    public ECShopProductInfo(String str, String str2, String str3, JSONObject jSONObject, int i3, boolean z16) {
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.dataJson = jSONObject;
        this.viewType = i3;
        this.hasExposed = z16;
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasExposed() {
        return this.hasExposed;
    }

    public final void c(boolean z16) {
        this.hasExposed = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.dataJson;
        int hashCode4 = (((hashCode3 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31) + this.viewType) * 31;
        boolean z16 = this.hasExposed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "ECShopProductInfo(id=" + this.id + ", name=" + this.name + ", url=" + this.url + ", dataJson=" + this.dataJson + ", viewType=" + this.viewType + ", hasExposed=" + this.hasExposed + ")";
    }

    public /* synthetic */ ECShopProductInfo(String str, String str2, String str3, JSONObject jSONObject, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i16 & 8) != 0 ? null : jSONObject, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopProductInfo)) {
            return false;
        }
        ECShopProductInfo eCShopProductInfo = (ECShopProductInfo) other;
        return Intrinsics.areEqual(this.id, eCShopProductInfo.id) && Intrinsics.areEqual(this.name, eCShopProductInfo.name) && Intrinsics.areEqual(this.url, eCShopProductInfo.url) && Intrinsics.areEqual(this.dataJson, eCShopProductInfo.dataJson) && this.viewType == eCShopProductInfo.viewType && this.hasExposed == eCShopProductInfo.hasExposed;
    }
}
