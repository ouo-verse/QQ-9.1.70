package com.tencent.mobileqq.qqlive.framework;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001a\u0010\f\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\u0001\u0010\u0004\"\u001a\u0010\r\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"", "a", "I", "d", "()I", "ROOT_PARENT_ID", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "PAGE_TAG", "MIN_TRIGGER_TIME_FOR_PRINT", "MIN_TRIGGER_TIME_FOR_TOTAL_PRINT", "qq-live-base-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f271222a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f271223b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f271224c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f271225d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f271222a = R.id.f58512q8;
        f271223b = "PageLogTag";
        f271224c = 1;
        f271225d = 3;
    }

    public static final int a() {
        return f271224c;
    }

    public static final int b() {
        return f271225d;
    }

    @NotNull
    public static final String c() {
        return f271223b;
    }

    public static final int d() {
        return f271222a;
    }
}
