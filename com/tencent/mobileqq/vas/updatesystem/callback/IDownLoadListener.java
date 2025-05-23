package com.tencent.mobileqq.vas.updatesystem.callback;

import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "", "onLoadFail", "", "params", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "onLoadSuccess", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IDownLoadListener {
    void onLoadFail(@NotNull UpdateListenerParams params);

    void onLoadSuccess(@NotNull UpdateListenerParams params);
}
