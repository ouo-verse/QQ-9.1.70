package com.tencent.ecommerce.biz.consumer.xinghuan;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "", "onClickButton", "", "view", "Landroid/view/View;", "url", "", "onDownloadTaskStatusChange", "appId", "progress", "", "taskStatus", "onFollowOrSubscribeStatusChange", "followStatus", "subscribeStatus", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IGameEventListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IGameEventListener iGameEventListener, View view, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                iGameEventListener.onClickButton(view, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClickButton");
        }
    }

    void onClickButton(@NotNull View view, @Nullable String url);

    void onDownloadTaskStatusChange(@NotNull String appId, int progress, int taskStatus);

    void onFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus);
}
