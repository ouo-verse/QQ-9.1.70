package com.tencent.qqnt.aio.adapter.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J,\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOMarketFaceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterMarketFacePreview", "", "clickedView", "Landroid/view/View;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "marketFaceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "enterMarketFacePreviewWithSource", "source", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOMarketFaceApi extends QRouteApi {
    void enterMarketFacePreview(@NotNull View clickedView, @NotNull MsgRecord msgRecord, @Nullable MarketFaceElement marketFaceElement);

    void enterMarketFacePreviewWithSource(@NotNull View clickedView, @NotNull MsgRecord msgRecord, @Nullable MarketFaceElement marketFaceElement, int source);
}
