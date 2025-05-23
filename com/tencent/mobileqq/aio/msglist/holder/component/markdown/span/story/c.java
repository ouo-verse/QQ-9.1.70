package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.story;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0006\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/c;", "", "Landroid/net/Uri;", "src", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/a;", "b", "a", "Landroid/net/Uri;", "getSrc", "()Landroid/net/Uri;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/a;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/a;", "storyCardContent", "<init>", "(Landroid/net/Uri;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Uri src;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a storyCardContent;

    public c(@NotNull Uri src) {
        Intrinsics.checkNotNullParameter(src, "src");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) src);
        } else {
            this.src = src;
            this.storyCardContent = b(src);
        }
    }

    private final a b(Uri src) {
        String queryParameter = src.getQueryParameter("text1");
        String str = "";
        if (queryParameter == null) {
            queryParameter = "";
        }
        String queryParameter2 = src.getQueryParameter("text2");
        if (queryParameter2 == null) {
            queryParameter2 = "";
        }
        String queryParameter3 = src.getQueryParameter("plot_id");
        if (queryParameter3 != null) {
            str = queryParameter3;
        }
        return new a(queryParameter, queryParameter2, str);
    }

    @NotNull
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.storyCardContent;
    }
}
