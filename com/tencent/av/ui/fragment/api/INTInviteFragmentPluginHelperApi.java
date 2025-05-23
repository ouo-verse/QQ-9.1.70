package com.tencent.av.ui.fragment.api;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface INTInviteFragmentPluginHelperApi extends QRouteApi {
    Fragment init(Activity activity, boolean z16);

    void onBackPressed();

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    void onNewIntent(Intent intent);
}
