package com.tencent.component.media.animwebp;

/* loaded from: classes5.dex */
public class AnimWebPInfo {
    private static final String TAG = "AnimWebPInfo";
    private int backgroundColor;
    private int canvasHeight;
    private int canvasWidth;
    private int durationMillis;
    private int frameCount;
    private int frameNumber;
    private int height;
    private int loopCount;
    private int width;
    private int xOffset;
    private int yOffset;

    public AnimWebPInfo(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
        this.width = i3;
        this.height = i16;
        this.xOffset = i17;
        this.yOffset = i18;
        this.backgroundColor = i19;
        this.canvasWidth = i26;
        this.canvasHeight = i27;
        this.frameCount = i28;
        this.loopCount = i29;
        this.durationMillis = i36;
        this.frameNumber = i37;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getFrameNumber() {
        return this.frameNumber;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getWidth() {
        return this.width;
    }

    public int getxOffset() {
        return this.xOffset;
    }

    public int getyOffset() {
        return this.yOffset;
    }

    public String toString() {
        return "AnimWebPInfo{width=" + this.width + ", height=" + this.height + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", backgroundColor=" + this.backgroundColor + ", canvasWidth=" + this.canvasWidth + ", canvasHeight=" + this.canvasHeight + ", frameCount=" + this.frameCount + ", loopCount=" + this.loopCount + ", durationMillis=" + this.durationMillis + ", frameNumber=" + this.frameNumber + '}';
    }
}
