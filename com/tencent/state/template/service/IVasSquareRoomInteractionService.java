package com.tencent.state.template.service;

import bt4.b;
import bt4.c;
import bt4.d;
import bt4.e;
import bt4.g;
import bt4.h;
import bt4.i;
import bt4.j;
import bt4.k;
import bt4.l;
import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0003\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0003\u001a\u00020\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0003\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/service/IVasSquareRoomInteractionService;", "", "Lbt4/d;", "req", "", "source", "Lcom/tencent/rapier/a;", "Lbt4/e;", "getMotionList", "Lbt4/k;", "Lbt4/l;", "sendInvite", "Lbt4/a;", "cancelInvite", "Lbt4/i;", "Lbt4/j;", "replyInvite", "Lbt4/b;", "Lbt4/c;", "endInteraction", "Lbt4/g;", "Lbt4/h;", "refreshUserInfo", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasSquareRoomInteractionService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String METHOD_CANCEL_INVITE = "CancelInvite";
    public static final String METHOD_END_INTERACTION = "EndInteraction";
    public static final String METHOD_GET_MOTION_LIST = "GetMotionList";
    public static final String METHOD_REFRESH_USER_INFO = "RefreshUserInfo";
    public static final String METHOD_REPLY_INVITE = "ReplyInvite";
    public static final String METHOD_SEND_INVITE = "SendInvite";
    public static final String SERVICE = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/template/service/IVasSquareRoomInteractionService$Companion;", "", "()V", "METHOD_CANCEL_INVITE", "", "METHOD_END_INTERACTION", "METHOD_GET_MOTION_LIST", "METHOD_REFRESH_USER_INFO", "METHOD_REPLY_INVITE", "METHOD_SEND_INVITE", "SERVICE", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String METHOD_CANCEL_INVITE = "CancelInvite";
        public static final String METHOD_END_INTERACTION = "EndInteraction";
        public static final String METHOD_GET_MOTION_LIST = "GetMotionList";
        public static final String METHOD_REFRESH_USER_INFO = "RefreshUserInfo";
        public static final String METHOD_REPLY_INVITE = "ReplyInvite";
        public static final String METHOD_SEND_INVITE = "SendInvite";
        public static final String SERVICE = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr";

        Companion() {
        }
    }

    @Route(method = "CancelInvite", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<Object> cancelInvite(bt4.a req, int source);

    @Route(method = "EndInteraction", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<c> endInteraction(b req, int source);

    @Route(method = "GetMotionList", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<e> getMotionList(d req, int source);

    @Route(method = "RefreshUserInfo", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<h> refreshUserInfo(g req, int source);

    @Route(method = "ReplyInvite", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<j> replyInvite(i req, int source);

    @Route(method = "SendInvite", service = "trpc.qmeta.room_interaction_svr.RoomInteractionSvr")
    a<l> sendInvite(k req, int source);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ a cancelInvite$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, bt4.a aVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.cancelInvite(aVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelInvite");
        }

        public static /* synthetic */ a endInteraction$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, b bVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.endInteraction(bVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endInteraction");
        }

        public static /* synthetic */ a getMotionList$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, d dVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.getMotionList(dVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMotionList");
        }

        public static /* synthetic */ a refreshUserInfo$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, g gVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.refreshUserInfo(gVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshUserInfo");
        }

        public static /* synthetic */ a replyInvite$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, i iVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.replyInvite(iVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replyInvite");
        }

        public static /* synthetic */ a sendInvite$default(IVasSquareRoomInteractionService iVasSquareRoomInteractionService, k kVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasSquareRoomInteractionService.sendInvite(kVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendInvite");
        }
    }
}
