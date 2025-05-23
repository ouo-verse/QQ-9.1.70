package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public interface IAppBrandPageContainer extends IPage {
    void cleanup(boolean z16);

    View getContentView();

    void launch(String str, String str2);

    boolean navigateBack(int i3, int i16);

    void navigateTo(String str, int i3);

    void onAttachedToActivity(Activity activity);

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();

    void redirectTo(String str, int i3);

    void setFromReload(boolean z16);

    void setMiniAppInfo(MiniAppInfo miniAppInfo);

    void switchTab(String str);
}
