package com.tencent.state.service;

import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import ht4.b;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/service/IVasBatchGroupInfoService;", "", "Lht4/a;", "req", "Lcom/tencent/rapier/a;", "Lht4/b;", PluginConst.DataJsPluginConst.API_GET_GROUP_INFO, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasBatchGroupInfoService {
    @Route(method = "BatchGetGroupInfo", service = "trpc.qmeta.square_group_svr.SquareGroupSvr")
    a<b> getGroupInfo(ht4.a req);
}
