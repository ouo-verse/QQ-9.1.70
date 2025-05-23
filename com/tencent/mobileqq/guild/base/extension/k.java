package com.tencent.mobileqq.guild.base.extension;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Landroid/content/Intent;", "b", "", "a", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class k {
    public static final boolean a(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return df1.a.INSTANCE.b(intent);
    }

    @NotNull
    public static final Intent b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        df1.a.INSTANCE.d(intent);
        return intent;
    }

    @NotNull
    public static final Intent c(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        df1.e.f393672d.e(intent);
        return intent;
    }
}
