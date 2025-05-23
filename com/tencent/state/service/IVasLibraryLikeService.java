package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import ks4.b;
import os4.c;
import os4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0006H'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\tH'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH'\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/service/IVasLibraryLikeService;", "", "Ljs4/a;", "req", "Lcom/tencent/rapier/a;", "batchGetFootLabel", "Lks4/a;", "Lks4/b;", "batchGetUniFootLabel", "Los4/a;", "Los4/b;", "getUnreadLikeNumber", "Los4/c;", "Los4/d;", "doLikeRedDotClick", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasLibraryLikeService {
    @Route(method = "BatchGetFootLabel", service = "trpc.qmeta.foot_label_svr.FootLabelSvr")
    a<Object> batchGetFootLabel(js4.a req);

    @Route(method = "BatchGetUniFootLabel", service = "trpc.qmeta.foot_label_svr.UniFootLabel")
    a<b> batchGetUniFootLabel(ks4.a req);

    @Route(method = "LikeReddotClean", service = "trpc.qmeta.library_like_svr.LibraryLikeSvr")
    a<d> doLikeRedDotClick(c req);

    @Route(method = "GetUnreadLikeNums", service = "trpc.qmeta.library_like_svr.LibraryLikeSvr")
    a<os4.b> getUnreadLikeNumber(os4.a req);
}
