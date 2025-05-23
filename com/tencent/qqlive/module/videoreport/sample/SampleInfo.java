package com.tencent.qqlive.module.videoreport.sample;

import com.tencent.qqlive.module.videoreport.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleInfo {
    public static final float MAX_SAMPLE_RATE = 100.0f;
    public static final float MIN_SAMPLE_RATE = 0.0f;
    public static final String TAG = "SampleInfo";
    public static final int TYPE_ELEMENT = 2;
    public static final int TYPE_PAGE = 1;

    /* renamed from: id, reason: collision with root package name */
    private final String f345297id;

    @NodeType
    private final int nodeType;
    private boolean isHit = true;
    private float sampleRate = 100.0f;
    private boolean isLocked = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SampleInfo(@NodeType int i3, String str) {
        this.f345297id = str;
        this.nodeType = i3;
    }

    public String getId() {
        return this.f345297id;
    }

    public float getSampleRate() {
        return this.sampleRate;
    }

    @NodeType
    int getType() {
        return this.nodeType;
    }

    public boolean isHit() {
        return this.isHit;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsHit(boolean z16) {
        this.isHit = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsLocked(boolean z16) {
        this.isLocked = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSampleRate(float f16) {
        float f17 = 0.0f;
        if (f16 < 0.0f) {
            Log.e(TAG, "setElementSampleRate() error -> sample rate must be in [0.0,100.0],but " + f16 + "is out of range,so auto change: 0.0");
        } else {
            f17 = 100.0f;
            if (f16 > 100.0f) {
                Log.e(TAG, "setElementSampleRate() error -> sample rate must be in [0.0,100.0],but " + f16 + "is out of range,so auto change: 100.0");
            }
            if (!this.isLocked) {
                Log.e(TAG, "setElementSampleRate() isLocked.get()==true,so return...");
                return;
            } else {
                this.sampleRate = f16;
                return;
            }
        }
        f16 = f17;
        if (!this.isLocked) {
        }
    }
}
