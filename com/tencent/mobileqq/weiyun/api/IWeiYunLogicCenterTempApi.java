package com.tencent.mobileqq.weiyun.api;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.weiyun.a;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes20.dex */
public interface IWeiYunLogicCenterTempApi extends IRuntimeService {
    void saveAioMedia2Weiyun(ChatMessage chatMessage, a aVar);
}
