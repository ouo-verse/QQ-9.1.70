package com.tencent.qne.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "b", "a", "qne_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class Md5UtilKt {
    @Nullable
    public static final String a(@NotNull String str) {
        boolean z16;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                file = null;
            }
            if (file != null) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            byte[] digest = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(digest, "digest");
                            joinToString$default = ArraysKt___ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Md5UtilKt$fileMd5$1$2.INSTANCE, 30, (Object) null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            return joinToString$default;
                        }
                    }
                } finally {
                }
            } else {
                throw new IOException("File does not exist or is empty.");
            }
        } catch (Exception e16) {
            Logger.e("[qne]Md5Util", Intrinsics.stringPlus("MD5 file hash calculation failed for file: ", str), e16);
            return null;
        }
    }

    @NotNull
    public static final String b(@NotNull String str) {
        String padStart;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
            Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(1, hashBytes).toString(16)");
            padStart = StringsKt__StringsKt.padStart(bigInteger, 32, '0');
            return padStart;
        } catch (Throwable th5) {
            Logger.e("[qne]Md5Util", "MD5 hash calculation failed.", th5);
            return "";
        }
    }
}
