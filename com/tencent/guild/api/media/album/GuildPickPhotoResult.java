package com.tencent.guild.api.media.album;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/api/media/album/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", CustomImageProps.QUALITY, "Ljava/lang/String;", "()Ljava/lang/String;", "localPath", "Lcom/tencent/guild/api/media/album/GuildAlbumMediaType;", "c", "Lcom/tencent/guild/api/media/album/GuildAlbumMediaType;", "()Lcom/tencent/guild/api/media/album/GuildAlbumMediaType;", "resultUriType", "d", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "extra", "e", "thumbPath", "<init>", "(ZLjava/lang/String;Lcom/tencent/guild/api/media/album/GuildAlbumMediaType;Ljava/lang/Object;Ljava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.api.media.album.d, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildPickPhotoResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean quality;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String localPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildAlbumMediaType resultUriType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object extra;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String thumbPath;

    public GuildPickPhotoResult() {
        this(false, null, null, null, null, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getQuality() {
        return this.quality;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildAlbumMediaType getResultUriType() {
        return this.resultUriType;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getThumbPath() {
        return this.thumbPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPickPhotoResult)) {
            return false;
        }
        GuildPickPhotoResult guildPickPhotoResult = (GuildPickPhotoResult) other;
        if (this.quality == guildPickPhotoResult.quality && Intrinsics.areEqual(this.localPath, guildPickPhotoResult.localPath) && this.resultUriType == guildPickPhotoResult.resultUriType && Intrinsics.areEqual(this.extra, guildPickPhotoResult.extra) && Intrinsics.areEqual(this.thumbPath, guildPickPhotoResult.thumbPath)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        boolean z16 = this.quality;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.localPath;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((i3 + hashCode) * 31) + this.resultUriType.hashCode()) * 31;
        Object obj = this.extra;
        if (obj == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = obj.hashCode();
        }
        int i17 = (hashCode3 + hashCode2) * 31;
        String str2 = this.thumbPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "GuildPickPhotoResult(quality=" + this.quality + ", localPath=" + this.localPath + ", resultUriType=" + this.resultUriType + ", extra=" + this.extra + ", thumbPath=" + this.thumbPath + ")";
    }

    public GuildPickPhotoResult(boolean z16, @Nullable String str, @NotNull GuildAlbumMediaType resultUriType, @Nullable Object obj, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(resultUriType, "resultUriType");
        this.quality = z16;
        this.localPath = str;
        this.resultUriType = resultUriType;
        this.extra = obj;
        this.thumbPath = str2;
    }

    public /* synthetic */ GuildPickPhotoResult(boolean z16, String str, GuildAlbumMediaType guildAlbumMediaType, Object obj, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? GuildAlbumMediaType.OTHER : guildAlbumMediaType, (i3 & 8) != 0 ? null : obj, (i3 & 16) == 0 ? str2 : null);
    }
}
