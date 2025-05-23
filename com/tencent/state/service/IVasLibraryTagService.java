package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import us4.b;
import us4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/service/IVasLibraryTagService;", "", "Lus4/b;", "req", "Lcom/tencent/rapier/a;", "Lus4/c;", "getTagInfos", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasLibraryTagService {
    @Route(method = "GetTagInfos", service = "trpc.qmeta.library_tag_svr.LibraryTagSvr")
    a<c> getTagInfos(b req);
}
