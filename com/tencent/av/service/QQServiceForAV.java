package com.tencent.av.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.g;
import com.tencent.av.service.k;
import com.tencent.av.u;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ak;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.av.utils.ba;
import com.tencent.avcore.rtc.node.report.utils.RtcVideoRecoveryNodeReport;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.m;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.WebSsoBody$WebSsoRequestBody;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.av;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.o;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.utils.aj;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.LogUtil;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQServiceForAV extends AppService implements Observer {
    private boolean G;
    private xw.a H;

    /* renamed from: d, reason: collision with root package name */
    int f74319d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f74320e = 0;

    /* renamed from: f, reason: collision with root package name */
    String f74321f = null;

    /* renamed from: h, reason: collision with root package name */
    String f74322h = null;

    /* renamed from: i, reason: collision with root package name */
    String f74323i = null;

    /* renamed from: m, reason: collision with root package name */
    String f74324m = null;
    long C = -1;
    long D = Long.MAX_VALUE;
    IFaceDecoder E = null;
    boolean F = false;
    DecodeTaskCompletionListener I = new a();
    QCallCardHandler.a J = new b();
    final RemoteCallbackList<com.tencent.av.service.f> K = new RemoteCallbackList<>();
    final g.a L = new QQServiceForAVBinder();
    private j M = null;
    private k N = null;
    private final bs P = new c();
    boolean Q = false;
    private boolean R = false;
    private ServiceConnection S = new e();
    l92.d T = new f();
    av U = new g();
    ArrayList<String> V = new ArrayList<>();
    ArrayList<String> W = new ArrayList<>();
    com.tencent.mobileqq.avatar.observer.a X = new h();
    ar Y = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class QQServiceForAVBinder extends g.a {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a extends ProtoUtils.TroopProtocolObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f74328d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f74329e;

            a(String str, int i3) {
                this.f74328d = str;
                this.f74329e = i3;
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "sendNearbyVideoChatPbReq, cmd " + this.f74328d + "==>onResult, errorCode:" + i3);
                }
                synchronized (QQServiceForAV.this.K) {
                    int beginBroadcast = QQServiceForAV.this.K.beginBroadcast();
                    for (int i16 = 0; i16 < beginBroadcast; i16++) {
                        try {
                            QQServiceForAV.this.K.getBroadcastItem(i16).j4(this.f74328d, this.f74329e, i3, bArr);
                        } catch (RemoteException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "callBack RemoteException", e16);
                            }
                        }
                    }
                    QQServiceForAV.this.K.finishBroadcast();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes3.dex */
        public class b implements IBinder.DeathRecipient {
            b() {
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x01ca  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x022d  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x01cf  */
            @Override // android.os.IBinder.DeathRecipient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void binderDied() {
                boolean z16;
                String str;
                String str2;
                boolean z17;
                Intent intent;
                Serializable currentUin;
                QQServiceForAV qQServiceForAV;
                boolean z18;
                QLog.w("QQServiceForAV", 1, "binderDied, video process died! try recovery");
                QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
                if (qQAppInterface != null) {
                    qQAppInterface.mQQServiceRef = null;
                    z16 = qQAppInterface.isBackgroundPause;
                } else {
                    z16 = false;
                }
                try {
                    QQServiceForAVBinder.this.n4();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                    AVCoreLog.printErrorLog("QQServiceForAV", "linkToDeath stopPumpMessage exception msg = " + e16.getMessage());
                }
                if (TextUtils.isEmpty(QQServiceForAV.this.f74323i) && qQAppInterface != null) {
                    QQServiceForAV.this.f74323i = qQAppInterface.getCurrentAccountUin();
                }
                QQServiceForAV qQServiceForAV2 = QQServiceForAV.this;
                String str3 = qQServiceForAV2.f74322h;
                String str4 = qQServiceForAV2.f74323i;
                int i3 = qQServiceForAV2.f74319d;
                if (i3 != 1004 && i3 != 1000 && i3 != 1020) {
                    if (i3 == 1006 && !str3.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        str2 = QQServiceForAV.this.f74324m;
                    } else {
                        str2 = str3;
                    }
                    str = str4;
                } else {
                    str = qQServiceForAV2.f74324m;
                    str2 = str3;
                }
                if (qQAppInterface != null && qQAppInterface.isVideoChatting()) {
                    AVCoreLog.printAllUserLog("QQServiceForAV", "video chatting!");
                    AVCoreLog.printAllUserLog("QQServiceForAV", "linkToVideoProcessDeath-->uinType=" + QQServiceForAV.this.f74319d + " friendUin=" + str2 + " senderUin=" + str);
                    if (str2 != null && str2.length() > 2) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    QQServiceForAV qQServiceForAV3 = QQServiceForAV.this;
                    if (qQServiceForAV3.Q && z18) {
                        z17 = z16;
                        VideoMsgTools.l(qQAppInterface, qQServiceForAV3.f74319d, 45, true, str2, str, true, null, true, new Object[0]);
                        if (QQServiceForAV.this.G) {
                            if (qQAppInterface != null) {
                                u.e("MobileQQ:BootAction", 5000L);
                                Intent intent2 = new Intent("com.tencent.av.ui.VChatActivity");
                                intent2.putExtra("uin", qQAppInterface.getCurrentUin());
                                intent2.putExtra("type", 1);
                                intent2.putExtra("processExitTimestamp", System.currentTimeMillis());
                                intent2.putExtra("source", 1);
                                intent2.putExtra("isQQBackGround", z17);
                                String e17 = VideoUtil.e(qQAppInterface.getCurrentAccountUin(), "start_dav_talk_recovery");
                                intent2.putExtra("traceId", e17);
                                intent2.setPackage(QQServiceForAV.this.getPackageName());
                                intent2.setFlags(32);
                                QQServiceForAV.this.sendBroadcast(intent2);
                                new RtcVideoRecoveryNodeReport(qQAppInterface.getCurrentUin(), "", e17, 3000).c();
                            }
                            QQServiceForAV.this.G = false;
                        }
                        intent = new Intent();
                        intent.setAction("tencent.av.v2q.StopVideoChat");
                        intent.putExtra("uinType", QQServiceForAV.this.f74319d);
                        intent.putExtra("bindType", QQServiceForAV.this.f74320e);
                        intent.putExtra("bindId", QQServiceForAV.this.f74321f);
                        intent.putExtra("peerUin", QQServiceForAV.this.f74322h);
                        intent.putExtra("extraUin", QQServiceForAV.this.f74324m);
                        intent.putExtra("stopReason", 0);
                        if (qQAppInterface != null) {
                            currentUin = 0;
                        } else {
                            currentUin = qQAppInterface.getCurrentUin();
                        }
                        intent.putExtra("selfUin", currentUin);
                        intent.setPackage(QQServiceForAV.this.getApplication().getPackageName());
                        qQServiceForAV = QQServiceForAV.this;
                        if (qQServiceForAV.f74322h != null && (qQServiceForAV.f74319d != 1006 || qQServiceForAV.f74324m != null)) {
                            AVCoreLog.printAllUserLog("QQServiceForAV", "ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = " + QQServiceForAV.this.f74319d + ", peerUin = " + QQServiceForAV.this.f74322h);
                            QQServiceForAV.this.sendBroadcast(intent);
                        }
                        if (qQAppInterface != null) {
                            long n3 = qQAppInterface.getAVNotifyCenter().n();
                            int o16 = qQAppInterface.getAVNotifyCenter().o();
                            int y16 = (int) qQAppInterface.getAVNotifyCenter().y(o16, n3);
                            if (n3 > 0 && QQServiceForAV.this.Q) {
                                long longValue = Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue();
                                Intent intent3 = new Intent();
                                intent3.setAction("tencent.av.v2q.MultiVideo");
                                intent3.putExtra("type", 23);
                                intent3.putExtra("friendUin", longValue);
                                intent3.putExtra("relationType", o16);
                                intent3.putExtra("relationId", n3);
                                intent3.putExtra("from", "QQServiceForAV");
                                intent3.putExtra("MultiAVType", qQAppInterface.getAVNotifyCenter().l(n3));
                                if (y16 > 1) {
                                    intent3.putExtra("roomUserNum", y16 - 1);
                                } else {
                                    intent3.putExtra("roomUserNum", 0);
                                }
                                intent3.setPackage(QQServiceForAV.this.getApplication().getPackageName());
                                AVCoreLog.printAllUserLog("QQServiceForAV", "linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=" + QQServiceForAV.this.f74319d + " roomNum=" + y16);
                                QQServiceForAV.this.sendBroadcast(intent3);
                            }
                            QQServiceForAV.this.Q = false;
                            qQAppInterface.getAVNotifyCenter().R0(0, 0);
                        }
                        QAVNotification.h(QQServiceForAV.this.getApplicationContext());
                        ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
                    }
                }
                z17 = z16;
                if (QQServiceForAV.this.G) {
                }
                intent = new Intent();
                intent.setAction("tencent.av.v2q.StopVideoChat");
                intent.putExtra("uinType", QQServiceForAV.this.f74319d);
                intent.putExtra("bindType", QQServiceForAV.this.f74320e);
                intent.putExtra("bindId", QQServiceForAV.this.f74321f);
                intent.putExtra("peerUin", QQServiceForAV.this.f74322h);
                intent.putExtra("extraUin", QQServiceForAV.this.f74324m);
                intent.putExtra("stopReason", 0);
                if (qQAppInterface != null) {
                }
                intent.putExtra("selfUin", currentUin);
                intent.setPackage(QQServiceForAV.this.getApplication().getPackageName());
                qQServiceForAV = QQServiceForAV.this;
                if (qQServiceForAV.f74322h != null) {
                    AVCoreLog.printAllUserLog("QQServiceForAV", "ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = " + QQServiceForAV.this.f74319d + ", peerUin = " + QQServiceForAV.this.f74322h);
                    QQServiceForAV.this.sendBroadcast(intent);
                }
                if (qQAppInterface != null) {
                }
                QAVNotification.h(QQServiceForAV.this.getApplicationContext());
                ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
            }
        }

        QQServiceForAVBinder() {
        }

        private void Q0(IBinder iBinder) {
            if (!((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive()) {
                AVCoreLog.printAllUserLog("QQServiceForAV", "linkToVideoProcessDeath");
                ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).setMonitorBinder(iBinder);
                try {
                    iBinder.linkToDeath(new b(), 0);
                } catch (RemoteException e16) {
                    ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
                    AVCoreLog.printErrorLog("QQServiceForAV", "linkToVideoProcessDeath exception msg = " + e16.getMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit u0(long j3, Boolean bool, List list) {
            QLog.w("QQServiceForAV", 1, "getAdminMemberList: onOIDB0X899_0_Ret, isSuccess=" + bool + ", adminUins=" + list);
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (TextUtils.isEmpty(QQServiceForAV.this.f74323i) && qQAppInterface != null) {
                QQServiceForAV.this.f74323i = qQAppInterface.getCurrentAccountUin();
            }
            String str = QQServiceForAV.this.f74323i;
            if (list.contains(str)) {
                QQServiceForAV.this.V(j3, Long.parseLong(str));
                return null;
            }
            return null;
        }

        @Override // com.tencent.av.service.g
        public void A1(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, String.format("keepVideoProcessAlive keepAlive=%s", Boolean.valueOf(z16)));
            }
            QQServiceForAV.this.G = z16;
        }

        @Override // com.tencent.av.service.g
        public long[] B0(String str) {
            AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) ((QQAppInterface) QQServiceForAV.this.Q()).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
            if (aIOAnimationControlManager != null) {
                return aIOAnimationControlManager.v(str);
            }
            return null;
        }

        @Override // com.tencent.av.service.g
        public String[] C0(String str) throws RemoteException {
            TroopManager troopManager;
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null && (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
                TroopInfo k3 = troopManager.k(str);
                if (k3 == null) {
                    return new String[0];
                }
                if (!TextUtils.isEmpty(k3.Administrator)) {
                    return k3.Administrator.split("\\|");
                }
            }
            return new String[0];
        }

        @Override // com.tencent.av.service.g
        public void C2(String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + str);
            }
            ((QQAppInterface) QQServiceForAV.this.Q()).getAvAddFriendService().g(str);
        }

        @Override // com.tencent.av.service.g
        public boolean D2(int i3) throws RemoteException {
            if (QQServiceForAV.this.H == null) {
                QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
                QQServiceForAV.this.H = new xw.a(qQAppInterface);
            }
            return QQServiceForAV.this.H.f(i3);
        }

        @Override // com.tencent.av.service.g
        public boolean F1(String str, boolean z16) {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            qQAppInterface.addObserver(QQServiceForAV.this.U);
            GVideoHandler gVideoHandler = (GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (gVideoHandler != null) {
                try {
                    gVideoHandler.N2(str, z16);
                    return true;
                } catch (Exception e16) {
                    qQAppInterface.removeObserver(QQServiceForAV.this.U);
                    QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->error,e=" + e16.getMessage());
                    return false;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
            }
            qQAppInterface.removeObserver(QQServiceForAV.this.U);
            return false;
        }

        @Override // com.tencent.av.service.g
        public void G2(com.tencent.av.service.h hVar) throws RemoteException {
            if (hVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
                    return;
                }
                return;
            }
            ConditionSearchManager conditionSearchManager = (ConditionSearchManager) ((AppService) QQServiceForAV.this).app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
            if (conditionSearchManager != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
                }
                if (conditionSearchManager.j() == 1) {
                    if (conditionSearchManager.h0(conditionSearchManager.j(), true) == 0) {
                        if (QQServiceForAV.this.M == null) {
                            QQServiceForAV.this.M = new j(this, conditionSearchManager, hVar);
                        } else {
                            QQServiceForAV.this.M.a(hVar);
                        }
                        conditionSearchManager.g(QQServiceForAV.this.M);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
                    }
                    b1(false, hVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
                }
                b1(true, hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
            }
            b1(false, hVar);
        }

        @Override // com.tencent.av.service.g
        public void G4(int i3, long j3, int i16, int i17) throws RemoteException {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            GVideoHandler gVideoHandler = (GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (gVideoHandler != null) {
                try {
                    QLog.w("QQServiceForAV", 1, "requestGrayVideoWebViewConfig, identity[" + i3 + "], guin[" + j3 + "], clientId[" + i16 + "], appVersion[" + i17 + "]");
                    qQAppInterface.addObserver(QQServiceForAV.this.U);
                    gVideoHandler.Q2(i3, j3);
                    return;
                } catch (Exception e16) {
                    qQAppInterface.removeObserver(QQServiceForAV.this.U);
                    if (QLog.isColorLevel()) {
                        QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->error,e=" + e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->can not get TroopHandle");
            }
        }

        @Override // com.tencent.av.service.g
        public boolean H1(String str, String str2) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "queryTroopMember troopUin = " + str + "memUin:" + str2);
            }
            if (((QQAppInterface) QQServiceForAV.this.Q()) == null || ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "QQServiceForAV") != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.av.service.g
        public void J1(String str) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) ((QQAppInterface) QQServiceForAV.this.Q()).getRuntimeService(IRedTouchManager.class, "");
            iRedTouchManager.onRedTouchItemExposure(iRedTouchManager.getAppInfoByPath(str), "");
        }

        @Override // com.tencent.av.service.g
        public boolean K0(final long j3) throws RemoteException {
            QLog.w("QQServiceForAV", 1, "getAdminMemberList, troopUin[" + j3 + "]");
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopAdmin(String.valueOf(j3), null, new Function2() { // from class: com.tencent.av.service.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u06;
                    u06 = QQServiceForAV.QQServiceForAVBinder.this.u0(j3, (Boolean) obj, (List) obj2);
                    return u06;
                }
            });
            return true;
        }

        @Override // com.tencent.av.service.g
        public boolean K2() throws RemoteException {
            return AppSetting.f99565y;
        }

        @Override // com.tencent.av.service.g
        public long[] K4(String str) throws RemoteException {
            ArrayList<DiscussionMemberInfo> m3 = ((n) ((QQAppInterface) QQServiceForAV.this.Q()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(str);
            if (m3 != null) {
                int size = m3.size();
                long[] jArr = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    DiscussionMemberInfo discussionMemberInfo = m3.get(i3);
                    if (discussionMemberInfo != null) {
                        jArr[i3] = Long.valueOf(discussionMemberInfo.memberUin).longValue();
                    }
                }
                return jArr;
            }
            return null;
        }

        @Override // com.tencent.av.service.g
        public boolean L0(String str, int i3, int i16, byte[] bArr) throws RemoteException {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            FMTransC2CMsgInfo fMTransC2CMsgInfo = new FMTransC2CMsgInfo();
            fMTransC2CMsgInfo.subCmd = i16;
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "send0x211C2CMsg");
            }
            return qQAppInterface.getMsgHandler().a3().f0(str, i3, bArr, fMTransC2CMsgInfo);
        }

        @Override // com.tencent.av.service.g
        public void L1(com.tencent.av.service.f fVar, String str) throws RemoteException {
            if (fVar != null) {
                QQServiceForAV.this.K.register(fVar, str);
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "registerCallback");
                }
                Q0(fVar.asBinder());
                QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
                qQAppInterface.mQQServiceRef = null;
                qQAppInterface.mQQServiceRef = new WeakReference<>(QQServiceForAV.this);
            }
        }

        @Override // com.tencent.av.service.g
        public void L2(long j3) throws RemoteException {
            ((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().F0(j3);
        }

        @Override // com.tencent.av.service.g
        public String M(int i3, String str, String str2, int i16) {
            Setting qQHeadSettingFromDB;
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "getAvatarDownloadUrl uinType = " + i3 + ", uin = " + str + ", extraUin = " + str2);
            }
            String str3 = null;
            if (ew.c.d(i3) && (qQHeadSettingFromDB = ((QQAppInterface) QQServiceForAV.this.Q()).getQQHeadSettingFromDB(str)) != null && !TextUtils.isEmpty(qQHeadSettingFromDB.uin) && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
                str3 = ew.c.a(qQHeadSettingFromDB.url, i16, qQHeadSettingFromDB.bFaceFlags);
            }
            if (!QQServiceForAV.this.W.contains(str)) {
                QQServiceForAV.this.W.add(str);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("QQServiceForAV", 4, "getAvatarDownloadUrl, uin[" + str + "], path[" + str3 + "]");
            }
            return str3;
        }

        @Override // com.tencent.av.service.g
        public Bundle M0(int i3, int i16, int i17, byte[] bArr, final Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
            boolean z16;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestEvent, mainCmd[");
                sb5.append(i3);
                sb5.append("], subType[");
                sb5.append(i16);
                sb5.append("], seq[");
                sb5.append(i17);
                sb5.append("], buf[");
                boolean z17 = false;
                if (bArr != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("], bundle[");
                if (bundle != null) {
                    z17 = true;
                }
                sb5.append(z17);
                sb5.append("]");
                QLog.d("QQServiceForAV", 1, sb5.toString());
                com.tencent.av.utils.e.m("requestEvent", bundle);
            }
            if (bundle == null) {
                return new Bundle();
            }
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 7) {
                                    String string = bundle.getString("red_touch_app_id");
                                    QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
                                    if (qQAppInterface != null) {
                                        bundle.putParcelable("red_touch_red_app_info", com.tencent.mobileqq.redtouch.g.a(((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(string)));
                                    }
                                    return bundle;
                                }
                                return null;
                            }
                            return cp.k((QQAppInterface) QQServiceForAV.this.Q(), bundle.getString("uin"));
                        }
                        return QAVHrMeeting.c((QQAppInterface) QQServiceForAV.this.Q(), bundle);
                    }
                    QAVHrMeeting.r((QQAppInterface) QQServiceForAV.this.Q(), bundle);
                    return null;
                }
                String string2 = bundle.getString("uin");
                QQAppInterface qQAppInterface2 = (QQAppInterface) QQServiceForAV.this.Q();
                boolean g16 = cp.g("GetInviteFlag", qQAppInterface2, string2);
                cp.i("GetInviteFlag", qQAppInterface2, string2);
                bundle.putBoolean("enableInvite", g16);
                return bundle;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.3
                @Override // java.lang.Runnable
                public void run() {
                    QQServiceForAV.W((QQAppInterface) QQServiceForAV.this.Q(), bundle);
                }
            }, 1L);
            return null;
        }

        @Override // com.tencent.av.service.g
        @Deprecated
        public int N3() {
            return 0;
        }

        @Override // com.tencent.av.service.g
        public void O1(String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + str);
            }
            ((QQAppInterface) QQServiceForAV.this.Q()).getAvAddFriendService().d(str);
        }

        @Override // com.tencent.av.service.g
        public boolean O3() throws RemoteException {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface == null) {
                return false;
            }
            return qQAppInterface.isBackgroundPause;
        }

        @Override // com.tencent.av.service.g
        public boolean P0(int i3, long j3) throws RemoteException {
            if (((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().y(i3, j3) > 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.av.service.g
        public void P1(String str, String str2, String str3, int i3) throws RemoteException {
            if (!"1".equals(str3) && !"2".equals(str3)) {
                if ("3".equals(str3)) {
                    QQServiceForAV.this.S(str);
                    return;
                }
                return;
            }
            QQServiceForAV.this.P(str, str2, str3, i3);
        }

        @Override // com.tencent.av.service.g
        public void P3(String str, String str2, String str3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "sendMessageToTroop");
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null) {
                MessageRecord d16 = q.d(-1000);
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                d16.init(qQAppInterface.getCurrentAccountUin(), str3, qQAppInterface.getCurrentAccountUin(), str, K0, -1000, 1, K0);
                d16.issend = 1;
                qQAppInterface.getMessageFacade().a(d16, null);
            }
        }

        @Override // com.tencent.av.service.g
        public int Q1() throws RemoteException {
            return ((IPhoneContactService) ((QQAppInterface) QQServiceForAV.this.Q()).getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
        }

        @Override // com.tencent.av.service.g
        public void Q3(boolean z16) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "listenTroopListUpdate bListen = " + z16);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null) {
                if (z16) {
                    qQAppInterface.addObserver(QQServiceForAV.this.P);
                } else {
                    qQAppInterface.removeObserver(QQServiceForAV.this.P);
                }
            }
        }

        @Override // com.tencent.av.service.g
        public boolean R4(String str, int i3) throws RemoteException {
            DiscussionInfo h16 = ((n) ((QQAppInterface) QQServiceForAV.this.Q()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
            if (h16 != null) {
                h16.mOrigin = i3;
                return true;
            }
            return false;
        }

        @Override // com.tencent.av.service.g
        public boolean S4() {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null && qQAppInterface.isVideoChatting()) {
                long n3 = qQAppInterface.getAVNotifyCenter().n();
                int o16 = qQAppInterface.getAVNotifyCenter().o();
                if (n3 > 0) {
                    int l3 = qQAppInterface.getAVNotifyCenter().l(n3);
                    if (o16 == 1 && l3 == 2) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // com.tencent.av.service.g
        public int T2() {
            return -1;
        }

        @Override // com.tencent.av.service.g
        public void U3(int i3, String str) throws RemoteException {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface == null) {
                qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            }
            QQServiceForAV qQServiceForAV = QQServiceForAV.this;
            qQServiceForAV.f74319d = i3;
            qQServiceForAV.f74322h = str;
            qQServiceForAV.D = com.tencent.mobileqq.service.message.e.K0();
            qQAppInterface.getMessageFacade().addObserver(QQServiceForAV.this);
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "startPumpMessage uinType = " + i3 + ", peerUin = " + str + ",mStartTime:" + QQServiceForAV.this.D);
            }
        }

        @Override // com.tencent.av.service.g
        public boolean W3(String str, int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "avAddFriend :" + str);
            }
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAvAddFriendService().e(str, i3);
        }

        @Override // com.tencent.av.service.g
        @Deprecated
        public int W4() {
            return 0;
        }

        @Override // com.tencent.av.service.g
        @Deprecated
        public int[] X() {
            return new int[3];
        }

        @Override // com.tencent.av.service.g
        public String X1(String str) throws RemoteException {
            String str2;
            if (str == null) {
                return null;
            }
            IPhoneContactService iPhoneContactService = (IPhoneContactService) ((QQAppInterface) QQServiceForAV.this.Q()).getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
                }
                return null;
            }
            PhoneContact queryPhoneContactByMobile = iPhoneContactService.queryPhoneContactByMobile(str);
            if (queryPhoneContactByMobile != null && (str2 = queryPhoneContactByMobile.name) != null) {
                return str2;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
            }
            return null;
        }

        @Override // com.tencent.av.service.g
        public void Y0(String str) throws RemoteException {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) ((QQAppInterface) QQServiceForAV.this.Q()).getRuntimeService(IRedTouchManager.class, "");
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "redTouchManagerDismiss, appId " + str);
            }
            iRedTouchManager.dismissRedTouch(str);
        }

        String Z(QQAppInterface qQAppInterface, String str, String str2) {
            String str3;
            PhoneContact phoneContact;
            if (!str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                if (str2 == null || !str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    return "";
                }
                str3 = str2;
            } else {
                str3 = str;
            }
            IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            String str4 = null;
            if (iPhoneContactService != null) {
                phoneContact = iPhoneContactService.queryContactByCodeNumber(str3);
            } else {
                phoneContact = null;
            }
            if (phoneContact != null) {
                return phoneContact.name;
            }
            String m06 = ac.m0(qQAppInterface, str3);
            if (m06 == null) {
                if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    if (str2 == null || str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        str2 = null;
                    }
                } else {
                    str2 = str;
                }
                if (str2 != null) {
                    ac.c(qQAppInterface, str3, str2);
                }
                m06 = str2;
            }
            if (m06 != null) {
                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
                str4 = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            }
            if (str4 != null && !str4.equals(m06)) {
                return str4;
            }
            FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            if (friendListHandler != null && m06 != null) {
                QQServiceForAV.this.V.add(m06);
                qQAppInterface.addObserver(QQServiceForAV.this.Y);
                friendListHandler.getFriendInfo(m06);
                return str3;
            }
            return str3;
        }

        @Override // com.tencent.av.service.g
        public boolean b0(String str) throws RemoteException {
            long j3;
            if (!(((AppService) QQServiceForAV.this).app instanceof QQAppInterface)) {
                return false;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) QQServiceForAV.this).app;
            try {
                j3 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                j3 = 0;
            }
            long y16 = qQAppInterface.getAVNotifyCenter().y(ba.uinType2AVRelationType(1), j3);
            aj ajVar = (aj) ((QQAppInterface) ((AppService) QQServiceForAV.this).app).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean e16 = ajVar.e(str);
            boolean d16 = ajVar.d(str);
            boolean f16 = ajVar.f(str);
            com.tencent.mobileqq.troop.troopgag.data.e b16 = ajVar.b(str);
            if (y16 != 0 || ((f16 || !e16) && (d16 || b16 == null || b16.f300239b <= 0))) {
                return false;
            }
            return true;
        }

        public void b1(boolean z16, com.tencent.av.service.h hVar) {
            int i3;
            if (z16) {
                i3 = 0;
            } else {
                i3 = -26;
            }
            try {
                hVar.R2(i3, ConditionSearchManager.s());
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", e16);
                }
            }
        }

        @Override // com.tencent.av.service.g
        public boolean c0(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "requestDecodeStrangeFace");
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            QQServiceForAV qQServiceForAV = QQServiceForAV.this;
            if (qQServiceForAV.E == null) {
                qQServiceForAV.E = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
                QQServiceForAV qQServiceForAV2 = QQServiceForAV.this;
                qQServiceForAV2.E.setDecodeTaskCompletionListener(qQServiceForAV2.I);
            }
            if (i3 == 25) {
                return QQServiceForAV.this.E.requestDecodeQCallFace(str, 16, true, false);
            }
            return QQServiceForAV.this.E.requestDecodeStrangeFace(str, 200, true, false);
        }

        @Override // com.tencent.av.service.g
        public void c5(long[] jArr, String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "getGVideoLevelInfo uins = " + jArr.toString() + " troopuin = " + str);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            qQAppInterface.addObserver(QQServiceForAV.this.U);
            GVideoHandler gVideoHandler = (GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (gVideoHandler != null) {
                try {
                    gVideoHandler.F2(jArr, Long.parseLong(str));
                    return;
                } catch (NumberFormatException e16) {
                    QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
            }
            qQAppInterface.removeObserver(QQServiceForAV.this.U);
        }

        @Override // com.tencent.av.service.g
        public boolean d4() throws RemoteException {
            boolean p16 = uv.b.p(new uv.c((QQAppInterface) QQServiceForAV.this.Q()));
            if (QLog.isColorLevel()) {
                QLog.w("PtuResCheck", 2, "getEffectsSoLoadIsOk, ret[" + p16 + "]");
            }
            return p16;
        }

        @Override // com.tencent.av.service.g
        public void d5(String str, int i3, int i16, byte[] bArr) throws RemoteException {
            ProtoUtils.a((QQAppInterface) QQServiceForAV.this.Q(), new a(str, i16), bArr, str, i3, i16);
        }

        @Override // com.tencent.av.service.g
        public int e0(String str) throws RemoteException {
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAvAddFriendService().i(str);
        }

        @Override // com.tencent.av.service.g
        public void e4(int i3) throws RemoteException {
            o oVar;
            IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) ((AppService) QQServiceForAV.this).app.getRuntimeService(IEarlyDownloadService.class, "");
            if (iEarlyDownloadService != null && (oVar = (o) iEarlyDownloadService.getEarlyHandler("qq.android.qav.video")) != null) {
                oVar.I(false);
            }
        }

        @Override // com.tencent.av.service.g
        public void f1() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "avStopAddFriendService");
            }
            ((QQAppInterface) QQServiceForAV.this.Q()).releaseAvAddFriendService();
        }

        @Override // com.tencent.av.service.g
        public long f3(String str) throws RemoteException {
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().D(str);
        }

        @Override // com.tencent.av.service.g
        public void g0(com.tencent.av.service.f fVar) throws RemoteException {
            if (fVar != null) {
                QQServiceForAV.this.K.unregister(fVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "unregisterCallback");
            }
            ((QQAppInterface) QQServiceForAV.this.Q()).mQQServiceRef = null;
        }

        @Override // com.tencent.av.service.g
        public void g5(String str) {
            ((IRedTouchManager) ((QQAppInterface) QQServiceForAV.this.Q()).getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(str);
        }

        @Override // com.tencent.av.service.g
        public String getPhoneNumByUin(String str) throws RemoteException {
            int selfBindState;
            PhoneContact queryPhoneContactByUin;
            String str2 = null;
            if (!TextUtils.isEmpty(str) && ((AppService) QQServiceForAV.this).app != null) {
                FriendsManager friendsManager = (FriendsManager) ((AppService) QQServiceForAV.this).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (friendsManager == null) {
                    return null;
                }
                Card r16 = friendsManager.r(str);
                if (r16 != null) {
                    BusinessCard b16 = BusinessCardUtils.b(r16.bCardInfo);
                    if (b16 != null && !b16.mobilesNum.isEmpty()) {
                        str2 = b16.mobilesNum.get(0);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  list-data phoneNumber:=" + str2);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    IPhoneContactService iPhoneContactService = (IPhoneContactService) ((AppService) QQServiceForAV.this).app.getRuntimeService(IPhoneContactService.class, "");
                    if (iPhoneContactService != null && (((selfBindState = iPhoneContactService.getSelfBindState()) == 9 || selfBindState == 8 || selfBindState == 4 || selfBindState == 2) && PermissionChecker.h().f() && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) != null)) {
                        str2 = queryPhoneContactByUin.mobileNo;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  PhoneContact phoneNumber:=" + str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.tencent.av.service.g
        public String getSKey() throws RemoteException {
            return null;
        }

        @Override // com.tencent.av.service.g
        public String getUinByPhoneNum(String str) throws RemoteException {
            PhoneContact queryPhoneContactByMobile;
            if (str == null || (queryPhoneContactByMobile = ((IPhoneContactService) ((AppService) QQServiceForAV.this).app.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByMobile(str)) == null) {
                return null;
            }
            return queryPhoneContactByMobile.uin;
        }

        @Override // com.tencent.av.service.g
        public void i2(String str) {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            l92.a aVar = (l92.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
            qQAppInterface.addObserver(QQServiceForAV.this.T);
            aVar.W1(str);
        }

        @Override // com.tencent.av.service.g
        public boolean isFriend(String str) throws RemoteException {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "QQServiceForAV");
        }

        @Override // com.tencent.av.service.g
        public String j1(String str) throws RemoteException {
            TroopManager troopManager;
            TroopInfo k3;
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "getTroopOwner mApp = " + qQAppInterface);
            }
            if (qQAppInterface == null || (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) == null || (k3 = troopManager.k(str)) == null) {
                return null;
            }
            return k3.troopowneruin;
        }

        @Override // com.tencent.av.service.g
        public boolean k0() throws RemoteException {
            boolean isInAdelieAVRoom = ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).isInAdelieAVRoom();
            QLog.d("QQServiceForAV", 1, "isInAVGameRoom ret=" + isInAdelieAVRoom);
            return isInAdelieAVRoom;
        }

        @Override // com.tencent.av.service.g
        public void k1(long j3, String str, long j16) throws RemoteException {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null) {
                qQAppInterface.getMsgCache().M(j3, str, j16);
            }
        }

        @Override // com.tencent.av.service.g
        public void k4(com.tencent.av.service.h hVar) throws RemoteException {
            if (hVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "getUserCurrentLocation IQQServiceLocationCallback is null, no need notify");
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface.getApp() != null && NetworkUtil.isNetSupport(qQAppInterface.getApp().getApplicationContext())) {
                if (QQServiceForAV.this.N == null) {
                    QQServiceForAV.this.N = new k();
                }
                QQServiceForAV.this.N.a(hVar);
                if (QQServiceForAV.this.N.b() == 1) {
                    qQAppInterface.addObserver(QQServiceForAV.this.N);
                    ((LBSHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).J2();
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
                        return;
                    }
                    return;
                }
            }
            try {
                hVar.W(false, null);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", e16);
                }
            }
        }

        @Override // com.tencent.av.service.g
        public void m0(int i3, String str) throws RemoteException {
            QQServiceForAV qQServiceForAV = QQServiceForAV.this;
            qQServiceForAV.f74321f = str;
            qQServiceForAV.f74320e = i3;
        }

        @Override // com.tencent.av.service.g
        public int m3(int i3, String str) throws RemoteException {
            boolean z16;
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int o16 = cp.o(qQAppInterface, z16, str);
            QLog.w("QQServiceForAV", 1, "getGroupMemberNum, relationType[" + i3 + "], uin[" + str + "], \u6210\u5458\u6570[" + o16 + "]");
            return o16;
        }

        @Override // com.tencent.av.service.g
        public boolean n() {
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().U();
        }

        @Override // com.tencent.av.service.g
        public void n1(String str, long j3) throws RemoteException {
            AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) ((QQAppInterface) QQServiceForAV.this.Q()).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
            if (aIOAnimationControlManager != null) {
                aIOAnimationControlManager.E(str);
            }
            if (j3 > 0 && (((AppService) QQServiceForAV.this).app instanceof QQAppInterface)) {
                QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) QQServiceForAV.this).app;
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179557e = str;
                sessionInfo.f179555d = 1;
                ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
            }
        }

        @Override // com.tencent.av.service.g
        public int n3(String str) throws RemoteException {
            if (!TextUtils.isEmpty(str)) {
                if (nx.a.d(str)) {
                    return 1025;
                }
                return 1024;
            }
            return -1;
        }

        @Override // com.tencent.av.service.g
        public void n4() throws RemoteException {
            QLog.w("QQServiceForAV", 1, "stopPumpMessage, monbind[" + QQServiceForAV.this.Q + "], IBinder[" + ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive() + "]");
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface == null) {
                qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            }
            qQAppInterface.getMessageFacade().deleteObserver(QQServiceForAV.this);
        }

        String o0(QQAppInterface qQAppInterface, String str, String str2) {
            PhoneContact phoneContact;
            String str3;
            IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null && str2 != null) {
                phoneContact = iPhoneContactService.queryContactByCodeNumber(str2);
            } else {
                phoneContact = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + phoneContact);
            }
            if (phoneContact != null) {
                return phoneContact.name;
            }
            QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) qQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(str);
            QCallCardHandler qCallCardHandler = (QCallCardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.QCALLCARD_HANDLER);
            qCallCardHandler.D2(str);
            qCallCardHandler.F2(QQServiceForAV.this.J);
            if (c16 == null || (str3 = c16.nickname) == null) {
                return "";
            }
            return str3;
        }

        @Override // com.tencent.av.service.g
        public void p2(long j3, String str, int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "reportGVideoOnlineTime uin = " + j3 + " troopuin = " + str + " onlineTime" + i3);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            qQAppInterface.addObserver(QQServiceForAV.this.U);
            GVideoHandler gVideoHandler = (GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (gVideoHandler != null) {
                try {
                    gVideoHandler.O2(j3, Long.parseLong(str), i3);
                    return;
                } catch (NumberFormatException e16) {
                    QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
            }
            qQAppInterface.removeObserver(QQServiceForAV.this.U);
        }

        @Override // com.tencent.av.service.g
        public void p3(boolean z16) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "playFlowerAnimation play: " + z16 + ", mFlowerAnimationActive: " + QQServiceForAV.this.F);
            }
        }

        @Override // com.tencent.av.service.g
        public int q2(String str) throws RemoteException {
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().C(str);
        }

        @Override // com.tencent.av.service.g
        public long r3(String str) throws RemoteException {
            DiscussionInfo h16 = ((n) ((QQAppInterface) QQServiceForAV.this.Q()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
            if (h16 != null) {
                return h16.mOrigin;
            }
            return 0L;
        }

        @Override // com.tencent.av.service.g
        public boolean s() {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null && qQAppInterface.getAVNotifyCenter() != null && qQAppInterface.getAVNotifyCenter().e0()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.av.service.g
        public boolean t2() {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "call isQQSVIP ");
            }
            return VasUtil.getSignedService((QQAppInterface) QQServiceForAV.this.Q()).getVipStatus().isSVip();
        }

        @Override // com.tencent.av.service.g
        public void u1(int i3, String str, String str2) throws RemoteException {
            QQServiceForAV qQServiceForAV = QQServiceForAV.this;
            qQServiceForAV.f74319d = i3;
            qQServiceForAV.f74322h = str;
            qQServiceForAV.f74324m = str2;
            qQServiceForAV.D = com.tencent.mobileqq.service.message.e.K0();
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "setPeerInfo uinType = " + i3 + ", peerUin = " + str + ", extraUin = " + str2 + ",mStartTime:" + QQServiceForAV.this.D);
            }
        }

        @Override // com.tencent.av.service.g
        public void v4() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceForAV", 2, "avStartAddFriendService");
            }
            ((QQAppInterface) QQServiceForAV.this.Q()).getAvAddFriendService();
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0119  */
        @Override // com.tencent.av.service.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Bitmap x1(int i3, String str, String str2, boolean z16, boolean z17) throws RemoteException {
            byte b16;
            Bitmap faceBitmap;
            String str3 = str2;
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "getFaceBitmap uinType = " + i3 + ", uin = " + str + ", extraUin = " + str3 + ", isRound = " + z16);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (z16) {
                b16 = 4;
            } else {
                b16 = 5;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    PhoneContact phoneContact = null;
                    faceBitmap = null;
                    phoneContact = null;
                    if (i3 != 25) {
                        if (i3 != 26) {
                            if (i3 != 1000) {
                                if (i3 != 1001) {
                                    if (i3 != 1004) {
                                        if (i3 != 1006) {
                                            if (i3 != 1010) {
                                                if (i3 != 1024) {
                                                    if (i3 != 3000) {
                                                        if (i3 != 10002) {
                                                            if (i3 != 1020 && i3 != 1021) {
                                                                faceBitmap = qQAppInterface.getFaceBitmap(str, b16, true);
                                                            }
                                                        }
                                                    } else {
                                                        BitmapDrawable bitmapDrawable = (BitmapDrawable) ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).V2(str, false);
                                                        if (bitmapDrawable != null) {
                                                            faceBitmap = bitmapDrawable.getBitmap();
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                                str3 = str;
                                            }
                                            faceBitmap = FaceDrawable.getMobileFaceDrawable(qQAppInterface, str3, b16).getLoadedBitmap();
                                        }
                                    }
                                }
                                faceBitmap = FaceDrawable.getStrangerFaceDrawable((AppInterface) qQAppInterface, 200, str, true).getLoadedBitmap();
                            }
                        } else {
                            faceBitmap = com.tencent.mobileqq.qcall.a.d(qQAppInterface, str3);
                        }
                    } else {
                        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
                        if (iPhoneContactService != null && str3 != null) {
                            phoneContact = iPhoneContactService.queryContactByCodeNumber(str3);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQServiceForAV", 2, "getFaceBitmap contact = " + phoneContact);
                        }
                        if (phoneContact != null) {
                            faceBitmap = FaceDrawable.getMobileFaceDrawable(qQAppInterface, str3, b16).getLoadedBitmap();
                        } else {
                            faceBitmap = qQAppInterface.getFaceBitmap(16, str, (byte) 3, true, 16);
                        }
                    }
                } else {
                    faceBitmap = qQAppInterface.getTroopFaceBitmap(str, b16, false, false);
                }
                if (faceBitmap == null) {
                    if (!QQServiceForAV.this.W.contains(str)) {
                        QQServiceForAV.this.W.add(str);
                    }
                    qQAppInterface.addObserver(QQServiceForAV.this.X);
                }
                if (faceBitmap != null && z17) {
                    if (QLog.isColorLevel()) {
                        QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
                    }
                    if (i3 == 1) {
                        return BaseImageUtil.getDefaultTroopFaceBitmap();
                    }
                    if (i3 == 3000) {
                        return BaseImageUtil.getDefaultDiscusionFaceBitmap();
                    }
                    return BaseImageUtil.getDefaultFaceBitmap();
                }
            }
            faceBitmap = qQAppInterface.getFaceBitmap(str, b16, true);
            if (faceBitmap == null) {
            }
            return faceBitmap != null ? faceBitmap : faceBitmap;
        }

        @Override // com.tencent.av.service.g
        public String x3(int i3, String str, String str2) throws RemoteException {
            String str3;
            String s16;
            FriendListHandler friendListHandler;
            TroopMemberInfo troopMemberInfoSync;
            if (str != null) {
                str = str.trim();
            }
            String str4 = "";
            if (!TextUtils.isEmpty(str)) {
                QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
                try {
                    if (i3 == 1006) {
                        str3 = Z(qQAppInterface, str, str2);
                    } else if (i3 == 26) {
                        str3 = com.tencent.mobileqq.qcall.a.c(qQAppInterface, str2);
                    } else if (i3 == 25) {
                        str3 = o0(qQAppInterface, str, str2);
                    } else if (i3 == 1) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (!ak.e("qav_get_troop_member_sync", true)) {
                                troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "QQServiceForAV");
                            } else {
                                troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "QQServiceForAV", 50L);
                            }
                            if (troopMemberInfoSync != null) {
                                str4 = troopMemberInfoSync.nickInfo.getShowName();
                            }
                        } else {
                            str3 = ac.g0(qQAppInterface, str, false);
                        }
                    } else if (i3 != 1024 && i3 != 1025) {
                        int w3 = ac.w(i3);
                        if (w3 == -1) {
                            s16 = ac.R(qQAppInterface, str, i3);
                        } else {
                            s16 = ac.s(qQAppInterface, str, str2, w3, 0);
                        }
                        if (TextUtils.isEmpty(s16) || str.equals(s16)) {
                            s16 = ac.g(qQAppInterface, str, true);
                        }
                        if (TextUtils.isEmpty(s16)) {
                            s16 = str;
                        }
                        if (str.equals(s16)) {
                            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                            aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
                            s16 = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                            if ((str.equals(s16) || TextUtils.isEmpty(s16)) && (friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) != null) {
                                QQServiceForAV.this.V.add(str);
                                qQAppInterface.addObserver(QQServiceForAV.this.Y);
                                friendListHandler.getFriendInfo(str);
                            }
                        }
                        str4 = s16;
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                        arrayList.add(uidFromUin);
                        if (com.tencent.qqnt.msg.f.b() != null) {
                            str3 = com.tencent.qqnt.msg.f.b().getBuddyNick(arrayList).get(uidFromUin);
                        }
                    }
                    str4 = str3;
                } catch (Throwable th5) {
                    QLog.d("QQServiceForAV", 1, "getDisplayName", th5);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w("QQServiceForAV", 1, "getDisplayName, uinType[" + i3 + "], uin[" + str + "], extraUin[" + str2 + "], name[" + str4 + "]");
            }
            return str4;
        }

        @Override // com.tencent.av.service.g
        public boolean x4(String str) throws RemoteException {
            return ((QQAppInterface) QQServiceForAV.this.Q()).getAVNotifyCenter().d0(str);
        }

        @Override // com.tencent.av.service.g
        public void z0(boolean z16) throws RemoteException {
            SharedPreferences U0 = ea.U0(((QQAppInterface) QQServiceForAV.this.Q()).getApplication().getApplicationContext());
            SharedPreferences.Editor edit = U0.edit();
            if (z16) {
                edit.putBoolean("qav_random_speakeron", true);
                edit.commit();
            } else {
                edit.putBoolean("qav_random_speakeron", false);
                edit.commit();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "qav_random_speakeron: " + U0.getBoolean("qav_random_speakeron", false));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements DecodeTaskCompletionListener {

        /* compiled from: P */
        /* renamed from: com.tencent.av.service.QQServiceForAV$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0742a implements k.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f74333a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bitmap f74334b;

            C0742a(String str, Bitmap bitmap) {
                this.f74333a = str;
                this.f74334b = bitmap;
            }

            @Override // com.tencent.av.service.k.a
            public void a(com.tencent.av.service.k kVar) {
                kVar.f(this.f74333a, this.f74334b);
                kVar.h();
            }
        }

        a() {
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
            }
            new com.tencent.av.service.k(((QQAppInterface) QQServiceForAV.this.Q()).getApp().getApplicationContext()).b(new C0742a(str, bitmap));
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements QCallCardHandler.a {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements k.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f74337a;

            a(String str) {
                this.f74337a = str;
            }

            @Override // com.tencent.av.service.k.a
            public void a(com.tencent.av.service.k kVar) {
                kVar.c(this.f74337a);
                kVar.h();
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.qcall.QCallCardHandler.a
        public void a(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "onGetQCallNickName");
            }
            new com.tencent.av.service.k(((QQAppInterface) QQServiceForAV.this.Q()).getApp().getApplicationContext()).b(new a(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c extends bs {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements IGroupVideoWrapper.a {
            a() {
            }

            @Override // cooperation.groupvideo.api.IGroupVideoWrapper.a
            public void a(IGroupVideoWrapper iGroupVideoWrapper) {
                iGroupVideoWrapper.onUpdateTroopList();
                iGroupVideoWrapper.uninitialize();
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateTroopList() {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface != null) {
                new cooperation.groupvideo.b(qQAppInterface).a(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74341d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f74342e;

        d(String str, String str2) {
            this.f74341d = str;
            this.f74342e = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0040, code lost:
        
            if (r3.optInt("retcode") != 0) goto L37;
         */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str = "";
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody = new WebSsoBody$WebSsoResponseBody();
                        webSsoBody$WebSsoResponseBody.mergeFrom(byteArray);
                        int i16 = webSsoBody$WebSsoResponseBody.ret.get();
                        JSONObject jSONObject = new JSONObject(webSsoBody$WebSsoResponseBody.data.get());
                        if (i16 != 0) {
                            str = jSONObject.optString("msg");
                        } else {
                            jSONObject.getJSONObject("result");
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, followUser 2:" + e16.toString());
                    }
                }
                z16 = false;
            }
            synchronized (QQServiceForAV.this.K) {
                int beginBroadcast = QQServiceForAV.this.K.beginBroadcast();
                for (int i17 = 0; i17 < beginBroadcast; i17++) {
                    try {
                        QQServiceForAV.this.K.getBroadcastItem(i17).K1(z16, this.f74341d, this.f74342e, str);
                    } catch (RemoteException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, followUser 3:" + e17.toString());
                        }
                    }
                }
                QQServiceForAV.this.K.finishBroadcast();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceConnected name=" + componentName + ", service=" + iBinder);
            QQServiceForAV.this.R = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceDisconnected name=" + componentName);
            QQServiceForAV.this.R = false;
            try {
                BaseApplication.getContext().unbindService(this);
            } catch (Throwable th5) {
                QLog.e("QQServiceForAV", 1, "onServiceDisconnected disconnect exception:" + th5, th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f extends l92.d {
        f() {
        }

        @Override // l92.d
        public void h(boolean z16, long j3, String str, int i3, int i16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("QQServiceForAV.onNearbyCardDownload(), isSuccess: ");
                sb5.append(z16);
                sb5.append(", card = ");
                sb5.append(", nickname=" + str + ", gender=" + i3 + ", age=" + i16);
                QLog.d("QQServiceForAV", 2, sb5.toString());
            }
            Intent intent = new Intent();
            intent.setAction("tencent.video.q2v.getNearByProfile");
            intent.putExtra("uin", String.valueOf(j3));
            intent.putExtra("nickname", str);
            intent.putExtra("gender", i3);
            intent.putExtra("age", i16);
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (qQAppInterface == null) {
                qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            }
            if (qQAppInterface != null) {
                qQAppInterface.getApp().sendBroadcast(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class g extends av {
        g() {
        }

        @Override // com.tencent.mobileqq.app.av
        protected void a(boolean z16, String str, boolean z17) {
            String str2;
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, onGetFollowStatus:" + z16 + "," + str + "," + z17);
            }
            synchronized (QQServiceForAV.this.K) {
                int beginBroadcast = QQServiceForAV.this.K.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    if (z17) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    try {
                        QQServiceForAV.this.K.getBroadcastItem(i3).K1(z16, str, str2, "getFollowStatus");
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, onGetFollowStatus:" + e16.toString());
                        }
                    }
                }
                QQServiceForAV.this.K.finishBroadcast();
            }
        }

        @Override // com.tencent.mobileqq.app.av
        protected void b(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18, int i19, long j3) {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (z16) {
                Intent intent = new Intent();
                intent.setAction("tencent.video.v2q.hide.webConfig");
                intent.putExtra("troopUin", str);
                intent.putExtra("color", i3);
                intent.putExtra("url", str2);
                intent.putExtra("grayFlag", i16);
                qQAppInterface.getApp().sendBroadcast(intent);
            }
            qQAppInterface.removeObserver(QQServiceForAV.this.U);
        }

        @Override // com.tencent.mobileqq.app.av
        protected void c(boolean z16, String str, int i3, boolean z17, boolean z18, int i16, int i17) {
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            String string = qQAppInterface.getApp().getString(i3);
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, String.format("onJoinOrExitOpenTroop --> success: %b, troopUin: %s, errorTips: %s isJoin: %b , visitorSpeakEnabled: %b, speakInterval: %d, startSpeakInterval: %d", Boolean.valueOf(z16), str, string, Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Integer.valueOf(i17)));
            }
            if (z17) {
                Intent intent = new Intent();
                intent.setAction("tencent.video.q2v.JoinOpenGroup");
                intent.putExtra("troopUin", str);
                intent.putExtra("success", z16);
                intent.putExtra("errorTips", string);
                intent.putExtra("visitorSpeakEnabled", z18);
                intent.putExtra("speakInterval", i16);
                intent.putExtra("startSpeakInterval", i17);
                qQAppInterface.getApp().sendBroadcast(intent);
            }
            qQAppInterface.removeObserver(QQServiceForAV.this.U);
        }

        @Override // com.tencent.mobileqq.app.av
        protected void d(Object obj) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            RecvGVideoLevelInfo[] recvGVideoLevelInfoArr = new RecvGVideoLevelInfo[length];
            for (int i3 = 0; i3 < length; i3++) {
                recvGVideoLevelInfoArr[i3] = (RecvGVideoLevelInfo) objArr[i3];
            }
            synchronized (QQServiceForAV.this.K) {
                int beginBroadcast = QQServiceForAV.this.K.beginBroadcast();
                for (int i16 = 0; i16 < beginBroadcast; i16++) {
                    try {
                        QQServiceForAV.this.K.getBroadcastItem(i16).E4(recvGVideoLevelInfoArr);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQServiceForAV", 2, "callBack RemoteException", e16);
                        }
                    }
                }
                QQServiceForAV.this.K.finishBroadcast();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class h extends com.tencent.mobileqq.avatar.observer.a {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            Intent intent = new Intent("com.tencent.qqhead.getheadresp2");
            intent.putExtra("uin", str);
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (QQServiceForAV.this.W.contains(str)) {
                qQAppInterface.getApp().sendBroadcast(intent);
            }
            QQServiceForAV.this.W.remove(str);
            if (QQServiceForAV.this.N()) {
                qQAppInterface.removeObserver(QQServiceForAV.this.X);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class i extends ar {
        i() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo uin = " + str);
                QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo isSuccess = " + z16);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) QQServiceForAV.this.Q();
            if (z16 && str != null) {
                Intent intent = new Intent();
                intent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
                intent.putExtra("uin", str);
                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
                intent.putExtra("nick", ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar));
                intent.setPackage(qQAppInterface.getApplication().getPackageName());
                qQAppInterface.getApp().sendBroadcast(intent);
                QQServiceForAV.this.V.remove(str);
                if (QQServiceForAV.this.O()) {
                    qQAppInterface.removeObserver(QQServiceForAV.this.Y);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class j implements ConditionSearchManager.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QQServiceForAVBinder> f74349a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<ConditionSearchManager> f74350b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<com.tencent.av.service.h> f74351c;

        public j(QQServiceForAVBinder qQServiceForAVBinder, ConditionSearchManager conditionSearchManager, com.tencent.av.service.h hVar) {
            this.f74349a = new WeakReference<>(qQServiceForAVBinder);
            this.f74350b = new WeakReference<>(conditionSearchManager);
            this.f74351c = new WeakReference<>(hVar);
        }

        public void a(com.tencent.av.service.h hVar) {
            this.f74351c = new WeakReference<>(hVar);
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            ConditionSearchManager conditionSearchManager = this.f74350b.get();
            if (conditionSearchManager != null) {
                conditionSearchManager.S(this);
            }
            QQServiceForAVBinder qQServiceForAVBinder = this.f74349a.get();
            com.tencent.av.service.h hVar = this.f74351c.get();
            if (qQServiceForAVBinder != null && hVar != null) {
                qQServiceForAVBinder.b1(z16, hVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class k extends bh {

        /* renamed from: d, reason: collision with root package name */
        private List<com.tencent.av.service.h> f74352d = new ArrayList();

        public void a(com.tencent.av.service.h hVar) {
            if (hVar != null) {
                this.f74352d.add(hVar);
            }
        }

        public int b() {
            return this.f74352d.size();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetUserLocation(boolean z16, LBSInfo lBSInfo) {
            Iterator<com.tencent.av.service.h> it = this.f74352d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().W(z16, lBSInfo);
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", e16);
                    }
                }
            }
            this.f74352d.clear();
        }
    }

    private boolean T(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt != 5 && parseInt != 7) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            AVCoreLog.printErrorLog("QQServiceForAV", "isTroopGiftGrayMsg: serviceType(" + str + ") cannot be parse to int");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(QQAppInterface qQAppInterface, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("uin");
            int i3 = bundle.getInt("uinType");
            String string2 = bundle.getString("wording");
            QLog.w("QQServiceForAV", 1, "writeGrayMsg_in_QQ, peerUin[" + string + "], wording[" + string2 + "]");
            if (!TextUtils.isEmpty(string)) {
                com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(string, qQAppInterface.getCurrentAccountUin(), string2, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 65560, 0L);
                MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
                com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
            }
        } catch (Exception e16) {
            QLog.w("QQServiceForAV", 1, "writeGrayMsg_in_QQ, Exception[" + e16.getClass().getName() + "]", e16);
        }
    }

    boolean N() {
        if (this.W.size() == 0) {
            return true;
        }
        return false;
    }

    boolean O() {
        if (this.V.size() == 0) {
            return true;
        }
        return false;
    }

    public void P(String str, String str2, String str3, int i3) {
        byte[] c16;
        QQAppInterface qQAppInterface = (QQAppInterface) Q();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client_ver", AppSetting.f99551k);
            jSONObject.put("from", str2);
            if ("1".equals(str2) && (c16 = qQAppInterface.getMsgCache().c1(str)) != null) {
                jSONObject.put("chat_sig", new String(PluginBaseInfoHelper.Base64Helper.encode(c16, 0)));
            }
            jSONObject.put("targetuin", str);
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.OPERATION, str3);
            jSONObject.put("sourceid", 3088);
            jSONObject.put("sub_sourceid", i3);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, followUser:" + jSONObject);
            }
            NewIntent newIntent = new NewIntent(qQAppInterface.getApplication().getApplicationContext(), m.class);
            newIntent.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
            WebSsoBody$WebSsoRequestBody webSsoBody$WebSsoRequestBody = new WebSsoBody$WebSsoRequestBody();
            webSsoBody$WebSsoRequestBody.type.set(0);
            webSsoBody$WebSsoRequestBody.data.set(jSONObject.toString());
            newIntent.putExtra("data", webSsoBody$WebSsoRequestBody.toByteArray());
            newIntent.setObserver(new d(str, str3));
            qQAppInterface.startServlet(newIntent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_NEARBY_VIDEO_FOLLOW, 2, "QQServiceForAV, followUser 1:" + e16.toString());
            }
        }
    }

    AppRuntime Q() {
        return this.app;
    }

    public Bundle R(int i3, int i16, Bundle bundle) {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getDataFromVideoProcess, mainCmd = ");
            sb5.append(i3);
            sb5.append(",subCmd = ");
            sb5.append(i16);
            sb5.append(",bundle = ");
            sb5.append(bundle);
            sb5.append(",mCallbacks =");
            if (this.K != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.w("QQServiceForAV", 1, sb5.toString());
        }
        RemoteCallbackList<com.tencent.av.service.f> remoteCallbackList = this.K;
        Bundle bundle2 = null;
        if (remoteCallbackList != null) {
            synchronized (remoteCallbackList) {
                int beginBroadcast = this.K.beginBroadcast();
                for (int i17 = 0; i17 < beginBroadcast; i17++) {
                    try {
                        Object broadcastCookie = this.K.getBroadcastCookie(i17);
                        if (broadcastCookie != null && (broadcastCookie instanceof String) && broadcastCookie.equals("video_process_cookie")) {
                            bundle2 = this.K.getBroadcastItem(i17).U2("video_process_cookie", i3, i16, bundle);
                        }
                    } catch (RemoteException unused) {
                    }
                }
                this.K.finishBroadcast();
            }
        }
        return bundle2;
    }

    public void S(String str) {
        QQAppInterface qQAppInterface = (QQAppInterface) Q();
        GVideoHandler gVideoHandler = (GVideoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
        if (gVideoHandler != null) {
            try {
                qQAppInterface.addObserver(this.U);
                gVideoHandler.E2(str);
                return;
            } catch (Exception e16) {
                qQAppInterface.removeObserver(this.U);
                AVCoreLog.printErrorLog(LogTag.TAG_NEARBY_VIDEO_FOLLOW, "QQServiceForAV, getFollowStatus exp:" + e16.getMessage());
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQServiceForAV", 2, "QQServiceForAV, getFollowStatus, troopHandler==null");
        }
    }

    public boolean U(String str, int i3, byte[] bArr) {
        int i16;
        boolean z16;
        synchronized (this.K) {
            int beginBroadcast = this.K.beginBroadcast();
            i16 = 0;
            z16 = false;
            for (int i17 = 0; i17 < beginBroadcast; i17++) {
                try {
                    Object broadcastCookie = this.K.getBroadcastCookie(i17);
                    if ((broadcastCookie instanceof String) && broadcastCookie.equals("video_process_cookie")) {
                        this.K.getBroadcastItem(i17).c1(str, i3, bArr);
                        z16 = true;
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QQServiceForAV", 2, "onReceiveChatRoomPushMsg", th5);
                    }
                    z16 = false;
                }
            }
            this.K.finishBroadcast();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceiveChatRoomPushMsg, msgType[");
            sb5.append(i3);
            sb5.append("], bytes[");
            if (bArr != null) {
                i16 = bArr.length;
            }
            sb5.append(i16);
            sb5.append("], ret[");
            sb5.append(z16);
            sb5.append("]");
            QLog.w("QQServiceForAV", 1, sb5.toString());
        }
        return z16;
    }

    void V(long j3, long j16) {
        QQAppInterface qQAppInterface = (QQAppInterface) Q();
        if (qQAppInterface == null) {
            qQAppInterface = (QQAppInterface) Q();
        }
        if (qQAppInterface != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.q2v.GroupSystemMsg");
            intent.putExtra("type", 3);
            intent.putExtra("relationType", 1);
            intent.putExtra("relationId", j3);
            intent.putExtra("userUin", j16);
            intent.putExtra("needSendCmd", false);
            QLog.w("QQServiceForAV", 1, "sendAdminToVideo, troopUin[" + j3 + "], userUin[" + LogUtil.getSafePrintUin(String.valueOf(j16)) + "], Action[tencent.video.q2v.GroupSystemMsg], type[3]");
            qQAppInterface.getApp().sendBroadcast(intent);
        }
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "onBind");
        }
        this.Q = true;
        QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn intent=" + intent);
        if (!this.R && !intent.getBooleanExtra("noNeedBindAVService", false)) {
            try {
                QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn bind service return " + BaseApplication.getContext().bindService(new Intent(BaseApplication.getContext(), (Class<?>) AVServiceForQQ.class), this.S, 1));
            } catch (Throwable th5) {
                QLog.e("QQServiceForAV", 1, "mHasBindToVideoProcess exception:" + th5, th5);
            }
        }
        return this.L;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "onCreate");
        }
        if ((Q() instanceof QQAppInterface) && (qQAppInterface = (QQAppInterface) Q()) != null) {
            this.f74323i = qQAppInterface.getCurrentAccountUin();
        }
        super.onCreate();
        SensorReport.e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AVCoreLog.printAllUserLog("QQServiceForAV", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        QQAppInterface qQAppInterface = (QQAppInterface) Q();
        IFaceDecoder iFaceDecoder = this.E;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.E = null;
        }
        this.Q = false;
        qQAppInterface.removeObserver(this.Y);
        qQAppInterface.removeObserver(this.X);
        ((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
        xw.a aVar = this.H;
        if (aVar != null) {
            aVar.d();
            this.H = null;
        }
        super.onDestroy();
        SensorReport.k(this);
        this.app = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "onStartCommand flags: " + i3 + ", startId: " + i16);
        }
        if ((Q() instanceof QQAppInterface) && (qQAppInterface = (QQAppInterface) Q()) != null) {
            this.f74323i = qQAppInterface.getCurrentAccountUin();
            return 3;
        }
        return 3;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        AVCoreLog.printAllUserLog("QQServiceForAV", "onUnbind");
        this.Q = false;
        this.R = false;
        return super.onUnbind(intent);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        QQAppInterface qQAppInterface;
        int i3;
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceForAV", 2, "update invalid data!");
                return;
            }
            return;
        }
        QQAppInterface qQAppInterface2 = (QQAppInterface) Q();
        if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "update data: " + obj + ", mLastUniseq: " + this.C + ",mStartTime:" + this.D);
        }
        if (!(obj instanceof MessageRecord)) {
            return;
        }
        MessageRecord messageRecord = (MessageRecord) obj;
        if (!messageRecord.isSendFromLocal()) {
            if ((this.f74323i == null || qQAppInterface2 == null || qQAppInterface2.getMessageFacade() == null) && (qQAppInterface = (QQAppInterface) Q()) != null) {
                this.f74323i = qQAppInterface.getCurrentAccountUin();
            }
            if (!TextUtils.isEmpty(this.f74323i) && !TextUtils.isEmpty(this.f74322h)) {
                if (!this.f74323i.equals(messageRecord.senderuin) && ((messageRecord.isSend() || messageRecord.isread) && (i3 = messageRecord.msgtype) != -2035 && i3 != -2038 && (i3 != 2024 || !T(messageRecord.getExtInfoFromExtStr("gray_tips_serviceType"))))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQServiceForAV", 2, "update  continue 1");
                        return;
                    }
                    return;
                }
                long j3 = messageRecord.time;
                long j16 = messageRecord.uniseq;
                if (this.C == -1) {
                    if (j3 < this.D) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQServiceForAV", 2, "update  continue 2");
                            return;
                        }
                        return;
                    }
                    this.C = j16;
                }
                String str = messageRecord.selfuin;
                String str2 = messageRecord.frienduin;
                String str3 = messageRecord.senderuin;
                int i16 = (int) messageRecord.vipBubbleID;
                if (j16 >= this.C && str != null && str2 != null && str3 != null && this.f74323i.equals(str) && this.f74322h.equals(str2)) {
                    int i17 = messageRecord.msgtype;
                    String str4 = null;
                    switch (i17) {
                        case MessageRecord.MSG_TYPE_TROOP_EFFECT_PIC /* -5015 */:
                            str4 = HardCodeUtil.qqStr(R.string.r2a);
                            break;
                        case MessageRecord.MSG_TYPE_ONLINE_FILE_REQ /* -3007 */:
                        case MessageRecord.MSG_TYPE_TROOP_OBJ_MSG /* -2017 */:
                        case -2005:
                            str4 = getResources().getString(R.string.ien);
                            break;
                        case MessageRecord.MSG_TYPE_GAME_SHARE /* -3005 */:
                            str4 = getResources().getString(R.string.ier);
                            break;
                        case MessageRecord.MSG_TYPE_VIDEO_EMOTICON /* -2079 */:
                            str4 = getResources().getString(R.string.f209505fl);
                            break;
                        case MessageRecord.MSG_TYPE_STICKER_MSG /* -2058 */:
                            str4 = getResources().getString(R.string.iet);
                            break;
                        case MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO /* -2022 */:
                            str4 = getResources().getString(R.string.ies);
                            break;
                        case MessageRecord.MSG_TYPE_STRUCT_MSG /* -2011 */:
                            try {
                                if (!ao.q(messageRecord.istroop) || !(messageRecord instanceof MessageForStructing)) {
                                    AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData);
                                    if (d16 == null) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
                                        }
                                    } else {
                                        str4 = d16.mMsgBrief;
                                    }
                                }
                                break;
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", e16);
                                    break;
                                }
                            }
                            break;
                        case -2007:
                        case -2001:
                            str4 = getResources().getString(R.string.iem);
                            break;
                        case -2002:
                        case -1031:
                            str4 = getResources().getString(R.string.ieq);
                            break;
                        case -2000:
                            str4 = getResources().getString(R.string.iep);
                            break;
                        case MessageRecord.MSG_TYPE_MIX /* -1035 */:
                            if (messageRecord instanceof MessageForMixedMsg) {
                                str4 = (String) MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg) messageRecord);
                                break;
                            }
                            break;
                        case -1000:
                            str4 = messageRecord.f203106msg;
                            if (str4 != null && str4.indexOf(AppConstants.GOOGLEMAP_URL_HTTPS) != -1) {
                                str4 = getResources().getString(R.string.ieo);
                                break;
                            }
                            break;
                        case MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS /* 2024 */:
                            if (messageRecord instanceof MessageForGrayTips) {
                                str4 = MessageForGrayTips.getOrginMsg(((MessageForGrayTips) messageRecord).getSummaryMsg());
                                break;
                            }
                            break;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQServiceForAV", 2, ", vipBubbleId: " + i16 + ", senderUin: " + str3 + ", msgtype: " + i17 + ", msg: " + str4 + ", time: " + j3 + ", uinseq: " + j16 + ", mLastUniseq: " + this.C);
                    }
                    this.C = j16 + 1;
                }
            }
        }
    }
}
