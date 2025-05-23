package com.tencent.mobileqq.troop.troopnotification.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/api/ITroopNotificationListenerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addKernelMsgNotifyListener", "", "app", "Lcom/tencent/common/app/AppInterface;", "removeKernelMsgNotifyListener", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopNotificationListenerApi extends QRouteApi {
    void addKernelMsgNotifyListener(@Nullable AppInterface app);

    void removeKernelMsgNotifyListener();
}
