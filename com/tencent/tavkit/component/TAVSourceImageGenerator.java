package com.tencent.tavkit.component;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSourceImageGenerator {
    public static final String TAG = "TAVSourceImageGenerator";
    private AssetImageGenerator assetImageGenerator;

    public TAVSourceImageGenerator(@NonNull TAVComposition tAVComposition, CGSize cGSize) {
        init(new TAVCompositionBuilder(tAVComposition).buildSource(), cGSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r6 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkRequestedTimes(List<CMTime> list) {
        List<CMTime> list2;
        if (list == null) {
            list2 = new ArrayList();
        }
        if (list2.isEmpty()) {
            list2.add(CMTime.CMTimeZero);
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            CMTime cMTime = (CMTime) list2.get(i3);
            if (cMTime == null || cMTime.getTimeUs() < 0) {
                list2.set(i3, CMTime.CMTimeZero);
            }
        }
        ArrayList arrayList = new ArrayList(list2.size());
        for (CMTime cMTime2 : list2) {
            if (!arrayList.contains(cMTime2)) {
                arrayList.add(cMTime2);
            }
        }
        list2.clear();
        list2.addAll(arrayList);
    }

    private void init(@NonNull TAVSource tAVSource, CGSize cGSize) {
        AssetImageGenerator assetImageGenerator = new AssetImageGenerator(tAVSource.getAsset());
        this.assetImageGenerator = assetImageGenerator;
        assetImageGenerator.setMaximumSize(cGSize);
        this.assetImageGenerator.setAppliesPreferredTrackTransform(true);
        this.assetImageGenerator.setVideoComposition(tAVSource.getVideoComposition());
    }

    public void generateThumbnailAtTime(CMTime cMTime, @NonNull AssetImageGenerator.ImageGeneratorListener imageGeneratorListener) {
        ArrayList arrayList = new ArrayList();
        if (cMTime == null || cMTime.getTimeUs() < 0) {
            cMTime = CMTime.CMTimeZero;
        }
        arrayList.add(cMTime);
        generateThumbnailAtTimes(arrayList, imageGeneratorListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x000f, code lost:
    
        if (r7.getTimeUs() < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap generateThumbnailAtTimeSync(CMTime cMTime) throws Exception {
        if (this.assetImageGenerator == null) {
            return null;
        }
        if (cMTime != null) {
            try {
            } catch (Exception e16) {
                e16.printStackTrace();
                throw new Exception(e16);
            }
        }
        cMTime = CMTime.CMTimeZero;
        return this.assetImageGenerator.copyCGImageAtTimeAndActualTime(cMTime, null);
    }

    public synchronized void generateThumbnailAtTimes(List<CMTime> list, @NonNull final AssetImageGenerator.ImageGeneratorListener imageGeneratorListener) {
        checkRequestedTimes(list);
        if (!list.isEmpty() && this.assetImageGenerator != null) {
            this.assetImageGenerator.generateCGImagesAsynchronouslyForTimes(list, new AssetImageGenerator.ImageGeneratorListener() { // from class: com.tencent.tavkit.component.TAVSourceImageGenerator.1
                @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
                public void onCompletion(@NonNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable CMTime cMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
                    imageGeneratorListener.onCompletion(cMTime, bitmap, cMTime2, assetImageGeneratorResult);
                }
            });
        }
    }

    public AssetImageGenerator getAssetImageGenerator() {
        return this.assetImageGenerator;
    }

    public TAVSourceImageGenerator(@NonNull TAVSource tAVSource, CGSize cGSize) {
        init(tAVSource, cGSize);
    }
}
