package com.tencent.localedit.fakenative.intercept;

import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/d;", "Lcom/tencent/localedit/fakenative/intercept/c;", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "Lu11/d;", "context", "<init>", "(Lu11/d;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class d extends c<WebResourceReq, WebResourceResp> {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d(@NotNull u11.d context) {
        super(r0, context);
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e[]{new b(), new CategoryResourceInterceptorImpl()});
    }
}
