package com.tencent.qqnt.notification.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/notification/util/j;", "", "", "input", "", "a", "(Ljava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f359913a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45692);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f359913a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(@Nullable Long input) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) input);
        }
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (bVar.isDebugVersion() && !bVar.isPublicVersion()) {
            if (input == null) {
                return null;
            }
            return input.toString();
        }
        if (input == null) {
            return null;
        }
        String l3 = input.toString();
        StringBuffer stringBuffer = new StringBuffer(l3);
        int length = l3.length() - 4;
        int i3 = length - 4;
        if (length < 0) {
            length = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 < length) {
            stringBuffer.replace(i3, length, "*");
        }
        return stringBuffer.toString();
    }
}
