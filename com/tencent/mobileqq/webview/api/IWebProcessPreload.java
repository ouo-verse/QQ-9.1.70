package com.tencent.mobileqq.webview.api;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.util.u;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWebProcessPreload extends QRouteApi {
    long getBusinessClickTimeMills(String str, String str2);

    boolean isPreloadWebProcess();

    boolean isWebProcessExist();

    void preDownX5(int i3, boolean z16);

    void preParseDns(@NonNull List<String> list, @NonNull String str);

    void preloadWebProcess(int i3, u uVar);

    void preloadWebProcessWithData(int i3, Bundle bundle);

    void releaseLightWebProcess();

    void setBusinessClickTimeMills(String str, String str2);

    void setPreloadWebProcess(boolean z16);

    void stopWebCoreService();
}
