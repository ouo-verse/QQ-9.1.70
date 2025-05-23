package com.tencent.biz.qqcircle.immersive.utils.ad;

import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/g;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "", "b", "", "endTime", "", "isPlayCompleted", "", "isCompletion", "finishType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "c", "a", "Ljava/lang/String;", "videoReportUrl", "J", "lastEndTime", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoReportUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastEndTime;

    public g(@NotNull String videoReportUrl) {
        Intrinsics.checkNotNullParameter(videoReportUrl, "videoReportUrl");
        this.videoReportUrl = videoReportUrl;
    }

    private final void b(String reportUrl) {
        boolean z16;
        if (reportUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("QDM-QFSAdVideoReporter", 1, "reportAd cancel, url is empty");
            return;
        }
        try {
            URLConnection openConnection = new URL(reportUrl).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            QLog.i("QDM-QFSAdVideoReporter", 1, "reportAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.i("QDM-QFSAdVideoReporter", 1, "reportAd error, url = " + reportUrl, th5);
        }
    }

    public static /* synthetic */ void d(g gVar, long j3, boolean z16, int i3, int i16, int i17, int i18, Object obj) {
        int i19;
        int i26;
        int i27;
        if ((i18 & 4) != 0) {
            i19 = 0;
        } else {
            i19 = i3;
        }
        if ((i18 & 8) != 0) {
            i26 = 3;
        } else {
            i26 = i16;
        }
        if ((i18 & 16) != 0) {
            i27 = 0;
        } else {
            i27 = i17;
        }
        gVar.c(j3, z16, i19, i26, i27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j3, long j16, int i3, int i16, int i17, g this$0, boolean z16) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bt", String.valueOf(j3));
        jSONObject.put(FileReaderHelper.ET_EXT, String.valueOf(j16));
        if (j3 != 0) {
            str = "0";
        } else {
            str = "1";
        }
        jSONObject.put("bf", str);
        jSONObject.put("ef", String.valueOf(i3));
        jSONObject.put("pp", "0");
        if (z16) {
            str2 = "13";
        } else {
            str2 = "11";
        }
        jSONObject.put("pa", str2);
        jSONObject.put("ft", String.valueOf(i16));
        jSONObject.put(Constants.KEYS.PLACEMENTS, String.valueOf(i17));
        QLog.i("QDM-QFSAdVideoReporter", 2, "begin time: " + j3 + ", end time: " + j16 + ", completion: " + i3 + ", finish type: " + i16 + ", play state: " + i17);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%s&video=%s", Arrays.copyOf(new Object[]{this$0.videoReportUrl, URLEncoder.encode(jSONObject.toString(), "UTF-8")}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        this$0.b(format);
    }

    public final void c(final long endTime, final boolean isPlayCompleted, final int isCompletion, final int finishType, final int playState) {
        final long j3 = this.lastEndTime;
        this.lastEndTime = endTime;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.f
            @Override // java.lang.Runnable
            public final void run() {
                g.e(j3, endTime, isCompletion, finishType, playState, this, isPlayCompleted);
            }
        }, 128, null, true);
    }
}
