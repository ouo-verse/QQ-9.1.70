package com.tencent.bugly.battery;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatteryMetricItem {

    /* renamed from: id, reason: collision with root package name */
    public int f97809id;
    public String processName = "";
    public String processLaunchID = "";
    public String launchID = "";
    public String appVersion = "";
    public String hotPatchNum = "";
    public JSONArray details = new JSONArray();
    public JSONObject userData = new JSONObject();
    public int collectCount = 0;
    public int collectIntervalInMinute = 5;
    public float foreAverageCurrent = 0.0f;
    public float averageTemperature = 0.0f;
    public long processAliveInMs = 0;
    public long processForeInMs = 0;
}
