package com.tencent.ams.xsad.rewarded.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface RewardedAdController {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface DisplayType {
        public static final int DYNAMIC = 2;
        public static final int NATIVE = 1;
        public static final int UNKOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onFailure();

        void onSuccess();
    }

    void b(Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData, a aVar);

    long c();

    void d(com.tencent.ams.xsad.rewarded.a aVar);

    @DisplayType
    int getDisplayType();

    View getView();

    void onBackPressed();

    void setRewardedAdListener(RewardedAdListener rewardedAdListener);
}
