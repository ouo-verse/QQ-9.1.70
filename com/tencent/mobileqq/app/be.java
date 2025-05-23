package com.tencent.mobileqq.app;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qui.quiblurview.f;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface be extends ba {
    void dismissLocalSearchDialog();

    QBaseActivity getActivity();

    f.b getBlurDirtyState();

    View getContentView();

    String getLastActivityName();

    boolean hasInited();

    boolean isFrameResume();

    void onAccountChanged();

    void onDrawComplete();

    void onFrameTabClick();

    void onLogout(Constants.LogoutReason logoutReason);

    View preLoadView(LayoutInflater layoutInflater);

    void setActivity(QBaseActivity qBaseActivity);
}
