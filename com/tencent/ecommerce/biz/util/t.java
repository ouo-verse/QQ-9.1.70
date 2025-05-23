package com.tencent.ecommerce.biz.util;

import android.text.TextUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/util/t;", "", "", "text", "", "maxLength", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f104882a = new t();

    t() {
    }

    public final String a(String text, int maxLength) {
        if (TextUtils.isEmpty(text)) {
            return text;
        }
        int length = text.length();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = text.charAt(i3);
            i16 += charAt >= '\u0080' ? 2 : 1;
            if (maxLength == i16 || (charAt > '\u0080' && maxLength + 1 == i16)) {
                i17 = i3;
            }
            i3++;
        }
        if (i16 < maxLength) {
            return text;
        }
        StringBuilder sb5 = new StringBuilder();
        int i18 = i17 + 1;
        if (text != null) {
            String substring = text.substring(0, i18);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            return sb5.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
