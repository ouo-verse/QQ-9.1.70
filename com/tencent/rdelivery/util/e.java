package com.tencent.rdelivery.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/util/e;", "", "", "input", "a", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f364656a = new e();

    e() {
    }

    @NotNull
    public final String a(@NotNull String input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] result = messageDigest.digest(bytes);
        StringBuilder sb5 = new StringBuilder();
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        for (byte b16 : result) {
            String hexString = Integer.toHexString(b16 & 255);
            Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(hex)");
            if (hexString.length() == 1) {
                sb5.append(0);
                sb5.append(hexString);
            } else {
                sb5.append(hexString);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "stringBuilder.toString()");
        return sb6;
    }
}
