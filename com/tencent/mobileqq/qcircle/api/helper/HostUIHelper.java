package com.tencent.mobileqq.qcircle.api.helper;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HostUIHelper {
    private static final String TAG = "HostUIHelper";
    private static volatile HostUIHelper sInstance;
    private final Context mHostApplicationContext;
    private int mHostTabHeight;
    private QCircleHookPluginIntentCallBack mQCircleHookPluginIntentCallBack;

    HostUIHelper(Context context) {
        this.mHostApplicationContext = context;
    }

    public static HostUIHelper getInstance() {
        if (sInstance == null) {
            synchronized (HostUIHelper.class) {
                if (sInstance == null) {
                    sInstance = new HostUIHelper(MobileQQ.sMobileQQ);
                }
            }
        }
        return sInstance;
    }

    public Context getHostApplicationContext() {
        return this.mHostApplicationContext;
    }

    public int getHostResourceId(String str, String str2) {
        return this.mHostApplicationContext.getResources().getIdentifier(str2, str, this.mHostApplicationContext.getPackageName());
    }

    public int getHostTabHeight() {
        QLog.d(TAG, 1, "getHostTabHeight:" + this.mHostTabHeight);
        return this.mHostTabHeight;
    }

    public QCircleHookPluginIntentCallBack getQCircleHookPluginIntentCallBack() {
        return this.mQCircleHookPluginIntentCallBack;
    }

    public void setHostTABHeight(int i3) {
        this.mHostTabHeight = i3;
        QLog.d(TAG, 1, "setHostTABHeight:" + i3);
    }

    public void setPluginIntentHook(QCircleHookPluginIntentCallBack qCircleHookPluginIntentCallBack) {
        this.mQCircleHookPluginIntentCallBack = qCircleHookPluginIntentCallBack;
    }
}
