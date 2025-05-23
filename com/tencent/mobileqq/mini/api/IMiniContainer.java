package com.tencent.mobileqq.mini.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IMiniContainer extends QRouteApi {
    void addExternalPlugin(Class<?> cls);

    void checkUpdate();

    void dispatchNativeEvent(String str, Map<String, ?> map);

    boolean isX5Installed();

    void launchPage(Context context, String str);

    MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, String str, ContainerLoadParams containerLoadParams);

    MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, String str, Map<String, ?> map, IMiniLoadCallback iMiniLoadCallback);

    MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, String str, Map<String, ?> map, IMiniLoadCallback iMiniLoadCallback, IContainerViewCallback iContainerViewCallback);

    void onThemeChanged();

    void prefetchPageData(String str);

    void prefetchPageDataWithExtraParam(String str, String str2, Map<String, String> map);

    void prepare();

    void refreshContainer();

    void registerMiniView(View view);

    void reloadAllMiniContainer();

    void reset();

    void retry(View view);

    void setContainerNavigator(IContainerPageNavigator iContainerPageNavigator);

    void setDrawEnabled(View view, boolean z16);

    void setLoadingView(View view, IMiniLoadingView iMiniLoadingView);
}
