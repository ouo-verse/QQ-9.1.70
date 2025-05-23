package com.tencent.mobileqq.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/data/GxhSuitItemData;", "", "", "toString", "", "hashCode", "other", "", "equals", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "number", "I", "getNumber", "()I", "setNumber", "(I)V", "isLongSeries", "Z", "()Z", "setLongSeries", "(Z)V", "id", "getId", "setId", "<init>", "(Ljava/lang/String;IZI)V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class GxhSuitItemData {
    private int id;
    private boolean isLongSeries;
    private int number;

    @NotNull
    private String url;

    public GxhSuitItemData(@NotNull String url, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.number = i3;
        this.isLongSeries = z16;
        this.id = i16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GxhSuitItemData)) {
            return false;
        }
        GxhSuitItemData gxhSuitItemData = (GxhSuitItemData) other;
        if (Intrinsics.areEqual(this.url, gxhSuitItemData.url) && this.number == gxhSuitItemData.number && this.isLongSeries == gxhSuitItemData.isLongSeries && this.id == gxhSuitItemData.id) {
            return true;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.url.hashCode() * 31) + this.number) * 31;
        boolean z16 = this.isLongSeries;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.id;
    }

    @NotNull
    public String toString() {
        return "GxhSuitItemData(url=" + this.url + ", number=" + this.number + ", isLongSeries=" + this.isLongSeries + ", id=" + this.id + ')';
    }
}
