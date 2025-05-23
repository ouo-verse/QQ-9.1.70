package com.tencent.mobileqq.qqlive.api.anchor.stream;

import android.util.Pair;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.encoder.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorStreamQuality {
    void changeOrientation(int i3);

    List<Pair<Long, Integer>> getUpLossRecordList();

    TRTCVideoQualityParams getVideoQuality();

    void setNetworkQosPreferenceParam(a aVar);

    void setVideoQuality(TRTCVideoQualityParams tRTCVideoQualityParams);
}
