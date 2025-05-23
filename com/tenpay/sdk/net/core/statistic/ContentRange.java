package com.tenpay.sdk.net.core.statistic;

import androidx.fragment.app.a;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.http.common.HttpConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/ContentRange;", "", "fromPosition", "", "endPosition", "totalSize", "(JJJ)V", "getEndPosition", "()J", "setEndPosition", "(J)V", "getFromPosition", "setFromPosition", "getTotalSize", "setTotalSize", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class ContentRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ContentRange";
    private long endPosition;
    private long fromPosition;
    private long totalSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/ContentRange$Companion;", "", "()V", "TAG", "", "parseContentRange", "Lcom/tenpay/sdk/net/core/statistic/ContentRange;", "headers", "Lokhttp3/Headers;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ContentRange parseContentRange(@Nullable Headers headers) {
            String str;
            String str2;
            int indexOf$default;
            int indexOf$default2;
            int indexOf$default3;
            ContentRange contentRange = new ContentRange(0L, 0L, 0L, 7, null);
            if (headers != null && (str2 = headers.get(HttpConst.HEADER.CONTENT_RANGE.getValue())) != null) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, "bytes ", 0, false, 6, (Object) null);
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str2, "-", 0, false, 6, (Object) null);
                indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str2, "/", 0, false, 6, (Object) null);
                try {
                    String substring = str2.substring(indexOf$default + 6, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    contentRange.setFromPosition(Long.parseLong(substring));
                    String substring2 = str2.substring(indexOf$default2 + 1, indexOf$default3);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    contentRange.setEndPosition(Long.parseLong(substring2));
                    String substring3 = str2.substring(indexOf$default3 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                    contentRange.setTotalSize(Long.parseLong(substring3));
                } catch (Exception e16) {
                    ILogAgent.DefaultImpls.e$default(DLog.INSTANCE, ContentRange.TAG, "parseContentRange " + e16.getMessage(), null, 4, null);
                }
            } else if (headers != null && (str = headers.get(HttpConst.HEADER.CONTENT_LENGTH.getValue())) != null) {
                contentRange.setFromPosition(0L);
                contentRange.setTotalSize(Long.parseLong(str));
                contentRange.setEndPosition(contentRange.getTotalSize() - 1);
            }
            return contentRange;
        }

        Companion() {
        }
    }

    public ContentRange() {
        this(0L, 0L, 0L, 7, null);
    }

    public static /* synthetic */ ContentRange copy$default(ContentRange contentRange, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = contentRange.fromPosition;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = contentRange.endPosition;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = contentRange.totalSize;
        }
        return contentRange.copy(j18, j19, j17);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFromPosition() {
        return this.fromPosition;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndPosition() {
        return this.endPosition;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotalSize() {
        return this.totalSize;
    }

    @NotNull
    public final ContentRange copy(long fromPosition, long endPosition, long totalSize) {
        return new ContentRange(fromPosition, endPosition, totalSize);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentRange)) {
            return false;
        }
        ContentRange contentRange = (ContentRange) other;
        if (this.fromPosition == contentRange.fromPosition && this.endPosition == contentRange.endPosition && this.totalSize == contentRange.totalSize) {
            return true;
        }
        return false;
    }

    public final long getEndPosition() {
        return this.endPosition;
    }

    public final long getFromPosition() {
        return this.fromPosition;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        return (((a.a(this.fromPosition) * 31) + a.a(this.endPosition)) * 31) + a.a(this.totalSize);
    }

    public final void setEndPosition(long j3) {
        this.endPosition = j3;
    }

    public final void setFromPosition(long j3) {
        this.fromPosition = j3;
    }

    public final void setTotalSize(long j3) {
        this.totalSize = j3;
    }

    @NotNull
    public String toString() {
        return "ContentRange(fromPosition=" + this.fromPosition + ", endPosition=" + this.endPosition + ", totalSize=" + this.totalSize + ")";
    }

    public ContentRange(long j3, long j16, long j17) {
        this.fromPosition = j3;
        this.endPosition = j16;
        this.totalSize = j17;
    }

    public /* synthetic */ ContentRange(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) != 0 ? -1L : j16, (i3 & 4) != 0 ? -1L : j17);
    }
}
