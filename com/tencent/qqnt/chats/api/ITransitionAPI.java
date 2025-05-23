package com.tencent.qqnt.chats.api;

import android.view.View;
import androidx.core.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/api/ITransitionAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addViewToTransitionPool", "", "view", "Landroid/view/View;", "tag", "", "getViewToTransitionPool", "Landroidx/core/util/Pair;", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface ITransitionAPI extends QRouteApi {
    void addViewToTransitionPool(@NotNull View view, @NotNull String tag);

    @Nullable
    Pair<View, String> getViewToTransitionPool(@NotNull String tag);
}
