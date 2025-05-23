package com.tencent.qqnt.util.permission;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.util.permission.impl.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/util/permission/a;", "", "Landroid/content/Context;", "context", "", "", "perms", "", "a", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Lcom/tencent/qqnt/util/permission/impl/b;", "b", "Lcom/tencent/qqnt/util/permission/impl/b;", "permissionImpl", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362982a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b permissionImpl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f362982a = new a();
            permissionImpl = new b();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable Context context, @NotNull String... perms) {
        Intrinsics.checkNotNullParameter(perms, "perms");
        return permissionImpl.a(context, (String[]) Arrays.copyOf(perms, perms.length));
    }
}
