package com.tencent.av.temp.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.t;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.hiddenchat.b;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ExternalUtilsApiImpl implements IExternalUtilsApi {
    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void checkMemPerf(int i3, int i16) {
        MemoryPerfStat.e(i3, i16);
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getBroadcastPermission() {
        return "";
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getDeviceUnBindRst() {
        return "";
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public int getEffectSettingQavNone() {
        return -1;
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getFileMD5String(String str) {
        return o.e(str);
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public Class<?> getQQServiceForAVClass() {
        return QQServiceForAV.class;
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getSmartDeviceReceiveSharpAckMsg() {
        return "";
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getSmartDeviceReceiveSharpMsg() {
        return "";
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public String getSmartDeviceSendSharpMsg() {
        return "";
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public Class<? extends Servlet> getVideoServletClass() {
        return t.class;
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public int getVoiceTypeNone() {
        return 0;
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public boolean isEnableAEModuleManager() {
        return j.D();
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public boolean isShowVideoMsg(Context context, String str, String str2, int i3) {
        return b.c(context, str, str2, i3);
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void notifyQQDownload(String str) {
        BusinessCommonConfig.notifyQQDownload(3, str, 0);
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void tryLoadPtuSo() {
        m.K();
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void smartDeviceReportAccept() {
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void smartDeviceReportReceive() {
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void sendBroadcastToSmartDevice(byte[] bArr) {
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void checkVoiceRecog(boolean z16, boolean z17) {
    }

    @Override // com.tencent.av.temp.IExternalUtilsApi
    public void deviceExitVideoProcess(BaseVideoAppInterface baseVideoAppInterface, Bundle bundle) {
    }
}
