package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R \u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014\u00a8\u00061"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "", "()V", "cover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "setCover", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;)V", "hasRaw", "", "getHasRaw", "()Z", "setHasRaw", "(Z)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "size", "", "getSize", "()J", "setSize", "(J)V", "url", "getUrl", "setUrl", QFSEdgeItem.KEY_VIDEO_TIME, "getVideoTime", "setVideoTime", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "getVideoUrl", "()Ljava/util/List;", "setVideoUrl", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonVideo {
    public static final int $stable = 8;
    private CommonImage cover;
    private boolean hasRaw;
    private int height;
    private String id;
    private long size;
    private String url;
    private long videoTime;
    private List<CommonPicSpecUrlEntry> videoUrl;
    private int width;

    public CommonVideo() {
        List<CommonPicSpecUrlEntry> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.videoUrl = emptyList;
    }

    public final CommonImage getCover() {
        return this.cover;
    }

    public final boolean getHasRaw() {
        return this.hasRaw;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.id;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getVideoTime() {
        return this.videoTime;
    }

    public final List<CommonPicSpecUrlEntry> getVideoUrl() {
        return this.videoUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setCover(CommonImage commonImage) {
        this.cover = commonImage;
    }

    public final void setHasRaw(boolean z16) {
        this.hasRaw = z16;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setSize(long j3) {
        this.size = j3;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVideoTime(long j3) {
        this.videoTime = j3;
    }

    public final void setVideoUrl(List<CommonPicSpecUrlEntry> list) {
        this.videoUrl = list;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }
}
