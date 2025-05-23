package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import xt4.k;
import xt4.l;
import xt4.x;
import xt4.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/service/IVasStatusSquareService;", "", "Lxt4/x;", "req", "Lcom/tencent/rapier/a;", "Lxt4/y;", "setCoverResource", "Lxt4/k;", "Lxt4/l;", "getResourceInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasStatusSquareService {
    @Route(method = "GetResourceInfo", service = VasStatusSquareService.CMD_SERVICE)
    a<l> getResourceInfo(k req);

    @Route(method = "SetCoverResource", service = VasStatusSquareService.CMD_SERVICE)
    a<y> setCoverResource(x req);
}
