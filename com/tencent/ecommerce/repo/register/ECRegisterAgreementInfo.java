package com.tencent.ecommerce.repo.register;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB5\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/repo/register/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "title", "b", "tips", "c", "desc", "", "Lcom/tencent/ecommerce/repo/register/a;", "d", "Ljava/util/List;", "()Ljava/util/List;", "checkBoxes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.register.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECRegisterAgreementInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tips;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECAgreementCheckBox> checkBoxes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/register/c$a;", "", "Lorg/json/JSONObject;", "infoJson", "Lcom/tencent/ecommerce/repo/register/c;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.register.c$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECRegisterAgreementInfo a(JSONObject infoJson) {
            JSONObject optJSONObject = infoJson.optJSONObject("result");
            if (optJSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("checkboxs");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("links");
                if (optJSONArray2 == null) {
                    optJSONArray2 = new JSONArray();
                }
                ArrayList arrayList2 = new ArrayList();
                int length2 = optJSONArray2.length();
                int i16 = 0;
                while (i16 < length2) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i16);
                    arrayList2.add(new ECAgreementLink(optJSONObject3.optString("text", ""), optJSONObject3.optString("url", ""), optJSONObject3.optInt("type", 0)));
                    i16++;
                    optJSONArray = optJSONArray;
                }
                arrayList.add(new ECAgreementCheckBox(optJSONObject2.optString("text", ""), arrayList2, optJSONObject2.optBoolean("is_required", false), optJSONObject2.optBoolean("check_by_default", false), optJSONObject2.optInt("type", 0), optJSONObject2.optBoolean("check_by_default", false)));
                i3++;
                optJSONArray = optJSONArray;
            }
            return new ECRegisterAgreementInfo(optJSONObject.optString("title", ""), optJSONObject.optString("tips", ""), optJSONObject.optString("desc", ""), arrayList);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECRegisterAgreementInfo() {
        this(null, null, null, null, 15, null);
    }

    public final List<ECAgreementCheckBox> a() {
        return this.checkBoxes;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tips;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<ECAgreementCheckBox> list = this.checkBoxes;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ECRegisterAgreementInfo(title=" + this.title + ", tips=" + this.tips + ", desc=" + this.desc + ", checkBoxes=" + this.checkBoxes + ")";
    }

    public ECRegisterAgreementInfo(String str, String str2, String str3, List<ECAgreementCheckBox> list) {
        this.title = str;
        this.tips = str2;
        this.desc = str3;
        this.checkBoxes = list;
    }

    public /* synthetic */ ECRegisterAgreementInfo(String str, String str2, String str3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? new ArrayList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECRegisterAgreementInfo)) {
            return false;
        }
        ECRegisterAgreementInfo eCRegisterAgreementInfo = (ECRegisterAgreementInfo) other;
        return Intrinsics.areEqual(this.title, eCRegisterAgreementInfo.title) && Intrinsics.areEqual(this.tips, eCRegisterAgreementInfo.tips) && Intrinsics.areEqual(this.desc, eCRegisterAgreementInfo.desc) && Intrinsics.areEqual(this.checkBoxes, eCRegisterAgreementInfo.checkBoxes);
    }
}
