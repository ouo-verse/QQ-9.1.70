package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.qzone.business.favorite.protocol.QzoneAddFavorRequest;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOFavApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", QzoneAddFavorRequest.CMD_STRING, "", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "selectedText", "", "multiFav", TabPreloadItem.TAB_NAME_MESSAGE, "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOFavApi extends QRouteApi {
    void addFav(@NotNull Context context, @NotNull AIOMsgItem msgItem, @Nullable CharSequence selectedText);

    void multiFav(@NotNull Context context, @NotNull List<? extends AIOMsgItem> msgList);
}
