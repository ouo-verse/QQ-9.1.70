package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import protocol.KQQConfig.GetResourceReqInfo;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes17.dex */
public interface IConfigHandlerTempService extends IRuntimeService {
    void doConfigHandlerUpdateConfigs(AppRuntime appRuntime, ArrayList<GetResourceReqInfo> arrayList, GetResourceReqInfo... getResourceReqInfoArr);
}
