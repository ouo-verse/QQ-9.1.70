package com.tencent.mobileqq.guild.api;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u000f\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "Ljava/io/Serializable;", "getAnchorNick", "", "getAnchorUid", "getChannelId", "getContentData", "", "getCreateTime", "", "getFeedId", "getGuildId", "getMediaInfoList", "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getTitleData", "MediaInfo", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface IFeedDetailDataParser extends Serializable {
    @NotNull
    String getAnchorNick();

    @NotNull
    String getAnchorUid();

    @NotNull
    String getChannelId();

    @NotNull
    CharSequence getContentData();

    long getCreateTime();

    @NotNull
    String getFeedId();

    @NotNull
    String getGuildId();

    @NotNull
    List<MediaInfo> getMediaInfoList();

    @NotNull
    CharSequence getTitleData();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "Ljava/io/Serializable;", "thumbUrl", "", "type", "", "durationMills", "", "width", "", "height", "urlType", "(Ljava/lang/String;IJFFI)V", "getDurationMills", "()J", "getHeight", "()F", "getThumbUrl", "()Ljava/lang/String;", "getType", "()I", "getUrlType", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class MediaInfo implements Serializable {
        private final long durationMills;
        private final float height;

        @NotNull
        private final String thumbUrl;
        private final int type;
        private final int urlType;
        private final float width;

        public MediaInfo(@NotNull String thumbUrl, int i3, long j3, float f16, float f17, int i16) {
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            this.thumbUrl = thumbUrl;
            this.type = i3;
            this.durationMills = j3;
            this.width = f16;
            this.height = f17;
            this.urlType = i16;
        }

        public static /* synthetic */ MediaInfo copy$default(MediaInfo mediaInfo, String str, int i3, long j3, float f16, float f17, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                str = mediaInfo.thumbUrl;
            }
            if ((i17 & 2) != 0) {
                i3 = mediaInfo.type;
            }
            int i18 = i3;
            if ((i17 & 4) != 0) {
                j3 = mediaInfo.durationMills;
            }
            long j16 = j3;
            if ((i17 & 8) != 0) {
                f16 = mediaInfo.width;
            }
            float f18 = f16;
            if ((i17 & 16) != 0) {
                f17 = mediaInfo.height;
            }
            float f19 = f17;
            if ((i17 & 32) != 0) {
                i16 = mediaInfo.urlType;
            }
            return mediaInfo.copy(str, i18, j16, f18, f19, i16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDurationMills() {
            return this.durationMills;
        }

        /* renamed from: component4, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* renamed from: component5, reason: from getter */
        public final float getHeight() {
            return this.height;
        }

        /* renamed from: component6, reason: from getter */
        public final int getUrlType() {
            return this.urlType;
        }

        @NotNull
        public final MediaInfo copy(@NotNull String thumbUrl, int type, long durationMills, float width, float height, int urlType) {
            Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
            return new MediaInfo(thumbUrl, type, durationMills, width, height, urlType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaInfo)) {
                return false;
            }
            MediaInfo mediaInfo = (MediaInfo) other;
            if (Intrinsics.areEqual(this.thumbUrl, mediaInfo.thumbUrl) && this.type == mediaInfo.type && this.durationMills == mediaInfo.durationMills && Float.compare(this.width, mediaInfo.width) == 0 && Float.compare(this.height, mediaInfo.height) == 0 && this.urlType == mediaInfo.urlType) {
                return true;
            }
            return false;
        }

        public final long getDurationMills() {
            return this.durationMills;
        }

        public final float getHeight() {
            return this.height;
        }

        @NotNull
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        public final int getType() {
            return this.type;
        }

        public final int getUrlType() {
            return this.urlType;
        }

        public final float getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((((((this.thumbUrl.hashCode() * 31) + this.type) * 31) + androidx.fragment.app.a.a(this.durationMills)) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + this.urlType;
        }

        @NotNull
        public String toString() {
            return "MediaInfo(thumbUrl=" + this.thumbUrl + ", type=" + this.type + ", durationMills=" + this.durationMills + ", width=" + this.width + ", height=" + this.height + ", urlType=" + this.urlType + ')';
        }

        public /* synthetic */ MediaInfo(String str, int i3, long j3, float f16, float f17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i17 & 2) != 0 ? 0 : i3, j3, (i17 & 8) != 0 ? 0.0f : f16, (i17 & 16) != 0 ? 0.0f : f17, (i17 & 32) != 0 ? 0 : i16);
        }
    }
}
