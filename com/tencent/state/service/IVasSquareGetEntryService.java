package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import et4.c;
import kotlin.Metadata;
import xr4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/service/IVasSquareGetEntryService;", "", "Let4/b;", "req", "Lcom/tencent/rapier/a;", "Let4/c;", "getAllEntry", "Lxr4/a;", "Lxr4/b;", "clearRedDot", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareGetEntryService {
    @Route(method = "ClearReddot", service = "trpc.qmeta.collect_card_svr.CollectCardSvr")
    a<b> clearRedDot(xr4.a req);

    @Route(method = "GetAllEntry", service = "trpc.qmeta.square_entry_svr.SquareEntry")
    a<c> getAllEntry(et4.b req);
}
