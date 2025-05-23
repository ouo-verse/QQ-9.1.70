package com.tencent.mobileqq.util;

import android.content.DialogInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IDialogUtilService extends QRouteApi {
    void showMSFRespCustomDialog(int i3, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2);
}
