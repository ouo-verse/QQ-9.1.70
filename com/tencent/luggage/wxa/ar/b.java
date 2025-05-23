package com.tencent.luggage.wxa.ar;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f121613a;

    /* renamed from: b, reason: collision with root package name */
    public static String f121614b;

    /* JADX WARN: Removed duplicated region for block: B:5:0x00b5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String str;
        if (f121613a == null) {
            try {
                f121613a = Build.SUPPORTED_ABIS[0].toLowerCase();
            } catch (NoSuchFieldError e16) {
                x0.c("AbiUtil", "getDeviceAbi failed, Build.SUPPORTED_ABIS NoSuchFieldError:" + e16);
            } catch (Throwable th5) {
                x0.a("AbiUtil", "getDeviceAbi failed, Build.SUPPORTED_ABIS error", th5);
            }
            if (f121613a == null) {
                BufferedReader bufferedReader2 = null;
                try {
                    inputStreamReader = new InputStreamReader(((Process) com.tencent.luggage.wxa.ia.a.a(Runtime.getRuntime(), new com.tencent.luggage.wxa.ja.a().a("getprop ro.product.cpu.abi").a(), "com/tencent/xweb/util/AbiUtil", "getDeviceAbi", "()Ljava/lang/String;", "java/lang/Runtime", "exec", "(Ljava/lang/String;)Ljava/lang/Process;")).getInputStream());
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            f121613a = bufferedReader.readLine().toLowerCase();
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedReader2 = bufferedReader;
                            try {
                                x0.a("AbiUtil", "getDeviceAbi failed, error", th);
                                bufferedReader = bufferedReader2;
                                w.a(inputStreamReader);
                                w.a(bufferedReader);
                                x0.d("AbiUtil", "Device ABI: " + f121613a);
                                str = f121613a;
                                if (str != null) {
                                }
                            } catch (Throwable th7) {
                                w.a(inputStreamReader);
                                w.a(bufferedReader2);
                                throw th7;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    inputStreamReader = null;
                }
                w.a(inputStreamReader);
                w.a(bufferedReader);
            }
            x0.d("AbiUtil", "Device ABI: " + f121613a);
        }
        str = f121613a;
        if (str != null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String lowerCase;
        if (f121614b == null) {
            try {
                lowerCase = Build.CPU_ABI.toLowerCase();
            } catch (Throwable th5) {
                x0.a("AbiUtil", "get abi from cpu_abi failed, error", th5);
            }
            if (!"armeabi".equals(lowerCase) && !"armeabi-v7a".equals(lowerCase)) {
                if ("arm64-v8a".equals(lowerCase)) {
                    f121614b = "arm64-v8a";
                } else if (ResourceAttributes.HostArchValues.X86.equals(lowerCase)) {
                    f121614b = ResourceAttributes.HostArchValues.X86;
                } else if ("x86_64".equals(lowerCase)) {
                    f121614b = "x86_64";
                } else {
                    f121614b = lowerCase;
                }
                if (TextUtils.isEmpty(f121614b)) {
                    try {
                        String lowerCase2 = System.getProperty("os.arch").toLowerCase();
                        if (!ResourceAttributes.HostArchValues.X86.equals(lowerCase2) && !"i686".equals(lowerCase2) && !"i386".equals(lowerCase2) && !"ia32".equals(lowerCase2)) {
                            if (!"x64".equals(lowerCase2) && !"x86_64".equals(lowerCase2)) {
                                if (!"armv7l".equals(lowerCase2) && !"armeabi".equals(lowerCase2) && !"armeabi-v7a".equals(lowerCase2)) {
                                    if (!"aarch64".equals(lowerCase2) && !"armv8".equals(lowerCase2) && !ResourceAttributes.HostArchValues.ARM64.equals(lowerCase2)) {
                                        f121614b = "arch:" + lowerCase2;
                                    }
                                    if (d()) {
                                        f121614b = "arm64-v8a";
                                    } else {
                                        f121614b = "armeabi-v7a";
                                    }
                                }
                                f121614b = "armeabi-v7a";
                            }
                            if (d()) {
                                f121614b = "x86_64";
                            } else {
                                f121614b = ResourceAttributes.HostArchValues.X86;
                            }
                        }
                        f121614b = ResourceAttributes.HostArchValues.X86;
                    } catch (Throwable th6) {
                        x0.a("AbiUtil", "get abi from os.arch failed, error", th6);
                    }
                }
                if (!f121614b.equals("armeabi-v7a")) {
                    if (e()) {
                        f121614b = ResourceAttributes.HostArchValues.X86;
                    }
                } else if (f121614b.equals("arm64-v8a") && e()) {
                    f121614b = "x86_64";
                }
                x0.d("AbiUtil", "Runtime ABI: " + f121614b);
            }
            f121614b = "armeabi-v7a";
            if (TextUtils.isEmpty(f121614b)) {
            }
            if (!f121614b.equals("armeabi-v7a")) {
            }
            x0.d("AbiUtil", "Runtime ABI: " + f121614b);
        }
        return f121614b;
    }

    public static boolean c() {
        String b16 = b();
        if (!b16.equals("arm64-v8a") && !b16.equals("x86_64")) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        String a16 = a();
        if (!a16.equals("arm64-v8a") && !a16.equals("x86_64")) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        String a16 = a();
        if (!a16.equals(ResourceAttributes.HostArchValues.X86) && !a16.equals("x86_64")) {
            return false;
        }
        return true;
    }
}
