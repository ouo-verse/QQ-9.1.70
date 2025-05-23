package com.tencent.mobileqq.qqlive.api.impl.anchor;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.prepare.d;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorObsRoom;
import com.tencent.mobileqq.qqlive.anchor.room.am;
import com.tencent.mobileqq.qqlive.anchor.room.an;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRoomSetting;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import ir4.a;
import ir4.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveModuleAnchorImpl implements IQQLiveModuleAnchor {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_DEFAULT = -1;
    public static final String ERROR_NULL = "sso is null";
    private static final String NICKNAME_TAG = "Audience|nickname_module|QQLiveSDK_anchor";
    private static final String TAG = "Audience|QQLiveSDK_anchor";
    private IQQLiveAnchorRoom curRoom;
    private IQQLiveSDK sdkImpl;

    public QQLiveModuleAnchorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.curRoom = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public IQQLiveAnchorRoom createFastResumeRoom(QQLiveAnchorRecord qQLiveAnchorRecord, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQQLiveAnchorRoom) iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQLiveAnchorRecord, (Object) iQQLiveAnchorRoomCallback);
        }
        IQQLiveAnchorRoom f16 = QQLiveAnchorHelperFastResume.f(this.sdkImpl, qQLiveAnchorRecord, iQQLiveAnchorRoomCallback);
        this.curRoom = f16;
        return f16;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public IQQLiveAnchorPrepareWrapper createPrepareWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IQQLiveAnchorPrepareWrapper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public IQQLiveAnchorRoom createRoom(@NonNull Context context, @NonNull QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IQQLiveAnchorRoom) iPatchRedirector.redirect((short) 6, this, context, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "anchor module create room: " + qQLiveAnchorRoomConfig.streamRecordType);
        }
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = qQLiveAnchorRoomConfig.streamRecordType;
        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
            this.curRoom = new an(context, this.sdkImpl, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        } else if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST) {
            this.curRoom = new QQLiveAnchorObsRoom(context, this.sdkImpl, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        } else {
            this.curRoom = new am(context, this.sdkImpl, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
        }
        return this.curRoom;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "anchor module destroy");
        }
        this.sdkImpl = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public void destroyRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "anchor module, destroy room");
        }
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.curRoom;
        if (iQQLiveAnchorRoom != null) {
            iQQLiveAnchorRoom.destroy();
        }
        this.curRoom = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public IQQLiveAnchorRoom getCurRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQQLiveAnchorRoom) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.curRoom;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public void getRoomSetting(long j3, IQQLiveGetRoomSettingCallback iQQLiveGetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), iQQLiveGetRoomSettingCallback);
            return;
        }
        a aVar = new a();
        aVar.f408443a = j3;
        c cVar = (c) this.sdkImpl.getExtModule("sso_module");
        if (cVar == null) {
            iQQLiveGetRoomSettingCallback.onFailed(-1, "getRoomSetting:sso is null");
        } else {
            cVar.f("trpc.qlive.room_data_svr.RoomDataSvr", "GetRoomSetting", MessageNano.toByteArray(aVar), new f(iQQLiveGetRoomSettingCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IQQLiveGetRoomSettingCallback val$callback;

                {
                    this.val$callback = iQQLiveGetRoomSettingCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveModuleAnchorImpl.this, (Object) iQQLiveGetRoomSettingCallback);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int i3, boolean z16, h hVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    boolean z17 = true;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                        return;
                    }
                    AegisLogger.i(QQLiveModuleAnchorImpl.NICKNAME_TAG, "getRoomSetting receive, type:" + i3 + ", success:" + z16);
                    try {
                        com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                        b c16 = b.c(hVar.e());
                        IQQLiveGetRoomSettingCallback iQQLiveGetRoomSettingCallback2 = this.val$callback;
                        if (c16.f408444a != 2) {
                            z17 = false;
                        }
                        iQQLiveGetRoomSettingCallback2.onSuccess(new QQLiveRoomSetting(z17));
                    } catch (QQLiveAnchorThrowable e16) {
                        AegisLogger.e(QQLiveModuleAnchorImpl.NICKNAME_TAG, "getRoomSetting failed: ", e16.message);
                        this.val$callback.onFailed(e16.originCode, e16.originMsg);
                    } catch (Throwable th5) {
                        AegisLogger.e(QQLiveModuleAnchorImpl.NICKNAME_TAG, "getRoomSetting failed: ", th5.getMessage());
                        this.val$callback.onFailed(0, hVar.f());
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public QQLiveAnchorRecord getValidAnchorRecord(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QQLiveAnchorRecord) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return QQLiveAnchorHelperFastResume.j(this.sdkImpl.getAppRuntime().getApplicationContext(), this.sdkImpl.getAppId(), str, this.sdkImpl);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "anchor module init");
        }
        this.sdkImpl = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public void removeAnchorRecord(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            QQLiveAnchorHelperFastResume.p(this.sdkImpl.getAppRuntime().getApplicationContext(), this.sdkImpl.getAppId(), str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public void setRoomSetting(long j3, boolean z16, IQQLiveSetRoomSettingCallback iQQLiveSetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Boolean.valueOf(z16), iQQLiveSetRoomSettingCallback);
            return;
        }
        ir4.f fVar = new ir4.f();
        fVar.f408454a = j3;
        fVar.f408455b = !z16;
        c cVar = (c) this.sdkImpl.getExtModule("sso_module");
        if (cVar == null) {
            iQQLiveSetRoomSettingCallback.onFailed(-1, "setRoomSetting:sso is null");
        } else {
            cVar.f("trpc.qlive.room_data_svr.RoomDataSvr", "SetRoomSetting", MessageNano.toByteArray(fVar), new f(iQQLiveSetRoomSettingCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IQQLiveSetRoomSettingCallback val$callback;

                {
                    this.val$callback = iQQLiveSetRoomSettingCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveModuleAnchorImpl.this, (Object) iQQLiveSetRoomSettingCallback);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int i3, boolean z17, h hVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z17), hVar);
                        return;
                    }
                    AegisLogger.i(QQLiveModuleAnchorImpl.NICKNAME_TAG, "setRoomSetting receive, type:" + i3 + ", success:" + z17);
                    try {
                        com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z17, hVar);
                        this.val$callback.onSuccess();
                    } catch (QQLiveAnchorThrowable e16) {
                        AegisLogger.e(QQLiveModuleAnchorImpl.NICKNAME_TAG, "setRoomSetting failed: ", e16.message);
                        this.val$callback.onFailed(e16.originCode, e16.originMsg);
                    } catch (Throwable th5) {
                        AegisLogger.e(QQLiveModuleAnchorImpl.NICKNAME_TAG, "setRoomSetting failed: ", th5.getMessage());
                        this.val$callback.onFailed(0, hVar.f());
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
    public int tryCloseIsolatedRoom(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), str)).intValue();
        }
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK != null && iQQLiveSDK.isInited() && this.sdkImpl.getLoginModule() != null && this.sdkImpl.getLoginModule().isLogined()) {
            if (j3 > 0 && !TextUtils.isEmpty(str)) {
                IQQLiveSDK iQQLiveSDK2 = this.sdkImpl;
                com.tencent.mobileqq.qqlive.anchor.room.helper.c.c(iQQLiveSDK2, iQQLiveSDK2.getAppId(), com.tencent.mobileqq.qqlive.anchor.util.a.D(j3, str), new ExitRoomCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveModuleAnchorImpl.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
                    public void onComplete(int i3, String str2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str2);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(QQLiveModuleAnchorImpl.TAG, 1, i3 + "_" + str2);
                        }
                    }
                });
                return 0;
            }
            return QQLiveError.ANCHOR_ISOLATE_CLOSE_ARGUMENT_INVALID;
        }
        return QQLiveError.ANCHOR_ISOLATE_CLOSE_SDK_NOT_READY;
    }
}
