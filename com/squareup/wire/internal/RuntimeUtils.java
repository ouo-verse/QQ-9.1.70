package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0080\f\u00a8\u0006\u0005"}, d2 = {"and", "", "", "other", "shl", "wire-runtime"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "RuntimeUtils")
/* loaded from: classes3.dex */
public final class RuntimeUtils {
    public static final int and(byte b16, int i3) {
        return b16 & i3;
    }

    public static final int shl(byte b16, int i3) {
        return b16 << i3;
    }
}
