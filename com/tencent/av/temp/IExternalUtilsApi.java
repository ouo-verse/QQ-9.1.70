package com.tencent.av.temp;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.Servlet;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IExternalUtilsApi extends QRouteApi {
    void checkMemPerf(int i3, int i16);

    void checkVoiceRecog(boolean z16, boolean z17);

    void deviceExitVideoProcess(BaseVideoAppInterface baseVideoAppInterface, Bundle bundle);

    String getBroadcastPermission();

    String getDeviceUnBindRst();

    int getEffectSettingQavNone();

    String getFileMD5String(String str);

    Class<?> getQQServiceForAVClass();

    String getSmartDeviceReceiveSharpAckMsg();

    String getSmartDeviceReceiveSharpMsg();

    String getSmartDeviceSendSharpMsg();

    Class<? extends Servlet> getVideoServletClass();

    int getVoiceTypeNone();

    boolean isEnableAEModuleManager();

    boolean isShowVideoMsg(Context context, String str, String str2, int i3);

    void notifyQQDownload(String str);

    void sendBroadcastToSmartDevice(byte[] bArr);

    void smartDeviceReportAccept();

    void smartDeviceReportReceive();

    void tryLoadPtuSo();
}
