package com.squareup.wire;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0006\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0002\u001a\u0004\u0018\u0001H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"get", "T", "value", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Wire")
/* loaded from: classes3.dex */
public final class Wire {
    public static final <T> T get(@Nullable T t16, T t17) {
        if (t16 == null) {
            return t17;
        }
        return t16;
    }
}
