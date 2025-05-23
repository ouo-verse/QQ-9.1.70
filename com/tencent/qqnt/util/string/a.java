package com.tencent.qqnt.util.string;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/util/string/a;", "", "", "inParam", "", "a", "str", "b", "", "Z", "init", "", "c", "[J", "CRCTable", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362984a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean init;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static long[] CRCTable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f362984a = new a();
            CRCTable = new long[256];
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long a(String inParam) {
        boolean z16;
        if (inParam != null) {
            if (inParam.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (!init) {
                    for (int i3 = 0; i3 < 256; i3++) {
                        long j3 = i3;
                        for (int i16 = 0; i16 < 8; i16++) {
                            if ((((int) j3) & 1) != 0) {
                                j3 = (j3 >> 1) ^ (-7661587058870466123L);
                            } else {
                                j3 >>= 1;
                            }
                        }
                        CRCTable[i3] = j3;
                    }
                    init = true;
                }
                int length = inParam.length();
                long j16 = -1;
                for (int i17 = 0; i17 < length; i17++) {
                    j16 = (j16 >> 8) ^ CRCTable[(inParam.charAt(i17) ^ ((int) j16)) & 255];
                }
                return j16;
            }
            return 0L;
        }
        return 0L;
    }

    @NotNull
    public final String b(@Nullable String str) {
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        long a16 = a(str);
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String l3 = Long.toString(a16, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return l3;
    }
}
