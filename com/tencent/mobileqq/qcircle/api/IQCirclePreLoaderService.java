package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {""})
/* loaded from: classes16.dex */
public interface IQCirclePreLoaderService extends IRuntimeService {
    void requestWhiteList(String str);
}
