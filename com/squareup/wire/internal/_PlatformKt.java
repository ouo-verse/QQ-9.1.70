package com.squareup.wire.internal;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0086\b\u001a1\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\rH\u0086\b*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015\u00a8\u0006\u0016"}, d2 = {"camelCase", "", HippyControllerProps.STRING, "upperCamel", "", "toUnmodifiableList", "", "T", "", "toUnmodifiableMap", "", "K", "V", "", "ObjectStreamException", "Ljava/io/ObjectStreamException;", "ProtocolException", "Ljava/net/ProtocolException;", "Serializable", "Ljava/io/Serializable;", "Throws", "Lkotlin/jvm/Throws;", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class _PlatformKt {
    @NotNull
    public static final String camelCase(@NotNull String string, boolean z16) {
        Intrinsics.checkNotNullParameter(string, "string");
        StringBuilder sb5 = new StringBuilder(string.length());
        int i3 = 0;
        while (i3 < string.length()) {
            int codePointAt = string.codePointAt(i3);
            i3 += Character.charCount(codePointAt);
            if (codePointAt == 95) {
                z16 = true;
            } else {
                if (z16 && 97 <= codePointAt && 122 >= codePointAt) {
                    codePointAt -= 32;
                }
                sb5.appendCodePoint(codePointAt);
                z16 = false;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb6;
    }

    public static /* synthetic */ String camelCase$default(String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return camelCase(str, z16);
    }

    @NotNull
    public static final <T> List<T> toUnmodifiableList(@NotNull List<T> toUnmodifiableList) {
        Intrinsics.checkNotNullParameter(toUnmodifiableList, "$this$toUnmodifiableList");
        List<T> unmodifiableList = Collections.unmodifiableList(toUnmodifiableList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(this)");
        return unmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> toUnmodifiableMap(@NotNull Map<K, V> toUnmodifiableMap) {
        Intrinsics.checkNotNullParameter(toUnmodifiableMap, "$this$toUnmodifiableMap");
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(toUnmodifiableMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(this)");
        return unmodifiableMap;
    }
}
