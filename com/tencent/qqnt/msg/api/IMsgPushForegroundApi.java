package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/msg/api/IMsgPushForegroundApi;", "Lmqq/app/api/IRuntimeService;", "registerForegroundCallback", "", "msg_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public interface IMsgPushForegroundApi extends IRuntimeService {
    void registerForegroundCallback();
}
