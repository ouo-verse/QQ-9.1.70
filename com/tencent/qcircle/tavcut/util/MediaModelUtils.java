package com.tencent.qcircle.tavcut.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaModelUtils {
    public static long getTotalSelectDuration(@Nullable MediaResourceModel mediaResourceModel) {
        if (mediaResourceModel == null) {
            return 0L;
        }
        return getTotalSelectDuration(mediaResourceModel.getVideos());
    }

    public static long getTotalSelectDuration(@NonNull List<MediaClipModel> list) {
        long j3 = 0;
        for (MediaClipModel mediaClipModel : list) {
            if (mediaClipModel != null) {
                j3 += mediaClipModel.getResource().getScaleDuration();
            }
        }
        return j3;
    }
}
