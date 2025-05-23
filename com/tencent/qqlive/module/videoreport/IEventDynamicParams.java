package com.tencent.qqlive.module.videoreport;

import java.util.Map;

/* loaded from: classes22.dex */
public interface IEventDynamicParams {
    void setEventDynamicParams(String str, Map<String, Object> map);

    void setNonRealtimePublicDynamicParams(Map<String, Object> map);

    void setRealtimePublicDynamicParams(Map<String, Object> map);
}
