package com.tencent.localedit.fakenative.intercept;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/b;", "Lcom/tencent/localedit/fakenative/intercept/e;", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "", "url", Const.BUNDLE_KEY_REQUEST, "e", "", "getPriority", "<init>", "()V", "d", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class b extends e<WebResourceReq, WebResourceResp> {
    @Override // com.tencent.localedit.fakenative.intercept.e
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public WebResourceResp d(@Nullable String url, @Nullable WebResourceReq request) {
        boolean z16;
        String n3 = LocalEditSDK.INSTANCE.getCache().n(url);
        if (n3 == null) {
            return null;
        }
        if (n3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        x11.b.f446855a.d("MediaResourceInterceptor", Intrinsics.stringPlus("interceptResourceRequest url=", url));
        return w11.a.c(w11.a.f444159a, n3, 0L, null, 6, null);
    }

    @Override // com.tencent.localedit.fakenative.intercept.e
    public int getPriority() {
        return 2;
    }
}
