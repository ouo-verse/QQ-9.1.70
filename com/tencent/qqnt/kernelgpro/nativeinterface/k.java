package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final /* synthetic */ class k {
    public static ArrayList B3(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static GProFaceAuthInfo C3(IKernelGuildService iKernelGuildService) {
        return null;
    }

    public static GProGuildRole C4(IKernelGuildService iKernelGuildService, long j3, long j16, long j17) {
        return null;
    }

    public static GProGuildRole D4(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, int i3) {
        return null;
    }

    public static GProCategoryChannelInfoList E4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return null;
    }

    public static ArrayList F3(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static boolean F5(IKernelGuildService iKernelGuildService, long j3) {
        return false;
    }

    public static boolean G5(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return false;
    }

    public static boolean H5(IKernelGuildService iKernelGuildService, long j3) {
        return false;
    }

    public static boolean I5(IKernelGuildService iKernelGuildService) {
        return false;
    }

    public static GProOnlineMemberInfo K4(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static GProGetCategoryPageGuildsRsp L9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGetCategoryPageGuildsRsp(bArr);
    }

    public static int M4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return 0;
    }

    public static GProGetCategoryTabContentRsp M9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGetCategoryTabContentRsp(bArr);
    }

    public static ArrayList N4(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static GProGetConfigTabContentRsp N9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGetConfigTabContentRsp(bArr);
    }

    public static GProGlobalBanner O3(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static GProPollingChannelState O4(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
        return null;
    }

    public static GProGetMyTabContentRsp O9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGetMyTabContentRsp(bArr);
    }

    public static HashMap P2(IKernelGuildService iKernelGuildService, long j3) {
        return new HashMap();
    }

    public static GProGetRecommendTabContentRsp P9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGetRecommendTabContentRsp(bArr);
    }

    public static GProGuildAdvFeedPos Q9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGuildAdvFeedPos(bArr);
    }

    public static GProGuild R3(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static ArrayList<GProGuild> R9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProGuilds(bArr);
    }

    public static GProQQMsgListChannel S4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return null;
    }

    public static ArrayList<GProNavigationTab> S9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProNavigationTabs(bArr);
    }

    public static GProGuildUserState T2(IKernelGuildService iKernelGuildService) {
        return null;
    }

    public static ArrayList T3(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static ArrayList T4(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static GProSysPromptDigest T9(byte[] bArr) {
        return IKernelGuildService.CppProxy.decodeGProSysPromptDigest(bArr);
    }

    public static ArrayList U4(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static byte[] U9(ArrayList<GProGuild> arrayList) {
        return IKernelGuildService.CppProxy.encodeGProGuilds(arrayList);
    }

    public static GProAppChnnPreInfo V2(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return null;
    }

    public static GProRecentVisitChannelList V4(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static byte[] V9(ArrayList<GProNavigationTab> arrayList) {
        return IKernelGuildService.CppProxy.encodeGProNavigationTabs(arrayList);
    }

    public static GProInviteInfo W(IKernelGuildService iKernelGuildService, GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo) {
        return null;
    }

    public static ArrayList W2(IKernelGuildService iKernelGuildService, long j3) {
        return new ArrayList();
    }

    public static GProGetRecentVisitGuildInfosFromCacheRsp W4(IKernelGuildService iKernelGuildService, int i3, int i16) {
        return null;
    }

    public static byte[] W9(GProShareAttaData gProShareAttaData) {
        return IKernelGuildService.CppProxy.encodeShareAttaData(gProShareAttaData);
    }

    public static ArrayList X2(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static ArrayList X3(IKernelGuildService iKernelGuildService, long j3) {
        return new ArrayList();
    }

    public static boolean X5(IKernelGuildService iKernelGuildService, int i3, int i16, GProMsgRouttingHead gProMsgRouttingHead, byte[] bArr) {
        return false;
    }

    public static GProGetContentRecommendRsp X9(byte[] bArr) {
        return IKernelGuildService.CppProxy.fastDecodeMVPFeedsRspPb(bArr);
    }

    public static String Y9(String str) {
        return IKernelGuildService.CppProxy.getFullAvatarPendantUrl(str);
    }

    public static long Z3(IKernelGuildService iKernelGuildService, long j3) {
        return 0L;
    }

    public static String Z9(String str, int i3) {
        return IKernelGuildService.CppProxy.getFullAvatarUrl(str, i3);
    }

    public static byte[] aa(byte[] bArr) {
        return IKernelGuildService.CppProxy.lz4DecompressBuf(bArr);
    }

    public static GProSpeakPermissionInfo b4(IKernelGuildService iKernelGuildService, long j3, int i3) {
        return null;
    }

    public static void ba() {
        IKernelGuildService.CppProxy.preloadInitJni();
    }

    public static String c4(IKernelGuildService iKernelGuildService, long j3) {
        return "";
    }

    public static void ca(int i3) {
        IKernelGuildService.CppProxy.setSdkLoggerLevel(i3);
    }

    public static HashMap d4(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
        return new HashMap();
    }

    public static GProGuildRole d5(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return null;
    }

    public static String e4(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
        return "";
    }

    public static ArrayList e5(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return new ArrayList();
    }

    public static ArrayList f3(IKernelGuildService iKernelGuildService, long j3) {
        return new ArrayList();
    }

    public static HashMap f4(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, int i3) {
        return new HashMap();
    }

    public static ArrayList g3(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new ArrayList();
    }

    public static ArrayList g4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return new ArrayList();
    }

    public static ArrayList h3(IKernelGuildService iKernelGuildService, long j3) {
        return new ArrayList();
    }

    public static HashMap h4(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new HashMap();
    }

    public static ArrayList i3(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new ArrayList();
    }

    public static HashMap i4(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new HashMap();
    }

    public static GProClientIdentity j4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return null;
    }

    public static GProGetContentRecommendRsp k0(IKernelGuildService iKernelGuildService, byte[] bArr) {
        return null;
    }

    public static String k4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return "";
    }

    public static GProScheduleInfo l0(IKernelGuildService iKernelGuildService, byte[] bArr) {
        return null;
    }

    public static HashMap l4(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new HashMap();
    }

    public static int m4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return 0;
    }

    public static int m5(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return 0;
    }

    public static ArrayList n3(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return new ArrayList();
    }

    public static GProMedal n4(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static int n5(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16) {
        return 0;
    }

    public static HashMap o4(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
        return new HashMap();
    }

    public static GProSimpleProfile o5(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
        return null;
    }

    public static String p4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return "";
    }

    public static HashMap q4(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList) {
        return new HashMap();
    }

    public static ArrayList q5(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static HashMap r3(IKernelGuildService iKernelGuildService, GProGetChannelIdsWithGuildIdsFromCacheReq gProGetChannelIdsWithGuildIdsFromCacheReq) {
        return new HashMap();
    }

    public static String r4(IKernelGuildService iKernelGuildService, long j3) {
        return "";
    }

    public static ArrayList r5(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static boolean r6(IKernelGuildService iKernelGuildService, long j3) {
        return false;
    }

    public static GProChannel s3(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static HashMap s4(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
        return new HashMap();
    }

    public static ArrayList s5(IKernelGuildService iKernelGuildService, long j3, int i3) {
        return new ArrayList();
    }

    public static ArrayList t3(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return new ArrayList();
    }

    public static long t4(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return 0L;
    }

    public static ArrayList t5(IKernelGuildService iKernelGuildService) {
        return new ArrayList();
    }

    public static int w3(IKernelGuildService iKernelGuildService, long j3, long j16) {
        return 0;
    }

    public static GProJumpToCategoryInfo y4(IKernelGuildService iKernelGuildService, long j3) {
        return null;
    }

    public static boolean z5(IKernelGuildService iKernelGuildService, long j3) {
        return false;
    }

    public static void D8(IKernelGuildService iKernelGuildService) {
    }

    public static void a(IKernelGuildService iKernelGuildService) {
    }

    public static void b(IKernelGuildService iKernelGuildService) {
    }

    public static void d9(IKernelGuildService iKernelGuildService) {
    }

    public static void C6(IKernelGuildService iKernelGuildService, IGProReportJoinRecommendGuild iGProReportJoinRecommendGuild) {
    }

    public static void E2(IKernelGuildService iKernelGuildService, IGProFetchSubscribeUserGuideCallback iGProFetchSubscribeUserGuideCallback) {
    }

    public static void E8(IKernelGuildService iKernelGuildService, boolean z16) {
    }

    public static void H3(IKernelGuildService iKernelGuildService, IGProLoadGuildAndChnListCallback iGProLoadGuildAndChnListCallback) {
    }

    public static void I2(IKernelGuildService iKernelGuildService, IGProFetchVersionNewsCallback iGProFetchVersionNewsCallback) {
    }

    public static void I3(IKernelGuildService iKernelGuildService, IGProGetGuildBindableGroupsCallback iGProGetGuildBindableGroupsCallback) {
    }

    public static void I6(IKernelGuildService iKernelGuildService, IGProRequestPubAccountMsgCountCallback iGProRequestPubAccountMsgCountCallback) {
    }

    public static void L2(IKernelGuildService iKernelGuildService, IGProGetAISearchRecommendWordsCallback iGProGetAISearchRecommendWordsCallback) {
    }

    public static void M(IKernelGuildService iKernelGuildService, IGProCheckIsStrangerNewMemberCallback iGProCheckIsStrangerNewMemberCallback) {
    }

    public static void O8(IKernelGuildService iKernelGuildService, long j3) {
    }

    public static void R(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
    }

    public static void R4(IKernelGuildService iKernelGuildService, IGProGetProfileSwitchCallback iGProGetProfileSwitchCallback) {
    }

    public static void U5(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void V6(IKernelGuildService iKernelGuildService, GProHeartbeatReq gProHeartbeatReq) {
    }

    public static void W6(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
    }

    public static void Y4(IKernelGuildService iKernelGuildService, IGProGetRecommendGuildInfoCallback iGProGetRecommendGuildInfoCallback) {
    }

    public static void Z5(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void c2(IKernelGuildService iKernelGuildService, IGProFetchLiveSecurityTipsCallback iGProFetchLiveSecurityTipsCallback) {
    }

    public static void d(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void e6(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void e9(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void f(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void f5(IKernelGuildService iKernelGuildService, IGProGetRtmpPushUrlCallback iGProGetRtmpPushUrlCallback) {
    }

    public static void f9(IKernelGuildService iKernelGuildService, boolean z16) {
    }

    public static void h9(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
    }

    public static void i2(IKernelGuildService iKernelGuildService, IGProFetchMyCreateGuildsCallback iGProFetchMyCreateGuildsCallback) {
    }

    public static void i9(IKernelGuildService iKernelGuildService, GProSubscribePollingScheduleReq gProSubscribePollingScheduleReq) {
    }

    public static void k(IKernelGuildService iKernelGuildService, IKernelGuildListener iKernelGuildListener) {
    }

    public static void k6(IKernelGuildService iKernelGuildService, boolean z16) {
    }

    public static void n7(IKernelGuildService iKernelGuildService, GProHeartbeatReq gProHeartbeatReq) {
    }

    public static void o(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void s9(IKernelGuildService iKernelGuildService, ArrayList arrayList) {
    }

    public static void t1(IKernelGuildService iKernelGuildService, IGProFetchDirectMsgStatusCallback iGProFetchDirectMsgStatusCallback) {
    }

    public static void t6(IKernelGuildService iKernelGuildService, IKernelGuildListener iKernelGuildListener) {
    }

    public static void t9(IKernelGuildService iKernelGuildService, long j3) {
    }

    public static void v0(IKernelGuildService iKernelGuildService, String str) {
    }

    public static void v1(IKernelGuildService iKernelGuildService, IGProGetFeedCommentsNotifySwitchCallback iGProGetFeedCommentsNotifySwitchCallback) {
    }

    public static void v4(IKernelGuildService iKernelGuildService, IGProGetGuildsInContactCallback iGProGetGuildsInContactCallback) {
    }

    public static void w1(IKernelGuildService iKernelGuildService, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback) {
    }

    public static void y0(IKernelGuildService iKernelGuildService, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void z6(IKernelGuildService iKernelGuildService, long j3) {
    }

    public static void Y6(IKernelGuildService iKernelGuildService, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, GProScheduleSendArkGuildInfo gProScheduleSendArkGuildInfo, long j3, int i3, String str, String str2, String str3, byte[] bArr, IGProSendScheduleArkMessageCallback iGProSendScheduleArkMessageCallback) {
    }

    public static void A0(IKernelGuildService iKernelGuildService, GProEnterAudioLiveChannelReq gProEnterAudioLiveChannelReq, IGProEnterAudioLiveChannelCallback iGProEnterAudioLiveChannelCallback) {
    }

    public static void A1(IKernelGuildService iKernelGuildService, long j3, IGProGuildActiveValueCallback iGProGuildActiveValueCallback) {
    }

    public static void A3(IKernelGuildService iKernelGuildService, GProDiscoverAudioVideoInfosReq gProDiscoverAudioVideoInfosReq, IGProGetDiscoverAudioVideoInfosCallback iGProGetDiscoverAudioVideoInfosCallback) {
    }

    public static void A5(IKernelGuildService iKernelGuildService, long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void B4(IKernelGuildService iKernelGuildService, GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetLiveAudioPollingCtxV2Callback iGProGetLiveAudioPollingCtxV2Callback) {
    }

    public static void B6(IKernelGuildService iKernelGuildService, GProFeedbackReq gProFeedbackReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void B9(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void C1(IKernelGuildService iKernelGuildService, GProBottomTabExpReq gProBottomTabExpReq, IGProFetchGuildBottomTabExpCallback iGProFetchGuildBottomTabExpCallback) {
    }

    public static void C5(IKernelGuildService iKernelGuildService, GProCmd0xf67ReqBody gProCmd0xf67ReqBody, IGProJoinGuildCallback iGProJoinGuildCallback) {
    }

    public static void C8(IKernelGuildService iKernelGuildService, String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void C9(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void D0(IKernelGuildService iKernelGuildService, GProExposureGuildTaskCardReq gProExposureGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void D3(IKernelGuildService iKernelGuildService, GProGetGuildFriendsReq gProGetGuildFriendsReq, IGProGetFriendsInGuildCallback iGProGetFriendsInGuildCallback) {
    }

    public static void D5(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void D6(IKernelGuildService iKernelGuildService, GProPAReportExecuteReq gProPAReportExecuteReq, IGProPAReportExecuteCallback iGProPAReportExecuteCallback) {
    }

    public static void D9(IKernelGuildService iKernelGuildService, GProGuildOnlineReportReq gProGuildOnlineReportReq, IGProUserOnlineReportCallback iGProUserOnlineReportCallback) {
    }

    public static void E0(IKernelGuildService iKernelGuildService, GProExposeRecommedsReq gProExposeRecommedsReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void E3(IKernelGuildService iKernelGuildService, GProGetFriendsRecommendReq gProGetFriendsRecommendReq, IGProGetFriendsRecommendCallback iGProGetFriendsRecommendCallback) {
    }

    public static void E5(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void E6(IKernelGuildService iKernelGuildService, GProReportShareAttaReq gProReportShareAttaReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void E9(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void F(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void F0(IKernelGuildService iKernelGuildService, long j3, IGProFetchActiveChannelsCallback iGProFetchActiveChannelsCallback) {
    }

    public static void F1(IKernelGuildService iKernelGuildService, GProGuildInfoAndMemberListReq gProGuildInfoAndMemberListReq, IGProFetchGuildInfoAndMemberListCallback iGProFetchGuildInfoAndMemberListCallback) {
    }

    public static void G(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void G2(IKernelGuildService iKernelGuildService, GProFetchUserJoinedGuildListReq gProFetchUserJoinedGuildListReq, IGProFetchUserJoinedGuildListCallbackV2 iGProFetchUserJoinedGuildListCallbackV2) {
    }

    public static void G4(IKernelGuildService iKernelGuildService, long j3, IGProGetMsgNotifyTypeCallback iGProGetMsgNotifyTypeCallback) {
    }

    public static void H1(IKernelGuildService iKernelGuildService, long j3, IGProFetchGuildSearchSwitchCallback iGProFetchGuildSearchSwitchCallback) {
    }

    public static void H4(IKernelGuildService iKernelGuildService, GProGetMyTabContentReq gProGetMyTabContentReq, IGProGetMyTabContentCallback iGProGetMyTabContentCallback) {
    }

    public static void H9(IKernelGuildService iKernelGuildService, GProVoiceSmobaGameDissmissRoomReq gProVoiceSmobaGameDissmissRoomReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void I0(IKernelGuildService iKernelGuildService, GProAnchorPrepareReq gProAnchorPrepareReq, IGProFetchAnchorPreparePageCallback iGProFetchAnchorPreparePageCallback) {
    }

    public static void I4(IKernelGuildService iKernelGuildService, GProGetNavigationReq gProGetNavigationReq, IGProGetNavigationCallback iGProGetNavigationCallback) {
    }

    public static void J(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void J0(IKernelGuildService iKernelGuildService, long j3, IGProFetchAppInfosCallback iGProFetchAppInfosCallback) {
    }

    public static void J3(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildBindingInfoCallback iGProGetGuildBindingInfoCallback) {
    }

    public static void J4(IKernelGuildService iKernelGuildService, GProGetNavigationStatusReq gProGetNavigationStatusReq, IGProGetNavigationStatusCallback iGProGetNavigationStatusCallback) {
    }

    public static void J5(IKernelGuildService iKernelGuildService, GProGuildTaskJoinChannelReq gProGuildTaskJoinChannelReq, IGProJoinChannelByGuildTaskCallback iGProJoinChannelByGuildTaskCallback) {
    }

    public static void J6(IKernelGuildService iKernelGuildService, GProRiskMemberListReq gProRiskMemberListReq, IGProRiskMemberListCallback iGProRiskMemberListCallback) {
    }

    public static void J7(IKernelGuildService iKernelGuildService, int i3, IGProSetFeedCommentsNotifySwitchCallback iGProSetFeedCommentsNotifySwitchCallback) {
    }

    public static void J9(IKernelGuildService iKernelGuildService, GProVoiceSmobaGameKickOutRoomReq gProVoiceSmobaGameKickOutRoomReq, IGProVoiceSmobaKickOutRoomCallback iGProVoiceSmobaKickOutRoomCallback) {
    }

    public static void K(IKernelGuildService iKernelGuildService, GProEncryptTextReq gProEncryptTextReq, IGProCheckAndEncryptTextCallBack iGProCheckAndEncryptTextCallBack) {
    }

    public static void K1(IKernelGuildService iKernelGuildService, long j3, IGProFetchGuildSpeakableRuleCallback iGProFetchGuildSpeakableRuleCallback) {
    }

    public static void K2(IKernelGuildService iKernelGuildService, long j3, IGproXWorldInfoCallback iGproXWorldInfoCallback) {
    }

    public static void K6(IKernelGuildService iKernelGuildService, GProSaveCustomApplicationReq gProSaveCustomApplicationReq, IGProSaveCustomApplicationCallback iGProSaveCustomApplicationCallback) {
    }

    public static void K7(IKernelGuildService iKernelGuildService, int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void K9(IKernelGuildService iKernelGuildService, GProVoiceSmobaGameQuitRoomReq gProVoiceSmobaGameQuitRoomReq, IGProVoiceSmobaGameQuitRoomCallback iGProVoiceSmobaGameQuitRoomCallback) {
    }

    public static void L(IKernelGuildService iKernelGuildService, GProCheckFeedAbstractInfoReq gProCheckFeedAbstractInfoReq, IGProCheckFeedAbstractInfoCallback iGProCheckFeedAbstractInfoCallback) {
    }

    public static void L1(IKernelGuildService iKernelGuildService, long j3, IGProFetchGuildSpeakableThresholdCallback iGProFetchGuildSpeakableThresholdCallback) {
    }

    public static void L3(IKernelGuildService iKernelGuildService, GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback) {
    }

    public static void L4(IKernelGuildService iKernelGuildService, GproGetOpenShareInfoReq gproGetOpenShareInfoReq, IGProGetOpenShareInfoCallback iGProGetOpenShareInfoCallback) {
    }

    public static void L6(IKernelGuildService iKernelGuildService, GProSaveGuildNavigationReq gProSaveGuildNavigationReq, IGProSaveGuildNavigationCallback iGProSaveGuildNavigationCallback) {
    }

    public static void M1(IKernelGuildService iKernelGuildService, GProAllGuildTaskCardReq gProAllGuildTaskCardReq, IGProFetchGuildTaskCardsCallback iGProFetchGuildTaskCardsCallback) {
    }

    public static void M6(IKernelGuildService iKernelGuildService, GProSearchBlackUserReq gProSearchBlackUserReq, IGProSearchBlackUserFromServerCallback iGProSearchBlackUserFromServerCallback) {
    }

    public static void N0(IKernelGuildService iKernelGuildService, GProAVMemberGroupListReq gProAVMemberGroupListReq, IGProFetchAudioLiveGroupListCallback iGProFetchAudioLiveGroupListCallback) {
    }

    public static void N3(IKernelGuildService iKernelGuildService, GProGuildSearchGetFeedCalendarReq gProGuildSearchGetFeedCalendarReq, IGProGuildGetFeedValidCalendarCallback iGProGuildGetFeedValidCalendarCallback) {
    }

    public static void N5(IKernelGuildService iKernelGuildService, boolean z16, IGProLoadGuildAndChannelsCallback iGProLoadGuildAndChannelsCallback) {
    }

    public static void N7(IKernelGuildService iKernelGuildService, GProGuildAuditInfoReq gProGuildAuditInfoReq, IGProAuditInfoResultCallback iGProAuditInfoResultCallback) {
    }

    public static void N8(IKernelGuildService iKernelGuildService, GProSetSearchSwitchReq gProSetSearchSwitchReq, IGProSetSearchSwitchCallback iGProSetSearchSwitchCallback) {
    }

    public static void O(IKernelGuildService iKernelGuildService, GProPreventAddictionCheckReq gProPreventAddictionCheckReq, IGProPreventAddictionCheckCallback iGProPreventAddictionCheckCallback) {
    }

    public static void O0(IKernelGuildService iKernelGuildService, GProAudioLiveUserListReq gProAudioLiveUserListReq, IGProFetchAudioLiveUserListCallback iGProFetchAudioLiveUserListCallback) {
    }

    public static void O1(IKernelGuildService iKernelGuildService, String str, IGProFetchInviteInfoCallback iGProFetchInviteInfoCallback) {
    }

    public static void O2(IKernelGuildService iKernelGuildService, GProGetAISearchShareURLReq gProGetAISearchShareURLReq, IGProGetAISearchShareURLCallback iGProGetAISearchShareURLCallback) {
    }

    public static void O7(IKernelGuildService iKernelGuildService, GProSortAndWriteBindGroupsReq gProSortAndWriteBindGroupsReq, IGProSetGuildBoundGroupsCallback iGProSetGuildBoundGroupsCallback) {
    }

    public static void P0(IKernelGuildService iKernelGuildService, GProBatchBotGetCommand gProBatchBotGetCommand, IGProFetchBatchBotGetCommandCallback iGProFetchBatchBotGetCommandCallback) {
    }

    public static void P3(IKernelGuildService iKernelGuildService, GProGetGuildHomeCategoriesReq gProGetGuildHomeCategoriesReq, IGProGetGuildHomeCategoriesCallback iGProGetGuildHomeCategoriesCallback) {
    }

    public static void P6(IKernelGuildService iKernelGuildService, GProGuildSearchNewSearchReq gProGuildSearchNewSearchReq, IGProGuildSearchCallback iGProGuildSearchCallback) {
    }

    public static void Q(IKernelGuildService iKernelGuildService, GProUserFreeGiftReq gProUserFreeGiftReq, IGProCheckUserFreeGiftCallback iGProCheckUserFreeGiftCallback) {
    }

    public static void Q0(IKernelGuildService iKernelGuildService, GProFetchCategoryAdminDisplayInfoReq gProFetchCategoryAdminDisplayInfoReq, IGProFetchCategoryAdminInfoListCallback iGProFetchCategoryAdminInfoListCallback) {
    }

    public static void Q1(IKernelGuildService iKernelGuildService, long j3, IGProFetchIsLiveChannelOpenCallback iGProFetchIsLiveChannelOpenCallback) {
    }

    public static void Q2(IKernelGuildService iKernelGuildService, long j3, IGProGetActiveLiveAudioChannelNumCallback iGProGetActiveLiveAudioChannelNumCallback) {
    }

    public static void Q3(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildHomeSectionsCallback iGProGetGuildHomeSectionsCallback) {
    }

    public static void Q4(IKernelGuildService iKernelGuildService, GProGetPreviewNavigationReq gProGetPreviewNavigationReq, IGProGetPreviewNavigationCallback iGProGetPreviewNavigationCallback) {
    }

    public static void Q6(IKernelGuildService iKernelGuildService, GProSearchGuildFeedsReq gProSearchGuildFeedsReq, IGProSearchChannelContentCallback iGProSearchChannelContentCallback) {
    }

    public static void R1(IKernelGuildService iKernelGuildService, long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void R2(IKernelGuildService iKernelGuildService, GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetActiveLiveAudioChannelNumV2Callback iGProGetActiveLiveAudioChannelNumV2Callback) {
    }

    public static void R5(IKernelGuildService iKernelGuildService, long j3, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
    }

    public static void R6(IKernelGuildService iKernelGuildService, GProGuildMemberSearchParams gProGuildMemberSearchParams, IGProSearchGuildMembersBySourceIdCallback iGProSearchGuildMembersBySourceIdCallback) {
    }

    public static void S1(IKernelGuildService iKernelGuildService, long j3, IGProFetchIsVoiceChannelOpenCallback iGProFetchIsVoiceChannelOpenCallback) {
    }

    public static void S2(IKernelGuildService iKernelGuildService, GProGuildSearchGetAllGuildAIInfoReq gProGuildSearchGetAllGuildAIInfoReq, IGProGetAllGuildSearchAIInfoCallback iGProGetAllGuildSearchAIInfoCallback) {
    }

    public static void S3(IKernelGuildService iKernelGuildService, GProGetGuildLabelReq gProGetGuildLabelReq, IGProGetGuildLableInfoCallback iGProGetGuildLableInfoCallback) {
    }

    public static void S6(IKernelGuildService iKernelGuildService, GProMsgSearchReq gProMsgSearchReq, IGProSearchMsgSeqsFromServerCallback iGProSearchMsgSeqsFromServerCallback) {
    }

    public static void S7(IKernelGuildService iKernelGuildService, long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void S8(IKernelGuildService iKernelGuildService, String str, String str2) {
    }

    public static void T(IKernelGuildService iKernelGuildService, long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void T1(IKernelGuildService iKernelGuildService, GProFetchJoinGuildOptionReq gProFetchJoinGuildOptionReq, IGProFetchJoinGuildOptionCallback iGProFetchJoinGuildOptionCallback) {
    }

    public static void T7(IKernelGuildService iKernelGuildService, GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback) {
    }

    public static void U3(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildMainFrameHeaderCallback iGProGetGuildMainFrameHeaderCallback) {
    }

    public static void U6(IKernelGuildService iKernelGuildService, GProSendNoticeReq gProSendNoticeReq, IGProSendAudioOrLiveNoticeCallback iGProSendAudioOrLiveNoticeCallback) {
    }

    public static void U7(IKernelGuildService iKernelGuildService, GProSetGlobalPermissionReq gProSetGlobalPermissionReq, IGProResultCallback iGProResultCallback) {
    }

    public static void V(IKernelGuildService iKernelGuildService, GProConvertThirdIdReq gProConvertThirdIdReq, IGProConvertGuildAndThirdIdCallback iGProConvertGuildAndThirdIdCallback) {
    }

    public static void V3(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildMemberNumCallback iGProGetGuildMemberNumCallback) {
    }

    public static void V7(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProSetGuildListSortCallback iGProSetGuildListSortCallback) {
    }

    public static void W1(IKernelGuildService iKernelGuildService, long j3, IGProFetchJumpInfoCallback iGProFetchJumpInfoCallback) {
    }

    public static void W3(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildNumCallback iGProGetGuildNumCallback) {
    }

    public static void W5(IKernelGuildService iKernelGuildService, GProModifyScheduleInviteReq gProModifyScheduleInviteReq, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback) {
    }

    public static void X0(IKernelGuildService iKernelGuildService, long j3, boolean z16) {
    }

    public static void X4(IKernelGuildService iKernelGuildService, GetRecommendForIntroReq getRecommendForIntroReq, IGProGetRecommendForIntroCallback iGProGetRecommendForIntroCallback) {
    }

    public static void X6(IKernelGuildService iKernelGuildService, GProSaveMsgReq gProSaveMsgReq, IGProSendOperationSaveMsgCallBack iGProSendOperationSaveMsgCallBack) {
    }

    public static void X8(IKernelGuildService iKernelGuildService, String str, IGProUserTypeSetCallback iGProUserTypeSetCallback) {
    }

    public static void Y5(IKernelGuildService iKernelGuildService, GProCreateLobbyReq gProCreateLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback) {
    }

    public static void Y8(IKernelGuildService iKernelGuildService, boolean z16, IGProUserTypeSetCallback iGProUserTypeSetCallback) {
    }

    public static void Z(IKernelGuildService iKernelGuildService, GProDirectMsgCreateInfo gProDirectMsgCreateInfo, IGProCreateDirectMsgSessionCallback iGProCreateDirectMsgSessionCallback) {
    }

    public static void Z2(IKernelGuildService iKernelGuildService, String str, IGProAssociativeWordsCallback iGProAssociativeWordsCallback) {
    }

    public static void Z4(IKernelGuildService iKernelGuildService, GProGetRecommendQuickJoinReq gProGetRecommendQuickJoinReq, IGProGetRecommendQuickJoinCallback iGProGetRecommendQuickJoinCallback) {
    }

    public static void a0(IKernelGuildService iKernelGuildService, GProCreateGuildReq gProCreateGuildReq, IGProCreateGuildCallback iGProCreateGuildCallback) {
    }

    public static void a1(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProFetchChannelListCategoryCallback iGProFetchChannelListCategoryCallback) {
    }

    public static void a4(IKernelGuildService iKernelGuildService, long j3, IGProGetGuildShowWeakNotifyCallback iGProGetGuildShowWeakNotifyCallback) {
    }

    public static void a5(IKernelGuildService iKernelGuildService, GProGetRecommendTabContentReq gProGetRecommendTabContentReq, IGProGetRecommendTabContentCallback iGProGetRecommendTabContentCallback) {
    }

    public static void a6(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void a9(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void b1(IKernelGuildService iKernelGuildService, long j3, IGProFetchChannelListForJumpCallback iGProFetchChannelListForJumpCallback) {
    }

    public static void b2(IKernelGuildService iKernelGuildService, GProLiveRoomInfoReq gProLiveRoomInfoReq, IGProFetchLiveChannelInfoListCallback iGProFetchLiveChannelInfoListCallback) {
    }

    public static void b3(IKernelGuildService iKernelGuildService, GProGetBannersReq gProGetBannersReq, IGProGetBannersCallback iGProGetBannersCallback) {
    }

    public static void b5(IKernelGuildService iKernelGuildService, GProGetRecommendTagListReq gProGetRecommendTagListReq, IGProGetRecommendTagListCallback iGProGetRecommendTagListCallback) {
    }

    public static void b6(IKernelGuildService iKernelGuildService, long j3, IGProResultCallback iGProResultCallback) {
    }

    public static void c1(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProFetchChannelListStateCallback iGProFetchChannelListStateCallback) {
    }

    public static void c5(IKernelGuildService iKernelGuildService, GProGetRiskMemberRedPointReq gProGetRiskMemberRedPointReq, IGProGetRiskMemberRedPointCallback iGProGetRiskMemberRedPointCallback) {
    }

    public static void c6(IKernelGuildService iKernelGuildService, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
    }

    public static void c9(IKernelGuildService iKernelGuildService, long j3, long j16) {
    }

    public static void d2(IKernelGuildService iKernelGuildService, GProGetContentRecommendReq gProGetContentRecommendReq, IGProFetchMVPFeedsDataCallback iGProFetchMVPFeedsDataCallback) {
    }

    public static void d3(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProGetBindingGroupInfosCallback iGProGetBindingGroupInfosCallback) {
    }

    public static void d6(IKernelGuildService iKernelGuildService, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
    }

    public static void d7(IKernelGuildService iKernelGuildService, GProAnchorSetRoomInfoReq gProAnchorSetRoomInfoReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void e0(IKernelGuildService iKernelGuildService, long j3, IGProCreateScheduleLimitQueryCallback iGProCreateScheduleLimitQueryCallback) {
    }

    public static void e2(IKernelGuildService iKernelGuildService, GProFeedMemberListReq gProFeedMemberListReq, IGProFetchMemberListCallback iGProFetchMemberListCallback) {
    }

    public static void e3(IKernelGuildService iKernelGuildService, GProGetBlockRecGuildsReq gProGetBlockRecGuildsReq, IGProGetBlockRecGuildsCallback iGProGetBlockRecGuildsCallback) {
    }

    public static void f0(IKernelGuildService iKernelGuildService, GProCreateScheduleReq gProCreateScheduleReq, IGProCreateScheduleCallback iGProCreateScheduleCallback) {
    }

    public static void f6(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProQueryTinyIdByLiveUIDCallback iGProQueryTinyIdByLiveUIDCallback) {
    }

    public static void g9(IKernelGuildService iKernelGuildService, long j3, int i3) {
    }

    public static void h(IKernelGuildService iKernelGuildService, GProAddGuildWithOptionReq gProAddGuildWithOptionReq, IGProJoinGuildCallback iGProJoinGuildCallback) {
    }

    public static void j0(IKernelGuildService iKernelGuildService, String str, IGProDecodeInviteJumpInfoCallback iGProDecodeInviteJumpInfoCallback) {
    }

    public static void j3(IKernelGuildService iKernelGuildService, GProGetCategoryChannelInfoListByFilterReq gProGetCategoryChannelInfoListByFilterReq, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback) {
    }

    public static void j9(IKernelGuildService iKernelGuildService, GProSuperAdminBanUserReq gProSuperAdminBanUserReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void k3(IKernelGuildService iKernelGuildService, GProGetCategoryChannelInfoListV2Req gProGetCategoryChannelInfoListV2Req, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback) {
    }

    public static void k7(IKernelGuildService iKernelGuildService, GProSetCategoryOrderReq gProSetCategoryOrderReq, IGProSetCategoryOrderCallback iGProSetCategoryOrderCallback) {
    }

    public static void k9(IKernelGuildService iKernelGuildService, GProCmd0x92331SuperAdminUnListFeedReq gProCmd0x92331SuperAdminUnListFeedReq, IGProSuperAdminUnListFeedCallback iGProSuperAdminUnListFeedCallback) {
    }

    public static void l(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProAddRecentVisitGuildIdsCallback iGProAddRecentVisitGuildIdsCallback) {
    }

    public static void l3(IKernelGuildService iKernelGuildService, GProGetCategoryGuildsReq gProGetCategoryGuildsReq, IGProGetCategoryGuildsCallback iGProGetCategoryGuildsCallback) {
    }

    public static void l5(IKernelGuildService iKernelGuildService, GProGetSelectChannelIDReq gProGetSelectChannelIDReq, IGProGetSelectChannelIDsCallback iGProGetSelectChannelIDsCallback) {
    }

    public static void l9(IKernelGuildService iKernelGuildService, GProSwitchLobbyReq gProSwitchLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback) {
    }

    public static void m(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void m0(IKernelGuildService iKernelGuildService, GProAISearchDeleteSessionReq gProAISearchDeleteSessionReq, IGProDeleteAISearchSessionCallback iGProDeleteAISearchSessionCallback) {
    }

    public static void m3(IKernelGuildService iKernelGuildService, GProGetCategoryPageGuildsReq gProGetCategoryPageGuildsReq, IGProGetCategoryPageGuildsCallback iGProGetCategoryPageGuildsCallback) {
    }

    public static void n(IKernelGuildService iKernelGuildService, GProAnchorEnterRoomReq gProAnchorEnterRoomReq, IGProAnchorEnterRoomCallback iGProAnchorEnterRoomCallback) {
    }

    public static void n0(IKernelGuildService iKernelGuildService, GProDeleteFeedReq gProDeleteFeedReq, IGProDeleteFeedCallback iGProDeleteFeedCallback) {
    }

    public static void n8(IKernelGuildService iKernelGuildService, String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void n9(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void o0(IKernelGuildService iKernelGuildService, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
    }

    public static void o2(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProFetchPskeyCallback iGProFetchPskeyCallback) {
    }

    public static void o3(IKernelGuildService iKernelGuildService, GProGetCategoryTabContentReq gProGetCategoryTabContentReq, IGProGetCategoryTabContentCallback iGProGetCategoryTabContentCallback) {
    }

    public static void o6(IKernelGuildService iKernelGuildService, GProRemoveChannelReq gProRemoveChannelReq, IGProResultCallback iGProResultCallback) {
    }

    public static void o8(IKernelGuildService iKernelGuildService, GProSetJoinGuildOptionReq gProSetJoinGuildOptionReq, IGProResultCallback iGProResultCallback) {
    }

    public static void o9(IKernelGuildService iKernelGuildService, GProTransThirdPlatformURLReq gProTransThirdPlatformURLReq, IGProTransThirdPlatformURLCallback iGProTransThirdPlatformURLCallback) {
    }

    public static void p(IKernelGuildService iKernelGuildService, int i3, IGProAppAuthorizationCallback iGProAppAuthorizationCallback) {
    }

    public static void p0(IKernelGuildService iKernelGuildService, GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback) {
    }

    public static void p3(IKernelGuildService iKernelGuildService, GProGetChannelActivityReq gProGetChannelActivityReq, IGProGetChannelActivityCallback iGProGetChannelActivityCallback) {
    }

    public static void p5(IKernelGuildService iKernelGuildService, GProGetSimpleProfileAsyncReq gProGetSimpleProfileAsyncReq, IGProGetSimpleProfileAsyncCallback iGProGetSimpleProfileAsyncCallback) {
    }

    public static void p8(IKernelGuildService iKernelGuildService, GProJumpToCategoryInfo gProJumpToCategoryInfo, IGProResultCallback iGProResultCallback) {
    }

    public static void p9(IKernelGuildService iKernelGuildService, GProTransThirdVideoURLReq gProTransThirdVideoURLReq, IGProTransThirdVideoURLCallback iGProTransThirdVideoURLCallback) {
    }

    public static void q(IKernelGuildService iKernelGuildService, GProLiveEnterRoomRequest gProLiveEnterRoomRequest, IGProOnAudienceEnterRoomCallback iGProOnAudienceEnterRoomCallback) {
    }

    public static void q6(IKernelGuildService iKernelGuildService, long j3, IGProResultCallback iGProResultCallback) {
    }

    public static void q9(IKernelGuildService iKernelGuildService, GProTransferGuildOwnerReq gProTransferGuildOwnerReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void r(IKernelGuildService iKernelGuildService, long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void r0(IKernelGuildService iKernelGuildService, GProSystemNoticeMessageDeleteReq gProSystemNoticeMessageDeleteReq, IGProDeleteSystemNoticeMessageCallback iGProDeleteSystemNoticeMessageCallback) {
    }

    public static void r1(IKernelGuildService iKernelGuildService, long j3, IGProFetchCurrentLiveRoomInfoCallback iGProFetchCurrentLiveRoomInfoCallback) {
    }

    public static void r2(IKernelGuildService iKernelGuildService, long j3, IGProFetchAtSetInfoCallback iGProFetchAtSetInfoCallback) {
    }

    public static void s0(IKernelGuildService iKernelGuildService, long j3, IGProResultCallback iGProResultCallback) {
    }

    public static void s1(IKernelGuildService iKernelGuildService, long j3, IGProFetchDirectMsgBlackCallback iGProFetchDirectMsgBlackCallback) {
    }

    public static void s6(IKernelGuildService iKernelGuildService, GProRemoveGuildTaskCardReq gProRemoveGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void t(IKernelGuildService iKernelGuildService, GProAISearchBatchDeleteSessionReq gProAISearchBatchDeleteSessionReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void t0(IKernelGuildService iKernelGuildService, GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback) {
    }

    public static void u0(IKernelGuildService iKernelGuildService, int i3, IGProGetRealNameAuthCallback iGProGetRealNameAuthCallback) {
    }

    public static void u1(IKernelGuildService iKernelGuildService, long j3, IGProFetchEndPageMessageCallback iGProFetchEndPageMessageCallback) {
    }

    public static void u4(IKernelGuildService iKernelGuildService, GProVerifyShareInfoReq gProVerifyShareInfoReq, IGuildVerifyShareInfoCallback iGuildVerifyShareInfoCallback) {
    }

    public static void u5(IKernelGuildService iKernelGuildService, String str, IGProGetUIDataCallback iGProGetUIDataCallback) {
    }

    public static void u8(IKernelGuildService iKernelGuildService, GProLocation gProLocation, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void u9(IKernelGuildService iKernelGuildService, ArrayList arrayList, IGProUpdateArchiveShowSeqCallback iGProUpdateArchiveShowSeqCallback) {
    }

    public static void v(IKernelGuildService iKernelGuildService, GProGetAudioBotStatusReq gProGetAudioBotStatusReq, IGProBatchGetAudioBotStatusCallback iGProBatchGetAudioBotStatusCallback) {
    }

    public static void v5(IKernelGuildService iKernelGuildService, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback) {
    }

    public static void v6(IKernelGuildService iKernelGuildService, GProRemoveRiskMembersReq gProRemoveRiskMembersReq, IGProRemoveRiskMembersCallback iGProRemoveRiskMembersCallback) {
    }

    public static void v9(IKernelGuildService iKernelGuildService, GProUpdateChannelThemeReq gProUpdateChannelThemeReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void w(IKernelGuildService iKernelGuildService, GProBatchGetGuildLabelInfoReq gProBatchGetGuildLabelInfoReq, IGProBatchGetGuildLabelInfoCallback iGProBatchGetGuildLabelInfoCallback) {
    }

    public static void w4(IKernelGuildService iKernelGuildService, GProGetHotLiveReq gProGetHotLiveReq, IGProGetHotLiveCallback iGProGetHotLiveCallback) {
    }

    public static void w5(IKernelGuildService iKernelGuildService, GProGetUnbindClientReq gProGetUnbindClientReq, IGProGetUnbindClientCallback iGProGetUnbindClientCallback) {
    }

    public static void w6(IKernelGuildService iKernelGuildService, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void x(IKernelGuildService iKernelGuildService, GProGetItemDetailReq gProGetItemDetailReq, IGProGetItemDetailCallback iGProGetItemDetailCallback) {
    }

    public static void x0(IKernelGuildService iKernelGuildService, GProEditScheduleReq gProEditScheduleReq, IGProEditScheduleCallback iGProEditScheduleCallback) {
    }

    public static void x6(IKernelGuildService iKernelGuildService, GProAISearchWordsReportReq gProAISearchWordsReportReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void x9(IKernelGuildService iKernelGuildService, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
    }

    public static void y3(IKernelGuildService iKernelGuildService, GProGetConfigTabContentReq gProGetConfigTabContentReq, IGProGetConfigTabContentCallback iGProGetConfigTabContentCallback) {
    }

    public static void y5(IKernelGuildService iKernelGuildService, int i3, IGProGetUserLiveInfoCallback iGProGetUserLiveInfoCallback) {
    }

    public static void y6(IKernelGuildService iKernelGuildService, GProAVReportReqInfo gProAVReportReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
    }

    public static void y8(IKernelGuildService iKernelGuildService, String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void y9(IKernelGuildService iKernelGuildService, GProUpdateGuildTaskCardProgressReq gProUpdateGuildTaskCardProgressReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void z1(IKernelGuildService iKernelGuildService, GProFetchGuildActiveLiveChannelNumReq gProFetchGuildActiveLiveChannelNumReq, IGProFetchGuildActiveLiveChannelNumCallback iGProFetchGuildActiveLiveChannelNumCallback) {
    }

    public static void z4(IKernelGuildService iKernelGuildService, GetLabelGuildsReq getLabelGuildsReq, IGProGetLabelGuildsCallback iGProGetLabelGuildsCallback) {
    }

    public static void z9(IKernelGuildService iKernelGuildService, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
    }

    public static void A(IKernelGuildService iKernelGuildService, long j3, HashMap hashMap, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void A4(IKernelGuildService iKernelGuildService, long j3, long j16, IGProGetLiveAudioPollingCtxCallback iGProGetLiveAudioPollingCtxCallback) {
    }

    public static void A8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
    }

    public static void A9(IKernelGuildService iKernelGuildService, ArrayList arrayList, int i3, IGProUpgradeGroupCallback iGProUpgradeGroupCallback) {
    }

    public static void B(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProResultCallback iGProResultCallback) {
    }

    public static void B0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProResultCallback iGProResultCallback) {
    }

    public static void B1(IKernelGuildService iKernelGuildService, long j3, byte[] bArr, IGProFetchGuildBlackListCallback iGProFetchGuildBlackListCallback) {
    }

    public static void B8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
    }

    public static void C(IKernelGuildService iKernelGuildService, long j3, int i3, IGProBeforehandGetSpeakPermissionCallback iGProBeforehandGetSpeakPermissionCallback) {
    }

    public static void C2(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchSpecifiedTypeChannelOpenStateCallback iGProFetchSpecifiedTypeChannelOpenStateCallback) {
    }

    public static void D1(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProFetchGuildBoundGroupsWithGroupCodesCallback iGProFetchGuildBoundGroupsWithGroupCodesCallback) {
    }

    public static void E1(IKernelGuildService iKernelGuildService, long j3, int i3, IGProFetchGuildInfoCallback iGProFetchGuildInfoCallback) {
    }

    public static void E7(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void F7(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void F8(IKernelGuildService iKernelGuildService, int i3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void G0(IKernelGuildService iKernelGuildService, int i3, long j3, IGProAddGuildInfoCallBack iGProAddGuildInfoCallBack) {
    }

    public static void G3(IKernelGuildService iKernelGuildService, long j3, String str, IGProGetGuidePageInfoCallback iGProGetGuidePageInfoCallback) {
    }

    public static void G7(IKernelGuildService iKernelGuildService, int i3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void G9(IKernelGuildService iKernelGuildService, GProVoiceSmobaGameBaseRoomParams gProVoiceSmobaGameBaseRoomParams, GProVoiceSmobaGameSmobaRoomParams gProVoiceSmobaGameSmobaRoomParams, IGProVoiceSmobaGameCreateRoomCallback iGProVoiceSmobaGameCreateRoomCallback) {
    }

    public static void H0(IKernelGuildService iKernelGuildService, long j3, int i3, IGProFetchAddGuildOptionCallback iGProFetchAddGuildOptionCallback) {
    }

    public static void H7(IKernelGuildService iKernelGuildService, int i3, int i16, IGProResultCallback iGProResultCallback) {
    }

    public static void I(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void I7(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16) {
    }

    public static void J1(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProFetchGuildSpeakableRoleListCallback iGProFetchGuildSpeakableRoleListCallback) {
    }

    public static void K3(IKernelGuildService iKernelGuildService, long j3, int i3, IGProGetGuildBoundGroupsFirstPageCallback iGProGetGuildBoundGroupsFirstPageCallback) {
    }

    public static void L0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback) {
    }

    public static void L7(IKernelGuildService iKernelGuildService, int i3, int i16, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback) {
    }

    public static void L8(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProResultCallback iGProResultCallback) {
    }

    public static void M0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchBlockUserStateCallback iGProFetchBlockUserStateCallback) {
    }

    public static void M2(IKernelGuildService iKernelGuildService, GProAISearchGetSessionListReq gProAISearchGetSessionListReq, boolean z16, IGProGetAISearchSessionListCallback iGProGetAISearchSessionListCallback) {
    }

    public static void M3(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProGetGuildCreatorTasksCallback iGProGetGuildCreatorTasksCallback) {
    }

    public static void M5(IKernelGuildService iKernelGuildService, long j3, long j16, IGProLoadAllMemberListCallback iGProLoadAllMemberListCallback) {
    }

    public static void N1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchHandUpMemberListCallback iGProFetchHandUpMemberListCallback) {
    }

    public static void N2(IKernelGuildService iKernelGuildService, GProAISearchGetSessionMsgListReq gProAISearchGetSessionMsgListReq, boolean z16, IGProGetAISearchSessionMsgListCallback iGProGetAISearchSessionMsgListCallback) {
    }

    public static void P4(IKernelGuildService iKernelGuildService, long j3, int i3, IGProGetPopupInfoCallback iGProGetPopupInfoCallback) {
    }

    public static void P5(IKernelGuildService iKernelGuildService, long j3, long j16, IGProLoadMemberRolesCallback iGProLoadMemberRolesCallback) {
    }

    public static void P7(IKernelGuildService iKernelGuildService, long j3, int i3, IGProSetGuildClientIdCallback iGProSetGuildClientIdCallback) {
    }

    public static void P8(IKernelGuildService iKernelGuildService, int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback) {
    }

    public static void Q8(IKernelGuildService iKernelGuildService, int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback) {
    }

    public static void R0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProChannelAdminInfoListCallback iGProChannelAdminInfoListCallback) {
    }

    public static void R7(IKernelGuildService iKernelGuildService, long j3, int i3, IGProSetGuildCoverFontColorIdCallback iGProSetGuildCoverFontColorIdCallback) {
    }

    public static void R8(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void S5(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
    }

    public static void T5(IKernelGuildService iKernelGuildService, long j3, long j16, IGProGetUserListCallback iGProGetUserListCallback) {
    }

    public static void U(IKernelGuildService iKernelGuildService, long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void U2(IKernelGuildService iKernelGuildService, int i3, int i16, IGProGetAppAuthorizationInfoCallback iGProGetAppAuthorizationInfoCallback) {
    }

    public static void X(IKernelGuildService iKernelGuildService, long j3, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void Y1(IKernelGuildService iKernelGuildService, long j3, int i3, IGProFetchLevelRoleListCallback iGProFetchLevelRoleListCallback) {
    }

    public static void Y3(IKernelGuildService iKernelGuildService, byte[] bArr, int i3, IGProGetRecommendCallback iGProGetRecommendCallback) {
    }

    public static void Y7(IKernelGuildService iKernelGuildService, long j3, String str, IGProResultCallback iGProResultCallback) {
    }

    public static void Z0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelInvisibleRoleListCallback iGProFetchChannelInvisibleRoleListCallback) {
    }

    public static void Z1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchLiveChannelAnchorListCallback iGProFetchLiveChannelAnchorListCallback) {
    }

    public static void Z7(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void Z8(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void a3(IKernelGuildService iKernelGuildService, String str, String str2, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
    }

    public static void a8(IKernelGuildService iKernelGuildService, long j3, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void b8(IKernelGuildService iKernelGuildService, long j3, String str, IGProResultCallback iGProResultCallback) {
    }

    public static void c8(IKernelGuildService iKernelGuildService, long j3, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void d8(IKernelGuildService iKernelGuildService, long j3, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void e(IKernelGuildService iKernelGuildService, long j3, long j16, IGProLoadGuildUserProfileCallback iGProLoadGuildUserProfileCallback) {
    }

    public static void e1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelLiveableRoleListCallback iGProFetchChannelLiveableRoleListCallback) {
    }

    public static void e8(IKernelGuildService iKernelGuildService, long j3, long j16, IGProResultCallback iGProResultCallback) {
    }

    public static void g1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelSpeakableRoleListCallback iGProFetchChannelSpeakableRoleListCallback) {
    }

    public static void g6(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void h0(IKernelGuildService iKernelGuildService, GProAdminAVReqInfo gProAdminAVReqInfo, boolean z16, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
    }

    public static void h8(IKernelGuildService iKernelGuildService, long j3, GproGuildSpeakableRule gproGuildSpeakableRule, IGProResultCallback iGProResultCallback) {
    }

    public static void i(IKernelGuildService iKernelGuildService, ArrayList arrayList, GProSourceId gProSourceId, IGProJoinGuildsCallback iGProJoinGuildsCallback) {
    }

    public static void i0(IKernelGuildService iKernelGuildService, String str, String str2, IGProDealNoticeCallback iGProDealNoticeCallback) {
    }

    public static void i1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelUnlivableRoleListCallback iGProFetchChannelUnlivableRoleListCallback) {
    }

    public static void i6(IKernelGuildService iKernelGuildService, long j3, boolean z16, int i3) {
    }

    public static void i8(IKernelGuildService iKernelGuildService, long j3, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, IGProResultCallback iGProResultCallback) {
    }

    public static void j(IKernelGuildService iKernelGuildService, String str, ArrayList arrayList, IGProJoinGuildsCallback iGProJoinGuildsCallback) {
    }

    public static void j2(IKernelGuildService iKernelGuildService, int i3, long j3, IGProFetchNewestNoticeCallback iGProFetchNewestNoticeCallback) {
    }

    public static void j6(IKernelGuildService iKernelGuildService, long j3, boolean z16, int i3) {
    }

    public static void j8(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void k1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelUnspeakableRoleListCallback iGProFetchChannelUnspeakableRoleListCallback) {
    }

    public static void k8(IKernelGuildService iKernelGuildService, long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback) {
    }

    public static void l6(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
    }

    public static void l7(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void l8(IKernelGuildService iKernelGuildService, long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void m6(IKernelGuildService iKernelGuildService, long j3, long j16, int i3) {
    }

    public static void m8(IKernelGuildService iKernelGuildService, long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback) {
    }

    public static void n2(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchProfileAddFriendFieldCallback iGProFetchProfileAddFriendFieldCallback) {
    }

    public static void n6(IKernelGuildService iKernelGuildService, long j3, long j16, IGProRemoveBanBeforeBroadcastCallback iGProRemoveBanBeforeBroadcastCallback) {
    }

    public static void o1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback) {
    }

    public static void p1(IKernelGuildService iKernelGuildService, long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback) {
    }

    public static void p2(IKernelGuildService iKernelGuildService, int i3, int i16, IGProFetchRecommendChannelCallback iGProFetchRecommendChannelCallback) {
    }

    public static void q0(IKernelGuildService iKernelGuildService, long j3, long j16, IGProResultCallback iGProResultCallback) {
    }

    public static void q2(IKernelGuildService iKernelGuildService, long j3, int i3, IGProFetchRecommendEssenceInfoCallback iGProFetchRecommendEssenceInfoCallback) {
    }

    public static void q3(IKernelGuildService iKernelGuildService, long j3, long j16, IGProGetChannelHeartbeatCallback iGProGetChannelHeartbeatCallback) {
    }

    public static void s(IKernelGuildService iKernelGuildService, long j3, long j16, IGProScreenShareCallback iGProScreenShareCallback) {
    }

    public static void u6(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void v2(IKernelGuildService iKernelGuildService, long j3, int i3, IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback) {
    }

    public static void v3(IKernelGuildService iKernelGuildService, long j3, long j16, IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback) {
    }

    public static void x3(IKernelGuildService iKernelGuildService, int i3, byte[] bArr, IGProGetClientInfoListCallback iGProGetClientInfoListCallback) {
    }

    public static void x4(IKernelGuildService iKernelGuildService, ArrayList arrayList, int i3, IGProGetHotSearchWordsCallback iGProGetHotSearchWordsCallback) {
    }

    public static void y(IKernelGuildService iKernelGuildService, long j3, HashMap hashMap, IGProResultCallback iGProResultCallback) {
    }

    public static void y1(IKernelGuildService iKernelGuildService, int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback) {
    }

    public static void z(IKernelGuildService iKernelGuildService, long j3, HashMap hashMap, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void z2(IKernelGuildService iKernelGuildService, ArrayList arrayList, boolean z16, IGProCommonCallback iGProCommonCallback) {
    }

    public static void z3(IKernelGuildService iKernelGuildService, long j3, long j16, IGProGetCurrPlaySongCallback iGProGetCurrPlaySongCallback) {
    }

    public static void F6(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, String str, int i16, IGProResultCallback iGProResultCallback) {
    }

    public static void F9(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, boolean z16, int i16, IGProVoiceChannelAuthCallback iGProVoiceChannelAuthCallback) {
    }

    public static void H6(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, GProProgrammeInfoReq gProProgrammeInfoReq, IGProResultCallback iGProResultCallback) {
    }

    public static void I8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, ArrayList arrayList, ArrayList arrayList2, IGProSetRoleChannelsCallback iGProSetRoleChannelsCallback) {
    }

    public static void O6(IKernelGuildService iKernelGuildService, String str, byte[] bArr, int i3, int i16, int i17, IGProSearchGuildInfoCallback iGProSearchGuildInfoCallback) {
    }

    public static void Q5(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, byte[] bArr, int i3, IGProLoadNextPageMemberListCallback iGProLoadNextPageMemberListCallback) {
    }

    public static void S0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelAbleMemberListCallback iGProFetchChannelAbleMemberListCallback) {
    }

    public static void U0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelUnableMemberListCallback iGProFetchChannelUnableMemberListCallback) {
    }

    public static void b0(IKernelGuildService iKernelGuildService, long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void b9(IKernelGuildService iKernelGuildService, long j3, long j16, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void g7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void h7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void i5(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, long j17, String str, IGProGetScheduleListNewCallback iGProGetScheduleListNewCallback) {
    }

    public static void j5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, byte[] bArr, IGProGetScheduleUsersCallback iGProGetScheduleUsersCallback) {
    }

    public static void m2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, int i16, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback) {
    }

    public static void t8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void z7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, boolean z16, int i16, IGProResultCallback iGProResultCallback) {
    }

    public static void A2(IKernelGuildService iKernelGuildService, long j3, long j16, GProFetchShareInfo0x10c3Req gProFetchShareInfo0x10c3Req, IGProFetchShareInfo0x10c3Callback iGProFetchShareInfo0x10c3Callback) {
    }

    public static void A7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void B5(IKernelGuildService iKernelGuildService, int i3, long j3, boolean z16, IGProInitGetNoticeListCallback iGProInitGetNoticeListCallback) {
    }

    public static void D(IKernelGuildService iKernelGuildService, int i3, String str, int i16, IGProBindAppRoleCallback iGProBindAppRoleCallback) {
    }

    public static void D2(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, int i3, IGProFetchSpecifiedTypeChannelsOpenStateCallback iGProFetchSpecifiedTypeChannelsOpenStateCallback) {
    }

    public static void D7(IKernelGuildService iKernelGuildService, int i3, int i16, int i17, IGProSetClientShowConfigCallback iGProSetClientShowConfigCallback) {
    }

    public static void E(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void F4(IKernelGuildService iKernelGuildService, int i3, long j3, int i16, IGProGetMoreNoticeListCallback iGProGetMoreNoticeListCallback) {
    }

    public static void G1(IKernelGuildService iKernelGuildService, GProGuildIdentity gProGuildIdentity, String str, String str2, IGProFetchGuildInfoByAppIdentityCallback iGProFetchGuildInfoByAppIdentityCallback) {
    }

    public static void G8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProSetQQMsgListChannelCallback iGProSetQQMsgListChannelCallback) {
    }

    public static void H(IKernelGuildService iKernelGuildService, long j3, long j16, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void H2(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProGetUserListCallback iGProGetUserListCallback) {
    }

    public static void H8(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProSetQQMsgListGuildCallback iGProSetQQMsgListGuildCallback) {
    }

    public static void J8(IKernelGuildService iKernelGuildService, long j3, long j16, GProRoleCreateInfo gProRoleCreateInfo, IGProResultCallback iGProResultCallback) {
    }

    public static void K5(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, IGProKickChannelMemberCallback iGProKickChannelMemberCallback) {
    }

    public static void M7(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, IGProSetGuildAdminResultCallback iGProSetGuildAdminResultCallback) {
    }

    public static void M8(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, IGProScreenShareCallback iGProScreenShareCallback) {
    }

    public static void N(IKernelGuildService iKernelGuildService, String str, long j3, long j16, IGProCheckLobbyAppAuthStatusCallback iGProCheckLobbyAppAuthStatusCallback) {
    }

    public static void O5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProLoadMemberListByIndexCallback iGProLoadMemberListByIndexCallback) {
    }

    public static void P(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProCheckUserBannedSpeakInChannelCallback iGProCheckUserBannedSpeakInChannelCallback) {
    }

    public static void Q7(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProSetGuildNotifyDisplayCallback iGProSetGuildNotifyDisplayCallback) {
    }

    public static void S(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProDeleteLobbyCallback iGProDeleteLobbyCallback) {
    }

    public static void T0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProFetchChannelAbleRoleListCallback iGProFetchChannelAbleRoleListCallback) {
    }

    public static void U1(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProFetchJubaoMsgResIdCallback iGProFetchJubaoMsgResIdCallback) {
    }

    public static void V0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback) {
    }

    public static void V1(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, IGProFetchJubaoMsgsResIdCallback iGProFetchJubaoMsgsResIdCallback) {
    }

    public static void W0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback) {
    }

    public static void W7(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProSetGuildListTopCallback iGProSetGuildListTopCallback) {
    }

    public static void X7(IKernelGuildService iKernelGuildService, long j3, String str, String str2, IGProResultCallback iGProResultCallback) {
    }

    public static void Y2(IKernelGuildService iKernelGuildService, int i3, String str, byte[] bArr, IGProGetAppRoleListCallback iGProGetAppRoleListCallback) {
    }

    public static void Z6(IKernelGuildService iKernelGuildService, long j3, long j16, GProInviteSpeakCfg gProInviteSpeakCfg, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void a2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProFetchBannedUserListCallback iGProFetchBannedUserListCallback) {
    }

    public static void b7(IKernelGuildService iKernelGuildService, long j3, long j16, GProVoiceQueueCfg gProVoiceQueueCfg, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void c0(IKernelGuildService iKernelGuildService, long j3, GProRoleCreateInfo gProRoleCreateInfo, ArrayList arrayList, IGProCreateRoleCallback iGProCreateRoleCallback) {
    }

    public static void c3(IKernelGuildService iKernelGuildService, int i3, int i16, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback) {
    }

    public static void d0(IKernelGuildService iKernelGuildService, long j3, long j16, GProScheduleInfo gProScheduleInfo, IGProCreateScheduleCallback iGProCreateScheduleCallback) {
    }

    public static void e7(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void f8(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void g(IKernelGuildService iKernelGuildService, long j3, GProSourceId gProSourceId, String str, IGProJoinGuildCallback iGProJoinGuildCallback) {
    }

    public static void g0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void g5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProGetScheduleDetailCallback iGProGetScheduleDetailCallback) {
    }

    public static void g8(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void h5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProGetScheduleListCallback iGProGetScheduleListCallback) {
    }

    public static void h6(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, boolean z16) {
    }

    public static void i7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void j7(IKernelGuildService iKernelGuildService, long j3, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void l1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback) {
    }

    public static void m7(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void o7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void p6(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
    }

    public static void q8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback) {
    }

    public static void r7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void r8(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback) {
    }

    public static void r9(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void s7(IKernelGuildService iKernelGuildService, long j3, long j16, String str, IGProResultCallback iGProResultCallback) {
    }

    public static void t7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void u(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, boolean z16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback) {
    }

    public static void u2(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProFetchRoleListCallback iGProFetchRoleListCallback) {
    }

    public static void u3(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProGetChannelTopMsgFlashStateCallback iGProGetChannelTopMsgFlashStateCallback) {
    }

    public static void u7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void w2(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProFetchRoleListWithoutLevelRoleCallback iGProFetchRoleListWithoutLevelRoleCallback) {
    }

    public static void w8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, IGProResultCallback iGProResultCallback) {
    }

    public static void w9(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void x1(IKernelGuildService iKernelGuildService, long j3, boolean z16, int i3, IGProFetchGuestGuildCallback iGProFetchGuestGuildCallback) {
    }

    public static void x7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
    }

    public static void x8(IKernelGuildService iKernelGuildService, short s16, short s17, short s18, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void y2(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback) {
    }

    public static void z0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, IGProEnterAudioChannelCallback iGProEnterAudioChannelCallback) {
    }

    public static void z8(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void T6(IKernelGuildService iKernelGuildService, String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, IGProSearchUnionCallback iGProSearchUnionCallback) {
    }

    public static void g2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, int i3, String str, int i16, IGProFetchMemberListWithRoleCookieCallback iGProFetchMemberListWithRoleCookieCallback) {
    }

    public static void k2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, long j19, int i3, int i16, IGProFetchNonRoleMembersCallback iGProFetchNonRoleMembersCallback) {
    }

    public static void B7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void C0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, ArrayList arrayList, IGProExitAudioLiveChannelCallback iGProExitAudioLiveChannelCallback) {
    }

    public static void C7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void F2(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, int i3, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
    }

    public static void G6(IKernelGuildService iKernelGuildService, ArrayList arrayList, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
    }

    public static void I1(IKernelGuildService iKernelGuildService, long j3, boolean z16, int i3, byte[] bArr, IGProFetchGuildSpeakableMemberListCallback iGProFetchGuildSpeakableMemberListCallback) {
    }

    public static void I9(IKernelGuildService iKernelGuildService, long j3, int i3, long j16, long j17, IGProVoiceSmobaGameEnterRoomCallback iGProVoiceSmobaGameEnterRoomCallback) {
    }

    public static void J2(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, int i3, IGProFetchVisibleMemberListByTinyIdCallback iGProFetchVisibleMemberListByTinyIdCallback) {
    }

    public static void K0(IKernelGuildService iKernelGuildService, long j3, long j16, byte[] bArr, int i3, IGProFetchArchiveArkDataCallback iGProFetchArchiveArkDataCallback) {
    }

    public static void L5(IKernelGuildService iKernelGuildService, long j3, ArrayList arrayList, boolean z16, GProRevokeOptions gProRevokeOptions, IGProResultCallback iGProResultCallback) {
    }

    public static void P1(IKernelGuildService iKernelGuildService, String str, String str2, String str3, int i3, IGProFetchInviteInfo0x10b4Callback iGProFetchInviteInfo0x10b4Callback) {
    }

    public static void T8(IKernelGuildService iKernelGuildService, int i3, String str, String str2, int i16, IGProSetUserLiveInfoCallback iGProSetUserLiveInfoCallback) {
    }

    public static void U8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void V5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback) {
    }

    public static void V8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void W8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
    }

    public static void X1(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, IGProFetchCommentsCallback iGProFetchCommentsCallback) {
    }

    public static void Y0(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelInvisibleMemberListCallback iGProFetchChannelInvisibleMemberListCallback) {
    }

    public static void a7(IKernelGuildService iKernelGuildService, long j3, long j16, String str, GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg, IGProSetSpeakModeCallback iGProSetSpeakModeCallback) {
    }

    public static void c(IKernelGuildService iKernelGuildService, String str, long j3, boolean z16, boolean z17, IGProGetMemberInfoByOpenIdCallback iGProGetMemberInfoByOpenIdCallback) {
    }

    public static void c7(IKernelGuildService iKernelGuildService, long j3, int i3, String str, String str2, IGProResultCallback iGProResultCallback) {
    }

    public static void d1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelLiveableMemberListCallback iGProFetchChannelLiveableMemberListCallback) {
    }

    public static void f1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelSpeakableMemberListCallback iGProFetchChannelSpeakableMemberListCallback) {
    }

    public static void f7(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, int i16, IGProResultCallback iGProResultCallback) {
    }

    public static void h1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnlivableMemberListCallback iGProFetchChannelUnlivableMemberListCallback) {
    }

    public static void h2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, IGProFetchMemberRolesCallback iGProFetchMemberRolesCallback) {
    }

    public static void j1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnspeakableMemberListCallback iGProFetchChannelUnspeakableMemberListCallback) {
    }

    public static void k5(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, IGProGetSchedulesStatusCallback iGProGetSchedulesStatusCallback) {
    }

    public static void l2(IKernelGuildService iKernelGuildService, long j3, int i3, int i16, ArrayList arrayList, IGProFetchOnlineUsersCallback iGProFetchOnlineUsersCallback) {
    }

    public static void m1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback) {
    }

    public static void m9(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, int i16, IGProTerminateLiveStreamCallback iGProTerminateLiveStreamCallback) {
    }

    public static void n1(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback) {
    }

    public static void p7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void q7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void s2(IKernelGuildService iKernelGuildService, int i3, int i16, byte[] bArr, long j3, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback) {
    }

    public static void s8(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void t2(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, boolean z16, IGProFetchRoleCallback iGProFetchRoleCallback) {
    }

    public static void v7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void w0(IKernelGuildService iKernelGuildService, long j3, long j16, GProScheduleInfo gProScheduleInfo, int i3, IGProEditScheduleCallback iGProEditScheduleCallback) {
    }

    public static void w7(IKernelGuildService iKernelGuildService, long j3, long j16, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void x5(IKernelGuildService iKernelGuildService, long j3, long j16, boolean z16, int i3, IGProGetUserListCallback iGProGetUserListCallback) {
    }

    public static void y7(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, int i3, IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback) {
    }

    public static void A6(IKernelGuildService iKernelGuildService, long j3, long j16, int i3, GProFeedReportData gProFeedReportData, int i16, GProReportTarget gProReportTarget, IGProReportFeedShareDataCallback iGProReportFeedShareDataCallback) {
    }

    public static void B2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, String str, GProFetchShareUrlFilter gProFetchShareUrlFilter, ArrayList arrayList, IGProFetchShareUrlCallback iGProFetchShareUrlCallback) {
    }

    public static void K8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void N6(IKernelGuildService iKernelGuildService, long j3, long j16, String str, byte[] bArr, GProSearchType gProSearchType, GProSearchCond gProSearchCond, IGProSearchChannelContentCallback iGProSearchChannelContentCallback) {
    }

    public static void Y(IKernelGuildService iKernelGuildService, long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProAssocCreateCategoryReq gProAssocCreateCategoryReq, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList arrayList, IGProCreateChannelCallback iGProCreateChannelCallback) {
    }

    public static void f2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, int i3, int i16, IGProFetchMemberListWithRoleCallback iGProFetchMemberListWithRoleCallback) {
    }

    public static void q1(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, long j19, long j26, IGProFetchCommentsCallback iGProFetchCommentsCallback) {
    }

    public static void v8(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, ArrayList arrayList, ArrayList arrayList2, IGProResultCallback iGProResultCallback) {
    }

    public static void x2(IKernelGuildService iKernelGuildService, long j3, long j16, long j17, long j18, long j19, int i3, IGProFetchRoleMembersCallback iGProFetchRoleMembersCallback) {
    }
}
