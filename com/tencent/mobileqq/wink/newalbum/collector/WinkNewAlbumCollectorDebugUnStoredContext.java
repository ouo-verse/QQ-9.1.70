package com.tencent.mobileqq.wink.newalbum.collector;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001\tBM\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u000e\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b\t\u0010\u001d\"\u0004\b'\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "photoID", "b", "d", "photoPath", "", UserInfo.SEX_FEMALE, "e", "()F", "textSimilarity", "Z", "f", "()Z", "setVideo", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "I", "()I", "setMediaType", "(I)V", "mediaType", "", "J", "getTimeStamp", "()J", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "g", "setCollectorLoop", "collectorLoop", "<init>", "(Ljava/lang/String;Ljava/lang/String;FZIJI)V", tl.h.F, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.collector.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumCollectorDebugUnStoredContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String photoID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String photoPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float textSimilarity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int mediaType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timeStamp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int collectorLoop;

    public WinkNewAlbumCollectorDebugUnStoredContext() {
        this(null, null, 0.0f, false, 0, 0L, 0, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCollectorLoop() {
        return this.collectorLoop;
    }

    /* renamed from: b, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPhotoID() {
        return this.photoID;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPhotoPath() {
        return this.photoPath;
    }

    /* renamed from: e, reason: from getter */
    public final float getTextSimilarity() {
        return this.textSimilarity;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumCollectorDebugUnStoredContext)) {
            return false;
        }
        WinkNewAlbumCollectorDebugUnStoredContext winkNewAlbumCollectorDebugUnStoredContext = (WinkNewAlbumCollectorDebugUnStoredContext) other;
        if (Intrinsics.areEqual(this.photoID, winkNewAlbumCollectorDebugUnStoredContext.photoID) && Intrinsics.areEqual(this.photoPath, winkNewAlbumCollectorDebugUnStoredContext.photoPath) && Float.compare(this.textSimilarity, winkNewAlbumCollectorDebugUnStoredContext.textSimilarity) == 0 && this.isVideo == winkNewAlbumCollectorDebugUnStoredContext.isVideo && this.mediaType == winkNewAlbumCollectorDebugUnStoredContext.mediaType && this.timeStamp == winkNewAlbumCollectorDebugUnStoredContext.timeStamp && this.collectorLoop == winkNewAlbumCollectorDebugUnStoredContext.collectorLoop) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.photoID.hashCode() * 31) + this.photoPath.hashCode()) * 31) + Float.floatToIntBits(this.textSimilarity)) * 31;
        boolean z16 = this.isVideo;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((hashCode + i3) * 31) + this.mediaType) * 31) + androidx.fragment.app.a.a(this.timeStamp)) * 31) + this.collectorLoop;
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumCollectorDebugUnStoredContext(photoID=" + this.photoID + ", photoPath=" + this.photoPath + ", textSimilarity=" + this.textSimilarity + ", isVideo=" + this.isVideo + ", mediaType=" + this.mediaType + ", timeStamp=" + this.timeStamp + ", collectorLoop=" + this.collectorLoop + ")";
    }

    public WinkNewAlbumCollectorDebugUnStoredContext(@NotNull String photoID, @NotNull String photoPath, float f16, boolean z16, int i3, long j3, int i16) {
        Intrinsics.checkNotNullParameter(photoID, "photoID");
        Intrinsics.checkNotNullParameter(photoPath, "photoPath");
        this.photoID = photoID;
        this.photoPath = photoPath;
        this.textSimilarity = f16;
        this.isVideo = z16;
        this.mediaType = i3;
        this.timeStamp = j3;
        this.collectorLoop = i16;
    }

    public /* synthetic */ WinkNewAlbumCollectorDebugUnStoredContext(String str, String str2, float f16, boolean z16, int i3, long j3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) == 0 ? str2 : "", (i17 & 4) != 0 ? 0.0f : f16, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? 0 : i3, (i17 & 32) != 0 ? 0L : j3, (i17 & 64) == 0 ? i16 : 0);
    }
}
