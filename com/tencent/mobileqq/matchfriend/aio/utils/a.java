package com.tencent.mobileqq.matchfriend.aio.utils;

import com.tencent.commonsdk.util.MD5Coding;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/utils/a;", "", "", "url", "a", "path", "prefix", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "QQ_STRANGER_CACHE", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f243984a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String QQ_STRANGER_CACHE = MobileQQ.sMobileQQ.getCacheDir().getAbsoluteFile() + "/stranger";

    a() {
    }

    private final String a(String url) {
        String sb5 = new StringBuilder(MD5Coding.encodeHexStr(url)).toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "sb.toString()");
        return sb5;
    }

    public final String b(String path, String url, String prefix) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String absolutePath = new File(path, prefix + a(url)).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(path, prefix + crea\u2026leName(url)).absolutePath");
        return absolutePath;
    }

    public final String c() {
        return QQ_STRANGER_CACHE;
    }
}
