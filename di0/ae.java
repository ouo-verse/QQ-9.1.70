package di0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.biz.showwindow.repo.window.FailItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Ldi0/ae;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "d", "Z", "()Z", "setSuccess", "(Z)V", "isSuccess", "", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/i;", "e", "Ljava/util/List;", "a", "()Ljava/util/List;", "setFaildItems", "(Ljava/util/List;)V", "faildItems", "", "f", "I", "c", "()I", "setTotalAddSuccessCount", "(I)V", "totalAddSuccessCount", "", tl.h.F, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFaildMsg", "(Ljava/lang/String;)V", "faildMsg", "<init>", "()V", "i", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ae implements IECResponse {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int totalAddSuccessCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSuccess = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<FailItem> faildItems = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String faildMsg = "";

    public final List<FailItem> a() {
        return this.faildItems;
    }

    /* renamed from: b, reason: from getter */
    public final String getFaildMsg() {
        return this.faildMsg;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalAddSuccessCount() {
        return this.totalAddSuccessCount;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveWindowUpdateRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.totalAddSuccessCount = data.optInt("total");
        this.faildMsg = data.optString("faild_msg");
        JSONArray optJSONArray = data.optJSONArray("faild_items");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj != null) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Object opt = jSONObject.opt(ReportDataBuilder.KEY_PRODUCT_ID);
                    if (opt != null) {
                        JSONObject jSONObject2 = (JSONObject) opt;
                        this.faildItems.add(new FailItem(jSONObject2.optInt("goods_type"), jSONObject2.optString("media_product_id"), jSONObject.optInt("ret_code"), jSONObject.optString("msg")));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        } else {
            this.isSuccess = true;
        }
        return true;
    }
}
