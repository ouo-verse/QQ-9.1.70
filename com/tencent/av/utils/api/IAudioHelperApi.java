package com.tencent.av.utils.api;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAudioHelperApi extends QRouteApi {
    void changButtonStyle(Resources resources, TextView textView, int i3, int i16, int i17);

    void changButtonStyle(Resources resources, TextView textView, boolean z16, int i3);

    void changViewStyle(View view, boolean z16, int i3);

    @TargetApi(17)
    long elapsedRealtimeNanos();

    long enlargeVolumWrapper(Context context, byte[] bArr, int i3, float f16);

    long genDebugSeq();

    int getDebugValue(int i3);

    String getLogString(Object obj);

    String getResIDName(Resources resources, int i3);

    String getResIDName(View view, int i3);

    long getServerMSTime();

    void initDebugValue();

    boolean isAccelerateSensorInsensitive();

    boolean isBluetoothHeadsetA2dpOn();

    boolean isBluetoothHeadsetOn(Context context);

    boolean isBluetoothHeadsetScoOn(Context context);

    boolean isBluetoothScoOn(Context context);

    @TargetApi(15)
    boolean isBluetoothSupportA2dp(BluetoothDevice bluetoothDevice);

    boolean isDev();

    boolean isForbidByRubbishMeizu(int i3);

    boolean isForbidByRubbishMeizu(int i3, Context context);

    boolean isForbidByRubbishXiaomi(int i3);

    boolean isHuaweiGreen();

    boolean isHuaweiGreenForSegment();

    boolean isLogColorOrGary();

    void print(String str, Intent intent);

    void print(String str, Bundle bundle);

    void print(String str, Bundle bundle, boolean z16);

    <T1, T2> void print(String str, Map<T1, T2> map, boolean z16);

    String printBaseInfo(AppInterface appInterface);

    String printBaseInfo(AppInterface appInterface, int i3);

    @TargetApi(17)
    void printTime(String str);

    boolean registDebugReceiver(BaseApplication baseApplication, long j3);

    void reportExp(String str, boolean z16);

    void saveAudioPlayerParam(int i3, int i16, int i17, boolean z16);

    void sendValueChanged(BaseApplication baseApplication, int i3);

    void setBeaconDebug(Context context);

    void setCurAccount(long j3);

    void setDebugValue(int i3, int i16);

    void showDebugToast(String str);

    long stringToLong(String str);

    void syncPrintBaseInfo(AppInterface appInterface);

    void writeTestLog(String str);
}
