package com.tencent.videocut.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/videocut/utils/f;", "", "", "str", "c", "", "b", "a", "Ljava/lang/String;", "mDevicesModel", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String mDevicesModel;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f f384238b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384238b = new f();
            mDevicesModel = "";
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    private final String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String replaceAll = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "m.replaceAll(\"\")");
        return replaceAll;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        for (String str : Build.SUPPORTED_64_BIT_ABIS) {
            com.tencent.videocut.utils.log.b.d("DeviceUtils", "cpubits : " + str);
            if (TextUtils.equals(str, "arm64-v8a")) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(q.f384265d.a("ro.miui.ui.version.name"))) {
            return true;
        }
        String str = Build.MANUFACTURER;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "Build.MANUFACTURER");
            String c16 = c(str);
            if (!TextUtils.isEmpty(c16)) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                if (c16 != null) {
                    String lowerCase = c16.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!TextUtils.isEmpty(lowerCase)) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "xiaomi", false, 2, (Object) null);
                        if (contains$default) {
                            return true;
                        }
                    }
                    return false;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return false;
    }
}
