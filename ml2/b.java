package ml2;

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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lml2/b;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "", "b", "", "endTime", "", "isCompletion", "finishType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "eventType", "c", "a", "Ljava/lang/String;", "videoReportUrl", "J", "lastEndTime", "<init>", "(Ljava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoReportUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastEndTime;

    public b(@NotNull String videoReportUrl) {
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
            QLog.e("AdVideoReporter", 1, "reportAd cancel, url is empty");
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
            QLog.i("AdVideoReporter", 1, "reportAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.i("AdVideoReporter", 1, "reportAd error, url = " + reportUrl, th5);
        }
    }

    public static /* synthetic */ void d(b bVar, long j3, int i3, int i16, int i17, int i18, int i19, Object obj) {
        int i26;
        int i27;
        int i28;
        int i29;
        if ((i19 & 2) != 0) {
            i26 = 0;
        } else {
            i26 = i3;
        }
        if ((i19 & 4) != 0) {
            i27 = 3;
        } else {
            i27 = i16;
        }
        if ((i19 & 8) != 0) {
            i28 = 0;
        } else {
            i28 = i17;
        }
        if ((i19 & 16) != 0) {
            i29 = 11;
        } else {
            i29 = i18;
        }
        bVar.c(j3, i26, i27, i28, i29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j3, long j16, int i3, int i16, int i17, int i18, b this$0) {
        String str;
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
        jSONObject.put("pa", String.valueOf(i18));
        jSONObject.put("ft", String.valueOf(i16));
        jSONObject.put(Constants.KEYS.PLACEMENTS, String.valueOf(i17));
        QLog.i("AdVideoReporter", 2, "begin time: " + j3 + ", end time: " + j16 + ", completion: " + i3 + ", finish type: " + i16 + ", play state: " + i17 + ", eventType: " + i18);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%s&video=%s", Arrays.copyOf(new Object[]{this$0.videoReportUrl, URLEncoder.encode(jSONObject.toString(), "UTF-8")}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        this$0.b(format);
    }

    public final void c(final long endTime, final int isCompletion, final int finishType, final int playState, final int eventType) {
        long j3;
        final long j16 = this.lastEndTime;
        if (isCompletion == 1) {
            j3 = 0;
        } else {
            j3 = endTime;
        }
        this.lastEndTime = j3;
        ThreadManagerV2.excute(new Runnable() { // from class: ml2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(j16, endTime, isCompletion, finishType, playState, eventType, this);
            }
        }, 128, null, true);
    }
}
