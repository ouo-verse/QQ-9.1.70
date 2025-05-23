package com.tencent.cachedrawable.dynamicdrawable.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/utils/e;", "", "", "dirStr", "", "a", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f99063a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f99063a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable String dirStr) {
        boolean z16;
        boolean z17;
        int length;
        int i3;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dirStr);
            return;
        }
        if (dirStr != null) {
            int length2 = dirStr.length() - 1;
            int i16 = 0;
            int i17 = 0;
            boolean z19 = false;
            while (i17 <= length2) {
                if (!z19) {
                    i3 = i17;
                } else {
                    i3 = length2;
                }
                if (Intrinsics.compare((int) dirStr.charAt(i3), 32) <= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z19) {
                    if (!z18) {
                        z19 = true;
                    } else {
                        i17++;
                    }
                } else if (!z18) {
                    break;
                } else {
                    length2--;
                }
            }
            if (dirStr.subSequence(i17, length2 + 1).toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                File file = new File(dirStr);
                if (!file.exists()) {
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if ((true ^ z17) && listFiles.length - 1 >= 0) {
                        while (true) {
                            int i18 = i16 + 1;
                            if (listFiles[i16].isDirectory()) {
                                a(listFiles[i16].getAbsolutePath());
                            } else {
                                listFiles[i16].delete();
                            }
                            if (i18 > length) {
                                break;
                            } else {
                                i16 = i18;
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }
}
