package com.qzone.module.feedcomponent.util;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"clipStr", "", "maxLength", "", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class StringExtKt {
    public static final String clipStr(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            int i18 = i16 + 1;
            String substring = str.substring(i16, i18);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            i17 += new Regex("[\u4e00-\u9fa5]").matches(substring) ? 2 : 1;
            if (i17 > i3) {
                String substring2 = str.substring(0, i16);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring2 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            i16 = i18;
        }
        return str;
    }
}
