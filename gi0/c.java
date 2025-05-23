package gi0;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lgi0/c;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$LabelInfo;", "Lorg/json/JSONObject;", "b", "Landroid/widget/TextView;", "textView", "", "goodsName", "", "labels", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f402085a = new c();

    c() {
    }

    private final JSONObject b(ECOrderInfo$LabelInfo eCOrderInfo$LabelInfo) {
        JSONObject jSONObject = new JSONObject();
        String str = eCOrderInfo$LabelInfo.background_color.get();
        if (str != null) {
            jSONObject.put("background_color", str);
        }
        String str2 = eCOrderInfo$LabelInfo.text_color.get();
        if (str2 != null) {
            jSONObject.put("text_color", str2);
        }
        String str3 = eCOrderInfo$LabelInfo.text.get();
        if (str3 != null) {
            jSONObject.put("text", str3);
        }
        String str4 = eCOrderInfo$LabelInfo.text_prefix.get();
        if (str4 != null) {
            jSONObject.put("text_prefix", str4);
        }
        jSONObject.put("text_style_type", eCOrderInfo$LabelInfo.text_style_type.get());
        String str5 = eCOrderInfo$LabelInfo.border_color.get();
        if (str5 != null) {
            jSONObject.put(LayoutAttrDefine.BorderColor, str5);
        }
        String str6 = eCOrderInfo$LabelInfo.pic_url.get();
        if (str6 != null) {
            jSONObject.put("pic_url", str6);
        }
        jSONObject.put("width", eCOrderInfo$LabelInfo.width.get());
        jSONObject.put("height", eCOrderInfo$LabelInfo.height.get());
        String str7 = eCOrderInfo$LabelInfo.pic_token.get();
        if (str7 != null) {
            jSONObject.put("pic_token", str7);
        }
        return jSONObject;
    }

    public final void a(TextView textView, String goodsName, List<ECOrderInfo$LabelInfo> labels) {
        if (labels.isEmpty()) {
            textView.setText(goodsName);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = labels.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(f402085a.b((ECOrderInfo$LabelInfo) it.next()));
        }
        l h16 = new k(null, 1, null).h(jSONArray);
        h16.e(goodsName, 14, "qecommerce_skin_color_text_primary", 1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        RichTextParser.parse(textView, spannableStringBuilder, h16.g());
        textView.setText(spannableStringBuilder);
    }
}
