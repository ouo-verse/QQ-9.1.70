package com.tencent.mobileqq.qwallet.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.utils.IOUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/c;", "", "", "e", "", "d", "c", "b", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f279254a = new c();

    c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r5 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r11, ':', 0, false, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a() {
        InputStreamReader inputStreamReader;
        Throwable th5;
        boolean startsWith$default;
        int indexOf$default;
        int i3;
        boolean z16;
        String str = "";
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8");
        } catch (Throwable th6) {
            inputStreamReader = null;
            th5 = th6;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                boolean z17 = false;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(readLine, "Hardware", false, 2, null);
                if (startsWith$default && indexOf$default > 1) {
                    String substring = readLine.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    int length = substring.length() - 1;
                    int i16 = 0;
                    boolean z18 = false;
                    while (i16 <= length) {
                        if (!z18) {
                            i3 = i16;
                        } else {
                            i3 = length;
                        }
                        if (Intrinsics.compare((int) substring.charAt(i3), 32) <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z18) {
                            if (!z16) {
                                z18 = true;
                            } else {
                                i16++;
                            }
                        } else {
                            if (!z16) {
                                break;
                            }
                            length--;
                        }
                    }
                    str = StringsKt__StringsJVMKt.replace$default(substring.subSequence(i16, length + 1).toString(), " ", "", false, 4, (Object) null);
                    if (str.length() > 0) {
                        z17 = true;
                    }
                    if (z17) {
                        break;
                    }
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            try {
                QLog.w("QWallet.Pet.DeviceUtils", 1, "getCpuBrand error", th5);
                IOUtils.INSTANCE.closeSilently(inputStreamReader);
                if (!TextUtils.isEmpty(str)) {
                }
            } catch (Throwable th8) {
                IOUtils.INSTANCE.closeSilently(inputStreamReader);
                throw th8;
            }
        }
        IOUtils.INSTANCE.closeSilently(inputStreamReader);
        if (!TextUtils.isEmpty(str)) {
            return "Unknown";
        }
        return str;
    }

    public final int b() {
        return ah.n();
    }

    public final int c() {
        return (int) (ah.m() / 1024);
    }

    public final int d() {
        return (int) Math.ceil(((float) com.tencent.mobileqq.utils.m.c()) / 1048576);
    }

    @NotNull
    public final String e() {
        String s16 = ah.s();
        Intrinsics.checkNotNullExpressionValue(s16, "getDeviceModel()");
        return s16;
    }
}
