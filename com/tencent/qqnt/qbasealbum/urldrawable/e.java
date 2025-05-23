package com.tencent.qqnt.qbasealbum.urldrawable;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/e;", "", "", "buffer", "", "a", "", "b", "[J", "sCrcTable", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f361612a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final long[] sCrcTable;

    static {
        long j3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f361612a = new e();
        sCrcTable = new long[256];
        for (int i3 = 0; i3 < 256; i3++) {
            long j16 = i3;
            for (int i16 = 0; i16 < 8; i16++) {
                if ((((int) j16) & 1) != 0) {
                    j3 = -7661587058870466123L;
                } else {
                    j3 = 0;
                }
                j16 = (j16 >> 1) ^ j3;
            }
            sCrcTable[i3] = j16;
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final long a(@NotNull byte[] buffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) buffer)).longValue();
        }
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        long j3 = -1;
        for (byte b16 : buffer) {
            j3 = (j3 ^ sCrcTable[(((int) j3) ^ b16) & 255]) >> 8;
        }
        return j3;
    }
}
