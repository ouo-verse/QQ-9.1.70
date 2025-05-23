package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFMToastUtil extends QRouteApi {
    void toast(int i3, int i16);

    void toast(Context context, int i3, int i16);

    void toastCommon(int i3, String str, int i16);

    void toastDefault(int i3);

    void toastDefault(String str);

    void toastError(int i3);

    void toastError(String str);

    void toastNone(int i3);

    void toastSuc(int i3);

    void toastSuc(String str);

    void toastSucLong(String str);
}
