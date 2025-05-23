package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static int f32462a = 19;

    /* renamed from: b, reason: collision with root package name */
    public static int f32463b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f32464c = 9;

    public static short a() {
        if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
            return (short) 18;
        }
        if (NetworkUtil.is3Gor4G(BaseApplication.getContext())) {
            return (short) 19;
        }
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            return (short) 20;
        }
        return (short) 17;
    }

    public static void b(QQAppInterface qQAppInterface, ReportItem reportItem, int i3) {
        String str;
        boolean z16;
        int i16;
        long j3;
        if (qQAppInterface == null) {
            return;
        }
        if (reportItem.bSend) {
            str = "actFAFileUp";
        } else {
            str = "actFAFileDown";
        }
        String str2 = str;
        int i17 = reportItem.emResult;
        if (i17 != 2 && i17 != 26 && i17 != 30 && i17 != 31 && i17 != 34) {
            z16 = false;
        } else {
            z16 = true;
        }
        long j16 = reportItem.uDuration;
        long j17 = reportItem.uFileSize - reportItem.uStartPos;
        if (i3 == f32463b) {
            ((RegisterProxySvcPackHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).T2();
        }
        int i18 = reportItem.uDevType;
        long j18 = 1;
        if (i18 != 0 && i18 != 1 && i18 == 3) {
            j18 = 21;
        }
        if (!reportItem.bSend) {
            reportItem.uSessionID &= -1152921504606846977L;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sessionid", String.valueOf(reportItem.uSessionID));
        hashMap.put("mobileterm", String.valueOf(f32462a));
        hashMap.put("otherterm", String.valueOf(j18));
        hashMap.put("channeltype", String.valueOf((int) reportItem.uChannelType));
        hashMap.put(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, String.valueOf((int) a()));
        hashMap.put(MediaDBValues.FILESIZE, String.valueOf(reportItem.uFileSize));
        hashMap.put("fileexist", String.valueOf(reportItem.bFileExist ? 1 : 0));
        hashMap.put("startpos", String.valueOf(reportItem.uStartPos));
        hashMap.put("duration", String.valueOf(reportItem.uDuration));
        hashMap.put("suffix", reportItem.sSuffix);
        hashMap.put("result", String.valueOf(reportItem.emResult));
        hashMap.put("failcode", String.valueOf(reportItem.nFailCode));
        hashMap.put("usercode", String.valueOf(reportItem.nUserCode));
        hashMap.put("filetye", String.valueOf(reportItem.uFileType));
        if (qQAppInterface.isMSFConnect()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        hashMap.put("qqstate", String.valueOf(i16));
        int i19 = reportItem.dwClientIP;
        if (i19 >= 0) {
            j3 = i19;
        } else {
            j3 = i19 + 4294967295L;
        }
        hashMap.put("clientip", String.valueOf(j3));
        int i26 = reportItem.dwServerIP;
        long j19 = i26;
        if (i26 < 0) {
            j19 += 4294967295L;
        }
        hashMap.put("serverip", String.valueOf(j19));
        int i27 = reportItem.wServerPort;
        if (i27 < 0) {
            i27 += 65535;
        }
        hashMap.put("serverport", String.valueOf(i27));
        hashMap.put("taskstart", String.valueOf(reportItem.uTaskStart / 1000));
        hashMap.put("taskend", String.valueOf(reportItem.uTaskEnd / 1000));
        hashMap.put("notifytime", String.valueOf(reportItem.uNotifyTime / 1000));
        hashMap.put("userretry", String.valueOf(reportItem.bUserRetry ? 1 : 0));
        if (QLog.isColorLevel()) {
            QLog.d(StatisticCollector.TAG, 2, "dataline event report: " + str2 + "session id = " + hashMap.get("sessionid") + " FILEASSISTANT_MOBILETERM = " + hashMap.get("mobileterm") + "  Report FILEASSISTANT_OTHERTERM  =  " + hashMap.get("otherterm"));
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), str2, z16, j16, j17, hashMap, null);
    }
}
