package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IPaiYiPaiApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jumpToWeb", "", "context", "Landroid/content/Context;", "sendDoubleClickReq", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "sendRevokePaiYiPaiReq", "uin", "", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/Long;)V", "shouldAddGuideTip", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IPaiYiPaiApi extends QRouteApi {
    void jumpToWeb(@NotNull Context context);

    void sendDoubleClickReq(@NotNull MsgRecord msgRecord);

    void sendRevokePaiYiPaiReq(@NotNull MsgRecord msgRecord, @Nullable Long uin);

    boolean shouldAddGuideTip();
}
