package com.tencent.qcircle.tavcut.aekit;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AEKitModel {
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private Map<String, String> adjustParams;
    private boolean disable;
    private boolean lastState;
    private String lutPath;
    private final int mediaType;
    private String overlayImgPath;
    private float effectStrength = 1.0f;
    private float lutAlpha = 1.0f;
    private int smoothLevel = 0;
    private float glowAlpha = 0.0f;
    private long mStartTime = 0;
    private long mDuration = TTL.MAX_VALUE;
    private String material = "";

    public AEKitModel(int i3) {
        this.mediaType = i3;
    }

    public Map<String, String> getAdjustParams() {
        return this.adjustParams;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public float getEffectStrength() {
        return this.effectStrength;
    }

    public float getGlowAlpha() {
        return this.glowAlpha;
    }

    public boolean getLastState() {
        return this.lastState;
    }

    public float getLutAlpha() {
        return this.lutAlpha;
    }

    public String getLutPath() {
        return this.lutPath;
    }

    public String getMaterial() {
        return this.material;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getOverlayImgPath() {
        return this.overlayImgPath;
    }

    public int getSmoothLevel() {
        return this.smoothLevel;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean isDisable() {
        return this.disable;
    }

    public void setAdjustParams(Map<String, String> map) {
        this.adjustParams = map;
    }

    public void setDisable(boolean z16) {
        this.lastState = this.disable;
        this.disable = z16;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setEffectStrength(float f16) {
        this.effectStrength = f16;
    }

    public void setGlowAlpha(float f16) {
        this.glowAlpha = f16;
    }

    public void setLastState(boolean z16) {
        this.lastState = z16;
    }

    public void setLutAlpha(float f16) {
        this.lutAlpha = f16;
    }

    public void setLutPath(String str) {
        this.lutPath = str;
    }

    public void setMaterial(String str) {
        this.material = str;
    }

    public void setOverlayImagePath(String str) {
        this.overlayImgPath = str;
    }

    public void setSmoothLevel(int i3) {
        this.smoothLevel = i3;
    }

    public void setStartTime(long j3) {
        this.mStartTime = j3;
    }
}
