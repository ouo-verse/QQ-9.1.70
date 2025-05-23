package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import mt4.d;
import mt4.e;
import mt4.h;
import mt4.i;
import yt4.b;
import yt4.c;
import yt4.f;
import yt4.g;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\nH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\rH'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\u0013H'\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/service/IZTPSquareRewardService;", "", "Lyt4/c;", "req", "Lcom/tencent/rapier/a;", "Lyt4/d;", "getRewardList", "Lyt4/e;", "Lyt4/f;", "getUserRewardPoints", "Lyt4/g;", "Lyt4/h;", "redeemRewards", "Lyt4/a;", "Lyt4/b;", "finishShareTask", "Lmt4/h;", "Lmt4/i;", "getSkins", "Lmt4/d;", "Lmt4/e;", "dressSkin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IZTPSquareRewardService {
    @Route(method = "DressSkin", service = "trpc.qmeta.status_bubbleskin_svr.StatusBubbleskinSvr")
    a<e> dressSkin(d req);

    @Route(method = "FinishShareTask", service = "trpc.qmeta.status_square_task_svr.StatusSquareTaskSvr")
    a<b> finishShareTask(yt4.a req);

    @Route(method = "GetRewardList", service = "trpc.qmeta.status_square_task_svr.StatusSquareTaskSvr")
    a<yt4.d> getRewardList(c req);

    @Route(method = "GetSkins", service = "trpc.qmeta.status_bubbleskin_svr.StatusBubbleskinSvr")
    a<i> getSkins(h req);

    @Route(method = "GetUserRewardPoints", service = "trpc.qmeta.status_square_task_svr.StatusSquareTaskSvr")
    a<f> getUserRewardPoints(yt4.e req);

    @Route(method = "RedeemRewards", service = "trpc.qmeta.status_square_task_svr.StatusSquareTaskSvr")
    a<yt4.h> redeemRewards(g req);
}
