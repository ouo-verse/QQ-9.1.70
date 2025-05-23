package com.tencent.mobileqq.qqexpand.flutter.router;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H&J@\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/router/a;", "", "", "a", "Landroid/net/Uri;", "pageUri", "", "urlParams", "exts", "", "b", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a {
    public abstract String a();

    public void b(Uri pageUri, Map<Object, ? extends Object> urlParams, Map<Object, ? extends Object> exts) {
        Intrinsics.checkNotNullParameter(pageUri, "pageUri");
    }
}
