package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/service/IVasSquareFriendPickService;", "", "Lgt4/a;", "req", "Lcom/tencent/rapier/a;", "getFriendPickEntryInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareFriendPickService {
    @Route(method = "GetEntryInfo", service = "trpc.qmeta.square_friends_pick_svr.SquareFriendsPickSvr")
    a<Object> getFriendPickEntryInfo(gt4.a req);
}
