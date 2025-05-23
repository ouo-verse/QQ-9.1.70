package com.tencent.localedit.fakenative.localserver;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.fakenative.meta.ChunkImportRequestData;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.meta.ResourceRequestData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/n;", "Req", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/localedit/fakenative/meta/FileIORequestData;", "b", "(Ljava/lang/Object;)Lcom/tencent/localedit/fakenative/meta/FileIORequestData;", "Lcom/tencent/localedit/fakenative/meta/ResourceRequestData;", "a", "(Ljava/lang/Object;)Lcom/tencent/localedit/fakenative/meta/ResourceRequestData;", "Lcom/tencent/localedit/fakenative/meta/ChunkImportRequestData;", "c", "(Ljava/lang/Object;)Lcom/tencent/localedit/fakenative/meta/ChunkImportRequestData;", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface n<Req> {
    @NotNull
    ResourceRequestData a(Req request);

    @NotNull
    FileIORequestData b(Req request);

    @NotNull
    ChunkImportRequestData c(Req request);
}
