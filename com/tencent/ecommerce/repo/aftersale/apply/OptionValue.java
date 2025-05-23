package com.tencent.ecommerce.repo.aftersale.apply;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AbortReason;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB)\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "I", "c", "()I", HippyTextInputController.COMMAND_setValue, "(I)V", "value", "", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "Ljava/util/List;", "()Ljava/util/List;", "setSubOptionInfoList", "(Ljava/util/List;)V", "subOptionInfoList", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OptionValue {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ECAfterSaleApplyOptionInfo> subOptionInfoList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/j$a;", "", "Lorg/json/JSONObject;", "valueJson", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$AbortReason;", "reason", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.apply.j$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final OptionValue a(ECSampleData$AbortReason reason) {
            return new OptionValue(reason.f105257msg.get(), reason.reason_id.get(), null, 4, null);
        }

        public final OptionValue b(JSONObject valueJson) {
            JSONArray optJSONArray = valueJson.optJSONArray("sub_cards");
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
            return new OptionValue(valueJson.optString("value_text"), valueJson.optInt("value"), arrayList);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OptionValue(String str, int i3, List<ECAfterSaleApplyOptionInfo> list) {
        this.text = str;
        this.value = i3;
        this.subOptionInfoList = list;
    }

    public final List<ECAfterSaleApplyOptionInfo> a() {
        return this.subOptionInfoList;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: c, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.value) * 31;
        List<ECAfterSaleApplyOptionInfo> list = this.subOptionInfoList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "OptionValue(text=" + this.text + ", value=" + this.value + ", subOptionInfoList=" + this.subOptionInfoList + ")";
    }

    public /* synthetic */ OptionValue(String str, int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? null : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionValue)) {
            return false;
        }
        OptionValue optionValue = (OptionValue) other;
        return Intrinsics.areEqual(this.text, optionValue.text) && this.value == optionValue.value && Intrinsics.areEqual(this.subOptionInfoList, optionValue.subOptionInfoList);
    }
}
