package com.tencent.mobileqq.app;

import MessageSvcPack.GroupInfo;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.RequestPushNotify;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.handler.IMsgHandler;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.messagehandler.WorkerHandler;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbGetDiscussMsgReq;
import msf.msgsvc.msg_svc$PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc$PbGetGroupMsgResp;
import msf.msgsvc.msg_svc$PbGetMsgReq;
import msf.msgsvc.msg_svc$PbGetOneDayRoamMsgReq;
import msf.msgsvc.msg_svc$PbGetRoamMsgReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import msf.msgsvc.msg_svc$PbPullGroupMsgSeqReq;
import msf.msgsvc.msg_svc$PbPullGroupMsgSeqResp;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$PbSendMsgResp;
import msf.msgsvc.msg_svc$PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc$PbUnReadMsgSeqResp;
import msf.msgsvc.msg_svc$TransSvrInfo;
import msf.onlinepush.msg_onlinepush$PbPushMsg;
import msf.registerproxy.register_proxy$SvcPbResponsePullDisMsgProxy;
import msf.registerproxy.register_proxy$SvcResponsePbPullGroupMsgProxy;
import org.jetbrains.annotations.NotNull;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.msg.nt_register_proxy$GetGroupShareMsgReq;
import tencent.im.msg.nt_register_proxy$GetGroupShareMsgRsp;
import tencent.im.oidb.cmd0x9db.cmd0x9db$ReqBody;
import tencent.im.oidb.cmd0xa89.oidb_0xa89$ReqBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31$ReqBody;
import tencent.im.oidb.cmd0xbad.oidb_0xbad$ReqBody;
import tencent.im.oidb.oidb_0xd55$CheckUrlSigReq;
import tencent.im.oidb.oidb_0xd55$ReqBody;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class MessageHandler extends BaseMessageHandler implements ProcessorObserver, ProcessorDispatcherInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    public static int f194802e0;
    private boolean C;
    private boolean D;
    private final int[] E;
    private final int[] F;
    WorkerHandler G;
    Object H;
    ArrayList<String> I;
    private int J;
    private final int K;
    private int L;
    private final int M;
    public int N;
    private final int P;
    public QQAppInterface Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private Thread U;
    private Thread V;
    private Thread W;
    private Runnable X;
    private Runnable Y;
    private Runnable Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f194803a0;

    /* renamed from: b0, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.a f194804b0;

    /* renamed from: c0, reason: collision with root package name */
    private ar f194805c0;

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f194806d;

    /* renamed from: d0, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f194807d0;

    /* renamed from: e, reason: collision with root package name */
    private Object f194808e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.mobileqq.service.message.e f194809f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.imcore.message.basic.c<String, IMsgHandler> f194810h;

    /* renamed from: i, reason: collision with root package name */
    private final RegisterProxyHandler.Callback f194811i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f194812m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.MessageHandler$10, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass10 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ long C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f194813d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f194814e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f194815f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ byte f194816h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f194817i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f194818m;
        final /* synthetic */ MessageHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long j3 = this.f194813d;
            long j16 = 3 - j3;
            long j17 = 480000;
            if (j3 != 0) {
                j17 = ((480000 * j16) / 3) - (j16 * 2000);
            }
            this.this$0.Z4(this.f194814e, this.f194815f, this.f194816h, !this.this$0.Q.getMessageFacade().getLastMessage(this.f194814e, 1001).hasReply, this.f194817i, this.f194818m, this.C, j17);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.MessageHandler$6, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQNotificationManager f194825d;
        final /* synthetic */ MessageHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                LockMethodProxy.sleep(5000L);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "PConline time expired cancel now");
                }
                this.f194825d.cancel("Q.msg.MessageHandler_PcOnlineNotifition", 264);
                this.this$0.R = false;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "PConline thread Interrupt");
                }
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.MessageHandler$7, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQNotificationManager f194826d;
        final /* synthetic */ MessageHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                LockMethodProxy.sleep(5000L);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "IPADonline time expired cancel now");
                }
                this.f194826d.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", 263);
                this.this$0.R = false;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "IPADonline thread Interrupt");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            } else if (z16 && z17 && z18 && !TextUtils.isEmpty(str)) {
                MessageHandler.this.Q.getMessageFacade().R1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "onUpdateAnswerAddedFriend isSuccess = " + z16 + ", uin = " + str + ", flag = " + i3);
            }
            if (z16) {
                MessageHandler.this.Q.getMessageFacade().R1();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "onUpdateFriendList isSuccess = " + z16 + ", isComplete = " + z17);
            }
            if (z16 && z17) {
                MessageHandler.this.Q.getMessageFacade().R1();
                ((IAIOPreDownloadService) MessageHandler.this.Q.getRuntimeService(IAIOPreDownloadService.class, "")).onGetOfflineMessageFinish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements RegisterProxyHandler.Callback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.handler.RegisterProxyHandler.Callback
        public List<String> getDiscussList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList<DiscussionInfo> k3 = ((n) MessageHandler.this.Q.getManager(QQManagerFactory.DISCUSSION_MANAGER)).k();
            ArrayList arrayList = new ArrayList();
            Iterator<DiscussionInfo> it = k3.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().uin);
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.app.handler.RegisterProxyHandler.Callback
        public void onInitMsgSendingInfo(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord);
            } else if (messageRecord.msgtype == -1035 && (messageRecord instanceof MessageForMixedMsg)) {
                MessageHandler.this.Q.msgFacade.Z0(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, 32768, messageRecord.sendFailCode);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f194830a;

        /* renamed from: b, reason: collision with root package name */
        private ToServiceMsg f194831b;

        /* renamed from: c, reason: collision with root package name */
        private FromServiceMsg f194832c;

        /* renamed from: d, reason: collision with root package name */
        private msg_svc$PbSendMsgResp f194833d;

        /* renamed from: e, reason: collision with root package name */
        private int f194834e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f194835f;

        /* renamed from: g, reason: collision with root package name */
        private long f194836g;

        /* renamed from: h, reason: collision with root package name */
        private long f194837h;

        /* renamed from: i, reason: collision with root package name */
        private String f194838i;

        /* renamed from: j, reason: collision with root package name */
        private int f194839j;

        public d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, int i3, boolean z16, long j3, long j16, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageHandler.this, toServiceMsg, fromServiceMsg, msg_svc_pbsendmsgresp, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i16));
                return;
            }
            this.f194831b = toServiceMsg;
            this.f194832c = fromServiceMsg;
            this.f194833d = msg_svc_pbsendmsgresp;
            this.f194834e = i3;
            this.f194835f = z16;
            this.f194836g = j3;
            this.f194837h = j16;
            this.f194838i = str;
            this.f194839j = i16;
        }

        public d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (d) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            int i3 = this.f194834e;
            if (i3 == 10 || i3 == 34) {
                this.f194835f = true;
                MessageRecord w06 = MessageHandler.this.Q.getMessageFacade().w0(this.f194838i, this.f194839j, this.f194836g);
                MessageHandler messageHandler = MessageHandler.this;
                if (messageHandler.U4(w06, messageHandler.P4(this.f194831b))) {
                    MessageHandler.this.removeSendMessageHandler(this.f194837h);
                    this.f194830a = true;
                    return this;
                }
            }
            MessageHandler.this.l4(this.f194831b, this.f194833d);
            Object[] objArr = {this.f194831b.extraData.getString("uToUin"), 3000, Integer.valueOf(this.f194834e), this.f194831b.getAttribute("sendmsgHandler"), Long.valueOf(this.f194831b.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT)), Long.valueOf(this.f194836g)};
            MessageHandler.this.s5(objArr, this.f194832c.getUin(), this.f194834e);
            MessageHandler.this.notifyBusiness(3008, false, objArr);
            msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp = this.f194833d;
            if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.errmsg.has() && this.f194833d.errmsg.get() != null && QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "send dicussion msg failed: " + this.f194833d.errmsg.get());
            }
            this.f194830a = false;
            return this;
        }

        boolean b() {
            return this.f194830a;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f194835f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f194841a;

        /* renamed from: b, reason: collision with root package name */
        private ToServiceMsg f194842b;

        /* renamed from: c, reason: collision with root package name */
        private FromServiceMsg f194843c;

        /* renamed from: d, reason: collision with root package name */
        private String f194844d;

        /* renamed from: e, reason: collision with root package name */
        private msg_svc$PbSendMsgResp f194845e;

        /* renamed from: f, reason: collision with root package name */
        private int f194846f;

        /* renamed from: g, reason: collision with root package name */
        private long f194847g;

        /* renamed from: h, reason: collision with root package name */
        private long f194848h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f194849i;

        /* renamed from: j, reason: collision with root package name */
        private Object[] f194850j;

        /* renamed from: k, reason: collision with root package name */
        private int f194851k;

        public e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, int i3, long j3, long j16, boolean z16, Object[] objArr, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageHandler.this, toServiceMsg, fromServiceMsg, str, msg_svc_pbsendmsgresp, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), objArr, Integer.valueOf(i16));
                return;
            }
            this.f194842b = toServiceMsg;
            this.f194843c = fromServiceMsg;
            this.f194844d = str;
            this.f194845e = msg_svc_pbsendmsgresp;
            this.f194846f = i3;
            this.f194847g = j3;
            this.f194848h = j16;
            this.f194849i = z16;
            this.f194850j = objArr;
            this.f194851k = i16;
        }

        public e a() {
            long j3;
            long K0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (e) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            int i3 = this.f194846f;
            if (i3 == 10 || i3 == 34) {
                this.f194849i = true;
                MessageRecord w06 = MessageHandler.this.Q.getMessageFacade().w0(this.f194844d, this.f194851k, this.f194848h);
                MessageHandler messageHandler = MessageHandler.this;
                if (messageHandler.U4(w06, messageHandler.P4(this.f194842b))) {
                    MessageHandler.this.removeSendMessageHandler(this.f194847g);
                    this.f194841a = true;
                    return this;
                }
            }
            if (this.f194846f == 299) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail uinseq = " + this.f194848h + ", msgseq = " + this.f194847g);
                }
                MessageRecord w07 = MessageHandler.this.Q.getMessageFacade().w0(this.f194844d, this.f194851k, this.f194848h);
                MessageHandler.this.removeSendMessageHandler(this.f194847g);
                MessageHandler.this.Q.getMsgCache().G1(this.f194844d, 1, this.f194848h);
                if (w07 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, MessageRecord=" + w07.toString());
                    }
                    j3 = w07.shmsgseq;
                    K0 = w07.time;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, uniseq not match !");
                    }
                    List<MessageRecord> Q = MessageHandler.this.Q.getMessageFacade().Q(this.f194844d, 1);
                    j3 = 0;
                    if (Q != null && !Q.isEmpty() && Q.get(Q.size() - 1).shmsgseq > 0) {
                        j3 = Q.get(Q.size() - 1).shmsgseq;
                        K0 = Q.get(Q.size() - 1).time;
                    } else {
                        K0 = com.tencent.mobileqq.service.message.e.K0();
                    }
                }
                long j16 = K0;
                MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                String str = this.f194844d;
                messageForUniteGrayTip.initGrayTipMsg(MessageHandler.this.Q, new com.tencent.mobileqq.graytip.g(str, str, this.f194850j[6].toString(), 1, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 131082, j16));
                messageForUniteGrayTip.isread = true;
                messageForUniteGrayTip.shmsgseq = j3;
                com.tencent.mobileqq.graytip.f.a(MessageHandler.this.Q, messageForUniteGrayTip);
            }
            MessageHandler.this.l4(this.f194842b, this.f194845e);
            MessageHandler.this.s5(this.f194850j, this.f194843c.getUin(), this.f194846f);
            MessageHandler.this.notifyBusiness(3002, false, this.f194850j);
            this.f194841a = false;
            return this;
        }

        boolean b() {
            return this.f194841a;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f194849i;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 150)) {
            redirector.redirect((short) 150);
        } else {
            f194802e0 = 500;
        }
    }

    public MessageHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194806d = null;
        this.f194808e = new Object();
        this.f194810h = new com.tencent.imcore.message.basic.d();
        c cVar = new c();
        this.f194811i = cVar;
        this.f194812m = false;
        this.D = false;
        this.E = new int[0];
        this.F = new int[0];
        this.H = new Object();
        this.I = new ArrayList<>();
        this.J = 0;
        this.K = 2;
        this.L = 0;
        this.M = 3;
        this.P = 6;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f194803a0 = false;
        this.f194804b0 = new a();
        this.f194805c0 = new b();
        this.f194807d0 = new ConcurrentHashMap<>();
        this.Q = qQAppInterface;
        this.mRegisterProxyHandler.setCallback(cVar);
        qQAppInterface.addObserver(this.f194805c0, true);
        qQAppInterface.addObserver(this.f194804b0, true);
        this.f194809f = qQAppInterface.getMsgCache();
    }

    private void A4(String[] strArr, HashMap hashMap) {
        if (!hashMap.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp  RegisterProxyTroopSeq FailedTroopSize=" + hashMap.size());
            }
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                P2((String) it.next());
            }
        }
        if (this.f194809f.m1()) {
            notifyUI(4003, true, strArr);
        }
    }

    private void B4(Object obj) {
        Object[] objArr;
        if ((obj instanceof Object[]) && (objArr = (Object[]) obj) != null && objArr.length > 2) {
            String str = (String) objArr[0];
            ((Integer) objArr[1]).intValue();
            int intValue = ((Integer) objArr[2]).intValue();
            if (intValue == 58) {
                com.tencent.mobileqq.service.message.c.b(this.Q, str);
                if (!((FriendsManager) this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).f0(str)) {
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
                    dVar.M();
                    dVar.r0(true);
                    iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "Q.msg.MessageHandler", new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(str) { // from class: com.tencent.mobileqq.app.MessageHandler.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ String f194821a;

                        {
                            this.f194821a = str;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageHandler.this, (Object) str);
                            }
                        }

                        @Override // hx3.c
                        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                            } else {
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.MessageHandler.4.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        BusinessHandler businessHandler = MessageHandler.this.Q.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                                        Boolean bool = Boolean.TRUE;
                                        businessHandler.notifyUI(54, true, new Object[]{Long.valueOf(Long.parseLong(AnonymousClass4.this.f194821a)), bool, bool, bool, ""});
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (intValue == 120) {
                p4(str);
            }
        }
    }

    @android.support.annotation.Nullable
    private msg_svc$PbGetGroupMsgResp C3(byte[] bArr) {
        try {
            return new msg_svc$PbGetGroupMsgResp().mergeFrom(bArr);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB : Exception occurs whitl parsing the bytes.");
            }
            return null;
        }
    }

    private void C4(int i3, Object obj) {
        Object[] objArr;
        if ((obj instanceof Object[]) && (objArr = (Object[]) obj) != null && objArr.length > 2) {
            String str = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            int intValue2 = ((Integer) objArr[2]).intValue();
            if (intValue2 == 55 && i3 != 8035) {
                ((ShieldListHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).Q2(str, intValue);
            } else if (intValue2 == 120) {
                p4(str);
            }
        }
    }

    private void D3(ToServiceMsg toServiceMsg, long j3, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, int i3, boolean z16, boolean z17, String str, long j16, boolean z18) {
        if (M4(toServiceMsg, msg_svc_pbgetgroupmsgresp)) {
            return;
        }
        if (msg_svc_pbgetgroupmsgresp.uint32_has_share_history_msg.has() && msg_svc_pbgetgroupmsgresp.uint32_has_share_history_msg.get() == 2) {
            N4(j16);
        } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "pullShareHistoryMsg--no--");
        }
        ArrayList<msg_comm$Msg> T0 = this.f194809f.T0(j16);
        if (z18) {
            F3(toServiceMsg, msg_svc_pbgetgroupmsgresp, str, T0);
        } else {
            E3(toServiceMsg, msg_svc_pbgetgroupmsgresp, z16, z17, str, j16, T0);
        }
        this.f194809f.F1(j16);
        ((com.tencent.mobileqq.troop.data.y) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP)).z("" + j16, msg_svc_pbgetgroupmsgresp, i3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "handleGetPullGroupMsgRespPB, cost time = [" + (System.currentTimeMillis() - j3) + "]");
        }
    }

    private void D4(Object obj) {
        Object[] objArr;
        if ((obj instanceof Object[]) && (objArr = (Object[]) obj) != null && objArr.length > 2) {
            ((Integer) objArr[2]).intValue();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008f, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0091, code lost:
    
        com.tencent.qphone.base.util.QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0097, code lost:
    
        com.tencent.util.MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
        notifyUI(4003, true, new java.lang.String[]{"" + r19});
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b5, code lost:
    
        if (r17 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b7, code lost:
    
        r0 = r13.mRegisterProxyHandler;
        r2 = r0.troopNum;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bb, code lost:
    
        if (r2 == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bf, code lost:
    
        if (r0.recvTroopNum < r2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c5, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c7, code lost:
    
        com.tencent.qphone.base.util.QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB notify NOTIFY_TYPE_GET_TROOP_MSG_FIN , troopNum:" + r13.mRegisterProxyHandler.troopNum + " , recvTroopNum:" + r13.mRegisterProxyHandler.recvTroopNum);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ed, code lost:
    
        com.tencent.util.MsgAutoMonitorUtil.getInstance().markGrpFinishTime();
        notifyUI(4003, true, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f9, code lost:
    
        notifyUI(4003, true, new java.lang.String[]{"" + r19});
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r13.mRegisterProxyHandler.recvTroopNum++;
        r13.f194809f.V1(java.lang.String.valueOf(r19), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0062, code lost:
    
        if (r17 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x004f, code lost:
    
        if (r17 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0075, code lost:
    
        m4(java.lang.String.valueOf(r19), "handleGetPullGroupMsgRespPB");
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0081, code lost:
    
        if (r16 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0089, code lost:
    
        if (r13.f194809f.m1() == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E3(ToServiceMsg toServiceMsg, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, boolean z16, boolean z17, String str, long j3, ArrayList<msg_comm$Msg> arrayList) {
        try {
            try {
                getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP).t(1002, toServiceMsg, arrayList, new Object[]{Long.valueOf(msg_svc_pbgetgroupmsgresp.group_code.get()), Integer.valueOf(msg_svc_pbgetgroupmsgresp.result.get()), Long.valueOf(msg_svc_pbgetgroupmsgresp.return_end_seq.get()), Boolean.FALSE}, str);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB initGetPullTroopMsg exception ! ", e16);
                }
            }
        } catch (Throwable th5) {
            if (z17) {
                this.mRegisterProxyHandler.recvTroopNum++;
                this.f194809f.V1(String.valueOf(j3), 2);
            } else {
                m4(String.valueOf(j3), "handleGetPullGroupMsgRespPB");
            }
            throw th5;
        }
    }

    private void E4(int i3, boolean z16, int i16, boolean z17, boolean z18, MessageRecord messageRecord) {
        if (z17 && i3 == 1000 && z16) {
            if (i16 > 0) {
                boolean z19 = false;
                try {
                    if (messageRecord == null) {
                        QQAppInterface qQAppInterface = this.Q;
                        if (!z18) {
                            z19 = true;
                        }
                        qQAppInterface.handleReceivedMessage(i16, true, z19);
                    } else if (!s4(messageRecord)) {
                        QQAppInterface qQAppInterface2 = this.Q;
                        if (!z18) {
                            z19 = true;
                        }
                        com.tencent.av.utils.an.m(qQAppInterface2, i16, true, z19, messageRecord);
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("notification", 2, "notification exception", e16);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "notification size = 0");
            }
        }
    }

    private void F3(ToServiceMsg toServiceMsg, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, String str, ArrayList<msg_comm$Msg> arrayList) {
        try {
            getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP).t(1003, toServiceMsg, msg_svc_pbgetgroupmsgresp, arrayList, str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "<--- handleGetPullGroupMsgRespPB refreshTroopHead exception ! ", e16);
            }
        }
    }

    private void G3(Object obj, boolean z16, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, int i3, long j3, boolean z17) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("handleGetPullTroopMsgResp msgStruct.cReplyCode = ");
            sb5.append(msg_svc_pbgetgroupmsgresp.result.get());
            sb5.append(" troopUin: ");
            sb5.append(j3);
            sb5.append(",isRefreshHead:");
            sb5.append(z17);
            sb5.append(", dataHash=@");
            sb5.append(Integer.toHexString(obj.hashCode()));
            sb5.append(" rtnBeginSeq:");
            sb5.append(msg_svc_pbgetgroupmsgresp.return_begin_seq.get());
            sb5.append(" rtnEndSeq:");
            sb5.append(msg_svc_pbgetgroupmsgresp.return_end_seq.get());
            sb5.append(",doSome:");
            sb5.append(i3);
            if (!z16) {
                sb5.append(",costTime = [");
                sb5.append(System.currentTimeMillis() - BaseMessageManagerForTroopAndDisc.G);
                sb5.append("]");
            }
            if (msg_svc_pbgetgroupmsgresp.f417534msg.get() != null) {
                sb5.append(" msgSize:");
                sb5.append(msg_svc_pbgetgroupmsgresp.f417534msg.get().size());
            } else {
                sb5.append(" msg:null.");
            }
            if (msg_svc_pbgetgroupmsgresp.uint32_has_share_history_msg.has()) {
                sb5.append(" has_share_history_msg:" + msg_svc_pbgetgroupmsgresp.uint32_has_share_history_msg.get());
            } else {
                sb5.append(" has_share_history_msg:empty.");
            }
            if (QLog.isColorLevel()) {
                if (z16) {
                    str = "Q.msg.MessageHandler.troop.register_proxy_pull_msg";
                } else {
                    str = "Q.msg.MessageHandler.trooptroop_pull_msg";
                }
                QLog.d(str, 2, sb5.toString());
            }
        }
    }

    private void I4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcResponsePullGroupMsgSeq svcResponsePullGroupMsgSeq, int i3, boolean z16, StringBuilder sb5, ArrayList<String> arrayList, HashMap hashMap, HashMap<String, String> hashMap2, int i16) {
        GroupInfo groupInfo = svcResponsePullGroupMsgSeq.vGroupInfo.get(i16);
        String valueOf = String.valueOf(groupInfo.lGroupCode);
        long j3 = groupInfo.lRedPackTime;
        long j16 = 0;
        if (j3 > 0) {
            hashMap2.put(valueOf, String.valueOf(j3));
        }
        Object[] C0 = this.f194809f.C0(valueOf);
        long D0 = this.f194809f.D0(valueOf);
        if (C0 != null && C0.length > 0) {
            j16 = ((Long) C0[0]).longValue();
        }
        long j17 = j16;
        if (QLog.isColorLevel()) {
            sb5.setLength(0);
            sb5.append("handleGetPullTroopMsgNumResp getGroupMsgMemberSeq groupUin=");
            sb5.append(groupInfo.lGroupCode);
            sb5.append(" memberseq=");
            sb5.append(groupInfo.lMemberSeq);
            sb5.append(" groupSeq=");
            sb5.append(groupInfo.lGroupSeq);
            sb5.append(" lMask=");
            sb5.append(groupInfo.lMask);
            sb5.append(" localMemberMsgSeq=");
            sb5.append(j17);
            sb5.append(" localLastSeq=");
            sb5.append(D0);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        if (z16) {
            K4(toServiceMsg, fromServiceMsg, hashMap, groupInfo, valueOf, D0, j17);
        } else {
            J4(toServiceMsg, i3, sb5, arrayList, groupInfo, valueOf, j17);
        }
    }

    private void J4(ToServiceMsg toServiceMsg, int i3, StringBuilder sb5, ArrayList<String> arrayList, GroupInfo groupInfo, String str, long j3) {
        long j16;
        this.f194809f.t(str, new Object[]{Long.valueOf(groupInfo.lMemberSeq), Long.valueOf(groupInfo.lGroupSeq)});
        com.tencent.mobileqq.statistics.d.f(str, groupInfo.lGroupSeq, groupInfo.lMemberSeq);
        if (j3 < groupInfo.lMemberSeq) {
            this.Q.getMessageFacade().M0(String.valueOf(groupInfo.lGroupCode), 1, groupInfo.lMemberSeq);
        }
        Pair<Long, Long> f36 = f3(str, 1, this.f194809f.B0(str), this.f194809f.A0(str), this.f194809f.M0(str, 1), groupInfo.lGroupSeq);
        int longValue = (int) (((Long) f36.second).longValue() - ((Long) f36.first).longValue());
        long longValue2 = ((Long) f36.first).longValue() + 1;
        long longValue3 = ((Long) f36.second).longValue();
        long j17 = longValue3 - longValue2;
        long j18 = 10;
        if (j17 > j18) {
            j16 = (longValue3 - j18) + 1;
        } else {
            j16 = longValue3 - j17;
        }
        long j19 = j16;
        if (QLog.isColorLevel()) {
            sb5.setLength(0);
            sb5.append("---------handleGetPullTroopMsgNumResp troopUin: ");
            sb5.append(str);
            sb5.append(" msg count: ");
            sb5.append(longValue);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        if (longValue <= 0) {
            ((com.tencent.mobileqq.troop.data.y) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP)).z(str, null, i3);
            return;
        }
        arrayList.add(str);
        if (arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next();
                g3(str, j19, longValue3, false, null, i3);
            }
            return;
        }
        notifyUI(4003, true, toServiceMsg.extraData.getStringArray("array_groupuin"));
    }

    private void K2(MessageRecord messageRecord, ToServiceMsg toServiceMsg) {
        MarkFaceMessage markFaceMessage;
        byte[] bArr;
        StructMsgForGeneralShare structMsgForGeneralShare;
        if ((messageRecord instanceof MessageForLongTextMsg) && (structMsgForGeneralShare = ((MessageForLongTextMsg) messageRecord).structingMsg) != null) {
            toServiceMsg.extraData.putString(WadlProxyConsts.PARAM_FILENAME, structMsgForGeneralShare.mFileName);
        }
        if ((messageRecord instanceof MessageForMarketFace) && (markFaceMessage = ((MessageForMarketFace) messageRecord).mMarkFaceMessage) != null && (((bArr = markFaceMessage.mobileparam) != null && bArr.length > 0) || markFaceMessage.mediaType == 3)) {
            toServiceMsg.extraData.putInt("mediaType", 2);
        }
        if (messageRecord instanceof MessageForText) {
            MessageForText messageForText = (MessageForText) messageRecord;
            toServiceMsg.extraData.putInt("msg_signal_sum", messageForText.mMsgSignalSum);
            toServiceMsg.extraData.putInt("msg_signal_count", messageForText.mMsgSignalCount);
            toServiceMsg.extraData.putBoolean("msg_signal_open", messageForText.mIsMsgSignalOpen);
            toServiceMsg.extraData.putInt("msg_signal_net_type", messageForText.mMsgSignalNetType);
            toServiceMsg.extraData.putLong("msg_send_time", messageForText.mMsgSendTime);
        }
        int i3 = messageRecord.istroop;
        if (i3 != 1 && i3 != 1026) {
            if (i3 == 3000) {
                toServiceMsg.extraData.putString("uToUin", messageRecord.frienduin);
            } else if (com.tencent.imcore.message.ao.c(i3) == 1032) {
                toServiceMsg.extraData.putInt(ConfessInfo.KEY_CONFESS_TOPICID, messageRecord.getConfessTopicId());
            }
        } else {
            toServiceMsg.extraData.putString("groupuin", messageRecord.frienduin);
        }
        if (com.tencent.imcore.message.ad.I(messageRecord.msgtype)) {
            toServiceMsg.extraData.putBoolean("RichNotify", true);
        }
    }

    private void K4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, HashMap hashMap, GroupInfo groupInfo, String str, long j3, long j16) {
        long j17 = groupInfo.lMask;
        if ((j17 == 2 || j17 == 3) && !this.Q.mAutomator.isSyncNormalMsgFinish()) {
            P2(str);
        } else {
            this.f194809f.t(str, new Object[]{Long.valueOf(groupInfo.lMemberSeq), Long.valueOf(groupInfo.lGroupSeq)});
            com.tencent.mobileqq.statistics.d.f(str, groupInfo.lGroupSeq, groupInfo.lMemberSeq);
            if (groupInfo.lGroupSeq <= j3) {
                P2(str);
                if (j16 < groupInfo.lMemberSeq) {
                    if (RegisterProxyHandler.isUsedMessageHandleThread) {
                        this.mRegisterProxyHandler.addProxyMsgToQueue(4, toServiceMsg, fromServiceMsg, groupInfo);
                    } else {
                        this.Q.getMessageFacade().M0(str, 1, groupInfo.lMemberSeq);
                    }
                }
            } else if (j16 < groupInfo.lMemberSeq) {
                this.f194809f.V1(str, 1);
            }
        }
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    private boolean L2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105891", true);
    }

    private boolean L4(ToServiceMsg toServiceMsg, msg_svc$PbGetDiscussMsgResp msg_svc_pbgetdiscussmsgresp) {
        if (msg_svc_pbgetdiscussmsgresp.f417533msg.get() != null && msg_svc_pbgetdiscussmsgresp.f417533msg.get().size() > 0) {
            boolean z16 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
            boolean z17 = toServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
            long j3 = toServiceMsg.extraData.getLong("lBeginSeq");
            long j16 = msg_svc_pbgetdiscussmsgresp.return_begin_seq.get();
            long j17 = toServiceMsg.extraData.getLong("lDisUin", msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "pullNextDisMsg disUin: " + j17 + " res.cReplyCode: " + msg_svc_pbgetdiscussmsgresp.result.get() + " srcBegSeq: " + j3 + " srcEndSeq: " + toServiceMsg.extraData.getLong("lEndSeq") + " res.lReturnBeginSeq: " + j16 + " res.lReturnEndSeq: " + msg_svc_pbgetdiscussmsgresp.return_end_seq.get() + " res.vMsgs.size(): " + msg_svc_pbgetdiscussmsgresp.f417533msg.get().size());
            }
            this.f194809f.F(j17, msg_svc_pbgetdiscussmsgresp.f417533msg.get());
            if (!z16 && !z17) {
                long j18 = j16 - 1;
                if (j3 <= j18 && msg_svc_pbgetdiscussmsgresp.return_begin_seq.get() <= msg_svc_pbgetdiscussmsgresp.return_end_seq.get()) {
                    return e3(j17, j3, j18, toServiceMsg.extraData.getBoolean("isRefreshHead"), toServiceMsg.extraData.getBundle("context"));
                }
            }
        }
        return false;
    }

    private boolean M4(ToServiceMsg toServiceMsg, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp) {
        boolean z16;
        Object obj;
        if (msg_svc_pbgetgroupmsgresp.f417534msg.get() != null && msg_svc_pbgetgroupmsgresp.f417534msg.get().size() > 0) {
            boolean z17 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
            boolean z18 = toServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
            String string = toServiceMsg.extraData.getString("groupuin");
            if (string == null) {
                string = String.valueOf(msg_svc_pbgetgroupmsgresp.group_code.get());
            }
            String str = string;
            long j3 = toServiceMsg.extraData.getLong("lBeginSeq", 0L);
            long j16 = msg_svc_pbgetgroupmsgresp.return_begin_seq.get();
            if (msg_svc_pbgetgroupmsgresp.f417534msg.get() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(128);
                sb5.append("pullNextTroopMsg troopUin: ");
                sb5.append(str);
                sb5.append(" msgStruct.cReplyCode: ");
                sb5.append(msg_svc_pbgetgroupmsgresp.result.get());
                sb5.append(" lBeginSeq: ");
                sb5.append(j3);
                sb5.append(" lEndSeq: ");
                sb5.append(toServiceMsg.extraData.getLong("lEndSeq"));
                sb5.append(" res.lReturnBeginSeq: ");
                sb5.append(j16);
                sb5.append(" res.lReturnEndSeq: ");
                sb5.append(msg_svc_pbgetgroupmsgresp.return_end_seq.get());
                sb5.append(" msg.size(): ");
                if (z16) {
                    obj = Integer.valueOf(msg_svc_pbgetgroupmsgresp.f417534msg.get().size());
                } else {
                    obj = "null";
                }
                sb5.append(obj);
                QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
            }
            this.f194809f.G(msg_svc_pbgetgroupmsgresp.group_code.get(), msg_svc_pbgetgroupmsgresp.f417534msg.get());
            long j17 = j16 - 1;
            if (!z17 && !z18 && j3 <= j17 && msg_svc_pbgetgroupmsgresp.return_begin_seq.get() <= msg_svc_pbgetgroupmsgresp.return_end_seq.get()) {
                return g3(str, j3, j17, toServiceMsg.extraData.getBoolean("isRefreshHead"), toServiceMsg.extraData.getBundle("context"), toServiceMsg.extraData.getInt("doSome"));
            }
        }
        return false;
    }

    private void N4(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 1, "pullShareHistoryMsg");
        }
        if (!com.tencent.mobileqq.selectmember.util.b.a(MobileQQ.sMobileQQ.peekAppRuntime())) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "isFeatureEnable= false");
            }
        } else {
            ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG);
            nt_register_proxy$GetGroupShareMsgReq nt_register_proxy_getgroupsharemsgreq = new nt_register_proxy$GetGroupShareMsgReq();
            nt_register_proxy_getgroupsharemsgreq.group_code.set(Long.valueOf(j3).longValue());
            createToServiceMsg.putWupBuffer(nt_register_proxy_getgroupsharemsgreq.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    private void P2(String str) {
        this.Q.getCurrentAccountUin();
        m4(str, "closeTroopOnlineMsgCache");
    }

    @NotNull
    private ToServiceMsg Q2(byte b16, byte[] bArr, int i3, boolean z16, boolean z17, String str, int i16, Object obj, byte[] bArr2, byte b17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "createGetOfflineMsgRequest");
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MessageSvc.PbGetMsg");
        createToServiceMsg.extraData.putByte("cChannel", b16);
        createToServiceMsg.extraData.putByteArray("vCookies", bArr);
        createToServiceMsg.extraData.putInt("cSyncFlag", i3);
        createToServiceMsg.extraData.putByteArray("vSyncCookie", bArr2);
        createToServiceMsg.extraData.putByte("onlineSyncFlag", b17);
        createToServiceMsg.extraData.putBoolean("needNofityConversation", z17);
        createToServiceMsg.extraData.putBoolean("isPullRoamMsg", z16);
        if (str != null) {
            createToServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PUSH_TIMESTAMP, str + "|" + System.currentTimeMillis());
        }
        createToServiceMsg.extraData.putInt("pullMsgType", i16);
        createToServiceMsg.extraData.putBoolean(MessageHandlerConstants.KEY_FROM_PUSH_NOTIFY, z18);
        createToServiceMsg.putWupBuffer(d3(i3, i16, obj, bArr2, b17).toByteArray());
        return createToServiceMsg;
    }

    @NotNull
    private ToServiceMsg R2(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, long j3, int i3, BusinessObserver businessObserver, boolean z16) {
        long length;
        long currentTimeMillis = System.currentTimeMillis();
        String str = messageRecord.f203106msg;
        if (str == null) {
            length = 0;
        } else {
            length = str.getBytes().length;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG, businessObserver);
        K2(messageRecord, createToServiceMsg);
        int M = com.tencent.mobileqq.service.message.p.M(messageRecord.istroop, this.Q);
        QLog.i("Q.msg.MessageHandler", 1, String.format(Locale.getDefault(), "<PbSendMsg><S> --->createSendRichTextMsgReq, uint32Seq:%d, random:%d, routingType:%d, %s", Integer.valueOf(((short) messageRecord.msgseq) & 65535), Integer.valueOf(com.tencent.mobileqq.service.message.s.e(messageRecord.msgUid)), Integer.valueOf(M), messageRecord.getBaseInfoString()));
        createToServiceMsg.extraData.putString("uin", messageRecord.frienduin);
        createToServiceMsg.extraData.putLong("msgsize", length);
        createToServiceMsg.extraData.putLong("uniseq", messageRecord.uniseq);
        createToServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, j3);
        createToServiceMsg.extraData.putLong("msgSeq", messageRecord.msgseq);
        createToServiceMsg.extraData.putLong("startTime", currentTimeMillis);
        createToServiceMsg.extraData.putInt("retryIndex", i3);
        createToServiceMsg.extraData.putInt("uintype", messageRecord.istroop);
        createToServiceMsg.extraData.putInt(AppConstants.Key.COLUMN_MSG_TYPE, messageRecord.msgtype);
        createToServiceMsg.extraData.putInt("ROUNTING_TYPE", M);
        createToServiceMsg.extraData.putInt("send_msg_req_size", createToServiceMsg.getWupBuffer().length);
        createToServiceMsg.putWupBuffer(msg_svc_pbsendmsgreq.toByteArray());
        createToServiceMsg.setTimeout(j3);
        createToServiceMsg.addAttribute(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(messageRecord.msgtype));
        createToServiceMsg.addAttribute("msgSeq", Long.valueOf(messageRecord.msgseq));
        createToServiceMsg.addAttribute("resend_by_user", Boolean.valueOf(z16));
        createToServiceMsg.addAttribute("retryIndex", Integer.valueOf(i3));
        String str2 = messageRecord.frienduin;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        createToServiceMsg.addAttribute("uin", str2);
        String str4 = messageRecord.senderuin;
        if (str4 != null) {
            str3 = str4;
        }
        createToServiceMsg.addAttribute("fromUin", str3);
        createToServiceMsg.addAttribute("normal_msg", Boolean.TRUE);
        return createToServiceMsg;
    }

    private void T3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        String string = toServiceMsg.extraData.getString("uin");
        long j3 = toServiceMsg.extraData.getLong("uniseq");
        long j16 = toServiceMsg.extraData.getLong("msgSeq");
        long j17 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        int i16 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        int i17 = toServiceMsg.extraData.getInt("retryIndex");
        int H = com.tencent.mobileqq.service.message.p.H(i16, this.Q);
        com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j3);
        String str = "<PbSendMsg><E><---handleSendC2CMessageError: ---cmd:" + serviceCmd + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + MsfSdkUtils.getShortUin(string) + " uniseq:" + j3 + " msgSeq:" + j16 + " msgType:" + i3 + " uinType:" + H + " routingType:" + i16 + " retryIndex:" + i17;
        QLog.e("Q.msg.MessageHandler", 1, str);
        X4(j3, str, string, H, "SendMessageError");
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j16);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (480000 == j17 || handlerFromQueue.c()) {
                int Z2 = Z2(i16);
                Object[] objArr = {string, Integer.valueOf(H), 0, toServiceMsg.getAttribute("sendmsgHandler"), Long.valueOf(j17), Long.valueOf(j3)};
                s5(objArr, fromServiceMsg.getUin(), fromServiceMsg.getResultCode());
                notifyBusiness(Z2, false, objArr);
                if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
                    StatictisInfo statictisInfo = new StatictisInfo();
                    statictisInfo.errCode = fromServiceMsg.getResultCode();
                    statictisInfo.retryCount = i17;
                    statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                    notifyCallBack(toServiceMsg, 5006, false, new Object[]{Long.valueOf(j3), statictisInfo});
                    R3(string, H, j3, false);
                }
                com.tencent.mobileqq.app.handler.d.e(this, toServiceMsg, fromServiceMsg, false);
                removeSendMessageHandler(j16);
                com.tencent.mobileqq.statistics.tianjige.metrics.a.c(toServiceMsg, fromServiceMsg);
            }
        }
    }

    private void U3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String str;
        String serviceCmd = toServiceMsg.getServiceCmd();
        String string = toServiceMsg.extraData.getString("uin");
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        long j17 = toServiceMsg.extraData.getLong("uniseq");
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        int i16 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        int i17 = toServiceMsg.extraData.getInt("retryIndex");
        int H = com.tencent.mobileqq.service.message.p.H(i16, this.Q);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            str = WadlProxyConsts.PARAM_TIME_OUT;
            sb5.append("<PbSendMsg><E><---handleSendDisMessageError: ---cmd:");
            sb5.append(serviceCmd);
            sb5.append(" ssoseq:");
            sb5.append(fromServiceMsg.getRequestSsoSeq());
            sb5.append(" appseq:");
            sb5.append(fromServiceMsg.getAppSeq());
            sb5.append(",sendC2CMessage error : peerUin:");
            sb5.append(string);
            sb5.append(" uniseq:");
            sb5.append(j17);
            sb5.append(" msgSeq:");
            sb5.append(j3);
            sb5.append(" msgType:");
            sb5.append(i3);
            sb5.append(" uinType:");
            sb5.append(H);
            sb5.append(" routingType:");
            sb5.append(i16);
            sb5.append(" retryIndex:");
            sb5.append(i17);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        } else {
            str = WadlProxyConsts.PARAM_TIME_OUT;
        }
        com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j17);
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                Object[] objArr = {toServiceMsg.extraData.getString("uToUin"), 3000, 0, toServiceMsg.getAttribute("sendmsgHandler"), Long.valueOf(toServiceMsg.extraData.getLong(str)), Long.valueOf(j17)};
                s5(objArr, fromServiceMsg.getUin(), fromServiceMsg.getResultCode());
                notifyBusiness(3008, false, objArr);
                if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
                    int i18 = toServiceMsg.extraData.getInt("retryIndex", 0);
                    StatictisInfo statictisInfo = new StatictisInfo();
                    statictisInfo.errCode = fromServiceMsg.getResultCode();
                    statictisInfo.retryCount = i18;
                    statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                    notifyCallBack(toServiceMsg, 5006, false, new Object[]{Long.valueOf(j17), statictisInfo});
                }
                com.tencent.mobileqq.app.handler.d.f(this, toServiceMsg, fromServiceMsg, false);
                removeSendMessageHandler(j3);
                com.tencent.mobileqq.statistics.tianjige.metrics.a.c(toServiceMsg, fromServiceMsg);
            }
        }
    }

    @android.support.annotation.Nullable
    private msg_svc$PbSendMsgResp W3(Object obj) {
        String arrays;
        try {
            return new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---handleSendDiscussionMsgRespPB:");
                if (obj == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString((byte[]) obj);
                }
                sb5.append(arrays);
                QLog.e("Q.msg.MessageHandler", 2, sb5.toString(), e16);
            }
            return null;
        }
    }

    private int X3(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp) {
        if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.result.has()) {
            if (msg_svc_pbsendmsgresp.result.get() != 0) {
                return msg_svc_pbsendmsgresp.result.get();
            }
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB did not return a valid result code, use 4 instead.");
        }
        return 4;
    }

    private void X4(long j3, String str, String str2, int i3, String str3) {
        MessageRecord P = this.Q.getMessageFacade().P(str2, i3, j3);
        if (P == null) {
            return;
        }
        P.saveExtInfoToExtStr(str3, str);
        this.Q.getMessageFacade().a1(str2, i3, j3, AppConstants.Key.COLUMN_EXT_STR, P.extStr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean Y3(int i3) {
        if (i3 != 0) {
            if (i3 == 35) {
                return false;
            }
            if (i3 != 241) {
                switch (i3) {
                }
            }
        }
        return true;
    }

    private void Z3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, long j3, boolean z16) {
        if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
            int i16 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            if (z16) {
                statictisInfo.errCode = fromServiceMsg.getResultCode();
                statictisInfo.retryCount = i16 + 1;
            } else {
                statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
                statictisInfo.retryCount = i16 + 1;
                statictisInfo.detailErrorReason = i3;
                statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
            }
            statictisInfo.reportSucc = 1;
            notifyCallBack(toServiceMsg, 5006, z16, new Object[]{Long.valueOf(j3), statictisInfo});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z4(String str, String str2, byte b16, boolean z16, String str3, long j3, long j16, long j17) {
        ToServiceMsg createToServiceMsg = createToServiceMsg("AccostSvc.ClientMsg");
        createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
        createToServiceMsg.extraData.putLong("to", Long.valueOf(str).longValue());
        createToServiceMsg.extraData.putString("msg", str2);
        createToServiceMsg.extraData.putByte("cType", b16);
        createToServiceMsg.extraData.putBoolean("hello", z16);
        createToServiceMsg.extraData.putString("pyNickname", str3);
        createToServiceMsg.extraData.putLong("uniseq", j16);
        createToServiceMsg.extraData.putLong("msgSeq", j3);
        createToServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, j17);
        createToServiceMsg.setTimeout(j17);
        send(createToServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, long j3, String str, int i3) {
        long j16;
        String str2;
        MessageRecord w06 = this.Q.getMessageFacade().w0(str, i3, j3);
        if (w06 instanceof RecommendCommonMessage) {
            if (msg_svc_pbsendmsgresp.text_analysis_result.has() && msg_svc_pbsendmsgresp.text_analysis_result.get() == 1) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---handleSendDiscussionMsgRespPB text_analysis_result=" + str2);
            }
            w06.saveExtInfoToExtStr("ark_text_analysis_flag", str2);
        }
        toServiceMsg.extraData.putBoolean("isJuhuaExist", com.tencent.mobileqq.service.message.e.r1(this.Q.getMsgCache().G1(toServiceMsg.extraData.getString("uToUin"), 3000, j3)));
        long j17 = toServiceMsg.extraData.getLong("msg_request_time", 0L);
        if (j17 > 0) {
            if (fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null && fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) != null) {
                long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                if (longValue < 0) {
                    longValue = 0;
                }
                if (longValue <= TTL.MAX_VALUE) {
                    j16 = longValue;
                    MessageHandlerConstants.MsgSendCostParams msgSendCostParams = new MessageHandlerConstants.MsgSendCostParams();
                    msgSendCostParams.mMsgNetsendToNetrecv = j16;
                    long currentTimeMillis = System.currentTimeMillis();
                    msgSendCostParams.mMsgNotifyUiTime = currentTimeMillis;
                    msgSendCostParams.mMsgRequestToResponse = currentTimeMillis - j17;
                    msgSendCostParams.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                    msgSendCostParams.mUinType = 3000;
                    Boolean bool = Boolean.FALSE;
                    msgSendCostParams.isCrossOper = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool)).booleanValue();
                    msgSendCostParams.isSentByXG = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool)).booleanValue();
                    msgSendCostParams.isWeaknet = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue();
                    if (w06 != null) {
                        msgSendCostParams.msgType = w06.msgtype;
                    }
                    com.tencent.mobileqq.app.handler.receivesuccess.z.a(fromServiceMsg, msgSendCostParams);
                    notifyUI(6003, true, new Object[]{toServiceMsg.extraData.getString("uToUin"), String.valueOf(j3), msgSendCostParams});
                }
            }
            j16 = 0;
            MessageHandlerConstants.MsgSendCostParams msgSendCostParams2 = new MessageHandlerConstants.MsgSendCostParams();
            msgSendCostParams2.mMsgNetsendToNetrecv = j16;
            long currentTimeMillis2 = System.currentTimeMillis();
            msgSendCostParams2.mMsgNotifyUiTime = currentTimeMillis2;
            msgSendCostParams2.mMsgRequestToResponse = currentTimeMillis2 - j17;
            msgSendCostParams2.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
            msgSendCostParams2.mUinType = 3000;
            Boolean bool2 = Boolean.FALSE;
            msgSendCostParams2.isCrossOper = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool2)).booleanValue();
            msgSendCostParams2.isSentByXG = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool2)).booleanValue();
            msgSendCostParams2.isWeaknet = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool2)).booleanValue();
            if (w06 != null) {
            }
            com.tencent.mobileqq.app.handler.receivesuccess.z.a(fromServiceMsg, msgSendCostParams2);
            notifyUI(6003, true, new Object[]{toServiceMsg.extraData.getString("uToUin"), String.valueOf(j3), msgSendCostParams2});
        } else {
            notifyUI(6003, true, new String[]{toServiceMsg.extraData.getString("uToUin"), String.valueOf(j3)});
        }
        com.tencent.mobileqq.statistics.tianjige.tracers.a.b(toServiceMsg, fromServiceMsg);
        q5(w06);
    }

    private void a5(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, long j3, int i3, BusinessObserver businessObserver, boolean z16) {
        long length;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "sendHCTopicMessageInner");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = messageRecord.f203106msg;
        if (str == null) {
            length = 0;
        } else {
            length = str.getBytes().length;
        }
        oidb_0xa89$ReqBody oidb_0xa89_reqbody = new oidb_0xa89$ReqBody();
        oidb_0xa89_reqbody.bytes_msg_body.set(ByteStringMicro.copyFrom(msg_svc_pbsendmsgreq.toByteArray()));
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xa89", 2697, 1, oidb_0xa89_reqbody.toByteArray(), j3, businessObserver, false);
        makeOIDBPkg.extraData.putString("uin", messageRecord.frienduin);
        makeOIDBPkg.extraData.putLong("msgsize", length);
        makeOIDBPkg.extraData.putLong("uniseq", messageRecord.uniseq);
        makeOIDBPkg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, j3);
        makeOIDBPkg.extraData.putLong("msgSeq", messageRecord.msgseq);
        makeOIDBPkg.extraData.putLong("startTime", currentTimeMillis);
        makeOIDBPkg.extraData.putInt("retryIndex", i3);
        makeOIDBPkg.extraData.putInt("uintype", messageRecord.istroop);
        makeOIDBPkg.extraData.putInt(AppConstants.Key.COLUMN_MSG_TYPE, messageRecord.msgtype);
        makeOIDBPkg.extraData.putString("groupuin", messageRecord.frienduin);
        if (com.tencent.imcore.message.ad.I(messageRecord.msgtype)) {
            makeOIDBPkg.extraData.putBoolean("RichNotify", true);
        }
        makeOIDBPkg.extraData.putInt("ROUNTING_TYPE", 21);
        makeOIDBPkg.extraData.putInt("send_msg_req_size", makeOIDBPkg.getWupBuffer().length);
        makeOIDBPkg.extraData.putLong("msg_request_time", messageRecord.time);
        makeOIDBPkg.addAttribute(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(messageRecord.msgtype));
        makeOIDBPkg.addAttribute("msgSeq", Long.valueOf(messageRecord.msgseq));
        makeOIDBPkg.addAttribute("resend_by_user", Boolean.valueOf(z16));
        makeOIDBPkg.addAttribute("retryIndex", Integer.valueOf(i3));
        String str2 = messageRecord.frienduin;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        makeOIDBPkg.addAttribute("uin", str2);
        String str4 = messageRecord.senderuin;
        if (str4 != null) {
            str3 = str4;
        }
        makeOIDBPkg.addAttribute("fromUin", str3);
        makeOIDBPkg.addAttribute("normal_msg", Boolean.TRUE);
        sendPBReqWithRemindSlowNetwork(makeOIDBPkg);
    }

    private void b5(MessageRecord messageRecord, bs bsVar) {
        com.tencent.biz.pubaccount.util.m.c().h(this.Q, messageRecord, bsVar, false);
    }

    @NotNull
    private msg_svc$PbGetMsgReq d3(int i3, int i16, Object obj, byte[] bArr, byte b16) {
        RequestPushNotify requestPushNotify;
        byte[] bArr2;
        msg_svc$PbGetMsgReq msg_svc_pbgetmsgreq = new msg_svc$PbGetMsgReq();
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    msg_svc_pbgetmsgreq.msg_req_type.set(2);
                    byte[] E0 = this.f194809f.E0();
                    if (E0 != null) {
                        msg_svc_pbgetmsgreq.pubaccount_cookie.set(ByteStringMicro.copyFrom(E0));
                    }
                }
            } else {
                msg_svc_pbgetmsgreq.msg_req_type.set(1);
                if (bArr != null) {
                    msg_svc_pbgetmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
                }
            }
        } else {
            msg_svc_pbgetmsgreq.msg_req_type.set(0);
            if (bArr != null) {
                msg_svc_pbgetmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
            }
        }
        msg_svc_pbgetmsgreq.sync_flag.set(i3);
        msg_svc_pbgetmsgreq.ramble_flag.set(0);
        msg_svc_pbgetmsgreq.context_flag.set(1);
        msg_svc_pbgetmsgreq.online_sync_flag.set(b16);
        msg_svc_pbgetmsgreq.latest_ramble_number.set(20);
        msg_svc_pbgetmsgreq.other_ramble_number.set(3);
        msg_svc_pbgetmsgreq.nt_flag.set(1);
        if (obj != null && (obj instanceof RequestPushNotify) && (bArr2 = (requestPushNotify = (RequestPushNotify) obj).bytes_server_buf) != null) {
            msg_svc_pbgetmsgreq.bytes_server_buf.set(ByteStringMicro.copyFrom(bArr2));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage (PushNotify getMsg) pb:", "MessageSvc.PbGetMsg", ", fill bytes_server_buf=", requestPushNotify.bytes_server_buf.toString());
            }
        }
        return msg_svc_pbgetmsgreq;
    }

    private void e4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String str;
        String serviceCmd = toServiceMsg.getServiceCmd();
        String string = toServiceMsg.extraData.getString("uin");
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        long j17 = toServiceMsg.extraData.getLong("uniseq");
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        int i16 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        int i17 = toServiceMsg.extraData.getInt("retryIndex");
        int H = com.tencent.mobileqq.service.message.p.H(i16, this.Q);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            str = WadlProxyConsts.PARAM_TIME_OUT;
            sb5.append("<PbSendMsg><E><---handleSendGrpMessageError: ---cmd:");
            sb5.append(serviceCmd);
            sb5.append(" ssoseq:");
            sb5.append(fromServiceMsg.getRequestSsoSeq());
            sb5.append(" appseq:");
            sb5.append(fromServiceMsg.getAppSeq());
            sb5.append(",sendC2CMessage error : peerUin:");
            sb5.append(string);
            sb5.append(" uniseq:");
            sb5.append(j17);
            sb5.append(" msgSeq:");
            sb5.append(j3);
            sb5.append(" msgType:");
            sb5.append(i3);
            sb5.append(" uinType:");
            sb5.append(H);
            sb5.append(" routingType:");
            sb5.append(i16);
            sb5.append(" retryIndex:");
            sb5.append(i17);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        } else {
            str = WadlProxyConsts.PARAM_TIME_OUT;
        }
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j17);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                Object[] objArr = {toServiceMsg.extraData.getString("groupuin"), 1, 0, toServiceMsg.getAttribute("sendmsgHandler"), Long.valueOf(toServiceMsg.extraData.getLong(str)), Long.valueOf(j17)};
                s5(objArr, fromServiceMsg.getUin(), fromServiceMsg.getResultCode());
                notifyBusiness(3002, false, objArr);
                if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
                    int i18 = toServiceMsg.extraData.getInt("retryIndex", 0);
                    StatictisInfo statictisInfo = new StatictisInfo();
                    statictisInfo.errCode = fromServiceMsg.getResultCode();
                    statictisInfo.retryCount = i18;
                    statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                    notifyCallBack(toServiceMsg, 5006, false, new Object[]{Long.valueOf(j17), statictisInfo});
                }
                com.tencent.mobileqq.app.handler.d.i(this, toServiceMsg, fromServiceMsg, false);
                removeSendMessageHandler(j3);
                com.tencent.mobileqq.statistics.tianjige.metrics.a.c(toServiceMsg, fromServiceMsg);
            }
        }
    }

    private Pair<Long, Long> f3(String str, int i3, long j3, long j16, long j17, long j18) {
        long j19 = j3;
        long j26 = j18;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "getPullMsgLowSeq uin = " + str + " ,type = " + i3 + " ,lastSeq = " + j19 + " ,expiredSeq = " + j16 + " ,delSeq = " + j17 + " ,svrSeq = " + j26);
        }
        List<MessageRecord> h16 = com.tencent.imcore.message.ad.h(this.Q.getMessageFacade().Q(str, i3), false);
        if (h16 != null && !h16.isEmpty()) {
            if (h16.get(h16.size() - 1).shmsgseq < j19) {
                j19 = h16.get(h16.size() - 1).shmsgseq;
            }
            if (h16.get(h16.size() - 1).shmsgseq > j26) {
                j26 = h16.get(h16.size() - 1).shmsgseq;
            }
        }
        long max = Math.max(j17, j16);
        long j27 = j26 - j19;
        long max2 = Math.max(max, j19);
        long max3 = Math.max(max, j26);
        if (max >= max2) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastSeq");
            }
            return new Pair<>(Long.valueOf(max), Long.valueOf(max3));
        }
        if (j27 >= 10) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "return pullCount >= 10");
            }
            return new Pair<>(Long.valueOf(max2), Long.valueOf(max3));
        }
        if (h16 != null && !h16.isEmpty()) {
            long j28 = h16.get(0).shmsgseq;
            if (max + 1 >= j28) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "return lowSeq >= lastBreakSeq");
                }
                return new Pair<>(Long.valueOf(max2), Long.valueOf(max3));
            }
            if (max3 - j28 >= 10) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "return svrSeq - lastBreakSeq >= 10");
                }
                return new Pair<>(Long.valueOf(max2), Long.valueOf(max3));
            }
            if (max3 > max2) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq > lastSeq , (" + Math.max(max3 - 10, max) + "," + max3 + ")");
                }
                return new Pair<>(Long.valueOf(Math.max(max3 - 10, max)), Long.valueOf(max3));
            }
            if (max3 == max2) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "return ok svrSeq == lastSeq , (" + Math.max(max3 - 10, max) + "," + Math.max(j28 - 1, max) + ")");
                }
                return new Pair<>(Long.valueOf(Math.max(max3 - 10, max)), Long.valueOf(Math.max(j28 - 1, max)));
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "return svrSeq < lastSeq");
            }
            return new Pair<>(Long.valueOf(max2), Long.valueOf(max3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "return local is null! ");
        }
        return new Pair<>(Long.valueOf(max2), Long.valueOf(max3));
    }

    @android.support.annotation.Nullable
    private msg_svc$PbSendMsgResp g4(Object obj) {
        String arrays;
        try {
            return new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---handleSendTroopMessageRespPB:");
                if (obj == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString((byte[]) obj);
                }
                sb5.append(arrays);
                QLog.e("Q.msg.MessageHandler", 2, sb5.toString(), e16);
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, long j3, int i3) {
        long j16;
        String str2;
        MessageRecord w06 = this.Q.getMessageFacade().w0(str, i3, j3);
        if (w06 instanceof RecommendCommonMessage) {
            if (msg_svc_pbsendmsgresp.text_analysis_result.has() && msg_svc_pbsendmsgresp.text_analysis_result.get() == 1) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB text_analysis_result=" + str2);
            }
            w06.saveExtInfoToExtStr("ark_text_analysis_flag", str2);
        }
        if (w06 != null) {
            w06.setExtraFlag(0);
            w06.saveExtInfoToExtStr("key_troop_sending_message_success", "1");
            this.Q.getMessageProxy(1).x(str, i3, j3);
            this.Q.getMessageProxy(1).N(str, i3, w06);
            EntityManager createEntityManager = this.Q.getEntityManagerFactory().createEntityManager();
            createEntityManager.update(w06);
            createEntityManager.close();
        }
        toServiceMsg.extraData.putBoolean("isJuhuaExist", com.tencent.mobileqq.service.message.e.r1(this.Q.getMsgCache().G1(toServiceMsg.extraData.getString("groupuin"), 1, j3)));
        long j17 = toServiceMsg.extraData.getLong("msg_request_time", 0L);
        if (j17 > 0) {
            if (fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null && fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) != null) {
                long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                if (longValue < 0) {
                    longValue = 0;
                }
                if (longValue <= TTL.MAX_VALUE) {
                    j16 = longValue;
                    MessageHandlerConstants.MsgSendCostParams msgSendCostParams = new MessageHandlerConstants.MsgSendCostParams();
                    msgSendCostParams.mMsgNetsendToNetrecv = j16;
                    long currentTimeMillis = System.currentTimeMillis();
                    msgSendCostParams.mMsgNotifyUiTime = currentTimeMillis;
                    msgSendCostParams.mMsgRequestToResponse = currentTimeMillis - j17;
                    msgSendCostParams.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                    msgSendCostParams.mUinType = 1;
                    Boolean bool = Boolean.FALSE;
                    msgSendCostParams.isCrossOper = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool)).booleanValue();
                    msgSendCostParams.isSentByXG = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool)).booleanValue();
                    msgSendCostParams.isWeaknet = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue();
                    if (w06 != null) {
                        msgSendCostParams.msgType = w06.msgtype;
                    }
                    com.tencent.mobileqq.app.handler.receivesuccess.z.a(fromServiceMsg, msgSendCostParams);
                    notifyUI(6003, true, new Object[]{toServiceMsg.extraData.getString("groupuin"), String.valueOf(j3), msgSendCostParams});
                }
            }
            j16 = 0;
            MessageHandlerConstants.MsgSendCostParams msgSendCostParams2 = new MessageHandlerConstants.MsgSendCostParams();
            msgSendCostParams2.mMsgNetsendToNetrecv = j16;
            long currentTimeMillis2 = System.currentTimeMillis();
            msgSendCostParams2.mMsgNotifyUiTime = currentTimeMillis2;
            msgSendCostParams2.mMsgRequestToResponse = currentTimeMillis2 - j17;
            msgSendCostParams2.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
            msgSendCostParams2.mUinType = 1;
            Boolean bool2 = Boolean.FALSE;
            msgSendCostParams2.isCrossOper = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool2)).booleanValue();
            msgSendCostParams2.isSentByXG = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool2)).booleanValue();
            msgSendCostParams2.isWeaknet = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool2)).booleanValue();
            if (w06 != null) {
            }
            com.tencent.mobileqq.app.handler.receivesuccess.z.a(fromServiceMsg, msgSendCostParams2);
            notifyUI(6003, true, new Object[]{toServiceMsg.extraData.getString("groupuin"), String.valueOf(j3), msgSendCostParams2});
        } else {
            notifyUI(6003, true, new String[]{toServiceMsg.extraData.getString("groupuin"), String.valueOf(j3)});
        }
        com.tencent.mobileqq.statistics.tianjige.tracers.a.b(toServiceMsg, fromServiceMsg);
        q5(w06);
    }

    private boolean i3(String str, int i3, TroopManager troopManager, Object[] objArr) {
        if (i3 == 0 || i3 == 241) {
            return true;
        }
        switch (i3) {
            case 101:
            case 102:
            case 103:
                RecentUserProxy m3 = this.Q.getProxyManager().m();
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(str, 1);
                if (findRecentUserByUin != null) {
                    m3.delRecentUser(findRecentUserByUin);
                }
                notifyBusiness(1002, true, objArr);
                notifyBusiness(2001, true, objArr);
                notifyBusiness(2002, true, objArr);
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i5(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, long j3, int i3, BusinessObserver businessObserver, boolean z16) {
        if (messageRecord.istroop == 1026) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.MessageHandler", 2, "sendRichTextMessageInner");
            }
            a5(messageRecord, msg_svc_pbsendmsgreq, j3, i3, businessObserver, z16);
        } else {
            ToServiceMsg R2 = R2(messageRecord, msg_svc_pbsendmsgreq, j3, i3, businessObserver, z16);
            if (AppSetting.B()) {
                this.Q.getParcelHooker().printSendParams(R2);
            }
            com.tencent.mobileqq.statistics.tianjige.tracers.a.f(R2, messageRecord, z16, i3, j3);
            sendPBReqWithRemindSlowNetwork(R2);
        }
    }

    public static int k3(int i3) {
        if (i3 == 0) {
            return 3001;
        }
        if (i3 != 1) {
            if (i3 != 1000) {
                if (i3 != 1026) {
                    if (i3 != 3000) {
                        if (i3 != 10008) {
                            if (i3 != 10010) {
                                if (i3 != 1009) {
                                    if (i3 != 1010) {
                                        if (i3 != 1023) {
                                            if (i3 != 1024) {
                                                switch (i3) {
                                                    case 1004:
                                                        return 8002;
                                                    case 1005:
                                                        return 7000;
                                                    case 1006:
                                                        return 8005;
                                                    default:
                                                        return 3001;
                                                }
                                            }
                                            return 8010;
                                        }
                                        return MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
                                    }
                                    return 8012;
                                }
                                return MessageHandlerConstants.NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP;
                            }
                            return MessageHandlerConstants.NOTIFY_TYPE_QQ_AUDIO_ROOM_RESP;
                        }
                        return MessageHandlerConstants.NOTIFY_TYPE_QQ_CIRCLE_RESP;
                    }
                    return 3008;
                }
                return 3013;
            }
            return 6000;
        }
        return 3002;
    }

    private void m4(String str, String str2) {
        this.f194809f.V1(str, 2);
        ArrayList<Object[]> f16 = this.f194809f.f1(str);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "----------handleTroopMsgResponseFinishedAndNotify troopUin: " + str + ", funcName:" + str2);
        }
        if (f16 != null && f16.size() > 0) {
            this.f194809f.H1(str);
            Iterator<Object[]> it = f16.iterator();
            while (it.hasNext()) {
                Object[] next = it.next();
                if (next != null && next.length >= 2) {
                    getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP).t(1001, next, null, Boolean.FALSE);
                }
            }
        }
        GroupMsgReadedNotify x16 = this.f194809f.x1(str);
        if (x16 != null) {
            ((com.tencent.mobileqq.troop.data.y) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP)).A(x16);
        }
    }

    private void m5(boolean z16) {
        this.C = z16;
    }

    private WorkerHandler o3() {
        if (this.G == null) {
            synchronized (this.H) {
                if (this.G == null) {
                    this.G = new WorkerHandler(this, ThreadManagerV2.getSubThreadLooper());
                }
            }
        }
        return this.G;
    }

    private void o5(String str) {
        com.tencent.mobileqq.troop.utils.bh bhVar = (com.tencent.mobileqq.troop.utils.bh) this.Q.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if (bhVar != null) {
            bhVar.e(str);
        }
    }

    private boolean onReceiveFailed(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str) {
        if (msgCmdFilter(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "cmdfilter error=" + str);
            }
            return true;
        }
        if (fromServiceMsg.getResultCode() != 1002 && fromServiceMsg.getResultCode() != 1013) {
            if (fromServiceMsg.getResultCode() != 1000) {
                handleError(toServiceMsg, fromServiceMsg);
                return true;
            }
            if (this.f194803a0) {
                return true;
            }
            return false;
        }
        com.tencent.mobileqq.app.handler.receivetimeout.a.a(this, toServiceMsg, fromServiceMsg);
        return true;
    }

    private void onReceiveSuccess(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, String str) {
        dispatchRespToProcessor(str, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.m.a(this, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.h.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.ae.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.l.a(this, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.aa.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.c.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.n.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.u.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.v.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.x.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.ac.a(this, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.z.e(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.y.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.ab.a(this.Q, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.w.b(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.d.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.t.a(this, toServiceMsg, fromServiceMsg);
        com.tencent.mobileqq.app.handler.receivesuccess.b.a(this, toServiceMsg, fromServiceMsg);
        com.tencent.mobileqq.app.handler.receivesuccess.f.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.a.a(this, toServiceMsg, fromServiceMsg);
        com.tencent.mobileqq.app.handler.receivesuccess.ad.a(this.Q, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.k.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.i.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.g.a(this, toServiceMsg, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.s.a(this, fromServiceMsg, obj);
        com.tencent.mobileqq.app.handler.receivesuccess.p.a(this, fromServiceMsg);
        com.tencent.mobileqq.app.handler.receivesuccess.o.a(this, fromServiceMsg);
        com.tencent.mobileqq.app.handler.receivesuccess.q.a(this.Q, obj, str);
        com.tencent.mobileqq.app.handler.receivesuccess.j.b(this, toServiceMsg, fromServiceMsg, obj, str);
        com.tencent.mobileqq.app.handler.receivesuccess.r.b(this, toServiceMsg, fromServiceMsg, obj, str);
    }

    private void p4(String str) {
        com.tencent.mobileqq.service.message.c.a(this.Q, str);
        ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlackedFlag(str, true);
    }

    private void p5(ArrayList<Long> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(com.tencent.mobileqq.utils.h.g(it.next().longValue()));
        }
        v3(arrayList2);
    }

    private boolean r4() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105886", false);
    }

    private boolean s4(MessageRecord messageRecord) {
        boolean z16 = false;
        if (messageRecord == null) {
            QLog.i("Q.msg.MessageHandler", 1, "[isTroopODMsgRecord] mr == null");
            return false;
        }
        if (messageRecord.istroop == 1 && messageRecord.msgtype == -2016) {
            z16 = true;
        }
        QLog.i("Q.msg.MessageHandler", 1, "[isTroopODMsgRecord] rtn = " + z16);
        return z16;
    }

    private void t3(String str, String str2) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("handleDiscMsgResponseFinishAndNotify uin = ");
            sb5.append(str);
            sb5.append(", funcName=");
            sb5.append(str2);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        this.f194809f.P1(str, 2);
        ArrayList<Object[]> v06 = this.f194809f.v0(str);
        if (v06 != null && !v06.isEmpty()) {
            ArrayList arrayList = new ArrayList(v06);
            this.f194809f.B1(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object[] objArr = (Object[]) it.next();
                if (objArr != null && objArr.length >= 3) {
                    getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC).t(1001, objArr[0], objArr[1], objArr[2], Boolean.FALSE);
                }
            }
        }
        DisMsgReadedNotify w16 = this.f194809f.w1(str);
        if (w16 != null) {
            ((DiscMessageProcessor) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC)).d0(w16);
        }
    }

    private boolean t4(boolean z16) {
        synchronized (this.E) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgGetting: " + this.f194812m);
            }
            if (this.f194812m) {
                return true;
            }
            setMsgGetting(true);
            m5(z16);
            return false;
        }
    }

    private boolean u4() {
        synchronized (this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "----------handlePAMsgGetting: " + this.D);
            }
            if (this.D) {
                return true;
            }
            setPAMsgGetting(true);
            return false;
        }
    }

    private void z4(String str, int i3, boolean z16) {
        if (i3 == 1000 && str != null && QLog.isColorLevel()) {
            QLog.d("notification", 2, "funName:" + str + ",isSuccess:" + z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0227 A[Catch: all -> 0x0286, TryCatch #2 {, blocks: (B:26:0x0139, B:28:0x013f, B:30:0x0141, B:35:0x0166, B:36:0x025b, B:37:0x0266, B:47:0x01a7, B:48:0x01b4, B:51:0x01f2, B:53:0x01fa, B:55:0x020b, B:57:0x0217, B:59:0x021d, B:61:0x0221, B:63:0x0227, B:64:0x0250, B:65:0x01b8, B:66:0x01bf, B:41:0x0180, B:43:0x0186, B:77:0x026a, B:78:0x0285, B:79:0x027b, B:73:0x01d8, B:74:0x01e6, B:45:0x0191, B:69:0x01c7, B:71:0x01cd), top: B:25:0x0139, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbGetDiscussMsgResp msg_svc_pbgetdiscussmsgresp;
        String valueOf;
        String str;
        com.tencent.mobileqq.service.message.e eVar;
        String valueOf2;
        RegisterProxyHandler registerProxyHandler;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String str2 = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR);
        try {
            msg_svc_pbgetdiscussmsgresp = new msg_svc$PbGetDiscussMsgResp().mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "Exception occurs while parsing the byte array.");
            }
            msg_svc_pbgetdiscussmsgresp = null;
        }
        if (msg_svc_pbgetdiscussmsgresp == null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.Q.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap<>(), "");
            z3(toServiceMsg, fromServiceMsg);
            return;
        }
        boolean z16 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
        boolean z17 = toServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
        new ArrayList();
        boolean z18 = toServiceMsg.extraData.getBoolean("isRefreshHead", false);
        long j3 = toServiceMsg.extraData.getLong("lDisUin", msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGetPullDiscussionMsgResp_PB res.cReplyCode = ");
            sb5.append(msg_svc_pbgetdiscussmsgresp.result.get());
            sb5.append(" discussUin: ");
            sb5.append(j3);
            sb5.append(" isRefreshHead: ");
            sb5.append(z18);
            sb5.append(", dataHash=@");
            sb5.append(Integer.toHexString(obj.hashCode()));
            sb5.append(" rtnBeginSeq:");
            sb5.append(msg_svc_pbgetdiscussmsgresp.return_begin_seq.get());
            sb5.append(" rtnEndSeq:");
            sb5.append(msg_svc_pbgetdiscussmsgresp.return_end_seq.get());
            if (msg_svc_pbgetdiscussmsgresp.f417533msg.get() != null) {
                sb5.append(" msgSize:");
                sb5.append(msg_svc_pbgetdiscussmsgresp.f417533msg.get().size());
            } else {
                sb5.append(" msg:null.");
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
            }
        }
        synchronized (getMessageHandleThreadSyncLock(String.valueOf(j3), 3000)) {
            if (L4(toServiceMsg, msg_svc_pbgetdiscussmsgresp)) {
                return;
            }
            ArrayList<msg_comm$Msg> S0 = this.f194809f.S0(msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
            this.f194809f.q(String.valueOf(j3), msg_svc_pbgetdiscussmsgresp.discuss_info_seq.get(), msg_svc_pbgetdiscussmsgresp.last_get_time.get());
            try {
                if (z18) {
                    try {
                        getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC).t(1003, toServiceMsg, S0, msg_svc_pbgetdiscussmsgresp, str2);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp refreshDiscussionHead exception ! ", e16);
                        }
                    }
                    this.f194809f.E1(msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
                    return;
                }
                try {
                    getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC).t(1002, toServiceMsg, S0, msg_svc_pbgetdiscussmsgresp);
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp initGetPullDiscussionMsg exception ! ", e17);
                    }
                    if (z17) {
                        this.mRegisterProxyHandler.recvDiscNum++;
                        eVar = this.f194809f;
                        valueOf2 = String.valueOf(j3);
                    } else {
                        valueOf = String.valueOf(j3);
                        str = "handleGetPullDiscussionMsgResp";
                    }
                }
                if (z17) {
                    this.mRegisterProxyHandler.recvDiscNum++;
                    eVar = this.f194809f;
                    valueOf2 = String.valueOf(j3);
                    eVar.P1(valueOf2, 2);
                    if (!z16 && this.f194809f.l1()) {
                        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
                        notifyUI(4002, true, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN ");
                        }
                    } else if (z17 && (i3 = (registerProxyHandler = this.mRegisterProxyHandler).discussionNum) != 0 && registerProxyHandler.recvDiscNum >= i3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MessageHandler", 2, "<--- handleGetPullDiscussionMsgResp notify NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN , discussionNum:" + this.mRegisterProxyHandler.discussionNum + " , recvDiscNum:" + this.mRegisterProxyHandler.recvDiscNum);
                        }
                        MsgAutoMonitorUtil.getInstance().markDisFinishTime();
                        notifyUI(4002, true, null);
                    }
                    this.f194809f.E1(msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
                    return;
                }
                valueOf = String.valueOf(j3);
                str = "handleGetPullDiscussionMsgResp";
                t3(valueOf, str);
                if (!z16) {
                }
                if (z17) {
                    if (QLog.isColorLevel()) {
                    }
                    MsgAutoMonitorUtil.getInstance().markDisFinishTime();
                    notifyUI(4002, true, null);
                }
                this.f194809f.E1(msg_svc_pbgetdiscussmsgresp.discuss_uin.get());
                return;
            } catch (Throwable th5) {
                if (z17) {
                    this.mRegisterProxyHandler.recvDiscNum++;
                    this.f194809f.P1(String.valueOf(j3), 2);
                } else {
                    t3(String.valueOf(j3), "handleGetPullDiscussionMsgResp");
                }
                throw th5;
            }
        }
    }

    public void B3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, boolean z16) {
        String uin;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, this, toServiceMsg, fromServiceMsg, obj, Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        msg_svc$PbGetGroupMsgResp C3 = C3((byte[]) obj);
        if (C3 == null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.Q.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap<>(), "");
        }
        if (C3 != null && obj != null) {
            int i3 = toServiceMsg.extraData.getInt("doSome", 0);
            boolean z17 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
            boolean z18 = toServiceMsg.extraData.getBoolean("used_new_register_proxy", false);
            if (toServiceMsg.getUin() == null) {
                uin = this.Q.getCurrentAccountUin();
            } else {
                uin = toServiceMsg.getUin();
            }
            String str = uin;
            String string = toServiceMsg.extraData.getString("groupuin");
            if (string != null) {
                j3 = Long.parseLong(string);
            } else {
                j3 = C3.group_code.get();
            }
            long j16 = j3;
            com.tencent.imcore.message.report.a.b(String.valueOf(j16));
            boolean z19 = toServiceMsg.extraData.getBoolean("isRefreshHead", false);
            G3(obj, z16, C3, i3, j16, z19);
            synchronized (getMessageHandleThreadSyncLock(String.valueOf(j16), 1)) {
                D3(toServiceMsg, currentTimeMillis, C3, i3, z17, z18, str, j16, z19);
            }
            return;
        }
        handleError(toServiceMsg, fromServiceMsg);
    }

    public void F4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
            return;
        }
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (i3 == 0) {
            qQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 264);
            this.R = false;
            Runnable runnable = this.Z;
            if (runnable != null) {
                ThreadManagerV2.remove(runnable);
                this.Z = null;
                return;
            }
            return;
        }
        if (i3 == 2) {
            qQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", NotificationUtil.Constants.NOTIFY_ID_PHONEONLINE_MSG);
            this.T = false;
            Runnable runnable2 = this.Y;
            if (runnable2 != null) {
                ThreadManagerV2.remove(runnable2);
                this.Y = null;
                return;
            }
            return;
        }
        if (i3 == 1) {
            qQNotificationManager.cancel("Q.msg.MessageHandler_OfflineNotifition", 263);
            this.S = false;
            Runnable runnable3 = this.X;
            if (runnable3 != null) {
                ThreadManagerV2.remove(runnable3);
                this.X = null;
            }
        }
    }

    public void G4(Context context, Intent intent) {
        ComponentName componentName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if ("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(action) || "com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(action) || "com.tencent.mobileqq.PHONEDONLINE_CLICK_NOTIFICATION".equals(action)) {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            qQNotificationManager.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 264);
            this.R = false;
            Thread thread = this.U;
            if (thread != null) {
                thread.interrupt();
            }
            qQNotificationManager.cancel("Q.msg.MessageHandler_onReceivePCONLINE_CLICK_NOTIFICATION", 263);
            this.S = false;
            Thread thread2 = this.V;
            if (thread2 != null) {
                thread2.interrupt();
            }
            qQNotificationManager.cancel("Q.msg.MessageHandler_onReceivePHONEONLINE_CLICK_NOTIFICATION", NotificationUtil.Constants.NOTIFY_ID_PHONEONLINE_MSG);
            this.T = false;
            Thread thread3 = this.W;
            if (thread3 != null) {
                thread3.interrupt();
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                componentName = runningTasks.get(0).topActivity;
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "PConline BroadcastReceiver clicked " + componentName.getClassName());
                }
                ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(BaseApplication.getContext(), new Intent(), -1);
                ReportController.o(this.Q, "CliOper", "", "", "My_eq", "PC_Online_notice", 0, 0, "", "", "", "");
            }
        }
    }

    public void H2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) str);
        } else {
            ((FriendsManager) this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
        }
    }

    public void H3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        boolean z16 = toServiceMsg.extraData.getBoolean("isRefreshHead", false);
        boolean z17 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
        String string = toServiceMsg.extraData.getString("groupuin");
        if (z16) {
            Bundle bundle = toServiceMsg.extraData.getBundle("context");
            if (bundle != null) {
                bundle.putBoolean("success", false);
                this.Q.getMessageFacade().g0(string, 1, null, null, bundle);
                return;
            }
            return;
        }
        try {
            m4(string, "handleGetPullTroopMsgError");
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError exception ! ", e16);
            }
        }
        if (z17) {
            if (this.f194809f.m1()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgError notify NOTIFY_TYPE_GET_TROOP_MSG_FIN ");
                }
                notifyUI(4003, false, new String[]{string});
                return;
            }
            this.f194809f.a0();
            return;
        }
        notifyUI(4003, false, new String[]{string});
    }

    public void H4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        if (this.T) {
            return;
        }
        this.T = true;
        BaseApplication context = BaseApplication.getContext();
        String string = context.getString(R.string.f171562o3);
        String string2 = context.getString(R.string.f171562o3);
        Bitmap g16 = com.tencent.mobileqq.util.j.g(context.getResources(), R.drawable.qfile_dataline_user_aio);
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(string2).setContentText("").setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker(string).setWhen(System.currentTimeMillis());
        if (g16 != null) {
            when.setLargeIcon(g16);
        } else {
            when.setLargeIcon(com.tencent.mobileqq.util.j.g(context.getResources(), R.drawable.qfile_dataline_user_aio));
        }
        Intent intent = new Intent("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, NotificationUtil.Constants.NOTIFY_ID_PHONEONLINE_MSG);
        when.setContentIntent(PendingIntent.getBroadcast(context, 0, intent, n5(0)));
        Notification build = when.build();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("Q.msg.MessageHandler_PhonecOnlineNotifition", 264);
            BadgeUtils.p(this.Q.getApp(), 0, build);
            QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_OTHER);
            qQNotificationManager.notify("Q.msg.MessageHandler_PhoneOnlineNotifition", NotificationUtil.Constants.NOTIFY_ID_PHONEONLINE_MSG, build);
            Runnable runnable = new Runnable(qQNotificationManager) { // from class: com.tencent.mobileqq.app.MessageHandler.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQNotificationManager f194824d;

                {
                    this.f194824d = qQNotificationManager;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this, (Object) qQNotificationManager);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        LockMethodProxy.sleep(5000L);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Q.msg.MessageHandler", 4, "Phoneonline time expired cancel now");
                        }
                        this.f194824d.cancel("Q.msg.MessageHandler_PhoneOnlineNotifition", NotificationUtil.Constants.NOTIFY_ID_PHONEONLINE_MSG);
                        MessageHandler.this.T = false;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MessageHandler", 2, "Phoneonline thread Interrupt");
                        }
                        e16.printStackTrace();
                    }
                }
            };
            this.Y = runnable;
            ThreadManagerV2.post(runnable, 5, null, false);
        }
    }

    public void I2(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, (Object) this, (Object) messageRecord);
            return;
        }
        this.Q.getMessageFacade().c(messageRecord, this.Q.getCurrentAccountUin());
        new ArrayList().add(messageRecord);
        v4("addMessageAndNotify", 1000, true, null, 1, needNotifyNotification(!messageRecord.isread), false, null);
    }

    public void I3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String[] stringArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg.extraData.getBoolean("used_register_proxy", false)) {
            RegisterProxyHandler registerProxyHandler = this.mRegisterProxyHandler;
            stringArray = registerProxyHandler.troopUinForRegisterProxyReq;
            registerProxyHandler.troopUinForRegisterProxyReq = null;
        } else {
            stringArray = toServiceMsg.extraData.getStringArray("array_groupuin");
        }
        this.L = 0;
        notifyUI(4003, false, stringArray);
        if (stringArray != null) {
            for (String str : stringArray) {
                try {
                    m4(str, "handleGetPullTroopMsgNumError");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumError exception ! ", e16);
                    }
                }
            }
        }
    }

    public void J2(MessageRecord messageRecord, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, this, messageRecord, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "addMessageAndNotifyForQAV:" + messageRecord.toString());
        }
        if (L2()) {
            this.Q.getMessageFacade().c(messageRecord, this.Q.getCurrentAccountUin());
            new ArrayList().add(messageRecord);
        }
        int i16 = messageRecord.msgtype;
        if (i16 != -4008 && i16 != -2016) {
            if (i16 == -2009 && ((i3 = messageRecord.istroop) == 0 || i3 == 1000 || i3 == 10004 || i3 == 1004 || i3 == 1006 || i3 == 1021 || i3 == 1010 || i3 == 1001 || i3 == 10002)) {
                v4("addMessageAndNotify", 1000, true, null, 1, needNotifyNotification(!z16), false, messageRecord);
                return;
            }
        } else if (messageRecord.istroop == 3000 && i16 == -4008) {
            v4("addMessageAndNotify", 1000, true, null, 1, true, false, messageRecord);
            return;
        } else if (s4(messageRecord)) {
            v4("addMessageAndNotify", 1000, true, null, 1, needNotifyNotification(!z16), false, messageRecord);
            return;
        }
        v4("addMessageAndNotify", 1000, true, null, 1, needNotifyNotification(!z16), false, null);
    }

    public void J3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcResponsePullGroupMsgSeq svcResponsePullGroupMsgSeq) {
        SvcResponsePullGroupMsgSeq svcResponsePullGroupMsgSeq2 = svcResponsePullGroupMsgSeq;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, this, toServiceMsg, fromServiceMsg, svcResponsePullGroupMsgSeq);
            return;
        }
        if (svcResponsePullGroupMsgSeq2 == null) {
            handleError(toServiceMsg, fromServiceMsg);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("doSome", 0);
        boolean z16 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
        StringBuilder sb5 = new StringBuilder();
        if (QLog.isColorLevel()) {
            sb5.append("<<---handleGetPullTroopMsgNumResp msgStruct.cReplyCode: ");
            sb5.append((int) svcResponsePullGroupMsgSeq2.cReplyCode);
            sb5.append(",isUsedRegisterProxy: ");
            sb5.append(z16);
            sb5.append(",doSome: ");
            sb5.append(i3);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        if (svcResponsePullGroupMsgSeq2.cReplyCode != 0) {
            I3(toServiceMsg, fromServiceMsg);
            return;
        }
        RegisterProxyHandler registerProxyHandler = this.mRegisterProxyHandler;
        String[] strArr = registerProxyHandler.troopUinForRegisterProxyReq;
        HashMap hashMap = null;
        registerProxyHandler.troopUinForRegisterProxyReq = null;
        this.L = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        if (z16) {
            hashMap = new HashMap(this.f194809f.e1());
        }
        HashMap hashMap2 = hashMap;
        IPasswdRedBagService c36 = c3();
        HashMap<String, String> hashMap3 = new HashMap<>();
        int i16 = 0;
        while (i16 < svcResponsePullGroupMsgSeq2.vGroupInfo.size()) {
            int i17 = i16;
            HashMap<String, String> hashMap4 = hashMap3;
            HashMap hashMap5 = hashMap2;
            I4(toServiceMsg, fromServiceMsg, svcResponsePullGroupMsgSeq, i3, z16, sb5, arrayList, hashMap5, hashMap4, i17);
            i16 = i17 + 1;
            c36 = c36;
            strArr = strArr;
            hashMap3 = hashMap4;
            hashMap2 = hashMap5;
            sb5 = sb5;
            svcResponsePullGroupMsgSeq2 = svcResponsePullGroupMsgSeq;
        }
        HashMap hashMap6 = hashMap2;
        String[] strArr2 = strArr;
        c36.saveGroupInfos(hashMap3);
        if (z16) {
            A4(strArr2, hashMap6);
        }
    }

    public void K3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        long j16;
        String str;
        String str2;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            handleError(toServiceMsg, fromServiceMsg);
            return;
        }
        int i3 = 2;
        try {
            msg_svc$PbUnReadMsgSeqResp mergeFrom = new msg_svc$PbUnReadMsgSeqResp().mergeFrom((byte[]) obj);
            if (mergeFrom.group_unread_info.has() && mergeFrom.group_unread_info.get() != null) {
                msg_svc$PbPullGroupMsgSeqResp msg_svc_pbpullgroupmsgseqresp = mergeFrom.group_unread_info.get();
                if (msg_svc_pbpullgroupmsgseqresp.result.get() != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: " + msg_svc_pbpullgroupmsgseqresp.result.get() + " ,groupMsgSeqResp.errmsg: " + msg_svc_pbpullgroupmsgseqresp.errmsg.get());
                    }
                    I3(toServiceMsg, fromServiceMsg);
                    return;
                }
                char c16 = 0;
                int i16 = toServiceMsg.extraData.getInt("doSome", 0);
                StringBuilder sb5 = new StringBuilder();
                if (QLog.isColorLevel()) {
                    sb5.append("<<---handleGetPullTroopMsgNumResp_PB groupMsgSeqResp.result: ");
                    sb5.append(msg_svc_pbpullgroupmsgseqresp.result.get());
                    sb5.append(" ,doSome: ");
                    sb5.append(i16);
                    QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
                }
                this.L = 0;
                int i17 = 0;
                while (i17 < msg_svc_pbpullgroupmsgseqresp.group_info_resp.get().size()) {
                    msg_svc$PbPullGroupMsgSeqResp.GroupInfoResp groupInfoResp = msg_svc_pbpullgroupmsgseqresp.group_info_resp.get().get(i17);
                    String valueOf = String.valueOf(groupInfoResp.group_code.get());
                    Object[] C0 = this.f194809f.C0(valueOf);
                    long D0 = this.f194809f.D0(valueOf);
                    if (C0 != null && C0.length > 0) {
                        j3 = ((Long) C0[c16]).longValue();
                    } else {
                        j3 = 0;
                    }
                    long j18 = j3;
                    com.tencent.mobileqq.service.message.e eVar = this.f194809f;
                    Object[] objArr = new Object[i3];
                    objArr[c16] = Long.valueOf(groupInfoResp.member_seq.get());
                    objArr[1] = Long.valueOf(groupInfoResp.group_seq.get());
                    eVar.t(valueOf, objArr);
                    msg_svc$PbPullGroupMsgSeqResp msg_svc_pbpullgroupmsgseqresp2 = msg_svc_pbpullgroupmsgseqresp;
                    com.tencent.mobileqq.statistics.d.f(valueOf, groupInfoResp.group_seq.get(), groupInfoResp.member_seq.get());
                    if (j18 < groupInfoResp.member_seq.get()) {
                        if (r4()) {
                            o5(String.valueOf(groupInfoResp.group_code.get()));
                        } else {
                            this.Q.getMessageFacade().M0(String.valueOf(groupInfoResp.group_code.get()), 1, groupInfoResp.member_seq.get());
                        }
                    }
                    if (QLog.isColorLevel()) {
                        sb5.setLength(0);
                        sb5.append("handleGetPullTroopMsgNumResp_PB getGroupMsgMemberSeq groupUin=");
                        sb5.append(groupInfoResp.group_code.get());
                        sb5.append(" ,memberseq=");
                        sb5.append(groupInfoResp.member_seq.get());
                        sb5.append(" ,groupSeq=");
                        sb5.append(groupInfoResp.group_seq.get());
                        sb5.append(" ,localMemberMsgSeq=");
                        sb5.append(j18);
                        sb5.append(" ,localLastSeq=");
                        sb5.append(D0);
                        sb5.append(", isHotChat=");
                        sb5.append(false);
                        QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
                    }
                    int i18 = i17;
                    int i19 = i16;
                    StringBuilder sb6 = sb5;
                    Pair<Long, Long> f36 = f3(valueOf, 1, this.f194809f.B0(valueOf), this.f194809f.A0(valueOf), this.f194809f.M0(valueOf, 1), groupInfoResp.group_seq.get());
                    int longValue = (int) (((Long) f36.second).longValue() - ((Long) f36.first).longValue());
                    long longValue2 = ((Long) f36.first).longValue() + 1;
                    long longValue3 = ((Long) f36.second).longValue();
                    long j19 = longValue3 - longValue2;
                    long j26 = 10;
                    if (j19 > j26) {
                        j16 = (longValue3 - j26) + 1;
                    } else {
                        j16 = longValue3 - j19;
                    }
                    long j27 = j16;
                    if (QLog.isColorLevel()) {
                        sb6.setLength(0);
                        sb6.append("---------handleGetPullTroopMsgNumResp_PB troopUin: ");
                        str = valueOf;
                        sb6.append(str);
                        sb6.append(" ,msg count: ");
                        sb6.append(longValue);
                        QLog.d("Q.msg.MessageHandler", 2, sb6.toString());
                    } else {
                        str = valueOf;
                    }
                    if (longValue <= 0 && i19 == 8) {
                        if (QLog.isColorLevel()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("handleGetPullTroopMsgNumResp_PB doSome=");
                            sb7.append(i19);
                            sb7.append("  beginSeq:");
                            j17 = j18;
                            sb7.append(j17 - 10);
                            sb7.append(" endSeq:");
                            sb7.append(j17);
                            QLog.d(LogTag.TAG_TROOP_JOIN_SPLIT_MSG, 2, sb7.toString());
                        } else {
                            j17 = j18;
                        }
                        str2 = str;
                        g3(str, j17 - 10, j17, false, null, i19);
                    } else {
                        str2 = str;
                    }
                    if (longValue <= 0) {
                        ((com.tencent.mobileqq.troop.data.y) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP)).z(str2, null, i19);
                    } else {
                        g3(str2, j27, longValue3, false, null, i19);
                    }
                    i17 = i18 + 1;
                    sb5 = sb6;
                    i16 = i19;
                    i3 = 2;
                    c16 = 0;
                    msg_svc_pbpullgroupmsgseqresp = msg_svc_pbpullgroupmsgseqresp2;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return group_unread_info");
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp_PB: server did not return a valid response");
            }
        }
    }

    public void L3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (this.L < 3) {
            msg_svc$PbUnReadMsgSeqReq msg_svc_pbunreadmsgseqreq = new msg_svc$PbUnReadMsgSeqReq();
            try {
                msg_svc_pbunreadmsgseqreq = msg_svc_pbunreadmsgseqreq.mergeFrom(toServiceMsg.getWupBuffer());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<---handleGetPullTroopMsgNumTimeOut : decode pb:", e16);
                }
            }
            Iterator<msg_svc$PbPullGroupMsgSeqReq.GroupInfoReq> it = msg_svc_pbunreadmsgseqreq.group_unread_info.get().group_info_req.get().iterator();
            while (it.hasNext()) {
                h3(String.valueOf(it.next().group_code.get()), toServiceMsg.extraData.getInt("doSome"));
            }
            this.L++;
            return;
        }
        I3(toServiceMsg, fromServiceMsg);
    }

    public void M2(boolean z16, String str, boolean z17, long j3, long j16, int i3, int i16, String str2, boolean z18, long j17, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z18), Long.valueOf(j17), troopProtocolObserver);
        } else {
            N2(z16, str, z17, j3, j16, i3, i16, str2, z18, j17, null, troopProtocolObserver);
        }
    }

    public void M3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            notifyCallBack(toServiceMsg, 3012, false, null);
        }
    }

    public void N2(boolean z16, String str, boolean z17, long j3, long j16, int i3, int i16, String str2, boolean z18, long j17, String str3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z18), Long.valueOf(j17), str3, troopProtocolObserver);
            return;
        }
        oidb_0xd55$ReqBody oidb_0xd55_reqbody = new oidb_0xd55$ReqBody();
        oidb_0xd55_reqbody.check_app_sign_req.setHasFlag(true);
        oidb_0xd55_reqbody.check_app_sign_req.client_info.setHasFlag(true);
        if (!TextUtils.isEmpty(str2)) {
            oidb_0xd55_reqbody.check_app_sign_req.client_info.android_package_name.set(str2);
        }
        oidb_0xd55_reqbody.check_app_sign_req.client_info.platform.set(1);
        String j18 = com.tencent.mobileqq.forward.x.j(BaseApplication.getContext(), str2);
        if (!TextUtils.isEmpty(j18)) {
            oidb_0xd55_reqbody.check_app_sign_req.client_info.android_signature.set(j18);
        }
        oidb_0xd55_reqbody.check_app_sign_req.client_info.sdk_version.set(AEResManagerConfigBean.DEFAULT_VERSION);
        oidb_0xd55_reqbody.check_user_req.setHasFlag(true);
        oidb_0xd55_reqbody.check_user_req.openid.set(str);
        oidb_0xd55_reqbody.check_user_req.need_check_same_user.set(z16 ? 1 : 0);
        if (z17) {
            oidb_0xd55_reqbody.check_mini_app_req.setHasFlag(true);
            oidb_0xd55_reqbody.check_mini_app_req.mini_app_appid.set(j3);
            oidb_0xd55_reqbody.check_mini_app_req.need_check_bind.set(1);
        }
        oidb_0xd55_reqbody.appid.set(j16);
        oidb_0xd55_reqbody.app_type.set(i3);
        oidb_0xd55_reqbody.src_id.set(i16);
        oidb_0xd55_reqbody.is_need_appinfo.set(z18 ? 1 : 0);
        if (!TextUtils.isEmpty(str3)) {
            oidb_0xd55_reqbody.raw_url.set(str3);
            oidb_0xd55$CheckUrlSigReq oidb_0xd55_checkurlsigreq = new oidb_0xd55$CheckUrlSigReq();
            oidb_0xd55_checkurlsigreq.is_need_check_raw_url_sig.set(true);
            oidb_0xd55_reqbody.check_url_sig_req.set(oidb_0xd55_checkurlsigreq);
        }
        ProtoUtils.c(this.Q, troopProtocolObserver, oidb_0xd55_reqbody.toByteArray(), "OidbSvc.0xd55", 3413, 0, null, j17);
    }

    public void N3(FromServiceMsg fromServiceMsg, Object obj) {
        msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) fromServiceMsg, obj);
            return;
        }
        try {
            msg_onlinepush_pbpushmsg = new msg_onlinepush$PbPushMsg().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: exception occurs while parsing the pb bytes.", e16);
            }
            msg_onlinepush_pbpushmsg = null;
        }
        if (msg_onlinepush_pbpushmsg == null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.Q.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap<>(), "");
        }
        if (msg_onlinepush_pbpushmsg != null && msg_onlinepush_pbpushmsg.f417541msg.has()) {
            msg_comm$Msg msg_comm_msg = msg_onlinepush_pbpushmsg.f417541msg.get();
            int i3 = msg_comm_msg.msg_head.get().msg_type.get();
            boolean z16 = false;
            if ((msg_onlinepush_pbpushmsg.uint32_general_flag.get() & 32) == 32) {
                com.tencent.mobileqq.util.az.d(true);
            } else {
                com.tencent.mobileqq.util.az.d(false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---handleMessagePush_PB: msgType:", Integer.valueOf(i3), " ,muteGeneralFlag:", Integer.valueOf(msg_onlinepush_pbpushmsg.uint32_general_flag.get()));
            }
            if ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).t(2003, msg_comm_msg, fromServiceMsg, msg_onlinepush_pbpushmsg);
                return;
            }
            if ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                l3().t(4004, msg_comm_msg, fromServiceMsg, msg_onlinepush_pbpushmsg);
                return;
            }
            if (i3 != 42) {
                if (i3 != 43 && i3 != 82) {
                    if (i3 != 83) {
                        if (i3 == 141) {
                            getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).t(1001, msg_comm_msg, fromServiceMsg, msg_onlinepush_pbpushmsg);
                            return;
                        }
                        return;
                    }
                } else {
                    BaseMessageProcessor processor = getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP);
                    Object[] objArr = new Object[4];
                    objArr[0] = msg_comm_msg;
                    objArr[1] = fromServiceMsg;
                    objArr[2] = msg_onlinepush_pbpushmsg;
                    if (msg_onlinepush_pbpushmsg.ping_flag.get() == 1) {
                        z16 = true;
                    }
                    objArr[3] = Boolean.valueOf(z16);
                    processor.t(1001, objArr);
                    return;
                }
            }
            getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC).t(1001, msg_comm_msg, fromServiceMsg, msg_onlinepush_pbpushmsg, Boolean.TRUE);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<---handleMessagePush_PB: pushMsg is null or doesn't has msg:");
            if (msg_onlinepush_pbpushmsg == null) {
                str = " null ";
            } else {
                str = "noMsg";
            }
            sb5.append(str);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
    }

    public void O2(long j3, String str, long j16, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, this, Long.valueOf(j3), str, Long.valueOf(j16), troopProtocolObserver);
            return;
        }
        oidb_0xbad$ReqBody oidb_0xbad_reqbody = new oidb_0xbad$ReqBody();
        oidb_0xbad_reqbody.bytes_openid.set(ByteStringMicro.copyFromUtf8(str));
        oidb_0xbad_reqbody.uint64_appid.set(j16);
        oidb_0xbad_reqbody.uint64_uin.set(j3);
        ProtoUtils.a(this.Q, troopProtocolObserver, oidb_0xbad_reqbody.toByteArray(), "OidbSvc.0xbad", 2989, 0);
    }

    public void O3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyC2CMsgResp.");
        }
        if (RegisterProxyHandler.isUsedMessageHandleThread) {
            this.mRegisterProxyHandler.addProxyMsgToQueue(1, toServiceMsg, fromServiceMsg, obj);
        } else {
            getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).t(1002, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void O4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
        } else {
            ((FriendsManager) this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).m0(str);
        }
    }

    public void P3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB: reqSeq " + j3);
                }
                if (retrySendMessage(handlerFromQueue, "msf")) {
                    return;
                }
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<ReadReport_All>handleMsgReadedReportError_PB, all retry: reqSeq " + j3);
                }
                removeSendMessageHandler(j3);
            }
        }
    }

    public bs P4(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            return (bs) iPatchRedirector.redirect((short) 143, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg != null) {
            Bundle bundle = toServiceMsg.extraData;
            String str = BaseBusinessHandler.SEQ_KEY;
            if (bundle.containsKey(str)) {
                synchronized (this.uiObserverMap) {
                    long j3 = toServiceMsg.extraData.getLong(str);
                    if (!bs.class.isInstance(this.uiObserverMap.get(Long.valueOf(j3)))) {
                        return null;
                    }
                    return (bs) this.uiObserverMap.remove(Long.valueOf(j3));
                }
            }
        }
        return null;
    }

    public void Q3(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, MessageRecord messageRecord, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, msg_svc_pbsendmsgresp, str, messageRecord, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (messageRecord != null) {
            try {
                if (messageRecord.msgtype == -8018) {
                    byte[] byteArray = msg_svc_pbsendmsgresp.msgeleminfo_servtype37.get().toByteArray();
                    if (byteArray.length <= 0) {
                        String format = String.format("result:%s hasFlag:%s", Integer.valueOf(msg_svc_pbsendmsgresp.result.get()), Boolean.valueOf(msg_svc_pbsendmsgresp.msgeleminfo_servtype37.has()));
                        String format2 = String.format("[seq:%s rand:%s uniseq:%s]", Long.valueOf(messageRecord.msgseq), Long.valueOf(messageRecord.msgUid), Long.valueOf(messageRecord.uniseq));
                        if (QLog.isColorLevel()) {
                            QLog.d("onRecvEmoticonRandomResult", 2, format2 + "--" + format);
                            return;
                        }
                        return;
                    }
                    if (!msg_svc_pbsendmsgresp.msgeleminfo_servtype37.has() || msg_svc_pbsendmsgresp.result.get() != 0) {
                        String format3 = String.format("result:%s hasFlag:%s", Integer.valueOf(msg_svc_pbsendmsgresp.result.get()), Boolean.valueOf(msg_svc_pbsendmsgresp.msgeleminfo_servtype37.has()));
                        if (QLog.isColorLevel()) {
                            QLog.d("onRecvEmoticonRandomResult", 2, format3);
                        }
                    }
                    MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
                    messageForAniSticker.deserializeMsgBody(byteArray);
                    MessageForAniSticker messageForAniSticker2 = (MessageForAniSticker) messageRecord;
                    messageForAniSticker2.resultId = messageForAniSticker.resultId;
                    messageForAniSticker2.surpriseId = messageForAniSticker.surpriseId;
                    messageForAniSticker2.msgData = messageForAniSticker2.serializeMsgData();
                    this.Q.getMessageFacade().Y0(str, i3, messageForAniSticker2.uniseq, messageForAniSticker2.msgData);
                    if (QLog.isColorLevel()) {
                        QLog.d("onRecvEmoticonRandomResult", 2, messageForAniSticker2.toString());
                    }
                    notifyUI(6017, true, (Object) new Object[]{str, messageForAniSticker2}, false);
                    return;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("onRecvEmoticonRandomResult", 2, "local msg null or msgtype error");
        }
    }

    public void Q4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "----------resetGetMsgFlag ");
        }
        this.f194812m = false;
        this.C = false;
        this.D = false;
    }

    public void R3(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (this.f194809f.s1() && this.f194809f.k1(str, i3, j3)) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "handleRevokingRichMsgCacheAndNotify, in revoking cache, isSuc:" + z16);
            }
            if (z16) {
                this.f194809f.U1(null);
            }
            this.Q.getMessageFacade().F(i3).a0();
        }
    }

    public void R4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
        } else {
            this.S = false;
        }
    }

    public void S2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) str);
        } else {
            T2(str, 0);
        }
    }

    public void S3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
            int i16 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            if (z16) {
                statictisInfo.errCode = fromServiceMsg.getResultCode();
                statictisInfo.retryCount = i16 + 1;
            } else {
                statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
                statictisInfo.detailErrorReason = i3;
                statictisInfo.retryCount = i16 + 1;
                statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
            }
            statictisInfo.reportSucc = 1;
            notifyCallBack(toServiceMsg, 5006, z16, new Object[]{Long.valueOf(j3), statictisInfo});
        }
    }

    public void S4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        } else {
            this.N = 0;
            this.L = 0;
        }
    }

    public void T2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) str, i3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("AccostSvc.ReqDeleteBlackList");
        createToServiceMsg.extraData.putString("deleteUin", str);
        createToServiceMsg.extraData.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        send(createToServiceMsg);
    }

    public void T4(String str, String str2, String str3, short s16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, str, str2, str3, Short.valueOf(s16), Long.valueOf(j3));
            return;
        }
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "StreamSvr.RespPushStreamMsg");
            toServiceMsg.extraData.putString("selfuin", str);
            toServiceMsg.extraData.putString("uin", str2);
            toServiceMsg.extraData.putString("filepath", str3);
            toServiceMsg.extraData.putShort("PackSeq", s16);
            toServiceMsg.extraData.putLong("lkey", j3);
            send(toServiceMsg);
        }
    }

    public AppShareID U2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (AppShareID) iPatchRedirector.redirect((short) 65, (Object) this, (Object) str);
        }
        return this.f194809f.d0(str);
    }

    public boolean U4(MessageRecord messageRecord, bs bsVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) messageRecord, (Object) bsVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "the values of disable big data channel is" + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDisableBigDataChannel());
        }
        if (((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDisableBigDataChannel()) {
            return false;
        }
        if (messageRecord instanceof MessageForStructing) {
            AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
            if (absStructMsg != null && com.tencent.biz.pubaccount.util.m.i(absStructMsg)) {
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("send_by_struct_long_message");
                String e16 = com.tencent.biz.pubaccount.util.m.e(absStructMsg);
                String b16 = com.tencent.biz.pubaccount.util.m.b(e16);
                if (!"1".equals(extInfoFromExtStr)) {
                    messageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "1");
                    b5(messageRecord, bsVar);
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, absStructMsg.source_puin, "0X8007A26", "0X8007A26", 0, 0, b16, e16, "", "", false);
                } else {
                    messageRecord.saveExtInfoToExtStr("send_by_struct_long_message", "0");
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, absStructMsg.source_puin, "0X8007A27", "0X8007A27", 0, 0, b16, e16, "", "", false);
                    return false;
                }
            } else {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.d("Q.msg.MessageHandler", 2, "struct msg is null");
                return false;
            }
        } else if (messageRecord instanceof MessageForArkApp) {
            ChatActivityFacade.A0(this.Q, (MessageForArkApp) messageRecord, false);
        } else if (messageRecord instanceof MessageForArkBabyqReply) {
            QLog.e("Q.msg.MessageHandler", 1, "MessageForArkBabyqReply no longer supported from 8.2.6");
        } else if (messageRecord instanceof MessageForReplyText) {
            ((com.tencent.mobileqq.multimsg.f) this.Q.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).h(this.Q, messageRecord, true);
        } else {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("Q.msg.MessageHandler", 2, "it is not message for structing");
            return false;
        }
        return true;
    }

    public void V2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, j3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("AccostSvc.ReqGetBlackList");
        createToServiceMsg.extraData.putLong("lNextMid", j3);
        send(createToServiceMsg);
    }

    public void V3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        long j3;
        long j16;
        String str2;
        int i3;
        boolean c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleSendDiscussionMsgRespPB enter");
        }
        if (obj == null) {
            return;
        }
        msg_svc$PbSendMsgResp W3 = W3(obj);
        int X3 = X3(W3);
        fromServiceMsg.extraData.putLong("ServerReplyCode", X3);
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        long j17 = toServiceMsg.extraData.getLong("uniseq");
        long j18 = toServiceMsg.extraData.getLong("msgSeq");
        int i16 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        String string = toServiceMsg.extraData.getString("uToUin");
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendDiscussionMsgRespPB: ---cmd:" + serviceCmd + "----replyCode:" + X3 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + "SendDiscussionMsgResp : peerUin:" + string + ",uniseq:" + j17 + ",msgSeq:" + j18);
        }
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j18);
        if (handlerFromQueue == null) {
            com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j17);
            return;
        }
        if (X3 == 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && retrySendMessage(handlerFromQueue, "server")) {
            return;
        }
        boolean Y3 = Y3(X3);
        int H = com.tencent.mobileqq.service.message.p.H(toServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.Q);
        if (Y3) {
            str = string;
            j3 = j18;
            a4(toServiceMsg, fromServiceMsg, W3, j17, str, H);
            j16 = j17;
            str2 = "uToUin";
            i3 = X3;
            c16 = false;
        } else {
            str = string;
            j3 = j18;
            j16 = j17;
            str2 = "uToUin";
            i3 = X3;
            d a16 = new d(toServiceMsg, fromServiceMsg, W3, X3, false, j17, j3, str, H).a();
            if (a16.b()) {
                return;
            } else {
                c16 = a16.c();
            }
        }
        Z3(toServiceMsg, fromServiceMsg, i3, j16, Y3);
        com.tencent.mobileqq.app.handler.d.f(this, toServiceMsg, fromServiceMsg, true);
        removeSendMessageHandler(j3);
        com.tencent.mobileqq.app.handler.d.a(this.Q, toServiceMsg, fromServiceMsg);
        ((com.tencent.mobileqq.multimsg.f) this.Q.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).f(toServiceMsg.extraData.getString(str2), 3000, j16, i3, System.currentTimeMillis() - toServiceMsg.extraData.getLong("startTime", 0L));
        ((IVideoReporter) QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(this.Q, i16, str, 3000, j16);
        if (!c16) {
            com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j16);
        }
    }

    public void V4(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
            dVar.M();
            dVar.k0(str2);
            dVar.g0(System.currentTimeMillis());
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "Q.msg.MessageHandler", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        }
    }

    public void W2(byte b16, byte[] bArr, int i3, boolean z16, boolean z17, boolean z18, String str, int i16, Object obj, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Byte.valueOf(b16), bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Integer.valueOf(i16), obj, Boolean.valueOf(z19));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (QLog.isColorLevel()) {
            sb5.setLength(0);
            sb5.append("<PbGetMsg><S>--->>getC2CMessage:cChannel:");
            sb5.append((int) b16);
            sb5.append(",syncFlag:");
            sb5.append(i3);
            sb5.append(",isPullRoamMsg:");
            sb5.append(z16);
            sb5.append(",newMsgInSync:");
            sb5.append(z18);
            sb5.append(",ssoTimeStamp:");
            sb5.append(str);
            sb5.append(",pullMsgType:");
            sb5.append(i16);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        if ((i16 != 2 && !t4(z18)) || (i16 == 2 && !u4())) {
            this.f194809f.M1(false);
            byte[] F0 = this.f194809f.F0();
            boolean z26 = !z16;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "--->>getC2CMessage cChannel: " + ((int) b16) + "vCookies: " + bArr + ",cSyncFlag:" + i3 + ",pullRoamMsg:" + z16 + ",onlineSyncFlag:" + (z26 ? 1 : 0));
            }
            sendPBReqWithRemindSlowNetwork(Q2(b16, bArr, i3, z16, z17, str, i16, obj, F0, z26 ? (byte) 1 : (byte) 0, z19));
        }
    }

    public void W4(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((FriendsManager) this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).r0(str, str2);
        }
    }

    public void X2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, j3);
            return;
        }
        oidb_0xb31$ReqBody oidb_0xb31_reqbody = new oidb_0xb31$ReqBody();
        oidb_0xb31_reqbody.uint64_to.set(j3);
        oidb_0xb31_reqbody.uint64_from.set(0L);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb31", 2865, 0, oidb_0xb31_reqbody.toByteArray());
        makeOIDBPkg.extraData.putLong("toUin", j3);
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "getCommonHobbyForAIOShow.");
        }
    }

    public com.tencent.mobileqq.service.message.e Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.mobileqq.service.message.e) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f194809f;
    }

    public void Y4(String str, int i3, boolean z16) {
        msg_svc$PbMsgReadedReportReq I0;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (com.tencent.imcore.message.ao.c(i3) != 1032 && com.tencent.imcore.message.ao.z(str, i3) && (I0 = this.Q.getMessageFacade().I0(str, i3, z16)) != null && I0.toByteArray() != null) {
            int i16 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i16 + 1;
            long j16 = i16;
            long currentTimeMillis = System.currentTimeMillis();
            SendMessageHandler sendMessageHandler = new SendMessageHandler();
            addToQueue(j16, sendMessageHandler);
            for (int i17 = 0; i17 < 9; i17++) {
                sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(I0, currentTimeMillis, j16) { // from class: com.tencent.mobileqq.app.MessageHandler.15
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ msg_svc$PbMsgReadedReportReq G;
                    final /* synthetic */ long H;
                    final /* synthetic */ long I;

                    {
                        this.G = I0;
                        this.H = currentTimeMillis;
                        this.I = j16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, MessageHandler.this, I0, Long.valueOf(currentTimeMillis), Long.valueOf(j16));
                        }
                    }

                    @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ToServiceMsg createToServiceMsg = MessageHandler.this.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
                        createToServiceMsg.putWupBuffer(this.G.toByteArray());
                        createToServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, this.f307281e);
                        createToServiceMsg.extraData.putLong("startTime", this.H);
                        createToServiceMsg.extraData.putInt("retryIndex", this.D);
                        createToServiceMsg.extraData.putLong("msgSeq", this.I);
                        createToServiceMsg.setEnableFastResend(true);
                        createToServiceMsg.setTimeout(this.f307281e);
                        MessageHandler.this.sendPbReq(createToServiceMsg);
                    }
                });
            }
            for (int i18 = 0; i18 < 3; i18++) {
                int i19 = 3 - i18;
                if (i18 == 0) {
                    j3 = 480000;
                } else {
                    j3 = ((i19 * 480000) / 3) - (i18 * 2000);
                }
                sendMessageHandler.f((480000 * i18) / 3, j3, "period");
            }
        }
    }

    public int Z2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, i3)).intValue();
        }
        return this.Q.getMessageFacade().Y().t().get(Integer.valueOf(i3)).a();
    }

    public com.tencent.mobileqq.app.message.l a3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            return (com.tencent.mobileqq.app.message.l) iPatchRedirector.redirect((short) 125, (Object) this);
        }
        return (com.tencent.mobileqq.app.message.l) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_OFFLINEFILE);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void actBExceptionReason01() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this);
        } else {
            super.actBExceptionReason01();
        }
    }

    public OpenID b3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (OpenID) iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        }
        return this.f194809f.R0(str);
    }

    public void b4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else if (this.J < 2) {
            send(toServiceMsg);
            this.J++;
        } else {
            notifyBusiness(5002, false, null);
            this.J = 0;
        }
    }

    public IPasswdRedBagService c3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (IPasswdRedBagService) iPatchRedirector.redirect((short) 96, (Object) this);
        }
        return (IPasswdRedBagService) this.Q.getRuntimeService(IPasswdRedBagService.class);
    }

    public void c4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageError");
        }
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        long j17 = toServiceMsg.extraData.getLong("uniseq");
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                Object[] objArr = {toServiceMsg.extraData.getString("groupuin"), 1026, 0, toServiceMsg.getAttribute("sendmsgHandler"), Long.valueOf(toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT)), Long.valueOf(j17)};
                s5(objArr, fromServiceMsg.getUin(), fromServiceMsg.getResultCode());
                notifyBusiness(3013, false, objArr);
                if (toServiceMsg.extraData.getBoolean("RichNotify", false)) {
                    int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
                    StatictisInfo statictisInfo = new StatictisInfo();
                    statictisInfo.errCode = fromServiceMsg.getResultCode();
                    statictisInfo.retryCount = i3;
                    statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
                    notifyCallBack(toServiceMsg, 5006, false, new Object[]{Long.valueOf(j17), statictisInfo});
                }
                removeSendMessageHandler(j3);
            }
        }
    }

    public void c5(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, z16);
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(z16) { // from class: com.tencent.mobileqq.app.MessageHandler.13
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f194819d;

                {
                    this.f194819d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MessageHandler.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ConfessMsgUtil.i(MessageHandler.this.Q, false);
                        ConfessMsgUtil.h(MessageHandler.this.Q, false);
                        MessageHandler.this.d5(this.f194819d);
                    } catch (RuntimeException e16) {
                        QLog.e("Q.msg.MessageHandler", 1, "sendMsgReadedReportInAll error :", e16);
                        throw e16;
                    }
                }
            }, 10, null, false);
            return;
        }
        ConfessMsgUtil.i(this.Q, false);
        ConfessMsgUtil.h(this.Q, false);
        d5(z16);
    }

    public void d4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if (MessageHandlerUtils.isC2CRoutingType(i3, this.Q)) {
            T3(toServiceMsg, fromServiceMsg);
        } else if (i3 == 9) {
            a3().W(toServiceMsg, fromServiceMsg);
        } else if (i3 == 13) {
            a3().X(toServiceMsg, fromServiceMsg);
        } else if (i3 == 4) {
            U3(toServiceMsg, fromServiceMsg);
        } else if (i3 == 2) {
            e4(toServiceMsg, fromServiceMsg);
        }
        com.tencent.mobileqq.app.handler.d.b(toServiceMsg, String.valueOf(fromServiceMsg.getResultCode()));
    }

    public void d5(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, z16);
            return;
        }
        msg_svc$PbMsgReadedReportReq G0 = this.Q.getMessageFacade().G0(z16);
        if (G0 != null && G0.toByteArray() != null) {
            int i3 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i3 + 1;
            long j16 = i3;
            long currentTimeMillis = System.currentTimeMillis();
            SendMessageHandler sendMessageHandler = new SendMessageHandler();
            addToQueue(j16, sendMessageHandler);
            for (int i16 = 0; i16 < 9; i16++) {
                sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(G0, currentTimeMillis, j16) { // from class: com.tencent.mobileqq.app.MessageHandler.14
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ msg_svc$PbMsgReadedReportReq G;
                    final /* synthetic */ long H;
                    final /* synthetic */ long I;

                    {
                        this.G = G0;
                        this.H = currentTimeMillis;
                        this.I = j16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, MessageHandler.this, G0, Long.valueOf(currentTimeMillis), Long.valueOf(j16));
                        }
                    }

                    @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ToServiceMsg createToServiceMsg = MessageHandler.this.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
                        createToServiceMsg.putWupBuffer(this.G.toByteArray());
                        createToServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, this.f307281e);
                        createToServiceMsg.extraData.putLong("startTime", this.H);
                        createToServiceMsg.extraData.putInt("retryIndex", this.D);
                        createToServiceMsg.extraData.putLong("msgSeq", this.I);
                        createToServiceMsg.setEnableFastResend(true);
                        createToServiceMsg.setTimeout(this.f307281e);
                        MessageHandler.this.sendPbReq(createToServiceMsg);
                    }
                });
            }
            for (int i17 = 0; i17 < 3; i17++) {
                int i18 = 3 - i17;
                if (i17 == 0) {
                    j3 = 480000;
                } else {
                    j3 = ((i18 * 480000) / 3) - (i17 * 2000);
                }
                sendMessageHandler.f((480000 * i17) / 3, j3, "period");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void deleteDiscussion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            iPatchRedirector.redirect((short) 147, (Object) this);
            return;
        }
        super.deleteDiscussion();
        n nVar = (n) this.Q.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        DiscussionHandler discussionHandler = (DiscussionHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        ArrayList<DiscussionInfo> k3 = nVar.k();
        new ArrayList();
        Iterator<DiscussionInfo> it = k3.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            DiscussionInfo next = it.next();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleNewRegisterProxyMsg--> should be deleted discussion" + i3 + ":" + next.uin);
            }
            if (n.y()) {
                discussionHandler.P2(next.uin);
                if (this.f194809f.v0(next.uin) != null) {
                    this.f194809f.B1(next.uin);
                }
            }
            i3++;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void doC2CUpdateWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (o3().hasMessages(2)) {
            o3().removeMessages(2);
        }
        o3().doC2CUpdateNow();
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void doMsgProxyDiscussMsgResp_PB(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        register_proxy$SvcPbResponsePullDisMsgProxy register_proxy_svcpbresponsepulldismsgproxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyDiscussMsgResp_PB return by null data");
            return;
        }
        if (obj instanceof register_proxy$SvcPbResponsePullDisMsgProxy) {
            register_proxy_svcpbresponsepulldismsgproxy = (register_proxy$SvcPbResponsePullDisMsgProxy) obj;
        } else {
            try {
                register_proxy_svcpbresponsepulldismsgproxy = new register_proxy$SvcPbResponsePullDisMsgProxy().mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode SvcPbResponsePullDisMsgProxy:", e16);
                }
                register_proxy_svcpbresponsepulldismsgproxy = null;
            }
        }
        if (register_proxy_svcpbresponsepulldismsgproxy != null) {
            try {
                byte[] byteArray = register_proxy_svcpbresponsepulldismsgproxy.msg_content.get().toByteArray();
                int length = byteArray.length - 4;
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, byteArray, 4, length);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDiscussMsgResp_PB. dataHash=" + obj.hashCode() + ", newDataHash=" + bArr.hashCode());
                }
                A3(toServiceMsg, fromServiceMsg, bArr);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyDiscussMsgResp_PB : decode pb:", e17);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void doMsgProxyTroopMsgResp_PB(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        register_proxy$SvcResponsePbPullGroupMsgProxy register_proxy_svcresponsepbpullgroupmsgproxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            QLog.e("Q.msg.MessageHandler", 1, "doMsgProxyTroopMsgResp_PB return by null data");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB.");
        }
        if (obj instanceof register_proxy$SvcResponsePbPullGroupMsgProxy) {
            register_proxy_svcresponsepbpullgroupmsgproxy = (register_proxy$SvcResponsePbPullGroupMsgProxy) obj;
        } else {
            try {
                register_proxy_svcresponsepbpullgroupmsgproxy = new register_proxy$SvcResponsePbPullGroupMsgProxy().mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode SvcResponsePbPullGroupMsgProxy:", e16);
                }
                register_proxy_svcresponsepbpullgroupmsgproxy = null;
            }
        }
        if (register_proxy_svcresponsepbpullgroupmsgproxy != null) {
            try {
                byte[] byteArray = register_proxy_svcresponsepbpullgroupmsgproxy.msg_content.get().toByteArray();
                int length = byteArray.length - 4;
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, byteArray, 4, length);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgResp_PB. dataHash=" + obj.hashCode() + ", newDataHash=" + bArr.hashCode());
                }
                B3(toServiceMsg, fromServiceMsg, bArr, true);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "<---handleMsgProxyTroopMsgResp_PB : decode pb:", e17);
                }
            }
        }
    }

    public boolean e3(long j3, long j16, long j17, boolean z16, Bundle bundle) {
        Pair<Long, Long> w06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Boolean) iPatchRedirector.redirect((short) 88, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z16), bundle)).booleanValue();
        }
        long M0 = this.f194809f.M0(String.valueOf(j3), 3000);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "--->>getPullDiscussionMsg uin: " + j3 + " beginSeq: " + j16 + " endSeq: " + j17 + " delSeq: " + M0);
        }
        if (j16 < 0 || j17 < 0 || (w06 = this.f194809f.w0(String.valueOf(j3))) == null) {
            return false;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MessageSvc.PbGetDiscussMsg");
        createToServiceMsg.extraData.putLong("lDisUin", j3);
        createToServiceMsg.extraData.putLong("lBeginSeq", j16);
        createToServiceMsg.extraData.putLong("lEndSeq", j17);
        createToServiceMsg.extraData.putBoolean("isRefreshHead", z16);
        createToServiceMsg.extraData.putBundle("context", bundle);
        createToServiceMsg.extraData.putLong("dwLastInfoSeq", ((Long) w06.first).longValue());
        createToServiceMsg.extraData.putLong("dwLastGetTime", ((Long) w06.second).longValue());
        msg_svc$PbGetDiscussMsgReq msg_svc_pbgetdiscussmsgreq = new msg_svc$PbGetDiscussMsgReq();
        msg_svc_pbgetdiscussmsgreq.begin_seq.set(j16);
        msg_svc_pbgetdiscussmsgreq.end_seq.set(j17);
        msg_svc_pbgetdiscussmsgreq.discuss_uin.set(j3);
        msg_svc_pbgetdiscussmsgreq.discuss_info_seq.set(((Long) w06.first).longValue());
        msg_svc_pbgetdiscussmsgreq.last_get_time.set(((Long) w06.second).longValue());
        createToServiceMsg.putWupBuffer(msg_svc_pbgetdiscussmsgreq.toByteArray());
        sendPBReqWithRemindSlowNetwork(createToServiceMsg);
        return true;
    }

    public void e5(long j3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void f4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        long j3;
        int i17;
        int i18;
        int i19;
        String str;
        long j16;
        int i26;
        long j17;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleSendTroopMessageRespPB enter");
        }
        String string = toServiceMsg.extraData.getString("groupuin");
        int i27 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        String serviceCmd = toServiceMsg.getServiceCmd();
        msg_svc$PbSendMsgResp g46 = g4(obj);
        if (g46 != null && g46.result.has()) {
            if (g46.result.get() != 0) {
                i3 = g46.result.get();
            } else {
                i3 = 0;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB:server did not return a valid result code, use 4 instead.");
            }
            i3 = 4;
        }
        fromServiceMsg.extraData.putLong("ServerReplyCode", i3);
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        long j18 = toServiceMsg.extraData.getLong("msgSeq");
        long j19 = toServiceMsg.extraData.getLong("uniseq");
        QLog.d("Q.msg.MessageHandler", 1, "<PbSendMsg><R><---handleSendTroopMessageRespPB: ---cmd:" + serviceCmd + "----replyCode:" + i3 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + ",SendTroopMessageResp : peerUin:" + string + ",uniseq:" + j19 + ",msgSeq:" + j18);
        int H = com.tencent.mobileqq.service.message.p.H(toServiceMsg.extraData.getInt("ROUNTING_TYPE"), this.Q);
        MessageRecord w06 = this.Q.getMessageFacade().w0(string, H, j19);
        if (g46 != null) {
            i16 = H;
            j3 = j19;
            i17 = i3;
            i18 = 1;
            Q3(g46, string, w06, i16, j3);
        } else {
            i16 = H;
            j3 = j19;
            i17 = i3;
            i18 = 1;
        }
        boolean z16 = false;
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j18);
        if (handlerFromQueue == null) {
            com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j3);
            return;
        }
        long j26 = j3;
        if (i17 == 255) {
            i19 = i18;
        } else {
            i19 = 0;
        }
        if (i19 != 0 && retrySendMessage(handlerFromQueue, "server")) {
            return;
        }
        TroopManager troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER);
        troopManager.g0(string);
        Object[] objArr = new Object[7];
        objArr[0] = string;
        objArr[i18] = Integer.valueOf(i18);
        objArr[2] = Integer.valueOf(i17);
        objArr[3] = toServiceMsg.getAttribute("sendmsgHandler");
        objArr[4] = Long.valueOf(toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT));
        objArr[5] = Long.valueOf(j26);
        if (g46 != null) {
            str = g46.errmsg.get();
        } else {
            str = "";
        }
        objArr[6] = str;
        boolean i36 = i3(string, i17, troopManager, objArr);
        if (i36) {
            j16 = j26;
            i26 = i17;
            h4(toServiceMsg, fromServiceMsg, string, g46, j26, i16);
            j17 = j18;
            str2 = string;
            str3 = "groupuin";
        } else {
            j16 = j26;
            i26 = i17;
            j17 = j18;
            str2 = string;
            str3 = "groupuin";
            e a16 = new e(toServiceMsg, fromServiceMsg, string, g46, i26, j18, j16, false, objArr, i16).a();
            if (a16.b()) {
                return;
            } else {
                z16 = a16.c();
            }
        }
        boolean z17 = z16;
        S3(toServiceMsg, fromServiceMsg, i26, j16, i36);
        com.tencent.mobileqq.app.handler.d.i(this, toServiceMsg, fromServiceMsg, true);
        removeSendMessageHandler(j17);
        com.tencent.mobileqq.app.handler.d.a(this.Q, toServiceMsg, fromServiceMsg);
        ((com.tencent.mobileqq.multimsg.f) this.Q.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).f(toServiceMsg.extraData.getString(str3), 1, j16, i26, System.currentTimeMillis() - toServiceMsg.extraData.getLong("startTime", 0L));
        ((IVideoReporter) QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(this.Q, i27, str2, 1, j16);
        if (!z17) {
            com.tencent.mobileqq.activity.aio.forward.b.d().k(this.Q, j16);
        }
    }

    public void f5(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            g5(i3, z16, 0L, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void flushDiscussionAndTroopMsg() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg begin.");
        }
        ConcurrentHashMap<String, Integer> e16 = this.f194809f.e1();
        if (e16 != null && e16.size() > 0) {
            try {
                ArrayList arrayList = new ArrayList();
                Enumeration<String> keys = e16.keys();
                while (keys.hasMoreElements()) {
                    String nextElement = keys.nextElement();
                    if (e16.get(nextElement).intValue() == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!Boolean.valueOf(z17).booleanValue()) {
                        arrayList.add(nextElement);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, troopSize=" + arrayList.size());
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m4((String) it.next(), "flushDiscussionAndTroopMsg");
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        ConcurrentHashMap<String, Integer> u06 = this.f194809f.u0();
        if (u06 != null && u06.size() > 0) {
            try {
                ArrayList arrayList2 = new ArrayList();
                Enumeration<String> keys2 = u06.keys();
                while (keys2.hasMoreElements()) {
                    String nextElement2 = keys2.nextElement();
                    if (u06.get(nextElement2).intValue() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!Boolean.valueOf(z16).booleanValue()) {
                        arrayList2.add(nextElement2);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg, disSize=" + arrayList2.size());
                }
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    t3((String) it5.next(), "flushDiscussionAndTroopMsg");
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "flushDiscussionAndTroopMsg end.");
        }
        this.f194809f.W();
    }

    @Deprecated
    public boolean g3(String str, long j3, long j16, boolean z16, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 86)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 86, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), bundle, Integer.valueOf(i3))).booleanValue();
    }

    public void g5(int i3, boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
        } else {
            this.mRegisterProxyHandler.sendRegisterProxy(i3, z16, j3, z17);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void getC2CMessage(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "getC2CMessage:isPullRoamMsg:" + z16 + " ,pullMsgType:" + i3);
        }
        getC2CMessage_PB((byte) 3, null, 0, z16, true, false, null, i3, null);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void getC2CMessage_PB(byte b16, byte[] bArr, int i3, boolean z16, boolean z17, boolean z18, String str, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Byte.valueOf(b16), bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Integer.valueOf(i16), obj);
        } else {
            W2(b16, bArr, i3, z16, z17, z18, str, i16, obj, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Set) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("MessageSvc.GetMsgV4");
            this.allowCmdSet.add("MessageSvc.PbGetMsg");
            this.allowCmdSet.add("MessageSvc.PbBindUinGetMsg");
            this.allowCmdSet.add("PbMessageSvc.PbBindUinMsgReadedConfirm");
            this.allowCmdSet.add("OidbSvc.0x5d0_1");
            this.allowCmdSet.add("MessageSvc.DelMsgV2");
            this.allowCmdSet.add("TransService.ReqOffFilePack");
            this.allowCmdSet.add("MessageSvc.PushNotify");
            this.allowCmdSet.add("MessageSvc.SetRoamMsgAllUser");
            this.allowCmdSet.add("MessageSvc.DelRoamMsg");
            this.allowCmdSet.add("PbMessageSvc.PbMsgReadedReport");
            this.allowCmdSet.add("ADMsgSvc.PushMsg");
            this.allowCmdSet.add("VideoCCSvc.Adaptation");
            this.allowCmdSet.add("SharpSvr.c2sack");
            this.allowCmdSet.add("SharpSvr.s2c");
            this.allowCmdSet.add("MultiVideo.c2sack");
            this.allowCmdSet.add("MultiVideo.s2c");
            this.allowCmdSet.add(BaseConstants.CMD_RESPPUSH);
            this.allowCmdSet.add(MiniConst.Spark.CMD_PUSH_SPARK_REWARD);
            this.allowCmdSet.add("MessageSvc.PushReaded");
            this.allowCmdSet.add("TransService.ReqTmpChatPicDownload");
            this.allowCmdSet.add("TransService.ReqGetSign");
            this.allowCmdSet.add("OnlinePush.PbPushTransMsg");
            this.allowCmdSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
            this.allowCmdSet.add("OidbSvc.0xa89");
            this.allowCmdSet.add("MessageSvc.PbMultiMsgSend");
            this.allowCmdSet.add("SecSvcBlessingHelper.blessing_helper");
            this.allowCmdSet.add("StreamSvr.RespUploadStreamMsg");
            this.allowCmdSet.add("StreamSvr.PushStreamMsg");
            this.allowCmdSet.add("AccostSvc.ClientMsg");
            this.allowCmdSet.add("AccostSvc.SvrMsg");
            this.allowCmdSet.add("AccostSvc.ReqInsertBlackList");
            this.allowCmdSet.add("OidbSvc.0x9db");
            this.allowCmdSet.add("AccostSvc.ReqGetBlackList");
            this.allowCmdSet.add("OidbSvc.0x4ff_42024");
            this.allowCmdSet.add("AccostSvc.ReqDeleteBlackList");
            this.allowCmdSet.add("MessageSvc.PbGetDiscussMsg");
            this.allowCmdSet.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG);
            this.allowCmdSet.add("MessageSvc.PullGroupMsgSeq");
            this.allowCmdSet.add(BaseConstants.CMD_MSG_UNREAD_MSG_SEQ);
            this.allowCmdSet.add("OnlinePush.PbPushGroupMsg");
            this.allowCmdSet.add("OnlinePush.PbPushBindUinGroupMsg");
            this.allowCmdSet.add("OnlinePush.PbPushDisMsg");
            this.allowCmdSet.add("OnlinePush.PbPushC2CMsg");
            this.allowCmdSet.add("OnlinePush.PbC2CMsgSync");
            this.allowCmdSet.add("MessageSvc.PbGetRoamMsg");
            this.allowCmdSet.add("MessageSvc.PbGetOneDayRoamMsg");
            this.allowCmdSet.add("PbMessageSvc.PbSearchRoamMsgInCloud");
            this.allowCmdSet.add("PbMessageSvc.PbDelOneRoamMsg");
            this.allowCmdSet.add("PbMessageSvc.PbMsgWithDraw");
            this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgRead");
            this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgAction");
            this.allowCmdSet.add("NearFieldTranFileSvr.NotifyList");
            this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew");
            this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Friend");
            this.allowCmdSet.add("ProfileService.Pb.ReqSystemMsgNew.Group");
            this.allowCmdSet.add("OidbSvc.0x5cf_0");
            this.allowCmdSet.add("OidbSvc.0x5cf_1");
            this.allowCmdSet.add("MessageSvc.PbReceiptRead");
            this.allowCmdSet.add("OidbSvc.0xb31");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public String getCurrentAIOUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            return (String) iPatchRedirector.redirect((short) 146, (Object) this);
        }
        return ((com.tencent.mobileqq.troop.utils.z) this.Q.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).d();
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public EntityManager getEM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        EntityManager entityManager = this.f194806d;
        if (entityManager == null || !entityManager.isOpen()) {
            synchronized (this.f194808e) {
                EntityManager entityManager2 = this.f194806d;
                if (entityManager2 == null || !entityManager2.isOpen()) {
                    this.f194806d = this.Q.getEntityManagerFactory().createEntityManager();
                }
            }
        }
        return this.f194806d;
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public Object getMessageHandleThreadSyncLock(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return iPatchRedirector.redirect((short) 121, (Object) this, (Object) str, i3);
        }
        String str2 = str + "_" + i3;
        if (!this.f194807d0.containsKey(str2)) {
            synchronized (this.f194807d0) {
                if (!this.f194807d0.containsKey(str2)) {
                    this.f194807d0.put(str2, new Object());
                }
            }
        }
        return this.f194807d0.get(str2);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public BaseMessageProcessor getProcessor(String str) {
        BaseMessageProcessor baseMessageProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            return (BaseMessageProcessor) iPatchRedirector.redirect((short) 122, (Object) this, (Object) str);
        }
        Map<String, BaseMessageProcessor> map = this.processorMap;
        if (map == null) {
            return null;
        }
        if (!map.containsKey(str)) {
            synchronized (this.processorMap) {
                if (!this.processorMap.containsKey(str)) {
                    if (ProcessorDispatcherInterface.PROCESSOR_KEY_C2C.equals(str)) {
                        baseMessageProcessor = new com.tencent.imcore.message.i(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.troop.data.y(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_DISC.equals(str)) {
                        baseMessageProcessor = new DiscMessageProcessor(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE.equals(str)) {
                        baseMessageProcessor = new com.tencent.imcore.message.af(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_SUB.equals(str)) {
                        baseMessageProcessor = ((ISubAccountService) this.Q.getRuntimeService(ISubAccountService.class, "")).createSubAccountMessageProcessor(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_ACCOST.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.app.message.b(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_OFFLINEFILE.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.app.message.l(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.app.message.n(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG.equals(str)) {
                        baseMessageProcessor = new UncommonMessageProcessor(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_VIDEO.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.app.message.p(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_DISCUSS_UPDATE.equals(str)) {
                        baseMessageProcessor = new DiscMessageProcessor(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_INFO_UPDATE.equals(str)) {
                        baseMessageProcessor = new ProfileCardMessageProcessor(this.Q, this);
                    } else if (ProcessorDispatcherInterface.PROCESSOR_KEY_SLAVE_MASTER_MSG.equals(str)) {
                        baseMessageProcessor = new com.tencent.mobileqq.app.message.h(this.Q, this);
                    } else {
                        baseMessageProcessor = null;
                    }
                    if (baseMessageProcessor == null) {
                        return null;
                    }
                    baseMessageProcessor.a(this);
                    this.processorMap.put(str, baseMessageProcessor);
                }
            }
        }
        return this.processorMap.get(str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushPBCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            return (Set) iPatchRedirector.redirect((short) 144, (Object) this);
        }
        return new HashSet<String>() { // from class: com.tencent.mobileqq.app.MessageHandler.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
                    return;
                }
                add("OnlinePush.PbPushGroupMsg");
                add("OnlinePush.PbPushDisMsg");
                add("OnlinePush.PbC2CMsgSync");
                add("NearFieldTranFileSvr.NotifyList");
                add("OnlinePush.PbPushC2CMsg");
                add("OnlinePush.PbPushBindUinGroupMsg");
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ce  */
    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getRoamMsgByTime(String str, long j3, long j16, long j17, short s16, long j18, int i3, byte[] bArr, int i16, boolean z16, int i17, boolean z17, boolean z18) {
        int i18;
        boolean z19;
        boolean z26;
        long j19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Short.valueOf(s16), Long.valueOf(j18), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgByTime friendUin: " + str + " beginTime: " + j3 + " endTime: " + j17 + " middleTime: " + j16 + " maxCnt: " + ((int) s16) + " random: " + j18 + " subcmd\uff1a" + i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("--->>getRoamMsgByTime req_type: ");
            sb5.append(i16);
            sb5.append(", ticket length: ");
            sb5.append(bArr == null ? 0 : bArr.length);
            sb5.append(", fetchMore: ");
            sb5.append(z16);
            sb5.append(", fetchNum: ");
            i18 = i17;
            sb5.append(i18);
            sb5.append(", isPreloadType: ");
            z19 = z17;
            sb5.append(z19);
            sb5.append(", notify: ");
            z26 = z18;
            sb5.append(z26);
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
            QLog.e("Q.msg.MessageHandler", 2, new Exception("getRoamMsgByTime"), new Object[0]);
        } else {
            i18 = i17;
            z19 = z17;
            z26 = z18;
        }
        if (j18 == 0 && this.roamCache.containsKey(str)) {
            this.roamCache.remove(str);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MessageSvc.PbGetRoamMsg");
        createToServiceMsg.extraData.putLong("lBeginTime", j3);
        createToServiceMsg.extraData.putLong("lEndTime", j17);
        createToServiceMsg.extraData.putBoolean("fetchMore", z16);
        createToServiceMsg.extraData.putInt("fetchNum", i18);
        createToServiceMsg.extraData.putString("peerUin", str);
        createToServiceMsg.extraData.putBoolean(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, z19);
        createToServiceMsg.extraData.putBoolean("notify", z26);
        msg_svc$PbGetRoamMsgReq msg_svc_pbgetroammsgreq = new msg_svc$PbGetRoamMsgReq();
        if (j18 == 0) {
            j19 = j16;
            if (j19 == 0) {
                msg_svc_pbgetroammsgreq.last_msgtime.set(j17);
                msg_svc_pbgetroammsgreq.peer_uin.set(Long.parseLong(str));
                msg_svc_pbgetroammsgreq.random.set(j18);
                msg_svc_pbgetroammsgreq.read_cnt.set(s16 == 0 ? s16 : (short) 1000);
                msg_svc_pbgetroammsgreq.subcmd.set(i3);
                msg_svc_pbgetroammsgreq.begin_msgtime.set(j3);
                createToServiceMsg.putWupBuffer(msg_svc_pbgetroammsgreq.toByteArray());
                sendPbReq(createToServiceMsg);
            }
        } else {
            j19 = j16;
        }
        msg_svc_pbgetroammsgreq.last_msgtime.set(j19);
        msg_svc_pbgetroammsgreq.peer_uin.set(Long.parseLong(str));
        msg_svc_pbgetroammsgreq.random.set(j18);
        msg_svc_pbgetroammsgreq.read_cnt.set(s16 == 0 ? s16 : (short) 1000);
        msg_svc_pbgetroammsgreq.subcmd.set(i3);
        msg_svc_pbgetroammsgreq.begin_msgtime.set(j3);
        createToServiceMsg.putWupBuffer(msg_svc_pbgetroammsgreq.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void h3(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) str, i3);
            return;
        }
        String[] strArr = {str};
        long[] jArr = {this.f194809f.D0(str)};
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "getPullTroopMsgNumber_PB troopUinArray.length: 1 troopUinArray:" + Arrays.toString(strArr) + ", lastSeqAry:" + Arrays.toString(jArr) + ", doSome:" + i3);
        }
        msg_svc$PbUnReadMsgSeqReq msg_svc_pbunreadmsgseqreq = new msg_svc$PbUnReadMsgSeqReq();
        msg_svc$PbPullGroupMsgSeqReq msg_svc_pbpullgroupmsgseqreq = new msg_svc$PbPullGroupMsgSeqReq();
        msg_svc$PbPullGroupMsgSeqReq.GroupInfoReq groupInfoReq = new msg_svc$PbPullGroupMsgSeqReq.GroupInfoReq();
        try {
            groupInfoReq.group_code.set(Long.parseLong(strArr[0]));
            groupInfoReq.last_seq.set(jArr[0]);
            msg_svc_pbpullgroupmsgseqreq.group_info_req.add(groupInfoReq);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        msg_svc_pbunreadmsgseqreq.group_unread_info.set(msg_svc_pbpullgroupmsgseqreq);
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_MSG_UNREAD_MSG_SEQ);
        createToServiceMsg.putWupBuffer(msg_svc_pbunreadmsgseqreq.toByteArray());
        createToServiceMsg.extraData.putInt("doSome", i3);
        sendPbReq(createToServiceMsg);
    }

    public void h5(MessageRecord messageRecord, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, this, messageRecord, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "sendRevokeMsgReq, timeout: " + j3);
        }
        if (!this.Q.getMsgCache().s1()) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "sendRevokeMsgReq error, isMsgRevoking: false");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (messageRecord.isLongMsg() && (messageRecord instanceof MessageForLongMsg)) {
            arrayList.addAll(((MessageForLongMsg) messageRecord).longMsgFragmentList);
        } else {
            arrayList.add(messageRecord);
        }
        ToServiceMsg C = n3().C(arrayList, 1);
        if (C == null) {
            return;
        }
        C.setTimeout(j3);
        sendPBReqWithRemindSlowNetwork(C);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            com.tencent.mobileqq.app.handler.receiveerror.a.a(this, toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public boolean handleMsgNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        synchronized (this.E) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "----------handleMsgNew: " + this.C);
            }
            if (this.C) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void handleRegPrxyCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            iPatchRedirector.redirect((short) 148, (Object) this);
        } else {
            int i3 = com.tencent.mobileqq.service.message.e.Q0;
        }
    }

    public void i4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            notifyBusiness(1005, false, null);
        }
    }

    public void j3(String str, long j3, short s16, Bundle bundle, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, str, Long.valueOf(j3), Short.valueOf(s16), bundle, Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "--->>getRoamMsgInOneDay friendUin: " + str + " reqLastMsgTime: " + j3 + " readCnt: " + ((int) s16) + " random: " + j16);
        }
        if (j16 == 0) {
            Pair<Long, Long> m06 = this.f194809f.m0(str);
            if (m06 == null) {
                j16 = 0;
            } else {
                j16 = ((Long) m06.second).longValue();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay rand=" + j16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "getRoamMsgInOneDay:" + j3);
        }
        if (j3 == 0) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("MessageSvc.PbGetOneDayRoamMsg");
        msg_svc$PbGetOneDayRoamMsgReq msg_svc_pbgetonedayroammsgreq = new msg_svc$PbGetOneDayRoamMsgReq();
        msg_svc_pbgetonedayroammsgreq.last_msgtime.set(j3);
        msg_svc_pbgetonedayroammsgreq.peer_uin.set(Long.parseLong(str));
        msg_svc_pbgetonedayroammsgreq.random.set(j16);
        msg_svc_pbgetonedayroammsgreq.read_cnt.set(s16);
        createToServiceMsg.putWupBuffer(msg_svc_pbgetonedayroammsgreq.toByteArray());
        if (bundle != null) {
            createToServiceMsg.extraData.putBundle("context", bundle);
        }
        sendPbReq(createToServiceMsg);
    }

    public void j4(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            notifyBusiness(1005, false, null);
        }
    }

    public void j5(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        boolean z17;
        AbsStructMsg absStructMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : msgseq=", Long.valueOf(messageRecord.msgseq));
        }
        SendMessageHandler sendMessageHandler = new SendMessageHandler();
        boolean addToQueue = addToQueue(messageRecord.msgseq, sendMessageHandler);
        msg_svc$PbSendMsgReq pbSendReqFromMessage = MessageHandlerUtils.getPbSendReqFromMessage(this.Q, messageRecord);
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null) {
            z17 = com.tencent.biz.pubaccount.util.m.f(absStructMsg);
        } else {
            z17 = false;
        }
        if (MessageForRichText.class.isInstance(messageRecord) && !z17) {
            ((MessageForRichText) messageRecord).richText = null;
        }
        if (pbSendReqFromMessage == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : the richText is null!", messageRecord.getBaseInfoString());
                return;
            }
            return;
        }
        i5(messageRecord, pbSendReqFromMessage, 480000L, 0, businessObserver, z16);
        sendMessageHandler.postDelayed(new Runnable(messageRecord) { // from class: com.tencent.mobileqq.app.MessageHandler.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageRecord f194820d;

            {
                this.f194820d = messageRecord;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this, (Object) messageRecord);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (MessageHandler.this.Q.getMsgCache().t1(this.f194820d)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgSend", 4, "delay notify: " + com.tencent.mobileqq.service.message.e.Q0);
                    }
                    MessageHandler.this.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_MSG_START_SENDING_UI, true, new String[]{this.f194820d.frienduin});
                }
            }
        }, com.tencent.mobileqq.service.message.e.Q0);
        if (addToQueue) {
            for (int i3 = 0; i3 < 8; i3++) {
                sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(messageRecord, pbSendReqFromMessage, businessObserver, z16) { // from class: com.tencent.mobileqq.app.MessageHandler.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ MessageRecord G;
                    final /* synthetic */ msg_svc$PbSendMsgReq H;
                    final /* synthetic */ BusinessObserver I;
                    final /* synthetic */ boolean J;

                    {
                        this.G = messageRecord;
                        this.H = pbSendReqFromMessage;
                        this.I = businessObserver;
                        this.J = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, MessageHandler.this, messageRecord, pbSendReqFromMessage, businessObserver, Boolean.valueOf(z16));
                        }
                    }

                    @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : resend message");
                        }
                        MessageHandler.this.i5(this.G, this.H, this.f307281e, this.D, this.I, this.J);
                    }
                });
            }
            int i16 = 1;
            while (i16 < 3) {
                sendMessageHandler.f((480000 * i16) / 3, (((3 - i16) * 480000) / 3) - (i16 * 2000), "period");
                i16++;
                sendMessageHandler = sendMessageHandler;
            }
        }
        if (messageRecord.istroop == 1) {
            this.f194809f.f286240x0.add(messageRecord);
            int size = this.f194809f.f286240x0.size();
            com.tencent.mobileqq.service.message.e eVar = this.f194809f;
            if (size > com.tencent.mobileqq.service.message.e.T0) {
                eVar.f286240x0.remove(0);
            }
        }
    }

    public void k4(long j3, byte[] bArr, long j16, int i3, boolean z16, String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), bArr, Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16), str);
            return;
        }
        String valueOf = String.valueOf(j16);
        if (!TextUtils.isEmpty(String.valueOf(j16)) && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j16)), "Q.msg.MessageHandler")) != null) {
            valueOf = friendsSimpleInfoWithUid.p();
        }
        long onlineStauts = this.Q.getOnlineStauts();
        Intent intent = new Intent("tencent.video.q2v.RecvSharpVideoCall");
        intent.setClassName(this.Q.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
        intent.putExtra("uin", String.valueOf(j3));
        intent.putExtra("fromUin", String.valueOf(j16));
        intent.putExtra("buffer", bArr);
        intent.putExtra("time", i3);
        intent.putExtra("name", valueOf);
        intent.putExtra("isPttRecordingOrPlaying", this.Q.isPttRecordingOrPlaying());
        intent.putExtra("isRequest", z16);
        intent.putExtra("onLineStatus", onlineStauts);
        intent.putExtra("traceId", str);
        intent.putExtra("msf_timestamp", System.currentTimeMillis());
        QLog.d("shanezhaiSHARP", 1, "avideo handleSharpVideoMessageResp sendBroadcast!!");
        this.Q.getApp().sendBroadcast(intent);
    }

    public void k5(String str, String str2, String str3, short s16, int i3, long j3, long j16, long j17, long j18, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, str, str2, str3, Short.valueOf(s16), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), bundle);
            return;
        }
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "StreamSvr.UploadStreamMsg");
            toServiceMsg.extraData.putString("selfuin", str);
            toServiceMsg.extraData.putString("uin", str2);
            toServiceMsg.extraData.putString("filepath", str3);
            toServiceMsg.extraData.putShort("PackSeq", s16);
            toServiceMsg.extraData.putShort("flowLayer", com.tencent.mobileqq.streamtransfile.b.m(str3));
            toServiceMsg.extraData.putInt(AppConstants.Key.COLUMN_MSG_SEQ, i3);
            toServiceMsg.extraData.putLong(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, j3);
            toServiceMsg.extraData.putLong("VoiceType", j16);
            toServiceMsg.extraData.putLong("VoiceLength", j17);
            toServiceMsg.extraData.putLong("SubBubbleId", j18);
            toServiceMsg.extraData.putInt("DiyTextId", bundle.getInt("DiyTextId", 0));
            toServiceMsg.setTimeout(60000L);
            toServiceMsg.setNeedRemindSlowNetwork(true);
            send(toServiceMsg);
        }
    }

    public com.tencent.mobileqq.app.message.a l3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            return (com.tencent.mobileqq.app.message.a) iPatchRedirector.redirect((short) 124, (Object) this);
        }
        return (com.tencent.mobileqq.app.message.a) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SUB);
    }

    public void l4(ToServiceMsg toServiceMsg, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg, (Object) msg_svc_pbsendmsgresp);
            return;
        }
        if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.errtype.has() && msg_svc_pbsendmsgresp.errtype.get() == 72 && msg_svc_pbsendmsgresp.trans_svr_info.has()) {
            msg_svc$TransSvrInfo msg_svc_transsvrinfo = msg_svc_pbsendmsgresp.trans_svr_info.get();
            notifyCallBack(toServiceMsg, MessageHandlerConstants.NOTIFY_TYPE_HIBOOM_AUTH, true, new Object[]{Integer.valueOf(msg_svc_transsvrinfo.int32_ret_code.get()), msg_svc_transsvrinfo.bytes_trans_info.get().toByteArray()});
        }
    }

    public void l5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this);
        } else {
            setMsgGetting(false);
            setPAMsgGetting(false);
        }
    }

    public com.tencent.mobileqq.app.message.n m3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return (com.tencent.mobileqq.app.message.n) iPatchRedirector.redirect((short) 123, (Object) this);
        }
        return (com.tencent.mobileqq.app.message.n) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM);
    }

    public UncommonMessageProcessor n3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            return (UncommonMessageProcessor) iPatchRedirector.redirect((short) 126, (Object) this);
        }
        return (UncommonMessageProcessor) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG);
    }

    public void n4(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        cmd0x9db$ReqBody cmd0x9db_reqbody = new cmd0x9db$ReqBody();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        cmd0x9db_reqbody.rpt_uint64_id.set(arrayList);
        cmd0x9db_reqbody.uint32_sequence.set(i3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9db", 2523, 0, cmd0x9db_reqbody.toByteArray());
        makeOIDBPkg.extraData.putLong("insertTinnyid", j3);
        makeOIDBPkg.extraData.putInt(IProfileCardConst.KEY_FROM_TYPE, i16);
        sendPbReq(makeOIDBPkg);
    }

    public int n5(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return ((Integer) iPatchRedirector.redirect((short) 149, (Object) this, i3)).intValue();
        }
        try {
            if (((IFeatureRuntimeService) this.Q.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("kapalai_message_set_mutable_flag")) {
                return i3 | 67108864;
            }
        } catch (Exception e16) {
            QLog.e("Q.msg.MessageHandler", 1, "setMutableFlag", e16);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public boolean neadNotifyGroupMsgNotifycation(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return ((Boolean) iPatchRedirector.redirect((short) 119, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list)).booleanValue();
        }
        if (z17 || !needNotifyNotification(z16)) {
            z18 = false;
        }
        if (z18 && list != null && list.size() > 0 && (TroopManager.T(this.Q, list.get(0)) || com.tencent.mobileqq.confess.g.e(this.Q, list.get(0)))) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("OpenTroopDebug", 2, "opentroop and hotchattroop msg not notify.");
            return false;
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void notifyBusiness(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            v4(null, i3, z16, obj, 0, false, false, null);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void notifyCallBack(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, toServiceMsg, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            notifyUI(toServiceMsg, i3, z16, obj);
        }
    }

    public void o4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("AccostSvc.ReqInsertBlackList");
        createToServiceMsg.extraData.putString("insertUin", str);
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
            return;
        }
        this.Q.removeObserver(this.f194805c0);
        this.Q.removeObserver(this.f194804b0);
        this.f194803a0 = true;
        S4();
        Q4();
        this.f194809f.V();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.MessageHandler.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AudioUtil.s();
                }
            }
        }, 16, null, true);
        this.mRegisterProxyHandler.stopRegisterProxyThread();
        destroySendQueue();
        EntityManager entityManager = this.f194806d;
        if (entityManager != null && entityManager.isOpen()) {
            this.f194806d.close();
        }
        ((DiscMessageProcessor) getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_DISC)).Y();
        this.processorMap.clear();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.MessageHandler.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    FileUtils.delete(com.tencent.mobileqq.msgforward.a.f251427d, true);
                } catch (Throwable th5) {
                    QLog.i("Q.msg.MessageHandler", 1, "delete err", th5);
                }
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("onReceive success ssoSeq:");
            sb5.append(toServiceMsg.getRequestSsoSeq());
            sb5.append(" serviceCmd: ");
            sb5.append(serviceCmd);
            sb5.append(", resultCode:");
            sb5.append(fromServiceMsg.getResultCode());
            QLog.d("Q.msg.MessageHandler", 2, sb5.toString());
        }
        com.tencent.mobileqq.tianjige.metric.h.t(fromServiceMsg);
        if (onReceiveFailed(toServiceMsg, fromServiceMsg, serviceCmd)) {
            return;
        }
        onReceiveSuccess(toServiceMsg, fromServiceMsg, obj, serviceCmd);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handle [cmd]=" + serviceCmd + " , costTime = [" + (currentTimeMillis2 - currentTimeMillis) + "]");
        }
    }

    @Override // com.tencent.mobileqq.app.message.ProcessorObserver
    public void onReceiveBusinessMessage(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            notifyUI(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.message.ProcessorObserver
    public void onReceiveBusinessResp(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            notifyBusiness(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.message.ProcessorObserver
    public void onReceiveNewMessage(String str, String str2, boolean z16, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        v4(str + "." + str2, 1000, z16, null, i3, z17, z18, null);
    }

    public void p3(FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleC2CMessagePush");
        }
        synchronized (this.E) {
            m5(true);
        }
        W2((byte) 1, null, 0, false, false, false, (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_PUSH_TIMESTAMP), 0, obj, true);
    }

    public void q3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        String string = toServiceMsg.extraData.getString("uin");
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        int i16 = toServiceMsg.extraData.getInt("retryIndex");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><E><---handleC2CReceiptMessageError: ---cmd:MessageSvc.PbReceiptRead ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + ",sendC2CMessage error : peerUin:" + string + " msgseq::" + j3 + " msgType:" + i3 + " retryIndex:" + i16 + " resultCode:" + fromServiceMsg.getResultCode() + " timeout:" + j16);
        }
        recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if ((fromServiceMsg.getResultCode() != 2901 || !retrySendMessage(handlerFromQueue, "msf")) && handlerFromQueue.c()) {
                notifyBusiness(3021, false, new Long[]{Long.valueOf(i3), Long.valueOf(j3), Long.valueOf(fromServiceMsg.getResultCode())});
                removeSendMessageHandler(j3);
            }
        }
    }

    public void q4(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (str != null && !str.equals("")) {
            String currentAccountUin = this.Q.getCurrentAccountUin();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ArrayList<MessageRecord> arrayList = new ArrayList<>();
            MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_FAILED_MSG);
            d16.init(currentAccountUin, str2, currentAccountUin, str, currentTimeMillis, 0, i3, 0L);
            d16.msgtype = MessageRecord.MSG_TYPE_FAILED_MSG;
            d16.isread = true;
            arrayList.add(d16);
            this.Q.getMessageFacade().e(arrayList, String.valueOf(currentAccountUin), false);
        }
    }

    public void q5(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) messageRecord);
        } else if (messageRecord != null && (messageRecord instanceof MessageForStructing)) {
            MiniAppController.tryReportShare((MessageForStructing) messageRecord);
        }
    }

    public void r3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            notifyBusiness(1003, false, null);
        }
    }

    public void r5(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        if (this.Q.getMsgCache().n1(i3, str, j3)) {
            MessageRecord y16 = this.Q.getMsgCache().y1(i3, str, j3);
            y16.time = j16;
            y16.setExtraFlag(0);
            n3().D(y16);
            return;
        }
        this.Q.getMessageFacade().W0(str, i3, j3, j16, str2);
    }

    public void s3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            notifyBusiness(1003, false, null);
        }
    }

    public void s5(Object[] objArr, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, objArr, str, Integer.valueOf(i3));
            return;
        }
        String str2 = (String) objArr[0];
        int intValue = ((Integer) objArr[1]).intValue();
        long longValue = ((Long) objArr[5]).longValue();
        Message lastMessage = this.Q.getMessageFacade().getLastMessage(str2, intValue);
        this.Q.getMsgCache().G1(str2, intValue, longValue);
        if (lastMessage != null && lastMessage.uniseq == longValue) {
            lastMessage.setExtraFlag(32768);
        }
        this.Q.getMessageFacade().Z0(str2, intValue, longValue, 32768, i3);
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void sendPBReqWithRemindSlowNetwork(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg);
        } else {
            toServiceMsg.setNeedRemindSlowNetwork(true);
            sendPbReq(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void sendWorkMessage(android.os.Message message, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, message, Boolean.valueOf(z16));
            return;
        }
        if (!o3().hasSameUnreadWorker(message)) {
            o3().addC2CWorkerToSet(message);
            if (z16) {
                o3().sendMessage(message);
            } else {
                o3().addC2CUpdateMessage(message);
                if (!o3().hasMessages(2)) {
                    o3().sendEmptyMessageDelayed(2, 5000L);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "sendWorkMessage doNow=" + z16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "return! caused by hasSameUnreadWorker");
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void setMsgGetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        synchronized (this.E) {
            this.f194812m = z16;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void setPAMsgGetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        synchronized (this.F) {
            this.D = z16;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void startGetShareAppIDInfo(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) l3);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(l3);
        p5(arrayList);
    }

    public void u3(byte[] bArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null || bArr.length != 21 || bArr[0] != 3) {
            return;
        }
        long longData = PkgTools.getLongData(bArr, 1);
        long longData2 = PkgTools.getLongData(bArr, 5);
        long longData3 = PkgTools.getLongData(bArr, 9);
        long longData4 = PkgTools.getLongData(bArr, 13);
        long longData5 = PkgTools.getLongData(bArr, 17);
        if (QLog.isColorLevel()) {
            QLog.d("Emoticon", 2, "uin:" + longData + " epId=" + longData2 + " expireTime=" + longData3 + " flag=" + longData4);
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.Q.getRuntimeService(IEmoticonManagerService.class);
        if (iEmoticonManagerService.syncFindTabEmoticonPackageById(Long.toString(longData2), 0) == null) {
            EmoticonPackage emoticonPackage = new EmoticonPackage();
            emoticonPackage.epId = Long.toString(longData2);
            emoticonPackage.wordingId = longData5;
            if (longData4 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            emoticonPackage.valid = z16;
            emoticonPackage.expiretime = longData3;
            emoticonPackage.aio = true;
            iEmoticonManagerService.saveEmoticonPackage(emoticonPackage);
            iEmoticonManagerService.syncPcTabEmoticonPackage(emoticonPackage.epId, 0);
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) this.Q.getRuntimeService(IEmojiManagerService.class);
            iEmojiManagerService.startDownloadEmosmJson(emoticonPackage.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
            iEmojiManagerService.startCoverDownload(emoticonPackage);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void updateGroupMsgContent(MessageRecord messageRecord, MessageRecord messageRecord2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) messageRecord, (Object) messageRecord2);
        } else if (messageRecord != null && messageRecord2 != null) {
            messageRecord2.extStr = messageRecord.extStr;
            messageRecord2.mExJsonObject = messageRecord.mExJsonObject;
            messageRecord2.extLong = messageRecord.extLong;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void updateGroupMsgSeqAndTime(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.Q.getMessageFacade().g2(str, i3, j3, j16, j17);
        if (this.Q.getMsgCache().n1(i3, str, j3)) {
            MessageRecord y16 = this.Q.getMsgCache().y1(i3, str, j3);
            y16.shmsgseq = j16;
            y16.time = j17;
            y16.setExtraFlag(0);
            n3().D(y16);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void updateLastRegisterProxyRespTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            iPatchRedirector.redirect((short) 145, (Object) this);
        } else {
            super.updateLastRegisterProxyRespTime();
            this.Q.mAutomator.updateLastRegisterProxyRespTime();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseMessageHandler
    public void updateSendC2CMessageTimeByUniseq(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        } else {
            r5(str, i3, j3, j16, null);
        }
    }

    public void v3(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                AppShareID U2 = U2(next);
                if (U2 == null || System.currentTimeMillis() - U2.updateTime >= 86400000) {
                    if (this.f194809f.e0().add(next)) {
                        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
                        getResourceReqInfo.uiResID = 0L;
                        getResourceReqInfo.strPkgName = next;
                        getResourceReqInfo.uiCurVer = 0L;
                        getResourceReqInfo.sResType = (short) 4;
                        getResourceReqInfo.sLanType = (short) 0;
                        getResourceReqInfo.sReqType = (short) 1;
                        arrayList2.add(getResourceReqInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("share_appid", 2, "Request list add appid = " + next);
                        }
                    }
                }
            }
            if (arrayList2.size() > 0) {
                QQAppInterface qQAppInterface = this.Q;
                com.tencent.mobileqq.service.config.b.a(qQAppInterface, qQAppInterface.getCurrentAccountUin(), arrayList2);
            }
        }
    }

    public void v4(String str, int i3, boolean z16, Object obj, int i16, boolean z17, boolean z18, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), obj, Integer.valueOf(i16), Boolean.valueOf(z17), Boolean.valueOf(z18), messageRecord);
            return;
        }
        z4(str, i3, z16);
        E4(i3, z16, i16, z17, z18, messageRecord);
        notifyUI(i3, z16, obj);
        if (w4(i3)) {
            B4(obj);
        } else if (x4(i3)) {
            C4(i3, obj);
        } else if (y4(i3)) {
            D4(obj);
        }
    }

    public void w3(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) toServiceMsg);
            return;
        }
        Q4();
        this.N = 0;
        setMsgGetting(false);
        int i3 = toServiceMsg.extraData.getInt("pullMsgType");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetBuddyMessageError ,pullMsgType:" + i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    notifyUI(4016, false, null);
                    return;
                }
                return;
            }
            notifyUI(4001, false, null);
            return;
        }
        notifyUI(4001, false, null);
        notifyUI(4016, false, null);
    }

    public boolean w4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, i3)).booleanValue();
        }
        if (i3 == 3001) {
            return true;
        }
        return false;
    }

    public void x3(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) toServiceMsg);
            return;
        }
        Q4();
        if (this.N < 6) {
            getC2CMessage(toServiceMsg.extraData.getBoolean("isPullRoamMsg"), toServiceMsg.extraData.getInt("pullMsgType"));
            this.N++;
        } else {
            w3(toServiceMsg);
        }
    }

    public boolean x4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, i3)).booleanValue();
        }
        if (i3 != 6000 && i3 != 8002 && i3 != 7000 && i3 != 8005 && i3 != 8006 && i3 != 6010 && i3 != 6012 && i3 != 6013 && i3 != 8008 && i3 != 8010 && i3 != 8012 && i3 != 8014 && i3 != 3022 && i3 != 8035 && i3 != 8028 && i3 != 8037 && i3 != 8032 && i3 != 8040 && i3 != 8041 && i3 != 8043 && i3 != 8044 && i3 != 8045 && i3 != 8049 && i3 != 8050) {
            return false;
        }
        return true;
    }

    public void y3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        nt_register_proxy$GetGroupShareMsgRsp nt_register_proxy_getgroupsharemsgrsp;
        String uin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetGroupShareMsgRspPB");
        }
        try {
            nt_register_proxy_getgroupsharemsgrsp = new nt_register_proxy$GetGroupShareMsgRsp().mergeFrom((byte[]) obj);
        } catch (Exception unused) {
            QLog.e("Q.msg.MessageHandler", 1, "handleGetGroupShareMsgRspPB");
            nt_register_proxy_getgroupsharemsgrsp = null;
        }
        if (nt_register_proxy_getgroupsharemsgrsp != null && obj != null) {
            if (toServiceMsg.getUin() == null) {
                uin = this.Q.getCurrentAccountUin();
            } else {
                uin = toServiceMsg.getUin();
            }
            getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP).t(1002, toServiceMsg, bu.a(nt_register_proxy_getgroupsharemsgrsp.f435956msg.get()), new Object[]{Long.valueOf(nt_register_proxy_getgroupsharemsgrsp.group_code.get()), Integer.valueOf(nt_register_proxy_getgroupsharemsgrsp.result.get()), 0, Boolean.TRUE}, uin);
            return;
        }
        QLog.e("Q.msg.MessageHandler", 1, "getGrpResp == null || data == null");
        handleError(toServiceMsg, fromServiceMsg);
    }

    public boolean y4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, i3)).booleanValue();
        }
        if (i3 != 3002 && i3 != 3013 && i3 != 3008) {
            return false;
        }
        return true;
    }

    public void z3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        boolean z16 = toServiceMsg.extraData.getBoolean("isRefreshHead", false);
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("lDisUin"));
        if (z16) {
            Bundle bundle = toServiceMsg.extraData.getBundle("context");
            if (bundle != null) {
                bundle.putBoolean("success", false);
                this.Q.getMessageFacade().g0(String.valueOf(valueOf), 3000, null, null, bundle);
                return;
            }
            return;
        }
        toServiceMsg.extraData.getBoolean("used_register_proxy", false);
        try {
            t3(String.valueOf(valueOf), "handleGetPullDiscussionMsgError");
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MessageHandler", 2, "handleGetPullDiscussionMsgError exception ! ", e16);
            }
        }
        if (this.f194809f.l1()) {
            notifyUI(4002, false, null);
        } else {
            this.f194809f.Z();
        }
    }
}
