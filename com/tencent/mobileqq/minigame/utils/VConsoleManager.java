package com.tencent.mobileqq.minigame.utils;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VConsoleManager {
    private static final String TAG = "VConsoleManager";
    private static VConsoleManager instance;
    private HashMap<Integer, VConsoleLogManager> vConsoleLogManagerMap = new HashMap<>();

    public static VConsoleManager getInstance() {
        if (instance == null) {
            instance = new VConsoleManager();
        }
        return instance;
    }

    public VConsoleLogManager getLogManager(int i3) {
        HashMap<Integer, VConsoleLogManager> hashMap = this.vConsoleLogManagerMap;
        if (hashMap == null || hashMap.size() == 0) {
            return null;
        }
        return this.vConsoleLogManagerMap.get(Integer.valueOf(i3));
    }

    public void registerLogManager(int i3, VConsoleLogManager vConsoleLogManager) {
        if (this.vConsoleLogManagerMap == null) {
            this.vConsoleLogManagerMap = new HashMap<>();
        }
        this.vConsoleLogManagerMap.put(Integer.valueOf(i3), vConsoleLogManager);
    }

    public void unRegisterLogManager(int i3) {
        HashMap<Integer, VConsoleLogManager> hashMap = this.vConsoleLogManagerMap;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(Integer.valueOf(i3));
    }
}
