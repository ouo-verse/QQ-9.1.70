package com.tencent.biz.richframework.animation.transition;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Pair;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionAnimConfig {
    private ImageView mImageView;
    private ViewGroup mRootView;
    private final HashMap<Integer, Pair<Float, Float>> mValuePairMap = new HashMap<>();
    private float mScaleFactor = 1.0f;

    public float getEndValue(int i3) {
        Float f16;
        Pair<Float, Float> pair = this.mValuePairMap.get(Integer.valueOf(i3));
        if (pair != null && (f16 = pair.second) != null) {
            return f16.floatValue();
        }
        return -1.0f;
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public float getStartValue(int i3) {
        Float f16;
        Pair<Float, Float> pair = this.mValuePairMap.get(Integer.valueOf(i3));
        if (pair != null && (f16 = pair.first) != null) {
            return f16.floatValue();
        }
        return -1.0f;
    }

    public TransitionAnimConfig setImageView(ImageView imageView) {
        this.mImageView = imageView;
        return this;
    }

    public TransitionAnimConfig setRootView(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        return this;
    }

    public void setScaleFactor(float f16) {
        this.mScaleFactor = f16;
    }

    public TransitionAnimConfig setValue(int i3, float f16, float f17) {
        this.mValuePairMap.put(Integer.valueOf(i3), new Pair<>(Float.valueOf(f16), Float.valueOf(f17)));
        return this;
    }
}
