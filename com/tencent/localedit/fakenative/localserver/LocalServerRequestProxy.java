package com.tencent.localedit.fakenative.localserver;

import androidx.annotation.Keep;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.fakenative.meta.LocalServerResponse;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0017\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/LocalServerRequestProxy;", "Lcom/tencent/localedit/fakenative/localserver/a;", "Lcom/tencent/local_edit/andserver/http/b;", "", Const.BUNDLE_KEY_REQUEST, "", InnerWebView.API_UPLOAD_IMAGE, "Lcom/tencent/local_edit/andserver/http/h;", "loadFile", "fileStat", "loadDocs", "saveDocs", InnerWebView.API_DOWNLOAD_IMAGE, "chunkImport", "report", "", "checkSecurity", "host", "Lcom/tencent/localedit/fakenative/localserver/a;", "handler", "<init>", "(Lcom/tencent/localedit/fakenative/localserver/a;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class LocalServerRequestProxy extends a<com.tencent.local_edit.andserver.http.b> {

    @NotNull
    private a<com.tencent.local_edit.andserver.http.b> host;

    public LocalServerRequestProxy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LocalServerRequestProxy(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LocalServerRequestHandler() : aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{"//"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkSecurity(@NotNull com.tencent.local_edit.andserver.http.b request) {
        List split$default;
        Object last;
        Intrinsics.checkNotNullParameter(request, "request");
        List<String> d16 = com.tencent.localedit.a.d();
        String header = request.getHeader(TtmlNode.ATTR_TTS_ORIGIN);
        String str = "";
        if (header != null && split$default != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
            String str2 = (String) last;
            if (str2 != null) {
                str = str2;
            }
        }
        return d16.contains(str);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String chunkImport(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.chunkImport(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String downloadImage(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.downloadImage(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String fileStat(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.fileStat(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String loadDocs(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            x11.b.f446855a.a("Local_edit", "loadDocs checkSecurity unSupport");
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        x11.b bVar = x11.b.f446855a;
        bVar.a("Local_edit", "loadDocs start");
        String loadDocs = this.host.loadDocs(request);
        bVar.a("Local_edit", "loadDocs end");
        return loadDocs;
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public com.tencent.local_edit.andserver.http.h loadFile(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new l11.b(new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString());
        }
        return this.host.loadFile(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String report(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.report(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String saveDocs(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.saveDocs(request);
    }

    @Override // com.tencent.localedit.fakenative.localserver.a
    @NotNull
    public String uploadImage(@NotNull com.tencent.local_edit.andserver.http.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!checkSecurity(request)) {
            return new LocalServerResponse(23001, null, null, 0, 14, null).toJsonString();
        }
        return this.host.uploadImage(request);
    }

    public LocalServerRequestProxy(@NotNull a<com.tencent.local_edit.andserver.http.b> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.host = handler;
    }
}
