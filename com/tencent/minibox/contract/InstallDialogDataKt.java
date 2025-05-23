package com.tencent.minibox.contract;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"decodeUrl", "", "url", "encodeUrl", "MiniBoxDynamicApi_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class InstallDialogDataKt {
    @NotNull
    public static final String decodeUrl(@NotNull String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        try {
            String decode = URLDecoder.decode(url, "utf-8");
            Intrinsics.checkExpressionValueIsNotNull(decode, "URLDecoder.decode(url, \"utf-8\")");
            return decode;
        } catch (UnsupportedEncodingException unused) {
            return url;
        }
    }

    @NotNull
    public static final String encodeUrl(@NotNull String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        try {
            String encode = URLEncoder.encode(url, "utf-8");
            Intrinsics.checkExpressionValueIsNotNull(encode, "URLEncoder.encode(url, \"utf-8\")");
            return encode;
        } catch (UnsupportedEncodingException unused) {
            return url;
        }
    }
}
