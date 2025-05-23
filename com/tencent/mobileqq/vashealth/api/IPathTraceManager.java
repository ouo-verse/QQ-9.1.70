package com.tencent.mobileqq.vashealth.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process = {"all"})
/* loaded from: classes20.dex */
public interface IPathTraceManager extends IRuntimeService {
    int getEngineWorkingMode();

    Entity getLastUnCompletedTrace();

    Entity getPathTrace();

    int getRunningStatus();

    boolean isRunning();

    boolean pathTraceDelete(Long l3);

    boolean pathTraceEnd(long j3, String str);

    void pathTracePause(String str);

    JSONObject pathTraceQuery();

    void pathTraceResume(String str);

    void pathTraceUpload(long j3, String str);

    JSONObject queryPathData(String str);

    void registerWebViewPlug(WebViewPlugin webViewPlugin);

    void setIgnoreSpeed(boolean z16);

    void setIsMute(boolean z16);

    void startLocation(int i3, String str);

    void startPathTrace(JSONObject jSONObject, String str);

    void stopLocation(int i3, String str);
}
