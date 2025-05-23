package com.tencent.qmethod.monitor.base.util;

import android.util.Base64;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/NetworkUtil;", "", "", "g", "", "data", "", "type", "f", "e", "", "param", "a", "b", "d", "c", "[B", "key", "iv", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static byte[] key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static byte[] iv;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkUtil f343513c = new NetworkUtil();

    NetworkUtil() {
    }

    private final byte[] e(byte[] data) {
        boolean z16;
        if (data.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        byte[] bytes = "PMonitor00000000".getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArr = new byte[16];
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[i3] = 0;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(bArr));
            return cipher.doFinal(data);
        } catch (Throwable th5) {
            o.d(com.tencent.qqmini.sdk.core.utils.NetworkUtil.TAG, "doFinal error", th5);
            return null;
        }
    }

    private final synchronized byte[] f(byte[] data, int type) {
        boolean z16;
        if (data.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        byte[] bArr = null;
        if (z16) {
            return null;
        }
        if (iv == null) {
            g();
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr2 = key;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            byte[] bArr3 = iv;
            if (bArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iv");
            }
            cipher.init(type, secretKeySpec, new IvParameterSpec(bArr3));
            bArr = cipher.doFinal(data);
        } catch (Throwable th5) {
            o.d(com.tencent.qqmini.sdk.core.utils.NetworkUtil.TAG, "doFinal error", th5);
        }
        return bArr;
    }

    private final void g() {
        String replace$default;
        IntRange intRange;
        int first;
        int last;
        replace$default = StringsKt__StringsJVMKt.replace$default(com.tencent.qmethod.monitor.a.f343451h.g().getAppKey(), "-", "", false, 4, (Object) null);
        if (replace$default.length() != 32 && (first = (intRange = new IntRange(replace$default.length(), 31)).getFirst()) <= (last = intRange.getLast())) {
            while (true) {
                replace$default = replace$default + "0";
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        if (replace$default != null) {
            String substring = replace$default.substring(0, 16);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            if (substring != null) {
                byte[] bytes = substring.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                key = bytes;
                String substring2 = replace$default.substring(16, 32);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                if (substring2 != null) {
                    byte[] bytes2 = substring2.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                    iv = bytes2;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String a(@NotNull String param) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        byte[] bytes = param.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] f16 = f(bytes, 1);
        if (f16 == null) {
            f16 = new byte[0];
        }
        String encodeToString = Base64.encodeToString(f16, 2);
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(\n \u2026 Base64.NO_WRAP\n        )");
        return encodeToString;
    }

    @NotNull
    public final String b(@NotNull byte[] param) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        byte[] f16 = f(param, 1);
        if (f16 == null) {
            f16 = new byte[0];
        }
        String encodeToString = Base64.encodeToString(f16, 2);
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(do\u2026Array(0), Base64.NO_WRAP)");
        return encodeToString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0018, code lost:
    
        r11 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default(r1, (java.lang.CharSequence) "", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) com.tencent.qmethod.monitor.base.util.NetworkUtil$a2bForBeacon$1.INSTANCE, 30, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(@NotNull String param) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(param, "param");
        byte[] bytes = param.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] e16 = e(bytes);
        if (e16 != null && joinToString$default != null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String upperCase = joinToString$default.toUpperCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            if (upperCase != null) {
                return upperCase;
            }
        }
        return "";
    }

    @NotNull
    public final String d(@NotNull String param) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        byte[] decode = Base64.decode(param, 2);
        Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(param, Base64.NO_WRAP)");
        byte[] f16 = f(decode, 2);
        if (f16 != null) {
            return new String(f16, Charsets.UTF_8);
        }
        return "";
    }
}
