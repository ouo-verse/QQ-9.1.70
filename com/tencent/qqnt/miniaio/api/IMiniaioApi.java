package com.tencent.qqnt.miniaio.api;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.miniaio.c;
import com.tencent.qqnt.miniaio.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/miniaio/api/IMiniaioApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "handleHorizontalMiniaioFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "toMainMsgList", "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/qqnt/miniaio/d;", "callback", "Lcom/tencent/qqnt/miniaio/c;", "getEmoticonPanel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMiniaioApi extends QRouteApi {
    @NotNull
    c getEmoticonPanel(@NotNull ViewGroup containerView, @NotNull d callback);

    void handleHorizontalMiniaioFinish();

    void toMainMsgList(@NotNull Activity activity);
}
