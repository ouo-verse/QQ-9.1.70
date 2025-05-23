package com.tencent.kuikly.core.render.android.expand.module;

import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import d01.w;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tj\u0004\u0018\u0001`\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/e;", "Li01/e;", "", "params", "a", "c", "i", "j", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "d", "input", "g", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class e extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/e$a;", "", "", "params", "a", "METHOD_BASE64_DECODE", "Ljava/lang/String;", "METHOD_BASE64_ENCODE", "METHOD_MD5", "METHOD_SHA256", "METHOD_URL_DECODE", "METHOD_URL_ENCODE", "MODULE_NAME", "TAG", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.e$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String a(@Nullable String params) {
            String padStart;
            if (params != null) {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bytes = params.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
                Intrinsics.checkNotNullExpressionValue(bigInteger, "bigInt.toString(16)");
                padStart = StringsKt__StringsKt.padStart(bigInteger, 32, '0');
                return padStart;
            }
            return "";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String a(String params) {
        if (params != null) {
            byte[] decode = Base64.decode(params, 2);
            Intrinsics.checkNotNullExpressionValue(decode, "Base64.decode(string, Base64.NO_WRAP)");
            return new String(decode, Charsets.UTF_8);
        }
        return "";
    }

    private final String c(String params) {
        if (params != null) {
            byte[] bytes = params.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(st\u2026eArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
        return "";
    }

    private final String i(String params) {
        if (params != null) {
            String decode = URLDecoder.decode(params);
            Intrinsics.checkNotNullExpressionValue(decode, "URLDecoder.decode(string)");
            return decode;
        }
        return "";
    }

    private final String j(String params) {
        if (params != null) {
            String encode = URLEncoder.encode(params);
            Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(string)");
            return encode;
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1162763235:
                if (method.equals("base64Decode")) {
                    return a(params);
                }
                return super.call(method, params, callback);
            case -1125822395:
                if (method.equals("base64Encode")) {
                    return c(params);
                }
                return super.call(method, params, callback);
            case -903629273:
                if (method.equals("sha256")) {
                    if (!(params instanceof String)) {
                        params = null;
                    }
                    if (params == null) {
                        params = "";
                    }
                    return g(params);
                }
                return super.call(method, params, callback);
            case -797625283:
                if (method.equals("urlDecode")) {
                    return i(params);
                }
                return super.call(method, params, callback);
            case -760684443:
                if (method.equals("urlEncode")) {
                    return j(params);
                }
                return super.call(method, params, callback);
            case 107902:
                if (method.equals("md5")) {
                    return d(params);
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @NotNull
    public final String d(@Nullable String params) {
        return INSTANCE.a(params);
    }

    @NotNull
    public final String g(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            byte[] bytes = input.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    sb5.append('0');
                }
                sb5.append(hexString);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "hexString.toString()");
            return sb6;
        } catch (Throwable th5) {
            w.f392617a.b("KRCodecModule", "SHA-256 algorithm not found: " + th5);
            return "";
        }
    }
}
