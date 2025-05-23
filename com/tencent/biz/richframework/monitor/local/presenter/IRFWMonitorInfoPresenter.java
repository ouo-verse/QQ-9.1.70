package com.tencent.biz.richframework.monitor.local.presenter;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy;

/* loaded from: classes5.dex */
public interface IRFWMonitorInfoPresenter {
    void injectProxyImpl(IRFWMonitorProxy iRFWMonitorProxy);

    void onCreateView(View view);

    void onInit(WindowManager windowManager);

    void onStart(Context context);

    void onStop();
}
