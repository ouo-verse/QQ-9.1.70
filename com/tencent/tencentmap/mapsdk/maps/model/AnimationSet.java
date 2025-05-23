package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes26.dex */
public class AnimationSet extends BaseAnimation {
    public List<Animation> mAnimations = new ArrayList();
    public boolean mShareInterpolator;

    public AnimationSet(boolean z16) {
        this.mShareInterpolator = z16;
    }

    public boolean addAnimation(Animation animation) {
        this.mAnimations.add(animation);
        return true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }
}
