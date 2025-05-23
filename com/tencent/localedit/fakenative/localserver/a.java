package com.tencent.localedit.fakenative.localserver;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/a;", "Req", "", Const.BUNDLE_KEY_REQUEST, "", InnerWebView.API_UPLOAD_IMAGE, "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/tencent/local_edit/andserver/http/h;", "loadFile", "(Ljava/lang/Object;)Lcom/tencent/local_edit/andserver/http/h;", InnerWebView.API_DOWNLOAD_IMAGE, "fileStat", "loadDocs", "saveDocs", "chunkImport", "report", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class a<Req> {
    @NotNull
    public abstract String chunkImport(Req request);

    @NotNull
    public abstract String downloadImage(Req request);

    @NotNull
    public abstract String fileStat(Req request);

    @NotNull
    public abstract String loadDocs(Req request);

    @NotNull
    public abstract com.tencent.local_edit.andserver.http.h loadFile(Req request);

    @NotNull
    public abstract String report(Req request);

    @NotNull
    public abstract String saveDocs(Req request);

    @NotNull
    public abstract String uploadImage(Req request);
}
