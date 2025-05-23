package com.tencent.ecommerce.base.somanager.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "", "isPtsLiteSoReady", "", "loadPtsLiteSo", "", "callback", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECSoManager {
    boolean isPtsLiteSoReady();

    void loadPtsLiteSo(@NotNull IECLoadSoCallback callback);
}
