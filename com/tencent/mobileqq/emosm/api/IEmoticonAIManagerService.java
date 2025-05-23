package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emosm/api/IEmoticonAIManagerService;", "Lmqq/app/api/IRuntimeService;", "getForceRequest", "", "timeStep", "", "setForceRequest", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "setLastRefreshTimeStamp", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IEmoticonAIManagerService extends IRuntimeService {
    boolean getForceRequest(long timeStep);

    void setForceRequest(boolean force);

    void setLastRefreshTimeStamp(long timeStamp);
}
