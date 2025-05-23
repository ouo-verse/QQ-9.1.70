package com.tencent.biz.richframework.video.rfw.player.init;

import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class RFWPlayerManger {
    private static final ConcurrentHashMap<Integer, RFWPlayerManger> sInstances = new ConcurrentHashMap<>();
    private RFWPlayerConfig mConfig;
    private final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private final int mSceneId;

    RFWPlayerManger(int i3) {
        this.mSceneId = i3;
    }

    public static RFWPlayerManger g(int i3) {
        ConcurrentHashMap<Integer, RFWPlayerManger> concurrentHashMap = sInstances;
        if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            return concurrentHashMap.get(Integer.valueOf(i3));
        }
        synchronized (RFWPlayerManger.class) {
            if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
                return concurrentHashMap.get(Integer.valueOf(i3));
            }
            RFWPlayerManger rFWPlayerManger = new RFWPlayerManger(i3);
            concurrentHashMap.put(Integer.valueOf(i3), rFWPlayerManger);
            return rFWPlayerManger;
        }
    }

    private void initBusinessProcess() {
        RFWPlayerOptionsProcessManager.g().initBusinessProcess(this.mConfig.getBusinessProcess());
    }

    public RFWPlayerConfig getConfig() {
        this.mHasInit.get();
        return this.mConfig;
    }

    public boolean hasInit() {
        return this.mHasInit.get();
    }

    public void init(RFWPlayerConfig rFWPlayerConfig) {
        synchronized (this) {
            if (this.mHasInit.get()) {
                return;
            }
            this.mConfig = rFWPlayerConfig;
            initBusinessProcess();
            this.mHasInit.set(true);
        }
    }
}
