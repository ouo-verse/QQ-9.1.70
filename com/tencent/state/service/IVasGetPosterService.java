package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import lt4.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/service/IVasGetPosterService;", "", "Llt4/a;", "req", "Lcom/tencent/rapier/a;", "Llt4/b;", "getPosterData", "Lkt4/a;", "Lkt4/b;", "getSquareShareData", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasGetPosterService {
    @Route(method = "GetPosterData", service = "trpc.qmeta.status_action_poster_svr.StatusActionPosterSvr")
    a<b> getPosterData(lt4.a req);

    @Route(method = "GetData", service = "trpc.qmeta.status_action_poster_svr.SharePoster")
    a<kt4.b> getSquareShareData(kt4.a req);
}
