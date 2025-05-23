package com.tencent.qcircle.tavcut.exporter;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CGSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ImageExportConfig extends ExportConfig {
    private List<String> outputPaths = new ArrayList();
    private int maxExportSize = -1;
    private int quality = 100;
    private CGSize screenSize = null;
    private Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;

    public Bitmap.CompressFormat getFormat() {
        return this.format;
    }

    public int getMaxExportSize() {
        return this.maxExportSize;
    }

    public List<String> getOutputPaths() {
        return this.outputPaths;
    }

    public int getQuality() {
        return this.quality;
    }

    public CGSize getScreenSize() {
        return this.screenSize;
    }

    public void setFormat(Bitmap.CompressFormat compressFormat) {
        this.format = compressFormat;
    }

    public void setMaxExportSize(int i3) {
        this.maxExportSize = i3;
    }

    public void setOutputPath(List<String> list) {
        this.outputPaths = list;
    }

    public void setQuality(int i3) {
        this.quality = i3;
    }

    public void setScreenSize(CGSize cGSize) {
        this.screenSize = cGSize;
    }
}
