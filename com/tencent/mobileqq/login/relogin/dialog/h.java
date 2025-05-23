package com.tencent.mobileqq.login.relogin.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/h;", "", "Lcom/tencent/mobileqq/login/account/a;", "account", "", "b", "d", "a", "Lcom/tencent/mobileqq/login/relogin/dialog/y;", "dialog", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static void a(@NotNull h hVar, @NotNull y dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }
    }

    void a(@NotNull com.tencent.mobileqq.login.account.a account);

    void b(@NotNull com.tencent.mobileqq.login.account.a account);

    void c(@NotNull y dialog);

    void d(@NotNull com.tencent.mobileqq.login.account.a account);
}
