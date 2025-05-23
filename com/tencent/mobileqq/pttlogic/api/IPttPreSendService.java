package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttPreSendService extends IRuntimeService {
    public static final int FLOW_LIMIT_WIFI = 10000000;
    public static final int FLOW_LIMIT_XG = 100000;
    public static final int FLOW_MIN_AVAILABLE_WIFI = 10000;
    public static final int FLOW_MIN_AVAILABLE_XG = 4000;
    public static final long FLOW_REFRESH_TIME = 86399999;

    void cleanUp();

    void doOnCancelSend();

    void doOnPreSendEnd(String str);

    void init();
}
