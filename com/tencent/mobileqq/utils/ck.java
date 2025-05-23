package com.tencent.mobileqq.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/utils/ck;", "", "", "b", "a", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ck {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ck f307533a = new ck();

    ck() {
    }

    public final boolean a() {
        boolean contains$default;
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ProcessConstant.MINI_BOX_CORE, false, 2, (Object) null);
        return contains$default;
    }

    public final boolean b() {
        boolean contains$default;
        boolean contains$default2;
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ":wxa_container", false, 2, (Object) null);
        if (!contains$default) {
            String processName2 = MobileQQ.processName;
            Intrinsics.checkNotNullExpressionValue(processName2, "processName");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) processName2, (CharSequence) "com.tencent.ilink.ServiceProcess", false, 2, (Object) null);
            if (!contains$default2) {
                return false;
            }
        }
        return true;
    }
}
