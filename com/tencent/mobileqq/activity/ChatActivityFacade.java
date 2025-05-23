package com.tencent.mobileqq.activity;

import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import NS_QQ_STORY_CLIENT.CLIENT$StGetUserNewestStoryRsp;
import NS_QQ_STORY_META.META$StStoryFeed;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.QzoneAioStoryFeedRequest;
import com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb$ResvAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.poke.IPokeSendHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qcircle.api.requests.QCircleStGetC2CFeedRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.manager.BirthDayNoticeManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudRead$StGetC2CFeedRsp;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatActivityFacade {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f175055a;

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f175056b;

    /* renamed from: c, reason: collision with root package name */
    private static b f175057c;

    /* renamed from: d, reason: collision with root package name */
    public static QQToast f175058d;

    /* renamed from: e, reason: collision with root package name */
    public static ActionSheet f175059e;

    /* renamed from: f, reason: collision with root package name */
    public static List<ChatMessage> f175060f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$12, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass12 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175073d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f175074e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MessageRecord f175075f;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatActivityFacade.N(this.f175073d, this.f175074e, this.f175075f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$13, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass13 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175076d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatMessage f175077e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f175076d.getMessageFacade().z0(this.f175077e, false);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$17, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass17 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageRecord f175095d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175096e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f175097f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f175098h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f175099i;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                if (this.f175095d.isSendFromLocal()) {
                    ITransFileController iTransFileController = (ITransFileController) this.f175096e.getRuntimeService(ITransFileController.class);
                    MessageRecord messageRecord = this.f175095d;
                    iTransFileController.removeProcessor(BaseTransFileController.makeKey(messageRecord.frienduin, messageRecord.uniseq));
                }
                AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(this.f175095d.msgData);
                this.f175096e.getMessageFacade().T1(this.f175097f, this.f175098h, this.f175099i);
                if (d16 instanceof StructMsgForImageShare) {
                    StructMsgForImageShare.resendAndUploadImageShare(this.f175096e, this.f175095d, (StructMsgForImageShare) d16);
                } else if ((d16 instanceof AbsShareMsg) && ForwardUtils.M(((AbsShareMsg) d16).forwardType, d16.mMsgServiceID)) {
                    AbsShareMsg.resendSdkShareMessage(this.f175096e, this.f175095d, (AbsShareMsg) d16);
                } else {
                    this.f175096e.getMessageFacade().b(com.tencent.mobileqq.service.message.q.n(this.f175095d), null, true);
                }
            } catch (RuntimeException e16) {
                QLog.e("ChatActivityFacade", 1, "resendStructMessage error :", e16);
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SessionInfo f175100d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175101e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f175102f;

        @Override // java.lang.Runnable
        public void run() {
            long[] jArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SessionInfo sessionInfo = this.f175100d;
            if (sessionInfo != null) {
                ChatActivityFacade.A(this.f175101e, sessionInfo);
                if (ChatActivityFacade.s0(this.f175101e, this.f175100d) || ChatActivityFacade.m0(this.f175101e, this.f175100d, true)) {
                    long e06 = ChatActivityFacade.e0(this.f175101e, this.f175100d);
                    QLog.i("ChatActivityFacade.QZoneFeeds", 1, "insertFriendNewestFeedIfNeeded    last publish time:" + e06);
                    try {
                        jArr = new long[]{com.tencent.av.utils.i.g(this.f175100d.f179557e)};
                    } catch (Exception unused) {
                        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "Long.valueOf " + this.f175100d.f179557e);
                        jArr = null;
                    }
                    long[] jArr2 = jArr;
                    boolean z16 = this.f175102f;
                    SessionInfo sessionInfo2 = this.f175100d;
                    if (sessionInfo2 != null && sessionInfo2.f179557e != null) {
                        c cVar = (c) ChatActivityFacade.f175056b.get(this.f175100d.f179557e);
                        if (cVar == null) {
                            cVar = new c();
                            ChatActivityFacade.f175056b.put(this.f175100d.f179557e, cVar);
                        }
                        c cVar2 = cVar;
                        cVar2.f175134d = new WeakReference<>(this.f175101e);
                        cVar2.f175135e = this.f175100d;
                        cVar2.f175136f = this.f175102f;
                        QLog.i("ChatActivityFacade.QZoneFeeds", 1, "insertFriendNewestFeedIfNeeded  request");
                        IQzoneReq iQzoneReq = (IQzoneReq) QRoute.api(IQzoneReq.class);
                        QQAppInterface qQAppInterface = this.f175101e;
                        iQzoneReq.sentNewestFeedServlet(qQAppInterface, cVar2, qQAppInterface.getLongAccountUin(), jArr2, e06, z16 ? 1 : 0);
                    }
                    ChatActivityFacade.W0(this.f175101e, this.f175100d, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_FEEDS_TIME);
                    return;
                }
                return;
            }
            QLog.e("ChatActivityFacade.insertFriendNewestFeedIfNeeded", 1, "insertFriendNewestFeedIfNeeded:sessionInfo == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175103d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SessionInfo f175104e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f175105f;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$3$a */
        /* loaded from: classes9.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetC2CFeedRsp> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                }
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetC2CFeedRsp feedCloudRead$StGetC2CFeedRsp) {
                PBStringField pBStringField;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetC2CFeedRsp);
                    return;
                }
                if (z16) {
                    if (feedCloudRead$StGetC2CFeedRsp != null) {
                        if (QLog.isColorLevel() && (pBStringField = feedCloudRead$StGetC2CFeedRsp.attchInfo) != null && pBStringField.get() != null) {
                            QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: response.attchInfo==" + feedCloudRead$StGetC2CFeedRsp.attchInfo.get());
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        ChatActivityFacade.r(anonymousClass3.f175103d, anonymousClass3.f175104e, feedCloudRead$StGetC2CFeedRsp, anonymousClass3.f175105f);
                        PBStringField pBStringField2 = feedCloudRead$StGetC2CFeedRsp.attchInfo;
                        if (pBStringField2 != null && !StringUtil.isEmpty(pBStringField2.get())) {
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            ChatActivityFacade.V0(anonymousClass32.f175103d, anonymousClass32.f175104e, feedCloudRead$StGetC2CFeedRsp.attchInfo.get());
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest failed: response==null");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("ChatActivityFacade.QCircleFeeds", 2, String.format(Locale.getDefault(), "QCircleStGetC2CFeedRequest failed: retCode=%d,errMsg=%s", Long.valueOf(j3), str));
                }
                QLog.d("ChatActivityFacade", 1, "getSingleFeed onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!ChatActivityFacade.s0(this.f175103d, this.f175104e) && !ChatActivityFacade.n0(this.f175103d, this.f175104e, true)) {
                QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: (isShowStatus || isNeedInsertQCircleNewestFeeds) == false");
                return;
            }
            if (TextUtils.isEmpty(this.f175104e.f179557e)) {
                QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: sessionInfo.curFriendUin is empty");
                return;
            }
            QCircleStGetC2CFeedRequest qCircleStGetC2CFeedRequest = new QCircleStGetC2CFeedRequest(this.f175104e.f179557e);
            String b06 = ChatActivityFacade.b0(this.f175103d, this.f175104e);
            qCircleStGetC2CFeedRequest.mReq.attchInfo.set(b06);
            QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: request.attchInfo==" + b06);
            VSNetworkHelper.getInstance().sendRequest(qCircleStGetC2CFeedRequest, new a());
            ChatActivityFacade.W0(this.f175103d, this.f175104e, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_QCIRCLE_FEEDS_TIME);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175107d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SessionInfo f175108e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (ChatActivityFacade.l0(this.f175107d, this.f175108e, true)) {
                long f06 = ChatActivityFacade.f0(this.f175107d, this.f175108e);
                QLog.i("ChatActivityFacade.QZoneStoryFeeds", 1, "lastTime: " + f06);
                NewIntent newIntent = new NewIntent(this.f175107d.getApplication(), QzoneAioStoryFeedServlet.class);
                newIntent.putExtra(QzoneAioStoryFeedServlet.KEY_LAST_AIO_STORY_CREATE_TIME, f06);
                try {
                    newIntent.putExtra(QzoneAioStoryFeedServlet.KEY_FRIEND_UIN, com.tencent.av.utils.i.g(this.f175108e.f179557e));
                } catch (Exception unused) {
                    QLog.e("ChatActivityFacade.QZoneStoryFeeds", 1, "Long.valueOf " + this.f175108e.f179557e);
                }
                ChatActivityFacade.f175057c.f175132d = new WeakReference<>(this.f175107d);
                ChatActivityFacade.f175057c.f175133e = this.f175108e;
                newIntent.setObserver(ChatActivityFacade.f175057c);
                this.f175107d.startServlet(newIntent);
                ChatActivityFacade.W0(this.f175107d, this.f175108e, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_STORY_FEED_TIME);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityFacade$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175109d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SessionInfo f175110e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BirthDayNoticeManager.f(this.f175109d, this.f175110e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f175126a;

        /* renamed from: b, reason: collision with root package name */
        public long f175127b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f175128c;

        /* renamed from: d, reason: collision with root package name */
        public long f175129d;

        /* renamed from: e, reason: collision with root package name */
        public int f175130e;

        /* renamed from: f, reason: collision with root package name */
        public int f175131f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class b extends QZoneObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<QQAppInterface> f175132d;

        /* renamed from: e, reason: collision with root package name */
        public SessionInfo f175133e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.observer.QZoneObserver
        protected void d(boolean z16, Bundle bundle) {
            CLIENT$StGetUserNewestStoryRsp onResponse;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            WeakReference<QQAppInterface> weakReference = this.f175132d;
            if (weakReference == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed appRef==null");
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = weakReference.get();
            if (qQAppInterface != null && this.f175133e != null) {
                if (z16) {
                    try {
                        FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable(QzoneAioStoryFeedServlet.KEY_FOR_AIO_STORY_FEED_DATA);
                        if (fromServiceMsg != null && (onResponse = QzoneAioStoryFeedRequest.onResponse(com.tencent.mobileqq.utils.fh.a(fromServiceMsg.getWupBuffer()))) != null) {
                            ChatActivityFacade.s(qQAppInterface, this.f175133e, onResponse);
                        }
                    } catch (Exception e16) {
                        QLog.e("UndealCount.QZoneObserver", 1, "call onGetNewestStoryFeed exception " + e16);
                        return;
                    }
                }
                this.f175133e = null;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.QZoneObserver.QZoneStoryFeeds", 2, "onGetQZoneNewestStoryFeed app == null || sessionInfo == nul");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class c extends QZoneObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<QQAppInterface> f175134d;

        /* renamed from: e, reason: collision with root package name */
        public SessionInfo f175135e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f175136f;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.observer.QZoneObserver
        protected void g(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            WeakReference<QQAppInterface> weakReference = this.f175134d;
            if (weakReference == null) {
                QLog.e("UndealCount.QZoneObserver.QZoneFeeds", 1, "onGetQZoneNewestFeed appRef==null");
                return;
            }
            QQAppInterface qQAppInterface = weakReference.get();
            if (qQAppInterface != null && this.f175135e != null) {
                Serializable serializable = bundle.getSerializable("data");
                if (z16 && serializable != null && (serializable instanceof AIONewestFeedRsp)) {
                    ChatActivityFacade.t(qQAppInterface, this.f175135e, (AIONewestFeedRsp) serializable, this.f175136f);
                } else {
                    QLog.e("UndealCount.QZoneObserver.QZoneFeeds", 1, "onGetQZoneNewestFeed  isSuc == false || rsp == null");
                }
                if (ChatActivityFacade.f175056b != null && !TextUtils.isEmpty(this.f175135e.f179557e)) {
                    c cVar = (c) ChatActivityFacade.f175056b.get(this.f175135e.f179557e);
                    ChatActivityFacade.f175056b.remove(this.f175135e.f179557e);
                    qQAppInterface.unRegistObserver(cVar);
                }
                this.f175135e = null;
                return;
            }
            QLog.e("UndealCount.QZoneObserver.QZoneFeeds", 1, "onGetQZoneNewestFeed app == null || sessionInfo == nul");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f175137a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f175138b;

        /* renamed from: c, reason: collision with root package name */
        public int f175139c;

        /* renamed from: d, reason: collision with root package name */
        public int f175140d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f175141e;

        /* renamed from: f, reason: collision with root package name */
        public int f175142f;

        /* renamed from: g, reason: collision with root package name */
        public long f175143g;

        /* renamed from: h, reason: collision with root package name */
        public MessageForReplyText.SourceMsgInfo f175144h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f175145i;

        /* renamed from: j, reason: collision with root package name */
        public long f175146j;

        /* renamed from: k, reason: collision with root package name */
        public int f175147k;

        /* renamed from: l, reason: collision with root package name */
        public String f175148l;

        /* renamed from: m, reason: collision with root package name */
        public String f175149m;

        /* renamed from: n, reason: collision with root package name */
        public int f175150n;

        /* renamed from: o, reason: collision with root package name */
        public long f175151o;

        /* renamed from: p, reason: collision with root package name */
        public long f175152p;

        /* renamed from: q, reason: collision with root package name */
        public int f175153q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f175154r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f175155s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f175156t;

        /* renamed from: u, reason: collision with root package name */
        public int f175157u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f175158v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f175159w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f175160x;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f175137a = true;
            this.f175138b = false;
            this.f175148l = null;
            this.f175149m = null;
            this.f175155s = false;
            this.f175156t = false;
            this.f175157u = -1;
            this.f175158v = false;
            this.f175159w = false;
            this.f175160x = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f175055a = -1L;
        f175056b = new ConcurrentHashMap<>();
        f175057c = new b();
        f175058d = null;
        f175059e = null;
        f175060f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface != null && sessionInfo != null) {
            boolean z16 = false;
            List<MessageRecord> D = qQAppInterface.getMessageFacade().D(sessionInfo.f179557e, 0, new int[]{MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED});
            if (D != null) {
                for (MessageRecord messageRecord : D) {
                    if (messageRecord != null && (messageRecord instanceof MessageForQzoneFeed) && ((MessageForQzoneFeed) messageRecord).isOldStructMsg) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ChatActivityFacade.QZoneFeeds", 2, "\u5220\u9664\u8001\u7ed3\u6784\u7684feeds");
                        }
                        qQAppInterface.getMessageFacade().A0(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                        qQAppInterface.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
                        z16 = true;
                    }
                }
            }
            if (z16) {
                E(qQAppInterface, sessionInfo);
            }
        }
    }

    public static void A0(QQAppInterface qQAppInterface, MessageForArkApp messageForArkApp, boolean z16) {
        u0(qQAppInterface);
        ((com.tencent.mobileqq.multimsg.e) qQAppInterface.getManager(QQManagerFactory.LONG_ARK_MSG_MANAGER)).k(qQAppInterface, messageForArkApp, z16);
    }

    private static void B(int i3, QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        ((com.tencent.mobileqq.activity.aio.q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(sessionInfo.f179557e, sessionInfo.f179555d, i3);
        C(qQAppInterface, sessionInfo);
    }

    public static boolean B0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArkAppMessage arkAppMessage) {
        boolean z16;
        p91.a asyncShareMsgManager;
        MessageForArkApp v3 = com.tencent.mobileqq.service.message.q.v(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d, arkAppMessage);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(v3.uniseq, arkAppMessage.uniSeq, arkAppMessage.forwardID);
        if (v3.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(v3);
        }
        v3.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286262e, "1");
        IArkAsyncShareMsgService iArkAsyncShareMsgService = (IArkAsyncShareMsgService) qQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "");
        if (iArkAsyncShareMsgService != null && v3.ark_app_message != null && (asyncShareMsgManager = iArkAsyncShareMsgService.getAsyncShareMsgManager()) != null) {
            z16 = asyncShareMsgManager.f(qQAppInterface, v3.ark_app_message.appName, sessionInfo, v3);
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityFacade", 2, "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(z16));
        }
        if (!z16) {
            qQAppInterface.getMessageFacade().a(v3, null);
        }
        return true;
    }

    private static void C(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        List<MessageRecord> D = qQAppInterface.getMessageFacade().D(sessionInfo.f179557e, 0, new int[]{MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED});
        if (D != null) {
            for (MessageRecord messageRecord : D) {
                if (messageRecord != null) {
                    qQAppInterface.getMessageFacade().A0(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                    qQAppInterface.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
                    com.tencent.mobileqq.utils.ea.l4(qQAppInterface.getCurrentUin(), messageRecord.frienduin, 0L);
                }
            }
        }
    }

    private static void C0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str, String str2, String str3, String str4, AbsShareMsg absShareMsg, String str5, String str6, String str7) {
        com.tencent.biz.map.b.d(qQAppInterface, str3, str4, str, str2, sessionInfo.f179557e, sessionInfo.f179555d, null);
    }

    private static void D(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        B(12, qQAppInterface, sessionInfo);
    }

    private static void D0(String str, SessionInfo sessionInfo, String str2, String str3, String str4, String str5, AbsShareMsg absShareMsg, String str6, String str7, String str8) {
        int i3 = sessionInfo.f179555d;
    }

    private static void E(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0);
            sharedPreferences.edit().remove(v(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_FEEDS_TIME)).apply();
        }
    }

    public static void E0(QQAppInterface qQAppInterface, String str, ArrayList<String> arrayList, a aVar) {
        String str2;
        boolean z16 = true;
        if (str != null) {
            str2 = com.tencent.mobileqq.service.message.s.d(str, true, null);
        } else {
            str2 = "";
        }
        String str3 = str2;
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        long j3 = i3;
        int abs = Math.abs(new Random().nextInt());
        int K0 = (int) com.tencent.mobileqq.service.message.e.K0();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        long f16 = com.tencent.mobileqq.service.message.s.f(abs);
        ChatMessage chatMessage = (ChatMessage) com.tencent.mobileqq.service.message.q.d(-1000);
        chatMessage.init(currentAccountUin, "", currentAccountUin, str3, K0, -1000, 0, j3);
        chatMessage.isread = true;
        chatMessage.msgUid = f16;
        chatMessage.shmsgseq = com.tencent.mobileqq.service.message.s.b(j3, 0);
        chatMessage.issend = 1;
        if (arrayList.size() > 10) {
            z16 = false;
        }
        chatMessage.needUpdateMsgTag = z16;
        ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(chatMessage);
        ((MessageForText) chatMessage).msgVia = 0;
        qQAppInterface.getMessageFacade().d2(qQAppInterface, chatMessage, arrayList, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,\u4e14storyFeeds.size =0 ,\u89c6\u4e3a\u540e\u53f0\u8ba9\u5ba2\u6237\u7aef\uff0c\u9700\u8981\u6e05\u7406\u672c\u5730\u7f13\u5b58");
        ((com.tencent.mobileqq.activity.aio.q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(sessionInfo.f179557e, sessionInfo.f179555d, 7);
        List<MessageRecord> D = qQAppInterface.getMessageFacade().D(sessionInfo.f179557e, 0, new int[]{MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO});
        if (D != null) {
            for (MessageRecord messageRecord : D) {
                if (messageRecord != null) {
                    qQAppInterface.getMessageFacade().A0(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                    qQAppInterface.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
                }
            }
        }
        X0(qQAppInterface, sessionInfo, 0L);
    }

    public static void F0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, String str, boolean z16, String str2, Bundle bundle) {
        G0(qQAppInterface, context, pVar, str, false, false, z16, null, null, str2, bundle);
    }

    public static long[] G(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        return new long[0];
    }

    public static void G0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, String str, boolean z16, boolean z17, boolean z18, String str2, StickerInfo stickerInfo, String str3, Bundle bundle) {
        if (str == null) {
            QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
            if (z16) {
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "5", "", "", "", "", "", "", "");
                return;
            }
            return;
        }
        com.tencent.mobileqq.utils.aw.m(-1L, pVar.f179555d, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            ChatActivityUtils.m0(context, R.string.cwe, 0);
            if (z16) {
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "6", "", "", "", "", "", "", "");
            }
            QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + str);
            return;
        }
        v.a aVar = new v.a();
        aVar.v(str);
        aVar.m(1006);
        aVar.x(pVar.f179557e);
        aVar.y(0);
        aVar.A(pVar.f179559f);
        aVar.B(qQAppInterface.getCurrentAccountUin());
        aVar.I(pVar.f179555d);
        aVar.H(pVar.S);
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1006);
        createPicReq.f(aVar.l());
        PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
        if (z18) {
            picMessageExtraData.imageBizType = 8;
            if (bundle != null) {
                picMessageExtraData.mTemplateId = bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "");
            }
        } else {
            picMessageExtraData.imageBizType = 1;
            picMessageExtraData.customFaceType = z17 ? 2 : 0;
            picMessageExtraData.emojiPkgId = z17 ? str2 : "";
            if (stickerInfo != null) {
                picMessageExtraData.stickerInfo = stickerInfo;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            picMessageExtraData.textSummary = "[" + str3 + "]";
        } else if (z18) {
            picMessageExtraData.textSummary = context.getResources().getString(R.string.imm);
        } else {
            picMessageExtraData.textSummary = context.getResources().getString(R.string.iml);
        }
        createPicReq.E = picMessageExtraData;
        int a16 = com.tencent.mobileqq.activity.aio.am.f178207a.a(picMessageExtraData.imageBizType);
        String string = bundle != null ? bundle.getString("filemd5") : null;
        com.tencent.mobileqq.forward.utils.f.f211079a.n(pVar, str, a16, string != null ? string : "");
        if (z16) {
            ThreadManagerV2.post(new Runnable(str, pVar, qQAppInterface) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f175070d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.activity.aio.p f175071e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f175072f;

                {
                    this.f175070d = str;
                    this.f175071e = pVar;
                    this.f175072f = qQAppInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, pVar, qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            com.tencent.mobileqq.activity.photo.m.k(new String[]{this.f175070d}, this.f175071e.f179555d, false, false, -1, this.f175072f);
                        } catch (Exception unused) {
                        }
                    }
                }
            }, 5, null, false);
        }
    }

    public static MessageRecord H(QQAppInterface qQAppInterface, SessionInfo sessionInfo, MessageForPtt messageForPtt) {
        if (sessionInfo != null && messageForPtt != null) {
            MessageRecord n3 = com.tencent.mobileqq.service.message.q.n(messageForPtt);
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(n3);
            qQAppInterface.getMessageFacade().c(n3, qQAppInterface.getCurrentAccountUin());
            return n3;
        }
        return null;
    }

    public static void H0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, Emoticon emoticon) {
        I0(qQAppInterface, context, pVar, emoticon, 0);
    }

    public static ChatMessage I(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        if (sessionInfo == null || str == null) {
            return null;
        }
        MessageForPic q16 = com.tencent.mobileqq.service.message.q.q(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d);
        q16.path = str;
        q16.size = 0L;
        q16.type = 1;
        q16.isRead = true;
        q16.serial();
        return q16;
    }

    public static void I0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, Emoticon emoticon, int i3) {
        if (emoticon == null) {
            QQToast.makeText(context, "emoticon is null.", 0).show();
            QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
            return;
        }
        int i16 = emoticon.jobType;
        if ((i16 == 0 || i16 == 2 || i16 == 4) && !emoticon.hasEncryptKey()) {
            QQToast.makeText(context, context.getString(R.string.b2g), 0).show();
            a1(qQAppInterface, emoticon);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "2", emoticon.epId, emoticon.eId, NetworkUtil.getNetworkType(context) + "", "", "", "", "");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendEmosmMsg emoticon Encrypt Key is null.name:");
            String str = emoticon.name;
            String str2 = "~";
            if (str == null) {
                str = "~";
            }
            sb5.append(str);
            sb5.append(", epid_eid:");
            String str3 = emoticon.epId;
            if (str3 == null) {
                str3 = "~";
            }
            sb5.append(str3);
            sb5.append("_");
            String str4 = emoticon.eId;
            if (str4 != null) {
                str2 = str4;
            }
            sb5.append(str2);
            QLog.e("ChatActivityFacade", 1, sb5.toString());
            return;
        }
        ThreadManagerV2.post(new Runnable(emoticon, context, pVar, i3) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.15
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Emoticon f175082e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f175083f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.activity.aio.p f175084h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f175085i;

            {
                this.f175082e = emoticon;
                this.f175083f = context;
                this.f175084h = pVar;
                this.f175085i = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, emoticon, context, pVar, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) QQAppInterface.this.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(this.f175082e.epId);
                if (syncFindEmoticonPackageById == null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("sendEmosmMsg ePackage == null name:");
                    String str5 = this.f175082e.name;
                    String str6 = "~";
                    if (str5 == null) {
                        str5 = "~";
                    }
                    sb6.append(str5);
                    sb6.append(", epid_eid:");
                    String str7 = this.f175082e.epId;
                    if (str7 == null) {
                        str7 = "~";
                    }
                    sb6.append(str7);
                    sb6.append("_");
                    String str8 = this.f175082e.eId;
                    if (str8 != null) {
                        str6 = str8;
                    }
                    sb6.append(str6);
                    QLog.e("ChatActivityFacade", 1, sb6.toString());
                    Emoticon emoticon2 = this.f175082e;
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "3", emoticon2.epId, emoticon2.eId, NetworkUtil.getNetworkType(this.f175083f) + "", "", "", "", "");
                    return;
                }
                MarkFaceMessage g06 = ChatActivityFacade.g0(QQAppInterface.this, syncFindEmoticonPackageById, this.f175082e);
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                com.tencent.mobileqq.activity.aio.p pVar2 = this.f175084h;
                MessageForMarketFace x16 = com.tencent.mobileqq.service.message.q.x(qQAppInterface2, pVar2.f179557e, pVar2.f179559f, pVar2.f179555d, g06);
                if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityFacade", 2, "diversionRunnable, epId = " + syncFindEmoticonPackageById.epId + " ePackage.copywritingType = " + syncFindEmoticonPackageById.copywritingType + " currentTime = " + System.currentTimeMillis());
                }
                ThreadManager.getUIHandler().post(new Runnable(x16, syncFindEmoticonPackageById) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.15.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageForMarketFace f175086d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ EmoticonPackage f175087e;

                    {
                        this.f175086d = x16;
                        this.f175087e = syncFindEmoticonPackageById;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass15.this, x16, syncFindEmoticonPackageById);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> keywordsByEmoticon;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        MessageForMarketFace messageForMarketFace = this.f175086d;
                        AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                        messageForMarketFace.sendFaceName = anonymousClass15.f175082e.name;
                        messageForMarketFace.msgVia = anonymousClass15.f175084h.P;
                        if (messageForMarketFace.istroop == 1) {
                            com.tencent.biz.anonymous.a.h().a(this.f175086d);
                        } else if (com.tencent.biz.anonymous.a.h().f78364c) {
                            com.tencent.biz.anonymous.a.h().f78364c = false;
                        }
                        if (com.tencent.imcore.message.ao.c(AnonymousClass15.this.f175084h.f179555d) == 1032) {
                            AnonymousClass15 anonymousClass152 = AnonymousClass15.this;
                            QQAppInterface qQAppInterface3 = QQAppInterface.this;
                            MessageForMarketFace messageForMarketFace2 = this.f175086d;
                            com.tencent.mobileqq.activity.aio.p pVar3 = anonymousClass152.f175084h;
                            ConfessMsgUtil.d(qQAppInterface3, messageForMarketFace2, pVar3.f179557e, pVar3.f179555d, pVar3.S);
                        } else {
                            AnonymousClass15 anonymousClass153 = AnonymousClass15.this;
                            com.tencent.mobileqq.activity.aio.p pVar4 = anonymousClass153.f175084h;
                            if (pVar4.U) {
                                ConfessMsgUtil.c(QQAppInterface.this, this.f175086d, pVar4.f179557e);
                            } else if (pVar4.V) {
                                ConfessMsgUtil.e(QQAppInterface.this, this.f175086d, pVar4.f179557e);
                            }
                        }
                        AnonymousClass15 anonymousClass154 = AnonymousClass15.this;
                        if (anonymousClass154.f175084h.f179555d == 10007) {
                            QQAppInterface qQAppInterface4 = QQAppInterface.this;
                            MessageForMarketFace messageForMarketFace3 = this.f175086d;
                            com.tencent.mobileqq.gamecenter.util.c.b(qQAppInterface4, messageForMarketFace3, messageForMarketFace3.frienduin, messageForMarketFace3.istroop);
                        }
                        com.tencent.mobileqq.activity.aio.forward.b.d().e(this.f175086d.uniseq, 0L, AnonymousClass15.this.f175085i);
                        AnonymousClass15 anonymousClass155 = AnonymousClass15.this;
                        com.tencent.mobileqq.activity.aio.p pVar5 = anonymousClass155.f175084h;
                        if (pVar5.f179555d == 10014) {
                            QQAppInterface.this.getMessageFacade().a(this.f175086d, null);
                        } else {
                            com.tencent.mobileqq.forward.utils.f.f211079a.j(pVar5, this.f175086d);
                        }
                        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) QQAppInterface.this.getRuntimeService(IEmoticonManagerService.class);
                        if (iEmoticonManagerService != null && (keywordsByEmoticon = iEmoticonManagerService.getKeywordsByEmoticon(AnonymousClass15.this.f175082e)) != null && keywordsByEmoticon.size() > 0) {
                            for (String str9 : keywordsByEmoticon) {
                                if (!TextUtils.isEmpty(str9)) {
                                    RecentEmotion recentEmotion = new RecentEmotion();
                                    Emoticon emoticon3 = AnonymousClass15.this.f175082e;
                                    recentEmotion.epId = emoticon3.epId;
                                    recentEmotion.eId = emoticon3.eId;
                                    recentEmotion.keyword = str9.toLowerCase();
                                    recentEmotion.exposeNum = 0;
                                    iEmoticonManagerService.addRecentEmotionToCache(recentEmotion);
                                }
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.f175087e.epId + " ePackage.copywritingType = " + this.f175087e.copywritingType + " currentTime = " + System.currentTimeMillis());
                        }
                    }
                });
            }
        }, 5, null, false);
    }

    public static MessageForPtt J(QQAppInterface qQAppInterface, String str, com.tencent.mobileqq.activity.aio.p pVar, int i3, int i16) {
        int i17;
        if (!TextUtils.isEmpty(str) && pVar != null) {
            int i18 = pVar.f179555d;
            MessageForPtt r16 = com.tencent.mobileqq.service.message.q.r(qQAppInterface, pVar.f179557e, pVar.f179559f, i18);
            r16.url = MessageForPtt.getMsgFilePath(i16, str);
            r16.fileSize = i3;
            r16.itemType = 2;
            if (((ISttManagerApi) QRoute.api(ISttManagerApi.class)).isSttSession(i18) && ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).getSttAbility(qQAppInterface)) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            r16.sttAbility = i17;
            r16.voiceType = i16;
            r16.longPttVipFlag = com.tencent.mobileqq.utils.ff.n(qQAppInterface, qQAppInterface.getCurrentAccountUin());
            com.tencent.biz.anonymous.a.h().a(r16);
            int i19 = pVar.f179555d;
            if (i19 != 1033 && (i19 != 1034 || pVar.S <= 0)) {
                if (pVar.U) {
                    ConfessMsgUtil.c(qQAppInterface, r16, pVar.f179557e);
                } else if (pVar.V) {
                    ConfessMsgUtil.e(qQAppInterface, r16, pVar.f179557e);
                }
            } else {
                ConfessMsgUtil.d(qQAppInterface, r16, pVar.f179557e, i19, pVar.S);
            }
            r16.serial();
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(r16);
            return r16;
        }
        return null;
    }

    public static void J0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, String str, int i3) {
        if (str == null) {
            return;
        }
        com.tencent.mobileqq.utils.aw.m(-1L, pVar.f179555d, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            ChatActivityUtils.m0(context, R.string.cwe, 0);
            com.tencent.mobileqq.utils.aw.m(-1L, pVar.f179555d, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
            return;
        }
        v.a aVar = new v.a();
        aVar.v(str);
        aVar.m(i3);
        aVar.x(pVar.f179557e);
        aVar.y(0);
        aVar.A(pVar.f179559f);
        aVar.B(qQAppInterface.getCurrentAccountUin());
        aVar.I(pVar.f179555d);
        aVar.H(pVar.S);
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, i3);
        createPicReq.f(aVar.l());
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        ThreadManagerV2.post(new Runnable(str, pVar, qQAppInterface) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175067d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.activity.aio.p f175068e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f175069f;

            {
                this.f175067d = str;
                this.f175068e = pVar;
                this.f175069f = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, pVar, qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    try {
                        com.tencent.mobileqq.activity.photo.m.k(new String[]{this.f175067d}, this.f175068e.f179555d, false, false, -1, this.f175069f);
                    } catch (Exception unused) {
                    }
                }
            }
        }, 5, null, false);
    }

    public static MessageRecord K(QQAppInterface qQAppInterface, String str, SessionInfo sessionInfo, int i3, int i16) {
        MessageForPtt J = J(qQAppInterface, str, sessionInfo, i3, i16);
        if (J != null) {
            J.msgVia = sessionInfo.P;
            qQAppInterface.getMessageFacade().c(J, qQAppInterface.getCurrentAccountUin());
        } else if (QLog.isColorLevel()) {
            QLog.d("ChatActivityFacade", 2, "createPttMessage null");
        }
        return J;
    }

    public static void K0(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, String str) {
        M0(qQAppInterface, context, sessionInfo, str, null, new d());
    }

    public static void L(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        qQAppInterface.getMessageFacade().T1(chatMessage.frienduin, chatMessage.istroop, chatMessage.uniseq);
        if (chatMessage.isSendFromLocal()) {
            ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(chatMessage.frienduin, chatMessage.uniseq));
        }
    }

    public static void L0(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, String str, ArrayList<AtTroopMemberInfo> arrayList) {
        M0(qQAppInterface, context, sessionInfo, str, arrayList, new d());
    }

    public static void M(QQAppInterface qQAppInterface, Context context, List<String> list) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SINGLE_WAY_FRIEND_LIST, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (String str : list) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject.has("uin") && jSONObject.has("type") && jSONObject.getString("uin").equals(com.tencent.imcore.message.an.a(str))) {
                            List<MessageRecord> Q = qQAppInterface.getMessageFacade().Q(str, 0);
                            ChatActivityUtils.r(context, str, 0, AppConstants.Preferences.SINGLE_WAY_FRIEND_LIST);
                            for (MessageRecord messageRecord : Q) {
                                if (messageRecord.msgtype == -2019) {
                                    qQAppInterface.getMessageFacade().T1(str, messageRecord.istroop, messageRecord.uniseq);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static long[] M0(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar, String str, ArrayList<AtTroopMemberInfo> arrayList, d dVar) {
        return new long[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(QQAppInterface qQAppInterface, boolean z16, MessageRecord messageRecord) {
        try {
            if (z16) {
                qQAppInterface.getMessageFacade().k(messageRecord);
            } else {
                qQAppInterface.getMessageFacade().a(messageRecord, null);
            }
        } catch (Exception e16) {
            QLog.e("ChatActivityFacade", 1, "doSendMsg life circle:", e16);
        }
    }

    public static void N0(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo) {
        O0(qQAppInterface, context, sessionInfo, 1, -1, "", "", 0);
    }

    public static void O(QQAppInterface qQAppInterface, String str, MessageForPtt messageForPtt, boolean z16, int i3, int i16, boolean z17) {
        P(qQAppInterface, str, messageForPtt, z16, i3, i16, z17, null);
    }

    public static void O0(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, int i3, int i16, String str, String str2, int i17) {
        int i18;
        MessageForPoke messageForPoke = new MessageForPoke();
        messageForPoke.msgtype = MessageRecord.MSG_TYPE_POKE_MSG;
        messageForPoke.isPlayed = false;
        messageForPoke.interactType = i3;
        messageForPoke.subId = i16;
        messageForPoke.name = str;
        messageForPoke.minVersion = str2;
        messageForPoke.strength = ((IPokeSendHelper) QRoute.api(IPokeSendHelper.class)).getStrengthStatus(qQAppInterface, sessionInfo.f179557e, messageForPoke.interactType, -1);
        if (i17 == 3 || i17 == 4) {
            int i19 = messageForPoke.flag;
            if (i17 == 3) {
                i18 = 8;
            } else {
                i18 = 16;
            }
            messageForPoke.flag = i18 | i19;
            messageForPoke.isPlayed = true;
        }
        com.tencent.mobileqq.service.message.q.I(qQAppInterface, messageForPoke, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d);
        messageForPoke.initMsg();
        if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + messageForPoke.strength + "." + messageForPoke);
        }
        qQAppInterface.getMessageFacade().a(messageForPoke, null);
        if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "sendPokeMsg type:" + messageForPoke.interactType + "." + messageForPoke);
        }
    }

    public static void P(QQAppInterface qQAppInterface, String str, MessageForPtt messageForPtt, boolean z16, int i3, int i16, boolean z17, com.tencent.mobileqq.pic.c cVar) {
        Runnable runnable = new Runnable(qQAppInterface, str, z17, cVar, i3, i16) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int C;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f175062e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f175063f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f175064h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.pic.c f175065i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ int f175066m;

            {
                this.f175062e = qQAppInterface;
                this.f175063f = str;
                this.f175064h = z17;
                this.f175065i = cVar;
                this.f175066m = i3;
                this.C = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MessageForPtt.this, qQAppInterface, str, Boolean.valueOf(z17), cVar, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileTrans", 2, "downloadPtt istroop" + MessageForPtt.this.istroop + " itemType " + MessageForPtt.this.itemType + " uniseq:" + MessageForPtt.this.uniseq);
                }
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mSelfUin = this.f175062e.getAccount();
                transferRequest.mPeerUin = this.f175063f;
                MessageForPtt messageForPtt2 = MessageForPtt.this;
                transferRequest.mUinType = messageForPtt2.istroop;
                transferRequest.mFileType = 2;
                transferRequest.mUniseq = messageForPtt2.uniseq;
                boolean z18 = false;
                transferRequest.mIsUp = false;
                transferRequest.mServerPath = messageForPtt2.urlAtServer;
                transferRequest.mOutFilePath = messageForPtt2.getLocalFilePath();
                if (MessageForPtt.this.isSendFromOtherTerminal() || MessageForPtt.this.isSend()) {
                    z18 = true;
                }
                transferRequest.mIsSelfSend = z18;
                MessageForPtt messageForPtt3 = MessageForPtt.this;
                transferRequest.mMd5 = messageForPtt3.md5;
                transferRequest.mGroupFileID = messageForPtt3.groupFileID;
                transferRequest.mGroupFileKeyStr = messageForPtt3.groupFileKeyStr;
                transferRequest.mDbRecVersion = messageForPtt3.subVersion;
                transferRequest.mRec = messageForPtt3;
                transferRequest.mDownMode = this.f175064h ? 1 : 0;
                transferRequest.mDownCallBack = this.f175065i;
                transferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(this.f175066m, this.C);
                ((ITransFileController) this.f175062e.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
            }
        };
        if (z16) {
            runnable.run();
        } else {
            qQAppInterface.execute(runnable);
        }
    }

    public static void P0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, int i3, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        if (systemAndEmojiEmoticonInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityFacade", 1, "sendPopEmoMsg emoticonInfo is null");
                return;
            }
            return;
        }
        MessageForPokeEmo messageForPokeEmo = new MessageForPokeEmo();
        messageForPokeEmo.msgtype = MessageRecord.MSG_TYPE_POKE_EMO_MSG;
        messageForPokeEmo.isNeedPlayed = false;
        messageForPokeEmo.pokeemoId = 13;
        messageForPokeEmo.pokeemoPressCount = i3;
        messageForPokeEmo.emoIndex = QQSysFaceUtil.convertToServer(systemAndEmojiEmoticonInfo.code);
        String prueFaceDescription = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(systemAndEmojiEmoticonInfo.code));
        messageForPokeEmo.summary = prueFaceDescription;
        messageForPokeEmo.emoString = prueFaceDescription;
        messageForPokeEmo.emoCompat = prueFaceDescription;
        messageForPokeEmo.initMsg();
        com.tencent.mobileqq.service.message.q.I(qQAppInterface, messageForPokeEmo, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d);
        qQAppInterface.getMessageFacade().a(messageForPokeEmo, null);
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityFacade", 2, String.format(" sendPopEmoMsg.emoIndex = %d,count = %d,summary = %s", Integer.valueOf(messageForPokeEmo.emoIndex), Integer.valueOf(i3), prueFaceDescription));
        }
    }

    public static void Q(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, Intent intent, String str, ForwardFileInfo forwardFileInfo, boolean z16) {
        R(qQAppInterface, context, sessionInfo, intent, str, forwardFileInfo, z16, 0);
    }

    public static void Q0(QQAppInterface qQAppInterface, com.tencent.mobileqq.activity.aio.p pVar) {
        try {
            Long.valueOf(pVar.f179557e).longValue();
            long X = qQAppInterface.getMessageFacade().X(pVar.f179557e, pVar.f179555d);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", pVar.f179557e, Integer.valueOf(pVar.f179555d), Long.valueOf(X)));
            }
            int i3 = pVar.f179555d;
            if (i3 != 1036 && X != -1 && X != pVar.D) {
                pVar.D = X;
                qQAppInterface.getMsgHandler().getProcessor(ProcessorDispatcher.getProcessType(i3)).c(pVar.f179557e, pVar.f179555d, X);
            }
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 2, e16, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void R(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, Intent intent, String str, ForwardFileInfo forwardFileInfo, boolean z16, int i3) {
        int i16;
        FileManagerEntity fileManagerEntity;
        int i17;
        String str2;
        String str3;
        if (i3 <= 0 && forwardFileInfo != null) {
            i16 = forwardFileInfo.L;
        } else {
            i16 = i3;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ChatActivityFacade", 1, "forwardForFile");
        }
        if (ForwardUtils.A(intent, sessionInfo, str, qQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityFacade", 2, "handleForwardEditedPhoto = " + str);
                return;
            }
            return;
        }
        if (forwardFileInfo != null && forwardFileInfo.getType() == 10006 && (TextUtils.isEmpty(forwardFileInfo.l()) || ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).canUseMsgForwardOnTroopFile())) {
            W(qQAppInterface, context, sessionInfo, intent, str, forwardFileInfo, i3);
            return;
        }
        if (!intent.getBooleanExtra("isFromFavorites", false) && intent.getBooleanExtra("isFromShare", false)) {
            if (intent.getBooleanExtra("sendMultiple", false)) {
                return;
            }
            if (sessionInfo.f179555d == 1) {
                qQAppInterface.getNTFileManageBridger().X(str, sessionInfo.f179557e, 0L, i16);
                return;
            } else {
                qQAppInterface.getNTFileManageBridger().V(str, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, 0L, i16);
                return;
            }
        }
        if (!intent.getBooleanExtra("not_forward", false)) {
            return;
        }
        if (forwardFileInfo != null) {
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().M(forwardFileInfo.n());
            i17 = forwardFileInfo.getType();
        } else {
            fileManagerEntity = null;
            i17 = -1;
        }
        if (fileManagerEntity == null && (fileManagerEntity = QfavHelper.m(intent.getExtras(), sessionInfo.f179557e, sessionInfo.f179555d)) != null && forwardFileInfo != null) {
            forwardFileInfo.E(fileManagerEntity.nSessionId);
        }
        if (fileManagerEntity != null || forwardFileInfo == null || !QLog.isColorLevel()) {
            str2 = "not_forward";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("there has a Bug!,sissionId[");
            str2 = "not_forward";
            sb5.append(forwardFileInfo.n());
            sb5.append("]");
            QLog.e("ChatActivityFacade", 2, sb5.toString());
        }
        if (i17 != 10006) {
            if (i17 != 10013) {
                if (i17 != 10008) {
                    if (i17 != 10009) {
                        switch (i17) {
                            case 10001:
                            case 10004:
                                if (sessionInfo.f179555d == 1) {
                                    if (com.tencent.mobileqq.filemanager.util.q.f(forwardFileInfo.l())) {
                                        qQAppInterface.getFileManagerEngine().J0(forwardFileInfo.l(), sessionInfo.f179557e, 0L, i16);
                                        break;
                                    } else {
                                        FileManagerEntity D = qQAppInterface.getFileManagerDataCenter().D(forwardFileInfo.n());
                                        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                                        int i18 = sessionInfo.f179555d;
                                        if (i18 != 1004 && i18 != 1000) {
                                            str3 = currentAccountUin;
                                        } else {
                                            str3 = sessionInfo.f179559f;
                                        }
                                        if (D != null && D.peerType == 3000) {
                                            FileManagerEntity g06 = qQAppInterface.getFileManagerEngine().g0(D, str3, sessionInfo.f179557e, sessionInfo.f178172i0, D.peerType, false);
                                            g06.selfUin = D.peerUin;
                                            qQAppInterface.getFileManagerEngine().u(g06, 27);
                                            break;
                                        } else {
                                            qQAppInterface.getFileManagerEngine().E(forwardFileInfo.n(), sessionInfo.f179557e, i16);
                                            break;
                                        }
                                    }
                                } else {
                                    qQAppInterface.getFileManagerEngine().E0(forwardFileInfo.n(), sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, i16);
                                    break;
                                }
                            case 10002:
                                if (sessionInfo.f179555d == 1) {
                                    if (com.tencent.mobileqq.filemanager.util.q.f(forwardFileInfo.l())) {
                                        qQAppInterface.getFileManagerEngine().I0(forwardFileInfo.l(), sessionInfo.f179557e);
                                        break;
                                    } else {
                                        forwardFileInfo.n();
                                        FileManagerEntity D2 = qQAppInterface.getFileManagerDataCenter().D(forwardFileInfo.n());
                                        if (D2 != null && D2.peerType == 3000) {
                                            FileManagerEntity g07 = qQAppInterface.getFileManagerEngine().g0(D2, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, D2.peerType, false);
                                            g07.selfUin = D2.peerUin;
                                            qQAppInterface.getFileManagerEngine().v(g07, 27, forwardFileInfo.r(), i16);
                                            break;
                                        } else {
                                            qQAppInterface.getFileManagerEngine().z(3, forwardFileInfo.n(), sessionInfo.f179557e, forwardFileInfo.r(), i16);
                                            break;
                                        }
                                    }
                                } else {
                                    FileManagerEntity D3 = qQAppInterface.getFileManagerDataCenter().D(forwardFileInfo.n());
                                    if (D3 != null && D3.status == 16) {
                                        if (context != null) {
                                            FileManagerUtil.dealWithErrCode(context.getResources().getString(R.string.bet));
                                            return;
                                        }
                                        return;
                                    }
                                    String currentAccountUin2 = qQAppInterface.getCurrentAccountUin();
                                    int i19 = sessionInfo.f179555d;
                                    if (i19 == 1004 || i19 == 1000) {
                                        currentAccountUin2 = sessionInfo.f179559f;
                                    }
                                    String str4 = currentAccountUin2;
                                    if (D3 != null && D3.peerType == 3000) {
                                        FileManagerEntity h06 = qQAppInterface.getFileManagerEngine().h0(D3, str4, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, forwardFileInfo.r(), i16);
                                        h06.selfUin = D3.peerUin;
                                        int i26 = sessionInfo.f179555d;
                                        if (i26 != 0 && i26 != 1006 && i26 != 1004 && i26 != 1000 && i26 != 1001 && i26 != 10002 && i26 != 1006) {
                                            if (i26 == 3000) {
                                                h06.nOpType = 22;
                                                qQAppInterface.getFileManagerEngine().u(h06, 22);
                                            }
                                        } else {
                                            h06.nOpType = 21;
                                            qQAppInterface.getFileManagerEngine().u(h06, 21);
                                        }
                                        qQAppInterface.getFileManagerDataCenter().f0(h06);
                                        break;
                                    } else {
                                        String l3 = forwardFileInfo.l();
                                        if (com.tencent.mobileqq.filemanager.util.q.f(l3)) {
                                            qQAppInterface.getNTFileManageBridger().p0(l3, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, forwardFileInfo.r(), i16);
                                            break;
                                        } else if (com.tencent.mobileqq.filemanager.util.q.f(str)) {
                                            qQAppInterface.getNTFileManageBridger().p0(str, sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, forwardFileInfo.r(), i16);
                                            break;
                                        } else {
                                            FileManagerEntity h07 = qQAppInterface.getFileManagerEngine().h0(D3, str4, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, forwardFileInfo.r(), i16);
                                            if (sessionInfo.f179555d == 3000) {
                                                h07.nOpType = 28;
                                            }
                                            qQAppInterface.getFileManagerEngine().C(h07);
                                            qQAppInterface.getFileManagerDataCenter().f0(h07);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 10003:
                                qQAppInterface.getFileManagerEngine().Q0(qQAppInterface.getFileManagerDataCenter().D(forwardFileInfo.n()), sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, i16);
                                break;
                        }
                    } else {
                        int i27 = sessionInfo.f179555d;
                        if (i27 == 1) {
                            qQAppInterface.getFileManagerEngine().t(forwardFileInfo.n(), sessionInfo.f179557e);
                        } else if (i27 == 0) {
                            qQAppInterface.getFileManagerEngine().r(forwardFileInfo.n(), sessionInfo.f179557e);
                        } else if (i27 == 3000) {
                            qQAppInterface.getFileManagerEngine().s(forwardFileInfo.n(), sessionInfo.f179557e);
                        }
                    }
                }
            } else if (fileManagerEntity != null) {
                qQAppInterface.getFileManagerEngine().C0(fileManagerEntity, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, i16);
            }
            if (z16) {
                String str5 = str2;
                if (intent.getBooleanExtra(str5, false)) {
                    intent.removeExtra(str5);
                    intent.getExtras().remove(str5);
                    return;
                }
                return;
            }
            return;
        }
        if (sessionInfo.f179555d == 1) {
            qQAppInterface.getNTFileManageBridger().X(forwardFileInfo.l(), sessionInfo.f179557e, forwardFileInfo.r(), i16);
        } else {
            qQAppInterface.getNTFileManageBridger().V(forwardFileInfo.l(), sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f178172i0, sessionInfo.f179555d, true, forwardFileInfo.r(), i16);
        }
        if (z16) {
        }
    }

    public static void R0(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, Emoticon emoticon, StickerInfo stickerInfo) {
        if (emoticon == null) {
            QQToast.makeText(context, "emoticon is null.", 0).show();
            QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
            return;
        }
        int i3 = emoticon.jobType;
        if ((i3 == 0 || i3 == 2 || i3 == 4) && !emoticon.hasEncryptKey()) {
            QQToast.makeText(context, context.getString(R.string.b2g), 0).show();
            a1(qQAppInterface, emoticon);
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "2", emoticon.epId, emoticon.eId, NetworkUtil.getNetworkType(context) + "", "", "", "", "");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendEmosmMsg emoticon Encrypt Key is null.name:");
            String str = emoticon.name;
            String str2 = "~";
            if (str == null) {
                str = "~";
            }
            sb5.append(str);
            sb5.append(", epid_eid:");
            String str3 = emoticon.epId;
            if (str3 == null) {
                str3 = "~";
            }
            sb5.append(str3);
            sb5.append("_");
            String str4 = emoticon.eId;
            if (str4 != null) {
                str2 = str4;
            }
            sb5.append(str2);
            QLog.e("ChatActivityFacade", 1, sb5.toString());
            return;
        }
        ThreadManagerV2.post(new Runnable(emoticon, context, sessionInfo, stickerInfo) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.16
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Emoticon f175089e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f175090f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ SessionInfo f175091h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ StickerInfo f175092i;

            {
                this.f175089e = emoticon;
                this.f175090f = context;
                this.f175091h = sessionInfo;
                this.f175092i = stickerInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, emoticon, context, sessionInfo, stickerInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) QQAppInterface.this.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(this.f175089e.epId);
                if (syncFindEmoticonPackageById == null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("sendEmosmMsg ePackage == null name:");
                    String str5 = this.f175089e.name;
                    String str6 = "~";
                    if (str5 == null) {
                        str5 = "~";
                    }
                    sb6.append(str5);
                    sb6.append(", epid_eid:");
                    String str7 = this.f175089e.epId;
                    if (str7 == null) {
                        str7 = "~";
                    }
                    sb6.append(str7);
                    sb6.append("_");
                    String str8 = this.f175089e.eId;
                    if (str8 != null) {
                        str6 = str8;
                    }
                    sb6.append(str6);
                    QLog.e("ChatActivityFacade", 1, sb6.toString());
                    Emoticon emoticon2 = this.f175089e;
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "3", emoticon2.epId, emoticon2.eId, NetworkUtil.getNetworkType(this.f175090f) + "", "", "", "", "");
                    return;
                }
                MarkFaceMessage g06 = ChatActivityFacade.g0(QQAppInterface.this, syncFindEmoticonPackageById, this.f175089e);
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                SessionInfo sessionInfo2 = this.f175091h;
                MessageForMarketFace x16 = com.tencent.mobileqq.service.message.q.x(qQAppInterface2, sessionInfo2.f179557e, sessionInfo2.f179559f, sessionInfo2.f179555d, g06);
                StickerInfo stickerInfo2 = this.f175092i;
                if (stickerInfo2 != null) {
                    stickerInfo2.isShown = false;
                    EmojiStickerManager.z(x16, stickerInfo2);
                    EmojiStickerManager.k().s(x16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityFacade", 2, "stickerInfo = " + this.f175092i);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityFacade", 2, "diversionRunnable, epId = " + syncFindEmoticonPackageById.epId + " ePackage.copywritingType = " + syncFindEmoticonPackageById.copywritingType + " currentTime = " + System.currentTimeMillis());
                }
                ThreadManager.getUIHandler().post(new Runnable(x16, syncFindEmoticonPackageById) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.16.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageForMarketFace f175093d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ EmoticonPackage f175094e;

                    {
                        this.f175093d = x16;
                        this.f175094e = syncFindEmoticonPackageById;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass16.this, x16, syncFindEmoticonPackageById);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> keywordsByEmoticon;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        MessageForMarketFace messageForMarketFace = this.f175093d;
                        AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                        messageForMarketFace.sendFaceName = anonymousClass16.f175089e.name;
                        messageForMarketFace.msgVia = anonymousClass16.f175091h.P;
                        if (messageForMarketFace.istroop == 1) {
                            com.tencent.biz.anonymous.a.h().a(this.f175093d);
                        } else if (com.tencent.biz.anonymous.a.h().f78364c) {
                            com.tencent.biz.anonymous.a.h().f78364c = false;
                        }
                        if (com.tencent.imcore.message.ao.c(AnonymousClass16.this.f175091h.f179555d) == 1032) {
                            AnonymousClass16 anonymousClass162 = AnonymousClass16.this;
                            QQAppInterface qQAppInterface3 = QQAppInterface.this;
                            MessageForMarketFace messageForMarketFace2 = this.f175093d;
                            SessionInfo sessionInfo3 = anonymousClass162.f175091h;
                            ConfessMsgUtil.d(qQAppInterface3, messageForMarketFace2, sessionInfo3.f179557e, sessionInfo3.f179555d, sessionInfo3.S);
                        } else {
                            AnonymousClass16 anonymousClass163 = AnonymousClass16.this;
                            SessionInfo sessionInfo4 = anonymousClass163.f175091h;
                            if (sessionInfo4.U) {
                                ConfessMsgUtil.c(QQAppInterface.this, this.f175093d, sessionInfo4.f179557e);
                            } else if (sessionInfo4.V) {
                                ConfessMsgUtil.e(QQAppInterface.this, this.f175093d, sessionInfo4.f179557e);
                            }
                        }
                        AnonymousClass16 anonymousClass164 = AnonymousClass16.this;
                        if (anonymousClass164.f175091h.f179555d == 10007) {
                            QQAppInterface qQAppInterface4 = QQAppInterface.this;
                            MessageForMarketFace messageForMarketFace3 = this.f175093d;
                            com.tencent.mobileqq.gamecenter.util.c.b(qQAppInterface4, messageForMarketFace3, messageForMarketFace3.frienduin, messageForMarketFace3.istroop);
                        }
                        AnonymousClass16 anonymousClass165 = AnonymousClass16.this;
                        SessionInfo sessionInfo5 = anonymousClass165.f175091h;
                        if (sessionInfo5.f179555d == 10014) {
                            QQAppInterface.this.getMessageFacade().a(this.f175093d, null);
                        } else {
                            com.tencent.mobileqq.forward.utils.f.f211079a.j(sessionInfo5, this.f175093d);
                        }
                        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) QQAppInterface.this.getRuntimeService(IEmoticonManagerService.class);
                        if (iEmoticonManagerService != null && (keywordsByEmoticon = iEmoticonManagerService.getKeywordsByEmoticon(AnonymousClass16.this.f175089e)) != null && keywordsByEmoticon.size() > 0) {
                            for (String str9 : keywordsByEmoticon) {
                                if (!TextUtils.isEmpty(str9)) {
                                    RecentEmotion recentEmotion = new RecentEmotion();
                                    Emoticon emoticon3 = AnonymousClass16.this.f175089e;
                                    recentEmotion.epId = emoticon3.epId;
                                    recentEmotion.eId = emoticon3.eId;
                                    recentEmotion.keyword = str9.toLowerCase();
                                    recentEmotion.exposeNum = 0;
                                    iEmoticonManagerService.addRecentEmotionToCache(recentEmotion);
                                }
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.f175094e.epId + " ePackage.copywritingType = " + this.f175094e.copywritingType + " currentTime = " + System.currentTimeMillis());
                        }
                    }
                });
            }
        }, 5, null, false);
    }

    public static void S(Context context, QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Bundle bundle) {
        String string;
        int i3;
        String f16 = com.tencent.biz.common.util.j.f(str4, 45, "UTF-8", MiniBoxNoticeInfo.APPNAME_SUFFIX);
        String f17 = com.tencent.biz.common.util.j.f(str5, 90, "UTF-8", MiniBoxNoticeInfo.APPNAME_SUFFIX);
        if (!context.getResources().getString(R.string.dq8).equals(f16)) {
            string = context.getResources().getString(R.string.aei) + " " + f16;
        } else {
            string = context.getResources().getString(R.string.aei);
        }
        String str10 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + str + "&lon=" + str2 + "&title=" + f16 + "&loc=" + f17 + "&dpid=" + str6;
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(32).d(string).e("").b("plugin", "", str10, "", "").a();
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        c16.o("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", f16, f17);
        a16.addItem(c16);
        if (sessionInfo == null || !((i3 = sessionInfo.f179555d) == 1025 || i3 == 1024)) {
            if (sessionInfo != null) {
                if (bundle != null) {
                    a16.forwardID = bundle.getInt("KEY_MSG_FORWARD_ID");
                }
                if (q0(sessionInfo, f17, bundle)) {
                    D0(str10, sessionInfo, str, str2, f16, f17, a16, str7, str8, str9);
                    C0(qQAppInterface, sessionInfo, str, str2, f16, f17, a16, str7, str8, str9);
                    return;
                } else {
                    T0(str10, sessionInfo, a16);
                    S0(qQAppInterface, sessionInfo, a16);
                    return;
                }
            }
            return;
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        d16.init(qQAppInterface.getCurrentAccountUin(), sessionInfo.f179557e, qQAppInterface.getCurrentAccountUin(), l.f183340a + com.tencent.mobileqq.utils.bo.f307494a.a() + str + "," + str2 + "&iwloc=A&hl=zh-CN (" + f17 + ")", K0, -1000, sessionInfo.f179555d, K0);
        d16.issend = 1;
        qQAppInterface.getMessageFacade().a(d16, null);
    }

    private static void S0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, AbsShareMsg absShareMsg) {
        U0(qQAppInterface, sessionInfo, absShareMsg);
        com.tencent.mobileqq.ark.g.b(qQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_MAP_STRING, "");
    }

    private static void T0(String str, SessionInfo sessionInfo, AbsShareMsg absShareMsg) {
        int i3 = sessionInfo.f179555d;
    }

    public static long U(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        long j3;
        MessageForPtt messageForPtt = (MessageForPtt) K(qQAppInterface, str, sessionInfo, -3, 0);
        if (messageForPtt != null) {
            long j16 = messageForPtt.uniseq;
            if (j16 != -1) {
                int filePlayTime = ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(messageForPtt);
                int b16 = RecordParams.b(str);
                Bundle bundle = new Bundle();
                bundle.putInt("DiyTextId", messageForPtt.vipBubbleDiyTextId);
                j3 = j16;
                b1(qQAppInterface, sessionInfo.f179555d, sessionInfo.f179557e, str, j16, true, filePlayTime * 1000, b16, true, 0, 0, true, messageForPtt.vipSubBubbleId, bundle);
            } else {
                j3 = j16;
            }
            return j3;
        }
        return 0L;
    }

    public static void U0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, AbsStructMsg absStructMsg) {
        String str;
        int i3 = sessionInfo.f179555d;
        if (i3 != 1000 && i3 != 1004 && i3 != 1020) {
            str = qQAppInterface.getCurrentAccountUin();
        } else {
            str = sessionInfo.f179559f;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String str2 = sessionInfo.f179557e;
        int i16 = sessionInfo.f179555d;
        int i17 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i17 + 1;
        MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str2, str, i16, i17, absStructMsg);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, absStructMsg.parentUniseq, absStructMsg.forwardID);
        qQAppInterface.getMessageFacade().a(A, null);
    }

    public static void V(QQAppInterface qQAppInterface, SessionInfo sessionInfo, MessageForPic messageForPic, int i3) {
        if (qQAppInterface != null && sessionInfo != null && messageForPic != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", sessionInfo.f179557e);
            intent.putExtra("troop_uin", sessionInfo.f179559f);
            intent.putExtra("uintype", sessionInfo.f179555d);
            intent.putExtra(AppConstants.Key.FORWARD_UIN_TYPE, sessionInfo.f179555d);
            intent.putExtra(AppConstants.Key.SENDER_TROOP_UIN, sessionInfo.f179559f);
            intent.putExtra(AppConstants.Key.FORWARD_PEER_UIN, sessionInfo.f179557e);
            intent.putExtra(AppConstants.Key.FORWARD_SELF_UIN, qQAppInterface.getCurrentAccountUin());
            intent.putExtra(AppConstants.Key.FORWARD_IMAGE_WIDTH, messageForPic.width);
            intent.putExtra(AppConstants.Key.FORWARD_IMAGE_HEIGHT, messageForPic.height);
            intent.putExtra(AppConstants.Key.FORWARD_FILE_SIZE, messageForPic.size);
            intent.putExtra(AppConstants.Key.FORWARD_IMAGE_TYPE, messageForPic.imageType);
            intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, messageForPic.path);
            String str = messageForPic.frienduin + messageForPic.uniseq + messageForPic.istroop;
            intent.putExtra(AppConstants.Key.BUSI_TYPE, 1009);
            intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_TASK_KEY, str);
            intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN, messageForPic.frienduin);
            intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, messageForPic.istroop);
            intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH, messageForPic.uuid);
            intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, messageForPic.uniseq);
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_ISSEND, messageForPic.issend);
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_MD5, messageForPic.md5);
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_GROUP_FILEID, messageForPic.groupFileID);
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_FILE_SIZE_FLAG, messageForPic.fileSizeFlag);
            com.tencent.mobileqq.pic.l createForwardPicInfo = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(1009, intent);
            com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(3, 1009);
            createPicReq.e(createForwardPicInfo);
            createPicReq.H = messageForPic;
            createPicReq.E = messageForPic.picExtraData;
            messageForPic.forwardId.put(createPicReq, Integer.valueOf(i3));
            com.tencent.mobileqq.forward.utils.f.f211079a.l(sessionInfo, messageForPic.path);
            return;
        }
        QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).edit().putString(v(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_REQUEST_TROOP_QCIRCLE_MSG_ATTACHE_DATA), str).apply();
        }
    }

    public static void W(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, Intent intent, String str, ForwardFileInfo forwardFileInfo, int i3) {
        int i16;
        boolean booleanExtra = intent.getBooleanExtra("not_forward", false);
        boolean booleanExtra2 = intent.getBooleanExtra("support_multi_forward", false);
        if (!booleanExtra && !booleanExtra2) {
            return;
        }
        int i17 = forwardFileInfo.L;
        if (i17 <= 0) {
            i16 = i3;
        } else {
            i16 = i17;
        }
        qQAppInterface.getFileManagerEngine().H(forwardFileInfo.n(), forwardFileInfo.q(), forwardFileInfo.k(), Long.parseLong(sessionInfo.f179557e), sessionInfo.f178172i0, sessionInfo.f179555d, forwardFileInfo.j(), forwardFileInfo.r(), i16);
        if (intent.getBooleanExtra("not_forward", false)) {
            intent.removeExtra("not_forward");
            intent.getExtras().remove("not_forward");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).edit().putLong(v(qQAppInterface, sessionInfo, str), NetConnInfoCenter.getServerTimeMillis()).apply();
        }
    }

    public static void X(QQAppInterface qQAppInterface, SessionInfo sessionInfo, MessageForShortVideo messageForShortVideo) {
        if (qQAppInterface != null && messageForShortVideo != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", sessionInfo.f179557e);
            intent.putExtra("troop_uin", sessionInfo.f179559f);
            intent.putExtra("uintype", sessionInfo.f179555d);
            intent.putExtra(ShortVideoConstants.FROM_UIN, com.tencent.mobileqq.shortvideo.j.c(messageForShortVideo));
            intent.putExtra(ShortVideoConstants.FROM_UIN_TYPE, messageForShortVideo.istroop);
            intent.putExtra(ShortVideoConstants.FROM_SESSION_UIN, messageForShortVideo.frienduin);
            intent.putExtra(ShortVideoConstants.FROM_BUSI_TYPE, messageForShortVideo.busiType);
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, messageForShortVideo.videoFileSize);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, messageForShortVideo.videoFileTime);
            intent.putExtra("file_name", messageForShortVideo.videoFileName);
            intent.putExtra(ShortVideoConstants.FILE_FORMAT, messageForShortVideo.videoFileFormat);
            String findVideoPathIfExists = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
            int i3 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + findVideoPathIfExists + ",videoPath = " + findVideoPathIfExists + ", " + messageForShortVideo.toLogString());
            }
            intent.putExtra("file_send_path", findVideoPathIfExists);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg"));
            intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, messageForShortVideo.md5);
            if (!TextUtils.isEmpty(messageForShortVideo.mLocalMd5)) {
                intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_LOCAL_MD5, messageForShortVideo.mLocalMd5);
            }
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, messageForShortVideo.thumbWidth);
            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, messageForShortVideo.thumbHeight);
            intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, messageForShortVideo.thumbMD5);
            intent.putExtra(ShortVideoConstants.FILE_SOURCE, messageForShortVideo.fileSource);
            intent.putExtra(ShortVideoConstants.FILE_UUID, messageForShortVideo.uuid);
            intent.putExtra(ShortVideoConstants.FILE_THUMB_SIZE, messageForShortVideo.thumbFileSize);
            intent.putExtra(ShortVideoConstants.SUPPORT_PROGRESSIVE, messageForShortVideo.supportProgressive);
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, messageForShortVideo.fileWidth);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, messageForShortVideo.fileHeight);
            intent.putExtra(ShortVideoConstants.FROM_MSG_UNISEQ, messageForShortVideo.uniseq);
            int i16 = messageForShortVideo.busiType;
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = 3;
                } else {
                    i3 = 0;
                }
            }
            intent.putExtra(ShortVideoConstants.SPECIAL_VIDEO_TYPE, messageForShortVideo.specialVideoType);
            if (messageForShortVideo.checkIsHotVideo()) {
                intent.putExtra(ShortVideoConstants.HOT_VIDEO_ICON, messageForShortVideo.hotVideoIconUrl);
                intent.putExtra(ShortVideoConstants.HOT_VIDEO_ICON_SUB, messageForShortVideo.hotVideoSubIconUrl);
                intent.putExtra(ShortVideoConstants.HOT_VIDEO_TITLE, messageForShortVideo.hotVideoTitle);
                intent.putExtra(ShortVideoConstants.HOT_VIDEO_URL, messageForShortVideo.hotVideoUrl);
            }
            intent.putExtra(ShortVideoConstants.MSG_TAIL_TYPE, messageForShortVideo.msgTailType);
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, messageForShortVideo.templateId);
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, messageForShortVideo.templateName);
            com.tencent.mobileqq.shortvideo.v b16 = com.tencent.mobileqq.shortvideo.h.b(3, i3);
            com.tencent.mobileqq.shortvideo.p a16 = com.tencent.mobileqq.shortvideo.l.a(i3, intent, b16);
            if (a16 != null) {
                a16.f288045h = messageForShortVideo.uniseq;
                a16.I = messageForShortVideo.forwardID;
                b16.d(a16);
            }
            com.tencent.mobileqq.shortvideo.l.e(b16, qQAppInterface);
            return;
        }
        QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
    }

    private static void X0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, long j3) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            if (j3 > NetConnInfoCenter.getServerTimeMillis()) {
                QLog.e("ChatActivityFacade.QZoneFeeds", 2, String.format("\u5e16\u5b50\u521b\u5efa\u65f6\u95f4\uff1a%d,\u5f53\u524d\u53d6\u5f97\u670d\u52a1\u5668\u65f6\u95f4\uff1a%d", Long.valueOf(j3), Long.valueOf(NetConnInfoCenter.getServerTimeMillis())));
            } else {
                QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story\u5e16\u5b50\u521b\u5efa\u65f6\u95f4\uff1a%d", Long.valueOf(j3)));
                qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).edit().putLong(v(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_STORY_FEED_CREATE_TIME), j3).apply();
            }
        }
    }

    public static StructMsgForGeneralShare Y(Context context, MessageRecord messageRecord, String str) {
        String str2;
        String charSequence;
        String str3;
        if (messageRecord == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (messageRecord instanceof MessageForMixedMsg) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg) messageRecord));
            charSequence = h0(context, (int) (BaseChatItemLayout.N * 0.8f), 2, 30, sb5.toString()).toString();
        } else {
            int i3 = 50;
            if (messageRecord instanceof MessageForReplyText) {
                MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                CharSequence charSequence2 = messageForReplyText.charStr;
                if (charSequence2 != null) {
                    str3 = charSequence2.toString();
                } else {
                    str3 = messageForReplyText.f203106msg;
                }
                if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str3)) {
                    str3 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(str3);
                }
                if (!com.tencent.biz.anonymous.a.m(messageRecord)) {
                    i3 = 60;
                }
                charSequence = h0(context, (int) (BaseChatItemLayout.N * 0.8f), 2, i3, str3).toString();
            } else {
                MessageForLongTextMsg messageForLongTextMsg = (MessageForLongTextMsg) messageRecord;
                CharSequence charSequence3 = messageForLongTextMsg.charStr;
                if (charSequence3 != null) {
                    str2 = charSequence3.toString();
                } else {
                    str2 = messageForLongTextMsg.f203106msg;
                }
                if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str2)) {
                    str2 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(str2);
                }
                if (!com.tencent.biz.anonymous.a.m(messageRecord)) {
                    i3 = 60;
                }
                charSequence = h0(context, (int) (BaseChatItemLayout.N * 0.8f), 2, i3, str2).toString();
            }
        }
        arrayList.add(new StructMsgItemTitle(charSequence));
        if (charSequence.length() > 30) {
            charSequence = charSequence.substring(0, 30);
        }
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) new AbsShareMsg.a(StructMsgForGeneralShare.class).g(35).d(charSequence).f(3).b("viewMultiMsg", "", null, null, null).i(context.getString(R.string.a0y), null).e(context.getResources().getString(R.string.ce9)).a();
        com.tencent.mobileqq.structmsg.view.k kVar = new com.tencent.mobileqq.structmsg.view.k(arrayList);
        kVar.m(new com.tencent.mobileqq.structmsg.view.d());
        kVar.m(new com.tencent.mobileqq.structmsg.view.ap(HardCodeUtil.qqStr(R.string.f171711kc4)));
        structMsgForGeneralShare.addItem(kVar);
        return structMsgForGeneralShare;
    }

    public static JSONObject Y0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, FeedCloudMeta$StShare feedCloudMeta$StShare) {
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.kcm);
        PBStringField pBStringField = feedCloudMeta$StFeed.title;
        pBStringField.set(pBStringField.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", qqStr));
        PBStringField pBStringField2 = feedCloudMeta$StFeed.content;
        pBStringField2.set(pBStringField2.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", qqStr));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feedid", feedCloudMeta$StFeed.f398449id.get());
            jSONObject.put("fromuin", feedCloudMeta$StFeed.poster.f398463id.get());
            jSONObject.put("title", feedCloudMeta$StFeed.title.get());
            jSONObject.put("content", feedCloudMeta$StFeed.content.get());
            jSONObject.put("coverImageUrl", feedCloudMeta$StFeed.cover.picUrl.get());
            jSONObject.put("imageCount", feedCloudMeta$StFeed.images.size());
            jSONObject.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, feedCloudMeta$StFeed.likeInfo.count.get());
            jSONObject.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, feedCloudMeta$StFeed.video.vecVideoUrl.get().size());
            jSONObject.put("lbsinfo", feedCloudMeta$StFeed.poiInfo.get());
            jSONObject.put("time", feedCloudMeta$StFeed.createTime.get());
            jSONObject.put("type", feedCloudMeta$StFeed.type.get());
            if (feedCloudMeta$StShare != null) {
                jSONObject.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_CONTENT_JUMP_URL, feedCloudMeta$StShare.url.get());
            }
            jSONObject.put("version", 2);
            jSONObject.put("isFirstMsgWithNewFriend", z16);
            JSONArray jSONArray = new JSONArray();
            if (feedCloudMeta$StFeed.type.get() == 2) {
                for (FeedCloudMeta$StImage feedCloudMeta$StImage : feedCloudMeta$StFeed.images.get()) {
                    MessageForQCircleFeed.MediaData mediaData = new MessageForQCircleFeed.MediaData();
                    mediaData.mediaUrl = feedCloudMeta$StImage.picUrl.get();
                    mediaData.type = 2;
                    jSONArray.mo162put(mediaData.toJson());
                }
            } else {
                MessageForQCircleFeed.MediaData mediaData2 = new MessageForQCircleFeed.MediaData();
                mediaData2.mediaUrl = feedCloudMeta$StFeed.video.playUrl.get();
                mediaData2.type = 3;
                jSONArray.mo162put(mediaData2.toJson());
            }
            jSONObject.put("mediaDatas", jSONArray.toString());
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            jSONObject.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_PUSH_COUNT, qQCircleFeedBase$StFeedBusiReqData.pushList.totalClickCount.get());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static AbsShareMsg Z(Context context, String str, List<ChatMessage> list, Map<String, String> map, boolean z16) {
        int i3;
        String str2;
        String str3;
        boolean z17;
        boolean z18;
        String str4;
        String str5;
        AbsShareMsg absShareMsg = null;
        absShareMsg = null;
        absShareMsg = null;
        if (list != null && list.size() != 0 && map != null) {
            ArrayList<AbsStructMsgElement> arrayList = new ArrayList();
            int i16 = 4;
            int size = list.size() >= 4 ? 4 : list.size();
            String str6 = "";
            int i17 = 0;
            String str7 = "";
            for (int i18 = 0; i18 < size && i16 > 0; i18++) {
                StringBuilder sb5 = new StringBuilder();
                ChatMessage chatMessage = list.get(i18);
                if (z16) {
                    str5 = map.get(com.tencent.imcore.message.ad.k(chatMessage));
                    if (chatMessage.istroop == 1) {
                        str5 = com.tencent.mobileqq.text.TextUtils.removeColorNickCode(str5);
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList(map.values());
                    str5 = !arrayList2.isEmpty() ? (String) arrayList2.get(0) : "";
                }
                if (!TextUtils.isEmpty(str5) && str5.trim().length() != 0) {
                    if (str5.length() > 12) {
                        str5 = str5.substring(0, 11) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                } else {
                    str5 = com.tencent.mobileqq.multimsg.i.d(chatMessage.senderuin);
                }
                if (chatMessage instanceof MessageForPic) {
                    str7 = chatMessage.getSummaryMsg();
                } else if (chatMessage instanceof MessageForShortVideo) {
                    if (chatMessage.msgtype == -2071) {
                        str7 = HardCodeUtil.qqStr(R.string.kc8);
                    } else {
                        str7 = HardCodeUtil.qqStr(R.string.kcg);
                    }
                } else if (chatMessage instanceof MessageForText) {
                    MessageForText messageForText = (MessageForText) chatMessage;
                    CharSequence charSequence = messageForText.charStr;
                    if (charSequence != null) {
                        str7 = charSequence.toString();
                    } else {
                        str7 = messageForText.f203106msg;
                    }
                    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str7)) {
                        str7 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(str7);
                    }
                } else if (!(chatMessage instanceof MessageForMixedMsg) && !(chatMessage instanceof MessageForLongMsg)) {
                    if (chatMessage instanceof MessageForStructing) {
                        str7 = chatMessage.getSummaryMsg();
                    } else if (chatMessage instanceof MessageForArkApp) {
                        str7 = ((MessageForArkApp) chatMessage).getSummery();
                    } else if (chatMessage instanceof MessageForArkBabyqReply) {
                        str7 = ((MessageForArkBabyqReply) chatMessage).getSummery();
                    } else if (chatMessage instanceof MessageForArkFlashChat) {
                        str7 = ((MessageForArkFlashChat) chatMessage).getSummery();
                    } else if (chatMessage instanceof MessageForReplyText) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) chatMessage;
                        messageForReplyText.parse();
                        str7 = messageForReplyText.getSummaryMsg();
                    } else if (chatMessage instanceof MessageForFile) {
                        MessageForFile messageForFile = (MessageForFile) chatMessage;
                        if (!messageForFile.hasFileName()) {
                            FileManagerEntity fileManagerEntityByMsgFile = FileManagerUtil.getFileManagerEntityByMsgFile((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), messageForFile);
                            if (fileManagerEntityByMsgFile.nFileType == 5 && !TextUtils.isEmpty(fileManagerEntityByMsgFile.strApkPackageName)) {
                                messageForFile.fileName = fileManagerEntityByMsgFile.strApkPackageName;
                            } else {
                                messageForFile.fileName = fileManagerEntityByMsgFile.fileName;
                            }
                        }
                        str7 = messageForFile.getSummaryMsg();
                    } else if (chatMessage instanceof MessageForDLFile) {
                        str7 = ((MessageForDLFile) chatMessage).getSummaryMsg();
                    } else if (chatMessage instanceof MessageForTroopFile) {
                        str7 = ((MessageForTroopFile) chatMessage).getSummaryMsg();
                    } else if (chatMessage instanceof MessageForPtt) {
                        str7 = HardCodeUtil.qqStr(R.string.kco);
                    }
                } else {
                    str7 = MessageForMixedMsg.getTextFromMixedMsg(chatMessage).toString();
                }
                sb5.append(str5);
                sb5.append(":  ");
                sb5.append(str7);
                boolean[] zArr = new boolean[1];
                arrayList.add(new StructMsgItemTitle(i0(context, (int) (BaseChatItemLayout.N * 0.8f), 3, 46, sb5.toString(), zArr).toString()));
                i16--;
                if (zArr[0]) {
                    i16--;
                }
            }
            AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(35).d(HardCodeUtil.qqStr(R.string.kcn)).f(3).b("viewMultiMsg", "", null, null, null).i(context.getString(R.string.a0y), null).a();
            com.tencent.mobileqq.structmsg.view.k kVar = new com.tencent.mobileqq.structmsg.view.k();
            ChatMessage chatMessage2 = list.get(0);
            int i19 = chatMessage2.istroop;
            if (i19 == 1 || i19 == 3000) {
                i3 = 2;
                str2 = "MultiMsg_TAG";
                str6 = HardCodeUtil.qqStr(R.string.kc5);
            } else if (i19 == 0) {
                String str8 = chatMessage2.senderuin;
                if (TextUtils.equals(str8, chatMessage2.selfuin)) {
                    str3 = chatMessage2.frienduin;
                } else {
                    str3 = chatMessage2.selfuin;
                }
                String str9 = map.get(str8);
                String str10 = map.get(str3);
                while (true) {
                    if (i17 >= list.size()) {
                        z17 = true;
                        break;
                    }
                    ChatMessage chatMessage3 = list.get(i17);
                    if (TextUtils.isEmpty(str6)) {
                        str6 = chatMessage3.senderuin;
                    } else if (!TextUtils.equals(str6, chatMessage3.senderuin)) {
                        z17 = false;
                        break;
                    }
                    i17++;
                }
                if (str9 == null || str9.trim().length() == 0) {
                    QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
                    str9 = com.tencent.mobileqq.multimsg.i.d(chatMessage2.senderuin);
                }
                if ((str10 == null || str10.trim().length() == 0) && !z17) {
                    QLog.d("MultiMsg_TAG", 2, "!hasOnlyOneSender !!! empty nick for receiver");
                    str10 = com.tencent.mobileqq.multimsg.i.d(str3);
                }
                if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(chatMessage2.senderuin)) {
                    str4 = map.get(chatMessage2.selfuin);
                    z18 = true;
                } else {
                    z18 = z17;
                    str4 = str9;
                }
                Paint paint = new Paint();
                paint.setTextSize(34.0f);
                i3 = 2;
                str2 = "MultiMsg_TAG";
                str6 = u(context, str4, str10, 2, (int) (BaseChatItemLayout.N * 0.7f), 2048, paint, z18);
            } else {
                i3 = 2;
                str2 = "MultiMsg_TAG";
            }
            if (TextUtils.isEmpty(str6)) {
                QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
                str6 = HardCodeUtil.qqStr(R.string.kck);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[3];
                objArr[0] = str6;
                objArr[1] = Integer.valueOf(list.size());
                objArr[i3] = Integer.valueOf(chatMessage2.istroop);
                QLog.d("MultiMsg_TAG.Nest", i3, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", objArr));
            }
            StructMsgItemTitle structMsgItemTitle = new StructMsgItemTitle(str6);
            structMsgItemTitle.L(WadlProxyConsts.OPER_TYPE_MONITOR);
            structMsgItemTitle.H("12");
            structMsgItemTitle.I("2");
            kVar.m(structMsgItemTitle);
            for (AbsStructMsgElement absStructMsgElement : arrayList) {
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.b) {
                    com.tencent.mobileqq.structmsg.b bVar = (com.tencent.mobileqq.structmsg.b) absStructMsgElement;
                    bVar.L("26");
                    bVar.G("#777777");
                    bVar.H("12");
                    bVar.I("4");
                }
                kVar.m(absStructMsgElement);
            }
            kVar.m(new com.tencent.mobileqq.structmsg.view.d());
            com.tencent.mobileqq.structmsg.view.ap apVar = new com.tencent.mobileqq.structmsg.view.ap(String.format(HardCodeUtil.qqStr(R.string.f171709kc2), Integer.valueOf(list.size())));
            apVar.L("26");
            apVar.G("#777777");
            kVar.m(apVar);
            a16.addItem(kVar);
            a16.mTSum = list.size();
            absShareMsg = a16;
            if (QLog.isColorLevel()) {
                byte[] a17 = com.tencent.mobileqq.structmsg.k.a(a16.getXmlBytes());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("generateStructMsgLength = ");
                sb6.append(a17 == null ? 0 : a17.length);
                QLog.d(str2, i3, sb6.toString());
                absShareMsg = a16;
            }
        }
        return absShareMsg;
    }

    public static JSONObject Z0(NewestFeedInfo newestFeedInfo, boolean z16, int i3) {
        if (newestFeedInfo == null) {
            return null;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.kcm);
        newestFeedInfo.strTitle = newestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", qqStr);
        newestFeedInfo.strSummary = newestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", qqStr);
        newestFeedInfo.strContent = newestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", qqStr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", newestFeedInfo.uAppid);
            jSONObject.put("title", newestFeedInfo.strTitle);
            jSONObject.put("actionUrl", newestFeedInfo.strJmpUrl);
            jSONObject.put("content", newestFeedInfo.strContent);
            jSONObject.put("coverImageUrl", newestFeedInfo.strImgUrl);
            jSONObject.put("fromuin", newestFeedInfo.uHostUin);
            jSONObject.put("imageCount", newestFeedInfo.uImgCount);
            jSONObject.put("lbsinfo", newestFeedInfo.strLBSInfo);
            jSONObject.put("summery", newestFeedInfo.strSummary);
            jSONObject.put("time", newestFeedInfo.uTime);
            jSONObject.put("version", 2);
            jSONObject.put("likeNums", newestFeedInfo.uLikeNum);
            jSONObject.put("commentNums", newestFeedInfo.uCommentNum);
            jSONObject.put("isFirstMsgWithNewFriend", z16);
            jSONObject.put(MessageForQzoneFeed.MSG_QZONE_FEED_KEY_GENDER, i3);
            Map<String, String> map = newestFeedInfo.mapEx;
            if (map != null && !map.isEmpty()) {
                jSONObject.put("mapExt", new JSONObject(newestFeedInfo.mapEx).toString());
            }
            ArrayList<Media_Data> arrayList = newestFeedInfo.mediaData;
            if (arrayList != null && arrayList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Media_Data> it = newestFeedInfo.mediaData.iterator();
                while (it.hasNext()) {
                    Media_Data next = it.next();
                    MessageForQzoneFeed.MediaData mediaData = new MessageForQzoneFeed.MediaData();
                    mediaData.uType = next.uType;
                    mediaData.strImgUrl = next.strImgUrl;
                    mediaData.extendInfo = next.extendInfo;
                    jSONArray.mo162put(mediaData.toJson());
                }
                jSONObject.put("mediaDatas", jSONArray.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String a0(List<ChatMessage> list, Map<String, String> map) {
        String str;
        if (list != null && list.size() != 0 && map != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = 4;
            if (list.size() < 4) {
                i3 = list.size();
            }
            for (int i16 = 0; i16 < i3; i16++) {
                StringBuilder sb6 = new StringBuilder();
                ChatMessage chatMessage = list.get(i16);
                String str2 = map.get(com.tencent.imcore.message.ad.k(chatMessage));
                if (TextUtils.isEmpty(str2)) {
                    str2 = " ";
                }
                if (chatMessage instanceof MessageForPic) {
                    String qqStr = HardCodeUtil.qqStr(R.string.kcr);
                    sb6.append(str2);
                    sb6.append(MsgSummary.STR_COLON);
                    sb6.append(qqStr);
                    sb5.append(sb6.toString());
                    sb5.append("\r\n");
                } else if (chatMessage instanceof MessageForShortVideo) {
                    String qqStr2 = HardCodeUtil.qqStr(R.string.kcf);
                    sb6.append(str2);
                    sb6.append(MsgSummary.STR_COLON);
                    sb6.append(qqStr2);
                    sb5.append(sb6.toString());
                    sb5.append("\r\n");
                } else if (chatMessage instanceof MessageForText) {
                    MessageForText messageForText = (MessageForText) chatMessage;
                    CharSequence charSequence = messageForText.charStr;
                    if (charSequence != null) {
                        str = charSequence.toString();
                    } else {
                        str = messageForText.f203106msg;
                    }
                    sb6.append(str2);
                    sb6.append(MsgSummary.STR_COLON);
                    sb6.append(str);
                    String sb7 = sb6.toString();
                    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(sb7)) {
                        sb7 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(sb7);
                    }
                    if (sb7.length() > 16) {
                        sb5.append(sb7.substring(0, 16));
                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    } else {
                        sb5.append(sb7);
                    }
                    sb5.append("\r\n");
                } else if (!(chatMessage instanceof MessageForMixedMsg) && !(chatMessage instanceof MessageForLongMsg)) {
                    if (chatMessage instanceof MessageForStructing) {
                        String summaryMsg = chatMessage.getSummaryMsg();
                        sb6.append(str2);
                        sb6.append(MsgSummary.STR_COLON);
                        sb6.append(summaryMsg);
                        if (summaryMsg.length() > 16) {
                            sb5.append(summaryMsg.substring(0, 16));
                            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        } else {
                            sb5.append(summaryMsg);
                        }
                        sb5.append("\r\n");
                    }
                } else {
                    sb6.append(str2);
                    sb6.append(MsgSummary.STR_COLON);
                    sb6.append(MessageForMixedMsg.getTextFromMixedMsg(chatMessage));
                    String emoticonToText = com.tencent.mobileqq.text.TextUtils.emoticonToText(sb6.toString());
                    if (emoticonToText.length() > 16) {
                        sb5.append(emoticonToText.substring(0, 16));
                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    } else {
                        sb5.append(emoticonToText);
                    }
                    sb5.append("\r\n");
                }
            }
            return sb5.toString();
        }
        return null;
    }

    public static void a1(QQAppInterface qQAppInterface, Emoticon emoticon) {
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, app:" + qQAppInterface + ",e:" + emoticon);
        }
        if (qQAppInterface != null && emoticon != null && !TextUtils.isEmpty(emoticon.epId) && !TextUtils.isEmpty(emoticon.eId) && TextUtils.isEmpty(emoticon.encryptKey)) {
            ThreadManagerV2.post(new Runnable((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class), (IEmojiManagerService) qQAppInterface.getRuntimeService(IEmojiManagerService.class)) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.14
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ IEmoticonManagerService f175079e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ IEmojiManagerService f175080f;

                {
                    this.f175079e = r8;
                    this.f175080f = r9;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Emoticon.this, r8, r9);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Emoticon emoticon2 = Emoticon.this;
                    int i3 = emoticon2.jobType;
                    if (i3 == 0) {
                        ArrayList<Emoticon> arrayList = (ArrayList) this.f175079e.syncGetSubEmoticonsByPackageId(emoticon2.epId, true);
                        if (arrayList != null && arrayList.size() > 0) {
                            this.f175080f.fetchEmoticonEncryptKeys(Emoticon.this.epId, arrayList);
                            if (QLog.isColorLevel()) {
                                QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, try fetch normal emotion keys. epId:" + Emoticon.this.epId + ",cur emo id:" + Emoticon.this.eId);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i3 == 2 || i3 == 4) {
                        ArrayList<Emoticon> arrayList2 = new ArrayList<>();
                        arrayList2.add(Emoticon.this);
                        this.f175080f.fetchEmoticonEncryptKeys(Emoticon.this.epId, arrayList2);
                        if (QLog.isColorLevel()) {
                            QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, try fetch magic emotion key. epId:" + Emoticon.this.epId + ",cur emo id:" + Emoticon.this.eId);
                        }
                    }
                }
            }, 5, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b0(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface == null || qQAppInterface.getApp() == null || sessionInfo == null) {
            return "";
        }
        return qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).getString(v(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_REQUEST_TROOP_QCIRCLE_MSG_ATTACHE_DATA), "");
    }

    public static void b1(QQAppInterface qQAppInterface, int i3, String str, String str2, long j3, boolean z16, int i16, int i17, boolean z17, int i18, int i19, boolean z18, long j16, Bundle bundle) {
        if (!z17 && !o0(qQAppInterface, str, i3, j3) && !z16 && com.tencent.mobileqq.streamtransfile.b.s(str2) >= 1) {
            com.tencent.mobileqq.streamtransfile.b.c(str2, qQAppInterface, str, j3, i16, i17, j16, bundle);
            return;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = qQAppInterface.getAccount();
        transferRequest.mPeerUin = str;
        transferRequest.mUinType = i3;
        transferRequest.mFileType = 2;
        transferRequest.mUniseq = j3;
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str2;
        transferRequest.mBusiType = 1002;
        transferRequest.mPttCompressFinish = z18;
        transferRequest.mPttUploadPanel = i19;
        MessageRecord P = qQAppInterface.getMessageFacade().P(str, i3, j3);
        transferRequest.mRec = P;
        if (P instanceof MessageForPtt) {
            MessageForPtt messageForPtt = (MessageForPtt) P;
            messageForPtt.voiceType = i17;
            messageForPtt.voiceLength = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(i16);
            messageForPtt.voiceChangeFlag = i18;
            messageForPtt.sendFromvoiceChangePanelFlag = i19 == 4;
        }
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    private static long c0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        if (qQAppInterface == null || qQAppInterface.getApp() == null || sessionInfo == null) {
            return 0L;
        }
        return qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).getLong(v(qQAppInterface, sessionInfo, str), 0L);
    }

    public static void c1(QQAppInterface qQAppInterface, int i3, String str, String str2, long j3, boolean z16, int i16, int i17, boolean z17, int i18, int i19, boolean z18, long j16, Bundle bundle, ArrayList<AtTroopMemberInfo> arrayList, String str3, boolean z19, MessageRecord messageRecord, int i26) {
        MessageRecord messageRecord2;
        if (!z17 && !o0(qQAppInterface, str, i3, j3) && !z16 && com.tencent.mobileqq.streamtransfile.b.s(str2) >= 1) {
            com.tencent.mobileqq.streamtransfile.b.c(str2, qQAppInterface, str, j3, i16, i17, j16, bundle);
            return;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = qQAppInterface.getAccount();
        transferRequest.mPeerUin = str;
        transferRequest.mUinType = i3;
        transferRequest.mFileType = 2;
        transferRequest.mUniseq = j3;
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str2;
        transferRequest.mBusiType = 1002;
        transferRequest.mPttCompressFinish = z18;
        transferRequest.mPttUploadPanel = i19;
        if (messageRecord != null) {
            transferRequest.mRec = messageRecord;
        } else {
            transferRequest.mRec = qQAppInterface.getMessageFacade().P(str, i3, j3);
        }
        if (arrayList != null && arrayList.size() > 0 && z19 && (messageRecord2 = transferRequest.mRec) != null) {
            messageRecord2.atInfoList = arrayList;
            messageRecord2.mRobotFlag = 1;
            new com.tencent.mobileqq.statistics.q(qQAppInterface).i("dc00899").a("Grp_robot").f("send_msg").d("voice_msg_suc").b(str, String.valueOf(arrayList.get(0).uin)).g();
        }
        MessageRecord messageRecord3 = transferRequest.mRec;
        if (messageRecord3 instanceof MessageForPtt) {
            MessageForPtt messageForPtt = (MessageForPtt) messageRecord3;
            messageForPtt.voiceType = i17;
            messageForPtt.voiceLength = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(i16);
            messageForPtt.voiceChangeFlag = i18;
            messageForPtt.mInputContent = str3;
            messageForPtt.autoToText = i26;
            messageForPtt.sendFromvoiceChangePanelFlag = i19 == 4;
        }
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    private static long d0(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        List<MessageRecord> D = qQAppInterface.getMessageFacade().D(sessionInfo.f179557e, 0, new int[]{MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED});
        if (D != null && D.size() > 0) {
            MessageRecord messageRecord = D.get(0);
            if (messageRecord != null && (messageRecord instanceof MessageForQzoneFeed)) {
                MessageForQzoneFeed messageForQzoneFeed = (MessageForQzoneFeed) messageRecord;
                messageForQzoneFeed.parse();
                if (QLog.isColorLevel()) {
                    QLog.w("ChatActivityFacade.QZoneFeeds", 2, "\u83b7\u53d6\u5230\u6700\u65b0\u7a7a\u95f4feeds\u7684\uff1a" + String.valueOf(messageRecord) + "\uff1afeeds json:" + messageForQzoneFeed.feedMsg);
                }
                return messageForQzoneFeed.feedTime;
            }
            if (QLog.isColorLevel()) {
                QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message record \u6709\u8bef:" + String.valueOf(messageRecord));
                return 0L;
            }
            return 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message recode \u4e3a\u7a7a\uff0c\u65e0\u6cd5\u83b7\u53d6\u53d1\u5e03\u65f6\u95f4");
            return 0L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long e0(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        long j3;
        long j16;
        MessageForQzoneFeed messageForQzoneFeed;
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
        }
        BeancurdMsg d16 = ((com.tencent.mobileqq.activity.aio.q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).d(sessionInfo.f179557e, sessionInfo.f179555d, 12);
        if (d16 != null) {
            try {
                j3 = new JSONObject(d16.buffer).optLong("time", 0L);
            } catch (JSONException e16) {
                QLog.e("ChatActivityFacade.QZoneFeeds", 1, "", e16);
                j3 = 0;
            }
        } else {
            List<MessageRecord> D = qQAppInterface.getMessageFacade().D(sessionInfo.f179557e, 0, new int[]{MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED});
            if (D != null && D.size() > 0 && (messageForQzoneFeed = (MessageForQzoneFeed) D.get(D.size() - 1)) != null) {
                messageForQzoneFeed.parse();
                j16 = messageForQzoneFeed.feedTime;
            } else {
                j16 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   \u6ca1\u6709qzone\u5386\u53f2\u8c46\u8150\u5757,sessionInfo.curFriendUin=" + sessionInfo.f179557e + ",sessionInfo.curType=" + sessionInfo.f179555d + " busiID=2");
            }
            j3 = j16;
        }
        if (j3 == 0) {
            return d0(qQAppInterface, sessionInfo);
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f0(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface == null || qQAppInterface.getApp() == null || sessionInfo == null) {
            return 0L;
        }
        return qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).getLong(v(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_STORY_FEED_CREATE_TIME), 0L);
    }

    @NonNull
    public static MarkFaceMessage g0(QQAppInterface qQAppInterface, EmoticonPackage emoticonPackage, Emoticon emoticon) {
        boolean z16;
        int i3;
        String str;
        MarkFaceMessage markFaceMessage = new MarkFaceMessage();
        if (r0(qQAppInterface, emoticon.epId)) {
            markFaceMessage.isReword = true;
        }
        markFaceMessage.cSubType = emoticonPackage.type;
        markFaceMessage.sbufID = com.tencent.mobileqq.emosm.e.i(emoticon.eId, emoticon.jobType);
        markFaceMessage.dwTabID = Integer.valueOf(emoticon.epId).intValue();
        markFaceMessage.sbfKey = emoticon.encryptKey.getBytes();
        markFaceMessage.imageWidth = emoticon.width;
        markFaceMessage.imageHeight = emoticon.height;
        markFaceMessage.faceName = emoticon.name;
        if (emoticonPackage.isAPNG == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        markFaceMessage.isAPNG = z16;
        if (emoticon.isSound) {
            markFaceMessage.mediaType = 1;
        }
        int i16 = emoticon.jobType;
        if (i16 == 1) {
            markFaceMessage.mediaType = 2;
        } else if (i16 == 4) {
            markFaceMessage.mediaType = 3;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivityFacade", 2, "sendEmosmMsg epid = :" + emoticon.epId + ",eid = :" + emoticon.eId + ";type = " + emoticonPackage.type + ";jobtype = " + emoticon.jobType + ";mfm.mediatype = " + markFaceMessage.mediaType);
        }
        int i17 = emoticonPackage.type;
        if (1 == i17 || 4 == i17) {
            markFaceMessage.cSubType = 3;
        }
        if (emoticon.jobType == 2 && (str = emoticon.magicValue) != null) {
            markFaceMessage.mobileparam = str.getBytes();
        }
        markFaceMessage.voicePrintItems = emoticon.parseSoundPrintString();
        markFaceMessage.backColor = emoticon.backColor;
        markFaceMessage.volumeColor = emoticon.volumeColor;
        ICommercialDrainageManagerService iCommercialDrainageManagerService = (ICommercialDrainageManagerService) qQAppInterface.getRuntimeService(ICommercialDrainageManagerService.class);
        MarketFaceExtPb$ResvAttr marketFaceExtPb$ResvAttr = new MarketFaceExtPb$ResvAttr();
        PBUInt32Field pBUInt32Field = marketFaceExtPb$ResvAttr.uint32_emoji_type;
        if (markFaceMessage.isAPNG) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        pBUInt32Field.set(i3);
        if (emoticonPackage.endTime == 0 && emoticonPackage.beginTime == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade", 2, "sendEmosmMsg, endTime and beginTime = 0, set tiem = " + currentTimeMillis);
            }
            emoticonPackage.beginTime = currentTimeMillis;
            emoticonPackage.endTime = currentTimeMillis;
        }
        boolean isIPSite = iCommercialDrainageManagerService.isIPSite(emoticonPackage);
        boolean isIPSite2 = iCommercialDrainageManagerService.isIPSite(emoticon);
        if (emoticonPackage.copywritingType != com.tencent.mobileqq.model.a.f247232b || isIPSite || isIPSite2) {
            if (isIPSite) {
                markFaceMessage.copywritingType = com.tencent.mobileqq.model.a.f247237g;
                markFaceMessage.copywritingContent = emoticonPackage.ipName;
                markFaceMessage.jumpUrl = emoticonPackage.ipJumpUrl;
                markFaceMessage.beginTime = emoticonPackage.beginTime;
                markFaceMessage.endTime = emoticonPackage.endTime;
                markFaceMessage.from = HardCodeUtil.qqStr(R.string.kci);
            } else if (isIPSite2) {
                markFaceMessage.copywritingType = com.tencent.mobileqq.model.a.f247237g;
                markFaceMessage.copywritingContent = emoticon.ipsiteName;
                markFaceMessage.jumpUrl = emoticon.ipsiteUrl;
                markFaceMessage.beginTime = emoticonPackage.beginTime;
                markFaceMessage.endTime = emoticonPackage.endTime;
                markFaceMessage.from = HardCodeUtil.qqStr(R.string.kcs);
            } else if (!iCommercialDrainageManagerService.shouldHiden(emoticonPackage)) {
                markFaceMessage.copywritingType = emoticonPackage.copywritingType;
                markFaceMessage.copywritingContent = emoticonPackage.diversionName;
                markFaceMessage.jumpUrl = emoticonPackage.jumpUrl;
                markFaceMessage.beginTime = emoticonPackage.beginTime;
                markFaceMessage.endTime = emoticonPackage.endTime;
                markFaceMessage.from = emoticonPackage.comeFom;
            }
            boolean z17 = emoticonPackage.hasIpProduct;
            markFaceMessage.hasIpProduct = z17;
            marketFaceExtPb$ResvAttr.uint32_has_ip_product.set(z17 ? 1 : 0);
            marketFaceExtPb$ResvAttr.uint32_source_type.set(markFaceMessage.copywritingType);
            marketFaceExtPb$ResvAttr.uint32_start_time.set((int) markFaceMessage.beginTime);
            marketFaceExtPb$ResvAttr.uint32_end_time.set((int) markFaceMessage.endTime);
            if (!TextUtils.isEmpty(markFaceMessage.from)) {
                marketFaceExtPb$ResvAttr.str_source_type_name.set(markFaceMessage.from);
            }
            if (!TextUtils.isEmpty(markFaceMessage.copywritingContent)) {
                marketFaceExtPb$ResvAttr.str_source_name.set(markFaceMessage.copywritingContent);
            }
            if (!TextUtils.isEmpty(markFaceMessage.jumpUrl)) {
                marketFaceExtPb$ResvAttr.str_source_jump_url.set(markFaceMessage.jumpUrl);
            }
        }
        List<Integer> list = markFaceMessage.voicePrintItems;
        if (list != null && !list.isEmpty()) {
            marketFaceExtPb$ResvAttr.uint32_voice_item_height_arr.set(markFaceMessage.voicePrintItems);
        }
        if (!TextUtils.isEmpty(markFaceMessage.backColor)) {
            marketFaceExtPb$ResvAttr.str_back_color.set(markFaceMessage.backColor);
        }
        if (!TextUtils.isEmpty(markFaceMessage.volumeColor)) {
            marketFaceExtPb$ResvAttr.str_volume_color.set(markFaceMessage.volumeColor);
        }
        ArrayList<MarketFaceSupportSize> e16 = com.tencent.qqnt.emotion.utils.a.e(emoticonPackage.supportSize);
        markFaceMessage.supportSize = e16;
        markFaceMessage.apngSupportSize = e16;
        markFaceMessage.resvAttr = marketFaceExtPb$ResvAttr.toByteArray();
        if (markFaceMessage.copywritingType != com.tencent.mobileqq.model.a.f247232b) {
            int showCount = iCommercialDrainageManagerService.getShowCount((int) com.tencent.mobileqq.service.message.e.K0(), emoticonPackage.epId, markFaceMessage.copywritingContent, markFaceMessage.copywritingType);
            if (showCount == 0) {
                markFaceMessage.shouldDisplay = true;
            } else if (showCount == 1 && markFaceMessage.hasIpProduct) {
                markFaceMessage.shouldDisplay = true;
                markFaceMessage.showIpProduct = true;
                markFaceMessage.from = com.tencent.mobileqq.model.a.f247239i;
                markFaceMessage.copywritingContent = com.tencent.mobileqq.model.a.f247240j;
            } else {
                markFaceMessage.shouldDisplay = false;
            }
        }
        return markFaceMessage;
    }

    private static CharSequence h0(Context context, int i3, int i16, int i17, CharSequence charSequence) {
        return i0(context, i3, i16, i17, charSequence, null);
    }

    private static CharSequence i0(Context context, int i3, int i16, int i17, CharSequence charSequence, boolean[] zArr) {
        int i18 = i16 * i3;
        Resources resources = context.getResources();
        TextPaint textPaint = new TextPaint(1);
        textPaint.density = resources.getDisplayMetrics().density;
        int length = charSequence.length();
        int i19 = 0;
        while (true) {
            if (i19 >= length) {
                break;
            }
            int i26 = i19 + 1;
            float desiredWidth = Layout.getDesiredWidth(charSequence, 0, i26, textPaint);
            if (desiredWidth > i3 && zArr != null && zArr.length > 0) {
                zArr[0] = true;
            }
            if (desiredWidth > i18) {
                i19--;
                break;
            }
            i19 = i26;
        }
        if (i19 >= length && i19 <= i17) {
            return charSequence;
        }
        if (i19 <= i17) {
            i17 = i19;
        }
        return charSequence.subSequence(0, i17).toString() + "\u2026";
    }

    public static void j0(QQAppInterface qQAppInterface, String str) {
        try {
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).X2(Long.valueOf(str).longValue());
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade", 2, "insertCommonHobbyIfNeeded uin is: " + str);
            }
        }
    }

    private static boolean k0(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f179555d;
        if (i3 == 0 || i3 == 3000 || i3 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, boolean z16) {
        if (qQAppInterface == null || sessionInfo == null || QZoneHelper.disableAioStoryFeedReq()) {
            return false;
        }
        if (z16) {
            return y(qQAppInterface, sessionInfo);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, boolean z16) {
        if (qQAppInterface == null || sessionInfo == null) {
            return false;
        }
        if (QZoneHelper.hideAioFeeds()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns \u4e0b\u53d1\u914d\u7f6e \u8981\u9690\u85cfaio feeds\uff0c\u6240\u4ee5\u4e5f\u4e0d\u53d1\u8bf7\u6c42\u4e86");
            }
            return false;
        }
        if (z16) {
            return w(qQAppInterface, sessionInfo);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, boolean z16) {
        if (qQAppInterface == null || sessionInfo == null) {
            return false;
        }
        if (!p0()) {
            QLog.i("ChatActivityFacade.QCircleFeeds", 2, "isNeedInsertQCircleNewestFeeds==false: \u975e\u5c0f\u4e16\u754c\u7070\u5ea6\u7528\u6237");
            return false;
        }
        if (!QZoneHelper.showAioQCircleFeeds()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QCircleFeeds", 2, "wns \u4e0b\u53d1\u914d\u7f6e \u8981\u9690\u85cfaio qcircle feeds\uff0c\u6240\u4ee5\u4e5f\u4e0d\u53d1\u8bf7\u6c42\u4e86");
            }
            return false;
        }
        if (z16) {
            return x(qQAppInterface, sessionInfo);
        }
        return true;
    }

    private static boolean o0(QQAppInterface qQAppInterface, String str, int i3, long j3) {
        MessageRecord P = qQAppInterface.getMessageFacade().P(str, i3, j3);
        if (P != null && (P instanceof MessageForPtt)) {
            return ((MessageForPtt) P).c2cViaOffline;
        }
        return false;
    }

    private static boolean p0() {
        if (!uq3.c.x6(StudyModeManager.t()) && !uq3.c.M6()) {
            return false;
        }
        return true;
    }

    private static boolean q0(SessionInfo sessionInfo, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && !str.equals("Unknown Address")) {
            if (bundle != null) {
                if (bundle.getInt("isArk") == 0) {
                    com.tencent.mobileqq.ark.d.d("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
                    return false;
                }
                if (k0(sessionInfo)) {
                    com.tencent.mobileqq.ark.d.d("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
                    return true;
                }
                com.tencent.mobileqq.ark.d.d("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
                return false;
            }
            com.tencent.mobileqq.ark.d.d("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
            return false;
        }
        com.tencent.mobileqq.ark.d.d("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(QQAppInterface qQAppInterface, SessionInfo sessionInfo, FeedCloudRead$StGetC2CFeedRsp feedCloudRead$StGetC2CFeedRsp, boolean z16) {
        if (feedCloudRead$StGetC2CFeedRsp != null && !feedCloudRead$StGetC2CFeedRsp.vecFeed.isEmpty()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCloudRead$StGetC2CFeedRsp.vecFeed.get().get(0);
            if (feedCloudMeta$StFeed == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 feed == null");
                    return;
                }
                return;
            }
            JSONObject Y0 = Y0(feedCloudMeta$StFeed, z16, feedCloudRead$StGetC2CFeedRsp.share);
            if (Y0 == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "jsonOb == null");
                    return;
                }
                return;
            }
            ThreadManager.getSubThreadHandler().post(new Runnable(sessionInfo, Y0, z16) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.7
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SessionInfo f175118e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ JSONObject f175119f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f175120h;

                {
                    this.f175118e = sessionInfo;
                    this.f175119f = Y0;
                    this.f175120h = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, sessionInfo, Y0, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ChatActivityFacade.n0(QQAppInterface.this, this.f175118e, false)) {
                        String optString = this.f175119f.optString("fromuin");
                        if (this.f175118e.f179557e.equals(optString)) {
                            QLog.i("ChatActivityFacade.QCircleFeeds", 1, "add new feeds publishTime:" + this.f175119f.optLong("time"));
                            if (this.f175120h) {
                                ((INewFriendService) QQAppInterface.this.getRuntimeService(INewFriendService.class)).insertFriendFeedForAIOShowNewsMsg(this.f175119f.toString(), optString);
                                return;
                            }
                            com.tencent.mobileqq.activity.aio.q qVar = (com.tencent.mobileqq.activity.aio.q) QQAppInterface.this.getManager(QQManagerFactory.BEANCURD_MANAGER);
                            BeancurdMsg beancurdMsg = new BeancurdMsg();
                            beancurdMsg.buffer = this.f175119f.toString();
                            beancurdMsg.busiid = 12;
                            beancurdMsg.frienduin = optString;
                            beancurdMsg.isNeedDelHistory = true;
                            beancurdMsg.startTime = com.tencent.mobileqq.service.message.e.K0();
                            beancurdMsg.validTime = JoinTimeType.SEVEN_DAY;
                            if (QLog.isColorLevel()) {
                                QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 receiveBeancurd:" + beancurdMsg);
                            }
                            qVar.l(beancurdMsg);
                            ReportController.o(null, "dc00898", "", this.f175118e.f179557e, "0X800B279", "0X800B279", 0, 0, "", "", "", "");
                            return;
                        }
                        QLog.e("ChatActivityFacade.QCircleFeeds", 1, "\u5f53\u524d\u83b7\u53d6\u5230\u7684feeds\u7684\u53d1\u8868\u4eba\u4e0d\u5339\u914d\uff0c\u5ffd\u7565\u4e0d\u63d2\u5165");
                    }
                }
            });
            return;
        }
        QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 \u6ca1\u6709\u62c9\u5230feeds\u4fe1\u606f");
    }

    @TargetApi(9)
    private static boolean r0(QQAppInterface qQAppInterface, String str) {
        EmoticonPackage syncFindEmoticonPackageById;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && (syncFindEmoticonPackageById = ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(str)) != null && (syncFindEmoticonPackageById.extraFlags & 1) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityFacade", 2, "isShowEmotionRewordTips epId = " + str);
            }
            SharedPreferences sharedPreferences = qQAppInterface.getApplication().getSharedPreferences(IPicEmoticonInfo.ORIGINAL_EMOTION_COUNT_SP_FILE_NAME + qQAppInterface.getCurrentAccountUin(), 0);
            int i3 = sharedPreferences.getInt(str, 0) + 1;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i3);
            edit.apply();
            if (i3 == 21) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(QQAppInterface qQAppInterface, SessionInfo sessionInfo, CLIENT$StGetUserNewestStoryRsp cLIENT$StGetUserNewestStoryRsp) {
        if (cLIENT$StGetUserNewestStoryRsp == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " rsp is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " hasNewStory:" + cLIENT$StGetUserNewestStoryRsp.hasNewStory.get());
        }
        if (cLIENT$StGetUserNewestStoryRsp.hasNewStory.get() == 1) {
            if (!cLIENT$StGetUserNewestStoryRsp.vecStoryFeed.isEmpty()) {
                META$StStoryFeed mETA$StStoryFeed = cLIENT$StGetUserNewestStoryRsp.vecStoryFeed.get(0);
                if (mETA$StStoryFeed == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "addQzoneStoryFeedMessage storyFeed == null");
                        return;
                    }
                    return;
                } else {
                    X0(qQAppInterface, sessionInfo, mETA$StStoryFeed.createTime.get());
                    ThreadManager.getSubThreadHandler().post(new Runnable(sessionInfo, mETA$StStoryFeed) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.8
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ SessionInfo f175122e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ META$StStoryFeed f175123f;

                        {
                            this.f175122e = sessionInfo;
                            this.f175123f = mETA$StStoryFeed;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, sessionInfo, mETA$StStoryFeed);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (ChatActivityFacade.l0(QQAppInterface.this, this.f175122e, false)) {
                                com.tencent.mobileqq.activity.aio.q qVar = (com.tencent.mobileqq.activity.aio.q) QQAppInterface.this.getManager(QQManagerFactory.BEANCURD_MANAGER);
                                BeancurdMsg beancurdMsg = new BeancurdMsg();
                                try {
                                    beancurdMsg.buffer = Base64.encodeToString(this.f175123f.toByteArray(), 0);
                                    beancurdMsg.busiid = 7;
                                    beancurdMsg.frienduin = this.f175122e.f179557e;
                                    beancurdMsg.isNeedDelHistory = true;
                                    beancurdMsg.ispush = true;
                                    beancurdMsg.startTime = com.tencent.mobileqq.service.message.e.K0();
                                    beancurdMsg.validTime = JoinTimeType.SEVEN_DAY;
                                    qVar.l(beancurdMsg);
                                } catch (Exception unused) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("ChatActivityFacade.byte encode to String", 2, "encode error");
                                    }
                                }
                            }
                        }
                    });
                    return;
                }
            }
            ThreadManager.getSubThreadHandler().post(new Runnable(sessionInfo) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.9
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SessionInfo f175125e;

                {
                    this.f175125e = sessionInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) sessionInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ChatActivityFacade.F(QQAppInterface.this, this.f175125e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s0(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (FeedsManager.isShowStatus(sessionInfo.f179557e)) {
            C(qQAppInterface, sessionInfo);
            E(qQAppInterface, sessionInfo);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(QQAppInterface qQAppInterface, SessionInfo sessionInfo, AIONewestFeedRsp aIONewestFeedRsp, boolean z16) {
        long j3;
        ArrayList<NewestFeedInfo> arrayList;
        int i3;
        NewestFeedInfo newestFeedInfo;
        if (qQAppInterface != null) {
            j3 = qQAppInterface.getLongAccountUin();
        } else {
            j3 = 0;
        }
        if (aIONewestFeedRsp != null && aIONewestFeedRsp.uOpuin == j3 && (arrayList = aIONewestFeedRsp.uFeedInfos) != null && !arrayList.isEmpty()) {
            Map<String, String> map = aIONewestFeedRsp.mapEx;
            if (map != null && map.containsKey(MessageForQzoneFeed.MSG_QZONE_FEED_KEY_GENDER)) {
                try {
                    i3 = Integer.parseInt(aIONewestFeedRsp.mapEx.get(MessageForQzoneFeed.MSG_QZONE_FEED_KEY_GENDER));
                } catch (Exception e16) {
                    QLog.e("ChatActivityFacade.QZoneFeeds", 1, "gender parse error:", e16);
                }
                newestFeedInfo = aIONewestFeedRsp.uFeedInfos.get(0);
                if (newestFeedInfo != null) {
                    QLog.e("ChatActivityFacade.QZoneFeeds", 1, "addQzoneFeedMessage feedInfo == null");
                    return;
                }
                boolean[] zArr = new boolean[1];
                long[] jArr = new long[1];
                String valueOf = String.valueOf(newestFeedInfo.uHostUin);
                if (FeedsManager.isShowStatus(valueOf)) {
                    jArr[0] = FeedsManager.getToken(valueOf);
                    zArr[0] = true;
                    FeedsManager.hideStatus(valueOf);
                }
                JSONObject Z0 = Z0(newestFeedInfo, z16, i3);
                if (Z0 == null) {
                    QLog.e("ChatActivityFacade.QZoneFeeds", 1, "jsonOb == null");
                    return;
                } else {
                    ThreadManager.getSubThreadHandler().post(new Runnable(sessionInfo, Z0, z16, zArr, jArr) { // from class: com.tencent.mobileqq.activity.ChatActivityFacade.6
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ SessionInfo f175112e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ JSONObject f175113f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ boolean f175114h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ boolean[] f175115i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ long[] f175116m;

                        {
                            this.f175112e = sessionInfo;
                            this.f175113f = Z0;
                            this.f175114h = z16;
                            this.f175115i = zArr;
                            this.f175116m = jArr;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, sessionInfo, Z0, Boolean.valueOf(z16), zArr, jArr);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (ChatActivityFacade.m0(QQAppInterface.this, this.f175112e, false)) {
                                long optLong = this.f175113f.optLong("fromuin");
                                if (String.valueOf(optLong).equals(this.f175112e.f179557e)) {
                                    QLog.i("ChatActivityFacade.QZoneFeeds", 1, "add new feeds publishTime:" + this.f175113f.optLong("time"));
                                    if (this.f175114h) {
                                        ((INewFriendService) QQAppInterface.this.getRuntimeService(INewFriendService.class)).insertFriendFeedForAIOShowNewsMsg(this.f175113f.toString(), String.valueOf(optLong));
                                        return;
                                    }
                                    com.tencent.mobileqq.activity.aio.q qVar = (com.tencent.mobileqq.activity.aio.q) QQAppInterface.this.getManager(QQManagerFactory.BEANCURD_MANAGER);
                                    BeancurdMsg beancurdMsg = new BeancurdMsg();
                                    beancurdMsg.buffer = this.f175113f.toString();
                                    beancurdMsg.busiid = 2;
                                    beancurdMsg.frienduin = String.valueOf(optLong);
                                    beancurdMsg.isNeedDelHistory = true;
                                    beancurdMsg.ispush = this.f175115i[0];
                                    beancurdMsg.startTime = com.tencent.mobileqq.service.message.e.K0();
                                    beancurdMsg.validTime = JoinTimeType.SEVEN_DAY;
                                    beancurdMsg.token = this.f175116m[0];
                                    QLog.i("ChatActivityFacade.QZoneFeeds", 1, "addQzoneFeedMessageV2l receiveBeancurd:" + String.valueOf(beancurdMsg));
                                    qVar.l(beancurdMsg);
                                    return;
                                }
                                QLog.e("ChatActivityFacade.QZoneFeeds", 1, "\u5f53\u524d\u83b7\u53d6\u5230\u7684feeds\u7684\u53d1\u8868\u4eba\u4e0d\u5339\u914d\uff0c\u5ffd\u7565\u4e0d\u63d2\u5165");
                            }
                        }
                    });
                    return;
                }
            }
            i3 = 1;
            newestFeedInfo = aIONewestFeedRsp.uFeedInfos.get(0);
            if (newestFeedInfo != null) {
            }
        } else if (aIONewestFeedRsp != null && aIONewestFeedRsp.uOpFlag == 1) {
            QLog.i("ChatActivityFacade.QZoneFeeds", 1, "newestFeed.uOpFlag==1  \u9700\u8981\u6e05\u7406\u672c\u5730\u7f13\u5b58");
            D(qQAppInterface, sessionInfo);
        } else if (QLog.isColorLevel()) {
            QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage \u6ca1\u6709\u62c9\u53bb\u5230feeds\u4fe1\u606f");
        }
    }

    public static void t0(SessionInfo sessionInfo, QQAppInterface qQAppInterface, Activity activity) {
        int i3;
        AllInOne allInOne;
        String str = sessionInfo.f179557e;
        boolean equals = str.equals(qQAppInterface.getCurrentAccountUin());
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.B(sessionInfo.f179555d), "", "", "");
        boolean z16 = false;
        if (equals) {
            allInOne = new AllInOne(qQAppInterface.getCurrentAccountUin(), 0);
            i3 = 1001;
        } else {
            int i16 = sessionInfo.f179555d;
            if (i16 == 1024) {
                i3 = 1001;
                CrmUtils.n(activity, null, sessionInfo.f179557e, true, -1, true, 2000);
                allInOne = null;
                z16 = true;
            } else {
                i3 = 1001;
                if (i16 == 1001) {
                    allInOne = new AllInOne(str, 42);
                } else if (i16 == 10002) {
                    allInOne = new AllInOne(str, 86);
                } else if (i16 == 10004) {
                    allInOne = new AllInOne(str, 94);
                } else if (i16 == 0) {
                    allInOne = new AllInOne(str, 70);
                } else if (i16 == 1000) {
                    allInOne = new AllInOne(str, 22);
                } else if (i16 == 1020) {
                    allInOne = new AllInOne(str, 58);
                } else if (i16 == 1001) {
                    allInOne = new AllInOne(str, 42);
                } else if (i16 == 10002) {
                    allInOne = new AllInOne(str, 86);
                } else if (i16 == 1004) {
                    allInOne = new AllInOne(str, 47);
                    allInOne.discussUin = sessionInfo.f179559f;
                } else if (i16 == 1005) {
                    allInOne = new AllInOne(str, 2);
                } else if (i16 == 1023) {
                    allInOne = new AllInOne(str, 74);
                } else if (i16 == 1006) {
                    allInOne = new AllInOne(str, 34);
                } else if (i16 == 1009) {
                    allInOne = new AllInOne(str, 57);
                } else if (i16 == 1021) {
                    allInOne = new AllInOne(str, 72);
                } else if (i16 == 1022) {
                    allInOne = new AllInOne(str, 27);
                } else if (i16 == 1025) {
                    allInOne = new AllInOne(str, 19);
                } else if (i16 != 1044 && i16 != 1045) {
                    if (i16 == 10008) {
                        allInOne = new AllInOne(str, 115);
                    } else if (i16 == 10010) {
                        allInOne = new AllInOne(str, 117);
                    } else {
                        allInOne = new AllInOne(str, 19);
                    }
                } else {
                    allInOne = new AllInOne(str, 96);
                }
            }
        }
        if (!z16) {
            if (TextUtils.isEmpty(allInOne.nickname)) {
                allInOne.nickname = sessionInfo.f179563i;
            }
            allInOne.reportExtra = NewReportPlugin.H(sessionInfo);
            allInOne.preWinUin = sessionInfo.f179557e;
            int i17 = sessionInfo.f179555d;
            allInOne.preWinType = i17;
            if (i17 == 1000 || i17 == 1020) {
                String str2 = sessionInfo.f179559f;
                allInOne.troopUin = str2;
                allInOne.troopCode = str2;
            }
            allInOne.lastActivity = 2;
            allInOne.uid = sessionInfo.f178172i0;
            if (i17 == 0) {
                allInOne.profileEntryType = 1;
            } else {
                allInOne.profileEntryType = 106;
            }
            if (i17 != i3 && i17 != 1010 && i17 != 10002) {
                ProfileUtils.openProfileCard(activity, allInOne);
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) u92.f.class);
            int i18 = sessionInfo.f179555d;
            if (i18 == i3) {
                allInOne.profileEntryType = 10;
                intent.putExtra("frome_where", 21);
            } else if (i18 == 1010) {
                allInOne.profileEntryType = 11;
            } else if (i18 == 10002) {
                intent.putExtra("frome_where", 22);
            }
            allInOne.reportExtra = NewReportPlugin.H(sessionInfo);
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            if (Utils.p(qQAppInterface.getCurrentAccountUin(), str)) {
                intent.putExtra("param_mode", 2);
            } else {
                intent.putExtra("param_mode", 3);
            }
            activity.startActivityForResult(intent, 9009);
        }
    }

    public static String u(Context context, String str, String str2, int i3, int i16, int i17, Paint paint, boolean z16) {
        String str3;
        int length;
        int length2;
        String str4;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("adjustTitleByNick() called with: firstNick = [");
            sb5.append(str);
            sb5.append("], secondNick = [");
            str3 = str2;
            sb5.append(str3);
            sb5.append("]");
            QLog.d("ChatActivityFacade", 2, sb5.toString());
        } else {
            str3 = str2;
        }
        String str5 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str5 = str3;
        }
        String str6 = str + HardCodeUtil.qqStr(R.string.kc_) + str5 + HardCodeUtil.qqStr(R.string.f171710kc3);
        if (z16) {
            str6 = str + HardCodeUtil.qqStr(R.string.kcq);
        }
        TextView textView = new TextView(context);
        textView.getPaint().set(paint);
        textView.setLayoutParams(new ViewGroup.LayoutParams(i16, -2));
        textView.setText(str6);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        textView.measure(makeMeasureSpec, makeMeasureSpec2);
        if (textView.getLineCount() > i3) {
            str6 = null;
            int i18 = 0;
            while (true) {
                if (i18 <= str.length()) {
                    length = i18;
                } else {
                    length = str.length();
                }
                String substring = str.substring(0, length);
                if (i18 <= str5.length()) {
                    length2 = i18;
                } else {
                    length2 = str5.length();
                }
                String substring2 = str5.substring(0, length2);
                if (z16) {
                    str4 = substring + HardCodeUtil.qqStr(R.string.kct);
                } else {
                    if (i18 < str.length()) {
                        substring = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    String str7 = (substring + HardCodeUtil.qqStr(R.string.kch)) + substring2;
                    if (i18 < str5.length()) {
                        str7 = str7 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    str4 = str7 + HardCodeUtil.qqStr(R.string.kcp);
                }
                textView.setText(str4);
                textView.measure(makeMeasureSpec, makeMeasureSpec2);
                int lineCount = textView.getLineCount();
                if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called title=[" + str4 + "],lineCount=[" + lineCount + "]");
                }
                if (lineCount > i3) {
                    break;
                }
                i18++;
                str6 = str4;
            }
        }
        return str6;
    }

    private static String v(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str) {
        return str + "_" + qQAppInterface.getCurrentUin() + "_" + sessionInfo.f179557e;
    }

    public static void v0(QQAppInterface qQAppInterface, com.tencent.mobileqq.activity.aio.p pVar, MessageForAniSticker messageForAniSticker, int i3) {
        if (messageForAniSticker == null) {
            return;
        }
        com.tencent.mobileqq.service.message.q.I(qQAppInterface, messageForAniSticker, pVar.f179557e, pVar.f179559f, pVar.f179555d);
        messageForAniSticker.mIsParsed = true;
        messageForAniSticker.f203106msg = messageForAniSticker.text;
        messageForAniSticker.msgVia = pVar.P;
        messageForAniSticker.msgtype = -8018;
        messageForAniSticker.msgData = messageForAniSticker.serializeMsgData();
        if (messageForAniSticker.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(messageForAniSticker);
        } else if (com.tencent.biz.anonymous.a.h().f78364c) {
            com.tencent.biz.anonymous.a.h().f78364c = false;
        }
        if (com.tencent.imcore.message.ao.c(pVar.f179555d) == 1032) {
            ConfessMsgUtil.d(qQAppInterface, messageForAniSticker, pVar.f179557e, pVar.f179555d, pVar.S);
        } else if (pVar.U) {
            ConfessMsgUtil.c(qQAppInterface, messageForAniSticker, pVar.f179557e);
        } else if (pVar.V) {
            ConfessMsgUtil.e(qQAppInterface, messageForAniSticker, pVar.f179557e);
        }
        if (QLog.isColorLevel()) {
            QLog.d(MessageForAniSticker.TAG, 2, "ChatActivityFacade#sendAniSticker:" + messageForAniSticker.toString());
        }
        com.tencent.mobileqq.activity.aio.forward.b.d().e(messageForAniSticker.uniseq, 0L, i3);
        qQAppInterface.getMessageFacade().a(messageForAniSticker, null);
    }

    private static boolean w(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - c0(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_FEEDS_TIME);
            long config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_REQUEST_AIO_FEEDS_DIV, 900000);
            if (serverTimeMillis > config) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5927\u4e8e\u7b49\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56detrue\uff0c\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), Long.valueOf(config)));
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5c0f\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56defalse\uff0c\u89e6\u53d1\u4e86\u9891\u7387\u63a7\u5236\uff0c\u4e0d\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), Long.valueOf(config)));
            }
        }
        return false;
    }

    public static boolean w0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArkAppMessage arkAppMessage) {
        return x0(qQAppInterface, sessionInfo, arkAppMessage, 0);
    }

    private static boolean x(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - c0(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_QCIRCLE_FEEDS_TIME);
            long config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_REQUEST_AIO_QCIRCLE_FEEDS_DIV, 900000);
            if (serverTimeMillis > config) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5927\u4e8e\u7b49\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56detrue\uff0c\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), Long.valueOf(config)));
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5c0f\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56defalse\uff0c\u89e6\u53d1\u4e86\u9891\u7387\u63a7\u5236\uff0c\u4e0d\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), Long.valueOf(config)));
            }
        }
        return false;
    }

    public static boolean x0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArkAppMessage arkAppMessage, int i3) {
        boolean z16;
        p91.a asyncShareMsgManager;
        u0(qQAppInterface);
        MessageForArkApp u16 = com.tencent.mobileqq.service.message.q.u(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d, arkAppMessage);
        if (i3 == 0) {
            i3 = arkAppMessage.forwardID;
        }
        com.tencent.mobileqq.activity.aio.forward.b.d().e(u16.uniseq, arkAppMessage.uniSeq, i3);
        if (u16.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(u16);
        }
        String str = arkAppMessage.mType;
        if (str != null && str.equals("inline_ark_robot_appid")) {
            u16.saveExtInfoToExtStr("inline_ark_robot_appid", arkAppMessage.mExtra);
        }
        IArkAsyncShareMsgService iArkAsyncShareMsgService = (IArkAsyncShareMsgService) qQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "");
        if (iArkAsyncShareMsgService != null && u16.ark_app_message != null && (asyncShareMsgManager = iArkAsyncShareMsgService.getAsyncShareMsgManager()) != null) {
            z16 = asyncShareMsgManager.f(qQAppInterface, u16.ark_app_message.appName, sessionInfo, u16);
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityFacade", 2, "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(z16));
        }
        if (!z16) {
            qQAppInterface.getMessageFacade().a(u16, null);
        }
        return true;
    }

    private static boolean y(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        if (qQAppInterface != null && qQAppInterface.getApp() != null && sessionInfo != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - c0(qQAppInterface, sessionInfo, QZoneHelper.Constants.KEY_LAST_REQUEST_AIO_STORY_FEED_TIME);
            if (serverTimeMillis > 900000) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5927\u4e8e\u7b49\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56detrue\uff0c\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), 900000L));
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story\u4e0e\u4e0a\u4e00\u6b21\u8bf7\u6c42\u95f4\u9694%d ms  \u5c0f\u4e8e \u4e0b\u53d1\u914d\u7f6e\uff1a%d ms,\u5c06\u8fd4\u56defalse\uff0c\u89e6\u53d1\u4e86\u9891\u7387\u63a7\u5236\uff0c\u4e0d\u53ef\u4ee5\u8fdb\u884c\u8bf7\u6c42", Long.valueOf(serverTimeMillis), 900000L));
            }
        }
        return false;
    }

    public static boolean y0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArkFlashChatMessage arkFlashChatMessage) {
        return z0(qQAppInterface, sessionInfo, arkFlashChatMessage, 0);
    }

    public static String z(String str, ArrayList<AtTroopMemberInfo> arrayList) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length() && str.codePointAt(i16) == 0; i16++) {
            i3++;
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
            }
        }
        if (i3 > 0) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<AtTroopMemberInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    AtTroopMemberInfo next = it.next();
                    short s16 = (short) (next.startPos - i3);
                    next.startPos = s16;
                    if (s16 < 0) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
                            return null;
                        }
                        return null;
                    }
                }
            }
            return str.substring(i3);
        }
        return str;
    }

    public static boolean z0(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArkFlashChatMessage arkFlashChatMessage, int i3) {
        u0(qQAppInterface);
        MessageForArkFlashChat w3 = com.tencent.mobileqq.service.message.q.w(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, sessionInfo.f179555d, arkFlashChatMessage);
        if (i3 == 0) {
            i3 = arkFlashChatMessage.forwardID;
        }
        com.tencent.mobileqq.activity.aio.forward.b.d().e(w3.uniseq, arkFlashChatMessage.uniSeq, i3);
        if (w3.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(w3);
        }
        qQAppInterface.getMessageFacade().a(w3, null);
        return true;
    }

    private static void u0(QQAppInterface qQAppInterface) {
    }

    public static void T(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str, String str2, String str3) {
    }
}
