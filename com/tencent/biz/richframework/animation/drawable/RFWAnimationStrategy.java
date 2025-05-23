package com.tencent.biz.richframework.animation.drawable;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface RFWAnimationStrategy {
    int getCutTimes();

    @NonNull
    RFWDownloadStrategy getDownLoadStrategy();

    boolean needCut();
}
