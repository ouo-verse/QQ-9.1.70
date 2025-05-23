package com.tencent.state.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import vs4.b;
import vs4.c;
import vs4.d;
import vs4.e;
import vs4.g;
import vs4.h;
import vs4.i;
import vs4.j;
import vs4.k;
import vs4.l;
import vs4.m;
import vs4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\tH'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000fH'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\u0012H'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u0015H'\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/service/IVasMultiMotionInviteService;", "", "Lvs4/m;", "req", "Lcom/tencent/rapier/a;", "Lvs4/n;", "sendInviteArk", "Lvs4/a;", "acceptInvite", "Lvs4/i;", "Lvs4/j;", "getInviteStatus", "Lvs4/g;", "Lvs4/h;", "getInviteDetail", "Lvs4/d;", "Lvs4/e;", "endMultiMotion", "Lvs4/k;", "Lvs4/l;", "resetUserInvite", "Lvs4/b;", "Lvs4/c;", "checkInvitePermission", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasMultiMotionInviteService {
    @Route(method = "AcceptInvite", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<Object> acceptInvite(vs4.a req);

    @Route(method = "CheckInvitePermission", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<c> checkInvitePermission(b req);

    @Route(method = "EndInvite", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<e> endMultiMotion(d req);

    @Route(method = "GetInviteDetail", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<h> getInviteDetail(g req);

    @Route(method = "GetInviteStatus", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<j> getInviteStatus(i req);

    @Route(method = "ResetUserInvite", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<l> resetUserInvite(k req);

    @Route(method = "SendInvite", service = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr")
    a<n> sendInviteArk(m req);
}
