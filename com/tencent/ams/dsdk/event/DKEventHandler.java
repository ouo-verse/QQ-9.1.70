package com.tencent.ams.dsdk.event;

import com.tencent.ams.dsdk.event.DKEventCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DKEventHandler {
    void onCreateView(String str, DKEventCenter.EngineType engineType, String str2, String str3);

    void onEngineCreateFail(String str, DKEventCenter.EngineType engineType, int i3);

    void onEngineCreated(String str, DKEventCenter.EngineType engineType);

    void onEngineInit(String str, DKEventCenter.EngineType engineType);

    void onEngineInitFail(String str, DKEventCenter.EngineType engineType, int i3);

    void onEngineInitParams(String str, DKEventCenter.EngineType engineType);

    void onEngineInitSuccess(String str, DKEventCenter.EngineType engineType);

    void onJsBundleLoadComplete(String str, DKEventCenter.EngineType engineType, String str2, int i3);

    void onViewCreateFail(String str, DKEventCenter.EngineType engineType, int i3, String str2);

    void onViewCreated(String str, DKEventCenter.EngineType engineType, String str2);

    void onViewLoadComplete(String str, DKEventCenter.EngineType engineType, String str2);
}
