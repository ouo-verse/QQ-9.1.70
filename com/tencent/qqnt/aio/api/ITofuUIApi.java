package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/ITofuUIApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDressShowBeancurdView", "Landroid/view/View;", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "getImageBeancurdView", "getMiniCardBeancurdView", "getMultiImageBeancurdView", "getOnlineStatusBeancurdNormalView", "getSystemNoticeBeancurdView", "getTextBeancurdView", "getVideoBeancurdView", "getWithBgTextBeancurdView", "getZPlanAvatarBeancurdView", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITofuUIApi extends QRouteApi {
    @Nullable
    View getDressShowBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getImageBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getMiniCardBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getMultiImageBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getOnlineStatusBeancurdNormalView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getSystemNoticeBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getTextBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getVideoBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getWithBgTextBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @Nullable
    View getZPlanAvatarBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem);
}
