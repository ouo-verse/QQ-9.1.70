package com.tencent.ams.xsad.rewarded.view;

import android.content.res.Configuration;
import android.view.View;
import com.tencent.ams.xsad.rewarded.RewardedAdData;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z16, boolean z17);
    }

    void a();

    void b();

    void c(int i3, int i16);

    void clear();

    void hideLoading();

    void onConfigurationChanged(Configuration configuration);

    void setActionButtonClickListener(View.OnClickListener onClickListener);

    void setData(RewardedAdData rewardedAdData);

    void setMute(boolean z16, boolean z17);

    void setMuteStatusChangeListener(a aVar);

    void setSkipButtonClickListener(View.OnClickListener onClickListener);

    void showLoading();
}
