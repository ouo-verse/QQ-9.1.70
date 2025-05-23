package com.tencent.mobileqq.onlinestatus.music;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.an;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.bx;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.f;
import com.tencent.mobileqq.onlinestatus.manager.h;
import com.tencent.mobileqq.onlinestatus.manager.i;
import com.tencent.mobileqq.onlinestatus.manager.k;
import com.tencent.mobileqq.onlinestatus.manager.u;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.aa;
import com.tencent.mobileqq.onlinestatus.utils.q;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0xe59.cmd0xe59$ReqBody;
import tencent.im.cs.cmd0xe59.cmd0xe59$RspBody;
import tencent.im.groupstatus.ImStatus$ImStatusDataPush;
import tencent.im.oidb.cmd0xe62$ReqBody;
import tencent.im.onlinestatus.OnlineStatusExtInfo$CustomStatus;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;
import tencent.im.statsvc.business.info.businessinfo$ReqBody;
import tencent.im.statsvc.business.info.businessinfo$RspBody;
import tencent.im.statsvc.song.StatSvcStatSong$ReqBody;
import tencent.im.statsvc.song.StatSvcStatSong$RspBody;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent$MedalEventRequest;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent$MedalEventResponse;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes16.dex */
public class OnlineStatusHandler extends BusinessHandler {
    private Handler C;

    /* renamed from: d, reason: collision with root package name */
    private c f256036d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f256037e;

    /* renamed from: f, reason: collision with root package name */
    private long f256038f;

    /* renamed from: h, reason: collision with root package name */
    private long f256039h;

    /* renamed from: i, reason: collision with root package name */
    private IOnlineStatusMiniService.b f256040i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f256041m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f256044a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime.Status f256045b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f256046c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f256047d;

