package com.tencent.videocut.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/utils/d;", "", "", "argbColor", "", "c", "", "color", "d", "a", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f384234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384234a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        r3 = kotlin.text.StringsKt___StringsKt.firstOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean c(String argbColor) {
        Character firstOrNull;
        if ((argbColor.length() != 9 && argbColor.length() != 7) || firstOrNull == null || '#' != firstOrNull.charValue()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String a(@NotNull String color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) color);
        }
        Intrinsics.checkNotNullParameter(color, "color");
        if (c(color)) {
            com.tencent.videocut.utils.log.b.a("ColorUtils", "Unknown color");
            return "";
        }
        if (color.length() == 7) {
            StringBuilder sb5 = new StringBuilder();
            String substring = color.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            String substring2 = color.substring(1, 7);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring2);
            sb5.append("ff");
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        String substring3 = color.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        sb6.append(substring3);
        sb6.append(color.subSequence(3, 9));
        String substring4 = color.substring(1, 3);
        Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        sb6.append(substring4);
        return sb6.toString();
    }

    @NotNull
    public final String b(@NotNull String color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) color);
        }
        Intrinsics.checkNotNullParameter(color, "color");
        if (color.length() == 9) {
            StringBuilder sb5 = new StringBuilder();
            String substring = color.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            String substring2 = color.substring(7, 9);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring2);
            String substring3 = color.substring(1, 7);
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring3);
            return sb5.toString();
        }
        com.tencent.videocut.utils.log.b.a("ColorUtils", "Unknown color");
        return "";
    }

    @NotNull
    public final String d(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, color);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
