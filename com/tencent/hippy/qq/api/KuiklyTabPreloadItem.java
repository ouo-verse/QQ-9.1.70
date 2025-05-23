package com.tencent.hippy.qq.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem;", "", "resId", "", "type", "Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType;", "priority", "", "downloadTimeGapMin", "", "(Ljava/lang/String;Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType;IJ)V", "getDownloadTimeGapMin", "()J", "getPriority", "()I", "getResId", "()Ljava/lang/String;", "getType", "()Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "PreloadType", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class KuiklyTabPreloadItem {
    private final long downloadTimeGapMin;
    private final int priority;

    @NotNull
    private final String resId;

    @NotNull
    private final PreloadType type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PRE_DOWNLOAD", "Companion", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum PreloadType {
        PRE_DOWNLOAD(0);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int type;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType$Companion;", "", "()V", "toType", "Lcom/tencent/hippy/qq/api/KuiklyTabPreloadItem$PreloadType;", "type", "", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final PreloadType toType(@NotNull String type) {
                Intrinsics.checkNotNullParameter(type, "type");
                if ("predownload".equals(type)) {
                    return PreloadType.PRE_DOWNLOAD;
                }
                return PreloadType.PRE_DOWNLOAD;
            }

            Companion() {
            }
        }

        PreloadType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    public KuiklyTabPreloadItem(@NotNull String resId, @NotNull PreloadType type, int i3, long j3) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.resId = resId;
        this.type = type;
        this.priority = i3;
        this.downloadTimeGapMin = j3;
    }

    public static /* synthetic */ KuiklyTabPreloadItem copy$default(KuiklyTabPreloadItem kuiklyTabPreloadItem, String str, PreloadType preloadType, int i3, long j3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = kuiklyTabPreloadItem.resId;
        }
        if ((i16 & 2) != 0) {
            preloadType = kuiklyTabPreloadItem.type;
        }
        PreloadType preloadType2 = preloadType;
        if ((i16 & 4) != 0) {
            i3 = kuiklyTabPreloadItem.priority;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            j3 = kuiklyTabPreloadItem.downloadTimeGapMin;
        }
        return kuiklyTabPreloadItem.copy(str, preloadType2, i17, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final PreloadType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDownloadTimeGapMin() {
        return this.downloadTimeGapMin;
    }

    @NotNull
    public final KuiklyTabPreloadItem copy(@NotNull String resId, @NotNull PreloadType type, int priority, long downloadTimeGapMin) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(type, "type");
        return new KuiklyTabPreloadItem(resId, type, priority, downloadTimeGapMin);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KuiklyTabPreloadItem)) {
            return false;
        }
        KuiklyTabPreloadItem kuiklyTabPreloadItem = (KuiklyTabPreloadItem) other;
        if (Intrinsics.areEqual(this.resId, kuiklyTabPreloadItem.resId) && this.type == kuiklyTabPreloadItem.type && this.priority == kuiklyTabPreloadItem.priority && this.downloadTimeGapMin == kuiklyTabPreloadItem.downloadTimeGapMin) {
            return true;
        }
        return false;
    }

    public final long getDownloadTimeGapMin() {
        return this.downloadTimeGapMin;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final String getResId() {
        return this.resId;
    }

    @NotNull
    public final PreloadType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.resId.hashCode() * 31) + this.type.hashCode()) * 31) + this.priority) * 31) + androidx.fragment.app.a.a(this.downloadTimeGapMin);
    }

    @NotNull
    public String toString() {
        return "KuiklyTabPreloadItem(resId=" + this.resId + ", type=" + this.type + ", priority=" + this.priority + ", downloadTimeGapMin=" + this.downloadTimeGapMin + ')';
    }

    public /* synthetic */ KuiklyTabPreloadItem(String str, PreloadType preloadType, int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? PreloadType.PRE_DOWNLOAD : preloadType, (i16 & 4) != 0 ? 1 : i3, (i16 & 8) != 0 ? 30L : j3);
    }
}
