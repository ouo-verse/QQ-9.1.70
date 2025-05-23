package com.tencent.aio.base.sp;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/base/sp/a;", "", "Landroid/content/Context;", "context", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "value", "", "isApply", "", "b", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f69207a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f69207a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public final int a(@NotNull Context context, @NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, this, context, key, Integer.valueOf(defaultValue))).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return context.getSharedPreferences("aio_preferences", 0).getInt(key, defaultValue);
        } catch (Exception e16) {
            com.tencent.aio.base.log.a.f69187b.a("AIOSharePre", "getInt fail key=" + key, e16);
            return defaultValue;
        }
    }

    public final void b(@NotNull Context context, @NotNull String key, int value, boolean isApply) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, key, Integer.valueOf(value), Boolean.valueOf(isApply));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor edit = context.getSharedPreferences("aio_preferences", 0).edit();
        Intrinsics.checkNotNullExpressionValue(edit, "pre.edit()");
        try {
            edit.putInt(key, value);
            if (isApply) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Exception e16) {
            com.tencent.aio.base.log.a.f69187b.a("AIOSharePre", "setInt fail key=" + key, e16);
        }
    }
}
