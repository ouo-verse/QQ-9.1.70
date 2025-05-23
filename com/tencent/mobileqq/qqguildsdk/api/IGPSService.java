package com.tencent.mobileqq.qqguildsdk.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSpeakRuleData;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.az;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.eo;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import com.tencent.mobileqq.qqguildsdk.data.fi;
import com.tencent.mobileqq.qqguildsdk.data.fj;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.genc.ab;
import com.tencent.mobileqq.qqguildsdk.data.genc.ac;
import com.tencent.mobileqq.qqguildsdk.data.genc.ae;
import com.tencent.mobileqq.qqguildsdk.data.genc.af;
import com.tencent.mobileqq.qqguildsdk.data.genc.ag;
import com.tencent.mobileqq.qqguildsdk.data.genc.ah;
import com.tencent.mobileqq.qqguildsdk.data.genc.ai;
import com.tencent.mobileqq.qqguildsdk.data.genc.al;
import com.tencent.mobileqq.qqguildsdk.data.genc.am;
import com.tencent.mobileqq.qqguildsdk.data.genc.as;
import com.tencent.mobileqq.qqguildsdk.data.genc.at;
import com.tencent.mobileqq.qqguildsdk.data.genc.bj;
import com.tencent.mobileqq.qqguildsdk.data.genc.bl;
import com.tencent.mobileqq.qqguildsdk.data.genc.bq;
import com.tencent.mobileqq.qqguildsdk.data.genc.cb;
import com.tencent.mobileqq.qqguildsdk.data.genc.cg;
import com.tencent.mobileqq.qqguildsdk.data.genc.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.mobileqq.qqguildsdk.data.genc.cp;
import com.tencent.mobileqq.qqguildsdk.data.genc.da;
import com.tencent.mobileqq.qqguildsdk.data.genc.dj;
import com.tencent.mobileqq.qqguildsdk.data.genc.dr;
import com.tencent.mobileqq.qqguildsdk.data.genc.du;
import com.tencent.mobileqq.qqguildsdk.data.genc.dw;
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
import com.tencent.mobileqq.qqguildsdk.data.genc.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.fo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fp;
import com.tencent.mobileqq.qqguildsdk.data.genc.m;
import com.tencent.mobileqq.qqguildsdk.data.genc.o;
import com.tencent.mobileqq.qqguildsdk.data.genc.r;
import com.tencent.mobileqq.qqguildsdk.data.genc.u;
import com.tencent.mobileqq.qqguildsdk.data.genc.x;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildAndChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportTarget;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import uh2.b;
import uh2.d;
import uh2.e;
import uh2.f;
import uh2.g;
import vh2.a;
import vh2.ar;
import vh2.au;
import vh2.bd;
import vh2.bg;
import vh2.bt;
import vh2.bv;
import vh2.c;
import vh2.cc;
import vh2.cd;
import vh2.ce;
import vh2.cf;
import vh2.co;
import vh2.p;
import wh2.aa;
import wh2.ad;
import wh2.aj;
import wh2.ak;
import wh2.an;
import wh2.ao;
import wh2.ap;
import wh2.aq;
import wh2.av;
import wh2.aw;
import wh2.ax;
import wh2.ay;
import wh2.ba;
import wh2.bb;
import wh2.bc;
import wh2.be;
import wh2.bf;
import wh2.bh;
import wh2.bi;
import wh2.bk;
import wh2.bm;
import wh2.bn;
import wh2.bo;
import wh2.bp;
import wh2.br;
import wh2.bs;
import wh2.bu;
import wh2.bw;
import wh2.bx;
import wh2.bz;
import wh2.ca;
import wh2.ci;
import wh2.ck;
import wh2.cl;
import wh2.cm;
import wh2.cn;
import wh2.cq;
import wh2.cr;
import wh2.cs;
import wh2.ct;
import wh2.cu;
import wh2.cv;
import wh2.cx;
import wh2.cz;
import wh2.db;
import wh2.dc;
import wh2.dd;
import wh2.de;
import wh2.df;
import wh2.dg;
import wh2.dh;
import wh2.di;
import wh2.dk;
import wh2.dl;
import wh2.dm;
import wh2.dn;
import wh2.dp;
import wh2.dq;
import wh2.ds;
import wh2.dv;
import wh2.dz;
import wh2.ea;
import wh2.eb;
import wh2.ec;
import wh2.ed;
import wh2.el;
import wh2.em;
import wh2.er;
import wh2.eu;
import wh2.h;
import wh2.i;
import wh2.j;
import wh2.k;
import wh2.l;
import wh2.n;
import wh2.q;
import wh2.s;
import wh2.t;
import wh2.v;
import wh2.w;
import wh2.y;
import wh2.z;

@Service(process = {"all"})
/* loaded from: classes17.dex */
public interface IGPSService extends IRuntimeService, g, f, e, d, b {
    /* synthetic */ void addChannelSubscribeBubbleShow(String str, String str2);

    /* synthetic */ void addGuild(String str, GuildSourceId guildSourceId, String str2, bv bvVar);

    /* synthetic */ void addGuildStateListener(@NonNull bt btVar);

    /* synthetic */ void addGuildWithOption(az azVar, bv bvVar);

    /* synthetic */ void addGuilds(ArrayList<da> arrayList, ep epVar, dm dmVar);

    /* synthetic */ void addGuildsForGrowth(String str, ArrayList<da> arrayList, dm dmVar);

    /* synthetic */ void addObserver(GPServiceObserver gPServiceObserver);

    /* synthetic */ void addRecentVisitGuildsListSync(ArrayList<Long> arrayList, wh2.b bVar);

    @Override // uh2.b
    /* synthetic */ void addSpeakOrderByUser(fc fcVar, er erVar);

    /* synthetic */ void addUserToGuildBlackList(String str, List<String> list, @Nullable fm fmVar, cd cdVar);

    /* synthetic */ void appAuthorization(String str, a aVar);

    /* synthetic */ void authScreenShared(String str, String str2, co coVar);

    /* synthetic */ void batchDeleteAISearchSession(com.tencent.mobileqq.qqguildsdk.data.genc.a aVar, em emVar);

    /* synthetic */ void batchGetGuildLabelInfo(r rVar, wh2.e eVar);

    /* synthetic */ void batchGetItemDetail(bq bqVar, cn cnVar);

    /* synthetic */ void batchSetBoolField(String str, HashMap<Integer, Boolean> hashMap, @NonNull cc ccVar);

    /* synthetic */ void batchSetIntField(String str, HashMap<Integer, Integer> hashMap, @NonNull cc ccVar);

    /* synthetic */ void batchUpdateChannelsMsgNotifyType(String str, List<com.tencent.mobileqq.qqguildsdk.data.f> list, c cVar);

    /* synthetic */ void beforehandGetGuildSpeakPermission(long j3, int i3, wh2.f fVar);

    /* synthetic */ void bindAppRole(String str, String str2, int i3, vh2.d dVar);

    /* synthetic */ void cancelChannelTopMsg(String str, String str2, ArrayList<Long> arrayList, @NonNull cc ccVar);

    @Override // uh2.b
    /* synthetic */ void cancelSpeakOrderByAdmin(o oVar, wh2.c cVar);

    @Override // uh2.b
    /* synthetic */ void cancelUserHandUpForAdmin(o oVar, wh2.c cVar);

    /* synthetic */ void changeChannelCategoryName(String str, long j3, String str2, bg bgVar);

    /* synthetic */ void changeGuildAllowSearch(String str, boolean z16, dv dvVar);

    @Override // uh2.b
    /* synthetic */ void checkAVState(fc fcVar, er erVar);

    /* synthetic */ void checkAndEncryptText(ah ahVar, h hVar);

    /* synthetic */ void checkFeedAbstractInfo(u uVar, i iVar);

    /* synthetic */ void checkIsStrangerNewMember(j jVar);

    /* synthetic */ void checkLobbyAppAuthStatus(String str, long j3, long j16, k kVar);

    /* synthetic */ void checkPreventAddiction(dr drVar, dq dqVar);

