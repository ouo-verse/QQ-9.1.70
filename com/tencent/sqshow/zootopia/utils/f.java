package com.tencent.sqshow.zootopia.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/f;", "", "", "date", "", "format", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f373268a = new f();

    f() {
    }

    public final String a(long date, String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String format2 = new SimpleDateFormat(format, Locale.getDefault()).format(new Date(date));
        Intrinsics.checkNotNullExpressionValue(format2, "sbf.format(time)");
        return format2;
    }
}
