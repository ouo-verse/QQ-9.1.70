package com.tencent.rdelivery.reshub.core;

import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/f;", "Lcom/tencent/rdelivery/reshub/core/c;", "Lcom/tencent/rdelivery/reshub/api/e;", "", QzoneZipCacheHelper.DIR, "fileExtension", "e", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class f extends c {
    @Override // com.tencent.rdelivery.reshub.core.c
    @NotNull
    public String e(@NotNull com.tencent.rdelivery.reshub.api.e buildFilePath, @NotNull String dir, @NotNull String fileExtension) {
        String substringAfterLast$default;
        Intrinsics.checkParameterIsNotNull(buildFilePath, "$this$buildFilePath");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        Intrinsics.checkParameterIsNotNull(fileExtension, "fileExtension");
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(buildFilePath.g(), "/", (String) null, 2, (Object) null);
        return g(dir, substringAfterLast$default);
    }
}
