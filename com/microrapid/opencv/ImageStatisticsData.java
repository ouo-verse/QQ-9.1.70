package com.microrapid.opencv;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageStatisticsData {
    public double colorfulness;
    public double contrast;
    public double lightness;
    public double overexposure;
    public double saturation;
    public double sharpness;
    public double temperature;
    public double underexposure;
    public double whiteBalance;

    public ImageStatisticsData(double[] dArr) {
        if (dArr != null && dArr.length == 9) {
            this.lightness = dArr[0];
            this.temperature = dArr[1];
            this.overexposure = dArr[2];
            this.underexposure = dArr[3];
            this.contrast = dArr[4];
            this.saturation = dArr[5];
            this.sharpness = dArr[6];
            this.colorfulness = dArr[7];
            this.whiteBalance = dArr[8];
        }
    }
}
