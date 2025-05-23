package com.tencent.filament.zplanservice.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplanservice/util/g;", "", "", "input", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f106447a = new g();

    g() {
    }

    @NotNull
    public final String a(@NotNull String input) {
        String padStart;
        Intrinsics.checkNotNullParameter(input, "input");
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(1, md.digest(\u2026yteArray())).toString(16)");
        padStart = StringsKt__StringsKt.padStart(bigInteger, 32, '0');
        return padStart;
    }
}
