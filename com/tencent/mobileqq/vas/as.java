package com.tencent.mobileqq.vas;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/as;", "", "", "a", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final as f308653a = new as();

    as() {
    }

    @NotNull
    public final String a() {
        String replace$default;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        replace$default = StringsKt__StringsJVMKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        String lowerCase = replace$default.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
