package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

@Public
/* loaded from: classes5.dex */
public class MergeProcessor extends ImageProcessor {
    private ArrayList<ImageProcessor> mProcessors;
    private int mType;

    @Public
    public MergeProcessor() {
        this.mType = 1;
        this.mProcessors = new ArrayList<>();
    }

    @Public
    public void addProcessor(int i3, ImageProcessor imageProcessor) {
        if (i3 < 0 || i3 > this.mProcessors.size() || imageProcessor == null) {
            return;
        }
        this.mProcessors.add(i3, imageProcessor);
    }

    @Public
    public ImageProcessor getProcessor(int i3) {
        return this.mProcessors.get(i3);
    }

    @Public
    public int getProcessorCount() {
        return this.mProcessors.size();
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return this.mType;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Drawable drawable2 = drawable;
        for (int i3 = 0; i3 < this.mProcessors.size(); i3++) {
            if (drawable2 == null) {
                return drawable;
            }
            drawable2 = this.mProcessors.get(i3).process(drawable2);
        }
        return drawable2;
    }

    @Public
    public void removeProcessor(ImageProcessor imageProcessor) {
        this.mProcessors.remove(imageProcessor);
    }

    @Public
    public void addProcessor(ImageProcessor imageProcessor) {
        if (imageProcessor != null) {
            this.mProcessors.add(imageProcessor);
        }
    }

    @Public
    public MergeProcessor(int i3) {
        this.mType = i3;
        this.mProcessors = new ArrayList<>();
    }
}
