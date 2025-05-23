package fm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fm1.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0017\u00a8\u0006*"}, d2 = {"Lfm1/a;", "Lfm1/i;", "Lfm1/h;", "", "f", "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "getPath", "getExtra", "Lorg/json/JSONObject;", "g", "a", "b", "c", "d", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "imageUrl", "l", "title", "j", "abstract", "k", "redirectUrl", "e", "mediaTaskId", "i", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "getThumbUrl", "thumbUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements i, h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String abstract;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String redirectUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mediaTaskId;

    public a(@NotNull String imageUrl, @NotNull String title, @NotNull String str, @NotNull String redirectUrl, @NotNull String mediaTaskId) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(str, "abstract");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(mediaTaskId, "mediaTaskId");
        this.imageUrl = imageUrl;
        this.title = title;
        this.abstract = str;
        this.redirectUrl = redirectUrl;
        this.mediaTaskId = mediaTaskId;
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
    /* renamed from: c */
    public String getVideoCoverUrl() {
        return "";
    }

    @Override // fm1.h
    @NotNull
    public String d() {
        boolean z16;
        String str = this.mediaTaskId;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String b16 = com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b();
            this.mediaTaskId = b16;
            return b16;
        }
        return str;
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
        JSONObject jSONObject = new JSONObject();
        c.g gVar = c.g.f220911a;
        jSONObject.put("url", this.redirectUrl);
        jSONObject.put("displayText", this.title);
        jSONObject.put("type", 6);
        jSONObject.put("media_task_id", this.mediaTaskId);
        JSONObject jSONObject2 = new JSONObject();
        c.a aVar = c.a.f220905a;
        jSONObject2.put("image_url", this.imageUrl);
        jSONObject2.put("title", this.title);
        jSONObject2.put("abstract", this.abstract);
        jSONObject2.put("redirect_url", this.redirectUrl);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("third_share_info", jSONObject2);
        return jSONObject;
    }

    @Override // fm1.i
    @NotNull
    public String getExtra() {
        return "";
    }

    @Override // fm1.i
    public int getHeight() {
        return AlbumThumbDownloader.THUMB_WIDHT / 2;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getPath */
    public String getDocUrl() {
        return "";
    }

    @Override // fm1.i
    /* renamed from: getSubType */
    public int getUrlType() {
        return 6;
    }

    @Override // fm1.i
    @NotNull
    public String getTaskId() {
        return "";
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getThumbUrl, reason: from getter */
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // fm1.i
    public int getType() {
        return 6;
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
    /* renamed from: j, reason: from getter */
    public final String getAbstract() {
        return this.abstract;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
