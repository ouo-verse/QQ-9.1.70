package fe1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.gamecenter.qa.data.GameQuestionFollow;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkRefChannel;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkRefInfo;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkRefQA;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkRefXWorld;
import com.tencent.mobileqq.gamecenter.qa.model.GameQuestionUserInfo;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyAnswer;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyQuestion;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.model.e;
import com.tencent.mobileqq.gamecenter.qa.model.f;
import com.tencent.mobileqq.gamecenter.qa.model.g;
import com.tencent.mobileqq.gamecenter.qa.model.j;
import com.tencent.mobileqq.gamecenter.qa.proto.GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameCenterMetaDreamUserCenter$IsFriendReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameCenterMetaDreamUserCenter$IsFriendRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$AnswerBase;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$BindedRobot;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$ChangeOnLineStatusReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$ChangeOnLineStatusRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$CheckMentionReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$CheckMentionRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$FeedsCard;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GameInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetBindedRobotReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetBindedRobotRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetChannelRecommendsV2Reply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetChannelRecommendsV2Request;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetMyRefMaterialsReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetMyRefMaterialsRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetNoAnsweredReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetNoAnsweredRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetOnLineStatusReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetOnLineStatusRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetRecmdRefMaterialsReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetRecmdRefMaterialsRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetRefMaterialByLinkReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetRefMaterialByLinkRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetStarListReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetStarListRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetTagsReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetTagsRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$HeartbeatReportReq;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$HeartbeatReportRsp;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$LikeAnswerReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$LikeAnswerRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$LikeQuestionReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewAnswerReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewAnswerRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewChannelAnswerReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewChannelAnswerRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewChannelQuestionReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewChannelQuestionRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewQuestionReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$NewQuestionRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$PicInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$Pics;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$PullGamesReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$PullGamesRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$QuestionBase;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RefChannelInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RefInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RefMaterialInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RefQAInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RefXWorldInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$Refs;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$RelatedQuestion;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$SearchQuestionsReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$SearchQuestionsRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$SetBindedRobotReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$SetBindedRobotRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$StarUserInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$TagInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$UserInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$UserInfo2;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$VideoInfo;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$Videos;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$CheckInWhiteListReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$CheckInWhiteListRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$GetJoinAnswerRequirementReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$GetJoinAnswerRequirementRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$JoinAnswerUserReply;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAAuth$JoinAnswerUserRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$InviteUserRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$InviteUserResponse;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$QueryUserListRequest;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$QueryUserListResponseV2;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$QueryUserRequestV2;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$QueryUserResponseV2;
import com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQAInvite$UserV2;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetOAIDReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetOAIDRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private d f398362a;

    /* renamed from: b, reason: collision with root package name */
    private WadlTrpcListener f398363b = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements WadlTrpcListener {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("/v1/369");
            hashSet.add("/v1/375");
            hashSet.add("/v1/367");
            hashSet.add("/v1/376");
            hashSet.add("/v1/578");
            hashSet.add("/v1/381");
            hashSet.add("/v1/387");
            hashSet.add("/v1/446");
            hashSet.add("/v1/444");
            hashSet.add("/v1/512");
            hashSet.add("/v1/511");
            hashSet.add("/v1/541");
            hashSet.add("/v1/538");
            hashSet.add("/v1/540");
            hashSet.add("/v1/542");
            hashSet.add("/v1/543");
            hashSet.add("/v1/572");
            hashSet.add("/v1/382");
            hashSet.add("/v1/608");
            hashSet.add("/v1/609");
            hashSet.add("/v1/610");
            hashSet.add("/v1/1015");
            hashSet.add("/v1/1016");
            hashSet.add("/v1/654");
            hashSet.add("/v1/747");
            hashSet.add("/v1/746");
            hashSet.add("/v1/778");
            hashSet.add("/v1/1353");
            hashSet.add("/v1/1331");
            hashSet.add("/v1/1329");
            hashSet.add("/v1/1502");
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (c.this.f398362a == null) {
                QLog.e("QQGameStrategyHandler", 1, "onTrpcRsp mGameStrategyListener == null");
                return;
            }
            if (j3 != 0 && trpcInovkeRsp != null && trpcInovkeRsp.f106731msg != null) {
                QLog.e("QQGameStrategyHandler", 1, "onTrpcRsp cmd:", str, ",ret:", Long.valueOf(j3), ",msg:", trpcInovkeRsp.f106731msg.get());
            }
            if ("/v1/369".equals(str)) {
                c.this.C0(j3, trpcInovkeRsp, intent);
                return;
            }
            if ("/v1/367".equals(str)) {
                c.this.H0(j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/375".equals(str)) {
                c.this.e0(j3, trpcInovkeRsp, intent);
                return;
            }
            if ("/v1/376".equals(str)) {
                c.this.F0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/578".equals(str)) {
                c.this.B0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/381".equals(str)) {
                c.this.n0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/387".equals(str)) {
                c.this.h0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/446".equals(str)) {
                c.this.g0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/444".equals(str)) {
                c.this.f0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/512".equals(str)) {
                c.this.j0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/511".equals(str)) {
                c.this.k0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/541".equals(str)) {
                c.this.A0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/538".equals(str)) {
                c.this.u0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/540".equals(str)) {
                c.this.m0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/542".equals(str)) {
                c.this.i0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/543".equals(str)) {
                c.this.p0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/572".equals(str)) {
                c.this.l0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/382".equals(str)) {
                c.this.y0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/608".equals(str)) {
                c.this.o0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/609".equals(str)) {
                c.this.G0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/610".equals(str)) {
                c.this.q0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/1015".equals(str)) {
                c.this.s0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/1016".equals(str)) {
                c.this.r0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/654".equals(str)) {
                c.this.w0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/747".equals(str)) {
                c.this.z0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/746".equals(str)) {
                c.this.E0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/778".equals(str)) {
                c.this.D0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/1353".equals(str)) {
                c.this.d0(intent, j3, trpcInovkeRsp);
                return;
            }
            if ("/v1/1331".equals(str)) {
                c.this.t0(intent, j3, trpcInovkeRsp);
            } else if ("/v1/1329".equals(str)) {
                c.this.x0(intent, j3, trpcInovkeRsp);
            } else if ("/v1/1502".equals(str)) {
                c.this.v0(intent, j3, trpcInovkeRsp);
            }
        }
    }

    public c() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f398363b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$GetStarListRsp gameStrategyQA$GetStarListRsp = new GameStrategyQA$GetStarListRsp();
                gameStrategyQA$GetStarListRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ArrayList arrayList = new ArrayList();
                for (GameStrategyQA$StarUserInfo gameStrategyQA$StarUserInfo : gameStrategyQA$GetStarListRsp.star_users.get()) {
                    com.tencent.mobileqq.gamecenter.qa.model.d dVar = new com.tencent.mobileqq.gamecenter.qa.model.d();
                    GameQuestionUserInfo gameQuestionUserInfo = new GameQuestionUserInfo();
                    gameQuestionUserInfo.avatar = gameStrategyQA$StarUserInfo.head.get();
                    gameQuestionUserInfo.name = gameStrategyQA$StarUserInfo.nick.get().toStringUtf8();
                    gameQuestionUserInfo.uin = gameStrategyQA$StarUserInfo.uin.get();
                    gameQuestionUserInfo.encodedUin = gameStrategyQA$StarUserInfo.uin_str.get();
                    gameQuestionUserInfo.isSelf = gameStrategyQA$StarUserInfo.is_self.get();
                    dVar.f212638c = gameQuestionUserInfo;
                    dVar.f212636a = gameStrategyQA$StarUserInfo.answer_num.get();
                    dVar.f212637b = gameStrategyQA$StarUserInfo.be_liked_num.get();
                    dVar.f212639d = gameStrategyQA$StarUserInfo.is_online.get();
                    arrayList.add(dVar);
                }
                e eVar = new e();
                eVar.f212640a = arrayList;
                eVar.f212641b = gameStrategyQA$GetStarListRsp.is_over.get();
                eVar.f212642c = gameStrategyQA$GetStarListRsp.total_num.get();
                eVar.f212643d = intent.getExtras().getInt("pageIndex");
                this.f398362a.onGetExpertList(j3, eVar);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameStrategyHandler", 2, "handleQuestionExpertRsp, result=", eVar);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleQuestionExpertRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleQuestionExpertRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetExpertList(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        int i3;
        int i16;
        String str;
        String str2;
        List<GameStrategyQA$VideoInfo> list;
        List<GameStrategyQA$PicInfo> list2;
        List<GameStrategyQA$VideoInfo> list3;
        List<GameStrategyQA$PicInfo> list4;
        String str3 = "QQGameStrategyHandler";
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            if (intent.getExtras() == null) {
                i16 = 2;
                i3 = 1;
            } else {
                try {
                    GameStrategyQA$GetChannelRecommendsV2Reply gameStrategyQA$GetChannelRecommendsV2Reply = new GameStrategyQA$GetChannelRecommendsV2Reply();
                    gameStrategyQA$GetChannelRecommendsV2Reply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    f fVar = new f();
                    fVar.f212645b = gameStrategyQA$GetChannelRecommendsV2Reply.next_page.get();
                    fVar.f212646c = gameStrategyQA$GetChannelRecommendsV2Reply.is_over.get();
                    fVar.f212647d = gameStrategyQA$GetChannelRecommendsV2Reply.total_num.get();
                    ArrayList arrayList = new ArrayList();
                    for (GameStrategyQA$FeedsCard gameStrategyQA$FeedsCard : gameStrategyQA$GetChannelRecommendsV2Reply.recommends.get()) {
                        if (gameStrategyQA$FeedsCard.question.has() && gameStrategyQA$FeedsCard.answer.has()) {
                            GameStrategyQA$QuestionBase gameStrategyQA$QuestionBase = gameStrategyQA$FeedsCard.question.get();
                            com.tencent.mobileqq.gamecenter.qa.model.c cVar = new com.tencent.mobileqq.gamecenter.qa.model.c();
                            cVar.f212617a = gameStrategyQA$QuestionBase.f212674id.get();
                            cVar.f212618b = gameStrategyQA$QuestionBase.status.get();
                            cVar.f212619c = gameStrategyQA$QuestionBase.appid.get();
                            cVar.f212620d = gameStrategyQA$QuestionBase.browse_count.get();
                            cVar.f212621e = gameStrategyQA$QuestionBase.answer_ids.get();
                            cVar.f212622f = gameStrategyQA$QuestionBase.title.get();
                            cVar.f212623g = gameStrategyQA$QuestionBase.content.get();
                            cVar.f212624h = new ArrayList();
                            GameStrategyQA$Pics gameStrategyQA$Pics = gameStrategyQA$QuestionBase.pics.get();
                            if (gameStrategyQA$Pics != null && (list4 = gameStrategyQA$Pics.pic_infos.get()) != null && list4.size() > 0) {
                                for (GameStrategyQA$PicInfo gameStrategyQA$PicInfo : list4) {
                                    GameStrategyPic gameStrategyPic = new GameStrategyPic();
                                    gameStrategyPic.mWidth = gameStrategyQA$PicInfo.width.get();
                                    gameStrategyPic.mHeight = gameStrategyQA$PicInfo.height.get();
                                    gameStrategyPic.mUrl = gameStrategyQA$PicInfo.url.get();
                                    cVar.f212624h.add(gameStrategyPic);
                                }
                            }
                            cVar.f212625i = gameStrategyQA$QuestionBase.is_star.get();
                            cVar.f212626j = gameStrategyQA$QuestionBase.create_time.get();
                            cVar.f212627k = gameStrategyQA$QuestionBase.like_count.get();
                            cVar.f212628l = gameStrategyQA$QuestionBase.answer_count.get();
                            cVar.f212629m = gameStrategyQA$QuestionBase.encode_author_uin.get();
                            cVar.f212630n = gameStrategyQA$QuestionBase.not_recommend.get();
                            cVar.f212631o = gameStrategyQA$QuestionBase.source.get();
                            cVar.f212632p = new ArrayList();
                            GameStrategyQA$Videos gameStrategyQA$Videos = gameStrategyQA$QuestionBase.videos.get();
                            if (gameStrategyQA$Videos != null && (list3 = gameStrategyQA$Videos.video_infos.get()) != null && list3.size() > 0) {
                                for (GameStrategyQA$VideoInfo gameStrategyQA$VideoInfo : list3) {
                                    GameStrategyVideo gameStrategyVideo = new GameStrategyVideo();
                                    GameStrategyQA$PicInfo gameStrategyQA$PicInfo2 = gameStrategyQA$VideoInfo.cover_pic.get();
                                    gameStrategyVideo.mCoverWidth = gameStrategyQA$PicInfo2.width.get();
                                    gameStrategyVideo.mCoverHeight = gameStrategyQA$PicInfo2.height.get();
                                    gameStrategyVideo.mCoverUrl = gameStrategyQA$PicInfo2.url.get();
                                    str = str3;
                                    try {
                                        gameStrategyVideo.mDuration = gameStrategyQA$VideoInfo.duration.get();
                                        gameStrategyVideo.mVideoUrl = gameStrategyQA$VideoInfo.video_url.get();
                                        cVar.f212632p.add(gameStrategyVideo);
                                        str3 = str;
                                    } catch (InvalidProtocolBufferMicroException e16) {
                                        e = e16;
                                        str3 = str;
                                        QLog.e(str3, 1, "handleQuestionList, exception=", e);
                                        return;
                                    }
                                }
                            }
                            str2 = str3;
                            cVar.f212633q = new GameQuestionUserInfo();
                            GameStrategyQA$UserInfo2 gameStrategyQA$UserInfo2 = gameStrategyQA$QuestionBase.author.get();
                            if (gameStrategyQA$UserInfo2 != null) {
                                cVar.f212633q.name = gameStrategyQA$UserInfo2.name.get().toStringUtf8();
                                cVar.f212633q.avatar = gameStrategyQA$UserInfo2.avatar.get();
                                cVar.f212633q.gender = gameStrategyQA$UserInfo2.gender.get();
                                cVar.f212633q.title = gameStrategyQA$UserInfo2.title.get();
                                cVar.f212633q.encodedUin = gameStrategyQA$UserInfo2.encode_uin.get();
                            }
                            cVar.f212634r = gameStrategyQA$QuestionBase.is_answered.get();
                            cVar.f212635s = gameStrategyQA$QuestionBase.is_liked_question.get();
                            GameStrategyQA$AnswerBase gameStrategyQA$AnswerBase = gameStrategyQA$FeedsCard.answer.get();
                            com.tencent.mobileqq.gamecenter.qa.model.a aVar = new com.tencent.mobileqq.gamecenter.qa.model.a();
                            aVar.f212598a = gameStrategyQA$AnswerBase.f212669id.get();
                            aVar.f212599b = gameStrategyQA$AnswerBase.status.get();
                            aVar.f212600c = gameStrategyQA$AnswerBase.appid.get();
                            aVar.f212601d = gameStrategyQA$AnswerBase.browse_count.get();
                            aVar.f212602e = gameStrategyQA$AnswerBase.question_id.get();
                            aVar.f212603f = GameQAUtil.k(gameStrategyQA$AnswerBase.content.get());
                            aVar.f212604g = new ArrayList();
                            GameStrategyQA$Pics gameStrategyQA$Pics2 = gameStrategyQA$AnswerBase.pics.get();
                            if (gameStrategyQA$Pics2 != null && (list2 = gameStrategyQA$Pics2.pic_infos.get()) != null && list2.size() > 0) {
                                for (GameStrategyQA$PicInfo gameStrategyQA$PicInfo3 : list2) {
                                    GameStrategyPic gameStrategyPic2 = new GameStrategyPic();
                                    gameStrategyPic2.mWidth = gameStrategyQA$PicInfo3.width.get();
                                    gameStrategyPic2.mHeight = gameStrategyQA$PicInfo3.height.get();
                                    gameStrategyPic2.mUrl = gameStrategyQA$PicInfo3.url.get();
                                    aVar.f212604g.add(gameStrategyPic2);
                                }
                            }
                            aVar.f212605h = gameStrategyQA$AnswerBase.create_time.get();
                            aVar.f212606i = gameStrategyQA$AnswerBase.like_count.get();
                            aVar.f212607j = gameStrategyQA$AnswerBase.is_star.get();
                            aVar.f212608k = gameStrategyQA$AnswerBase.comment_count.get();
                            aVar.f212609l = gameStrategyQA$AnswerBase.is_liked.get();
                            aVar.f212610m = gameStrategyQA$AnswerBase.encode_author_uin.get();
                            aVar.f212611n = gameStrategyQA$AnswerBase.questioner_like.get();
                            aVar.f212612o = gameStrategyQA$AnswerBase.source.get();
                            aVar.f212613p = new ArrayList();
                            GameStrategyQA$Videos gameStrategyQA$Videos2 = gameStrategyQA$AnswerBase.videos.get();
                            if (gameStrategyQA$Videos2 != null && (list = gameStrategyQA$Videos2.video_infos.get()) != null && list.size() > 0) {
                                for (GameStrategyQA$VideoInfo gameStrategyQA$VideoInfo2 : list) {
                                    GameStrategyVideo gameStrategyVideo2 = new GameStrategyVideo();
                                    GameStrategyQA$PicInfo gameStrategyQA$PicInfo4 = gameStrategyQA$VideoInfo2.cover_pic.get();
                                    gameStrategyVideo2.mCoverWidth = gameStrategyQA$PicInfo4.width.get();
                                    gameStrategyVideo2.mCoverHeight = gameStrategyQA$PicInfo4.height.get();
                                    gameStrategyVideo2.mCoverUrl = gameStrategyQA$PicInfo4.url.get();
                                    gameStrategyVideo2.mDuration = gameStrategyQA$VideoInfo2.duration.get();
                                    gameStrategyVideo2.mVideoUrl = gameStrategyQA$VideoInfo2.video_url.get();
                                    aVar.f212613p.add(gameStrategyVideo2);
                                }
                            }
                            aVar.f212614q = new GameQuestionUserInfo();
                            GameStrategyQA$UserInfo2 gameStrategyQA$UserInfo22 = gameStrategyQA$QuestionBase.author.get();
                            if (gameStrategyQA$UserInfo22 != null) {
                                aVar.f212614q.name = gameStrategyQA$UserInfo22.name.get().toStringUtf8();
                                aVar.f212614q.avatar = gameStrategyQA$UserInfo22.avatar.get();
                                aVar.f212614q.gender = gameStrategyQA$UserInfo22.gender.get();
                                aVar.f212614q.title = gameStrategyQA$UserInfo22.title.get();
                                aVar.f212614q.encodedUin = gameStrategyQA$UserInfo22.encode_uin.get();
                            }
                            com.tencent.mobileqq.gamecenter.qa.model.b bVar = new com.tencent.mobileqq.gamecenter.qa.model.b();
                            bVar.f212615a = cVar;
                            bVar.f212616b = aVar;
                            arrayList.add(bVar);
                        } else {
                            str2 = str3;
                        }
                        str3 = str2;
                    }
                    str = str3;
                    fVar.f212644a = arrayList;
                    if (QLog.isColorLevel()) {
                        str3 = str;
                        QLog.d(str3, 2, "handleQuestionList, result:", fVar);
                    } else {
                        str3 = str;
                    }
                    this.f398362a.onGetQuestionList(j3, fVar);
                    return;
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                }
            }
        } else {
            i3 = 1;
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        objArr[0] = "handleQuestionList, error null ret:";
        objArr[i3] = Long.valueOf(j3);
        QLog.e("QQGameStrategyHandler", i3, objArr);
        this.f398362a.onGetQuestionList(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp, Intent intent) {
        int intExtra = intent.getIntExtra("scene", 0);
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$NewQuestionReply gameStrategyQA$NewQuestionReply = new GameStrategyQA$NewQuestionReply();
                gameStrategyQA$NewQuestionReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onPublishQuestionFinish(j3, gameStrategyQA$NewQuestionReply.question_id.get(), intExtra);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onPublishQuestionFinish(j3, 0L, intExtra);
        QLog.e("QQGameStrategyHandler", 1, "handleQuestionReply return failed, ret:", Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        int i3 = intent.getExtras().getInt("refType");
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$GetRecmdRefMaterialsRsp gameStrategyQA$GetRecmdRefMaterialsRsp = new GameStrategyQA$GetRecmdRefMaterialsRsp();
                gameStrategyQA$GetRecmdRefMaterialsRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < gameStrategyQA$GetRecmdRefMaterialsRsp.list.size(); i16++) {
                    arrayList.add(H(gameStrategyQA$GetRecmdRefMaterialsRsp.list.get(i16)));
                }
                this.f398362a.onGetRecommendMaterials(j3, i3, arrayList);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onGetRecommendMaterials(j3, i3, null);
        QLog.e("QQGameStrategyHandler", 1, "handleRecommendRefMaterials return failed, ret:", Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        long longExtra = intent.getLongExtra("sequenceId", 0L);
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$GetRefMaterialByLinkRsp gameStrategyQA$GetRefMaterialByLinkRsp = new GameStrategyQA$GetRefMaterialByLinkRsp();
                gameStrategyQA$GetRefMaterialByLinkRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onGetRefMaterialByLink(j3, H(gameStrategyQA$GetRefMaterialByLinkRsp.info.get()), longExtra);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onGetRefMaterialByLink(j3, null, longExtra);
        QLog.e("QQGameStrategyHandler", 1, "handleRefMaterialByLink return failed, ret:", Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                String string = intent.getExtras().getString("keyWord");
                GameStrategyQA$SearchQuestionsReply gameStrategyQA$SearchQuestionsReply = new GameStrategyQA$SearchQuestionsReply();
                gameStrategyQA$SearchQuestionsReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ArrayList arrayList = new ArrayList();
                for (GameStrategyQA$RelatedQuestion gameStrategyQA$RelatedQuestion : gameStrategyQA$SearchQuestionsReply.questions.get()) {
                    j jVar = new j();
                    jVar.f212663a = gameStrategyQA$RelatedQuestion.question_info.appid.get();
                    jVar.f212664b = gameStrategyQA$RelatedQuestion.question_info.f212675id.get();
                    jVar.f212665c = gameStrategyQA$RelatedQuestion.question_info.title.get();
                    jVar.f212667e = gameStrategyQA$RelatedQuestion.answer_num.get();
                    jVar.f212666d = gameStrategyQA$RelatedQuestion.like.get();
                    jVar.f212668f = string;
                    arrayList.add(jVar);
                }
                this.f398362a.onSearchQuestionsFinish(j3, arrayList);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleSearchResult error null ret:", Long.valueOf(j3));
        this.f398362a.onSearchQuestionsFinish(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        int i3 = intent.getExtras().getInt("appId");
        if (trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQA$SetBindedRobotReply gameStrategyQA$SetBindedRobotReply = new GameStrategyQA$SetBindedRobotReply();
                gameStrategyQA$SetBindedRobotReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                int i16 = gameStrategyQA$SetBindedRobotReply.code.get();
                QLog.e("QQGameStrategyHandler", 1, "handleSetChannelBindInfoRsp, code=", Integer.valueOf(i16), ", msg=", gameStrategyQA$SetBindedRobotReply.err_msg.get());
                this.f398362a.onSetBindInfoRsp(i16, i3);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleSetChannelBindInfoRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleSetChannelBindInfoRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onSetBindInfoRsp(j3, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00de A[LOOP:0: B:13:0x00ce->B:15:0x00de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013f A[LOOP:1: B:22:0x012f->B:24:0x013f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01a7 A[LOOP:2: B:28:0x01a7->B:30:0x01af, LOOP_START, PHI: r4
  0x01a7: PHI (r4v3 int) = (r4v1 int), (r4v4 int) binds: [B:27:0x01a5, B:30:0x01af] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private GameQALinkCardData H(GameStrategyQA$RefMaterialInfo gameStrategyQA$RefMaterialInfo) {
        GameQALinkRefInfo gameQALinkRefInfo;
        GameQALinkRefInfo gameQALinkRefInfo2;
        int i3;
        int i16;
        GameStrategyQA$RefInfo gameStrategyQA$RefInfo = gameStrategyQA$RefMaterialInfo.ref.get();
        int i17 = gameStrategyQA$RefInfo.type.get();
        if (i17 != 2) {
            if (i17 != 3) {
                if (i17 != 4) {
                    gameQALinkRefInfo2 = null;
                    GameStrategyQA$UserInfo gameStrategyQA$UserInfo = gameStrategyQA$RefMaterialInfo.userinfo.get();
                    GameQuestionUserInfo gameQuestionUserInfo = new GameQuestionUserInfo();
                    gameQuestionUserInfo.uin = gameStrategyQA$UserInfo.uin.get();
                    gameQuestionUserInfo.name = gameStrategyQA$UserInfo.name.get().toStringUtf8();
                    gameQuestionUserInfo.avatar = gameStrategyQA$UserInfo.avatar.get();
                    gameQuestionUserInfo.gender = gameStrategyQA$UserInfo.gender.get();
                    gameQuestionUserInfo.title = gameStrategyQA$UserInfo.title.get();
                    gameQuestionUserInfo.encodedUin = gameStrategyQA$UserInfo.encode_uin.get();
                    ArrayList arrayList = new ArrayList();
                    if (gameStrategyQA$RefMaterialInfo.pics.get() != null && gameStrategyQA$RefMaterialInfo.pics.get().pic_infos.get() != null) {
                        for (i16 = 0; i16 < gameStrategyQA$RefMaterialInfo.pics.get().pic_infos.size(); i16++) {
                            GameStrategyQA$PicInfo gameStrategyQA$PicInfo = gameStrategyQA$RefMaterialInfo.pics.get().pic_infos.get(i16);
                            GameStrategyPic gameStrategyPic = new GameStrategyPic();
                            gameStrategyPic.mHeight = gameStrategyQA$PicInfo.height.get();
                            gameStrategyPic.mWidth = gameStrategyQA$PicInfo.width.get();
                            gameStrategyPic.mUrl = gameStrategyQA$PicInfo.url.get();
                            arrayList.add(gameStrategyPic);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (gameStrategyQA$RefMaterialInfo.videos.get() != null && gameStrategyQA$RefMaterialInfo.videos.get().video_infos.get() != null) {
                        for (i3 = 0; i3 < gameStrategyQA$RefMaterialInfo.videos.get().video_infos.size(); i3++) {
                            GameStrategyQA$VideoInfo gameStrategyQA$VideoInfo = gameStrategyQA$RefMaterialInfo.videos.get().video_infos.get(i3);
                            GameStrategyVideo gameStrategyVideo = new GameStrategyVideo();
                            gameStrategyVideo.mVideoUrl = gameStrategyQA$VideoInfo.video_url.get();
                            gameStrategyVideo.mDuration = gameStrategyQA$VideoInfo.duration.get();
                            gameStrategyVideo.mCoverUrl = gameStrategyQA$VideoInfo.cover_pic.get().url.get();
                            gameStrategyVideo.mCoverHeight = gameStrategyQA$VideoInfo.cover_pic.get().height.get();
                            gameStrategyVideo.mCoverWidth = gameStrategyQA$VideoInfo.cover_pic.get().width.get();
                            arrayList2.add(gameStrategyVideo);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    if (gameStrategyQA$RefMaterialInfo.tags.get() != null) {
                        for (int i18 = 0; i18 < gameStrategyQA$RefMaterialInfo.tags.size(); i18++) {
                            arrayList3.add(gameStrategyQA$RefMaterialInfo.tags.get(i18));
                        }
                    }
                    return new GameQALinkCardData(LinkType.values()[gameStrategyQA$RefInfo.type.get()], gameQALinkRefInfo2, gameQuestionUserInfo, gameStrategyQA$RefMaterialInfo.create_ts.get(), gameStrategyQA$RefMaterialInfo.title.get(), GameQAUtil.k(gameStrategyQA$RefMaterialInfo.content.get()), arrayList, arrayList2, gameStrategyQA$RefMaterialInfo.like_count.get(), arrayList3, gameStrategyQA$RefMaterialInfo.url.get(), gameStrategyQA$RefMaterialInfo.is_self.get());
                }
                gameQALinkRefInfo = new GameQALinkRefInfo(null, null, new GameQALinkRefXWorld(gameStrategyQA$RefInfo.xworld.f212677id.get()));
            } else {
                gameQALinkRefInfo = new GameQALinkRefInfo(null, new GameQALinkRefChannel(gameStrategyQA$RefInfo.channel.invite_code.get(), gameStrategyQA$RefInfo.channel.content_id.get()), null);
            }
        } else {
            gameQALinkRefInfo = new GameQALinkRefInfo(new GameQALinkRefQA(gameStrategyQA$RefInfo.f212676qa.appid.get(), gameStrategyQA$RefInfo.f212676qa.qusid.get(), gameStrategyQA$RefInfo.f212676qa.ansid.get()), null, null);
        }
        gameQALinkRefInfo2 = gameQALinkRefInfo;
        GameStrategyQA$UserInfo gameStrategyQA$UserInfo2 = gameStrategyQA$RefMaterialInfo.userinfo.get();
        GameQuestionUserInfo gameQuestionUserInfo2 = new GameQuestionUserInfo();
        gameQuestionUserInfo2.uin = gameStrategyQA$UserInfo2.uin.get();
        gameQuestionUserInfo2.name = gameStrategyQA$UserInfo2.name.get().toStringUtf8();
        gameQuestionUserInfo2.avatar = gameStrategyQA$UserInfo2.avatar.get();
        gameQuestionUserInfo2.gender = gameStrategyQA$UserInfo2.gender.get();
        gameQuestionUserInfo2.title = gameStrategyQA$UserInfo2.title.get();
        gameQuestionUserInfo2.encodedUin = gameStrategyQA$UserInfo2.encode_uin.get();
        ArrayList arrayList4 = new ArrayList();
        if (gameStrategyQA$RefMaterialInfo.pics.get() != null) {
            while (i16 < gameStrategyQA$RefMaterialInfo.pics.get().pic_infos.size()) {
            }
        }
        ArrayList arrayList22 = new ArrayList();
        if (gameStrategyQA$RefMaterialInfo.videos.get() != null) {
            while (i3 < gameStrategyQA$RefMaterialInfo.videos.get().video_infos.size()) {
            }
        }
        ArrayList arrayList32 = new ArrayList();
        if (gameStrategyQA$RefMaterialInfo.tags.get() != null) {
        }
        return new GameQALinkCardData(LinkType.values()[gameStrategyQA$RefInfo.type.get()], gameQALinkRefInfo2, gameQuestionUserInfo2, gameStrategyQA$RefMaterialInfo.create_ts.get(), gameStrategyQA$RefMaterialInfo.title.get(), GameQAUtil.k(gameStrategyQA$RefMaterialInfo.content.get()), arrayList4, arrayList22, gameStrategyQA$RefMaterialInfo.like_count.get(), arrayList32, gameStrategyQA$RefMaterialInfo.url.get(), gameStrategyQA$RefMaterialInfo.is_self.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$GetTagsReply gameStrategyQA$GetTagsReply = new GameStrategyQA$GetTagsReply();
                gameStrategyQA$GetTagsReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ArrayList arrayList = new ArrayList();
                for (GameStrategyQA$TagInfo gameStrategyQA$TagInfo : gameStrategyQA$GetTagsReply.tags.get()) {
                    GameStrategyTag gameStrategyTag = new GameStrategyTag();
                    gameStrategyTag.mTagId = gameStrategyQA$TagInfo.tag_id.get();
                    gameStrategyTag.mTagName = gameStrategyQA$TagInfo.tag_name.get();
                    arrayList.add(gameStrategyTag);
                }
                this.f398362a.onQueryTagsFinish(j3, arrayList);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onQueryTagsFinish(j3, null);
        QLog.e("QQGameStrategyHandler", 1, "handleTagReply return failed, ret:", Long.valueOf(j3));
    }

    private static int K() {
        return Math.abs(new Random().nextInt());
    }

    private void O0(GameStrategyAnswer gameStrategyAnswer, int i3, long j3) {
        if (gameStrategyAnswer == null) {
            return;
        }
        GameStrategyQA$NewAnswerRequest gameStrategyQA$NewAnswerRequest = new GameStrategyQA$NewAnswerRequest();
        gameStrategyQA$NewAnswerRequest.appid.set(gameStrategyAnswer.mAppId);
        gameStrategyQA$NewAnswerRequest.question_id.set(gameStrategyAnswer.mQuestionId);
        gameStrategyQA$NewAnswerRequest.content.set(gameStrategyAnswer.mContent);
        gameStrategyQA$NewAnswerRequest.scene.set(i3);
        gameStrategyQA$NewAnswerRequest.f212672id.set(j3);
        gameStrategyQA$NewAnswerRequest.pics.set(X(gameStrategyAnswer.getPics()));
        gameStrategyQA$NewAnswerRequest.videos.set(c0(gameStrategyAnswer.getVideos()));
        gameStrategyQA$NewAnswerRequest.refs.set(b0(gameStrategyAnswer.getLinkCards()));
        if (!TextUtils.isEmpty(gameStrategyAnswer.mRichContent)) {
            gameStrategyQA$NewAnswerRequest.rich_content.set(gameStrategyAnswer.mRichContent);
        }
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/375", false, gameStrategyQA$NewAnswerRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    @NonNull
    private GameStrategyQA$Pics X(List<GameStrategyPic> list) {
        GameStrategyQA$Pics gameStrategyQA$Pics = new GameStrategyQA$Pics();
        ArrayList arrayList = new ArrayList();
        for (GameStrategyPic gameStrategyPic : list) {
            GameStrategyQA$PicInfo gameStrategyQA$PicInfo = new GameStrategyQA$PicInfo();
            gameStrategyQA$PicInfo.url.set(gameStrategyPic.mUrl);
            gameStrategyQA$PicInfo.width.set(gameStrategyPic.mWidth);
            gameStrategyQA$PicInfo.height.set(gameStrategyPic.mHeight);
            arrayList.add(gameStrategyQA$PicInfo);
        }
        gameStrategyQA$Pics.pic_infos.set(arrayList);
        return gameStrategyQA$Pics;
    }

    private GameStrategyQA$Refs b0(List<GameQALinkCardData> list) {
        boolean z16;
        GameStrategyQA$Refs gameStrategyQA$Refs = new GameStrategyQA$Refs();
        ArrayList arrayList = new ArrayList();
        for (GameQALinkCardData gameQALinkCardData : list) {
            GameStrategyQA$RefInfo gameStrategyQA$RefInfo = new GameStrategyQA$RefInfo();
            gameStrategyQA$RefInfo.type.set(gameQALinkCardData.getLinkType().getType());
            if ((gameQALinkCardData.getPics() != null && gameQALinkCardData.getPics().size() > 0) || (gameQALinkCardData.getVideos() != null && gameQALinkCardData.getVideos().size() > 0)) {
                z16 = true;
            } else {
                z16 = false;
            }
            gameStrategyQA$RefInfo.has_media.set(z16);
            GameQALinkRefInfo linkRefInfo = gameQALinkCardData.getLinkRefInfo();
            if (linkRefInfo != null) {
                GameQALinkRefChannel channelInfo = linkRefInfo.getChannelInfo();
                GameQALinkRefXWorld xWorldInfo = linkRefInfo.getXWorldInfo();
                GameQALinkRefQA qaInfo = linkRefInfo.getQaInfo();
                if (channelInfo != null) {
                    GameStrategyQA$RefChannelInfo gameStrategyQA$RefChannelInfo = new GameStrategyQA$RefChannelInfo();
                    gameStrategyQA$RefChannelInfo.content_id.set(channelInfo.getContentId());
                    gameStrategyQA$RefChannelInfo.invite_code.set(channelInfo.getInviteCode());
                    gameStrategyQA$RefInfo.channel.set(gameStrategyQA$RefChannelInfo);
                }
                if (xWorldInfo != null) {
                    GameStrategyQA$RefXWorldInfo gameStrategyQA$RefXWorldInfo = new GameStrategyQA$RefXWorldInfo();
                    gameStrategyQA$RefXWorldInfo.f212677id.set(xWorldInfo.getContentId());
                    gameStrategyQA$RefInfo.xworld.set(gameStrategyQA$RefXWorldInfo);
                }
                if (qaInfo != null) {
                    GameStrategyQA$RefQAInfo gameStrategyQA$RefQAInfo = new GameStrategyQA$RefQAInfo();
                    gameStrategyQA$RefQAInfo.ansid.set(qaInfo.getAnsid());
                    gameStrategyQA$RefQAInfo.qusid.set(qaInfo.getQusid());
                    gameStrategyQA$RefQAInfo.appid.set(qaInfo.getAppid());
                    gameStrategyQA$RefInfo.f212676qa.set(gameStrategyQA$RefQAInfo);
                }
            }
            arrayList.add(gameStrategyQA$RefInfo);
        }
        gameStrategyQA$Refs.refs.set(arrayList);
        return gameStrategyQA$Refs;
    }

    @NonNull
    private GameStrategyQA$Videos c0(List<GameStrategyVideo> list) {
        ArrayList arrayList = new ArrayList();
        for (GameStrategyVideo gameStrategyVideo : list) {
            GameStrategyQA$VideoInfo gameStrategyQA$VideoInfo = new GameStrategyQA$VideoInfo();
            gameStrategyQA$VideoInfo.video_url.set(gameStrategyVideo.mVideoUrl);
            gameStrategyQA$VideoInfo.duration.set(gameStrategyVideo.mDuration);
            GameStrategyQA$PicInfo gameStrategyQA$PicInfo = new GameStrategyQA$PicInfo();
            gameStrategyQA$PicInfo.url.set(gameStrategyVideo.mCoverUrl);
            gameStrategyQA$PicInfo.width.set(gameStrategyVideo.mCoverWidth);
            gameStrategyQA$PicInfo.height.set(gameStrategyVideo.mCoverHeight);
            gameStrategyQA$VideoInfo.cover_pic.set(gameStrategyQA$PicInfo);
            arrayList.add(gameStrategyQA$VideoInfo);
        }
        GameStrategyQA$Videos gameStrategyQA$Videos = new GameStrategyQA$Videos();
        gameStrategyQA$Videos.video_infos.set(arrayList);
        return gameStrategyQA$Videos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        boolean z16 = false;
        QLog.d("QQGameStrategyHandler", 1, "handleAddMetaDreamGameFriendRsp retCode=", Long.valueOf(j3));
        if (intent != null && trpcInovkeRsp != null) {
            d dVar = this.f398362a;
            if (j3 == 0) {
                z16 = true;
            }
            dVar.onAddMetaDreamGameFriend(z16, j3);
            return;
        }
        QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend req or rsp null");
        this.f398362a.onAddMetaDreamGameFriend(false, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp, Intent intent) {
        int intExtra = intent.getIntExtra("scene", 0);
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$NewAnswerReply gameStrategyQA$NewAnswerReply = new GameStrategyQA$NewAnswerReply();
                gameStrategyQA$NewAnswerReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onAnswerQuestionFinish(j3, gameStrategyQA$NewAnswerReply.answer_id.get(), intExtra);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onAnswerQuestionFinish(j3, 0L, intExtra);
        QLog.e("QQGameStrategyHandler", 1, "handleAnswerReply return failed, ret:", Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                int i3 = intent.getExtras().getInt("appId");
                GameStrategyQAAuth$JoinAnswerUserReply gameStrategyQAAuth$JoinAnswerUserReply = new GameStrategyQAAuth$JoinAnswerUserReply();
                gameStrategyQAAuth$JoinAnswerUserReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onGetAuthJoin(j3, i3, gameStrategyQAAuth$JoinAnswerUserReply.can_join.get());
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleAuthJoin, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleAuthJoin, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetAuthJoin(j3, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && intent.getExtras() != null) {
            int i3 = intent.getExtras().getInt("appId");
            String string = intent.getExtras().getString("channelId");
            if (trpcInovkeRsp != null && j3 == 0) {
                try {
                    GameStrategyQAAuth$GetJoinAnswerRequirementReply gameStrategyQAAuth$GetJoinAnswerRequirementReply = new GameStrategyQAAuth$GetJoinAnswerRequirementReply();
                    gameStrategyQAAuth$GetJoinAnswerRequirementReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    GameStrategyAuthRequire gameStrategyAuthRequire = new GameStrategyAuthRequire();
                    gameStrategyAuthRequire.canJoinAnswer = gameStrategyQAAuth$GetJoinAnswerRequirementReply.can_join_answer.get();
                    gameStrategyAuthRequire.reqDoc = gameStrategyQAAuth$GetJoinAnswerRequirementReply.req_doc.get();
                    gameStrategyAuthRequire.joinTitle = gameStrategyQAAuth$GetJoinAnswerRequirementReply.join_title.get();
                    gameStrategyAuthRequire.successAuthDoc = gameStrategyQAAuth$GetJoinAnswerRequirementReply.success_auth_doc.get();
                    this.f398362a.onGetAuthRequire(j3, string, i3, gameStrategyAuthRequire);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QQGameStrategyHandler", 1, "handleAuthRequire, exception=", e16);
                    return;
                }
            }
            QLog.e("QQGameStrategyHandler", 1, "handleAuthRequire, error null ret:", Long.valueOf(j3));
            this.f398362a.onGetAuthRequire(j3, string, i3, null);
            return;
        }
        QLog.e("QQGameStrategyHandler", 1, "handleAuthRequire, error null request");
        this.f398362a.onGetAuthRequire(j3, null, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && intent.getExtras() != null) {
            int i3 = intent.getExtras().getInt("appId");
            String string = intent.getExtras().getString("channelId");
            if (trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
                try {
                    GameStrategyQAAuth$CheckInWhiteListReply gameStrategyQAAuth$CheckInWhiteListReply = new GameStrategyQAAuth$CheckInWhiteListReply();
                    gameStrategyQAAuth$CheckInWhiteListReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    this.f398362a.onGetAuthWhite(j3, string, i3, gameStrategyQAAuth$CheckInWhiteListReply.is_in_whitelist.get());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QQGameStrategyHandler", 1, "handleAuthWhite, exception=", e16);
                    return;
                }
            }
            QLog.e("QQGameStrategyHandler", 1, "handleAuthWhite, error null ret:", Long.valueOf(j3));
            this.f398362a.onGetAuthWhite(j3, string, i3, false);
            return;
        }
        QLog.e("QQGameStrategyHandler", 1, "handleAuthWhite, error null request");
        this.f398362a.onGetAuthWhite(j3, null, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                new MessageMicro<GameStrategyQA$ChangeOnLineStatusRsp>() { // from class: com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$ChangeOnLineStatusRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameStrategyQA$ChangeOnLineStatusRsp.class);
                }.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onChangeOnlineStatus(j3, intent.getExtras().getBoolean("isOnline"));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleChangeExpertOnlineStatusRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleChangeExpertOnlineStatusRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onChangeOnlineStatus(j3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$NewChannelAnswerReply gameStrategyQA$NewChannelAnswerReply = new GameStrategyQA$NewChannelAnswerReply();
                gameStrategyQA$NewChannelAnswerReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onChannelAnswerQuestionFinish(j3, gameStrategyQA$NewChannelAnswerReply.answer_id.get(), gameStrategyQA$NewChannelAnswerReply.ark_json.get(), intent.getIntExtra("randomId", 0));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleChannelNewAnswer, error null ret:", Long.valueOf(j3));
        this.f398362a.onChannelAnswerQuestionFinish(j3, 0L, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$NewChannelQuestionReply gameStrategyQA$NewChannelQuestionReply = new GameStrategyQA$NewChannelQuestionReply();
                gameStrategyQA$NewChannelQuestionReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onChannelPublishQuestionFinish(j3, gameStrategyQA$NewChannelQuestionReply.question_id.get(), gameStrategyQA$NewChannelQuestionReply.ark_json.get(), intent.getIntExtra("randomId", 0));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleChannelNewQuestion, error null ret:", Long.valueOf(j3));
        this.f398362a.onChannelPublishQuestionFinish(j3, 0L, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQA$CheckMentionRsp gameStrategyQA$CheckMentionRsp = new GameStrategyQA$CheckMentionRsp();
                gameStrategyQA$CheckMentionRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                boolean z16 = gameStrategyQA$CheckMentionRsp.can_mention.get();
                QLog.d("QQGameStrategyHandler", 1, "handleCheckAtRobotRsp, canMention=", Boolean.valueOf(z16));
                this.f398362a.onCheckAtRobot(j3, z16);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleCheckAtRobotRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleCheckAtRobotRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onCheckAtRobot(j3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$HeartbeatReportRsp gameStrategyQA$HeartbeatReportRsp = new GameStrategyQA$HeartbeatReportRsp();
                gameStrategyQA$HeartbeatReportRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                int i3 = gameStrategyQA$HeartbeatReportRsp.interval_seconds.get();
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameStrategyHandler", 2, "handleExpertOnlineHeartbeatRsp, interval=", Integer.valueOf(i3));
                }
                this.f398362a.onExpertOnlineHeartbeat(j3, i3);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleExpertOnlineHeartbeatRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleExpertOnlineHeartbeatRsp, error null ret:", Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$LikeQuestionReply gameStrategyQA$LikeQuestionReply = new GameStrategyQA$LikeQuestionReply();
                gameStrategyQA$LikeQuestionReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                GameQuestionFollow gameQuestionFollow = (GameQuestionFollow) intent.getExtras().getSerializable("followQuestion");
                gameQuestionFollow.f212415msg = gameStrategyQA$LikeQuestionReply.f212671msg.get();
                this.f398362a.onQuestionFollow(j3, gameQuestionFollow);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleFollowQuestionRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleFollowQuestionRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onQuestionFollow(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQA$GetBindedRobotReply gameStrategyQA$GetBindedRobotReply = new GameStrategyQA$GetBindedRobotReply();
                gameStrategyQA$GetBindedRobotReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                GameStrategyQA$BindedRobot gameStrategyQA$BindedRobot = gameStrategyQA$GetBindedRobotReply.robot.get();
                int i3 = gameStrategyQA$BindedRobot.appid.get();
                String str = gameStrategyQA$BindedRobot.robot_id.get();
                QLog.d("QQGameStrategyHandler", 1, "handleGetChannelBindInfoRsp, appid=", Integer.valueOf(i3), ", robotId=", str);
                this.f398362a.onGetBindInfoRsp(j3, i3, str);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetChannelBindInfoRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetChannelBindInfoRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetBindInfoRsp(j3, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$GetOnLineStatusRsp gameStrategyQA$GetOnLineStatusRsp = new GameStrategyQA$GetOnLineStatusRsp();
                gameStrategyQA$GetOnLineStatusRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                boolean z16 = gameStrategyQA$GetOnLineStatusRsp.is_online.get();
                QLog.d("QQGameStrategyHandler", 1, "handleGetExpertOnlineStatusRsp, isOnline=", Boolean.valueOf(z16));
                this.f398362a.onGetOnlineStatus(j3, z16);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetExpertOnlineStatusRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetExpertOnlineStatusRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetOnlineStatus(j3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQA$PullGamesReply gameStrategyQA$PullGamesReply = new GameStrategyQA$PullGamesReply();
                gameStrategyQA$PullGamesReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                boolean z16 = gameStrategyQA$PullGamesReply.is_over.get();
                long j16 = gameStrategyQA$PullGamesReply.next_page.get();
                ArrayList arrayList = new ArrayList();
                List<GameStrategyQA$GameInfo> list = gameStrategyQA$PullGamesReply.games.get();
                if (list != null && list.size() > 0) {
                    for (GameStrategyQA$GameInfo gameStrategyQA$GameInfo : list) {
                        GameListItem gameListItem = new GameListItem();
                        gameListItem.e(gameStrategyQA$GameInfo.appid.get());
                        gameListItem.f(gameStrategyQA$GameInfo.icon.get());
                        gameListItem.g(gameStrategyQA$GameInfo.name.get());
                        arrayList.add(gameListItem);
                    }
                }
                QLog.d("QQGameStrategyHandler", 1, "handleGetGameListRsp, size=", Integer.valueOf(arrayList.size()), ", nextPageIndex=", Long.valueOf(j16), ", isOver=", Boolean.valueOf(z16));
                this.f398362a.onGetGameList(j3, arrayList, j16, z16);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetGameListRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetGameListRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetGameList(j3, null, 0L, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQAInvite$QueryUserResponseV2 gameStrategyQAInvite$QueryUserResponseV2 = new GameStrategyQAInvite$QueryUserResponseV2();
                gameStrategyQAInvite$QueryUserResponseV2.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                List<GameStrategyQAInvite$UserV2> list = gameStrategyQAInvite$QueryUserResponseV2.users.get();
                ArrayList arrayList = new ArrayList();
                for (GameStrategyQAInvite$UserV2 gameStrategyQAInvite$UserV2 : list) {
                    InviteData inviteData = new InviteData();
                    inviteData.m(gameStrategyQAInvite$UserV2.nick.get());
                    inviteData.l(gameStrategyQAInvite$UserV2.avatar.get());
                    inviteData.j(gameStrategyQAInvite$UserV2.describe.get());
                    inviteData.n(gameStrategyQAInvite$UserV2.title.get());
                    inviteData.k(gameStrategyQAInvite$UserV2.encoded_uin.get());
                    arrayList.add(inviteData);
                }
                QLog.d("QQGameStrategyHandler", 1, "handleGetInviteListDetailRsp, size=", Integer.valueOf(list.size()));
                this.f398362a.onGetInviteListDetail(j3, arrayList);
                return;
            } catch (Exception e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetGameListRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetInviteListDetailRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetInviteListDetail(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQAInvite$QueryUserListResponseV2 gameStrategyQAInvite$QueryUserListResponseV2 = new GameStrategyQAInvite$QueryUserListResponseV2();
                gameStrategyQAInvite$QueryUserListResponseV2.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                List<String> list = gameStrategyQAInvite$QueryUserListResponseV2.recommends.get();
                QLog.d("QQGameStrategyHandler", 1, "handleGetInviteListRsp, size=", Integer.valueOf(list.size()));
                this.f398362a.onGetInviteList(j3, list);
                return;
            } catch (Exception e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetGameListRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetInviteListRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetInviteList(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.d("QQGameStrategyHandler", 1, "handleGetMetaDreamGameTeamingLink");
        if (intent == null) {
            QLog.d("QQGameStrategyHandler", 1, "handleGetMetaDreamGameTeamingLink request is null.");
            return;
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp = new GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp();
                gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f398362a.onGetMetaDreamGameTeamingLink(true, 0L, gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkRsp.link.get());
                return;
            } catch (Throwable th5) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetMetaDreamGameTeamingLink exception:", th5);
                return;
            }
        }
        QLog.d("QQGameStrategyHandler", 1, "handleGetMetaDreamGameTeamingLink rsp error, retCode=", Long.valueOf(j3));
        this.f398362a.onGetMetaDreamGameTeamingLink(false, j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0 && intent.getExtras() != null) {
            try {
                GameStrategyQA$GetNoAnsweredReply gameStrategyQA$GetNoAnsweredReply = new GameStrategyQA$GetNoAnsweredReply();
                gameStrategyQA$GetNoAnsweredReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                g gVar = new g();
                gVar.f212648a = gameStrategyQA$GetNoAnsweredReply.num.get();
                gVar.f212649b = gameStrategyQA$GetNoAnsweredReply.jump_url.get();
                this.f398362a.onGetNoAnswer(j3, gVar);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameStrategyHandler", 2, "handleGetNoAnswerNumRsp, result=", gVar);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetNoAnswerNumRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleGetNoAnswerNumRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onGetNoAnswer(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.d("QQGameStrategyHandler", 1, "handleGetOAIDResponse");
        if (intent == null) {
            QLog.d("QQGameStrategyHandler", 1, "handleGetOAIDResponse request is null.");
            return;
        }
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                GameCenterYunGameAuth$GetOAIDRsp gameCenterYunGameAuth$GetOAIDRsp = new GameCenterYunGameAuth$GetOAIDRsp();
                gameCenterYunGameAuth$GetOAIDRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                String str = gameCenterYunGameAuth$GetOAIDRsp.oaid.get();
                this.f398362a.onGetOAID(true, str);
                if (!TextUtils.isEmpty(str)) {
                    QLog.d("QQGameStrategyHandler", 1, "handleGetOAIDResponse save oaid");
                    QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).encodeString("key_gc_ad_oaid", str);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetOAIDResponse exception:", th5);
                return;
            }
        }
        QLog.d("QQGameStrategyHandler", 1, "handleGetOAIDResponse rsp error, retCode=", Long.valueOf(j3));
        this.f398362a.onGetOAID(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent != null && trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQAInvite$InviteUserResponse gameStrategyQAInvite$InviteUserResponse = new GameStrategyQAInvite$InviteUserResponse();
                gameStrategyQAInvite$InviteUserResponse.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                List<Long> list = gameStrategyQAInvite$InviteUserResponse.uins.get();
                QLog.d("QQGameStrategyHandler", 1, "handleInviteUserRsp, code:" + j3);
                this.f398362a.onInviteUser(j3, list);
                return;
            } catch (Exception e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleInviteUserRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleInviteUserRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onInviteUser(j3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend retCode=", Long.valueOf(j3));
        if (intent != null && trpcInovkeRsp != null) {
            if (j3 != 0) {
                QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend retCode=", Long.valueOf(j3));
                this.f398362a.onGetMetaDreamIsFriend(false, j3, false);
                return;
            }
            if (!trpcInovkeRsp.data.has()) {
                QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend empty body");
                this.f398362a.onGetMetaDreamIsFriend(true, j3, false);
                return;
            }
            try {
                GameCenterMetaDreamUserCenter$IsFriendRsp gameCenterMetaDreamUserCenter$IsFriendRsp = new GameCenterMetaDreamUserCenter$IsFriendRsp();
                gameCenterMetaDreamUserCenter$IsFriendRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                boolean z16 = gameCenterMetaDreamUserCenter$IsFriendRsp.is_friend.get();
                QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend isFriend=", Boolean.valueOf(z16));
                this.f398362a.onGetMetaDreamIsFriend(true, j3, z16);
                return;
            } catch (Throwable th5) {
                QLog.e("QQGameStrategyHandler", 1, "handleGetMetaDreamFriendList exception:", th5);
                return;
            }
        }
        QLog.d("QQGameStrategyHandler", 1, "handleIsMetaDreamGameFriend req or rsp null");
        this.f398362a.onGetMetaDreamIsFriend(false, j3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        Bundle extras = intent.getExtras();
        long j16 = extras.getLong("questionId");
        long j17 = extras.getLong("answerId");
        boolean z16 = extras.getBoolean("likeAnswerStatus");
        if (trpcInovkeRsp != null && j3 == 0) {
            try {
                GameStrategyQA$LikeAnswerReply gameStrategyQA$LikeAnswerReply = new GameStrategyQA$LikeAnswerReply();
                gameStrategyQA$LikeAnswerReply.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                QLog.d("QQGameStrategyHandler", 1, "handleLikeAnswerRsp, msg=", gameStrategyQA$LikeAnswerReply.f212670msg.get());
                this.f398362a.onLikeAnswerRsp(j3, j16, j17, z16, true);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, "handleLikeAnswerRsp, exception=", e16);
                return;
            }
        }
        QLog.e("QQGameStrategyHandler", 1, "handleLikeAnswerRsp, error null ret:", Long.valueOf(j3));
        this.f398362a.onLikeAnswerRsp(j3, j16, j17, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        boolean z16;
        int i3 = intent.getExtras().getInt("pageIndex");
        int i16 = intent.getExtras().getInt("refType");
        int i17 = intent.getExtras().getInt("sourceType");
        if (j3 == 0 && trpcInovkeRsp != null) {
            try {
                GameStrategyQA$GetMyRefMaterialsRsp gameStrategyQA$GetMyRefMaterialsRsp = new GameStrategyQA$GetMyRefMaterialsRsp();
                gameStrategyQA$GetMyRefMaterialsRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ArrayList arrayList = new ArrayList();
                for (int i18 = 0; i18 < gameStrategyQA$GetMyRefMaterialsRsp.list.size(); i18++) {
                    arrayList.add(H(gameStrategyQA$GetMyRefMaterialsRsp.list.get(i18)));
                }
                if (gameStrategyQA$GetMyRefMaterialsRsp.is_over.has()) {
                    z16 = gameStrategyQA$GetMyRefMaterialsRsp.is_over.get();
                } else {
                    z16 = false;
                }
                this.f398362a.onGetMyRefMaterials(j3, arrayList, i3, i16, i17, z16);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQGameStrategyHandler", 1, e16, new Object[0]);
                return;
            }
        }
        this.f398362a.onGetMyRefMaterials(j3, null, i3, i16, i17, false);
        QLog.e("QQGameStrategyHandler", 1, "handleMyRefMaterials return failed, ret:", Long.valueOf(j3));
    }

    public void G(String str, String str2) {
        QLog.d("QQGameStrategyHandler", 1, "addMetaDreamGameFriend");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq gameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq = new GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq();
                gameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq.to_openid.set(str);
                gameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq.to_aio_role_id.set(str2);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1353", false, gameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq.toByteArray());
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
                return;
            } catch (Throwable th5) {
                QLog.e("QQGameStrategyHandler", 1, "addMetaDreamGameFriend exception=", th5);
                return;
            }
        }
        QLog.d("QQGameStrategyHandler", 1, "addMetaDreamGameFriend invalid param");
    }

    public void I(String str, String str2, int i3, boolean z16) {
        QLog.d("QQGameStrategyHandler", 1, "changeExpertOnlineStatus, guildId=", str, ", channelId=", str2, ", appid=", Integer.valueOf(i3), ", isOnline=", Boolean.valueOf(z16));
        GameStrategyQA$ChangeOnLineStatusReq gameStrategyQA$ChangeOnLineStatusReq = new GameStrategyQA$ChangeOnLineStatusReq();
        gameStrategyQA$ChangeOnLineStatusReq.guild_id.set(str);
        gameStrategyQA$ChangeOnLineStatusReq.channel_id.set(str2);
        gameStrategyQA$ChangeOnLineStatusReq.game_appid.set(i3);
        gameStrategyQA$ChangeOnLineStatusReq.is_online.set(z16);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/542", false, gameStrategyQA$ChangeOnLineStatusReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putSerializable("isOnline", Boolean.valueOf(z16));
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void I0(String str, String str2, int i3) {
        QLog.d("QQGameStrategyHandler", 1, "heartbeat, guildId=", str, ", channelId=", str2, ", appid=", Integer.valueOf(i3));
        GameStrategyQA$HeartbeatReportReq gameStrategyQA$HeartbeatReportReq = new GameStrategyQA$HeartbeatReportReq();
        gameStrategyQA$HeartbeatReportReq.guild_id.set(str);
        gameStrategyQA$HeartbeatReportReq.channel_id.set(str2);
        gameStrategyQA$HeartbeatReportReq.game_appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/540", false, gameStrategyQA$HeartbeatReportReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void J(String str, String str2) {
        QLog.d("QQGameStrategyHandler", 1, "checkAtRobot, guildId=", str, ", channelId=", str2);
        GameStrategyQA$CheckMentionReq gameStrategyQA$CheckMentionReq = new GameStrategyQA$CheckMentionReq();
        gameStrategyQA$CheckMentionReq.guild_id.set(str);
        gameStrategyQA$CheckMentionReq.channel_id.set(str2);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/572", false, gameStrategyQA$CheckMentionReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void J0(long j3, int i3, List<String> list) {
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[inviteUser] questionId:");
        sb5.append(j3);
        sb5.append(",appId:");
        sb5.append(i3);
        sb5.append(",uinList:");
        if (list != null) {
            i16 = list.size();
        } else {
            i16 = 0;
        }
        sb5.append(i16);
        QLog.d("QQGameStrategyHandler", 1, sb5.toString());
        GameStrategyQAInvite$InviteUserRequest gameStrategyQAInvite$InviteUserRequest = new GameStrategyQAInvite$InviteUserRequest();
        gameStrategyQAInvite$InviteUserRequest.way.set(2);
        gameStrategyQAInvite$InviteUserRequest.appid.set(i3);
        gameStrategyQAInvite$InviteUserRequest.question_id.set(j3);
        gameStrategyQAInvite$InviteUserRequest.encoded_uins.set(list);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/654", false, gameStrategyQAInvite$InviteUserRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void K0(String str) {
        QLog.d("QQGameStrategyHandler", 1, "isMetaDreamGameFriend");
        try {
            GameCenterMetaDreamUserCenter$IsFriendReq gameCenterMetaDreamUserCenter$IsFriendReq = new GameCenterMetaDreamUserCenter$IsFriendReq();
            gameCenterMetaDreamUserCenter$IsFriendReq.aio_role_id.set(str);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1329", false, gameCenterMetaDreamUserCenter$IsFriendReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e("QQGameStrategyHandler", 1, "isMetaDreamGameFriend exception=", th5);
        }
    }

    public void L(String str, int i3) {
        GameStrategyQAAuth$GetJoinAnswerRequirementRequest gameStrategyQAAuth$GetJoinAnswerRequirementRequest = new GameStrategyQAAuth$GetJoinAnswerRequirementRequest();
        gameStrategyQAAuth$GetJoinAnswerRequirementRequest.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/446", false, gameStrategyQAAuth$GetJoinAnswerRequirementRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putString("channelId", str);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void L0(int i3) {
        GameStrategyQAAuth$JoinAnswerUserRequest gameStrategyQAAuth$JoinAnswerUserRequest = new GameStrategyQAAuth$JoinAnswerUserRequest();
        gameStrategyQAAuth$JoinAnswerUserRequest.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/444", false, gameStrategyQAAuth$JoinAnswerUserRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void M(String str, int i3) {
        GameStrategyQAAuth$CheckInWhiteListRequest gameStrategyQAAuth$CheckInWhiteListRequest = new GameStrategyQAAuth$CheckInWhiteListRequest();
        gameStrategyQAAuth$CheckInWhiteListRequest.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/387", false, gameStrategyQAAuth$CheckInWhiteListRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putString("channelId", str);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void M0(long j3, long j16, int i3, boolean z16) {
        long j17;
        QLog.d("QQGameStrategyHandler", 1, "likeAnswer, questionId=", Long.valueOf(j3), ", answerId=", Long.valueOf(j16), ", appid=", Integer.valueOf(i3), ", isLike=", Boolean.valueOf(z16));
        GameStrategyQA$LikeAnswerRequest gameStrategyQA$LikeAnswerRequest = new GameStrategyQA$LikeAnswerRequest();
        gameStrategyQA$LikeAnswerRequest.question_id.set(j3);
        gameStrategyQA$LikeAnswerRequest.answer_id.set(j16);
        gameStrategyQA$LikeAnswerRequest.appid.set(i3);
        PBInt64Field pBInt64Field = gameStrategyQA$LikeAnswerRequest.value;
        if (z16) {
            j17 = 1;
        } else {
            j17 = -1;
        }
        pBInt64Field.set(j17);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/382", false, gameStrategyQA$LikeAnswerRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putLong("questionId", j3);
        bundle.putLong("answerId", j16);
        bundle.putBoolean("likeAnswerStatus", z16);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void N(String str, String str2) {
        QLog.d("QQGameStrategyHandler", 1, "getChannelBindInfo, guildId=", str, ", channelId=", str2);
        GameStrategyQA$GetBindedRobotRequest gameStrategyQA$GetBindedRobotRequest = new GameStrategyQA$GetBindedRobotRequest();
        gameStrategyQA$GetBindedRobotRequest.guild_id.set(Long.parseLong(str));
        gameStrategyQA$GetBindedRobotRequest.channel_id.set(Long.parseLong(str2));
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/608", false, gameStrategyQA$GetBindedRobotRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void N0() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f398363b);
    }

    public void O(long j3, int i3) {
        QLog.d("QQGameStrategyHandler", 1, "getGameList, pageIndex=", Long.valueOf(j3), ", size=", Integer.valueOf(i3));
        GameStrategyQA$PullGamesRequest gameStrategyQA$PullGamesRequest = new GameStrategyQA$PullGamesRequest();
        gameStrategyQA$PullGamesRequest.page.set(j3);
        gameStrategyQA$PullGamesRequest.size.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/610", false, gameStrategyQA$PullGamesRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void P(int i3, int i16, long j3, String str) {
        QLog.d("QQGameStrategyHandler", 1, "[getInviteList] queryType:" + i3 + ",appId:" + i16 + ",questionId:" + j3 + ",match:" + str);
        GameStrategyQAInvite$QueryUserListRequest gameStrategyQAInvite$QueryUserListRequest = new GameStrategyQAInvite$QueryUserListRequest();
        gameStrategyQAInvite$QueryUserListRequest.query.set(i3);
        gameStrategyQAInvite$QueryUserListRequest.appid.set(i16);
        gameStrategyQAInvite$QueryUserListRequest.question_id.set(j3);
        gameStrategyQAInvite$QueryUserListRequest.match.set(str);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1015", false, gameStrategyQAInvite$QueryUserListRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("query", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void P0(GameStrategyAnswer gameStrategyAnswer, long j3) {
        O0(gameStrategyAnswer, 1, j3);
    }

    public void Q(int i3, int i16, List<String> list) {
        int i17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getInviteListDetail] queryType:");
        sb5.append(i3);
        sb5.append(",appId:");
        sb5.append(i16);
        sb5.append(",uinList:");
        if (list != null) {
            i17 = list.size();
        } else {
            i17 = 0;
        }
        sb5.append(i17);
        QLog.d("QQGameStrategyHandler", 1, sb5.toString());
        GameStrategyQAInvite$QueryUserRequestV2 gameStrategyQAInvite$QueryUserRequestV2 = new GameStrategyQAInvite$QueryUserRequestV2();
        gameStrategyQAInvite$QueryUserRequestV2.query.set(i3);
        gameStrategyQAInvite$QueryUserRequestV2.appid.set(i16);
        gameStrategyQAInvite$QueryUserRequestV2.encoded_uins.set(list);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1016", false, gameStrategyQAInvite$QueryUserRequestV2.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("query", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void Q0(GameStrategyAnswer gameStrategyAnswer) {
        if (gameStrategyAnswer == null) {
            return;
        }
        GameStrategyQA$NewChannelAnswerRequest gameStrategyQA$NewChannelAnswerRequest = new GameStrategyQA$NewChannelAnswerRequest();
        gameStrategyQA$NewChannelAnswerRequest.appid.set(gameStrategyAnswer.mAppId);
        gameStrategyQA$NewChannelAnswerRequest.question_id.set(gameStrategyAnswer.mQuestionId);
        gameStrategyQA$NewChannelAnswerRequest.content.set(gameStrategyAnswer.mContent);
        gameStrategyQA$NewChannelAnswerRequest.pics.set(X(gameStrategyAnswer.getPics()));
        gameStrategyQA$NewChannelAnswerRequest.source.set(2);
        gameStrategyQA$NewChannelAnswerRequest.guild_id.set(Long.parseLong(gameStrategyAnswer.channelEntry.guildId));
        gameStrategyQA$NewChannelAnswerRequest.channel_id.set(Long.parseLong(gameStrategyAnswer.channelEntry.channelId));
        int K = K();
        gameStrategyQA$NewChannelAnswerRequest.ark_random.set(K);
        gameStrategyQA$NewChannelAnswerRequest.videos.set(c0(gameStrategyAnswer.getVideos()));
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/512", false, gameStrategyQA$NewChannelAnswerRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("randomId", K);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void R(String str, String str2, String str3) {
        QLog.d("QQGameStrategyHandler", 1, "getMetaDreamGameTeamingLink");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq = new GameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq();
                gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq.to_openid.set(str);
                gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq.to_roleid.set(str2);
                gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq.from_roleid.set(str3);
                TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1331", false, gameCenterMetaDreamUserCenter$GetGameAIOTeamLinkReq.toByteArray());
                TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                trpcListReq.list.add(createTrpcInvokeReq);
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
                return;
            } catch (Throwable th5) {
                QLog.e("QQGameStrategyHandler", 1, "getMetaDreamGameTeamingLink exception=", th5);
                return;
            }
        }
        QLog.d("QQGameStrategyHandler", 1, "getMetaDreamGameTeamingLink, invalid param");
    }

    public void R0(GameStrategyQuestion gameStrategyQuestion) {
        GameStrategyQA$NewChannelQuestionRequest gameStrategyQA$NewChannelQuestionRequest = new GameStrategyQA$NewChannelQuestionRequest();
        gameStrategyQA$NewChannelQuestionRequest.appid.set(gameStrategyQuestion.mAppId);
        gameStrategyQA$NewChannelQuestionRequest.tag_ids.set(gameStrategyQuestion.getTagIds());
        gameStrategyQA$NewChannelQuestionRequest.title.set(gameStrategyQuestion.mTitle);
        gameStrategyQA$NewChannelQuestionRequest.content.set(gameStrategyQuestion.mContent);
        gameStrategyQA$NewChannelQuestionRequest.pics.set(X(gameStrategyQuestion.getPics()));
        gameStrategyQA$NewChannelQuestionRequest.source.set(2);
        gameStrategyQA$NewChannelQuestionRequest.guild_id.set(Long.parseLong(gameStrategyQuestion.channelEntry.guildId));
        gameStrategyQA$NewChannelQuestionRequest.channel_id.set(Long.parseLong(gameStrategyQuestion.channelEntry.channelId));
        int K = K();
        gameStrategyQA$NewChannelQuestionRequest.ark_random.set(K);
        gameStrategyQA$NewChannelQuestionRequest.videos.set(c0(gameStrategyQuestion.getVideos()));
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/511", false, gameStrategyQA$NewChannelQuestionRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("randomId", K);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void S(int i3) {
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/778", false, new MessageMicro<GameStrategyQA$GetRecmdRefMaterialsReq>() { // from class: com.tencent.mobileqq.gamecenter.qa.proto.GameStrategyQA$GetRecmdRefMaterialsReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameStrategyQA$GetRecmdRefMaterialsReq.class);
        }.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("refType", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void S0(GameStrategyAnswer gameStrategyAnswer, long j3) {
        O0(gameStrategyAnswer, 0, j3);
    }

    public void T(int i3, int i16, int i17, int i18) {
        GameStrategyQA$GetMyRefMaterialsReq gameStrategyQA$GetMyRefMaterialsReq = new GameStrategyQA$GetMyRefMaterialsReq();
        gameStrategyQA$GetMyRefMaterialsReq.ref_type.set(i3);
        gameStrategyQA$GetMyRefMaterialsReq.req_type.set(i16);
        gameStrategyQA$GetMyRefMaterialsReq.page_index.set(i17);
        gameStrategyQA$GetMyRefMaterialsReq.page_size.set(i18);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/747", false, gameStrategyQA$GetMyRefMaterialsReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("pageIndex", i17);
        bundle.putInt("refType", i3);
        bundle.putInt("sourceType", i16);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void T0(GameStrategyQuestion gameStrategyQuestion, long j3) {
        U0(gameStrategyQuestion, 0, j3);
    }

    public void U(int i3) {
        QLog.d("QQGameStrategyHandler", 1, "getNoAnswerNum, appId=", Integer.valueOf(i3));
        GameStrategyQA$GetNoAnsweredRequest gameStrategyQA$GetNoAnsweredRequest = new GameStrategyQA$GetNoAnsweredRequest();
        gameStrategyQA$GetNoAnsweredRequest.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/538", false, gameStrategyQA$GetNoAnsweredRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void U0(GameStrategyQuestion gameStrategyQuestion, int i3, long j3) {
        if (gameStrategyQuestion == null) {
            return;
        }
        GameStrategyQA$NewQuestionRequest gameStrategyQA$NewQuestionRequest = new GameStrategyQA$NewQuestionRequest();
        gameStrategyQA$NewQuestionRequest.appid.set(gameStrategyQuestion.mAppId);
        gameStrategyQA$NewQuestionRequest.title.set(gameStrategyQuestion.mTitle);
        gameStrategyQA$NewQuestionRequest.content.set(gameStrategyQuestion.mContent);
        gameStrategyQA$NewQuestionRequest.tag_ids.set(gameStrategyQuestion.getTagIds());
        gameStrategyQA$NewQuestionRequest.scene.set(i3);
        gameStrategyQA$NewQuestionRequest.f212673id.set(j3);
        gameStrategyQA$NewQuestionRequest.pics.set(X(gameStrategyQuestion.getPics()));
        gameStrategyQA$NewQuestionRequest.videos.set(c0(gameStrategyQuestion.getVideos()));
        gameStrategyQA$NewQuestionRequest.refs.set(b0(gameStrategyQuestion.getLinkCards()));
        if (!TextUtils.isEmpty(gameStrategyQuestion.mRichContent)) {
            gameStrategyQA$NewQuestionRequest.rich_content.set(gameStrategyQuestion.mRichContent);
        }
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/369", false, gameStrategyQA$NewQuestionRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void V(String str) {
        QLog.d("QQGameStrategyHandler", 1, com.tencent.luggage.wxa.q2.e.NAME);
        try {
            GameCenterYunGameAuth$GetOAIDReq gameCenterYunGameAuth$GetOAIDReq = new GameCenterYunGameAuth$GetOAIDReq();
            gameCenterYunGameAuth$GetOAIDReq.ticket.set(str);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1502", false, gameCenterYunGameAuth$GetOAIDReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Throwable th5) {
            QLog.e("QQGameStrategyHandler", 1, "getOAID exception=", th5);
        }
    }

    public void V0(GameStrategyQuestion gameStrategyQuestion, long j3) {
        U0(gameStrategyQuestion, 1, j3);
    }

    public void W(String str, String str2, int i3) {
        QLog.d("QQGameStrategyHandler", 1, "getOnlineStatus, guildId=", str, ", channelId=", str2, ", appid=", Integer.valueOf(i3));
        GameStrategyQA$GetOnLineStatusReq gameStrategyQA$GetOnLineStatusReq = new GameStrategyQA$GetOnLineStatusReq();
        gameStrategyQA$GetOnLineStatusReq.guild_id.set(str);
        gameStrategyQA$GetOnLineStatusReq.channel_id.set(str2);
        gameStrategyQA$GetOnLineStatusReq.game_appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/543", false, gameStrategyQA$GetOnLineStatusReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void W0(int i3) {
        GameStrategyQA$GetTagsRequest gameStrategyQA$GetTagsRequest = new GameStrategyQA$GetTagsRequest();
        gameStrategyQA$GetTagsRequest.appid.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/367", false, gameStrategyQA$GetTagsRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void X0(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GameStrategyQA$SearchQuestionsRequest gameStrategyQA$SearchQuestionsRequest = new GameStrategyQA$SearchQuestionsRequest();
        gameStrategyQA$SearchQuestionsRequest.appid.set(i3);
        gameStrategyQA$SearchQuestionsRequest.keyword.set(str);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/376", false, gameStrategyQA$SearchQuestionsRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putString("keyWord", str);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void Y(String str, String str2, int i3, int i16, int i17) {
        QLog.d("QQGameStrategyHandler", 1, "getQuestionExpertList, guildId=", str, ", channelId=", str2, ", appid=", Integer.valueOf(i3), ", page=", Integer.valueOf(i16), ", size=", Integer.valueOf(i17));
        GameStrategyQA$GetStarListReq gameStrategyQA$GetStarListReq = new GameStrategyQA$GetStarListReq();
        gameStrategyQA$GetStarListReq.guild_id.set(str);
        gameStrategyQA$GetStarListReq.channel_id.set(str2);
        gameStrategyQA$GetStarListReq.game_appid.set(i3);
        gameStrategyQA$GetStarListReq.page.set(i16);
        gameStrategyQA$GetStarListReq.num.set(i17);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/541", false, gameStrategyQA$GetStarListReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pageIndex", Integer.valueOf(i16));
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void Y0(String str, String str2, int i3, String str3) {
        QLog.d("QQGameStrategyHandler", 1, "setChannelBindInfo, guildId=", str, ", channelId=", str2);
        GameStrategyQA$SetBindedRobotRequest gameStrategyQA$SetBindedRobotRequest = new GameStrategyQA$SetBindedRobotRequest();
        gameStrategyQA$SetBindedRobotRequest.guild_id.set(Long.parseLong(str));
        gameStrategyQA$SetBindedRobotRequest.channel_id.set(Long.parseLong(str2));
        GameStrategyQA$BindedRobot gameStrategyQA$BindedRobot = new GameStrategyQA$BindedRobot();
        gameStrategyQA$BindedRobot.appid.set(i3);
        gameStrategyQA$BindedRobot.robot_id.set(str3);
        gameStrategyQA$SetBindedRobotRequest.robot.set(gameStrategyQA$BindedRobot);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/609", false, gameStrategyQA$SetBindedRobotRequest.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void Z(int i3, long j3, int i16, String str, int i17) {
        QLog.d("QQGameStrategyHandler", 1, "getQuestionList, appId=", Integer.valueOf(i3), ", page=", Long.valueOf(j3), ", pageType=", Integer.valueOf(i16), ", viewSign=", str, ", size=", Integer.valueOf(i17));
        GameStrategyQA$GetChannelRecommendsV2Request gameStrategyQA$GetChannelRecommendsV2Request = new GameStrategyQA$GetChannelRecommendsV2Request();
        gameStrategyQA$GetChannelRecommendsV2Request.appid.set(i3);
        gameStrategyQA$GetChannelRecommendsV2Request.page.set(j3);
        gameStrategyQA$GetChannelRecommendsV2Request.tag.set(0L);
        gameStrategyQA$GetChannelRecommendsV2Request.size.set(i17);
        gameStrategyQA$GetChannelRecommendsV2Request.view_sign.set(str);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/578", false, gameStrategyQA$GetChannelRecommendsV2Request.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public void Z0(d dVar) {
        this.f398362a = dVar;
    }

    public void a0(String str, long j3) {
        GameStrategyQA$GetRefMaterialByLinkReq gameStrategyQA$GetRefMaterialByLinkReq = new GameStrategyQA$GetRefMaterialByLinkReq();
        gameStrategyQA$GetRefMaterialByLinkReq.url.set(str);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/746", false, gameStrategyQA$GetRefMaterialByLinkReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putLong("sequenceId", j3);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }
}
