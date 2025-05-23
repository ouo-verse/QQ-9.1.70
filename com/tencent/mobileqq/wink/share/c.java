package com.tencent.mobileqq.wink.share;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/share/c;", "", "", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "preview", "b", "g", "desc", "a", "f", "shareUrl", "d", "i", "shareExternalUrl", "c", tl.h.F, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    @SerializedName("title")
    @NotNull
    private String title = "\u8fd9\u662f\u4e00\u95f4\u795e\u5947\u7684\u9b54\u6cd5\u753b\u5ba4";

    @SerializedName("preview")
    @NotNull
    private String preview = "https://shadow-h5-image-1251316161.file.myqcloud.com/2023-aigc/wecom-temp-143487-e5a1fb8b2f66f7d63dbf0d93f1e88b0d.png";

    @SerializedName("desc")
    @NotNull
    private String desc = "\u5168\u7f51\u7206\u706b\u7684\u7ed8\u753b\u795e\u5668\u6765\u54af\uff01\u8bf4\u51fa\u4f60\u7684\u60f3\u8c61\u5c31\u80fd\u4e00\u952e\u6210\u753b\uff0c\u5feb\u6765\u8bd5\u8bd5\u5427";

    @SerializedName("shareUrl")
    @NotNull
    private String shareUrl = "https://h5.tu.qq.com/web/2023-aigc/index?root_channel=client&current_channel=client";

    @SerializedName("shareExternalUrl")
    @Nullable
    private String shareExternalUrl = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPreview() {
        return this.preview;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getShareExternalUrl() {
        return this.shareExternalUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preview = str;
    }

    public final void h(@Nullable String str) {
        this.shareExternalUrl = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareUrl = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
