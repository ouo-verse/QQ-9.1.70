package com.tencent.mobileqq.msf.core.quic;

import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QuicWrapper {
    static IPatchRedirector $redirector_ = null;
    private static String DEFAULT_QUIC_FLL_PATH = null;
    private static final int QLOG_ERROR = 2;
    private static final int QLOG_FATAL = 3;
    private static final int QLOG_INFO = 0;
    private static final int QLOG_VERBOSE = -1;
    private static final int QLOG_WARNING = 1;
    private static final String QUIC_RES_CONFIG_SP = "quic_res_config";
    private static final String QUIC_RES_LOAD_PATH = "quic_res_load_path";
    private static final String QUIC_RES_QUIC_LIB = "libquic.so";
    private static final String QUIC_RES_SATURN_LIB = "libsaturn.so";
    private static final String QUIC_RES_VERSION = "quic_res_version";
    private static final String QUIC_SO_LIB_PATH = "/app_lib/quic/";
    public static boolean isLoaded = false;
    private static final String tag = "QuicWrapper";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class QuicBundle {
        static IPatchRedirector $redirector_;
        public byte[] data;
        public int data_len;
        public int retcode;

        public QuicBundle(int i3, byte[] bArr, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16));
                return;
            }
            this.retcode = i3;
            this.data = bArr;
            this.data_len = i16;
        }

        public void putData(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            } else {
                this.data = bArr;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17618);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public QuicWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void closeConn(long j3);

    public static native int connect(long j3, String str, int i3, int i16);

    public static native synchronized long createQuicContext(b bVar);

    public static native long createSyncClient(long j3, boolean z16, boolean z17);

    public static String getQuicResLoadPath() {
        return MsfService.getCore().getSharedPreferences(QUIC_RES_CONFIG_SP, 4).getString(QUIC_RES_LOAD_PATH, DEFAULT_QUIC_FLL_PATH);
    }

    public static int getQuicResVersion() {
        return MsfService.getCore().getSharedPreferences(QUIC_RES_CONFIG_SP, 4).getInt(QUIC_RES_VERSION, 0);
    }

    public static native synchronized boolean initialize(long j3);

    public static native QuicBundle recv(long j3, int i3, int i16);

    public static native synchronized void releaseQuicContext(long j3);

    public static native void releaseSyncClient(long j3, long j16);

    public static boolean reload() {
        int i3;
        if (!isLoaded) {
            DEFAULT_QUIC_FLL_PATH = Environment.getDataDirectory() + "/data/" + BaseApplication.getContext().getPackageName() + QUIC_SO_LIB_PATH;
            String quicResLoadPath = getQuicResLoadPath();
            if (TextUtils.isEmpty(quicResLoadPath)) {
                quicResLoadPath = DEFAULT_QUIC_FLL_PATH;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean loadLibrary = StringUtils.loadLibrary(tag, BaseApplication.getContext(), quicResLoadPath + QUIC_RES_SATURN_LIB, null);
            isLoaded = StringUtils.loadLibrary(tag, BaseApplication.getContext(), quicResLoadPath + QUIC_RES_QUIC_LIB, null);
            QLog.i(tag, 1, "load quic library " + quicResLoadPath + " loadSaturn=" + loadLibrary + " loadQuic=" + isLoaded + " cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            if (isLoaded) {
                if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
                setLogLevel(i3, true ^ BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion());
            }
        }
        return isLoaded;
    }

    public static native int send(long j3, byte[] bArr, int i3, int i16);

    public static native synchronized void setLogLevel(int i3, boolean z16);
}
