package di0;

import ck0.Product;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B;\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Ldi0/ad;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "I", WadlProxyConsts.CHANNEL, "", "b", "J", "roomId", "", "Lck0/c;", "c", "Ljava/util/List;", "getAddProductList", "()Ljava/util/List;", "addProductList", "d", "getDelProductList", "delProductList", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "e", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "<init>", "(IJLjava/util/List;Ljava/util/List;Lcom/tencent/ecommerce/biz/live/LiveTabId;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ad implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Product> addProductList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Product> delProductList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveTabId tabId;

    public ad(int i3, long j3, List<Product> list, List<Product> list2, LiveTabId liveTabId) {
        this.channel = i3;
        this.roomId = j3;
        this.addProductList = list;
        this.delProductList = list2;
        this.tabId = liveTabId;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<Product> it = this.addProductList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(Product.INSTANCE.a(it.next()));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Product> it5 = this.delProductList.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(Product.INSTANCE.a(it5.next()));
            }
            jSONObject.put("add_product_ids", jSONArray);
            jSONObject.put("del_product_ids", jSONArray2);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.channel);
            jSONObject.put(AudienceReportConst.ROOM_ID, this.roomId);
            jSONObject.put(com.qzone.widget.u.COLUMN_TAB_ID, this.tabId.getValue());
            cg0.a.b("ECLiveWindowUpdateReq", "[encodeParams] req = " + jSONObject);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECLiveWindowUpdateReq", "encodeParams", "[encodeParams] e = " + e16);
            return new JSONObject();
        }
    }
}
