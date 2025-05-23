package com.tencent.mobileqq.guild.data;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b'\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\nB\u0083\u0001\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020\t\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\n\u0010\rR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u0015\u0010\u001dR\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u0017\u0010&\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010*\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010-\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b\u001a\u0010\r\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "id", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "path", "c", "fileSize", "d", "l", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "thumbnailPath", "e", "I", tl.h.F, "()I", "mediaWidth", "f", "mediaHeight", "g", "i", "mimeType", "k", BasicAnimation.KeyPath.ROTATION, "mDuration", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "isRaw", "mediaOriginWidth", "mediaOriginHeight", "mediaOriginBitrate", "<init>", "(JLjava/lang/String;JLjava/lang/String;IILjava/lang/String;IJZIIJ)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long fileSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thumbnailPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mediaWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mediaHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mimeType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int rotation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long mDuration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean isRaw;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int mediaOriginWidth;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int mediaOriginHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long mediaOriginBitrate;

    public g(long j3, @NotNull String path, long j16, @NotNull String thumbnailPath, int i3, int i16, @NotNull String mimeType, int i17, long j17, boolean z16, int i18, int i19, long j18) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.id = j3;
        this.path = path;
        this.fileSize = j16;
        this.thumbnailPath = thumbnailPath;
        this.mediaWidth = i3;
        this.mediaHeight = i16;
        this.mimeType = mimeType;
        this.rotation = i17;
        this.mDuration = j17;
        this.isRaw = z16;
        this.mediaOriginWidth = i18;
        this.mediaOriginHeight = i19;
        this.mediaOriginBitrate = j18;
    }

    /* renamed from: a, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final long getMDuration() {
        return this.mDuration;
    }

    /* renamed from: d, reason: from getter */
    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    /* renamed from: e, reason: from getter */
    public final long getMediaOriginBitrate() {
        return this.mediaOriginBitrate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.id == gVar.id && Intrinsics.areEqual(this.path, gVar.path) && this.fileSize == gVar.fileSize && Intrinsics.areEqual(this.thumbnailPath, gVar.thumbnailPath) && this.mediaWidth == gVar.mediaWidth && this.mediaHeight == gVar.mediaHeight && Intrinsics.areEqual(this.mimeType, gVar.mimeType) && this.rotation == gVar.rotation && this.mDuration == gVar.mDuration && this.isRaw == gVar.isRaw && this.mediaOriginWidth == gVar.mediaOriginWidth && this.mediaOriginHeight == gVar.mediaOriginHeight && this.mediaOriginBitrate == gVar.mediaOriginBitrate) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getMediaOriginHeight() {
        return this.mediaOriginHeight;
    }

    /* renamed from: g, reason: from getter */
    public final int getMediaOriginWidth() {
        return this.mediaOriginWidth;
    }

    /* renamed from: h, reason: from getter */
    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((((((((((((((androidx.fragment.app.a.a(this.id) * 31) + this.path.hashCode()) * 31) + androidx.fragment.app.a.a(this.fileSize)) * 31) + this.thumbnailPath.hashCode()) * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + this.mimeType.hashCode()) * 31) + this.rotation) * 31) + androidx.fragment.app.a.a(this.mDuration)) * 31;
        boolean z16 = this.isRaw;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((a16 + i3) * 31) + this.mediaOriginWidth) * 31) + this.mediaOriginHeight) * 31) + androidx.fragment.app.a.a(this.mediaOriginBitrate);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: k, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsRaw() {
        return this.isRaw;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbnailPath = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildLocalMediaInfo:{");
        sb5.append("id = " + this.id + TokenParser.SP);
        sb5.append("path = " + this.path.length() + ", ");
        sb5.append("fileSize = " + this.fileSize + ", ");
        sb5.append("thumbnailPath = " + this.thumbnailPath.length() + ", ");
        sb5.append("mediaWidth = " + this.mediaWidth + ", ");
        sb5.append("mediaHeight = " + this.mediaHeight + ", ");
        sb5.append("mMimeType = " + this.mimeType + ", ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("rotation = ");
        sb6.append(this.rotation);
        sb5.append(sb6.toString());
        sb5.append("mDuration = " + this.mDuration);
        sb5.append("isRaw = " + this.isRaw);
        sb5.append("}");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "stringBuilder.toString()");
        return sb7;
    }

    public /* synthetic */ g(long j3, String str, long j16, String str2, int i3, int i16, String str3, int i17, long j17, boolean z16, int i18, int i19, long j18, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, j16, (i26 & 8) != 0 ? "" : str2, (i26 & 16) != 0 ? 0 : i3, (i26 & 32) != 0 ? 0 : i16, (i26 & 64) != 0 ? "" : str3, (i26 & 128) != 0 ? 0 : i17, (i26 & 256) != 0 ? 0L : j17, (i26 & 512) != 0 ? true : z16, (i26 & 1024) != 0 ? 0 : i18, (i26 & 2048) != 0 ? 0 : i19, (i26 & 4096) != 0 ? 0L : j18);
    }
}
