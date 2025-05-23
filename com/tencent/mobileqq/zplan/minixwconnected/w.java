package com.tencent.mobileqq.zplan.minixwconnected;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"", "stringA", "stringB", "", "maxLength", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class w {
    public static final String a(String stringA, String stringB, int i3) {
        Intrinsics.checkNotNullParameter(stringA, "stringA");
        Intrinsics.checkNotNullParameter(stringB, "stringB");
        if (stringA.length() >= i3) {
            String substring = stringA.substring(0, 7);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            stringA = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return stringA + stringB;
    }

    public static /* synthetic */ String b(String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 10;
        }
        return a(str, str2, i3);
    }
}
