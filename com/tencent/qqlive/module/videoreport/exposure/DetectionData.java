package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DetectionData {
    final SafeList<AncestorInfo> ancestorsInfo;
    final SafeList<AreaInfo> mAreaInfo;
    int viewsDetected = 0;
    final RectF helperRectF = new RectF();
    final Rect helperRectForExclusion = new Rect();

    public DetectionData() {
        int i3 = 20;
        this.ancestorsInfo = new SafeList<AncestorInfo>(i3) { // from class: com.tencent.qqlive.module.videoreport.exposure.DetectionData.1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qqlive.module.videoreport.exposure.SafeList
            public AncestorInfo initValue() {
                return new AncestorInfo();
            }
        };
        this.mAreaInfo = new SafeList<AreaInfo>(i3) { // from class: com.tencent.qqlive.module.videoreport.exposure.DetectionData.2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qqlive.module.videoreport.exposure.SafeList
            public AreaInfo initValue() {
                return null;
            }
        };
    }
}
