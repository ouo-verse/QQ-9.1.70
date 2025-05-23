package com.tencent.ttpic.openapi;

import java.util.List;

/* loaded from: classes27.dex */
public class PTEmotionAttr {
    public static final int EMOTION_TYPE_SMILE = 14;
    public static final String EXPRESSION_DETECT_FOR_EVERY_FACE = "expressionDetectForEveryFace";
    private List<Boolean> isSmiles;
    private List<Integer> smileValues;
    private int value = 0;
    private boolean isCurrentFrameSmile = false;
    private boolean isSmile = false;

    public List<Boolean> getIsSmiles() {
        return this.isSmiles;
    }

    public List<Integer> getSmileValues() {
        return this.smileValues;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isSmile() {
        if (this.isCurrentFrameSmile) {
            return true;
        }
        return this.isSmile;
    }

    public void setCurrentFrameSmile(boolean z16) {
        this.isCurrentFrameSmile = z16;
    }

    public void setIsSmiles(List<Boolean> list) {
        this.isSmiles = list;
    }

    public void setSmile(boolean z16) {
        this.isSmile = z16;
    }

    public void setSmileValues(List<Integer> list) {
        this.smileValues = list;
    }

    public void setValue(int i3) {
        this.value = i3;
    }
}
