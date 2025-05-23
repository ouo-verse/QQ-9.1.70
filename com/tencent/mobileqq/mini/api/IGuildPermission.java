package com.tencent.mobileqq.mini.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IGuildPermission extends QRouteApi {
    public static final int AUTHORIZED = 2;
    public static final int CANCELED = 0;
    public static final String GAME_CENTER = "24";
    public static final String SUB_CHANNEL = "23";
    public static final int UNAUTHORIZED = 1;

    /* loaded from: classes15.dex */
    public interface DialogCallBack {
        void onCancel();

        void onConfirm();

        void onReject();
    }

    /* loaded from: classes15.dex */
    public interface StatusCallBack {
        void onError(int i3, String str);

        void onResult(int i3);
    }

    void getUserStatus(StatusCallBack statusCallBack);

    void showPermissionDialog(Context context, DialogCallBack dialogCallBack, String str);
}
