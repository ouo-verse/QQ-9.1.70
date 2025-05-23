package com.tencent.tmassistantsdk;

import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes26.dex */
public class TMAssistantCallYYBParamStruct {
    public static final String SOURCE_KEY = TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID;
    public String SNGAppId;
    public String actionFlag;
    public String channelId;
    public String outerCallReportData;
    public String recommendId;
    public String source;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public Map<String, Long> timePointMap;
    public String uin;
    public String uinType;
    public String via;

    public TMAssistantCallYYBParamStruct() {
        this.SNGAppId = "";
        this.taskAppId = "";
        this.taskApkId = "";
        this.taskVersion = 0;
        this.via = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.channelId = "";
        this.actionFlag = "0";
        this.timePointMap = new ConcurrentHashMap();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SNGAppId = " + this.SNGAppId);
        sb5.append(",taskAppId = " + this.taskAppId);
        sb5.append(",taskApkId = " + this.taskApkId);
        sb5.append(",taskVersion = " + this.taskVersion);
        sb5.append(",via = " + this.via);
        sb5.append(",taskPackageName = " + this.taskPackageName);
        sb5.append(",uin = " + this.uin);
        sb5.append(",uinType = " + this.uinType);
        sb5.append(",channelId = " + this.channelId);
        sb5.append(",actionFlag = " + this.actionFlag);
        return sb5.toString();
    }

    public TMAssistantCallYYBParamStruct(String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.SNGAppId = "";
        this.taskAppId = "";
        this.taskApkId = "";
        this.taskVersion = 0;
        this.via = "";
        this.taskPackageName = "";
        this.uin = "";
        this.uinType = "";
        this.channelId = "";
        this.actionFlag = "0";
        this.timePointMap = new ConcurrentHashMap();
        this.SNGAppId = str;
        this.taskAppId = str2;
        this.taskApkId = str3;
        this.taskVersion = i3;
        this.via = str4;
        this.taskPackageName = str5;
        this.uin = str6;
        this.uinType = str7;
        this.channelId = str8;
        this.actionFlag = str9;
    }
}
