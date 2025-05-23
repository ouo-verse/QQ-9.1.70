package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOEssenceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEssenceMenuType", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "isFullScreenEssenceEnable", "", "aioParam", "Lcom/tencent/aio/data/AIOParam;", "onEssenceMenuClicked", "", "context", "Landroid/content/Context;", "isCancel", "setEssenceMsgFromFullScreen", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOEssenceApi extends QRouteApi {
    int getEssenceMenuType(@NotNull AIOMsgItem msgItem);

    boolean isFullScreenEssenceEnable(@NotNull AIOParam aioParam);

    void onEssenceMenuClicked(@NotNull Context context, @NotNull AIOMsgItem msgItem, boolean isCancel);

    void setEssenceMsgFromFullScreen(@NotNull MsgRecord msgRecord);
}
