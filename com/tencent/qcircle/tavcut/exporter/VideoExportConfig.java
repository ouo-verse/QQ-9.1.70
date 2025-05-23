package com.tencent.qcircle.tavcut.exporter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoExportConfig extends ExportConfig {
    private String outputPath = "";
    private int width = -1;
    private int height = -1;
    private int bitRate = -1;
    private int frameRate = -1;

    public int getBitRate() {
        return this.bitRate;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public String getOutputPath() {
        return this.outputPath;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitRate(int i3) {
        this.bitRate = i3;
    }

    public void setFrameRate(int i3) {
        this.frameRate = i3;
    }

    public void setOutputPath(String str) {
        this.outputPath = str;
    }

    public void setSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }
}
