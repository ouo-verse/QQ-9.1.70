package com.tencent.mobileqq.wink.editor.aielimination;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/a;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "preview", "c", "i", "desc", "a", "g", "descForQq", "b", tl.h.F, "shareUrl", "e", "setShareUrl", "schemaUrl", "d", "setSchemaUrl", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    @SerializedName("title")
    @NotNull
    private String title = "AI\u6d88\u9664";

    @SerializedName("preview")
    @NotNull
    private String preview = "https://shadow-h5-image-1251316161.file.myqcloud.com/ark/eliminate_share_icon_v4.png";

    @SerializedName("desc")
    @NotNull
    private String desc = "\u9080\u8bf7\u4f60\u4f53\u9a8c\u4e00\u952e\u6d88\u9664\u8def\u4eba\u548c\u6587\u5b57 #\u6765\u81eaQQ\u7a7a\u95f4";

    @SerializedName("desc")
    @NotNull
    private String descForQq = "\u9080\u8bf7\u4f60\u4f53\u9a8c\u4e00\u952e\u6d88\u9664\u8def\u4eba\u548c\u6587\u5b57";

    @SerializedName("shareUrl")
    @NotNull
    private String shareUrl = "https://ti.qq.com/new_open_qq/index.html?appid=10&hb=1&ac=1&url=mqzone%3A%2F%2Farouse%2Fopenqqpublish%2Fmood%3Ftarget%3D23%26source%3D16%26defaultposter%3D1";

    @SerializedName("schemaUrl")
    @NotNull
    private String schemaUrl = "mqqapi://qcircle/openqqpublish?source=16&target=23";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDescForQq() {
        return this.descForQq;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPreview() {
        return this.preview;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descForQq = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preview = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
