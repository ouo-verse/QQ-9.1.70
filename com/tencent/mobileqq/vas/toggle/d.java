package com.tencent.mobileqq.vas.toggle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/d;", "Lcom/tencent/mobileqq/vas/toggle/a;", "", "title", "", "b", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d implements a {
    @Override // com.tencent.mobileqq.vas.toggle.a
    public boolean a(@NotNull String title, boolean b16) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new UnitedProxy(title).isEnable(b16);
    }
}
