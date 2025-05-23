package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(V v3) {
        this(Collections.singletonList(new Keyframe(v3)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.keyframes.isEmpty()) {
            return true;
        }
        if (this.keyframes.size() == 1 && this.keyframes.get(0).isStatic()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb5.append("values=");
            sb5.append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }
}
