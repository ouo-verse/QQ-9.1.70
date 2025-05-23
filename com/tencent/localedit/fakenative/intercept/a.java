package com.tencent.localedit.fakenative.intercept;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/a;", "Lcom/tencent/localedit/fakenative/intercept/e;", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "", "url", Const.BUNDLE_KEY_REQUEST, "g", "", "getPriority", "offlineEnabledUrl", "i", "e", "f", "<init>", "()V", "d", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class a extends e<WebResourceReq, WebResourceResp> {
    @Nullable
    public abstract String e(@Nullable String url);

    @Nullable
    public abstract String f(@Nullable String url);

    @Override // com.tencent.localedit.fakenative.intercept.e
    @Nullable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public WebResourceResp d(@Nullable String url, @Nullable WebResourceReq request) {
        long j3;
        String i3 = i(e(url));
        if (i3 == null) {
            return null;
        }
        w11.a aVar = w11.a.f444159a;
        if (aVar.s(request)) {
            j3 = 2592000;
        } else {
            j3 = -1;
        }
        return aVar.b(i3, j3, f(i3));
    }

    @Override // com.tencent.localedit.fakenative.intercept.e
    public int getPriority() {
        return 1;
    }

    @Nullable
    public abstract String i(@Nullable String offlineEnabledUrl);
}
