package com.tencent.mobileqq.dt.api;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONException;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQSecChannel extends QRouteApi {
    void collectReport(AppInterface appInterface, String str, String str2, a aVar);

    void feCameraActionReport(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, a aVar);

    void feEnvReport(AppInterface appInterface, String str, String str2, a aVar);

    void loginReport(AppInterface appInterface, String str, Object obj);

    void loginTouchEvent(AppInterface appInterface, String str, View view);

    void mainPageReport(String str, Object obj);

    void regReport(AppInterface appInterface, String str, Object obj);

    void regTouchEvent(AppInterface appInterface, String str, View view);

    boolean reportEnable();

    void sendRequest(AppInterface appInterface, String str, byte[] bArr, a aVar) throws JSONException;

    void setTouchEvent(String str, View view);

    void uiEndSensor(AppInterface appInterface, String str);

    void uiStartSensor(AppInterface appInterface, String str);
}
