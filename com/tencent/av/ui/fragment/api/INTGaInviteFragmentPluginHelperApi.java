package com.tencent.av.ui.fragment.api;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.av.ui.o;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface INTGaInviteFragmentPluginHelperApi extends QRouteApi {
    void btnOnClick(View view);

    String genGroupName(AppRuntime appRuntime, TextView textView, int i3, int i16, String str, long[] jArr);

    long getGroupId();

    int getUinType();

    Fragment init(boolean z16);

    boolean isShowing();

    void onBackPressed();

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void refreshGaFaceUI(String str, String str2, AppRuntime appRuntime, int i3, int i16, long j3, long j16, o oVar);

    Intent setIntentFrom(Intent intent, String str);

    void stopRefreshGaFaceUI();
}
