package com.tencent.mobileqq.qcircle.api.animation;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.animation.drawable.RFWAnimationStrategy;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import vq3.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleDefaultAnimationStrategy implements RFWAnimationStrategy {
    @Override // com.tencent.biz.richframework.animation.drawable.RFWAnimationStrategy
    public int getCutTimes() {
        return 2;
    }

    @Override // com.tencent.biz.richframework.animation.drawable.RFWAnimationStrategy
    @NonNull
    public RFWDownloadStrategy getDownLoadStrategy() {
        return a.a();
    }

    @Override // com.tencent.biz.richframework.animation.drawable.RFWAnimationStrategy
    public boolean needCut() {
        return QCircleDeviceInfoUtils.isLowDevice();
    }
}
