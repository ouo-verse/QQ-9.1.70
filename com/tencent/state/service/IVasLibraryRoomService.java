package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import rs4.b;
import rs4.c;
import rs4.d;
import rs4.e;
import rs4.f;
import rs4.g;
import rs4.h;
import rs4.i;
import rs4.j;
import rs4.k;
import rs4.l;
import rs4.m;
import rs4.n;
import rs4.o;
import rs4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\nH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\rH'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\u0013H'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0003\u001a\u00020\u0016H'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0003\u001a\u00020\u0019H'\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/service/IVasLibraryRoomService;", "", "Lrs4/e;", "req", "Lcom/tencent/rapier/a;", "Lrs4/f;", "enterRoom", "Lrs4/g;", "Lrs4/h;", "doFocus", "Lrs4/m;", "Lrs4/n;", "switchRoom", "Lrs4/k;", "Lrs4/l;", "leaveRoom", "Lrs4/a;", "Lrs4/b;", "doEndFocus", "Lrs4/i;", "Lrs4/j;", "getRemainLifeTime", "Lrs4/o;", "Lrs4/p;", "switchTable", "Lrs4/c;", "Lrs4/d;", "editTag", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasLibraryRoomService {
    @Route(method = "CancelFocus", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<b> doEndFocus(rs4.a req);

    @Route(method = "Focus", service = "trpc.qmeta.library_like_svr.libraryLikeSvr")
    a<h> doFocus(g req);

    @Route(method = "EditTagID", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<d> editTag(c req);

    @Route(method = "EnterRoom", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<f> enterRoom(e req);

    @Route(method = "GetRemainLifeTime", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<j> getRemainLifeTime(i req);

    @Route(method = "LeaveRoom", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<l> leaveRoom(k req);

    @Route(method = "SwitchRoom", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<n> switchRoom(m req);

    @Route(method = "SwitchTable", service = "trpc.qmeta.library_room_svr.LibraryRoom")
    a<p> switchTable(o req);
}
