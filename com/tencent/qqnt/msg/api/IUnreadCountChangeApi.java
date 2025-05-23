package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0004H&J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/msg/api/IUnreadCountChangeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/msg/unread/c;", "interceptor", "", "registerUnreadCountInterceptor", "unRegisterUnreadCountInterceptor", "Lcom/tencent/qqnt/msg/unread/a;", "observer", "registerUnreadCountObserver", "unRegisterUnreadCountObserver", "", "uid", "", "getUnreadCount", "getTotalUnreadCount", "notifyCurUnreadInfo", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "getTotalUnreadInfo", "msg_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IUnreadCountChangeApi extends QRouteApi {
    int getTotalUnreadCount();

    @NotNull
    Map<String, UnreadCntInfo> getTotalUnreadInfo();

    int getUnreadCount(@NotNull String uid);

    void notifyCurUnreadInfo();

    void registerUnreadCountInterceptor(@NotNull com.tencent.qqnt.msg.unread.c interceptor);

    void registerUnreadCountObserver(@NotNull com.tencent.qqnt.msg.unread.a observer);

    void unRegisterUnreadCountInterceptor(@NotNull com.tencent.qqnt.msg.unread.c interceptor);

    void unRegisterUnreadCountObserver(@NotNull com.tencent.qqnt.msg.unread.a observer);
}
