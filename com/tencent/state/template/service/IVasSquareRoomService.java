package com.tencent.state.template.service;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import wt4.b;
import wt4.c;
import wt4.d;
import wt4.e;
import wt4.f;
import wt4.g;
import wt4.h;
import wt4.i;
import wt4.j;
import wt4.l;
import wt4.m;
import wt4.n;
import wt4.o;
import wt4.p;
import wt4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0003\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0003\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0003\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0003\u001a\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0003\u001a\u00020\u00182\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0003\u001a\u00020\u001b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/template/service/IVasSquareRoomService;", "", "Lwt4/e;", "req", "", "source", "Lcom/tencent/rapier/a;", "Lwt4/f;", "enterRoom", "Lwt4/n;", "Lwt4/o;", "switchRoom", "Lwt4/i;", "Lwt4/j;", "leaveRoom", "Lwt4/g;", "Lwt4/h;", WSPublicAccReport.SOP_NAME_FOCUS, "Lwt4/a;", "Lwt4/b;", "cancelFocus", "Lwt4/p;", "Lwt4/q;", "switchTable", "Lwt4/l;", "Lwt4/m;", "refreshUserInfo", "Lwt4/c;", "Lwt4/d;", "choose", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareRoomService {
    @Route(method = "CancelFocus", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<b> cancelFocus(wt4.a req, int source);

    @Route(method = "Choose", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<d> choose(c req, int source);

    @Route(method = "EnterRoom", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<f> enterRoom(e req, int source);

    @Route(method = "Focus", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<h> focus(g req, int source);

    @Route(method = "LeaveRoom", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<j> leaveRoom(i req, int source);

    @Route(method = "RefreshUserInfo", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<m> refreshUserInfo(l req, int source);

    @Route(method = "SwitchRoom", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<o> switchRoom(n req, int source);

    @Route(method = "SwitchTable", service = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr")
    a<q> switchTable(p req, int source);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ a cancelFocus$default(IVasSquareRoomService iVasSquareRoomService, wt4.a aVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.cancelFocus(aVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelFocus");
        }

        public static /* synthetic */ a choose$default(IVasSquareRoomService iVasSquareRoomService, c cVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.choose(cVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: choose");
        }

        public static /* synthetic */ a enterRoom$default(IVasSquareRoomService iVasSquareRoomService, e eVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.enterRoom(eVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoom");
        }

        public static /* synthetic */ a focus$default(IVasSquareRoomService iVasSquareRoomService, g gVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.focus(gVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focus");
        }

        public static /* synthetic */ a leaveRoom$default(IVasSquareRoomService iVasSquareRoomService, i iVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.leaveRoom(iVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaveRoom");
        }

        public static /* synthetic */ a refreshUserInfo$default(IVasSquareRoomService iVasSquareRoomService, l lVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.refreshUserInfo(lVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshUserInfo");
        }

        public static /* synthetic */ a switchRoom$default(IVasSquareRoomService iVasSquareRoomService, n nVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.switchRoom(nVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchRoom");
        }

        public static /* synthetic */ a switchTable$default(IVasSquareRoomService iVasSquareRoomService, p pVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomService.switchTable(pVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchTable");
        }
    }
}
