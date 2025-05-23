package com.tencent.mobileqq.qwallet.setting;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/f;", "", "Landroid/content/Context;", "context", "", "b", "", "startType", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f279176a = new f();

    f() {
    }

    public final void a(@NotNull Context context, int startType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("qwallet_setting_start_type", startType);
        com.tencent.mobileqq.base.c.f(context, intent, QWalletSettingFragment.class, false, 8, null);
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.base.c.i(context, new Intent(), QWalletSettingFragment.class, 103, false, 16, null);
    }
}
