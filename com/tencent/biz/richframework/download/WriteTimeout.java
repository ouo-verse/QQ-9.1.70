package com.tencent.biz.richframework.download;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/download/WriteTimeout;", "", "time", "", "(I)V", "getTime", "()I", "setTime", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "download_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class WriteTimeout {
    private int time;

    public WriteTimeout(int i3) {
        this.time = i3;
    }

    public static /* synthetic */ WriteTimeout copy$default(WriteTimeout writeTimeout, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = writeTimeout.time;
        }
        return writeTimeout.copy(i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTime() {
        return this.time;
    }

    @NotNull
    public final WriteTimeout copy(int time) {
        return new WriteTimeout(time);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof WriteTimeout) || this.time != ((WriteTimeout) other).time) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.time;
    }

    public final void setTime(int i3) {
        this.time = i3;
    }

    @NotNull
    public String toString() {
        return "WriteTimeout(time=" + this.time + ")";
    }
}
