package com.tencent.qqnt.chats.core.adapter.factory;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0015\n\u0002\b\u0007\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u0017\u0010\u0006\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0005\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"", "a", "[I", "()[I", "DEFAULT_VIEW_TYPE", "b", "RECENT_LIST_VIEW_TYPE", "chats_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final int[] f354465a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final int[] f354466b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39270);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f354465a = new int[]{0};
            f354466b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        }
    }

    @NotNull
    public static final int[] a() {
        return f354465a;
    }

    @NotNull
    public static final int[] b() {
        return f354466b;
    }
}
