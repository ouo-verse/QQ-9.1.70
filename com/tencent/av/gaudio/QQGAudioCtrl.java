package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.f;
import com.tencent.av.m;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.aa;
import com.tencent.av.utils.af;
import com.tencent.av.utils.d;
import com.tencent.av.utils.e;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.data.AVInviteAccount;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.engine.mav.IMavAdapter;
import com.tencent.avcore.engine.mav.MavEventId;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.mav.MavEngineProxy;
import com.tencent.avcore.util.AVConstants;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.avcore.util.MavJniUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import tencent.im.groupvideo.memposinfo.memposinfo$AccountExtInfo;
import tencent.im.groupvideo.memposinfo.memposinfo$AccountExtInfoList;
import tencent.im.groupvideo.memposinfo.memposinfo$CommonInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQGAudioCtrl extends MavEngineProxy implements MavEventId, IMavAdapter {
    public static final String SMALL_HOME_SIG = "smallhome";
    static final String TAG = "QQGAudioCtrl";
    static QQGAudioCtrl sQQGAudioCtrl;
    private AVNativeEventProcessor mEventCallback;
    protected final f mSysInfo;
    protected b mMavCallback = null;
    protected long mGroupId = 0;
    public boolean mIsSwitchGroup = false;
    public Vector<Long> mInviteGAudioUinList = new Vector<>();
    public Vector<String> mInviteGAudioOpenIdList = new Vector<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements AVNativeEventProcessor {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            if (message == null) {
                QLog.e(QQGAudioCtrl.TAG, 1, "handleMessage-->Message is empty!");
                return true;
            }
            QQGAudioCtrl qQGAudioCtrl = QQGAudioCtrl.this;
            if (qQGAudioCtrl.mMavCallback == null) {
                QLog.e(QQGAudioCtrl.TAG, 1, "handleMessage-->mVideoControl = null");
                return true;
            }
            MavNativeEventParams mavNativeEventParams = (MavNativeEventParams) message.obj;
            if (mavNativeEventParams == null) {
                QLog.e(QQGAudioCtrl.TAG, 1, "handleMessage-->NativeEventParams is null");
                return true;
            }
            int i3 = message.what;
            byte[] bArr = mavNativeEventParams.detail;
            long j3 = mavNativeEventParams.info;
            long j16 = mavNativeEventParams.groupId;
            int i16 = mavNativeEventParams.multiAVType;
            int i17 = mavNativeEventParams.relationType;
            int i18 = mavNativeEventParams.bufferLen;
            ArrayList<AVInviteAccount> arrayList = null;
            if (i3 != 20) {
                if (i3 != 30) {
                    if (i3 != 33) {
                        if (i3 != 80) {
                            if (i3 != 123) {
                                if (i3 != 186) {
                                    if (i3 != 174) {
                                        if (i3 != 175) {
                                            if (QLog.isColorLevel()) {
                                                QLog.e(QQGAudioCtrl.TAG, 2, "Wrong type of eventid=" + i3);
                                            }
                                        } else {
                                            ReportController.o(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int) j3, "", "", "", "");
                                        }
                                    } else {
                                        ReportController.o(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int) j3, "", "", "", "");
                                    }
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.i(QQGAudioCtrl.TAG, 2, "onMavSpeakingWhenCloseMic");
                                    }
                                    QQGAudioCtrl.this.mMavCallback.j();
                                }
                            } else {
                                int i19 = (int) j3;
                                BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i19));
                                zv.c.c().a("load", i19);
                            }
                        } else {
                            ArrayList<AVUserInfo> aVInfoListFromByte2 = QQGAudioCtrl.getAVInfoListFromByte2(bArr, i18);
                            if (aVInfoListFromByte2 != null) {
                                QQGAudioCtrl.this.mMavCallback.b(j16, aVInfoListFromByte2);
                            }
                        }
                    } else {
                        qQGAudioCtrl.processMicAuthAfterEnterRoom(bArr);
                        if (d.d()) {
                            d.c().j(null, QQGAudioCtrl.this);
                        }
                    }
                } else {
                    qQGAudioCtrl.processMicAuthAfterEnterRoom(bArr);
                    if (d.d()) {
                        d.c().j(null, QQGAudioCtrl.this);
                    }
                }
            } else if (j3 == 0) {
                MavInviteData inviteDataFromBuffer = MavInviteData.getInviteDataFromBuffer(bArr, i18);
                QQGAudioCtrl.this.mMavCallback.onGAudioInviteResp(inviteDataFromBuffer);
                if (inviteDataFromBuffer != null) {
                    arrayList = inviteDataFromBuffer.inviteAccountList;
                }
                if ((i16 == 10 || i16 == 1) && arrayList != null) {
                    long a16 = QQGAudioCtrl.this.mMavCallback.a(i17, i16, j16);
                    ArrayList<com.tencent.av.gaudio.a> arrayList2 = new ArrayList<>(arrayList.size());
                    long i26 = e.i() / 1000;
                    Iterator<AVInviteAccount> it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList2.add(new com.tencent.av.gaudio.a(Long.parseLong(it.next().account), i26));
                        } catch (NumberFormatException e16) {
                            QLog.e(QQGAudioCtrl.TAG, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                        }
                    }
                    QQGAudioCtrl.this.mMavCallback.g(j16, a16, arrayList2);
                    if (QLog.isColorLevel()) {
                        QLog.i(QQGAudioCtrl.TAG, 2, "EM_SDK_EVENT_ID_PB_INVITE_RSP = MULTIAV_GROUP_AUDIO saveInviteMembers");
                    }
                }
            } else {
                if (bArr == null) {
                    str = "";
                } else {
                    str = new String(bArr);
                }
                QQGAudioCtrl.this.mMavCallback.i(j16, j3, str);
            }
            return true;
        }

        @Override // com.tencent.avcore.util.AVNativeEventProcessor
        public boolean isMsgNeedExtraDeal(int i3) {
            if (i3 != 30 && i3 != 33) {
                return false;
            }
            return true;
        }
    }

    protected QQGAudioCtrl() {
        m.a();
        BaseApplication.getContext();
        f fVar = new f();
        this.mSysInfo = fVar;
        initEngine(fVar, this);
        if (d.d()) {
            d.a();
        }
    }

    public static ArrayList<AVUserInfo> getAVInfoListFromByte2(byte[] bArr, int i3) {
        ArrayList<AVUserInfo> arrayList = null;
        if (bArr != null) {
            try {
                if (bArr.length == i3) {
                    memposinfo$AccountExtInfoList memposinfo_accountextinfolist = new memposinfo$AccountExtInfoList();
                    memposinfo_accountextinfolist.mergeFrom(bArr);
                    for (memposinfo$AccountExtInfo memposinfo_accountextinfo : memposinfo_accountextinfolist.msg_account_ext_info.get()) {
                        if (memposinfo_accountextinfo.msg_common_info.has()) {
                            memposinfo$CommonInfo memposinfo_commoninfo = memposinfo_accountextinfo.msg_common_info.get();
                            AVUserInfo aVUserInfo = new AVUserInfo();
                            aVUserInfo.account = String.valueOf(memposinfo_commoninfo.uint64_account.get());
                            aVUserInfo.openId = memposinfo_commoninfo.bytes_account.get().toStringUtf8();
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(aVUserInfo);
                        }
                    }
                }
            } catch (Exception e16) {
                AVCoreLog.e(TAG, "getAVInfoListFromByte2 fail.", e16);
            }
        }
        return arrayList;
    }

    public static QQGAudioCtrl getGAudioCtrlInstance() {
        if (sQQGAudioCtrl == null) {
            if (!AVSoUtils.H()) {
                return null;
            }
            sQQGAudioCtrl = new QQGAudioCtrl();
        }
        return sQQGAudioCtrl;
    }

    private Object[] getRoomParams(SessionInfo sessionInfo) {
        int i3;
        long j3;
        if (sessionInfo == null) {
            return null;
        }
        int i16 = 8;
        if (sessionInfo.f73060o0) {
            j3 = Long.parseLong(sessionInfo.f73091w);
            i3 = 3;
        } else {
            i3 = sessionInfo.S0;
            j3 = sessionInfo.P0;
            if (i3 == 2) {
                i16 = 1;
            } else if (i3 == 1) {
                i16 = sessionInfo.f73063p;
            } else if (i3 != 3) {
                i16 = 0;
            }
        }
        return new Object[]{Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)};
    }

    public int accept(int i3, long j3, int i16, int i17, int i18, int i19) {
        int o16 = af.o();
        if (o16 <= 0) {
            o16 = 5;
        }
        int i26 = o16;
        QLog.w(TAG, 1, "accept, maxShowVideo[" + i26 + "]");
        return accept(i3, j3, i16, i17, i18, i26, i19);
    }

    public int acceptGAudio(int i3, int i16, int i17, long j3, long[] jArr, int i18, long j16, int i19, int i26) {
        if (j3 == 0 || i16 == -1 || i3 == -1 || i17 == -1) {
            return -1;
        }
        this.mGroupId = j3;
        if (i3 == 2 && jArr != null && jArr.length > 0) {
            if (this.mInviteGAudioUinList.size() > 0) {
                this.mInviteGAudioUinList.clear();
            }
            for (long j17 : jArr) {
                if (j17 != j16) {
                    this.mInviteGAudioUinList.add(Long.valueOf(j17));
                }
            }
        }
        int o16 = af.o();
        if (o16 <= 0) {
            o16 = 5;
        }
        int i27 = o16;
        QLog.w(TAG, 1, "acceptGAudio, emAVRelationType[" + i3 + "], emMultiAVType[" + i16 + "], emMultiAVSubType[" + i17 + "], nConfID[" + i19 + "], groupId[" + j3 + "], maxShowVideo[" + i27 + "], audioScene[" + i26 + "]");
        accept(i3, j3, i16, i17, i19, i27, i26);
        return 0;
    }

    @Override // com.tencent.avcore.engine.mav.IMavAdapter
    public byte[] getConfigInfoFromFile() {
        return Common.readFile(BaseApplication.getContext(), Common.FILE_NAME);
    }

    @Override // com.tencent.avcore.engine.IAVAdapter
    public Context getContext() {
        return BaseApplication.getContext();
    }

    @Override // com.tencent.avcore.engine.IAVAdapter
    public AVNativeEventProcessor getNativeEventProcessor() {
        if (this.mEventCallback == null) {
            synchronized (a.class) {
                if (this.mEventCallback == null) {
                    this.mEventCallback = new a();
                }
            }
        }
        return this.mEventCallback;
    }

    public int getRoomUserSdkVersion(SessionInfo sessionInfo, String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (Throwable unused) {
            j3 = 0;
        }
        Object[] roomParams = getRoomParams(sessionInfo);
        if (roomParams != null && j3 != 0) {
            int intValue = ((Integer) roomParams[0]).intValue();
            long longValue = ((Long) roomParams[1]).longValue();
            int intValue2 = ((Integer) roomParams[2]).intValue();
            int roomUserClientVersion = getRoomUserClientVersion(intValue, longValue, intValue2, j3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("getRoomUserSdkVersion [%s, %s, %s, %s, %s]", Integer.valueOf(intValue), Long.valueOf(longValue), Integer.valueOf(intValue2), Long.valueOf(j3), Integer.valueOf(roomUserClientVersion)));
            }
            return roomUserClientVersion;
        }
        return -1;
    }

    public int getRoomUserTerminalType(SessionInfo sessionInfo, String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (Throwable unused) {
            j3 = 0;
        }
        Object[] roomParams = getRoomParams(sessionInfo);
        if (roomParams != null && j3 != 0) {
            int intValue = ((Integer) roomParams[0]).intValue();
            long longValue = ((Long) roomParams[1]).longValue();
            int intValue2 = ((Integer) roomParams[2]).intValue();
            int roomUserTerminalType = getRoomUserTerminalType(intValue, longValue, intValue2, j3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("getRoomUserTerminalType [%s, %s, %s, %s, %s]", Integer.valueOf(intValue), Long.valueOf(longValue), Integer.valueOf(intValue2), Long.valueOf(j3), Integer.valueOf(roomUserTerminalType)));
            }
            return roomUserTerminalType;
        }
        return -1;
    }

    @Override // com.tencent.avcore.engine.mav.IMavAdapter
    public String getSharpConfigPayloadFromFile() {
        String str;
        byte[] readFile = Common.readFile(BaseApplication.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
        String str2 = "";
        if (readFile != null) {
            String str3 = new String(readFile);
            int indexOf = str3.indexOf(124);
            try {
                str = str3.substring(0, indexOf);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "GetSharpConfigPayloadFromFile version e = " + e16);
                }
                str = "";
            }
            try {
                str2 = str3.substring(indexOf + 1);
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "GetSharpConfigPayloadFromFile payload e = " + e17);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "GetSharpConfigPayloadFromFile multi version: " + str + ". payload: " + str2);
            }
        }
        return str2;
    }

    @Override // com.tencent.avcore.engine.mav.IMavAdapter
    public int getSharpConfigVersionFromFile() {
        try {
            byte[] readFile = Common.readFile(BaseApplication.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
            if (readFile != null) {
                String str = new String(readFile);
                if (!TextUtils.isEmpty(str)) {
                    int indexOf = str.indexOf(124);
                    String substring = str.substring(0, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (QLog.isColorLevel()) {
                        QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + substring + ". payload: " + substring2);
                    }
                    return Integer.parseInt(substring);
                }
                QLog.w(TAG, 1, "GetSharpConfigVersionFromFile, payloadBufTmp[" + str + "]");
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "GetSharpConfigVersionFromFile, Exception", e16);
        }
        return 0;
    }

    public void init(Context context, long j3, int i3, boolean z16, int i16, int i17, boolean z17) {
        NtrtcVideoParam ntrtcVideoParam;
        boolean z18;
        aa aaVar = new aa(true);
        NtrtcAppParam b16 = aaVar.b(context.getPackageName());
        NtrtcNetworkParam e16 = aaVar.e(i3);
        NtrtcAudioParam c16 = aaVar.c();
        if (!z16) {
            c16.aiDenoiseModelDir = "";
        }
        c16.audioMode = i16;
        c16.audioStreamType = i17;
        if (z17) {
            ntrtcVideoParam = aaVar.f();
        } else {
            ntrtcVideoParam = null;
        }
        NtrtcVideoParam ntrtcVideoParam2 = ntrtcVideoParam;
        NtrtcCommonParam d16 = aaVar.d();
        int init = super.init(context, String.valueOf(j3), b16, e16, c16, ntrtcVideoParam2, d16);
        String str = c16.traeSoFullFilename;
        boolean z19 = false;
        if (init != -49) {
            z18 = true;
        } else {
            z18 = false;
        }
        AVSoUtils.K(str, z18, 0);
        if (init != 0) {
            QLog.e(TAG, 1, "MAVEngine init failed. result: " + init);
            super.uninit();
            if (init == -49) {
                c16.traeSoFullFilename = AVSoUtils.J(c16.traeSoFullFilename);
            }
            QLog.i(TAG, 1, "MAVEngine reinit start.");
            int init2 = super.init(context, String.valueOf(j3), b16, e16, c16, ntrtcVideoParam2, d16);
            QLog.i(TAG, 1, "MAVEngine reinit end. result: " + init2);
            String str2 = c16.traeSoFullFilename;
            if (init2 != -49) {
                z19 = true;
            }
            AVSoUtils.K(str2, z19, 1);
        }
    }

    public int inviteUser(int i3, long[] jArr, int i16, int i17, int i18, String[] strArr) {
        String[] strArr2;
        String[] strArr3;
        if (i3 == 17) {
            strArr3 = strArr;
        } else {
            if (jArr != null) {
                strArr2 = new String[jArr.length];
                for (int i19 = 0; i19 < jArr.length; i19++) {
                    strArr2[i19] = String.valueOf(jArr[i19]);
                }
            } else {
                strArr2 = null;
            }
            strArr3 = strArr2;
        }
        int invite = invite(i3, strArr3, i16, i17, i18);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(SquareJSConst.Params.PARAMS_UIN_LIST);
            if (jArr != null) {
                for (long j3 : jArr) {
                    sb5.append("[");
                    sb5.append(j3);
                    sb5.append("]");
                }
            } else {
                sb5 = new StringBuilder("uinList [null]");
            }
            sb5.append("openIdList");
            if (strArr != null) {
                for (String str : strArr) {
                    sb5.append("[");
                    sb5.append(str);
                    sb5.append("]");
                }
            } else {
                sb5.append(" openId[null]");
            }
            QLog.i(TAG, 2, "inviteUser, " + ((Object) sb5) + "], nReason[" + i16 + "], original[" + i17 + "], pstnLevel[" + i18 + "], ret[" + invite + "]");
        }
        return invite;
    }

    public void lockVideoMaxQP(int i3, String str) {
        QLog.e(TAG, 1, "LockVideoMaxQP nNewQP=" + i3 + " , strDesc= " + str);
        lockVideoMaxQP(i3);
    }

    public int nativeStopAudioSend(boolean z16) {
        try {
            return stopAudioSend(z16);
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int nativeStopVideoSend() {
        try {
            return stopVideoSend();
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int nativeUpdateRoomInfo(int i3, long j3, int i16, boolean z16, boolean z17, boolean z18) {
        try {
            return updateRoomInfo(i3, j3, i16, z16, z17, z18);
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavAdapter
    public void onReceiveAudio(byte[] bArr, int i3, int i16, int i17, int i18) {
        b bVar = this.mMavCallback;
        if (bVar != null) {
            bVar.h(bArr, i3, i16, i17, i18);
            if (d.d()) {
                d.c().onReceiveAudioFrame(bArr, i18, bArr.length);
            }
        }
    }

    void processMicAuthAfterEnterRoom(byte[] bArr) {
        boolean z16;
        if (bArr != null && bArr.length >= 8) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            if (MavJniUtil.getIntFromByte(bArr2) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            byte[] bArr3 = new byte[4];
            System.arraycopy(bArr, 4, bArr3, 0, 4);
            this.mMavCallback.onGAudioMicSetByAdmin(0L, MavJniUtil.getIntFromByte(bArr3));
            this.mMavCallback.onGAudioRoomMicModeChanged(0L, z16, true);
        }
    }

    @Override // com.tencent.avcore.jni.mav.MavEngineProxy, com.tencent.avcore.engine.mav.IMavEngine
    public int quitRoom(int i3) {
        if (d.d()) {
            d.c().k();
        }
        return super.quitRoom(i3);
    }

    public int request(int i3, long j3, int i16, int i17, int i18, int i19) {
        int o16 = af.o();
        if (o16 <= 0) {
            o16 = 5;
        }
        int i26 = o16;
        QLog.w(TAG, 1, "request, maxShowVideo[" + i26 + "]");
        return request(i3, j3, i16, i17, i18, i19, i26, 0, 0, null);
    }

    public int sendShareFrame(byte[] bArr, int i3, int i16, int i17, int i18) {
        return sendShareFrame2Native(bArr, i3, i16, i17, i18);
    }

    public void setCallback(b bVar) {
        this.mMavCallback = bVar;
        setEventListener(bVar);
    }

    public void setInviteUserList(long j3, long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            if (this.mInviteGAudioUinList.size() > 0) {
                this.mInviteGAudioUinList.clear();
            }
            for (long j16 : jArr) {
                if (j16 != j3) {
                    this.mInviteGAudioUinList.add(Long.valueOf(j16));
                }
            }
        }
    }

    public void setShareEncParam(RecordParam recordParam, int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "setShareEncParam, param[" + recordParam + "], maxW[" + i3 + "], maxH[" + i16 + "], activeNow[" + i17 + "]");
        }
        setShareEncParam(1, recordParam.width, recordParam.height, recordParam.fps, 4, i3, i16, i17);
    }

    public int startAudioSend() {
        return startAudioSend(false);
    }

    public int startCommonGAudio(int i3, int i16, int i17, long j3, long j16, String str, int i18, byte[] bArr, int i19) {
        int i26 = -1;
        if (i3 == 11 && i16 == 14 && i17 == 1) {
            int o16 = af.o();
            if (o16 <= 0) {
                o16 = 5;
            }
            int i27 = o16;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("startCommonGAudio emAVRelationType:");
                sb5.append(i3);
                sb5.append(" emMultiAVType:");
                sb5.append(i16);
                sb5.append(" emMultiAVSubType:");
                sb5.append(i17);
                sb5.append(" roomId:");
                sb5.append(j3);
                sb5.append(" selfUin:");
                sb5.append(j16);
                sb5.append(" llAppid:");
                sb5.append(i18);
                sb5.append(" nConfig:");
                int i28 = 0;
                sb5.append(0);
                sb5.append(" maxShowVideo:");
                sb5.append(i27);
                sb5.append(" openId:");
                sb5.append(str);
                sb5.append(" sourceId:");
                sb5.append(i18);
                sb5.append(" commonSig.length:");
                if (bArr != null) {
                    i28 = bArr.length;
                }
                sb5.append(i28);
                sb5.append(" svrRecogFlag:");
                sb5.append(i19);
                QLog.d(TAG, 2, sb5.toString());
            }
            try {
                int commonRequest = commonRequest(i3, j3, i16, i17, i18, 0, i27, str, i18, bArr, i19);
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "startCommonGAudio result:" + commonRequest);
                        return commonRequest;
                    }
                    return commonRequest;
                } catch (Throwable th5) {
                    th = th5;
                    i26 = commonRequest;
                    QLog.e(TAG, 1, "startCommonGAudio fail.", th);
                    return i26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startCommonGAudio type error!");
            }
            return -1;
        }
    }

    public int startGAudio(int i3, int i16, int i17, long j3, long[] jArr, String[] strArr, int i18, long j16, boolean z16, int i19, int i26, int i27, int i28) {
        byte[] bArr;
        int i29;
        if (i16 == 17) {
            if (this.mInviteGAudioOpenIdList.size() > 0) {
                this.mInviteGAudioOpenIdList.clear();
            }
            if (strArr != null) {
                this.mInviteGAudioOpenIdList.addAll(Arrays.asList(strArr));
            }
            bArr = SMALL_HOME_SIG.getBytes();
        } else {
            if (this.mInviteGAudioUinList.size() > 0) {
                this.mInviteGAudioUinList.clear();
            }
            if (jArr != null) {
                for (long j17 : jArr) {
                    if (j17 != j16) {
                        this.mInviteGAudioUinList.add(Long.valueOf(j17));
                    }
                }
            }
            bArr = null;
        }
        byte[] bArr2 = bArr;
        int o16 = af.o();
        if (o16 <= 0) {
            o16 = 5;
        }
        int i36 = o16;
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "startGAudio, emAVRelationType[" + i3 + "], groupId[" + j3 + "], emMultiAVType[" + i16 + "], emMultiAVSubType[" + i17 + "], isSwitchGroup[" + z16 + "], apnType[" + i18 + "], nConfigID[" + i26 + "], llConfAppid[" + i19 + "], maxShowVideo[" + i36 + "], audioScene[" + i28 + "]");
        }
        try {
            i29 = request(i3, j3, i16, i17, i19, i26, i36, i27, i28, bArr2);
            try {
                this.mGroupId = j3;
                this.mIsSwitchGroup = z16;
            } catch (UnsatisfiedLinkError e16) {
                e = e16;
                AVCoreLog.printErrorLog(TAG, e.getMessage());
                return i29;
            }
        } catch (UnsatisfiedLinkError e17) {
            e = e17;
            i29 = -1;
        }
        return i29;
    }

    public boolean startOrStopShareSend(boolean z16, int i3) {
        int startShareSend;
        if (z16) {
            startShareSend = stopShareSend(i3);
        } else {
            startShareSend = startShareSend(i3);
        }
        QLog.i(TAG, 1, "startOrStopShareSend, stop[" + z16 + "], emShareType[" + i3 + "], ret[" + startShareSend + "]");
        if (startShareSend == 1) {
            return true;
        }
        return false;
    }

    public int startVideoRecv(ArrayList<c> arrayList) {
        return startVideoRecv(arrayList, false);
    }

    @Override // com.tencent.avcore.jni.mav.MavEngineProxy, com.tencent.avcore.engine.mav.IMavEngine
    public void uninit() {
        super.uninit();
    }

    public int sendShareFrame(Bitmap bitmap, int i3, int i16) {
        return sendShareFrame2NativeBmp(bitmap, i3, i16);
    }

    public int startVideoRecv(ArrayList<c> arrayList, boolean z16) {
        if (arrayList == null || arrayList.size() == 0) {
            return 0;
        }
        int size = arrayList.size() * 3;
        String[] strArr = new String[size];
        String str = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int i16 = i3 * 3;
            strArr[i16] = String.valueOf(arrayList.get(i3).f73827a);
            String str2 = str + "uin=" + strArr[i16] + " ,";
            int i17 = i16 + 1;
            strArr[i17] = String.valueOf(arrayList.get(i3).f73828b);
            String str3 = str2 + "videoSrcType=" + strArr[i17] + " ,";
            if (z16) {
                b bVar = this.mMavCallback;
                if (bVar == null) {
                    return 0;
                }
                if (bVar.d(arrayList.get(i3).f73827a, i3)) {
                    strArr[i16 + 2] = "1";
                } else {
                    strArr[i16 + 2] = "0";
                }
            } else if (arrayList.get(i3).f73829c) {
                strArr[i16 + 2] = "1";
            } else {
                strArr[i16 + 2] = "0";
            }
            str = str3 + "isBig=" + strArr[i16 + 2] + " ,";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startVideoRecv-->info=" + str + "viewsize:" + arrayList.size());
        }
        return startVideoRecv(strArr, size);
    }

    public int inviteUser(int i3, long[] jArr, int i16, String[] strArr) {
        String str;
        if (jArr != null) {
            str = SquareJSConst.Params.PARAMS_UIN_LIST;
            for (long j3 : jArr) {
                str = str + "[" + j3 + "]";
            }
        } else {
            str = "[null]";
        }
        if (i3 != 17) {
            if (jArr != null) {
                strArr = new String[jArr.length];
                for (int i17 = 0; i17 < jArr.length; i17++) {
                    strArr[i17] = String.valueOf(jArr[i17]);
                }
            } else {
                strArr = null;
            }
        }
        int invite = invite(i3, strArr, i16, 0, 0);
        QLog.w(TAG, 1, "inviteUser, " + str + ", nReason[" + i16 + "], ret[" + invite + "]");
        return invite;
    }
}
