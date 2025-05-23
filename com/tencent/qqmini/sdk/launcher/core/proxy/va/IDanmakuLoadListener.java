package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/IDanmakuLoadListener;", "", "onGetDanmakuList", "", "isSuccess", "", "danmakuList", "", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/TipsData;", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface IDanmakuLoadListener {
    void onGetDanmakuList(boolean isSuccess, @NotNull List<TipsData> danmakuList);
}
