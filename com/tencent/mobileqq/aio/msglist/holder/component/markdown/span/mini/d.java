package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0006\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/d;", "", "Landroid/net/Uri;", "src", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/b;", "b", "a", "Landroid/net/Uri;", "getSrc", "()Landroid/net/Uri;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/b;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/b;", "miniProfileContent", "<init>", "(Landroid/net/Uri;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Uri src;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b miniProfileContent;

    public d(@NotNull Uri src) {
        Intrinsics.checkNotNullParameter(src, "src");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) src);
        } else {
            this.src = src;
            this.miniProfileContent = b(src);
        }
    }

    private final b b(Uri src) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String queryParameter = src.getQueryParameter("title");
        if (queryParameter == null) {
            str = "";
        } else {
            str = queryParameter;
        }
        String queryParameter2 = src.getQueryParameter("desc");
        if (queryParameter2 == null) {
            str2 = "";
        } else {
            str2 = queryParameter2;
        }
        String queryParameter3 = src.getQueryParameter("tag1");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        String queryParameter4 = src.getQueryParameter("tag2");
        if (queryParameter4 == null) {
            queryParameter4 = "";
        }
        String queryParameter5 = src.getQueryParameter("tag3");
        if (queryParameter5 == null) {
            queryParameter5 = "";
        }
        if (TextUtils.isEmpty(queryParameter4)) {
            queryParameter4 = queryParameter5;
            queryParameter5 = "";
        }
        if (TextUtils.isEmpty(queryParameter3)) {
            str5 = queryParameter5;
            str3 = "";
            str4 = queryParameter4;
        } else {
            str3 = queryParameter5;
            str4 = queryParameter3;
            str5 = queryParameter4;
        }
        return new b(str, str4, str5, str3, str2);
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.miniProfileContent;
    }
}
