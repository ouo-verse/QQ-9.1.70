package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterExitRoomLog;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.ExitRoomType;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.g;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import rt3.i;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AudienceRoomEnterExitModule {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CoreEnterRoom";
    EnterRoomInfo currentInfo;
    private IAegisLogApi iAegisLogApi;
    LiveInfo liveInfo;

    public AudienceRoomEnterExitModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.currentInfo = null;
        this.liveInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSdkStatus(IQQLiveSDK iQQLiveSDK) {
        if (iQQLiveSDK != null && iQQLiveSDK.isInited() && !iQQLiveSDK.isDestroyed()) {
            return true;
        }
        return false;
    }

    public void enterRoom(EnterRoomInfo enterRoomInfo, EnterRoomReqConfig enterRoomReqConfig, IQQLiveSDK iQQLiveSDK, AudienceRoomConfig.VideoFormat videoFormat, @Nullable EnterAudienceRoomCallback enterAudienceRoomCallback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, enterRoomInfo, enterRoomReqConfig, iQQLiveSDK, videoFormat, enterAudienceRoomCallback);
            return;
        }
        if (!checkSdkStatus(iQQLiveSDK)) {
            EnterExitRoomLog.INSTANCE.errorEnterRoom("enterRoom, but sdk status error");
            if (enterAudienceRoomCallback != null) {
                enterAudienceRoomCallback.onFailed(5109, "sdk status error");
                return;
            }
            return;
        }
        setRoomInfo(enterRoomInfo);
        i iVar = new i();
        iVar.f432303a = enterRoomInfo.getRoomId();
        iVar.f432309g = enterRoomInfo.getChannelId();
        iVar.f432306d = new String[]{videoFormat.value};
        iVar.f432308f = enterRoomInfo.getProgramId();
        iVar.f432310h = enterRoomInfo.getTransData();
        iVar.f432304b = enterRoomInfo.getDeviceId();
        if (!TextUtils.isEmpty(enterRoomInfo.getExtraData())) {
            iVar.f432307e = enterRoomInfo.getExtraData().getBytes();
        }
        if (!TextUtils.isEmpty(enterRoomInfo.getSource())) {
            iVar.f432305c = enterRoomInfo.getSource().getBytes();
        }
        if (iQQLiveSDK == null) {
            EnterExitRoomLog.INSTANCE.errorEnterRoom("try exitRoom but liveSDK is null!");
            if (enterAudienceRoomCallback != null) {
                enterAudienceRoomCallback.onFailed(5108, "liveSDK is null");
                return;
            }
            return;
        }
        IQQLiveModule extModule = iQQLiveSDK.getExtModule("sso_module");
        if (extModule instanceof com.tencent.mobileqq.qqlive.sso.c) {
            g gVar = new g(new com.tencent.mobileqq.qqlive.sso.a(enterRoomInfo, enterAudienceRoomCallback, iQQLiveSDK, System.currentTimeMillis(), iVar) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ EnterAudienceRoomCallback val$callback;
                final /* synthetic */ IQQLiveSDK val$liveSDK;
                final /* synthetic */ i val$request;
                final /* synthetic */ EnterRoomInfo val$roomInfo;
                final /* synthetic */ long val$timeStamp;

                {
                    this.val$roomInfo = enterRoomInfo;
                    this.val$callback = enterAudienceRoomCallback;
                    this.val$liveSDK = iQQLiveSDK;
                    this.val$timeStamp = r9;
                    this.val$request = iVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AudienceRoomEnterExitModule.this, enterRoomInfo, enterAudienceRoomCallback, iQQLiveSDK, Long.valueOf(r9), iVar);
                    }
                }

                private void callFailed(int i3, String str) {
                    if (this.val$roomInfo.getRoomId() != AudienceRoomEnterExitModule.this.currentInfo.getRoomId()) {
                        EnterExitRoomLog.INSTANCE.errorEnterRoom("this response is not match currentRoom");
                        return;
                    }
                    EnterAudienceRoomCallback enterAudienceRoomCallback2 = this.val$callback;
                    if (enterAudienceRoomCallback2 != null) {
                        enterAudienceRoomCallback2.onFailed(i3, str);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.a
                public void onBusinessFailed(int i3, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, i3, (Object) str);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - this.val$timeStamp;
                    AudienceRoomEnterExitModule.this.iAegisLogApi.e("CoreEnterRoom", 1, this.val$request.f432303a + " enterRoom businessFailed, code " + i3 + ", msg " + str + ", cost " + currentTimeMillis);
                    callFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.qqlive.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - this.val$timeStamp;
                    AudienceRoomEnterExitModule.this.iAegisLogApi.e("CoreEnterRoom", 1, this.val$request.f432303a + " enterRoom failed, code " + i3 + ", msg " + str + ", cost " + currentTimeMillis);
                    callFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.qqlive.sso.a
                public void onProxyRequestSuccess(int i3, h hVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) hVar);
                        return;
                    }
                    if (this.val$roomInfo.getRoomId() != AudienceRoomEnterExitModule.this.currentInfo.getRoomId()) {
                        EnterExitRoomLog.INSTANCE.errorEnterRoom("this response is not match currentRoom");
                        return;
                    }
                    try {
                        LiveInfo b16 = com.tencent.mobileqq.qqlive.utils.d.b(rt3.h.c(hVar.e()));
                        AudienceRoomEnterExitModule audienceRoomEnterExitModule = AudienceRoomEnterExitModule.this;
                        audienceRoomEnterExitModule.liveInfo = b16;
                        if (!audienceRoomEnterExitModule.checkSdkStatus(this.val$liveSDK)) {
                            AudienceRoomEnterExitModule.this.iAegisLogApi.e("CoreEnterRoom", 1, "enterRoom, but sdk status error");
                            EnterAudienceRoomCallback enterAudienceRoomCallback2 = this.val$callback;
                            if (enterAudienceRoomCallback2 != null) {
                                enterAudienceRoomCallback2.onFailed(5109, "sdk status error");
                                return;
                            }
                            return;
                        }
                        AudienceRoomEnterExitModule.this.iAegisLogApi.i("CoreEnterRoom", 1, String.format("guestEnterRoom success, roomId %s, ssoSeq: %s, cost %s", Long.valueOf(this.val$roomInfo.getRoomId()), Integer.valueOf(hVar.h().getRequestSsoSeq()), Long.valueOf(System.currentTimeMillis() - this.val$timeStamp)));
                        EnterAudienceRoomCallback enterAudienceRoomCallback3 = this.val$callback;
                        if (enterAudienceRoomCallback3 != null) {
                            enterAudienceRoomCallback3.onSuccess(AudienceRoomEnterExitModule.this.liveInfo);
                        }
                    } catch (Exception e16) {
                        EnterAudienceRoomCallback enterAudienceRoomCallback4 = this.val$callback;
                        if (enterAudienceRoomCallback4 != null) {
                            enterAudienceRoomCallback4.onFailed(-3301, e16.getMessage());
                        }
                    }
                }
            });
            com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) extModule;
            byte[] byteArray = MessageNano.toByteArray(iVar);
            if (enterRoomReqConfig != null && enterRoomReqConfig.getSelfNotify()) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.h("trpc.qlive.room_access.RoomAccess", "EnterRoom", byteArray, z16, gVar);
            return;
        }
        QLog.e("CoreEnterRoom", 1, "try exitRoom but ssoModule is null!");
        if (enterAudienceRoomCallback != null) {
            enterAudienceRoomCallback.onFailed(5108, "ssoModule is null");
        }
    }

    public void exitRoom(IQQLiveSDK iQQLiveSDK, ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iQQLiveSDK, (Object) exitRoomCallback);
            return;
        }
        if (this.currentInfo == null) {
            EnterExitRoomLog.INSTANCE.errorExitRoom("exitRoom failed currentInfo is null");
            return;
        }
        it3.e eVar = new it3.e();
        eVar.f408728a = this.currentInfo.getRoomId();
        eVar.f408729b = ExitRoomType.UserLeave.ordinal();
        if (iQQLiveSDK == null) {
            EnterExitRoomLog.INSTANCE.errorExitRoom("try exitRoom but liveSDK is null!");
            if (exitRoomCallback != null) {
                exitRoomCallback.onComplete(5108, "liveSDK is null");
                return;
            }
            return;
        }
        IQQLiveModule extModule = iQQLiveSDK.getExtModule("sso_module");
        if (extModule instanceof com.tencent.mobileqq.qqlive.sso.c) {
            ((com.tencent.mobileqq.qqlive.sso.c) extModule).f("trpc.qlive.room_dispatch.RoomDispatch", "LeaveRoom", MessageNano.toByteArray(eVar), new f(exitRoomCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ExitRoomCallback val$callback;

                {
                    this.val$callback = exitRoomCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudienceRoomEnterExitModule.this, (Object) exitRoomCallback);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int i3, boolean z16, h hVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                        return;
                    }
                    if (z16) {
                        ExitRoomCallback exitRoomCallback2 = this.val$callback;
                        if (exitRoomCallback2 != null) {
                            exitRoomCallback2.onComplete(0, "");
                        }
                        QLog.d("CoreEnterRoom", 1, "exitRoom success id");
                        return;
                    }
                    ExitRoomCallback exitRoomCallback3 = this.val$callback;
                    if (exitRoomCallback3 != null) {
                        exitRoomCallback3.onComplete(5108, "sso return failed");
                    }
                    if (hVar != null) {
                        EnterExitRoomLog.INSTANCE.errorExitRoom("exitRoom failed code is " + hVar.b() + " msg is " + hVar.c());
                        return;
                    }
                    EnterExitRoomLog.INSTANCE.errorExitRoom("RspData is null");
                }
            });
            return;
        }
        QLog.e("CoreEnterRoom", 1, "try exitRoom but ssoModule is null!");
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(5108, "ssoModule is null");
        }
    }

    @Nullable
    public BaseAnchorInfo getAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseAnchorInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo == null) {
            return null;
        }
        return liveInfo.anchorInfo;
    }

    public LiveInfo getLiveInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.liveInfo;
    }

    @Nullable
    public BaseRoomInfo getRoomInfo() {
        LiveRoomInfo liveRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseRoomInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo != null && (liveRoomInfo = liveInfo.roomInfo) != null) {
            return liveRoomInfo;
        }
        return this.currentInfo;
    }

    public void recordCurRoom(@Nullable IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        if (!checkSdkStatus(iQQLiveSDK)) {
            QLog.e("CoreEnterRoom", 1, "recordCurRoom liveSDK is null");
            return;
        }
        QLog.d("CoreEnterRoom", 1, "recordCurRoom liveInfo:" + this.liveInfo);
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo != null && liveInfo.roomInfo != null) {
            QQLiveCurRoomInfo qQLiveCurRoomInfo = new QQLiveCurRoomInfo();
            qQLiveCurRoomInfo.roomId = this.liveInfo.roomInfo.roomId;
            qQLiveCurRoomInfo.roomType = 2;
            IQQLiveModuleLogin loginModule = iQQLiveSDK.getLoginModule();
            if (loginModule != null && loginModule.getLoginInfo() != null) {
                qQLiveCurRoomInfo.uid = iQQLiveSDK.getLoginModule().getLoginInfo().uid;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CoreEnterRoom", 2, "recordCurRoom curRoomInfo:" + qQLiveCurRoomInfo);
            }
            iQQLiveSDK.recordCurRoomInfo(qQLiveCurRoomInfo);
            return;
        }
        QLog.e("CoreEnterRoom", 1, "recordRoomInfo, liveInfo null");
    }

    public void removeCurRoom(@Nullable IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        if (!checkSdkStatus(iQQLiveSDK)) {
            QLog.e("CoreEnterRoom", 1, "recordCurRoom liveSDK is null");
            return;
        }
        EnterRoomInfo enterRoomInfo = this.currentInfo;
        if (enterRoomInfo == null) {
            QLog.e("CoreEnterRoom", 1, "currentInfo is null");
        } else {
            iQQLiveSDK.removeCurRoomRecord(enterRoomInfo.getRoomId());
        }
    }

    void setRoomInfo(EnterRoomInfo enterRoomInfo) {
        this.currentInfo = enterRoomInfo;
    }
}
