package com.tencent.state.square.detail;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.Stickers;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/detail/DetailGuestListener;", "Lcom/tencent/state/square/detail/DetailCommonListener;", "goToInteraction", "", "goToMiniAioChat", "data", "Lcom/tencent/state/map/MapItem;", "resetTargetAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "updateQZoneFeeds", "uin", "", "feedsInfo", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "updateStickers", c.B, "Lcom/tencent/state/square/data/Stickers;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface DetailGuestListener extends DetailCommonListener {
    void goToInteraction();

    void goToMiniAioChat(MapItem data);

    void resetTargetAvatar(Resource resource);

    void updateQZoneFeeds(String uin, QZoneFeedsInfo feedsInfo);

    void updateStickers(String uin, Stickers stickers);
}
