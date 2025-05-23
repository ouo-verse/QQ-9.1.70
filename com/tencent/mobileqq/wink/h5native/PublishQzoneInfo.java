package com.tencent.mobileqq.wink.h5native;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J'\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo", "", "", "component1", "", "component2", "component3", "sync_to_qzone", "content", "url_title", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo;", "copy", "toString", "", "hashCode", "other", "equals", "Z", "getSync_to_qzone", "()Z", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "getUrl_title", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PublishQzoneInfo, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PublishQzoneInfo {

    @NotNull
    private final String content;
    private final boolean sync_to_qzone;

    @NotNull
    private final String url_title;

    public PublishQzoneInfo(boolean z16, @NotNull String content, @NotNull String url_title) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(url_title, "url_title");
        this.sync_to_qzone = z16;
        this.content = content;
        this.url_title = url_title;
    }

    public static /* synthetic */ PublishQzoneInfo copy$default(PublishQzoneInfo publishQzoneInfo, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = publishQzoneInfo.sync_to_qzone;
        }
        if ((i3 & 2) != 0) {
            str = publishQzoneInfo.content;
        }
        if ((i3 & 4) != 0) {
            str2 = publishQzoneInfo.url_title;
        }
        return publishQzoneInfo.copy(z16, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSync_to_qzone() {
        return this.sync_to_qzone;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUrl_title() {
        return this.url_title;
    }

    @NotNull
    public final PublishQzoneInfo copy(boolean sync_to_qzone, @NotNull String content, @NotNull String url_title) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(url_title, "url_title");
        return new PublishQzoneInfo(sync_to_qzone, content, url_title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishQzoneInfo)) {
            return false;
        }
        PublishQzoneInfo publishQzoneInfo = (PublishQzoneInfo) other;
        if (this.sync_to_qzone == publishQzoneInfo.sync_to_qzone && Intrinsics.areEqual(this.content, publishQzoneInfo.content) && Intrinsics.areEqual(this.url_title, publishQzoneInfo.url_title)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final boolean getSync_to_qzone() {
        return this.sync_to_qzone;
    }

    @NotNull
    public final String getUrl_title() {
        return this.url_title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.sync_to_qzone;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.content.hashCode()) * 31) + this.url_title.hashCode();
    }

    @NotNull
    public String toString() {
        return "PublishQzoneInfo(sync_to_qzone=" + this.sync_to_qzone + ", content=" + this.content + ", url_title=" + this.url_title + ")";
    }
}
