package com.tencent.ecommerce.repo.aftersale.apply;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.luggage.wxa.l6.o;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\nB=\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u001e\u0010\u0015R(\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\"\u001a\u0004\b\u001d\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "a", "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "b", "()Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "setApplyType", "(Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;)V", "applyType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFormMainTitle", "(Ljava/lang/String;)V", "formMainTitle", "d", "setFormSubTitle", "formSubTitle", "f", o.NAME, VasWebviewConstants.KEY_PAGE_TITLE, "e", "setApplyMount", "applyMount", "", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "Ljava/util/List;", "()Ljava/util/List;", "setOptionInfoList", "(Ljava/util/List;)V", "optionInfoList", "<init>", "(Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplyInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ApplyType applyType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String formMainTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String formSubTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String pageTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String applyMount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ECAfterSaleApplyOptionInfo> optionInfoList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/c$a;", "", "Lorg/json/JSONObject;", "applyInfoJson", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.apply.c$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECAfterSaleApplyInfo a(JSONObject applyInfoJson) {
            JSONArray optJSONArray = applyInfoJson.optJSONArray("option_cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (obj != null) {
                        arrayList.add(ECAfterSaleApplyOptionInfo.INSTANCE.a((JSONObject) obj));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
            }
            return new ECAfterSaleApplyInfo(ApplyType.INSTANCE.a(applyInfoJson.optInt("apply_type")), applyInfoJson.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT), applyInfoJson.optString("button_tips"), applyInfoJson.optString("title"), applyInfoJson.optString("apply_amount"), arrayList);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECAfterSaleApplyInfo(ApplyType applyType, String str, String str2, String str3, String str4, List<ECAfterSaleApplyOptionInfo> list) {
        this.applyType = applyType;
        this.formMainTitle = str;
        this.formSubTitle = str2;
        this.pageTitle = str3;
        this.applyMount = str4;
        this.optionInfoList = list;
    }

    /* renamed from: a, reason: from getter */
    public final String getApplyMount() {
        return this.applyMount;
    }

    /* renamed from: b, reason: from getter */
    public final ApplyType getApplyType() {
        return this.applyType;
    }

    /* renamed from: c, reason: from getter */
    public final String getFormMainTitle() {
        return this.formMainTitle;
    }

    /* renamed from: d, reason: from getter */
    public final String getFormSubTitle() {
        return this.formSubTitle;
    }

    public final List<ECAfterSaleApplyOptionInfo> e() {
        return this.optionInfoList;
    }

    /* renamed from: f, reason: from getter */
    public final String getPageTitle() {
        return this.pageTitle;
    }

    public int hashCode() {
        ApplyType applyType = this.applyType;
        int hashCode = (applyType != null ? applyType.hashCode() : 0) * 31;
        String str = this.formMainTitle;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.formSubTitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pageTitle;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.applyMount;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ECAfterSaleApplyOptionInfo> list = this.optionInfoList;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleApplyInfo(applyType=" + this.applyType + ", formMainTitle=" + this.formMainTitle + ", formSubTitle=" + this.formSubTitle + ", pageTitle=" + this.pageTitle + ", applyMount=" + this.applyMount + ", optionInfoList=" + this.optionInfoList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleApplyInfo)) {
            return false;
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo = (ECAfterSaleApplyInfo) other;
        return Intrinsics.areEqual(this.applyType, eCAfterSaleApplyInfo.applyType) && Intrinsics.areEqual(this.formMainTitle, eCAfterSaleApplyInfo.formMainTitle) && Intrinsics.areEqual(this.formSubTitle, eCAfterSaleApplyInfo.formSubTitle) && Intrinsics.areEqual(this.pageTitle, eCAfterSaleApplyInfo.pageTitle) && Intrinsics.areEqual(this.applyMount, eCAfterSaleApplyInfo.applyMount) && Intrinsics.areEqual(this.optionInfoList, eCAfterSaleApplyInfo.optionInfoList);
    }
}
