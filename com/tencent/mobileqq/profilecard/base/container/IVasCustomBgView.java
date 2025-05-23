package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IVasCustomBgView {
    View getAvatarView();

    View getLayoutView();

    View getPendantView();

    void onPause();

    void onResume();

    void onStop();

    void updateData(ProfileCardInfo profileCardInfo);
}
