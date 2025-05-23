package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.mobileqq.R;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1 extends e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECShopDetailSkuInfoViewModel f102476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1(ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel) {
        this.f102476a = eCShopDetailSkuInfoViewModel;
    }

    @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
    public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
        String str;
        Integer intOrNull;
        EditText editText;
        MutableLiveData mutableLiveData;
        String str2;
        if (dataMap == null || (str = dataMap.get("eventType")) == null) {
            return;
        }
        cg0.a.b("ECShopDetailSkuInfoViewModel", "[onTapEventTriggered] " + str);
        Editable editable = null;
        switch (str.hashCode()) {
            case -2120946614:
                if (str.equals("specSelectItem")) {
                    String str3 = dataMap.get("specTitle");
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = dataMap.get("specSelectItem");
                    if (str4 == null) {
                        str4 = "";
                    }
                    if (str3.length() == 0) {
                        return;
                    }
                    if (str4.length() == 0) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str4);
                    if (jSONObject.optBoolean("disable", false)) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.f102476a), null, null, new ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$1(this, str3, jSONObject.optString("text", ""), null), 3, null);
                    return;
                }
                return;
            case -1166000724:
                if (str.equals("count_adjuster")) {
                    Object tag = view != null ? view.getTag() : null;
                    if (Intrinsics.areEqual(tag, "count_adjuster_event_add")) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.f102476a), null, null, new ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$1(null, this, view), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(tag, "count_adjuster_event_minus")) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.f102476a), null, null, new ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$2(null, this, view), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(tag, "count_adjuster_event_text_change")) {
                        if (view != null && (editText = (EditText) view.findViewById(R.id.o8e)) != null) {
                            editable = editText.getText();
                        }
                        String valueOf = String.valueOf(editable);
                        ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel = this.f102476a;
                        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(valueOf);
                        eCShopDetailSkuInfoViewModel.inputValue = intOrNull != null ? intOrNull.intValue() : 0;
                        return;
                    }
                    return;
                }
                return;
            case -960709980:
                if (str.equals("closeBtnClick")) {
                    mutableLiveData = this.f102476a._closePageData;
                    mutableLiveData.postValue(Boolean.TRUE);
                    return;
                }
                return;
            case 433923123:
                if (!str.equals("showPhotoBrowser") || (str2 = dataMap.get("photosData")) == null) {
                    return;
                }
                lg0.a.b(lg0.a.f414523b, ECShopProductCommentViewModel.INSTANCE.a(str2), identifier != null ? Integer.parseInt(identifier) : 0, null, 4, null);
                return;
            default:
                return;
        }
    }
}
