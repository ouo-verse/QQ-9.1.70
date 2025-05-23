package bu2;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020#\u0012\b\b\u0002\u0010+\u001a\u00020#\u0012\b\b\u0002\u0010.\u001a\u00020#\u0012\b\b\u0002\u00100\u001a\u00020#\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\b\u0012\b\b\u0002\u0010;\u001a\u00020\b\u00a2\u0006\u0004\b>\u0010?J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010)\u001a\u00020#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u00020#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b\u0015\u0010&\"\u0004\b*\u0010(R\"\u0010.\u001a\u00020#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R\"\u00100\u001a\u00020#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010$\u001a\u0004\b\u001d\u0010&\"\u0004\b/\u0010(R\"\u00103\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\"\u00105\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b4\u0010\u000fR\"\u0010:\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u00106\u001a\u0004\b\u0011\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b2\u00106\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u0014\u0010=\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u00107\u00a8\u0006@"}, d2 = {"Lbu2/b;", "Lbu2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "nickName", "b", "g", "o", "headImageUrl", "c", h.F, "w", "videoSessionKey", "d", "getOpenId", "r", "openId", "e", "l", CommonConstant.KEY_ACCESS_TOKEN, "f", "t", "refreshToken", "", "J", "j", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "accessTokenExpireTime", HippyTKDListViewAdapter.X, "videoUserId", "i", "v", "videoExpireTime", "u", "videoCreateTime", "k", DomainData.DOMAIN_NAME, "appId", "p", "imToken", "Z", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "isPlatformOverdue", "isVip", "setVip", "isExpired", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;Ljava/lang/String;ZZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bu2.b, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class TVideoAccountInfo implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nickName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String headImageUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoSessionKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String openId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String accessToken;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String refreshToken;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long accessTokenExpireTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long videoUserId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long videoExpireTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long videoCreateTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String imToken;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPlatformOverdue;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isVip;

    public TVideoAccountInfo() {
        this(null, null, null, null, null, null, 0L, 0L, 0L, 0L, null, null, false, false, 16383, null);
    }

    @Override // bu2.a
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // bu2.a
    /* renamed from: b, reason: from getter */
    public boolean getIsPlatformOverdue() {
        return this.isPlatformOverdue;
    }

    @Override // bu2.a
    /* renamed from: c, reason: from getter */
    public long getVideoUserId() {
        return this.videoUserId;
    }

    @Override // bu2.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public String getImToken() {
        return this.imToken;
    }

    @Override // bu2.a
    /* renamed from: e, reason: from getter */
    public long getVideoCreateTime() {
        return this.videoCreateTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TVideoAccountInfo)) {
            return false;
        }
        TVideoAccountInfo tVideoAccountInfo = (TVideoAccountInfo) other;
        if (Intrinsics.areEqual(getNickName(), tVideoAccountInfo.getNickName()) && Intrinsics.areEqual(getHeadImageUrl(), tVideoAccountInfo.getHeadImageUrl()) && Intrinsics.areEqual(getVideoSessionKey(), tVideoAccountInfo.getVideoSessionKey()) && Intrinsics.areEqual(getOpenId(), tVideoAccountInfo.getOpenId()) && Intrinsics.areEqual(getAccessToken(), tVideoAccountInfo.getAccessToken()) && Intrinsics.areEqual(getRefreshToken(), tVideoAccountInfo.getRefreshToken()) && getAccessTokenExpireTime() == tVideoAccountInfo.getAccessTokenExpireTime() && getVideoUserId() == tVideoAccountInfo.getVideoUserId() && getVideoExpireTime() == tVideoAccountInfo.getVideoExpireTime() && getVideoCreateTime() == tVideoAccountInfo.getVideoCreateTime() && Intrinsics.areEqual(getAppId(), tVideoAccountInfo.getAppId()) && Intrinsics.areEqual(getImToken(), tVideoAccountInfo.getImToken()) && getIsPlatformOverdue() == tVideoAccountInfo.getIsPlatformOverdue() && getIsVip() == tVideoAccountInfo.getIsVip()) {
            return true;
        }
        return false;
    }

    @Override // bu2.a
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // bu2.a
    @NotNull
    /* renamed from: g, reason: from getter */
    public String getHeadImageUrl() {
        return this.headImageUrl;
    }

    @Override // bu2.a
    @NotNull
    public String getNickName() {
        return this.nickName;
    }

    @Override // bu2.a
    @NotNull
    public String getOpenId() {
        return this.openId;
    }

    @Override // bu2.a
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getVideoSessionKey() {
        return this.videoSessionKey;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((getNickName().hashCode() * 31) + getHeadImageUrl().hashCode()) * 31) + getVideoSessionKey().hashCode()) * 31) + getOpenId().hashCode()) * 31) + getAccessToken().hashCode()) * 31) + getRefreshToken().hashCode()) * 31) + androidx.fragment.app.a.a(getAccessTokenExpireTime())) * 31) + androidx.fragment.app.a.a(getVideoUserId())) * 31) + androidx.fragment.app.a.a(getVideoExpireTime())) * 31) + androidx.fragment.app.a.a(getVideoCreateTime())) * 31) + getAppId().hashCode()) * 31) + getImToken().hashCode()) * 31;
        boolean isPlatformOverdue = getIsPlatformOverdue();
        int i3 = 1;
        int i16 = isPlatformOverdue;
        if (isPlatformOverdue) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean isVip = getIsVip();
        if (!isVip) {
            i3 = isVip;
        }
        return i17 + i3;
    }

    @Override // bu2.a
    /* renamed from: i, reason: from getter */
    public long getVideoExpireTime() {
        return this.videoExpireTime;
    }

    @Override // bu2.a
    public boolean isExpired() {
        if (getVideoCreateTime() <= 0 || getVideoExpireTime() <= 0 || getVideoCreateTime() + getVideoExpireTime() < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    @Override // bu2.a
    /* renamed from: isVip, reason: from getter */
    public boolean getIsVip() {
        return this.isVip;
    }

    @Override // bu2.a
    /* renamed from: j, reason: from getter */
    public long getAccessTokenExpireTime() {
        return this.accessTokenExpireTime;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public String getAppId() {
        return this.appId;
    }

    public void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken = str;
    }

    public void m(long j3) {
        this.accessTokenExpireTime = j3;
    }

    public void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headImageUrl = str;
    }

    public void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imToken = str;
    }

    public void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openId = str;
    }

    public void s(boolean z16) {
        this.isPlatformOverdue = z16;
    }

    public void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refreshToken = str;
    }

    @NotNull
    public String toString() {
        return "TVideoAccountInfo(nickName=" + getNickName() + ", headImageUrl=" + getHeadImageUrl() + ", videoSessionKey=" + getVideoSessionKey() + ", openId=" + getOpenId() + ", accessToken=" + getAccessToken() + ", refreshToken=" + getRefreshToken() + ", accessTokenExpireTime=" + getAccessTokenExpireTime() + ", videoUserId=" + getVideoUserId() + ", videoExpireTime=" + getVideoExpireTime() + ", videoCreateTime=" + getVideoCreateTime() + ", appId=" + getAppId() + ", imToken=" + getImToken() + ", isPlatformOverdue=" + getIsPlatformOverdue() + ", isVip=" + getIsVip() + ")";
    }

    public void u(long j3) {
        this.videoCreateTime = j3;
    }

    public void v(long j3) {
        this.videoExpireTime = j3;
    }

    public void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoSessionKey = str;
    }

    public void x(long j3) {
        this.videoUserId = j3;
    }

    public TVideoAccountInfo(@NotNull String nickName, @NotNull String headImageUrl, @NotNull String videoSessionKey, @NotNull String openId, @NotNull String accessToken, @NotNull String refreshToken, long j3, long j16, long j17, long j18, @NotNull String appId, @NotNull String imToken, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(headImageUrl, "headImageUrl");
        Intrinsics.checkNotNullParameter(videoSessionKey, "videoSessionKey");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(imToken, "imToken");
        this.nickName = nickName;
        this.headImageUrl = headImageUrl;
        this.videoSessionKey = videoSessionKey;
        this.openId = openId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpireTime = j3;
        this.videoUserId = j16;
        this.videoExpireTime = j17;
        this.videoCreateTime = j18;
        this.appId = appId;
        this.imToken = imToken;
        this.isPlatformOverdue = z16;
        this.isVip = z17;
    }

    public /* synthetic */ TVideoAccountInfo(String str, String str2, String str3, String str4, String str5, String str6, long j3, long j16, long j17, long j18, String str7, String str8, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? 0L : j3, (i3 & 128) != 0 ? 0L : j16, (i3 & 256) != 0 ? 0L : j17, (i3 & 512) == 0 ? j18 : 0L, (i3 & 1024) != 0 ? "" : str7, (i3 & 2048) != 0 ? "" : str8, (i3 & 4096) != 0 ? false : z16, (i3 & 8192) == 0 ? z17 : false);
    }
}
