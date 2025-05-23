package com.tencent.qmethod.monitor.ext.download;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010O\u001a\u00020\u0004\u0012\b\b\u0002\u0010S\u001a\u00020P\u00a2\u0006\u0004\bT\u0010UJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b!\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b+\u0010\u0018R\"\u00103\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b5\u0010\u0018R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b*\u0010\u0016\"\u0004\b;\u0010\u0018R\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b4\u0010\u0016\"\u0004\b=\u0010\u0018R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0014\u001a\u0004\b-\u0010\u0016\"\u0004\b@\u0010\u0018R\"\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b?\u0010\u0016\"\u0004\bB\u0010\u0018R$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010M\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\bE\u0010\u001d\"\u0004\bL\u0010\u001fR\u0017\u0010O\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bG\u0010\u0014\u001a\u0004\bN\u0010\u0016R\u0017\u0010S\u001a\u00020P8\u0006\u00a2\u0006\f\n\u0004\bN\u0010Q\u001a\u0004\b:\u0010R\u00a8\u0006V"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/download/a;", "", "Lorg/json/JSONObject;", "resultJson", "", "key", "o", "Landroid/graphics/Bitmap;", "pic", "", "w", "callBackUrl", HippyTKDListViewAdapter.X, "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "nativeUI", "b", "Z", "k", "()Z", "t", "(Z)V", "downloadBtn", "c", ReportConstant.COSTREPORT_PREFIX, "apkURL", "d", "setApkVerName", "apkVerName", "e", "setApkVerCode", "apkVerCode", "f", "setApkPkg", "apkPkg", "g", "I", "r", "()I", "setGame", "(I)V", "isGame", h.F, "setAppAuthor", "appAuthor", "i", "setAppVersion", "appVersion", "j", "setAppName", "appName", "setAppPrivacy", "appPrivacy", "l", "setAppPermission", "appPermission", "setGameCP", "gameCP", "", DomainData.DOMAIN_NAME, "[B", "p", "()[B", "setScreenCapture", "([B)V", "screenCapture", "v", "needCapture", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "webUrl", "", "J", "()J", "checkTime", "<init>", "(Ljava/lang/String;J)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.ext.download.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class DownloadInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nativeUI;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean downloadBtn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkURL;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkVerName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkVerCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkPkg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int isGame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appAuthor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appVersion;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appPrivacy;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appPermission;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String gameCP;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] screenCapture;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean needCapture;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String webUrl;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final long checkTime;

    public DownloadInfo(@NotNull String webUrl, long j3) {
        Intrinsics.checkParameterIsNotNull(webUrl, "webUrl");
        this.webUrl = webUrl;
        this.checkTime = j3;
        this.nativeUI = "";
        this.apkURL = "";
        this.apkVerName = "";
        this.apkVerCode = "";
        this.apkPkg = "";
        this.appAuthor = "";
        this.appVersion = "";
        this.appName = "";
        this.appPrivacy = "";
        this.appPermission = "";
        this.gameCP = "";
        this.needCapture = true;
    }

    private final String o(JSONObject resultJson, String key) {
        boolean z16;
        if (resultJson.has(key)) {
            String optString = resultJson.optString(key);
            Intrinsics.checkExpressionValueIsNotNull(optString, "resultJson.optString(key)");
            if (optString != null && optString.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return "[\u53d1\u73b0\u8981\u7d20\u540d,\u8981\u7d20\u4fe1\u606f\u53ef\u80fd\u662f\u8d85\u94fe\u63a5]";
            }
            return optString;
        }
        return "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getApkPkg() {
        return this.apkPkg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getApkURL() {
        return this.apkURL;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getApkVerCode() {
        return this.apkVerCode;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getApkVerName() {
        return this.apkVerName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppAuthor() {
        return this.appAuthor;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DownloadInfo) {
                DownloadInfo downloadInfo = (DownloadInfo) other;
                if (!Intrinsics.areEqual(this.webUrl, downloadInfo.webUrl) || this.checkTime != downloadInfo.checkTime) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getAppPermission() {
        return this.appPermission;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getAppPrivacy() {
        return this.appPrivacy;
    }

    public int hashCode() {
        int i3;
        String str = this.webUrl;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + androidx.fragment.app.a.a(this.checkTime);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: j, reason: from getter */
    public final long getCheckTime() {
        return this.checkTime;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getDownloadBtn() {
        return this.downloadBtn;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getGameCP() {
        return this.gameCP;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getNativeUI() {
        return this.nativeUI;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getNeedCapture() {
        return this.needCapture;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final byte[] getScreenCapture() {
        return this.screenCapture;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* renamed from: r, reason: from getter */
    public final int getIsGame() {
        return this.isGame;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.apkURL = str;
    }

    public final void t(boolean z16) {
        this.downloadBtn = z16;
    }

    @NotNull
    public String toString() {
        return "DownloadInfo(webUrl=" + this.webUrl + ", checkTime=" + this.checkTime + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.nativeUI = str;
    }

    public final void v(boolean z16) {
        this.needCapture = z16;
    }

    public final void w(@NotNull Bitmap pic) {
        Integer num;
        double d16;
        Intrinsics.checkParameterIsNotNull(pic, "pic");
        try {
            int byteCount = pic.getByteCount();
            byte[] a16 = hr3.a.f406095a.a(pic);
            this.screenCapture = a16;
            if (a16 != null) {
                num = Integer.valueOf(a16.length);
            } else {
                num = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("origin size=");
            sb5.append(byteCount);
            sb5.append(", new size=");
            sb5.append(num);
            sb5.append(',');
            sb5.append(" compress rate=");
            double d17 = 1;
            if (num != null) {
                d16 = num.intValue() / byteCount;
            } else {
                d16 = 0.0d;
            }
            sb5.append(d17 - d16);
            o.a("DownloadInfo", sb5.toString());
        } catch (Throwable th5) {
            o.d("DownloadInfo", "setScreenCapture error", th5);
            try {
                if (!pic.isRecycled()) {
                    pic.recycle();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void x(@NotNull String callBackUrl) {
        Intrinsics.checkParameterIsNotNull(callBackUrl, "callBackUrl");
        String queryParameter = Uri.parse(callBackUrl).getQueryParameter("resultJson");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        if (queryParameter == null) {
            Intrinsics.throwNpe();
        }
        JSONObject jSONObject = new JSONObject(queryParameter);
        String optString = jSONObject.optString("\u5f00\u53d1\u5546");
        Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(\"\u5f00\u53d1\u5546\")");
        this.appAuthor = optString;
        String optString2 = jSONObject.optString("\u7248\u672c");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optString(\"\u7248\u672c\")");
        this.appVersion = optString2;
        String optString3 = jSONObject.optString("\u5e94\u7528");
        Intrinsics.checkExpressionValueIsNotNull(optString3, "it.optString(\"\u5e94\u7528\")");
        this.appName = optString3;
        String optString4 = jSONObject.optString("\u8fd0\u8425\u5546");
        Intrinsics.checkExpressionValueIsNotNull(optString4, "it.optString(\"\u8fd0\u8425\u5546\")");
        this.gameCP = optString4;
        this.appPrivacy = o(jSONObject, "\u9690\u79c1\u653f\u7b56");
        this.appPermission = o(jSONObject, "\u6743\u9650\u8be6\u60c5");
    }

    public /* synthetic */ DownloadInfo(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? System.currentTimeMillis() : j3);
    }
}
