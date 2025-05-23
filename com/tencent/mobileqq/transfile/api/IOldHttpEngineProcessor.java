package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/transfile/api/IOldHttpEngineProcessor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cancelMsg", "", "req", "Lcom/tencent/mobileqq/utils/httputils/HttpMsg;", "cancelReq", "Lcom/tencent/mobileqq/transfile/NetReq;", SmsPlugin.API_SEND_SMS, "", "msg", "sendReq", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
@Deprecated
/* loaded from: classes19.dex */
public interface IOldHttpEngineProcessor extends QRouteApi {
    void cancelMsg(@Nullable HttpMsg req);

    void cancelReq(@Nullable NetReq req);

    int sendMsg(@NotNull HttpMsg msg2);

    void sendReq(@NotNull NetReq req);
}
