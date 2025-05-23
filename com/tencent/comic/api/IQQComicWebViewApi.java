package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.comic.data.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicWebViewApi extends QRouteApi {
    String addUrlField(String str, String str2, String str3);

    Object createComicFragment(Intent intent);

    View createComicTabBarView(Context context, Intent intent, List<c> list, TabBarView.d dVar);

    Object createComicTitleBarUI(Object obj);

    Object getCommonJsPluginFactory();

    boolean isBoodoUrl(String str);

    void openComicWebView(Activity activity, String str, Intent intent);

    String replaceUrlFieldValueReg(String str, String str2, String str3);

    void updateOfflinePkgAsync(int i3, AppRuntime appRuntime);
}
