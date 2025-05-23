package com.tencent.ecommerce.base.imageloader.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "", "downloadPagSo", "", "loadPagSo", "", "loadPagSoAsync", "resultBlock", "Lkotlin/Function1;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPagSoLoader {
    void downloadPagSo();

    boolean loadPagSo();

    void loadPagSoAsync(@NotNull Function1<? super Boolean, Unit> resultBlock);
}
