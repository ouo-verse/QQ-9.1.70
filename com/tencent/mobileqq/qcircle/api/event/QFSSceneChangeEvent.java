package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSSceneChangeEvent extends SimpleBaseEvent {
    public static final int BEGIN_SCENE_TYPE = 0;
    public static final int END_SCENE_TYPE = 1;
    private String mSceneName;
    private int mSceneType;

    public QFSSceneChangeEvent(String str, int i3) {
        this.mSceneName = str;
        this.mSceneType = i3;
    }

    public String getSceneName() {
        return this.mSceneName;
    }

    public int getSceneType() {
        return this.mSceneType;
    }
}
