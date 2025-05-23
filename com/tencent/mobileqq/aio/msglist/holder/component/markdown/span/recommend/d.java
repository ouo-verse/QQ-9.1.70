package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.recommend;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/d;", "", "Landroid/net/Uri;", "src", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/b;", "e", "a", "Landroid/net/Uri;", "d", "()Landroid/net/Uri;", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "imageUrl", "c", ZPlanPublishSource.FROM_SCHEME, "Ljava/util/List;", "()Ljava/util/List;", "lineContentList", "<init>", "(Landroid/net/Uri;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Uri src;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scheme;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> lineContentList;

    public d(@NotNull Uri src) {
        Intrinsics.checkNotNullParameter(src, "src");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) src);
            return;
        }
        this.src = src;
        String queryParameter = src.getQueryParameter("leftImageUrl");
        this.imageUrl = queryParameter == null ? "" : queryParameter;
        String queryParameter2 = src.getQueryParameter(ZPlanPublishSource.FROM_SCHEME);
        this.scheme = queryParameter2 != null ? queryParameter2 : "";
        this.lineContentList = e(src);
    }

    private final List<b> e(Uri src) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < 4; i3++) {
            String queryParameter = src.getQueryParameter("icon" + i3);
            String str = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
            boolean booleanQueryParameter = src.getBooleanQueryParameter("iconDye" + i3, false);
            String queryParameter2 = src.getQueryParameter("text" + i3);
            if (queryParameter2 != null) {
                str = queryParameter2;
            }
            arrayList.add(new b(queryParameter, booleanQueryParameter, str));
        }
        return arrayList;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.imageUrl;
    }

    @NotNull
    public final List<b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lineContentList;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.scheme;
    }

    @NotNull
    public final Uri d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Uri) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.src;
    }
}
