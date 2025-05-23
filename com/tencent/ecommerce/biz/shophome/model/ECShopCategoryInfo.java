package com.tencent.ecommerce.biz.shophome.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0013j\b\u0012\u0004\u0012\u00020\u0000`\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0013j\b\u0012\u0004\u0012\u00020\u0000`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\nR\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\r\u0010\u001d\"\u0004\b\u0010\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/b;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "Ljava/lang/String;", "name", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "categoryInfo", "c", "I", "categoryType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "subCategory", "e", "url", "f", "Z", "()Z", "(Z)V", "isSelected", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;ILjava/util/ArrayList;Ljava/lang/String;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.model.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopCategoryInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject categoryInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int categoryType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<ECShopCategoryInfo> subCategory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    public ECShopCategoryInfo(String str, JSONObject jSONObject, int i3, ArrayList<ECShopCategoryInfo> arrayList, String str2, boolean z16) {
        this.name = str;
        this.categoryInfo = jSONObject;
        this.categoryType = i3;
        this.subCategory = arrayList;
        this.url = str2;
        this.isSelected = z16;
    }

    public final ArrayList<ECShopCategoryInfo> a() {
        return this.subCategory;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void c(boolean z16) {
        this.isSelected = z16;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ECShopCategoryInfo)) {
            return false;
        }
        ECShopCategoryInfo eCShopCategoryInfo = (ECShopCategoryInfo) other;
        if (!Intrinsics.areEqual(eCShopCategoryInfo.name, this.name)) {
            return false;
        }
        JSONObject jSONObject = eCShopCategoryInfo.categoryInfo;
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        JSONObject jSONObject3 = this.categoryInfo;
        return Intrinsics.areEqual(jSONObject2, jSONObject3 != null ? jSONObject3.toString() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        JSONObject jSONObject = this.categoryInfo;
        int hashCode2 = (((hashCode + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31) + this.categoryType) * 31;
        ArrayList<ECShopCategoryInfo> arrayList = this.subCategory;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str2 = this.url;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "ECShopCategoryInfo(name=" + this.name + ", categoryInfo=" + this.categoryInfo + ", categoryType=" + this.categoryType + ", subCategory=" + this.subCategory + ", url=" + this.url + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ ECShopCategoryInfo(String str, JSONObject jSONObject, int i3, ArrayList arrayList, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? null : jSONObject, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? new ArrayList() : arrayList, (i16 & 16) != 0 ? "" : str2, (i16 & 32) != 0 ? false : z16);
    }
}
