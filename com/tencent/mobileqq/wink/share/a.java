package com.tencent.mobileqq.wink.share;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/share/a;", "", "", "title", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "preview", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "desc", "b", "l", "shareUrlPrefix", tl.h.F, "setShareUrlPrefix", "shareQZoneUrl", "f", "o", "shareUrl", "g", "p", "shareExternalUrl", "e", DomainData.DOMAIN_NAME, "coupleDesc", "a", "setCoupleDesc", "tagIcon", "i", "setTagIcon", "tagName", "j", "setTagName", "prompt", "d", "setPrompt", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    @SerializedName("title")
    @NotNull
    private String title = "\u6b22\u8fce\u4f53\u9a8cAI\u5934\u50cf";

    @SerializedName("preview")
    @NotNull
    private String preview = "https://qq-video.cdn-go.cn/ios/latest/defaultmode/9105/qzone_lingganku_ai_share.jpg";

    @SerializedName("desc")
    @NotNull
    private String desc = "\u5feb\u6765\u5236\u4f5c\u4e00\u6b3e\u9177\u70ab\u7684AI\u5934\u50cf\u5427!";

    @SerializedName("shareUrlPrefix")
    @NotNull
    private String shareUrlPrefix = "https://ti.qq.com/open_qq/index.html?ac=1&hb=1&url=";

    @SerializedName("shareQZoneUrl")
    @NotNull
    private String shareQZoneUrl = "mqzone://arouse/openqqpublish/mood?target=24&come_from=1";

    @SerializedName("shareUrl")
    @NotNull
    private String shareUrl = "mqzone://arouse/openqqpublish/mood?target=24&come_from=1";

    @SerializedName("shareExternalUrl")
    @Nullable
    private String shareExternalUrl = "";

    @SerializedName("coupleTitle")
    @Nullable
    private String coupleDesc = "${name}\u5236\u4f5c\u4e86\u60c5\u4fa3\u6b3eAI\u5934\u50cf\uff0c\u5feb\u6765\u770b\u770b\u5427!";

    @SerializedName("tagIcon")
    @Nullable
    private String tagIcon = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/ai_avatar/qq_icon_avatar_ai_ark.png";

    @SerializedName("tagName")
    @Nullable
    private String tagName = "AI\u5934\u50cf";

    @SerializedName("prompt")
    @Nullable
    private String prompt = "\u6765AI\u5934\u50cf\u4f53\u9a8c\u5947\u8da3\u7f8e\u56fe\uff0c\u53d1\u73b0\u767e\u53d8\u81ea\u6211";

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCoupleDesc() {
        return this.coupleDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPreview() {
        return this.preview;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getShareExternalUrl() {
        return this.shareExternalUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getShareQZoneUrl() {
        return this.shareQZoneUrl;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getShareUrlPrefix() {
        return this.shareUrlPrefix;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getTagIcon() {
        return this.tagIcon;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preview = str;
    }

    public final void n(@Nullable String str) {
        this.shareExternalUrl = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareQZoneUrl = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareUrl = str;
    }
}
