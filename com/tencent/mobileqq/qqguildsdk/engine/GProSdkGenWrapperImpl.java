package com.tencent.mobileqq.qqguildsdk.engine;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSearchDataInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.aq;
import com.tencent.mobileqq.qqguildsdk.data.dr;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAISearchDeleteSessionRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAISearchGetRecommendWordsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAISearchGetSessionListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAISearchGetSessionMsgListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVMemberGroupListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAllGuildTaskCardRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAtSetInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAudioLiveUserListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProBatchGetGuildLabelInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProBindableGroups;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProBindingGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProBlockUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProBusinessData;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCheckFeedAbstractInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCmd0x1258ExtendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCmd0x92331SuperAdminUnListFeedRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCommonInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProConvertThirdIdRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCreateGuildRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCreateLobbyRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCreatedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProDeleteFeedRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProEncryptTextRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProExitAVChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFeedMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFetchCategoryAdminDisplayInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFetchGuildActiveLiveChannelNumRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFetchJoinGuildOptionRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFetchShareUrlRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProFetchUserJoinedGuildListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetAISearchShareURLRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetBannersRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetBlockRecGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetCategoryGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetCategoryPageGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetCategoryTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetChannelActivityRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetConfigTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetCurrPlaySongRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetFriendsRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetGuidePageInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetGuildBindingInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetGuildFriendsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetGuildLabelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetGuildNumRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetHotLiveRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetHotSearchWordRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetItemDetailRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetMyTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetPopupInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetProfileSwitchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRecentVisitGuildInfosFromCacheRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRecommendQuickJoinRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRecommendTagListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRiskMemberRedPointRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetSelectChannelIDRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetSimpleProfileAsyncRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGlobalPrivacySwitchGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildActiveValue;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildBottomTabExpData;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildCheckinRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildHomeSections;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildInfoAndMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildInit;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildListSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildOnlineReportRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildOnlineUsersInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchAllGuildAIInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchGetFeedCalendarRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchNewSearchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildTaskJoinChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProListenTogetherRspHead;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProLobbyAppAuthStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMemberGetBoundGroupRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProPAReportExecuteRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProPersonalSignatureTemplate;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProPreventAddictionCheckRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProQQMsgListGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRealNameAuthInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRemoveRiskMembersRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRetentionGuildListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRiskMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSearchBlackUserRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSendNoticeRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSetCategoryOrderRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSetSearchSwitchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSortAndWriteBindGroupsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSubscribeUserGuide;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProTaskInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProTransThirdPlatformURLRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProTransThirdVideoURLRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUserFreeGiftInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVerifyShareInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVersionNews;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameBaseRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSmobaGameSmobaRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSpeakModeRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGetLabelGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGproGetOpenShareInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGproXWorldInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPersonalSignatureTemplate;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ab;
import com.tencent.mobileqq.qqguildsdk.data.genc.ai;
import com.tencent.mobileqq.qqguildsdk.data.genc.al;
import com.tencent.mobileqq.qqguildsdk.data.genc.am;
import com.tencent.mobileqq.qqguildsdk.data.genc.as;
import com.tencent.mobileqq.qqguildsdk.data.genc.at;
import com.tencent.mobileqq.qqguildsdk.data.genc.au;
import com.tencent.mobileqq.qqguildsdk.data.genc.ba;
import com.tencent.mobileqq.qqguildsdk.data.genc.bb;
import com.tencent.mobileqq.qqguildsdk.data.genc.bc;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qqguildsdk.data.genc.be;
import com.tencent.mobileqq.qqguildsdk.data.genc.bf;
import com.tencent.mobileqq.qqguildsdk.data.genc.bg;
import com.tencent.mobileqq.qqguildsdk.data.genc.bh;
import com.tencent.mobileqq.qqguildsdk.data.genc.bi;
import com.tencent.mobileqq.qqguildsdk.data.genc.bj;
import com.tencent.mobileqq.qqguildsdk.data.genc.bk;
import com.tencent.mobileqq.qqguildsdk.data.genc.bl;
import com.tencent.mobileqq.qqguildsdk.data.genc.bm;
import com.tencent.mobileqq.qqguildsdk.data.genc.bn;
import com.tencent.mobileqq.qqguildsdk.data.genc.bs;
import com.tencent.mobileqq.qqguildsdk.data.genc.bt;
import com.tencent.mobileqq.qqguildsdk.data.genc.bu;
import com.tencent.mobileqq.qqguildsdk.data.genc.bv;
import com.tencent.mobileqq.qqguildsdk.data.genc.bw;
import com.tencent.mobileqq.qqguildsdk.data.genc.bx;
import com.tencent.mobileqq.qqguildsdk.data.genc.bz;
import com.tencent.mobileqq.qqguildsdk.data.genc.ca;
import com.tencent.mobileqq.qqguildsdk.data.genc.ce;
import com.tencent.mobileqq.qqguildsdk.data.genc.cg;
import com.tencent.mobileqq.qqguildsdk.data.genc.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.mobileqq.qqguildsdk.data.genc.cp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cv;
import com.tencent.mobileqq.qqguildsdk.data.genc.da;
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
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchBatchDeleteSessionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchDeleteSessionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchDeleteSessionRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetRecommendWordsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionMsgListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionMsgListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchWordsReportReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVMemberGroupListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVMemberGroupListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVReportReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAdminAVReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAllGuildTaskCardReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAllGuildTaskCardRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAppChnnPreInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAppInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtSetInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAudioLiveUserListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAudioLiveUserListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetGuildLabelInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetGuildLabelInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindableGroups;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindingGroup;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlackList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlockUserState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBottomTabExpReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelInfoList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelOpenStateResultInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckFeedAbstractInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckFeedAbstractInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x1258ExtendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x92331SuperAdminUnListFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x92331SuperAdminUnListFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf5aGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf67ReqBody;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommonInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProConvertThirdIdReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProConvertThirdIdRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateGuildReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateGuildRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateLobbyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateLobbyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreatedGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEditScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEncryptTextReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEncryptTextRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnterAudioLiveChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnterAudioLiveChannelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProExitAVChannelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProExposeRecommedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProExposureGuildTaskCardReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMemberListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMemberListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedReportData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedbackReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchCategoryAdminDisplayInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchCategoryAdminDisplayInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchGuildActiveLiveChannelNumReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchGuildActiveLiveChannelNumRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchJoinGuildOptionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchJoinGuildOptionRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchShareInfo0x10c3Req;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchShareUrlFilter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchShareUrlRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchUserJoinedGuildListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchUserJoinedGuildListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetAISearchShareURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetAISearchShareURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetBannersReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetBannersRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetBlockRecGuildsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetBlockRecGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryChannelInfoListByFilterReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryChannelInfoListV2Req;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryGuildsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryPageGuildsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryPageGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryTabContentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetChannelActivityReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetChannelActivityRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetConfigTabContentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetConfigTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCurrPlaySongRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFriendsRecommendReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFriendsRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuidePageInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildAndChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildBindingInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFriendsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFriendsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildHomeCategoriesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildLabelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildLabelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildNumRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetHotLiveReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetHotLiveRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetHotSearchWordRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetItemDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetItemDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetMyTabContentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetMyTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNavigationStatusReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNavigationStatusRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPopupInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPreviewNavigationReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPreviewNavigationRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetProfileSwitchRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendQuickJoinReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendQuickJoinRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTabContentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTagListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTagListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRiskMemberRedPointReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRiskMemberRedPointRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetSelectChannelIDReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetSelectChannelIDRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetSimpleProfileAsyncReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetSimpleProfileAsyncRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGlobalBanner;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGlobalBannerRep;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGlobalPrivacySwitchGroup;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildActiveValue;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildBottomTabExpData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildCheckinReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildCheckinRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildEssenceSvrReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildEssenceSvrRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildHomeSections;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfoAndMemberListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfoAndMemberListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildListSortInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineReportReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineReportRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineUsersInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchAllGuildAIInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetAllGuildAIInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetFeedCalendarReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetFeedCalendarRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchNewSearchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchNewSearchRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskJoinChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskJoinChannelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHeartbeatReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteSpeakCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuilds;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpToCategoryInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProListenTogetherRspHead;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLobbyAppAuthStatusRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMemberGetBoundGroupRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProModifyScheduleInviteReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPAReportExecuteReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPAReportExecuteRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPersonalSignatureTemplate;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreventAddictionCheckReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreventAddictionCheckRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQRCodeShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealNameAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendEssenceSvrRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRemoveGuildTaskCardReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRemoveRiskMembersReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRemoveRiskMembersRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportShareAttaReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportTarget;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRetentionGuildListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRiskMemberListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRiskMemberListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSaveCustomApplicationReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSaveGuildNavigationReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSaveMsgReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchBlackUserReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchBlackUserRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchCond;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSecurityResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSendNoticeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSendNoticeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetCategoryOrderReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetCategoryOrderRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetGlobalPermissionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetJoinGuildOptionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetSearchSwitchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetSearchSwitchRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProShareExtendInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSortAndWriteBindGroupsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSortAndWriteBindGroupsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSourceId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSpeakPermissionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSubscribePollingScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSubscribeUserGuide;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSuperAdminBanUserReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSwitchLobbyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSystemNoticeMessageDeleteReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTaskInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdPlatformURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdVideoURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdVideoURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransferGuildOwnerReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProURLParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUpdateChannelThemeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUpdateGuildTaskCardProgressReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserAVReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserAVRspInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserFreeGiftInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserFreeGiftReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVerifyShareInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVerifyShareInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVersionNews;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceQueueCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameBaseRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameBaseRoomParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameDissmissRoomReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameKickOutRoomReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameQuitRoomReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameRoomStateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameSmobaRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameSmobaRoomParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSpeakModeCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSpeakModeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GetLabelGuildsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GetLabelGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GproGetOpenShareInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GproGetOpenShareInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GproXWorldInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAddGuildInfoCallBack;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAddRecentVisitGuildIdsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAuditInfoResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetGuildLabelInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBeforehandGetSpeakPermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelUserPermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckAndEncryptTextCallBack;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckFeedAbstractInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckIsStrangerNewMemberCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckLobbyAppAuthStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckUserFreeGiftCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCommonCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProConvertGuildAndThirdIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateGuildCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateLobbyCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDecodeInviteJumpInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteAISearchSessionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteLobbyCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteSystemNoticeMessageCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProEnterAudioLiveChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProExitAudioLiveChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchActiveChannelsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAppInfosCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAtSetInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveGroupListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveUserListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchBlockUserStateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchCategoryAdminInfoListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelAbleMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelAbleRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildActiveLiveChannelNumCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBlackListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBottomTabExpCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBoundGroupsWithGroupCodesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildInfoAndMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildTaskCardsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchJoinGuildOptionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchJumpInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLevelRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMVPFeedsDataCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMyCreateGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchOnlineUsersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchProfileAddFriendFieldCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRecommendEssenceInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRetentionGuildListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListWithoutLevelRoleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchShareInfo0x10c3Callback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchShareUrlCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchSpecifiedTypeChannelsOpenStateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchSubscribeUserGuideCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchUserJoinedGuildListCallbackV2;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchVersionNewsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchRecommendWordsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchSessionListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchSessionMsgListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchShareURLCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetActiveLiveAudioChannelNumCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllGuildSearchAIInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBannersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBindingGroupInfosCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBlockRecGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryChannelInfoListV2Callback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryPageGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryTabContentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelActivityCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetConfigTabContentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCurrPlaySongCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFriendsInGuildCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFriendsRecommendCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuidePageInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBindableGroupsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBindingInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBoundGroupsFirstPageCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildCreatorTasksCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildHomeCategoriesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildHomeSectionsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildLableInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildNumCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildsInContactCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetHotLiveCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetHotSearchWordsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetItemDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLabelGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMyTabContentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetNavigationStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetOpenShareInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetPopupInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetPreviewNavigationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetProfileSwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRealNameAuthCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendQuickJoinCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendTabContentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendTagListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRiskMemberRedPointCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSelectChannelIDsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSimpleProfileAsyncCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalBannerCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalPrivacySwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildActiveValueCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildCheckinCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetFeedValidCalendarCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildSearchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinChannelByGuildTaskCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProListenTogetherPlayListOptCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProPAReportExecuteCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreventAddictionCheckCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProRemoveRiskMembersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProReportFeedShareDataCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProReportJoinRecommendGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProRequestPubAccountMsgCountCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProRiskMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSaveCustomApplicationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSaveGuildNavigationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchBlackUserFromServerCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchChannelContentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchGuildInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchGuildMembersBySourceIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendAudioOrLiveNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendOperationSaveMsgCallBack;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetCategoryOrderCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildBoundGroupsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildListTopCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildNotifyDisplayCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetQQMsgListGuildCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetSearchSwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetSpeakModeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSuperAdminUnListFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransThirdPlatformURLCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransThirdVideoURLCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpgradeGroupCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserOnlineReportCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserTypeSetCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameCreateRoomCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameEnterRoomCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameQuitRoomCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaKickOutRoomCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGproXWorldInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildVerifyShareInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.Iterator;
import wh2.Cdo;
import wh2.ac;
import wh2.ad;
import wh2.ae;
import wh2.af;
import wh2.ag;
import wh2.ah;
import wh2.aj;
import wh2.ak;
import wh2.an;
import wh2.ao;
import wh2.ap;
import wh2.ar;
import wh2.av;
import wh2.aw;
import wh2.ax;
import wh2.ay;
import wh2.az;
import wh2.bo;
import wh2.bp;
import wh2.bq;
import wh2.br;
import wh2.cb;
import wh2.cc;
import wh2.cd;
import wh2.cf;
import wh2.ci;
import wh2.ck;
import wh2.cm;
import wh2.co;
import wh2.cq;
import wh2.cr;
import wh2.cs;
import wh2.ct;
import wh2.cu;
import wh2.cw;
import wh2.cx;
import wh2.cy;
import wh2.cz;
import wh2.db;
import wh2.dc;
import wh2.dd;
import wh2.de;
import wh2.df;
import wh2.dg;
import wh2.dh;
import wh2.di;
import wh2.dj;
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
import wh2.eo;
import wh2.ep;
import wh2.eq;
import wh2.er;
import wh2.eu;
import wh2.ez;

/* loaded from: classes17.dex */
public class GProSdkGenWrapperImpl {

    /* renamed from: c, reason: collision with root package name */
    public static int f266767c;

    /* renamed from: a, reason: collision with root package name */
    protected IKernelGuildService f266768a;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f266769b;

