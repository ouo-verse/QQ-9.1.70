package com.tencent.mobileqq.qqguildsdk.wrapper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVRoomOptPushInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProScreenShareUserData;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserChannelStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVChannelConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildListSortInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateRspInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchedulePollingInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface hn {
    void A(String str, com.tencent.mobileqq.qqguildsdk.data.bg bgVar);

    void A0(String str, String str2, String str3, String str4, int i3, String str5, int i16);

    void B(String str, String str2, int i3, List<String> list);

    void B0(int i3, GProGuildInfo gProGuildInfo, boolean z16);

    void C(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void C0(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void D(String str, GProGuildInfo gProGuildInfo);

    void D0(List<String> list, List<com.tencent.mobileqq.qqguildsdk.data.fc> list2);

    void E(String str, String str2);

    void E0(String str, List<GProGuildRoleInfo> list);

    void F(String str, List<String> list);

    void F0(String str, String str2, List<Object> list, int i3);

    void G(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void G0();

    void H(int i3, String str, int i16, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list);

    void H0();

    void I(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo);

    void I0(String str, com.tencent.mobileqq.qqguildsdk.data.ck ckVar);

    void J(int i3, long j3, int i16);

    void J0(String str, String str2, int i3);

    void K(int i3, byte[] bArr);

    void K0(GGProAVRoomOptPushInfo gGProAVRoomOptPushInfo);

    void L(String str, String str2, String str3, int i3, String str4);

    void L0(String str, String str2);

    void M(String str, String str2, com.tencent.mobileqq.qqguildsdk.data.ck ckVar);

    void M0(String str, String str2, GProGuildRoleInfo gProGuildRoleInfo);

    void N(String str, String str2, int i3, int i16);

    void O(String str, String str2, boolean z16);

    void P(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void Q(String str);

    void R(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void S(int i3, String str, IGProHeartbeatRsq iGProHeartbeatRsq);

    void T(String str, String str2, boolean z16, long j3);

    void U(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo);

    void V(String str);

    void W(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void X(int i3, String str);

    void Y(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void Z(String str, GProGuildInfo gProGuildInfo, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list);

    void a(HashSet<String> hashSet);

    void a0(String str, String str2, int i3);

    void b(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void b0();

    void c(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void c0(GGProVoiceSmobaGameRoomManageSysMsg gGProVoiceSmobaGameRoomManageSysMsg);

    void d(String str, String str2, String str3, int i3);

    void d0(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void e(int i3, String str, String str2, String str3, com.tencent.mobileqq.qqguildsdk.data.cf cfVar);

    void e0(int i3, GProChannelInfo gProChannelInfo);

    void f(com.tencent.mobileqq.qqguildsdk.data.o oVar);

    void f0(String str, String str2, GProAVChannelConfig gProAVChannelConfig);

    void g(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void g0(String str, boolean z16, boolean z17, boolean z18, long j3);

    void h(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void h0(String str, String str2, boolean z16, long j3);

    void i(GProSchedulePollingInfo gProSchedulePollingInfo);

    void i0(ArrayList<String> arrayList, String str);

    void j(String str, String str2, List<GProScreenShareUserData> list, String str3);

    void j0(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void k(String str, String str2, String str3, IGuildSchemaConfig iGuildSchemaConfig);

    void k0(com.tencent.mobileqq.qqguildsdk.data.ch chVar);

    void l(String str, String str2, int i3, int i16, String str3);

    void l0(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void m(int i3, String str, boolean z16, ArrayList<String> arrayList, ArrayList<GProGuildInfo> arrayList2, GProGuildListSortInfo gProGuildListSortInfo);

    void m0(String str, String str2);

    void n(String str, List<IGProRoleMemberChange> list);

    void n0(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void o(String str, String str2);

    void o0(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo);

    void p(String str, GProGuildInfo gProGuildInfo, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list, String str2, int i3);

    void p0(int i3);

    void q(String str, String str2, String str3, String str4);

    void q0(String str, long j3);

    void r(String str);

    void r0(String str, String str2, int i3);

    void s(GProUserChannelStateInfo gProUserChannelStateInfo);

    void s0(GProSecurityInfo gProSecurityInfo);

    void t(com.tencent.mobileqq.qqguildsdk.data.fb fbVar);

    void t0(String str, String str2, String str3, int i3, String str4);

    void u(List<Integer> list, List<com.tencent.mobileqq.qqguildsdk.data.fl> list2);

    void u0(List<Integer> list, List<com.tencent.mobileqq.qqguildsdk.data.fk> list2);

    void v(List<com.tencent.mobileqq.qqguildsdk.state.a> list);

    void v0(String str, String str2, int i3);

    void w(List<String> list);

    void w0(String str, String str2, String str3, String str4, String str5, int i3, int i16, ILiveProgramInfo iLiveProgramInfo, long j3, ILiveRoomInfo iLiveRoomInfo);

    void x(GProGuildStateRspInfo gProGuildStateRspInfo);

    void x0(String str, List<GProGuildRoleInfo> list);

    void y(String str, String str2, boolean z16, long j3);

    void y0(String str, String str2);

    void z(List<com.tencent.mobileqq.qqguildsdk.data.bi> list);

    void z0(String str, String str2, String str3, ArrayList<IGProTopMsg> arrayList, ArrayList<IGProTopMsg> arrayList2);
}
