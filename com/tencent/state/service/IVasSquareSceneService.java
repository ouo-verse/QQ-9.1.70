package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import it4.b;
import it4.c;
import it4.d;
import it4.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/service/IVasSquareSceneService;", "", "Lit4/b;", "req", "Lcom/tencent/rapier/a;", "Lit4/c;", "getAllBuildingStyles", "Lit4/d;", "Lit4/e;", "saveBuildingStyle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareSceneService {
    @Route(method = "GetAllStyles", service = "trpc.qmeta.square_scene_svr.SquareSceneSvr")
    a<c> getAllBuildingStyles(b req);

    @Route(method = "SaveBuildings", service = "trpc.qmeta.square_scene_svr.SquareSceneSvr")
    a<e> saveBuildingStyle(d req);
}
