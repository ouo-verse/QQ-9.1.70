package com.tencent.ttpic.offlineset.beans;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StyleFilterSettingJsonBean {

    /* renamed from: id, reason: collision with root package name */
    public String f381698id;
    public Map<String, String> lutPaths;
    public Map<String, String> materialPaths;
    public int type;
    public float isDenoise = 0.0f;
    public float styleParams = 0.18f;
    public int faceThreshold = 65;
    public int typeThreshold = 90;
    public int highlightThreshold = 128;

    public StyleFilterSettingJsonBean() {
    }

    private void updateMap(String str, Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it;
        if (map != null && map.size() != 0 && (it = map.entrySet().iterator()) != null && it.hasNext()) {
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                next.setValue(str + File.separator + next.getValue());
            }
        }
    }

    public boolean isCurrentStyle(String str) {
        String str2 = this.f381698id;
        if (str2 != null && str != null && str2.equals(str)) {
            return true;
        }
        return false;
    }

    public void updatePath(String str) {
        updateMap(str, this.lutPaths);
        updateMap(str, this.materialPaths);
    }

    public StyleFilterSettingJsonBean(int i3) {
        this.type = i3;
    }
}
