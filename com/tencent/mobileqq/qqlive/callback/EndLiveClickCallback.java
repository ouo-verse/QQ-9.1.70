package com.tencent.mobileqq.qqlive.callback;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface EndLiveClickCallback {
    void onCloseClick(View view);

    void onFollowClick(View view);

    void onHeadIconClick(View view);

    void onNickClick(View view);

    void onPopularityClick(View view);

    void onRecommendClick(int i3, QQLiveEndRecommendInfo qQLiveEndRecommendInfo, View view);

    void onTimeClick(View view);
}
