package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.genc.dt;
import com.tencent.mobileqq.qqguildsdk.data.genc.du;
import com.tencent.mobileqq.qqguildsdk.data.genc.dw;
import com.tencent.mobileqq.qqguildsdk.data.genc.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.dy;
import com.tencent.mobileqq.qqguildsdk.data.genc.ee;
import com.tencent.mobileqq.qqguildsdk.data.genc.ef;
import com.tencent.mobileqq.qqguildsdk.data.genc.eg;
import com.tencent.mobileqq.qqguildsdk.data.genc.eh;
import com.tencent.mobileqq.qqguildsdk.data.genc.ei;
import com.tencent.mobileqq.qqguildsdk.data.genc.ej;
import com.tencent.mobileqq.qqguildsdk.data.genc.ek;
import com.tencent.mobileqq.qqguildsdk.data.genc.en;
import com.tencent.mobileqq.qqguildsdk.data.genc.ep;
import com.tencent.mobileqq.qqguildsdk.data.genc.eq;
import com.tencent.mobileqq.qqguildsdk.data.genc.es;
import com.tencent.mobileqq.qqguildsdk.data.genc.et;
import com.tencent.mobileqq.qqguildsdk.data.genc.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.ew;
import com.tencent.mobileqq.qqguildsdk.data.genc.ex;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qqguildsdk.data.genc.fa;
import com.tencent.mobileqq.qqguildsdk.data.genc.fb;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.data.genc.fe;
import com.tencent.mobileqq.qqguildsdk.data.genc.fg;
import com.tencent.mobileqq.qqguildsdk.data.genc.fh;
import com.tencent.mobileqq.qqguildsdk.data.genc.fi;
import com.tencent.mobileqq.qqguildsdk.data.genc.fj;
import com.tencent.mobileqq.qqguildsdk.data.genc.fk;
import com.tencent.mobileqq.qqguildsdk.data.genc.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.fm;
import com.tencent.mobileqq.qqguildsdk.data.genc.fn;
import com.tencent.mobileqq.qqguildsdk.data.genc.fo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportTarget;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import wh2.Cdo;
import wh2.ds;
import wh2.dv;
import wh2.dz;
import wh2.ea;
import wh2.eb;
import wh2.ec;
import wh2.ed;
import wh2.el;
import wh2.em;
import wh2.eo;
import wh2.er;
import wh2.eu;
import wh2.ez;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cb extends bv {
    public void addGuilds(ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.da> arrayList, ep epVar, wh2.dm dmVar) {
        if (isRun()) {
            this.mEngine.N0(arrayList, epVar, dmVar);
        }
    }

    public void addGuildsForGrowth(String str, ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.da> arrayList, wh2.dm dmVar) {
        if (isRun()) {
            this.mEngine.O0(str, arrayList, dmVar);
        }
    }

    public void addRecentVisitGuildsListSync(ArrayList<Long> arrayList, wh2.b bVar) {
        if (isRun()) {
            this.mEngine.P0(arrayList, bVar);
        }
    }

    public void addSpeakOrderByUser(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.Q0(fcVar, erVar);
        }
    }

    public void batchDeleteAISearchSession(com.tencent.mobileqq.qqguildsdk.data.genc.a aVar, em emVar) {
        if (isRun()) {
            this.mEngine.R0(aVar, emVar);
        }
    }

    public void batchGetGuildLabelInfo(com.tencent.mobileqq.qqguildsdk.data.genc.r rVar, wh2.e eVar) {
        if (isRun()) {
            this.mEngine.S0(rVar, eVar);
        }
    }

    public void batchGetItemDetail(com.tencent.mobileqq.qqguildsdk.data.genc.bq bqVar, wh2.cn cnVar) {
        if (isRun()) {
            this.mEngine.T0(bqVar, cnVar);
        }
    }

    public void beforehandGetGuildSpeakPermission(long j3, int i3, wh2.f fVar) {
        if (isRun()) {
            this.mEngine.U0(j3, i3, fVar);
        }
    }

    public void cancelSpeakOrderByAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.V0(oVar, cVar);
        }
    }

    public void cancelUserHandUpForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.W0(oVar, cVar);
        }
    }

    public void changeGuildAllowSearch(String str, boolean z16, dv dvVar) {
        if (isRun()) {
            this.mEngine.X0(str, z16, dvVar);
        }
    }

    public void checkAVState(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.Y0(fcVar, erVar);
        }
    }

    public void checkAndEncryptText(com.tencent.mobileqq.qqguildsdk.data.genc.ah ahVar, wh2.h hVar) {
        if (isRun()) {
            this.mEngine.Z0(ahVar, hVar);
        }
    }

    public void checkFeedAbstractInfo(com.tencent.mobileqq.qqguildsdk.data.genc.u uVar, wh2.i iVar) {
        if (isRun()) {
            this.mEngine.a1(uVar, iVar);
        }
    }

    public void checkIsStrangerNewMember(wh2.j jVar) {
        if (isRun()) {
            this.mEngine.b1(jVar);
        }
    }

    public void checkLobbyAppAuthStatus(String str, long j3, long j16, wh2.k kVar) {
        if (isRun()) {
            this.mEngine.c1(str, j3, j16, kVar);
        }
    }

    public void checkPreventAddiction(com.tencent.mobileqq.qqguildsdk.data.genc.dr drVar, wh2.dq dqVar) {
        if (isRun()) {
            this.mEngine.d1(drVar, dqVar);
        }
    }

    public void checkUserFreeGiftInfo(fe feVar, wh2.l lVar) {
        if (isRun()) {
            this.mEngine.e1(feVar, lVar);
        }
    }

    public void clearGuildRelatedData(ArrayList<Long> arrayList) {
        if (isRun()) {
            this.mEngine.f1(arrayList);
        }
    }

    public void closeAVLobbyApp(long j3, long j16, long j17, wh2.u uVar) {
        if (isRun()) {
            this.mEngine.g1(j3, j16, j17, uVar);
        }
    }

    public void closeChannelActivitySwitch(long j3, em emVar) {
        if (isRun()) {
            this.mEngine.h1(j3, emVar);
        }
    }

    public void convertGuildAndThirdIds(com.tencent.mobileqq.qqguildsdk.data.genc.ab abVar, wh2.n nVar) {
        if (isRun()) {
            this.mEngine.i1(abVar, nVar);
        }
    }

    @Nullable
    public IGProInviteInfo convertToGuildInviteInfo(com.tencent.mobileqq.qqguildsdk.data.genc.x xVar) {
        if (isRun()) {
            return this.mEngine.j1(xVar);
        }
        return null;
    }

    public void createGuild(com.tencent.mobileqq.qqguildsdk.data.genc.ac acVar, wh2.o oVar) {
        if (isRun()) {
            this.mEngine.k1(acVar, oVar);
        }
    }

    public void createScheduleV2(com.tencent.mobileqq.qqguildsdk.data.genc.ae aeVar, wh2.q qVar) {
        if (isRun()) {
            this.mEngine.l1(aeVar, qVar);
        }
    }

    public void dealHandUpRequestForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, boolean z16, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.m1(oVar, z16, cVar);
        }
    }

    public void decodeInviteJumpInfo(String str, wh2.r rVar) {
        if (isRun()) {
            this.mEngine.n1(str, rVar);
        }
    }

    @Nullable
    public IGProGetContentRecommendRsp decodeMVPFeedsRspPb(byte[] bArr) {
        if (isRun()) {
            return this.mEngine.o1(bArr);
        }
        return null;
    }

    @Nullable
    public IGProScheduleInfo decodeScheduleInfo(byte[] bArr) {
        if (isRun()) {
            return this.mEngine.p1(bArr);
        }
        return null;
    }

    public void deleteAISearchSession(com.tencent.mobileqq.qqguildsdk.data.genc.b bVar, wh2.s sVar) {
        if (isRun()) {
            this.mEngine.q1(bVar, sVar);
        }
    }

    public void deleteFeed(com.tencent.mobileqq.qqguildsdk.data.genc.af afVar, wh2.t tVar) {
        if (isRun()) {
            this.mEngine.r1(afVar, tVar);
        }
    }

    public void deleteGuildEssence(com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar, wh2.dh dhVar) {
        if (isRun()) {
            this.mEngine.s1(chVar, dhVar);
        }
    }

    public void deleteGuildGlobalBanner(com.tencent.mobileqq.qqguildsdk.data.genc.cb cbVar, wh2.dd ddVar) {
        if (isRun()) {
            this.mEngine.t1(cbVar, ddVar);
        }
    }

    public void deleteSystemNoticeMessage(et etVar, wh2.v vVar) {
        if (isRun()) {
            this.mEngine.u1(etVar, vVar);
        }
    }

    public void destroyGuild(String str, dv dvVar) {
        if (isRun()) {
            this.mEngine.v1(str, dvVar);
        }
    }

    public void doGuildCheckin(com.tencent.mobileqq.qqguildsdk.data.genc.cg cgVar, wh2.dg dgVar) {
        if (isRun()) {
            this.mEngine.w1(cgVar, dgVar);
        }
    }

    public void doRealNameAuth(int i3, wh2.cv cvVar) {
        if (isRun()) {
            this.mEngine.x1(i3, cvVar);
        }
    }

    public void domainResolveByLocalDns(String str) {
        if (isRun()) {
            this.mEngine.y1(str);
        }
    }

    public void editScheduleV2(com.tencent.mobileqq.qqguildsdk.data.genc.ag agVar, wh2.w wVar) {
        if (isRun()) {
            this.mEngine.z1(agVar, wVar);
        }
    }

    public void enterAudioLiveChannel(com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar, wh2.x xVar) {
        if (isRun()) {
            this.mEngine.A1(aiVar, xVar);
        }
    }

    public void exitAudioLiveChannel(long j3, long j16, int i3, ArrayList<String> arrayList, wh2.y yVar) {
        if (isRun()) {
            this.mEngine.B1(j3, j16, i3, arrayList, yVar);
        }
    }

    public void exposeGuildTaskCard(com.tencent.mobileqq.qqguildsdk.data.genc.am amVar, em emVar) {
        if (isRun()) {
            this.mEngine.C1(amVar, emVar);
        }
    }

    public void exposeRecommends(com.tencent.mobileqq.qqguildsdk.data.genc.al alVar, em emVar) {
        if (isRun()) {
            this.mEngine.D1(alVar, emVar);
        }
    }

    public void fetchActiveChannels(String str, wh2.z zVar) {
        if (isRun()) {
            this.mEngine.E1(str, zVar);
        }
    }

    public void fetchAddGuildInfo(int i3, long j3, wh2.a aVar) {
        if (isRun()) {
            this.mEngine.F1(i3, j3, aVar);
        }
    }

    public void fetchAppInfos(String str, wh2.aa aaVar) {
        if (isRun()) {
            this.mEngine.G1(str, aaVar);
        }
    }

    public void fetchAudioLiveChannelBlockUserState(long j3, long j16, wh2.ae aeVar) {
        if (isRun()) {
            this.mEngine.H1(j3, j16, aeVar);
        }
    }

    public void fetchAudioLiveChannelGroupList(com.tencent.mobileqq.qqguildsdk.data.genc.m mVar, wh2.ac acVar) {
        if (isRun()) {
            this.mEngine.I1(mVar, acVar);
        }
    }

    public void fetchAudioLiveChannelUserList(com.tencent.mobileqq.qqguildsdk.data.genc.q qVar, wh2.ad adVar) {
        if (isRun()) {
            this.mEngine.J1(qVar, adVar);
        }
    }

    public void fetchCategoryAdminInfoList(com.tencent.mobileqq.qqguildsdk.data.genc.as asVar, wh2.af afVar) {
        if (isRun()) {
            this.mEngine.K1(asVar, afVar);
        }
    }

    public void fetchChannelAuthControlMemberList(long j3, long j16, int i3, byte[] bArr, int i16, wh2.ag agVar) {
        if (isRun()) {
            this.mEngine.L1(j3, j16, i3, bArr, i16, agVar);
        }
    }

    public void fetchChannelAuthControlRoleList(long j3, long j16, int i3, wh2.ah ahVar) {
        if (isRun()) {
            this.mEngine.M1(j3, j16, i3, ahVar);
        }
    }

    public void fetchChannelAuthControlUnableMemberList(long j3, long j16, int i3, byte[] bArr, int i16, wh2.ai aiVar) {
        if (isRun()) {
            this.mEngine.N1(j3, j16, i3, bArr, i16, aiVar);
        }
    }

    public void fetchChannelInfoWithUnreadStatus(String str, boolean z16) {
        if (isRun()) {
            this.mEngine.O1(str, z16);
        }
    }

    public void fetchChannelVisibleRoleListWithoutLevelRole(long j3, long j16, wh2.aj ajVar) {
        if (isRun()) {
            this.mEngine.P1(j3, j16, ajVar);
        }
    }

    public void fetchGlobalPrivacySwitch(wh2.de deVar) {
        if (isRun()) {
            this.mEngine.Q1(deVar);
        }
    }

    public void fetchGuestGuildInfoWithChannelList(int i3, com.tencent.mobileqq.qqguildsdk.data.genc.bl blVar, wh2.ak akVar) {
        if (isRun()) {
            this.mEngine.R1(i3, blVar, akVar);
        }
    }

    public void fetchGuildActiveLiveChannelNum(com.tencent.mobileqq.qqguildsdk.data.genc.at atVar, wh2.al alVar) {
        if (isRun()) {
            this.mEngine.S1(atVar, alVar);
        }
    }

    public void fetchGuildActiveValue(long j3, wh2.df dfVar) {
        if (isRun()) {
            this.mEngine.T1(j3, dfVar);
        }
    }

    public void fetchGuildBlackList(String str, byte[] bArr, wh2.am amVar) {
        if (isRun()) {
            this.mEngine.U1(str, bArr, amVar);
        }
    }

    public void fetchGuildBottomTabExp(com.tencent.mobileqq.qqguildsdk.data.genc.s sVar, wh2.an anVar) {
        if (isRun()) {
            this.mEngine.V1(sVar, anVar);
        }
    }

    public void fetchGuildBoundGroupsWithGroupCodes(String str, ArrayList<Long> arrayList, wh2.ao aoVar) {
        if (isRun()) {
            this.mEngine.W1(str, arrayList, aoVar);
        }
    }

    public void fetchGuildInfoAndMemberList(com.tencent.mobileqq.qqguildsdk.data.genc.cj cjVar, wh2.ap apVar) {
        if (isRun()) {
            this.mEngine.X1(cjVar, apVar);
        }
    }

    public void fetchGuildTaskCards(com.tencent.mobileqq.qqguildsdk.data.genc.p pVar, wh2.aq aqVar) {
        if (isRun()) {
            this.mEngine.Y1(pVar, aqVar);
        }
    }

    public void fetchJoinGuildOption(com.tencent.mobileqq.qqguildsdk.data.genc.au auVar, wh2.ar arVar) {
        if (isRun()) {
            this.mEngine.Z1(auVar, arVar);
        }
    }

    public void fetchJumpInfo(long j3, wh2.as asVar) {
        if (isRun()) {
            this.mEngine.a2(j3, asVar);
        }
    }

    public void fetchLevelRolePermissions(long j3, int i3, wh2.at atVar) {
        if (isRun()) {
            this.mEngine.b2(j3, i3, atVar);
        }
    }

    public void fetchMVPFeedsFromServer(com.tencent.mobileqq.qqguildsdk.data.genc.bj bjVar, wh2.au auVar) {
        if (isRun()) {
            this.mEngine.c2(bjVar, auVar);
        }
    }

    public void fetchMemberListForFeed(com.tencent.mobileqq.qqguildsdk.data.genc.ap apVar, wh2.av avVar) {
        if (isRun()) {
            this.mEngine.d2(apVar, avVar);
        }
    }

    public void fetchMyCreateGuilds(wh2.aw awVar) {
        if (isRun()) {
            this.mEngine.e2(awVar);
        }
    }

    public void fetchOnlineUsers(String str, int i3, int i16, ArrayList<Long> arrayList, wh2.ax axVar) {
        if (isRun()) {
            this.mEngine.f2(str, i3, i16, arrayList, axVar);
        }
    }

    public void fetchOtherChannelUserPermission(long j3, long j16, long j17, int i3, int i16, wh2.g gVar) {
        if (isRun()) {
            this.mEngine.g2(j3, j16, j17, i3, i16, gVar);
        }
    }

    public void fetchProfileAddFriendField(String str, String str2, wh2.ay ayVar) {
        if (isRun()) {
            this.mEngine.h2(str, str2, ayVar);
        }
    }

    public void fetchRecommendEssenceInfo(long j3, int i3, wh2.az azVar) {
        if (isRun()) {
            this.mEngine.i2(j3, i3, azVar);
        }
    }

    public void fetchRemainAtSetInfo(long j3, wh2.ab abVar) {
        if (isRun()) {
            this.mEngine.j2(j3, abVar);
        }
    }

    public void fetchRetentionGuildList(int i3, int i16, byte[] bArr, long j3, wh2.ba baVar) {
        if (isRun()) {
            this.mEngine.k2(i3, i16, bArr, j3, baVar);
        }
    }

    public void fetchRoleListWithoutLevelRoleWithFilter(long j3, int i3, int i16, wh2.bb bbVar) {
        if (isRun()) {
            this.mEngine.l2(j3, i3, i16, bbVar);
        }
    }

    public void fetchShareButtonReq(ArrayList<Long> arrayList, boolean z16, wh2.m mVar) {
        if (isRun()) {
            this.mEngine.m2(arrayList, z16, mVar);
        }
    }

    public void fetchShareInfo0x10c3(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.av avVar, wh2.bc bcVar) {
        if (isRun()) {
            this.mEngine.n2(j3, j16, avVar, bcVar);
        }
    }

    public void fetchShareUrlReq(long j3, long j16, long j17, String str, com.tencent.mobileqq.qqguildsdk.data.genc.aw awVar, ArrayList<ey> arrayList, wh2.bd bdVar) {
        if (isRun()) {
            this.mEngine.o2(j3, j16, j17, str, awVar, arrayList, bdVar);
        }
    }

    public void fetchSpecifiedTypeChannelsOpenState(long j3, ArrayList<Integer> arrayList, int i3, wh2.be beVar) {
        if (isRun()) {
            this.mEngine.p2(j3, arrayList, i3, beVar);
        }
    }

    public void fetchSubscribeUserGuide(wh2.bf bfVar) {
        if (isRun()) {
            this.mEngine.q2(bfVar);
        }
    }

    public void fetchUserJoinedGuildListV2(com.tencent.mobileqq.qqguildsdk.data.genc.ax axVar, wh2.bg bgVar) {
        if (isRun()) {
            this.mEngine.r2(axVar, bgVar);
        }
    }

    public void fetchVersionNews(wh2.bh bhVar) {
        if (isRun()) {
            this.mEngine.s2(bhVar);
        }
    }

    public void fetchXWordInfo(long j3, wh2.ey eyVar) {
        if (isRun()) {
            this.mEngine.t2(j3, eyVar);
        }
    }

    public void getAISearchRecommendWords(wh2.bi biVar) {
        if (isRun()) {
            this.mEngine.u2(biVar);
        }
    }

    public void getAISearchSessionList(com.tencent.mobileqq.qqguildsdk.data.genc.c cVar, boolean z16, wh2.bj bjVar) {
        if (isRun()) {
            this.mEngine.v2(cVar, z16, bjVar);
        }
    }

    public void getAISearchSessionMsgList(com.tencent.mobileqq.qqguildsdk.data.genc.d dVar, boolean z16, wh2.bk bkVar) {
        if (isRun()) {
            this.mEngine.w2(dVar, z16, bkVar);
        }
    }

    public void getAISearchShareURL(com.tencent.mobileqq.qqguildsdk.data.genc.az azVar, wh2.bl blVar) {
        if (isRun()) {
            this.mEngine.x2(azVar, blVar);
        }
    }

    public void getActiveLiveAudioChannelNum(long j3, wh2.bm bmVar) {
        if (isRun()) {
            this.mEngine.y2(j3, bmVar);
        }
    }

    public void getAllGuildSearchAIInfo(com.tencent.mobileqq.qqguildsdk.data.genc.co coVar, wh2.bn bnVar) {
        if (isRun()) {
            this.mEngine.z2(coVar, bnVar);
        }
    }

    @Nullable
    public IGProGuildUserState getAlreadyEnteredChannel() {
        if (isRun()) {
            return this.mEngine.A2();
        }
        return null;
    }

    @Nullable
    public IGProAppChnnPreInfo getAppChannelPreInfo(String str, String str2) {
        if (isRun()) {
            return this.mEngine.B2(str, str2);
        }
        return null;
    }

    @Nullable
    public ArrayList<IGProAppChnnPreInfo> getAppChannelPreInfos(String str) {
        if (isRun()) {
            return this.mEngine.C2(str);
        }
        return null;
    }

    @Nullable
    public ArrayList<IGProAppInfo> getAppInfos() {
        if (isRun()) {
            return this.mEngine.D2();
        }
        return null;
    }

    public void getBanners(com.tencent.mobileqq.qqguildsdk.data.genc.ba baVar, wh2.bo boVar) {
        if (isRun()) {
            this.mEngine.E2(baVar, boVar);
        }
    }

    public void getBindingGroupInfos(ArrayList<Long> arrayList, wh2.bp bpVar) {
        if (isRun()) {
            this.mEngine.F2(arrayList, bpVar);
        }
    }

    public void getBlockRecGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.bb bbVar, wh2.bq bqVar) {
        if (isRun()) {
            this.mEngine.G2(bbVar, bqVar);
        }
    }

    @Nullable
    public ArrayList<IGProCategoryChannelIdList> getCategoryChannelIdList(long j3) {
        if (isRun()) {
            return this.mEngine.H2(j3);
        }
        return null;
    }

    @Nullable
    public ArrayList<IGProCategoryChannelIdList> getCategoryChannelIdListExcludeCategoryType(long j3, ArrayList<Integer> arrayList) {
        if (isRun()) {
            return this.mEngine.I2(j3, arrayList);
        }
        return null;
    }

    @Nullable
    public ArrayList<IGProCategoryChannelInfoList> getCategoryChannelInfoListByCategoryType(long j3, ArrayList<Integer> arrayList) {
        if (isRun()) {
            return this.mEngine.J2(j3, arrayList);
        }
        return null;
    }

    public void getCategoryChannelInfoListByFilter(com.tencent.mobileqq.qqguildsdk.data.genc.bc bcVar, wh2.br brVar) {
        if (isRun()) {
            this.mEngine.K2(bcVar, brVar);
        }
    }

    public void getCategoryChannelInfoListV2(com.tencent.mobileqq.qqguildsdk.data.genc.bd bdVar, wh2.br brVar) {
        if (isRun()) {
            this.mEngine.L2(bdVar, brVar);
        }
    }

    public void getCategoryGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.be beVar, wh2.bs bsVar) {
        if (isRun()) {
            this.mEngine.M2(beVar, bsVar);
        }
    }

    public void getCategoryPageGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.bf bfVar, wh2.bt btVar) {
        if (isRun()) {
            this.mEngine.N2(bfVar, btVar);
        }
    }

    public void getCategoryTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bg bgVar, wh2.bu buVar) {
        if (isRun()) {
            this.mEngine.O2(bgVar, buVar);
        }
    }

    public void getChannelActivity(com.tencent.mobileqq.qqguildsdk.data.genc.bh bhVar, wh2.bv bvVar) {
        if (isRun()) {
            this.mEngine.P2(bhVar, bvVar);
        }
    }

    public void getConfigTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bi biVar, wh2.bw bwVar) {
        if (isRun()) {
            this.mEngine.Q2(biVar, bwVar);
        }
    }

    public void getCurrPlaySong(long j3, long j16, wh2.bx bxVar) {
        if (isRun()) {
            this.mEngine.R2(j3, j16, bxVar);
        }
    }

    public void getFriendsInGuild(com.tencent.mobileqq.qqguildsdk.data.genc.bm bmVar, wh2.bz bzVar) {
        if (isRun()) {
            this.mEngine.S2(bmVar, bzVar);
        }
    }

    public void getFriendsRecommend(com.tencent.mobileqq.qqguildsdk.data.genc.bk bkVar, wh2.ca caVar) {
        if (isRun()) {
            this.mEngine.T2(bkVar, caVar);
        }
    }

    public void getGuidePageInfo(long j3, String str, wh2.cb cbVar) {
        if (isRun()) {
            this.mEngine.U2(j3, str, cbVar);
        }
    }

    public void getGuildBindableGroups(wh2.cc ccVar) {
        if (isRun()) {
            this.mEngine.V2(ccVar);
        }
    }

    public void getGuildBindingInfo(long j3, wh2.cd cdVar) {
        if (isRun()) {
            this.mEngine.W2(j3, cdVar);
        }
    }

    public void getGuildBoundGroupsFirstPage(String str, int i3, wh2.ce ceVar) {
        if (isRun()) {
            this.mEngine.X2(str, i3, ceVar);
        }
    }

    public void getGuildCheckinInfo(com.tencent.mobileqq.qqguildsdk.data.genc.cg cgVar, wh2.dg dgVar) {
        if (isRun()) {
            this.mEngine.Y2(cgVar, dgVar);
        }
    }

    public void getGuildCreatorTasks(String str, boolean z16, wh2.cf cfVar) {
        if (isRun()) {
            this.mEngine.Z2(str, z16, cfVar);
        }
    }

    public void getGuildFeedsValidCalendar(com.tencent.mobileqq.qqguildsdk.data.genc.cp cpVar, wh2.di diVar) {
        if (isRun()) {
            this.mEngine.a3(cpVar, diVar);
        }
    }

    @Nullable
    public IGProGlobalBanner getGuildGlobalBanner(String str) {
        if (isRun()) {
            return this.mEngine.b3(str);
        }
        return null;
    }

    public void getGuildHomeCategories(com.tencent.mobileqq.qqguildsdk.data.genc.bn bnVar, wh2.cg cgVar) {
        if (isRun()) {
            this.mEngine.c3(bnVar, cgVar);
        }
    }

    public void getGuildHomeSections(long j3, wh2.ch chVar) {
        if (isRun()) {
            this.mEngine.d3(j3, chVar);
        }
    }

    public void getGuildLableInfo(com.tencent.mobileqq.qqguildsdk.data.genc.bo boVar, wh2.ci ciVar) {
        if (isRun()) {
            this.mEngine.e3(boVar, ciVar);
        }
    }

    public void getGuildNum(long j3, wh2.cj cjVar) {
        if (isRun()) {
            this.mEngine.f3(j3, cjVar);
        }
    }

    @Nullable
    public long getGuildRoleLimit(long j3) {
        if (isRun()) {
            return this.mEngine.g3(j3);
        }
        return 0L;
    }

    @Nullable
    public String getGuildUserAvatarPendantUrl(String str) {
        if (isRun()) {
            return this.mEngine.h3(str);
        }
        return "";
    }

    @Nullable
    public String getGuildUserAvatarUrl(String str, String str2, int i3) {
        if (isRun()) {
            return this.mEngine.i3(str, str2, i3);
        }
        return "";
    }

    @Nullable
    public ArrayList<Long> getGuildUserChannelCategoryAdminList(String str, String str2) {
        if (isRun()) {
            return this.mEngine.j3(str, str2);
        }
        return null;
    }

    @Nullable
    public IGProClientIdentity getGuildUserClientIdentity(String str, String str2) {
        if (isRun()) {
            return this.mEngine.k3(str, str2);
        }
        return null;
    }

    @Nullable
    public String getGuildUserDisplayName(String str, String str2) {
        if (isRun()) {
            return this.mEngine.l3(str, str2);
        }
        return "";
    }

    @Nullable
    public int getGuildUserLevelRoleId(String str, String str2) {
        if (isRun()) {
            return this.mEngine.m3(str, str2);
        }
        return 0;
    }

    @Nullable
    public IGProMedal getGuildUserMedal(String str) {
        if (isRun()) {
            return this.mEngine.n3(str);
        }
        return null;
    }

    @Nullable
    public String getGuildUserMemberName(String str, String str2) {
        if (isRun()) {
            return this.mEngine.o3(str, str2);
        }
        return "";
    }

    @Nullable
    public String getGuildUserNickname(String str) {
        if (isRun()) {
            return this.mEngine.p3(str);
        }
        return "";
    }

    @Nullable
    public long getGuildUserTopRoleId(String str, String str2) {
        if (isRun()) {
            return this.mEngine.q3(str, str2);
        }
        return 0L;
    }

    public void getGuildVerifyShareInfo(fg fgVar, ez ezVar) {
        if (isRun()) {
            this.mEngine.r3(fgVar, ezVar);
        }
    }

    public void getGuildsInContact(wh2.ck ckVar) {
        if (isRun()) {
            this.mEngine.s3(ckVar);
        }
    }

    public void getHotLive(com.tencent.mobileqq.qqguildsdk.data.genc.bp bpVar, wh2.cl clVar) {
        if (isRun()) {
            this.mEngine.t3(bpVar, clVar);
        }
    }

    public void getHotSearchWords(ArrayList<Integer> arrayList, int i3, wh2.cm cmVar) {
        if (isRun()) {
            this.mEngine.u3(arrayList, i3, cmVar);
        }
    }

    @Nullable
    public IGProJumpToCategoryInfo getJumpToCategory(String str) {
        if (isRun()) {
            return this.mEngine.v3(str);
        }
        return null;
    }

    public void getLabelGuilds(fo foVar, wh2.co coVar) {
        if (isRun()) {
            this.mEngine.w3(foVar, coVar);
        }
    }

    @Nullable
    public IGProGuildRoleInfo getMemberLevelRoleInfo(long j3, long j16, long j17) {
        if (isRun()) {
            return this.mEngine.x3(j3, j16, j17);
        }
        return null;
    }

    @Nullable
    public IGProGuildRoleInfo getMemberTopRoleInfo(long j3, long j16, long j17, long j18, int i3) {
        if (isRun()) {
            return this.mEngine.y3(j3, j16, j17, j18, i3);
        }
        return null;
    }

    public void getMyTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.br brVar, wh2.cp cpVar) {
        if (isRun()) {
            this.mEngine.z3(brVar, cpVar);
        }
    }

    public void getNavigationStatus(com.tencent.mobileqq.qqguildsdk.data.genc.bs bsVar, wh2.cq cqVar) {
        if (isRun()) {
            this.mEngine.A3(bsVar, cqVar);
        }
    }

    public void getOpenShareInfo(fp fpVar, wh2.cr crVar) {
        if (isRun()) {
            this.mEngine.B3(fpVar, crVar);
        }
    }

    @Nullable
    public ArrayList<IGProPersonalSignatureTemplate> getPersonalSignatureTemplate() {
        if (isRun()) {
            return this.mEngine.C3();
        }
        return null;
    }

    public void getPopupInfo(long j3, int i3, wh2.cs csVar) {
        if (isRun()) {
            this.mEngine.D3(j3, i3, csVar);
        }
    }

    public void getPreviewNavigation(com.tencent.mobileqq.qqguildsdk.data.genc.bt btVar, wh2.ct ctVar) {
        if (isRun()) {
            this.mEngine.E3(btVar, ctVar);
        }
    }

    public void getProfileSwitch(wh2.cu cuVar) {
        if (isRun()) {
            this.mEngine.F3(cuVar);
        }
    }

    @Nullable
    public ArrayList<IGProQQMsgListGuild> getQQMsgListGuilds() {
        if (isRun()) {
            return this.mEngine.G3();
        }
        return null;
    }

    @Nullable
    public IGProGetRecentVisitGuildInfosFromCacheRsp getRecentVisitGuildInfosListSync(int i3, int i16) {
        if (isRun()) {
            return this.mEngine.H3(i3, i16);
        }
        return null;
    }

    public void getRecommendQuickJoin(com.tencent.mobileqq.qqguildsdk.data.genc.bu buVar, wh2.cw cwVar) {
        if (isRun()) {
            this.mEngine.I3(buVar, cwVar);
        }
    }

    public void getRecommendTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bv bvVar, wh2.cx cxVar) {
        if (isRun()) {
            this.mEngine.J3(bvVar, cxVar);
        }
    }

    public void getRecommendTagList(com.tencent.mobileqq.qqguildsdk.data.genc.bw bwVar, wh2.cy cyVar) {
        if (isRun()) {
            this.mEngine.K3(bwVar, cyVar);
        }
    }

    public void getRiskMemberRedPoint(com.tencent.mobileqq.qqguildsdk.data.genc.bx bxVar, wh2.cz czVar) {
        if (isRun()) {
            this.mEngine.L3(bxVar, czVar);
        }
    }

    @Nullable
    public IGProGuildRoleInfo getRoleInfo(long j3, long j16) {
        if (isRun()) {
            return this.mEngine.M3(j3, j16);
        }
        return null;
    }

    @Nullable
    public ArrayList<Integer> getRolePermission(long j3, long j16) {
        if (isRun()) {
            return this.mEngine.N3(j3, j16);
        }
        return null;
    }

    public void getSelectChannelIDs(com.tencent.mobileqq.qqguildsdk.data.genc.bz bzVar, wh2.da daVar) {
        if (isRun()) {
            this.mEngine.O3(bzVar, daVar);
        }
    }

    @Nullable
    public int getSelfLiveChannelBanStatus(String str, String str2) {
        if (isRun()) {
            return this.mEngine.P3(str, str2);
        }
        return 0;
    }

    @Nullable
    public int getShareButtonFromCache(long j3, long j16, boolean z16) {
        if (isRun()) {
            return this.mEngine.Q3(j3, j16, z16);
        }
        return 0;
    }

    @Nullable
    public IGProSimpleProfile getSimpleProfile(String str, String str2, int i3) {
        if (isRun()) {
            return this.mEngine.R3(str, str2, i3);
        }
        return null;
    }

    public void getSimpleProfileAsync(com.tencent.mobileqq.qqguildsdk.data.genc.ca caVar, wh2.db dbVar) {
        if (isRun()) {
            this.mEngine.S3(caVar, dbVar);
        }
    }

    @Nullable
    public ArrayList<Long> getSortedGuildIdsFromCache() {
        if (isRun()) {
            return this.mEngine.T3();
        }
        return null;
    }

    public void inviteJoinSingleGuild(com.tencent.mobileqq.qqguildsdk.data.genc.z zVar, wh2.dl dlVar) {
        if (isRun()) {
            this.mEngine.U3(zVar, dlVar);
        }
    }

    public void inviteUserHandUpForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.V3(oVar, cVar);
        }
    }

    public void inviteUserQueueForAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.W3(oVar, cVar);
        }
    }

    @Nullable
    public boolean isGuildMember(String str) {
        if (isRun()) {
            return this.mEngine.X3(str);
        }
        return false;
    }

    @Nullable
    public boolean isQQMsgListGuild(long j3) {
        if (isRun()) {
            return this.mEngine.Y3(j3);
        }
        return false;
    }

    @Nullable
    public boolean isQQMsgListReady() {
        if (isRun()) {
            return this.mEngine.Z3();
        }
        return false;
    }

    public void joinChannelByGuildTask(com.tencent.mobileqq.qqguildsdk.data.genc.cu cuVar, wh2.dk dkVar) {
        if (isRun()) {
            this.mEngine.a4(cuVar, dkVar);
        }
    }

    public void loadPartRoleMemberList(long j3, wh2.dc dcVar) {
        if (isRun()) {
            this.mEngine.b4(j3, dcVar);
        }
    }

    public void modifyScheduleInviteStatusV2(com.tencent.mobileqq.qqguildsdk.data.genc.di diVar, Cdo cdo) {
        if (isRun()) {
            this.mEngine.c4(diVar, cdo);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.impl.bv, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        super.onCreate(appRuntime);
    }

    public void openAVLobbyApp(com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar, wh2.p pVar) {
        if (isRun()) {
            this.mEngine.d4(adVar, pVar);
        }
    }

    public void queryAVState(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.e4(fcVar, erVar);
        }
    }

    public void queryApplyAddGuildStatus(String str, dv dvVar) {
        if (isRun()) {
            this.mEngine.f4(str, dvVar);
        }
    }

    public void queryGuildEssence(com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar, wh2.dh dhVar) {
        if (isRun()) {
            this.mEngine.g4(chVar, dhVar);
        }
    }

    public void queryGuildVisitor(com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar, wh2.dh dhVar) {
        if (isRun()) {
            this.mEngine.h4(chVar, dhVar);
        }
    }

    public void refreshAppChannelPreInfos(String str, boolean z16, em emVar) {
        if (isRun()) {
            this.mEngine.i4(str, z16, emVar);
        }
    }

    public void removeGuild(String str, dv dvVar) {
        if (isRun()) {
            this.mEngine.j4(str, dvVar);
        }
    }

    @Nullable
    public boolean removeGuildGlobalBanner(String str) {
        if (isRun()) {
            return this.mEngine.k4(str);
        }
        return false;
    }

    public void removeGuildTaskCard(dt dtVar, em emVar) {
        if (isRun()) {
            this.mEngine.l4(dtVar, emVar);
        }
    }

    public void removeRiskMembers(du duVar, wh2.dr drVar) {
        if (isRun()) {
            this.mEngine.m4(duVar, drVar);
        }
    }

    public void removeSpeakOrderByUser(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.n4(fcVar, erVar);
        }
    }

    public void reportAISearchRecommendWords(com.tencent.mobileqq.qqguildsdk.data.genc.i iVar, em emVar) {
        if (isRun()) {
            this.mEngine.o4(iVar, emVar);
        }
    }

    public void reportAVState(com.tencent.mobileqq.qqguildsdk.data.genc.n nVar, er erVar) {
        if (isRun()) {
            this.mEngine.p4(nVar, erVar);
        }
    }

    public void reportCurrentGuild(long j3) {
        if (isRun()) {
            this.mEngine.q4(j3);
        }
    }

    public void reportFeedShareData(String str, String str2, int i3, com.tencent.mobileqq.qqguildsdk.data.genc.aq aqVar, int i16, GProReportTarget gProReportTarget, ds dsVar) {
        if (isRun()) {
            this.mEngine.r4(str, str2, i3, aqVar, i16, gProReportTarget, dsVar);
        }
    }

    public void reportFeedback(com.tencent.mobileqq.qqguildsdk.data.genc.ar arVar, em emVar) {
        if (isRun()) {
            this.mEngine.s4(arVar, emVar);
        }
    }

    public void reportJoinRecommendGuild(wh2.dt dtVar) {
        if (isRun()) {
            this.mEngine.t4(dtVar);
        }
    }

    public void reportPreventAddictionInstructions(com.tencent.mobileqq.qqguildsdk.data.genc.dq dqVar, wh2.dp dpVar) {
        if (isRun()) {
            this.mEngine.u4(dqVar, dpVar);
        }
    }

    public void reportShareAtta(com.tencent.mobileqq.qqguildsdk.data.genc.dv dvVar, em emVar) {
        if (isRun()) {
            this.mEngine.v4(dvVar, emVar);
        }
    }

    public void reportUserViewGuild(ArrayList<String> arrayList, String str, String str2, int i3, em emVar) {
        if (isRun()) {
            this.mEngine.w4(arrayList, str, str2, i3, emVar);
        }
    }

    public void requestPubAccountMsgCount(wh2.du duVar) {
        if (isRun()) {
            this.mEngine.x4(duVar);
        }
    }

    public void riskMemberList(dw dwVar, wh2.dw dwVar2) {
        if (isRun()) {
            this.mEngine.y4(dwVar, dwVar2);
        }
    }

    public void saveCustomApplication(dx dxVar, wh2.dx dxVar2) {
        if (isRun()) {
            this.mEngine.z4(dxVar, dxVar2);
        }
    }

    public void saveGuidNavigation(dy dyVar, wh2.dy dyVar2) {
        if (isRun()) {
            this.mEngine.A4(dyVar, dyVar2);
        }
    }

    public void searchBlackUserFromServer(ee eeVar, dz dzVar) {
        if (isRun()) {
            this.mEngine.B4(eeVar, dzVar);
        }
    }

    public void searchChannelContent(String str, String str2, String str3, byte[] bArr, eh ehVar, ef efVar, ea eaVar) {
        if (isRun()) {
            this.mEngine.C4(str, str2, str3, bArr, ehVar, efVar, eaVar);
        }
    }

    public void searchGuild(String str, byte[] bArr, int i3, int i16, int i17, eb ebVar) {
        if (isRun()) {
            this.mEngine.D4(str, bArr, i3, i16, i17, ebVar);
        }
    }

    public void searchGuildContent(com.tencent.mobileqq.qqguildsdk.data.genc.cr crVar, wh2.dj djVar) {
        if (isRun()) {
            this.mEngine.E4(crVar, djVar);
        }
    }

    public void searchGuildFeeds(eg egVar, ea eaVar) {
        if (isRun()) {
            this.mEngine.F4(egVar, eaVar);
        }
    }

    public void searchGuildMembersBySourceId(com.tencent.mobileqq.qqguildsdk.data.genc.cl clVar, ec ecVar) {
        if (isRun()) {
            this.mEngine.G4(clVar, ecVar);
        }
    }

    public void sendAudioOrLiveNotice(ei eiVar, ed edVar) {
        if (isRun()) {
            this.mEngine.H4(eiVar, edVar);
        }
    }

    public void sendChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar) {
        if (isRun()) {
            this.mEngine.I4(cvVar);
        }
    }

    public void sendOperationSaveMsg(com.tencent.mobileqq.qqguildsdk.data.genc.dz dzVar, wh2.ee eeVar) {
        if (isRun()) {
            this.mEngine.J4(dzVar, eeVar);
        }
    }

    public void setAVChannelInviteSpeakSwitch(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.cw cwVar, em emVar) {
        if (isRun()) {
            this.mEngine.K4(j3, j16, cwVar, emVar);
        }
    }

    public void setAVChannelSpeakMode(long j3, long j16, String str, fn fnVar, el elVar) {
        if (isRun()) {
            this.mEngine.L4(j3, j16, str, fnVar, elVar);
        }
    }

    public void setAVChannelSpeakOrder(long j3, long j16, fh fhVar, em emVar) {
        if (isRun()) {
            this.mEngine.M4(j3, j16, fhVar, emVar);
        }
    }

    public void setChannelAuthControl(long j3, long j16, int i3, int i16, dv dvVar) {
        if (isRun()) {
            this.mEngine.N4(j3, j16, i3, i16, dvVar);
        }
    }

    public void setChannelAuthControlMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, dv dvVar) {
        if (isRun()) {
            this.mEngine.O4(j3, j16, arrayList, arrayList2, i3, dvVar);
        }
    }

    public void setChannelAuthControlRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, dv dvVar) {
        if (isRun()) {
            this.mEngine.P4(j3, j16, arrayList, arrayList2, i3, dvVar);
        }
    }

    public void setChannelCategoryOrder(ej ejVar, wh2.ef efVar) {
        if (isRun()) {
            this.mEngine.Q4(ejVar, efVar);
        }
    }

    public void setChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar) {
        if (isRun()) {
            this.mEngine.R4(cvVar);
        }
    }

    public void setChannelUserNumLimit(long j3, long j16, int i3, boolean z16, int i16, dv dvVar) {
        if (isRun()) {
            this.mEngine.S4(j3, j16, i3, z16, i16, dvVar);
        }
    }

    public void setEnteredChannelState(long j3, long j16, boolean z16) {
        if (isRun()) {
            this.mEngine.T4(j3, j16, z16);
        }
    }

    public void setGlobalPrivacySwitch(int i3, int i16, wh2.de deVar) {
        if (isRun()) {
            this.mEngine.U4(i3, i16, deVar);
        }
    }

    public void setGuildAuditInfo(com.tencent.mobileqq.qqguildsdk.data.genc.ce ceVar, wh2.d dVar) {
        if (isRun()) {
            this.mEngine.V4(ceVar, dVar);
        }
    }

    public void setGuildBoundGroups(en enVar, wh2.eg egVar) {
        if (isRun()) {
            this.mEngine.W4(enVar, egVar);
        }
    }

    public void setGuildCommonUnNotifyFlag(long j3, int i3, int i16, wh2.ei eiVar) {
        if (isRun()) {
            this.mEngine.X4(j3, i3, i16, eiVar);
        }
    }

    public void setGuildCreatorTaskSkipStatus(String str, em emVar) {
        if (isRun()) {
            this.mEngine.Y4(str, emVar);
        }
    }

    public void setGuildGlobalBanner(com.tencent.mobileqq.qqguildsdk.data.genc.cb cbVar, wh2.dd ddVar) {
        if (isRun()) {
            this.mEngine.Z4(cbVar, ddVar);
        }
    }

    public void setGuildGlobalPermission(ek ekVar, dv dvVar) {
        if (isRun()) {
            this.mEngine.a5(ekVar, dvVar);
        }
    }

    public void setGuildListTop(String str, int i3, int i16, wh2.eh ehVar) {
        if (isRun()) {
            this.mEngine.b5(str, i3, i16, ehVar);
        }
    }

    public void setGuildMemberName(String str, String str2, String str3, dv dvVar) {
        if (isRun()) {
            this.mEngine.c5(str, str2, str3, dvVar);
        }
    }

    public void setGuildNeedRealNameForVisitor(String str, boolean z16, em emVar) {
        if (isRun()) {
            this.mEngine.d5(str, z16, emVar);
        }
    }

    public void setGuildNumSearchSwitch(long j3, int i3, dv dvVar) {
        if (isRun()) {
            this.mEngine.e5(j3, i3, dvVar);
        }
    }

    public void setGuildQRCodeSwitch(long j3, int i3, dv dvVar) {
        if (isRun()) {
            this.mEngine.f5(j3, i3, dvVar);
        }
    }

    public void setJoinGuildOption(com.tencent.mobileqq.qqguildsdk.data.genc.el elVar, dv dvVar) {
        if (isRun()) {
            this.mEngine.g5(elVar, dvVar);
        }
    }

    public void setJumpToCategory(com.tencent.mobileqq.qqguildsdk.data.genc.de deVar, dv dvVar) {
        if (isRun()) {
            this.mEngine.h5(deVar, dvVar);
        }
    }

    public void setListenTogetherPlayOpt(long j3, long j16, int i3, wh2.dn dnVar) {
        if (isRun()) {
            this.mEngine.i5(j3, j16, i3, dnVar);
        }
    }

    public void setListenTogetherPlayVolumeByAdmin(long j3, long j16, int i3, wh2.dn dnVar) {
        if (isRun()) {
            this.mEngine.j5(j3, j16, i3, dnVar);
        }
    }

    public void setMyBirthday(short s16, short s17, short s18, em emVar) {
        if (isRun()) {
            this.mEngine.k5(s16, s17, s18, emVar);
        }
    }

    public void setMyPersonalSignature(String str, em emVar) {
        if (isRun()) {
            this.mEngine.l5(str, emVar);
        }
    }

    public void setMyProfileShowTypeSwitch(String str, int i3, int i16, em emVar) {
        if (isRun()) {
            this.mEngine.m5(str, i3, i16, emVar);
        }
    }

    public void setMyVoiceNetworkQuality(String str, String str2, int i3) {
        if (isRun()) {
            this.mEngine.n5(str, str2, i3);
        }
    }

    public void setMyVoiceSysMicStatus(String str, String str2, int i3) {
        if (isRun()) {
            this.mEngine.o5(str, str2, i3);
        }
    }

    public void setProfileSwitch(int i3, boolean z16, em emVar) {
        if (isRun()) {
            this.mEngine.p5(i3, z16, emVar);
        }
    }

    public void setQQMsgListGuild(long j3, int i3, int i16, wh2.ej ejVar) {
        if (isRun()) {
            this.mEngine.q5(j3, i3, i16, ejVar);
        }
    }

    public void setSearchSwitch(com.tencent.mobileqq.qqguildsdk.data.genc.em emVar, wh2.ek ekVar) {
        if (isRun()) {
            this.mEngine.r5(emVar, ekVar);
        }
    }

    public void setTopicSquareEntranceSwitch(long j3, boolean z16, dv dvVar) {
        if (isRun()) {
            this.mEngine.s5(j3, z16, dvVar);
        }
    }

    public void setUserPermissionInGuild(long j3, long j16, long j17, boolean z16, dv dvVar) {
        if (isRun()) {
            this.mEngine.t5(j3, j16, j17, z16, dvVar);
        }
    }

    public void setUserTypeWithUserConfigure(boolean z16, wh2.et etVar) {
        if (isRun()) {
            this.mEngine.u5(z16, etVar);
        }
    }

    public void startPollingForDiscoverState() {
        if (isRun()) {
            this.mEngine.v5();
        }
    }

    public void stopPollingForDiscoverState(boolean z16) {
        if (isRun()) {
            this.mEngine.w5(z16);
        }
    }

    public void subscribePollingSchedule(eq eqVar) {
        if (isRun()) {
            this.mEngine.x5(eqVar);
        }
    }

    public void superAdminBanUser(com.tencent.mobileqq.qqguildsdk.data.genc.er erVar, em emVar) {
        if (isRun()) {
            this.mEngine.y5(erVar, emVar);
        }
    }

    public void superAdminUnListFeed(com.tencent.mobileqq.qqguildsdk.data.genc.w wVar, wh2.en enVar) {
        if (isRun()) {
            this.mEngine.z5(wVar, enVar);
        }
    }

    public void switchAVLobbyApp(es esVar, wh2.p pVar) {
        if (isRun()) {
            this.mEngine.A5(esVar, pVar);
        }
    }

    public void topSpeakOrderByAdmin(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, wh2.c cVar) {
        if (isRun()) {
            this.mEngine.B5(oVar, cVar);
        }
    }

    public void transThirdPlatformURL(ev evVar, eo eoVar) {
        if (isRun()) {
            this.mEngine.C5(evVar, eoVar);
        }
    }

    public void transThirdVideoURL(ew ewVar, wh2.ep epVar) {
        if (isRun()) {
            this.mEngine.D5(ewVar, epVar);
        }
    }

    public void transferGuildOwner(ex exVar, em emVar) {
        if (isRun()) {
            this.mEngine.E5(exVar, emVar);
        }
    }

    public void updateAudioLiveChannelTheme(fa faVar, em emVar) {
        if (isRun()) {
            this.mEngine.F5(faVar, emVar);
        }
    }

    public void updateGuildEssence(com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar, wh2.dh dhVar) {
        if (isRun()) {
            this.mEngine.G5(chVar, dhVar);
        }
    }

    public void updateGuildTaskCardProgress(fb fbVar, em emVar) {
        if (isRun()) {
            this.mEngine.H5(fbVar, emVar);
        }
    }

    public void updateGuildVisitor(com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar, wh2.dh dhVar) {
        if (isRun()) {
            this.mEngine.I5(chVar, dhVar);
        }
    }

    public void upgradeGroupFeed(ArrayList<Long> arrayList, int i3, wh2.eq eqVar) {
        if (isRun()) {
            this.mEngine.J5(arrayList, i3, eqVar);
        }
    }

    public void userDealSpeakInvitation(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.K5(fcVar, erVar);
        }
    }

    public void userHandUp(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.L5(fcVar, erVar);
        }
    }

    public void userOnlineReport(com.tencent.mobileqq.qqguildsdk.data.genc.cn cnVar, wh2.es esVar) {
        if (isRun()) {
            this.mEngine.M5(cnVar, esVar);
        }
    }

    public void userShareScreen(fc fcVar, er erVar) {
        if (isRun()) {
            this.mEngine.N5(fcVar, erVar);
        }
    }

    public void voiceSmobaGameCreateRoom(fi fiVar, fm fmVar, eu euVar) {
        if (isRun()) {
            this.mEngine.O5(fiVar, fmVar, euVar);
        }
    }

    public void voiceSmobaGameDissmissRoom(fj fjVar, em emVar) {
        if (isRun()) {
            this.mEngine.P5(fjVar, emVar);
        }
    }

    public void voiceSmobaGameEnterRoom(long j3, int i3, long j16, long j17, wh2.ev evVar) {
        if (isRun()) {
            this.mEngine.Q5(j3, i3, j16, j17, evVar);
        }
    }

    public void voiceSmobaGameKickOutRoom(fk fkVar, wh2.ex exVar) {
        if (isRun()) {
            this.mEngine.R5(fkVar, exVar);
        }
    }

    public void voiceSmobaGameQuitRoom(fl flVar, wh2.ew ewVar) {
        if (isRun()) {
            this.mEngine.S5(flVar, ewVar);
        }
    }
}