        a(ToServiceMsg toServiceMsg, AppRuntime.Status status, long j3, Bundle bundle) {
            this.f256044a = toServiceMsg;
            this.f256045b = status;
            this.f256046c = j3;
            this.f256047d = bundle;
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> eVar) {
            Object attribute = this.f256044a.getAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO);
            if (attribute instanceof CustomShareInfo) {
                CustomShareInfo customShareInfo = (CustomShareInfo) attribute;
                if (this.f256045b == customShareInfo.getOriginStatus() && customShareInfo.getExtStatus() == this.f256046c) {
                    ((CustomHandler) OnlineStatusHandler.this.f256037e.getBusinessHandler(CustomHandler.class.getName())).L2(customShareInfo);
                }
            }
            OnlineStatusHandler.this.notifyUI(1, true, this.f256047d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnlineStatusHandler.this.h3(((Boolean) message.obj).booleanValue());
        }
    }

    public OnlineStatusHandler(AppInterface appInterface) {
        super(appInterface);
        this.f256038f = -1L;
        this.f256039h = -1L;
        this.C = new b(ThreadManagerV2.getQQCommonThreadLooper());
        this.f256037e = appInterface;
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        OlympicMedalEvent$MedalEventResponse olympicMedalEvent$MedalEventResponse = new OlympicMedalEvent$MedalEventResponse();
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "handleOnlineInfoOlympicMedalEvent. ");
        }
        if (z16) {
            try {
                olympicMedalEvent$MedalEventResponse.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("OnlineStatusHandler", 1, "handleOnlineInfoOlympicMedalEvent.  InvalidProtocolBufferMicroException result\uff1a" + e16.toString());
            }
        } else if (fromServiceMsg != null) {
            QLog.e("OnlineStatusHandler", 1, "ERRCODE:" + fromServiceMsg.getResultCode());
        }
        z17 = z16;
        if (z17) {
            pc2.a aVar = new pc2.a();
            if (olympicMedalEvent$MedalEventResponse.event_valid.has()) {
                aVar.i(olympicMedalEvent$MedalEventResponse.event_valid.get());
            } else {
                aVar.i(true);
            }
            if (olympicMedalEvent$MedalEventResponse.pull_interval_seconds.has()) {
                aVar.j(olympicMedalEvent$MedalEventResponse.pull_interval_seconds.get());
            }
            if (olympicMedalEvent$MedalEventResponse.event.has()) {
                aVar.h(olympicMedalEvent$MedalEventResponse.event.get());
            }
            ((u) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(h.class)).R(aVar);
        }
    }

    private void Q2(FromServiceMsg fromServiceMsg, Object obj) {
        try {
            businessinfo$RspBody businessinfo_rspbody = new businessinfo$RspBody();
            businessinfo_rspbody.mergeFrom((byte[]) obj);
            int i3 = businessinfo_rspbody.uint32_error_code.get();
            String str = businessinfo_rspbody.string_error_msg.get();
            int i16 = businessinfo_rspbody.uint32_interval.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusHandler", 2, "handleRecvSetBatteryBusinessInfo,errorCode  = ", Integer.valueOf(i3), " errorMsg=", str, " interval=", Integer.valueOf(i16));
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            businessinfo$RspBody businessinfo_rspbody = new businessinfo$RspBody();
            businessinfo_rspbody.mergeFrom((byte[]) obj);
            int i3 = businessinfo_rspbody.uint32_error_code.get();
            String str = businessinfo_rspbody.string_error_msg.get();
            int i16 = businessinfo_rspbody.uint32_interval.get();
            boolean z16 = false;
            QLog.d("OnlineStatusHandler", 1, "handleRecvSetExtBusinessInfo,errorCode  = ", Integer.valueOf(i3), " errorMsg=", str, " interval=", Integer.valueOf(i16));
            if (i3 == 0) {
                OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) toServiceMsg.getAttribute("online_status_permission_item");
                if (onlineStatusPermissionItem != null) {
                    ((OnlineStatusPermissionManager) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(i.class)).K(new OnlineStatusFriendsPermissionItem(onlineStatusPermissionItem.isAllHasPermission(), onlineStatusPermissionItem.getPermissionUins()));
                }
                int i17 = toServiceMsg.extraData.getInt("StatusId");
                Boolean bool = Boolean.FALSE;
                if (((Boolean) toServiceMsg.getAttribute("from_need_update_delay_time", bool)).booleanValue()) {
                    OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class);
                    onlineStatusDataManager.R(i17, i16);
                    onlineStatusDataManager.S(i17, NetConnInfoCenter.getServerTime());
                }
                boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("from_register", bool)).booleanValue();
                boolean booleanValue2 = ((Boolean) toServiceMsg.getAttribute("from_modify", bool)).booleanValue();
                if (!booleanValue && !booleanValue2) {
                    ((IOnlineStatusService) this.f256037e.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, i17);
                }
            }
            if (i3 == 0) {
                z16 = true;
            }
            notifyUI(7, z16, toServiceMsg.extraData);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void S2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            businessinfo$RspBody businessinfo_rspbody = new businessinfo$RspBody();
            businessinfo_rspbody.mergeFrom((byte[]) obj);
            int i3 = businessinfo_rspbody.uint32_error_code.get();
            String str = businessinfo_rspbody.string_error_msg.get();
            int i16 = businessinfo_rspbody.uint32_interval.get();
            boolean z16 = true;
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusHandler", 2, "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i3), " errorMsg=", str, " interval=", Integer.valueOf(i16));
            }
            if (i3 == 0) {
                OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) toServiceMsg.getAttribute("online_status_permission_item");
                if (onlineStatusPermissionItem != null) {
                    ((OnlineStatusPermissionManager) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(i.class)).K(new OnlineStatusFriendsPermissionItem(onlineStatusPermissionItem.isAllHasPermission(), onlineStatusPermissionItem.getPermissionUins()));
                }
                IOnlineStatusManagerService iOnlineStatusManagerService = (IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "");
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f256037e.getRuntimeService(IOnlineStatusService.class, "");
                ((OnlineStatusDataManager) iOnlineStatusManagerService.getManager(f.class)).Q(-1, i16);
                if (!((Boolean) toServiceMsg.getAttribute("from_register", Boolean.FALSE)).booleanValue()) {
                    iOnlineStatusService.updateOnlineStatus(AppRuntime.Status.online, -1L);
                }
            } else {
                this.f256037e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(OnlineStatusHandler.this.f256037e.getApp(), 1, "\u201c\u6211\u7684\u4f4d\u7f6e\u201d \u5207\u6362\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u3002", 1).show();
                    }
                });
            }
            if (i3 != 0) {
                z16 = false;
            }
            notifyUI(2, z16, null);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess() && obj != null) {
            SvcRespRegister svcRespRegister = (SvcRespRegister) obj;
            long j3 = svcRespRegister.timeStamp;
            byte b16 = svcRespRegister.cReplyCode;
            long j16 = svcRespRegister.iStatus;
            long j17 = svcRespRegister.uExtOnlineStatus;
            long j18 = svcRespRegister.uClientAutoStatusInterval;
            QLog.d("OnlineStatusHandler", 1, "[status][autoMgr] handleRecvSetOnlineStatus timeStamp:", Long.valueOf(j3), " cCode:", Byte.valueOf(b16), " iStatus:", Long.valueOf(j16), " extOnlineStatus:", Long.valueOf(j17), " autoStatusInterval: ", Long.valueOf(j18));
            if (b16 == 0) {
                bundle.putLong("onlineStatus", j16);
                bundle.putLong("extStatus", j17);
                bundle.putLong("autoStatusInterval", j18);
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f256037e.getRuntimeService(IOnlineStatusService.class, "");
                AppRuntime.Status build = AppRuntime.Status.build((int) j16);
                iOnlineStatusService.setOnlineStatus(build, "handleRecvSetOnlineStatus");
                iOnlineStatusService.setExtOnlineStatus(j17);
                ((OnlineStatusDataManager) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class)).M();
                H2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.music.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OnlineStatusHandler.X2();
                    }
                }, 100L);
                c H = bs.H("OnlineStatusHandler");
                if (H == null) {
                    QLog.e("OnlineStatusHandler", 1, "handleRecvSetOnlineStatus simpleInfo is null");
                    notifyUI(1, true, bundle);
                    return;
                } else {
                    H.G0((byte) ((j16 / 10) * 10));
                    H.a1(j17);
                    ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).updateOnlineStatusSimpleInfo(H, "OnlineStatusHandler", new a(toServiceMsg, build, j17, bundle));
                    return;
                }
            }
            if (b16 == 99) {
                bundle.putLong("cCode", 99L);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "handleRecvSetOnlineStatus res:", Boolean.valueOf(fromServiceMsg.isSuccess()));
        }
        if (aa.f()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).setDiyInfo(null);
            }
            aa.a(this.f256037e);
        }
        notifyUI(1, false, bundle);
    }

    private void U2(FromServiceMsg fromServiceMsg, Object obj) {
        byte b16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            b16 = ((SvcRespSetToken) obj).cReplyCode;
        } else {
            b16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "handleRecvSetPushToken res:", Boolean.valueOf(fromServiceMsg.isSuccess()), "replycode = ", Integer.valueOf(b16));
        }
    }

    private void V2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            businessinfo$RspBody businessinfo_rspbody = new businessinfo$RspBody();
            businessinfo_rspbody.mergeFrom((byte[]) obj);
            int i3 = businessinfo_rspbody.uint32_error_code.get();
            String str = businessinfo_rspbody.string_error_msg.get();
            int i16 = businessinfo_rspbody.uint32_interval.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusHandler", 2, "handleRecvSetTencentVideoBusinessInfo,errorCode  = ", Integer.valueOf(i3), " errorMsg=", str, " interval=", Integer.valueOf(i16));
            }
            if (i3 != 0) {
                IOnlineStatusMiniService.b bVar = this.f256040i;
                if (bVar != null) {
                    bVar.a(false);
                }
                notifyUI(10, false, toServiceMsg.extraData);
                return;
            }
            int i17 = toServiceMsg.extraData.getInt("StatusId");
            Boolean bool = Boolean.FALSE;
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("from_register", bool)).booleanValue();
            boolean booleanValue2 = ((Boolean) toServiceMsg.getAttribute("from_modify", bool)).booleanValue();
            if (!booleanValue && !booleanValue2) {
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f256037e.getRuntimeService(IOnlineStatusService.class, "");
                Object attribute = toServiceMsg.getAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO);
                if (attribute instanceof CustomShareInfo) {
                    iOnlineStatusService.updateOnlineStatusUsingShareInfo((CustomShareInfo) attribute);
                } else {
                    iOnlineStatusService.updateOnlineStatus(AppRuntime.Status.online, i17);
                }
                byte[] byteArray = toServiceMsg.extraData.getByteArray("TencentVideoInfo");
                if (byteArray == null) {
                    return;
                }
                OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
                onlineStatusExtInfo$SynchVideoBizInfo.mergeFrom(byteArray);
                String str2 = onlineStatusExtInfo$SynchVideoBizInfo.string_cid.get();
                if (onlineStatusExtInfo$SynchVideoBizInfo.synch_type.get() == 2 && !TextUtils.isEmpty(str2)) {
                    IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
                    c A = bs.A(toServiceMsg.getUin(), "OnlineStatusHandler");
                    if (A != null) {
                        A.d1(str2);
                        A.f1(onlineStatusExtInfo$SynchVideoBizInfo.string_tvURL.get());
                        iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(A, "OnlineStatusHandler", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
                    }
                    ((TencentVideoNameHandler) this.f256037e.getBusinessHandler(TencentVideoNameHandler.class.getName())).D2(1, str2, this.f256037e.getCurrentAccountUin());
                }
            }
            IOnlineStatusMiniService.b bVar2 = this.f256040i;
            if (bVar2 != null) {
                bVar2.a(true);
            }
            notifyUI(10, true, toServiceMsg.extraData);
        } catch (Exception e16) {
            QLog.e("OnlineStatusHandler", 1, "handleRecvSetTencentVideoBusinessInfo: " + e16);
        }
    }

    private void W2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            businessinfo$RspBody businessinfo_rspbody = new businessinfo$RspBody();
            businessinfo_rspbody.mergeFrom((byte[]) obj);
            int i3 = businessinfo_rspbody.uint32_error_code.get();
            String str = businessinfo_rspbody.string_error_msg.get();
            int i16 = businessinfo_rspbody.uint32_interval.get();
            boolean z16 = false;
            long intValue = ((Integer) toServiceMsg.getAttribute("StatusId", 0)).intValue();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusHandler", 2, "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i3), " errorMsg=", str, " interval=", Integer.valueOf(i16), " id=", Long.valueOf(intValue));
            }
            if (i3 == 0) {
                OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class);
                onlineStatusDataManager.R(intValue, i16);
                onlineStatusDataManager.S((int) intValue, NetConnInfoCenter.getServerTime());
            }
            if (i3 == 0) {
                z16 = true;
            }
            notifyUI(3, z16, null);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X2() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        ((IFriendHandlerTempService) waitAppRuntime.getRuntimeService(IFriendHandlerTempService.class, "all")).getOnlineInfo(waitAppRuntime.getCurrentUin(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).requestNTOnlineStatusByUin(str, true, "OnlineStatusHandler");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IFriendHandlerTempService) peekAppRuntime.getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(str, false);
        }
        QLog.i("OnlineStatusHandler", 1, "requestOnlineStatusInfo " + str);
    }

    public boolean G2(boolean z16) {
        if (z16) {
            if (this.f256038f + 5000 < System.currentTimeMillis()) {
                return true;
            }
        } else if (this.f256039h + MiniBoxNoticeInfo.MIN_5 < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public Handler H2() {
        if (this.f256041m == null) {
            this.f256041m = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
        return this.f256041m;
    }

    public void I2(c cVar) {
        if (cVar == null) {
            return;
        }
        String V = cVar.V();
        if (TextUtils.isEmpty(V)) {
            QLog.e("OnlineStatusHandler", 1, "getMusicLyric, songId is empty");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("OnlineStatusHandler", 2, "getMusicLyric, id:", V);
        }
        k kVar = (k) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
        if (kVar.f255966f.containsKey(V)) {
            QLog.e("OnlineStatusHandler", 1, "getMusicLyric return, getting status");
            return;
        }
        this.f256036d = cVar;
        kVar.f255966f.put(V, new com.tencent.mobileqq.lyric.data.b(0, 0, null));
        cmd0xe59$ReqBody cmd0xe59_reqbody = new cmd0xe59$ReqBody();
        cmd0xe59_reqbody.song_id.set(ByteStringMicro.copyFromUtf8(V));
        cmd0xe59_reqbody.zip_compress_flag.set(true);
        if (!TextUtils.isEmpty(cVar.Z())) {
            cmd0xe59_reqbody.song_name.set(ByteStringMicro.copyFromUtf8(cVar.Z()));
        }
        if (!TextUtils.isEmpty(cVar.G())) {
            cmd0xe59_reqbody.singer_name.set(ByteStringMicro.copyFromUtf8(cVar.G()));
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe59", 3673, 0, cmd0xe59_reqbody.toByteArray());
        makeOIDBPkg.getAttributes().put(IOnlineStatusService.SONG_ID, V);
        sendPbReq(makeOIDBPkg);
    }

    public void J2(boolean z16) {
        K2(z16, false);
    }

    public void K2(boolean z16, boolean z17) {
        long j3;
        long currentTimeMillis;
        QLog.d("OnlineStatusHandler", 1, "getOlympicMedalEventReq " + z16, new Throwable("\u6253\u5370\u5806\u6808"));
        if (!z17 && !G2(z16)) {
            if (z16) {
                j3 = this.f256038f + 5000;
                currentTimeMillis = System.currentTimeMillis();
            } else {
                j3 = this.f256039h + MiniBoxNoticeInfo.MIN_5;
                currentTimeMillis = System.currentTimeMillis();
            }
            long j16 = j3 - currentTimeMillis;
            Message obtainMessage = this.C.obtainMessage();
            obtainMessage.obj = Boolean.valueOf(z16);
            obtainMessage.what = 0;
            this.C.removeMessages(0);
            this.C.sendMessageDelayed(obtainMessage, j16);
            QLog.d("OnlineStatusHandler", 1, "sendOlympicMedalEventReq after " + j16 + "ms");
            return;
        }
        h3(z16);
        QLog.d("OnlineStatusHandler", 1, "sendOlympicMedalEventReq.");
    }

    public af L2() {
        return af.C();
    }

    public void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        c cVar;
        String str;
        String str2 = (String) toServiceMsg.getAttribute(IOnlineStatusService.SONG_ID, "");
        k kVar = (k) ((IOnlineStatusManagerService) this.f256037e.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess() && !TextUtils.isEmpty(str2)) {
                    cmd0xe59$RspBody cmd0xe59_rspbody = new cmd0xe59$RspBody();
                    OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xe59_rspbody);
                    boolean z16 = cmd0xe59_rspbody.safe_hit_flag.get();
                    int i3 = cmd0xe59_rspbody.ret.get();
                    int i16 = cmd0xe59_rspbody.sub_ret.get();
                    String stringUtf8 = cmd0xe59_rspbody.f435937msg.get().toStringUtf8();
                    boolean z17 = cmd0xe59_rspbody.zip_compress_flag.get();
                    if (i3 == 0 && !z16) {
                        com.tencent.mobileqq.lyric.data.b bVar = new com.tencent.mobileqq.lyric.data.b(0, 0, new ArrayList());
                        if (cmd0xe59_rspbody.song_lyric.has()) {
                            byte[] byteArray = cmd0xe59_rspbody.song_lyric.get().toByteArray();
                            if (byteArray.length > 0) {
                                if (z17) {
                                    str = new String(q.b(byteArray));
                                } else {
                                    str = new String(byteArray);
                                }
                                bVar = Y2(str);
                            }
                        }
                        if (bVar != null) {
                            kVar.f255966f.put(str2, bVar);
                            Bundle bundle = new Bundle(1);
                            bundle.putString(IOnlineStatusService.SONG_ID, str2);
                            notifyUI(11, true, bundle);
                        }
                    } else {
                        kVar.f255966f.remove(str2);
                        if (z16 && (cVar = this.f256036d) != null && str2.equals(cVar.V())) {
                            this.f256036d.V0("");
                            this.f256036d.R0("");
                            kVar.f255967h.add(this.f256036d.V());
                            a3(this.f256036d.f0());
                        }
                    }
                    QLog.d("OnlineStatusHandler", 1, "handleGetMusicLyric, ret:", Integer.valueOf(i3), " subRet:", Integer.valueOf(i16), " errorMsg:", stringUtf8, " zipFlag:", Boolean.valueOf(z17), " safeHitFlag:", Boolean.valueOf(z16));
                    return;
                }
            } catch (Exception e16) {
                QLog.e("OnlineStatusHandler", 1, "handleGetMusicLyric", e16);
                kVar.f255966f.remove(str2);
                return;
            }
        }
        kVar.f255966f.remove(str2);
    }

    public void O2(FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    StatSvcStatSong$RspBody statSvcStatSong$RspBody = new StatSvcStatSong$RspBody();
                    statSvcStatSong$RspBody.mergeFrom((byte[]) obj);
                    int i3 = statSvcStatSong$RspBody.error_code.get();
                    String str = statSvcStatSong$RspBody.error_msg.get();
                    String str2 = "";
                    if (statSvcStatSong$RspBody.bytes_song_id.get() != null) {
                        str2 = statSvcStatSong$RspBody.bytes_song_id.get().toStringUtf8();
                    }
                    QLog.d("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, errorCode:", Integer.valueOf(i3), " errorMsg:", str, " convertSongId:", str2);
                }
            } catch (Exception e16) {
                QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", e16);
            }
        }
    }

    public void P2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    ImStatus$ImStatusDataPush imStatus$ImStatusDataPush = new ImStatus$ImStatusDataPush();
                    imStatus$ImStatusDataPush.mergeFrom((byte[]) obj);
                    final String valueOf = String.valueOf(imStatus$ImStatusDataPush.uint64_uin.get());
                    int i3 = imStatus$ImStatusDataPush.uint32_music_info_refresh.get();
                    if (i3 == 1) {
                        ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).onMusicInfoChange(valueOf);
                        String currChatUin = ((IMessageFacade) this.f256037e.getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
                        if (valueOf != null && (valueOf.equals(currChatUin) || valueOf.equals(this.f256037e.getCurrentAccountUin()))) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean isContactShown = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).isContactShown();
                        if (z16 || isContactShown) {
                            final int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
                            H2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    QLog.d("OnlineStatusHandler", 1, "getOnlineInfo after music push seq: " + requestSsoSeq);
                                    OnlineStatusHandler.this.a3(valueOf);
                                }
                            }, 500L);
                        }
                        QLog.d("OnlineStatusHandler", 1, "handleRecvMusicStatusPush, uin:", valueOf, " currentChatUin:", StringUtil.getSimpleUinForPrint(currChatUin), " needRefresh:", Integer.valueOf(i3), " isContactShown:", Boolean.valueOf(isContactShown), " isAioShown:", Boolean.valueOf(z16));
                        return;
                    }
                    QLog.d("OnlineStatusHandler", 1, "handleRecvMusicStatusPush needRefresh false, uin:" + valueOf);
                }
            } catch (Exception e16) {
                QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", e16);
            }
        }
    }

    public com.tencent.mobileqq.lyric.data.b Y2(String str) {
        com.tencent.mobileqq.lyric.data.b a16 = com.tencent.mobileqq.lyric.util.b.a(str, true);
        if (a16 == null) {
            return com.tencent.mobileqq.lyric.util.b.a(str, false);
        }
        return a16;
    }

    public void Z2(an anVar) {
        long M = L2().M(this.f256037e);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "pushMusicStatus curExtStatus:", Long.valueOf(M), ", ", anVar);
        }
        if (anVar == null) {
            anVar = new an();
        }
        if (M == 1028) {
            StatSvcStatSong$ReqBody statSvcStatSong$ReqBody = new StatSvcStatSong$ReqBody();
            statSvcStatSong$ReqBody.bool_need_convert.set(anVar.f255410a);
            statSvcStatSong$ReqBody.uint32_song_type.set(anVar.f255413d);
            statSvcStatSong$ReqBody.uint32_remaining_time.set(anVar.f255415f);
            statSvcStatSong$ReqBody.uint32_source_type.set(anVar.f255416g);
            statSvcStatSong$ReqBody.bytes_song_id.set(ByteStringMicro.copyFromUtf8(anVar.f255411b));
            statSvcStatSong$ReqBody.bytes_song_name.set(ByteStringMicro.copyFromUtf8(anVar.f255412c));
            statSvcStatSong$ReqBody.bytes_singer_name.set(ByteStringMicro.copyFromUtf8(anVar.f255414e));
            statSvcStatSong$ReqBody.bool_pause_flag.set(anVar.f255417h);
            statSvcStatSong$ReqBody.uint32_song_play_time.set(anVar.f255418i);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256037e.getCurrentAccountUin(), "StatSvc.SetSong");
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            toServiceMsg.putWupBuffer(statSvcStatSong$ReqBody.toByteArray());
            sendPbReq(toServiceMsg);
        }
    }

    public void b3(int i3, Bundle bundle, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        c3(i3, bundle, onlineStatusPermissionItem, null);
    }

    public void c3(int i3, Bundle bundle, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem, CustomShareInfo customShareInfo) {
        int i16;
        int i17;
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256037e.getCurrentAccountUin(), "StatSvc.SetBusinessInfo");
        businessinfo$ReqBody businessinfo_reqbody = new businessinfo$ReqBody();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 5) {
                        byte[] byteArray = bundle.getByteArray("TencentVideoInfo");
                        businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
                        businessinfo_reqbody.uint32_ext_status.set(1021);
                        businessinfo_reqbody.bytes_business_info.set(ByteStringMicro.copyFrom(byteArray));
                        toServiceMsg.extraData.putAll(bundle);
                    }
                } else {
                    byte[] byteArray2 = bundle.getByteArray("ExtInfo");
                    int i18 = bundle.getInt("StatusId");
                    businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
                    businessinfo_reqbody.uint32_ext_status.set(i18);
                    businessinfo_reqbody.bytes_business_info.set(ByteStringMicro.copyFrom(byteArray2));
                    if (onlineStatusPermissionItem != null) {
                        cmd0xe62$ReqBody cmd0xe62_reqbody = new cmd0xe62$ReqBody();
                        PBUInt32Field pBUInt32Field = cmd0xe62_reqbody.set_type;
                        if (onlineStatusPermissionItem.isAllHasPermission()) {
                            i17 = 1;
                        } else {
                            i17 = 2;
                        }
                        pBUInt32Field.set(i17);
                        if (onlineStatusPermissionItem.getPermissionUins() != null) {
                            cmd0xe62_reqbody.rpt_uint64_uin.set(onlineStatusPermissionItem.getPermissionUins());
                        }
                        businessinfo_reqbody.private_info.set(cmd0xe62_reqbody);
                        toServiceMsg.addAttribute("online_status_permission_item", onlineStatusPermissionItem);
                    }
                    toServiceMsg.extraData.putAll(bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusHandler", 2, "requestSetBusinessInfo: invoked. ", " statusId: ", Integer.valueOf(i18), " onlinePermission: ", onlineStatusPermissionItem);
                    }
                }
            } else {
                byte[] byteArray3 = bundle.getByteArray("LocationInfo");
                businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
                businessinfo_reqbody.uint32_ext_status.set(-1);
                businessinfo_reqbody.bytes_business_info.set(ByteStringMicro.copyFrom(byteArray3));
                if (onlineStatusPermissionItem != null) {
                    cmd0xe62$ReqBody cmd0xe62_reqbody2 = new cmd0xe62$ReqBody();
                    PBUInt32Field pBUInt32Field2 = cmd0xe62_reqbody2.set_type;
                    if (onlineStatusPermissionItem.isAllHasPermission()) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    pBUInt32Field2.set(i16);
                    if (onlineStatusPermissionItem.getPermissionUins() != null) {
                        cmd0xe62_reqbody2.rpt_uint64_uin.set(onlineStatusPermissionItem.getPermissionUins());
                    }
                    businessinfo_reqbody.private_info.set(cmd0xe62_reqbody2);
                    toServiceMsg.addAttribute("online_status_permission_item", onlineStatusPermissionItem);
                }
            }
        } else {
            int i19 = bundle.getInt("BatteryInfo", 0);
            businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
            businessinfo_reqbody.uint32_ext_status.set(1000);
            businessinfo_reqbody.int32_battery_status.set(i19);
        }
        toServiceMsg.addAttribute("from_modify", Boolean.valueOf(bundle.getBoolean("from_modify", false)));
        toServiceMsg.addAttribute("from_register", Boolean.valueOf(bundle.getBoolean("from_register", false)));
        toServiceMsg.addAttribute("from_need_update_delay_time", Boolean.valueOf(bundle.getBoolean("from_need_update_delay_time", false)));
        toServiceMsg.addAttribute("business_type", Integer.valueOf(i3));
        toServiceMsg.addAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO, customShareInfo);
        toServiceMsg.putWupBuffer(businessinfo_reqbody.toByteArray());
        sendPbReq(toServiceMsg);
        QLog.d("OnlineStatusHandler", 1, "requestSetBusinessInfo type:", Integer.valueOf(i3));
    }

    public void d3(AppRuntime appRuntime, AppRuntime.Status status, long j3, long j16, boolean z16, int i3, DiyStatusEmoInfo diyStatusEmoInfo) {
        e3(appRuntime, status, j3, j16, z16, i3, diyStatusEmoInfo, null);
    }

    public void e3(AppRuntime appRuntime, AppRuntime.Status status, long j3, long j16, boolean z16, int i3, DiyStatusEmoInfo diyStatusEmoInfo, CustomShareInfo customShareInfo) {
        QLog.d("OnlineStatusHandler", 1, "requestSetOnlineStatus onlineStatus:" + status + " extStatus:" + j3 + " largeSeq:" + j16 + " isAutoSet:" + z16 + " from:" + i3 + " info:" + diyStatusEmoInfo + " shareInfo:" + customShareInfo);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", appRuntime.getCurrentAccountUin(), IOnlineStatusService.CMD_SET_ONLINE_STATUS);
        Bundle bundle = toServiceMsg.extraData;
        bundle.putLong("K_SEQ", j16);
        bundle.putSerializable("onlineStatus", status);
        bundle.putLong("extOnlineStatus", j3);
        if (status == AppRuntime.Status.online && j3 == 1000) {
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
            try {
                if (iOnlineStatusService.getExtOnlineStatus() != 1000) {
                    iOnlineStatusService.setPowerConnect(af.E());
                }
            } catch (Throwable th5) {
                QLog.e("OnlineStatusHandler", 1, "setOnlineStatus t:", th5);
            }
            bundle.putInt("batteryCapacity", iOnlineStatusService.getBatteryCapacity());
            bundle.putInt("powerConnect", iOnlineStatusService.getPowerConnect());
        }
        if (status == AppRuntime.Status.online && j3 == 2000 && diyStatusEmoInfo != null) {
            OnlineStatusExtInfo$CustomStatus onlineStatusExtInfo$CustomStatus = new OnlineStatusExtInfo$CustomStatus();
            String desc = diyStatusEmoInfo.getDesc();
            int type = diyStatusEmoInfo.getType();
            long id5 = diyStatusEmoInfo.getId();
            if (!TextUtils.isEmpty(desc) && id5 > 0 && type > 0) {
                onlineStatusExtInfo$CustomStatus.sWording.set(desc);
                onlineStatusExtInfo$CustomStatus.ufaceIndex.set(id5);
                onlineStatusExtInfo$CustomStatus.ufaceType.set(type);
            }
            byte[] byteArray = onlineStatusExtInfo$CustomStatus.toByteArray();
            ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setDiyInfo(new DiyStatusEmoInfo(type, id5, desc));
            aa.i(id5, type, desc, appRuntime);
            bundle.putByteArray("diyStatusInfo", byteArray);
        }
        bundle.putBoolean("isAutoSet", z16);
        int L = bs.L();
        bundle.putInt(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, L);
        bundle.putInt("from_type", i3);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "OnlineStatusHandler-requestSetOnlineStatus.vendor_push_type:" + L);
        }
        try {
            if (be.p() && bs.J0()) {
                int i16 = bs.r(status, j3).f256383a;
                if (((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(i16)) {
                    QLog.d("OnlineStatusHandler", 1, "requestSetOnlineStatus.setStatusHasAvatar:" + i16);
                    bundle.putInt(IOnlineStatusService.SET_AVATAR, 1);
                }
            }
        } catch (Exception e16) {
            QLog.e("OnlineStatusHandler", 1, "isSupportAvatarView " + e16);
        }
        toServiceMsg.addAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO, customShareInfo);
        send(toServiceMsg);
    }

    public void f3(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "HPush_requestSetPushToken token:", str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256037e.getCurrentAccountUin(), IOnlineStatusService.CMD_SET_PUSH_TOKEN);
        Bundle bundle = toServiceMsg.extraData;
        bundle.putString("push_token", str);
        bundle.putString("push_profileid", str2);
        if (bx.a()) {
            bundle.putInt(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, bs.L());
        }
        send(toServiceMsg);
    }

    public void g3(int i3, Bundle bundle) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256037e.getCurrentAccountUin(), "StatSvc.SyncBusinessInfo");
        businessinfo$ReqBody businessinfo_reqbody = new businessinfo$ReqBody();
        int i16 = bundle.getInt("StatusId", 0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.w("OnlineStatusHandler", 1, "error type:" + i3);
                    return;
                }
                byte[] byteArray = bundle.getByteArray("ExtInfo");
                businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
                businessinfo_reqbody.uint32_ext_status.set(i16);
                businessinfo_reqbody.bytes_business_info.set(ByteStringMicro.copyFrom(byteArray));
                businessinfo_reqbody.private_info.set(new cmd0xe62$ReqBody());
            } else {
                byte[] byteArray2 = bundle.getByteArray("LocationInfo");
                businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
                businessinfo_reqbody.uint32_ext_status.set(-1);
                businessinfo_reqbody.bytes_business_info.set(ByteStringMicro.copyFrom(byteArray2));
                businessinfo_reqbody.private_info.set(new cmd0xe62$ReqBody());
                i16 = -1;
            }
        } else {
            businessinfo_reqbody.int32_battery_status.set(bundle.getInt("BatteryInfo", 0));
            businessinfo_reqbody.uint32_status.set(AppRuntime.Status.online.getValue());
            i16 = 1000;
            businessinfo_reqbody.uint32_ext_status.set(1000);
        }
        toServiceMsg.addAttribute("StatusId", Integer.valueOf(i16));
        toServiceMsg.addAttribute("business_type", Integer.valueOf(i3));
        toServiceMsg.putWupBuffer(businessinfo_reqbody.toByteArray());
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, "requestSynBusinessInfo type:", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(IOnlineStatusService.CMD_SET_ONLINE_STATUS);
            this.allowCmdSet.add("StatSvc.SetBusinessInfo");
            this.allowCmdSet.add("StatSvc.SyncBusinessInfo");
            this.allowCmdSet.add("StatSvc.SetSong");
            this.allowCmdSet.add(IOnlineStatusService.CMD_RECV_MUSIC_STATUS_PUSH);
            this.allowCmdSet.add("OidbSvc.0xe59");
            this.allowCmdSet.add("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get");
            this.allowCmdSet.add(IOnlineStatusService.CMD_SET_PUSH_TOKEN);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushPBCommandList() {
        return new HashSet<String>() { // from class: com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.1
            {
                add(IOnlineStatusService.CMD_RECV_MUSIC_STATUS_PUSH);
            }
        };
    }

    void h3(boolean z16) {
        OlympicMedalEvent$MedalEventRequest olympicMedalEvent$MedalEventRequest = new OlympicMedalEvent$MedalEventRequest();
        olympicMedalEvent$MedalEventRequest.from_aio.set(z16);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get");
        createToServiceMsg.putWupBuffer(olympicMedalEvent$MedalEventRequest.toByteArray());
        sendPbReq(createToServiceMsg);
        if (z16) {
            this.f256038f = System.currentTimeMillis();
        } else {
            this.f256039h = System.currentTimeMillis();
        }
    }

    public void i3(IOnlineStatusMiniService.b bVar) {
        this.f256040i = bVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return av.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd) && QLog.isColorLevel()) {
                QLog.d("OnlineStatusHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
            }
            if ("StatSvc.SetSong".equals(serviceCmd)) {
                O2(fromServiceMsg, obj);
                return;
            }
            if (IOnlineStatusService.CMD_SET_PUSH_TOKEN.equals(serviceCmd)) {
                U2(fromServiceMsg, obj);
                return;
            }
            if (IOnlineStatusService.CMD_SET_ONLINE_STATUS.equals(serviceCmd)) {
                T2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("StatSvc.SyncBusinessInfo".equals(serviceCmd)) {
                W2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("StatSvc.SetBusinessInfo".equals(serviceCmd)) {
                int intValue = ((Integer) toServiceMsg.getAttribute("business_type", -1)).intValue();
                if (intValue == 2) {
                    S2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                if (intValue == 1) {
                    Q2(fromServiceMsg, obj);
                    return;
                } else if (intValue == 3) {
                    R2(toServiceMsg, fromServiceMsg, obj);
                    return;
                } else {
                    if (intValue == 5) {
                        V2(toServiceMsg, fromServiceMsg, obj);
                        return;
                    }
                    return;
                }
            }
            if (IOnlineStatusService.CMD_RECV_MUSIC_STATUS_PUSH.equals(serviceCmd)) {
                P2(fromServiceMsg, obj);
            } else if ("OidbSvc.0xe59".equals(serviceCmd)) {
                M2(toServiceMsg, fromServiceMsg, obj);
            } else if ("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get".equals(serviceCmd)) {
                N2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
