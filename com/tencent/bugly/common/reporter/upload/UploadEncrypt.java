package com.tencent.bugly.common.reporter.upload;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/UploadEncrypt;", "", "()V", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class UploadEncrypt {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int IV_LENGTH = 16;
    private static final String VERSION = "v1";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/UploadEncrypt$Companion;", "", "()V", "IV_LENGTH", "", "VERSION", "", "createEncryptKey", "doResponseDecrypt", "", "response", "key", "doUploadEncrypt", Const.BUNDLE_KEY_REQUEST, "getEncryptVersion", "sha256", "input", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final byte[] sha256(String input) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                Charset charset = Charsets.UTF_8;
                if (input != null) {
                    byte[] bytes = input.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    return messageDigest.digest(bytes);
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        @JvmStatic
        @NotNull
        public final String createEncryptKey() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
            if (TextUtils.isEmpty(uuid)) {
                return "";
            }
            return new Regex("-").replace(uuid, "");
        }

        @JvmStatic
        @NotNull
        public final byte[] doResponseDecrypt(@NotNull byte[] response, @NotNull String key) {
            byte[] bArr;
            Intrinsics.checkParameterIsNotNull(response, "response");
            Intrinsics.checkParameterIsNotNull(key, "key");
            byte[] sha256 = sha256(key);
            if (sha256 != null) {
                bArr = Arrays.copyOf(sha256, 16);
                Intrinsics.checkExpressionValueIsNotNull(bArr, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                bArr = null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(sha256, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(bArr));
            byte[] doFinal = cipher.doFinal(response);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.doFinal(response)");
            return doFinal;
        }

        @JvmStatic
        @NotNull
        public final byte[] doUploadEncrypt(@NotNull byte[] request, @NotNull String key) {
            byte[] bArr;
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(key, "key");
            byte[] sha256 = sha256(key);
            if (sha256 != null) {
                bArr = Arrays.copyOf(sha256, 16);
                Intrinsics.checkExpressionValueIsNotNull(bArr, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                bArr = null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(sha256, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(bArr));
            byte[] doFinal = cipher.doFinal(request);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.doFinal(request)");
            return doFinal;
        }

        @JvmStatic
        @NotNull
        public final String getEncryptVersion() {
            return UploadEncrypt.VERSION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @NotNull
    public static final String createEncryptKey() {
        return INSTANCE.createEncryptKey();
    }

    @JvmStatic
    @NotNull
    public static final byte[] doResponseDecrypt(@NotNull byte[] bArr, @NotNull String str) {
        return INSTANCE.doResponseDecrypt(bArr, str);
    }

    @JvmStatic
    @NotNull
    public static final byte[] doUploadEncrypt(@NotNull byte[] bArr, @NotNull String str) {
        return INSTANCE.doUploadEncrypt(bArr, str);
    }

    @JvmStatic
    @NotNull
    public static final String getEncryptVersion() {
        return INSTANCE.getEncryptVersion();
    }
}
