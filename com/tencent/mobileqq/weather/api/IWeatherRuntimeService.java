package com.tencent.mobileqq.weather.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import p43.a;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes20.dex */
public interface IWeatherRuntimeService extends IRuntimeService {
    long getConfigVersion();

    void setWeatherUpdateListener(a aVar);

    boolean unzipResource(long j3, String str);
}