    /* synthetic */ void checkUserBannedSpeakInChannel(String str, String str2, String str3, vh2.f fVar);

    /* synthetic */ void checkUserFreeGiftInfo(fe feVar, l lVar);

    /* synthetic */ void clearGuildRelatedData(ArrayList<Long> arrayList);

    /* synthetic */ void closeAVLobbyApp(long j3, long j16, long j17, wh2.u uVar);

    /* synthetic */ void closeChannelActivitySwitch(long j3, em emVar);

    /* synthetic */ void closeChannelTopMsg(String str, String str2, @NonNull cc ccVar);

    /* synthetic */ GProNotice convert2GProNotice(@NonNull com.tencent.mobileqq.qqguildsdk.data.co coVar);

    /* synthetic */ dj convert2GWGProNotice(@NonNull com.tencent.mobileqq.qqguildsdk.data.co coVar);

    /* synthetic */ GuildScheduleInfo convert2GuildScheduleInfo(GProScheduleInfo gProScheduleInfo);

    /* synthetic */ void convertGuildAndThirdIds(ab abVar, n nVar);

    /* synthetic */ IGProGuildInfo convertToGuildInfo(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo, int i3, IGProCmd0xf5aUserInfo iGProCmd0xf5aUserInfo);

    /* synthetic */ ez convertToGuildInviteInfo(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo);

    @Nullable
    /* synthetic */ IGProInviteInfo convertToGuildInviteInfo(x xVar);

    /* synthetic */ void createChannel(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, int i3, com.tencent.mobileqq.qqguildsdk.data.b bVar, vh2.g gVar);

    /* synthetic */ void createChannelCategory(String str, String str2, bg bgVar);

    /* synthetic */ void createDirectMsgSession(@NonNull com.tencent.mobileqq.qqguildsdk.data.i iVar, @NonNull vh2.h hVar);

    /* synthetic */ void createGuild(ac acVar, wh2.o oVar);

    /* synthetic */ void createLinkChannel(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, bd bdVar);

    @Override // uh2.f
    /* synthetic */ void createRole(String str, @NonNull fn fnVar, @NonNull List<String> list, @NonNull vh2.i iVar);

