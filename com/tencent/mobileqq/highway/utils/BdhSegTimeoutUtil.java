package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.segment.RequestDataTrans;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BdhSegTimeoutUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int DYN_TIMEOUT_ENABLE = 1;
    public static final int DYN_TIMEOUT_UNABLE = 0;
    public static final long HEARTBREAK_TIMEOUT_DEFAULT = 10000;
    public static final long MAX_TIMEOUT_DEFAULT = 90000;
    private static final long TBASE_2G_DEFAULT = 8000;
    private static final long TBASE_3G_DEFAULT = 8000;
    private static final long TBASE_4G_DEFAULT = 3000;
    private static final long TBASE_WIFI_DEFAULT = 3000;
    public static final long[] TIME_OUT_DELTA;
    private static final long TORG_2G_DEFAULT = 15000;
    private static final long TORG_3G_DEFAULT = 15000;
    private static final long TORG_4G_DEFAULT = 5000;
    private static final long TORG_WIFI_DEFAULT = 5000;
    public static int sEnableDynTimeout;
    private static long sHbTimeoutDef;
    private static long sHbTimeout_2G;
    private static long sHbTimeout_3G;
    private static long sHbTimeout_4G;
    private static long sHbTimeout_wifi;
    private static long sMaxTimeoutDef;
    private static long sMaxTimeout_2G;
    private static long sMaxTimeout_3G;
    private static long sMaxTimeout_4G;
    private static long sMaxTimeout_wifi;
    private static long sTbase_2G;
    private static long sTbase_3G;
    private static long sTbase_4G;
    private static long sTbase_wifi;
    private static long sTorg_2G;
    private static long sTorg_3G;
    private static long sTorg_4G;
    private static long sTorg_wifi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sTbase_2G = 8000L;
        sTbase_3G = 8000L;
        sTbase_4G = 3000L;
        sTbase_wifi = 3000L;
        sTorg_2G = 15000L;
        sTorg_3G = 15000L;
        sTorg_4G = 5000L;
        sTorg_wifi = 5000L;
        sMaxTimeoutDef = 90000L;
        sMaxTimeout_2G = 90000L;
        sMaxTimeout_3G = 90000L;
        sMaxTimeout_4G = 90000L;
        sMaxTimeout_wifi = 90000L;
        sHbTimeoutDef = 10000L;
        sHbTimeout_2G = 10000L;
        sHbTimeout_3G = 10000L;
        sHbTimeout_4G = 10000L;
        sHbTimeout_wifi = 10000L;
        sEnableDynTimeout = 0;
        TIME_OUT_DELTA = new long[]{0, 4000, MiniGamePAHippyBaseFragment.LOAD_HIPPY_TIME_OUT, PeakConstants.SHORT_VIDEO_DURATION_UPPER_BOUND, s.G, 36000, 49000, 64000, 81000};
    }

    public BdhSegTimeoutUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:11:0x001d, B:13:0x002d, B:15:0x004e, B:17:0x0057, B:20:0x005d, B:22:0x0061, B:25:0x0067, B:27:0x0091, B:39:0x0087, B:43:0x0035, B:46:0x003f, B:48:0x0048), top: B:10:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:11:0x001d, B:13:0x002d, B:15:0x004e, B:17:0x0057, B:20:0x005d, B:22:0x0061, B:25:0x0067, B:27:0x0091, B:39:0x0087, B:43:0x0035, B:46:0x003f, B:48:0x0048), top: B:10:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized long calculateTimeout(Context context, RequestDataTrans requestDataTrans, long j3, int i3, long j16) {
        long j17;
        int i16;
        long[] jArr;
        long j18;
        long j19;
        long j26;
        long j27;
        long j28;
        long j29;
        synchronized (BdhSegTimeoutUtil.class) {
            if (context != null && requestDataTrans != null && j3 > 0 && i3 >= 0 && j16 >= 0) {
                long j36 = sTbase_2G;
                long j37 = sTorg_2G;
                long j38 = sMaxTimeoutDef;
                int systemNetwork = HwNetworkUtil.getSystemNetwork(context);
                if (2 == systemNetwork) {
                    j38 = sMaxTimeout_2G;
                } else {
                    if (3 == systemNetwork) {
                        j17 = sTbase_3G;
                        j37 = sTorg_3G;
                        j38 = sMaxTimeout_3G;
                    } else if (4 == systemNetwork) {
                        j17 = sTbase_4G;
                        j37 = sTorg_4G;
                        j38 = sMaxTimeout_4G;
                    } else if (1 == systemNetwork) {
                        j17 = sTbase_wifi;
                        j37 = sTorg_wifi;
                        j38 = sMaxTimeout_wifi;
                    }
                    i16 = requestDataTrans.timeOutCount;
                    jArr = TIME_OUT_DELTA;
                    j18 = j38;
                    if (i16 >= jArr.length) {
                        i16 = jArr.length - 1;
                    }
                    int i17 = 0;
                    if (j16 <= 0) {
                        DataTransInfo dataTransInfo = requestDataTrans.mInfo;
                        if (dataTransInfo != null && (i17 = dataTransInfo.length) > 0 && i16 >= 0) {
                            j19 = j37;
                            j29 = jArr[i16] + j17 + j3 + ((long) ((i17 / i3) * j16));
                        } else {
                            j19 = j37;
                            j29 = -1;
                        }
                        j26 = j3;
                        j27 = j29;
                    } else {
                        j19 = j37;
                        j26 = j3;
                        if (i16 >= 0) {
                            j27 = jArr[i16] + j17 + j26 + j19;
                        } else {
                            j27 = -1;
                        }
                    }
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "BdhSegTimeoutUtil.calculateTimeout:  req.hwSeq = " + requestDataTrans.getHwSeq() + " tBase = " + j17 + " tOrg = " + j19 + " tMaxTimeout = " + j18 + " rtt = " + j26 + " lastSegSize = " + i3 + " lastTimeCost = " + j16 + " segSize = " + i17 + " timeoutCount = " + i16 + " timeout = " + j27);
                    if (j27 <= j18) {
                        j28 = j18;
                    } else {
                        j28 = j27;
                    }
                    return j28;
                }
                j17 = j36;
                i16 = requestDataTrans.timeOutCount;
                jArr = TIME_OUT_DELTA;
                j18 = j38;
                if (i16 >= jArr.length) {
                }
                int i172 = 0;
                if (j16 <= 0) {
                }
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "BdhSegTimeoutUtil.calculateTimeout:  req.hwSeq = " + requestDataTrans.getHwSeq() + " tBase = " + j17 + " tOrg = " + j19 + " tMaxTimeout = " + j18 + " rtt = " + j26 + " lastSegSize = " + i3 + " lastTimeCost = " + j16 + " segSize = " + i172 + " timeoutCount = " + i16 + " timeout = " + j27);
                if (j27 <= j18) {
                }
                return j28;
            }
            return -1L;
        }
    }

    public static synchronized long getUrgentHbTimeout(Context context) {
        synchronized (BdhSegTimeoutUtil.class) {
            long j3 = sHbTimeoutDef;
            if (context == null) {
                return j3;
            }
            int systemNetwork = HwNetworkUtil.getSystemNetwork(context);
            if (2 == systemNetwork) {
                j3 = sHbTimeout_2G;
            } else if (3 == systemNetwork) {
                j3 = sHbTimeout_3G;
            } else if (4 == systemNetwork) {
                j3 = sHbTimeout_3G;
            } else if (1 == systemNetwork) {
                j3 = sHbTimeout_wifi;
            }
            return j3;
        }
    }

    public static synchronized void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf dynTimeOutConf) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        synchronized (BdhSegTimeoutUtil.class) {
            if (dynTimeOutConf == null) {
                return;
            }
            if (dynTimeOutConf.uint32_tbase_2g.has() && (i57 = dynTimeOutConf.uint32_tbase_2g.get()) >= 1 && i57 <= 100) {
                sTbase_2G = Long.valueOf(i57).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_tbase_3g.has() && (i56 = dynTimeOutConf.uint32_tbase_3g.get()) >= 1 && i56 <= 100) {
                sTbase_3G = Long.valueOf(i56).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_tbase_4g.has() && (i49 = dynTimeOutConf.uint32_tbase_4g.get()) >= 1 && i49 <= 100) {
                sTbase_4G = Long.valueOf(i49).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_tbase_wifi.has() && (i48 = dynTimeOutConf.uint32_tbase_wifi.get()) >= 1 && i48 <= 100) {
                sTbase_wifi = Long.valueOf(i48).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_torg_2g.has() && (i47 = dynTimeOutConf.uint32_torg_2g.get()) >= 1 && i47 <= 100) {
                sTorg_2G = Long.valueOf(i47).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_torg_3g.has() && (i46 = dynTimeOutConf.uint32_torg_3g.get()) >= 1 && i46 <= 100) {
                sTorg_3G = Long.valueOf(i46).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_torg_4g.has() && (i39 = dynTimeOutConf.uint32_torg_4g.get()) >= 1 && i39 <= 100) {
                sTorg_4G = Long.valueOf(i39).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_torg_wifi.has() && (i38 = dynTimeOutConf.uint32_torg_wifi.get()) >= 1 && i38 <= 100) {
                sTorg_wifi = Long.valueOf(i38).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_max_timeout.has() && (i37 = dynTimeOutConf.uint32_max_timeout.get()) >= 10 && i37 <= 1000) {
                sMaxTimeoutDef = Long.valueOf(i37).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_max_timeout_2g.has() && (i36 = dynTimeOutConf.uint32_max_timeout_2g.get()) >= 10 && i36 <= 1000) {
                sMaxTimeout_2G = Long.valueOf(i36).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_max_timeout_3g.has() && (i29 = dynTimeOutConf.uint32_max_timeout_3g.get()) >= 10 && i29 <= 1000) {
                sMaxTimeout_3G = Long.valueOf(i29).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_max_timeout_4g.has() && (i28 = dynTimeOutConf.uint32_max_timeout_4g.get()) >= 10 && i28 <= 1000) {
                sMaxTimeout_4G = Long.valueOf(i28).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_max_timeout_wifi.has() && (i27 = dynTimeOutConf.uint32_max_timeout_wifi.get()) >= 10 && i27 <= 1000) {
                sMaxTimeout_wifi = Long.valueOf(i27).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_enable_dyn_timeout.has() && ((i26 = dynTimeOutConf.uint32_enable_dyn_timeout.get()) == 0 || i26 == 1)) {
                sEnableDynTimeout = i26;
            }
            if (dynTimeOutConf.uint32_hb_timeout_default.has() && (i19 = dynTimeOutConf.uint32_hb_timeout_default.get()) > 0) {
                sHbTimeoutDef = Long.valueOf(i19).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_hb_timeout_2g.has() && (i18 = dynTimeOutConf.uint32_hb_timeout_2g.get()) > 0) {
                sHbTimeout_2G = Long.valueOf(i18).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_hb_timeout_3g.has() && (i17 = dynTimeOutConf.uint32_hb_timeout_3g.get()) > 0) {
                sHbTimeout_3G = Long.valueOf(i17).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_hb_timeout_4g.has() && (i16 = dynTimeOutConf.uint32_hb_timeout_4g.get()) > 0) {
                sHbTimeout_4G = Long.valueOf(i16).longValue() * 1000;
            }
            if (dynTimeOutConf.uint32_hb_timeout_wifi.has() && (i3 = dynTimeOutConf.uint32_hb_timeout_wifi.get()) > 0) {
                sHbTimeout_wifi = Long.valueOf(i3).longValue() * 1000;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "BdhSegTimeoutUtil.updateFromSrv:  sTbase_2G = " + sTbase_2G + " sTbase_3G = " + sTbase_3G + " sTbase_4G = " + sTbase_4G + " sTbase_wifi = " + sTbase_wifi + " sTorg_2G = " + sTorg_2G + " sTorg_3G = " + sTorg_3G + " sTorg_4G = " + sTorg_4G + " sTorg_wifi = " + sTorg_wifi + " sMaxTimeoutDef = " + sMaxTimeoutDef + " sMaxTimeout_2G = " + sMaxTimeout_2G + " sMaxTimeout_3G = " + sMaxTimeout_3G + " sMaxTimeout_4G = " + sMaxTimeout_4G + " sMaxTimeout_wifi = " + sMaxTimeout_wifi + " sEnableDynTimeout = " + sEnableDynTimeout + " sHbTimeoutDef = " + sHbTimeoutDef + " sHbTimeout_2G = " + sHbTimeout_2G + " sHbTimeout_3G = " + sHbTimeout_3G + " sHbTimeout_4G = " + sHbTimeout_4G + " sHbTimeout_wifi = " + sHbTimeout_wifi);
        }
    }
}
