package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMemoryVideo;", "", "()V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl", "setJumpUrl", QQWinkConstants.TAB_SUBTITLE, "getSubTitle", "setSubTitle", "templateId", "getTemplateId", "setTemplateId", "title", "getTitle", "setTitle", "videoId", "getVideoId", "setVideoId", "viewed", "", "getViewed", "()Z", "setViewed", "(Z)V", "toString", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMemoryVideo {
    public static final int $stable = 8;
    private boolean viewed;
    private String templateId = "";
    private String videoId = "";
    private String coverUrl = "";
    private String jumpUrl = "";
    private String title = "";
    private String subTitle = "";

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean getViewed() {
        return this.viewed;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final void setViewed(boolean z16) {
        this.viewed = z16;
    }

    public String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CommonMemoryVideo(templateId:");
        m3.append(this.templateId);
        m3.append("| videoId:");
        m3.append(this.videoId);
        m3.append("| coverUrl:");
        m3.append(this.coverUrl);
        m3.append("| viewed:");
        m3.append(this.viewed);
        m3.append("| jumpUrl:");
        m3.append(this.jumpUrl);
        m3.append("| title:");
        m3.append(this.title);
        m3.append("| subTitle:");
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, this.subTitle, "| )");
    }
}
