package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import io.github.landerlyoung.jenny.NativeProxy;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentMD5Util;", "", "()V", "md5", "", "input", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentMD5Util {

    @NotNull
    public static final FilamentMD5Util INSTANCE = new FilamentMD5Util();

    FilamentMD5Util() {
    }

    @JvmStatic
    @NotNull
    public static final String md5(@NotNull String input) {
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
