package com.gyailib.library;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SDKDeviceConfig {
    private int cpuLevel;
    private String device = "ARM";
    private Map<String, String> infos;
    private boolean smoothEnable;

    public String getDevice() {
        return this.device;
    }

    public String getInfos() {
        Map<String, String> map = this.infos;
        if (map != null && map.size() >= 1) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : this.infos.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(" ");
                sb5.append(entry.getValue());
                sb5.append(" ");
            }
            return sb5.toString().trim();
        }
        return "";
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setInfos(Map<String, String> map) {
        this.infos = map;
    }
}
