package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQFloatingPermission extends QRouteApi {
    boolean checkPermission(Context context);

    void enterPermissionRequestDialog(Context context);

    void enterPermissionRequestDialogCustom(Context context, int i3, int i16);

    void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18);

    void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener);

    void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener);

    void enterPermissionRequestDialogCustomWithDecorator(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener, c cVar);

    boolean requestPermission(Context context);
}
