package f80;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lf80/e;", "", "", "a", DomainData.DOMAIN_NAME, "k", "", "jsonKey", "jsonValue", "o", "l", "d", "j", "", "currentDuration", "e", h.F, "g", "c", "f", "i", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "tag", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "mAdVideoReportParams", "mAdVideoReportUrl", "I", "mAdReportDuration", "mLastPlayPosition", "getMVideoPlayDuration", "()I", "setMVideoPlayDuration", "(I)V", "mVideoPlayDuration", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject mAdVideoReportParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAdVideoReportUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mAdReportDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mLastPlayPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mVideoPlayDuration;

    public e(@NotNull GdtAd mAd) {
        Intrinsics.checkNotNullParameter(mAd, "mAd");
        this.tag = "QFSSearchVideoAdReport";
        this.mAdVideoReportParams = new JSONObject();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = mAd.info;
        if (adInfo != null) {
            Intrinsics.checkNotNull(adInfo);
            this.mAdReportDuration = adInfo.report_info.thirdparty_monitor_urls.video_play_duration.get();
        }
        this.mAdVideoReportUrl = mAd.getVideoReportUrl();
        a();
        l();
    }

    private final void a() {
        try {
            this.mAdVideoReportParams.put("bt", "0");
            this.mAdVideoReportParams.put(FileReaderHelper.ET_EXT, "0");
            this.mAdVideoReportParams.put("bf", "0");
            this.mAdVideoReportParams.put("ef", "0");
            this.mAdVideoReportParams.put("pp", "0");
            this.mAdVideoReportParams.put("pa", "0");
            this.mAdVideoReportParams.put("ft", "0");
            this.mAdVideoReportParams.put(Constants.KEYS.PLACEMENTS, "0");
            this.mAdVideoReportParams.put("pt", "0");
        } catch (JSONException e16) {
            QLog.e(this.tag, 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    private final void k() {
        if (TextUtils.isEmpty(this.mAdVideoReportUrl)) {
            QLog.i(this.tag, 1, "videoReportUrl is empty, cancel video report");
            return;
        }
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%s&video=%s", Arrays.copyOf(new Object[]{this.mAdVideoReportUrl, URLEncoder.encode(this.mAdVideoReportParams.toString())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        dVar.d(format);
        o("ft", "0");
    }

    private final void l() {
        this.mVideoPlayDuration = 0;
        this.mLastPlayPosition = 0;
    }

    private final void n() {
        if (!TextUtils.equals(this.mAdVideoReportParams.optString("ft"), "2")) {
            o("ft", "3");
        }
    }

    private final void o(String jsonKey, String jsonValue) {
        try {
            this.mAdVideoReportParams.put(jsonKey, jsonValue);
        } catch (JSONException e16) {
            QLog.e(this.tag, 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    public final void b() {
        String str;
        o("bt", String.valueOf(this.mLastPlayPosition));
        if (this.mLastPlayPosition == 0) {
            str = "1";
        } else {
            str = "0";
        }
        o("bf", str);
    }

    public final void c() {
        o("ef", "1");
        k();
    }

    public final void d() {
        n();
        j();
        k();
    }

    public final void e(int currentDuration) {
        o(FileReaderHelper.ET_EXT, String.valueOf(currentDuration));
        int i3 = (this.mVideoPlayDuration + currentDuration) - this.mLastPlayPosition;
        this.mVideoPlayDuration = i3;
        o("pt", String.valueOf(i3));
        this.mLastPlayPosition = currentDuration;
    }

    public final void f() {
        o("ft", "3");
        k();
    }

    public final void g() {
        o("ef", "1");
        k();
        o("ef", "0");
    }

    public final void h() {
        o("pa", "14");
        o("bt", "0");
        this.mLastPlayPosition = 0;
    }

    public final void i() {
        o(Constants.KEYS.PLACEMENTS, "2");
    }

    public final void j() {
        o("bf", "0");
        o("ef", "0");
    }

    public final void m() {
        n();
    }
}
