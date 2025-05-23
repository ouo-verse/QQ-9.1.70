package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.api.e;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/api/e;", "getPanelProvider", "", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "convertToNtEmoticon", "markFaceMessage", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "convertToNtMarkFaceMessage", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "source", "", "emoType", "", "openAIOEmoPanel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOEmoPanelApi extends QRouteApi {
    @Nullable
    Emoticon convertToNtEmoticon(@Nullable Object emoticon);

    @Nullable
    MarkFaceMessage convertToNtMarkFaceMessage(@Nullable Object markFaceMessage);

    @NotNull
    e getPanelProvider(@NotNull Context context);

    void openAIOEmoPanel(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String source, int emoType);
}
