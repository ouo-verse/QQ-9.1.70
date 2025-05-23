package com.tencent.mobileqq.reminder.db.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001b\u0010\u0004\u001a\u00020\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "Lkotlin/Lazy;", "()Ljava/lang/String;", "TAB_NAME", "qqreminder-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ReminderRecordKtKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f281038a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34917);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ReminderRecordKtKt$TAB_NAME$2.INSTANCE);
            f281038a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    @NotNull
    public static final String a() {
        return (String) f281038a.getValue();
    }
}
