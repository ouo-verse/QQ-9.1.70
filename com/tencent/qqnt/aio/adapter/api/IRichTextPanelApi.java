package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.api.e;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IRichTextPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/api/e;", "getPanelProvider", "", "getZhituConfigState", "getEmojiPanelProvider", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IRichTextPanelApi extends QRouteApi {
    @NotNull
    e getEmojiPanelProvider(@NotNull Context context);

    @NotNull
    e getPanelProvider(@NotNull Context context);

    boolean getZhituConfigState();
}
