package com.tencent.av.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.m;
import com.tencent.av.q;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.af;
import com.tencent.av.utils.i;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.engine.dav.DavClosedReason;
import com.tencent.avcore.engine.dav.IDavAdapter;
import com.tencent.avcore.jni.data.NtrtcSessionParam;
import com.tencent.avcore.jni.dav.NtrtcAudio;
import com.tencent.avcore.jni.dav.NtrtcEngine;
import com.tencent.avcore.jni.dav.NtrtcRoom;
import com.tencent.avcore.jni.dav.NtrtcSession;
import com.tencent.avcore.jni.dav.NtrtcUtil;
import com.tencent.avcore.jni.dav.NtrtcVideo;
import com.tencent.avcore.netchannel.IDavNetChannel;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.avcore.util.QavABTestHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.nt.qav.reporter.QavReporter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VcControllerImpl implements DavClosedReason, IDavAdapter {
    private static final String KEY_IS_SESSION_OFFLINE = "is_offline_session";
    private static final String KEY_NATIVE_QCLEAR_SWITCH = "native_qclear_switch";
    private static final String KEY_SOCKET_RECONNECT = "enable_reconnect";
    private static final String KEY_SOCKET_RECONNECT_TIMEOUT = "reconnect_timeout";
    private static final String TAG = "VcControllerImpl";
    public static boolean sIsSpecialDevice;
    private final Object lock1;
    private final Object lock2;
    private final String mAppId;
    private int mCloseReason;
    private int mCloseResult;
    private c mCloseVideoTimeoutCallback;
    private Runnable mCloseVideoTimeoutRunnable;
    public com.tencent.av.core.d mEventListener;
    private final e mJniSimpleInfo;
    private String mMcc;
    private String mMnc;
    private int setAudioInputMuteResult;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements QavABTestHelper.a {
        a() {
        }

        @Override // com.tencent.avcore.util.QavABTestHelper.a
        public QavABTestHelper.b a(String str) {
            QavABTestHelper.b bVar = new QavABTestHelper.b();
            try {
                bVar.f77542a = Long.parseLong(yt.b.c(str));
            } catch (NumberFormatException unused) {
                bVar.f77542a = 0L;
            }
            bVar.f77543b = str;
            bVar.f77544c = yt.b.b(str);
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements QavReporter.a {
        b() {
        }

        @Override // com.tencent.nt.qav.reporter.QavReporter.a
        public void a(String str, String str2, HashMap<String, String> hashMap) {
            QQBeaconReport.reportWithAppKey(str, "", str2, true, hashMap, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void j(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public long f73560a;

        /* renamed from: b, reason: collision with root package name */
        public int f73561b;

        /* renamed from: c, reason: collision with root package name */
        public int f73562c;

        /* renamed from: d, reason: collision with root package name */
        String f73563d;

        public d() {
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" uin : " + this.f73560a + " operation : " + this.f73561b + " opvalue : " + this.f73562c + " nickname : " + this.f73563d);
            return sb5.toString();
        }
    }

    static {
        boolean z16;
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y66") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67A") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67L") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9Plus") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9Plus L") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s L") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s Plus") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s Plus L") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi S2")) {
            z16 = false;
        } else {
            z16 = true;
        }
        sIsSpecialDevice = z16;
    }

    public VcControllerImpl() {
        this.mCloseResult = -1;
        this.mCloseReason = -1;
        this.mCloseVideoTimeoutCallback = null;
        this.mCloseVideoTimeoutRunnable = new Runnable() { // from class: com.tencent.av.core.VcControllerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (VcControllerImpl.this.mCloseResult != 0 && VcControllerImpl.this.mCloseVideoTimeoutCallback != null) {
                    VcControllerImpl.this.mCloseVideoTimeoutCallback.j(VcControllerImpl.this.mCloseReason);
                }
            }
        };
        this.mMcc = PhoneCodeUtils.a();
        this.mMnc = "";
        this.lock1 = new Object();
        this.lock2 = new Object();
        this.setAudioInputMuteResult = -1;
        this.mAppId = null;
        this.mJniSimpleInfo = null;
    }

    private int changeBusyType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "change busy type error : busy type = " + i3);
        }
        return 1;
    }

    private boolean quaReport(String str, int i3, int i16) {
        try {
            SharedPreferences proxy = SharedPreferencesProxyManager.getInstance().getProxy(q.f74193d, 4);
            Map<String, ?> all = proxy.getAll();
            if (all != null && all.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "do qua report : found exception map, size = " + all.size());
                }
                for (String str2 : all.keySet()) {
                    QuaReportInfo quaReportInfo = new QuaReportInfo();
                    quaReportInfo.toObject((String) all.get(str2));
                    if (quaReportInfo.selfUin != null && quaReportInfo.peerUin != null) {
                        NtrtcUtil.getInstance().doQuaReport(Long.valueOf(quaReportInfo.selfUin).longValue(), Long.valueOf(quaReportInfo.peerUin).longValue(), changeBusyType(quaReportInfo.busytype), 0);
                    }
                }
                boolean commit = proxy.edit().clear().commit();
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "do qua report : exception map commitResult = " + commit);
                }
            }
            boolean commit2 = SharedPreferencesProxyManager.getInstance().getProxy(q.f74192c, 4).edit().clear().commit();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "do qua report : common map commitResult = " + commit2);
                return true;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Do qua report error : " + e16);
                return false;
            }
            return false;
        }
    }

    private void setCarrierType(long j3) {
        NtrtcEngine.getInstance().setCarrierType(j3, this.mMcc, this.mMnc);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uin = " + j3 + ", mMcc = " + this.mMcc + ", mMnc = " + this.mMnc);
        }
    }

    public int acceptVideo(String str, long j3, int i3, int i16, int i17, int i18) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            long g16 = i.g(str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "acceptVideo friendUin = " + g16);
            }
            NtrtcEngine.getInstance().setApType(i3);
            int accept = NtrtcSession.getInstance().accept(g16, i16, i17, i18);
            setCarrierType(g16);
            return accept;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int closeVideo(String str, final int i3, c cVar) {
        QLog.d(TAG, 1, "closeVideo reason = " + i3, new Throwable());
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            final long g16 = i.g(str);
            if (com.tencent.av.utils.d.d()) {
                com.tencent.av.utils.d.c().k();
            }
            if (cVar != null && sIsSpecialDevice) {
                this.mCloseResult = -1;
                this.mCloseReason = i3;
                this.mCloseVideoTimeoutCallback = cVar;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.core.VcControllerImpl.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(VcControllerImpl.TAG, 1, "closeVideo start.");
                        VcControllerImpl.this.mCloseResult = NtrtcSession.getInstance().close(g16, i3);
                        ThreadManager.getUIHandler().removeCallbacks(VcControllerImpl.this.mCloseVideoTimeoutRunnable);
                        VcControllerImpl.this.mCloseReason = -1;
                        VcControllerImpl.this.mCloseVideoTimeoutCallback = null;
                        VcControllerImpl.this.mJniSimpleInfo.c(g16);
                        QLog.d(VcControllerImpl.TAG, 1, "closeVideo end. mCloseResult = " + VcControllerImpl.this.mCloseResult);
                        synchronized (VcControllerImpl.this.lock1) {
                            VcControllerImpl.this.lock1.notify();
                        }
                    }
                }, 16, null, false);
                long j3 = 2000;
                ThreadManager.getUIHandler().postDelayed(this.mCloseVideoTimeoutRunnable, j3);
                synchronized (this.lock1) {
                    try {
                        this.lock1.wait(j3);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                QLog.d(TAG, 1, "closeVideo end. continue.");
                return 0;
            }
            int close = NtrtcSession.getInstance().close(g16, i3);
            this.mJniSimpleInfo.c(g16);
            return close;
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e17.getMessage());
            return -1;
        }
    }

    public byte[] createTLVpackage(long j3, String str, byte b16, int i3) {
        byte[] bArr;
        int i16;
        try {
            bArr = str.getBytes("utf-8");
            i16 = bArr.length;
        } catch (Exception unused) {
            bArr = new byte[0];
            i16 = 0;
        }
        byte[] bArr2 = new byte[i16 + 12 + 3 + 6 + 6];
        bArr2[0] = 1;
        bArr2[1] = 1;
        bArr2[2] = 1;
        bArr2[3] = 2;
        bArr2[4] = 1;
        bArr2[5] = 1;
        bArr2[6] = 3;
        bArr2[7] = 8;
        byte[] bArr3 = bArr;
        System.arraycopy(new byte[]{(byte) ((j3 >> 56) & 255), (byte) ((j3 >> 48) & 255), (byte) ((j3 >> 40) & 255), (byte) ((j3 >> 32) & 255), (byte) ((j3 >> 24) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 8) & 255), (byte) (j3 & 255)}, 0, bArr2, 8, 8);
        bArr2[16] = 4;
        bArr2[17] = (byte) i16;
        if (i16 > 0) {
            System.arraycopy(bArr3, 0, bArr2, 18, 8);
        }
        int i17 = 18 + i16;
        bArr2[i17] = 5;
        int i18 = i17 + 1;
        bArr2[i18] = 1;
        int i19 = i18 + 1;
        bArr2[i19] = b16;
        int i26 = i19 + 1;
        bArr2[i26] = 6;
        int i27 = i26 + 1;
        bArr2[i27] = 4;
        System.arraycopy(new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)}, 0, bArr2, i27 + 1, 4);
        return bArr2;
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public boolean enableQClearFromConfig() {
        return af.O();
    }

    protected void finalize() throws Throwable {
        try {
            if (AVSoUtils.A()) {
                NtrtcSession.getInstance().setCallback(null);
                NtrtcRoom.getInstance().setCallback(null);
                NtrtcAudio.getInstance().setCallback(null);
                NtrtcVideo.getInstance().setCallback(null);
                NtrtcEngine.getInstance().uninit();
            }
            NtrtcEngine.destroyInstance();
        } finally {
            super.finalize();
        }
    }

    public long getChatRoomId(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcRoom.getInstance().getChatRoomID(i.g(str));
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1L;
        }
    }

    @Override // com.tencent.avcore.engine.IAVAdapter
    public Context getContext() {
        return BaseApplication.getContext();
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public String getCustomInfo(long j3, String str) {
        String str2 = "";
        try {
            if (KEY_SOCKET_RECONNECT.equals(str)) {
                str2 = String.valueOf(com.tencent.av.ui.funchat.record.e.a().f75884p);
            } else if (KEY_SOCKET_RECONNECT_TIMEOUT.equals(str)) {
                str2 = String.valueOf(com.tencent.av.ui.funchat.record.e.a().f75885q);
            } else if (KEY_IS_SESSION_OFFLINE.equals(str)) {
                com.tencent.av.core.d dVar = this.mEventListener;
                str2 = (dVar == null || dVar.isOfflineSession(String.valueOf(j3)) != 1) ? "false" : "true";
            } else if (KEY_NATIVE_QCLEAR_SWITCH.equals(str)) {
                str2 = "-1";
                if (com.tencent.av.utils.e.e(23) == 1) {
                    str2 = "1";
                } else if (com.tencent.av.utils.e.e(23) == 0) {
                    str2 = "0";
                }
                QLog.d(TAG, 1, "callbackGetCustomInfo KEY_NATIVE_QCLEAR_SWITCH, result = " + str2);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "callbackGetCustomInfo fail.", th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("callbackGetCustomInfo peerUin=%s key=%s result=%s", Long.valueOf(j3), str, str2));
        }
        return str2;
    }

    public e getJniSimpleInfo() {
        return this.mJniSimpleInfo;
    }

    @Override // com.tencent.avcore.engine.IAVAdapter
    public AVNativeEventProcessor getNativeEventProcessor() {
        return null;
    }

    public int getPeerSdkVersion(String str) {
        return this.mJniSimpleInfo.f(str, false, true);
    }

    public int getPeerTerminalType(String str) {
        return this.mJniSimpleInfo.g(str, false, true);
    }

    public long handleAndParseUin(String str) {
        if (TextUtils.isEmpty(str)) {
            AVCoreLog.printErrorLog(TAG, "handleAndParseUin-> uin is " + str);
            return -1L;
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return i.g(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1L;
        }
    }

    public void handleFunChatMsg(long j3, byte[] bArr, String str) {
        int i3 = (int) j3;
        if (i3 != 8) {
            switch (i3) {
                case 1:
                case 3:
                    this.mEventListener.g(i3, new String(bArr));
                    return;
                case 2:
                    this.mEventListener.h(bArr);
                    return;
                case 4:
                    this.mEventListener.d(new String(bArr));
                    return;
                case 5:
                    this.mEventListener.k(new String(bArr));
                    return;
                case 6:
                    this.mEventListener.e(new String(bArr));
                    return;
                default:
                    switch (i3) {
                        case 15:
                            this.mEventListener.f(str, new String(bArr));
                            return;
                        case 16:
                            this.mEventListener.i(str, new String(bArr));
                            return;
                        case 17:
                            this.mEventListener.c(str, new String(bArr));
                            return;
                        default:
                            this.mEventListener.a(str, i3, bArr);
                            return;
                    }
            }
        }
        this.mEventListener.b(str, new String(bArr));
    }

    public int ignoreVideo(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            long g16 = i.g(str);
            NtrtcEngine.getInstance().setApType(i3);
            int ignore = NtrtcSession.getInstance().ignore(g16);
            setCarrierType(g16);
            return ignore;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public void initBeaconReporter() {
        QQBeaconReport.start();
        QavReporter.getInstance().setReport(new b());
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public void initClientLogReport() {
        int i3;
        try {
            i3 = Integer.parseInt(this.mAppId);
        } catch (Throwable unused) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "initClientLogReport, app id invalid [" + this.mAppId + "]");
            }
            i3 = 0;
        }
        ClientLogReport.instance().init(getContext(), i3);
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public void initConfig() {
        ConfigInfo.instance(BaseApplication.getContext());
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public void initTABSDK() {
        QavABTestHelper.getInstance().setABTest(new a());
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public boolean loadLibrary() {
        return AVSoUtils.H();
    }

    public int notifyAnotherSelfIsRing(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcEngine.getInstance().notifyAnotherSelfIsRing(i.g(str), z16);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int pauseVideo(String str) {
        try {
            return NtrtcVideo.getInstance().stopVideoSend();
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public d receiveTransferMsg(byte[] bArr) {
        d unpackTLV = unpackTLV(bArr);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " receiveTransferMsg : tlv = " + unpackTLV.toString());
        }
        return unpackTLV;
    }

    public int rejectVideo(String str, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "rejectVideo --> PeerUin = " + str + " ,apn = " + i3 + " ,rejectReason = " + i16);
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            long g16 = i.g(str);
            NtrtcEngine.getInstance().setApType(i3);
            int reject = NtrtcSession.getInstance().reject(g16, i16);
            setCarrierType(g16);
            return reject;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int requestFromUnQQ(long j3, int i3, int i16, int i17) {
        QLog.e(TAG, 1, "requestFromUnQQ failed. not support.");
        return -1;
    }

    public int requestVideo(String str, long j3, int i3, int i16, int i17, String str2, String str3, String str4, int i18, String str5, String str6, long j16, byte[] bArr, String str7, String str8, String str9, int i19, int i26, String str10, int i27, int i28, String str11) {
        String str12 = TextUtils.isEmpty(str) ? "0" : str;
        String str13 = TextUtils.isEmpty(str5) ? "0" : str5;
        String str14 = TextUtils.isEmpty(str6) ? "0" : str6;
        String str15 = TextUtils.isEmpty(str7) ? "" : str7;
        String str16 = TextUtils.isEmpty(str8) ? "" : str8;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "requestVideo1 funcall buffer:" + str15);
        }
        try {
            long g16 = i.g(str12);
            long parseLong = Long.parseLong(str13);
            long parseLong2 = Long.parseLong(str14);
            NtrtcEngine.getInstance().setApType(i3);
            if (j16 != 0) {
                int requestSwitchTerminal = NtrtcSession.getInstance().requestSwitchTerminal(g16, i16, i17, j16, str11);
                setCarrierType(g16);
                return requestSwitchTerminal;
            }
            if (4 == i17) {
                try {
                    int changeBusyType = changeBusyType(i16);
                    if (parseLong == 0 && parseLong2 == 9 && changeBusyType == 1) {
                        changeBusyType = 5;
                    }
                    quaReport(String.valueOf(g16), changeBusyType, i18);
                    NtrtcSessionParam ntrtcSessionParam = new NtrtcSessionParam();
                    ntrtcSessionParam.base.peerUid = String.valueOf(g16);
                    NtrtcSessionParam.NtrtcSessionBaseParam ntrtcSessionBaseParam = ntrtcSessionParam.base;
                    ntrtcSessionBaseParam.businessType = i16;
                    ntrtcSessionBaseParam.relationType = i17;
                    NtrtcSessionParam.NtrtcSessionExtParam ntrtcSessionExtParam = ntrtcSessionParam.ext;
                    ntrtcSessionExtParam.subServiceType = 29 == i18 ? 1013 : 0;
                    ntrtcSessionExtParam.interestingChatBuf = str15;
                    NtrtcSessionParam.NtrtcTempChatParam ntrtcTempChatParam = ntrtcSessionParam.tempChat;
                    ntrtcTempChatParam.tempChatType = i18;
                    ntrtcTempChatParam.tempId = parseLong;
                    ntrtcTempChatParam.tempUin = parseLong2;
                    ntrtcTempChatParam.sign = bArr;
                    ntrtcTempChatParam.dcReportBuf = str16;
                    int request = NtrtcSession.getInstance().request(ntrtcSessionParam);
                    setCarrierType(request);
                    return request;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    AVCoreLog.printErrorLog(TAG, e16.getMessage());
                    return -1;
                }
            }
            try {
                quaReport(String.valueOf(g16), changeBusyType(i16), 0);
                NtrtcSessionParam ntrtcSessionParam2 = new NtrtcSessionParam();
                ntrtcSessionParam2.base.peerUid = String.valueOf(g16);
                NtrtcSessionParam.NtrtcSessionBaseParam ntrtcSessionBaseParam2 = ntrtcSessionParam2.base;
                ntrtcSessionBaseParam2.businessType = i16;
                ntrtcSessionBaseParam2.relationType = i17;
                ntrtcSessionBaseParam2.inviteScene = i28;
                NtrtcSessionParam.NtrtcSessionExtParam ntrtcSessionExtParam2 = ntrtcSessionParam2.ext;
                ntrtcSessionExtParam2.interestingChatBuf = str15;
                ntrtcSessionExtParam2.traceId = str11;
                int request2 = NtrtcSession.getInstance().request(ntrtcSessionParam2);
                setCarrierType(g16);
                return request2;
            } catch (Exception e17) {
                e17.printStackTrace();
                AVCoreLog.printErrorLog(TAG, e17.getMessage());
                return -1;
            }
        } catch (NumberFormatException e18) {
            e18.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e18.getMessage());
            return -1;
        }
    }

    public int resumeVideo(String str) {
        return NtrtcVideo.getInstance().startVideoSend();
    }

    public int sendAVAvatar2DSwitchRequest(String str, boolean z16, int i3, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendAVAvatar2DSwitchRequest, uin=" + str + ", enable=" + z16 + ", width=" + i3 + ", height=" + i16 + ", materialID=" + str2);
        }
        long handleAndParseUin = handleAndParseUin(str);
        if (handleAndParseUin == -1) {
            return -1;
        }
        return NtrtcRoom.getInstance().sendAVAvatar2DSwitchRequest(handleAndParseUin, z16, i3, i16, str2);
    }

    public int sendAVFunChatMsg(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendAVFunChatMsg, uin=" + str + ", type=" + i3 + ", data=" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcRoom.getInstance().sendAVFunChatMsg(i.g(str), i3, str2.getBytes());
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int sendAvatar2DMsg(String str, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendAvatar2DMsg, uin=" + str + ", data=" + bArr);
        }
        long handleAndParseUin = handleAndParseUin(str);
        if (handleAndParseUin == -1) {
            return -1;
        }
        return NtrtcRoom.getInstance().sendAVAvatar2DMsg(handleAndParseUin, bArr, false);
    }

    public int setAudioInputMute(String str, final boolean z16) {
        this.setAudioInputMuteResult = -1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.core.VcControllerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                int startAudioSend;
                VcControllerImpl vcControllerImpl = VcControllerImpl.this;
                if (z16) {
                    startAudioSend = NtrtcAudio.getInstance().stopAudioSend();
                } else {
                    startAudioSend = NtrtcAudio.getInstance().startAudioSend();
                }
                vcControllerImpl.setAudioInputMuteResult = startAudioSend;
                synchronized (VcControllerImpl.this.lock2) {
                    VcControllerImpl.this.lock2.notify();
                }
            }
        }, 16, null, false);
        synchronized (this.lock2) {
            try {
                this.lock2.wait(200);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        return this.setAudioInputMuteResult;
    }

    public int setAudioOutput(String str, boolean z16) {
        NtrtcAudio ntrtcAudio = NtrtcAudio.getInstance();
        if (z16) {
            return ntrtcAudio.startAudioRecv();
        }
        return ntrtcAudio.stopAudioRecv();
    }

    public int setAudioSpeakerVolume(int i3) {
        return 0;
    }

    public int setGroundGlassSwitch(String str, int i3) {
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcVideo.getInstance().setGroundGlassSwitch(Long.parseLong(str), i3);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, " setGroundGlassSwitch| uin = " + str);
            return -1;
        }
    }

    public int setNativeGatewayTestResult(int i3, int i16, int i17) {
        try {
            return NtrtcEngine.getInstance().setGatewayTestResult(i3, i16, i17);
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public int switchAudio(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcRoom.getInstance().switchAudio(i.g(str));
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "switchAudio", e16);
                return -1;
            }
            return -1;
        }
    }

    public int switchVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcRoom.getInstance().switchVideo(i.g(str));
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "switchVideo", e16);
                return -1;
            }
            return -1;
        }
    }

    public d unpackTLV(byte[] bArr) {
        System.arraycopy(bArr, 8, new byte[8], 0, 8);
        long j3 = ((r2[0] & 255) << 56) | ((r2[1] & 255) << 48) | ((r2[2] & 255) << 40) | ((r2[3] & 255) << 32) | ((r2[4] & 255) << 24) | ((r2[5] & 255) << 16) | ((r2[6] & 255) << 8) | ((255 & r2[7]) << 0);
        int i3 = bArr[17];
        String str = "";
        int i16 = 18;
        if (i3 > 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 18, bArr2, 0, i3);
            try {
                str = new String(bArr2, "utf-8");
            } catch (UnsupportedEncodingException unused) {
            }
            i16 = 18 + i3;
        }
        int i17 = i16 + 2;
        int i18 = bArr[i17];
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, i17 + 1 + 2, bArr3, 0, 4);
        int i19 = (bArr3[3] & 255) | ((bArr3[2] & 255) << 8) | ((bArr3[1] & 255) << 16) | ((bArr3[0] & 255) << 24);
        d dVar = new d();
        dVar.f73560a = j3;
        dVar.f73563d = str;
        dVar.f73561b = i18;
        dVar.f73562c = i19;
        return dVar;
    }

    public void updateForeBackgroundFlag(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            NtrtcEngine.getInstance().updateForeBackgroundFlag(Long.parseLong(str), z16);
        } catch (NumberFormatException unused) {
            QLog.e(TAG, 1, " updateForeBackgroundFlag failed. peerUin: " + str);
        }
    }

    public int updateSelfUin(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return NtrtcEngine.getInstance().setSelfUin(i.g(str));
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(TAG, e16.getMessage());
            return -1;
        }
    }

    public void uploadSharpNode(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str.substring(1);
        }
    }

    @Override // com.tencent.avcore.engine.dav.IDavAdapter
    public boolean useVideoConfigPolicyOfServer() {
        return af.P();
    }

    public int sendAVFunChatMsg(String str, int i3, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                AVCoreLog.printErrorLog(TAG, "uin is " + str);
                return -1;
            }
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = str.substring(1);
            }
            try {
                return NtrtcRoom.getInstance().sendAVFunChatMsg(Long.parseLong(str), i3, bArr);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                QLog.e(TAG, 1, " sendAVFunChatMsg| uin = " + str);
            }
        }
        return -1;
    }

    public VcControllerImpl(Context context, String str, IDavNetChannel iDavNetChannel, com.tencent.av.core.d dVar) {
        this.mCloseResult = -1;
        this.mCloseReason = -1;
        this.mCloseVideoTimeoutCallback = null;
        this.mCloseVideoTimeoutRunnable = new Runnable() { // from class: com.tencent.av.core.VcControllerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (VcControllerImpl.this.mCloseResult != 0 && VcControllerImpl.this.mCloseVideoTimeoutCallback != null) {
                    VcControllerImpl.this.mCloseVideoTimeoutCallback.j(VcControllerImpl.this.mCloseReason);
                }
            }
        };
        this.mMcc = PhoneCodeUtils.a();
        this.mMnc = "";
        this.lock1 = new Object();
        this.lock2 = new Object();
        this.setAudioInputMuteResult = -1;
        m.a();
        this.mJniSimpleInfo = new e(this);
        AVCoreSystemInfo.getCpuInfo();
        this.mAppId = str;
        this.mEventListener = dVar;
        NtrtcEngine.getInstance().initContext(BaseApplication.getContext(), iDavNetChannel, this, this.mEventListener);
        String imsi = QQDeviceInfo.getIMSI("62ad83");
        if (!TextUtils.isEmpty(imsi) && imsi.length() >= 5) {
            this.mMnc = imsi.substring(3, 5);
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "VcControllerImpl, mMnc[" + this.mMnc + "]");
        }
    }

    public void setBackground(boolean z16) {
    }
}
