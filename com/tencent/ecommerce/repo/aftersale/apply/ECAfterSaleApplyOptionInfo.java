package com.tencent.ecommerce.repo.aftersale.apply;

import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\tBG\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\t\u0010\u001f\"\u0004\b \u0010!R$\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setKeyText", "(Ljava/lang/String;)V", "keyText", "b", "I", "()I", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(I)V", "key", "", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "Ljava/util/List;", "d", "()Ljava/util/List;", "setOptionValueList", "(Ljava/util/List;)V", "optionValueList", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "()Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "setDefaultValue", "(Lcom/tencent/ecommerce/repo/aftersale/apply/j;)V", RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", "g", "selectedOption", "f", "Z", "()Z", "setDisable", "(Z)V", "isDisable", "<init>", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/ecommerce/repo/aftersale/apply/j;Lcom/tencent/ecommerce/repo/aftersale/apply/j;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplyOptionInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String keyText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<OptionValue> optionValueList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private OptionValue defaultValue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private OptionValue selectedOption;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isDisable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/g$a;", "", "Lorg/json/JSONObject;", "optionCardJson", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "a", "", "KEY_TYPE_HOW_TO_SEND", "I", "KEY_TYPE_RECEIVE_STATUS", "KEY_TYPE_REFUND_REASON", "KEY_TYPE_UNKNOW", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.apply.g$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECAfterSaleApplyOptionInfo a(JSONObject optionCardJson) {
            JSONArray optJSONArray = optionCardJson.optJSONArray("values");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (obj != null) {
                        arrayList.add(OptionValue.INSTANCE.b((JSONObject) obj));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
            }
            JSONObject optJSONObject = optionCardJson.optJSONObject("default_value");
            return new ECAfterSaleApplyOptionInfo(optionCardJson.optString("key_text"), optionCardJson.optInt("key"), arrayList, optJSONObject == null ? null : OptionValue.INSTANCE.b(optJSONObject), null, optionCardJson.optBoolean("disabled", false), 16, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECAfterSaleApplyOptionInfo(String str, int i3, List<OptionValue> list, OptionValue optionValue, OptionValue optionValue2, boolean z16) {
        this.keyText = str;
        this.key = i3;
        this.optionValueList = list;
        this.defaultValue = optionValue;
        this.selectedOption = optionValue2;
        this.isDisable = z16;
    }

    /* renamed from: a, reason: from getter */
    public final OptionValue getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: b, reason: from getter */
    public final int getKey() {
        return this.key;
    }

    /* renamed from: c, reason: from getter */
    public final String getKeyText() {
        return this.keyText;
    }

    public final List<OptionValue> d() {
        return this.optionValueList;
    }

    /* renamed from: e, reason: from getter */
    public final OptionValue getSelectedOption() {
        return this.selectedOption;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsDisable() {
        return this.isDisable;
    }

    public final void g(OptionValue optionValue) {
        this.selectedOption = optionValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.keyText;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.key) * 31;
        List<OptionValue> list = this.optionValueList;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        OptionValue optionValue = this.defaultValue;
        int hashCode3 = (hashCode2 + (optionValue != null ? optionValue.hashCode() : 0)) * 31;
        OptionValue optionValue2 = this.selectedOption;
        int hashCode4 = (hashCode3 + (optionValue2 != null ? optionValue2.hashCode() : 0)) * 31;
        boolean z16 = this.isDisable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "ECAfterSaleApplyOptionInfo(keyText=" + this.keyText + ", key=" + this.key + ", optionValueList=" + this.optionValueList + ", defaultValue=" + this.defaultValue + ", selectedOption=" + this.selectedOption + ", isDisable=" + this.isDisable + ")";
    }

    public /* synthetic */ ECAfterSaleApplyOptionInfo(String str, int i3, List list, OptionValue optionValue, OptionValue optionValue2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, list, (i16 & 8) != 0 ? null : optionValue, (i16 & 16) != 0 ? null : optionValue2, (i16 & 32) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleApplyOptionInfo)) {
            return false;
        }
        ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo = (ECAfterSaleApplyOptionInfo) other;
        return Intrinsics.areEqual(this.keyText, eCAfterSaleApplyOptionInfo.keyText) && this.key == eCAfterSaleApplyOptionInfo.key && Intrinsics.areEqual(this.optionValueList, eCAfterSaleApplyOptionInfo.optionValueList) && Intrinsics.areEqual(this.defaultValue, eCAfterSaleApplyOptionInfo.defaultValue) && Intrinsics.areEqual(this.selectedOption, eCAfterSaleApplyOptionInfo.selectedOption) && this.isDisable == eCAfterSaleApplyOptionInfo.isDisable;
    }
}
