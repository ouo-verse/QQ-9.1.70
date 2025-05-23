package fm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fm1.i;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010!\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0019\u00a8\u0006\""}, d2 = {"Lfm1/g;", "Lfm1/i;", "", "f", "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "getPath", "getExtra", "a", "b", "c", "Lorg/json/JSONObject;", "g", "Ljava/lang/String;", "videoPlayUrl", "J", "videoDuration", "videoCoverUrl", "d", "()Ljava/lang/String;", "videoShortPlayUrl", "i", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "getThumbUrl", "thumbUrl", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoPlayUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long videoDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoCoverUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoShortPlayUrl;

    @Override // fm1.i
    @NotNull
    public String a() {
        return "";
    }

    @Override // fm1.i
    /* renamed from: b */
    public boolean getIsGif() {
        return false;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getVideoCover() {
        return this.videoCoverUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getVideoShortPlayUrl() {
        return this.videoShortPlayUrl;
    }

    @Override // fm1.i
    @Nullable
    /* renamed from: e */
    public LocalMediaInfo getRealInfo() {
        return i.a.a(this);
    }

    @Override // fm1.i
    public boolean f() {
        return false;
    }

    @Override // fm1.i
    @NotNull
    public JSONObject g() {
        return nm1.a.f420455a.a();
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getExtra */
    public String getSvrContentJson() {
        return "";
    }

    @Override // fm1.i
    public int getHeight() {
        return AlbumThumbDownloader.THUMB_WIDHT / 2;
    }

    @Override // fm1.i
    @NotNull
    /* renamed from: getPath, reason: from getter */
    public String getVideoPlayUrl() {
        return this.videoPlayUrl;
    }

    @Override // fm1.i
    /* renamed from: getSubType */
    public int getMediaType() {
        return 1;
    }

    @Override // fm1.i
    @NotNull
    public String getTaskId() {
        return "";
    }

    @Override // fm1.i
    @NotNull
    public String getThumbUrl() {
        return this.videoCoverUrl;
    }

    @Override // fm1.i
    public int getType() {
        return 1;
    }

    @Override // fm1.i
    public long getVideoDuration() {
        return this.videoDuration;
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
}
