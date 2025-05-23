package com.tencent.state.square.pickfriend.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import ot4.g;
import ot4.h;
import rt4.j;
import rt4.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/pickfriend/service/IVasPickFriendService;", "", "Lot4/g;", "req", "Lcom/tencent/rapier/a;", "Lot4/h;", "getEntryInfo", "Lrt4/j;", "Lrt4/k;", "getFriendList", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasPickFriendService {
    @Route(method = "GetGuidance", service = "trpc.qmeta.status_flower_svr.StatusFlowerSvr")
    a<h> getEntryInfo(g req);

    @Route(method = "GetStatusPanel", service = "trpc.qmeta.status_flower_svr.statusPanelSvr")
    a<k> getFriendList(j req);
}
