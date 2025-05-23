package com.tencent.ecommerce.base.network.api;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "", "downloadFileAsync", "", "src", "", "file", "Ljava/io/File;", "resultBlock", "Lkotlin/Function1;", "", "downloadFileSync", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECHttpDownloader {
    void downloadFileAsync(@NotNull String src, @NotNull File file, @NotNull Function1<? super Boolean, Unit> resultBlock);

    boolean downloadFileSync(@NotNull String src, @NotNull File file);
}
