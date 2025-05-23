package com.tencent.state.square.flower.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import ot4.b;
import ot4.c;
import ot4.d;
import ot4.e;
import ot4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\nH'\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/flower/service/IVasFlowerService;", "", "Lot4/a;", "req", "Lcom/tencent/rapier/a;", "Lot4/b;", "getFlowerDisplayInfo", "Lot4/c;", "Lot4/d;", "getFlowerToday", "Lot4/e;", "Lot4/f;", "getFlowerYesterday", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasFlowerService {
    @Route(method = "GetFlowerPageInfo", service = "trpc.qmeta.status_flower_svr.StatusFlowerSvr")
    a<b> getFlowerDisplayInfo(ot4.a req);

    @Route(method = "GetFlowerToday", service = "trpc.qmeta.status_flower_svr.StatusFlowerSvr")
    a<d> getFlowerToday(c req);

    @Route(method = "GetFlowerYestoday", service = "trpc.qmeta.status_flower_svr.StatusFlowerSvr")
    a<f> getFlowerYesterday(e req);
}
