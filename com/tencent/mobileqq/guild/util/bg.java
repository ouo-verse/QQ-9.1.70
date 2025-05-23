package com.tencent.mobileqq.guild.util;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bg;", "", "", "url", "Landroid/net/Uri;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bg {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bg f235465a = new bg();

    bg() {
    }

    @NotNull
    public final Uri a(@NotNull String url) {
        String replace$default;
        Intrinsics.checkNotNullParameter(url, "url");
        replace$default = StringsKt__StringsJVMKt.replace$default(url, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
        Uri parse = Uri.parse(replace$default);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url.replace(\"+\", \"%2B\"))");
        return parse;
    }
}
