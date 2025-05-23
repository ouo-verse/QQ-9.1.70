package com.tencent.richframework.argus.node;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "T", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes25.dex */
final class ArgusNode$extra$2 extends Lambda implements Function0<ConcurrentHashMap<String, Object>> {
    public static final ArgusNode$extra$2 INSTANCE = new ArgusNode$extra$2();

    ArgusNode$extra$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ConcurrentHashMap<String, Object> invoke() {
        return new ConcurrentHashMap<>();
    }
}
