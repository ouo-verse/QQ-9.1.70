package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.troop.findtroop.TabRecommendPB$MediaInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000eH\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0006\u0010\u001e\u001a\u00020\u0000J\u0013\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\bH\u00d6\u0001J\t\u0010#\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/data/MediaInfo;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/persistence/Entity;", "", "info", "Ltencent/im/troop/findtroop/TabRecommendPB$MediaInfo;", "(Ltencent/im/troop/findtroop/TabRecommendPB$MediaInfo;)V", "mediaType", "", "picUrl", "", "text", "reportData", "hasPic", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getHasPic", "()Z", "getMediaType", "()I", "getPicUrl", "()Ljava/lang/String;", "getReportData", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "copyData", "equals", "other", "", "hashCode", "toString", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final /* data */ class MediaInfo extends Entity implements Serializable, Cloneable {
    private final boolean hasPic;
    private final int mediaType;

    @NotNull
    private final String picUrl;

    @NotNull
    private final String reportData;

    @NotNull
    private final String text;

    public MediaInfo(int i3, @NotNull String picUrl, @NotNull String text, @NotNull String reportData, boolean z16) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.mediaType = i3;
        this.picUrl = picUrl;
        this.text = text;
        this.reportData = reportData;
        this.hasPic = z16;
    }

    public static /* synthetic */ MediaInfo copy$default(MediaInfo mediaInfo, int i3, String str, String str2, String str3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = mediaInfo.mediaType;
        }
        if ((i16 & 2) != 0) {
            str = mediaInfo.picUrl;
        }
        String str4 = str;
        if ((i16 & 4) != 0) {
            str2 = mediaInfo.text;
        }
        String str5 = str2;
        if ((i16 & 8) != 0) {
            str3 = mediaInfo.reportData;
        }
        String str6 = str3;
        if ((i16 & 16) != 0) {
            z16 = mediaInfo.hasPic;
        }
        return mediaInfo.copy(i3, str4, str5, str6, z16);
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    /* renamed from: component1, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHasPic() {
        return this.hasPic;
    }

    @NotNull
    public final MediaInfo copy(int mediaType, @NotNull String picUrl, @NotNull String text, @NotNull String reportData, boolean hasPic) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new MediaInfo(mediaType, picUrl, text, reportData, hasPic);
    }

    @NotNull
    public final MediaInfo copyData() {
        return copy$default(this, 0, null, null, null, false, 31, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if (this.mediaType == mediaInfo.mediaType && Intrinsics.areEqual(this.picUrl, mediaInfo.picUrl) && Intrinsics.areEqual(this.text, mediaInfo.text) && Intrinsics.areEqual(this.reportData, mediaInfo.reportData) && this.hasPic == mediaInfo.hasPic) {
            return true;
        }
        return false;
    }

    public final boolean getHasPic() {
        return this.hasPic;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.mediaType * 31) + this.picUrl.hashCode()) * 31) + this.text.hashCode()) * 31) + this.reportData.hashCode()) * 31;
        boolean z16 = this.hasPic;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "MediaInfo(mediaType=" + this.mediaType + ", picUrl=" + this.picUrl + ", text=" + this.text + ", reportData=" + this.reportData + ", hasPic=" + this.hasPic + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaInfo(@NotNull TabRecommendPB$MediaInfo info) {
        this(r2, r3, r4, r0 == null ? "" : r0, info.has_pic.get());
        Intrinsics.checkNotNullParameter(info, "info");
        int i3 = info.type.get();
        String str = info.pic_url.get();
        String str2 = str == null ? "" : str;
        String str3 = info.text.get();
        String str4 = str3 == null ? "" : str3;
        String str5 = info.report_data.get();
    }
}
