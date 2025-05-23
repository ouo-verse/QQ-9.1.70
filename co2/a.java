package co2;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.model.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import wn2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends ContactSearchEngine {
    public a(AppInterface appInterface, int i3, int i16, String str, Set<String> set) {
        super(appInterface, i3, i16, str, set);
    }

    @Override // com.tencent.mobileqq.search.business.contact.ContactSearchEngine
    protected List<k> C(int i3) {
        ArrayList arrayList = new ArrayList();
        List<GameFriendSelectorSvr$Friend> gameFriendsInfo = ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getGameFriendsInfo();
        if (gameFriendsInfo != null && gameFriendsInfo.size() > 0) {
            Iterator<GameFriendSelectorSvr$Friend> it = gameFriendsInfo.iterator();
            while (it.hasNext()) {
                arrayList.add(new d(this.f282844d, this.D, r(r7.f213219id.get()), it.next()));
            }
        }
        return arrayList;
    }
}
