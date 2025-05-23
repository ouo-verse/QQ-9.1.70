package com.tencent.mobileqq.msfcore;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.msfcore.config.MSFGeneralConfigAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFKernel {
    static IPatchRedirector $redirector_ = null;
    public static final int BUILD_TYPE_CI = 2;
    public static final int BUILD_TYPE_GRAY_VERSION = 1;
    public static final int BUILD_TYPE_PUBLICATION = 0;
    private static volatile MSFKernel INSTANCE = null;
    public static final int IP_TYPE_DUAL = 3;
    public static final int IP_TYPE_IPV4 = 1;
    public static final int IP_TYPE_IPV6 = 2;
    public static final int IP_TYPE_NONE = 0;
    public static final String LIGHT_QUIC_LIB = "LightQuic";
    public static final int MSF_APN_Reachable_WIFI = 2;
    public static final int MSF_APN_Reachable_WWAN = 1;
    public static final int MSF_APN_UNKNOWN = 0;
    public static final int MSF_APN_Unreachable = 3;
    public static final int MSF_BAD_NETWORK_REASON_CONN_TIME_TOO_LONG = 1;
    public static final int MSF_BAD_NETWORK_REASON_HEARTBEAT_PKG_COST_TOO_LONG = 16;
    public static final int MSF_BAD_NETWORK_REASON_NONE = 0;
    public static final int MSF_BAD_NETWORK_REASON_PACKET_BLOCK = 8;
    public static final int MSF_BAD_NETWORK_REASON_PING_TIME_TOO_LONG = 2;
    public static final int MSF_BAD_NETWORK_REASON_RTTS_TOO_LONG = 4;
    public static final int MSF_CONFIG_TYPE_DUAL_ENGINE = 13;
    public static final int MSF_CONFIG_TYPE_GENERAL = 0;
    public static final int MSF_CONFIG_TYPE_MODIFY_SWITCH = 8;
    public static final int MSF_CONFIG_TYPE_MULTI_TCP = 4;
    public static final int MSF_CONFIG_TYPE_NETWORK_CONFIGURE = 9;
    public static final int MSF_CONFIG_TYPE_PACKAGE_COMBINE = 1;
    public static final int MSF_CONFIG_TYPE_PKG_COMPRESS = 7;
    public static final int MSF_CONFIG_TYPE_PKG_STATISTICS = 6;
    public static final int MSF_CONFIG_TYPE_QUIC_ENGINE = 10;
    public static final int MSF_CONFIG_TYPE_SIDEWAY_HTTP = 2;
    public static final int MSF_CONFIG_TYPE_SIDEWAY_UDP = 3;
    public static final int MSF_CONFIG_TYPE_SSID = 11;
    public static final int MSF_CONFIG_TYPE_TCP_ENGINE = 5;
    public static final int MSF_CONFIG_TYPE_TRACE = 12;
    public static final int MSF_CONN_MODE_DUAL = 6;
    public static final int MSF_CONN_MODE_HTTP = 2;
    public static final int MSF_CONN_MODE_HYBRID = 5;
    public static final int MSF_CONN_MODE_QUIC = 4;
    public static final int MSF_CONN_MODE_SIDEWAY_HTTP = 3;
    public static final int MSF_CONN_MODE_TCP = 1;
    public static final int MSF_CONN_MODE_UNKNOWN = 0;
    public static final int MSF_CONN_TYPE_HTTP_LONG = 3;
    public static final int MSF_CONN_TYPE_HTTP_SHORT = 4;
    public static final int MSF_CONN_TYPE_MULTI_TCP = 2;
    public static final int MSF_CONN_TYPE_QUIC = 5;
    public static final int MSF_CONN_TYPE_TCP_LONG = 1;
    public static final int MSF_CONN_TYPE_UDP = 6;
    public static final int MSF_CONN_TYPE_UNKNOWN = 0;
    public static final int MSF_ERROR_ILLEGAL_APP = 1;
    public static final int MSF_ERROR_NOT_GRAY_USER = 2;
    public static final String MSF_KERNEL_LIB = "MSFKernel";
    public static final int MSF_LOG_LEVEL_ALL = 9;
    public static final int MSF_LOG_LEVEL_DEBUG = 6;
    public static final int MSF_LOG_LEVEL_ERROR = 2;
    public static final int MSF_LOG_LEVEL_EVENT = 1;
    public static final int MSF_LOG_LEVEL_INFO = 5;
    public static final int MSF_LOG_LEVEL_METHOD = 8;
    public static final int MSF_LOG_LEVEL_NOTICE = 4;
    public static final int MSF_LOG_LEVEL_OFF = 0;
    public static final int MSF_LOG_LEVEL_TRACE = 7;
    public static final int MSF_LOG_LEVEL_WARN = 3;
    public static final int MSF_PACKET_FAIL = 4;
    public static final int MSF_PACKET_FAIL_FLOW_SAVE_FILTERED = 9;
    public static final int MSF_PACKET_FAIL_LOGIC_ERROR = 11;
    public static final int MSF_PACKET_FAIL_NO_AUTH_ON_REQ = 3;
    public static final int MSF_PACKET_FAIL_NO_NET_ON_REQ = 1;
    public static final int MSF_PACKET_FAIL_NO_NET_ON_RESP = 2;
    public static final int MSF_PACKET_FAIL_NO_RESEND_ON_REQ = 7;
    public static final int MSF_PACKET_FAIL_NO_RESEND_ON_RESP = 8;
    public static final int MSF_PACKET_FAIL_OVER_LOAD_ON_REQ = 10;
    public static final int MSF_PACKET_FAIL_SSO_ERROR = 4;
    public static final int MSF_PACKET_FAIL_TIMEOUT_ON_REQ = 5;
    public static final int MSF_PACKET_FAIL_TIMEOUT_ON_RESP = 6;
    public static final int MSF_PACKET_FAIL_UNKNOWN = 0;
    public static final int MSF_PACKET_RECEIVE_WAY_HTTP = 2;
    public static final int MSF_PACKET_RECEIVE_WAY_MULTI_PATH = 4;
    public static final int MSF_PACKET_RECEIVE_WAY_ONE_SECOND_HTTP = 5;
    public static final int MSF_PACKET_RECEIVE_WAY_ONE_SECOND_UDP = 8;
    public static final int MSF_PACKET_RECEIVE_WAY_SIDE_WAY_HTTP = 3;
    public static final int MSF_PACKET_RECEIVE_WAY_SIDE_WAY_HTTP_UNIQUE = 6;
    public static final int MSF_PACKET_RECEIVE_WAY_SIDE_WAY_QUIC_FOR_HTTP = 7;
    public static final int MSF_PACKET_RECEIVE_WAY_SIDE_WAY_TCP = 10;
    public static final int MSF_PACKET_RECEIVE_WAY_TCP = 1;
    public static final int MSF_PACKET_RECEIVE_WAY_UDP = 9;
    public static final int MSF_PACKET_RECEIVE_WAY_UNKNOWN = 0;
    public static final int MSF_PACKET_RECV_WAY_HTTP = 2;
    public static final int MSF_PACKET_RECV_WAY_MULTI_PATH = 4;
    public static final int MSF_PACKET_RECV_WAY_ONE_SECOND_HTTP = 5;
    public static final int MSF_PACKET_RECV_WAY_ONE_SECOND_UDP = 8;
    public static final int MSF_PACKET_RECV_WAY_QUIC = 11;
    public static final int MSF_PACKET_RECV_WAY_SIDE_WAY_HTTP = 3;
    public static final int MSF_PACKET_RECV_WAY_SIDE_WAY_HTTP_UNIQUE = 6;
    public static final int MSF_PACKET_RECV_WAY_SIDE_WAY_QUIC = 12;
    public static final int MSF_PACKET_RECV_WAY_SIDE_WAY_QUIC_FOR_HTTP = 7;
    public static final int MSF_PACKET_RECV_WAY_SIDE_WAY_TCP = 10;
    public static final int MSF_PACKET_RECV_WAY_TCP = 1;
    public static final int MSF_PACKET_RECV_WAY_UDP = 9;
    public static final int MSF_PACKET_RECV_WAY_UNKNOWN = 0;
    public static final int MSF_PACKET_SEND_OK = 2;
    public static final int MSF_PACKET_SUCCESS = 3;
    public static final int MSF_PACKET_TCP_SEND_SUCCESS = 5;
    public static final int MSF_PACKET_TO_SEND = 1;
    public static final int MSF_PACKET_UNKNOWN = 0;
    public static final int MSF_SEND_PACKET_TYPE_AFTER_LOGOUT = 3;
    public static final int MSF_SEND_PACKET_TYPE_AFTER_LOGOUT_END = 4;
    public static final int MSF_SEND_PACKET_TYPE_NORMAL = 1;
    public static final int MSF_SEND_PACKET_TYPE_UNKNOWN = 0;
    public static final int MSF_SEND_PACKET_TYPE_WITH_UIN = 2;
    public static final int MSF_SEND_PRIORITY_HIGH = 100;
    public static final int MSF_SEND_PRIORITY_LOW = 50;
    public static final int MSF_SEND_PRIORITY_MEDIUM = 75;
    public static final int MSF_SEND_PRIORITY_MIN = 0;
    public static final int MSF_SEND_WITHOUT_COMBINE = 8;
    public static final int MSF_SEND_WITHOUT_RESEND = 2;
    public static final int MSF_SEND_WITHOUT_SIDE_WAY = 16;
    public static final int MSF_SEND_WITH_ABORT_WHEN_NO_NET = 4;
    public static final int MSF_SEND_WITH_ANSWER = 1;
    public static final int MSF_SEND_WITH_FORCE_SEC_SING = 32;
    public static final int MSF_SEND_WITH_NONE = 0;
    public static final int MSF_SEND_WITH_UID_CHECK = 64;
    public static final int MSF_SIDE_WAY_MODE_ALL = 1;
    public static final int MSF_SIDE_WAY_MODE_DEFAULT = 2;
    public static final int MSF_TCP_ENGINE_CONN_MODE_HYBRID = 3;
    public static final int MSF_TCP_ENGINE_CONN_MODE_PARALLEL = 2;
    public static final int MSF_TCP_ENGINE_CONN_MODE_SERIAL = 1;
    public static final int MSF_UIN_TYPE_MAIL = 1;
    public static final int MSF_UIN_TYPE_QQ = 0;
    public static final int MSF_WHITE_LIST_TYPE_MULTI_TCP = 4;
    public static final int MSF_WHITE_LIST_TYPE_PACKAGE_COMBINE = 16;
    public static final int MSF_WHITE_LIST_TYPE_REGISTER_PROXY = 32;
    public static final int MSF_WHITE_LIST_TYPE_SEC_SIG = 8;
    public static final int MSF_WHITE_LIST_TYPE_SIDE_WAY_HTTP = 1;
    public static final int MSF_WHITE_LIST_TYPE_SIDE_WAY_UDP = 2;
    public static final int NETWORK_CONNECT_FAIL = 4;
    public static final int NETWORK_CONNECT_SUCCESS = 3;
    public static final int NETWORK_CONNECT_TOO_FREQUENT = 1;
    public static final int NETWORK_DETECTOR_SHOW_NET_ERROR = 8;
    public static final int NETWORK_DETECTOR_SHOW_NET_UNREACHABLE = 9;
    public static final int NETWORK_DETECTOR_SHOW_NET_WEB_AUTH = 7;
    public static final int NETWORK_DISCONNECT = 5;
    public static final int NETWORK_RECV_PING = 10;
    public static final int NETWORK_SHOW_NET_ERROR = 6;
    public static final int NETWORK_STATUS_NOT_REACHABLE = 0;
    public static final int NETWORK_STATUS_VIA_WAN = 2;
    public static final int NETWORK_STATUS_VIA_WIFI = 1;
    public static final int NETWORK_TO_CONNECT = 2;
    public static final int NETWORK_UNKNOWN = 0;
    public static final int SSO_SEC_SIG_ALL = 1;
    public static final int SSO_SEC_SIG_NONE = 0;
    public static final int SSO_SEC_SIG_SOME = 2;
    public static final String TAG = "MSFKernel";
    private static final AtomicBoolean hasInit;
    private static boolean isLightQuicLoad;
    private static boolean isLoaded;
    private MSFKernelBridge bridge;
    private MSFConfigBridge msfConfigBridge;
    private final UpperBridgesImpl upperBridges;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        hasInit = new AtomicBoolean(false);
        isLoaded = false;
        isLightQuicLoad = false;
    }

    MSFKernel(UpperBridgesImpl upperBridgesImpl, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, upperBridgesImpl, Boolean.valueOf(z16));
            return;
        }
        this.bridge = null;
        MSFKernelLogger.setLogger(upperBridgesImpl.getLogger());
        SoLoader.setLoader(upperBridgesImpl.getSoLoader());
        this.upperBridges = upperBridgesImpl;
        try {
            isLightQuicLoad = SoLoader.load(LIGHT_QUIC_LIB);
        } catch (UnsatisfiedLinkError e16) {
            MSFKernelLogger.e("MSFKernel", "MSFKernel Load lightQuic error", e16);
            SoLoader.reportLoadSoError(LIGHT_QUIC_LIB, isLightQuicLoad, e16.getMessage());
        }
        try {
            isLoaded = SoLoader.load("MSFKernel");
            MSFKernelBridge a16 = a.a(upperBridgesImpl, z16);
            this.bridge = a16;
            if (a16 != null) {
                this.msfConfigBridge = a16.getMSFConfigBridge();
            }
        } catch (UnsatisfiedLinkError e17) {
            MSFKernelLogger.e("MSFKernel", "MSFKernel create bridge error", e17);
            SoLoader.reportLoadSoError("MSFKernel", isLoaded, e17.getMessage());
        }
    }

    @NonNull
    public static MSFKernel getInstance(UpperBridgesImpl upperBridgesImpl, boolean z16) {
        if (INSTANCE == null) {
            synchronized (MSFKernel.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MSFKernel(upperBridgesImpl, z16);
                }
            }
        }
        return INSTANCE;
    }

    @Nullable
    public static MSFKernel getOrNull() {
        return INSTANCE;
    }

    public void clearHistorySigns() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "clearHistorySigs with not init");
        } else {
            this.bridge.clearHistorySigns();
        }
    }

    public void clearSign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "clearSign with not init");
        } else {
            this.bridge.clearSign(str);
        }
    }

    public void connect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "connect with not init");
        } else {
            this.bridge.connect();
        }
    }

    public int connectState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "connectState with not init");
            return 0;
        }
        return this.bridge.getConnectState();
    }

    public int currentConnType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "currentConnType with not init");
            return -1;
        }
        return this.bridge.currentConnType();
    }

    public long currentRtt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Long) iPatchRedirector.redirect((short) 36, (Object) this)).longValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "currentRtt with not init");
            return -1L;
        }
        return this.bridge.currentRtt();
    }

    public String currentSSOAddr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "currentSSOAddr with not init");
            return "";
        }
        return this.bridge.currentSSOAddr();
    }

    public String currentSSOIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "currentSSOIP with not init");
            return "";
        }
        return this.bridge.currentSSOIP();
    }

    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "disconnect with not init");
        } else {
            this.bridge.disconnect();
        }
    }

    public int getApnState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getApnState with not init");
            return 0;
        }
        return this.bridge.getApnState();
    }

    public String getClientIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getClientIP with not init");
            return "";
        }
        return this.bridge.getClientIP();
    }

    public long getConnSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getConnSeq with not init");
            return -1L;
        }
        return this.bridge.getConnSeq();
    }

    public int getCurrentUsedIPType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getCurrentUsedIPType with not init");
            return 0;
        }
        return this.bridge.getCurrentUsedIPType();
    }

    public int getIPStackType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getIPStackType with not init");
            return 0;
        }
        return this.bridge.getIPStackType();
    }

    public int getNextPacketSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getNextPacketSeq with not init");
            return -1;
        }
        return this.bridge.getNextPacketSeq();
    }

    public int getServerTimeDiff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "getServerTimeDiff with not init");
            return 0;
        }
        return this.bridge.getServerTimeDiff();
    }

    public void init(Context context, IAppInfoProvider iAppInfoProvider, IMSFCallbackBridge iMSFCallbackBridge) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iAppInfoProvider, iMSFCallbackBridge);
            return;
        }
        if (hasInit.compareAndSet(false, true)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                MSFGeneralConfig build = new MSFGeneralConfigAdapter.Builder().buildType(iAppInfoProvider.getBuildType()).secSigType(2).sandBoxPath(iAppInfoProvider.getSandBoxPath()).appIdentifier(iAppInfoProvider.getAppIdentifier()).appVersion(iAppInfoProvider.getAppVersion()).sysVersion(iAppInfoProvider.getSystemVersion()).build();
                this.bridge.initMSFCore(iAppInfoProvider.getAppid(), iAppInfoProvider.getQua(), iAppInfoProvider.getImei(), build);
                this.bridge.setQimei36(iAppInfoProvider.getQimei36());
                MSFKernelLogger.d("MSFKernel", "init MSFCore with appInfo{buildType: " + build.getBuildType() + ", sandBoxPath: " + build.getSandBoxPath() + ", appIdentifier: " + build.getAppIdentifier() + ", appVersion: " + build.getAppVersion() + ", sysVersion: " + build.getSysVersion() + ", qimei: " + iAppInfoProvider.getQimei36() + ", isLoadedSo: " + isLoaded + ", costTime: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e16) {
                MSFKernelLogger.e("MSFKernel", "MSFCore init error, ", e16);
            }
        }
    }

    public boolean isBadNetwork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "isBadNetwork with not init");
            return false;
        }
        return this.bridge.isBadNetwork();
    }

    public boolean isConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "isConnected with not init");
            return false;
        }
        return this.bridge.isConnected();
    }

    public boolean isConnecting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "isConnecting with not init");
            return false;
        }
        return this.bridge.isConnecting();
    }

    public boolean isPullIpOver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "isPullIpOver with not init");
            return false;
        }
        return this.bridge.isPullIpOver();
    }

    public void notifyLoginSuccess(String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), str2, bArr, bArr2, bArr3);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "notifyLoginSuccess with not init");
        } else {
            this.bridge.notifyLoginSuccess(str, i3, str2, bArr, bArr2, bArr3);
        }
    }

    public void notifyLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "notifyLogout with not init");
        } else {
            this.bridge.notifyLogout();
        }
    }

    public void notifyNetworkInfo(int i3, int i16, MSFExternNetworkInfo mSFExternNetworkInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), mSFExternNetworkInfo);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "notifyNetworkInfo with not init");
        } else {
            this.bridge.notifyNetworkInfo(i3, i16, mSFExternNetworkInfo);
        }
    }

    public void notifyRefreshSign(String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), str2, bArr, bArr2, bArr3);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "notifyRefreshSign with not init");
        } else {
            this.bridge.notifyRefreshSign(str, i3, str2, bArr, bArr2, bArr3);
        }
    }

    public void onAppBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "onAppBackground with not init");
        } else {
            this.bridge.appDidEnterBackground();
        }
    }

    public void onAppForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "onAppForeground with not init");
        } else {
            this.bridge.appWillEnterForeground();
        }
    }

    public long recvQueueSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Long) iPatchRedirector.redirect((short) 38, (Object) this)).longValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "recvQueueSize with not init");
            return -1L;
        }
        return this.bridge.recvQueueSize();
    }

    public void sendMSFPingCheck(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "sendMSFPingCheck with not init");
        } else {
            this.bridge.sendMSFPingCheck(i3);
        }
    }

    public int sendPacket(MSFRequestAdapter mSFRequestAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) mSFRequestAdapter)).intValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "sendPacket with not init");
            return -1;
        }
        return this.bridge.sendPacket(mSFRequestAdapter);
    }

    public long sendQueueSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Long) iPatchRedirector.redirect((short) 37, (Object) this)).longValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "sendQueueSize with not init");
            return -1L;
        }
        return this.bridge.sendQueueSize();
    }

    public boolean setCertificateData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str)).booleanValue();
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setCertificateData with not init");
            return false;
        }
        return this.bridge.setCertificateData(str);
    }

    public void setLogLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setLogLevel with not init");
            return;
        }
        this.bridge.setLogLevel(i3);
        if (isLightQuicLoad) {
            this.bridge.setLightQuicLogListener(i3);
        }
    }

    public void setMSFConfig(int i3, MSFConfig mSFConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) mSFConfig);
            return;
        }
        if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setMSFConfig with not init");
            return;
        }
        if (this.msfConfigBridge == null) {
            MSFKernelLogger.e("MSFKernel", "setMSFConfig with msfConfigBridge null");
        }
        switch (i3) {
            case 0:
                this.msfConfigBridge.setMSFGeneralConfig((MSFGeneralConfig) mSFConfig);
                return;
            case 1:
                this.msfConfigBridge.setMSFPacketCombineConfig((MSFPacketCombineConfig) mSFConfig);
                return;
            case 2:
                this.msfConfigBridge.setMSFSideWayHttpConfig((MSFSideWayHttpConfig) mSFConfig);
                return;
            case 3:
                this.msfConfigBridge.setMSFSideWayUdpConfig((MSFSideWayUdpConfig) mSFConfig);
                return;
            case 4:
                this.msfConfigBridge.setMSFMultiTcpConfig((MSFMultiTcpConfig) mSFConfig);
                return;
            case 5:
                this.msfConfigBridge.setMSFTcpEngineConfig((MSFTcpEngineConfig) mSFConfig);
                return;
            case 6:
                this.msfConfigBridge.setMSFPkgStatisticsConfig((MSFPkgStatisticsConfig) mSFConfig);
                return;
            case 7:
                this.msfConfigBridge.setMSFPkgCompressConfig((MSFPkgCompressConfig) mSFConfig);
                return;
            case 8:
                this.msfConfigBridge.setMSFCoreModifyConfig((MSFModifyConfig) mSFConfig);
                return;
            case 9:
                MSFNetworkConfig mSFNetworkConfig = (MSFNetworkConfig) mSFConfig;
                int i16 = mSFNetworkConfig.mNetworkConnMode;
                if ((i16 == 4 || i16 == 5) && !isLightQuicLoad) {
                    mSFNetworkConfig.setNetworkConnMode(1);
                    MSFKernelLogger.d("MSFKernel", "LightQuic load fail, revert to Tcp from quic");
                }
                this.msfConfigBridge.setMSFNetworkConfig(mSFNetworkConfig);
                return;
            case 10:
                this.msfConfigBridge.setMSFQuicEngineConfig((MSFQuicEngineConfig) mSFConfig);
                return;
            case 11:
                this.msfConfigBridge.setMSFSSIDConfig((MSFSSIDConfig) mSFConfig);
                return;
            case 12:
            default:
                return;
            case 13:
                this.msfConfigBridge.setMSFDualEngineConfig((MSFDualEngineConfig) mSFConfig);
                return;
        }
    }

    public void setMSFReportSampleRate(HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) hashMap);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setMSFReportSampleRate with not init");
        } else {
            this.bridge.setMSFReportSampleRate(hashMap);
        }
    }

    public void setMSFWhiteList(int i3, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) arrayList);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setMSFWhiteList with not init");
        } else {
            this.bridge.setMSFWhiteList(i3, arrayList);
        }
    }

    public void setQimei36(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setQimei36 with not init");
        } else {
            this.bridge.setQimei36(str);
        }
    }

    public void setSSOTestEnv(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), str2);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "setSSOTestEnv with not init");
        } else {
            this.bridge.setSSOTestEnv(str, i3, str2);
        }
    }

    public void updateSidewayNetId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        } else if (!hasInit.get()) {
            MSFKernelLogger.d("MSFKernel", "updateSidewayNetId with not init");
        } else {
            this.bridge.updateSidewayNetId(j3);
        }
    }
}
