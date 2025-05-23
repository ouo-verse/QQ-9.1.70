package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/api/SquareMiniAioMultiSelectedRecord;", "", "uin", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SquareMiniAioMultiSelectedRecord {
    private final int type;

    @NotNull
    private final String uin;

    public SquareMiniAioMultiSelectedRecord(@NotNull String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.type = i3;
    }

    public static /* synthetic */ SquareMiniAioMultiSelectedRecord copy$default(SquareMiniAioMultiSelectedRecord squareMiniAioMultiSelectedRecord, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = squareMiniAioMultiSelectedRecord.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = squareMiniAioMultiSelectedRecord.type;
        }
        return squareMiniAioMultiSelectedRecord.copy(str, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final SquareMiniAioMultiSelectedRecord copy(@NotNull String uin, int type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new SquareMiniAioMultiSelectedRecord(uin, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareMiniAioMultiSelectedRecord) {
                SquareMiniAioMultiSelectedRecord squareMiniAioMultiSelectedRecord = (SquareMiniAioMultiSelectedRecord) other;
                if (!Intrinsics.areEqual(this.uin, squareMiniAioMultiSelectedRecord.uin) || this.type != squareMiniAioMultiSelectedRecord.type) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        String str = this.uin;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "SquareMiniAioMultiSelectedRecord(uin=" + this.uin + ", type=" + this.type + ")";
    }
}
