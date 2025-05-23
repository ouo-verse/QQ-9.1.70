package com.tencent.mobileqq.aio.msg.template;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/IPositionMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bindPositionMsgView", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "metaJson", "", "createPositionMsgView", "isPositionMsg", "", "appName", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IPositionMsgApi extends QRouteApi {
    void bindPositionMsgView(@Nullable Context context, @NotNull View view, @NotNull String metaJson);

    @NotNull
    View createPositionMsgView(@NotNull Context context);

    boolean isPositionMsg(@Nullable String appName);
}
