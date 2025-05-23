package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.Constants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtImpressionReporter {
    public static final int FT_AD = 2;
    public static final int FT_CLICK = 1;
    public static final int FT_DEFAULT = 3;
    public static final int PA_AUTO = 11;
    public static final int PA_AUTO_REPEAT = 14;
    public static final int PA_MANUAL = 12;
    public static final int PA_REPEAT = 13;
    public static final int PP_CEILING = 7;
    public static final int PP_DEFAULT = 0;
    public static final int PP_FLOATING = 11;
    public static final int PS_CACHE = 2;
    public static final int PS_DEFAULT = 3;
    public static final int PS_NO_ERROR = -1;
    private static final String TAG = "GdtVideoStatisticsReport";
    private static final String VIDEO_ATTACH_KEY = "video";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GdtVideoReportInfo {
        private int playType = 11;
        private int finishType = 3;
        private int errorType = -1;

        public GdtVideoReportInfo() {
            resetAll();
        }

        public int getErrorType() {
            return this.errorType;
        }

        public int getFinishType() {
            return this.finishType;
        }

        public int getPlayType() {
            return this.playType;
        }

        public boolean isErrorInfo() {
            if (this.errorType != -1) {
                return true;
            }
            return false;
        }

        public void resetAll() {
            resetPlayType();
            resetFinishType();
            resetErrorType();
        }

        public void resetErrorType() {
            this.errorType = -1;
        }

        public void resetFinishType() {
            this.finishType = 3;
        }

        public void resetPlayType() {
            this.playType = 11;
        }

        public void setErrorType(int i3) {
            this.errorType = i3;
        }

        public void setErrorTypeFromSP(int i3, int i16) {
            int i17;
            if (i3 != 1101 && i3 != 1103 && ((int) (i16 / 1000000.0d)) != 14) {
                i17 = 3;
            } else {
                i17 = 2;
            }
            this.errorType = i17;
        }

        public void setFinishType(int i3) {
            this.finishType = i3;
        }

        public void setPlayType(int i3) {
            this.playType = i3;
        }
    }

    @Nullable
    private static String createGDTVideoAttachment(long j3, long j16, boolean z16, int i3, @NonNull GdtVideoReportInfo gdtVideoReportInfo) {
        int i16;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bt", j3 + "");
            jSONObject.put(FileReaderHelper.ET_EXT, j16 + "");
            StringBuilder sb5 = new StringBuilder();
            int i17 = 0;
            if (j3 > 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            sb5.append(i16);
            sb5.append("");
            jSONObject.put("bf", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            if (z16) {
                i17 = 1;
            }
            sb6.append(i17);
            sb6.append("");
            jSONObject.put("ef", sb6.toString());
            jSONObject.put("pp", String.valueOf(getPPField(i3)));
            jSONObject.put("pa", gdtVideoReportInfo.getPlayType() + "");
            jSONObject.put("ft", gdtVideoReportInfo.getFinishType() + "");
            if (gdtVideoReportInfo.isErrorInfo()) {
                jSONObject.put(Constants.KEYS.PLACEMENTS, String.valueOf(gdtVideoReportInfo.getErrorType()));
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "json exception: " + e16.getMessage());
            return null;
        }
    }

    private static int getPPField(int i3) {
        if (i3 == 7) {
            return 7;
        }
        return 0;
    }

    public static void impressionReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GdtReporter.doCgiReport(str);
    }

    public static void report(GdtAd gdtAd, long j3, long j16, boolean z16, int i3, @NonNull GdtVideoReportInfo gdtVideoReportInfo) {
        String createGDTVideoAttachment = createGDTVideoAttachment(j3, j16, z16, i3, gdtVideoReportInfo);
        QLog.i(TAG, 1, "report: " + createGDTVideoAttachment);
        videoPlayReport(gdtAd, createGDTVideoAttachment);
    }

    private static void videoPlayReport(@Nullable GdtAd gdtAd, String str) {
        if (gdtAd == null || TextUtils.isEmpty(gdtAd.getVideoReportUrl())) {
            return;
        }
        videoPlayReport(gdtAd.getVideoReportUrl(), str);
    }

    private static void videoPlayReport(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str + ContainerUtils.FIELD_DELIMITER + "video" + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str2);
        }
        GdtReporter.doCgiReport(str);
    }
}
