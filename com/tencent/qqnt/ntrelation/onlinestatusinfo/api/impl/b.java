package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/b;", "", "", "uin", "uid", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "a", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f360117a = new b();

    b() {
    }

    public final c a(String uin, String uid, Friends friend) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        c cVar = new c(null, null, 3, null);
        cVar.c1(uin);
        cVar.b1(uid);
        cVar.r0(friend != null ? friend.abilityBits : 0L);
        cVar.a1(friend != null ? friend.uExtOnlineStatus : 0L);
        cVar.K0(friend != null ? friend.iBatteryStatus : 0);
        cVar.G0(friend != null ? friend.detalStatusFlag : (byte) 0);
        cVar.O0(friend != null ? friend.netTypeIconId : 0);
        cVar.L0(friend != null ? friend.iTermType : 0);
        cVar.P0(friend != null ? friend.eNetwork : 0);
        String str28 = "";
        if (friend == null || (str = friend.customOnlineStatus) == null) {
            str = "";
        }
        cVar.E0(str);
        cVar.F0(friend != null ? friend.customOnlineStatusType : 0);
        if (friend == null || (str2 = friend.strTermDesc) == null) {
            str2 = "";
        }
        cVar.Y0(str2);
        if (friend == null || (str3 = friend.songId) == null) {
            str3 = "";
        }
        cVar.U0(str3);
        if (friend == null || (str4 = friend.songName) == null) {
            str4 = "";
        }
        cVar.V0(str4);
        if (friend == null || (str5 = friend.singerName) == null) {
            str5 = "";
        }
        cVar.R0(str5);
        cVar.T0(friend != null ? friend.songEndTime : 0L);
        cVar.X0(friend != null ? friend.songSourceType : 0);
        cVar.W0(friend != null ? friend.songPauseRemainTime : 0);
        cVar.S0(friend != null ? friend.songDuration : 0);
        if (friend == null || (str6 = friend.temper) == null) {
            str6 = "";
        }
        cVar.Z0(str6);
        if (friend == null || (str7 = friend.weatherType) == null) {
            str7 = "";
        }
        cVar.l1(str7);
        if (friend == null || (str8 = friend.weatherTypeId) == null) {
            str8 = "";
        }
        cVar.m1(str8);
        if (friend == null || (str9 = friend.weatherTip) == null) {
            str9 = "";
        }
        cVar.k1(str9);
        if (friend == null || (str10 = friend.adCode) == null) {
            str10 = "";
        }
        cVar.s0(str10);
        cVar.n1(friend != null ? friend.weatherUpdateTime : 0L);
        if (friend == null || (str11 = friend.city) == null) {
            str11 = "";
        }
        cVar.u0(str11);
        if (friend == null || (str12 = friend.weatherDecs) == null) {
            str12 = "";
        }
        cVar.g1(str12);
        cVar.h1(friend != null ? friend.weatherFlag : 0);
        if (friend == null || (str13 = friend.area) == null) {
            str13 = "";
        }
        cVar.t0(str13);
        if (friend == null || (str14 = friend.weatherIconKey) == null) {
            str14 = "";
        }
        cVar.i1(str14);
        if (friend == null || (str15 = friend.weatherPrompt) == null) {
            str15 = "";
        }
        cVar.j1(str15);
        if (friend == null || (str16 = friend.constellationTodayTrend) == null) {
            str16 = "";
        }
        cVar.B0(str16);
        if (friend == null || (str17 = friend.constellationTomorrowTrend) == null) {
            str17 = "";
        }
        cVar.C0(str17);
        if (friend == null || (str18 = friend.constellationBgImageUrl) == null) {
            str18 = "";
        }
        cVar.v0(str18);
        if (friend == null || (str19 = friend.constellationIconUrl) == null) {
            str19 = "";
        }
        cVar.x0(str19);
        if (friend == null || (str20 = friend.constellationJumpUrl) == null) {
            str20 = "";
        }
        cVar.y0(str20);
        if (friend == null || (str21 = friend.constellationDateStr) == null) {
            str21 = "";
        }
        cVar.w0(str21);
        if (friend == null || (str22 = friend.constellationLuckyColor) == null) {
            str22 = "";
        }
        cVar.z0(str22);
        if (friend == null || (str23 = friend.constellationLuckyNumber) == null) {
            str23 = "";
        }
        cVar.A0(str23);
        cVar.J0(friend != null ? friend.diyEmoType : 0);
        cVar.I0(friend != null ? friend.diyEmoSeverId : 0L);
        if (friend == null || (str24 = friend.diyDesc) == null) {
            str24 = "";
        }
        cVar.H0(str24);
        if (friend == null || (str25 = friend.videoId) == null) {
            str25 = "";
        }
        cVar.d1(str25);
        if (friend == null || (str26 = friend.videoName) == null) {
            str26 = "";
        }
        cVar.e1(str26);
        if (friend != null && (str27 = friend.videoUrl) != null) {
            str28 = str27;
        }
        cVar.f1(str28);
        cVar.D0(friend != null ? friend.curOlympicRank : -1L);
        cVar.N0(friend != null ? friend.lastLoginType : 0L);
        cVar.M0(friend != null ? friend.showLoginClient : 0L);
        cVar.Q0(friend != null ? friend.onlineStatusUpdateTime : 0L);
        return cVar;
    }
}
