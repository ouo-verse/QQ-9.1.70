package di0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B'\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Ldi0/y;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", WadlProxyConsts.CHANNEL, "", "b", "J", "roomId", "Lcom/tencent/ecommerce/repo/live/q;", "c", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "d", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "<init>", "(IJLcom/tencent/ecommerce/repo/live/q;Lcom/tencent/ecommerce/biz/live/LiveTabId;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class y implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LiveProduct liveProduct;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LiveTabId tabId;

    public y(int i3, long j3, LiveProduct liveProduct, LiveTabId liveTabId) {
        this.channel = i3;
        this.roomId = j3;
        this.liveProduct = liveProduct;
        this.tabId = liveTabId;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, LiveProduct.INSTANCE.a(this.liveProduct));
            jSONObject.put("op", this.liveProduct.getIsExplaining() ? 1 : 2);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.roomId);
            jSONObject.put(com.qzone.widget.u.COLUMN_TAB_ID, this.tabId.getValue());
            cg0.a.b("ECLiveWinowSetProductExplainReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWinowSetProductExplainReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
