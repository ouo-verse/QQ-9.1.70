package com.tencent.tav.extractor.wrapper;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExtractorWrapper {
    private long duration;
    private long lastUpdateTime;
    private int preferRotation;
    private String videoPath;
    private CGSize videoSize;

    public ExtractorWrapper(String str) {
        this.videoPath = str;
    }

    private boolean exit() {
        if (!TextUtils.isEmpty(this.videoPath) && new File(this.videoPath).exists()) {
            return true;
        }
        return false;
    }

    private void loadWith(AssetExtractor assetExtractor) {
        this.duration = assetExtractor.getDuration();
        this.videoSize = assetExtractor.getSize();
        this.preferRotation = assetExtractor.getPreferRotation();
        this.lastUpdateTime = new File(this.videoPath).lastModified();
    }

    private boolean needReload() {
        if (this.lastUpdateTime != new File(this.videoPath).lastModified()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkAndLoad(AssetExtractor assetExtractor) {
        if (exit() && needReload()) {
            loadWith(assetExtractor);
        }
    }

    public long getDuration() {
        return this.duration;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public CGSize getVideoSize() {
        return this.videoSize;
    }
}
