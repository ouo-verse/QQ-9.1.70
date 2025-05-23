package com.tencent.mobileqq.wink.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ak;", "", "", "b", "", "c", "encryptedString", "algorithm", "transformation", "key", "a", "content", "", "[C", "hexChar", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ak f326673a = new ak();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    ak() {
    }

    private final String c(byte[] b16) {
        StringBuilder sb5 = new StringBuilder(b16.length * 2);
        for (byte b17 : b16) {
            char[] cArr = hexChar;
            sb5.append(cArr[(b17 & 240) >>> 4]);
            sb5.append(cArr[b17 & RegisterType.DOUBLE_HI]);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @Nullable
    public final String a(@NotNull String encryptedString, @NotNull String algorithm, @NotNull String transformation, @NotNull String key) {
        Intrinsics.checkNotNullParameter(encryptedString, "encryptedString");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            byte[] decode = Base64.decode(encryptedString, 0);
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, algorithm);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(2, secretKeySpec);
            byte[] decryptedByteArray = cipher.doFinal(decode);
            int length = decryptedByteArray.length;
            for (int length2 = decryptedByteArray.length - 1; -1 < length2 && decryptedByteArray[length2] == 0; length2--) {
                length--;
            }
            Intrinsics.checkNotNullExpressionValue(decryptedByteArray, "decryptedByteArray");
            return new String(decryptedByteArray, 0, length, Charsets.UTF_8);
        } catch (Throwable th5) {
            w53.b.c("WinkCryptoUtils", "decrypt failed: " + th5);
            return null;
        }
    }

    @NotNull
    public final String b(@NotNull String content) {
        byte[] digest;
        Intrinsics.checkNotNullParameter(content, "content");
        if (!TextUtils.isEmpty(content)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Charset charset = Charsets.UTF_8;
                byte[] bytes = content.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] bytes2 = content.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes, 0, bytes2.length);
                digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "sha1.digest()");
            } catch (Exception unused) {
                return "";
            }
        }
        return c(digest);
    }
}
