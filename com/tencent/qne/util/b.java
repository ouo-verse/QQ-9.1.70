package com.tencent.qne.util;

import android.os.SystemProperties;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qne/util/b;", "", "", "a", "b", "property", "c", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f344371a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15261);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f344371a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        r3 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r9, ':', 0, false, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r1, null);
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0088, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a() {
        ?? r36;
        Throwable th5;
        CharSequence trim;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            try {
                r36 = "UTF-8";
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8");
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    r36 = 0;
                                    break;
                                }
                                boolean z16 = true;
                                r36 = StringsKt__StringsJVMKt.startsWith(readLine, "Hardware", true);
                                if (r36 != 0 && r36 > 1) {
                                    String substring = readLine.substring(r36 + 1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                    if (substring == null) {
                                        break;
                                    }
                                    trim = StringsKt__StringsKt.trim((CharSequence) substring);
                                    r36 = StringsKt__StringsJVMKt.replace$default(trim.toString(), " ", "", false, 4, (Object) null);
                                    if (r36.length() <= 0) {
                                        z16 = false;
                                    }
                                    if (!z16) {
                                    }
                                }
                            } catch (Throwable th6) {
                                r36 = 0;
                                Throwable th7 = th6;
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                            try {
                                throw th5;
                            } catch (Throwable th9) {
                                CloseableKt.closeFinally(inputStreamReader, th5);
                                throw th9;
                            }
                        }
                    }
                } catch (Throwable th10) {
                    r36 = 0;
                    th5 = th10;
                }
            } catch (Throwable th11) {
                th = th11;
                Logger.e("[qne]HardwareUtil", "getCpuInfoHardware exception", th);
                String str = r36;
                return str;
            }
        } catch (Throwable th12) {
            r36 = 0;
            th = th12;
            Logger.e("[qne]HardwareUtil", "getCpuInfoHardware exception", th);
            String str2 = r36;
            return str2;
        }
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c(AVCoreSystemInfo.SOC_MODEL_KEY);
    }

    @Nullable
    public final String c(@NotNull String property) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) property);
        }
        Intrinsics.checkNotNullParameter(property, "property");
        try {
            return (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, property);
        } catch (Throwable unused) {
            return null;
        }
    }
}