    /* synthetic */ void createSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, ce ceVar);

    /* synthetic */ void createScheduleLimitQuery(String str, cf cfVar);

    /* synthetic */ void createScheduleV2(ae aeVar, q qVar);

    @Override // uh2.b
    /* synthetic */ void dealHandUpRequestForAdmin(o oVar, boolean z16, wh2.c cVar);

    /* synthetic */ void dealNotice(String str, String str2, vh2.j jVar);

    @Nullable
    /* synthetic */ GuildScheduleInfo decodeGuildScheduleInfo(byte[] bArr);

    /* synthetic */ void decodeInviteJumpInfo(String str, wh2.r rVar);

    @Nullable
    /* synthetic */ IGProGetContentRecommendRsp decodeMVPFeedsRspPb(byte[] bArr);

    @Nullable
    /* synthetic */ IGProScheduleInfo decodeScheduleInfo(byte[] bArr);

    /* synthetic */ void deleteAISearchSession(com.tencent.mobileqq.qqguildsdk.data.genc.b bVar, s sVar);

    /* synthetic */ void deleteFeed(af afVar, t tVar);

    /* synthetic */ void deleteGuildEssence(ch chVar, dh dhVar);

    /* synthetic */ void deleteGuildGlobalBanner(cb cbVar, dd ddVar);

    /* synthetic */ void deleteObserver(GPServiceObserver gPServiceObserver);

    @Override // uh2.f
    /* synthetic */ void deleteRole(String str, String str2, @NonNull cd cdVar);

    /* synthetic */ void deleteSystemNoticeMessage(et etVar, v vVar);

    /* synthetic */ void destroyGuild(String str, dv dvVar);

    /* synthetic */ void doGuildCheckin(cg cgVar, dg dgVar);

    /* synthetic */ void doRealNameAuth(int i3, cv cvVar);

    /* synthetic */ void domainResolveByLocalDns(String str);

    /* synthetic */ void editSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i3, vh2.cg cgVar);

    /* synthetic */ void editScheduleV2(ag agVar, w wVar);

    /* synthetic */ void enterAudioLiveChannel(ai aiVar, wh2.x xVar);

    /* synthetic */ void enterAudioLiveChannelAndCallbackDirect(ai aiVar, wh2.x xVar);

    /* synthetic */ void exitAudioLiveChannel(long j3, long j16, int i3, ArrayList<String> arrayList, y yVar);

    /* synthetic */ void exposeGuildTaskCard(am amVar, em emVar);

    /* synthetic */ void exposeRecommends(al alVar, em emVar);

    /* synthetic */ void fetchActiveChannels(String str, z zVar);

    /* synthetic */ void fetchAddGuildInfo(int i3, long j3, wh2.a aVar);

    /* synthetic */ void fetchAppInfos(String str, aa aaVar);

    /* synthetic */ void fetchArchiveArkData(String str, String str2, byte[] bArr, int i3, vh2.l lVar);

    /* synthetic */ void fetchAudioLiveChannelBlockUserState(long j3, long j16, wh2.ae aeVar);

    /* synthetic */ void fetchAudioLiveChannelGroupList(m mVar, wh2.ac acVar);

    /* synthetic */ void fetchAudioLiveChannelGroupListAndCallbackDirect(m mVar, wh2.ac acVar);

    @Override // uh2.b
    /* synthetic */ void fetchAudioLiveChannelUserList(com.tencent.mobileqq.qqguildsdk.data.genc.q qVar, ad adVar);

    /* synthetic */ void fetchCategoryAdminInfoList(as asVar, wh2.af afVar);

    /* synthetic */ void fetchCategoryAdminMemberList(String str, String str2, String str3, int i3, boolean z16, @NonNull ar arVar);

    /* synthetic */ void fetchChannelAdminInfoList(String str, String str2, @NonNull vh2.e eVar);

    /* synthetic */ void fetchChannelAdminInfoList(String str, @NonNull vh2.e eVar);

    /* synthetic */ void fetchChannelAdminMemberList(String str, String str2, String str3, int i3, boolean z16, @NonNull ar arVar);

    /* synthetic */ void fetchChannelAuthControlMemberList(long j3, long j16, int i3, byte[] bArr, int i16, wh2.ag agVar);

    @Override // uh2.b
    /* synthetic */ void fetchChannelAuthControlRoleList(long j3, long j16, int i3, wh2.ah ahVar);

    /* synthetic */ void fetchChannelAuthControlUnableMemberList(long j3, long j16, int i3, byte[] bArr, int i16, wh2.ai aiVar);

    /* synthetic */ void fetchChannelInfoWithCategory(String str, String str2, int i3, vh2.n nVar);

    /* synthetic */ void fetchChannelInfoWithUnreadStatus(String str, boolean z16);

    /* synthetic */ void fetchChannelList(String str, vh2.o oVar);

    /* synthetic */ void fetchChannelListForJump(long j3, vh2.az azVar);

    /* synthetic */ void fetchChannelLiveableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.f fVar);

    @Override // uh2.d
    /* synthetic */ void fetchChannelLiveableRoleList(String str, String str2, @NonNull xh2.g gVar);

    /* synthetic */ void fetchChannelUnlivableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.j jVar);

    /* synthetic */ void fetchChannelUnlivableRoleList(String str, String str2, @NonNull xh2.k kVar);

    /* synthetic */ void fetchChannelUserPermission(String str, String str2, int i3, @NonNull xh2.n nVar);

    /* synthetic */ void fetchChannelVisibleRoleListWithoutLevelRole(long j3, long j16, aj ajVar);

    /* synthetic */ void fetchComments(String str, String str2, long j3, long j16, long j17, long j18, p pVar);

    /* synthetic */ void fetchDirectMsgBlack(String str, @NonNull vh2.q qVar);

    /* synthetic */ void fetchDirectMsgStatus(@NonNull vh2.r rVar);

    /* synthetic */ void fetchFeedsNotifySwitch(vh2.k kVar);

    /* synthetic */ void fetchGlobalPrivacySwitch(de deVar);

    /* synthetic */ void fetchGuestGuild(String str, boolean z16, vh2.s sVar);

    /* synthetic */ void fetchGuestGuildInfoWithChannelList(int i3, bl blVar, ak akVar);

    /* synthetic */ void fetchGuestGuildWithChannelListAndJoinSig(int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, vh2.t tVar);

    /* synthetic */ void fetchGuildActiveLiveChannelNum(at atVar, wh2.al alVar);

    /* synthetic */ void fetchGuildActiveValue(long j3, df dfVar);

    /* synthetic */ void fetchGuildBlackList(String str, byte[] bArr, wh2.am amVar);

    /* synthetic */ void fetchGuildBottomTabExp(com.tencent.mobileqq.qqguildsdk.data.genc.s sVar, an anVar);

    /* synthetic */ void fetchGuildBoundGroupsWithGroupCodes(String str, ArrayList<Long> arrayList, ao aoVar);

    /* synthetic */ void fetchGuildInfoAndMemberList(cj cjVar, ap apVar);

    void fetchGuildInfoByAppIdentity(com.tencent.mobileqq.qqguildsdk.data.cj cjVar, String str, String str2, vh2.u uVar);

    void fetchGuildInfoByInviteCode(String str, vh2.aa aaVar);

    void fetchGuildInfoByInviteCodeAndContentID(String str, String str2, String str3, int i3, vh2.z zVar);

    /* synthetic */ void fetchGuildInfoOnly(String str, int i3, vh2.v vVar);

    /* synthetic */ void fetchGuildInfoWithSource(String str, int i3, vh2.v vVar);

    /* synthetic */ void fetchGuildSearchSwitch(String str, @NonNull vh2.w wVar);

    /* synthetic */ void fetchGuildSpeakableMemberList(String str, boolean z16, byte[] bArr, @NonNull xh2.p pVar);

    @Override // uh2.f
    /* synthetic */ void fetchGuildSpeakableRoleList(String str, boolean z16, @NonNull xh2.q qVar);

    /* synthetic */ void fetchGuildSpeakableRule(String str, au auVar);

    /* synthetic */ void fetchGuildSpeakableThreshold(String str, vh2.x xVar);

    /* synthetic */ void fetchGuildTaskCards(com.tencent.mobileqq.qqguildsdk.data.genc.p pVar, aq aqVar);

    /* synthetic */ void fetchIsLiveChannelOpen(String str, vh2.ab abVar);

    /* synthetic */ void fetchIsVoiceChannelOpen(String str, vh2.ac acVar);

    /* synthetic */ void fetchJoinGuildOption(com.tencent.mobileqq.qqguildsdk.data.genc.au auVar, wh2.ar arVar);

    /* synthetic */ void fetchJumpInfo(long j3, wh2.as asVar);

    /* synthetic */ void fetchLatestComments(String str, String str2, long j3, long j16, p pVar);

    /* synthetic */ void fetchLevelRolePermissions(long j3, int i3, wh2.at atVar);

    /* synthetic */ void fetchLiveChannelAnchorList(String str, String str2, vh2.ad adVar);

    /* synthetic */ void fetchLiveChannelBannedUserList(String str, String str2, String str3, vh2.ae aeVar);

    /* synthetic */ void fetchLiveRoomInfo(com.tencent.mobileqq.qqguildsdk.data.ag agVar, vh2.af afVar);

    /* synthetic */ void fetchLiveSecurityTips(vh2.ag agVar);

    /* synthetic */ void fetchMVPFeedsFromServer(bj bjVar, wh2.au auVar);

    /* synthetic */ void fetchMVPFeedsFromServerWithNonUiThreadCallback(bj bjVar, wh2.au auVar);

    /* synthetic */ void fetchMemberListForFeed(com.tencent.mobileqq.qqguildsdk.data.genc.ap apVar, av avVar);

    @Override // uh2.f
    /* synthetic */ void fetchMemberListWithRole(String str, String str2, int i3, boolean z16, @NonNull vh2.ai aiVar);

    @Override // uh2.f
    /* synthetic */ void fetchMemberRoleList(String str, String str2, String str3, int i3, @NonNull vh2.ak akVar);

    /* synthetic */ void fetchMyCreateGuilds(aw awVar);

    /* synthetic */ void fetchNewestNotice(int i3, String str, @NonNull vh2.al alVar);

    /* synthetic */ void fetchNonRoleMemberList(String str, String str2, String str3, String str4, int i3, boolean z16, @NonNull vh2.am amVar);

    /* synthetic */ void fetchOnlineUsers(String str, int i3, int i16, ArrayList<Long> arrayList, ax axVar);

    /* synthetic */ void fetchOtherChannelUserPermission(long j3, long j16, long j17, int i3, int i16, wh2.g gVar);

    /* synthetic */ void fetchProfileAddFriendField(String str, String str2, ay ayVar);

    /* synthetic */ void fetchRecommendChannel(int i3, int i16, vh2.ao aoVar);

    /* synthetic */ void fetchRecommendEssenceInfo(long j3, int i3, wh2.az azVar);

    /* synthetic */ void fetchRemainAtSetInfo(long j3, wh2.ab abVar);

    void fetchRemainAtSetInfo(String str, vh2.m mVar);

    /* synthetic */ void fetchRetentionGuildList(int i3, int i16, byte[] bArr, long j3, ba baVar);

    /* synthetic */ void fetchRole(String str, String str2, boolean z16, int i3, @NonNull vh2.ap apVar);

    /* synthetic */ void fetchRoleList(String str, int i3, int i16, @NonNull vh2.aq aqVar);

    /* synthetic */ void fetchRoleList(String str, int i3, @NonNull vh2.aq aqVar);

    @Override // uh2.d
    /* synthetic */ void fetchRoleListWithPermission(String str, int i3, @NonNull xh2.a aVar);

    /* synthetic */ void fetchRoleListWithoutLevelRoleWithFilter(long j3, int i3, int i16, bb bbVar);

    /* synthetic */ void fetchRoleMemberList(String str, String str2, int i3, boolean z16, @NonNull ar arVar);

    @Override // uh2.d
    /* synthetic */ void fetchRoleWithPermission(String str, String str2, int i3, @NonNull xh2.b bVar);

    /* synthetic */ void fetchShareButtonReq(ArrayList<Long> arrayList, boolean z16, wh2.m mVar);

    void fetchShareInfo(String str, String str2, int i3, byte[] bArr, boolean z16, ArrayList<ey> arrayList, com.tencent.mobileqq.qqguildsdk.data.genc.v vVar, vh2.at atVar);

    /* synthetic */ void fetchShareInfo0x10c3(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.av avVar, bc bcVar);

    /* synthetic */ void fetchShareUrlReq(long j3, long j16, long j17, String str, com.tencent.mobileqq.qqguildsdk.data.genc.aw awVar, ArrayList<ey> arrayList, wh2.bd bdVar);

    /* synthetic */ void fetchSpecifiedTypeChannelsOpenState(long j3, ArrayList<Integer> arrayList, int i3, be beVar);

    /* synthetic */ void fetchSubscribeUserGuide(bf bfVar);

    /* synthetic */ void fetchUserInfo(String str, String str2, List<String> list, boolean z16, vh2.bq bqVar);

    /* synthetic */ void fetchUserInfo(String str, List<String> list, boolean z16, vh2.bq bqVar);

    /* synthetic */ void fetchUserInfo(String str, List<String> list, boolean z16, boolean z17, vh2.bq bqVar);

    /* synthetic */ void fetchUserJoinedGuildListV2(com.tencent.mobileqq.qqguildsdk.data.genc.ax axVar, wh2.bg bgVar);

    /* synthetic */ void fetchVersionNews(bh bhVar);

    /* synthetic */ void fetchVisibleMemberListByTinyId(String str, String str2, @NonNull List<String> list, @NonNull vh2.av avVar);

    /* synthetic */ void fetchXWordInfo(long j3, wh2.ey eyVar);

    /* synthetic */ void getAISearchRecommendWords(bi biVar);

    /* synthetic */ void getAISearchSessionList(com.tencent.mobileqq.qqguildsdk.data.genc.c cVar, boolean z16, wh2.bj bjVar);

    /* synthetic */ void getAISearchSessionMsgList(com.tencent.mobileqq.qqguildsdk.data.genc.d dVar, boolean z16, bk bkVar);

    /* synthetic */ void getAISearchShareURL(com.tencent.mobileqq.qqguildsdk.data.genc.az azVar, wh2.bl blVar);

    /* synthetic */ void getActiveLiveAudioChannelNum(long j3, bm bmVar);

    /* synthetic */ void getActiveLiveAudioChannelNumV2(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, vh2.ba baVar);

    /* synthetic */ void getAllGuildSearchAIInfo(com.tencent.mobileqq.qqguildsdk.data.genc.co coVar, bn bnVar);

    @Nullable
    /* synthetic */ IGProGuildUserState getAlreadyEnteredChannel();

    /* synthetic */ void getAppAuthorizationInfo(String str, int i3, vh2.be beVar);

    @Nullable
    /* synthetic */ IGProAppChnnPreInfo getAppChannelPreInfo(String str, String str2);

    @Nullable
    /* synthetic */ ArrayList<IGProAppChnnPreInfo> getAppChannelPreInfos(String str);

    @Nullable
    /* synthetic */ IGProAppChnnPreInfo getAppChnnPreInfo(String str, String str2);

    @Nullable
    /* synthetic */ ArrayList<IGProAppInfo> getAppInfos();

    /* synthetic */ void getAppRoleList(String str, String str2, byte[] bArr, vh2.bf bfVar);

    /* synthetic */ void getAssociativeWords(String str, vh2.b bVar);

    /* synthetic */ String getAvatarUrl(String str, long j3, int i3);

    /* synthetic */ void getBanners(com.tencent.mobileqq.qqguildsdk.data.genc.ba baVar, bo boVar);

    /* synthetic */ void getBindClientService(int i3, String str, byte[] bArr, vh2.bi biVar);

    /* synthetic */ void getBindingGroupInfos(ArrayList<Long> arrayList, bp bpVar);

    /* synthetic */ void getBlockRecGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.bb bbVar, wh2.bq bqVar);

    /* synthetic */ HashMap<Long, ArrayList<Long>> getBoardPermission(String str);

    @Nullable
    /* synthetic */ ArrayList<IGProCategoryChannelIdList> getCategoryChannelIdList(long j3);

    @Nullable
    /* synthetic */ ArrayList<IGProCategoryChannelIdList> getCategoryChannelIdListExcludeCategoryType(long j3, ArrayList<Integer> arrayList);

    @Nullable
    /* synthetic */ ArrayList<IGProCategoryChannelInfoList> getCategoryChannelInfoListByCategoryType(long j3, ArrayList<Integer> arrayList);

    /* synthetic */ void getCategoryChannelInfoListByFilter(com.tencent.mobileqq.qqguildsdk.data.genc.bc bcVar, br brVar);

    /* synthetic */ void getCategoryChannelInfoListV2(com.tencent.mobileqq.qqguildsdk.data.genc.bd bdVar, br brVar);

    /* synthetic */ void getCategoryGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.be beVar, bs bsVar);

    /* synthetic */ void getCategoryPageGuilds(com.tencent.mobileqq.qqguildsdk.data.genc.bf bfVar, wh2.bt btVar);

    @Override // uh2.d
    @NonNull
    /* synthetic */ dx getCategoryPermission(String str, String str2);

    /* synthetic */ void getCategoryTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bg bgVar, bu buVar);

    /* synthetic */ void getChannelActivity(com.tencent.mobileqq.qqguildsdk.data.genc.bh bhVar, wh2.bv bvVar);

    /* synthetic */ List<cy> getChannelCategoryList(String str);

    /* synthetic */ void getChannelHeartbeat(String str, String str2, vh2.aw awVar);

    /* synthetic */ IGProChannelInfo getChannelInfo(String str);

    /* synthetic */ void getChannelInvisibleMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.d dVar);

    /* synthetic */ void getChannelInvisibleRoleList(String str, String str2, @NonNull xh2.e eVar);

    @NonNull
    /* synthetic */ List<IGProChannelInfo> getChannelList(String str);

    @Nullable
    /* synthetic */ List<cy> getChannelListForSelector(String str, boolean z16);

    @Override // uh2.d
    @NonNull
    /* synthetic */ dx getChannelPermission(String str, String str2);

    /* synthetic */ HashMap<Long, ArrayList<Long>> getChannelPermission(String str, int i3);

    /* synthetic */ void getChannelSpeakableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.h hVar);

    @Override // uh2.d
    /* synthetic */ void getChannelSpeakableRoleList(String str, String str2, @NonNull xh2.i iVar);

    /* synthetic */ void getChannelTopMsgState(String str, String str2, @NonNull vh2.bh bhVar);

    /* synthetic */ void getChannelUnspeakableMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.l lVar);

    /* synthetic */ void getChannelUnspeakableRoleList(String str, String str2, @NonNull xh2.m mVar);

    /* synthetic */ int getChannelUserPermission(@NonNull String str, @NonNull String str2);

    /* synthetic */ void getChannelVisibleAllMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.o oVar);

    /* synthetic */ void getChannelVisibleMemberList(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull xh2.o oVar);

    @Override // uh2.d
    /* synthetic */ void getChannelVisibleRoleList(String str, String str2, @NonNull aj ajVar);

    /* synthetic */ void getClientInfoList(int i3, byte[] bArr, vh2.bk bkVar);

    /* synthetic */ void getConfigTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bi biVar, bw bwVar);

    /* synthetic */ void getCurrPlaySong(long j3, long j16, bx bxVar);

    /* synthetic */ Cdo getFaceAuthInfo();

    /* synthetic */ void getFriendsInGuild(com.tencent.mobileqq.qqguildsdk.data.genc.bm bmVar, bz bzVar);

    /* synthetic */ void getFriendsRecommend(com.tencent.mobileqq.qqguildsdk.data.genc.bk bkVar, ca caVar);

    /* synthetic */ String getFullAvatarUrl(cw cwVar, int i3);

    @Nullable
    /* synthetic */ String getFullGuildUserUserAvatarUrl(String str, String str2, int i3);

    @Override // uh2.g
    /* synthetic */ String getFullUserAvatarPendantUrl(String str);

    /* synthetic */ List<IGProGuildInfo> getGroupGuildList();

    /* synthetic */ void getGuidePageInfo(long j3, String str, wh2.cb cbVar);

    /* synthetic */ String getGuildAvatarUrl(String str, int i3);

    /* synthetic */ void getGuildBindableGroups(wh2.cc ccVar);

    /* synthetic */ void getGuildBindingInfo(long j3, wh2.cd cdVar);

    /* synthetic */ void getGuildBoundGroupsFirstPage(String str, int i3, wh2.ce ceVar);

    /* synthetic */ void getGuildCheckinInfo(cg cgVar, dg dgVar);

    /* synthetic */ void getGuildCreatorTasks(String str, boolean z16, wh2.cf cfVar);

    /* synthetic */ void getGuildFeedsValidCalendar(cp cpVar, di diVar);

    @Nullable
    /* synthetic */ IGProGlobalBanner getGuildGlobalBanner(String str);

    /* synthetic */ void getGuildHomeCategories(com.tencent.mobileqq.qqguildsdk.data.genc.bn bnVar, wh2.cg cgVar);

    /* synthetic */ void getGuildHomeSections(long j3, wh2.ch chVar);

    /* synthetic */ String getGuildIdOf(String str);

    @Nullable
    /* synthetic */ IGProGuildInfo getGuildInfo(String str);

    /* synthetic */ void getGuildLableInfo(com.tencent.mobileqq.qqguildsdk.data.genc.bo boVar, ci ciVar);

    /* synthetic */ List<IGProGuildInfo> getGuildList();

    /* synthetic */ void getGuildMainFrameHeaderInfo(long j3, vh2.ax axVar);

    @Nullable
    /* synthetic */ IGProClientIdentityInfo getGuildMemberClientIdentity(String str, String str2, String str3);

    @NonNull
    /* synthetic */ String getGuildMemberName(String str, String str2);

    @NonNull
    /* synthetic */ Map<String, String> getGuildMemberNames(String str, List<String> list);

    /* synthetic */ String getGuildName(String str);

    /* synthetic */ void getGuildNum(long j3, wh2.cj cjVar);

    @Override // uh2.d
    @NonNull
    /* synthetic */ dx getGuildPermission(String str);

    /* synthetic */ void getGuildRecommend(byte[] bArr, vh2.bp bpVar);

    @Nullable
    /* synthetic */ long getGuildRoleLimit(long j3);

    /* synthetic */ long getGuildRoleLimit(String str);

    /* synthetic */ eo getGuildSpeakPermission(String str, int i3);

    /* synthetic */ IGuildSpeakableThresholdPermission getGuildSpeakableThresholdPermission(String str);

    @Nullable
    /* synthetic */ dt getGuildState(String str);

    @Nullable
    /* synthetic */ String getGuildUserAvatarPendantUrl(String str);

    @Nullable
    /* synthetic */ String getGuildUserAvatarUrl(String str, String str2, int i3);

    @Nullable
    /* synthetic */ Map<String, String> getGuildUserAvatarUrls(String str, List<String> list, int i3);

    @Nullable
    /* synthetic */ ArrayList<Long> getGuildUserChannelCategoryAdminList(String str, String str2);

    @Nullable
    /* synthetic */ IGProClientIdentity getGuildUserClientIdentity(String str, String str2);

    @NonNull
    /* synthetic */ String getGuildUserDisplayName(String str, String str2);

    @NonNull
    /* synthetic */ String getGuildUserDisplayName(String str, String str2, String str3);

    @NonNull
    /* synthetic */ String getGuildUserDisplayNameInternal(String str, String str2);

    @Nullable
    /* synthetic */ int getGuildUserLevelRoleId(String str, String str2);

    @Nullable
    /* synthetic */ IGProMedal getGuildUserMedal(String str);

    @Nullable
    /* synthetic */ String getGuildUserMemberName(String str, String str2);

    @NonNull
    /* synthetic */ String getGuildUserNick(String str, String str2);

    @Nullable
    /* synthetic */ String getGuildUserNickname(String str);

    @Nullable
    /* synthetic */ long getGuildUserTopRoleId(String str, String str2);

    @NonNull
    /* synthetic */ Map<String, String> getGuildUsersNicks(String str, List<String> list);

    /* synthetic */ void getGuildVerifyShareInfo(fg fgVar, wh2.ez ezVar);

    /* synthetic */ void getGuildsInContact(ck ckVar);

    /* synthetic */ void getHotLive(com.tencent.mobileqq.qqguildsdk.data.genc.bp bpVar, cl clVar);

    /* synthetic */ void getHotSearchWords(ArrayList<Integer> arrayList, int i3, cm cmVar);

    /* synthetic */ boolean getIsGuildListFirstLoadingCallbacked();

    /* synthetic */ List<IGProChannelInfo> getJumpChannelList(String str, String str2);

    @Nullable
    /* synthetic */ IGProJumpToCategoryInfo getJumpToCategory(String str);

    /* synthetic */ void getLabelGuilds(fo foVar, wh2.co coVar);

    @Deprecated
    /* synthetic */ void getLiveAudioPollingCtx(String str, String str2, vh2.bb bbVar);

    /* synthetic */ void getLiveAudioPollingCtxV2(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, vh2.bc bcVar);

    /* synthetic */ void getMemberInfoByOpenId(String str, long j3, boolean z16, boolean z17, vh2.bn bnVar);

    /* synthetic */ IGProGuildRoleInfo getMemberLevelRole(String str, String str2, String str3);

    @Nullable
    /* synthetic */ IGProGuildRoleInfo getMemberLevelRoleInfo(long j3, long j16, long j17);

    /* synthetic */ IGProGuildRoleInfo getMemberTopRole(String str, String str2, String str3, String str4, int i3);

    @Nullable
    /* synthetic */ IGProGuildRoleInfo getMemberTopRoleInfo(long j3, long j16, long j17, long j18, int i3);

    /* synthetic */ void getMoreNoticeList(int i3, String str, int i16, vh2.bo boVar);

    /* synthetic */ void getMyTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.br brVar, wh2.cp cpVar);

    /* synthetic */ void getNavigationStatus(com.tencent.mobileqq.qqguildsdk.data.genc.bs bsVar, cq cqVar);

    @Nullable
    /* synthetic */ IGProOnlineMember getOnlineMemberInfo(String str);

    /* synthetic */ void getOpenShareInfo(fp fpVar, cr crVar);

    /* synthetic */ int getPermissionChangeFilter(@NonNull String str, @NonNull String str2);

    @Nullable
    /* synthetic */ ArrayList<IGProPersonalSignatureTemplate> getPersonalSignatureTemplate();

    @Nullable
    /* synthetic */ IGProAppChnnPreInfo getPollingChannelOfApp(String str, String str2);

    @Nullable
    /* synthetic */ ILiveRoomInfo getPollingChannelOfLive(String str, String str2);

    @Nullable
    /* synthetic */ IAudioChannelMemberInfos getPollingChannelOfVoice(String str, String str2);

    /* synthetic */ void getPopupInfo(long j3, int i3, cs csVar);

    /* synthetic */ void getPreviewNavigation(com.tencent.mobileqq.qqguildsdk.data.genc.bt btVar, ct ctVar);

    /* synthetic */ void getProfileSwitch(cu cuVar);

    @NotNull
    /* synthetic */ fk getQQMsgListChannel(@NotNull String str, @NotNull String str2);

    @Override // uh2.e
    @NotNull
    /* synthetic */ List<fk> getQQMsgListChannels();

    @Nullable
    /* synthetic */ ArrayList<IGProQQMsgListGuild> getQQMsgListGuilds();

    @Nullable
    /* synthetic */ IGProGetRecentVisitGuildInfosFromCacheRsp getRecentVisitGuildInfosListSync(int i3, int i16);

    @Nullable
    /* synthetic */ IGProRecommendEssenceSvrRsp getRecommendEssenceSvrRsp(String str, String str2);

    @Nullable
    /* synthetic */ void getRecommendGuildInfoFromCache(vh2.ay ayVar);

    /* synthetic */ void getRecommendQuickJoin(com.tencent.mobileqq.qqguildsdk.data.genc.bu buVar, wh2.cw cwVar);

    /* synthetic */ void getRecommendTabContent(com.tencent.mobileqq.qqguildsdk.data.genc.bv bvVar, cx cxVar);

    /* synthetic */ void getRecommendTagList(com.tencent.mobileqq.qqguildsdk.data.genc.bw bwVar, wh2.cy cyVar);

    /* synthetic */ void getRiskMemberRedPoint(com.tencent.mobileqq.qqguildsdk.data.genc.bx bxVar, cz czVar);

    @Nullable
    /* synthetic */ IGProGuildRoleInfo getRoleInfo(long j3, long j16);

    @Override // uh2.f
    @Nullable
    /* synthetic */ IGProGuildRoleInfo getRoleInfo(String str, String str2);

    @Nullable
    /* synthetic */ ArrayList<Integer> getRolePermission(long j3, long j16);

    /* synthetic */ void getScheduleDetail(String str, String str2, String str3, vh2.ch chVar);

    /* synthetic */ void getScheduleList(String str, String str2, long j3, vh2.ci ciVar);

    /* synthetic */ void getScheduleListNew(String str, String str2, int i3, long j3, String str3, vh2.cj cjVar);

    /* synthetic */ void getScheduleUsers(String str, String str2, String str3, int i3, byte[] bArr, vh2.cl clVar);

    /* synthetic */ void getSchedulesStatus(String str, String str2, long j3, long j16, vh2.ck ckVar);

    /* synthetic */ void getSelectChannelIDs(com.tencent.mobileqq.qqguildsdk.data.genc.bz bzVar, wh2.da daVar);

    @NonNull
    /* synthetic */ String getSelfGuildMemberName(String str);

    @Nullable
    /* synthetic */ int getSelfLiveChannelBanStatus(String str, String str2);

    String getSelfTinyId();

    @Nullable
    /* synthetic */ int getShareButtonFromCache(long j3, long j16, boolean z16);

    @Nullable
    /* synthetic */ IGProSimpleProfile getSimpleProfile(String str, String str2, int i3);

    /* synthetic */ void getSimpleProfileAsync(com.tencent.mobileqq.qqguildsdk.data.genc.ca caVar, db dbVar);

    @Nullable
    /* synthetic */ ArrayList<Long> getSortedGuildIdsFromCache();

    /* synthetic */ List<IGProGuildInfo> getSortedGuildList();

    /* synthetic */ int getSpeakLimit(String str, String str2);

    /* synthetic */ List<IGProChannelInfo> getSpecificTypeChannelList(String str, int i3);

    /* synthetic */ List<String> getTopGuildList();

    /* synthetic */ void getUnBindClientServiceV2(byte[] bArr, vh2.bj bjVar);

    /* synthetic */ void getUserList(String str, long j3, boolean z16, int i3, vh2.br brVar);

    /* synthetic */ void getUserList(String str, Object obj, boolean z16, int i3, @NonNull vh2.bl blVar);

    /* synthetic */ void getUserLiveInfo(int i3, vh2.bs bsVar);

    /* synthetic */ boolean hasSetSpeakableThreshold(String str);

    /* synthetic */ void initGetNoticeList(int i3, String str, boolean z16, vh2.bu buVar);

    /* synthetic */ void inviteJoinSingleGuild(com.tencent.mobileqq.qqguildsdk.data.genc.z zVar, dl dlVar);

    @Override // uh2.b
    /* synthetic */ void inviteUserHandUpForAdmin(o oVar, wh2.c cVar);

    @Override // uh2.b
    /* synthetic */ void inviteUserQueueForAdmin(o oVar, wh2.c cVar);

    boolean isAllGuildAndChannelFetchCompleted();

    /* synthetic */ boolean isChannelAdmin(String str, String str2);

    /* synthetic */ boolean isGProSDKInitCompleted();

    /* synthetic */ boolean isGuest(IGProGuildInfo iGProGuildInfo);

    /* synthetic */ boolean isGuest(String str);

    @Nullable
    /* synthetic */ boolean isGuildMember(String str);

    @Override // uh2.e
    /* synthetic */ boolean isQQMsgListChannel(@NotNull String str, @NotNull String str2);

    @Nullable
    /* synthetic */ boolean isQQMsgListGuild(long j3);

    @Nullable
    /* synthetic */ boolean isQQMsgListReady();

    /* synthetic */ void joinChannelByGuildTask(com.tencent.mobileqq.qqguildsdk.data.genc.cu cuVar, dk dkVar);

    /* synthetic */ void kickAudioChannelUsers(String str, String str2, ArrayList<String> arrayList, vh2.bw bwVar);

    /* synthetic */ void kickGuildUsers(String str, List<String> list, boolean z16, @Nullable fm fmVar, cd cdVar);

    /* synthetic */ void loadGProUserProfileInfo(String str, String str2, vh2.bz bzVar);

    @Override // uh2.f
    /* synthetic */ void loadMemberRoleList(String str, String str2, @NonNull vh2.bx bxVar);

    /* synthetic */ void loadPartRoleMemberList(long j3, dc dcVar);

    /* synthetic */ void loadUserInfo(String str, List<String> list, vh2.bq bqVar, List<IGProUserInfo> list2, boolean z16);

    /* synthetic */ void loadUserList(String str, long j3, vh2.br brVar);

    byte[] lz4DecompressBuf(byte[] bArr);

    /* synthetic */ void modifyGuildSpeakableMemberList(String str, List<String> list, List<String> list2, @NonNull dv dvVar);

    @Override // uh2.f
    /* synthetic */ void modifyGuildSpeakableRoleList(String str, List<String> list, List<String> list2, dv dvVar);

    /* synthetic */ void modifyGuildSpeakableRule(String str, GProGuildSpeakRuleData gProGuildSpeakRuleData, dv dvVar);

    /* synthetic */ void modifyScheduleInviteStatus(String str, String str2, String str3, int i3, vh2.cm cmVar);

    /* synthetic */ void modifyScheduleInviteStatusV2(com.tencent.mobileqq.qqguildsdk.data.genc.di diVar, wh2.Cdo cdo);

    void onSrvPushMsg(int i3, int i16, fi fiVar, byte[] bArr);

    /* synthetic */ void openAVLobbyApp(com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar, wh2.p pVar);

    @Override // uh2.b
    /* synthetic */ void queryAVState(fc fcVar, er erVar);

    /* synthetic */ void queryApplyAddGuildStatus(String str, dv dvVar);

    /* synthetic */ void queryGuildEssence(ch chVar, dh dhVar);

    /* synthetic */ void queryGuildVisitor(ch chVar, dh dhVar);

    /* synthetic */ void queryTinyIdByLiveUID(List<String> list, vh2.ca caVar);

    /* synthetic */ void refreshAppChannelPreInfos(String str, boolean z16, em emVar);

    /* synthetic */ void refreshChannelInfo(String str, String str2, boolean z16, int i3);

    /* synthetic */ void refreshGuildList(boolean z16);

    /* synthetic */ void refreshGuildState();

    /* synthetic */ void refreshGuildUserProfileInfo(String str, String str2);

    /* synthetic */ void refreshPollingData();

    /* synthetic */ void refreshPollingData(@NonNull String str, int i3);

    /* synthetic */ void refreshPollingData(@NonNull String str, @NonNull String str2);

    /* synthetic */ void removeBanBeforeBroadcast(String str, String str2, vh2.cb cbVar);

    /* synthetic */ void removeChannel(String str, String str2, int i3, cd cdVar);

    /* synthetic */ void removeChannelCategory(String str, long j3, boolean z16, bg bgVar);

    /* synthetic */ void removeGuild(String str, dv dvVar);

    @Nullable
    /* synthetic */ boolean removeGuildGlobalBanner(String str);

    /* synthetic */ void removeGuildStateListener(@NonNull bt btVar);

    /* synthetic */ void removeGuildTaskCard(com.tencent.mobileqq.qqguildsdk.data.genc.dt dtVar, em emVar);

    /* synthetic */ void removeMemberFromGuildBlackList(String str, @NonNull List<String> list, cc ccVar);

    /* synthetic */ void removeRiskMembers(du duVar, wh2.dr drVar);

    @Override // uh2.b
    /* synthetic */ void removeSpeakOrderByUser(fc fcVar, er erVar);

    /* synthetic */ void reportAISearchRecommendWords(com.tencent.mobileqq.qqguildsdk.data.genc.i iVar, em emVar);

    @Override // uh2.b
    /* synthetic */ void reportAVState(com.tencent.mobileqq.qqguildsdk.data.genc.n nVar, er erVar);

    /* synthetic */ void reportCurrentGuild(long j3);

    /* synthetic */ void reportFeedShareData(String str, String str2, int i3, com.tencent.mobileqq.qqguildsdk.data.genc.aq aqVar, int i16, GProReportTarget gProReportTarget, ds dsVar);

    /* synthetic */ void reportFeedback(com.tencent.mobileqq.qqguildsdk.data.genc.ar arVar, em emVar);

    /* synthetic */ void reportJoinRecommendGuild(wh2.dt dtVar);

    /* synthetic */ void reportPreventAddictionInstructions(com.tencent.mobileqq.qqguildsdk.data.genc.dq dqVar, dp dpVar);

    /* synthetic */ void reportShareAtta(com.tencent.mobileqq.qqguildsdk.data.genc.dv dvVar, em emVar);

    void reportShareInfo(String str, String str2, int i3, String str3, int i16, cc ccVar);

    /* synthetic */ void reportUserViewGuild(ArrayList<String> arrayList, String str, String str2, int i3, em emVar);

    /* synthetic */ void requestBeginBroadcast(String str, String str2, String str3, int i3, com.tencent.mobileqq.qqguildsdk.data.bl blVar, cd cdVar);

    /* synthetic */ void requestPubAccountMsgCount(wh2.du duVar);

    /* synthetic */ void riskMemberList(dw dwVar, wh2.dw dwVar2);

    /* synthetic */ void saveCustomApplication(com.tencent.mobileqq.qqguildsdk.data.genc.dx dxVar, wh2.dx dxVar2);

    /* synthetic */ void saveGuidNavigation(dy dyVar, wh2.dy dyVar2);

    /* synthetic */ void searchBlackUserFromServer(ee eeVar, dz dzVar);

    /* synthetic */ void searchChannelContent(String str, String str2, String str3, byte[] bArr, eh ehVar, ef efVar, ea eaVar);

    /* synthetic */ void searchGuild(String str, byte[] bArr, int i3, int i16, int i17, eb ebVar);

    /* synthetic */ void searchGuildContent(com.tencent.mobileqq.qqguildsdk.data.genc.cr crVar, wh2.dj djVar);

    /* synthetic */ void searchGuildFeeds(eg egVar, ea eaVar);

    /* synthetic */ void searchGuildMembersBySourceId(com.tencent.mobileqq.qqguildsdk.data.genc.cl clVar, ec ecVar);

    /* synthetic */ void searchMsgSeqsFromServer(@NonNull com.tencent.mobileqq.qqguildsdk.data.bd bdVar, @NonNull vh2.cp cpVar);

    /* synthetic */ void searchUnion(String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, vh2.cq cqVar);

    /* synthetic */ void sendAudioOrLiveNotice(ei eiVar, ed edVar);

    /* synthetic */ void sendChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar);

    /* synthetic */ void sendDirectMsgReadReport(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.j> list);

    /* synthetic */ void sendOperationSaveMsg(com.tencent.mobileqq.qqguildsdk.data.genc.dz dzVar, wh2.ee eeVar);

    /* synthetic */ void sendScheduleArkMessage(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<com.tencent.mobileqq.qqguildsdk.data.cu> arrayList3, com.tencent.mobileqq.qqguildsdk.data.cu cuVar, long j3, int i3, String str, String str2, String str3, byte[] bArr, vh2.cn cnVar);

    /* synthetic */ void setAVChannelInviteSpeakSwitch(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.cw cwVar, em emVar);

    /* synthetic */ void setAVChannelSpeakMode(long j3, long j16, String str, com.tencent.mobileqq.qqguildsdk.data.genc.fn fnVar, el elVar);

    @Override // uh2.b
    /* synthetic */ void setAVChannelSpeakOrder(long j3, long j16, fh fhVar, em emVar);

    /* synthetic */ void setAdminMsgNotifyType(String str, String str2, int i3, vh2.cr crVar);

    /* synthetic */ void setChannelAuthControl(long j3, long j16, int i3, int i16, dv dvVar);

    /* synthetic */ void setChannelAuthControlMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, dv dvVar);

    @Override // uh2.b
    /* synthetic */ void setChannelAuthControlRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, dv dvVar);

    /* synthetic */ void setChannelBannedSpeak(String str, int i3, cd cdVar);

    /* synthetic */ void setChannelCategory(String str, String str2, long j3, bg bgVar);

    /* synthetic */ void setChannelCategoryInfo(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, bg bgVar);

    /* synthetic */ void setChannelCategoryOrder(ej ejVar, wh2.ef efVar);

    /* synthetic */ void setChannelCategoryOrder(String str, ArrayList<Long> arrayList, bg bgVar);

    /* synthetic */ void setChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.data.genc.cv cvVar);

    /* synthetic */ void setChannelLiveable(String str, String str2, int i3, @NonNull cd cdVar);

    /* synthetic */ void setChannelLiveableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    @Override // uh2.d
    /* synthetic */ void setChannelLiveableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    /* synthetic */ void setChannelName(String str, String str2, String str3, vh2.ct ctVar);

    /* synthetic */ void setChannelSlowMode(String str, int i3, cd cdVar);

    /* synthetic */ void setChannelSpeakable(String str, String str2, int i3, @NonNull cd cdVar);

    /* synthetic */ void setChannelSpeakableMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    @Override // uh2.d
    /* synthetic */ void setChannelSpeakableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    /* synthetic */ void setChannelTopMsg(String str, String str2, long j3, int i3, int i16, @NonNull cc ccVar);

    /* synthetic */ void setChannelUserNumLimit(long j3, long j16, int i3, boolean z16, int i16, dv dvVar);

    /* synthetic */ void setChannelVisible(String str, String str2, int i3, @NonNull cd cdVar);

    /* synthetic */ void setChannelVisibleMemberList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    @Override // uh2.d
    /* synthetic */ void setChannelVisibleRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    /* synthetic */ void setClientShowConfig(String str, int i3, int i16, vh2.cu cuVar);

    /* synthetic */ void setDirectMsgBlack(String str, boolean z16, @NonNull cd cdVar);

    /* synthetic */ void setDirectMsgNotifyForGuild(int i3, boolean z16, @NonNull cd cdVar);

    /* synthetic */ void setDirectMsgNotifyType(String str, int i3, @NonNull cd cdVar);

    /* synthetic */ void setDirectMsgStatus(int i3, int i16, @NonNull cd cdVar);

    /* synthetic */ void setEnteredChannelState(long j3, long j16, boolean z16);

    /* synthetic */ void setFeedCommentsNotifySwitch(int i3, vh2.k kVar);

    void setGender(int i3, cc ccVar);

    /* synthetic */ void setGlobalPrivacySwitch(int i3, int i16, de deVar);

    /* synthetic */ void setGuildAuditInfo(com.tencent.mobileqq.qqguildsdk.data.genc.ce ceVar, wh2.d dVar);

    /* synthetic */ void setGuildBoundGroups(en enVar, wh2.eg egVar);

    /* synthetic */ void setGuildClientId(String str, String str2, vh2.cv cvVar);

    /* synthetic */ void setGuildCommonUnNotifyFlag(long j3, int i3, int i16, wh2.ei eiVar);

    /* synthetic */ void setGuildCoverFontColorId(String str, int i3, vh2.cw cwVar);

    /* synthetic */ void setGuildCreatorTaskSkipStatus(String str, em emVar);

    /* synthetic */ void setGuildGlobalBanner(cb cbVar, dd ddVar);

    /* synthetic */ void setGuildGlobalPermission(ek ekVar, dv dvVar);

    /* synthetic */ void setGuildListSort(ArrayList<String> arrayList, vh2.cy cyVar);

    /* synthetic */ void setGuildListTop(String str, int i3, int i16, wh2.eh ehVar);

    /* synthetic */ void setGuildMemberName(String str, String str2, String str3, dv dvVar);

    /* synthetic */ void setGuildName(String str, String str2, vh2.cx cxVar);

    /* synthetic */ void setGuildNeedRealNameForVisitor(String str, boolean z16, em emVar);

    /* synthetic */ void setGuildNumSearchSwitch(long j3, int i3, dv dvVar);

    /* synthetic */ void setGuildProfile(String str, String str2, cd cdVar);

    /* synthetic */ void setGuildQRCodePeriod(String str, int i3, cd cdVar);

    /* synthetic */ void setGuildQRCodeSwitch(long j3, int i3, dv dvVar);

    /* synthetic */ void setGuildShutUp(String str, long j3, @NonNull cd cdVar);

    /* synthetic */ void setGuildSpeakableThreshold(String str, com.tencent.mobileqq.qqguildsdk.data.fc fcVar, dv dvVar);

    /* synthetic */ void setGuildTop(String str, boolean z16, vh2.da daVar);

    /* synthetic */ void setGuildUnNotifyFlag(String str, int i3, vh2.cz czVar);

    /* synthetic */ void setGuildVisibilityForVisitor(String str, boolean z16, @NonNull cc ccVar);

    /* synthetic */ void setGuildWeakNotifyDisplay(String str, int i3, vh2.db dbVar);

    /* synthetic */ void setJoinGuildOption(com.tencent.mobileqq.qqguildsdk.data.genc.el elVar, dv dvVar);

    /* synthetic */ void setJumpToCategory(com.tencent.mobileqq.qqguildsdk.data.genc.de deVar, dv dvVar);

    /* synthetic */ void setListenTogetherPlayOpt(long j3, long j16, int i3, dn dnVar);

    /* synthetic */ void setListenTogetherPlayVolumeByAdmin(long j3, long j16, int i3, dn dnVar);

    /* synthetic */ void setLiveChannelAnchorList(String str, String str2, List<String> list, List<String> list2, cd cdVar);

    /* synthetic */ void setLiveChannelBannedUser(String str, String str2, String str3, String str4, int i3, cc ccVar);

    void setLocation(GProLocationInfo gProLocationInfo, cc ccVar);

    @Override // uh2.f
    /* synthetic */ void setMemberRoles(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cd cdVar);

    /* synthetic */ void setMemberShutUp(String str, String str2, long j3, @NonNull cd cdVar);

    /* synthetic */ void setMyBirthday(short s16, short s17, short s18, em emVar);

    /* synthetic */ void setMyMsgNotifyType(String str, String str2, int i3, vh2.cs csVar);

    /* synthetic */ void setMyPersonalSignature(String str, em emVar);

    /* synthetic */ void setMyProfileShowTypeSwitch(String str, int i3, int i16, em emVar);

    /* synthetic */ void setMyVoiceNetworkQuality(String str, String str2, int i3);

    /* synthetic */ void setMyVoiceSysMicStatus(String str, String str2, int i3);

    void setNickName(String str, cc ccVar);

    /* synthetic */ void setOnLogin(boolean z16);

    /* synthetic */ void setProfileSwitch(int i3, boolean z16, em emVar);

    @Override // uh2.e
    /* synthetic */ void setQQMsgListChannel(@NotNull String str, @NotNull String str2, int i3, @NotNull cc ccVar);

    /* synthetic */ void setQQMsgListGuild(long j3, int i3, int i16, wh2.ej ejVar);

    @Override // uh2.f
    /* synthetic */ void setRoleInfo(String str, String str2, @NonNull fn fnVar, @NonNull cd cdVar);

    /* synthetic */ void setRoleMembers(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cd cdVar);

    @Override // uh2.f
    /* synthetic */ void setRoleOrder(String str, @NonNull List<String> list, @NonNull cd cdVar);

    @Override // uh2.f
    /* synthetic */ void setRoleSpeakableChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);

    @Override // uh2.f
    /* synthetic */ void setRoleVisibleChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);

    /* synthetic */ void setScreenSharedInGuild(String str, String str2, boolean z16, co coVar);

    /* synthetic */ void setSearchSwitch(com.tencent.mobileqq.qqguildsdk.data.genc.em emVar, wh2.ek ekVar);

    void setSelfTinyId(String str);

    /* synthetic */ void setShowArchive(String str, boolean z16, vh2.dd ddVar);

    /* synthetic */ void setShowPresence(String str, boolean z16, vh2.dd ddVar);

    /* synthetic */ void setTopicSquareEntranceSwitch(long j3, boolean z16, dv dvVar);

    /* synthetic */ void setUserLiveInfo(int i3, String str, String str2, int i16, vh2.dc dcVar);

    /* synthetic */ void setUserMuteSeatInGuild(String str, String str2, String str3, boolean z16, cc ccVar);

    /* synthetic */ void setUserPermissionInGuild(long j3, long j16, long j17, boolean z16, dv dvVar);

    /* synthetic */ void setUserType(String str, vh2.dg dgVar);

    /* synthetic */ void setUserTypeWithUserConfigure(boolean z16, wh2.et etVar);

    /* synthetic */ void setUserVoicelessToMe(String str, boolean z16, cc ccVar);

    /* synthetic */ void startPollingForDiscoverState();

    /* synthetic */ void stopPollingForDiscoverState(boolean z16);

    /* synthetic */ void subscribePolling(@NonNull String str);

    /* synthetic */ void subscribePollingChannels(@NonNull List<fj> list);

    /* synthetic */ void subscribePollingSchedule(eq eqVar);

    /* synthetic */ void superAdminBanUser(com.tencent.mobileqq.qqguildsdk.data.genc.er erVar, em emVar);

    /* synthetic */ void superAdminUnListFeed(com.tencent.mobileqq.qqguildsdk.data.genc.w wVar, wh2.en enVar);

    /* synthetic */ void switchAVLobbyApp(es esVar, wh2.p pVar);

    /* synthetic */ void terminateLiveStream(String str, String str2, int i3, int i16, vh2.de deVar);

    /* synthetic */ void terminateLiveStream(String str, String str2, int i3, vh2.de deVar);

    @Override // uh2.b
    /* synthetic */ void topSpeakOrderByAdmin(o oVar, wh2.c cVar);

    /* synthetic */ void transThirdPlatformURL(ev evVar, wh2.eo eoVar);

    /* synthetic */ void transThirdVideoURL(ew ewVar, wh2.ep epVar);

    /* synthetic */ void transferGuildOwner(ex exVar, em emVar);

    /* synthetic */ void tryUnmuteMicrophone(String str, String str2, boolean z16, @NonNull cc ccVar);

    /* synthetic */ void ubsubscribePollingChannels(@NonNull List<fj> list);

    /* synthetic */ void unsubscribePolling(@NonNull String str);

    /* synthetic */ void updateArchiveShowSeq(ArrayList<Integer> arrayList, vh2.df dfVar);

    /* synthetic */ void updateAudioLiveChannelTheme(fa faVar, em emVar);

    /* synthetic */ void updateForumChannelSortMode(String str, String str2, int i3, @NonNull cd cdVar);

    /* synthetic */ void updateGuildEssence(ch chVar, dh dhVar);

    /* synthetic */ void updateGuildTaskCardProgress(fb fbVar, em emVar);

    /* synthetic */ void updateGuildVisitor(ch chVar, dh dhVar);

    /* synthetic */ void upgradeGroupFeed(ArrayList<Long> arrayList, int i3, wh2.eq eqVar);

    @Override // uh2.b
    /* synthetic */ void userDealSpeakInvitation(fc fcVar, er erVar);

    @Override // uh2.b
    /* synthetic */ void userHandUp(fc fcVar, er erVar);

    /* synthetic */ void userOnlineReport(com.tencent.mobileqq.qqguildsdk.data.genc.cn cnVar, wh2.es esVar);

    /* synthetic */ void userShareScreen(fc fcVar, er erVar);

    /* synthetic */ void voiceChannelAuth0x10b6(String str, String str2, int i3, boolean z16, int i16, vh2.dh dhVar);

    /* synthetic */ void voiceSmobaGameCreateRoom(com.tencent.mobileqq.qqguildsdk.data.genc.fi fiVar, com.tencent.mobileqq.qqguildsdk.data.genc.fm fmVar, eu euVar);

    /* synthetic */ void voiceSmobaGameDissmissRoom(com.tencent.mobileqq.qqguildsdk.data.genc.fj fjVar, em emVar);

    /* synthetic */ void voiceSmobaGameEnterRoom(long j3, int i3, long j16, long j17, wh2.ev evVar);

    /* synthetic */ void voiceSmobaGameKickOutRoom(com.tencent.mobileqq.qqguildsdk.data.genc.fk fkVar, wh2.ex exVar);

    /* synthetic */ void voiceSmobaGameQuitRoom(fl flVar, wh2.ew ewVar);
}
