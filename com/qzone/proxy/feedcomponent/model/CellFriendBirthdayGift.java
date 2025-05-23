package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_gift_item;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFriendBirthdayGift implements SmartParcelable {

    @NeedParcel
    public ArrayList<FriendBirthdayGift> gifts = null;

    public static CellFriendBirthdayGift create(l lVar) {
        if (lVar == null || lVar.V == null) {
            return null;
        }
        CellFriendBirthdayGift cellFriendBirthdayGift = new CellFriendBirthdayGift();
        if (lVar.V.gifts == null) {
            return cellFriendBirthdayGift;
        }
        cellFriendBirthdayGift.gifts = new ArrayList<>();
        Iterator<s_gift_item> it = lVar.V.gifts.iterator();
        while (it.hasNext()) {
            FriendBirthdayGift g16 = com.qzone.proxy.feedcomponent.util.e.g(it.next());
            if (g16 != null) {
                cellFriendBirthdayGift.gifts.add(g16);
            }
        }
        return cellFriendBirthdayGift;
    }
}
