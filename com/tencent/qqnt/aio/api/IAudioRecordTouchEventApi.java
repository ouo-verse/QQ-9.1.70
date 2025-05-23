package com.tencent.qqnt.aio.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAudioRecordTouchEventApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", "recordButton", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "setTouchEvent", "destroy", "setPauseEvent", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAudioRecordTouchEventApi extends QRouteApi {
    void destroy();

    void setPauseEvent();

    void setTouchEvent(@NotNull View recordButton, @NotNull com.tencent.aio.api.runtime.a aioContext);
}
