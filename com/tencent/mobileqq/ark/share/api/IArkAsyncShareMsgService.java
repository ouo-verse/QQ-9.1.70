package com.tencent.mobileqq.ark.share.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import p91.a;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes11.dex */
public interface IArkAsyncShareMsgService extends IRuntimeService {
    a getAsyncShareMsgManager();

    o91.a getMessagePreprocessorMgr();
}
