package di0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.TabInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Ldi0/w;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "d", "Z", "isSuccess", "()Z", "setSuccess", "(Z)V", "", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "e", "Ljava/util/List;", "a", "()Ljava/util/List;", "tabList", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class w implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSuccess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<TabInfo> tabList = new ArrayList();

    public final List<TabInfo> a() {
        return this.tabList;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECLiveWindowGetTabsRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONArray optJSONArray = data.optJSONArray("tab_infos");
        if (optJSONArray == null) {
            return true;
        }
        this.isSuccess = optJSONArray.length() > 0;
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                this.tabList.add(new TabInfo(LiveTabId.INSTANCE.a(optJSONObject.optInt(com.qzone.widget.u.COLUMN_TAB_ID)), optJSONObject.optString("name"), optJSONObject.optInt("total"), optJSONObject.optBoolean("allow_edit"), optJSONObject.optBoolean("is_anchored"), optJSONObject.optBoolean("has_search"), 0, 64, null));
            }
        }
        return true;
    }
}
