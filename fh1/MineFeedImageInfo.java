package fh1;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lfh1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "b", "Z", "()Z", BaseProfileQZoneComponent.KEY_IS_VIDEO, "c", "I", "getWidth", "()I", "width", "d", "getHeight", "height", "<init>", "(Ljava/lang/String;ZII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fh1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MineFeedImageInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isVideo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    public MineFeedImageInfo(@NotNull String url, boolean z16, int i3, int i16) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.isVideo = z16;
        this.width = i3;
        this.height = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MineFeedImageInfo)) {
            return false;
        }
        MineFeedImageInfo mineFeedImageInfo = (MineFeedImageInfo) other;
        if (Intrinsics.areEqual(this.url, mineFeedImageInfo.url) && this.isVideo == mineFeedImageInfo.isVideo && this.width == mineFeedImageInfo.width && this.height == mineFeedImageInfo.height) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        boolean z16 = this.isVideo;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.width) * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "MineFeedImageInfo(url=" + this.url + ", isVideo=" + this.isVideo + ", width=" + this.width + ", height=" + this.height + ")";
    }
}
