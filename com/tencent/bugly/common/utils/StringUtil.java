package com.tencent.bugly.common.utils;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/bugly/common/utils/StringUtil;", "", "()V", "TAG", "", "digits", "", "bytes2HexStr", "bytes", "", "encode", "value", "getMD5", "source", "isNullOrNil", "", "str", "nullAsNil", "parseHex", "", "valueStr", "replaceBlank", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class StringUtil {

    @NotNull
    public static final String TAG = "RMonitor_common_StringUtil";
    public static final StringUtil INSTANCE = new StringUtil();
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    StringUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String bytes2HexStr(@Nullable byte[] bytes) {
        boolean z16;
        if (bytes != null) {
            if (bytes.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                char[] cArr = new char[bytes.length * 2];
                int length = bytes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    byte b16 = bytes[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = digits;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                }
                return new String(cArr);
            }
            return "";
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final String encode(@NotNull String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        try {
            String encode = URLEncoder.encode(value, "UTF-8");
            Intrinsics.checkExpressionValueIsNotNull(encode, "URLEncoder.encode(value, \"UTF-8\")");
            return encode;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String getMD5(@Nullable String source) {
        if (source == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bytes = source.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            return bytes2HexStr(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JvmStatic
    public static final boolean isNullOrNil(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final String nullAsNil(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    @JvmStatic
    public static final long parseHex(@NotNull String valueStr) {
        Intrinsics.checkParameterIsNotNull(valueStr, "valueStr");
        try {
            return Long.parseLong(valueStr, 16);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @JvmStatic
    @NotNull
    public static final String replaceBlank(@Nullable String str) {
        if (str == null) {
            return "";
        }
        String replaceAll = Pattern.compile("[\t\r\n]").matcher(str).replaceAll("");
        Intrinsics.checkExpressionValueIsNotNull(replaceAll, "m.replaceAll(\"\")");
        return replaceAll;
    }
}
