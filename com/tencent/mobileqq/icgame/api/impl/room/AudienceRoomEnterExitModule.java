package com.tencent.mobileqq.icgame.api.impl.room;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.corelog.EnterExitRoomLog;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.ExitRoomType;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import yy0.f;
import yy0.g;
import yy0.u;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AudienceRoomEnterExitModule {
    private static final String TAG = "ICGameCoreEnterRoom";
    private IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    EnterRoomInfo currentInfo = null;
    LiveInfo liveInfo = null;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSdkStatus(IQQLiveSDK iQQLiveSDK) {
        if (iQQLiveSDK != null && iQQLiveSDK.isInited() && !iQQLiveSDK.isDestroyed()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoginUserInfo(IQQLiveSDK iQQLiveSDK, f fVar) {
        if (iQQLiveSDK != null && fVar != null) {
            if (iQQLiveSDK.getLoginModule() == null) {
                this.iAegisLogApi.e("ICGameCoreEnterRoom", "updateLoginUserInfo fail! getLoginModule is null!");
                return;
            }
            IQQLiveModuleLogin loginModule = iQQLiveSDK.getLoginModule();
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            u uVar = fVar.f451459r;
            liveUserInfo.uid = uVar.f451534a;
            liveUserInfo.nick = uVar.f451536c;
            liveUserInfo.headUrl = uVar.f451538e;
            liveUserInfo.sex = fVar.f451446e.f451535b;
            loginModule.updateUserInfo(liveUserInfo);
            return;
        }
        this.iAegisLogApi.e("ICGameCoreEnterRoom", "updateLoginUserInfo fail! liveSDK:" + iQQLiveSDK + " reply:" + fVar);
    }

    public void enterRoom(final EnterRoomInfo enterRoomInfo, EnterRoomReqConfig enterRoomReqConfig, final IQQLiveSDK iQQLiveSDK, AudienceRoomConfig.VideoFormat videoFormat, @Nullable final b32.c cVar) {
        String shareToken;
        boolean z16;
        if (!checkSdkStatus(iQQLiveSDK)) {
            EnterExitRoomLog.INSTANCE.errorEnterRoom("enterRoom, but sdk status error");
            if (cVar != null) {
                cVar.onFailed(5109, "sdk status error");
                return;
            }
            return;
        }
        setRoomInfo(enterRoomInfo);
        final g gVar = new g();
        gVar.f451461a = enterRoomInfo.getRoomId();
        gVar.f451467g = enterRoomInfo.getChannelId();
        gVar.f451464d = new String[]{videoFormat.value};
        gVar.f451466f = enterRoomInfo.getProgramId();
        gVar.f451468h = enterRoomInfo.getTransData();
        gVar.f451462b = enterRoomInfo.getDeviceMachineCode();
        if (!TextUtils.isEmpty(enterRoomInfo.getExtraData())) {
            gVar.f451465e = enterRoomInfo.getExtraData().getBytes();
        }
        if (!TextUtils.isEmpty(enterRoomInfo.getSource())) {
            gVar.f451463c = enterRoomInfo.getSource().getBytes();
        }
        if (TextUtils.isEmpty(enterRoomInfo.getShareToken())) {
            shareToken = "";
        } else {
            shareToken = enterRoomInfo.getShareToken();
        }
        gVar.f451470j = shareToken;
        if (iQQLiveSDK == null) {
            EnterExitRoomLog.INSTANCE.errorEnterRoom("try exitRoom but liveSDK is null!");
            if (cVar != null) {
                cVar.onFailed(5108, "liveSDK is null");
                return;
            }
            return;
        }
        IQQLiveModule extModule = iQQLiveSDK.getExtModule("sso_module");
        if (extModule instanceof com.tencent.mobileqq.icgame.sso.c) {
            final long currentTimeMillis = System.currentTimeMillis();
            h hVar = new h(new com.tencent.mobileqq.icgame.sso.a() { // from class: com.tencent.mobileqq.icgame.api.impl.room.AudienceRoomEnterExitModule.1
                private void callFailed(int i3, String str) {
                    if (enterRoomInfo.getRoomId() != AudienceRoomEnterExitModule.this.currentInfo.getRoomId()) {
                        EnterExitRoomLog.INSTANCE.errorEnterRoom("this response is not match currentRoom");
                        return;
                    }
                    b32.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.onFailed(i3, str);
                    }
                }

                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onBusinessFailed(int i3, String str) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    AudienceRoomEnterExitModule.this.iAegisLogApi.e("ICGameCoreEnterRoom", 1, gVar.f451461a + " enterRoom businessFailed, code " + i3 + ", msg " + str + ", cost " + currentTimeMillis2);
                    callFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.icgame.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    AudienceRoomEnterExitModule.this.iAegisLogApi.e("ICGameCoreEnterRoom", 1, gVar.f451461a + " enterRoom failed, code " + i3 + ", msg " + str + ", cost " + currentTimeMillis2);
                    callFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onProxyRequestSuccess(int i3, i iVar) {
                    if (enterRoomInfo.getRoomId() != AudienceRoomEnterExitModule.this.currentInfo.getRoomId()) {
                        EnterExitRoomLog.INSTANCE.errorEnterRoom("this response is not match currentRoom");
                        return;
                    }
                    try {
                        f c16 = f.c(iVar.e());
                        LiveInfo b16 = t42.b.b(c16);
                        AudienceRoomEnterExitModule audienceRoomEnterExitModule = AudienceRoomEnterExitModule.this;
                        audienceRoomEnterExitModule.liveInfo = b16;
                        audienceRoomEnterExitModule.updateLoginUserInfo(iQQLiveSDK, c16);
                        if (!AudienceRoomEnterExitModule.this.checkSdkStatus(iQQLiveSDK)) {
                            AudienceRoomEnterExitModule.this.iAegisLogApi.e("ICGameCoreEnterRoom", 1, "enterRoom, but sdk status error");
                            b32.c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.onFailed(5109, "sdk status error");
                                return;
                            }
                            return;
                        }
                        AudienceRoomEnterExitModule.this.iAegisLogApi.i("ICGameCoreEnterRoom", 1, String.format("guestEnterRoom success, roomId %s, ssoSeq: %s, cost %s", Long.valueOf(enterRoomInfo.getRoomId()), Integer.valueOf(iVar.h().getRequestSsoSeq()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                        b32.c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.onSuccess(AudienceRoomEnterExitModule.this.liveInfo);
                        }
                    } catch (Exception e16) {
                        b32.c cVar4 = cVar;
                        if (cVar4 != null) {
                            cVar4.onFailed(-3301, e16.getMessage());
                        }
                    }
                }
            });
            com.tencent.mobileqq.icgame.sso.c cVar2 = (com.tencent.mobileqq.icgame.sso.c) extModule;
            byte[] byteArray = MessageNano.toByteArray(gVar);
            if (enterRoomReqConfig != null && enterRoomReqConfig.getSelfNotify()) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar2.g("trpc.icggame.room_access.RoomAccessSvr", "EnterRoom", byteArray, z16, hVar);
            return;
        }
        QLog.e("ICGameCoreEnterRoom", 1, "try exitRoom but ssoModule is null!");
        if (cVar != null) {
            cVar.onFailed(5108, "ssoModule is null");
        }
    }

    public void exitRoom(IQQLiveSDK iQQLiveSDK, final ExitRoomCallback exitRoomCallback) {
        if (this.currentInfo == null) {
            EnterExitRoomLog.INSTANCE.errorExitRoom("exitRoom failed currentInfo is null");
            return;
        }
        final py0.e eVar = new py0.e();
        eVar.f428050a = this.currentInfo.getRoomId();
        eVar.f428051b = ExitRoomType.UserLeave.ordinal();
        if (iQQLiveSDK == null) {
            EnterExitRoomLog.INSTANCE.errorExitRoom("try exitRoom but liveSDK is null!");
            if (exitRoomCallback != null) {
                exitRoomCallback.onComplete(5108, "liveSDK is null");
                return;
            }
            return;
        }
        IQQLiveModule extModule = iQQLiveSDK.getExtModule("sso_module");
        if (extModule instanceof com.tencent.mobileqq.icgame.sso.c) {
            ((com.tencent.mobileqq.icgame.sso.c) extModule).f("trpc.icggame.room_dispatch.RoomDispatch", "LeaveRoom", MessageNano.toByteArray(eVar), new com.tencent.mobileqq.icgame.sso.g() { // from class: com.tencent.mobileqq.icgame.api.impl.room.AudienceRoomEnterExitModule.2
                @Override // com.tencent.mobileqq.icgame.sso.g
                public void onReceive(int i3, boolean z16, i iVar) {
                    if (z16) {
                        ExitRoomCallback exitRoomCallback2 = exitRoomCallback;
                        if (exitRoomCallback2 != null) {
                            exitRoomCallback2.onComplete(0, "");
                        }
                        QLog.i("ICGameCoreEnterRoom", 1, "exitRoom success id " + eVar.f428050a);
                        return;
                    }
                    ExitRoomCallback exitRoomCallback3 = exitRoomCallback;
                    if (exitRoomCallback3 != null) {
                        exitRoomCallback3.onComplete(5108, "sso return failed");
                    }
                    if (iVar != null) {
                        EnterExitRoomLog.INSTANCE.errorExitRoom("exitRoom failed code is " + iVar.b() + " msg is " + iVar.c());
                        return;
                    }
                    EnterExitRoomLog.INSTANCE.errorExitRoom("RspData is null");
                }
            });
            return;
        }
        QLog.e("ICGameCoreEnterRoom", 1, "try exitRoom but ssoModule is null!");
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(5108, "ssoModule is null");
        }
    }

    @Nullable
    public BaseAnchorInfo getAnchorInfo() {
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo == null) {
            return null;
        }
        return liveInfo.anchorInfo;
    }

    public LiveInfo getLiveInfo() {
        return this.liveInfo;
    }

    @Nullable
    public BaseRoomInfo getRoomInfo() {
        LiveRoomInfo liveRoomInfo;
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo != null && (liveRoomInfo = liveInfo.roomInfo) != null) {
            return liveRoomInfo;
        }
        return this.currentInfo;
    }

    public void recordCurRoom(@Nullable IQQLiveSDK iQQLiveSDK) {
        if (!checkSdkStatus(iQQLiveSDK)) {
            QLog.e("ICGameCoreEnterRoom", 1, "recordCurRoom liveSDK is null");
            return;
        }
        QLog.d("ICGameCoreEnterRoom", 1, "recordCurRoom liveInfo:" + this.liveInfo);
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
                QLog.d("ICGameCoreEnterRoom", 2, "recordCurRoom curRoomInfo:" + qQLiveCurRoomInfo);
            }
            iQQLiveSDK.recordCurRoomInfo(qQLiveCurRoomInfo);
            return;
        }
        QLog.e("ICGameCoreEnterRoom", 1, "recordRoomInfo, liveInfo null");
    }

    public void removeCurRoom(@Nullable IQQLiveSDK iQQLiveSDK) {
        if (!checkSdkStatus(iQQLiveSDK)) {
            QLog.e("ICGameCoreEnterRoom", 1, "recordCurRoom liveSDK is null");
            return;
        }
        EnterRoomInfo enterRoomInfo = this.currentInfo;
        if (enterRoomInfo == null) {
            QLog.e("ICGameCoreEnterRoom", 1, "currentInfo is null");
        } else {
            iQQLiveSDK.removeCurRoomRecord(enterRoomInfo.getRoomId());
        }
    }

    void setRoomInfo(EnterRoomInfo enterRoomInfo) {
        this.currentInfo = enterRoomInfo;
    }
}
