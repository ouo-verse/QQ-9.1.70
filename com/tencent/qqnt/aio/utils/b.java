package com.tencent.qqnt.aio.utils;

import android.os.Bundle;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/utils/b;", "", "", "str", "c", "", WidgetCacheConstellationData.NUM, "b", "Landroid/os/Bundle;", "bundle", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f352292a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f352292a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Deprecated(message = "\u8bf7\u4f7f\u7528 com.tencent.util.SensitiveLogUtil", replaceWith = @ReplaceWith(expression = "SensitiveLogUtil.filterSensitiveInfo(bundle)", imports = {"com.tencent.util.SensitiveLogUtil"}))
    @JvmStatic
    @NotNull
    public static final String a(@Nullable Bundle bundle) {
        return com.tencent.util.k.a(bundle);
    }

    @Deprecated(message = "\u8bf7\u4f7f\u7528 com.tencent.util.SensitiveLogUtil", replaceWith = @ReplaceWith(expression = "SensitiveLogUtil.filterSensitiveInfo(num)", imports = {"com.tencent.util.SensitiveLogUtil"}))
    @JvmStatic
    @NotNull
    public static final String b(@Nullable Number num) {
        return com.tencent.util.k.b(num);
    }

    @Deprecated(message = "\u8bf7\u4f7f\u7528 com.tencent.util.SensitiveLogUtil", replaceWith = @ReplaceWith(expression = "SensitiveLogUtil.filterSensitiveInfo(str)", imports = {"com.tencent.util.SensitiveLogUtil"}))
    @JvmStatic
    @NotNull
    public static final String c(@Nullable String str) {
        return com.tencent.util.k.d(str);
    }
}
