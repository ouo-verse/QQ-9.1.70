package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00060"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "cover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "setCover", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;)V", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicSpecUrlEntry;", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Ljava/util/List;", "getVideoUrl", "()Ljava/util/List;", "setVideoUrl", "(Ljava/util/List;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "", QFSEdgeItem.KEY_VIDEO_TIME, "J", "getVideoTime", "()J", "setVideoTime", "(J)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStVideo {
    public static final int $stable = 8;
    private int height;
    private long videoTime;
    private int width;
    private String id = "";
    private String url = "";
    private CommonStImage cover = new CommonStImage();
    private List<CommonStPicSpecUrlEntry> videoUrl = new ArrayList();

    public final CommonStImage getCover() {
        return this.cover;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getVideoTime() {
        return this.videoTime;
    }

    public final List<CommonStPicSpecUrlEntry> getVideoUrl() {
        return this.videoUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setCover(CommonStImage commonStImage) {
        this.cover = commonStImage;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVideoTime(long j3) {
        this.videoTime = j3;
    }

    public final void setVideoUrl(List<CommonStPicSpecUrlEntry> list) {
        this.videoUrl = list;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.v("id", this.id);
        eVar.v("url", this.url);
        eVar.v("cover", this.cover.toJSONObject());
        b bVar = new b();
        Iterator<CommonStPicSpecUrlEntry> it = this.videoUrl.iterator();
        while (it.hasNext()) {
            bVar.t(it.next().toJSONObject());
        }
        eVar.v(AppConstants.Key.KEY_QZONE_VIDEO_URL, bVar);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.u(QFSEdgeItem.KEY_VIDEO_TIME, this.videoTime);
        return eVar;
    }
}
