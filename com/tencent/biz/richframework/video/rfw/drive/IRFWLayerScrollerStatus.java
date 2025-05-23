package com.tencent.biz.richframework.video.rfw.drive;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IRFWLayerScrollerStatus {
    void onDestroy();

    void onFeedPageScrolled(int i3, float f16, int i16);

    void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo);

    void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo);

    void onLoadFeedExport(int i3, int i16);

    void onPageScrolledIdle(int i3);

    void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo);

    void onPosUpdate(int i3);

    void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo);

    void onStart(RFWFeedSelectInfo rFWFeedSelectInfo);

    void onStop(RFWFeedSelectInfo rFWFeedSelectInfo);
}
