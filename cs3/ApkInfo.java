package cs3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\"\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u0014\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcs3/a;", "", "", "toString", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", VirtualAppProxy.KEY_GAME_ID, "b", "i", "gameIcon", "d", "k", "gameName", "getPkgName", "l", PushClientConstants.TAG_PKG_NAME, "e", "f", DomainData.DOMAIN_NAME, "versionCode", h.F, "downloadUrl", "g", "o", "versionName", "", "J", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "size", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cs3.a, reason: from toString */
/* loaded from: classes22.dex */
public final class ApkInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String gameId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String gameIcon = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String gameName = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String pkgName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String versionCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String downloadUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String versionName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long size;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGameIcon() {
        return this.gameIcon;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGameId() {
        return this.gameId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGameName() {
        return this.gameName;
    }

    /* renamed from: e, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getVersionCode() {
        return this.versionCode;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    public final void h(@Nullable String str) {
        this.downloadUrl = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameIcon = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameId = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameName = str;
    }

    public final void l(@Nullable String str) {
        this.pkgName = str;
    }

    public final void m(long j3) {
        this.size = j3;
    }

    public final void n(@Nullable String str) {
        this.versionCode = str;
    }

    public final void o(@Nullable String str) {
        this.versionName = str;
    }

    @NotNull
    public String toString() {
        return "ApkInfo(gameId='" + this.gameId + "', gameIcon='" + this.gameIcon + "', gameName='" + this.gameName + "', pkgName=" + this.pkgName + ", versionCode=" + this.versionCode + ", downloadUrl=" + this.downloadUrl + ", versionName=" + this.versionName + ", size=" + this.size + ')';
    }
}
