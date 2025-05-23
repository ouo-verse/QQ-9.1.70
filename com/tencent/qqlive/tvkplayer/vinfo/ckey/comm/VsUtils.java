package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsUtils {
    static final String dataFmStr = "yyyy-MM-dd HH:mm:ss";
    static final String onlyDayFmStr = "yyyy-MM-dd";

    public static byte[] decodeDatasByUnZipAndUnEncry(byte[] bArr, int i3, int i16, String str) {
        try {
            return unzipDatas(unencryDatas(bArr, i16, str), i3);
        } catch (Exception e16) {
            VsLog.printStackTrace(e16);
            return null;
        }
    }

    public static byte[] encodeDatasByZipAndEncry(byte[] bArr, int i3, int i16, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return encryDatas(zipDatas(bArr, i3), i16, str);
        } catch (Throwable th5) {
            VsLog.printStackTrace(th5);
            return null;
        }
    }

    public static byte[] encryDatas(byte[] bArr, int i3, String str) {
        if (bArr != null && i3 == 3) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            String substring = str.substring(0, 16);
            VsLog.debug("enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i3));
            try {
                return VsEncryptUtil.vsAesEncrypt(substring, bArr);
            } catch (Throwable th5) {
                VsLog.printStackTrace(th5);
                VsLog.error("err enD: %s", th5.toString());
                return null;
            }
        }
        return bArr;
    }

    public static String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
    }

    public static String getToday() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        } catch (Throwable th5) {
            VsLog.printStackTrace(th5);
            return "";
        }
    }

    public static long getTodayTimes() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime();
        } catch (Throwable th5) {
            VsLog.printStackTrace(th5);
            return -1L;
        }
    }

    public static long parseCurrentToServerTime(long j3) {
        return new Date().getTime() + j3;
    }

    public static Date parseToDate(String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
            } catch (ParseException e16) {
                VsLog.printStackTrace(e16);
            }
        }
        return null;
    }

    public static byte[] unencryDatas(byte[] bArr, int i3, String str) {
        if (bArr != null && i3 == 3) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            try {
                return VsEncryptUtil.vsAesDecrypt(str.substring(0, 16), bArr);
            } catch (Throwable th5) {
                VsLog.printStackTrace(th5);
                VsLog.error("err unD: %s", th5.toString());
                return null;
            }
        }
        return bArr;
    }

    public static byte[] unzipDatas(byte[] bArr, int i3) {
        if (bArr != null && i3 != -1) {
            VsLog.debug("unzp: %s len: %s", Integer.valueOf(i3), Integer.valueOf(bArr.length));
            try {
                return CompressUtil.uncompress(i3, bArr);
            } catch (Throwable th5) {
                VsLog.printStackTrace(th5);
                VsLog.error("err unzp}" + th5.toString(), new Object[0]);
                return null;
            }
        }
        return bArr;
    }

    public static byte[] zipDatas(byte[] bArr, int i3) {
        if (bArr != null && i3 != -1) {
            VsLog.debug("zp: %s len: %s", Integer.valueOf(i3), Integer.valueOf(bArr.length));
            try {
                return CompressUtil.compress(i3, bArr);
            } catch (Throwable th5) {
                VsLog.printStackTrace(th5);
                VsLog.error("err zp : %s", th5.toString());
                return null;
            }
        }
        return bArr;
    }
}
