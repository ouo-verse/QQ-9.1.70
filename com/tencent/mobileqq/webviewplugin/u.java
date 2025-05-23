package com.tencent.mobileqq.webviewplugin;

import com.tencent.mobileqq.webview.swift.y;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface u extends y {
    long getDetect302Time();

    boolean getIsReloadUrl();

    long getOpenUrlAfterCheckOfflineTime();

    long getReadIndexFromOfflineTime();

    JSONObject getX5Performance();

    long getgetWebViewTime();

    long getinitBrowserTime();

    long getinitTBSTime();

    long getinitTime();

    boolean getisWebViewCache();

    long getmClickTime();

    long getmOnCreateMilliTimeStamp();

    boolean getmPerfFirstLoadTag();

    long getmStartLoadUrlMilliTimeStamp();

    long getmTimeBeforeLoadUrl();

    long getonCreateTime();

    long getpluginFinished();

    long getviewInflateTime();

    boolean isMainPageUseLocalFile();

    void setX5Performance(JSONObject jSONObject);
}