    public void A1(ai aiVar, final wh2.x xVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "enterAudioLiveChannel", "", "", i3);
        GProEnterAudioLiveChannelReq I = aa.I(aiVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "enterAudioLiveChannel kernelGuildService is null");
        } else {
            iKernelGuildService.enterAudioLiveChannel(I, new IGProEnterAudioLiveChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.39
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProEnterAudioLiveChannelCallback
                public void onEnterAudioLiveChannel(final int i16, final String str, final GProSecurityResult gProSecurityResult, final GProEnterAudioLiveChannelRsp gProEnterAudioLiveChannelRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.39.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "enterAudioLiveChannel", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            xVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), new GGProEnterAudioLiveChannelRsp(gProEnterAudioLiveChannelRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProGuildUserState A2() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAlreadyEnteredChannel kernelGuildService is null");
            return null;
        }
        return new GGProGuildUserState(iKernelGuildService.getAlreadyEnteredChannel());
    }

    public void A3(bs bsVar, final cq cqVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getNavigationStatus", "", "", i3);
        GProGetNavigationStatusReq s06 = aa.s0(bsVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getNavigationStatus kernelGuildService is null");
        } else {
            iKernelGuildService.getNavigationStatus(s06, new IGProGetNavigationStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.149
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetNavigationStatusCallback
                public void onGetNavigationStatus(final int i16, final String str, final GProGetNavigationStatusRsp gProGetNavigationStatusRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.149.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getNavigationStatus", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cqVar.a(i16, str, new GGProGetNavigationStatusRsp(gProGetNavigationStatusRsp));
                        }
                    });
                }
            });
        }
    }

    public void A4(dy dyVar, final wh2.dy dyVar2) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "saveGuidNavigation", "", "", i3);
        GProSaveGuildNavigationReq C1 = aa.C1(dyVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "saveGuidNavigation kernelGuildService is null");
        } else {
            iKernelGuildService.saveGuidNavigation(C1, new IGProSaveGuildNavigationCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.147
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSaveGuildNavigationCallback
                public void onSaveGuildNavigation(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.147.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "saveGuidNavigation", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dyVar2.onSaveGuildNavigation(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void A5(es esVar, final wh2.p pVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "switchAVLobbyApp", "", "", i3);
        GProSwitchLobbyReq W1 = aa.W1(esVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "switchAVLobbyApp kernelGuildService is null");
        } else {
            iKernelGuildService.switchAVLobbyApp(W1, new IGProCreateLobbyCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.100
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateLobbyCallback
                public void onCreateLobby(final int i16, final String str, final GProCreateLobbyRsp gProCreateLobbyRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.100.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "switchAVLobbyApp", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            pVar.a(i16, str, new GGProCreateLobbyRsp(gProCreateLobbyRsp));
                        }
                    });
                }
            });
        }
    }

    public void B1(long j3, long j16, int i3, ArrayList<String> arrayList, final wh2.y yVar) {
        String str = "guildId:" + j3 + " channelId:" + j16 + " channelType:" + i3 + " roomIds.size():" + arrayList.size() + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "exitAudioLiveChannel", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "exitAudioLiveChannel kernelGuildService is null");
        } else {
            iKernelGuildService.exitAudioLiveChannel(j3, j16, i3, arrayList, new IGProExitAudioLiveChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.40
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProExitAudioLiveChannelCallback
                public void onExitAudioLiveChannel(final int i17, final String str2, final GProExitAVChannelRsp gProExitAVChannelRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.40.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "exitAudioLiveChannel", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", q16);
                            yVar.a(i17, str2, new GGProExitAVChannelRsp(gProExitAVChannelRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProAppChnnPreInfo B2(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAppChannelPreInfo kernelGuildService is null");
            return null;
        }
        return new GGProAppChnnPreInfo(iKernelGuildService.getAppChannelPreInfo(O0, O02));
    }

    public void B3(fp fpVar, final cr crVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getOpenShareInfo", "", "", i3);
        GproGetOpenShareInfoReq t26 = aa.t2(fpVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getOpenShareInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getOpenShareInfo(t26, new IGProGetOpenShareInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.98
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetOpenShareInfoCallback
                public void onGetOpenShareInfo(final int i16, final String str, final GproGetOpenShareInfoRsp gproGetOpenShareInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.98.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getOpenShareInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            crVar.a(i16, str, new GGproGetOpenShareInfoRsp(gproGetOpenShareInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void B4(ee eeVar, final dz dzVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchBlackUserFromServer", "", "", i3);
        GProSearchBlackUserReq I1 = aa.I1(eeVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchBlackUserFromServer kernelGuildService is null");
        } else {
            iKernelGuildService.searchBlackUserFromServer(I1, new IGProSearchBlackUserFromServerCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.116
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchBlackUserFromServerCallback
                public void onBlackUserSearch(final int i16, final String str, final GProSearchBlackUserRsp gProSearchBlackUserRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.116.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchBlackUserFromServer", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dzVar.a(i16, str, new GGProSearchBlackUserRsp(gProSearchBlackUserRsp));
                        }
                    });
                }
            });
        }
    }

    public void B5(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "topSpeakOrderByAdmin", "", "", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "topSpeakOrderByAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.topSpeakOrderByAdmin(o16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.79
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.79.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "topSpeakOrderByAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void C1(am amVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "exposeGuildTaskCard", "", "", i3);
        GProExposureGuildTaskCardReq M = aa.M(amVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "exposeGuildTaskCard kernelGuildService is null");
        } else {
            iKernelGuildService.exposeGuildTaskCard(M, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.186
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.186.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "exposeGuildTaskCard", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProAppChnnPreInfo> C2(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAppChannelPreInfos kernelGuildService is null");
            return null;
        }
        ArrayList<GProAppChnnPreInfo> appChannelPreInfos = iKernelGuildService.getAppChannelPreInfos(O0);
        ArrayList<IGProAppChnnPreInfo> arrayList = new ArrayList<>();
        Iterator<GProAppChnnPreInfo> it = appChannelPreInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAppChnnPreInfo(it.next()));
        }
        return arrayList;
    }

    @Nullable
    public ArrayList<IGProPersonalSignatureTemplate> C3() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getPersonalSignatureTemplate kernelGuildService is null");
            return null;
        }
        ArrayList<GProPersonalSignatureTemplate> personalSignatureTemplate = iKernelGuildService.getPersonalSignatureTemplate();
        ArrayList<IGProPersonalSignatureTemplate> arrayList = new ArrayList<>();
        Iterator<GProPersonalSignatureTemplate> it = personalSignatureTemplate.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPersonalSignatureTemplate(it.next()));
        }
        return arrayList;
    }

    public void C4(String str, String str2, String str3, byte[] bArr, eh ehVar, ef efVar, final ea eaVar) {
        byte[] bArr2;
        String str4 = str3;
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchChannelContent", "", "tinyId:" + str + " guildId:" + str2 + " query:" + str4 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        GProSearchType L1 = aa.L1(ehVar);
        GProSearchCond J1 = aa.J1(efVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchChannelContent kernelGuildService is null");
        } else {
            iKernelGuildService.searchChannelContent(O0, O02, str5, bArr2, L1, J1, new IGProSearchChannelContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.3
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchChannelContentCallback
                public void onResult(final int i16, final String str6, final GProGuildSearchRsp gProGuildSearchRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchChannelContent", "", i16, str6, "result:" + i16 + " errMsg:" + str6 + " ", q16);
                            eaVar.a(i16, str6, new GGProGuildSearchRsp(gProGuildSearchRsp));
                        }
                    });
                }
            });
        }
    }

    public void C5(ev evVar, eo eoVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "transThirdPlatformURL", "", "", i3);
        GProTransThirdPlatformURLReq Z1 = aa.Z1(evVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "transThirdPlatformURL kernelGuildService is null");
        } else {
            iKernelGuildService.transThirdPlatformURL(Z1, new IGProTransThirdPlatformURLCallback(q16, eoVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.166

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267274a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransThirdPlatformURLCallback
                public void onResult(final int i16, final String str, final GProTransThirdPlatformURLRsp gProTransThirdPlatformURLRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.166.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "transThirdPlatformURL", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass166.this.f267274a);
                            new GGProTransThirdPlatformURLRsp(gProTransThirdPlatformURLRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void D1(al alVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "exposeRecommends", "", "", i3);
        GProExposeRecommedsReq L = aa.L(alVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "exposeRecommends kernelGuildService is null");
        } else {
            iKernelGuildService.exposeRecommends(L, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.102
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.102.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "exposeRecommends", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProAppInfo> D2() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAppInfos kernelGuildService is null");
            return null;
        }
        ArrayList<GProAppInfo> appInfos = iKernelGuildService.getAppInfos();
        ArrayList<IGProAppInfo> arrayList = new ArrayList<>();
        Iterator<GProAppInfo> it = appInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAppInfo(it.next()));
        }
        return arrayList;
    }

    public void D3(long j3, int i3, final cs csVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getPopupInfo", "", "groupId:" + j3 + " serviceType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getPopupInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getPopupInfo(j3, i3, new IGProGetPopupInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.121
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetPopupInfoCallback
                public void onGetPopupInfoCallback(final int i17, final String str, final GProGetPopupInfoRsp gProGetPopupInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.121.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getPopupInfo", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            csVar.a(i17, str, new GGProGetPopupInfoRsp(gProGetPopupInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void D4(String str, byte[] bArr, int i3, int i16, int i17, eb ebVar) {
        int i18 = f266767c;
        f266767c = i18 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchGuild", "", "keyWord:" + str + " size:" + i3 + " sourceType:" + i16 + " extendReqType:" + i17 + " ", i18);
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr2 = bArr;
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchGuild kernelGuildService is null");
        } else {
            iKernelGuildService.searchGuild(str2, bArr2, i3, i16, i17, new IGProSearchGuildInfoCallback(q16, ebVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.8

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268103a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchGuildInfoCallback
                public void onResult(final int i19, final String str3, final GProSecurityResult gProSecurityResult, final boolean z16, final byte[] bArr3, final ArrayList<GProGuildSearchInfo> arrayList, final ArrayList<GProGuildSearchInfo> arrayList2, final String str4) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchGuild", "", i19, str3, "result:" + i19 + " errMsg:" + str3 + " isEnd:" + z16 + " infoList.size():" + arrayList.size() + " rcdInfoList.size():" + arrayList2.size() + " keyWord:" + str4 + " ", AnonymousClass8.this.f268103a);
                            new GProSecurityInfo(gProSecurityResult);
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new GProGuildSearchDataInfo((GProGuildSearchInfo) it.next()));
                            }
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                arrayList4.add(new GProGuildSearchDataInfo((GProGuildSearchInfo) it5.next()));
                            }
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void D5(ew ewVar, ep epVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "transThirdVideoURL", "", "", i3);
        GProTransThirdVideoURLReq a26 = aa.a2(ewVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "transThirdVideoURL kernelGuildService is null");
        } else {
            iKernelGuildService.transThirdVideoURL(a26, new IGProTransThirdVideoURLCallback(q16, epVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.167

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267280a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransThirdVideoURLCallback
                public void onResult(final int i16, final String str, final GProTransThirdVideoURLRsp gProTransThirdVideoURLRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.167.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "transThirdVideoURL", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass167.this.f267280a);
                            new GGProTransThirdVideoURLRsp(gProTransThirdVideoURLRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void E1(String str, final wh2.z zVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchActiveChannels", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchActiveChannels kernelGuildService is null");
        } else {
            iKernelGuildService.fetchActiveChannels(O0, new IGProFetchActiveChannelsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.139
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchActiveChannelsCallback
                public void onFetchActiveChannels(final int i16, final String str2, final ArrayList<GProRecommendItem> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.139.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchActiveChannels", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " activeChannels.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProRecommendItem> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProRecommendItem((GProRecommendItem) it.next()));
                            }
                            zVar.onFetchActiveChannels(i16, str2, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void E2(ba baVar, bo boVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getBanners", "", "", i3);
        GProGetBannersReq a06 = aa.a0(baVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getBanners kernelGuildService is null");
        } else {
            iKernelGuildService.getBanners(a06, new IGProGetBannersCallback(q16, boVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.142

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267097a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBannersCallback
                public void onGetBanners(final int i16, final String str, final GProGetBannersRsp gProGetBannersRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.142.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getBanners", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass142.this.f267097a);
                            new GGProGetBannersRsp(gProGetBannersRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void E3(bt btVar, final ct ctVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getPreviewNavigation", "", "", i3);
        GProGetPreviewNavigationReq t06 = aa.t0(btVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getPreviewNavigation kernelGuildService is null");
        } else {
            iKernelGuildService.getPreviewNavigation(t06, new IGProGetPreviewNavigationCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.148
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetPreviewNavigationCallback
                public void onGetPreviewNavigation(final int i16, final String str, final GProGetPreviewNavigationRsp gProGetPreviewNavigationRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.148.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getPreviewNavigation", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ctVar.a(i16, str, new GGProGetPreviewNavigationRsp(gProGetPreviewNavigationRsp));
                        }
                    });
                }
            });
        }
    }

    public void E4(com.tencent.mobileqq.qqguildsdk.data.genc.cr crVar, final dj djVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchGuildContent", "", "", i3);
        GProGuildSearchNewSearchReq Q0 = aa.Q0(crVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchGuildContent kernelGuildService is null");
        } else {
            iKernelGuildService.searchGuildContent(Q0, new IGProGuildSearchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.4
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildSearchCallback
                public void onResult(final int i16, final String str, final GProGuildSearchNewSearchRsp gProGuildSearchNewSearchRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchGuildContent", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            djVar.a(i16, str, new GGProGuildSearchNewSearchRsp(gProGuildSearchNewSearchRsp));
                        }
                    });
                }
            });
        }
    }

    public void E5(ex exVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "transferGuildOwner", "", "", i3);
        GProTransferGuildOwnerReq b26 = aa.b2(exVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "transferGuildOwner kernelGuildService is null");
        } else {
            iKernelGuildService.transferGuildOwner(b26, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.204
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.204.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "transferGuildOwner", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void F1(int i3, long j3, final wh2.a aVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAddGuildInfo", "", "appid:" + i3 + " guildId:" + j3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchAddGuildInfo kernelGuildService is null");
        } else {
            iKernelGuildService.fetchAddGuildInfo(i3, j3, new IGProAddGuildInfoCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.28
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAddGuildInfoCallBack
                public void onResult(final int i17, final String str, final String str2, final String str3, final String str4) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAddGuildInfo", "", i17, str, "result:" + i17 + " errMsg:" + str + " mainSource:" + str2 + " subSource:" + str3 + " joinGuildSig:" + str4 + " ", q16);
                            aVar.onResult(i17, str, str2, str3, str4);
                        }
                    });
                }
            });
        }
    }

    public void F2(ArrayList<Long> arrayList, final bp bpVar) {
        String str = "groupCodes.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getBindingGroupInfos", "", str, i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getBindingGroupInfos kernelGuildService is null");
        } else {
            iKernelGuildService.getBindingGroupInfos(arrayList, new IGProGetBindingGroupInfosCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.163
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBindingGroupInfosCallback
                public void onGetBindingGroupInfos(final int i16, final String str2, final ArrayList<GProBindingGroup> arrayList2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.163.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getBindingGroupInfos", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " bindingGroups.size():" + arrayList2.size() + " ", q16);
                            ArrayList<IGProBindingGroup> arrayList3 = new ArrayList<>();
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new GGProBindingGroup((GProBindingGroup) it.next()));
                            }
                            bpVar.onGetBindingGroupInfos(i16, str2, arrayList3);
                        }
                    });
                }
            });
        }
    }

    public void F3(final cu cuVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getProfileSwitch", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getProfileSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.getProfileSwitch(new IGProGetProfileSwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.196
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetProfileSwitchCallback
                public void onGetProfileSwitch(final int i16, final String str, final GProGetProfileSwitchRsp gProGetProfileSwitchRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.196.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getProfileSwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cuVar.a(i16, str, new GGProGetProfileSwitchRsp(gProGetProfileSwitchRsp));
                        }
                    });
                }
            });
        }
    }

    public void F4(eg egVar, final ea eaVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchGuildFeeds", "", "", i3);
        GProSearchGuildFeedsReq K1 = aa.K1(egVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchGuildFeeds kernelGuildService is null");
        } else {
            iKernelGuildService.searchGuildFeeds(K1, new IGProSearchChannelContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.183
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchChannelContentCallback
                public void onResult(final int i16, final String str, final GProGuildSearchRsp gProGuildSearchRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.183.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchGuildFeeds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            eaVar.a(i16, str, new GGProGuildSearchRsp(gProGuildSearchRsp));
                        }
                    });
                }
            });
        }
    }

    public void F5(fa faVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateAudioLiveChannelTheme", "", "", i3);
        GProUpdateChannelThemeReq e26 = aa.e2(faVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "updateAudioLiveChannelTheme kernelGuildService is null");
        } else {
            iKernelGuildService.updateAudioLiveChannelTheme(e26, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.49
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.49.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "updateAudioLiveChannelTheme", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void G1(String str, final wh2.aa aaVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAppInfos", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchAppInfos kernelGuildService is null");
        } else {
            iKernelGuildService.fetchAppInfos(O0, new IGProFetchAppInfosCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.118
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAppInfosCallback
                public void onResult(final int i16, final String str2, final ArrayList<GProAppInfo> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.118.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAppInfos", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " appInfos.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProAppInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProAppInfo((GProAppInfo) it.next()));
                            }
                            aaVar.onResult(i16, str2, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void G2(bb bbVar, bq bqVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getBlockRecGuilds", "", "", i3);
        GProGetBlockRecGuildsReq b06 = aa.b0(bbVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getBlockRecGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.getBlockRecGuilds(b06, new IGProGetBlockRecGuildsCallback(q16, bqVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.104

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266809a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetBlockRecGuildsCallback
                public void onGetBlockRecGuilds(final int i16, final String str, final GProGetBlockRecGuildsRsp gProGetBlockRecGuildsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.104.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getBlockRecGuilds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass104.this.f266809a);
                            new GGProGetBlockRecGuildsRsp(gProGetBlockRecGuildsRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProQQMsgListGuild> G3() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getQQMsgListGuilds kernelGuildService is null");
            return null;
        }
        ArrayList<GProQQMsgListGuild> qQMsgListGuilds = iKernelGuildService.getQQMsgListGuilds();
        ArrayList<IGProQQMsgListGuild> arrayList = new ArrayList<>();
        Iterator<GProQQMsgListGuild> it = qQMsgListGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProQQMsgListGuild(it.next()));
        }
        return arrayList;
    }

    public void G4(cl clVar, final ec ecVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchGuildMembersBySourceId", "", "", i3);
        GProGuildMemberSearchParams K0 = aa.K0(clVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "searchGuildMembersBySourceId kernelGuildService is null");
        } else {
            iKernelGuildService.searchGuildMembersBySourceId(K0, new IGProSearchGuildMembersBySourceIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.117
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchGuildMembersBySourceIdCallback
                public void onSearchGuildMembersBySourceId(final int i16, final String str, final GProGuildMemberSearchResult gProGuildMemberSearchResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.117.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchGuildMembersBySourceId", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ecVar.a(i16, str, new GGProGuildMemberSearchResult(gProGuildMemberSearchResult));
                        }
                    });
                }
            });
        }
    }

    public void G5(ch chVar, final dh dhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateGuildEssence", "", "", i3);
        GProGuildEssenceSvrReq G0 = aa.G0(chVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "updateGuildEssence kernelGuildService is null");
        } else {
            iKernelGuildService.updateGuildEssence(G0, new IGProGuildEssenceCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.62
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack
                public void onGProGuildEssenceInfoCallBack(final int i16, final String str, final GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.62.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "updateGuildEssence", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dhVar.a(i16, str, new GGProGuildEssenceSvrRsp(gProGuildEssenceSvrRsp));
                        }
                    });
                }
            });
        }
    }

    public void H1(long j3, long j16, final ae aeVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAudioLiveChannelBlockUserState", "", "guildId:" + j3 + " channelId:" + j16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchAudioLiveChannelBlockUserState kernelGuildService is null");
        } else {
            iKernelGuildService.fetchAudioLiveChannelBlockUserState(j3, j16, new IGProFetchBlockUserStateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.59
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchBlockUserStateCallback
                public void onFetchBlockUserState(final int i16, final String str, final GProBlockUserState gProBlockUserState) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.59.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAudioLiveChannelBlockUserState", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            aeVar.a(i16, str, new GGProBlockUserState(gProBlockUserState));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProCategoryChannelIdList> H2(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryChannelIdList kernelGuildService is null");
            return null;
        }
        ArrayList<GProCategoryChannelIdList> categoryChannelIdList = iKernelGuildService.getCategoryChannelIdList(j3);
        ArrayList<IGProCategoryChannelIdList> arrayList = new ArrayList<>();
        Iterator<GProCategoryChannelIdList> it = categoryChannelIdList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCategoryChannelIdList(it.next()));
        }
        return arrayList;
    }

    @Nullable
    public IGProGetRecentVisitGuildInfosFromCacheRsp H3(int i3, int i16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRecentVisitGuildInfosListSync kernelGuildService is null");
            return null;
        }
        return new GGProGetRecentVisitGuildInfosFromCacheRsp(iKernelGuildService.getRecentVisitGuildInfosListSync(i3, i16));
    }

    public void H4(ei eiVar, final ed edVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "sendAudioOrLiveNotice", "", "", i3);
        GProSendNoticeReq M1 = aa.M1(eiVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "sendAudioOrLiveNotice kernelGuildService is null");
        } else {
            iKernelGuildService.sendAudioOrLiveNotice(M1, new IGProSendAudioOrLiveNoticeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.179
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendAudioOrLiveNoticeCallback
                public void onResult(final int i16, final String str, final GProSendNoticeRsp gProSendNoticeRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.179.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "sendAudioOrLiveNotice", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            edVar.a(i16, str, new GGProSendNoticeRsp(gProSendNoticeRsp));
                        }
                    });
                }
            });
        }
    }

    public void H5(fb fbVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateGuildTaskCardProgress", "", "", i3);
        GProUpdateGuildTaskCardProgressReq f26 = aa.f2(fbVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "updateGuildTaskCardProgress kernelGuildService is null");
        } else {
            iKernelGuildService.updateGuildTaskCardProgress(f26, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.188
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.188.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "updateGuildTaskCardProgress", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void I1(com.tencent.mobileqq.qqguildsdk.data.genc.m mVar, final ac acVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAudioLiveChannelGroupList", "", "", i3);
        GProAVMemberGroupListReq m3 = aa.m(mVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchAudioLiveChannelGroupList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchAudioLiveChannelGroupList(m3, new IGProFetchAudioLiveGroupListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.42
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveGroupListCallback
                public void onFetchAudioLiveChannelGroups(final int i16, final String str, final GProAVMemberGroupListRsp gProAVMemberGroupListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.42.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAudioLiveChannelGroupList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            acVar.a(i16, str, new GGProAVMemberGroupListRsp(gProAVMemberGroupListRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProCategoryChannelIdList> I2(long j3, ArrayList<Integer> arrayList) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryChannelIdListExcludeCategoryType kernelGuildService is null");
            return null;
        }
        ArrayList<GProCategoryChannelIdList> categoryChannelIdListExcludeCategoryType = iKernelGuildService.getCategoryChannelIdListExcludeCategoryType(j3, arrayList);
        ArrayList<IGProCategoryChannelIdList> arrayList2 = new ArrayList<>();
        Iterator<GProCategoryChannelIdList> it = categoryChannelIdListExcludeCategoryType.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GGProCategoryChannelIdList(it.next()));
        }
        return arrayList2;
    }

    public void I3(bu buVar, cw cwVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getRecommendQuickJoin", "", "", i3);
        GProGetRecommendQuickJoinReq u06 = aa.u0(buVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRecommendQuickJoin kernelGuildService is null");
        } else {
            iKernelGuildService.getRecommendQuickJoin(u06, new IGProGetRecommendQuickJoinCallback(q16, cwVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.135

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267042a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendQuickJoinCallback
                public void onGProGetRecommendQuickJoinCallback(final int i16, final String str, final GProGetRecommendQuickJoinRsp gProGetRecommendQuickJoinRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.135.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getRecommendQuickJoin", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass135.this.f267042a);
                            new GGProGetRecommendQuickJoinRsp(gProGetRecommendQuickJoinRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void I4(cv cvVar) {
        GProHeartbeatReq U0 = aa.U0(cvVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "sendChannelHeartbeat kernelGuildService is null");
        } else {
            iKernelGuildService.sendChannelHeartbeat(U0);
        }
    }

    public void I5(ch chVar, final dh dhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateGuildVisitor", "", "", i3);
        GProGuildEssenceSvrReq G0 = aa.G0(chVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "updateGuildVisitor kernelGuildService is null");
        } else {
            iKernelGuildService.updateGuildVisitor(G0, new IGProGuildEssenceCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.65
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack
                public void onGProGuildEssenceInfoCallBack(final int i16, final String str, final GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.65.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "updateGuildVisitor", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dhVar.a(i16, str, new GGProGuildEssenceSvrRsp(gProGuildEssenceSvrRsp));
                        }
                    });
                }
            });
        }
    }

    public void J1(com.tencent.mobileqq.qqguildsdk.data.genc.q qVar, final ad adVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAudioLiveChannelUserList", "", "", i3);
        GProAudioLiveUserListReq q17 = aa.q(qVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchAudioLiveChannelUserList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchAudioLiveChannelUserList(q17, new IGProFetchAudioLiveUserListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.41
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveUserListCallback
                public void onFetchAudioLiveChannelUsers(final int i16, final String str, final GProAudioLiveUserListRsp gProAudioLiveUserListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.41.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAudioLiveChannelUserList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            adVar.a(i16, str, new GGProAudioLiveUserListRsp(gProAudioLiveUserListRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<IGProCategoryChannelInfoList> J2(long j3, ArrayList<Integer> arrayList) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryChannelInfoListByCategoryType kernelGuildService is null");
            return null;
        }
        ArrayList<GProCategoryChannelInfoList> categoryChannelInfoListByCategoryType = iKernelGuildService.getCategoryChannelInfoListByCategoryType(j3, arrayList);
        ArrayList<IGProCategoryChannelInfoList> arrayList2 = new ArrayList<>();
        Iterator<GProCategoryChannelInfoList> it = categoryChannelInfoListByCategoryType.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GGProCategoryChannelInfoList(it.next()));
        }
        return arrayList2;
    }

    public void J3(bv bvVar, final cx cxVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getRecommendTabContent", "", "", i3);
        GProGetRecommendTabContentReq v06 = aa.v0(bvVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRecommendTabContent kernelGuildService is null");
        } else {
            iKernelGuildService.getRecommendTabContent(v06, new IGProGetRecommendTabContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.190
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendTabContentCallback
                public void onGetRecommendTabContent(final int i16, final String str, final GProGetRecommendTabContentRsp gProGetRecommendTabContentRsp, final byte[] bArr) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.190.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getRecommendTabContent", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cxVar.a(i16, str, new GGProGetRecommendTabContentRsp(gProGetRecommendTabContentRsp), bArr);
                        }
                    });
                }
            });
        }
    }

    public void J4(com.tencent.mobileqq.qqguildsdk.data.genc.dz dzVar, wh2.ee eeVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "sendOperationSaveMsg", "", "", i3);
        GProSaveMsgReq D1 = aa.D1(dzVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "sendOperationSaveMsg kernelGuildService is null");
        } else {
            iKernelGuildService.sendOperationSaveMsg(D1, new IGProSendOperationSaveMsgCallBack(q16, eeVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.101

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266791a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendOperationSaveMsgCallBack
                public void onSendOperationSaveMsg(final int i16, final String str, final int i17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.101.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "sendOperationSaveMsg", "", i16, str, "result:" + i16 + " errMsg:" + str + " msgId:" + i17 + " ", AnonymousClass101.this.f266791a);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void J5(ArrayList<Long> arrayList, int i3, final eq eqVar) {
        String str = "groupIdList.size():" + arrayList.size() + " operateType:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "upgradeGroupFeed", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "upgradeGroupFeed kernelGuildService is null");
        } else {
            iKernelGuildService.upgradeGroupFeed(arrayList, i3, new IGProUpgradeGroupCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.122
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpgradeGroupCallback
                public void onUpgradeGroupCallback(final int i17, final String str2, final ArrayList<Long> arrayList2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.122.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "upgradeGroupFeed", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " successList.size():" + arrayList2.size() + " ", q16);
                            eqVar.onUpgradeGroupCallback(i17, str2, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void K1(as asVar, final af afVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchCategoryAdminInfoList", "", "", i3);
        GProFetchCategoryAdminDisplayInfoReq S = aa.S(asVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchCategoryAdminInfoList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchCategoryAdminInfoList(S, new IGProFetchCategoryAdminInfoListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.134
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchCategoryAdminInfoListCallback
                public void onResult(final int i16, final String str, final GProFetchCategoryAdminDisplayInfoRsp gProFetchCategoryAdminDisplayInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.134.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchCategoryAdminInfoList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            afVar.a(i16, str, new GGProFetchCategoryAdminDisplayInfoRsp(gProFetchCategoryAdminDisplayInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void K2(bc bcVar, final br brVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCategoryChannelInfoListByFilter", "", "", i3);
        GProGetCategoryChannelInfoListByFilterReq c06 = aa.c0(bcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryChannelInfoListByFilter kernelGuildService is null");
        } else {
            iKernelGuildService.getCategoryChannelInfoListByFilter(c06, new IGProGetCategoryChannelInfoListV2Callback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.154
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryChannelInfoListV2Callback
                public void onGetCategoryChannelInfoListV2(final ArrayList<GProCategoryChannelInfoList> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.154.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCategoryChannelInfoListByFilter", "", "infoList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProCategoryChannelInfoList> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProCategoryChannelInfoList((GProCategoryChannelInfoList) it.next()));
                            }
                            brVar.onGetCategoryChannelInfoListV2(arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void K3(bw bwVar, cy cyVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getRecommendTagList", "", "", i3);
        GProGetRecommendTagListReq w06 = aa.w0(bwVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRecommendTagList kernelGuildService is null");
        } else {
            iKernelGuildService.getRecommendTagList(w06, new IGProGetRecommendTagListCallback(q16, cyVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.106

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266821a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendTagListCallback
                public void onGetRecommendTagListCallback(final int i16, final String str, final GProGetRecommendTagListRsp gProGetRecommendTagListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.106.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getRecommendTagList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass106.this.f266821a);
                            new GGProGetRecommendTagListRsp(gProGetRecommendTagListRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void K4(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.cw cwVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setAVChannelInviteSpeakSwitch", "", "guildId:" + j3 + " channelId:" + j16 + " ", i3);
        GProInviteSpeakCfg V0 = aa.V0(cwVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setAVChannelInviteSpeakSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setAVChannelInviteSpeakSwitch(j3, j16, V0, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.76
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.76.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setAVChannelInviteSpeakSwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void K5(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "userDealSpeakInvitation", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "userDealSpeakInvitation kernelGuildService is null");
        } else {
            iKernelGuildService.userDealSpeakInvitation(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.34
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.34.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "userDealSpeakInvitation", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void L1(long j3, long j16, int i3, byte[] bArr, int i16, final ag agVar) {
        byte[] bArr2;
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelAuthControlMemberList", "", "guildId:" + j3 + " channelId:" + j16 + " count:" + i3 + " authType:" + i16 + " ", i17);
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchChannelAuthControlMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchChannelAuthControlMemberList(j3, j16, i3, bArr2, i16, new IGProFetchChannelAbleMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.52
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelAbleMemberListCallback
                public void onFetchChannelAbleMemberList(final int i18, final String str, final int i19, final boolean z16, final byte[] bArr3, final ArrayList<GProUser> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.52.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelAuthControlMemberList", "", i18, str, "result:" + i18 + " errMsg:" + str + " totalMemberNum:" + i19 + " isEnd:" + z16 + " memberList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProUserInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProUserInfo((GProUser) it.next()));
                            }
                            agVar.onFetchChannelAbleMemberList(i18, str, i19, z16, bArr3, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void L2(bd bdVar, final br brVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCategoryChannelInfoListV2", "", "", i3);
        GProGetCategoryChannelInfoListV2Req d06 = aa.d0(bdVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryChannelInfoListV2 kernelGuildService is null");
        } else {
            iKernelGuildService.getCategoryChannelInfoListV2(d06, new IGProGetCategoryChannelInfoListV2Callback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.153
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryChannelInfoListV2Callback
                public void onGetCategoryChannelInfoListV2(final ArrayList<GProCategoryChannelInfoList> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.153.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCategoryChannelInfoListV2", "", "infoList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProCategoryChannelInfoList> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProCategoryChannelInfoList((GProCategoryChannelInfoList) it.next()));
                            }
                            brVar.onGetCategoryChannelInfoListV2(arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void L3(bx bxVar, cz czVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getRiskMemberRedPoint", "", "", i3);
        GProGetRiskMemberRedPointReq x06 = aa.x0(bxVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRiskMemberRedPoint kernelGuildService is null");
        } else {
            iKernelGuildService.getRiskMemberRedPoint(x06, new IGProGetRiskMemberRedPointCallback(q16, czVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.145

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267117a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRiskMemberRedPointCallback
                public void onGetRiskMemberRedPoint(final int i16, final String str, final GProGetRiskMemberRedPointRsp gProGetRiskMemberRedPointRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.145.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getRiskMemberRedPoint", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass145.this.f267117a);
                            new GGProGetRiskMemberRedPointRsp(gProGetRiskMemberRedPointRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void L4(long j3, long j16, String str, fn fnVar, final el elVar) {
        String str2 = str;
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setAVChannelSpeakMode", "", "guildId:" + j3 + " channelId:" + j16 + " confirmExt:" + str2 + " ", i3);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        GProVoiceSpeakModeCfg r26 = aa.r2(fnVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setAVChannelSpeakMode kernelGuildService is null");
        } else {
            iKernelGuildService.setAVChannelSpeakMode(j3, j16, str3, r26, new IGProSetSpeakModeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.74
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetSpeakModeCallback
                public void onSetSpeakModeCallback(final int i16, final String str4, final GProVoiceSpeakModeRsp gProVoiceSpeakModeRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.74.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setAVChannelSpeakMode", "", i16, str4, "result:" + i16 + " errMsg:" + str4 + " ", q16);
                            elVar.a(i16, str4, new GGProVoiceSpeakModeRsp(gProVoiceSpeakModeRsp));
                        }
                    });
                }
            });
        }
    }

    public void L5(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "userHandUp", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "userHandUp kernelGuildService is null");
        } else {
            iKernelGuildService.userHandUp(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.29
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "userHandUp", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void M1(long j3, long j16, int i3, final ah ahVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelAuthControlRoleList", "", "guildId:" + j3 + " channelId:" + j16 + " authType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchChannelAuthControlRoleList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchChannelAuthControlRoleList(j3, j16, i3, new IGProFetchChannelAbleRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.51
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelAbleRoleListCallback
                public void onFetchChannelAbleRoleList(final int i17, final String str, final int i18, final ArrayList<GProGuildRole> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.51.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelAuthControlRoleList", "", i17, str, "result:" + i17 + " errMsg:" + str + " totalRoleNum:" + i18 + " roleList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProGuildRoleInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProGuildRoleInfo((GProGuildRole) it.next()));
                            }
                            ahVar.onFetchChannelAbleRoleList(i17, str, i18, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void M2(be beVar, wh2.bs bsVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCategoryGuilds", "", "", i3);
        GProGetCategoryGuildsReq e06 = aa.e0(beVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.getCategoryGuilds(e06, new IGProGetCategoryGuildsCallback(q16, bsVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.105

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266815a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryGuildsCallback
                public void onetCategoryGuilds(final int i16, final String str, final GProGetCategoryGuildsRsp gProGetCategoryGuildsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.105.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCategoryGuilds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass105.this.f266815a);
                            new GGProGetCategoryGuildsRsp(gProGetCategoryGuildsRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProGuildRoleInfo M3(long j3, long j16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRoleInfo kernelGuildService is null");
            return null;
        }
        return new GProGuildRoleInfo(iKernelGuildService.getRoleInfo(j3, j16));
    }

    public void M4(long j3, long j16, fh fhVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setAVChannelSpeakOrder", "", "guildId:" + j3 + " channelId:" + j16 + " ", i3);
        GProVoiceQueueCfg l26 = aa.l2(fhVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setAVChannelSpeakOrder kernelGuildService is null");
        } else {
            iKernelGuildService.setAVChannelSpeakOrder(j3, j16, l26, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.75
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.75.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setAVChannelSpeakOrder", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void M5(cn cnVar, final wh2.es esVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "userOnlineReport", "", "", i3);
        GProGuildOnlineReportReq M0 = aa.M0(cnVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "userOnlineReport kernelGuildService is null");
        } else {
            iKernelGuildService.userOnlineReport(M0, new IGProUserOnlineReportCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.14
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserOnlineReportCallback
                public void onUserOnlineReport(final int i16, final String str, final GProGuildOnlineReportRsp gProGuildOnlineReportRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "userOnlineReport", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            esVar.a(i16, str, new GGProGuildOnlineReportRsp(gProGuildOnlineReportRsp));
                        }
                    });
                }
            });
        }
    }

    public void N0(ArrayList<da> arrayList, com.tencent.mobileqq.qqguildsdk.data.genc.ep epVar, final dm dmVar) {
        String str = "joinGuilds.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuilds", "", str, i3);
        ArrayList<GProJoinGuilds> arrayList2 = new ArrayList<>();
        Iterator<da> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(aa.e1(it.next()));
        }
        GProSourceId T1 = aa.T1(epVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "addGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.addGuilds(arrayList2, T1, new IGProJoinGuildsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.86
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildsCallback
                public void onJoinGuilds(final int i16, final String str2, final ArrayList<GProJoinGuildResult> arrayList3) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.86.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "addGuilds", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " joinGuildsRest.size():" + arrayList3.size() + " ", q16);
                            ArrayList<IGProJoinGuildResult> arrayList4 = new ArrayList<>();
                            Iterator it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                arrayList4.add(new GGProJoinGuildResult((GProJoinGuildResult) it5.next()));
                            }
                            dmVar.onJoinGuilds(i16, str2, arrayList4);
                        }
                    });
                }
            });
        }
    }

    public void N1(long j3, long j16, int i3, byte[] bArr, int i16, final wh2.ai aiVar) {
        byte[] bArr2;
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelAuthControlUnableMemberList", "", "guildId:" + j3 + " channelId:" + j16 + " count:" + i3 + " authType:" + i16 + " ", i17);
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchChannelAuthControlUnableMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchChannelAuthControlUnableMemberList(j3, j16, i3, bArr2, i16, new IGProFetchChannelUnableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.53
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnableMemberListCallback
                public void onFetchChannelUnableMemberList(final int i18, final String str, final boolean z16, final byte[] bArr3, final ArrayList<GProUser> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.53.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelAuthControlUnableMemberList", "", i18, str, "result:" + i18 + " errMsg:" + str + " isEnd:" + z16 + " memberList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProUserInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProUserInfo((GProUser) it.next()));
                            }
                            aiVar.onFetchChannelUnableMemberList(i18, str, z16, bArr3, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void N2(bf bfVar, final wh2.bt btVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCategoryPageGuilds", "", "", i3);
        GProGetCategoryPageGuildsReq f06 = aa.f0(bfVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryPageGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.getCategoryPageGuilds(f06, new IGProGetCategoryPageGuildsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.136
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryPageGuildsCallback
                public void onGetCategoryPageGuilds(final int i16, final String str, final GProGetCategoryPageGuildsRsp gProGetCategoryPageGuildsRsp, final byte[] bArr) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.136.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCategoryPageGuilds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            btVar.a(i16, str, new GGProGetCategoryPageGuildsRsp(gProGetCategoryPageGuildsRsp), bArr);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<Integer> N3(long j3, long j16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getRolePermission kernelGuildService is null");
            return null;
        }
        return iKernelGuildService.getRolePermission(j3, j16);
    }

    public void N4(long j3, long j16, int i3, int i16, final dv dvVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelAuthControl", "", "guildId:" + j3 + " channelId:" + j16 + " authType:" + i3 + " type:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelAuthControl kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelAuthControl(j3, j16, i3, i16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.50
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i18, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.50.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelAuthControl", "", i18, str, "result:" + i18 + " errMsg:" + str + " ", q16);
                            dvVar.a(i18, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void N5(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "userShareScreen", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "userShareScreen kernelGuildService is null");
        } else {
            iKernelGuildService.userShareScreen(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.30
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "userShareScreen", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void O0(String str, ArrayList<da> arrayList, final dm dmVar) {
        String str2 = "expCode:" + str + " joinGuilds.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuildsForGrowth", "", str2, i3);
        if (str == null) {
            str = "";
        }
        ArrayList<GProJoinGuilds> arrayList2 = new ArrayList<>();
        Iterator<da> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(aa.e1(it.next()));
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "addGuildsForGrowth kernelGuildService is null");
        } else {
            iKernelGuildService.addGuildsForGrowth(str, arrayList2, new IGProJoinGuildsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.90
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildsCallback
                public void onJoinGuilds(final int i16, final String str3, final ArrayList<GProJoinGuildResult> arrayList3) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.90.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "addGuildsForGrowth", "", i16, str3, "result:" + i16 + " errMsg:" + str3 + " joinGuildsRest.size():" + arrayList3.size() + " ", q16);
                            ArrayList<IGProJoinGuildResult> arrayList4 = new ArrayList<>();
                            Iterator it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                arrayList4.add(new GGProJoinGuildResult((GProJoinGuildResult) it5.next()));
                            }
                            dmVar.onJoinGuilds(i16, str3, arrayList4);
                        }
                    });
                }
            });
        }
    }

    public void O1(String str, boolean z16) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchChannelInfoWithUnreadStatus kernelGuildService is null");
        } else {
            iKernelGuildService.fetchChannelInfoWithUnreadStatus(O0, z16);
        }
    }

    public void O2(bg bgVar, final wh2.bu buVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCategoryTabContent", "", "", i3);
        GProGetCategoryTabContentReq g06 = aa.g0(bgVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCategoryTabContent kernelGuildService is null");
        } else {
            iKernelGuildService.getCategoryTabContent(g06, new IGProGetCategoryTabContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.192
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCategoryTabContentCallback
                public void onGetCategoryTabContent(final int i16, final String str, final GProGetCategoryTabContentRsp gProGetCategoryTabContentRsp, final byte[] bArr) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.192.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCategoryTabContent", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            buVar.a(i16, str, new GGProGetCategoryTabContentRsp(gProGetCategoryTabContentRsp), bArr);
                        }
                    });
                }
            });
        }
    }

    public void O3(bz bzVar, wh2.da daVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getSelectChannelIDs", "", "", i3);
        GProGetSelectChannelIDReq y06 = aa.y0(bzVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getSelectChannelIDs kernelGuildService is null");
        } else {
            iKernelGuildService.getSelectChannelIDs(y06, new IGProGetSelectChannelIDsCallback(q16, daVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.91

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268193a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSelectChannelIDsCallback
                public void onGetSelectChannelIDs(final int i16, final String str, final GProGetSelectChannelIDRsp gProGetSelectChannelIDRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.91.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getSelectChannelIDs", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass91.this.f268193a);
                            new GGProGetSelectChannelIDRsp(gProGetSelectChannelIDRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void O4(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, final dv dvVar) {
        String str = "guildId:" + j3 + " channelId:" + j16 + " addIdList.size():" + arrayList.size() + " removeIdList.size():" + arrayList2.size() + " authType:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelAuthControlMemberList", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelAuthControlMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelAuthControlMemberList(j3, j16, arrayList, arrayList2, i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.55
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i17, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.55.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelAuthControlMemberList", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i17, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void O5(fi fiVar, fm fmVar, final eu euVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceSmobaGameCreateRoom", "", "", i3);
        GProVoiceSmobaGameBaseRoomParams m26 = aa.m2(fiVar);
        GProVoiceSmobaGameSmobaRoomParams q26 = aa.q2(fmVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "voiceSmobaGameCreateRoom kernelGuildService is null");
        } else {
            iKernelGuildService.voiceSmobaGameCreateRoom(m26, q26, new IGProVoiceSmobaGameCreateRoomCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.46
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameCreateRoomCallback
                public void onCreateGProVoiceSmobaGameRoom(final int i16, final String str, final GProVoiceSmobaGameBaseRoomInfo gProVoiceSmobaGameBaseRoomInfo, final GProVoiceSmobaGameSmobaRoomInfo gProVoiceSmobaGameSmobaRoomInfo, final GProVoiceSmobaGameRoomStateInfo gProVoiceSmobaGameRoomStateInfo, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.46.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceSmobaGameCreateRoom", "", i16, str, "result:" + i16 + " errMsg:" + str + " smobaSchema:" + str2 + " ", q16);
                            euVar.a(i16, str, new GGProVoiceSmobaGameBaseRoomInfo(gProVoiceSmobaGameBaseRoomInfo), new GGProVoiceSmobaGameSmobaRoomInfo(gProVoiceSmobaGameSmobaRoomInfo), new GGProVoiceSmobaGameRoomStateInfo(gProVoiceSmobaGameRoomStateInfo), str2);
                        }
                    });
                }
            });
        }
    }

    public void P0(ArrayList<Long> arrayList, final wh2.b bVar) {
        String str = "guildIds.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addRecentVisitGuildsListSync", "", str, i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "addRecentVisitGuildsListSync kernelGuildService is null");
        } else {
            iKernelGuildService.addRecentVisitGuildsListSync(arrayList, new IGProAddRecentVisitGuildIdsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.155
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAddRecentVisitGuildIdsCallback
                public void onResult(final int i16, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.155.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "addRecentVisitGuildsListSync", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            bVar.onResult(i16, str2);
                        }
                    });
                }
            });
        }
    }

    public void P1(long j3, long j16, final aj ajVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelVisibleRoleListWithoutLevelRole", "", "guildId:" + j3 + " channelId:" + j16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchChannelVisibleRoleListWithoutLevelRole kernelGuildService is null");
        } else {
            iKernelGuildService.fetchChannelVisibleRoleListWithoutLevelRole(j3, j16, new IGProFetchChannelVisibleRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.124
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleRoleListCallback
                public void onFetchChannelVisibleRoleList(final int i16, final String str, final int i17, final ArrayList<GProGuildRole> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.124.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelVisibleRoleListWithoutLevelRole", "", i16, str, "result:" + i16 + " errMsg:" + str + " totalRoleNum:" + i17 + " roleList.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProGuildRoleInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProGuildRoleInfo((GProGuildRole) it.next()));
                            }
                            ajVar.onFetchChannelVisibleRoleList(i16, str, i17, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void P2(bh bhVar, final wh2.bv bvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getChannelActivity", "", "", i3);
        GProGetChannelActivityReq h06 = aa.h0(bhVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getChannelActivity kernelGuildService is null");
        } else {
            iKernelGuildService.getChannelActivity(h06, new IGProGetChannelActivityCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.93
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelActivityCallback
                public void onGetChannelActivityCallback(final int i16, final String str, final GProGetChannelActivityRsp gProGetChannelActivityRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.93.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getChannelActivity", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bvVar.a(i16, str, new GGProGetChannelActivityRsp(gProGetChannelActivityRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public int P3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getSelfLiveChannelBanStatus kernelGuildService is null");
            return 0;
        }
        return iKernelGuildService.getSelfLiveChannelBanStatus(O0, O02);
    }

    public void P4(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, final dv dvVar) {
        String str = "guildId:" + j3 + " channelId:" + j16 + " addIdList.size():" + arrayList.size() + " removeIdList.size():" + arrayList2.size() + " authType:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelAuthControlRoleList", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelAuthControlRoleList kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelAuthControlRoleList(j3, j16, arrayList, arrayList2, i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.54
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i17, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.54.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelAuthControlRoleList", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i17, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void P5(fj fjVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceSmobaGameDissmissRoom", "", "", i3);
        GProVoiceSmobaGameDissmissRoomReq n26 = aa.n2(fjVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "voiceSmobaGameDissmissRoom kernelGuildService is null");
        } else {
            iKernelGuildService.voiceSmobaGameDissmissRoom(n26, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.44
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.44.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceSmobaGameDissmissRoom", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void Q0(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addSpeakOrderByUser", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "addSpeakOrderByUser kernelGuildService is null");
        } else {
            iKernelGuildService.addSpeakOrderByUser(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.77
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.77.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "addSpeakOrderByUser", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void Q1(final de deVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGlobalPrivacySwitch", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGlobalPrivacySwitch kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGlobalPrivacySwitch(new IGProGlobalPrivacySwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.25
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalPrivacySwitchCallback
                public void onResult(final int i16, final String str, final GProGlobalPrivacySwitchGroup gProGlobalPrivacySwitchGroup) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGlobalPrivacySwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            deVar.a(i16, str, new GGProGlobalPrivacySwitchGroup(gProGlobalPrivacySwitchGroup));
                        }
                    });
                }
            });
        }
    }

    public void Q2(bi biVar, final wh2.bw bwVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getConfigTabContent", "", "", i3);
        GProGetConfigTabContentReq i06 = aa.i0(biVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getConfigTabContent kernelGuildService is null");
        } else {
            iKernelGuildService.getConfigTabContent(i06, new IGProGetConfigTabContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.193
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetConfigTabContentCallback
                public void onGetConfigTabContent(final int i16, final String str, final GProGetConfigTabContentRsp gProGetConfigTabContentRsp, final byte[] bArr) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.193.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getConfigTabContent", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bwVar.a(i16, str, new GGProGetConfigTabContentRsp(gProGetConfigTabContentRsp), bArr);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public int Q3(long j3, long j16, boolean z16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getShareButtonFromCache kernelGuildService is null");
            return 0;
        }
        return iKernelGuildService.getShareButtonFromCache(j3, j16, z16);
    }

    public void Q4(ej ejVar, final wh2.ef efVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryOrder", "", "", i3);
        GProSetCategoryOrderReq N1 = aa.N1(ejVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelCategoryOrder kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelCategoryOrder(N1, new IGProSetCategoryOrderCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.165
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetCategoryOrderCallback
                public void onSetCategoryOrder(final int i16, final String str, final GProSecurityResult gProSecurityResult, final GProSetCategoryOrderRsp gProSetCategoryOrderRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.165.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelCategoryOrder", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            efVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), new GGProSetCategoryOrderRsp(gProSetCategoryOrderRsp));
                        }
                    });
                }
            });
        }
    }

    public void Q5(long j3, int i3, long j16, long j17, final wh2.ev evVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceSmobaGameEnterRoom", "", "roomId:" + j3 + " roomType:" + i3 + " guildId:" + j16 + " channelId:" + j17 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "voiceSmobaGameEnterRoom kernelGuildService is null");
        } else {
            iKernelGuildService.voiceSmobaGameEnterRoom(j3, i3, j16, j17, new IGProVoiceSmobaGameEnterRoomCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.47
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameEnterRoomCallback
                public void onEnterGProVoiceSmobaGameRoom(final int i17, final String str, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.47.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceSmobaGameEnterRoom", "", i17, str, "result:" + i17 + " errMsg:" + str + " smobaSchema:" + str2 + " ", q16);
                            evVar.onEnterGProVoiceSmobaGameRoom(i17, str, str2);
                        }
                    });
                }
            });
        }
    }

    public void R0(com.tencent.mobileqq.qqguildsdk.data.genc.a aVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchDeleteAISearchSession", "", "", i3);
        GProAISearchBatchDeleteSessionReq a16 = aa.a(aVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "batchDeleteAISearchSession kernelGuildService is null");
        } else {
            iKernelGuildService.batchDeleteAISearchSession(a16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.209
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.209.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchDeleteAISearchSession", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void R1(int i3, bl blVar, ak akVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuestGuildInfoWithChannelList", "", "sourceType:" + i3 + " ", i16);
        GProGetGuildAndChannelReq l06 = aa.l0(blVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuestGuildInfoWithChannelList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuestGuildInfoWithChannelList(i3, l06, new IGProFetchGuestGuildInfoWithChannelListCallback(q16, akVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.200

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267535a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuestGuildInfoWithChannelListCallback
                public void onFetchGuestGuildInfoWithChannelList(final int i17, final String str, final String str2, final GProGuild gProGuild, final GProGuildInit gProGuildInit, final int i18, final GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.200.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuestGuildInfoWithChannelList", "", i17, str, "result:" + i17 + " errMsg:" + str + " joinSig:" + str2 + " extCode:" + i18 + " ", AnonymousClass200.this.f267535a);
                            new GProGuildInfo(gProGuild);
                            new GGProGuildInit(gProGuildInit);
                            new GGProCmd0x1258ExtendRsp(gProCmd0x1258ExtendRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void R2(long j3, long j16, final wh2.bx bxVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getCurrPlaySong", "", "guildId:" + j3 + " channelId:" + j16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getCurrPlaySong kernelGuildService is null");
        } else {
            iKernelGuildService.getCurrPlaySong(j3, j16, new IGProGetCurrPlaySongCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.83
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetCurrPlaySongCallback
                public void onGetCurrPlaySongCallback(final int i16, final String str, final GProGetCurrPlaySongRsp gProGetCurrPlaySongRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.83.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getCurrPlaySong", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bxVar.a(i16, str, new GGProGetCurrPlaySongRsp(gProGetCurrPlaySongRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProSimpleProfile R3(String str, String str2, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getSimpleProfile kernelGuildService is null");
            return null;
        }
        return new GGProSimpleProfile(iKernelGuildService.getSimpleProfile(O0, O02, i3));
    }

    public void R4(cv cvVar) {
        GProHeartbeatReq U0 = aa.U0(cvVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelHeartbeat kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelHeartbeat(U0);
        }
    }

    public void R5(fk fkVar, final wh2.ex exVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceSmobaGameKickOutRoom", "", "", i3);
        GProVoiceSmobaGameKickOutRoomReq o26 = aa.o2(fkVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "voiceSmobaGameKickOutRoom kernelGuildService is null");
        } else {
            iKernelGuildService.voiceSmobaGameKickOutRoom(o26, new IGProVoiceSmobaKickOutRoomCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.45
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaKickOutRoomCallback
                public void onVoiceSmobaKickOutRoom(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.45.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceSmobaGameKickOutRoom", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            exVar.onVoiceSmobaKickOutRoom(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void S0(com.tencent.mobileqq.qqguildsdk.data.genc.r rVar, final wh2.e eVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchGetGuildLabelInfo", "", "", i3);
        GProBatchGetGuildLabelInfoReq r16 = aa.r(rVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "batchGetGuildLabelInfo kernelGuildService is null");
        } else {
            iKernelGuildService.batchGetGuildLabelInfo(r16, new IGProBatchGetGuildLabelInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.173
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetGuildLabelInfoCallback
                public void onBatchGetGuildLabelInfo(final int i16, final String str, final GProBatchGetGuildLabelInfoRsp gProBatchGetGuildLabelInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.173.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchGetGuildLabelInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            eVar.a(i16, str, new GGProBatchGetGuildLabelInfoRsp(gProBatchGetGuildLabelInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void S1(at atVar, final wh2.al alVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildActiveLiveChannelNum", "", "", i3);
        GProFetchGuildActiveLiveChannelNumReq T = aa.T(atVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildActiveLiveChannelNum kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildActiveLiveChannelNum(T, new IGProFetchGuildActiveLiveChannelNumCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.201
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildActiveLiveChannelNumCallback
                public void onResult(final int i16, final String str, final GProFetchGuildActiveLiveChannelNumRsp gProFetchGuildActiveLiveChannelNumRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.201.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildActiveLiveChannelNum", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            alVar.a(i16, str, new GGProFetchGuildActiveLiveChannelNumRsp(gProFetchGuildActiveLiveChannelNumRsp));
                        }
                    });
                }
            });
        }
    }

    public void S2(bm bmVar, final wh2.bz bzVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getFriendsInGuild", "", "", i3);
        GProGetGuildFriendsReq m06 = aa.m0(bmVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getFriendsInGuild kernelGuildService is null");
        } else {
            iKernelGuildService.getFriendsInGuild(m06, new IGProGetFriendsInGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.202
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFriendsInGuildCallback
                public void onGetFriendsInGuild(final int i16, final String str, final GProGetGuildFriendsRsp gProGetGuildFriendsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.202.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getFriendsInGuild", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bzVar.a(i16, str, new GGProGetGuildFriendsRsp(gProGetGuildFriendsRsp));
                        }
                    });
                }
            });
        }
    }

    public void S3(ca caVar, final db dbVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getSimpleProfileAsync", "", "", i3);
        GProGetSimpleProfileAsyncReq z06 = aa.z0(caVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getSimpleProfileAsync kernelGuildService is null");
        } else {
            iKernelGuildService.getSimpleProfileAsync(z06, new IGProGetSimpleProfileAsyncCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.216
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSimpleProfileAsyncCallback
                public void onResult(final int i16, final String str, final GProGetSimpleProfileAsyncRsp gProGetSimpleProfileAsyncRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.216.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getSimpleProfileAsync", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dbVar.a(i16, str, new GGProGetSimpleProfileAsyncRsp(gProGetSimpleProfileAsyncRsp));
                        }
                    });
                }
            });
        }
    }

    public void S4(long j3, long j16, int i3, boolean z16, int i16, final dv dvVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelUserNumLimit", "", "guildId:" + j3 + " channelId:" + j16 + " channelType:" + i3 + " isLimit:" + z16 + " limitNum:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setChannelUserNumLimit kernelGuildService is null");
        } else {
            iKernelGuildService.setChannelUserNumLimit(j3, j16, i3, z16, i16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.84
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i18, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.84.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelUserNumLimit", "", i18, str, "result:" + i18 + " errMsg:" + str + " ", q16);
                            dvVar.a(i18, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void S5(fl flVar, final wh2.ew ewVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceSmobaGameQuitRoom", "", "", i3);
        GProVoiceSmobaGameQuitRoomReq p26 = aa.p2(flVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "voiceSmobaGameQuitRoom kernelGuildService is null");
        } else {
            iKernelGuildService.voiceSmobaGameQuitRoom(p26, new IGProVoiceSmobaGameQuitRoomCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.48
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceSmobaGameQuitRoomCallback
                public void onVoiceSmobaGameQuitRoomCallback(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.48.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceSmobaGameQuitRoom", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ewVar.onVoiceSmobaGameQuitRoomCallback(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void T0(com.tencent.mobileqq.qqguildsdk.data.genc.bq bqVar, wh2.cn cnVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchGetItemDetail", "", "", i3);
        GProGetItemDetailReq q06 = aa.q0(bqVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "batchGetItemDetail kernelGuildService is null");
        } else {
            iKernelGuildService.batchGetItemDetail(q06, new IGProGetItemDetailCallback(q16, cnVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.103

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266803a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetItemDetailCallback
                public void onItemDetailCallback(final int i16, final String str, final GProGetItemDetailRsp gProGetItemDetailRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.103.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchGetItemDetail", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass103.this.f266803a);
                            new GGProGetItemDetailRsp(gProGetItemDetailRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void T1(long j3, final df dfVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildActiveValue", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildActiveValue kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildActiveValue(j3, new IGProGuildActiveValueCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.69
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildActiveValueCallback
                public void onGuildActiveValue(final int i16, final String str, final GProGuildActiveValue gProGuildActiveValue) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.69.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildActiveValue", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dfVar.a(i16, str, new GGProGuildActiveValue(gProGuildActiveValue));
                        }
                    });
                }
            });
        }
    }

    public void T2(bk bkVar, wh2.ca caVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getFriendsRecommend", "", "", i3);
        GProGetFriendsRecommendReq k06 = aa.k0(bkVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getFriendsRecommend kernelGuildService is null");
        } else {
            iKernelGuildService.getFriendsRecommend(k06, new IGProGetFriendsRecommendCallback(q16, caVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.178

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267360a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFriendsRecommendCallback
                public void onGetFriendsRecommend(final int i16, final String str, final GProGetFriendsRecommendRsp gProGetFriendsRecommendRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.178.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getFriendsRecommend", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass178.this.f267360a);
                            new GGProGetFriendsRecommendRsp(gProGetFriendsRecommendRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<Long> T3() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getSortedGuildIdsFromCache kernelGuildService is null");
            return null;
        }
        return iKernelGuildService.getSortedGuildIdsFromCache();
    }

    public void T4(long j3, long j16, boolean z16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setEnteredChannelState kernelGuildService is null");
        } else {
            iKernelGuildService.setEnteredChannelState(j3, j16, z16);
        }
    }

    public void U0(long j3, int i3, final wh2.f fVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "beforehandGetGuildSpeakPermission", "", "guildId:" + j3 + " sourceType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "beforehandGetGuildSpeakPermission kernelGuildService is null");
        } else {
            iKernelGuildService.beforehandGetGuildSpeakPermission(j3, i3, new IGProBeforehandGetSpeakPermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.146
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBeforehandGetSpeakPermissionCallback
                public void onBeforehandGetSpeakPermission(final int i17, final String str, final GProSpeakPermissionInfo gProSpeakPermissionInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.146.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "beforehandGetGuildSpeakPermission", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            fVar.a(i17, str, new com.tencent.mobileqq.qqguildsdk.data.r(gProSpeakPermissionInfo));
                        }
                    });
                }
            });
        }
    }

    public void U1(String str, byte[] bArr, final wh2.am amVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildBlackList", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildBlackList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildBlackList(O0, bArr, new IGProFetchGuildBlackListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.6
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBlackListCallback
                public void onFetchGuildBlackList(final int i16, final String str2, final ArrayList<GProBlackList> arrayList, final byte[] bArr2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildBlackList", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " blackLists.size():" + arrayList.size() + " ", q16);
                            ArrayList<dr> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new aq((GProBlackList) it.next()));
                            }
                            amVar.onFetchGuildBlackList(i16, str2, arrayList2, bArr2);
                        }
                    });
                }
            });
        }
    }

    public void U2(long j3, String str, final cb cbVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuidePageInfo", "", "appId:" + j3 + " templateId:" + str + " ", i3);
        if (str == null) {
            str = "";
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuidePageInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuidePageInfo(j3, str, new IGProGetGuidePageInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.132
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuidePageInfoCallback
                public void onGetGuidePageInfoCallback(final int i16, final String str2, final GProGetGuidePageInfoRsp gProGetGuidePageInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.132.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuidePageInfo", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            cbVar.a(i16, str2, new GGProGetGuidePageInfoRsp(gProGetGuidePageInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void U3(com.tencent.mobileqq.qqguildsdk.data.genc.z zVar, final dl dlVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "inviteJoinSingleGuild", "", "", i3);
        GProCmd0xf67ReqBody z16 = aa.z(zVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "inviteJoinSingleGuild kernelGuildService is null");
        } else {
            iKernelGuildService.inviteJoinSingleGuild(z16, new IGProJoinGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.203
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildCallback
                public void onJoinGuild(final int i16, final String str, final GProJoinGuildResult gProJoinGuildResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.203.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "inviteJoinSingleGuild", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dlVar.a(i16, str, new GGProJoinGuildResult(gProJoinGuildResult));
                        }
                    });
                }
            });
        }
    }

    public void U4(int i3, int i16, final de deVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGlobalPrivacySwitch", "", "status:" + i3 + " type:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGlobalPrivacySwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setGlobalPrivacySwitch(i3, i16, new IGProGlobalPrivacySwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.26
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalPrivacySwitchCallback
                public void onResult(final int i18, final String str, final GProGlobalPrivacySwitchGroup gProGlobalPrivacySwitchGroup) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGlobalPrivacySwitch", "", i18, str, "result:" + i18 + " errMsg:" + str + " ", q16);
                            deVar.a(i18, str, new GGProGlobalPrivacySwitchGroup(gProGlobalPrivacySwitchGroup));
                        }
                    });
                }
            });
        }
    }

    public void V0(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "cancelSpeakOrderByAdmin", "", "", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "cancelSpeakOrderByAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.cancelSpeakOrderByAdmin(o16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.80
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.80.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "cancelSpeakOrderByAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void V1(com.tencent.mobileqq.qqguildsdk.data.genc.s sVar, final an anVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildBottomTabExp", "", "", i3);
        GProBottomTabExpReq s16 = aa.s(sVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildBottomTabExp kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildBottomTabExp(s16, new IGProFetchGuildBottomTabExpCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.85
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBottomTabExpCallback
                public void onFetchGuildBottomTabExp(final int i16, final String str, final GProGuildBottomTabExpData gProGuildBottomTabExpData) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.85.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildBottomTabExp", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            anVar.a(i16, str, new GGProGuildBottomTabExpData(gProGuildBottomTabExpData));
                        }
                    });
                }
            });
        }
    }

    public void V2(final cc ccVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildBindableGroups", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildBindableGroups kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildBindableGroups(new IGProGetGuildBindableGroupsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.160
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBindableGroupsCallback
                public void onGetGuildBindableGroups(final int i16, final String str, final GProBindableGroups gProBindableGroups, final GProBindableGroups gProBindableGroups2, final GProBindableGroups gProBindableGroups3) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.160.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildBindableGroups", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ccVar.a(i16, str, new GGProBindableGroups(gProBindableGroups), new GGProBindableGroups(gProBindableGroups2), new GGProBindableGroups(gProBindableGroups3));
                        }
                    });
                }
            });
        }
    }

    public void V3(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "inviteUserHandUpForAdmin", "", "", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "inviteUserHandUpForAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.inviteUserHandUpForAdmin(o16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.37
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.37.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "inviteUserHandUpForAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void V4(ce ceVar, final wh2.d dVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildAuditInfo", "", "", i3);
        GProGuildAuditInfoReq D0 = aa.D0(ceVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildAuditInfo kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildAuditInfo(D0, new IGProAuditInfoResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.129
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAuditInfoResultCallback
                public void onResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final int i17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.129.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildAuditInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " backEndResult:" + i17 + " ", q16);
                            dVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), i17);
                        }
                    });
                }
            });
        }
    }

    public void W0(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "cancelUserHandUpForAdmin", "", "", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "cancelUserHandUpForAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.cancelUserHandUpForAdmin(o16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.36
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.36.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "cancelUserHandUpForAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void W1(String str, ArrayList<Long> arrayList, final ao aoVar) {
        String str2 = "guildId:" + str + " groupCodes.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildBoundGroupsWithGroupCodes", "", str2, i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildBoundGroupsWithGroupCodes kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildBoundGroupsWithGroupCodes(O0, arrayList, new IGProFetchGuildBoundGroupsWithGroupCodesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.162
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildBoundGroupsWithGroupCodesCallback
                public void onFetchGuildBoundGroupsWithGroupCodes(final int i16, final String str3, final ArrayList<GProBindingGroup> arrayList2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.162.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildBoundGroupsWithGroupCodes", "", i16, str3, "result:" + i16 + " errMsg:" + str3 + " boundGroups.size():" + arrayList2.size() + " ", q16);
                            ArrayList<IGProBindingGroup> arrayList3 = new ArrayList<>();
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new GGProBindingGroup((GProBindingGroup) it.next()));
                            }
                            aoVar.onFetchGuildBoundGroupsWithGroupCodes(i16, str3, arrayList3);
                        }
                    });
                }
            });
        }
    }

    public void W2(long j3, final cd cdVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildBindingInfo", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildBindingInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildBindingInfo(j3, new IGProGetGuildBindingInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.131
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBindingInfoCallback
                public void onGetGuildBindingInfoCallback(final int i16, final String str, final GProGetGuildBindingInfoRsp gProGetGuildBindingInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.131.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildBindingInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cdVar.a(i16, str, new GGProGetGuildBindingInfoRsp(gProGetGuildBindingInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void W3(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "inviteUserQueueForAdmin", "", "", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "inviteUserQueueForAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.inviteUserQueueForAdmin(o16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.38
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.38.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "inviteUserQueueForAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void W4(en enVar, final wh2.eg egVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildBoundGroups", "", "", i3);
        GProSortAndWriteBindGroupsReq R1 = aa.R1(enVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildBoundGroups kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildBoundGroups(R1, new IGProSetGuildBoundGroupsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.164
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildBoundGroupsCallback
                public void onSetGuildBoundGroups(final int i16, final String str, final GProSortAndWriteBindGroupsRsp gProSortAndWriteBindGroupsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.164.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildBoundGroups", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            egVar.a(i16, str, new GGProSortAndWriteBindGroupsRsp(gProSortAndWriteBindGroupsRsp));
                        }
                    });
                }
            });
        }
    }

    public void X0(String str, boolean z16, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "changeGuildAllowSearch", "", "guildId:" + str + " allowSearch:" + z16 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "changeGuildAllowSearch kernelGuildService is null");
        } else {
            iKernelGuildService.changeGuildAllowSearch(O0, z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.11
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "changeGuildAllowSearch", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i16, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void X1(cj cjVar, final ap apVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoAndMemberList", "", "", i3);
        GProGuildInfoAndMemberListReq I0 = aa.I0(cjVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildInfoAndMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildInfoAndMemberList(I0, new IGProFetchGuildInfoAndMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.170
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildInfoAndMemberListCallback
                public void onFetchGuildInfoAndMemberList(final int i16, final String str, final GProGuildInfoAndMemberListRsp gProGuildInfoAndMemberListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.170.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoAndMemberList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            apVar.a(i16, str, new GGProGuildInfoAndMemberListRsp(gProGuildInfoAndMemberListRsp));
                        }
                    });
                }
            });
        }
    }

    public void X2(String str, int i3, final wh2.ce ceVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildBoundGroupsFirstPage", "", "guildId:" + str + " pageNum:" + i3 + " ", i16);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildBoundGroupsFirstPage kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildBoundGroupsFirstPage(O0, i3, new IGProGetGuildBoundGroupsFirstPageCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.161
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildBoundGroupsFirstPageCallback
                public void onGetGuildBoundGroupsFirstPage(final int i17, final String str2, final GProMemberGetBoundGroupRsp gProMemberGetBoundGroupRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.161.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildBoundGroupsFirstPage", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", q16);
                            ceVar.a(i17, str2, new GGProMemberGetBoundGroupRsp(gProMemberGetBoundGroupRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public boolean X3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "isGuildMember kernelGuildService is null");
            return false;
        }
        return iKernelGuildService.isGuildMember(O0);
    }

    public void X4(long j3, int i3, int i16, final wh2.ei eiVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildCommonUnNotifyFlag", "", "guildId:" + j3 + " setType:" + i3 + " notifyFlag:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildCommonUnNotifyFlag kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildCommonUnNotifyFlag(j3, i3, i16, new IGProSetGuildNotifyDisplayCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.152
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildNotifyDisplayCallback
                public void onSetGuildNotifyDisplay(final int i18, final String str, final int i19) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.152.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildCommonUnNotifyFlag", "", i18, str, "result:" + i18 + " errMsg:" + str + " needNotice:" + i19 + " ", q16);
                            eiVar.onSetGuildNotifyDisplay(i18, str, i19);
                        }
                    });
                }
            });
        }
    }

    public void Y0(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkAVState", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkAVState kernelGuildService is null");
        } else {
            iKernelGuildService.checkAVState(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.32
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.32.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkAVState", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void Y1(com.tencent.mobileqq.qqguildsdk.data.genc.p pVar, wh2.aq aqVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildTaskCards", "", "", i3);
        GProAllGuildTaskCardReq p16 = aa.p(pVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchGuildTaskCards kernelGuildService is null");
        } else {
            iKernelGuildService.fetchGuildTaskCards(p16, new IGProFetchGuildTaskCardsCallback(q16, aqVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.185

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267415a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildTaskCardsCallback
                public void onFetchGuildTaskCards(final int i16, final String str, final GProAllGuildTaskCardRsp gProAllGuildTaskCardRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.185.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildTaskCards", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass185.this.f267415a);
                            new GGProAllGuildTaskCardRsp(gProAllGuildTaskCardRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void Y2(cg cgVar, final dg dgVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildCheckinInfo", "", "", i3);
        GProGuildCheckinReq F0 = aa.F0(cgVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildCheckinInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildCheckinInfo(F0, new IGProGuildCheckinCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.180
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildCheckinCallback
                public void onGuildCheckin(final int i16, final String str, final GProGuildCheckinRsp gProGuildCheckinRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.180.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildCheckinInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dgVar.a(i16, str, new GGProGuildCheckinRsp(gProGuildCheckinRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public boolean Y3(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "isQQMsgListGuild kernelGuildService is null");
            return false;
        }
        return iKernelGuildService.isQQMsgListGuild(j3);
    }

    public void Y4(String str, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildCreatorTaskSkipStatus", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildCreatorTaskSkipStatus kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildCreatorTaskSkipStatus(O0, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.111
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.111.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildCreatorTaskSkipStatus", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            emVar.onResult(i16, str2);
                        }
                    });
                }
            });
        }
    }

    public void Z0(com.tencent.mobileqq.qqguildsdk.data.genc.ah ahVar, final wh2.h hVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkAndEncryptText", "", "", i3);
        GProEncryptTextReq H = aa.H(ahVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkAndEncryptText kernelGuildService is null");
        } else {
            iKernelGuildService.checkAndEncryptText(H, new IGProCheckAndEncryptTextCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.107
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckAndEncryptTextCallBack
                public void checkAndEncryptText(final int i16, final String str, final GProEncryptTextRsp gProEncryptTextRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.107.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkAndEncryptText", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            hVar.a(i16, str, new GGProEncryptTextRsp(gProEncryptTextRsp));
                        }
                    });
                }
            });
        }
    }

    public void Z1(au auVar, final ar arVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchJoinGuildOption", "", "", i3);
        GProFetchJoinGuildOptionReq U = aa.U(auVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchJoinGuildOption kernelGuildService is null");
        } else {
            iKernelGuildService.fetchJoinGuildOption(U, new IGProFetchJoinGuildOptionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.150
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchJoinGuildOptionCallback
                public void onFetchJoinGuildOption(final int i16, final String str, final GProSecurityResult gProSecurityResult, final GProFetchJoinGuildOptionRsp gProFetchJoinGuildOptionRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.150.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchJoinGuildOption", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            arVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), new GGProFetchJoinGuildOptionRsp(gProFetchJoinGuildOptionRsp));
                        }
                    });
                }
            });
        }
    }

    public void Z2(String str, boolean z16, final cf cfVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildCreatorTasks", "", "guildId:" + str + " needSort:" + z16 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildCreatorTasks kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildCreatorTasks(O0, z16, new IGProGetGuildCreatorTasksCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.110
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildCreatorTasksCallback
                public void onResult(final int i16, final String str2, final int i17, final boolean z17, final int i18, final int i19, final ArrayList<GProTaskInfo> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.110.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildCreatorTasks", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " skipStatus:" + i17 + " isAllFinished:" + z17 + " finishedCnt:" + i18 + " totalCnt:" + i19 + " tasks.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProTaskInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProTaskInfo((GProTaskInfo) it.next()));
                            }
                            cfVar.onResult(i16, str2, i17, z17, i18, i19, arrayList2);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public boolean Z3() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "isQQMsgListReady kernelGuildService is null");
            return false;
        }
        return iKernelGuildService.isQQMsgListReady();
    }

    public void Z4(com.tencent.mobileqq.qqguildsdk.data.genc.cb cbVar, final dd ddVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildGlobalBanner", "", "", i3);
        GProGlobalBannerRep A0 = aa.A0(cbVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildGlobalBanner kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildGlobalBanner(A0, new IGProGlobalBannerCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.17
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalBannerCallback
                public void onUpdateGlobalBanner(final int i16, final String str, final GProGlobalBanner gProGlobalBanner) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildGlobalBanner", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ddVar.a(i16, str, new GGProGlobalBanner(gProGlobalBanner));
                        }
                    });
                }
            });
        }
    }

    public void a1(com.tencent.mobileqq.qqguildsdk.data.genc.u uVar, final wh2.i iVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkFeedAbstractInfo", "", "", i3);
        GProCheckFeedAbstractInfoReq u16 = aa.u(uVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkFeedAbstractInfo kernelGuildService is null");
        } else {
            iKernelGuildService.checkFeedAbstractInfo(u16, new IGProCheckFeedAbstractInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.177
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckFeedAbstractInfoCallback
                public void onCheckFeedAbstractInfo(final int i16, final String str, final GProCheckFeedAbstractInfoRsp gProCheckFeedAbstractInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.177.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkFeedAbstractInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            iVar.a(i16, str, new GGProCheckFeedAbstractInfoRsp(gProCheckFeedAbstractInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void a2(long j3, wh2.as asVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchJumpInfo", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchJumpInfo kernelGuildService is null");
        } else {
            iKernelGuildService.fetchJumpInfo(j3, new IGProFetchJumpInfoCallback(q16, asVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.19

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267445a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchJumpInfoCallback
                public void onFetchJumpInfoResult(final int i16, final String str, final boolean z16, final GProChannel gProChannel) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchJumpInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " isSwitchOn:" + z16 + " ", AnonymousClass19.this.f267445a);
                            new GGProChannel(gProChannel);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void a3(cp cpVar, final di diVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildFeedsValidCalendar", "", "", i3);
        GProGuildSearchGetFeedCalendarReq O0 = aa.O0(cpVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildFeedsValidCalendar kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildFeedsValidCalendar(O0, new IGProGuildGetFeedValidCalendarCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.182
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetFeedValidCalendarCallback
                public void onResult(final int i16, final String str, final GProGuildSearchGetFeedCalendarRsp gProGuildSearchGetFeedCalendarRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.182.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildFeedsValidCalendar", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            diVar.a(i16, str, new GGProGuildSearchGetFeedCalendarRsp(gProGuildSearchGetFeedCalendarRsp));
                        }
                    });
                }
            });
        }
    }

    public void a4(com.tencent.mobileqq.qqguildsdk.data.genc.cu cuVar, dk dkVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "joinChannelByGuildTask", "", "", i3);
        GProGuildTaskJoinChannelReq T0 = aa.T0(cuVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "joinChannelByGuildTask kernelGuildService is null");
        } else {
            iKernelGuildService.joinChannelByGuildTask(T0, new IGProJoinChannelByGuildTaskCallback(q16, dkVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.189

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267439a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinChannelByGuildTaskCallback
                public void onJoinChannelByGuildTask(final int i16, final String str, final GProGuildTaskJoinChannelRsp gProGuildTaskJoinChannelRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.189.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "joinChannelByGuildTask", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass189.this.f267439a);
                            new GGProGuildTaskJoinChannelRsp(gProGuildTaskJoinChannelRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void a5(ek ekVar, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildGlobalPermission", "", "", i3);
        GProSetGlobalPermissionReq O1 = aa.O1(ekVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildGlobalPermission kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildGlobalPermission(O1, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.206
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.206.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildGlobalPermission", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dvVar.a(i16, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void b1(wh2.j jVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkIsStrangerNewMember", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkIsStrangerNewMember kernelGuildService is null");
        } else {
            iKernelGuildService.checkIsStrangerNewMember(new IGProCheckIsStrangerNewMemberCallback(q16, jVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.71

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268043a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckIsStrangerNewMemberCallback
                public void onGProCheckIsStrangerNewMemberCallback(final int i16, final String str, final int i17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.71.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkIsStrangerNewMember", "", i16, str, "result:" + i16 + " errMsg:" + str + " openStatus:" + i17 + " ", AnonymousClass71.this.f268043a);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void b2(long j3, int i3, wh2.at atVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLevelRolePermissions", "", "guildId:" + j3 + " sourceType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchLevelRolePermissions kernelGuildService is null");
        } else {
            iKernelGuildService.fetchLevelRolePermissions(j3, i3, new IGProFetchLevelRoleListCallback(q16, atVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.68

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268017a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLevelRoleListCallback
                public void onFetchRoleListCallback(final int i17, final String str, final ArrayList<GProGuildRole> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.68.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLevelRolePermissions", "", i17, str, "result:" + i17 + " errMsg:" + str + " roleInfoList.size():" + arrayList.size() + " ", AnonymousClass68.this.f268017a);
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProGuildRoleInfo((GProGuildRole) it.next()));
                            }
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProGlobalBanner b3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildGlobalBanner kernelGuildService is null");
            return null;
        }
        return new GGProGlobalBanner(iKernelGuildService.getGuildGlobalBanner(O0));
    }

    public void b4(long j3, final dc dcVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadPartRoleMemberList", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "loadPartRoleMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.loadPartRoleMemberList(j3, new IGProGetUserInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.171
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserInfoCallback
                public void onGetUserInfo(final int i16, final String str, final ArrayList<GProUser> arrayList, final ArrayList<Long> arrayList2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.171.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadPartRoleMemberList", "", i16, str, "result:" + i16 + " errMsg:" + str + " sucList.size():" + arrayList.size() + " failList.size():" + arrayList2.size() + " ", q16);
                            ArrayList<IGProUserInfo> arrayList3 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new GProUserInfo((GProUser) it.next()));
                            }
                            dcVar.onGetUserInfo(i16, str, arrayList3, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void b5(String str, int i3, int i16, final wh2.eh ehVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildListTop", "", "guildId:" + str + " opType:" + i3 + " topType:" + i16 + " ", i17);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildListTop kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildListTop(O0, i3, i16, new IGProSetGuildListTopCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.16
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildListTopCallback
                public void onSetGuildListTop(final int i18, final String str2, final GProGuildListSortInfo gProGuildListSortInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildListTop", "", i18, str2, "result:" + i18 + " errMsg:" + str2 + " ", q16);
                            ehVar.a(i18, str2, new GGProGuildListSortInfo(gProGuildListSortInfo));
                        }
                    });
                }
            });
        }
    }

    public void c1(String str, long j3, long j16, final wh2.k kVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkLobbyAppAuthStatus", "", "appId:" + str + " guildId:" + j3 + " channelId:" + j16 + " ", i3);
        if (str == null) {
            str = "";
        }
        String str2 = str;
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkLobbyAppAuthStatus kernelGuildService is null");
        } else {
            iKernelGuildService.checkLobbyAppAuthStatus(str2, j3, j16, new IGProCheckLobbyAppAuthStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.99
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckLobbyAppAuthStatusCallback
                public void onCheckLobbyAppAuthStatus(final int i16, final String str3, final GProLobbyAppAuthStatusRsp gProLobbyAppAuthStatusRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.99.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkLobbyAppAuthStatus", "", i16, str3, "result:" + i16 + " errMsg:" + str3 + " ", q16);
                            kVar.a(i16, str3, new GGProLobbyAppAuthStatusRsp(gProLobbyAppAuthStatusRsp));
                        }
                    });
                }
            });
        }
    }

    public void c2(bj bjVar, final wh2.au auVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMVPFeedsFromServer", "", "", i3);
        GProGetContentRecommendReq j06 = aa.j0(bjVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchMVPFeedsFromServer kernelGuildService is null");
        } else {
            iKernelGuildService.fetchMVPFeedsFromServer(j06, new IGProFetchMVPFeedsDataCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.159
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMVPFeedsDataCallback
                public void onFetchMVPFeedsData(final int i16, final String str, final GProGetContentRecommendRsp gProGetContentRecommendRsp, final byte[] bArr) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.159.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMVPFeedsFromServer", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            auVar.a(i16, str, new GGProGetContentRecommendRsp(gProGetContentRecommendRsp), bArr);
                        }
                    });
                }
            });
        }
    }

    public void c3(bn bnVar, final wh2.cg cgVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildHomeCategories", "", "", i3);
        GProGetGuildHomeCategoriesReq n06 = aa.n0(bnVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildHomeCategories kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildHomeCategories(n06, new IGProGetGuildHomeCategoriesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.198
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildHomeCategoriesCallback
                public void onGetGuildHomeCategories(final ArrayList<GProCategoryChannelInfoList> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.198.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildHomeCategories", "", "categories.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProCategoryChannelInfoList> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProCategoryChannelInfoList((GProCategoryChannelInfoList) it.next()));
                            }
                            cgVar.onGetGuildHomeCategories(arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void c4(com.tencent.mobileqq.qqguildsdk.data.genc.di diVar, final Cdo cdo) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "modifyScheduleInviteStatusV2", "", "", i3);
        GProModifyScheduleInviteReq m16 = aa.m1(diVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "modifyScheduleInviteStatusV2 kernelGuildService is null");
        } else {
            iKernelGuildService.modifyScheduleInviteStatusV2(m16, new IGProModifyScheduleInviteStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.176
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback
                public void onModifyInviteStatus(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.176.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "modifyScheduleInviteStatusV2", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cdo.onModifyInviteStatus(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void c5(String str, String str2, String str3, final dv dvVar) {
        String str4;
        String str5;
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildMemberName", "", "guildId:" + str + " memberName:" + str2 + " basicName:" + str3 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = str3;
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildMemberName kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildMemberName(O0, str4, str5, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.120
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str6, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.120.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildMemberName", "", i16, str6, "result:" + i16 + " errMsg:" + str6 + " ", q16);
                            dvVar.a(i16, str6, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void d1(com.tencent.mobileqq.qqguildsdk.data.genc.dr drVar, final dq dqVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkPreventAddiction", "", "", i3);
        GProPreventAddictionCheckReq v16 = aa.v1(drVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkPreventAddiction kernelGuildService is null");
        } else {
            iKernelGuildService.checkPreventAddiction(v16, new IGProPreventAddictionCheckCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.112
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreventAddictionCheckCallback
                public void onPreventAddictionCheckCallback(final int i16, final String str, final GProPreventAddictionCheckRsp gProPreventAddictionCheckRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.112.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkPreventAddiction", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dqVar.a(i16, str, new GGProPreventAddictionCheckRsp(gProPreventAddictionCheckRsp));
                        }
                    });
                }
            });
        }
    }

    public void d2(com.tencent.mobileqq.qqguildsdk.data.genc.ap apVar, final av avVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMemberListForFeed", "", "", i3);
        GProFeedMemberListReq P = aa.P(apVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchMemberListForFeed kernelGuildService is null");
        } else {
            iKernelGuildService.fetchMemberListForFeed(P, new IGProFetchMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.7
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberListCallback
                public void onResult(final int i16, final String str, final GProFeedMemberListRsp gProFeedMemberListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMemberListForFeed", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            avVar.a(i16, str, new GGProFeedMemberListRsp(gProFeedMemberListRsp));
                        }
                    });
                }
            });
        }
    }

    public void d3(long j3, final wh2.ch chVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildHomeSections", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildHomeSections kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildHomeSections(j3, new IGProGetGuildHomeSectionsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.197
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildHomeSectionsCallback
                public void onGetGuildHomeSections(final GProGuildHomeSections gProGuildHomeSections) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.197.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildHomeSections", "", "", q16);
                            chVar.a(new GGProGuildHomeSections(gProGuildHomeSections));
                        }
                    });
                }
            });
        }
    }

    public void d4(com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar, final wh2.p pVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "openAVLobbyApp", "", "", i3);
        GProCreateLobbyReq D = aa.D(adVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "openAVLobbyApp kernelGuildService is null");
        } else {
            iKernelGuildService.openAVLobbyApp(D, new IGProCreateLobbyCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.95
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateLobbyCallback
                public void onCreateLobby(final int i16, final String str, final GProCreateLobbyRsp gProCreateLobbyRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.95.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "openAVLobbyApp", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            pVar.a(i16, str, new GGProCreateLobbyRsp(gProCreateLobbyRsp));
                        }
                    });
                }
            });
        }
    }

    public void d5(String str, boolean z16, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildNeedRealNameForVisitor", "", "guildId:" + str + " needRealName:" + z16 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildNeedRealNameForVisitor kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildNeedRealNameForVisitor(O0, z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.72
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.72.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildNeedRealNameForVisitor", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            emVar.onResult(i16, str2);
                        }
                    });
                }
            });
        }
    }

    public void e1(fe feVar, final wh2.l lVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkUserFreeGiftInfo", "", "", i3);
        GProUserFreeGiftReq i26 = aa.i2(feVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "checkUserFreeGiftInfo kernelGuildService is null");
        } else {
            iKernelGuildService.checkUserFreeGiftInfo(i26, new IGProCheckUserFreeGiftCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.138
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckUserFreeGiftCallback
                public void onResult(final int i16, final String str, final GProUserFreeGiftInfoRsp gProUserFreeGiftInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.138.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkUserFreeGiftInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            lVar.a(i16, str, new GGProUserFreeGiftInfoRsp(gProUserFreeGiftInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void e2(final aw awVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMyCreateGuilds", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchMyCreateGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.fetchMyCreateGuilds(new IGProFetchMyCreateGuildsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.20
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMyCreateGuildsCallback
                public void onFetchMyCreateGuilds(final int i16, final String str, final ArrayList<GProCreatedGuildInfo> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMyCreateGuilds", "", i16, str, "result:" + i16 + " errMsg:" + str + " createdGuilds.size():" + arrayList.size() + " ", q16);
                            ArrayList<IGProCreatedGuildInfo> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProCreatedGuildInfo((GProCreatedGuildInfo) it.next()));
                            }
                            awVar.onFetchMyCreateGuilds(i16, str, arrayList2);
                        }
                    });
                }
            });
        }
    }

    public void e3(com.tencent.mobileqq.qqguildsdk.data.genc.bo boVar, ci ciVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildLableInfo", "", "", i3);
        GProGetGuildLabelReq o06 = aa.o0(boVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildLableInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildLableInfo(o06, new IGProGetGuildLableInfoCallback(q16, ciVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.89

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268173a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildLableInfoCallback
                public void onGetGuildLableInfo(final int i16, final String str, final GProGetGuildLabelRsp gProGetGuildLabelRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.89.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildLableInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass89.this.f268173a);
                            new GGProGetGuildLabelRsp(gProGetGuildLabelRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void e4(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryAVState", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "queryAVState kernelGuildService is null");
        } else {
            iKernelGuildService.queryAVState(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.31
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryAVState", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void e5(long j3, int i3, final dv dvVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildNumSearchSwitch", "", "guildId:" + j3 + " guildNumSearchSwitch:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildNumSearchSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildNumSearchSwitch(j3, i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.130
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i17, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.130.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildNumSearchSwitch", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            dvVar.a(i17, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void f1(ArrayList<Long> arrayList) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "clearGuildRelatedData kernelGuildService is null");
        } else {
            iKernelGuildService.clearGuildRelatedData(arrayList);
        }
    }

    public void f2(String str, int i3, int i16, ArrayList<Long> arrayList, final ax axVar) {
        String str2 = "guildId:" + str + " getNum:" + i3 + " groupType:" + i16 + " channelIds.size():" + arrayList.size() + " ";
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchOnlineUsers", "", str2, i17);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchOnlineUsers kernelGuildService is null");
        } else {
            iKernelGuildService.fetchOnlineUsers(O0, i3, i16, arrayList, new IGProFetchOnlineUsersCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.13
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchOnlineUsersCallback
                public void onFetchOnlineUsers(final int i18, final String str3, final GProGuildOnlineUsersInfo gProGuildOnlineUsersInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchOnlineUsers", "", i18, str3, "result:" + i18 + " errMsg:" + str3 + " ", q16);
                            axVar.a(i18, str3, new GGProGuildOnlineUsersInfo(gProGuildOnlineUsersInfo));
                        }
                    });
                }
            });
        }
    }

    public void f3(long j3, final wh2.cj cjVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildNum", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildNum kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildNum(j3, new IGProGetGuildNumCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.133
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildNumCallback
                public void onGetGuildNumCallback(final int i16, final String str, final GProGetGuildNumRsp gProGetGuildNumRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.133.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildNum", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            cjVar.a(i16, str, new GGProGetGuildNumRsp(gProGetGuildNumRsp));
                        }
                    });
                }
            });
        }
    }

    public void f4(String str, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryApplyAddGuildStatus", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "queryApplyAddGuildStatus kernelGuildService is null");
        } else {
            iKernelGuildService.queryApplyAddGuildStatus(O0, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.12
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryApplyAddGuildStatus", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i16, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void f5(long j3, int i3, final dv dvVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildQRCodeSwitch", "", "guildId:" + j3 + " qrCodeSwitch:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setGuildQRCodeSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setGuildQRCodeSwitch(j3, i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.128
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i17, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.128.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildQRCodeSwitch", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            dvVar.a(i17, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void g1(long j3, long j16, long j17, final wh2.u uVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "closeAVLobbyApp", "", "guildId:" + j3 + " channelId:" + j16 + " lobbyId:" + j17 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "closeAVLobbyApp kernelGuildService is null");
        } else {
            iKernelGuildService.closeAVLobbyApp(j3, j16, j17, new IGProDeleteLobbyCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.96
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteLobbyCallback
                public void onDeleteLobby(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.96.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "closeAVLobbyApp", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            uVar.onDeleteLobby(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void g2(long j3, long j16, long j17, int i3, int i16, final wh2.g gVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchOtherChannelUserPermission", "", "guildId:" + j3 + " channelId:" + j16 + " tinyId:" + j17 + " permissionFilter:" + i3 + " sourceType:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchOtherChannelUserPermission kernelGuildService is null");
        } else {
            iKernelGuildService.fetchOtherChannelUserPermission(j3, j16, j17, i3, i16, new IGProChannelUserPermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.58
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelUserPermissionCallback
                public void onFetchChannelUserPermission(final int i18, final String str, final int i19) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.58.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchOtherChannelUserPermission", "", i18, str, "result:" + i18 + " errMsg:" + str + " userPermissionType:" + i19 + " ", q16);
                            gVar.onFetchChannelUserPermission(i18, str, i19);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public long g3(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildRoleLimit kernelGuildService is null");
            return 0L;
        }
        return iKernelGuildService.getGuildRoleLimit(j3);
    }

    public void g4(ch chVar, final dh dhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryGuildEssence", "", "", i3);
        GProGuildEssenceSvrReq G0 = aa.G0(chVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "queryGuildEssence kernelGuildService is null");
        } else {
            iKernelGuildService.queryGuildEssence(G0, new IGProGuildEssenceCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.61
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack
                public void onGProGuildEssenceInfoCallBack(final int i16, final String str, final GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.61.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryGuildEssence", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dhVar.a(i16, str, new GGProGuildEssenceSvrRsp(gProGuildEssenceSvrRsp));
                        }
                    });
                }
            });
        }
    }

    public void g5(com.tencent.mobileqq.qqguildsdk.data.genc.el elVar, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setJoinGuildOption", "", "", i3);
        GProSetJoinGuildOptionReq P1 = aa.P1(elVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setJoinGuildOption kernelGuildService is null");
        } else {
            iKernelGuildService.setJoinGuildOption(P1, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.151
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.151.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setJoinGuildOption", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dvVar.a(i16, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void h1(long j3, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "closeChannelActivitySwitch", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "closeChannelActivitySwitch kernelGuildService is null");
        } else {
            iKernelGuildService.closeChannelActivitySwitch(j3, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.94
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.94.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "closeChannelActivitySwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void h2(String str, String str2, final ay ayVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchProfileAddFriendField", "", "guildId:" + str + " tinyId:" + str2 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchProfileAddFriendField kernelGuildService is null");
        } else {
            iKernelGuildService.fetchProfileAddFriendField(O0, O02, new IGProFetchProfileAddFriendFieldCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.126
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchProfileAddFriendFieldCallback
                public void onFetchProfileAddFriendField(final int i16, final String str3, final String str4, final boolean z16) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.126.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchProfileAddFriendField", "", i16, str3, "result:" + i16 + " errMsg:" + str3 + " openId:" + str4 + " isQQFriend:" + z16 + " ", q16);
                            ayVar.onFetchProfileAddFriendField(i16, str3, str4, z16);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public String h3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserAvatarPendantUrl kernelGuildService is null");
            return "";
        }
        return iKernelGuildService.getGuildUserAvatarPendantUrl(O0);
    }

    public void h4(ch chVar, final dh dhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryGuildVisitor", "", "", i3);
        GProGuildEssenceSvrReq G0 = aa.G0(chVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "queryGuildVisitor kernelGuildService is null");
        } else {
            iKernelGuildService.queryGuildVisitor(G0, new IGProGuildEssenceCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.64
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack
                public void onGProGuildEssenceInfoCallBack(final int i16, final String str, final GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.64.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryGuildVisitor", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dhVar.a(i16, str, new GGProGuildEssenceSvrRsp(gProGuildEssenceSvrRsp));
                        }
                    });
                }
            });
        }
    }

    public void h5(com.tencent.mobileqq.qqguildsdk.data.genc.de deVar, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setJumpToCategory", "", "", i3);
        GProJumpToCategoryInfo i16 = aa.i1(deVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setJumpToCategory kernelGuildService is null");
        } else {
            iKernelGuildService.setJumpToCategory(i16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.1
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i17, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setJumpToCategory", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            dvVar.a(i17, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void i1(ab abVar, final wh2.n nVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "convertGuildAndThirdIds", "", "", i3);
        GProConvertThirdIdReq B = aa.B(abVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "convertGuildAndThirdIds kernelGuildService is null");
        } else {
            iKernelGuildService.convertGuildAndThirdIds(B, new IGProConvertGuildAndThirdIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.97
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProConvertGuildAndThirdIdCallback
                public void onConvertGuildAndThirdId(final int i16, final String str, final GProConvertThirdIdRsp gProConvertThirdIdRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.97.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "convertGuildAndThirdIds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            nVar.a(i16, str, new GGProConvertThirdIdRsp(gProConvertThirdIdRsp));
                        }
                    });
                }
            });
        }
    }

    public void i2(long j3, int i3, az azVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRecommendEssenceInfo", "", "guildId:" + j3 + " sourceType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchRecommendEssenceInfo kernelGuildService is null");
        } else {
            iKernelGuildService.fetchRecommendEssenceInfo(j3, i3, new IGProFetchRecommendEssenceInfoCallback(q16, azVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.60

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267959a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRecommendEssenceInfoCallback
                public void onFetchRecommendEssenceInfoCallback(final int i17, final String str, final GProRecommendEssenceSvrRsp gProRecommendEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.60.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRecommendEssenceInfo", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", AnonymousClass60.this.f267959a);
                            new GGProRecommendEssenceSvrRsp(gProRecommendEssenceSvrRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public String i3(String str, String str2, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserAvatarUrl kernelGuildService is null");
            return "";
        }
        return iKernelGuildService.getGuildUserAvatarUrl(O0, O02, i3);
    }

    public void i4(String str, boolean z16, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshAppChannelPreInfos", "", "guildId:" + str + " isForce:" + z16 + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "refreshAppChannelPreInfos kernelGuildService is null");
        } else {
            iKernelGuildService.refreshAppChannelPreInfos(O0, z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.119
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.119.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "refreshAppChannelPreInfos", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            emVar.onResult(i16, str2);
                        }
                    });
                }
            });
        }
    }

    public void i5(long j3, long j16, int i3, final dn dnVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setListenTogetherPlayOpt", "", "guildId:" + j3 + " channelId:" + j16 + " modPlayOpt:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setListenTogetherPlayOpt kernelGuildService is null");
        } else {
            iKernelGuildService.setListenTogetherPlayOpt(j3, j16, i3, new IGProListenTogetherPlayListOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.81
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProListenTogetherPlayListOptCallback
                public void onPlayListOptCallback(final int i17, final String str, final GProListenTogetherRspHead gProListenTogetherRspHead) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.81.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setListenTogetherPlayOpt", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            dnVar.a(i17, str, new GGProListenTogetherRspHead(gProListenTogetherRspHead));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProInviteInfo j1(com.tencent.mobileqq.qqguildsdk.data.genc.x xVar) {
        GProCmd0xf5aGuildInfo x16 = aa.x(xVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "convertToGuildInviteInfo kernelGuildService is null");
            return null;
        }
        return new GGProInviteInfo(iKernelGuildService.convertToGuildInviteInfo(x16));
    }

    public void j2(long j3, wh2.ab abVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRemainAtSetInfo", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchRemainAtSetInfo kernelGuildService is null");
        } else {
            iKernelGuildService.fetchRemainAtSetInfo(j3, new IGProFetchAtSetInfoCallback(q16, abVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.114

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266882a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAtSetInfoCallback
                public void onFetchAtSetInfoCallback(final int i16, final String str, final GProAtSetInfo gProAtSetInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.114.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRemainAtSetInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass114.this.f266882a);
                            new GGProAtSetInfo(gProAtSetInfo);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public ArrayList<Long> j3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserChannelCategoryAdminList kernelGuildService is null");
            return null;
        }
        return iKernelGuildService.getGuildUserChannelCategoryAdminList(O0, O02);
    }

    public void j4(String str, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeGuild", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "removeGuild kernelGuildService is null");
        } else {
            iKernelGuildService.removeGuild(O0, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.9
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeGuild", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i16, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void j5(long j3, long j16, int i3, final dn dnVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setListenTogetherPlayVolumeByAdmin", "", "guildId:" + j3 + " channelId:" + j16 + " volume:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setListenTogetherPlayVolumeByAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.setListenTogetherPlayVolumeByAdmin(j3, j16, i3, new IGProListenTogetherPlayListOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.82
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProListenTogetherPlayListOptCallback
                public void onPlayListOptCallback(final int i17, final String str, final GProListenTogetherRspHead gProListenTogetherRspHead) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.82.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setListenTogetherPlayVolumeByAdmin", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            dnVar.a(i17, str, new GGProListenTogetherRspHead(gProListenTogetherRspHead));
                        }
                    });
                }
            });
        }
    }

    public void k1(com.tencent.mobileqq.qqguildsdk.data.genc.ac acVar, final wh2.o oVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createGuild", "", "", i3);
        GProCreateGuildReq C = aa.C(acVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "createGuild kernelGuildService is null");
        } else {
            iKernelGuildService.createGuild(C, new IGProCreateGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.184
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateGuildCallback
                public void onCreateGuild(final int i16, final String str, final GProCreateGuildRsp gProCreateGuildRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.184.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createGuild", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            oVar.a(i16, str, new GGProCreateGuildRsp(gProCreateGuildRsp));
                        }
                    });
                }
            });
        }
    }

    public void k2(int i3, int i16, byte[] bArr, long j3, wh2.ba baVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRetentionGuildList", "", "businessType:" + i3 + " count:" + i16 + " quitGuildId:" + j3 + " ", i17);
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr2 = bArr;
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchRetentionGuildList kernelGuildService is null");
        } else {
            iKernelGuildService.fetchRetentionGuildList(i3, i16, bArr2, j3, new IGProFetchRetentionGuildListCallback(q16, baVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.87

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268161a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRetentionGuildListCallback
                public void onGProFetchRetentionGuildListCallback(final int i18, final String str, final GProRetentionGuildListRsp gProRetentionGuildListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.87.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRetentionGuildList", "", i18, str, "result:" + i18 + " errMsg:" + str + " ", AnonymousClass87.this.f268161a);
                            new GGProRetentionGuildListRsp(gProRetentionGuildListRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProClientIdentity k3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserClientIdentity kernelGuildService is null");
            return null;
        }
        return new GGProClientIdentity(iKernelGuildService.getGuildUserClientIdentity(O0, O02));
    }

    @Nullable
    public boolean k4(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "removeGuildGlobalBanner kernelGuildService is null");
            return false;
        }
        return iKernelGuildService.removeGuildGlobalBanner(O0);
    }

    public void k5(short s16, short s17, short s18, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMyBirthday", "", "birthYear:" + ((int) s16) + " birthMonth:" + ((int) s17) + " birthDay:" + ((int) s18) + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setMyBirthday kernelGuildService is null");
        } else {
            iKernelGuildService.setMyBirthday(s16, s17, s18, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.22
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setMyBirthday", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void l1(com.tencent.mobileqq.qqguildsdk.data.genc.ae aeVar, final wh2.q qVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createScheduleV2", "", "", i3);
        GProCreateScheduleReq E = aa.E(aeVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "createScheduleV2 kernelGuildService is null");
        } else {
            iKernelGuildService.createScheduleV2(E, new IGProCreateScheduleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.174
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback
                public void onCreateSchedule(final int i16, final String str, final GProScheduleInfo gProScheduleInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.174.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createScheduleV2", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            qVar.a(i16, str, new GGProScheduleInfo(gProScheduleInfo));
                        }
                    });
                }
            });
        }
    }

    public void l2(long j3, int i3, int i16, wh2.bb bbVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRoleListWithoutLevelRoleWithFilter", "", "guildId:" + j3 + " filter:" + i3 + " sourceType:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchRoleListWithoutLevelRoleWithFilter kernelGuildService is null");
        } else {
            iKernelGuildService.fetchRoleListWithoutLevelRoleWithFilter(j3, i3, i16, new IGProFetchRoleListWithoutLevelRoleCallback(q16, bbVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.115

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266888a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListWithoutLevelRoleCallback
                public void onFetchRoleListCallback(final int i18, final String str, final long j16, final ArrayList<GProGuildRole> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.115.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRoleListWithoutLevelRoleWithFilter", "", i18, str, "result:" + i18 + " errMsg:" + str + " limit:" + j16 + " roleInfoList.size():" + arrayList.size() + " ", AnonymousClass115.this.f266888a);
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GProGuildRoleInfo((GProGuildRole) it.next()));
                            }
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public String l3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserDisplayName kernelGuildService is null");
            return "";
        }
        return iKernelGuildService.getGuildUserDisplayName(O0, O02);
    }

    public void l4(dt dtVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeGuildTaskCard", "", "", i3);
        GProRemoveGuildTaskCardReq x16 = aa.x1(dtVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "removeGuildTaskCard kernelGuildService is null");
        } else {
            iKernelGuildService.removeGuildTaskCard(x16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.187
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.187.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeGuildTaskCard", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void l5(String str, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMyPersonalSignature", "", "personalSignature:" + str + " ", i3);
        if (str == null) {
            str = "";
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setMyPersonalSignature kernelGuildService is null");
        } else {
            iKernelGuildService.setMyPersonalSignature(str, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.23
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setMyPersonalSignature", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            emVar.onResult(i16, str2);
                        }
                    });
                }
            });
        }
    }

    public void m1(com.tencent.mobileqq.qqguildsdk.data.genc.o oVar, boolean z16, final wh2.c cVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "dealHandUpRequestForAdmin", "", "isAgree:" + z16 + " ", i3);
        GProAdminAVReqInfo o16 = aa.o(oVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "dealHandUpRequestForAdmin kernelGuildService is null");
        } else {
            iKernelGuildService.dealHandUpRequestForAdmin(o16, z16, new IGProAdminDealResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.35
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAdminDealResultCallback
                public void onAdminDealResult(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.35.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "dealHandUpRequestForAdmin", "", i16, str, "result:" + i16 + " errMsg:" + str + " rspInfo:" + str2 + " ", q16);
                            cVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2);
                        }
                    });
                }
            });
        }
    }

    public void m2(ArrayList<Long> arrayList, boolean z16, wh2.m mVar) {
        String str = "guildIds.size():" + arrayList.size() + " isForce:" + z16 + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchShareButtonReq", "", str, i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchShareButtonReq kernelGuildService is null");
        } else {
            iKernelGuildService.fetchShareButtonReq(arrayList, z16, new IGProCommonCallback(q16, mVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.140

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267083a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCommonCallback
                public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult, final GProCommonInfo gProCommonInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.140.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchShareButtonReq", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", AnonymousClass140.this.f267083a);
                            new GProSecurityInfo(gProSecurityResult);
                            new GGProCommonInfo(gProCommonInfo);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public int m3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserLevelRoleId kernelGuildService is null");
            return 0;
        }
        return iKernelGuildService.getGuildUserLevelRoleId(O0, O02);
    }

    public void m4(du duVar, final wh2.dr drVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeRiskMembers", "", "", i3);
        GProRemoveRiskMembersReq y16 = aa.y1(duVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "removeRiskMembers kernelGuildService is null");
        } else {
            iKernelGuildService.removeRiskMembers(y16, new IGProRemoveRiskMembersCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.144
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProRemoveRiskMembersCallback
                public void onRemoveRiskMembers(final int i16, final String str, final GProRemoveRiskMembersRsp gProRemoveRiskMembersRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.144.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeRiskMembers", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            drVar.a(i16, str, new GGProRemoveRiskMembersRsp(gProRemoveRiskMembersRsp));
                        }
                    });
                }
            });
        }
    }

    public void m5(String str, int i3, int i16, final em emVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMyProfileShowTypeSwitch", "", "guildId:" + str + " showSwitch:" + i3 + " showType:" + i16 + " ", i17);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setMyProfileShowTypeSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setMyProfileShowTypeSwitch(O0, i3, i16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.24
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i18, final String str2) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setMyProfileShowTypeSwitch", "", i18, str2, "result:" + i18 + " errMsg:" + str2 + " ", q16);
                            emVar.onResult(i18, str2);
                        }
                    });
                }
            });
        }
    }

    public void n1(String str, final wh2.r rVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "decodeInviteJumpInfo", "", "jumpInfo:" + str + " ", i3);
        if (str == null) {
            str = "";
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "decodeInviteJumpInfo kernelGuildService is null");
        } else {
            iKernelGuildService.decodeInviteJumpInfo(str, new IGProDecodeInviteJumpInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.67
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDecodeInviteJumpInfoCallback
                public void onDecodeInviteJumpInfo(final int i16, final String str2, final GProInviteInfo gProInviteInfo, final GProBusinessData gProBusinessData) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.67.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "decodeInviteJumpInfo", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            rVar.a(i16, str2, new GGProInviteInfo(gProInviteInfo), new GGProBusinessData(gProBusinessData));
                        }
                    });
                }
            });
        }
    }

    public void n2(long j3, long j16, com.tencent.mobileqq.qqguildsdk.data.genc.av avVar, final wh2.bc bcVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchShareInfo0x10c3", "", "guildId:" + j3 + " chnId:" + j16 + " ", i3);
        GProFetchShareInfo0x10c3Req V = aa.V(avVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchShareInfo0x10c3 kernelGuildService is null");
        } else {
            iKernelGuildService.fetchShareInfo0x10c3(j3, j16, V, new IGProFetchShareInfo0x10c3Callback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.66
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchShareInfo0x10c3Callback
                public void onFetchShareInfo(final int i16, final String str, final GProSecurityResult gProSecurityResult, final String str2, final String str3, final long j17, final GProQRCodeShareInfo gProQRCodeShareInfo, final GProShareExtendInfo gProShareExtendInfo, final String str4) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.66.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchShareInfo0x10c3", "", i16, str, "result:" + i16 + " errMsg:" + str + " shareUrl:" + str2 + " shareInfo:" + str3 + " shareExpiredTime:" + j17 + " attaContendId:" + str4 + " ", q16);
                            bcVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), str2, str3, j17, new GGProQRCodeShareInfo(gProQRCodeShareInfo), new GGProShareExtendInfo(gProShareExtendInfo), str4);
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProMedal n3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserMedal kernelGuildService is null");
            return null;
        }
        return new GGProMedal(iKernelGuildService.getGuildUserMedal(O0));
    }

    public void n4(fc fcVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeSpeakOrderByUser", "", "", i3);
        GProUserAVReqInfo g26 = aa.g2(fcVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "removeSpeakOrderByUser kernelGuildService is null");
        } else {
            iKernelGuildService.removeSpeakOrderByUser(g26, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.78
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.78.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeSpeakOrderByUser", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void n5(String str, String str2, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setMyVoiceNetworkQuality kernelGuildService is null");
        } else {
            iKernelGuildService.setMyVoiceNetworkQuality(O0, O02, i3);
        }
    }

    @Nullable
    public IGProGetContentRecommendRsp o1(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "decodeMVPFeedsRspPb kernelGuildService is null");
            return null;
        }
        return new GGProGetContentRecommendRsp(iKernelGuildService.decodeMVPFeedsRspPb(bArr));
    }

    public void o2(long j3, long j16, long j17, String str, com.tencent.mobileqq.qqguildsdk.data.genc.aw awVar, ArrayList<ey> arrayList, final wh2.bd bdVar) {
        String str2 = str;
        String str3 = "guildId:" + j3 + " channelId:" + j16 + " msgSeq:" + j17 + " feedId:" + str2 + " urlParams.size():" + arrayList.size() + " ";
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchShareUrlReq", "", str3, i3);
        if (str2 == null) {
            str2 = "";
        }
        String str4 = str2;
        GProFetchShareUrlFilter W = aa.W(awVar);
        ArrayList<GProURLParam> arrayList2 = new ArrayList<>();
        Iterator<ey> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(aa.c2(it.next()));
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchShareUrlReq kernelGuildService is null");
        } else {
            iKernelGuildService.fetchShareUrlReq(j3, j16, j17, str4, W, arrayList2, new IGProFetchShareUrlCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.141
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchShareUrlCallback
                public void onResult(final int i16, final String str5, final GProFetchShareUrlRsp gProFetchShareUrlRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.141.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchShareUrlReq", "", i16, str5, "result:" + i16 + " errMsg:" + str5 + " ", q16);
                            bdVar.a(i16, str5, new GGProFetchShareUrlRsp(gProFetchShareUrlRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public String o3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserMemberName kernelGuildService is null");
            return "";
        }
        return iKernelGuildService.getGuildUserMemberName(O0, O02);
    }

    public void o4(com.tencent.mobileqq.qqguildsdk.data.genc.i iVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportAISearchRecommendWords", "", "", i3);
        GProAISearchWordsReportReq i16 = aa.i(iVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportAISearchRecommendWords kernelGuildService is null");
        } else {
            iKernelGuildService.reportAISearchRecommendWords(i16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.214
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i17, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.214.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportAISearchRecommendWords", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i17, str);
                        }
                    });
                }
            });
        }
    }

    public void o5(String str, String str2, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setMyVoiceSysMicStatus kernelGuildService is null");
        } else {
            iKernelGuildService.setMyVoiceSysMicStatus(O0, O02, i3);
        }
    }

    @Nullable
    public IGProScheduleInfo p1(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "decodeScheduleInfo kernelGuildService is null");
            return null;
        }
        return new GGProScheduleInfo(iKernelGuildService.decodeScheduleInfo(bArr));
    }

    public void p2(long j3, ArrayList<Integer> arrayList, int i3, final wh2.be beVar) {
        String str = "guildId:" + j3 + " channelTypeList.size():" + arrayList.size() + " sourceType:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchSpecifiedTypeChannelsOpenState", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchSpecifiedTypeChannelsOpenState kernelGuildService is null");
        } else {
            iKernelGuildService.fetchSpecifiedTypeChannelsOpenState(j3, arrayList, i3, new IGProFetchSpecifiedTypeChannelsOpenStateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.57
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchSpecifiedTypeChannelsOpenStateCallback
                public void onRequestFetchSpecifiedTypeChannelsOpenStateCallback(final int i17, final String str2, final GProChannelOpenStateResultInfo gProChannelOpenStateResultInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.57.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchSpecifiedTypeChannelsOpenState", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", q16);
                            beVar.a(i17, str2, new GGProChannelOpenStateResultInfo(gProChannelOpenStateResultInfo));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public String p3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserNickname kernelGuildService is null");
            return "";
        }
        return iKernelGuildService.getGuildUserNickname(O0);
    }

    public void p4(com.tencent.mobileqq.qqguildsdk.data.genc.n nVar, final er erVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportAVState", "", "", i3);
        GProAVReportReqInfo n3 = aa.n(nVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportAVState kernelGuildService is null");
        } else {
            iKernelGuildService.reportAVState(n3, new IGProUserAVOptCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.33
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserAVOptCallback
                public void onUserAVOptResult(final int i16, final String str, final GProUserAVRspInfo gProUserAVRspInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.33.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportAVState", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            erVar.a(i16, str, new GGProUserAVRspInfo(gProUserAVRspInfo));
                        }
                    });
                }
            });
        }
    }

    public void p5(int i3, boolean z16, final em emVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setProfileSwitch", "", "type:" + i3 + " enable:" + z16 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setProfileSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setProfileSwitch(i3, z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.195
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i17, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.195.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setProfileSwitch", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i17, str);
                        }
                    });
                }
            });
        }
    }

    public void q1(com.tencent.mobileqq.qqguildsdk.data.genc.b bVar, final wh2.s sVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteAISearchSession", "", "", i3);
        GProAISearchDeleteSessionReq b16 = aa.b(bVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "deleteAISearchSession kernelGuildService is null");
        } else {
            iKernelGuildService.deleteAISearchSession(b16, new IGProDeleteAISearchSessionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.208
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteAISearchSessionCallback
                public void onResult(final int i16, final String str, final GProAISearchDeleteSessionRsp gProAISearchDeleteSessionRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.208.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteAISearchSession", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            sVar.a(i16, str, new GGProAISearchDeleteSessionRsp(gProAISearchDeleteSessionRsp));
                        }
                    });
                }
            });
        }
    }

    public void q2(wh2.bf bfVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchSubscribeUserGuide", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchSubscribeUserGuide kernelGuildService is null");
        } else {
            iKernelGuildService.fetchSubscribeUserGuide(new IGProFetchSubscribeUserGuideCallback(q16, bfVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.137

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267056a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchSubscribeUserGuideCallback
                public void onFetchSubscribeUserGuideCallback(final int i16, final String str, final ArrayList<GProSubscribeUserGuide> arrayList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.137.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchSubscribeUserGuide", "", i16, str, "result:" + i16 + " errMsg:" + str + " subscribeUserGuides.size():" + arrayList.size() + " ", AnonymousClass137.this.f267056a);
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new GGProSubscribeUserGuide((GProSubscribeUserGuide) it.next()));
                            }
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public long q3(String str, String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildUserTopRoleId kernelGuildService is null");
            return 0L;
        }
        return iKernelGuildService.getGuildUserTopRoleId(O0, O02);
    }

    public void q4(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportCurrentGuild kernelGuildService is null");
        } else {
            iKernelGuildService.reportCurrentGuild(j3);
        }
    }

    public void q5(long j3, int i3, int i16, final wh2.ej ejVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setQQMsgListGuild", "", "guildId:" + j3 + " op:" + i3 + " scene:" + i16 + " ", i17);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setQQMsgListGuild kernelGuildService is null");
        } else {
            iKernelGuildService.setQQMsgListGuild(j3, i3, i16, new IGProSetQQMsgListGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.108
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetQQMsgListGuildCallback
                public void onSetQQMsgListGuildCallback(final int i18, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.108.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setQQMsgListGuild", "", i18, str, "result:" + i18 + " errMsg:" + str + " ", q16);
                            ejVar.onSetQQMsgListGuildCallback(i18, str);
                        }
                    });
                }
            });
        }
    }

    public void r1(com.tencent.mobileqq.qqguildsdk.data.genc.af afVar, wh2.t tVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteFeed", "", "", i3);
        GProDeleteFeedReq F = aa.F(afVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "deleteFeed kernelGuildService is null");
        } else {
            iKernelGuildService.deleteFeed(F, new IGProDeleteFeedCallback(q16, tVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.156

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267195a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedCallback
                public void onResult(final int i16, final String str, final GProDeleteFeedRsp gProDeleteFeedRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.156.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteFeed", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass156.this.f267195a);
                            new GGProDeleteFeedRsp(gProDeleteFeedRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void r2(com.tencent.mobileqq.qqguildsdk.data.genc.ax axVar, final wh2.bg bgVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchUserJoinedGuildListV2", "", "", i3);
        GProFetchUserJoinedGuildListReq X = aa.X(axVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchUserJoinedGuildListV2 kernelGuildService is null");
        } else {
            iKernelGuildService.fetchUserJoinedGuildListV2(X, new IGProFetchUserJoinedGuildListCallbackV2() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.127
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchUserJoinedGuildListCallbackV2
                public void onFetchUserJoinedGuildList(final int i16, final String str, final GProFetchUserJoinedGuildListRsp gProFetchUserJoinedGuildListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.127.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchUserJoinedGuildListV2", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bgVar.a(i16, str, new GGProFetchUserJoinedGuildListRsp(gProFetchUserJoinedGuildListRsp));
                        }
                    });
                }
            });
        }
    }

    public void r3(fg fgVar, final ez ezVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildVerifyShareInfo", "", "", i3);
        GProVerifyShareInfoReq k26 = aa.k2(fgVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildVerifyShareInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildVerifyShareInfo(k26, new IGuildVerifyShareInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.215
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildVerifyShareInfoCallback
                public void onResult(final int i16, final String str, final GProVerifyShareInfoRsp gProVerifyShareInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.215.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildVerifyShareInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ezVar.a(i16, str, new GGProVerifyShareInfoRsp(gProVerifyShareInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void r4(String str, String str2, int i3, com.tencent.mobileqq.qqguildsdk.data.genc.aq aqVar, int i16, GProReportTarget gProReportTarget, final ds dsVar) {
        int i17 = f266767c;
        f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportFeedShareData", "", "guildId:" + str + " channelId:" + str2 + " shareType:" + i3 + " destPlat:" + i16 + " ", i17);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        GProFeedReportData Q = aa.Q(aqVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportFeedShareData kernelGuildService is null");
        } else {
            iKernelGuildService.reportFeedShareData(O0, O02, i3, Q, i16, gProReportTarget, new IGProReportFeedShareDataCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.2
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProReportFeedShareDataCallback
                public void onResult(final int i18, final String str3) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportFeedShareData", "", i18, str3, "result:" + i18 + " errMsg:" + str3 + " ", q16);
                            dsVar.onResult(i18, str3);
                        }
                    });
                }
            });
        }
    }

    public void r5(com.tencent.mobileqq.qqguildsdk.data.genc.em emVar, final wh2.ek ekVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setSearchSwitch", "", "", i3);
        GProSetSearchSwitchReq Q1 = aa.Q1(emVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setSearchSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setSearchSwitch(Q1, new IGProSetSearchSwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.169
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetSearchSwitchCallback
                public void onSetSearchSwitch(final int i16, final String str, final GProSetSearchSwitchRsp gProSetSearchSwitchRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.169.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setSearchSwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ekVar.a(i16, str, new GGProSetSearchSwitchRsp(gProSetSearchSwitchRsp));
                        }
                    });
                }
            });
        }
    }

    public void s1(ch chVar, final dh dhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteGuildEssence", "", "", i3);
        GProGuildEssenceSvrReq G0 = aa.G0(chVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "deleteGuildEssence kernelGuildService is null");
        } else {
            iKernelGuildService.deleteGuildEssence(G0, new IGProGuildEssenceCallBack() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.63
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildEssenceCallBack
                public void onGProGuildEssenceInfoCallBack(final int i16, final String str, final GProGuildEssenceSvrRsp gProGuildEssenceSvrRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.63.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteGuildEssence", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dhVar.a(i16, str, new GGProGuildEssenceSvrRsp(gProGuildEssenceSvrRsp));
                        }
                    });
                }
            });
        }
    }

    public void s2(wh2.bh bhVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchVersionNews", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchVersionNews kernelGuildService is null");
        } else {
            iKernelGuildService.fetchVersionNews(new IGProFetchVersionNewsCallback(q16, bhVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.15

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267150a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchVersionNewsCallback
                public void onFetchVersionNews(final int i16, final String str, final GProVersionNews gProVersionNews, final int i17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchVersionNews", "", i16, str, "result:" + i16 + " errMsg:" + str + " displayStatus:" + i17 + " ", AnonymousClass15.this.f267150a);
                            new GGProVersionNews(gProVersionNews);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void s3(final ck ckVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildsInContact", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildsInContact kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildsInContact(new IGProGetGuildsInContactCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.172
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildsInContactCallback
                public void onGetGuildsInContact(final ArrayList<GProGuild> arrayList, final ArrayList<GProGuild> arrayList2, final ArrayList<GProGuild> arrayList3) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.172.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildsInContact", "", "createdGuilds.size():" + arrayList.size() + " managedGuilds.size():" + arrayList2.size() + " joinedGuilds.size():" + arrayList3.size() + " ", q16);
                            ArrayList<IGProGuildInfo> arrayList4 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(new GProGuildInfo((GProGuild) it.next()));
                            }
                            ArrayList<IGProGuildInfo> arrayList5 = new ArrayList<>();
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                arrayList5.add(new GProGuildInfo((GProGuild) it5.next()));
                            }
                            ArrayList<IGProGuildInfo> arrayList6 = new ArrayList<>();
                            Iterator it6 = arrayList3.iterator();
                            while (it6.hasNext()) {
                                arrayList6.add(new GProGuildInfo((GProGuild) it6.next()));
                            }
                            ckVar.onGetGuildsInContact(arrayList4, arrayList5, arrayList6);
                        }
                    });
                }
            });
        }
    }

    public void s4(com.tencent.mobileqq.qqguildsdk.data.genc.ar arVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportFeedback", "", "", i3);
        GProFeedbackReq R = aa.R(arVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportFeedback kernelGuildService is null");
        } else {
            iKernelGuildService.reportFeedback(R, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.125
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.125.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportFeedback", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void s5(long j3, boolean z16, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setTopicSquareEntranceSwitch", "", "guildId:" + j3 + " isOn:" + z16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setTopicSquareEntranceSwitch kernelGuildService is null");
        } else {
            iKernelGuildService.setTopicSquareEntranceSwitch(j3, z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.73
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.73.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setTopicSquareEntranceSwitch", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dvVar.a(i16, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void t1(com.tencent.mobileqq.qqguildsdk.data.genc.cb cbVar, final dd ddVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteGuildGlobalBanner", "", "", i3);
        GProGlobalBannerRep A0 = aa.A0(cbVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "deleteGuildGlobalBanner kernelGuildService is null");
        } else {
            iKernelGuildService.deleteGuildGlobalBanner(A0, new IGProGlobalBannerCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.18
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGlobalBannerCallback
                public void onUpdateGlobalBanner(final int i16, final String str, final GProGlobalBanner gProGlobalBanner) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteGuildGlobalBanner", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            ddVar.a(i16, str, new GGProGlobalBanner(gProGlobalBanner));
                        }
                    });
                }
            });
        }
    }

    public void t2(long j3, wh2.ey eyVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchXWordInfo", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchXWordInfo kernelGuildService is null");
        } else {
            iKernelGuildService.fetchXWordInfo(j3, new IGproXWorldInfoCallback(q16, eyVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.43

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267824a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGproXWorldInfoCallback
                public void onFetchXWorldInfoCallback(final int i16, final String str, final GproXWorldInfo gproXWorldInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.43.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchXWordInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass43.this.f267824a);
                            new GGproXWorldInfo(gproXWorldInfo);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void t3(com.tencent.mobileqq.qqguildsdk.data.genc.bp bpVar, final wh2.cl clVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getHotLive", "", "", i3);
        GProGetHotLiveReq p06 = aa.p0(bpVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getHotLive kernelGuildService is null");
        } else {
            iKernelGuildService.getHotLive(p06, new IGProGetHotLiveCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.194
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetHotLiveCallback
                public void onGetHotLive(final int i16, final String str, final GProGetHotLiveRsp gProGetHotLiveRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.194.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getHotLive", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            clVar.a(i16, str, new GGProGetHotLiveRsp(gProGetHotLiveRsp));
                        }
                    });
                }
            });
        }
    }

    public void t4(wh2.dt dtVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportJoinRecommendGuild", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportJoinRecommendGuild kernelGuildService is null");
        } else {
            iKernelGuildService.reportJoinRecommendGuild(new IGProReportJoinRecommendGuild(q16, dtVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.123

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266950a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProReportJoinRecommendGuild
                public void onReportJoinRecommendGuildCallback(final int i16, final String str, final GProRecommendGuildInfo gProRecommendGuildInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.123.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportJoinRecommendGuild", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass123.this.f266950a);
                            new GGProRecommendGuildInfo(gProRecommendGuildInfo);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void t5(long j3, long j16, long j17, boolean z16, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserPermissionInGuild", "", "guildId:" + j3 + " channelId:" + j16 + " tinyId:" + j17 + " bShared:" + z16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setUserPermissionInGuild kernelGuildService is null");
        } else {
            iKernelGuildService.setUserPermissionInGuild(j3, j16, j17, z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.56
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.56.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserPermissionInGuild", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dvVar.a(i16, str, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void u1(et etVar, final wh2.v vVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteSystemNoticeMessage", "", "", i3);
        GProSystemNoticeMessageDeleteReq X1 = aa.X1(etVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "deleteSystemNoticeMessage kernelGuildService is null");
        } else {
            iKernelGuildService.deleteSystemNoticeMessage(X1, new IGProDeleteSystemNoticeMessageCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.27
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteSystemNoticeMessageCallback
                public void onDeleteSystemNoticeMessageResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteSystemNoticeMessage", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            vVar.onDeleteSystemNoticeMessageResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void u2(final wh2.bi biVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAISearchRecommendWords", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAISearchRecommendWords kernelGuildService is null");
        } else {
            iKernelGuildService.getAISearchRecommendWords(new IGProGetAISearchRecommendWordsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.213
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchRecommendWordsCallback
                public void onResult(final int i16, final String str, final GProAISearchGetRecommendWordsRsp gProAISearchGetRecommendWordsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.213.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAISearchRecommendWords", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            biVar.a(i16, str, new GGProAISearchGetRecommendWordsRsp(gProAISearchGetRecommendWordsRsp));
                        }
                    });
                }
            });
        }
    }

    public void u3(ArrayList<Integer> arrayList, int i3, cm cmVar) {
        String str = "contentTypes.size():" + arrayList.size() + " isAllForums:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getHotSearchWords", "", str, i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getHotSearchWords kernelGuildService is null");
        } else {
            iKernelGuildService.getHotSearchWords(arrayList, i3, new IGProGetHotSearchWordsCallback(q16, cmVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.70

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268037a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetHotSearchWordsCallback
                public void onGProGetHotSearchWordsCallback(final int i17, final String str2, final GProGetHotSearchWordRsp gProGetHotSearchWordRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.70.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getHotSearchWords", "", i17, str2, "result:" + i17 + " errMsg:" + str2 + " ", AnonymousClass70.this.f268037a);
                            new GGProGetHotSearchWordRsp(gProGetHotSearchWordRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void u4(com.tencent.mobileqq.qqguildsdk.data.genc.dq dqVar, final dp dpVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportPreventAddictionInstructions", "", "", i3);
        GProPAReportExecuteReq u16 = aa.u1(dqVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportPreventAddictionInstructions kernelGuildService is null");
        } else {
            iKernelGuildService.reportPreventAddictionInstructions(u16, new IGProPAReportExecuteCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.113
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProPAReportExecuteCallback
                public void onPAReportExecuteCallback(final int i16, final String str, final GProPAReportExecuteRsp gProPAReportExecuteRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.113.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportPreventAddictionInstructions", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dpVar.a(i16, str, new GGProPAReportExecuteRsp(gProPAReportExecuteRsp));
                        }
                    });
                }
            });
        }
    }

    public void u5(boolean z16, wh2.et etVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserTypeWithUserConfigure", "", "isIgnoreOldUser:" + z16 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "setUserTypeWithUserConfigure kernelGuildService is null");
        } else {
            iKernelGuildService.setUserTypeWithUserConfigure(z16, new IGProUserTypeSetCallback(q16, etVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.88

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268167a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserTypeSetCallback
                public void onUserTypeSetResult(final int i16, final String str, final boolean z17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.88.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserTypeWithUserConfigure", "", i16, str, "result:" + i16 + " errMsg:" + str + " isGuildNewUser:" + z17 + " ", AnonymousClass88.this.f268167a);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void v1(String str, final dv dvVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "destroyGuild", "", "guildId:" + str + " ", i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "destroyGuild kernelGuildService is null");
        } else {
            iKernelGuildService.destroyGuild(O0, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.10
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
                public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "destroyGuild", "", i16, str2, "result:" + i16 + " errMsg:" + str2 + " ", q16);
                            dvVar.a(i16, str2, new GProSecurityInfo(gProSecurityResult));
                        }
                    });
                }
            });
        }
    }

    public void v2(com.tencent.mobileqq.qqguildsdk.data.genc.c cVar, boolean z16, final wh2.bj bjVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAISearchSessionList", "", "needCache:" + z16 + " ", i3);
        GProAISearchGetSessionListReq c16 = aa.c(cVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAISearchSessionList kernelGuildService is null");
        } else {
            iKernelGuildService.getAISearchSessionList(c16, z16, new IGProGetAISearchSessionListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.207
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchSessionListCallback
                public void onResult(final int i16, final String str, final boolean z17, final GProAISearchGetSessionListRsp gProAISearchGetSessionListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.207.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAISearchSessionList", "", i16, str, "result:" + i16 + " errMsg:" + str + " isCache:" + z17 + " ", q16);
                            bjVar.a(i16, str, z17, new GGProAISearchGetSessionListRsp(gProAISearchGetSessionListRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProJumpToCategoryInfo v3(String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getJumpToCategory kernelGuildService is null");
            return null;
        }
        return new GGProJumpToCategoryInfo(iKernelGuildService.getJumpToCategory(O0));
    }

    public void v4(com.tencent.mobileqq.qqguildsdk.data.genc.dv dvVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportShareAtta", "", "", i3);
        GProReportShareAttaReq z16 = aa.z1(dvVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportShareAtta kernelGuildService is null");
        } else {
            iKernelGuildService.reportShareAtta(z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.205
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.205.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportShareAtta", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void v5() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "startPollingForDiscoverState kernelGuildService is null");
        } else {
            iKernelGuildService.startPollingForDiscoverState();
        }
    }

    public void w1(cg cgVar, final dg dgVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "doGuildCheckin", "", "", i3);
        GProGuildCheckinReq F0 = aa.F0(cgVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "doGuildCheckin kernelGuildService is null");
        } else {
            iKernelGuildService.doGuildCheckin(F0, new IGProGuildCheckinCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.181
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildCheckinCallback
                public void onGuildCheckin(final int i16, final String str, final GProGuildCheckinRsp gProGuildCheckinRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.181.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "doGuildCheckin", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dgVar.a(i16, str, new GGProGuildCheckinRsp(gProGuildCheckinRsp));
                        }
                    });
                }
            });
        }
    }

    public void w2(com.tencent.mobileqq.qqguildsdk.data.genc.d dVar, boolean z16, final wh2.bk bkVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAISearchSessionMsgList", "", "needCache:" + z16 + " ", i3);
        GProAISearchGetSessionMsgListReq d16 = aa.d(dVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAISearchSessionMsgList kernelGuildService is null");
        } else {
            iKernelGuildService.getAISearchSessionMsgList(d16, z16, new IGProGetAISearchSessionMsgListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.212
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchSessionMsgListCallback
                public void onResult(final int i16, final String str, final boolean z17, final GProAISearchGetSessionMsgListRsp gProAISearchGetSessionMsgListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.212.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAISearchSessionMsgList", "", i16, str, "result:" + i16 + " errMsg:" + str + " isCache:" + z17 + " ", q16);
                            bkVar.a(i16, str, z17, new GGProAISearchGetSessionMsgListRsp(gProAISearchGetSessionMsgListRsp));
                        }
                    });
                }
            });
        }
    }

    public void w3(fo foVar, co coVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getLabelGuilds", "", "", i3);
        GetLabelGuildsReq s26 = aa.s2(foVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getLabelGuilds kernelGuildService is null");
        } else {
            iKernelGuildService.getLabelGuilds(s26, new IGProGetLabelGuildsCallback(q16, coVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.92

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f268199a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLabelGuildsCallback
                public void onGetLabelGuilds(final int i16, final String str, final GetLabelGuildsRsp getLabelGuildsRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.92.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getLabelGuilds", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass92.this.f268199a);
                            new GGetLabelGuildsRsp(getLabelGuildsRsp);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void w4(ArrayList<String> arrayList, String str, String str2, int i3, final em emVar) {
        String str3;
        String str4;
        String str5 = "guildIdList.size():" + arrayList.size() + " mainSourceId:" + str + " subSourceId:" + str2 + " businessType:" + i3 + " ";
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportUserViewGuild", "", str5, i16);
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "reportUserViewGuild kernelGuildService is null");
        } else {
            iKernelGuildService.reportUserViewGuild(arrayList, str3, str4, i3, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.5
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i17, final String str6) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportUserViewGuild", "", i17, str6, "result:" + i17 + " errMsg:" + str6 + " ", q16);
                            emVar.onResult(i17, str6);
                        }
                    });
                }
            });
        }
    }

    public void w5(boolean z16) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "stopPollingForDiscoverState kernelGuildService is null");
        } else {
            iKernelGuildService.stopPollingForDiscoverState(z16);
        }
    }

    public void x1(int i3, final wh2.cv cvVar) {
        int i16 = f266767c;
        f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "doRealNameAuth", "", "sceneType:" + i3 + " ", i16);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "doRealNameAuth kernelGuildService is null");
        } else {
            iKernelGuildService.doRealNameAuth(i3, new IGProGetRealNameAuthCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.21
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRealNameAuthCallback
                public void onGetRealNameAuthResult(final int i17, final String str, final GProRealNameAuthInfo gProRealNameAuthInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "doRealNameAuth", "", i17, str, "result:" + i17 + " errMsg:" + str + " ", q16);
                            cvVar.a(i17, str, new GGProRealNameAuthInfo(gProRealNameAuthInfo));
                        }
                    });
                }
            });
        }
    }

    public void x2(com.tencent.mobileqq.qqguildsdk.data.genc.az azVar, final wh2.bl blVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAISearchShareURL", "", "", i3);
        GProGetAISearchShareURLReq Z = aa.Z(azVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAISearchShareURL kernelGuildService is null");
        } else {
            iKernelGuildService.getAISearchShareURL(Z, new IGProGetAISearchShareURLCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.210
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAISearchShareURLCallback
                public void onResult(final int i16, final String str, final GProGetAISearchShareURLRsp gProGetAISearchShareURLRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.210.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAISearchShareURL", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            blVar.a(i16, str, new GGProGetAISearchShareURLRsp(gProGetAISearchShareURLRsp));
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProGuildRoleInfo x3(long j3, long j16, long j17) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getMemberLevelRoleInfo kernelGuildService is null");
            return null;
        }
        return new GProGuildRoleInfo(iKernelGuildService.getMemberLevelRoleInfo(j3, j16, j17));
    }

    public void x4(wh2.du duVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "requestPubAccountMsgCount", "", "", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "requestPubAccountMsgCount kernelGuildService is null");
        } else {
            iKernelGuildService.requestPubAccountMsgCount(new IGProRequestPubAccountMsgCountCallback(q16, duVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.109

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f266840a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProRequestPubAccountMsgCountCallback
                public void onResult(final int i16, final String str, final int i17) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.109.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "requestPubAccountMsgCount", "", i16, str, "result:" + i16 + " errMsg:" + str + " msgCount:" + i17 + " ", AnonymousClass109.this.f266840a);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    public void x5(com.tencent.mobileqq.qqguildsdk.data.genc.eq eqVar) {
        GProSubscribePollingScheduleReq U1 = aa.U1(eqVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "subscribePollingSchedule kernelGuildService is null");
        } else {
            iKernelGuildService.subscribePollingSchedule(U1);
        }
    }

    public void y1(String str) {
        if (str == null) {
            str = "";
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "domainResolveByLocalDns kernelGuildService is null");
        } else {
            iKernelGuildService.domainResolveByLocalDns(str);
        }
    }

    public void y2(long j3, wh2.bm bmVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getActiveLiveAudioChannelNum", "", "guildId:" + j3 + " ", i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getActiveLiveAudioChannelNum kernelGuildService is null");
        } else {
            iKernelGuildService.getActiveLiveAudioChannelNum(j3, new IGProGetActiveLiveAudioChannelNumCallback(q16, bmVar) { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.168

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f267286a;

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetActiveLiveAudioChannelNumCallback
                public void onResult(final int i16) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.168.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper callback", "getActiveLiveAudioChannelNum", "", "activeChannelNum:" + i16 + " ", AnonymousClass168.this.f267286a);
                            getClass();
                            throw null;
                        }
                    });
                }
            });
        }
    }

    @Nullable
    public IGProGuildRoleInfo y3(long j3, long j16, long j17, long j18, int i3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getMemberTopRoleInfo kernelGuildService is null");
            return null;
        }
        return new GProGuildRoleInfo(iKernelGuildService.getMemberTopRoleInfo(j3, j16, j17, j18, i3));
    }

    public void y4(dw dwVar, final wh2.dw dwVar2) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "riskMemberList", "", "", i3);
        GProRiskMemberListReq A1 = aa.A1(dwVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "riskMemberList kernelGuildService is null");
        } else {
            iKernelGuildService.riskMemberList(A1, new IGProRiskMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.143
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProRiskMemberListCallback
                public void onRiskMemberList(final int i16, final String str, final GProRiskMemberListRsp gProRiskMemberListRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.143.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "riskMemberList", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dwVar2.a(i16, str, new GGProRiskMemberListRsp(gProRiskMemberListRsp));
                        }
                    });
                }
            });
        }
    }

    public void y5(com.tencent.mobileqq.qqguildsdk.data.genc.er erVar, final em emVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "superAdminBanUser", "", "", i3);
        GProSuperAdminBanUserReq V1 = aa.V1(erVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "superAdminBanUser kernelGuildService is null");
        } else {
            iKernelGuildService.superAdminBanUser(V1, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.158
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
                public void onResult(final int i16, final String str) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.158.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "superAdminBanUser", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            emVar.onResult(i16, str);
                        }
                    });
                }
            });
        }
    }

    public void z1(com.tencent.mobileqq.qqguildsdk.data.genc.ag agVar, final wh2.w wVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "editScheduleV2", "", "", i3);
        GProEditScheduleReq G = aa.G(agVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "editScheduleV2 kernelGuildService is null");
        } else {
            iKernelGuildService.editScheduleV2(G, new IGProEditScheduleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.175
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback
                public void onEditSchedule(final int i16, final String str, final GProScheduleInfo gProScheduleInfo) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.175.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "editScheduleV2", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            wVar.a(i16, str, new GGProScheduleInfo(gProScheduleInfo));
                        }
                    });
                }
            });
        }
    }

    public void z2(com.tencent.mobileqq.qqguildsdk.data.genc.co coVar, final wh2.bn bnVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAllGuildSearchAIInfo", "", "", i3);
        GProGuildSearchGetAllGuildAIInfoReq N0 = aa.N0(coVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getAllGuildSearchAIInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getAllGuildSearchAIInfo(N0, new IGProGetAllGuildSearchAIInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.211
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllGuildSearchAIInfoCallback
                public void onResult(final int i16, final String str, final GProGuildSearchAllGuildAIInfoRsp gProGuildSearchAllGuildAIInfoRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.211.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAllGuildSearchAIInfo", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            bnVar.a(i16, str, new GGProGuildSearchAllGuildAIInfoRsp(gProGuildSearchAllGuildAIInfoRsp));
                        }
                    });
                }
            });
        }
    }

    public void z3(com.tencent.mobileqq.qqguildsdk.data.genc.br brVar, final wh2.cp cpVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getMyTabContent", "", "", i3);
        GProGetMyTabContentReq r06 = aa.r0(brVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getMyTabContent kernelGuildService is null");
        } else {
            iKernelGuildService.getMyTabContent(r06, new IGProGetMyTabContentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.191
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMyTabContentCallback
                public void onGetMyTabContent(final int i16, final String str, final GProGetMyTabContentRsp gProGetMyTabContentRsp, final byte[] bArr, final boolean z16) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.191.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getMyTabContent", "", i16, str, "result:" + i16 + " errMsg:" + str + " hasJoinedGuild:" + z16 + " ", q16);
                            cpVar.a(i16, str, new GGProGetMyTabContentRsp(gProGetMyTabContentRsp), bArr, z16);
                        }
                    });
                }
            });
        }
    }

    public void z4(dx dxVar, final wh2.dx dxVar2) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "saveCustomApplication", "", "", i3);
        GProSaveCustomApplicationReq B1 = aa.B1(dxVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "saveCustomApplication kernelGuildService is null");
        } else {
            iKernelGuildService.saveCustomApplication(B1, new IGProSaveCustomApplicationCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.199
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSaveCustomApplicationCallback
                public void onSaveCustomApplication(final int i16, final String str, final GProCategoryChannelInfoList gProCategoryChannelInfoList) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.199.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "saveCustomApplication", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            dxVar2.a(i16, str, new GGProCategoryChannelInfoList(gProCategoryChannelInfoList));
                        }
                    });
                }
            });
        }
    }

    public void z5(com.tencent.mobileqq.qqguildsdk.data.genc.w wVar, final wh2.en enVar) {
        int i3 = f266767c;
        f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "superAdminUnListFeed", "", "", i3);
        GProCmd0x92331SuperAdminUnListFeedReq w3 = aa.w(wVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "superAdminUnListFeed kernelGuildService is null");
        } else {
            iKernelGuildService.superAdminUnListFeed(w3, new IGProSuperAdminUnListFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.157
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSuperAdminUnListFeedCallback
                public void onResult(final int i16, final String str, final GProCmd0x92331SuperAdminUnListFeedRsp gProCmd0x92331SuperAdminUnListFeedRsp) {
                    GProSdkGenWrapperImpl.this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl.157.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "superAdminUnListFeed", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                            enVar.a(i16, str, new GGProCmd0x92331SuperAdminUnListFeedRsp(gProCmd0x92331SuperAdminUnListFeedRsp));
                        }
                    });
                }
            });
        }
    }
}
