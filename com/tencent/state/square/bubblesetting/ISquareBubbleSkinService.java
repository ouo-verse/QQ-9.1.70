package com.tencent.state.square.bubblesetting;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import mt4.b;
import mt4.c;
import mt4.f;
import mt4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/bubblesetting/ISquareBubbleSkinService;", "", "Lmt4/f;", "req", "Lcom/tencent/rapier/a;", "Lmt4/g;", "getBubbleSkin", "Lmt4/b;", "Lmt4/c;", "dressBubbleSkin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareBubbleSkinService {
    @Route(method = "DressBubbleskin", service = "trpc.qmeta.status_bubbleskin_svr.StatusBubbleskinSvr")
    a<c> dressBubbleSkin(b req);

    @Route(method = "GetBubbleskins", service = "trpc.qmeta.status_bubbleskin_svr.StatusBubbleskinSvr")
    a<g> getBubbleSkin(f req);
}
