package di0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 22\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b1\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R>\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010,\u001a\u00020#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b$\u0010%\u0012\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016\u00a8\u00063"}, d2 = {"Ldi0/m;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "d", "Z", "isSuccess", "()Z", "setSuccess", "(Z)V", "e", "Ljava/lang/String;", "getRichTxt", "()Ljava/lang/String;", "setRichTxt", "(Ljava/lang/String;)V", "richTxt", "f", "getDetailUrl", "setDetailUrl", "detailUrl", tl.h.F, "Ljava/util/HashMap;", "getReportInfoMap", "()Ljava/util/HashMap;", "setReportInfoMap", "(Ljava/util/HashMap;)V", "reportInfoMap", "", "i", "I", "getGoodsType", "()I", "setGoodsType", "(I)V", "getGoodsType$annotations", "()V", "goodsType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMediaProductId", "setMediaProductId", "mediaProductId", "<init>", BdhLogUtil.LogTag.Tag_Conn, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class m implements IECResponse {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int goodsType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSuccess = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String richTxt = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String detailUrl = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> reportInfoMap = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mediaProductId = "";

    public final HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("PARAM_RICH_TXT", this.richTxt);
        hashMap.put("PARAM_DETAIL_URL", this.detailUrl);
        hashMap.put("PARAM_PRODUCT_ID", this.mediaProductId);
        hashMap.put("PARAM_REPORT_INFO", this.reportInfoMap);
        return hashMap;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveWinowGetBubbleRsp", "[decodeData] data = " + data);
        if (data == null) {
            this.isSuccess = false;
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("bubble_info");
        if (optJSONObject != null) {
            this.richTxt = optJSONObject.optString("rich_txt");
            this.detailUrl = optJSONObject.optString("detail_url");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(ReportDataBuilder.KEY_PRODUCT_ID);
            if (optJSONObject2 != null) {
                this.goodsType = optJSONObject2.optInt("goods_type");
                this.mediaProductId = optJSONObject2.optString("media_product_id");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
            if (optJSONObject3 != null) {
                Iterator keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.reportInfoMap.put(str, optJSONObject3.optString(str));
                }
            }
        }
        this.isSuccess = true;
        return true;
    }
}
