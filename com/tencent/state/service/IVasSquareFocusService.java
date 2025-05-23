package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import ft4.b;
import ft4.c;
import ft4.d;
import ft4.e;
import ft4.f;
import ft4.g;
import ft4.h;
import ft4.j;
import ft4.k;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\tH'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0013H'\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/service/IVasSquareFocusService;", "", "Lft4/e;", "req", "Lcom/tencent/rapier/a;", "Lft4/f;", "getSceneInfo", "Lft4/h;", "quitOtherScene", "Lft4/c;", "callGather", "Lft4/a;", "Lft4/b;", "applyCallGather", "Lft4/g;", "getUseFocusInfo", "Lft4/j;", "Lft4/k;", "watchUserRoom", "Lft4/d;", "editFocusTag", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareFocusService {
    @Route(method = "ApplyCallGather", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<b> applyCallGather(ft4.a req);

    @Route(method = "CallGather", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<Object> callGather(c req);

    @Route(method = "EditFocusTag", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<Object> editFocusTag(d req);

    @Route(method = "GetSceneInfo", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<f> getSceneInfo(e req);

    @Route(method = "GetUseFocusInfo", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<Object> getUseFocusInfo(g req);

    @Route(method = "QuitOtherScene", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<Object> quitOtherScene(h req);

    @Route(method = "WatchUserRoom", service = "trpc.qmeta.square_focus_svr.SquareFocusSvr")
    a<k> watchUserRoom(j req);
}
