package fm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fm1.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\n\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010!\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b \u0010\u0015R\u0014\u0010$\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010(\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0015\u00a8\u0006+"}, d2 = {"Lfm1/f;", "Lfm1/i;", "", "f", "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "getPath", "getExtra", "a", "b", "c", "Lorg/json/JSONObject;", "g", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "docUrl", "d", "coverUrl", DomainData.DOMAIN_NAME, "title", "k", "iconUrl", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "platformName", "l", "permissionDsc", "i", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "getThumbUrl", "thumbUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String docUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String coverUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String platformName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String permissionDsc;

    public f(@NotNull String docUrl, @NotNull String coverUrl, @NotNull String title, @NotNull String iconUrl, @NotNull String platformName, @NotNull String permissionDsc) {
        Intrinsics.checkNotNullParameter(docUrl, "docUrl");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(permissionDsc, "permissionDsc");
        this.docUrl = docUrl;
        this.coverUrl = coverUrl;
        this.title = title;
        this.iconUrl = iconUrl;
        this.platformName = platformName;
        this.permissionDsc = permissionDsc;
    }

    @Override // fm1.i
    @NotNull
    public String a() {
        return "";
    }

    @Override // fm1.i
    public boolean b() {
        return false;
    }

    @Override // fm1.i
    @NotNull
    public String c() {
        return "";
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // fm1.i
    @Nullable
    public LocalMediaInfo e() {
        return i.a.a(this);
    }

    @Override // fm1.i
    public boolean f() {
        return false;
    }

    @Override // fm1.i
    @NotNull
    public JSONObject g() {
        return new JSONObject();
    }

    @Override // fm1.i
    @NotNull
    public String getExtra() {
        return "";
    }

    @Override // fm1.i
    public int getHeight() {
        return AlbumThumbDownloader.THUMB_WIDHT;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getPath, reason: from getter */
    public String getDocUrl() {
        return this.docUrl;
    }

    @Override // fm1.i
    public int getSubType() {
        return 3;
    }

    @Override // fm1.i
    @NotNull
    public String getTaskId() {
        return "";
    }

    @Override // fm1.i
    @NotNull
    public String getThumbUrl() {
        return this.coverUrl;
    }

    @Override // fm1.i
    public int getType() {
        return 4;
    }

    @Override // fm1.i
    public long getVideoDuration() {
        return 0L;
    }

    @Override // fm1.i
    public int getWidth() {
        return AlbumThumbDownloader.THUMB_WIDHT;
    }

    @Override // fm1.i
    public void h(@NotNull String str) {
        i.a.b(this, str);
    }

    @Override // fm1.i
    public int i() {
        return 1;
    }

    @NotNull
    public final String j() {
        return this.docUrl;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getPermissionDsc() {
        return this.permissionDsc;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
