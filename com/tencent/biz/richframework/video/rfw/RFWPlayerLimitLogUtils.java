package com.tencent.biz.richframework.video.rfw;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.RFWBaseVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* loaded from: classes5.dex */
public class RFWPlayerLimitLogUtils {
    private static String mPrePrintDownloadProgressExtra = "";

    /* loaded from: classes5.dex */
    public static class PrintLogParam {
        private Object mExtra;
        private int mHashCode;
        private String mPlayerTag;
        private SuperPlayerVideoInfo mSuperPlayerVideoInfo;
        private int mWhat;

        PrintLogParam() {
        }

        public static PrintLogParam build() {
            return new PrintLogParam();
        }

        public PrintLogParam setExtra(Object obj) {
            this.mExtra = obj;
            return this;
        }

        public PrintLogParam setHashCode(int i3) {
            this.mHashCode = i3;
            return this;
        }

        public PrintLogParam setPlayerTag(String str) {
            this.mPlayerTag = str;
            return this;
        }

        public PrintLogParam setSuperPlayerVideoInfo(SuperPlayerVideoInfo superPlayerVideoInfo) {
            this.mSuperPlayerVideoInfo = superPlayerVideoInfo;
            return this;
        }

        public PrintLogParam setWhat(int i3) {
            this.mWhat = i3;
            return this;
        }
    }

    public static String getCurrentStackTrace(String str, int i3) {
        String str2 = str + "\n";
        try {
        } catch (Throwable th5) {
            RFWLog.d("RFWPlayerLimitLogUtils", 1, "[getCurrentStackTrace] ex: ", th5.getMessage());
        }
        if (!QLog.isDevelopLevel() && Build.VERSION.SDK_INT <= 27) {
            return "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length != 0) {
            int min = Math.min(i3, stackTrace.length);
            for (int i16 = 0; i16 < min; i16++) {
                str2 = str2 + stackTrace[i16] + "\n";
            }
            return str2;
        }
        return str2;
    }

    private static void printDownloadProgressUpdate(@NonNull PrintLogParam printLogParam, String str) {
        boolean z16;
        if (RFWLog.isColorLevel() && printLogParam.mExtra != null && !TextUtils.isEmpty(str)) {
            String str2 = "onInfo: hashCode:" + printLogParam.hashCode() + " ,what:" + RFWBaseVideoUtils.convertWhatToString(printLogParam.mWhat);
            String obj = printLogParam.mExtra.toString();
            if (!TextUtils.equals(mPrePrintDownloadProgressExtra, obj)) {
                str2 = (str2 + ", extra:" + obj) + ", fileId:" + str;
                mPrePrintDownloadProgressExtra = obj;
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                RFWLog.i(printLogParam.mPlayerTag, RFWLog.CLR, str2);
            }
        }
    }

    public static void printPlayerInfo(PrintLogParam printLogParam) {
        String playUrl;
        if (printLogParam != null && printLogParam.mWhat != 252 && printLogParam.mWhat != 205) {
            String str = "";
            if (printLogParam.mWhat == 207) {
                if (printLogParam.mSuperPlayerVideoInfo != null) {
                    str = printLogParam.mSuperPlayerVideoInfo.getFileId();
                }
                printDownloadProgressUpdate(printLogParam, str);
                return;
            }
            if (RFWLog.isColorLevel()) {
                if (printLogParam.mSuperPlayerVideoInfo == null) {
                    playUrl = "";
                } else {
                    playUrl = printLogParam.mSuperPlayerVideoInfo.getPlayUrl();
                }
                String str2 = printLogParam.mPlayerTag;
                int i3 = RFWLog.CLR;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(printLogParam.mHashCode);
                objArr[1] = RFWBaseVideoUtils.convertWhatToString(printLogParam.mWhat);
                if (printLogParam.mExtra != null) {
                    str = printLogParam.mExtra.toString();
                }
                objArr[2] = str;
                objArr[3] = playUrl;
                RFWLog.i(str2, i3, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", objArr));
            }
        }
    }
}
