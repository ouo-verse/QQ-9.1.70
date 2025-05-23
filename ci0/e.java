package ci0;

import com.tencent.ecommerce.biz.live.ECLiveEvent;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.event.ECLiveWindowLocalUpdateEvent;
import com.tencent.ecommerce.repo.live.LiveProduct;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/live/event/ECLiveWindowLocalUpdateEvent;", "", "event", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "", "mediaProductId", "liveUserId", "liveRoomId", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class e {
    public static final ECLiveWindowLocalUpdateEvent a(ECLiveWindowLocalUpdateEvent eCLiveWindowLocalUpdateEvent, @ECLiveEvent int i3, LiveTabId liveTabId, String str, String str2, String str3, LiveProduct liveProduct) {
        return new ECLiveWindowLocalUpdateEvent(i3, liveTabId, str, str2, str3, liveProduct);
    }

    public static /* synthetic */ ECLiveWindowLocalUpdateEvent b(ECLiveWindowLocalUpdateEvent eCLiveWindowLocalUpdateEvent, int i3, LiveTabId liveTabId, String str, String str2, String str3, LiveProduct liveProduct, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = eCLiveWindowLocalUpdateEvent.event;
        }
        if ((i16 & 2) != 0) {
            liveTabId = eCLiveWindowLocalUpdateEvent.tabId;
        }
        LiveTabId liveTabId2 = liveTabId;
        if ((i16 & 4) != 0) {
            str = eCLiveWindowLocalUpdateEvent.mediaProductId;
        }
        String str4 = str;
        if ((i16 & 8) != 0) {
            str2 = eCLiveWindowLocalUpdateEvent.liveUserId;
        }
        String str5 = str2;
        if ((i16 & 16) != 0) {
            str3 = eCLiveWindowLocalUpdateEvent.liveRoomId;
        }
        String str6 = str3;
        if ((i16 & 32) != 0) {
            liveProduct = eCLiveWindowLocalUpdateEvent.getLiveProduct();
        }
        return a(eCLiveWindowLocalUpdateEvent, i3, liveTabId2, str4, str5, str6, liveProduct);
    }
}
