package com.tencent.ams.fusion.widget.animatorplayer.physics;

import com.tencent.ams.fusion.widget.animatorplayer.AnimationItem;
import java.util.Iterator;

/* loaded from: classes3.dex */
public interface PhysicsEngine {

    /* loaded from: classes3.dex */
    public interface AnimationItemIterator extends Iterator<AnimationItem> {
    }

    void dynamicLogic();

    long getAnimationBaseTime();

    AnimationItem getClickBoxItem(float f16, float f17);

    AnimationItemIterator getDrawItemIterator();

    void setAnimationBaseTime(long j3);

    void setEngineStateListener(PhysicsEngineStateListener physicsEngineStateListener);

    void setStepTimeGap(float f16);
}
