package com.tencent.mobileqq.zplan.utils;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ByteArrayData;", "Ljava/io/Serializable;", "data", "", "timestampMillis", "", "([BJ)V", "getData", "()[B", "getTimestampMillis", "()J", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ByteArrayData implements Serializable {
    private final byte[] data;
    private final long timestampMillis;

    public ByteArrayData(byte[] data, long j3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.timestampMillis = j3;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }
}
