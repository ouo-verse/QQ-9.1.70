package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/data/InterPlaceholderInfo;", "", "url", "", "dpi", "Lcom/tencent/state/template/data/Dpi;", "(Ljava/lang/String;Lcom/tencent/state/template/data/Dpi;)V", "getDpi", "()Lcom/tencent/state/template/data/Dpi;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InterPlaceholderInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dpi dpi;
    private final String url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/InterPlaceholderInfo$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InterPlaceholderInfo(String url, Dpi dpi) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dpi, "dpi");
        this.url = url;
        this.dpi = dpi;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final Dpi getDpi() {
        return this.dpi;
    }

    public final InterPlaceholderInfo copy(String url, Dpi dpi) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dpi, "dpi");
        return new InterPlaceholderInfo(url, dpi);
    }

    public final Dpi getDpi() {
        return this.dpi;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Dpi dpi = this.dpi;
        return hashCode + (dpi != null ? dpi.hashCode() : 0);
    }

    public String toString() {
        return "InterPlaceholderInfo(url=" + this.url + ", dpi=" + this.dpi + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterPlaceholderInfo)) {
            return false;
        }
        InterPlaceholderInfo interPlaceholderInfo = (InterPlaceholderInfo) other;
        return Intrinsics.areEqual(this.url, interPlaceholderInfo.url) && Intrinsics.areEqual(this.dpi, interPlaceholderInfo.dpi);
    }

    public static /* synthetic */ InterPlaceholderInfo copy$default(InterPlaceholderInfo interPlaceholderInfo, String str, Dpi dpi, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interPlaceholderInfo.url;
        }
        if ((i3 & 2) != 0) {
            dpi = interPlaceholderInfo.dpi;
        }
        return interPlaceholderInfo.copy(str, dpi);
    }
}
