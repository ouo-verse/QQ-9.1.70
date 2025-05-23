package com.tencent.qqmini.sdk.launcher.core;

import android.view.KeyEvent;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public interface IPage {
    String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent);

    void dispatchEventToWebView(String str, String str2, int[] iArr);

    boolean doDispatchKeyEvent(KeyEvent keyEvent);

    ICapsuleButton getCapsuleButton();

    int getNaviBarTextStyle();

    int getNaviBarVisibility();

    AppPageInfo getPageInfo(int i3);

    String getPageOrientation();

    int getTabBarVisibility();

    boolean hideLoading();

    void hideSoftInput(View view);

    boolean operateCustomButton(String str, long j3, JSONObject jSONObject, View.OnClickListener onClickListener);

    boolean operateFloatDragAd(String str, FloatDragAdInfo floatDragAdInfo);

    boolean operatePendantAd(String str, PendantAdInfo pendantAdInfo);

    boolean setMiniAIOEntranceVisible(boolean z16, JSONObject jSONObject);

    void setNaviVisibility(int i3);

    void setTabBarVisibility(int i3);

    boolean showLoading();

    boolean toggleDebugPanel();

    boolean toggleMonitorPanel();
}
