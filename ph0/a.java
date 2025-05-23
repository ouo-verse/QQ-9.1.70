package ph0;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b!\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b#\u0010\b\u00a8\u0006'"}, d2 = {"Lph0/a;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "appId", "", "b", "I", "i", "()I", "setVersionCode", "(I)V", "versionCode", "j", "apkChannel", "d", "k", "apkUrl", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "appName", "f", DomainData.DOMAIN_NAME, "iconUrl", "g", "o", PushClientConstants.TAG_PKG_NAME, h.F, "p", VirtualAppProxy.KEY_PKG_SIZE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "reportData", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int versionCode;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkChannel = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apkUrl = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appName = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String iconUrl = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pkgName = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pkgSize = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportData = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getApkChannel() {
        return this.apkChannel;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getApkUrl() {
        return this.apkUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPkgSize() {
        return this.pkgSize;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    /* renamed from: i, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    public final void j(@NotNull String str) {
        this.apkChannel = str;
    }

    public final void k(@NotNull String str) {
        this.apkUrl = str;
    }

    public final void l(@NotNull String str) {
        this.appId = str;
    }

    public final void m(@NotNull String str) {
        this.appName = str;
    }

    public final void n(@NotNull String str) {
        this.iconUrl = str;
    }

    public final void o(@NotNull String str) {
        this.pkgName = str;
    }

    public final void p(@NotNull String str) {
        this.pkgSize = str;
    }

    public final void q(@NotNull String str) {
        this.reportData = str;
    }
}
