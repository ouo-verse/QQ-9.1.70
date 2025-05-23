package com.tencent.mobileqq.gamecenter.api;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IYunGameChannelApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface AuthResult {
        void onCancel();

        void onComplete(Object obj);

        void onError(Object obj);

        void onWarning(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface OnGetLaunchKeyListener {
        void onResult(String str, String str2, String str3, String str4);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface PermissionHandler {
        void onAllGranted();

        void onDenied(List<String> list, List<Integer> list2);

        void onDialogShow(Dialog dialog, List<String> list);

        void onFailed(String str);

        void onViewShow(View view, List<String> list);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface ResultHandler {
        void onActivityResult(int i3, int i16, Intent intent);
    }

    AppRuntime createAppInterface(MobileQQ mobileQQ, String str);

    String getDeviceInfo();

    QIPCModule getIPCModule();

    void initMidas(Context context, String str, String str2, String str3);

    boolean isFoldDevice();

    void releaseMidas(Context context, String str, String str2);

    ResultHandler requesetLogin(Context context, String str, String str2, String str3, String str4, AuthResult authResult);

    void requestPermission(Context context, String str, PermissionHandler permissionHandler);

    void startGetLaunchKeys(String str, OnGetLaunchKeyListener onGetLaunchKeyListener);
}
