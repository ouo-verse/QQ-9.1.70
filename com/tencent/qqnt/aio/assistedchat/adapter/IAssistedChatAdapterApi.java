package com.tencent.qqnt.aio.assistedchat.adapter;

import android.view.View;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "chatType", "", "isExperiment", "isReplySuggestionExperiment", "", "reportExpExposure", "Landroid/view/View;", "view", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "setDtReportPageInfo", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAssistedChatAdapterApi extends QRouteApi {
    boolean isExperiment(int chatType);

    boolean isReplySuggestionExperiment(int chatType);

    void reportExpExposure(int chatType);

    void setDtReportPageInfo(@NotNull View view, @NotNull a aioContext);
}
